/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : MnrAudDBDAOSearchHbarInquiryByHistoryRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.05.20
*@LastModifier : 
*@LastVersion : 1.0
* 2015.05.20 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.eas.expnaud.mnraud.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class MnrAudDBDAOSearchHbarInquiryByHistoryRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * HBar Inquiry by History 조회
	  * </pre>
	  */
	public MnrAudDBDAOSearchHbarInquiryByHistoryRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_to_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_yd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_fm_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_loc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_reg_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.eas.expnaud.mnraud.integration").append("\n"); 
		query.append("FileName : MnrAudDBDAOSearchHbarInquiryByHistoryRSQL").append("\n"); 
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
		query.append("SELECT RHQ_CD" ).append("\n"); 
		query.append("      ,MNR_FLG_YD_CD" ).append("\n"); 
		query.append("      ,REG_OFC_CD" ).append("\n"); 
		query.append("      ,EQ_NO" ).append("\n"); 
		query.append("      ,EQ_TPSZ_CD" ).append("\n"); 
		query.append("      ,HNGR_BAR_AMD_QTY" ).append("\n"); 
		query.append("      ,WO_NO" ).append("\n"); 
		query.append("      ,WO_CURR_CD" ).append("\n"); 
		query.append("      ,WO_AMT" ).append("\n"); 
		query.append("      ,VNDR_SEQ" ).append("\n"); 
		query.append("      ,VNDR_NM" ).append("\n"); 
		query.append("      ,BKG_NO" ).append("\n"); 
		query.append("      ,BKG_GET_TOKEN_FNC(BKG_SCG_INFO,1,',') AS BKG_CURR_CD" ).append("\n"); 
		query.append("      ,BKG_GET_TOKEN_FNC(BKG_SCG_INFO,2,',') AS BKG_SCG_AMT" ).append("\n"); 
		query.append("      ,(CASE WHEN LENGTH(BKG_GET_TOKEN_FNC(BKG_SCG_INFO,3)) > 1 THEN 'Y' END) AS BKG_SCG_MIX_FLG" ).append("\n"); 
		query.append("      ,POR_NOD_CD" ).append("\n"); 
		query.append("      ,POL_NOD_CD" ).append("\n"); 
		query.append("      ,SUBSTR(OFT_IN,1,1) OFT_IN " ).append("\n"); 
		query.append("  FROM (" ).append("\n"); 
		query.append("        SELECT RHQ_CD" ).append("\n"); 
		query.append("              ,MNR_FLG_YD_CD" ).append("\n"); 
		query.append("              ,REG_OFC_CD" ).append("\n"); 
		query.append("              ,EQ_NO" ).append("\n"); 
		query.append("              ,EQ_TPSZ_CD" ).append("\n"); 
		query.append("              ,HNGR_BAR_AMD_QTY" ).append("\n"); 
		query.append("              ,WO_NO" ).append("\n"); 
		query.append("              ,CURR_CD AS WO_CURR_CD" ).append("\n"); 
		query.append("              ,MNR_WRK_AMT AS WO_AMT" ).append("\n"); 
		query.append("              ,VNDR_SEQ" ).append("\n"); 
		query.append("              ,VNDR_NM" ).append("\n"); 
		query.append("              ,BKG_GET_TOKEN_FNC(BKG_INFO,1) AS BKG_NO" ).append("\n"); 
		query.append("              ,BKG_GET_TOKEN_FNC(BKG_INFO,2) AS POR_NOD_CD" ).append("\n"); 
		query.append("              ,BKG_GET_TOKEN_FNC(BKG_INFO,3) AS POL_NOD_CD" ).append("\n"); 
		query.append("              ,(SELECT WM_CONCAT(CURR_CD||','||CHG_UT_AMT)" ).append("\n"); 
		query.append("                  FROM BKG_CHG_RT X" ).append("\n"); 
		query.append("                 WHERE X.BKG_NO = BKG_GET_TOKEN_FNC(BKG_INFO,1,',')" ).append("\n"); 
		query.append("                   AND X.CHG_CD = 'GOH'" ).append("\n"); 
		query.append("                   AND ((X.RAT_UT_CD = AA.EQ_TPSZ_CD) OR (CASE WHEN SUBSTR(AA.EQ_TPSZ_CD, 2,1) IN ('2', '3') THEN '20'" ).append("\n"); 
		query.append("                                                               WHEN SUBSTR(AA.EQ_TPSZ_CD, 2,1) IN ('4', '5') THEN '40'" ).append("\n"); 
		query.append("                                                               WHEN SUBSTR(AA.EQ_TPSZ_CD, 2,1) IN ('6', '7') THEN '45'" ).append("\n"); 
		query.append("                                                          END" ).append("\n"); 
		query.append("                                                         ) = X.RAT_UT_CD" ).append("\n"); 
		query.append("                                                      OR (X.RAT_UT_CD = 'BX')" ).append("\n"); 
		query.append("                       )" ).append("\n"); 
		query.append("               ) BKG_SCG_INFO" ).append("\n"); 
		query.append("			   ,(SELECT WM_CONCAT(FRT_INCL_XCLD_DIV_CD)" ).append("\n"); 
		query.append("                  FROM BKG_CHG_RT X" ).append("\n"); 
		query.append("                 WHERE X.BKG_NO = BKG_GET_TOKEN_FNC(BKG_INFO,1,',')" ).append("\n"); 
		query.append("                   AND X.CHG_CD = 'GOH'" ).append("\n"); 
		query.append("                   AND ((X.RAT_UT_CD = AA.EQ_TPSZ_CD) OR (CASE WHEN SUBSTR(AA.EQ_TPSZ_CD, 2,1) IN ('2', '3') THEN '20'" ).append("\n"); 
		query.append("                                                               WHEN SUBSTR(AA.EQ_TPSZ_CD, 2,1) IN ('4', '5') THEN '40'" ).append("\n"); 
		query.append("                                                               WHEN SUBSTR(AA.EQ_TPSZ_CD, 2,1) IN ('6', '7') THEN '45'" ).append("\n"); 
		query.append("                                                          END" ).append("\n"); 
		query.append("                                                         ) = X.RAT_UT_CD" ).append("\n"); 
		query.append("                                                      OR (X.RAT_UT_CD = 'BX')" ).append("\n"); 
		query.append("                       )" ).append("\n"); 
		query.append("               ) OFT_IN" ).append("\n"); 
		query.append("          FROM (" ).append("\n"); 
		query.append("                SELECT (SELECT TRS_COMMON_PKG.TRS_GET_RHQ_OFC_CD(A.CRE_OFC_CD) FROM DUAL)AS RHQ_CD" ).append("\n"); 
		query.append("                      ,A.MNR_FLG_YD_CD" ).append("\n"); 
		query.append("                      ,A.CRE_OFC_CD AS REG_OFC_CD" ).append("\n"); 
		query.append("                      ,A.EQ_NO" ).append("\n"); 
		query.append("                      ,A.EQ_TPSZ_CD" ).append("\n"); 
		query.append("                      ,NVL(A.HNGR_BAR_AMD_QTY, 0) AS HNGR_BAR_AMD_QTY" ).append("\n"); 
		query.append("                      ,B.MNR_ORD_OFC_CTY_CD||B.MNR_ORD_SEQ AS WO_NO" ).append("\n"); 
		query.append("                      ,B.CURR_CD" ).append("\n"); 
		query.append("                      ,B.MNR_WRK_AMT" ).append("\n"); 
		query.append("                      ,B.VNDR_SEQ" ).append("\n"); 
		query.append("                      ,(SELECT X.VNDR_LGL_ENG_NM FROM MDM_VENDOR X WHERE X.VNDR_SEQ = B.VNDR_SEQ) VNDR_NM" ).append("\n"); 
		query.append("                      ,(SELECT P.BKG_NO || ',' || P.POR_NOD_CD  || ',' || P.POL_NOD_CD" ).append("\n"); 
		query.append("                          FROM BKG_VVD O" ).append("\n"); 
		query.append("                              ,BKG_BOOKING P" ).append("\n"); 
		query.append("                              ,VSK_VSL_PORT_SKD Q" ).append("\n"); 
		query.append("                              ,BKG_CONTAINER R" ).append("\n"); 
		query.append("                         WHERE 1=1" ).append("\n"); 
		query.append("                           AND O.BKG_NO     = P.BKG_NO" ).append("\n"); 
		query.append("                           AND O.POL_YD_CD  = P.POL_NOD_CD" ).append("\n"); 
		query.append("                           AND O.VSL_CD     = Q.VSL_CD" ).append("\n"); 
		query.append("                           AND O.SKD_VOY_NO = Q.SKD_VOY_NO" ).append("\n"); 
		query.append("                           AND O.SKD_DIR_CD = Q.SKD_DIR_CD" ).append("\n"); 
		query.append("                           AND O.POL_CD     = Q.VPS_PORT_CD" ).append("\n"); 
		query.append("                           AND O.POL_CLPT_IND_SEQ = Q.CLPT_IND_SEQ   " ).append("\n"); 
		query.append("                           AND O.POL_YD_CD  = Q.YD_CD" ).append("\n"); 
		query.append("                           AND O.BKG_NO     = R.BKG_NO" ).append("\n"); 
		query.append("                           AND P.HNGR_FLG = 'Y'" ).append("\n"); 
		query.append("                           AND R.HNGR_FLG = 'Y'" ).append("\n"); 
		query.append("                           AND P.BKG_STS_CD <> 'X'" ).append("\n"); 
		query.append("                           AND SUBSTR(Q.YD_CD,1,2) IN (SELECT Y.CNT_CD" ).append("\n"); 
		query.append("                                                        FROM MDM_ORGANIZATION X" ).append("\n"); 
		query.append("                                                            ,MDM_LOCATION     Y" ).append("\n"); 
		query.append("                                                       WHERE X.LOC_CD = Y.LOC_CD" ).append("\n"); 
		query.append("                                                         AND X.OFC_CD = A.CRE_OFC_CD)" ).append("\n"); 
		query.append("                           AND R.CNTR_NO = A.EQ_NO" ).append("\n"); 
		query.append("                           AND Q.VPS_ETD_DT BETWEEN A.MNR_FLG_INP_DT - 50 AND A.MNR_FLG_INP_DT + 50" ).append("\n"); 
		query.append("                           AND ROWNUM = 1" ).append("\n"); 
		query.append("                           ) BKG_INFO" ).append("\n"); 
		query.append("                  FROM  MNR_FLG_HIS A" ).append("\n"); 
		query.append("                        ,MNR_ORD_HDR B" ).append("\n"); 
		query.append("                 WHERE  A.MNR_ORD_OFC_CTY_CD = B.MNR_ORD_OFC_CTY_CD(+)" ).append("\n"); 
		query.append("                   AND  A.MNR_ORD_SEQ        = B.MNR_ORD_SEQ(+)" ).append("\n"); 
		query.append("                   AND  A.MNR_FLG_TP_CD = 'HGR'" ).append("\n"); 
		query.append("                   AND  A.MNR_STS_FLG   = 'Y'" ).append("\n"); 
		query.append("                   #if (${s_fm_dt} != ''|| ${s_to_dt} != '')" ).append("\n"); 
		query.append("                     AND A.MNR_FLG_INP_DT BETWEEN TO_DATE(REPLACE(@[s_fm_dt],'-',''), 'YYYYMMDD') AND TO_DATE(REPLACE(@[s_to_dt],'-',''), 'YYYYMMDD') + 0.99999" ).append("\n"); 
		query.append("                   #end" ).append("\n"); 
		query.append("                   AND EXISTS (SELECT  1" ).append("\n"); 
		query.append("                                 FROM  MDM_ORGANIZATION X" ).append("\n"); 
		query.append("                                      ,MDM_LOCATION     Y" ).append("\n"); 
		query.append("                                WHERE  X.LOC_CD = Y.LOC_CD" ).append("\n"); 
		query.append("                                #if ( ${s_cnt_cd} != '')" ).append("\n"); 
		query.append("                                AND Y.CNT_CD = @[s_cnt_cd]" ).append("\n"); 
		query.append("                                #end" ).append("\n"); 
		query.append("                                AND X.OFC_CD = A.CRE_OFC_CD" ).append("\n"); 
		query.append("                                )" ).append("\n"); 
		query.append("					#if($s_cntr_no.size() > 0) " ).append("\n"); 
		query.append("                	  AND A.EQ_NO IN (" ).append("\n"); 
		query.append("                    	#foreach( ${key} in ${s_cntr_no}) " ).append("\n"); 
		query.append("                          #if($velocityCount == 1) " ).append("\n"); 
		query.append("                            '$key'" ).append("\n"); 
		query.append("                          #else " ).append("\n"); 
		query.append("                            , '$key'" ).append("\n"); 
		query.append("                          #end " ).append("\n"); 
		query.append("                        #end" ).append("\n"); 
		query.append("                		)" ).append("\n"); 
		query.append("           			#end" ).append("\n"); 
		query.append("                    #if ( ${s_wo_flg} == 'Y')" ).append("\n"); 
		query.append("                      AND B.MNR_ORD_OFC_CTY_CD IS NOT NULL" ).append("\n"); 
		query.append("                    #elseif ( ${s_wo_flg} == 'N')" ).append("\n"); 
		query.append("                      AND B.MNR_ORD_OFC_CTY_CD IS NULL" ).append("\n"); 
		query.append("                    #end" ).append("\n"); 
		query.append("					#if ( ${s_reg_ofc_cd} != '')" ).append("\n"); 
		query.append("					  AND A.CRE_OFC_CD = @[s_reg_ofc_cd]" ).append("\n"); 
		query.append("					#end" ).append("\n"); 
		query.append("               ) AA" ).append("\n"); 
		query.append("      ) AAA" ).append("\n"); 
		query.append("WHERE  1 = 1" ).append("\n"); 
		query.append("       #if ( ${s_loc_cd} != '' && ${s_yd_cd} != '')" ).append("\n"); 
		query.append("       		AND ( AAA.POR_NOD_CD LIKE @[s_loc_cd] || @[s_yd_cd]|| '%' OR AAA.POL_NOD_CD LIKE @[s_loc_cd] || @[s_yd_cd]|| '%' )" ).append("\n"); 
		query.append("       #elseif ( ${s_loc_cd} != '' && ${s_yd_cd} == '')" ).append("\n"); 
		query.append("       		AND ( AAA.POR_NOD_CD LIKE @[s_loc_cd] || '%' OR AAA.POL_NOD_CD LIKE @[s_loc_cd] || '%' )" ).append("\n"); 
		query.append("       #end" ).append("\n"); 

	}
}