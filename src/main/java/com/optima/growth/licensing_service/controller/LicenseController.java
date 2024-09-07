package com.optima.growth.licensing_service.controller;

import org.springframework.web.bind.annotation.RestController;

import com.optima.growth.licensing_service.model.License;
import com.optima.growth.licensing_service.service.LicenseService;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;





@RestController
@RequestMapping(value="v1/organization/{organizationId}/license")
public class LicenseController {

  @Autowired
  private LicenseService licenseService;

  @GetMapping("/{licenseId}")
  public ResponseEntity<License> getLicense(@PathVariable("organizationId") String organizationId,
  @PathVariable("licenseId") String licenseId
  ) {
      License license = licenseService.getLicense(licenseId, organizationId);
      return ResponseEntity.ok(license);
  }
  

  @PutMapping
  public ResponseEntity<String> updateLicense(@PathVariable String organizationId, @RequestBody License entity) {
      
      
      return ResponseEntity.ok(licenseService.updateLicense(entity, organizationId));
  }


  @PostMapping
  public ResponseEntity<String> createLicense(@PathVariable String organizationId, @RequestBody License entity) {
      return ResponseEntity.ok(licenseService.createLicense(entity, organizationId));
  }


  @DeleteMapping("/{licenseId}")
  public ResponseEntity<String> deleteLicense(@PathVariable String organizationId, @PathVariable String licenseId) {
      return ResponseEntity.ok(licenseService.deleteLicense(licenseId, organizationId));
  }



  
}
