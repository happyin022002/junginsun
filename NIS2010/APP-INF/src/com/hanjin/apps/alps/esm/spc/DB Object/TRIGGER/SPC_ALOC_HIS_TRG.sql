CREATE OR REPLACE TRIGGER NISADM.SPC_ALOC_HIS_TRG
  after insert OR UPDATE on "SPC_ALOC_POL_POD"
for each row
/*
  1.Name       : 김원섭
  2.Create Date: 2006-12-15
  3.Description:
      - 용도: Allocation 변경 정보의 History를 저장한다
  4.Revision History
    2006-12-15:김원섭:최초생성
    2008-02-20:서관영:Alloc 저장시 Forecast,BKG QTY 도 함께 저장한다.
    2010-07-08:Lee.S.Y - [프로젝트] Ticket ID : CHM-201004171 53ft 관련 수정
    2013-03-20:K.S.J   - [Ticket ID : CHM-201322502] Alloc 저장 시 Contract Forecast 정보도 함꼐 저장되도록 수정
    2014-07-18:K.S.M   - [프로젝트] CHM-201431081 : CUST_CNT_CD,CUST_SEQ,USA_BKG_MOD_CD,DEST_LOC_CD 추가
    2014-12-10:신자영  - [Ticket ID : CHM-201433097] : CTRT_NO (booking의 계약 no)추가 
*/
declare
  -- local variables here
    gnte_qty NUMBER(6);
    his_seq NUMBER(4);
    V_USER VARCHAR2(50);
BEGIN

        V_USER := SYS_CONTEXT('USERENV', 'AUTHENTICATED_IDENTITY');
