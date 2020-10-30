package com.sar.crm.web.rest;

import com.sar.crm.domain.Setting;
import com.sar.crm.service.SettingService;
import com.sar.crm.service.dto.SettingDTO;
import com.sar.crm.web.rest.errors.BadRequestAlertException;

import io.github.jhipster.web.util.HeaderUtil;
import io.github.jhipster.web.util.PaginationUtil;
import io.github.jhipster.web.util.ResponseUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

/**
 * REST controller for managing {@link Setting}.
 */
@RestController
@RequestMapping("/api")
public class SettingResource {

    private final Logger log = LoggerFactory.getLogger(SettingResource.class);

    private static final String ENTITY_NAME = "sETTING";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final SettingService sETTINGService;

    public SettingResource(SettingService sETTINGService) {
        this.sETTINGService = sETTINGService;
    }

    /**
     * {@code POST  /settings} : Create a new sETTING.
     *
     * @param sETTINGDTO the sETTINGDTO to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new sETTINGDTO, or with status {@code 400 (Bad Request)} if the sETTING has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/settings")
    public ResponseEntity<SettingDTO> createSETTING(@Valid @RequestBody SettingDTO sETTINGDTO) throws URISyntaxException {
        log.debug("REST request to save SETTING : {}", sETTINGDTO);
        if (sETTINGDTO.getId() != null) {
            throw new BadRequestAlertException("A new sETTING cannot already have an ID", ENTITY_NAME, "idexists");
        }
        SettingDTO result = sETTINGService.save(sETTINGDTO);
        return ResponseEntity.created(new URI("/api/settings/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, true, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * {@code PUT  /settings} : Updates an existing sETTING.
     *
     * @param sETTINGDTO the sETTINGDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated sETTINGDTO,
     * or with status {@code 400 (Bad Request)} if the sETTINGDTO is not valid,
     * or with status {@code 500 (Internal Server Error)} if the sETTINGDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/settings")
    public ResponseEntity<SettingDTO> updateSETTING(@Valid @RequestBody SettingDTO sETTINGDTO) throws URISyntaxException {
        log.debug("REST request to update SETTING : {}", sETTINGDTO);
        if (sETTINGDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        SettingDTO result = sETTINGService.save(sETTINGDTO);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, sETTINGDTO.getId().toString()))
            .body(result);
    }

    /**
     * {@code GET  /settings} : get all the sETTINGS.
     *
     * @param pageable the pagination information.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of sETTINGS in body.
     */
    @GetMapping("/settings")
    public ResponseEntity<List<SettingDTO>> getAllSETTINGS(Pageable pageable) {
        log.debug("REST request to get a page of SETTINGS");
        Page<SettingDTO> page = sETTINGService.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }

    /**
     * {@code GET  /settings/:id} : get the "id" sETTING.
     *
     * @param id the id of the sETTINGDTO to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the sETTINGDTO, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/settings/{id}")
    public ResponseEntity<SettingDTO> getSETTING(@PathVariable Long id) {
        log.debug("REST request to get SETTING : {}", id);
        Optional<SettingDTO> sETTINGDTO = sETTINGService.findOne(id);
        return ResponseUtil.wrapOrNotFound(sETTINGDTO);
    }

    /**
     * {@code DELETE  /settings/:id} : delete the "id" sETTING.
     *
     * @param id the id of the sETTINGDTO to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/settings/{id}")
    public ResponseEntity<Void> deleteSETTING(@PathVariable Long id) {
        log.debug("REST request to delete SETTING : {}", id);
        sETTINGService.delete(id);
        return ResponseEntity.noContent().headers(HeaderUtil.createEntityDeletionAlert(applicationName, true, ENTITY_NAME, id.toString())).build();
    }
}
