package com.sar.crm.web.rest;

import com.sar.crm.service.PerformanceService;
import com.sar.crm.web.rest.errors.BadRequestAlertException;
import com.sar.crm.service.dto.PerformanceDTO;

import io.github.jhipster.web.util.HeaderUtil;
import io.github.jhipster.web.util.PaginationUtil;
import io.github.jhipster.web.util.ResponseUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;
import java.util.stream.StreamSupport;

/**
 * REST controller for managing {@link com.sar.crm.domain.Performance}.
 */
@RestController
@RequestMapping("/api")
public class PerformanceResource {

    private final Logger log = LoggerFactory.getLogger(PerformanceResource.class);

    private static final String ENTITY_NAME = "performance";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final PerformanceService performanceService;

    public PerformanceResource(PerformanceService performanceService) {
        this.performanceService = performanceService;
    }

    /**
     * {@code POST  /performances} : Create a new performance.
     *
     * @param performanceDTO the performanceDTO to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new performanceDTO, or with status {@code 400 (Bad Request)} if the performance has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/performances")
    public ResponseEntity<PerformanceDTO> createPerformance(@Valid @RequestBody PerformanceDTO performanceDTO) throws URISyntaxException {
        log.debug("REST request to save Performance : {}", performanceDTO);
        if (performanceDTO.getId() != null) {
            throw new BadRequestAlertException("A new performance cannot already have an ID", ENTITY_NAME, "idexists");
        }
        PerformanceDTO result = performanceService.save(performanceDTO);
        return ResponseEntity.created(new URI("/api/performances/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, true, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * {@code PUT  /performances} : Updates an existing performance.
     *
     * @param performanceDTO the performanceDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated performanceDTO,
     * or with status {@code 400 (Bad Request)} if the performanceDTO is not valid,
     * or with status {@code 500 (Internal Server Error)} if the performanceDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/performances")
    public ResponseEntity<PerformanceDTO> updatePerformance(@Valid @RequestBody PerformanceDTO performanceDTO) throws URISyntaxException {
        log.debug("REST request to update Performance : {}", performanceDTO);
        if (performanceDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        PerformanceDTO result = performanceService.save(performanceDTO);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, performanceDTO.getId().toString()))
            .body(result);
    }

    /**
     * {@code GET  /performances} : get all the performances.
     *
     * @param pageable the pagination information.
     * @param filter the filter of the request.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of performances in body.
     */
    @GetMapping("/performances")
    public ResponseEntity<List<PerformanceDTO>> getAllPerformances(Pageable pageable, @RequestParam(required = false) String filter) {
        if ("job-is-null".equals(filter)) {
            log.debug("REST request to get all Performances where job is null");
            return new ResponseEntity<>(performanceService.findAllWhereJobIsNull(),
                    HttpStatus.OK);
        }
        log.debug("REST request to get a page of Performances");
        Page<PerformanceDTO> page = performanceService.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }

    /**
     * {@code GET  /performances/:id} : get the "id" performance.
     *
     * @param id the id of the performanceDTO to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the performanceDTO, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/performances/{id}")
    public ResponseEntity<PerformanceDTO> getPerformance(@PathVariable Long id) {
        log.debug("REST request to get Performance : {}", id);
        Optional<PerformanceDTO> performanceDTO = performanceService.findOne(id);
        return ResponseUtil.wrapOrNotFound(performanceDTO);
    }

    /**
     * {@code DELETE  /performances/:id} : delete the "id" performance.
     *
     * @param id the id of the performanceDTO to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/performances/{id}")
    public ResponseEntity<Void> deletePerformance(@PathVariable Long id) {
        log.debug("REST request to delete Performance : {}", id);
        performanceService.delete(id);
        return ResponseEntity.noContent().headers(HeaderUtil.createEntityDeletionAlert(applicationName, true, ENTITY_NAME, id.toString())).build();
    }
}
