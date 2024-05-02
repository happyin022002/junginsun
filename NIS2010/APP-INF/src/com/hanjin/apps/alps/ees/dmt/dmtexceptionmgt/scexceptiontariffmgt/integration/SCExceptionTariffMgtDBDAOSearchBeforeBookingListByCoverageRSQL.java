/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : SCExceptionTariffMgtDBDAOSearchBeforeBookingListByCoverageRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.04.07
*@LastModifier : 
*@LastVersion : 1.0
* 2017.04.07 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.dmt.dmtexceptionmgt.scexceptiontariffmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SCExceptionTariffMgtDBDAOSearchBeforeBookingListByCoverageRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SC & RFA Exception Inquiry (BeforeBooking, COVERAGE) 조회쿼리
	  * </pre>
	  */
	public SCExceptionTariffMgtDBDAOSearchBeforeBookingListByCoverageRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rgn_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ste_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("loc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("act_cust_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.dmt.dmtexceptionmgt.scexceptiontariffmgt.integration").append("\n"); 
		query.append("FileName : SCExceptionTariffMgtDBDAOSearchBeforeBookingListByCoverageRSQL").append("\n"); 
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
		query.append("SELECT	DISTINCT " ).append("\n"); 
		query.append("        RFA_NO" ).append("\n"); 
		query.append("       ,STATUS" ).append("\n"); 
		query.append("       ,RQST_SEQ" ).append("\n"); 
		query.append("       ,TARIFF" ).append("\n"); 
		query.append("       ,EFF_DT" ).append("\n"); 
		query.append("       ,EXP_DT" ).append("\n"); 
		query.append("       ,CNTRCGO" ).append("\n"); 
		query.append("       ,CVRG_SEQ" ).append("\n"); 
		query.append("       ,CNT_CD" ).append("\n"); 
		query.append("       ,RGN_CD" ).append("\n"); 
		query.append("       ,LOC_CD" ).append("\n"); 
		query.append("       ,FT_ADD_DYS" ).append("\n"); 
		query.append("       ,FT_TOT_DYS" ).append("\n"); 
		query.append("       ,XCLD_SAT_FLG" ).append("\n"); 
		query.append("       ,XCLD_SUN_FLG" ).append("\n"); 
		query.append("       ,XCLD_HOL_FLG" ).append("\n"); 
		query.append("       ,CURR_CD" ).append("\n"); 
		query.append("       ,DECODE(CVRG_COUNT, 1, 'Single', 'Multi') 		AS ORG_DEST_MULTI" ).append("\n"); 
		query.append("       ,DECODE(CVRG_COUNT, 1, ORG_DEST_CONTI_CD, '') 	AS ORG_DEST_CONTI_CD" ).append("\n"); 
		query.append("       ,DECODE(CVRG_COUNT, 1, ORG_DEST_CNT_CD, '') 		AS ORG_DEST_CNT_CD" ).append("\n"); 
		query.append("       ,DECODE(CVRG_COUNT, 1, ORG_DEST_RGN_CD, '') 		AS ORG_DEST_RGN_CD " ).append("\n"); 
		query.append("       ,DECODE(CVRG_COUNT, 1, ORG_DEST_LOC_CD, '') 		AS ORG_DEST_LOC_CD" ).append("\n"); 
		query.append("       ,FNL_DEST_CNT_CD" ).append("\n"); 
		query.append("       ,FNL_DEST_RGN_CD" ).append("\n"); 
		query.append("       ,FNL_DEST_LOC_CD" ).append("\n"); 
		query.append("       ,ACT_CUST_CD" ).append("\n"); 
		query.append("       ,ACT_CUST_NM" ).append("\n"); 
		query.append("       ,RT_FLG" ).append("\n"); 
		query.append("       ,DAR_NO" ).append("\n"); 
		query.append("       ,VER_SEQ" ).append("\n"); 
		query.append("       ,APVL_NO" ).append("\n"); 
		query.append("       ,PROP_NO" ).append("\n"); 
		query.append("       ,CUST_CD" ).append("\n"); 
		query.append("       ,CUST_NM" ).append("\n"); 
		query.append("  FROM  (" ).append("\n"); 
		query.append("			SELECT  /*+ NO_EXPAND LEADING(TRF_DTL CVRG TRF) USE_NL(HDR MN CUST TRF COM_DTL TRF_DTL CUST2 COM_DTL2 COM_DTL3 CVRG) */" ).append("\n"); 
		query.append("                    HDR.RFA_NO" ).append("\n"); 
		query.append("			       ,COM_DTL.INTG_CD_VAL_DP_DESC 											AS STATUS" ).append("\n"); 
		query.append("				   ,TRF_DTL.RFA_RQST_DTL_SEQ 												AS RQST_SEQ" ).append("\n"); 
		query.append("				   ,TRF_DTL.DMDT_TRF_CD 													AS TARIFF" ).append("\n"); 
		query.append("				   ,TO_CHAR(TRF_DTL.EFF_DT, 'YYYY-MM-DD') 									AS EFF_DT" ).append("\n"); 
		query.append("				   ,TO_CHAR(TRF_DTL.EXP_DT, 'YYYY-MM-DD') 									AS EXP_DT" ).append("\n"); 
		query.append("				   ,COM_DTL2.INTG_CD_VAL_DP_DESC || ' - ' || COM_DTL3.INTG_CD_VAL_DP_DESC 	AS CNTRCGO" ).append("\n"); 
		query.append("				   ,CVRG.CVRG_CMB_SEQ 														AS CVRG_SEQ" ).append("\n"); 
		query.append("				   ,CVRG.CVRG_CNT_CD 														AS CNT_CD" ).append("\n"); 
		query.append("				   ,CASE WHEN CVRG.CVRG_CNT_CD IN ('CA', 'US') THEN CVRG.CVRG_STE_CD ELSE CVRG.CVRG_RGN_CD END RGN_CD" ).append("\n"); 
		query.append("				   ,CVRG.CVRG_LOC_CD 														AS LOC_CD" ).append("\n"); 
		query.append("				   ,TRF_DTL.ADD_DYS 														AS FT_ADD_DYS" ).append("\n"); 
		query.append("				   ,TRF_DTL.TTL_DYS 														AS FT_TOT_DYS" ).append("\n"); 
		query.append("				   ,TRF_DTL.XCLD_SAT_FLG" ).append("\n"); 
		query.append("				   ,TRF_DTL.XCLD_SUN_FLG" ).append("\n"); 
		query.append("				   ,TRF_DTL.XCLD_HOL_FLG" ).append("\n"); 
		query.append("				   ,TRF_DTL.CURR_CD" ).append("\n"); 
		query.append("				   ,CVRG.ORG_DEST_CONTI_CD" ).append("\n"); 
		query.append("				   ,CVRG.ORG_DEST_CNT_CD" ).append("\n"); 
		query.append("				   ,CASE WHEN CVRG.ORG_DEST_CNT_CD IN ('CA', 'US') THEN CVRG.ORG_DEST_STE_CD ELSE CVRG.ORG_DEST_RGN_CD END ORG_DEST_RGN_CD" ).append("\n"); 
		query.append("				   ,CVRG.ORG_DEST_LOC_CD" ).append("\n"); 
		query.append("				   ,TRF_DTL.FNL_DEST_CNT_CD" ).append("\n"); 
		query.append("				   ,CASE WHEN TRF_DTL.FNL_DEST_CNT_CD IN ('CA', 'US') THEN TRF_DTL.FNL_DEST_STE_CD ELSE TRF_DTL.FNL_DEST_RGN_CD END FNL_DEST_RGN_CD" ).append("\n"); 
		query.append("				   ,TRF_DTL.FNL_DEST_LOC_CD" ).append("\n"); 
		query.append("				   ,TRF_DTL.ACT_CUST_CNT_CD || LPAD(TRF_DTL.ACT_CUST_SEQ, 6, '0') 			AS ACT_CUST_CD" ).append("\n"); 
		query.append("				   ,CUST2.CUST_LGL_ENG_NM ACT_CUST_NM   " ).append("\n"); 
		query.append("				   ,TRF_DTL.RT_USE_FLG 														AS RT_FLG" ).append("\n"); 
		query.append("				   ,TRF.RFA_EXPT_DAR_NO 													AS DAR_NO" ).append("\n"); 
		query.append("			       ,LPAD(TRF.RFA_EXPT_VER_SEQ, 3, '0') 										AS VER_SEQ" ).append("\n"); 
		query.append("			       ,TRF.RFA_EXPT_APRO_NO 													AS APVL_NO" ).append("\n"); 
		query.append("			       ,TRF.PROP_NO" ).append("\n"); 
		query.append("			       ,MN.CTRT_CUST_CNT_CD || LPAD(MN.CTRT_CUST_SEQ, 6, '0') 					AS CUST_CD" ).append("\n"); 
		query.append("			       ,CUST.CUST_LGL_ENG_NM 													AS CUST_NM            " ).append("\n"); 
		query.append("				   ,(" ).append("\n"); 
		query.append("			        	SELECT  COUNT(CVRG_CMB_SEQ)" ).append("\n"); 
		query.append("			        	  FROM  DMT_RFA_EXPT_CVRG_CMB" ).append("\n"); 
		query.append("			        	 WHERE  RFA_EXPT_DAR_NO = TRF_DTL.RFA_EXPT_DAR_NO" ).append("\n"); 
		query.append("			               AND  RFA_EXPT_MAPG_SEQ = TRF_DTL.RFA_EXPT_MAPG_SEQ" ).append("\n"); 
		query.append("			               AND  RFA_EXPT_VER_SEQ = TRF_DTL.RFA_EXPT_VER_SEQ" ).append("\n"); 
		query.append("			               AND  RFA_RQST_DTL_SEQ = TRF_DTL.RFA_RQST_DTL_SEQ" ).append("\n"); 
		query.append("			     	) 																		AS CVRG_COUNT" ).append("\n"); 
		query.append("					" ).append("\n"); 
		query.append("			  FROM  PRI_RP_HDR 				HDR" ).append("\n"); 
		query.append("			       ,PRI_RP_MN 				MN" ).append("\n"); 
		query.append("			       ,MDM_CUSTOMER 			CUST" ).append("\n"); 
		query.append("			       ,DMT_RFA_EXPT_TRF 		TRF" ).append("\n"); 
		query.append("			       ,COM_INTG_CD_DTL 		COM_DTL " ).append("\n"); 
		query.append("			       ,DMT_RFA_EXPT_TRF_DTL 	TRF_DTL" ).append("\n"); 
		query.append("			       ,MDM_CUSTOMER 			CUST2" ).append("\n"); 
		query.append("				   ,COM_INTG_CD_DTL 		COM_DTL2" ).append("\n"); 
		query.append("				   ,COM_INTG_CD_DTL 		COM_DTL3" ).append("\n"); 
		query.append("				   ,DMT_RFA_EXPT_CVRG_CMB 	CVRG" ).append("\n"); 
		query.append("				   " ).append("\n"); 
		query.append("			 WHERE  HDR.PROP_NO = TRF.PROP_NO" ).append("\n"); 
		query.append("			   AND  HDR.PROP_NO = MN.PROP_NO" ).append("\n"); 
		query.append("               AND  MN.ROWID    =  " ).append("\n"); 
		query.append("					(" ).append("\n"); 
		query.append("						SELECT  /*+ INDEX_DESC(PRI_RP_MN XPKPRI_RP_MN) */" ).append("\n"); 
		query.append("                                ROWID  RID                               " ).append("\n"); 
		query.append("                          FROM  PRI_RP_MN                                " ).append("\n"); 
		query.append("                         WHERE  PROP_NO = TRF.PROP_NO                    " ).append("\n"); 
		query.append("                           AND  ROWNUM = 1                               " ).append("\n"); 
		query.append("                    )" ).append("\n"); 
		query.append("					" ).append("\n"); 
		query.append("			#if(${cust_cd} != '' && ${act_cust_cd} != '')" ).append("\n"); 
		query.append("               AND  MN.CTRT_CUST_CNT_CD = CUST.CUST_CNT_CD(+)" ).append("\n"); 
		query.append("               AND  MN.CTRT_CUST_SEQ    = CUST.CUST_SEQ(+)" ).append("\n"); 
		query.append("			#else" ).append("\n"); 
		query.append("               AND  MN.CTRT_CUST_CNT_CD ||'' = CUST.CUST_CNT_CD" ).append("\n"); 
		query.append("               AND  MN.CTRT_CUST_SEQ    ||'' = CUST.CUST_SEQ" ).append("\n"); 
		query.append("			#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("               AND  TRF.DMDT_EXPT_RQST_STS_CD IN (" ).append("\n"); 
		query.append("						#foreach( $sts_cd in ${sts_cd_list} )" ).append("\n"); 
		query.append("							#if($velocityCount < $sts_cd_list.size()) '$sts_cd', #else '$sts_cd' #end" ).append("\n"); 
		query.append("						#end" ).append("\n"); 
		query.append("					)" ).append("\n"); 
		query.append("               AND  TRF.DMDT_EXPT_RQST_STS_CD = COM_DTL.INTG_CD_VAL_CTNT" ).append("\n"); 
		query.append("               AND  COM_DTL.INTG_CD_ID        = 'CD02069'                  " ).append("\n"); 
		query.append("               AND  TRF.RFA_EXPT_DAR_NO       = TRF_DTL.RFA_EXPT_DAR_NO" ).append("\n"); 
		query.append("               AND  TRF.RFA_EXPT_MAPG_SEQ     = TRF_DTL.RFA_EXPT_MAPG_SEQ" ).append("\n"); 
		query.append("               AND  TRF.RFA_EXPT_VER_SEQ      = TRF_DTL.RFA_EXPT_VER_SEQ" ).append("\n"); 
		query.append("               AND  TRF_DTL.DMDT_TRF_CD IN (" ).append("\n"); 
		query.append("						#foreach( $trf_cd in ${trf_cd_list} )" ).append("\n"); 
		query.append("							#if($velocityCount < $trf_cd_list.size()) '$trf_cd', #else '$trf_cd' #end" ).append("\n"); 
		query.append("						#end" ).append("\n"); 
		query.append("					)" ).append("\n"); 
		query.append("               AND  (" ).append("\n"); 
		query.append("						(TRF_DTL.EFF_DT >= TO_DATE(@[fm_dt], 'YYYY-MM-DD') AND TRF_DTL.EFF_DT <= TO_DATE(@[to_dt], 'YYYY-MM-DD') + 0.99999)" ).append("\n"); 
		query.append("						OR" ).append("\n"); 
		query.append("						(TRF_DTL.EXP_DT >= TO_DATE(@[fm_dt], 'YYYY-MM-DD') AND TRF_DTL.EXP_DT <= TO_DATE(@[to_dt], 'YYYY-MM-DD') + 0.99999)" ).append("\n"); 
		query.append("						OR" ).append("\n"); 
		query.append("						(TRF_DTL.EFF_DT <= TO_DATE(@[fm_dt], 'YYYY-MM-DD') AND TRF_DTL.EXP_DT >= TO_DATE(@[to_dt], 'YYYY-MM-DD') + 0.99999)" ).append("\n"); 
		query.append("						OR" ).append("\n"); 
		query.append("						(TRF_DTL.EFF_DT >= TO_DATE(@[fm_dt], 'YYYY-MM-DD') AND TRF_DTL.EXP_DT <= TO_DATE(@[to_dt], 'YYYY-MM-DD') + 0.99999)" ).append("\n"); 
		query.append("					)" ).append("\n"); 
		query.append("               AND  TRF_DTL.DMDT_CNTR_TP_CD = COM_DTL2.INTG_CD_VAL_CTNT" ).append("\n"); 
		query.append("               AND  COM_DTL2.INTG_CD_ID     = 'CD02053'" ).append("\n"); 
		query.append("               AND  TRF_DTL.DMDT_CGO_TP_CD  = COM_DTL3.INTG_CD_VAL_CTNT" ).append("\n"); 
		query.append("               AND  COM_DTL3.INTG_CD_ID     = 'CD01963'" ).append("\n"); 
		query.append("			   " ).append("\n"); 
		query.append("			#if(${cust_cd} != '' && ${act_cust_cd} == '')" ).append("\n"); 
		query.append("               AND  MN.CTRT_CUST_CNT_CD = SUBSTR(@[cust_cd], 0, 2) AND MN.CTRT_CUST_SEQ = SUBSTR(@[cust_cd], 3)" ).append("\n"); 
		query.append("			#elseif(${cust_cd} == '' && ${act_cust_cd} != '')" ).append("\n"); 
		query.append("               AND  TRF_DTL.ACT_CUST_CNT_CD = SUBSTR(@[act_cust_cd], 0, 2) AND TRF_DTL.ACT_CUST_SEQ = SUBSTR(@[act_cust_cd], 3)" ).append("\n"); 
		query.append("			#elseif(${cust_cd} != '' && ${act_cust_cd} != '')" ).append("\n"); 
		query.append("               AND  (" ).append("\n"); 
		query.append("						(MN.CTRT_CUST_CNT_CD = SUBSTR(@[cust_cd], 0, 2) AND MN.CTRT_CUST_SEQ = SUBSTR(@[cust_cd], 3))" ).append("\n"); 
		query.append("						OR" ).append("\n"); 
		query.append("						(TRF_DTL.ACT_CUST_CNT_CD = SUBSTR(@[act_cust_cd], 0, 2) AND TRF_DTL.ACT_CUST_SEQ = SUBSTR(@[act_cust_cd], 3))" ).append("\n"); 
		query.append("				    )" ).append("\n"); 
		query.append("			#end" ).append("\n"); 
		query.append("			" ).append("\n"); 
		query.append("               AND  TRF_DTL.ACT_CUST_CNT_CD = CUST2.CUST_CNT_CD(+)" ).append("\n"); 
		query.append("               AND  TRF_DTL.ACT_CUST_SEQ    = CUST2.CUST_SEQ(+)" ).append("\n"); 
		query.append("               AND  CVRG.ROWID              = " ).append("\n"); 
		query.append("					(" ).append("\n"); 
		query.append("						SELECT	/*+ INDEX_ASC(DMT_RFA_EXPT_CVRG_CMB XPKDMT_RFA_EXPT_CVRG_CMB) */ " ).append("\n"); 
		query.append("							    ROWID  RID" ).append("\n"); 
		query.append("						  FROM  DMT_RFA_EXPT_CVRG_CMB" ).append("\n"); 
		query.append("						 WHERE  RFA_EXPT_DAR_NO   = TRF_DTL.RFA_EXPT_DAR_NO     " ).append("\n"); 
		query.append("					       AND  RFA_EXPT_MAPG_SEQ = TRF_DTL.RFA_EXPT_MAPG_SEQ " ).append("\n"); 
		query.append("					       AND  RFA_EXPT_VER_SEQ  = TRF_DTL.RFA_EXPT_VER_SEQ   " ).append("\n"); 
		query.append("					       AND  RFA_RQST_DTL_SEQ  = TRF_DTL.RFA_RQST_DTL_SEQ   " ).append("\n"); 
		query.append("					       AND  ROWNUM            = 1" ).append("\n"); 
		query.append("					)" ).append("\n"); 
		query.append("               AND  CVRG.CVRG_CNT_CD ||'' = @[cnt_cd]" ).append("\n"); 
		query.append("				" ).append("\n"); 
		query.append("			#if(${rgn_cd} != '')" ).append("\n"); 
		query.append("               AND  CVRG.CVRG_RGN_CD ||'' = @[rgn_cd]" ).append("\n"); 
		query.append("			#end" ).append("\n"); 
		query.append("			#if(${ste_cd} != '')" ).append("\n"); 
		query.append("               AND  CVRG.CVRG_STE_CD ||'' = @[ste_cd]" ).append("\n"); 
		query.append("			#end" ).append("\n"); 
		query.append("			#if(${loc_cd} != '')" ).append("\n"); 
		query.append("               AND  CVRG.CVRG_LOC_CD ||'' = @[loc_cd]" ).append("\n"); 
		query.append("			#end			" ).append("\n"); 
		query.append("		)" ).append("\n"); 
		query.append("ORDER BY RFA_NO, PROP_NO, VER_SEQ, RQST_SEQ, CVRG_SEQ" ).append("\n"); 

	}
}