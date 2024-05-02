CREATE OR REPLACE VIEW OPUSADM.COA_BOOKING_V
(   BKG_VVD,
    VSL_CD,
    SKD_VOY_NO,
    DIR_CD,
    SLAN_CD,
    BKG_NO,
    BL_NO,
    BL_NO_TP,
    BKG_CGO_WGT,
    BKG_WGT_TP_CD,
    SLS_OFC_CD,
    RHQ_CD,
    RGN_OFC_CD,
    BKG_CGO_TP_CD,
    BKG_POR_CD,
    BKG_POL_CD,
    BKG_POD_CD,
    BKG_DEL_CD,
    BKG_RCV_TERM_CD,
    BKG_DE_TERM_CD,
    SPCL_DG_CGO_FLG,
    SPCL_RC_FLG,
    SPCL_AWK_CGO_FLG,
    SPCL_BB_CGO_FLG,
    RD_FLG,
    SOC_FLG,
    N1ST_VVD,
    N2ND_VVD,
    N3RD_VVD,
    N4TH_VVD,
    N1ST_POL_CD,
    N1ST_POD_CD,
    N2ND_POL_CD,
    N2ND_POD_CD,
    N3RD_POL_CD,
    N3RD_POD_CD,
    N4TH_POL_CD,
    N4TH_POD_CD,
    N1ST_SLAN_CD,
    N2ND_SLAN_CD,
    N3RD_SLAN_CD,
    N4TH_SLAN_CD,
    BKG_STS_CD,
    CMDT_CD,
    BKG_OFC_CD,
    REP_CMDT_CD,
    N1ST_POL_CONTI,
    N1ST_POD_CONTI,
    N2ND_POL_CONTI,
    N2ND_POD_CONTI,
    N3RD_POL_CONTI,
    N3RD_POD_CONTI,
    N4TH_POL_CONTI,
    N4TH_POD_CONTI,
    N1ST_IOC,
    N2ND_IOC,
    N3RD_IOC,
    N4TH_IOC,
    SHPR_NM,
    CNEE_NM,
    NTFY_NM,
    SHPR_CNT_CD,
    SHPR_CUST_SEQ,
    S_MSCD_CPT,
    CNEE_CNT_CD,
    CNEE_CUST_SEQ,
    NTFY_CNT_CD,
    NTFY_CUST_SEQ,
    BKG_POR_YD_CD,
    BKG_DEL_YD_CD,
    PPD_OFC_CD,
    CLT_OFC_CD,
    SC_NO,
    RFA_NO,
    CNTR_RCV_DT,
    OBRD_DT,
    OFT_TP_CD,
    SREP_CD,
    CTRT_OFC_CD,
    CTRT_SREP_CD,
    KR_CSTMS_CUST_TP_CD,
    CTRT_CUST_CNT_CD,
    CTRT_CUST_SEQ,
    CUST_TP_CD,
    CUST_KEY_AGMT_MGR_FLG,
    BKG_REV_VVD,
    AGMT_SGN_OFC_CD,
    TAA_NO,
    RT_BL_TP_CD
)
AS
select a1.vsl_cd||a1.skd_voy_no||a1.skd_dir_cd as bkg_vvd ,
  a1.vsl_cd ,
  a1.skd_voy_no ,
  a1.skd_dir_cd dir_cd ,
  a1.slan_cd ,
  a1.bkg_no ,
  a1.bl_no ,
  a1.bl_no_tp ,
  a4.act_wgt as bkg_cgo_wgt ,
  a4.wgt_ut_cd as bkg_wgt_tp_cd ,
  a1.ob_sls_ofc_cd as sls_ofc_cd ,
  a1.sls_rhq_cd as rhq_cd ,
  a1.sls_rgn_ofc_cd as rgn_ofc_cd ,
  a1.bkg_cgo_tp_cd ,
  a1.por_cd as bkg_por_cd ,
  a1.pol_cd as bkg_pol_cd ,
  a1.pod_cd as bkg_pod_cd ,
  a1.del_cd as bkg_del_cd ,
  a1.rcv_term_cd as bkg_rcv_term_cd ,
  a1.de_term_cd as bkg_de_term_cd ,
  a1.dcgo_flg as spcl_dg_cgo_flg ,
  a1.rc_flg as spcl_rc_flg ,
  a1.awk_cgo_flg as spcl_awk_cgo_flg ,
  a1.bb_cgo_flg as spcl_bb_cgo_flg ,
  a1.rd_cgo_flg as rd_flg ,
  a1.soc_flg ,
  a2.n1st_vvd ,
  a2.n2nd_vvd ,
  a2.n3rd_vvd ,
  a2.n4th_vvd ,
  a2.n1st_pol_cd ,
  a2.n1st_pod_cd ,
  a2.n2nd_pol_cd ,
  a2.n2nd_pod_cd ,
  a2.n3rd_pol_cd ,
  a2.n3rd_pod_cd ,
  a2.n4th_pol_cd ,
  a2.n4th_pod_cd ,
  a2.n1st_slan_cd ,
  a2.n2nd_slan_cd ,
  a2.n3rd_slan_cd ,
  a2.n4th_slan_cd ,
  a1.bkg_sts_cd ,
  a1.cmdt_cd ,
  a1.bkg_ofc_cd ,
  a6.rep_cmdt_cd ,
  pol1.conti_cd as n1st_pol_conti ,
  pod1.conti_cd as n1st_pod_conti ,
  nvl(pol2.conti_cd, pod1.conti_cd) as n2nd_pol_conti ,
  pod2.conti_cd as n2nd_pod_conti ,
  nvl(pol3.conti_cd, pod2.conti_cd) as n3rd_pol_conti ,
  pod3.conti_cd as n3rd_pod_conti ,
  nvl(pol4.conti_cd, pod3.conti_cd) as n4th_pol_conti ,
  pod4.conti_cd as n4th_pod_conti ,
  decode(a9.conti_cd, a10.conti_cd, 'i'|| a10.conti_cd, 'oo') as n1st_ioc ,
  decode(a2.n2nd_pol_cd, null, null, decode(a10.conti_cd, a11.conti_cd, 'i'||a11.conti_cd, 'oo')) as n2nd_ioc ,
  decode(a2.n3rd_pol_cd, null, null, decode(a11.conti_cd, a12.conti_cd, 'i'||a12.conti_cd, 'oo')) as n3rd_ioc ,
  decode(a2.n4th_pol_cd, null, null, decode(a12.conti_cd, a13.conti_cd, 'i'||a13.conti_cd, 'oo')) as n4th_ioc ,
  translate(nvl(a7.shpr_nm, ' '), chr(13)||chr(10), ' ') as shpr_nm ,
  translate(nvl(a7.cnee_nm, ' '), chr(13)||chr(10), ' ') as cnee_nm ,
  translate(nvl(a7.ntfy_nm, ' '), chr(13)||chr(10), ' ') as ntfy_nm ,
  a7.shpr_cnt_cd ,
  a7.shpr_cust_seq ,
  a7.s_mscd_cpt ,
  a7.cnee_cnt_cd ,
  a7.cnee_cnt_seq ,
  a7.ntfy_cnt_cd ,
  a7.ntfy_cust_seq ,
  substr(a1.por_nod_cd, -2) as bkg_por_yd_cd ,
  substr(a1.del_nod_cd, -2) as bkg_del_yd_cd ,
  a3.ppd_rcv_ofc_cd as ppd_ofc_cd ,
  a3.clt_ofc_cd ,
  a1.sc_no ,
  a1.rfa_no

