/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ActualCostCSRManageDBDAOSearchActualCostCSRListRSQL.java
*@FileTitle : Accrual Result by Booking
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.28
*@LastModifier : Jeon Jae Hong
*@LastVersion : 1.0
* 2009.08.28 Jeon Jae Hong
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.lea.logisticsexpenseaccrual.actualcostcsrmanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Jeon Jae Hong
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ActualCostCSRManageDBDAOSearchActualCostCSRListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Actual Cost  - CSR List 조회
	  * </pre>
	  */
	public ActualCostCSRManageDBDAOSearchActualCostCSRListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("frm_st_if_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("frm_inv_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("frm_src_ctnt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("frm_end_if_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("frm_lea_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("frm_if_flg",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.lea.logisticsexpenseaccrual.actualcostcsrmanage.integration").append("\n"); 
		query.append("FileName : ActualCostCSRManageDBDAOSearchActualCostCSRListRSQL").append("\n"); 
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
		query.append("SELECT	CSR_NO," ).append("\n"); 
		query.append("DECODE(SRC_CTNT, 'SO_TRANS', 'TRS', 'SO_TERMINAL', 'TES') SRC_CTNT," ).append("\n"); 
		query.append("NVL (IF_FLG, 'N') IF_FLG," ).append("\n"); 
		query.append("TO_CHAR (IF_DT, 'YYYY MM.DD  HH24:MI') IF_DT," ).append("\n"); 
		query.append("IF_ERR_RSN," ).append("\n"); 
		query.append("DECODE(IF_FLG, 'Y', DECODE(SUBSTR(ESTM_ERR_RSN, 1, 3), 'LEA', 'N', 'Y'), 'N') LEA_FLG," ).append("\n"); 
		query.append("CSR_CURR_CD," ).append("\n"); 
		query.append("TO_CHAR(CSR_AMT, '99999999999990.00') CSR_AMT," ).append("\n"); 
		query.append("ERR_CSR_NO," ).append("\n"); 
		query.append("SUBSTR(GL_DT, 1, 4)||'-'||SUBSTR(GL_DT, 5, 2)||'-'||SUBSTR(GL_DT, 7, 2) GL_DT," ).append("\n"); 
		query.append("CASE 	WHEN LENGTH(CSR_NO) = 20 THEN" ).append("\n"); 
		query.append("SUBSTR(CSR_NO, 4, 6)" ).append("\n"); 
		query.append("ELSE" ).append("\n"); 
		query.append("SUBSTR(CSR_NO, 4, 5)" ).append("\n"); 
		query.append("END INV_OFC_CD" ).append("\n"); 
		query.append("FROM	AP_INV_HDR" ).append("\n"); 
		query.append("WHERE	IF_DT BETWEEN TO_DATE(REPLACE(@[frm_st_if_dt],'-',''),'YYYYMMDD')" ).append("\n"); 
		query.append("AND	TO_DATE(REPLACE(@[frm_end_if_dt],'-',''),'YYYYMMDD') + 0.99999" ).append("\n"); 
		query.append("AND		SRC_CTNT IN ('SO_TRANS','SO_TERMINAL')" ).append("\n"); 
		query.append("AND		SRC_CTNT = DECODE(@[frm_src_ctnt], 	'ALL', SRC_CTNT," ).append("\n"); 
		query.append("'TRS', 'SO_TRANS'," ).append("\n"); 
		query.append("'TES', 'SO_TERMINAL')" ).append("\n"); 
		query.append("AND		NVL(IF_FLG, 'N') = DECODE(@[frm_if_flg], 'ALL', NVL(IF_FLG, 'N'), @[frm_if_flg])" ).append("\n"); 
		query.append("AND		DECODE(IF_FLG, 'Y', DECODE(SUBSTR(ESTM_ERR_RSN, 1, 3), 'LEA', 'N', 'Y'), 'N')" ).append("\n"); 
		query.append("= DECODE(@[frm_lea_flg], 'ALL', DECODE(IF_FLG, 'Y', DECODE(SUBSTR(ESTM_ERR_RSN, 1, 3), 'LEA', 'N', 'Y'), 'N'),@[frm_lea_flg])" ).append("\n"); 
		query.append("AND		CASE	WHEN LENGTH(CSR_NO) = 20 THEN" ).append("\n"); 
		query.append("SUBSTR(CSR_NO, 4, 6)" ).append("\n"); 
		query.append("ELSE" ).append("\n"); 
		query.append("SUBSTR(CSR_NO, 4, 5)" ).append("\n"); 
		query.append("END = @[frm_inv_ofc_cd]" ).append("\n"); 

	}
}