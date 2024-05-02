CREATE OR REPLACE PACKAGE COA_COST_PARA_ASSIGN_PKG
AUTHID CURRENT_USER
AS
/*******************************************************************************
   1. Object Name      : COA_COST_PARA_ASSIGN_PKG
   2. Version          : 1.0
   3. Create Date      : 2007-02-11
   4. Sub System       : COA
   5.Revision History
       2014.11.13 PCM NYK Mty Repo Cost
       2014.11.18 SMY Internal Pricing   
*******************************************************************************/

   PROCEDURE main_prd_avg(
      in_bkg_no          IN   VARCHAR2
     ,in_start_pctl_no   IN   VARCHAR2
     ,in_end_pctl_no     IN   VARCHAR2
     ,in_cost_yrmon      IN   VARCHAR2
   );

   PROCEDURE main_cop_avg(
      in_bkg_no          IN   VARCHAR2
     ,in_start_pctl_no   IN   VARCHAR2
     ,in_end_pctl_no     IN   VARCHAR2
     ,in_cost_yrmon      IN   VARCHAR2
   ); 
   
   PROCEDURE main_prd_prod_ctl_mst(in_start_pctl_no IN VARCHAR2, in_end_pctl_no IN VARCHAR2, in_cost_yrmon IN VARCHAR2);

   PROCEDURE main_com_ttl_para(
      in_bkg_no          IN   VARCHAR2
     ,in_start_pctl_no   IN   VARCHAR2
     ,in_end_pctl_no     IN   VARCHAR2
     ,in_cost_yrmon      IN   VARCHAR2
   );

   FUNCTION para_tes_avg(
      in_bkg_no          IN   VARCHAR2
     ,in_start_pctl_no   IN   VARCHAR2
     ,in_end_pctl_no     IN   VARCHAR2
     ,in_cost_yrmon      IN   VARCHAR2
     ,in_appl_info       IN   VARCHAR2
   )
      RETURN VARCHAR2;

   FUNCTION para_trs_avg(
      in_bkg_no          IN   VARCHAR2
     ,in_start_pctl_no   IN   VARCHAR2
     ,in_end_pctl_no     IN   VARCHAR2
     ,in_cost_yrmon      IN   VARCHAR2
     ,in_appl_info       IN   VARCHAR2
   )
      RETURN VARCHAR2;

   FUNCTION pa_tes_mty(
      in_bkg_no          IN   VARCHAR2
     ,in_start_pctl_no   IN   VARCHAR2
     ,in_end_pctl_no     IN   VARCHAR2
     ,in_cost_yrmon      IN   VARCHAR2
     ,in_appl_info       IN   VARCHAR2
   )
      RETURN VARCHAR2;

   FUNCTION pa_trs_mty(
      in_bkg_no          IN   VARCHAR2
     ,in_start_pctl_no   IN   VARCHAR2
     ,in_end_pctl_no     IN   VARCHAR2
     ,in_cost_yrmon      IN   VARCHAR2
     ,in_appl_info       IN   VARCHAR2
   )
      RETURN VARCHAR2;

   FUNCTION get_mty_ecc_ut_cost_uc_amt(
      in_cost_yrmon      IN   VARCHAR
     ,in_cntr_tpsz_cd    IN   VARCHAR
     ,in_mty_fm_nod_cd   IN   VARCHAR
     ,in_mty_to_nod_cd   IN   VARCHAR
     ,in_trd_cd          IN   VARCHAR
     ,in_appl_info       IN   VARCHAR2
   )
      RETURN VARCHAR;

   FUNCTION para_dmdt(
      in_bkg_no          IN   VARCHAR2
     ,in_start_pctl_no   IN   VARCHAR2
     ,in_end_pctl_no     IN   VARCHAR2
     ,in_cost_yrmon      IN   VARCHAR2
     ,in_appl_info       IN   VARCHAR2
   )
      RETURN VARCHAR2;

   FUNCTION pa_hld(
      in_bkg_no          IN   VARCHAR2
     ,in_start_pctl_no   IN   VARCHAR2
     ,in_end_pctl_no     IN   VARCHAR2
     ,in_cost_yrmon      IN   VARCHAR2
     ,in_appl_info       IN   VARCHAR2
   )
      RETURN VARCHAR2;

   FUNCTION get_mcgo_tz_days(
      in_cost_yrmon      IN   VARCHAR
     ,in_eq_tpsz_cd      IN   VARCHAR
     ,in_mty_fm_nod_cd   IN   VARCHAR
     ,in_mty_to_nod_cd   IN   VARCHAR
     ,in_appl_info       IN   VARCHAR2
   )
      RETURN VARCHAR;
      
   FUNCTION get_ioc(in_pol_cd IN VARCHAR, in_pod_cd IN VARCHAR, in_appl_info IN VARCHAR2)
      RETURN VARCHAR;

   FUNCTION clr_tes_tp(
      in_bkg_no          IN   VARCHAR2
     ,in_start_pctl_no   IN   VARCHAR2
     ,in_end_pctl_no     IN   VARCHAR2
     ,in_appl_info       IN   VARCHAR2
   )
      RETURN VARCHAR2;

   FUNCTION calc_prd_sum_cost(in_start_pctl_no IN VARCHAR2, in_end_pctl_no IN VARCHAR2, in_cost_yrmon IN VARCHAR2, in_appl_info IN VARCHAR2)
      RETURN VARCHAR2;

   FUNCTION calc_ttl_cost(
      in_bkg_no          IN   VARCHAR2
     ,in_start_pctl_no   IN   VARCHAR2
     ,in_end_pctl_no     IN   VARCHAR2
     ,in_cost_yrmon      IN   VARCHAR2
     ,in_appl_info       IN   VARCHAR2
   )
      RETURN VARCHAR2;

   FUNCTION clr_fdr_term(
      in_bkg_no          IN   VARCHAR2
     ,in_start_pctl_no   IN   VARCHAR2
     ,in_end_pctl_no     IN   VARCHAR2
     ,in_appl_info       IN   VARCHAR2
   )
      RETURN VARCHAR2;
      
   FUNCTION para_agt_oth(
      in_bkg_no          IN   VARCHAR2
     ,in_start_pctl_no   IN   VARCHAR2
     ,in_end_pctl_no     IN   VARCHAR2
     ,in_cost_yrmon      IN   VARCHAR2
     ,in_appl_info       IN   VARCHAR2
   )
      RETURN VARCHAR2;  
      
   FUNCTION para_slt_inter_prc(  
      in_bkg_no          IN   VARCHAR2
     ,in_start_pctl_no   IN   VARCHAR2
     ,in_end_pctl_no     IN   VARCHAR2
     ,in_cost_yrmon      IN   VARCHAR2
     ,in_appl_info       IN   VARCHAR2
   )
      RETURN VARCHAR2;      
         
   FUNCTION para_so_cancel(
      in_bkg_no          IN   VARCHAR2
     ,in_appl_info       IN   VARCHAR2
   )
      RETURN VARCHAR2;     
      
END COA_COST_PARA_ASSIGN_PKG;