--      ,a3.cgo_rcv_dt     as cntr_rcv_dt --2010.07.29 Cargo Receiving Data 항목을 Application Data로 변경
  ,
  a3.rt_aply_dt as cntr_rcv_dt

--      ,a5.obl_iss_dt     as obrd_dt --2010.07.29 ON BOARD DATA가 컬렴이 잘못 메핑되어 있어 수정[BKG_BL_ISS->BKG_BL_DOC]
  ,
  a4.bl_obrd_dt as obrd_dt ,
  a3.frt_term_cd as oft_tp_cd ,
  a1.ob_srep_cd as srep_cd ,
  a1.ctrt_ofc_cd ,
  a1.ctrt_srep_cd ,
  a1.kr_cstms_cust_tp_cd ,
  a1.ctrt_cust_cnt_cd ,
  a1.ctrt_cust_seq ,
  a8.cntr_cust_tp_cd as cust_tp_cd ,
  a8.key_acct_flg as cust_key_agmt_mgr_flg

--REV VVD
  ,
  DECODE(a2.n1st_rev_vvd_flg, 'Y', a2.n1st_vvd , DECODE(a2.n2nd_rev_vvd_flg, 'Y', a2.n2nd_vvd , DECODE(a2.n3rd_rev_vvd_flg, 'Y', a2.n3rd_vvd , DECODE(a2.n4th_rev_vvd_flg, 'Y', a2.n4th_vvd) ) ) ) AS bkg_rev_vvd ,
  nvl(trim(a1.ctrt_ofc_cd), a1.ob_sls_ofc_cd) as agmt_sgn_ofc_cd ,
  a1.taa_no ,
  a3.RT_BL_TP_CD
