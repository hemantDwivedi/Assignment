package com.services.Escapian.controller;

import com.services.Escapian.config.APIResponse;
import com.services.Escapian.payload.PriceDTO;
import com.services.Escapian.service.PriceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/price")
public class PriceController {

    @Autowired
    private PriceService priceService;

    // POST-MAPPING for price
    @PostMapping
    public ResponseEntity<PriceDTO> createPrice(@RequestBody PriceDTO priceDTO){
        return new ResponseEntity<>(this.priceService.createPrice(priceDTO), HttpStatus.CREATED);
    }

    // update price by id
    @PutMapping("/{priceId}")
    public ResponseEntity<PriceDTO> updatePrice(@PathVariable Integer priceId, @RequestBody PriceDTO priceDTO){
        return new ResponseEntity<>(this.priceService.updatePrice(priceId, priceDTO), HttpStatus.OK);
    }

    // delete price by id.
    @DeleteMapping("/{priceId}")
    public ResponseEntity<APIResponse> deletePrice(@PathVariable Integer priceId){
        this.priceService.deletePrice(priceId);
        return new ResponseEntity<>(new APIResponse("price deleted with id: " + priceId), HttpStatus.OK);
    }
}
