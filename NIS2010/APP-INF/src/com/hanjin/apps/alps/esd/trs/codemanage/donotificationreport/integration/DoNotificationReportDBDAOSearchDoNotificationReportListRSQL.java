/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : DoNotificationReportDBDAOSearchDoNotificationReportListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.08.09
*@LastModifier : 
*@LastVersion : 1.0
* 2016.08.09 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.trs.codemanage.donotificationreport.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class DoNotificationReportDBDAOSearchDoNotificationReportListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchDoNotificationReportList
	  * </pre>
	  */
	public DoNotificationReportDBDAOSearchDoNotificationReportListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_sent_to_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_fm_node",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_to_node",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_door",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_sent_fm_dt",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.trs.codemanage.donotificationreport.integration").append("\n"); 
		query.append("FileName : DoNotificationReportDBDAOSearchDoNotificationReportListRSQL").append("\n"); 
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
		query.append("    CTRL_OFC_CD," ).append("\n"); 
		query.append("    NTC_SND_DT," ).append("\n"); 
		query.append("    CNTR_NO," ).append("\n"); 
		query.append("    CNTR_TPSZ_CD," ).append("\n"); 
		query.append("    FM_NOD_CD," ).append("\n"); 
		query.append("    FM_YARD_CD," ).append("\n"); 
		query.append("    TO_NOD_CD," ).append("\n"); 
		query.append("    TO_YARD_CD," ).append("\n"); 
		query.append("    DOR_NOD_CD," ).append("\n"); 
		query.append("    DOR_YARD_CD," ).append("\n"); 
		query.append("    DOR_NOD_NM," ).append("\n"); 
		query.append("    BKG_NO," ).append("\n"); 
		query.append("    BL_NO," ).append("\n"); 
		query.append("    SC_NO," ).append("\n"); 
		query.append("    TRNK_VVD_CD," ).append("\n"); 
		query.append("    SLAN_CD," ).append("\n"); 
		query.append("    IB_VVD_CD," ).append("\n"); 
		query.append("    ETA_DT," ).append("\n"); 
		query.append("    ETA_TIME," ).append("\n"); 
		query.append("	RAIL_ETA_DT," ).append("\n"); 
		query.append("	RAIL_ETA_TIME," ).append("\n"); 
		query.append("    CUST_SEQ," ).append("\n"); 
		query.append("    CUST_NM," ).append("\n"); 
		query.append("    NVL(EML_NO_1, FAX_NO_1) AS EML_FAX_1," ).append("\n"); 
		query.append("    NVL(EML_NO_2, FAX_NO_2) AS EML_FAX_2," ).append("\n"); 
		query.append("    NVL(EML_NO_3, FAX_NO_3) AS EML_FAX_3," ).append("\n"); 
		query.append("    NVL(EML_NO_4, FAX_NO_4) AS EML_FAX_4," ).append("\n"); 
		query.append("    NVL(EML_NO_5, FAX_NO_5) AS EML_FAX_5," ).append("\n"); 
		query.append("    NVL(EML_NO_6, FAX_NO_6) AS EML_FAX_6," ).append("\n"); 
		query.append("    NVL(EML_NO_7, FAX_NO_7) AS EML_FAX_7," ).append("\n"); 
		query.append("    NVL(EML_RESULT_1,FAX_RESULT_1) AS RESULT_1," ).append("\n"); 
		query.append("    NVL(EML_RESULT_2,FAX_RESULT_2) AS RESULT_2," ).append("\n"); 
		query.append("    NVL(EML_RESULT_3,FAX_RESULT_3) AS RESULT_3," ).append("\n"); 
		query.append("    NVL(EML_RESULT_4,FAX_RESULT_4) AS RESULT_4," ).append("\n"); 
		query.append("    NVL(EML_RESULT_5,FAX_RESULT_5) AS RESULT_5," ).append("\n"); 
		query.append("    NVL(EML_RESULT_6,FAX_RESULT_6) AS RESULT_6," ).append("\n"); 
		query.append("    NVL(EML_RESULT_7,FAX_RESULT_7) AS RESULT_7" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("    (SELECT MAX(DNSD.CTRL_OFC_CD) AS CTRL_OFC_CD," ).append("\n"); 
		query.append("    #if(${f_latest} == '')" ).append("\n"); 
		query.append("       TO_CHAR(DNSD.NTC_SND_DT, 'YYYY-MM-DD') AS NTC_SND_DT," ).append("\n"); 
		query.append("    #else" ).append("\n"); 
		query.append("       MAX(TO_CHAR(DNSD.NTC_SND_DT, 'YYYY-MM-DD')) AS NTC_SND_DT," ).append("\n"); 
		query.append("    #end   " ).append("\n"); 
		query.append("       DNSD.CNTR_NO AS CNTR_NO," ).append("\n"); 
		query.append("       MAX(DNSD.CNTR_TPSZ_CD) AS CNTR_TPSZ_CD," ).append("\n"); 
		query.append("       MAX(SUBSTR(DNSD.FM_NOD_CD, 0, 5)) AS FM_NOD_CD," ).append("\n"); 
		query.append("       MAX(SUBSTR(DNSD.FM_NOD_CD, 6, 2)) AS FM_YARD_CD," ).append("\n"); 
		query.append("       MAX(SUBSTR(DNSD.TO_NOD_CD, 0, 5)) AS TO_NOD_CD," ).append("\n"); 
		query.append("       MAX(SUBSTR(DNSD.TO_NOD_CD, 6, 2)) AS TO_YARD_CD," ).append("\n"); 
		query.append("       MAX(SUBSTR(DNSD.DOR_NOD_CD, 0, 5)) AS DOR_NOD_CD," ).append("\n"); 
		query.append("       MAX(SUBSTR(DNSD.DOR_NOD_CD, 6, 2)) AS DOR_YARD_CD," ).append("\n"); 
		query.append("       MAX((SELECT ZN_NM" ).append("\n"); 
		query.append("          FROM MDM_ZONE" ).append("\n"); 
		query.append("         WHERE 1=1" ).append("\n"); 
		query.append("           AND ZN_CD = DNSD.DOR_NOD_CD" ).append("\n"); 
		query.append("           AND DELT_FLG = 'N'" ).append("\n"); 
		query.append("           AND ROWNUM = 1)) AS DOR_NOD_NM," ).append("\n"); 
		query.append("       MAX(DNSD.BKG_NO) AS BKG_NO," ).append("\n"); 
		query.append("       BKGM.BL_NO AS BL_NO," ).append("\n"); 
		query.append("       MAX(NVL(BKGM.SC_NO, BKGM.RFA_NO)) AS SC_NO," ).append("\n"); 
		query.append("       MAX(BKGM.VSL_CD || BKGM.SKD_VOY_NO || BKGM.SKD_DIR_CD) AS TRNK_VVD_CD," ).append("\n"); 
		query.append("       MAX(BKGM.SLAN_CD) AS SLAN_CD," ).append("\n"); 
		query.append("       MAX(DNSD.IB_VVD_CD) AS IB_VVD_CD," ).append("\n"); 
		query.append("       MAX(TO_CHAR(DNSD.ETA_DT, 'YYYY-MM-DD')) AS ETA_DT," ).append("\n"); 
		query.append("       MAX(TO_CHAR(DNSD.ETA_DT, 'HH24:MI')) AS ETA_TIME," ).append("\n"); 
		query.append("	   MAX(TO_CHAR(DNSD.RAIL_ETA_DT, 'YYYY-MM-DD')) AS RAIL_ETA_DT," ).append("\n"); 
		query.append("	   MAX(TO_CHAR(DNSD.RAIL_ETA_DT, 'HH24:MI')) AS RAIL_ETA_TIME," ).append("\n"); 
		query.append("       MAX(DNSR.CUST_CNT_CD || LPAD(DNSR.CUST_SEQ,6,0)) AS CUST_SEQ," ).append("\n"); 
		query.append("       MAX((SELECT BCST.CUST_NM" ).append("\n"); 
		query.append("          FROM BKG_CUSTOMER BCST" ).append("\n"); 
		query.append("         WHERE 1=1" ).append("\n"); 
		query.append("           AND BCST.BKG_NO = BKGM.BKG_NO" ).append("\n"); 
		query.append("           AND BCST.CUST_SEQ = DNSR.CUST_SEQ" ).append("\n"); 
		query.append("           AND BCST.BKG_CUST_TP_CD = DNSR.BKG_CUST_TP_CD)) AS CUST_NM," ).append("\n"); 
		query.append("       MAX(DECODE(DNSR.CUST_CNTC_TP_CD, 'C1', DNSR.NTC_EML , NULL)) AS EML_NO_1," ).append("\n"); 
		query.append("       MAX(DECODE(DNSR.CUST_CNTC_TP_CD, 'C2', DNSR.NTC_EML , NULL)) AS EML_NO_2," ).append("\n"); 
		query.append("       MAX(DECODE(DNSR.CUST_CNTC_TP_CD, 'B1', DNSR.NTC_EML , NULL)) AS EML_NO_3," ).append("\n"); 
		query.append("       MAX(DECODE(DNSR.CUST_CNTC_TP_CD, 'B2', DNSR.NTC_EML , NULL)) AS EML_NO_4," ).append("\n"); 
		query.append("       MAX(DECODE(DNSR.CUST_CNTC_TP_CD, 'A1', DNSR.NTC_EML , NULL)) AS EML_NO_5," ).append("\n"); 
		query.append("       MAX(DECODE(DNSR.CUST_CNTC_TP_CD, 'A2', DNSR.NTC_EML , NULL)) AS EML_NO_6," ).append("\n"); 
		query.append("       MAX(DECODE(DNSR.CUST_CNTC_TP_CD, 'AN', DNSR.NTC_EML , NULL)) AS EML_NO_7," ).append("\n"); 
		query.append("       MAX(DECODE(DNSR.CUST_CNTC_TP_CD, 'C1', DNSR.FAX_NO , NULL)) AS FAX_NO_1," ).append("\n"); 
		query.append("       MAX(DECODE(DNSR.CUST_CNTC_TP_CD, 'C2', DNSR.FAX_NO , NULL)) AS FAX_NO_2," ).append("\n"); 
		query.append("       MAX(DECODE(DNSR.CUST_CNTC_TP_CD, 'B1', DNSR.FAX_NO , NULL)) AS FAX_NO_3," ).append("\n"); 
		query.append("       MAX(DECODE(DNSR.CUST_CNTC_TP_CD, 'B2', DNSR.FAX_NO , NULL)) AS FAX_NO_4," ).append("\n"); 
		query.append("       MAX(DECODE(DNSR.CUST_CNTC_TP_CD, 'A1', DNSR.FAX_NO , NULL)) AS FAX_NO_5," ).append("\n"); 
		query.append("       MAX(DECODE(DNSR.CUST_CNTC_TP_CD, 'A2', DNSR.FAX_NO , NULL)) AS FAX_NO_6," ).append("\n"); 
		query.append("       MAX(DECODE(DNSR.CUST_CNTC_TP_CD, 'AN', DNSR.FAX_NO , NULL)) AS FAX_NO_7," ).append("\n"); 
		query.append("       MAX(BKG_COM_INTG_CD_NM_FNC('CD00960', DECODE(DNSR.CUST_CNTC_TP_CD, 'C1', EMSD.EML_PROC_STS_CD, NULL))) AS EML_RESULT_1," ).append("\n"); 
		query.append("       MAX(BKG_COM_INTG_CD_NM_FNC('CD00960', DECODE(DNSR.CUST_CNTC_TP_CD, 'C2', EMSD.EML_PROC_STS_CD, NULL))) AS EML_RESULT_2," ).append("\n"); 
		query.append("       MAX(BKG_COM_INTG_CD_NM_FNC('CD00960', DECODE(DNSR.CUST_CNTC_TP_CD, 'B1', EMSD.EML_PROC_STS_CD, NULL))) AS EML_RESULT_3," ).append("\n"); 
		query.append("       MAX(BKG_COM_INTG_CD_NM_FNC('CD00960', DECODE(DNSR.CUST_CNTC_TP_CD, 'B2', EMSD.EML_PROC_STS_CD, NULL))) AS EML_RESULT_4," ).append("\n"); 
		query.append("       MAX(BKG_COM_INTG_CD_NM_FNC('CD00960', DECODE(DNSR.CUST_CNTC_TP_CD, 'A1', EMSD.EML_PROC_STS_CD, NULL))) AS EML_RESULT_5," ).append("\n"); 
		query.append("       MAX(BKG_COM_INTG_CD_NM_FNC('CD00960', DECODE(DNSR.CUST_CNTC_TP_CD, 'A2', EMSD.EML_PROC_STS_CD, NULL))) AS EML_RESULT_6," ).append("\n"); 
		query.append("       MAX(BKG_COM_INTG_CD_NM_FNC('CD00960', DECODE(DNSR.CUST_CNTC_TP_CD, 'AN', EMSD.EML_PROC_STS_CD, NULL))) AS EML_RESULT_7," ).append("\n"); 
		query.append("       MAX(BKG_COM_INTG_CD_NM_FNC('CD00959', DECODE(DNSR.CUST_CNTC_TP_CD, 'C1', FXSD.FAX_PROC_STS_CD, NULL))) AS FAX_RESULT_1," ).append("\n"); 
		query.append("       MAX(BKG_COM_INTG_CD_NM_FNC('CD00959', DECODE(DNSR.CUST_CNTC_TP_CD, 'C2', FXSD.FAX_PROC_STS_CD, NULL))) AS FAX_RESULT_2," ).append("\n"); 
		query.append("       MAX(BKG_COM_INTG_CD_NM_FNC('CD00959', DECODE(DNSR.CUST_CNTC_TP_CD, 'B1', FXSD.FAX_PROC_STS_CD, NULL))) AS FAX_RESULT_3," ).append("\n"); 
		query.append("       MAX(BKG_COM_INTG_CD_NM_FNC('CD00959', DECODE(DNSR.CUST_CNTC_TP_CD, 'B2', FXSD.FAX_PROC_STS_CD, NULL))) AS FAX_RESULT_4," ).append("\n"); 
		query.append("       MAX(BKG_COM_INTG_CD_NM_FNC('CD00959', DECODE(DNSR.CUST_CNTC_TP_CD, 'A1', FXSD.FAX_PROC_STS_CD, NULL))) AS FAX_RESULT_5," ).append("\n"); 
		query.append("       MAX(BKG_COM_INTG_CD_NM_FNC('CD00959', DECODE(DNSR.CUST_CNTC_TP_CD, 'A2', FXSD.FAX_PROC_STS_CD, NULL))) AS FAX_RESULT_6," ).append("\n"); 
		query.append("       MAX(BKG_COM_INTG_CD_NM_FNC('CD00959', DECODE(DNSR.CUST_CNTC_TP_CD, 'AN', FXSD.FAX_PROC_STS_CD, NULL))) AS FAX_RESULT_7" ).append("\n"); 
		query.append("    FROM TRS_DO_NTFC_SNT_RPT DNSR," ).append("\n"); 
		query.append("       TRS_DO_NTFC_SNT_RPT_DTL DNSD," ).append("\n"); 
		query.append("       BKG_BOOKING BKGM," ).append("\n"); 
		query.append("       COM_FAX_SND_INFO FXSD," ).append("\n"); 
		query.append("       COM_EML_SND_INFO EMSD" ).append("\n"); 
		query.append("    WHERE 1=1" ).append("\n"); 
		query.append("        AND DNSR.DO_NTFC_SNT_RPT_SEQ = DNSD.DO_NTFC_SNT_RPT_SEQ" ).append("\n"); 
		query.append("        AND DNSD.BKG_NO = BKGM.BKG_NO" ).append("\n"); 
		query.append("        AND DNSR.FAX_NTC_SND_ID = FXSD.FAX_SND_NO(+)" ).append("\n"); 
		query.append("        AND DNSR.EML_NTC_SND_ID = EMSD.EML_SND_NO(+)" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("    #if(${f_sent_fm_dt} != '' && ${f_sent_to_dt} != '')" ).append("\n"); 
		query.append("        AND DNSD.NTC_SND_DT BETWEEN TO_DATE(@[f_sent_fm_dt], 'YYYYMMDD') AND TO_DATE(@[f_sent_to_dt], 'YYYYMMDD')+0.99999" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("    #if ($f_ctrl_ofc_cd.size() > 0)" ).append("\n"); 
		query.append("        AND DNSD.CTRL_OFC_CD IN (" ).append("\n"); 
		query.append("        #foreach($key in ${f_ctrl_ofc_cd}) " ).append("\n"); 
		query.append("            #if($velocityCount < $f_ctrl_ofc_cd.size()) " ).append("\n"); 
		query.append("                '$key', " ).append("\n"); 
		query.append("            #else " ).append("\n"); 
		query.append("                '$key' " ).append("\n"); 
		query.append("            #end " ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("        )" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("    #if(${f_fm_node} != '') " ).append("\n"); 
		query.append("        AND DNSD.FM_NOD_CD LIKE @[f_fm_node]||'%'" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("    #if(${f_to_node} != '') " ).append("\n"); 
		query.append("        AND DNSD.TO_NOD_CD LIKE @[f_to_node]||'%'" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("    #if(${f_door} != '') " ).append("\n"); 
		query.append("        AND DNSD.DOR_NOD_CD LIKE @[f_door]||'%'" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("    #if($f_trnk_vvd.size() > 0)" ).append("\n"); 
		query.append("		AND ((BKGM.VSL_CD, BKGM.SKD_VOY_NO, BKGM.SKD_DIR_CD) IN (" ).append("\n"); 
		query.append("		#foreach( ${key} in ${f_trnk_vvd}) " ).append("\n"); 
		query.append("        	#if($velocityCount == 1)" ).append("\n"); 
		query.append("				( SUBSTR('$key', 1, 4), SUBSTR('$key', 5, 4), SUBSTR('$key', 9))" ).append("\n"); 
		query.append("	        #else " ).append("\n"); 
		query.append("    		     , ( SUBSTR('$key', 1, 4), SUBSTR('$key', 5, 4), SUBSTR('$key', 9))" ).append("\n"); 
		query.append("			#end " ).append("\n"); 
		query.append("       #end" ).append("\n"); 
		query.append("			)" ).append("\n"); 
		query.append("		)" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("    #if ($f_bkg_no.size() > 0)" ).append("\n"); 
		query.append("		AND BKGM.BKG_NO IN (" ).append("\n"); 
		query.append("		#foreach( $key in ${f_bkg_no}) " ).append("\n"); 
		query.append("			#if($velocityCount < $f_bkg_no.size()) " ).append("\n"); 
		query.append("        		UPPER('$key'), " ).append("\n"); 
		query.append("        	#else " ).append("\n"); 
		query.append("            	UPPER('$key')" ).append("\n"); 
		query.append("        	#end " ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("       )" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("    #if($f_cntr_no.size() > 0)    " ).append("\n"); 
		query.append("        AND DNSD.CNTR_NO IN (" ).append("\n"); 
		query.append("		#foreach( ${key} in ${f_cntr_no}) " ).append("\n"); 
		query.append("			#if($velocityCount < $f_cntr_no.size()) " ).append("\n"); 
		query.append("        		UPPER('${key}'), " ).append("\n"); 
		query.append("        	#else " ).append("\n"); 
		query.append("            	UPPER('${key}')" ).append("\n"); 
		query.append("        	#end " ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("       )" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("    #if($f_sc_no.size() > 0)" ).append("\n"); 
		query.append("        AND (BKGM.SC_NO IN (" ).append("\n"); 
		query.append("		#foreach( ${key} in ${f_sc_no})" ).append("\n"); 
		query.append("			#if($velocityCount < $f_sc_no.size()) " ).append("\n"); 
		query.append("        		UPPER('${key}'), " ).append("\n"); 
		query.append("        	#else " ).append("\n"); 
		query.append("            	UPPER('${key}')" ).append("\n"); 
		query.append("        	#end " ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("       ) OR BKGM.RFA_NO IN (" ).append("\n"); 
		query.append("		#foreach( ${key} in ${f_sc_no})" ).append("\n"); 
		query.append("			#if($velocityCount < $f_sc_no.size()) " ).append("\n"); 
		query.append("        		UPPER('${key}'), " ).append("\n"); 
		query.append("        	#else " ).append("\n"); 
		query.append("            	UPPER('${key}')" ).append("\n"); 
		query.append("        	#end " ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("			)" ).append("\n"); 
		query.append("		)" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("    GROUP BY " ).append("\n"); 
		query.append("        BKGM.BL_NO" ).append("\n"); 
		query.append("       ,DNSD.CNTR_NO" ).append("\n"); 
		query.append("	   ,DNSR.BKG_CUST_TP_CD" ).append("\n"); 
		query.append("       ,DNSR.CUST_SEQ " ).append("\n"); 
		query.append("    #if(${f_latest} == '')" ).append("\n"); 
		query.append("       ,DNSD.NTC_SND_DT" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("    ORDER BY " ).append("\n"); 
		query.append("        BKGM.BL_NO" ).append("\n"); 
		query.append("       ,DNSD.CNTR_NO" ).append("\n"); 
		query.append("	   ,DNSR.BKG_CUST_TP_CD" ).append("\n"); 
		query.append("       ,DNSR.CUST_SEQ " ).append("\n"); 
		query.append("    #if(${f_latest} == '')" ).append("\n"); 
		query.append("       ,DNSD.NTC_SND_DT" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append(" )" ).append("\n"); 

	}
}