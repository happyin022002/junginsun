/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : TesBkgAudDBDAOSearchRehandlingBkgCodRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.07.28
*@LastModifier : 
*@LastVersion : 1.0
* 2016.07.28 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.eas.expnaud.tesbkgaud.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TesBkgAudDBDAOSearchRehandlingBkgCodRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Rehandling(BKG COD) 데이타 조회
	  * </pre>
	  */
	public TesBkgAudDBDAOSearchRehandlingBkgCodRSQL(){
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
		params.put("s_fm_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_rhq_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_vvd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.eas.expnaud.tesbkgaud.integration").append("\n"); 
		query.append("FileName : TesBkgAudDBDAOSearchRehandlingBkgCodRSQL").append("\n"); 
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
		query.append("SELECT BKG_NO" ).append("\n"); 
		query.append("      ,CNTR_QTY" ).append("\n"); 
		query.append("      ,BKG_OFC_CD" ).append("\n"); 
		query.append("      ,CORR_OFC_CD" ).append("\n"); 
		query.append("      ,TO_CHAR(CORR_DT,'YYYY-MM-DD HH24:MI:SS') CORR_DT" ).append("\n"); 
		query.append("      ,VVD" ).append("\n"); 
		query.append("      ,SVC_SCP_CD" ).append("\n"); 
		query.append("      ,O_POD_CD" ).append("\n"); 
		query.append("      ,O_DEL_CD" ).append("\n"); 
		query.append("      ,O_RLY_PORT_CD" ).append("\n"); 
		query.append("      ,C_POD_CD" ).append("\n"); 
		query.append("      ,C_DEL_CD" ).append("\n"); 
		query.append("      ,C_RLY_PORT_CD" ).append("\n"); 
		query.append("      ,CORR_NO" ).append("\n"); 
		query.append("	  , CA_RSN_CD" ).append("\n"); 
		query.append("      ,REPLACE(REPLACE(BKG_CORR_RMK, CHR(13), ''), CHR(10),'') AS BKG_CORR_RMK" ).append("\n"); 
		query.append("      ,CORR_USR_NM" ).append("\n"); 
		query.append("      ,BKG_GET_TOKEN_FNC(DVC,1,'^') AS DVC_TRF_ITM_NO" ).append("\n"); 
		query.append("      ,BKG_GET_TOKEN_FNC(DVC,2,'^') AS DVC_CURR_CD" ).append("\n"); 
		query.append("      ,BKG_GET_TOKEN_FNC(DVC,3,'^') AS DVC_CHG_AMT      " ).append("\n"); 
		query.append("      ,BKG_GET_TOKEN_FNC(DVC,4,'^') AS DVC_RAT_AS_QTY" ).append("\n"); 
		query.append("      ,BKG_GET_TOKEN_FNC(DVC,5,'^') AS DVC_INCL_OFT_FLG" ).append("\n"); 
		query.append("      ,BKG_GET_TOKEN_FNC(DVC,6,'^') AS DVC_CHG_USD_AMT" ).append("\n"); 
		query.append("      ,BKG_GET_TOKEN_FNC(OCH,1,'^') AS OCH_TRF_ITM_NO" ).append("\n"); 
		query.append("      ,BKG_GET_TOKEN_FNC(OCH,2,'^') AS OCH_CURR_CD" ).append("\n"); 
		query.append("      ,BKG_GET_TOKEN_FNC(OCH,3,'^') AS OCH_CHG_AMT      " ).append("\n"); 
		query.append("      ,BKG_GET_TOKEN_FNC(OCH,4,'^') AS OCH_RAT_AS_QTY" ).append("\n"); 
		query.append("      ,BKG_GET_TOKEN_FNC(OCH,5,'^') AS OCH_INCL_OFT_FLG" ).append("\n"); 
		query.append("      ,BKG_GET_TOKEN_FNC(OCH,6,'^') AS OCH_CHG_USD_AMT" ).append("\n"); 
		query.append("      ,BKG_GET_TOKEN_FNC(DCH,1,'^') AS DCH_TRF_ITM_NO" ).append("\n"); 
		query.append("      ,BKG_GET_TOKEN_FNC(DCH,2,'^') AS DCH_CURR_CD" ).append("\n"); 
		query.append("      ,BKG_GET_TOKEN_FNC(DCH,3,'^') AS DCH_CHG_AMT      " ).append("\n"); 
		query.append("      ,BKG_GET_TOKEN_FNC(DCH,4,'^') AS DCH_RAT_AS_QTY" ).append("\n"); 
		query.append("      ,BKG_GET_TOKEN_FNC(DCH,5,'^') AS DCH_INCL_OFT_FLG" ).append("\n"); 
		query.append("      ,BKG_GET_TOKEN_FNC(DCH,6,'^') AS DCH_CHG_USD_AMT" ).append("\n"); 
		query.append("      ,BKG_GET_TOKEN_FNC(MIS,1,'^') AS MIS_TRF_ITM_NO" ).append("\n"); 
		query.append("      ,BKG_GET_TOKEN_FNC(MIS,2,'^') AS MIS_CURR_CD" ).append("\n"); 
		query.append("      ,BKG_GET_TOKEN_FNC(MIS,3,'^') AS MIS_CHG_AMT      " ).append("\n"); 
		query.append("      ,BKG_GET_TOKEN_FNC(MIS,4,'^') AS MIS_RAT_AS_QTY" ).append("\n"); 
		query.append("      ,BKG_GET_TOKEN_FNC(MIS,5,'^') AS MIS_INCL_OFT_FLG" ).append("\n"); 
		query.append("      ,BKG_GET_TOKEN_FNC(MIS,6,'^') AS MIS_CHG_USD_AMT" ).append("\n"); 
		query.append("      ,( SELECT	'Y'" ).append("\n"); 
		query.append("		 FROM	EAS_DEST_CNG_CHK EE" ).append("\n"); 
		query.append("		 WHERE  1 =1" ).append("\n"); 
		query.append("				AND EE.BKG_NO = AA.BKG_NO " ).append("\n"); 
		query.append("				AND EE.CORR_NO = AA.CORR_NO ) EAC_IF_FLG" ).append("\n"); 
		query.append("  FROM (" ).append("\n"); 
		query.append("        SELECT A.BKG_NO" ).append("\n"); 
		query.append("              ,(SELECT SUM(X.OP_CNTR_QTY) FROM BKG_QUANTITY X WHERE X.BKG_NO = A.BKG_NO) CNTR_QTY" ).append("\n"); 
		query.append("              ,A.BKG_OFC_CD" ).append("\n"); 
		query.append("              ,B.CORR_OFC_CD" ).append("\n"); 
		query.append("              ,B.CORR_DT" ).append("\n"); 
		query.append("              ,A.VSL_CD||A.SKD_VOY_NO||A.SKD_DIR_CD AS VVD" ).append("\n"); 
		query.append("              ,D.POD_CD          AS O_POD_CD" ).append("\n"); 
		query.append("              ,D.DEL_CD          AS O_DEL_CD" ).append("\n"); 
		query.append("              ,D.PST_RLY_PORT_CD AS O_RLY_PORT_CD" ).append("\n"); 
		query.append("              ,C.POD_CD          AS C_POD_CD" ).append("\n"); 
		query.append("              ,C.DEL_CD          AS C_DEL_CD" ).append("\n"); 
		query.append("              ,C.PST_RLY_PORT_CD AS C_RLY_PORT_CD" ).append("\n"); 
		query.append("              ,B.CORR_NO" ).append("\n"); 
		query.append("			  , B.CA_RSN_CD" ).append("\n"); 
		query.append("              ,B.BKG_CORR_RMK" ).append("\n"); 
		query.append("              ,A.SVC_SCP_CD" ).append("\n"); 
		query.append("              ,(SELECT X.USR_NM FROM COM_USER X WHERE X.USR_ID = B.CORR_USR_ID) CORR_USR_NM" ).append("\n"); 
		query.append("              ,(SELECT MAX(TRF_ITM_NO) ||'^'||" ).append("\n"); 
		query.append("                       CASE WHEN MIN(CURR_CD) = MAX(CURR_CD) THEN MAX(CURR_CD) END ||'^'||" ).append("\n"); 
		query.append("                       CASE WHEN MIN(CURR_CD) = MAX(CURR_CD) THEN SUM(CHG_AMT) END ||'^'||" ).append("\n"); 
		query.append("                       MAX(RAT_AS_QTY) ||'^'||" ).append("\n"); 
		query.append("                       MAX(FRT_INCL_XCLD_DIV_CD) ||'^'||" ).append("\n"); 
		query.append("                       SUM(ROUND (X.CHG_AMT / " ).append("\n"); 
		query.append("                             CASE WHEN NVL(X.CURR_CD,'USD') = 'USD' THEN 1" ).append("\n"); 
		query.append("                                  ELSE (SELECT USD_LOCL_XCH_RT" ).append("\n"); 
		query.append("                                          FROM GL_MON_XCH_RT XCH" ).append("\n"); 
		query.append("                                         WHERE XCH.ACCT_XCH_RT_LVL = 1 " ).append("\n"); 
		query.append("                                           AND XCH.CURR_CD           = X.CURR_CD" ).append("\n"); 
		query.append("                                           AND XCH.ACCT_XCH_RT_YRMON = TO_CHAR(B.CORR_DT, 'YYYYMM') )" ).append("\n"); 
		query.append("                             END" ).append("\n"); 
		query.append("                       , 2))" ).append("\n"); 
		query.append("                  FROM BKG_CHG_RT X" ).append("\n"); 
		query.append("                 WHERE X.BKG_NO = A.BKG_NO" ).append("\n"); 
		query.append("                   AND X.CHG_CD = 'DVC') DVC" ).append("\n"); 
		query.append("              ,(SELECT MAX(TRF_ITM_NO) ||'^'||" ).append("\n"); 
		query.append("                       CASE WHEN MIN(CURR_CD) = MAX(CURR_CD) THEN MAX(CURR_CD) END ||'^'||" ).append("\n"); 
		query.append("                       CASE WHEN MIN(CURR_CD) = MAX(CURR_CD) THEN SUM(CHG_AMT) END ||'^'||" ).append("\n"); 
		query.append("                       MAX(RAT_AS_QTY) ||'^'||" ).append("\n"); 
		query.append("                       MAX(FRT_INCL_XCLD_DIV_CD) ||'^'||" ).append("\n"); 
		query.append("                       SUM(ROUND (X.CHG_AMT / " ).append("\n"); 
		query.append("                             CASE WHEN NVL(X.CURR_CD,'USD') = 'USD' THEN 1" ).append("\n"); 
		query.append("                                  ELSE (SELECT USD_LOCL_XCH_RT" ).append("\n"); 
		query.append("                                          FROM GL_MON_XCH_RT XCH" ).append("\n"); 
		query.append("                                         WHERE XCH.ACCT_XCH_RT_LVL = 1 " ).append("\n"); 
		query.append("                                           AND XCH.CURR_CD           = X.CURR_CD" ).append("\n"); 
		query.append("                                           AND XCH.ACCT_XCH_RT_YRMON = TO_CHAR(B.CORR_DT, 'YYYYMM') )" ).append("\n"); 
		query.append("                             END" ).append("\n"); 
		query.append("                       , 2))" ).append("\n"); 
		query.append("                  FROM BKG_CHG_RT X" ).append("\n"); 
		query.append("                 WHERE X.BKG_NO = A.BKG_NO" ).append("\n"); 
		query.append("                   AND X.CHG_CD = 'OCH') OCH" ).append("\n"); 
		query.append("              ,(SELECT MAX(TRF_ITM_NO) ||'^'||" ).append("\n"); 
		query.append("                       CASE WHEN MIN(CURR_CD) = MAX(CURR_CD) THEN MAX(CURR_CD) END ||'^'||" ).append("\n"); 
		query.append("                       CASE WHEN MIN(CURR_CD) = MAX(CURR_CD) THEN SUM(CHG_AMT) END ||'^'||" ).append("\n"); 
		query.append("                       MAX(RAT_AS_QTY) ||'^'||" ).append("\n"); 
		query.append("                       MAX(FRT_INCL_XCLD_DIV_CD) ||'^'||" ).append("\n"); 
		query.append("                       SUM(ROUND (X.CHG_AMT / " ).append("\n"); 
		query.append("                             CASE WHEN NVL(X.CURR_CD,'USD') = 'USD' THEN 1" ).append("\n"); 
		query.append("                                  ELSE (SELECT USD_LOCL_XCH_RT" ).append("\n"); 
		query.append("                                          FROM GL_MON_XCH_RT XCH" ).append("\n"); 
		query.append("                                         WHERE XCH.ACCT_XCH_RT_LVL = 1 " ).append("\n"); 
		query.append("                                           AND XCH.CURR_CD           = X.CURR_CD" ).append("\n"); 
		query.append("                                           AND XCH.ACCT_XCH_RT_YRMON = TO_CHAR(B.CORR_DT, 'YYYYMM') )" ).append("\n"); 
		query.append("                             END" ).append("\n"); 
		query.append("                       , 2))" ).append("\n"); 
		query.append("                  FROM BKG_CHG_RT X" ).append("\n"); 
		query.append("                 WHERE X.BKG_NO = A.BKG_NO" ).append("\n"); 
		query.append("                   AND X.CHG_CD = 'DCH') DCH" ).append("\n"); 
		query.append("              ,(SELECT MAX(TRF_ITM_NO) ||'^'||" ).append("\n"); 
		query.append("                       CASE WHEN MIN(CURR_CD) = MAX(CURR_CD) THEN MAX(CURR_CD) END ||'^'||" ).append("\n"); 
		query.append("                       CASE WHEN MIN(CURR_CD) = MAX(CURR_CD) THEN SUM(CHG_AMT) END ||'^'||" ).append("\n"); 
		query.append("                       MAX(RAT_AS_QTY) ||'^'||" ).append("\n"); 
		query.append("                       MAX(FRT_INCL_XCLD_DIV_CD) ||'^'||" ).append("\n"); 
		query.append("                       SUM(ROUND (X.CHG_AMT / " ).append("\n"); 
		query.append("                             CASE WHEN NVL(X.CURR_CD,'USD') = 'USD' THEN 1" ).append("\n"); 
		query.append("                                  ELSE (SELECT USD_LOCL_XCH_RT" ).append("\n"); 
		query.append("                                          FROM GL_MON_XCH_RT XCH" ).append("\n"); 
		query.append("                                         WHERE XCH.ACCT_XCH_RT_LVL = 1 " ).append("\n"); 
		query.append("                                           AND XCH.CURR_CD           = X.CURR_CD" ).append("\n"); 
		query.append("                                           AND XCH.ACCT_XCH_RT_YRMON = TO_CHAR(B.CORR_DT, 'YYYYMM') )" ).append("\n"); 
		query.append("                             END" ).append("\n"); 
		query.append("                       , 2))" ).append("\n"); 
		query.append("                  FROM BKG_CHG_RT X" ).append("\n"); 
		query.append("                 WHERE X.BKG_NO = A.BKG_NO" ).append("\n"); 
		query.append("                   AND X.CHG_CD = 'MIS') MIS" ).append("\n"); 
		query.append("          FROM BKG_BOOKING    A" ).append("\n"); 
		query.append("              ,BKG_CORRECTION B" ).append("\n"); 
		query.append("              ,BKG_BKG_HIS    C" ).append("\n"); 
		query.append("              ,BKG_BKG_HIS    D" ).append("\n"); 
		query.append("         WHERE A.BKG_NO  = B.BKG_NO" ).append("\n"); 
		query.append("           AND B.BKG_NO  = C.BKG_NO" ).append("\n"); 
		query.append("           AND B.CORR_NO = C.CORR_NO  " ).append("\n"); 
		query.append("           AND B.CORR_NO NOT IN ('0000000001', 'TMP0000001')   " ).append("\n"); 
		query.append("           AND B.ROUT_CORR_FLG = 'Y'" ).append("\n"); 
		query.append("           AND D.BKG_NO  = A.BKG_NO" ).append("\n"); 
		query.append("           AND D.CORR_NO = '0000000001'" ).append("\n"); 
		query.append("           " ).append("\n"); 
		query.append("           -- C/A Issue Date로 조회시" ).append("\n"); 
		query.append("		   #if( ${s_fm_dt} != '' && ${s_to_dt} != '')" ).append("\n"); 
		query.append("           AND B.CORR_DT BETWEEN TO_DATE(REPLACE(@[s_fm_dt],'-',''),'YYYYMMDD') AND TO_DATE(REPLACE(@[s_to_dt],'-',''),'YYYYMMDD') + 0.99998 " ).append("\n"); 
		query.append("           #end" ).append("\n"); 
		query.append("           -- RHQ로 조회시 -- 필수" ).append("\n"); 
		query.append("           AND B.CORR_OFC_CD IN (SELECT OFC_CD" ).append("\n"); 
		query.append("                                   FROM MDM_ORGANIZATION" ).append("\n"); 
		query.append("                                  WHERE DELT_FLG = 'N'" ).append("\n"); 
		query.append("                                CONNECT BY NOCYCLE PRIOR OFC_CD = PRNT_OFC_CD" ).append("\n"); 
		query.append("                                  START WITH OFC_CD = @[s_rhq_ofc_cd]" ).append("\n"); 
		query.append("                                )" ).append("\n"); 
		query.append("           #if(${s_ofc_cd} != '')                     " ).append("\n"); 
		query.append("                AND B.CORR_OFC_CD = @[s_ofc_cd]" ).append("\n"); 
		query.append("           #end" ).append("\n"); 
		query.append("           " ).append("\n"); 
		query.append("           #if(${s_ca_item_cd} == 'P')" ).append("\n"); 
		query.append("                AND NVL(D.POD_CD,'X') <> NVL(C.POD_CD,'X')" ).append("\n"); 
		query.append("           #elseif (${s_ca_item_cd} == 'D')" ).append("\n"); 
		query.append("                AND NVL(D.DEL_CD,'X') <> NVL(C.DEL_CD,'X')" ).append("\n"); 
		query.append("           #elseif (${s_ca_item_cd} == 'T')" ).append("\n"); 
		query.append("                AND NVL(D.PST_RLY_PORT_CD,'X') <> NVL(C.PST_RLY_PORT_CD,'X')" ).append("\n"); 
		query.append("           #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("           #if($s_ca_reason.size() > 0)" ).append("\n"); 
		query.append("                AND B.CA_RSN_CD IN ( " ).append("\n"); 
		query.append("                    #foreach( ${key} in ${s_ca_reason})" ).append("\n"); 
		query.append("                        #if($velocityCount == 1)" ).append("\n"); 
		query.append("                            '$key'" ).append("\n"); 
		query.append("                        #else" ).append("\n"); 
		query.append("                            , '$key'" ).append("\n"); 
		query.append("                        #end    " ).append("\n"); 
		query.append("                    #end" ).append("\n"); 
		query.append("                                )" ).append("\n"); 
		query.append("           #end" ).append("\n"); 
		query.append("           " ).append("\n"); 
		query.append("           #if(${s_vvd} != '')" ).append("\n"); 
		query.append("                AND (A.VSL_CD,A.SKD_VOY_NO,A.SKD_DIR_CD) IN ( (SUBSTR(@[s_vvd],1,4), SUBSTR(@[s_vvd],5,4), SUBSTR(@[s_vvd],9,1)) )" ).append("\n"); 
		query.append("           #end" ).append("\n"); 
		query.append("           -- BKG No로 조회시 (Multi로 입력 가능)" ).append("\n"); 
		query.append("           #if($s_bkg_no.size() > 0)" ).append("\n"); 
		query.append("                AND A.BKG_NO IN ( " ).append("\n"); 
		query.append("                    #foreach( ${key} in ${s_bkg_no})" ).append("\n"); 
		query.append("                        #if($velocityCount == 1)" ).append("\n"); 
		query.append("                            '$key'" ).append("\n"); 
		query.append("                        #else" ).append("\n"); 
		query.append("                            , '$key'" ).append("\n"); 
		query.append("                        #end    " ).append("\n"); 
		query.append("                    #end" ).append("\n"); 
		query.append("                                )" ).append("\n"); 
		query.append("           #end" ).append("\n"); 
		query.append("       ) AA" ).append("\n"); 
		query.append(" WHERE 1=1" ).append("\n"); 
		query.append("        #if ( ${s_scg_cd} == 'DVC')" ).append("\n"); 
		query.append("            AND REPLACE(DVC, '^', '') IS NOT NULL" ).append("\n"); 
		query.append("        #elseif ( ${s_scg_cd} == 'OCH')" ).append("\n"); 
		query.append("            AND REPLACE(OCH, '^', '') IS NOT NULL" ).append("\n"); 
		query.append("        #elseif ( ${s_scg_cd} == 'DCH')" ).append("\n"); 
		query.append("            AND REPLACE(DCH, '^', '') IS NOT NULL" ).append("\n"); 
		query.append("        #elseif ( ${s_scg_cd} == 'MIS')" ).append("\n"); 
		query.append("            AND REPLACE(MIS, '^', '') IS NOT NULL" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("		#if (${s_eac_if} != '')" ).append("\n"); 
		query.append("      		#if (${s_eac_if} == 'Y')" ).append("\n"); 
		query.append("         		AND EXISTS (SELECT	'1'" ).append("\n"); 
		query.append("                  		      FROM	EAS_DEST_CNG_CHK EE" ).append("\n"); 
		query.append("                		     WHERE	1=1" ).append("\n"); 
		query.append("									AND EE.BKG_NO = AA.BKG_NO " ).append("\n"); 
		query.append("									AND EE.CORR_NO = AA.CORR_NO" ).append("\n"); 
		query.append("                 		    )" ).append("\n"); 
		query.append("      		#else" ).append("\n"); 
		query.append("         		AND NOT EXISTS (SELECT	'1'" ).append("\n"); 
		query.append("                 		          FROM	EAS_DEST_CNG_CHK EE" ).append("\n"); 
		query.append("                	          	 WHERE	1=1" ).append("\n"); 
		query.append("										AND EE.BKG_NO = AA.BKG_NO " ).append("\n"); 
		query.append("										AND EE.CORR_NO = AA.CORR_NO" ).append("\n"); 
		query.append("                         	)" ).append("\n"); 
		query.append("      		#end" ).append("\n"); 
		query.append("   		#end" ).append("\n"); 
		query.append("ORDER BY CORR_DT" ).append("\n"); 

	}
}