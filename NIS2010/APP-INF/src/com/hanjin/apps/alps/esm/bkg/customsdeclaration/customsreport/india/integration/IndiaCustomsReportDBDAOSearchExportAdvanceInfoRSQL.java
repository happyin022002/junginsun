/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : IndiaCustomsReportDBDAOSearchExportAdvanceInfoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.01.18
*@LastModifier : 
*@LastVersion : 1.0
* 2017.01.18 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.customsreport.india.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class IndiaCustomsReportDBDAOSearchExportAdvanceInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchExportAdvanceInfo를 조회하기 위해 생성
	  * </pre>
	  */
	public IndiaCustomsReportDBDAOSearchExportAdvanceInfoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("to_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pol",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("from_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("terminal_val",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("export_vvd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.customsdeclaration.customsreport.india.integration").append("\n"); 
		query.append("FileName : IndiaCustomsReportDBDAOSearchExportAdvanceInfoRSQL").append("\n"); 
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
		query.append("SELECT 'CTR' CTR, " ).append("\n"); 
		query.append("       '' BAY_LOC, " ).append("\n"); 
		query.append("       BC.CNTR_NO, " ).append("\n"); 
		query.append("       BC.MEAS_QTY, " ).append("\n"); 
		query.append("       (SELECT CNTR_TPSZ_ISO_CD " ).append("\n"); 
		query.append("        FROM MDM_CNTR_TP_SZ" ).append("\n"); 
		query.append("        WHERE BC.CNTR_TPSZ_CD = CNTR_TPSZ_CD) ISO_CD, " ).append("\n"); 
		query.append("       DECODE(BB.BKG_CGO_TP_CD, 'F', 'F', 'E') STS, " ).append("\n"); 
		query.append("       (SELECT DISTINCT IMDG_CLSS_CD " ).append("\n"); 
		query.append("        FROM BKG_DG_CGO BDC" ).append("\n"); 
		query.append("        WHERE BC.BKG_NO = BDC.BKG_NO " ).append("\n"); 
		query.append("        AND BC.CNTR_NO = BDC.CNTR_NO " ).append("\n"); 
		query.append("        AND ROWNUM = 1) IMO," ).append("\n"); 
		query.append("       'NSA' POL, " ).append("\n"); 
		query.append("       SUBSTR(BV.POD_CD, 3, 5) POD," ).append("\n"); 
		query.append("       'E' CATE," ).append("\n"); 
		query.append("       NVL(BB.ORG_TRNS_MOD_CD, ' ') KIND," ).append("\n"); 
		query.append("       DECODE(@[terminal_val], 'JNPT', 'SML1', 'SML') LINE," ).append("\n"); 
		query.append("       DECODE(BC.RC_FLG, 'Y', 'Y', 'N') RF_FLG," ).append("\n"); 
		query.append("       (SELECT DISTINCT CDO_TEMP FROM BKG_RF_CGO BRC" ).append("\n"); 
		query.append("        WHERE BC.BKG_NO = BRC.BKG_NO" ).append("\n"); 
		query.append("        AND   BC.CNTR_NO = BRC.CNTR_NO" ).append("\n"); 
		query.append("        AND   ROWNUM = 1) TEMP, " ).append("\n"); 
		query.append("       DECODE(BC.RC_FLG, 'Y', 'C', '') UNIT   " ).append("\n"); 
		query.append("FROM VSK_VSL_PORT_SKD VPS, BKG_BOOKING BB, BKG_CONTAINER BC, BKG_VVD BV" ).append("\n"); 
		query.append("WHERE 1=1 " ).append("\n"); 
		query.append("--1. 기간 조건(M)" ).append("\n"); 
		query.append("AND VPS_ETD_DT BETWEEN TO_DATE(@[from_dt], 'YYYY-MM-DD') AND TO_DATE(@[to_dt], 'YYYY-MM-DD') + 0.99999" ).append("\n"); 
		query.append("--2. VVD 조건(O)" ).append("\n"); 
		query.append("AND VPS.VSL_CD 		= SUBSTR(@[export_vvd], 1, 4)" ).append("\n"); 
		query.append("AND	VPS.SKD_VOY_NO 	= SUBSTR(@[export_vvd], 5, 4)" ).append("\n"); 
		query.append("AND	VPS.SKD_DIR_CD 	= SUBSTR(@[export_vvd], 9, 1)" ).append("\n"); 
		query.append("--3. POL 조건(M)" ).append("\n"); 
		query.append("AND BV.POL_CD LIKE @[pol]||'%'" ).append("\n"); 
		query.append("--4. 터미널 선택 조건(M)은 select시 사용" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("AND VPS.VSL_CD 		= BV.VSL_CD" ).append("\n"); 
		query.append("AND	VPS.SKD_VOY_NO 	= BV.SKD_VOY_NO" ).append("\n"); 
		query.append("AND	VPS.SKD_DIR_CD 	= BV.SKD_DIR_CD" ).append("\n"); 
		query.append("AND VPS.VPS_PORT_CD = BV.POL_CD" ).append("\n"); 
		query.append("AND BB.BKG_NO = BC.BKG_NO" ).append("\n"); 
		query.append("AND BB.BKG_NO = BV.BKG_NO" ).append("\n"); 
		query.append("AND	BB.BKG_STS_CD	   <>  'X'" ).append("\n"); 

	}
}