from bkg_booking a1 --B
  ,
  ( -- vsl_pre_post_cd[S, T, U], vsl_seq을 이용하여 T/S 순서를 결정한다. 
    select bkg_no ,
      vsl_pre_pst_cd ,
      vsl_pre_pst_cd ,
      vsl_seq ,
      rank()over(partition by bkg_no
        order by decode(vsl_pre_pst_cd, 'S', 1, 'T', 2, 'U', 3), vsl_seq) seq1 ,
      slan_cd as n1st_slan_cd ,
      LEAD(slan_cd, 1) over(partition by bkg_no
        order by decode(vsl_pre_pst_cd, 'S', 1, 'T', 2, 'U', 3), vsl_seq) as n2nd_slan_cd ,
      LEAD(slan_cd, 2) over(partition by bkg_no
        order by decode(vsl_pre_pst_cd, 'S', 1, 'T', 2, 'U', 3), vsl_seq) as n3rd_slan_cd ,
      LEAD(slan_cd, 3) over(partition by bkg_no
        order by decode(vsl_pre_pst_cd, 'S', 1, 'T', 2, 'U', 3), vsl_seq) as n4th_slan_cd ,
      vsl_cd||skd_voy_no||skd_dir_cd as n1st_vvd ,
      LEAD(vsl_cd||skd_voy_no||skd_dir_cd, 1) over(partition by bkg_no
        order by decode(vsl_pre_pst_cd, 'S', 1, 'T', 2, 'U', 3), vsl_seq) as n2nd_vvd ,
      LEAD(vsl_cd||skd_voy_no||skd_dir_cd, 2) over(partition by bkg_no
        order by decode(vsl_pre_pst_cd, 'S', 1, 'T', 2, 'U', 3), vsl_seq) as n3rd_vvd ,
      LEAD(vsl_cd||skd_voy_no||skd_dir_cd, 3) over(partition by bkg_no
        order by decode(vsl_pre_pst_cd, 'S', 1, 'T', 2, 'U', 3), vsl_seq) as n4th_vvd ,
      pol_cd as n1st_pol_cd ,
      pod_cd as n1st_pod_cd ,
      LEAD(pol_cd, 1) over(partition by bkg_no
        order by decode(vsl_pre_pst_cd, 'S', 1, 'T', 2, 'U', 3), vsl_seq) as n2nd_pol_cd ,
      LEAD(pod_cd, 1) over(partition by bkg_no
        order by decode(vsl_pre_pst_cd, 'S', 1, 'T', 2, 'U', 3), vsl_seq) as n2nd_pod_cd ,
      LEAD(pol_cd, 2) over(partition by bkg_no
        order by decode(vsl_pre_pst_cd, 'S', 1, 'T', 2, 'U', 3), vsl_seq) as n3rd_pol_cd ,
      LEAD(pod_cd, 2) over(partition by bkg_no
        order by decode(vsl_pre_pst_cd, 'S', 1, 'T', 2, 'U', 3), vsl_seq) as n3rd_pod_cd ,
      LEAD(pol_cd, 3) over(partition by bkg_no
        order by decode(vsl_pre_pst_cd, 'S', 1, 'T', 2, 'U', 3), vsl_seq) as n4th_pol_cd ,
      LEAD(pod_cd, 3) over(partition by bkg_no
        order by decode(vsl_pre_pst_cd, 'S', 1, 'T', 2, 'U', 3), vsl_seq) as n4th_pod_cd ,
      rev_vvd_flg as n1st_rev_vvd_flg ,
      LEAD(rev_vvd_flg, 1) over(partition by bkg_no
        order by decode(vsl_pre_pst_cd, 'S', 1, 'T', 2, 'U', 3), vsl_seq) as n2nd_rev_vvd_flg ,
      LEAD(rev_vvd_flg, 2) over(partition by bkg_no
        order by decode(vsl_pre_pst_cd, 'S', 1, 'T', 2, 'U', 3), vsl_seq) as n3rd_rev_vvd_flg ,
      LEAD(rev_vvd_flg, 3) over(partition by bkg_no
        order by decode(vsl_pre_pst_cd, 'S', 1, 'T', 2, 'U', 3), vsl_seq) as n4th_rev_vvd_flg
    from bkg_vvd )a2 -- VVD1~4
  ,
  bkg_rate a3 --R 
  ,
  bkg_bl_doc a4 --M 