--        IF V_USER != 'SPCAPPL' THEN
--    SELECT NVL(SUM(t.bkg_aval_ttl_qty),0) INTO gnte_qty
--    FROM spc_aloc_gnte t
--    WHERE
--            t.rlane_cd = :new.rlane_cd
--        AND t.dir_cd = :new.dir_cd
--        AND t.vsl_cd = :new.vsl_cd
--        AND t.skd_voy_no = :new.skd_voy_no
--        AND t.skd_dir_cd = :new.skd_dir_cd
--        AND t.sls_ofc_cd = :new.sls_ofc_cd
--        AND t.pol_cd = :new.pol_yd_cd
--        AND t.pod_cd = :new.pod_yd_cd;

    SELECT NVL(MAX(t.modi_seq), 0) 
      INTO his_seq
      FROM spc_aloc_his t
     WHERE
           t.rlane_cd   = :new.rlane_cd
       AND t.dir_cd     = :new.dir_cd
       AND t.vsl_cd     = :new.vsl_cd
       AND t.skd_voy_no = :new.skd_voy_no
       AND t.skd_dir_cd = :new.skd_dir_cd
       AND t.sls_ofc_cd = :new.sls_ofc_cd
       AND t.pol_yd_cd  = :new.pol_yd_cd
       AND t.pod_yd_cd  = :new.pod_yd_cd
       AND t.ts_flg     = :new.ts_flg
       AND t.mnl_flg    = :new.mnl_flg
       AND t.ioc_cd     = :new.ioc_cd
       AND t.cust_cnt_cd    = :new.cust_cnt_cd
       AND t.cust_seq       = :new.cust_seq
       AND t.ctrt_no        = :new.ctrt_no
       AND t.usa_bkg_mod_cd = :new.usa_bkg_mod_cd
       AND t.dest_loc_cd    = :new.dest_loc_cd
     ;

    his_seq := his_seq + 1;

    insert INTO spc_aloc_his
        (   rlane_cd,
            dir_cd,
            vsl_cd,
            skd_voy_no,
            skd_dir_cd,
            sls_ofc_cd,
            pol_yd_cd,
            pod_yd_cd,
            ts_flg,
            mnl_flg,
            modi_seq,
            rep_trd_cd,
            rep_sub_trd_cd,
            trd_cd,
            sub_trd_cd,
            ioc_cd,
            sls_rhq_cd,
            sls_rgn_ofc_cd,
            asgn_ttl_qty,
            asgn_20ft_qty,
            asgn_40ft_qty,
            asgn_40ft_hc_qty,
            asgn_45ft_hc_qty,
            asgn_53ft_qty,
            asgn_rf_qty,
            asgn_ttl_wgt,
            bkg_aval_ttl_qty,
            bkg_aval_20ft_qty,
            bkg_aval_40ft_qty,
            bkg_aval_40ft_hc_qty,
            bkg_aval_45ft_hc_qty,
            bkg_aval_53ft_qty,
            bkg_aval_rf_qty,
            bkg_aval_ttl_wgt,
            aloc_usr_id,
            aloc_gdt,
            cust_spc_gnte_qty,
            modi_usr_id,
            modi_gdt,
            cre_usr_id,
            cre_dt,
            upd_usr_id,
            upd_dt,
            mnl_aloc_rmk,
            ioc_ts_cd,
            fcast_ttl_qty,
            fcast_40ft_hc_qty,
            fcast_45ft_hc_qty,
            fcast_53ft_qty,
            fcast_rf_qty,
            fcast_ttl_wgt,
            usd_bkg_ttl_qty,
            usd_bkg_20ft_qty,
            usd_bkg_40ft_qty,
            usd_bkg_40ft_hc_qty,
            usd_bkg_45ft_hc_qty,
            usd_bkg_53ft_qty,
            usd_bkg_rf_qty,
            usd_bkg_ttl_wgt,
            aloc_lod_qty,
            aloc_40ft_hc_qty,
            aloc_45ft_hc_qty,
            aloc_53ft_qty,
            aloc_rf_qty,
            aloc_ttl_wgt,
            ctrt_fcast_ttl_qty,
            ctrt_fcast_40ft_hc_qty,
            ctrt_fcast_45ft_hc_qty,
            ctrt_fcast_53ft_qty,
            ctrt_fcast_rf_qty,
            ctrt_fcast_ttl_wgt,
            CUST_CNT_CD,
            CUST_SEQ,
            CTRT_NO,
            USA_BKG_MOD_CD,
            DEST_LOC_CD,
            ASGN_20FT_DRY_QTY,
            ASGN_40FT_DRY_QTY,
            ASGN_RD_QTY,
            BKG_AVAL_20FT_DRY_QTY,
            BKG_AVAL_40FT_DRY_QTY,
            BKG_AVAL_RD_QTY,
            FCAST_20FT_DRY_QTY,
            FCAST_40FT_DRY_QTY,
            FCAST_RD_QTY,
            USD_BKG_20FT_DRY_QTY,
            USD_BKG_40FT_DRY_QTY,
            USD_BKG_RD_QTY,
            ALOC_20FT_DRY_QTY,
            ALOC_40FT_DRY_QTY,
            ALOC_RD_QTY            
        )
    select  rlane_cd,
            dir_cd,
            vsl_cd,
            skd_voy_no,
            skd_dir_cd,
            sls_ofc_cd,
            pol_yd_cd,
            pod_yd_cd,
            ts_flg,
            mnl_flg,
            modi_seq,
            rep_trd_cd,
            rep_sub_trd_cd,
            trd_cd,
            sub_trd_cd,
            ioc_cd,
            sls_rhq_cd,
            sls_rgn_ofc_cd,
            asgn_ttl_qty,
            asgn_20ft_qty,
            asgn_40ft_qty,
            asgn_40ft_hc_qty,
            asgn_45ft_hc_qty,
            asgn_53ft_qty,
            asgn_rf_qty,
            asgn_ttl_wgt,
            bkg_aval_ttl_qty,
            bkg_aval_20ft_qty,
            bkg_aval_40ft_qty,
            bkg_aval_40ft_hc_qty,
            bkg_aval_45ft_hc_qty,
            bkg_aval_53ft_qty,
            bkg_aval_rf_qty,
            bkg_aval_ttl_wgt,
            aloc_usr_id,
            aloc_gdt,
            cust_spc_gnte_qty,
            modi_usr_id,
            modi_gdt,
            cre_usr_id,
            cre_dt,
            upd_usr_id,
            upd_dt,
            mnl_aloc_rmk,
            ioc_ts_cd,
            fcast_ttl_qty,
            fcast_40ft_hc_qty,
            fcast_45ft_hc_qty,
            fcast_53ft_qty,
            fcast_rf_qty,
            fcast_ttl_wgt,
            usd_bkg_ttl_qty,
            usd_bkg_20ft_qty,
            usd_bkg_40ft_qty,
            usd_bkg_40ft_hc_qty,
            usd_bkg_45ft_hc_qty,
            usd_bkg_53ft_qty,
            usd_bkg_rf_qty,
            usd_bkg_ttl_wgt,
            aloc_lod_qty,
            aloc_40ft_hc_qty,
            aloc_45ft_hc_qty,
            aloc_53ft_qty,
            aloc_rf_qty,
            aloc_ttl_wgt,
            ctrt_fcast_ttl_qty,
            ctrt_fcast_40ft_hc_qty,
            ctrt_fcast_45ft_hc_qty,
            ctrt_fcast_53ft_qty,
            ctrt_fcast_rf_qty,
            ctrt_fcast_ttl_wgt,
            CUST_CNT_CD,
            CUST_SEQ,
            CTRT_NO,
            USA_BKG_MOD_CD,
            DEST_LOC_CD,
            ASGN_20FT_DRY_QTY,
            ASGN_40FT_DRY_QTY,
            ASGN_RD_QTY,
            BKG_AVAL_20FT_DRY_QTY,
            BKG_AVAL_40FT_DRY_QTY,
            BKG_AVAL_RD_QTY,
            FCAST_20FT_DRY_QTY,
            FCAST_40FT_DRY_QTY,
            FCAST_RD_QTY,
            USD_BKG_20FT_DRY_QTY,
            USD_BKG_40FT_DRY_QTY,
            USD_BKG_RD_QTY,
            ALOC_20FT_DRY_QTY,
            ALOC_40FT_DRY_QTY,
            ALOC_RD_QTY       
       from (
             select :new.rlane_cd             as rlane_cd,
                    :new.dir_cd               as dir_cd,
                    :new.vsl_cd               as vsl_cd,
                    :new.skd_voy_no           as skd_voy_no,
                    :new.skd_dir_cd           as skd_dir_cd,
                    :new.sls_ofc_cd           as sls_ofc_cd,
                    :new.pol_yd_cd            as pol_yd_cd,
                    :new.pod_yd_cd            as pod_yd_cd,
                    :new.ts_flg               as ts_flg,
                    :new.mnl_flg              as mnl_flg,
                    his_seq                   as modi_seq,
                    :new.rep_trd_cd           as rep_trd_cd,
                    :new.rep_sub_trd_cd       as rep_sub_trd_cd,
                    :new.trd_cd               as trd_cd,
                    :new.sub_trd_cd           as sub_trd_cd,
                    :new.ioc_cd               as ioc_cd,
                    :new.sls_rhq_cd           as sls_rhq_cd,
                    :new.sls_rgn_ofc_cd       as sls_rgn_ofc_cd,
                    :new.asgn_ttl_qty         as asgn_ttl_qty,
                    :new.asgn_20ft_qty        as asgn_20ft_qty,
                    :new.asgn_40ft_qty        as asgn_40ft_qty,
                    :new.asgn_40ft_hc_qty     as asgn_40ft_hc_qty,
                    :new.asgn_45ft_hc_qty     as asgn_45ft_hc_qty,
                    :new.asgn_53ft_qty        as asgn_53ft_qty,
                    :new.asgn_rf_qty          as asgn_rf_qty,
                    :new.asgn_ttl_wgt         as asgn_ttl_wgt,
                    :new.bkg_aval_ttl_qty     as bkg_aval_ttl_qty,
                    :new.bkg_aval_20ft_qty    as bkg_aval_20ft_qty,
                    :new.bkg_aval_40ft_qty    as bkg_aval_40ft_qty,
                    :new.bkg_aval_40ft_hc_qty as bkg_aval_40ft_hc_qty,
                    :new.bkg_aval_45ft_hc_qty as bkg_aval_45ft_hc_qty,
                    :new.bkg_aval_53ft_qty    as bkg_aval_53ft_qty,
                    :new.bkg_aval_rf_qty      as bkg_aval_rf_qty,
                    :new.bkg_aval_ttl_wgt     as bkg_aval_ttl_wgt,
                    :new.aloc_usr_id          as aloc_usr_id,
                    :new.aloc_gdt             as aloc_gdt,
                    0                         as cust_spc_gnte_qty,
                    :new.upd_usr_id           as modi_usr_id,
                    :new.aloc_gdt             as modi_gdt,
                    :new.cre_usr_id           as cre_usr_id,
                    :new.cre_dt               as cre_dt,
                    :new.upd_usr_id           as upd_usr_id,
                    :new.upd_dt               as upd_dt,
                    :new.mnl_aloc_rmk         as mnl_aloc_rmk,
                    decode(:new.ts_flg,'Y','T',:new.ioc_cd) as ioc_ts_cd,
                    :new.fcast_ttl_qty        as fcast_ttl_qty,
                    :new.fcast_40ft_hc_qty    as fcast_40ft_hc_qty,
                    :new.fcast_45ft_hc_qty    as fcast_45ft_hc_qty,
                    :new.fcast_53ft_qty       as fcast_53ft_qty,
                    :new.fcast_rf_qty         as fcast_rf_qty,
                    :new.fcast_ttl_wgt        as fcast_ttl_wgt,
                    :new.usd_bkg_ttl_qty      as usd_bkg_ttl_qty,
                    :new.usd_bkg_20ft_qty     as usd_bkg_20ft_qty,  -- USD_BKG_20FT_QTY
                    :new.usd_bkg_40ft_qty     as usd_bkg_40ft_qty,
                    :new.usd_bkg_40ft_hc_qty  as usd_bkg_40ft_hc_qty,
                    :new.usd_bkg_45ft_hc_qty  as usd_bkg_45ft_hc_qty,
                    :new.usd_bkg_53ft_qty     as usd_bkg_53ft_qty,
                    :new.usd_bkg_rf_qty       as usd_bkg_rf_qty,
                    :new.usd_bkg_ttl_wgt      as usd_bkg_ttl_wgt,
                    decode(:new.mnl_aloc_rmk,'3',:new.asgn_ttl_qty,    :new.bkg_aval_ttl_qty)     as aloc_lod_qty,
                    decode(:new.mnl_aloc_rmk,'3',:new.asgn_40ft_hc_qty,:new.bkg_aval_40ft_hc_qty) as aloc_40ft_hc_qty,
                    decode(:new.mnl_aloc_rmk,'3',:new.asgn_45ft_hc_qty,:new.bkg_aval_45ft_hc_qty) as aloc_45ft_hc_qty,
                    decode(:new.mnl_aloc_rmk,'3',:new.asgn_53ft_qty,   :new.bkg_aval_53ft_qty)    as aloc_53ft_qty,
                    decode(:new.mnl_aloc_rmk,'3',:new.asgn_rf_qty,     :new.bkg_aval_rf_qty)      as aloc_rf_qty,
                    decode(:new.mnl_aloc_rmk,'3',:new.asgn_ttl_wgt,    :new.bkg_aval_ttl_wgt)     as aloc_ttl_wgt,
                    
                    :new.cust_cnt_cd            as cust_cnt_cd,
                    :new.cust_seq               as cust_seq,
                    :new.CTRT_NO                 as ctrt_no,
                    :new.usa_bkg_mod_cd         as usa_bkg_mod_cd,
                    :new.dest_loc_cd            as dest_loc_cd,
                    :new.asgn_20ft_dry_qty      as asgn_20ft_dry_qty,
                    :new.asgn_40ft_dry_qty      as asgn_40ft_dry_qty,
                    :new.asgn_rd_qty            as asgn_rd_qty,
                    :new.bkg_aval_20ft_dry_qty  as bkg_aval_20ft_dry_qty,
                    :new.bkg_aval_40ft_dry_qty  as bkg_aval_40ft_dry_qty,
                    :new.bkg_aval_rd_qty        as bkg_aval_rd_qty,
                    :new.fcast_20ft_dry_qty     as fcast_20ft_dry_qty,
                    :new.fcast_40ft_dry_qty     as fcast_40ft_dry_qty,
                    :new.fcast_rd_qty           as fcast_rd_qty,
                    :new.usd_bkg_20ft_dry_qty   as usd_bkg_20ft_dry_qty,
                    :new.usd_bkg_40ft_dry_qty   as usd_bkg_40ft_dry_qty,
                    :new.usd_bkg_rd_qty         as usd_bkg_rd_qty,
                    decode(:new.mnl_aloc_rmk,'3',:new.asgn_20ft_dry_qty, :new.bkg_aval_20ft_dry_qty) as aloc_20ft_dry_qty,
                    decode(:new.mnl_aloc_rmk,'3',:new.asgn_40ft_dry_qty, :new.bkg_aval_40ft_dry_qty) as aloc_40ft_dry_qty,
                    decode(:new.mnl_aloc_rmk,'3',:new.asgn_rd_qty,       :new.bkg_aval_rd_qty      ) as aloc_rd_qty    
               from dual
            ) a,
            ( select sum(fcast_ttl_qty)     as ctrt_fcast_ttl_qty,                      
                     sum(fcast_40ft_hc_qty) as ctrt_fcast_40ft_hc_qty,                      
                     sum(fcast_45ft_hc_qty) as ctrt_fcast_45ft_hc_qty,                      
                     sum(fcast_53ft_qty)    as ctrt_fcast_53ft_qty, 
                     sum(fcast_rf_qty)      as ctrt_fcast_rf_qty, 
                     sum(fcast_ttl_wgt)     as ctrt_fcast_ttl_wgt
                from spc_ctrt_fcast_cust
               where trd_cd         = :new.trd_cd
                 and rlane_cd       = :new.rlane_cd
                 and ioc_ts_cd      = decode(:new.ts_flg, 'Y', 'T', :new.ioc_cd)
                 and vsl_cd         = :new.vsl_cd
                 and skd_voy_no     = :new.skd_voy_no
                 and skd_dir_cd     = :new.skd_dir_cd
                 and sls_rgn_ofc_cd = :new.sls_ofc_cd
                 and pol_yd_cd      = :new.pol_yd_cd
                 and pod_yd_cd      = :new.pod_yd_cd
            ) b
          ;
--     END IF;
end SPC_ALOC_HIS_TRG;