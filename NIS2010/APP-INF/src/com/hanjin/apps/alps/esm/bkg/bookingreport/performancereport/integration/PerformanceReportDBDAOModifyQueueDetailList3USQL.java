/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : PerformanceReportDBDAOModifyQueueDetailList3USQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.08.11
*@LastModifier : 
*@LastVersion : 1.0
* 2015.08.11 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PerformanceReportDBDAOModifyQueueDetailList3USQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 2011.03 김기종 [CHM-201109394-01] DPCS고도화일환으로 START TIME 관리
	  * </pre>
	  */
	public PerformanceReportDBDAOModifyQueueDetailList3USQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sr_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("src_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.integration").append("\n"); 
		query.append("FileName : PerformanceReportDBDAOModifyQueueDetailList3USQL").append("\n"); 
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
		query.append("UPDATE BKG_SR_CRNT_RQST R SET " ).append("\n"); 
		query.append("#if (${com_flg} == 'start' || ${com_flg} == 'end')" ).append("\n"); 
		query.append("#if (${com_flg} == 'start')" ).append("\n"); 
		query.append("	SR_WRK_STS_CD	= 'W' " ).append("\n"); 
		query.append("	,DPCS_DOC_FM_DT = GLOBALDATE_PKG.TIME_CONV_FNC('KRPUS',SYSDATE,GLOBALDATE_PKG.GET_LOCCD_FNC('PKGSA'))" ).append("\n"); 
		query.append("	" ).append("\n"); 
		query.append("#elseif (${com_flg} == 'end')" ).append("\n"); 
		query.append("	--,DPCS_DOC_FM_DT = NULL" ).append("\n"); 
		query.append("	#if (${pnd_flg} == 'P' || ${pnd_flg} == 'Y' )" ).append("\n"); 
		query.append("	SR_WRK_STS_CD	= '' " ).append("\n"); 
		query.append("   ,PND_FLG = 'N'" ).append("\n"); 
		query.append("   ,PND_USR_ID = @[usr_id]" ).append("\n"); 
		query.append("   ,PND_END_DT = GLOBALDATE_PKG.TIME_CONV_FNC('KRPUS',SYSDATE,GLOBALDATE_PKG.GET_LOCCD_FNC('PKGSA'))" ).append("\n"); 
		query.append("   ,PND_HRS = (SELECT SUM(SR_PROC_HRS) FROM BKG_SR_HIS H WHERE H.SR_KND_CD=R.SR_KND_CD AND H.SR_NO = R.SR_NO AND H.BKG_NO = R.BKG_NO AND H.SR_STS_CD = 'PN')" ).append("\n"); 
		query.append("	#else" ).append("\n"); 
		query.append("	SR_WRK_STS_CD	= DECODE(SR_WRK_STS_CD,'W','',SR_WRK_STS_CD) " ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("	,SR_WRK_STS_USR_ID = @[usr_id]" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("	SR_WRK_STS_USR_ID = @[usr_id]" ).append("\n"); 
		query.append("	#if (${pnd_flg} == 'P' || ${pnd_flg} == 'Y' )" ).append("\n"); 
		query.append("   ,PND_FLG = 'N'" ).append("\n"); 
		query.append("   ,PND_USR_ID = @[usr_id]" ).append("\n"); 
		query.append("   ,PND_END_DT = GLOBALDATE_PKG.TIME_CONV_FNC('KRPUS',SYSDATE,GLOBALDATE_PKG.GET_LOCCD_FNC('PKGSA'))" ).append("\n"); 
		query.append("   ,PND_HRS = (SELECT SUM(SR_PROC_HRS) FROM BKG_SR_HIS H WHERE H.SR_KND_CD=R.SR_KND_CD AND H.SR_NO = R.SR_NO AND H.BKG_NO = R.BKG_NO AND H.SR_STS_CD = 'PN')" ).append("\n"); 
		query.append("	#if (${com_flg} == 'pnx')" ).append("\n"); 
		query.append("   ,SR_WRK_STS_CD = DECODE(BL_RT_FLG||BL_AUD_FLG||BL_DRFT_FAX_OUT_FLG||BL_DOC_INP_FLG,'YYYY','Y','W')" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("   #end" ).append("\n"); 
		query.append("	,DPCS_DOC_FM_DT = GLOBALDATE_PKG.TIME_CONV_FNC('KRPUS',SYSDATE,GLOBALDATE_PKG.GET_LOCCD_FNC('PKGSA'))" ).append("\n"); 
		query.append("	" ).append("\n"); 
		query.append("#if (${com_flg} == 'inp')" ).append("\n"); 
		query.append("	,BL_DOC_INP_FLG = 'Y'" ).append("\n"); 
		query.append("   ,BL_DOC_INP_USR_ID = @[usr_id]" ).append("\n"); 
		query.append("   ,BL_DOC_INP_ST_DT =	DPCS_DOC_FM_DT" ).append("\n"); 
		query.append("   ,BL_DOC_INP_DT = GLOBALDATE_PKG.TIME_CONV_FNC('KRPUS',SYSDATE,GLOBALDATE_PKG.GET_LOCCD_FNC('PKGSA'))" ).append("\n"); 
		query.append("   ,SR_WRK_STS_CD  = DECODE(BL_RT_FLG||BL_AUD_FLG||BL_DRFT_FAX_OUT_FLG,'YYY','Y','W')	" ).append("\n"); 
		query.append("   ,BL_DOC_INP_HRS =  (SELECT SUM(SR_PROC_HRS) FROM BKG_SR_HIS H WHERE H.SR_KND_CD=R.SR_KND_CD AND H.SR_NO = R.SR_NO AND H.BKG_NO = R.BKG_NO AND H.SR_STS_CD = 'ID')" ).append("\n"); 
		query.append("#elseif (${com_flg} == 'rt')" ).append("\n"); 
		query.append("	,BL_RT_FLG = 'Y'" ).append("\n"); 
		query.append("   ,BL_RT_USR_ID = @[usr_id]" ).append("\n"); 
		query.append("   ,BL_RT_ST_DT =	DPCS_DOC_FM_DT" ).append("\n"); 
		query.append("   ,BL_RT_DT = GLOBALDATE_PKG.TIME_CONV_FNC('KRPUS',SYSDATE,GLOBALDATE_PKG.GET_LOCCD_FNC('PKGSA'))" ).append("\n"); 
		query.append("   ,SR_WRK_STS_CD  = DECODE(BL_DOC_INP_FLG||BL_AUD_FLG||BL_DRFT_FAX_OUT_FLG,'YYY','Y','W')		" ).append("\n"); 
		query.append("   ,BL_RT_HRS =  (SELECT SUM(SR_PROC_HRS) FROM BKG_SR_HIS H WHERE H.SR_KND_CD=R.SR_KND_CD AND H.SR_NO = R.SR_NO AND H.BKG_NO = R.BKG_NO AND H.SR_STS_CD = 'RD')	" ).append("\n"); 
		query.append("#elseif (${com_flg} == 'qa')" ).append("\n"); 
		query.append("   ,BL_AUD_FLG = 'Y'" ).append("\n"); 
		query.append("   ,BL_AUD_USR_ID = @[usr_id]" ).append("\n"); 
		query.append("   ,BL_AUD_ST_DT = DPCS_DOC_FM_DT" ).append("\n"); 
		query.append("   ,BL_AUD_DT = GLOBALDATE_PKG.TIME_CONV_FNC('KRPUS',SYSDATE,GLOBALDATE_PKG.GET_LOCCD_FNC('PKGSA'))" ).append("\n"); 
		query.append("   ,SR_WRK_STS_CD  = DECODE(BL_DOC_INP_FLG||BL_RT_FLG||BL_DRFT_FAX_OUT_FLG,'YYY','Y','W')" ).append("\n"); 
		query.append("   ,BL_AUD_HRS =  (SELECT SUM(SR_PROC_HRS) FROM BKG_SR_HIS H WHERE H.SR_KND_CD=R.SR_KND_CD AND H.SR_NO = R.SR_NO AND H.BKG_NO = R.BKG_NO AND H.SR_STS_CD = 'AD')				" ).append("\n"); 
		query.append("#elseif (${com_flg} == 'fax')" ).append("\n"); 
		query.append(" 	,BL_DRFT_FAX_OUT_FLG = 'Y'" ).append("\n"); 
		query.append("   ,BL_DRFT_FAX_OUT_USR_ID = @[usr_id]" ).append("\n"); 
		query.append("   ,BL_DRFT_FAX_OUT_ST_DT =	DPCS_DOC_FM_DT" ).append("\n"); 
		query.append("   ,BL_DRFT_FAX_OUT_DT = GLOBALDATE_PKG.TIME_CONV_FNC('KRPUS',SYSDATE,GLOBALDATE_PKG.GET_LOCCD_FNC('PKGSA'))" ).append("\n"); 
		query.append("   ,SR_WRK_STS_CD  = DECODE(BL_DOC_INP_FLG||BL_RT_FLG||BL_AUD_FLG,'YYY','Y','W')	" ).append("\n"); 
		query.append("   ,BL_DRFT_FAX_OUT_HRS =  (SELECT SUM(SR_PROC_HRS) FROM BKG_SR_HIS H WHERE H.SR_KND_CD=R.SR_KND_CD AND H.SR_NO = R.SR_NO AND H.BKG_NO = R.BKG_NO AND H.SR_STS_CD = 'DF')				" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("   ,CRNT_DT = GLOBALDATE_PKG.TIME_CONV_FNC('KRPUS',SYSDATE,GLOBALDATE_PKG.GET_LOCCD_FNC('PKGSA'))" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(",	UPD_USR_ID = @[usr_id]" ).append("\n"); 
		query.append(",	UPD_DT = SYSDATE	" ).append("\n"); 
		query.append("WHERE	SR_KND_CD = @[src_cd]" ).append("\n"); 
		query.append("AND	SR_NO = @[sr_no]" ).append("\n"); 
		query.append("AND	BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("AND SR_AMD_SEQ = (SELECT NVL(MAX(SR_AMD_SEQ),0)" ).append("\n"); 
		query.append("                             FROM  BKG_SR_CRNT_RQST" ).append("\n"); 
		query.append("                            WHERE SR_KND_CD = R.SR_KND_CD" ).append("\n"); 
		query.append("                              AND SR_AMD_TP_CD = R.SR_AMD_TP_CD" ).append("\n"); 
		query.append("                              AND BKG_NO = R.BKG_NO" ).append("\n"); 
		query.append("                              AND SR_NO = R.SR_NO" ).append("\n"); 
		query.append("                              AND FNT_OFC_TRNS_DT IS NOT NULL" ).append("\n"); 
		query.append("                           )" ).append("\n"); 

	}
}