--    ,bkg_bl_iss a5  --O 
  ,
  mdm_commodity a6 --CMDT 
  ,
  (
    select bkg_no ,
      bkg_cust_tp_cd ,
      cust_cnt_cd as shpr_cnt_cd --bkg_cust_tp_cd:S
      ,
      cust_seq as shpr_cust_seq --bkg_cust_tp_cd:S
      ,
      cust_nm as shpr_nm ,
      cust_tp_cd as s_mscd_cpt --bkg_cust_tp_cd:S
      ,
      rank() over(partition by bkg_no
        order by decode(bkg_cust_tp_cd, 'S', 1, 'N', 2, 'C', 3, 4)) seq1 ,
      LEAD(cust_cnt_cd, 1) over(partition by bkg_no
        order by decode(bkg_cust_tp_cd, 'S', 1, 'N', 2, 'C', 3, 4)) as ntfy_cnt_cd ,
      LEAD(cust_seq, 1) over(partition by bkg_no
        order by decode(bkg_cust_tp_cd, 'S', 1, 'N', 2, 'C', 3, 4)) as ntfy_cust_seq ,
      LEAD(cust_nm, 1) over(partition by bkg_no
        order by decode(bkg_cust_tp_cd, 'S', 1, 'N', 2, 'C', 3, 4)) as ntfy_nm ,
      LEAD(cust_cnt_cd, 2) over(partition by bkg_no
        order by decode(bkg_cust_tp_cd, 'S', 1, 'N', 2, 'C', 3, 4)) as cnee_cnt_cd ,
      LEAD(cust_seq, 2) over(partition by bkg_no
        order by decode(bkg_cust_tp_cd, 'S', 1, 'N', 2, 'C', 3, 4)) as cnee_cnt_seq ,
      LEAD(cust_nm, 2) over(partition by bkg_no
        order by decode(bkg_cust_tp_cd, 'S', 1, 'N', 2, 'C', 3, 4)) as cnee_nm
    from bkg_customer ) a7 --S1,C1,N1
  ,
  mdm_customer a8 --S2  
  ,
  mdm_location a9 --loc1 
  ,
  mdm_location a10 --loc2 
  ,
  mdm_location a11 --loc3 
  ,
  mdm_location a12 --loc4 
  ,
  mdm_location a13 --loc5 
  ,
  mdm_location pol1 ,
  mdm_location pod1 ,
  mdm_location pol2 ,
  mdm_location pod2 ,
  mdm_location pol3 ,
  mdm_location pod3 ,
  mdm_location pol4 ,
  mdm_location pod4
where 1=1

--  and a1.bkg_no        = 'TSNXXK03360'
  and a1.bkg_no = a2.bkg_no
  and a2.seq1 = 1 -- bkg_vvd에서 1번만 가지고 오면 모든 정보를 가지고올수 있음
  and a1.bkg_no = a3.bkg_no(+)
  and a1.bkg_no = a4.bkg_no(+)

--  and a1.bkg_no        = a5.bkg_no(+)
  and a1.cmdt_cd = a6.cmdt_cd(+) --20100421 cmdt 코드가 맞지 않아 bkg전체를 조회하지 못하고 있어서 (+) 사용함
  and a6.delt_flg = 'N' -- BKG에서 삭제된 CMDT 코드가 들어와서 문제가됨
  and a1.bkg_no = a7.bkg_no(+)
  and a7.seq1 = 1
  and a7.shpr_cnt_cd = a8.cust_cnt_cd(+)
  and a7.shpr_cust_seq = a8.cust_seq(+)
  and a2.n1st_pol_cd = a9.loc_cd(+)
  and a2.n1st_pod_cd = a10.loc_cd(+)
  and a2.n2nd_pod_cd = a11.loc_cd(+)
  and a2.n3rd_pod_cd = a12.loc_cd(+)
  and a2.n4th_pod_cd = a13.loc_cd(+)
  and a2.n1st_pol_cd = pol1.loc_cd(+)
  and a2.n1st_pod_cd = pod1.loc_cd(+)
  and a2.n2nd_pol_cd = pol2.loc_cd(+)
  and a2.n2nd_pod_cd = pod2.loc_cd(+)
  and a2.n3rd_pol_cd = pol3.loc_cd(+)
  and a2.n3rd_pod_cd = pod3.loc_cd(+)
  and a2.n4th_pol_cd = pol4.loc_cd(+)
  and a2.n4th_pod_cd = pod4.loc_cd(+);