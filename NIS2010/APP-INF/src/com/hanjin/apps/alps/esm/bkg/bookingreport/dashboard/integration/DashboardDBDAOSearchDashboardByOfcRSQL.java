/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : DashboardDBDAOSearchDashboardByOfcRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.12.19
*@LastModifier : 
*@LastVersion : 1.0
* 2013.12.19 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingreport.dashboard.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class DashboardDBDAOSearchDashboardByOfcRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Office 기준으로 대시보드 리스트를 조회한다.
	  * </pre>
	  */
	public DashboardDBDAOSearchDashboardByOfcRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_rep_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("combo_gcust",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_pod_nod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_vvd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_staff_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_pol_nod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_rhq_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("combo_cust",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_ctrt_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_gcust_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_cust_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_bkg_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.bookingreport.dashboard.integration").append("\n"); 
		query.append("FileName : DashboardDBDAOSearchDashboardByOfcRSQL").append("\n"); 
		query.append("*/").append("\n"); 
	}
	
	public String getSQL(){
		return query.toString();
	}
	
	public HashMap<String,String[]> getParams() {
		return params;
	}

	/**
	 * Query 생성
	 */
	public void setQuery(){
		query.append("SELECT" ).append("\n"); 
		query.append("  DEST" ).append("\n"); 
		query.append(", BKG_OFC_CD  " ).append("\n"); 
		query.append(", NVL(MIN(CNT_1),'0/'||MIN(BKG_TOT_CNT)) CNT_RATED" ).append("\n"); 
		query.append(", NVL(MIN(LMT_1),0) LMT_RATED" ).append("\n"); 
		query.append(", NVL(MIN(CNT_2),'0/'||MIN(BKG_TOT_CNT)) CNT_DWL_NTFC" ).append("\n"); 
		query.append(", NVL(MIN(LMT_2),0) LMT_DWL_NTFC" ).append("\n"); 
		query.append(", NVL(MIN(CNT_3),'0/'||MIN(BKG_TOT_CNT)) CNT_PORT_SKIP" ).append("\n"); 
		query.append(", NVL(MIN(LMT_3),0) LMT_PORT_SKIP" ).append("\n"); 
		query.append(", NVL(MIN(CNT_4),'0/'||MIN(BKG_TOT_CNT)) CNT_TPB" ).append("\n"); 
		query.append(", NVL(MIN(LMT_4),0) LMT_TPB" ).append("\n"); 
		query.append(", NVL(MIN(CNT_5),'0/'||MIN(BKG_TOT_CNT)) CNT_NOT_UPD_CNTR" ).append("\n"); 
		query.append(", NVL(MIN(LMT_5),0) LMT_NOT_UPD_CNTR" ).append("\n"); 
		query.append(", NVL(MIN(CNT_6),'0/'||MIN(BKG_TOT_CNT)) CNT_OBL_RLS" ).append("\n"); 
		query.append(", NVL(MIN(LMT_6),0) LMT_OBL_RLS" ).append("\n"); 
		query.append(", NVL(MIN(CNT_7),'0/'||MIN(BKG_TOT_CNT)) CNT_WT_BKG" ).append("\n"); 
		query.append(", NVL(MIN(LMT_7),0) LMT_WT_BKG" ).append("\n"); 
		query.append(", NVL(MIN(CNT_8),'0/'||MIN(BKG_TOT_CNT)) CNT_CUST_ADV_FX_SND" ).append("\n"); 
		query.append(", NVL(MIN(LMT_8),0) LMT_CUST_ADV_FX_SND" ).append("\n"); 
		query.append(", NVL(MIN(CNT_9),'0/'||MIN(BKG_TOT_CNT)) CNT_CNTR_FNL_CFM" ).append("\n"); 
		query.append(", NVL(MIN(LMT_9),0) LMT_CNTR_FNL_CFM" ).append("\n"); 
		query.append(", NVL(MIN(CNT_10),'0/'||MIN(BKG_TOT_CNT)) CNT_CNTRT_APP" ).append("\n"); 
		query.append(", NVL(MIN(LMT_10),0) LMT_CNTRT_APP" ).append("\n"); 
		query.append(", NVL(MIN(CNT_11),'0/'||MIN(BKG_TOT_CNT)) CNT_RDN" ).append("\n"); 
		query.append(", NVL(MIN(LMT_11),0) LMT_RDN" ).append("\n"); 
		query.append(", NVL(MIN(CNT_12),'0/'||MIN(BKG_TOT_CNT)) CNT_US_HLD" ).append("\n"); 
		query.append(", NVL(MIN(LMT_12),0) LMT_US_HLD" ).append("\n"); 
		query.append(", NVL(MIN(CNT_13),'0/'||MIN(BKG_TOT_CNT)) CNT_EUR_HLD" ).append("\n"); 
		query.append(", NVL(MIN(LMT_13),0) LMT_EUR_HLD" ).append("\n"); 
		query.append(", NVL(MIN(CNT_14),'0/'||MIN(BKG_TOT_CNT)) CNT_301_TML" ).append("\n"); 
		query.append(", NVL(MIN(LMT_14),0) LMT_301_TML" ).append("\n"); 
		query.append(", NVL(MIN(CNT_15),'0/'||MIN(BKG_TOT_CNT)) CNT_BKR_HLD" ).append("\n"); 
		query.append(", NVL(MIN(LMT_15),0) LMT_BKR_HLD" ).append("\n"); 
		query.append(", NVL(MIN(CNT_16),'0/'||MIN(BKG_TOT_CNT)) CNT_COD" ).append("\n"); 
		query.append(", NVL(MIN(LMT_16),0) LMT_COD" ).append("\n"); 
		query.append(", NVL(MIN(CNT_17),'0/'||MIN(BKG_TOT_CNT)) CNT_NW_WB_BL_INSTR" ).append("\n"); 
		query.append(", NVL(MIN(LMT_17),0) LMT_NW_WB_BL_INSTR" ).append("\n"); 
		query.append(", NVL(MIN(CNT_18),'0/'||MIN(BKG_TOT_CNT)) CNT_VSL_SKD_CHG" ).append("\n"); 
		query.append(", NVL(MIN(LMT_18),0) LMT_VSL_SKD_CHG" ).append("\n"); 
		query.append(", NVL(MIN(CNT_19),'0/'||MIN(BKG_TOT_CNT)) CNT_VSL_SKD_DLY_NTC" ).append("\n"); 
		query.append(", NVL(MIN(LMT_19),0) LMT_VSL_SKD_DLY_NTC" ).append("\n"); 
		query.append(", NVL(MIN(CNT_20),'0/'||MIN(BKG_TOT_CNT)) CNT_E_SI_RJT" ).append("\n"); 
		query.append(", NVL(MIN(LMT_20),0) LMT_E_SI_RJT" ).append("\n"); 
		query.append(", NVL(MIN(CNT_21),'0/'||MIN(BKG_TOT_CNT)) CNT_BKG_RCP_NTC" ).append("\n"); 
		query.append(", NVL(MIN(LMT_21),0) LMT_BKG_RCP_NTC" ).append("\n"); 
		query.append(", NVL(MIN(CNT_22),'0/'||MIN(BKG_TOT_CNT)) CNT_DEM_DET" ).append("\n"); 
		query.append(", NVL(MIN(LMT_22),0) LMT_DEM_DET" ).append("\n"); 
		query.append(", NVL(MIN(CNT_23),'0/'||MIN(BKG_TOT_CNT)) CNT_OCN_DEL" ).append("\n"); 
		query.append(", NVL(MIN(LMT_23),0) LMT_OCN_DEL" ).append("\n"); 
		query.append(", NVL(MIN(CNT_24),'0/'||MIN(BKG_TOT_CNT)) CNT_IRG_DEL" ).append("\n"); 
		query.append(", NVL(MIN(LMT_24),0) LMT_IRG_DEL" ).append("\n"); 
		query.append(", NVL(MIN(CNT_25),'0/'||MIN(BKG_TOT_CNT)) CNT_ARR_NTC" ).append("\n"); 
		query.append(", NVL(MIN(LMT_25),0) LMT_ARR_NTC" ).append("\n"); 
		query.append(", NVL(MIN(CNT_26),'0/'||MIN(BKG_TOT_CNT)) CNT_SPCL_CGO_APR" ).append("\n"); 
		query.append(", NVL(MIN(LMT_26),0) LMT_SPCL_CGO_APR" ).append("\n"); 
		query.append(", NVL(MIN(CNT_27),'0/'||MIN(BKG_TOT_CNT)) CNT_DWL_CNDDT" ).append("\n"); 
		query.append(", NVL(MIN(LMT_27),0) LMT_DWL_CNDDT" ).append("\n"); 
		query.append(", NVL(MIN(CNT_30),'0/'||MIN(BKG_TOT_CNT)) CNT_PHSE_OUT" ).append("\n"); 
		query.append(", NVL(MIN(LMT_30),0) LMT_PHSE_OUT" ).append("\n"); 
		query.append(", NVL(MIN(CNT_40),'0/'||MIN(BKG_TOT_CNT)) CNT_VL_UNMTCH" ).append("\n"); 
		query.append(", NVL(MIN(LMT_40),0) LMT_VL_UNMTCH" ).append("\n"); 
		query.append(", NVL(MIN(CNT_41),'0/'||MIN(BKG_TOT_CNT)) CNT_VD_UNMTCH" ).append("\n"); 
		query.append(", NVL(MIN(LMT_41),0) LMT_VD_UNMTCH" ).append("\n"); 
		query.append(", NVL(MIN(CNT_51),'0/'||MIN(BKG_TOT_CNT)) CNT_DRFT_BL" ).append("\n"); 
		query.append(", NVL(MIN(LMT_51),0) LMT_DRFT_BL" ).append("\n"); 
		query.append(", NVL(MIN(CNT_61),'0/'||MIN(BKG_TOT_CNT)) CNT_LNK_CNSTR" ).append("\n"); 
		query.append(", NVL(MIN(LMT_61),0) LMT_LNK_CNSTR" ).append("\n"); 
		query.append(", NVL(MIN(CNT_62),'0/'||MIN(BKG_TOT_CNT)) CNT_NOD_CNSTR" ).append("\n"); 
		query.append(", NVL(MIN(LMT_62),0) LMT_NOD_CNSTR" ).append("\n"); 
		query.append(", NVL(MIN(CNT_63),'0/'||MIN(BKG_TOT_CNT)) CNT_ROUT_CNSTR" ).append("\n"); 
		query.append(", NVL(MIN(LMT_63),0) LMT_ROUT_CNSTR" ).append("\n"); 
		query.append(", NVL(MIN(CNT_64),'0/'||MIN(BKG_TOT_CNT)) CNT_PRD_CNSTR" ).append("\n"); 
		query.append(", NVL(MIN(LMT_64),0) LMT_PRD_CNSTR" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("  DEST" ).append("\n"); 
		query.append(", BKG_OFC_CD  " ).append("\n"); 
		query.append(", DECODE(DBD_IRR_TP_CD,1,TOT_CNT) CNT_1" ).append("\n"); 
		query.append(", DECODE(DBD_IRR_TP_CD,1,LMT_STEP_NO) LMT_1" ).append("\n"); 
		query.append(", DECODE(DBD_IRR_TP_CD,2,TOT_CNT) CNT_2" ).append("\n"); 
		query.append(", DECODE(DBD_IRR_TP_CD,2,LMT_STEP_NO) LMT_2" ).append("\n"); 
		query.append(", DECODE(DBD_IRR_TP_CD,3,TOT_CNT) CNT_3" ).append("\n"); 
		query.append(", DECODE(DBD_IRR_TP_CD,3,LMT_STEP_NO) LMT_3" ).append("\n"); 
		query.append(", DECODE(DBD_IRR_TP_CD,4,TOT_CNT) CNT_4" ).append("\n"); 
		query.append(", DECODE(DBD_IRR_TP_CD,4,LMT_STEP_NO) LMT_4" ).append("\n"); 
		query.append(", DECODE(DBD_IRR_TP_CD,5,TOT_CNT) CNT_5" ).append("\n"); 
		query.append(", DECODE(DBD_IRR_TP_CD,5,LMT_STEP_NO) LMT_5" ).append("\n"); 
		query.append(", DECODE(DBD_IRR_TP_CD,6,TOT_CNT) CNT_6" ).append("\n"); 
		query.append(", DECODE(DBD_IRR_TP_CD,6,LMT_STEP_NO) LMT_6" ).append("\n"); 
		query.append(", DECODE(DBD_IRR_TP_CD,7,TOT_CNT) CNT_7" ).append("\n"); 
		query.append(", DECODE(DBD_IRR_TP_CD,7,LMT_STEP_NO) LMT_7" ).append("\n"); 
		query.append(", DECODE(DBD_IRR_TP_CD,8,TOT_CNT) CNT_8" ).append("\n"); 
		query.append(", DECODE(DBD_IRR_TP_CD,8,LMT_STEP_NO) LMT_8" ).append("\n"); 
		query.append(", DECODE(DBD_IRR_TP_CD,9,TOT_CNT) CNT_9" ).append("\n"); 
		query.append(", DECODE(DBD_IRR_TP_CD,9,LMT_STEP_NO) LMT_9" ).append("\n"); 
		query.append(", DECODE(DBD_IRR_TP_CD,10,TOT_CNT) CNT_10" ).append("\n"); 
		query.append(", DECODE(DBD_IRR_TP_CD,10,LMT_STEP_NO) LMT_10" ).append("\n"); 
		query.append(", DECODE(DBD_IRR_TP_CD,11,TOT_CNT) CNT_11" ).append("\n"); 
		query.append(", DECODE(DBD_IRR_TP_CD,11,LMT_STEP_NO) LMT_11" ).append("\n"); 
		query.append(", DECODE(DBD_IRR_TP_CD,12,TOT_CNT) CNT_12" ).append("\n"); 
		query.append(", DECODE(DBD_IRR_TP_CD,12,LMT_STEP_NO) LMT_12" ).append("\n"); 
		query.append(", DECODE(DBD_IRR_TP_CD,13,TOT_CNT) CNT_13" ).append("\n"); 
		query.append(", DECODE(DBD_IRR_TP_CD,13,LMT_STEP_NO) LMT_13" ).append("\n"); 
		query.append(", DECODE(DBD_IRR_TP_CD,14,TOT_CNT) CNT_14" ).append("\n"); 
		query.append(", DECODE(DBD_IRR_TP_CD,14,LMT_STEP_NO) LMT_14" ).append("\n"); 
		query.append(", DECODE(DBD_IRR_TP_CD,15,TOT_CNT) CNT_15" ).append("\n"); 
		query.append(", DECODE(DBD_IRR_TP_CD,15,LMT_STEP_NO) LMT_15" ).append("\n"); 
		query.append(", DECODE(DBD_IRR_TP_CD,16,TOT_CNT) CNT_16" ).append("\n"); 
		query.append(", DECODE(DBD_IRR_TP_CD,16,LMT_STEP_NO) LMT_16" ).append("\n"); 
		query.append(", DECODE(DBD_IRR_TP_CD,17,TOT_CNT) CNT_17" ).append("\n"); 
		query.append(", DECODE(DBD_IRR_TP_CD,17,LMT_STEP_NO) LMT_17" ).append("\n"); 
		query.append(", DECODE(DBD_IRR_TP_CD,18,TOT_CNT) CNT_18" ).append("\n"); 
		query.append(", DECODE(DBD_IRR_TP_CD,18,LMT_STEP_NO) LMT_18" ).append("\n"); 
		query.append(", DECODE(DBD_IRR_TP_CD,19,TOT_CNT) CNT_19" ).append("\n"); 
		query.append(", DECODE(DBD_IRR_TP_CD,19,LMT_STEP_NO) LMT_19" ).append("\n"); 
		query.append(", DECODE(DBD_IRR_TP_CD,20,TOT_CNT) CNT_20" ).append("\n"); 
		query.append(", DECODE(DBD_IRR_TP_CD,20,LMT_STEP_NO) LMT_20" ).append("\n"); 
		query.append(", DECODE(DBD_IRR_TP_CD,21,TOT_CNT) CNT_21" ).append("\n"); 
		query.append(", DECODE(DBD_IRR_TP_CD,21,LMT_STEP_NO) LMT_21" ).append("\n"); 
		query.append(", DECODE(DBD_IRR_TP_CD,22,TOT_CNT) CNT_22" ).append("\n"); 
		query.append(", DECODE(DBD_IRR_TP_CD,22,LMT_STEP_NO) LMT_22" ).append("\n"); 
		query.append(", DECODE(DBD_IRR_TP_CD,23,TOT_CNT) CNT_23" ).append("\n"); 
		query.append(", DECODE(DBD_IRR_TP_CD,23,LMT_STEP_NO) LMT_23" ).append("\n"); 
		query.append(", DECODE(DBD_IRR_TP_CD,24,TOT_CNT) CNT_24" ).append("\n"); 
		query.append(", DECODE(DBD_IRR_TP_CD,24,LMT_STEP_NO) LMT_24" ).append("\n"); 
		query.append(", DECODE(DBD_IRR_TP_CD,25,TOT_CNT) CNT_25" ).append("\n"); 
		query.append(", DECODE(DBD_IRR_TP_CD,25,LMT_STEP_NO) LMT_25" ).append("\n"); 
		query.append(", DECODE(DBD_IRR_TP_CD,26,TOT_CNT) CNT_26" ).append("\n"); 
		query.append(", DECODE(DBD_IRR_TP_CD,26,LMT_STEP_NO) LMT_26" ).append("\n"); 
		query.append(", DECODE(DBD_IRR_TP_CD,27,TOT_CNT) CNT_27" ).append("\n"); 
		query.append(", DECODE(DBD_IRR_TP_CD,27,LMT_STEP_NO) LMT_27" ).append("\n"); 
		query.append(", DECODE(DBD_IRR_TP_CD,30,TOT_CNT) CNT_30" ).append("\n"); 
		query.append(", DECODE(DBD_IRR_TP_CD,30,LMT_STEP_NO) LMT_30" ).append("\n"); 
		query.append(", DECODE(DBD_IRR_TP_CD,40,TOT_CNT) CNT_40" ).append("\n"); 
		query.append(", DECODE(DBD_IRR_TP_CD,40,LMT_STEP_NO) LMT_40" ).append("\n"); 
		query.append(", DECODE(DBD_IRR_TP_CD,41,TOT_CNT) CNT_41" ).append("\n"); 
		query.append(", DECODE(DBD_IRR_TP_CD,41,LMT_STEP_NO) LMT_41" ).append("\n"); 
		query.append(", DECODE(DBD_IRR_TP_CD,51,TOT_CNT) CNT_51" ).append("\n"); 
		query.append(", DECODE(DBD_IRR_TP_CD,51,LMT_STEP_NO) LMT_51" ).append("\n"); 
		query.append(", DECODE(DBD_IRR_TP_CD,61,TOT_CNT) CNT_61" ).append("\n"); 
		query.append(", DECODE(DBD_IRR_TP_CD,61,LMT_STEP_NO) LMT_61" ).append("\n"); 
		query.append(", DECODE(DBD_IRR_TP_CD,62,TOT_CNT) CNT_62" ).append("\n"); 
		query.append(", DECODE(DBD_IRR_TP_CD,62,LMT_STEP_NO) LMT_62" ).append("\n"); 
		query.append(", DECODE(DBD_IRR_TP_CD,63,TOT_CNT) CNT_63" ).append("\n"); 
		query.append(", DECODE(DBD_IRR_TP_CD,63,LMT_STEP_NO) LMT_63" ).append("\n"); 
		query.append(", DECODE(DBD_IRR_TP_CD,64,TOT_CNT) CNT_64" ).append("\n"); 
		query.append(", DECODE(DBD_IRR_TP_CD,64,LMT_STEP_NO) LMT_64" ).append("\n"); 
		query.append(", BKG_TOT_CNT" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("    SELECT" ).append("\n"); 
		query.append("      DBD_IRR_TP_CD" ).append("\n"); 
		query.append("    , BKG_OFC_CD" ).append("\n"); 
		query.append("    , DEST" ).append("\n"); 
		query.append("    , CNT" ).append("\n"); 
		query.append("    , PCNT" ).append("\n"); 
		query.append("    , TOT_CNT" ).append("\n"); 
		query.append("    , LMT_STEP_NO" ).append("\n"); 
		query.append("    , BKG_TOT_CNT" ).append("\n"); 
		query.append("    FROM" ).append("\n"); 
		query.append("    ( " ).append("\n"); 
		query.append("        SELECT" ).append("\n"); 
		query.append("        ROW_NUMBER() OVER (PARTITION BY C.DEST, C.BKG_OFC_CD, C.DBD_IRR_TP_CD  ORDER BY LMT_STEP_NO ) PROT2" ).append("\n"); 
		query.append("        , C.DBD_IRR_TP_CD" ).append("\n"); 
		query.append("        , C.BKG_OFC_CD" ).append("\n"); 
		query.append("        , DEST" ).append("\n"); 
		query.append("        , CNT" ).append("\n"); 
		query.append("        , PCNT" ).append("\n"); 
		query.append("        , TOT_CNT" ).append("\n"); 
		query.append("        , LMT_STEP_NO" ).append("\n"); 
		query.append("        , BKG_TOT_CNT" ).append("\n"); 
		query.append("        FROM" ).append("\n"); 
		query.append("        (" ).append("\n"); 
		query.append("            SELECT" ).append("\n"); 
		query.append("              A2.DBD_IRR_TP_CD" ).append("\n"); 
		query.append("            , A2.BKG_OFC_CD" ).append("\n"); 
		query.append("            , A2.DEST" ).append("\n"); 
		query.append("            , A2.CNT" ).append("\n"); 
		query.append("            , ROUND(A2.CNT/A1.CNT*100,1) PCNT" ).append("\n"); 
		query.append("            , A2.CNT||'/'||A1.CNT TOT_CNT" ).append("\n"); 
		query.append("            , A1.CNT BKG_TOT_CNT" ).append("\n"); 
		query.append("            FROM" ).append("\n"); 
		query.append("            (" ).append("\n"); 
		query.append("            SELECT" ).append("\n"); 
		query.append("              N.BKG_OFC_CD" ).append("\n"); 
		query.append("            , SUBSTR(B.POD_NOD_CD, 1,2) DEST" ).append("\n"); 
		query.append("            , COUNT(N.BKG_NO) CNT" ).append("\n"); 
		query.append("            FROM BKG_DBD_BAT A" ).append("\n"); 
		query.append("            , BKG_DBD_BAT_CNDDT N" ).append("\n"); 
		query.append("            , BKG_BOOKING B" ).append("\n"); 
		query.append("            WHERE 1=1" ).append("\n"); 
		query.append("            AND A.BAT_STS_CD = 'S'" ).append("\n"); 
		query.append("            AND A.DBD_CRE_DT = N.DBD_CRE_DT" ).append("\n"); 
		query.append("            AND A.DBD_CRE_SEQ = N.DBD_CRE_SEQ" ).append("\n"); 
		query.append("            AND N.BKG_NO = B.BKG_NO" ).append("\n"); 
		query.append("        #if (${s_kind} == 'rhq')" ).append("\n"); 
		query.append("            #if (${f_rhq_cd} != '')" ).append("\n"); 
		query.append("            AND N.BKG_OFC_CD IN (SELECT OFC_CD FROM MDM_ORGANIZATION CONNECT BY PRIOR OFC_CD = PRNT_OFC_CD START WITH OFC_CD = @[f_rhq_cd])" ).append("\n"); 
		query.append("            #end" ).append("\n"); 
		query.append("        #elseif (${s_kind} == 'ofc')" ).append("\n"); 
		query.append("            #if (${f_sub_bkg_ofc_cd} != '')" ).append("\n"); 
		query.append("            AND N.BKG_OFC_CD IN (${f_sub_bkg_ofc_list})" ).append("\n"); 
		query.append("            #elseif (${f_bkg_ofc_cd} != '')" ).append("\n"); 
		query.append("            AND N.BKG_OFC_CD = @[f_bkg_ofc_cd]" ).append("\n"); 
		query.append("            #end" ).append("\n"); 
		query.append("        #elseif (${s_kind} == 'bkgno')" ).append("\n"); 
		query.append("            #if (${f_bkg_no} != '')" ).append("\n"); 
		query.append("            AND N.BKG_NO = @[f_bkg_no]" ).append("\n"); 
		query.append("            #end" ).append("\n"); 
		query.append("        #elseif (${s_kind} == 'cust')" ).append("\n"); 
		query.append("            AND EXISTS (SELECT 'X' FROM BKG_CUSTOMER CU WHERE B.BKG_NO = CU.BKG_NO" ).append("\n"); 
		query.append("            #if (${combo_cust} != 'Z' && ${combo_cust} != '')" ).append("\n"); 
		query.append("                           AND CU.BKG_CUST_TP_CD = @[combo_cust]" ).append("\n"); 
		query.append("            #end" ).append("\n"); 
		query.append("            #if (${f_cust_cd} != '')" ).append("\n"); 
		query.append("                           AND (CU.CUST_CNT_CD,CU.CUST_SEQ) IN (( SUBSTR(@[f_cust_cd],1,2),SUBSTR(@[f_cust_cd],3) ))" ).append("\n"); 
		query.append("            #end       )" ).append("\n"); 
		query.append("        #elseif (${s_kind} == 'gcust')" ).append("\n"); 
		query.append("            AND EXISTS (SELECT 'X' FROM BKG_CUSTOMER CU, MDM_CUSTOMER M WHERE B.BKG_NO = CU.BKG_NO" ).append("\n"); 
		query.append("                           AND CU.CUST_CNT_CD = M.CUST_CNT_CD" ).append("\n"); 
		query.append("                           AND CU.CUST_SEQ = M.CUST_SEQ" ).append("\n"); 
		query.append("            #if (${combo_gcust} != 'Z' && ${combo_gcust} != '')" ).append("\n"); 
		query.append("                           AND CU.BKG_CUST_TP_CD = @[combo_gcust]" ).append("\n"); 
		query.append("            #end" ).append("\n"); 
		query.append("            #if (${f_gcust_cd} != '')" ).append("\n"); 
		query.append("                           AND M.CUST_GRP_ID = @[f_gcust_cd]" ).append("\n"); 
		query.append("            #end       )" ).append("\n"); 
		query.append("        #elseif (${s_kind} == 'ctrt')" ).append("\n"); 
		query.append("            #if (${combo_ctrt} == 'S')" ).append("\n"); 
		query.append("            AND B.SC_NO = @[f_ctrt_no]" ).append("\n"); 
		query.append("            #elseif (${combo_ctrt} == 'R')" ).append("\n"); 
		query.append("            AND B.RFA_NO = @[f_ctrt_no]" ).append("\n"); 
		query.append("            #elseif (${combo_ctrt} == 'T')" ).append("\n"); 
		query.append("            AND B.TAA_NO = @[f_ctrt_no]" ).append("\n"); 
		query.append("            #else" ).append("\n"); 
		query.append("            AND @[f_ctrt_no] IN (C.SC_NO, C.RFA_NO, C.TAA_NO)" ).append("\n"); 
		query.append("            #end" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("        #if (${f_pol_nod_cd} != '')" ).append("\n"); 
		query.append("            AND B.POL_NOD_CD LIKE @[f_pol_nod_cd]||'%'" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("        #if (${f_pod_nod_cd} != '')" ).append("\n"); 
		query.append("            AND B.POD_NOD_CD LIKE @[f_pod_nod_cd]||'%'" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("        #if (${f_vvd} != '')" ).append("\n"); 
		query.append("        AND EXISTS (SELECT 'X' FROM BKG_VVD V WHERE 1=1" ).append("\n"); 
		query.append("                       AND N.BKG_NO = V.BKG_NO" ).append("\n"); 
		query.append("                       AND (V.VSL_CD,V.SKD_VOY_NO,V.SKD_DIR_CD) IN ((SUBSTR(@[f_vvd],1,4),SUBSTR(@[f_vvd],5,4),SUBSTR(@[f_vvd],9,1)))" ).append("\n"); 
		query.append("                    )" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("        #if (${f_staff_id} != '')" ).append("\n"); 
		query.append("            AND B.DOC_USR_ID = @[f_staff_id]" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("        #if (${f_rep_id} != '')" ).append("\n"); 
		query.append("            AND B.OB_SREP_CD = @[f_rep_id]" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("            GROUP BY" ).append("\n"); 
		query.append("            N.BKG_OFC_CD" ).append("\n"); 
		query.append("            , SUBSTR(B.POD_NOD_CD, 1,2)" ).append("\n"); 
		query.append("            ) A1" ).append("\n"); 
		query.append("        ,	(" ).append("\n"); 
		query.append("            SELECT" ).append("\n"); 
		query.append("              B.DBD_IRR_TP_CD" ).append("\n"); 
		query.append("            , SUBSTR(C.POD_CD, 1,2) DEST" ).append("\n"); 
		query.append("            , C.BKG_OFC_CD" ).append("\n"); 
		query.append("            , COUNT(B.BKG_NO) CNT" ).append("\n"); 
		query.append("            FROM BKG_DBD_BAT A" ).append("\n"); 
		query.append("            , BKG_DBD_RPT B" ).append("\n"); 
		query.append("            , BKG_DBD_BAT_CNDDT C" ).append("\n"); 
		query.append("            , BKG_BOOKING D" ).append("\n"); 
		query.append("            WHERE 1=1" ).append("\n"); 
		query.append("            AND A.BAT_STS_CD = 'S'" ).append("\n"); 
		query.append("            AND A.DBD_CRE_DT = C.DBD_CRE_DT" ).append("\n"); 
		query.append("            AND A.DBD_CRE_SEQ = C.DBD_CRE_SEQ" ).append("\n"); 
		query.append("            AND C.DBD_CRE_DT = B.DBD_CRE_DT(+)" ).append("\n"); 
		query.append("            AND C.DBD_CRE_SEQ = B.DBD_CRE_SEQ(+)" ).append("\n"); 
		query.append("            AND C.BKG_NO = B.BKG_NO(+)" ).append("\n"); 
		query.append("            AND C.BKG_NO = D.BKG_NO" ).append("\n"); 
		query.append("        #if (${s_kind} == 'rhq')" ).append("\n"); 
		query.append("            #if (${f_rhq_cd} != '')" ).append("\n"); 
		query.append("            AND C.BKG_OFC_CD IN (SELECT OFC_CD FROM MDM_ORGANIZATION CONNECT BY PRIOR OFC_CD = PRNT_OFC_CD START WITH OFC_CD = @[f_rhq_cd])" ).append("\n"); 
		query.append("            #end" ).append("\n"); 
		query.append("        #elseif (${s_kind} == 'ofc')" ).append("\n"); 
		query.append("            #if (${f_sub_bkg_ofc_cd} != '')" ).append("\n"); 
		query.append("            AND C.BKG_OFC_CD IN (${f_sub_bkg_ofc_list})" ).append("\n"); 
		query.append("            #elseif (${f_bkg_ofc_cd} != '')" ).append("\n"); 
		query.append("            AND C.BKG_OFC_CD = @[f_bkg_ofc_cd]" ).append("\n"); 
		query.append("            #end" ).append("\n"); 
		query.append("        #elseif (${s_kind} == 'bkgno')" ).append("\n"); 
		query.append("            #if (${f_bkg_no} != '')" ).append("\n"); 
		query.append("            AND C.BKG_NO = @[f_bkg_no]" ).append("\n"); 
		query.append("            #end" ).append("\n"); 
		query.append("        #elseif (${s_kind} == 'cust')" ).append("\n"); 
		query.append("            AND EXISTS (SELECT 'X' FROM BKG_CUSTOMER CU WHERE C.BKG_NO = CU.BKG_NO" ).append("\n"); 
		query.append("            #if (${combo_cust} != 'Z' && ${combo_cust} != '')" ).append("\n"); 
		query.append("                           AND CU.BKG_CUST_TP_CD = @[combo_cust]" ).append("\n"); 
		query.append("            #end" ).append("\n"); 
		query.append("            #if (${f_cust_cd} != '')" ).append("\n"); 
		query.append("                           AND (CU.CUST_CNT_CD,CU.CUST_SEQ) IN (( SUBSTR(@[f_cust_cd],1,2),SUBSTR(@[f_cust_cd],3) ))" ).append("\n"); 
		query.append("            #end       )" ).append("\n"); 
		query.append("        #elseif (${s_kind} == 'gcust')" ).append("\n"); 
		query.append("            AND EXISTS (SELECT 'X' FROM BKG_CUSTOMER CU, MDM_CUSTOMER M WHERE C.BKG_NO = CU.BKG_NO" ).append("\n"); 
		query.append("                           AND CU.CUST_CNT_CD = M.CUST_CNT_CD" ).append("\n"); 
		query.append("                           AND CU.CUST_SEQ = M.CUST_SEQ" ).append("\n"); 
		query.append("            #if (${combo_gcust} != 'Z' && ${combo_gcust} != '')" ).append("\n"); 
		query.append("                           AND CU.BKG_CUST_TP_CD = @[combo_gcust]" ).append("\n"); 
		query.append("            #end" ).append("\n"); 
		query.append("            #if (${f_gcust_cd} != '')" ).append("\n"); 
		query.append("                           AND M.CUST_GRP_ID = @[f_gcust_cd]" ).append("\n"); 
		query.append("            #end       )" ).append("\n"); 
		query.append("        #elseif (${s_kind} == 'ctrt')" ).append("\n"); 
		query.append("            #if (${combo_ctrt} == 'S')" ).append("\n"); 
		query.append("            AND D.SC_NO = @[f_ctrt_no]" ).append("\n"); 
		query.append("            #elseif (${combo_ctrt} == 'R')" ).append("\n"); 
		query.append("            AND D.RFA_NO = @[f_ctrt_no]" ).append("\n"); 
		query.append("            #elseif (${combo_ctrt} == 'T')" ).append("\n"); 
		query.append("            AND D.TAA_NO = @[f_ctrt_no]" ).append("\n"); 
		query.append("            #else" ).append("\n"); 
		query.append("            AND @[f_ctrt_no] IN (D.SC_NO, D.RFA_NO, D.TAA_NO)" ).append("\n"); 
		query.append("            #end" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("        #if (${f_pol_nod_cd} != '')" ).append("\n"); 
		query.append("            AND C.POL_CD LIKE @[f_pol_nod_cd]||'%'" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("        #if (${f_pod_nod_cd} != '')" ).append("\n"); 
		query.append("            AND C.POD_CD LIKE @[f_pod_nod_cd]||'%'" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("        #if (${f_vvd} != '')" ).append("\n"); 
		query.append("        AND EXISTS (SELECT 'X' FROM BKG_VVD V WHERE 1=1" ).append("\n"); 
		query.append("                       AND C.BKG_NO = V.BKG_NO" ).append("\n"); 
		query.append("                       AND (V.VSL_CD,V.SKD_VOY_NO,V.SKD_DIR_CD) IN ((SUBSTR(@[f_vvd],1,4),SUBSTR(@[f_vvd],5,4),SUBSTR(@[f_vvd],9,1)))" ).append("\n"); 
		query.append("                    )" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("        #if (${f_staff_id} != '')" ).append("\n"); 
		query.append("            AND D.DOC_USR_ID = @[f_staff_id]" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("        #if (${f_rep_id} != '')" ).append("\n"); 
		query.append("            AND D.OB_SREP_CD = @[f_rep_id]" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("            GROUP BY" ).append("\n"); 
		query.append("              DBD_IRR_TP_CD" ).append("\n"); 
		query.append("            , SUBSTR(C.POD_CD, 1,2)" ).append("\n"); 
		query.append("            , C.BKG_OFC_CD" ).append("\n"); 
		query.append("        ) A2" ).append("\n"); 
		query.append("        WHERE 1=1" ).append("\n"); 
		query.append("        AND A1.BKG_OFC_CD = A2.BKG_OFC_CD" ).append("\n"); 
		query.append("        AND A1.DEST = A2.DEST" ).append("\n"); 
		query.append("    ) C," ).append("\n"); 
		query.append("        (" ).append("\n"); 
		query.append("            SELECT " ).append("\n"); 
		query.append("              DBD_IRR_TP_CD" ).append("\n"); 
		query.append("            , BKG_DBD_SET_TP_CD" ).append("\n"); 
		query.append("            , BKG_OFC_CD" ).append("\n"); 
		query.append("            , LMT_STEP_NO" ).append("\n"); 
		query.append("            , FM_VAL" ).append("\n"); 
		query.append("            , TO_VAL" ).append("\n"); 
		query.append("            FROM" ).append("\n"); 
		query.append("                (" ).append("\n"); 
		query.append("                    SELECT" ).append("\n"); 
		query.append("                      ROW_NUMBER() OVER (PARTITION BY DBD_IRR_TP_CD, LMT_STEP_NO, BKG_OFC_CD  ORDER BY BKG_OFC_CD, DECODE(BKG_DBD_SET_TP_CD,'U', 1, 'D', 2, 3)) PROT" ).append("\n"); 
		query.append("                    , DBD_IRR_TP_CD" ).append("\n"); 
		query.append("                    , BKG_DBD_SET_TP_CD" ).append("\n"); 
		query.append("                    , BKG_OFC_CD" ).append("\n"); 
		query.append("                    , LMT_STEP_NO" ).append("\n"); 
		query.append("                    , FM_VAL" ).append("\n"); 
		query.append("                    , TO_VAL" ).append("\n"); 
		query.append("                    FROM BKG_DBD_SET S WHERE 1=1" ).append("\n"); 
		query.append("        #if (${s_kind} == 'ofc')" ).append("\n"); 
		query.append("            #if (${f_sub_bkg_ofc_cd} != '')" ).append("\n"); 
		query.append("                     AND S.BKG_OFC_CD IN (${f_sub_bkg_ofc_list})" ).append("\n"); 
		query.append("            #elseif (${f_bkg_ofc_cd} != '')" ).append("\n"); 
		query.append("                     AND S.BKG_OFC_CD = @[f_bkg_ofc_cd]" ).append("\n"); 
		query.append("            #end" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("                     AND (BKG_DBD_SET_TP_CD,CRE_USR_ID) IN (('U',@[f_usr_id]),('D','SYSTEM'))" ).append("\n"); 
		query.append("                ) B" ).append("\n"); 
		query.append("            WHERE PROT = 1" ).append("\n"); 
		query.append("        ) S" ).append("\n"); 
		query.append("        WHERE C.DBD_IRR_TP_CD = S.DBD_IRR_TP_CD(+)" ).append("\n"); 
		query.append("        AND C.BKG_OFC_CD = S.BKG_OFC_CD(+)" ).append("\n"); 
		query.append("        AND C.PCNT BETWEEN S.FM_VAL(+) AND S.TO_VAL(+)" ).append("\n"); 
		query.append("    ) V" ).append("\n"); 
		query.append("    WHERE PROT2=1" ).append("\n"); 
		query.append("    ) " ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("GROUP BY DEST, BKG_OFC_CD" ).append("\n"); 
		query.append("ORDER BY BKG_OFC_CD, DEST" ).append("\n"); 

	}
}