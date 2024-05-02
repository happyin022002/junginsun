/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : ActualCostCSRManageDBDAOSearchActualCostCSRListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.08.20
*@LastModifier : 
*@LastVersion : 1.0
* 2015.08.20 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.lea.logisticsexpenseaccrual.actualcostcsrmanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
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
		params.put("page_no",new String[]{arrTmp[0],arrTmp[1]});

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

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pagerows",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.lea.logisticsexpenseaccrual.actualcostcsrmanage.integration").append("\n"); 
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
		query.append("SELECT" ).append("\n"); 
		query.append("*" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("SELECT	A.CSR_NO," ).append("\n"); 
		query.append("		DECODE(A.SRC_CTNT, 'SO_TRANS', 'TRS', 'SO_TERMINAL', 'TES') SRC_CTNT," ).append("\n"); 
		query.append("        A.INV_DT," ).append("\n"); 
		query.append("		NVL (A.IF_FLG, 'N') IF_FLG," ).append("\n"); 
		query.append("		TO_CHAR (A.IF_DT, 'YYYY MM.DD  HH24:MI') IF_DT," ).append("\n"); 
		query.append("		A.IF_ERR_RSN," ).append("\n"); 
		query.append("		DECODE(A.IF_FLG, 'Y', DECODE(SUBSTR(ESTM_ERR_RSN, 1, 3), 'LEA', 'N', 'Y'), 'N') LEA_FLG," ).append("\n"); 
		query.append("		A.CSR_CURR_CD," ).append("\n"); 
		query.append("		TO_CHAR(A.CSR_AMT, '99999999999990.00') CSR_AMT," ).append("\n"); 
		query.append("		A.ERR_CSR_NO," ).append("\n"); 
		query.append("		SUBSTR(A.GL_DT, 1, 4)||'-'||SUBSTR(A.GL_DT, 5, 2)||'-'||SUBSTR(A.GL_DT, 7, 2) GL_DT," ).append("\n"); 
		query.append("		COUNT(*) OVER() TOTAL_CNT," ).append("\n"); 
		query.append("        ROW_NUMBER() OVER(ORDER BY A.CSR_NO) RNUM," ).append("\n"); 
		query.append("		CASE  WHEN A.SRC_CTNT = 'TES' THEN" ).append("\n"); 
		query.append("					(SELECT TE.INV_OFC_CD FROM TES_TML_SO_HDR TE WHERE TE.CSR_NO = A.CSR_NO AND ROWNUM = 1)" ).append("\n"); 
		query.append("        	  WHEN A.SRC_CTNT = 'TRS' THEN                                      							" ).append("\n"); 
		query.append("			   	NVL((SELECT COST_OFC_CD FROM TRS_TRSP_INV_WRK TW WHERE TW.CSR_NO = A.CSR_NO AND ROWNUM = 1), " ).append("\n"); 
		query.append("                    (SELECT COST_OFC_CD FROM TRS_TRSP_RAIL_INV_WRK TRW WHERE TRW.CSR_NO = A.CSR_NO AND ROWNUM = 1 ))" ).append("\n"); 
		query.append("        	  ELSE  " ).append("\n"); 
		query.append("                  A.TJ_OFC_CD " ).append("\n"); 
		query.append("		END INV_OFC_CD" ).append("\n"); 
		query.append("FROM   AP_INV_HDR A" ).append("\n"); 
		query.append("WHERE  A.IF_DT BETWEEN TO_DATE(REPLACE(@[frm_st_if_dt],'-',''),'YYYYMMDD')" ).append("\n"); 
		query.append("		 		 AND TO_DATE(REPLACE(@[frm_end_if_dt],'-',''),'YYYYMMDD') + 0.99999" ).append("\n"); 
		query.append("AND	   A.SRC_CTNT IN ('SO_TRANS','SO_TERMINAL')" ).append("\n"); 
		query.append("AND	   A.SRC_CTNT = DECODE(@[frm_src_ctnt], 	'ALL', A.SRC_CTNT," ).append("\n"); 
		query.append("											'TRS', 'SO_TRANS'," ).append("\n"); 
		query.append("											'TES', 'SO_TERMINAL')" ).append("\n"); 
		query.append("AND	   NVL(A.IF_FLG, 'N') = DECODE(@[frm_if_flg], 'ALL', NVL(A.IF_FLG, 'N'), @[frm_if_flg])" ).append("\n"); 
		query.append("AND	   DECODE(A.IF_FLG, 'Y', DECODE(SUBSTR(A.ESTM_ERR_RSN, 1, 3), 'LEA', 'N', 'Y'), 'N')" ).append("\n"); 
		query.append("			= DECODE(@[frm_lea_flg], 'ALL', DECODE(A.IF_FLG, 'Y', DECODE(SUBSTR(A.ESTM_ERR_RSN, 1, 3), 'LEA', 'N', 'Y'), 'N'),@[frm_lea_flg])" ).append("\n"); 
		query.append("#if(${frm_inv_ofc_cd} != '')" ).append("\n"); 
		query.append("AND	 CASE  WHEN A.SRC_CTNT = 'TES' THEN" ).append("\n"); 
		query.append("					(SELECT TE.INV_OFC_CD FROM TES_TML_SO_HDR TE WHERE TE.CSR_NO = A.CSR_NO AND ROWNUM = 1)" ).append("\n"); 
		query.append("           WHEN A.SRC_CTNT = 'TRS' THEN                                      							" ).append("\n"); 
		query.append("			   	NVL((SELECT COST_OFC_CD FROM TRS_TRSP_INV_WRK TW WHERE TW.CSR_NO = A.CSR_NO AND ROWNUM = 1), " ).append("\n"); 
		query.append("                    (SELECT COST_OFC_CD FROM TRS_TRSP_RAIL_INV_WRK TRW WHERE TRW.CSR_NO = A.CSR_NO AND ROWNUM = 1 ))" ).append("\n"); 
		query.append("           ELSE  " ).append("\n"); 
		query.append("                  A.TJ_OFC_CD " ).append("\n"); 
		query.append("		END = @[frm_inv_ofc_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND RNUM BETWEEN (@[page_no]-1)*@[pagerows]+1 AND @[page_no]*@[pagerows]" ).append("\n"); 

	}
}