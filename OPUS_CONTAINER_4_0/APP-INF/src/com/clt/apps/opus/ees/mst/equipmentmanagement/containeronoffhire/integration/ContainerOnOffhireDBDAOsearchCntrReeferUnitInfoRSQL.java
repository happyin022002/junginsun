/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : ContainerOnOffhireDBDAOsearchCntrReeferUnitInfoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.11.16
*@LastModifier : 
*@LastVersion : 1.0
* 2015.11.16 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.mst.equipmentmanagement.containeronoffhire.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ContainerOnOffhireDBDAOsearchCntrReeferUnitInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * EXCEL UPLOAD된 DATA의 Validation Check Query
	  * </pre>
	  */
	public ContainerOnOffhireDBDAOsearchCntrReeferUnitInfoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rf_rfr_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rstr_usg_lbl_desc",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_tpsz_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rstr_usg_lbl_tp",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("min_temp",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("max_temp",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rf_mkr_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rf_cmpr_ctnt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rf_mdl_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rf_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rf_humid_ctrl_val_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("lstm_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.mst.equipmentmanagement.containeronoffhire.integration").append("\n"); 
		query.append("FileName : ContainerOnOffhireDBDAOsearchCntrReeferUnitInfoRSQL").append("\n"); 
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
		query.append("SELECT " ).append("\n"); 
		query.append("      A1.CNTR_NO" ).append("\n"); 
		query.append("     ,A.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("     ,A.LSTM_CD" ).append("\n"); 
		query.append("     ,TO_CHAR(A.ONH_DT, 'YYYY-MM-DD') ONH_DT" ).append("\n"); 
		query.append("     ,AGMT_CTY_CD||TO_CHAR(AGMT_SEQ,'000000') AS AGMT_NO" ).append("\n"); 
		query.append("	 ,MST_COMMON_PKG.MST_RU_LBL_GET_FNC(A.CNTR_NO) AS RSTR_USG_LBL_NM" ).append("\n"); 
		query.append("	 ,MST_COMMON_PKG.MST_RU_TP_GET_FNC(A.CNTR_NO) AS RSTR_USG_LBL_TP" ).append("\n"); 
		query.append("     ,MST_COMMON_PKG.MST_RU_VAL_GET_FNC(A.CNTR_NO) AS RSTR_USG_LBL_DESC" ).append("\n"); 
		query.append("     ,A.VNDR_SEQ" ).append("\n"); 
		query.append("     ,A1.RF_MKR_SEQ" ).append("\n"); 
		query.append("	 ,A1.RF_TP_CD" ).append("\n"); 
		query.append("	 ,A1.RF_HUMID_CTRL_VAL_CD" ).append("\n"); 
		query.append("	 ,A1.RF_CMPR_CTNT" ).append("\n"); 
		query.append("     ,CASE WHEN A1.RF_MKR_SEQ IS NOT NULL THEN" ).append("\n"); 
		query.append("        (SELECT NVL(B.VNDR_ABBR_NM,VNDR_LGL_ENG_NM) CODE_NM" ).append("\n"); 
		query.append("         FROM MDM_VENDOR B" ).append("\n"); 
		query.append("         WHERE B.VNDR_SEQ = A1.RF_MKR_SEQ" ).append("\n"); 
		query.append("           AND NVL(B.DELT_FLG, 'N') = 'N')" ).append("\n"); 
		query.append("      ELSE'' " ).append("\n"); 
		query.append("      END AS RF_MKR_NM     " ).append("\n"); 
		query.append("     ,A1.RF_MDL_NM" ).append("\n"); 
		query.append("     ,A1.RF_RFR_NO" ).append("\n"); 
		query.append("     ,A1.MIN_TEMP" ).append("\n"); 
		query.append("     ,A1.MAX_TEMP          " ).append("\n"); 
		query.append("     ,DECODE(A.LSTM_CD, 'ST', '' ,'LT', '', 'E') AS AEFLG " ).append("\n"); 
		query.append("     ,DECODE(SUBSTR(A.CNTR_TPSZ_CD,1,1), 'R', '' , 'E') AS BEFLG         " ).append("\n"); 
		query.append("     ,CASE WHEN A1.RF_MKR_SEQ IS NOT NULL THEN" ).append("\n"); 
		query.append("        DECODE((SELECT COUNT(1)" ).append("\n"); 
		query.append("                FROM MDM_CNTR_VNDR_CLSS A," ).append("\n"); 
		query.append("                     MDM_VENDOR B" ).append("\n"); 
		query.append("                WHERE A.CNTR_VNDR_SVC_CD ='MFR'" ).append("\n"); 
		query.append("                AND A.VNDR_SEQ = A1.RF_MKR_SEQ" ).append("\n"); 
		query.append("                AND A.VNDR_SEQ = B.VNDR_SEQ" ).append("\n"); 
		query.append("                AND NVL(A.DELT_FLG, 'N') = 'N'" ).append("\n"); 
		query.append("                AND NVL(B.DELT_FLG, 'N') = 'N'),0,'E','') " ).append("\n"); 
		query.append("     ELSE" ).append("\n"); 
		query.append("    	DECODE(A1.RF_MKR_SEQ,NULL,'','E') -- RF_MKR_SEQ가 null인경우는 처리한다.		 " ).append("\n"); 
		query.append("     END AS CEFLG    " ).append("\n"); 
		query.append("    ,'' AS DEFLG" ).append("\n"); 
		query.append("    ,'' AS EEFLG" ).append("\n"); 
		query.append("FROM MST_CONTAINER A," ).append("\n"); 
		query.append("    (SELECT  SUBSTR( CNTR_NO,INSTR(CNTR_NO, '|', 1, LEVEL) + 1,INSTR(CNTR_NO, '|', 1, LEVEL + 1) - INSTR(CNTR_NO, '|', 1, LEVEL) - 1) AS CNTR_NO," ).append("\n"); 
		query.append("             SUBSTR( LSTM_CD,INSTR(LSTM_CD, '|', 1, LEVEL) + 1 ,INSTR(LSTM_CD, '|', 1, LEVEL + 1) - INSTR(LSTM_CD, '|', 1, LEVEL) - 1) AS LSTM_CD ," ).append("\n"); 
		query.append("             SUBSTR( CNTR_TPSZ_CD,INSTR(CNTR_TPSZ_CD, '|', 1, LEVEL) + 1 ,INSTR(CNTR_TPSZ_CD, '|', 1, LEVEL + 1) - INSTR(CNTR_TPSZ_CD, '|', 1, LEVEL) - 1) AS CNTR_TPSZ_CD ," ).append("\n"); 
		query.append("             SUBSTR( RF_MKR_SEQ,INSTR(RF_MKR_SEQ, '|', 1, LEVEL) + 1 ,INSTR(RF_MKR_SEQ, '|', 1, LEVEL + 1) - INSTR(RF_MKR_SEQ, '|', 1, LEVEL) - 1) AS RF_MKR_SEQ ," ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("			 SUBSTR( RSTR_USG_LBL_TP,INSTR(RSTR_USG_LBL_TP, '|', 1, LEVEL) + 1 ,INSTR(RSTR_USG_LBL_TP, '|', 1, LEVEL + 1) - INSTR(RSTR_USG_LBL_TP, '|', 1, LEVEL) - 1) AS RSTR_USG_LBL_TP ," ).append("\n"); 
		query.append("			 SUBSTR( RSTR_USG_LBL_DESC,INSTR(RSTR_USG_LBL_DESC, '|', 1, LEVEL) + 1 ,INSTR(RSTR_USG_LBL_DESC, '|', 1, LEVEL + 1) - INSTR(RSTR_USG_LBL_DESC, '|', 1, LEVEL) - 1) AS RSTR_USG_LBL_DESC ," ).append("\n"); 
		query.append("			 SUBSTR( RF_TP_CD,INSTR(RF_TP_CD, '|', 1, LEVEL) + 1 ,INSTR(RF_TP_CD, '|', 1, LEVEL + 1) - INSTR(RF_TP_CD, '|', 1, LEVEL) - 1) AS RF_TP_CD ," ).append("\n"); 
		query.append("			 SUBSTR( RF_HUMID_CTRL_VAL_CD,INSTR(RF_HUMID_CTRL_VAL_CD, '|', 1, LEVEL) + 1 ,INSTR(RF_HUMID_CTRL_VAL_CD, '|', 1, LEVEL + 1) - INSTR(RF_HUMID_CTRL_VAL_CD, '|', 1, LEVEL) - 1) AS RF_HUMID_CTRL_VAL_CD ," ).append("\n"); 
		query.append("			 SUBSTR( RF_CMPR_CTNT,INSTR(RF_CMPR_CTNT, '|', 1, LEVEL) + 1 ,INSTR(RF_CMPR_CTNT, '|', 1, LEVEL + 1) - INSTR(RF_CMPR_CTNT, '|', 1, LEVEL) - 1) AS RF_CMPR_CTNT ," ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("             SUBSTR( RF_MDL_NM,INSTR(RF_MDL_NM, '|', 1, LEVEL) + 1 ,INSTR(RF_MDL_NM, '|', 1, LEVEL + 1) - INSTR(RF_MDL_NM, '|', 1, LEVEL) - 1) AS RF_MDL_NM ," ).append("\n"); 
		query.append("             SUBSTR( RF_RFR_NO,INSTR(RF_RFR_NO, '|', 1, LEVEL) + 1,INSTR(RF_RFR_NO, '|', 1, LEVEL + 1) - INSTR(RF_RFR_NO, '|', 1, LEVEL) - 1) AS RF_RFR_NO," ).append("\n"); 
		query.append("             SUBSTR( MIN_TEMP,INSTR(MIN_TEMP, '|', 1, LEVEL) + 1,INSTR(MIN_TEMP, '|', 1, LEVEL + 1) - INSTR(MIN_TEMP, '|', 1, LEVEL) - 1) AS MIN_TEMP," ).append("\n"); 
		query.append("             SUBSTR( MAX_TEMP,INSTR(MAX_TEMP, '|', 1, LEVEL) + 1,INSTR(MAX_TEMP, '|', 1, LEVEL + 1) - INSTR(MAX_TEMP, '|', 1, LEVEL) - 1) AS MAX_TEMP           " ).append("\n"); 
		query.append("    FROM (SELECT  @[cntr_no] AS CNTR_NO," ).append("\n"); 
		query.append("                  @[lstm_cd] AS LSTM_CD," ).append("\n"); 
		query.append("                  @[cntr_tpsz_cd] AS CNTR_TPSZ_CD," ).append("\n"); 
		query.append("                  @[rf_mkr_seq] AS RF_MKR_SEQ, " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("				  @[rstr_usg_lbl_tp] 		AS RSTR_USG_LBL_TP," ).append("\n"); 
		query.append("				  @[rstr_usg_lbl_desc]		AS RSTR_USG_LBL_DESC," ).append("\n"); 
		query.append("				  @[rf_tp_cd] 				AS RF_TP_CD," ).append("\n"); 
		query.append("				  @[rf_humid_ctrl_val_cd] 	AS RF_HUMID_CTRL_VAL_CD," ).append("\n"); 
		query.append("				  @[rf_cmpr_ctnt] 			AS RF_CMPR_CTNT," ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                  @[rf_mdl_nm] AS RF_MDL_NM, " ).append("\n"); 
		query.append("                  @[rf_rfr_no] AS RF_RFR_NO, " ).append("\n"); 
		query.append("                  @[min_temp] AS MIN_TEMP, " ).append("\n"); 
		query.append("                  @[max_temp] AS MAX_TEMP                " ).append("\n"); 
		query.append("            FROM dual)" ).append("\n"); 
		query.append("    CONNECT BY LEVEL <= LENGTH(CNTR_NO) - LENGTH(REPLACE(CNTR_NO, '|')) - 1" ).append("\n"); 
		query.append("    )A1" ).append("\n"); 
		query.append("WHERE 1 = 1" ).append("\n"); 
		query.append("  AND A.CNTR_NO(+) = A1.CNTR_NO" ).append("\n"); 
		query.append("  AND A.CNTR_NO IS NOT NULL" ).append("\n"); 

	}
}