CREATE OR REPLACE VIEW "OPUSADM"."COA_REV_LANE_V"
(   RLANE_CD,
    SLAN_CD,
    DIR_CD,
    FM_CONTI_CD,
    TO_CONTI_CD,
    TRD_CD
)
AS
select distinct a.rlane_cd,
  vsl_slan_cd slan_cd ,
  a.VSL_SLAN_DIR_CD dir_cd,
  a.fm_conti_cd,
  a.to_conti_cd,
  A.TRD_CD
from mdm_dtl_rev_lane a,
  mdm_rev_lane b
where a.rlane_cd = b.rlane_cd
  and b.vsl_tp_cd = 'C'
 ;