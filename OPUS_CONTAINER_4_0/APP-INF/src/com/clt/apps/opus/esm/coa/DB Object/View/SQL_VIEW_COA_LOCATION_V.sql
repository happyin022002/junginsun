CREATE OR REPLACE VIEW "OPUSADM"."COA_LOCATION_V"
(   LOC_CD,
    SCC_CD,
    ECC_CD,
    LCC_CD,
    RCC_CD
)
AS
select a.loc_cd,
  a.scc_cd,
  b.ecc_cd,
  b.lcc_cd,
  b.Rcc_cd
from mdm_location a,
  mdm_eq_orz_cht b
where a.scc_cd = b.scc_cd
  and b.delt_flg ='N'
 ;