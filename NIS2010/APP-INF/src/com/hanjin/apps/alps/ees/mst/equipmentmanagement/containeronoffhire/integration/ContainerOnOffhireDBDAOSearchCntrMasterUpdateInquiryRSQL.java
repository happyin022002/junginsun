/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : ContainerOnOffhireDBDAOSearchCntrMasterUpdateInquiryRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.01.18
*@LastModifier : 
*@LastVersion : 1.0
* 2017.01.18 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.mst.equipmentmanagement.containeronoffhire.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ContainerOnOffhireDBDAOSearchCntrMasterUpdateInquiryRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchCntrMasterUpdateInquiry
	  * </pre>
	  */
	public ContainerOnOffhireDBDAOSearchCntrMasterUpdateInquiryRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("chk_dgt",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.mst.equipmentmanagement.containeronoffhire.integration").append("\n"); 
		query.append("FileName : ContainerOnOffhireDBDAOSearchCntrMasterUpdateInquiryRSQL").append("\n"); 
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
		query.append("WITH PPARAM" ).append("\n"); 
		query.append("AS " ).append("\n"); 
		query.append("(SELECT /*+ INDEX( A XPKMST_CONTAINER) */" ).append("\n"); 
		query.append("                 CNTR_NO " ).append("\n"); 
		query.append("                 FROM MST_CONTAINER A" ).append("\n"); 
		query.append("                 WHERE 1 = 1" ).append("\n"); 
		query.append("                 ##${cntr_no}" ).append("\n"); 
		query.append("            #if(${noExit} == 'A')" ).append("\n"); 
		query.append("        		#if (${chk_dgt} == '')" ).append("\n"); 
		query.append("        		AND  A.CNTR_NO = @[cntr_no]" ).append("\n"); 
		query.append("       			#end" ).append("\n"); 
		query.append("        		#if (${chk_dgt} != '') " ).append("\n"); 
		query.append("        		AND  A.CNTR_NO = @[cntr_no] || @[chk_dgt]" ).append("\n"); 
		query.append("        		#end " ).append("\n"); 
		query.append("    		#end" ).append("\n"); 
		query.append("    	   #if(${noExit} == 'E')" ).append("\n"); 
		query.append("        		#if (${chk_dgt} == '')" ).append("\n"); 
		query.append("        		AND  A.CNTR_NO = MST_COMMON_PKG.MST_CNTR_NO_FNC(@[cntr_no])" ).append("\n"); 
		query.append("        		#end" ).append("\n"); 
		query.append("        		#if (${chk_dgt} != '') " ).append("\n"); 
		query.append("        		AND  A.CNTR_NO = @[cntr_no] || @[chk_dgt]" ).append("\n"); 
		query.append("        		#end " ).append("\n"); 
		query.append("    	   #end " ).append("\n"); 
		query.append("                 AND CNMV_DT = (" ).append("\n"); 
		query.append("                               SELECT MAX(CNMV_DT) " ).append("\n"); 
		query.append("                               FROM MST_CONTAINER " ).append("\n"); 
		query.append("                               WHERE 1 = 1" ).append("\n"); 
		query.append("                               ##${cntr_no}" ).append("\n"); 
		query.append("                              #if(${noExit} == 'A')" ).append("\n"); 
		query.append("       							 #if (${chk_dgt} == '')" ).append("\n"); 
		query.append("        					   AND  CNTR_NO = @[cntr_no]" ).append("\n"); 
		query.append("        						 #end" ).append("\n"); 
		query.append("        					   #if (${chk_dgt} != '') " ).append("\n"); 
		query.append("        					   AND  CNTR_NO = @[cntr_no] || @[chk_dgt]" ).append("\n"); 
		query.append("        					   #end " ).append("\n"); 
		query.append("                           #end" ).append("\n"); 
		query.append("    					   #if(${noExit} == 'E')" ).append("\n"); 
		query.append("        						#if (${chk_dgt} == '')" ).append("\n"); 
		query.append("       						   AND  CNTR_NO = MST_COMMON_PKG.MST_CNTR_NO_FNC(@[cntr_no])" ).append("\n"); 
		query.append("        						#end" ).append("\n"); 
		query.append("        						#if (${chk_dgt} != '') " ).append("\n"); 
		query.append("        						AND  CNTR_NO = @[cntr_no] || @[chk_dgt]" ).append("\n"); 
		query.append("       					    	 #end " ).append("\n"); 
		query.append("   						 #end " ).append("\n"); 
		query.append("                               )" ).append("\n"); 
		query.append("                 AND ROWNUM = 1 " ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("    SELECT" ).append("\n"); 
		query.append("        A.CNTR_NO," ).append("\n"); 
		query.append("        SUBSTR(A.CNTR_NO,11) CHK_DGT," ).append("\n"); 
		query.append("        DECODE(A.ACIAC_DIV_CD, 'I', 'Inactive','A','Active') ACIAC_DIV_CD," ).append("\n"); 
		query.append("        A.CNTR_TPSZ_CD," ).append("\n"); 
		query.append("        B.CNTR_TPSZ_ISO_CD," ).append("\n"); 
		query.append("        A.CNTR_MTRL_CD," ).append("\n"); 
		query.append("        E.TARE_WGT," ).append("\n"); 
		query.append("        E.CNTR_SPEC_NO," ).append("\n"); 
		query.append("        ROUND(TO_NUMBER(E.TARE_WGT) * 2.2046) TARE_WGT_LBS," ).append("\n"); 
		query.append("        A.LSTM_CD," ).append("\n"); 
		query.append("	    CASE WHEN A.ACIAC_DIV_CD = 'I' THEN " ).append("\n"); 
		query.append("	         CASE WHEN F.CNTR_STS_CD IN ('SBO', 'MUO', 'SBI', 'MUI') THEN (SELECT X.LSTM_CD " ).append("\n"); 
		query.append("	                                                                       FROM LSE_AGREEMENT X " ).append("\n"); 
		query.append("	                                                                       WHERE  F.AGMT_CTY_CD = X.AGMT_CTY_CD" ).append("\n"); 
		query.append("                                                                           AND    F.AGMT_SEQ    = X.AGMT_SEQ)" ).append("\n"); 
		query.append("	         ELSE A.LSTM_CD END" ).append("\n"); 
		query.append("	    ELSE A.LSTM_CD END SUB_LSTM_CD,              " ).append("\n"); 
		query.append("        (SELECT DECODE(INTG_CD_VAL_CTNT,'H','SM Line',INTG_CD_VAL_DP_DESC)" ).append("\n"); 
		query.append("         FROM COM_INTG_CD_DTL" ).append("\n"); 
		query.append("         WHERE INTG_CD_ID ='CD01020'" ).append("\n"); 
		query.append("         AND INTG_CD_VAL_CTNT = A.CNTR_USE_CO_CD" ).append("\n"); 
		query.append("        ) CNTR_USE_CO_CD," ).append("\n"); 
		query.append("        (SELECT DECODE(INTG_CD_VAL_CTNT,'H','SM Line',INTG_CD_VAL_DP_DESC)" ).append("\n"); 
		query.append("         FROM COM_INTG_CD_DTL" ).append("\n"); 
		query.append("         WHERE INTG_CD_ID ='CD01047'" ).append("\n"); 
		query.append("         AND INTG_CD_VAL_CTNT = A.OWNR_CO_CD" ).append("\n"); 
		query.append("        ) OWNR_CO_CD," ).append("\n"); 
		query.append("        A.MFTR_VNDR_SEQ VNDR_ABBR_NM," ).append("\n"); 
		query.append("        C.VNDR_ABBR_NM  VNDR_LGL_ENG_NM," ).append("\n"); 
		query.append("        TO_CHAR(A.MFT_DT, 'YYYY-MM-DD') MFT_DT," ).append("\n"); 
		query.append("        A.D2_PAYLD_FLG," ).append("\n"); 
		query.append("        A.RF_TP_CD" ).append("\n"); 
		query.append("    FROM " ).append("\n"); 
		query.append("    MST_CONTAINER A," ).append("\n"); 
		query.append("    MDM_CNTR_TP_SZ B," ).append("\n"); 
		query.append("    (" ).append("\n"); 
		query.append("        SELECT " ).append("\n"); 
		query.append("           BB.VNDR_ABBR_NM," ).append("\n"); 
		query.append("           BB.VNDR_LGL_ENG_NM," ).append("\n"); 
		query.append("           BB.VNDR_SEQ" ).append("\n"); 
		query.append("        FROM" ).append("\n"); 
		query.append("           MST_CONTAINER AA, " ).append("\n"); 
		query.append("           MDM_VENDOR BB," ).append("\n"); 
		query.append("           PPARAM P" ).append("\n"); 
		query.append("        WHERE AA.CNTR_NO = P.CNTR_NO" ).append("\n"); 
		query.append("        AND   AA.MFTR_VNDR_SEQ = BB.VNDR_SEQ" ).append("\n"); 
		query.append("    ) C," ).append("\n"); 
		query.append("    (" ).append("\n"); 
		query.append("        SELECT" ).append("\n"); 
		query.append("          AA.VNDR_SEQ," ).append("\n"); 
		query.append("          BB.VNDR_LGL_ENG_NM" ).append("\n"); 
		query.append("        FROM " ).append("\n"); 
		query.append("          MST_CONTAINER AA," ).append("\n"); 
		query.append("          MDM_VENDOR BB," ).append("\n"); 
		query.append("          PPARAM P" ).append("\n"); 
		query.append("        WHERE AA.CNTR_NO    = P.CNTR_NO" ).append("\n"); 
		query.append("        AND   AA.VNDR_SEQ   = BB.VNDR_SEQ" ).append("\n"); 
		query.append("    ) D," ).append("\n"); 
		query.append("    (" ).append("\n"); 
		query.append("        SELECT NVL(A.TARE_WGT, C.CNTR_TPSZ_TARE_WGT) TARE_WGT, A.CNTR_SPEC_NO " ).append("\n"); 
		query.append("        FROM" ).append("\n"); 
		query.append("        (" ).append("\n"); 
		query.append("        SELECT B.TARE_WGT, B.CNTR_TPSZ_CD, B.CNTR_SPEC_NO " ).append("\n"); 
		query.append("        FROM MST_CNTR_SPEC B, MST_CONTAINER C, PPARAM P" ).append("\n"); 
		query.append("        WHERE 1 = 1 " ).append("\n"); 
		query.append("        AND   C.CNTR_NO = P.CNTR_NO" ).append("\n"); 
		query.append("        AND   C.CNTR_SPEC_NO = B.CNTR_SPEC_NO" ).append("\n"); 
		query.append("        ) A, " ).append("\n"); 
		query.append("        (SELECT A.CNTR_TPSZ_TARE_WGT, A.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("         FROM MDM_CNTR_TP_SZ A, MST_CONTAINER C, PPARAM P" ).append("\n"); 
		query.append("         WHERE  1 = 1" ).append("\n"); 
		query.append("         AND   C.CNTR_NO = P.CNTR_NO" ).append("\n"); 
		query.append("         AND   A.CNTR_TPSZ_CD = C.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("        ) C   " ).append("\n"); 
		query.append("        WHERE" ).append("\n"); 
		query.append("          A.CNTR_TPSZ_CD(+) = C.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("    ) E," ).append("\n"); 
		query.append("    MST_CNTR_STS_HIS F, " ).append("\n"); 
		query.append("    LSE_AGREEMENT G," ).append("\n"); 
		query.append("    (" ).append("\n"); 
		query.append("        SELECT MAX(CNTR_STS_SEQ) MAX_STS_SEQ, A.CNTR_NO " ).append("\n"); 
		query.append("        FROM" ).append("\n"); 
		query.append("        MST_CNTR_STS_HIS A," ).append("\n"); 
		query.append("        PPARAM P" ).append("\n"); 
		query.append("        WHERE 1 = 1" ).append("\n"); 
		query.append("        AND    A.CNTR_NO = P.CNTR_NO" ).append("\n"); 
		query.append("        GROUP BY A.CNTR_NO" ).append("\n"); 
		query.append("    ) H," ).append("\n"); 
		query.append("    PPARAM P   " ).append("\n"); 
		query.append("    WHERE 1 = 1" ).append("\n"); 
		query.append("    AND A.CNTR_NO = P.CNTR_NO" ).append("\n"); 
		query.append("    AND H.CNTR_NO = A.CNTR_NO" ).append("\n"); 
		query.append("    AND H.CNTR_NO     = F.CNTR_NO" ).append("\n"); 
		query.append("    AND H.MAX_STS_SEQ = F.CNTR_STS_SEQ" ).append("\n"); 
		query.append("    AND G.AGMT_CTY_CD = A.AGMT_CTY_CD" ).append("\n"); 
		query.append("    AND G.AGMT_SEQ    = A.AGMT_SEQ" ).append("\n"); 
		query.append("    AND B.CNTR_TPSZ_CD  =    A.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("    AND A.MFTR_VNDR_SEQ =    C.VNDR_SEQ(+)" ).append("\n"); 
		query.append("    AND A.VNDR_SEQ      =    D.VNDR_SEQ(+)" ).append("\n"); 

	}
}