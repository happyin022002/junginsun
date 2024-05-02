/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : StatusReportDBDAOsearchCllCdlVslSumForRDRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.06.08
*@LastModifier : 
*@LastVersion : 1.0
* 2016.06.08 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingreport.statusreport.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class StatusReportDBDAOsearchCllCdlVslSumForRDRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Search Vsl and Total for CLL CDL RD
	  * </pre>
	  */
	public StatusReportDBDAOsearchCllCdlVslSumForRDRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("in_pol_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("in_vvd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.bookingreport.statusreport.integration").append("\n"); 
		query.append("FileName : StatusReportDBDAOsearchCllCdlVslSumForRDRSQL").append("\n"); 
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
		query.append("SELECT CNTR.VSL_CD||CNTR.SKD_VOY_NO||CNTR.SKD_DIR_CD VVD," ).append("\n"); 
		query.append("       NVL(LO.UN_LOC_CD, VPS.VPS_PORT_CD) UN_LOC_CD," ).append("\n"); 
		query.append("       TO_CHAR(VPS.VPS_ETA_DT, 'YYYY-MM-DD HH24:MI') VPS_ETA_DT ," ).append("\n"); 
		query.append("       TO_CHAR(VPS.VPS_ETD_DT, 'YYYY-MM-DD HH24:MI') VPS_ETD_DT ," ).append("\n"); 
		query.append("       TO_CHAR(VPS.VPS_ETB_DT, 'YYYY-MM-DD HH24:MI') VPS_ETB_DT ," ).append("\n"); 
		query.append("       VSL.VSL_ENG_NM||' '||VPS.OB_CSSM_VOY_NO AS CSSM_VVD ," ).append("\n"); 
		query.append("       D2," ).append("\n"); 
		query.append("       D4," ).append("\n"); 
		query.append("       D5," ).append("\n"); 
		query.append("       D7," ).append("\n"); 
		query.append("       D8," ).append("\n"); 
		query.append("       D9," ).append("\n"); 
		query.append("       DW," ).append("\n"); 
		query.append("       DX," ).append("\n"); 
		query.append("       R2," ).append("\n"); 
		query.append("       R4," ).append("\n"); 
		query.append("       R5," ).append("\n"); 
		query.append("       F2," ).append("\n"); 
		query.append("       F4," ).append("\n"); 
		query.append("       F5," ).append("\n"); 
		query.append("       O2," ).append("\n"); 
		query.append("       O4," ).append("\n"); 
		query.append("       O5," ).append("\n"); 
		query.append("       S2," ).append("\n"); 
		query.append("       S4," ).append("\n"); 
		query.append("       T2," ).append("\n"); 
		query.append("       T4," ).append("\n"); 
		query.append("       A2," ).append("\n"); 
		query.append("       A4," ).append("\n"); 
		query.append("       P2," ).append("\n"); 
		query.append("       P4," ).append("\n"); 
		query.append("       Z2," ).append("\n"); 
		query.append("       Z4," ).append("\n"); 
		query.append("       T20," ).append("\n"); 
		query.append("       T40," ).append("\n"); 
		query.append("       WGT," ).append("\n"); 
		query.append("       MEA," ).append("\n"); 
		query.append("	   E_WGT," ).append("\n"); 
		query.append("	   LCL," ).append("\n"); 
		query.append("	   TS," ).append("\n"); 
		query.append("       TTL" ).append("\n"); 
		query.append("  FROM(SELECT CNTR.VSL_CD," ).append("\n"); 
		query.append("               CNTR.SKD_VOY_NO," ).append("\n"); 
		query.append("               CNTR.SKD_DIR_CD," ).append("\n"); 
		query.append("               SUM(DECODE(CNTR.CNTR_TPSZ_CD, 'D2', 1, 0)) D2," ).append("\n"); 
		query.append("               SUM(DECODE(CNTR.CNTR_TPSZ_CD, 'D4', 1, 0)) D4," ).append("\n"); 
		query.append("               SUM(DECODE(CNTR.CNTR_TPSZ_CD, 'D5', 1, 0)) D5," ).append("\n"); 
		query.append("               SUM(DECODE(CNTR.CNTR_TPSZ_CD, 'D7', 1, 0)) D7," ).append("\n"); 
		query.append("               SUM(DECODE(CNTR.CNTR_TPSZ_CD, 'D8', 1, 0)) D8," ).append("\n"); 
		query.append("               SUM(DECODE(CNTR.CNTR_TPSZ_CD, 'D9', 1, 0)) D9," ).append("\n"); 
		query.append("               SUM(DECODE(CNTR.CNTR_TPSZ_CD, 'DW', 1, 0)) DW," ).append("\n"); 
		query.append("               SUM(DECODE(CNTR.CNTR_TPSZ_CD, 'DX', 1, 0)) DX," ).append("\n"); 
		query.append("               SUM(DECODE(CNTR.CNTR_TPSZ_CD, 'R2', 1, 0)) R2," ).append("\n"); 
		query.append("               SUM(DECODE(CNTR.CNTR_TPSZ_CD, 'R4', 1, 0)) R4," ).append("\n"); 
		query.append("               SUM(DECODE(CNTR.CNTR_TPSZ_CD, 'R5', 1, 0)) R5," ).append("\n"); 
		query.append("               SUM(DECODE(CNTR.CNTR_TPSZ_CD, 'F2', 1, 0)) F2," ).append("\n"); 
		query.append("               SUM(DECODE(CNTR.CNTR_TPSZ_CD, 'F4', 1, 0)) F4," ).append("\n"); 
		query.append("               SUM(DECODE(CNTR.CNTR_TPSZ_CD, 'F5', 1, 0)) F5," ).append("\n"); 
		query.append("               SUM(DECODE(CNTR.CNTR_TPSZ_CD, 'O2', 1, 0)) O2," ).append("\n"); 
		query.append("               SUM(DECODE(CNTR.CNTR_TPSZ_CD, 'O4', 1, 0)) O4," ).append("\n"); 
		query.append("               SUM(DECODE(CNTR.CNTR_TPSZ_CD, 'O5', 1, 0)) O5," ).append("\n"); 
		query.append("               SUM(DECODE(CNTR.CNTR_TPSZ_CD, 'S2', 1, 0)) S2," ).append("\n"); 
		query.append("               SUM(DECODE(CNTR.CNTR_TPSZ_CD, 'S4', 1, 0)) S4," ).append("\n"); 
		query.append("               SUM(DECODE(CNTR.CNTR_TPSZ_CD, 'T2', 1, 0)) T2," ).append("\n"); 
		query.append("               SUM(DECODE(CNTR.CNTR_TPSZ_CD, 'T4', 1, 0)) T4," ).append("\n"); 
		query.append("               SUM(DECODE(CNTR.CNTR_TPSZ_CD, 'A2', 1, 0)) A2," ).append("\n"); 
		query.append("               SUM(DECODE(CNTR.CNTR_TPSZ_CD, 'A4', 1, 0)) A4," ).append("\n"); 
		query.append("               SUM(DECODE(CNTR.CNTR_TPSZ_CD, 'P2', 1, 0)) P2," ).append("\n"); 
		query.append("               SUM(DECODE(CNTR.CNTR_TPSZ_CD, 'P4', 1, 0)) P4," ).append("\n"); 
		query.append("               SUM(DECODE(CNTR.CNTR_TPSZ_CD, 'Z2', 1, 0)) Z2," ).append("\n"); 
		query.append("               SUM(DECODE(CNTR.CNTR_TPSZ_CD, 'Z4', 1, 0)) Z4," ).append("\n"); 
		query.append("               SUM(DECODE(SUBSTR(CNTR.CNTR_TPSZ_CD, 2, 1), '2', 1, 0)) T20," ).append("\n"); 
		query.append("               SUM(DECODE(SUBSTR(CNTR.CNTR_TPSZ_CD, 2, 1), '2', 0, 1)) T40," ).append("\n"); 
		query.append("               SUM(CNTR.CNTR_WGT) WGT," ).append("\n"); 
		query.append("               SUM(CNTR.E_WGT) E_WGT," ).append("\n"); 
		query.append("               SUM(CNTR.MEAS_QTY) MEA," ).append("\n"); 
		query.append("               SUM(DECODE(TS_CD,'L',1,0)) LCL," ).append("\n"); 
		query.append("               SUM(DECODE(TS_CD,'T',1,0)) TS," ).append("\n"); 
		query.append("               COUNT(1) TTL" ).append("\n"); 
		query.append("          FROM (SELECT B.VSL_CD," ).append("\n"); 
		query.append("                       B.SKD_VOY_NO," ).append("\n"); 
		query.append("                       B.SKD_DIR_CD," ).append("\n"); 
		query.append("			           DECODE(B.POL_CD,@[in_pol_cd],'L','T') TS_CD,	" ).append("\n"); 
		query.append("                       C.CNTR_NO," ).append("\n"); 
		query.append("                       C.CNTR_TPSZ_CD," ).append("\n"); 
		query.append("                       C.CNTR_WGT," ).append("\n"); 
		query.append("                       C.MEAS_QTY," ).append("\n"); 
		query.append("                       C.CNTR_VOL_QTY," ).append("\n"); 
		query.append("                       ROUND((ROUND(NVL(D.ACT_WGT, 0) * DECODE(SUBSTR(C.CNTR_TPSZ_CD, 2, 1), '2', 1, 2) / SUM(DECODE(SUBSTR(C.CNTR_TPSZ_CD, 2, 1), '2', 1, 2))) + NVL(C.CNTR_VOL_QTY, 1)* decode(nvl(MST_TARE.MST_WGT, 0), 0, decode(nvl(MDM_TARE.MDM_WGT, 0), 0, 2500, MDM_TARE.MDM_WGT), MST_TARE.MST_WGT))/1000) E_WGT" ).append("\n"); 
		query.append("                  FROM BKG_BOOKING B," ).append("\n"); 
		query.append("                       BKG_CONTAINER C," ).append("\n"); 
		query.append("                       BKG_BL_DOC D," ).append("\n"); 
		query.append("                       (SELECT MAX(NVL(SPEC.TARE_WGT, 0)) MST_WGT ," ).append("\n"); 
		query.append("                               MST.CNTR_NO" ).append("\n"); 
		query.append("                          FROM MST_CONTAINER MST," ).append("\n"); 
		query.append("                               MST_CNTR_SPEC SPEC" ).append("\n"); 
		query.append("                         WHERE MST.CNTR_SPEC_NO = SPEC.CNTR_SPEC_NO" ).append("\n"); 
		query.append("                         GROUP BY MST.CNTR_NO) MST_TARE," ).append("\n"); 
		query.append("                       (SELECT MAX(NVL(MDM.CNTR_TPSZ_TARE_WGT, 0)) MDM_WGT ," ).append("\n"); 
		query.append("                               MDM.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("                          FROM MDM_CNTR_TP_SZ MDM" ).append("\n"); 
		query.append("                         GROUP BY MDM.CNTR_TPSZ_CD ) MDM_TARE" ).append("\n"); 
		query.append("                 WHERE B.BKG_NO = C.BKG_NO" ).append("\n"); 
		query.append("                   AND B.BKG_NO = D.BKG_NO" ).append("\n"); 
		query.append("                   AND MST_TARE.CNTR_NO = C.CNTR_NO" ).append("\n"); 
		query.append("                   AND MDM_TARE.CNTR_TPSZ_CD = C.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("                   AND B.BKG_STS_CD <> 'X'" ).append("\n"); 
		query.append("                   AND B.BKG_CGO_TP_CD <> 'P'" ).append("\n"); 
		query.append("				 #if(${bkg_no_list} != '')" ).append("\n"); 
		query.append("				   AND B.BKG_NO IN (${bkg_no_list})" ).append("\n"); 
		query.append("				 #end" ).append("\n"); 
		query.append("                 GROUP BY B.VSL_CD," ).append("\n"); 
		query.append("                       B.SKD_VOY_NO," ).append("\n"); 
		query.append("                       B.SKD_DIR_CD," ).append("\n"); 
		query.append("					   B.POL_CD," ).append("\n"); 
		query.append("                       C.CNTR_NO," ).append("\n"); 
		query.append("                       C.CNTR_TPSZ_CD," ).append("\n"); 
		query.append("                       C.CNTR_WGT," ).append("\n"); 
		query.append("                       C.MEAS_QTY," ).append("\n"); 
		query.append("                       C.CNTR_VOL_QTY," ).append("\n"); 
		query.append("                       D.ACT_WGT," ).append("\n"); 
		query.append("                       C.CNTR_TPSZ_CD," ).append("\n"); 
		query.append("                       MST_TARE.MST_WGT," ).append("\n"); 
		query.append("                       MDM_TARE.MDM_WGT ) CNTR" ).append("\n"); 
		query.append("         GROUP BY CNTR.VSL_CD," ).append("\n"); 
		query.append("               CNTR.SKD_VOY_NO," ).append("\n"); 
		query.append("               CNTR.SKD_DIR_CD ) CNTR," ).append("\n"); 
		query.append("       VSK_VSL_PORT_SKD VPS," ).append("\n"); 
		query.append("       MDM_VSL_CNTR VSL," ).append("\n"); 
		query.append("       MDM_LOCATION LO" ).append("\n"); 
		query.append(" WHERE VPS.VSL_CD = VSL.VSL_CD" ).append("\n"); 
		query.append("   AND VPS.VPS_PORT_CD = LO.LOC_CD" ).append("\n"); 
		query.append("   AND VPS.VSL_CD = CNTR.VSL_CD" ).append("\n"); 
		query.append("   AND VPS.SKD_VOY_NO = CNTR.SKD_VOY_NO" ).append("\n"); 
		query.append("   AND VPS.SKD_DIR_CD = CNTR.SKD_DIR_CD" ).append("\n"); 
		query.append("   AND VPS.VPS_PORT_CD = @[in_pol_cd]" ).append("\n"); 
		query.append("   AND CNTR.VSL_CD = SUBSTR(@[in_vvd], 1, 4)" ).append("\n"); 
		query.append("   AND CNTR.SKD_VOY_NO = SUBSTR(@[in_vvd], 5, 4)" ).append("\n"); 
		query.append("   AND CNTR.SKD_DIR_CD = SUBSTR(@[in_vvd], 9, 1)" ).append("\n"); 
		query.append("   AND ROWNUM = 1" ).append("\n"); 

	}
}