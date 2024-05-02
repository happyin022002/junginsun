/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : DashboardDBDAOSearchDashboardByCustRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.12.03
*@LastModifier : 
*@LastVersion : 1.0
* 2013.12.03 
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

public class DashboardDBDAOSearchDashboardByCustRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Customer 기준으로 대시보드 리스트를 조회한다.
	  * </pre>
	  */
	public DashboardDBDAOSearchDashboardByCustRSQL(){
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
		params.put("combo_gcust",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("f_cust_cd",new String[]{arrTmp[0],arrTmp[1]});

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

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.bookingreport.dashboard.integration").append("\n"); 
		query.append("FileName : DashboardDBDAOSearchDashboardByCustRSQL").append("\n"); 
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
		query.append(", NVL(MIN(CNT_1),'0/0') CNT_VSL_SKD" ).append("\n"); 
		query.append(", NVL(MIN(LMT_1),0) LMT_VSL_SKD" ).append("\n"); 
		query.append(", NVL(MIN(CNT_2),'0/0') CNT_DWL_NTFC" ).append("\n"); 
		query.append(", NVL(MIN(LMT_2),0) LMT_DWL_NTFC" ).append("\n"); 
		query.append(", NVL(MIN(CNT_3),'0/0') CNT_PORT_SKIP" ).append("\n"); 
		query.append(", NVL(MIN(LMT_3),0) LMT_PORT_SKIP" ).append("\n"); 
		query.append(", NVL(MIN(CNT_4),'0/0') CNT_TPB" ).append("\n"); 
		query.append(", NVL(MIN(LMT_4),0) LMT_TPB" ).append("\n"); 
		query.append(", NVL(MIN(CNT_5),'0/0') CNT_NOT_UPD_CNTR" ).append("\n"); 
		query.append(", NVL(MIN(LMT_5),0) LMT_NOT_UPD_CNTR" ).append("\n"); 
		query.append(", NVL(MIN(CNT_6),'0/0') CNT_OBL_RLS" ).append("\n"); 
		query.append(", NVL(MIN(LMT_6),0) LMT_OBL_RLS" ).append("\n"); 
		query.append(", NVL(MIN(CNT_7),'0/0') CNT_WT_BKG" ).append("\n"); 
		query.append(", NVL(MIN(LMT_7),0) LMT_WT_BKG" ).append("\n"); 
		query.append(", NVL(MIN(CNT_8),'0/0') CNT_CUST_ADV_FX_SND" ).append("\n"); 
		query.append(", NVL(MIN(LMT_8),0) LMT_CUST_ADV_FX_SND" ).append("\n"); 
		query.append(", NVL(MIN(CNT_9),'0/0') CNT_CNTR_FNL_CFM" ).append("\n"); 
		query.append(", NVL(MIN(LMT_9),0) LMT_CNTR_FNL_CFM" ).append("\n"); 
		query.append(", NVL(MIN(CNT_10),'0/0') CNT_RATE" ).append("\n"); 
		query.append(", NVL(MIN(LMT_10),0) LMT_RATE" ).append("\n"); 
		query.append(", NVL(MIN(CNT_11),'0/0') CNT_RDN" ).append("\n"); 
		query.append(", NVL(MIN(LMT_11),0) LMT_RDN" ).append("\n"); 
		query.append(", NVL(MIN(CNT_12),'0/0') CNT_US_HLD" ).append("\n"); 
		query.append(", NVL(MIN(LMT_12),0) LMT_US_HLD" ).append("\n"); 
		query.append(", NVL(MIN(CNT_13),'0/0') CNT_EUR_HLD" ).append("\n"); 
		query.append(", NVL(MIN(LMT_13),0) LMT_EUR_HLD" ).append("\n"); 
		query.append(", NVL(MIN(CNT_14),'0/0') CNT_301_TML" ).append("\n"); 
		query.append(", NVL(MIN(LMT_14),0) LMT_301_TML" ).append("\n"); 
		query.append(", NVL(MIN(CNT_15),'0/0') CNT_BKR_HLD" ).append("\n"); 
		query.append(", NVL(MIN(LMT_15),0) LMT_BKR_HLD" ).append("\n"); 
		query.append(", NVL(MIN(CNT_16),'0/0') CNT_COD" ).append("\n"); 
		query.append(", NVL(MIN(LMT_16),0) LMT_COD" ).append("\n"); 
		query.append(", NVL(MIN(CNT_17),'0/0') CNT_NW_WB_BL_INSTR" ).append("\n"); 
		query.append(", NVL(MIN(LMT_17),0) LMT_NW_WB_BL_INSTR" ).append("\n"); 
		query.append(", NVL(MIN(CNT_18),'0/0') CNT_VSL_SKD_CHG" ).append("\n"); 
		query.append(", NVL(MIN(LMT_18),0) LMT_VSL_SKD_CHG" ).append("\n"); 
		query.append(", NVL(MIN(CNT_19),'0/0') CNT_VSL_SKD_DLY_NTC" ).append("\n"); 
		query.append(", NVL(MIN(LMT_19),0) LMT_VSL_SKD_DLY_NTC" ).append("\n"); 
		query.append(", NVL(MIN(CNT_20),'0/0') CNT_E_SI_RJT" ).append("\n"); 
		query.append(", NVL(MIN(LMT_20),0) LMT_E_SI_RJT" ).append("\n"); 
		query.append(", NVL(MIN(CNT_21),'0/0') CNT_BKG_RCP_NTC" ).append("\n"); 
		query.append(", NVL(MIN(LMT_21),0) LMT_BKG_RCP_NTC" ).append("\n"); 
		query.append(", NVL(MIN(CNT_22),'0/0') CNT_DEM_DET" ).append("\n"); 
		query.append(", NVL(MIN(LMT_22),0) LMT_DEM_DET" ).append("\n"); 
		query.append(", NVL(MIN(CNT_23),'0/0') CNT_OCN_DEL" ).append("\n"); 
		query.append(", NVL(MIN(LMT_23),0) LMT_OCN_DEL" ).append("\n"); 
		query.append(", NVL(MIN(CNT_24),'0/0') CNT_IRG_DEL" ).append("\n"); 
		query.append(", NVL(MIN(LMT_24),0) LMT_IRG_DEL" ).append("\n"); 
		query.append(", NVL(MIN(CNT_25),'0/0') CNT_ARR_NTC" ).append("\n"); 
		query.append(", NVL(MIN(LMT_25),0) LMT_ARR_NTC" ).append("\n"); 
		query.append(", NVL(MIN(CNT_26),'0/0') CNT_SPCL_CGO_APR" ).append("\n"); 
		query.append(", NVL(MIN(LMT_26),0) LMT_SPCL_CGO_APR" ).append("\n"); 
		query.append(", NVL(MIN(CNT_30),'0/0') CNT_PHSE_OUT" ).append("\n"); 
		query.append(", NVL(MIN(LMT_30),0) LMT_PHSE_OUT" ).append("\n"); 
		query.append(", NVL(MIN(CNT_31),'0/0') CNT_301_CUST" ).append("\n"); 
		query.append(", NVL(MIN(LMT_31),0) LMT_301_CUST" ).append("\n"); 
		query.append(", NVL(MIN(CNT_40),'0/0') CNT_VL_UNMTCH" ).append("\n"); 
		query.append(", NVL(MIN(LMT_40),0) LMT_VL_UNMTCH" ).append("\n"); 
		query.append(", NVL(MIN(CNT_41),'0/0') CNT_VD_UNMTCH" ).append("\n"); 
		query.append(", NVL(MIN(LMT_41),0) LMT_VD_UNMTCH" ).append("\n"); 
		query.append(", NVL(MIN(CNT_50),'0/0') CNT_310" ).append("\n"); 
		query.append(", NVL(MIN(LMT_50),0) LMT_310" ).append("\n"); 
		query.append(", NVL(MIN(CNT_51),'0/0') CNT_DRFT_BL" ).append("\n"); 
		query.append(", NVL(MIN(LMT_51),0) LMT_DRFT_BL" ).append("\n"); 
		query.append(", NVL(MIN(CNT_61),'0/0') CNT_LNK_CNSTR" ).append("\n"); 
		query.append(", NVL(MIN(LMT_61),0) LMT_LNK_CNSTR" ).append("\n"); 
		query.append(", NVL(MIN(CNT_62),'0/0') CNT_NOD_CNSTR" ).append("\n"); 
		query.append(", NVL(MIN(LMT_62),0) LMT_NOD_CNSTR" ).append("\n"); 
		query.append(", NVL(MIN(CNT_63),'0/0') CNT_ROUT_CNSTR" ).append("\n"); 
		query.append(", NVL(MIN(LMT_63),0) LMT_ROUT_CNSTR" ).append("\n"); 
		query.append(", NVL(MIN(CNT_64),'0/0') CNT_PRD_CNSTR" ).append("\n"); 
		query.append(", NVL(MIN(LMT_64),0) LMT_PRD_CNSTR" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("  C.DEST" ).append("\n"); 
		query.append(", BKG_OFC_CD  " ).append("\n"); 
		query.append(", DECODE(C.DBD_IRR_TP_CD,1,C.TOT_CNT) CNT_1" ).append("\n"); 
		query.append(", DECODE(C.DBD_IRR_TP_CD,1,S.LMT_STEP_NO) LMT_1" ).append("\n"); 
		query.append(", DECODE(C.DBD_IRR_TP_CD,2,C.TOT_CNT) CNT_2" ).append("\n"); 
		query.append(", DECODE(C.DBD_IRR_TP_CD,2,S.LMT_STEP_NO) LMT_2" ).append("\n"); 
		query.append(", DECODE(C.DBD_IRR_TP_CD,3,C.TOT_CNT) CNT_3" ).append("\n"); 
		query.append(", DECODE(C.DBD_IRR_TP_CD,3,S.LMT_STEP_NO) LMT_3" ).append("\n"); 
		query.append(", DECODE(C.DBD_IRR_TP_CD,4,C.TOT_CNT) CNT_4" ).append("\n"); 
		query.append(", DECODE(C.DBD_IRR_TP_CD,4,S.LMT_STEP_NO) LMT_4" ).append("\n"); 
		query.append(", DECODE(C.DBD_IRR_TP_CD,5,C.TOT_CNT) CNT_5" ).append("\n"); 
		query.append(", DECODE(C.DBD_IRR_TP_CD,5,S.LMT_STEP_NO) LMT_5" ).append("\n"); 
		query.append(", DECODE(C.DBD_IRR_TP_CD,6,C.TOT_CNT) CNT_6" ).append("\n"); 
		query.append(", DECODE(C.DBD_IRR_TP_CD,6,S.LMT_STEP_NO) LMT_6" ).append("\n"); 
		query.append(", DECODE(C.DBD_IRR_TP_CD,7,C.TOT_CNT) CNT_7" ).append("\n"); 
		query.append(", DECODE(C.DBD_IRR_TP_CD,7,S.LMT_STEP_NO) LMT_7" ).append("\n"); 
		query.append(", DECODE(C.DBD_IRR_TP_CD,8,C.TOT_CNT) CNT_8" ).append("\n"); 
		query.append(", DECODE(C.DBD_IRR_TP_CD,8,S.LMT_STEP_NO) LMT_8" ).append("\n"); 
		query.append(", DECODE(C.DBD_IRR_TP_CD,9,C.TOT_CNT) CNT_9" ).append("\n"); 
		query.append(", DECODE(C.DBD_IRR_TP_CD,9,S.LMT_STEP_NO) LMT_9" ).append("\n"); 
		query.append(", DECODE(C.DBD_IRR_TP_CD,10,C.TOT_CNT) CNT_10" ).append("\n"); 
		query.append(", DECODE(C.DBD_IRR_TP_CD,10,S.LMT_STEP_NO) LMT_10" ).append("\n"); 
		query.append(", DECODE(C.DBD_IRR_TP_CD,11,C.TOT_CNT) CNT_11" ).append("\n"); 
		query.append(", DECODE(C.DBD_IRR_TP_CD,11,S.LMT_STEP_NO) LMT_11" ).append("\n"); 
		query.append(", DECODE(C.DBD_IRR_TP_CD,12,C.TOT_CNT) CNT_12" ).append("\n"); 
		query.append(", DECODE(C.DBD_IRR_TP_CD,12,S.LMT_STEP_NO) LMT_12" ).append("\n"); 
		query.append(", DECODE(C.DBD_IRR_TP_CD,13,C.TOT_CNT) CNT_13" ).append("\n"); 
		query.append(", DECODE(C.DBD_IRR_TP_CD,13,S.LMT_STEP_NO) LMT_13" ).append("\n"); 
		query.append(", DECODE(C.DBD_IRR_TP_CD,14,C.TOT_CNT) CNT_14" ).append("\n"); 
		query.append(", DECODE(C.DBD_IRR_TP_CD,14,S.LMT_STEP_NO) LMT_14" ).append("\n"); 
		query.append(", DECODE(C.DBD_IRR_TP_CD,15,C.TOT_CNT) CNT_15" ).append("\n"); 
		query.append(", DECODE(C.DBD_IRR_TP_CD,15,S.LMT_STEP_NO) LMT_15" ).append("\n"); 
		query.append(", DECODE(C.DBD_IRR_TP_CD,16,C.TOT_CNT) CNT_16" ).append("\n"); 
		query.append(", DECODE(C.DBD_IRR_TP_CD,16,S.LMT_STEP_NO) LMT_16" ).append("\n"); 
		query.append(", DECODE(C.DBD_IRR_TP_CD,17,C.TOT_CNT) CNT_17" ).append("\n"); 
		query.append(", DECODE(C.DBD_IRR_TP_CD,17,S.LMT_STEP_NO) LMT_17" ).append("\n"); 
		query.append(", DECODE(C.DBD_IRR_TP_CD,18,C.TOT_CNT) CNT_18" ).append("\n"); 
		query.append(", DECODE(C.DBD_IRR_TP_CD,18,S.LMT_STEP_NO) LMT_18" ).append("\n"); 
		query.append(", DECODE(C.DBD_IRR_TP_CD,19,C.TOT_CNT) CNT_19" ).append("\n"); 
		query.append(", DECODE(C.DBD_IRR_TP_CD,19,S.LMT_STEP_NO) LMT_19" ).append("\n"); 
		query.append(", DECODE(C.DBD_IRR_TP_CD,20,C.TOT_CNT) CNT_20" ).append("\n"); 
		query.append(", DECODE(C.DBD_IRR_TP_CD,20,S.LMT_STEP_NO) LMT_20" ).append("\n"); 
		query.append(", DECODE(C.DBD_IRR_TP_CD,21,C.TOT_CNT) CNT_21" ).append("\n"); 
		query.append(", DECODE(C.DBD_IRR_TP_CD,21,S.LMT_STEP_NO) LMT_21" ).append("\n"); 
		query.append(", DECODE(C.DBD_IRR_TP_CD,22,C.TOT_CNT) CNT_22" ).append("\n"); 
		query.append(", DECODE(C.DBD_IRR_TP_CD,22,S.LMT_STEP_NO) LMT_22" ).append("\n"); 
		query.append(", DECODE(C.DBD_IRR_TP_CD,23,C.TOT_CNT) CNT_23" ).append("\n"); 
		query.append(", DECODE(C.DBD_IRR_TP_CD,23,S.LMT_STEP_NO) LMT_23" ).append("\n"); 
		query.append(", DECODE(C.DBD_IRR_TP_CD,24,C.TOT_CNT) CNT_24" ).append("\n"); 
		query.append(", DECODE(C.DBD_IRR_TP_CD,24,S.LMT_STEP_NO) LMT_24" ).append("\n"); 
		query.append(", DECODE(C.DBD_IRR_TP_CD,25,C.TOT_CNT) CNT_25" ).append("\n"); 
		query.append(", DECODE(C.DBD_IRR_TP_CD,25,S.LMT_STEP_NO) LMT_25" ).append("\n"); 
		query.append(", DECODE(C.DBD_IRR_TP_CD,26,C.TOT_CNT) CNT_26" ).append("\n"); 
		query.append(", DECODE(C.DBD_IRR_TP_CD,26,S.LMT_STEP_NO) LMT_26" ).append("\n"); 
		query.append(", DECODE(C.DBD_IRR_TP_CD,30,C.TOT_CNT) CNT_30" ).append("\n"); 
		query.append(", DECODE(C.DBD_IRR_TP_CD,30,S.LMT_STEP_NO) LMT_30" ).append("\n"); 
		query.append(", DECODE(C.DBD_IRR_TP_CD,31,C.TOT_CNT) CNT_31" ).append("\n"); 
		query.append(", DECODE(C.DBD_IRR_TP_CD,31,S.LMT_STEP_NO) LMT_31" ).append("\n"); 
		query.append(", DECODE(C.DBD_IRR_TP_CD,40,C.TOT_CNT) CNT_40" ).append("\n"); 
		query.append(", DECODE(C.DBD_IRR_TP_CD,40,S.LMT_STEP_NO) LMT_40" ).append("\n"); 
		query.append(", DECODE(C.DBD_IRR_TP_CD,41,C.TOT_CNT) CNT_41" ).append("\n"); 
		query.append(", DECODE(C.DBD_IRR_TP_CD,41,S.LMT_STEP_NO) LMT_41" ).append("\n"); 
		query.append(", DECODE(C.DBD_IRR_TP_CD,50,C.TOT_CNT) CNT_50" ).append("\n"); 
		query.append(", DECODE(C.DBD_IRR_TP_CD,50,S.LMT_STEP_NO) LMT_50" ).append("\n"); 
		query.append(", DECODE(C.DBD_IRR_TP_CD,51,C.TOT_CNT) CNT_51" ).append("\n"); 
		query.append(", DECODE(C.DBD_IRR_TP_CD,51,S.LMT_STEP_NO) LMT_51" ).append("\n"); 
		query.append(", DECODE(C.DBD_IRR_TP_CD,61,C.TOT_CNT) CNT_61" ).append("\n"); 
		query.append(", DECODE(C.DBD_IRR_TP_CD,61,S.LMT_STEP_NO) LMT_61" ).append("\n"); 
		query.append(", DECODE(C.DBD_IRR_TP_CD,62,C.TOT_CNT) CNT_62" ).append("\n"); 
		query.append(", DECODE(C.DBD_IRR_TP_CD,62,S.LMT_STEP_NO) LMT_62" ).append("\n"); 
		query.append(", DECODE(C.DBD_IRR_TP_CD,63,C.TOT_CNT) CNT_63" ).append("\n"); 
		query.append(", DECODE(C.DBD_IRR_TP_CD,63,S.LMT_STEP_NO) LMT_63" ).append("\n"); 
		query.append(", DECODE(C.DBD_IRR_TP_CD,64,C.TOT_CNT) CNT_64" ).append("\n"); 
		query.append(", DECODE(C.DBD_IRR_TP_CD,64,S.LMT_STEP_NO) LMT_64" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("    SELECT" ).append("\n"); 
		query.append("      A2.DBD_IRR_TP_CD" ).append("\n"); 
		query.append("    , A2.BKG_OFC_CD" ).append("\n"); 
		query.append("    , A2.DEST" ).append("\n"); 
		query.append("    , A2.CNT" ).append("\n"); 
		query.append("    , A2.CNT||'/'||A1.CNT TOT_CNT" ).append("\n"); 
		query.append("    FROM" ).append("\n"); 
		query.append("        (" ).append("\n"); 
		query.append("        SELECT" ).append("\n"); 
		query.append("          N.BKG_OFC_CD" ).append("\n"); 
		query.append("        , SUBSTR(B.POD_NOD_CD, 1,2) DEST" ).append("\n"); 
		query.append("        , COUNT(N.BKG_NO) CNT" ).append("\n"); 
		query.append("        FROM BKG_DBD_BAT A" ).append("\n"); 
		query.append("        , BKG_DBD_BAT_CNDDT N" ).append("\n"); 
		query.append("        , BKG_BOOKING B" ).append("\n"); 
		query.append("        WHERE 1=1" ).append("\n"); 
		query.append("        AND A.BAT_STS_CD = 'S'" ).append("\n"); 
		query.append("        AND A.DBD_CRE_DT = N.DBD_CRE_DT" ).append("\n"); 
		query.append("        AND A.DBD_CRE_SEQ = N.DBD_CRE_SEQ" ).append("\n"); 
		query.append("        AND N.BKG_NO = B.BKG_NO" ).append("\n"); 
		query.append("#if (${c_kind} == 'cust')" ).append("\n"); 
		query.append("	AND EXISTS (SELECT 'X' FROM BKG_CUSTOMER CU WHERE B.BKG_NO = CU.BKG_NO" ).append("\n"); 
		query.append("	#if (${combo_cust} != 'Z' && ${combo_cust} != '')" ).append("\n"); 
		query.append("                   AND CU.BKG_CUST_TP_CD = @[combo_cust]" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("	#if (${f_cust_cd} != '')" ).append("\n"); 
		query.append("                   AND (CU.CUST_CNT_CD,CU.CUST_SEQ) IN (( SUBSTR(@[f_cust_cd],1,2),SUBSTR(@[f_cust_cd],3) ))" ).append("\n"); 
		query.append("	#end       )" ).append("\n"); 
		query.append("#elseif (${c_kind} == 'gcust')" ).append("\n"); 
		query.append("	AND EXISTS (SELECT 'X' FROM BKG_CUSTOMER CU, MDM_CUSTOMER M WHERE B.BKG_NO = CU.BKG_NO" ).append("\n"); 
		query.append("                   AND CU.CUST_CNT_CD = M.CUST_CNT_CD" ).append("\n"); 
		query.append("                   AND CU.CUST_SEQ = M.CUST_SEQ" ).append("\n"); 
		query.append("	#if (${combo_gcust} != 'Z' && ${combo_gcust} != '')" ).append("\n"); 
		query.append("                   AND CU.BKG_CUST_TP_CD = @[combo_gcust]" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("	#if (${f_gcust_cd} != '')" ).append("\n"); 
		query.append("                   AND M.CUST_GRP_ID = @[f_gcust_cd]" ).append("\n"); 
		query.append("	#end       )" ).append("\n"); 
		query.append("#elseif (${c_kind} == 'ctrt')" ).append("\n"); 
		query.append("	#if (${combo_ctrt} == 'S')" ).append("\n"); 
		query.append("	AND C.SC_NO = @[f_ctrt_no]" ).append("\n"); 
		query.append("	#elseif (${combo_ctrt} == 'R')" ).append("\n"); 
		query.append("    AND C.RFA_NO = @[f_ctrt_no]" ).append("\n"); 
		query.append("	#elseif (${combo_ctrt} == 'T')" ).append("\n"); 
		query.append("    AND C.TAA_NO = @[f_ctrt_no]" ).append("\n"); 
		query.append("	#else" ).append("\n"); 
		query.append("    AND @[f_ctrt_no] IN (C.SC_NO, C.RFA_NO, C.TAA_NO)" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("#elseif (${c_kind} == 'bkgno')" ).append("\n"); 
		query.append("	#if (${f_bkg_no} != '')" ).append("\n"); 
		query.append("	AND C.BKG_NO = @[f_bkg_no]" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${f_pol_nod_cd} != '')" ).append("\n"); 
		query.append("	AND C.POL_NOD_CD LIKE @[f_pol_nod_cd]||'%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${f_pod_nod_cd} != '')" ).append("\n"); 
		query.append("	AND C.POD_NOD_CD LIKE @[f_pod_nod_cd]||'%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${f_vvd} != '')" ).append("\n"); 
		query.append("AND EXISTS (SELECT 'X' FROM BKG_VVD V WHERE 1=1" ).append("\n"); 
		query.append("               AND B.BKG_NO = V.BKG_NO" ).append("\n"); 
		query.append("               AND (V.VSL_CD,V.SKD_VOY_NO,V.SKD_DIR_CD) IN ((SUBSTR(@[f_vvd],1,4),SUBSTR(@[f_vvd],5,4),SUBSTR(@[f_vvd],9,1)))" ).append("\n"); 
		query.append("            )" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("        GROUP BY" ).append("\n"); 
		query.append("        N.BKG_OFC_CD" ).append("\n"); 
		query.append("        , SUBSTR(B.POD_NOD_CD, 1,2)" ).append("\n"); 
		query.append("        ) A1" ).append("\n"); 
		query.append("    ,	(" ).append("\n"); 
		query.append("        SELECT" ).append("\n"); 
		query.append("          B.DBD_IRR_TP_CD" ).append("\n"); 
		query.append("        , SUBSTR(C.POD_NOD_CD, 1,2) DEST" ).append("\n"); 
		query.append("        , B.BKG_OFC_CD" ).append("\n"); 
		query.append("        , COUNT(B.BKG_NO) CNT" ).append("\n"); 
		query.append("        FROM BKG_DBD_BAT A" ).append("\n"); 
		query.append("        , BKG_DBD_RPT B" ).append("\n"); 
		query.append("        , BKG_BOOKING C" ).append("\n"); 
		query.append("        WHERE 1=1" ).append("\n"); 
		query.append("        AND A.BAT_STS_CD = 'S'" ).append("\n"); 
		query.append("        AND A.DBD_CRE_DT = B.DBD_CRE_DT" ).append("\n"); 
		query.append("        AND A.DBD_CRE_SEQ = B.DBD_CRE_SEQ" ).append("\n"); 
		query.append("        AND B.BKG_NO = C.BKG_NO" ).append("\n"); 
		query.append("#if (${c_kind} == 'cust')" ).append("\n"); 
		query.append("	AND EXISTS (SELECT 'X' FROM BKG_CUSTOMER CU WHERE B.BKG_NO = CU.BKG_NO" ).append("\n"); 
		query.append("	#if (${combo_cust} != 'Z' && ${combo_cust} != '')" ).append("\n"); 
		query.append("                   AND CU.BKG_CUST_TP_CD = @[combo_cust]" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("	#if (${f_cust_cd} != '')" ).append("\n"); 
		query.append("                   AND (CU.CUST_CNT_CD,CU.CUST_SEQ) IN (( SUBSTR(@[f_cust_cd],1,2),SUBSTR(@[f_cust_cd],3) ))" ).append("\n"); 
		query.append("	#end       )" ).append("\n"); 
		query.append("#elseif (${c_kind} == 'gcust')" ).append("\n"); 
		query.append("	AND EXISTS (SELECT 'X' FROM BKG_CUSTOMER CU, MDM_CUSTOMER M WHERE B.BKG_NO = CU.BKG_NO" ).append("\n"); 
		query.append("                   AND CU.CUST_CNT_CD = M.CUST_CNT_CD" ).append("\n"); 
		query.append("                   AND CU.CUST_SEQ = M.CUST_SEQ" ).append("\n"); 
		query.append("	#if (${combo_gcust} != 'Z' && ${combo_gcust} != '')" ).append("\n"); 
		query.append("                   AND CU.BKG_CUST_TP_CD = @[combo_gcust]" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("	#if (${f_gcust_cd} != '')" ).append("\n"); 
		query.append("                   AND M.CUST_GRP_ID = @[f_gcust_cd]" ).append("\n"); 
		query.append("	#end       )" ).append("\n"); 
		query.append("#elseif (${c_kind} == 'ctrt')" ).append("\n"); 
		query.append("	#if (${combo_ctrt} == 'S')" ).append("\n"); 
		query.append("	AND C.SC_NO = @[f_ctrt_no]" ).append("\n"); 
		query.append("	#elseif (${combo_ctrt} == 'R')" ).append("\n"); 
		query.append("    AND C.RFA_NO = @[f_ctrt_no]" ).append("\n"); 
		query.append("	#elseif (${combo_ctrt} == 'T')" ).append("\n"); 
		query.append("    AND C.TAA_NO = @[f_ctrt_no]" ).append("\n"); 
		query.append("	#else" ).append("\n"); 
		query.append("    AND @[f_ctrt_no] IN (C.SC_NO, C.RFA_NO, C.TAA_NO)" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("#elseif (${c_kind} == 'bkgno')" ).append("\n"); 
		query.append("	#if (${f_bkg_no} != '')" ).append("\n"); 
		query.append("	AND C.BKG_NO = @[f_bkg_no]" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${f_pol_nod_cd} != '')" ).append("\n"); 
		query.append("	AND C.POL_NOD_CD LIKE @[f_pol_nod_cd]||'%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${f_pod_nod_cd} != '')" ).append("\n"); 
		query.append("	AND C.POD_NOD_CD LIKE @[f_pod_nod_cd]||'%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${f_vvd} != '')" ).append("\n"); 
		query.append("AND EXISTS (SELECT 'X' FROM BKG_VVD V WHERE 1=1" ).append("\n"); 
		query.append("               AND B.BKG_NO = V.BKG_NO" ).append("\n"); 
		query.append("               AND (V.VSL_CD,V.SKD_VOY_NO,V.SKD_DIR_CD) IN ((SUBSTR(@[f_vvd],1,4),SUBSTR(@[f_vvd],5,4),SUBSTR(@[f_vvd],9,1)))" ).append("\n"); 
		query.append("            )" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("        GROUP BY" ).append("\n"); 
		query.append("          DBD_IRR_TP_CD" ).append("\n"); 
		query.append("        , SUBSTR(POD_NOD_CD, 1,2)" ).append("\n"); 
		query.append("        , B.BKG_OFC_CD" ).append("\n"); 
		query.append("    ) A2" ).append("\n"); 
		query.append("    WHERE 1=1" ).append("\n"); 
		query.append("    AND A1.BKG_OFC_CD = A2.BKG_OFC_CD" ).append("\n"); 
		query.append("    AND A1.DEST = A2.DEST" ).append("\n"); 
		query.append(") C," ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("    SELECT B.* FROM" ).append("\n"); 
		query.append("    (" ).append("\n"); 
		query.append("        SELECT" ).append("\n"); 
		query.append("          ROW_NUMBER() OVER (PARTITION BY DBD_IRR_TP_CD, LMT_STEP_NO ORDER BY DECODE(BKG_DBD_SET_TP_CD,'U', 1, 'D', 2, 3)) PROT" ).append("\n"); 
		query.append("        , DBD_IRR_TP_CD" ).append("\n"); 
		query.append("        , BKG_DBD_SET_TP_CD" ).append("\n"); 
		query.append("        , LMT_STEP_NO" ).append("\n"); 
		query.append("        , FM_VAL" ).append("\n"); 
		query.append("        , TO_VAL" ).append("\n"); 
		query.append("        FROM BKG_DBD_SET" ).append("\n"); 
		query.append("        WHERE 1=1" ).append("\n"); 
		query.append("        AND (BKG_DBD_SET_TP_CD='U' AND (CRE_USR_ID = @[f_usr_id]))" ).append("\n"); 
		query.append("         OR BKG_DBD_SET_TP_CD = 'D'" ).append("\n"); 
		query.append("    ) B" ).append("\n"); 
		query.append("    WHERE PROT = 1" ).append("\n"); 
		query.append(") S" ).append("\n"); 
		query.append("WHERE C.DBD_IRR_TP_CD = S.DBD_IRR_TP_CD" ).append("\n"); 
		query.append("AND C.CNT BETWEEN S.FM_VAL AND S.TO_VAL" ).append("\n"); 
		query.append("ORDER BY   C.DEST, C.BKG_OFC_CD, TO_NUMBER(C.DBD_IRR_TP_CD)" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("GROUP BY DEST, BKG_OFC_CD" ).append("\n"); 
		query.append("ORDER BY DEST" ).append("\n"); 

	}
}