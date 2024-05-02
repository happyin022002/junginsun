/*=========================================================
*Copyright(c) 2018 CyberLogitec
*@FileName : ChargeCalculationDBDAOInactiveListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2018.06.18
*@LastModifier : 
*@LastVersion : 1.0
* 2018.06.18 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.dmt.dmtclosing.chargecalculation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ChargeCalculationDBDAOInactiveListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * InactiveListVO
	  * </pre>
	  */
	public ChargeCalculationDBDAOInactiveListRSQL(){
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
		params.put("usr_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("chg_delt_path_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("fm_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("tab_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.dmt.dmtclosing.chargecalculation.integration").append("\n"); 
		query.append("FileName : ChargeCalculationDBDAOInactiveListRSQL").append("\n"); 
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
		query.append("SELECT  MAX(AA.DMDT_DELT_RQST_STS_CD) DMDT_DELT_RQST_STS_CD" ).append("\n"); 
		query.append("       ,MAX(AA.STS_CD)STS_CD" ).append("\n"); 
		query.append("       ,MAX(AA.INACT_RQST_NO) INACT_RQST_NO" ).append("\n"); 
		query.append("       ,MAX(CASE WHEN AA.INACT_RQST_NO IS NULL THEN TO_CHAR(ROWNUM) ELSE AA.INACT_RQST_NO END) GROUP_RQST_NO" ).append("\n"); 
		query.append("       ,MAX(AA.INACT_APRO_NO) INACT_APRO_NO" ).append("\n"); 
		query.append("	    #if (${group_by} == 'BKG' )" ).append("\n"); 
		query.append("       ,AA.BKG_NO" ).append("\n"); 
		query.append("	    #end	" ).append("\n"); 
		query.append("	    #if (${group_by} == 'CNTR' ) " ).append("\n"); 
		query.append("       ,AA.CNTR_NO" ).append("\n"); 
		query.append("	    #end" ).append("\n"); 
		query.append("       ,MAX(TO_DATE(TO_CHAR(SYSDATE, 'YYYYMMDD'), 'YYYYMMDD') - TO_DATE(TO_CHAR(CC.RQST_DT, 'YYYYMMDD'), 'YYYYMMDD')) AS OVR_DYS" ).append("\n"); 
		query.append("       ,MAX(TO_CHAR(CC.RQST_DT,'YYYYMMDD')) RQST_DT" ).append("\n"); 
		query.append("       ,MAX(CC.RQST_OFC_CD) RQST_OFC" ).append("\n"); 
		query.append("       ,MAX( CASE WHEN CC.RQST_OFC_CD = @[usr_ofc_cd] THEN 'Y' ELSE 'N' END ) RQST_OFC_FLG" ).append("\n"); 
		query.append("       ,MAX(( SELECT USR_NM FROM COM_USER WHERE USR_ID = CC.RQST_USR_ID )) AS RQST_NM" ).append("\n"); 
		query.append("	   --// OOM ( OFC Operation Manager )" ).append("\n"); 
		query.append("       ,MAX(CASE WHEN BB.CHG_DELT_PATH_CD = 'OOM' AND TRIM(BB.CHG_DELT_STS_CD) IS NOT NULL THEN TO_CHAR(BB.UPD_DT,'YYYYMMDD') ELSE '' END) OOM_DT" ).append("\n"); 
		query.append("       ,MAX(CASE WHEN BB.CHG_DELT_PATH_CD = 'OOM' AND TRIM(BB.CHG_DELT_STS_CD) IS NOT NULL THEN BB.UPD_OFC_CD ELSE '' END) OOM_OFC" ).append("\n"); 
		query.append("       ,MAX(CASE WHEN BB.CHG_DELT_PATH_CD = 'OOM' AND TRIM(BB.CHG_DELT_STS_CD) IS NOT NULL THEN ( SELECT USR_NM FROM COM_USER WHERE USR_ID = BB.UPD_USR_ID ) ELSE '' END) OOM_NM	   " ).append("\n"); 
		query.append("	   --// BBG ( Branch Office )" ).append("\n"); 
		query.append("       ,MAX(CASE WHEN BB.CHG_DELT_PATH_CD = 'BBG' AND TRIM(BB.CHG_DELT_STS_CD) IS NOT NULL THEN TO_CHAR(BB.UPD_DT,'YYYYMMDD') ELSE '' END) BBG_DT" ).append("\n"); 
		query.append("       ,MAX(CASE WHEN BB.CHG_DELT_PATH_CD = 'BBG' AND TRIM(BB.CHG_DELT_STS_CD) IS NOT NULL THEN BB.UPD_OFC_CD ELSE '' END) BBG_OFC" ).append("\n"); 
		query.append("       ,MAX(CASE WHEN BB.CHG_DELT_PATH_CD = 'BBG' AND TRIM(BB.CHG_DELT_STS_CD) IS NOT NULL THEN ( SELECT USR_NM FROM COM_USER WHERE USR_ID = BB.UPD_USR_ID ) ELSE '' END) BBG_NM" ).append("\n"); 
		query.append("	   --// RHQ" ).append("\n"); 
		query.append("       ,MAX(CASE WHEN BB.CHG_DELT_PATH_CD = 'RHQ' AND TRIM(BB.CHG_DELT_STS_CD) IS NOT NULL THEN TO_CHAR(BB.UPD_DT,'YYYYMMDD') ELSE '' END) RHQ_DT" ).append("\n"); 
		query.append("       ,MAX(CASE WHEN BB.CHG_DELT_PATH_CD = 'RHQ' AND TRIM(BB.CHG_DELT_STS_CD) IS NOT NULL THEN BB.UPD_OFC_CD ELSE '' END) RHQ_OFC" ).append("\n"); 
		query.append("       ,MAX(CASE WHEN BB.CHG_DELT_PATH_CD = 'RHQ' AND TRIM(BB.CHG_DELT_STS_CD) IS NOT NULL THEN ( SELECT USR_NM FROM COM_USER WHERE USR_ID = BB.UPD_USR_ID ) ELSE '' END) RHQ_NM" ).append("\n"); 
		query.append("       --// HDO" ).append("\n"); 
		query.append("	   ,MAX(CASE WHEN BB.CHG_DELT_PATH_CD = 'HDO' AND TRIM(BB.CHG_DELT_STS_CD) IS NOT NULL THEN TO_CHAR(BB.UPD_DT,'YYYYMMDD') ELSE '' END) HDO_DT" ).append("\n"); 
		query.append("       ,MAX(CASE WHEN BB.CHG_DELT_PATH_CD = 'HDO' AND TRIM(BB.CHG_DELT_STS_CD) IS NOT NULL THEN BB.UPD_OFC_CD ELSE '' END) HDO_OFC" ).append("\n"); 
		query.append("       ,MAX(CASE WHEN BB.CHG_DELT_PATH_CD = 'HDO' AND TRIM(BB.CHG_DELT_STS_CD) IS NOT NULL THEN ( SELECT USR_NM FROM COM_USER WHERE USR_ID = BB.UPD_USR_ID ) ELSE '' END) HDO_NM" ).append("\n"); 
		query.append("       ,AA.INACTIV_INFO INACTIV_INFO" ).append("\n"); 
		query.append("       ,MAX(CASE WHEN AA.DMDT_DELT_RQST_STS_CD = 'R' AND @[tab_cd] = 'S' THEN 'N' ELSE AA.CHG_DELT_USR_YN END) CHG_DELT_USR_YN" ).append("\n"); 
		query.append("	   ,MAX(( SELECT ATTR_CTNT2 FROM DMT_HRD_CDG_CTNT WHERE HRD_CDG_ID = 'CHG_DELT_RSN_CD' AND ATTR_CTNT1 = CC.DMDT_CHG_DELT_RSN_CD AND ROWNUM = 1)) INACT_RSN" ).append("\n"); 
		query.append("	   ,MAX(( SELECT ATTR_CTNT4 FROM DMT_HRD_CDG_CTNT WHERE HRD_CDG_ID = 'CHG_DELT_RSN_CD' AND ATTR_CTNT3 = CC.DMDT_CHG_DELT_SPEC_RSN_CD AND ROWNUM = 1)) SPEC_RSN" ).append("\n"); 
		query.append("	   " ).append("\n"); 
		query.append("  FROM  (" ).append("\n"); 
		query.append("			SELECT  T1.INACT_RQST_NO" ).append("\n"); 
		query.append("                   ,T1.INACT_APRO_NO" ).append("\n"); 
		query.append("                   ,T1.DMDT_DELT_RQST_STS_CD" ).append("\n"); 
		query.append("                   ,(" ).append("\n"); 
		query.append("						SELECT  INTG_CD_VAL_DP_DESC " ).append("\n"); 
		query.append("						  FROM  COM_INTG_CD_DTL " ).append("\n"); 
		query.append("						 WHERE  INTG_CD_ID = 'CD03382' " ).append("\n"); 
		query.append("						   AND  INTG_CD_VAL_CTNT = T1.DMDT_DELT_RQST_STS_CD " ).append("\n"); 
		query.append("					) AS STS_CD" ).append("\n"); 
		query.append("                   ,T1.SYS_AREA_GRP_ID||'|'||T1.CNTR_NO||'|'||T1.CNTR_CYC_NO||'|'||T1.DMDT_TRF_CD||'|'||T1.DMDT_CHG_LOC_DIV_CD||'|'||T1.CHG_SEQ||'|'||T1.CHG_OFC_CD||'|'||T1.DELT_SEQ||'|' INACTIV_INFO" ).append("\n"); 
		query.append("        	       ,MAX((" ).append("\n"); 
		query.append("								" ).append("\n"); 
		query.append("							CASE " ).append("\n"); 
		query.append("								WHEN DECODE(@[chg_delt_path_cd], 'OOM', 1, 'BBG', 2, 'RHQ', 3, 'HDO', 4, 0) >= " ).append("\n"); 
		query.append("									(" ).append("\n"); 
		query.append("										SELECT  MAX(CHG_DELT_PATH_LVL)" ).append("\n"); 
		query.append("										  FROM  DMT_CHG_DELT_PATH" ).append("\n"); 
		query.append("										 WHERE  SYS_AREA_GRP_ID        = T1.SYS_AREA_GRP_ID" ).append("\n"); 
		query.append("										   AND  CNTR_NO                = T1.CNTR_NO" ).append("\n"); 
		query.append("										   AND  CNTR_CYC_NO            = T1.CNTR_CYC_NO" ).append("\n"); 
		query.append("										   AND  DMDT_TRF_CD            = T1.DMDT_TRF_CD" ).append("\n"); 
		query.append("										   AND  DMDT_CHG_LOC_DIV_CD    = T1.DMDT_CHG_LOC_DIV_CD" ).append("\n"); 
		query.append("										   AND  CHG_SEQ                = T1.CHG_SEQ" ).append("\n"); 
		query.append("										   AND  CHG_OFC_CD             = T1.CHG_OFC_CD" ).append("\n"); 
		query.append("										   AND  DELT_SEQ               = T1.DELT_SEQ" ).append("\n"); 
		query.append("										   AND  (CHG_DELT_PATH_CPLS_FLG = 'Y' OR CHG_DELT_STS_CD IN ('A', 'J'))" ).append("\n"); 
		query.append("										   AND  CHG_OFC_CD             = T4.OFC_N8TH_LVL_CD" ).append("\n"); 
		query.append("									) " ).append("\n"); 
		query.append("									THEN " ).append("\n"); 
		query.append("									(" ).append("\n"); 
		query.append("										CASE " ).append("\n"); 
		query.append("											WHEN @[chg_delt_path_cd] = 'RHQ' AND T1.RQST_OFC_CD IN ('ATLSC', 'CHISC', 'HOUSC', 'LGBSC', 'SFOBS', 'NYCSC', 'OREBS', 'PDXSO', 'SEASC', 'PHXSA') " ).append("\n"); 
		query.append("												THEN" ).append("\n"); 
		query.append("													CASE WHEN @[usr_id] IN ( SELECT ATTR_CTNT1 FROM DMT_HRD_CDG_CTNT WHERE HRD_CDG_ID = 'INACTIV_APPL_USER' ) THEN 'Y' ELSE 'N' END" ).append("\n"); 
		query.append("											ELSE 'Y'" ).append("\n"); 
		query.append("										END" ).append("\n"); 
		query.append("									)" ).append("\n"); 
		query.append("								ELSE" ).append("\n"); 
		query.append("									NVL((" ).append("\n"); 
		query.append("											SELECT  CASE" ).append("\n"); 
		query.append("														WHEN SYS_AREA_GRP_ID IS NOT NULL THEN" ).append("\n"); 
		query.append("															CASE " ).append("\n"); 
		query.append("																WHEN @[chg_delt_path_cd] = 'RHQ' AND T1.RQST_OFC_CD in ('ATLSC', 'CHISC', 'HOUSC', 'LGBSC', 'SFOBS', 'NYCSC', 'OREBS', 'PDXSO', 'SEASC', 'PHXSA') THEN" ).append("\n"); 
		query.append("																	CASE WHEN @[usr_id] in ( SELECT ATTR_CTNT1 FROM DMT_HRD_CDG_CTNT WHERE HRD_CDG_ID = 'INACTIV_APPL_USER' ) THEN 'Y' ELSE 'N' END" ).append("\n"); 
		query.append("																ELSE" ).append("\n"); 
		query.append("																	'Y'" ).append("\n"); 
		query.append("															END								" ).append("\n"); 
		query.append("														ELSE" ).append("\n"); 
		query.append("															'N'" ).append("\n"); 
		query.append("													END" ).append("\n"); 
		query.append("											  FROM  DMT_CHG_DELT_PATH" ).append("\n"); 
		query.append("											 WHERE  SYS_AREA_GRP_ID        = T1.SYS_AREA_GRP_ID" ).append("\n"); 
		query.append("											   AND  CNTR_NO                = T1.CNTR_NO" ).append("\n"); 
		query.append("											   AND  CNTR_CYC_NO            = T1.CNTR_CYC_NO" ).append("\n"); 
		query.append("											   AND  DMDT_TRF_CD            = T1.DMDT_TRF_CD" ).append("\n"); 
		query.append("											   AND  DMDT_CHG_LOC_DIV_CD    = T1.DMDT_CHG_LOC_DIV_CD" ).append("\n"); 
		query.append("											   AND  CHG_SEQ                = T1.CHG_SEQ" ).append("\n"); 
		query.append("											   AND  CHG_OFC_CD             = T1.CHG_OFC_CD" ).append("\n"); 
		query.append("											   AND  DELT_SEQ               = T1.DELT_SEQ" ).append("\n"); 
		query.append("											   AND  CHG_DELT_PATH_CD       = @[chg_delt_path_cd]" ).append("\n"); 
		query.append("											   AND  CHG_DELT_PATH_LVL     >= DECODE(T1.DMDT_DELT_RQST_STS_CD, 'R', 1, 'O', 1, 'P', 1, 'B', 2, 'E', 2, 'Q', 3, 'F', 3, 'H', 4, 'G', 4, 0)" ).append("\n"); 
		query.append("											   AND  CHG_DELT_PATH_CPLS_FLG = 'Y'" ).append("\n"); 
		query.append("											   AND  CHG_OFC_CD             = T4.OFC_N8TH_LVL_CD" ).append("\n"); 
		query.append("											   AND  ROWNUM                 = 1" ).append("\n"); 
		query.append("									),'N')" ).append("\n"); 
		query.append("							END" ).append("\n"); 
		query.append("					))													AS CHG_DELT_USR_YN		--// Charge Deletion ?붿껌????빐 ?뱀씤沅뚰븳?먯씤吏??щ?瑜??섑??몃떎." ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	               #if (${group_by} == 'BKG' )" ).append("\n"); 
		query.append("                   ,T3.BKG_NO" ).append("\n"); 
		query.append("	               #elseif (${group_by} == 'CNTR' )" ).append("\n"); 
		query.append("                   ,T3.CNTR_NO" ).append("\n"); 
		query.append("	               #end" ).append("\n"); 
		query.append("				   " ).append("\n"); 
		query.append("			  FROM  DMT_CHG_DELT_RQST_APRO 	T1" ).append("\n"); 
		query.append("		           ,DMT_CHG_BKG_CNTR 		T3" ).append("\n"); 
		query.append("		           ,(" ).append("\n"); 
		query.append("						SELECT  /*+NO_MERGE*/ OFC_N8TH_LVL_CD " ).append("\n"); 
		query.append("						  FROM  DMT_OFC_LVL_V  " ).append("\n"); 
		query.append("						 WHERE  DECODE(@[usr_ofc_cd], 'SELCON', 'SELHO', SUBSTR(@[usr_ofc_cd], 1, 5)) IN " ).append("\n"); 
		query.append("								( OFC_N1ST_LVL_CD, OFC_N2ND_LVL_CD, OFC_N3RD_LVL_CD, OFC_N4TH_LVL_CD, OFC_N5TH_LVL_CD ) " ).append("\n"); 
		query.append("					) T4 " ).append("\n"); 
		query.append("					" ).append("\n"); 
		query.append("			 WHERE  1 = 1" ).append("\n"); 
		query.append("               AND  T1.INACT_RQST_NO IS NULL" ).append("\n"); 
		query.append("		       AND  T1.SYS_AREA_GRP_ID = T3.SYS_AREA_GRP_ID" ).append("\n"); 
		query.append("               AND  T1.CNTR_NO = T3.CNTR_NO" ).append("\n"); 
		query.append("               AND  T1.CNTR_CYC_NO = T3.CNTR_CYC_NO" ).append("\n"); 
		query.append("			   " ).append("\n"); 
		query.append("			   #if (${inact_no} == '' && ${apvl_no} == '' && ${bkg_no} == '' && ${bl_no} == '')" ).append("\n"); 
		query.append("				#if (${dt_tp} == 'R')" ).append("\n"); 
		query.append("               AND T1.RQST_DT BETWEEN TO_DATE(REPLACE(@[fm_dt],'-',''),'YYYYMMDD') AND TO_DATE(REPLACE(@[to_dt],'-',''),'YYYYMMDD') + 0.99999" ).append("\n"); 
		query.append("				#else" ).append("\n"); 
		query.append("               AND T1.UPD_DT BETWEEN TO_DATE(REPLACE(@[fm_dt],'-',''),'YYYYMMDD') AND TO_DATE(REPLACE(@[to_dt],'-',''),'YYYYMMDD') + 0.99999" ).append("\n"); 
		query.append("				#end" ).append("\n"); 
		query.append("	           #end" ).append("\n"); 
		query.append("			   " ).append("\n"); 
		query.append("			   #if (${inact_sts_cd} != '')" ).append("\n"); 
		query.append("               AND  T1.DMDT_DELT_RQST_STS_CD IN (" ).append("\n"); 
		query.append("			   		#foreach( $inact_sts_cd in ${inact_sts_cd_list} )" ).append("\n"); 
		query.append("			   			#if($velocityCount < $inact_sts_cd_list.size()) '$inact_sts_cd', #else '$inact_sts_cd' #end" ).append("\n"); 
		query.append("			   		#end" ).append("\n"); 
		query.append("			   		)" ).append("\n"); 
		query.append("			   #end" ).append("\n"); 
		query.append("			   " ).append("\n"); 
		query.append("			   #if (${ofc_cd} != '')" ).append("\n"); 
		query.append("               AND  T1.CHG_OFC_CD IN (" ).append("\n"); 
		query.append("					#foreach( $ofc_cd in ${ofc_cd_list} )" ).append("\n"); 
		query.append("						#if($velocityCount < $ofc_cd_list.size()) '$ofc_cd', #else '$ofc_cd' #end" ).append("\n"); 
		query.append("					#end" ).append("\n"); 
		query.append("					)" ).append("\n"); 
		query.append("			   #end" ).append("\n"); 
		query.append("			   " ).append("\n"); 
		query.append("			   #if (${trf_cd} != '')" ).append("\n"); 
		query.append("               AND  T1.DMDT_TRF_CD IN (" ).append("\n"); 
		query.append("					#foreach( $trf_cd in ${trf_cd_list} )" ).append("\n"); 
		query.append("						#if($velocityCount < $trf_cd_list.size()) '$trf_cd', #else '$trf_cd' #end" ).append("\n"); 
		query.append("					#end" ).append("\n"); 
		query.append("					)" ).append("\n"); 
		query.append("			   #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("			   #if (${inact_no} != '')" ).append("\n"); 
		query.append("               AND  T1.INACT_RQST_NO IN (" ).append("\n"); 
		query.append("					#foreach( $inact_no in ${inact_no_list} )" ).append("\n"); 
		query.append("						#if($velocityCount < $inact_no_list.size()) '$inact_no', #else '$inact_no' #end" ).append("\n"); 
		query.append("					#end" ).append("\n"); 
		query.append("					)" ).append("\n"); 
		query.append("			   #end" ).append("\n"); 
		query.append("	" ).append("\n"); 
		query.append("			   #if (${apvl_no} != '')" ).append("\n"); 
		query.append("               AND  T1.INACT_APRO_NO IN (" ).append("\n"); 
		query.append("					#foreach( $apvl_no in ${apvl_no_list} )" ).append("\n"); 
		query.append("						#if($velocityCount < $apvl_no_list.size()) '$apvl_no', #else '$apvl_no' #end" ).append("\n"); 
		query.append("					#end" ).append("\n"); 
		query.append("					)" ).append("\n"); 
		query.append("               #end" ).append("\n"); 
		query.append("	" ).append("\n"); 
		query.append("			   #if (${bkg_no} != '')" ).append("\n"); 
		query.append("               AND  T3.BKG_NO IN (" ).append("\n"); 
		query.append("					#foreach( $bkg_no in ${bkg_no_list} )" ).append("\n"); 
		query.append("						#if($velocityCount < $bkg_no_list.size()) '$bkg_no', #else '$bkg_no' #end" ).append("\n"); 
		query.append("					#end" ).append("\n"); 
		query.append("					)" ).append("\n"); 
		query.append("               #end" ).append("\n"); 
		query.append("	" ).append("\n"); 
		query.append("			   #if (${bl_no} != '')" ).append("\n"); 
		query.append("               AND T3.BL_NO IN (" ).append("\n"); 
		query.append("					#foreach( $bl_no in ${bl_no_list} )" ).append("\n"); 
		query.append("						#if($velocityCount < $bl_no_list.size()) '$bl_no', #else '$bl_no' #end" ).append("\n"); 
		query.append("					#end" ).append("\n"); 
		query.append("					)" ).append("\n"); 
		query.append("			   #end" ).append("\n"); 
		query.append("			   " ).append("\n"); 
		query.append("			   #if (${inact_rsn_cd} != '' )" ).append("\n"); 
		query.append("               AND  T1.DMDT_CHG_DELT_RSN_CD IN (" ).append("\n"); 
		query.append("					#foreach( $inact_rsn_cd in ${inact_rsn_cd_list} )" ).append("\n"); 
		query.append("						#if($velocityCount < $inact_rsn_cd_list.size()) '$inact_rsn_cd', #else '$inact_rsn_cd' #end" ).append("\n"); 
		query.append("					#end" ).append("\n"); 
		query.append("					)" ).append("\n"); 
		query.append("			   #end" ).append("\n"); 
		query.append("	" ).append("\n"); 
		query.append("			   #if (${spec_rsn_cd} != '' )" ).append("\n"); 
		query.append("               AND  T1.DMDT_CHG_DELT_SPEC_RSN_CD IN (" ).append("\n"); 
		query.append("					#foreach( $spec_rsn_cd in ${spec_rsn_cd_list} )" ).append("\n"); 
		query.append("						#if($velocityCount < $spec_rsn_cd_list.size()) '$spec_rsn_cd', #else '$spec_rsn_cd' #end" ).append("\n"); 
		query.append("					#end" ).append("\n"); 
		query.append("					)" ).append("\n"); 
		query.append("			   #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("			GROUP BY T1.INACT_RQST_NO" ).append("\n"); 
		query.append("                    ,T1.INACT_APRO_NO" ).append("\n"); 
		query.append("                    ,T1.DMDT_DELT_RQST_STS_CD" ).append("\n"); 
		query.append("                    ,T1.DMDT_DELT_RQST_STS_CD" ).append("\n"); 
		query.append("                    ,T1.SYS_AREA_GRP_ID" ).append("\n"); 
		query.append("                    ,T1.CNTR_NO" ).append("\n"); 
		query.append("                    ,T1.CNTR_CYC_NO" ).append("\n"); 
		query.append("                    ,T1.DMDT_TRF_CD" ).append("\n"); 
		query.append("                    ,T1.DMDT_CHG_LOC_DIV_CD" ).append("\n"); 
		query.append("                    ,T1.CHG_SEQ" ).append("\n"); 
		query.append("                    ,T1.CHG_OFC_CD" ).append("\n"); 
		query.append("                    ,T1.DELT_SEQ" ).append("\n"); 
		query.append("				    #if (${group_by} == 'BKG' )" ).append("\n"); 
		query.append("                    ,T3.BKG_NO" ).append("\n"); 
		query.append("					#elseif (${group_by} == 'CNTR' )" ).append("\n"); 
		query.append("                    ,T3.CNTR_NO" ).append("\n"); 
		query.append("					#end" ).append("\n"); 
		query.append("             " ).append("\n"); 
		query.append("        UNION ALL" ).append("\n"); 
		query.append("        " ).append("\n"); 
		query.append("			SELECT  T1.INACT_RQST_NO" ).append("\n"); 
		query.append("				   ,T1.INACT_APRO_NO" ).append("\n"); 
		query.append("                   ,T1.DMDT_DELT_RQST_STS_CD" ).append("\n"); 
		query.append("                   ,( " ).append("\n"); 
		query.append("						SELECT  INTG_CD_VAL_DP_DESC " ).append("\n"); 
		query.append("						  FROM  COM_INTG_CD_DTL " ).append("\n"); 
		query.append("						 WHERE  INTG_CD_ID = 'CD03382' " ).append("\n"); 
		query.append("						   AND  INTG_CD_VAL_CTNT = T1.DMDT_DELT_RQST_STS_CD " ).append("\n"); 
		query.append("					) AS STS_CD" ).append("\n"); 
		query.append("                   ,MAX(T1.SYS_AREA_GRP_ID||'|'||T1.CNTR_NO||'|'||T1.CNTR_CYC_NO||'|'||T1.DMDT_TRF_CD||'|'||T1.DMDT_CHG_LOC_DIV_CD||'|'||T1.CHG_SEQ||'|'||T1.CHG_OFC_CD||'|'||T1.DELT_SEQ)||'|' INACTIV_INFO" ).append("\n"); 
		query.append("                   ,MAX((CASE" ).append("\n"); 
		query.append("                            WHEN DECODE(@[chg_delt_path_cd], 'OOM', 1, 'BBG', 2, 'RHQ', 3, 'HDO', 4, 0) >= " ).append("\n"); 
		query.append("								(" ).append("\n"); 
		query.append("									SELECT  MAX(CHG_DELT_PATH_LVL)" ).append("\n"); 
		query.append("									  FROM  DMT_CHG_DELT_PATH" ).append("\n"); 
		query.append("									 WHERE  SYS_AREA_GRP_ID        = T1.SYS_AREA_GRP_ID" ).append("\n"); 
		query.append("									   AND  CNTR_NO                = T1.CNTR_NO" ).append("\n"); 
		query.append("									   AND  CNTR_CYC_NO            = T1.CNTR_CYC_NO" ).append("\n"); 
		query.append("									   AND  DMDT_TRF_CD            = T1.DMDT_TRF_CD" ).append("\n"); 
		query.append("									   AND  DMDT_CHG_LOC_DIV_CD    = T1.DMDT_CHG_LOC_DIV_CD" ).append("\n"); 
		query.append("									   AND  CHG_SEQ                = T1.CHG_SEQ" ).append("\n"); 
		query.append("									   AND  CHG_OFC_CD             = T1.CHG_OFC_CD" ).append("\n"); 
		query.append("									   AND  DELT_SEQ               = T1.DELT_SEQ" ).append("\n"); 
		query.append("									   AND  (CHG_DELT_PATH_CPLS_FLG = 'Y' OR CHG_DELT_STS_CD IN ('A', 'J'))" ).append("\n"); 
		query.append("									   AND  CHG_OFC_CD             =  T4.OFC_N8TH_LVL_CD" ).append("\n"); 
		query.append("								) " ).append("\n"); 
		query.append("								 THEN " ).append("\n"); 
		query.append("								 (" ).append("\n"); 
		query.append("									CASE " ).append("\n"); 
		query.append("										WHEN @[chg_delt_path_cd] = 'RHQ' AND T1.RQST_OFC_CD IN ('ATLSC', 'CHISC', 'HOUSC', 'LGBSC', 'SFOBS', 'NYCSC', 'OREBS', 'PDXSO', 'SEASC', 'PHXSA') THEN" ).append("\n"); 
		query.append("											CASE WHEN @[usr_id] IN ( SELECT ATTR_CTNT1 FROM DMT_HRD_CDG_CTNT WHERE HRD_CDG_ID = 'INACTIV_APPL_USER' ) THEN 'Y' ELSE 'N' END" ).append("\n"); 
		query.append("										ELSE" ).append("\n"); 
		query.append("											'Y'" ).append("\n"); 
		query.append("									END" ).append("\n"); 
		query.append("								 )" ).append("\n"); 
		query.append("							ELSE" ).append("\n"); 
		query.append("								NVL((" ).append("\n"); 
		query.append("									SELECT  CASE" ).append("\n"); 
		query.append("												WHEN SYS_AREA_GRP_ID IS NOT NULL THEN" ).append("\n"); 
		query.append("													CASE " ).append("\n"); 
		query.append("														WHEN @[chg_delt_path_cd] = 'RHQ' AND T1.RQST_OFC_CD IN ('ATLSC', 'CHISC', 'HOUSC', 'LGBSC', 'SFOBS', 'NYCSC', 'OREBS', 'PDXSO', 'SEASC', 'PHXSA') THEN" ).append("\n"); 
		query.append("															CASE " ).append("\n"); 
		query.append("																WHEN @[usr_id] IN ( SELECT ATTR_CTNT1 FROM DMT_HRD_CDG_CTNT WHERE HRD_CDG_ID = 'INACTIV_APPL_USER' ) THEN 'Y' ELSE 'N' " ).append("\n"); 
		query.append("															END" ).append("\n"); 
		query.append("														ELSE" ).append("\n"); 
		query.append("															'Y'" ).append("\n"); 
		query.append("													END								" ).append("\n"); 
		query.append("												ELSE" ).append("\n"); 
		query.append("													'N'" ).append("\n"); 
		query.append("											END" ).append("\n"); 
		query.append("									  FROM  DMT_CHG_DELT_PATH" ).append("\n"); 
		query.append("									 WHERE  SYS_AREA_GRP_ID        = T1.SYS_AREA_GRP_ID" ).append("\n"); 
		query.append("									   AND  CNTR_NO                = T1.CNTR_NO" ).append("\n"); 
		query.append("									   AND  CNTR_CYC_NO            = T1.CNTR_CYC_NO" ).append("\n"); 
		query.append("									   AND  DMDT_TRF_CD            = T1.DMDT_TRF_CD" ).append("\n"); 
		query.append("									   AND  DMDT_CHG_LOC_DIV_CD    = T1.DMDT_CHG_LOC_DIV_CD" ).append("\n"); 
		query.append("									   AND  CHG_SEQ                = T1.CHG_SEQ" ).append("\n"); 
		query.append("									   AND  CHG_OFC_CD             = T1.CHG_OFC_CD" ).append("\n"); 
		query.append("									   AND  DELT_SEQ               = T1.DELT_SEQ" ).append("\n"); 
		query.append("									   AND  CHG_DELT_PATH_CD       = @[chg_delt_path_cd]" ).append("\n"); 
		query.append("									   AND  CHG_DELT_PATH_LVL     >= DECODE(T1.DMDT_DELT_RQST_STS_CD, 'R', 1, 'O', 1, 'P', 1, 'B', 2, 'E', 2, 'Q', 3, 'F', 3, 'H', 4, 'G', 4, 0)" ).append("\n"); 
		query.append("									   AND  CHG_DELT_PATH_CPLS_FLG = 'Y'" ).append("\n"); 
		query.append("									   AND  CHG_OFC_CD =  T4.OFC_N8TH_LVL_CD" ).append("\n"); 
		query.append("									   AND  ROWNUM = 1" ).append("\n"); 
		query.append("								), 'N')" ).append("\n"); 
		query.append("					END))													AS CHG_DELT_USR_YN		--// Charge Deletion ?붿껌????빐 ?뱀씤沅뚰븳?먯씤吏??щ?瑜??섑??몃떎." ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("				   #if (${group_by} == 'BKG' )" ).append("\n"); 
		query.append("				   ,T3.BKG_NO" ).append("\n"); 
		query.append("				   #elseif (${group_by} == 'CNTR' )" ).append("\n"); 
		query.append("				   ,T3.CNTR_NO" ).append("\n"); 
		query.append("				   #end" ).append("\n"); 
		query.append("				   " ).append("\n"); 
		query.append("			  FROM  DMT_CHG_DELT_RQST_APRO T1" ).append("\n"); 
		query.append("				   ,DMT_CHG_BKG_CNTR T3" ).append("\n"); 
		query.append("				   ,( " ).append("\n"); 
		query.append("						SELECT  /*+NO_MERGE*/ OFC_N8TH_LVL_CD " ).append("\n"); 
		query.append("						  FROM  DMT_OFC_LVL_V  " ).append("\n"); 
		query.append("						 WHERE  DECODE(@[usr_ofc_cd], 'SELCON', 'SELHO', SUBSTR(@[usr_ofc_cd] ,1,5)) IN " ).append("\n"); 
		query.append("								(OFC_N1ST_LVL_CD, OFC_N2ND_LVL_CD, OFC_N3RD_LVL_CD, OFC_N4TH_LVL_CD, OFC_N5TH_LVL_CD) " ).append("\n"); 
		query.append("					) T4 " ).append("\n"); 
		query.append("					" ).append("\n"); 
		query.append("			 WHERE  1 = 1" ).append("\n"); 
		query.append("               AND  T1.INACT_RQST_NO IS NOT NULL" ).append("\n"); 
		query.append("			   AND  T1.SYS_AREA_GRP_ID = T3.SYS_AREA_GRP_ID" ).append("\n"); 
		query.append("			   AND  T1.CNTR_NO         = T3.CNTR_NO" ).append("\n"); 
		query.append("			   AND  T1.CNTR_CYC_NO     = T3.CNTR_CYC_NO" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("			   #if (${inact_no} == '' && ${apvl_no} == '' && ${bkg_no} == '' && ${bl_no} == '')" ).append("\n"); 
		query.append("				#if (${dt_tp} == 'R')" ).append("\n"); 
		query.append("               AND T1.RQST_DT BETWEEN TO_DATE(REPLACE(@[fm_dt],'-',''),'YYYYMMDD') AND TO_DATE(REPLACE(@[to_dt],'-',''),'YYYYMMDD') + 0.99999" ).append("\n"); 
		query.append("				#else" ).append("\n"); 
		query.append("               AND T1.UPD_DT BETWEEN TO_DATE(REPLACE(@[fm_dt],'-',''),'YYYYMMDD') AND TO_DATE(REPLACE(@[to_dt],'-',''),'YYYYMMDD') + 0.99999" ).append("\n"); 
		query.append("				#end" ).append("\n"); 
		query.append("	           #end			   " ).append("\n"); 
		query.append("			   " ).append("\n"); 
		query.append("			   #if (${inact_sts_cd} != '')" ).append("\n"); 
		query.append("               AND  T1.DMDT_DELT_RQST_STS_CD IN (" ).append("\n"); 
		query.append("			   		#foreach( $inact_sts_cd in ${inact_sts_cd_list} )" ).append("\n"); 
		query.append("			   			#if($velocityCount < $inact_sts_cd_list.size()) '$inact_sts_cd', #else '$inact_sts_cd' #end" ).append("\n"); 
		query.append("			   		#end" ).append("\n"); 
		query.append("			   		)" ).append("\n"); 
		query.append("			   #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("			   #if (${ofc_cd} != '')" ).append("\n"); 
		query.append("               AND  T1.CHG_OFC_CD IN (" ).append("\n"); 
		query.append("					#foreach( $ofc_cd in ${ofc_cd_list} )" ).append("\n"); 
		query.append("						#if($velocityCount < $ofc_cd_list.size()) '$ofc_cd', #else '$ofc_cd' #end" ).append("\n"); 
		query.append("					#end" ).append("\n"); 
		query.append("					)" ).append("\n"); 
		query.append("			   #end" ).append("\n"); 
		query.append("			   " ).append("\n"); 
		query.append("			   #if (${trf_cd} != '')" ).append("\n"); 
		query.append("               AND  T1.DMDT_TRF_CD IN (" ).append("\n"); 
		query.append("					#foreach( $trf_cd in ${trf_cd_list} )" ).append("\n"); 
		query.append("						#if($velocityCount < $trf_cd_list.size()) '$trf_cd', #else '$trf_cd' #end" ).append("\n"); 
		query.append("					#end" ).append("\n"); 
		query.append("					)" ).append("\n"); 
		query.append("			   #end" ).append("\n"); 
		query.append("			   " ).append("\n"); 
		query.append("			   #if (${inact_no} != '')" ).append("\n"); 
		query.append("               AND  T1.INACT_RQST_NO IN (" ).append("\n"); 
		query.append("					#foreach( $inact_no in ${inact_no_list} )" ).append("\n"); 
		query.append("						#if($velocityCount < $inact_no_list.size()) '$inact_no', #else '$inact_no' #end" ).append("\n"); 
		query.append("					#end" ).append("\n"); 
		query.append("					)" ).append("\n"); 
		query.append("			   #end" ).append("\n"); 
		query.append("	" ).append("\n"); 
		query.append("			   #if (${apvl_no} != '')" ).append("\n"); 
		query.append("               AND  T1.INACT_APRO_NO IN (" ).append("\n"); 
		query.append("					#foreach( $apvl_no in ${apvl_no_list} )" ).append("\n"); 
		query.append("						#if($velocityCount < $apvl_no_list.size()) '$apvl_no', #else '$apvl_no' #end" ).append("\n"); 
		query.append("					#end" ).append("\n"); 
		query.append("					)" ).append("\n"); 
		query.append("               #end" ).append("\n"); 
		query.append("	" ).append("\n"); 
		query.append("			   #if (${bkg_no} != '')" ).append("\n"); 
		query.append("               AND  T3.BKG_NO IN (" ).append("\n"); 
		query.append("					#foreach( $bkg_no in ${bkg_no_list} )" ).append("\n"); 
		query.append("						#if($velocityCount < $bkg_no_list.size()) '$bkg_no', #else '$bkg_no' #end" ).append("\n"); 
		query.append("					#end" ).append("\n"); 
		query.append("					)" ).append("\n"); 
		query.append("               #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("			   #if (${bl_no} != '')" ).append("\n"); 
		query.append("               AND T3.BL_NO IN (" ).append("\n"); 
		query.append("					#foreach( $bl_no in ${bl_no_list} )" ).append("\n"); 
		query.append("						#if($velocityCount < $bl_no_list.size()) '$bl_no', #else '$bl_no' #end" ).append("\n"); 
		query.append("					#end" ).append("\n"); 
		query.append("					)" ).append("\n"); 
		query.append("			   #end" ).append("\n"); 
		query.append("			   " ).append("\n"); 
		query.append("			   #if (${inact_rsn_cd} != '' )" ).append("\n"); 
		query.append("               AND  T1.DMDT_CHG_DELT_RSN_CD IN (" ).append("\n"); 
		query.append("					#foreach( $inact_rsn_cd in ${inact_rsn_cd_list} )" ).append("\n"); 
		query.append("						#if($velocityCount < $inact_rsn_cd_list.size()) '$inact_rsn_cd', #else '$inact_rsn_cd' #end" ).append("\n"); 
		query.append("					#end" ).append("\n"); 
		query.append("					)" ).append("\n"); 
		query.append("			   #end" ).append("\n"); 
		query.append("	" ).append("\n"); 
		query.append("			   #if (${spec_rsn_cd} != '' )" ).append("\n"); 
		query.append("               AND  T1.DMDT_CHG_DELT_SPEC_RSN_CD IN (" ).append("\n"); 
		query.append("					#foreach( $spec_rsn_cd in ${spec_rsn_cd_list} )" ).append("\n"); 
		query.append("						#if($velocityCount < $spec_rsn_cd_list.size()) '$spec_rsn_cd', #else '$spec_rsn_cd' #end" ).append("\n"); 
		query.append("					#end" ).append("\n"); 
		query.append("					)" ).append("\n"); 
		query.append("			   #end" ).append("\n"); 
		query.append("			   " ).append("\n"); 
		query.append("			GROUP BY T1.INACT_RQST_NO" ).append("\n"); 
		query.append("                    ,T1.INACT_APRO_NO" ).append("\n"); 
		query.append("                    ,T1.DMDT_DELT_RQST_STS_CD" ).append("\n"); 
		query.append("                    ,T1.DMDT_DELT_RQST_STS_CD " ).append("\n"); 
		query.append("					#if (${group_by} == 'BKG' )" ).append("\n"); 
		query.append("                    ,T3.BKG_NO" ).append("\n"); 
		query.append("					#elseif (${group_by} == 'CNTR' )" ).append("\n"); 
		query.append("                    ,T3.CNTR_NO" ).append("\n"); 
		query.append("					#end" ).append("\n"); 
		query.append("		) 						AA" ).append("\n"); 
		query.append("       ,DMT_CHG_DELT_RQST_APRO 	CC" ).append("\n"); 
		query.append("       ,DMT_CHG_DELT_PATH 		BB" ).append("\n"); 
		query.append("	   " ).append("\n"); 
		query.append(" WHERE  1 = 1" ).append("\n"); 
		query.append("   AND  AA.DMDT_DELT_RQST_STS_CD IS NOT NULL" ).append("\n"); 
		query.append("   AND  SUBSTR(AA.INACTIV_INFO,0,INSTR(AA.INACTIV_INFO,'|',1,1)-1) = CC.SYS_AREA_GRP_ID" ).append("\n"); 
		query.append("   AND  SUBSTR(AA.INACTIV_INFO,INSTR(AA.INACTIV_INFO,'|',1,1)+1,INSTR(AA.INACTIV_INFO,'|',1,2)-INSTR(AA.INACTIV_INFO,'|',1,1)-1) = CC.CNTR_NO" ).append("\n"); 
		query.append("   AND  SUBSTR(AA.INACTIV_INFO,INSTR(AA.INACTIV_INFO,'|',1,2)+1,INSTR(AA.INACTIV_INFO,'|',1,3)-INSTR(AA.INACTIV_INFO,'|',1,2)-1) = CC.CNTR_CYC_NO" ).append("\n"); 
		query.append("   AND  SUBSTR(AA.INACTIV_INFO,INSTR(AA.INACTIV_INFO,'|',1,3)+1,INSTR(AA.INACTIV_INFO,'|',1,4)-INSTR(AA.INACTIV_INFO,'|',1,3)-1) = CC.DMDT_TRF_CD" ).append("\n"); 
		query.append("   AND  SUBSTR(AA.INACTIV_INFO,INSTR(AA.INACTIV_INFO,'|',1,4)+1,INSTR(AA.INACTIV_INFO,'|',1,5)-INSTR(AA.INACTIV_INFO,'|',1,4)-1) = CC.DMDT_CHG_LOC_DIV_CD" ).append("\n"); 
		query.append("   AND  SUBSTR(AA.INACTIV_INFO,INSTR(AA.INACTIV_INFO,'|',1,5)+1,INSTR(AA.INACTIV_INFO,'|',1,6)-INSTR(AA.INACTIV_INFO,'|',1,5)-1) = CC.CHG_SEQ" ).append("\n"); 
		query.append("   AND  SUBSTR(AA.INACTIV_INFO,INSTR(AA.INACTIV_INFO,'|',1,6)+1,INSTR(AA.INACTIV_INFO,'|',1,7)-INSTR(AA.INACTIV_INFO,'|',1,6)-1) = CC.CHG_OFC_CD" ).append("\n"); 
		query.append("   AND  SUBSTR(AA.INACTIV_INFO,INSTR(AA.INACTIV_INFO,'|',1,7)+1,INSTR(AA.INACTIV_INFO,'|',1,8)-INSTR(AA.INACTIV_INFO,'|',1,7)-1) = CC.DELT_SEQ" ).append("\n"); 
		query.append("   AND  BB.SYS_AREA_GRP_ID(+)     = CC.SYS_AREA_GRP_ID" ).append("\n"); 
		query.append("   AND  BB.CNTR_NO(+)             = CC.CNTR_NO" ).append("\n"); 
		query.append("   AND  BB.CNTR_CYC_NO(+)         = CC.CNTR_CYC_NO" ).append("\n"); 
		query.append("   AND  BB.DMDT_TRF_CD(+)         = CC.DMDT_TRF_CD" ).append("\n"); 
		query.append("   AND  BB.DMDT_CHG_LOC_DIV_CD(+) = CC.DMDT_CHG_LOC_DIV_CD" ).append("\n"); 
		query.append("   AND  BB.CHG_SEQ(+)             = CC.CHG_SEQ" ).append("\n"); 
		query.append("   AND  BB.CHG_OFC_CD(+)          = CC.CHG_OFC_CD" ).append("\n"); 
		query.append("   AND  BB.DELT_SEQ(+)            = CC.DELT_SEQ" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${tab_cd} == 'P' )" ).append("\n"); 
		query.append("   AND  (" ).append("\n"); 
		query.append("			(" ).append("\n"); 
		query.append("					 CHG_DELT_USR_YN           = 'Y' " ).append("\n"); 
		query.append("				AND  AA.DMDT_DELT_RQST_STS_CD != 'C'" ).append("\n"); 
		query.append("				AND  ( " ).append("\n"); 
		query.append("						SELECT  MIN(CHG_DELT_PATH_LVL) " ).append("\n"); 
		query.append("						  FROM  DMT_CHG_DELT_PATH T2" ).append("\n"); 
		query.append("						 WHERE  1 = 1" ).append("\n"); 
		query.append("						   AND  BB.SYS_AREA_GRP_ID        = T2.SYS_AREA_GRP_ID" ).append("\n"); 
		query.append("						   AND  BB.CNTR_NO                = T2.CNTR_NO" ).append("\n"); 
		query.append("						   AND  BB.CNTR_CYC_NO            = T2.CNTR_CYC_NO" ).append("\n"); 
		query.append("						   AND  BB.DMDT_TRF_CD            = T2.DMDT_TRF_CD" ).append("\n"); 
		query.append("						   AND  BB.DMDT_CHG_LOC_DIV_CD    = T2.DMDT_CHG_LOC_DIV_CD" ).append("\n"); 
		query.append("						   AND  BB.CHG_SEQ                = T2.CHG_SEQ" ).append("\n"); 
		query.append("						   AND  BB.CHG_OFC_CD             = T2.CHG_OFC_CD" ).append("\n"); 
		query.append("						   AND  BB.DELT_SEQ               = T2.DELT_SEQ" ).append("\n"); 
		query.append("						   AND  T2.CHG_DELT_PATH_CPLS_FLG = 'Y'" ).append("\n"); 
		query.append("						   AND  T2.CHG_DELT_STS_CD       != 'A' " ).append("\n"); 
		query.append("					 ) = CASE @[chg_delt_path_cd] " ).append("\n"); 
		query.append("							WHEN 'HDO' THEN 4" ).append("\n"); 
		query.append("							WHEN 'RHQ' THEN 3" ).append("\n"); 
		query.append("							WHEN 'BBG' THEN 2" ).append("\n"); 
		query.append("							WHEN 'OOM' THEN 1" ).append("\n"); 
		query.append("							ELSE 0 " ).append("\n"); 
		query.append("						 END " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("				AND  SUBSTR(INACTIV_INFO,INSTR(INACTIV_INFO,'|',1,6)+1,INSTR(INACTIV_INFO,'|',1,7)-INSTR(INACTIV_INFO,'|',1,6)-1) IN " ).append("\n"); 
		query.append("					 ( " ).append("\n"); 
		query.append("						SELECT  OFC_N8TH_LVL_CD " ).append("\n"); 
		query.append("						  FROM  DMT_OFC_LVL_V " ).append("\n"); 
		query.append("						 WHERE  DECODE(@[usr_ofc_cd], 'SELCON', 'SELHO', SUBSTR(@[usr_ofc_cd], 1, 5)) IN " ).append("\n"); 
		query.append("								(OFC_N1ST_LVL_CD, OFC_N2ND_LVL_CD, OFC_N3RD_LVL_CD, OFC_N4TH_LVL_CD, OFC_N5TH_LVL_CD)" ).append("\n"); 
		query.append("					 )" ).append("\n"); 
		query.append("                AND  AA.DMDT_DELT_RQST_STS_CD NOT IN ('P', 'E', 'F', 'G')" ).append("\n"); 
		query.append("			)" ).append("\n"); 
		query.append("         OR ( " ).append("\n"); 
		query.append("				( 	@[chg_delt_path_cd] IS NULL " ).append("\n"); 
		query.append("				OR  ( " ).append("\n"); 
		query.append("						CASE " ).append("\n"); 
		query.append("							WHEN @[chg_delt_path_cd] = 'RHQ' AND CC.RQST_OFC_CD IN ('ATLSC', 'CHISC', 'HOUSC', 'LGBSC', 'SFOBS', 'NYCSC', 'OREBS', 'PDXSO', 'SEASC', 'PHXSA') " ).append("\n"); 
		query.append("								THEN" ).append("\n"); 
		query.append("									CASE " ).append("\n"); 
		query.append("										WHEN @[usr_id] IN ( SELECT ATTR_CTNT1 FROM DMT_HRD_CDG_CTNT WHERE HRD_CDG_ID = 'INACTIV_APPL_USER' ) THEN 'Y' ELSE 'N' " ).append("\n"); 
		query.append("									END" ).append("\n"); 
		query.append("							ELSE 'Y' " ).append("\n"); 
		query.append("						END " ).append("\n"); 
		query.append("					) = 'N' )" ).append("\n"); 
		query.append("				AND  AA.DMDT_DELT_RQST_STS_CD = 'R'" ).append("\n"); 
		query.append("				AND  SUBSTR(INACTIV_INFO,INSTR(INACTIV_INFO,'|',1,6)+1,INSTR(INACTIV_INFO,'|',1,7)-INSTR(INACTIV_INFO,'|',1,6)-1) = DECODE(@[usr_ofc_cd], 'SELCON', 'SELHO', SUBSTR(@[usr_ofc_cd],1,5)) " ).append("\n"); 
		query.append("			)" ).append("\n"); 
		query.append("		)" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#elseif (${tab_cd} == 'S' )" ).append("\n"); 
		query.append("   AND  (" ).append("\n"); 
		query.append("			(" ).append("\n"); 
		query.append("				(" ).append("\n"); 
		query.append("					CASE " ).append("\n"); 
		query.append("						WHEN @[chg_delt_path_cd] = 'OOM' THEN 1 " ).append("\n"); 
		query.append("						WHEN @[chg_delt_path_cd] = 'BBG' THEN 2 " ).append("\n"); 
		query.append("						WHEN @[chg_delt_path_cd] = 'RHQ' THEN 3 " ).append("\n"); 
		query.append("						WHEN @[chg_delt_path_cd] = 'HDO' THEN 4" ).append("\n"); 
		query.append("					END = " ).append("\n"); 
		query.append("					CASE " ).append("\n"); 
		query.append("						WHEN @[chg_delt_path_cd] = 'OOM' AND AA.DMDT_DELT_RQST_STS_CD IN ('O', 'P') THEN 1" ).append("\n"); 
		query.append("						WHEN @[chg_delt_path_cd] = 'BBG' AND AA.DMDT_DELT_RQST_STS_CD IN ('B', 'E') THEN 2" ).append("\n"); 
		query.append("						WHEN @[chg_delt_path_cd] = 'RHQ' AND AA.DMDT_DELT_RQST_STS_CD IN ('Q', 'F') THEN 3" ).append("\n"); 
		query.append("						WHEN @[chg_delt_path_cd] = 'HDO' AND AA.DMDT_DELT_RQST_STS_CD IN ('H', 'G') THEN 4                       " ).append("\n"); 
		query.append("					END" ).append("\n"); 
		query.append("				)" ).append("\n"); 
		query.append("				AND  SUBSTR(INACTIV_INFO,INSTR(INACTIV_INFO,'|',1,6)+1,INSTR(INACTIV_INFO,'|',1,7)-INSTR(INACTIV_INFO,'|',1,6)-1) IN " ).append("\n"); 
		query.append("					 ( " ).append("\n"); 
		query.append("						SELECT  OFC_N8TH_LVL_CD " ).append("\n"); 
		query.append("						  FROM  DMT_OFC_LVL_V " ).append("\n"); 
		query.append("						 WHERE  DECODE(@[usr_ofc_cd], 'SELCON', 'SELHO', SUBSTR(@[usr_ofc_cd], 1, 5)) IN " ).append("\n"); 
		query.append("								(OFC_N1ST_LVL_CD, OFC_N2ND_LVL_CD, OFC_N3RD_LVL_CD, OFC_N4TH_LVL_CD, OFC_N5TH_LVL_CD)" ).append("\n"); 
		query.append("					 )" ).append("\n"); 
		query.append("			)" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("         OR (" ).append("\n"); 
		query.append("				( " ).append("\n"); 
		query.append("					@[chg_delt_path_cd] IS NULL OR" ).append("\n"); 
		query.append("					( " ).append("\n"); 
		query.append("						CASE " ).append("\n"); 
		query.append("							WHEN @[chg_delt_path_cd] = 'RHQ' AND CC.RQST_OFC_CD IN ('ATLSC', 'CHISC', 'HOUSC', 'LGBSC', 'SFOBS', 'NYCSC', 'OREBS', 'PDXSO', 'SEASC', 'PHXSA') " ).append("\n"); 
		query.append("								THEN" ).append("\n"); 
		query.append("									CASE " ).append("\n"); 
		query.append("										WHEN @[usr_id] IN ( SELECT ATTR_CTNT1 FROM DMT_HRD_CDG_CTNT WHERE HRD_CDG_ID = 'INACTIV_APPL_USER' ) THEN 'Y' ELSE 'N' " ).append("\n"); 
		query.append("									END" ).append("\n"); 
		query.append("							ELSE 'Y' " ).append("\n"); 
		query.append("						END " ).append("\n"); 
		query.append("					) = 'N'" ).append("\n"); 
		query.append("				)" ).append("\n"); 
		query.append("				AND  AA.DMDT_DELT_RQST_STS_CD IN ('R', 'C')" ).append("\n"); 
		query.append("				AND  SUBSTR(INACTIV_INFO,INSTR(INACTIV_INFO,'|',1,6)+1,INSTR(INACTIV_INFO,'|',1,7)-INSTR(INACTIV_INFO,'|',1,6)-1) = DECODE(@[usr_ofc_cd], 'SELCON', 'SELHO', SUBSTR(@[usr_ofc_cd],1,5)) " ).append("\n"); 
		query.append("			)" ).append("\n"); 
		query.append("		)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("GROUP BY AA.INACTIV_INFO" ).append("\n"); 
		query.append("		#if (${group_by} == 'BKG' )" ).append("\n"); 
		query.append("        ,AA.BKG_NO" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("		#if (${group_by} == 'CNTR' )" ).append("\n"); 
		query.append("        ,AA.CNTR_NO" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("		" ).append("\n"); 
		query.append("ORDER BY " ).append("\n"); 
		query.append("		#if (${group_by} == 'INACT' )" ).append("\n"); 
		query.append("		INACT_RQST_NO" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("		#if (${group_by} == 'BKG' )" ).append("\n"); 
		query.append("		AA.BKG_NO" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("		#if (${group_by} == 'CNTR' )" ).append("\n"); 
		query.append("		AA.CNTR_NO" ).append("\n"); 
		query.append("		#end" ).append("\n"); 

	}
}