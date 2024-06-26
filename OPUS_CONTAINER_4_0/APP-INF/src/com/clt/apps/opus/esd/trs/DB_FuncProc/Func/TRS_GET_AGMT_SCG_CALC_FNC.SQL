CREATE OR REPLACE FUNCTION TRS_GET_AGMT_SCG_CALC_FNC (
    pi_rail_svc_tp_cd           IN  VARCHAR2    /* Rail Service Type */
   ,pi_scg_knd_indicator        IN  VARCHAR2    /* FU : FUEL SURCHARGE, OW : OVER WEIGHT SURCHARGE */
   ,pi_way_type                 IN  VARCHAR2    /* ONE or RND      */
   ,pi_crr_mod_cd               IN  VARCHAR2
   ,pi_trsp_agmt_ofc_cty_cd     IN  VARCHAR2
   ,pi_trsp_agmt_seq            IN  NUMBER
   ,pi_trsp_agmt_rt_tp_ser_no   IN  NUMBER
   ,pi_vndr_seq                 IN  VARCHAR2
   ,pi_basis_dt                 IN  DATE
   ,pi_eq_knd_cd                IN  VARCHAR2
   ,pi_eq_tp_sz_cd              IN  VARCHAR2
   ,pi_cgo_tp_cd                IN  VARCHAR2
   ,pi_from_nod_cd              IN  VARCHAR2
   ,pi_via_nod_cd               IN  VARCHAR2
   ,pi_door_nod_cd              IN  VARCHAR2
   ,pi_to_nod_cd                IN  VARCHAR2
   ,pi_bundle_cnt               IN  NUMBER
   ,pi_wgt_uom                  IN  VARCHAR2    /* L-LBS, K-KG */
   ,pi_wgt_qty                  IN  NUMBER
   ,pi_basic_rt                 IN  NUMBER
   ,pi_basic_curr_cd            IN  VARCHAR2
   ,pi_spcl_cgo_cd              IN  VARCHAR2
   ,pi_debug_flg                IN  VARCHAR2  -- Debug Flag ('Y' : DBMS LOG 기록)
)
RETURN NUMBER
AUTHID CURRENT_USER
IS
/******************************************************************************
   Name         :   TRS_GET_AGMT_SCG_CALC_FNC
   Purpose      :   Agreement Surcharge를 계산하는 Function
   Table        :   TRS_TRSP_AGMT_TMP
   Ver          :   1.0
   Date         :   2010.04.66
   System       :   e-NIS > TRS
   Author       :   최종혁
   History      :   
******************************************************************************/
    v_trsp_so_knd_indicator  VARCHAR2(15);
    v_scg_knd                VARCHAR2(15);
    v_wgt_qty                NUMBER(10);
    v_eq_tp_sz_cd            VARCHAR2(3);
    vo_trsp_scg_cd           TRS_AGMT_SCG_NOD.TRSP_SCG_CD%TYPE;
    vo_trsp_agmt_scg_nod_seq TRS_AGMT_SCG_NOD.TRSP_AGMT_SCG_NOD_SEQ%TYPE;
    vo_trsp_agmt_scg_rt_seq  TRS_AGMT_SCG_RT.TRSP_AGMT_SCG_RT_SEQ%TYPE;
    vo_scg_union_exp         VARCHAR2(100);
    vo_scg_curr_cd           VARCHAR2(3)  := '';
    vo_scg_rt                NUMBER(18,3);
    vo_scg_rtn_cd            NUMBER(5);
    vo_scg_rtn_msg           VARCHAR2(1000);
BEGIN
    DBMS_OUTPUT.ENABLE(1000000);  
    /* NONE_USRAIL SO, US RAIL SO 판단 START */
    IF LENGTH(pi_rail_svc_tp_cd) >= 2 AND pi_crr_mod_cd = 'RD' THEN
        v_trsp_so_knd_indicator := 'USRAIL';
        IF pi_scg_knd_indicator = 'FU' THEN
            v_scg_knd := 'FSG';
        ELSIF pi_scg_knd_indicator = 'OW' THEN
            v_scg_knd := 'OWS';
            v_wgt_qty := pi_wgt_qty;
        ELSIF pi_scg_knd_indicator = 'HZ' THEN
            v_scg_knd := 'HZS';
        ELSIF pi_scg_knd_indicator = 'TL' THEN
            v_scg_knd := 'TTL';
        END IF;
    ELSE
        v_trsp_so_knd_indicator := 'NONE_USRAIL' ;
        IF pi_scg_knd_indicator = 'FU' THEN
            v_scg_knd := 'FU';
        ELSIF pi_scg_knd_indicator = 'OW' THEN
            v_scg_knd := 'OW';
            v_wgt_qty := pi_wgt_qty;
        END IF;
    END IF;

    IF v_trsp_so_knd_indicator = 'NONE_USRAIL' THEN
        TRS_AGMT_RATE_CC_PKG.GET_SCG_RATE_CALCULATION_PRC (
            'TRS'              ,v_trsp_so_knd_indicator   ,v_scg_knd      ,pi_way_type   ,pi_trsp_agmt_ofc_cty_cd
           ,pi_trsp_agmt_seq   ,pi_trsp_agmt_rt_tp_ser_no ,pi_vndr_seq    ,pi_basis_dt
           ,pi_eq_knd_cd       ,pi_eq_tp_sz_cd            ,pi_cgo_tp_cd   ,pi_from_nod_cd
           ,pi_via_nod_cd      ,pi_door_nod_cd            ,pi_to_nod_cd   ,pi_bundle_cnt ,pi_wgt_uom
           ,pi_wgt_qty         ,pi_basic_rt    ,pi_basic_curr_cd ,pi_debug_flg
           /* OUT PARAMETER */
           ,vo_scg_union_exp   ,vo_trsp_scg_cd ,vo_trsp_agmt_scg_nod_seq  ,vo_trsp_agmt_scg_rt_seq ,vo_scg_curr_cd
           ,vo_scg_rt
           ,vo_scg_rtn_cd   ,vo_scg_rtn_msg
        );
    ELSIF v_trsp_so_knd_indicator = 'USRAIL' THEN
            TRS_AGMT_RATE_CC_PKG.GET_RAIL_SCG_RATE_CALC_PRC
            (
                'TRS' 
               ,pi_eq_tp_sz_cd ,pi_vndr_seq    ,pi_trsp_agmt_ofc_cty_cd  ,pi_trsp_agmt_seq ,v_scg_knd
               ,pi_cgo_tp_cd   ,pi_from_nod_cd ,pi_to_nod_cd ,pi_wgt_uom ,pi_wgt_qty ,pi_basis_dt
               ,pi_spcl_cgo_cd ,pi_basic_curr_cd ,pi_basic_rt    ,pi_debug_flg
               -- OUT PRAMETER
               ,vo_scg_curr_cd ,vo_scg_rt
               ,vo_scg_rtn_cd  ,vo_scg_rtn_msg
            );
    END IF;
RETURN vo_scg_rt;

END ;