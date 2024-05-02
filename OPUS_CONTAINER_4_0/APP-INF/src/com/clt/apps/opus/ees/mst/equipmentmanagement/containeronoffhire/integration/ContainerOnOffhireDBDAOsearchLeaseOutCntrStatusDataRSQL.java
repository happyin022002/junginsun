/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : ContainerOnOffhireDBDAOsearchLeaseOutCntrStatusDataRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.11.30
*@LastModifier : 
*@LastVersion : 1.0
* 2016.11.30 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.mst.equipmentmanagement.containeronoffhire.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ContainerOnOffhireDBDAOsearchLeaseOutCntrStatusDataRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchLeaseOutCntrStatusData
	  * </pre>
	  */
	public ContainerOnOffhireDBDAOsearchLeaseOutCntrStatusDataRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("agmt_cty_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sts_evnt_yd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("hid_cntr_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("approval_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("agmt_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.mst.equipmentmanagement.containeronoffhire.integration").append("\n"); 
		query.append("FileName : ContainerOnOffhireDBDAOsearchLeaseOutCntrStatusDataRSQL").append("\n"); 
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
		query.append("SELECT                                                                                                " ).append("\n"); 
		query.append("   AA.EEFLG,                                                                                             " ).append("\n"); 
		query.append("   AA.CNTR_NO,                                                                                           " ).append("\n"); 
		query.append("   '' OFFH_STS_CD,                                                                                       " ).append("\n"); 
		query.append("   '' OFFH_DUE_DT,                                                                                       " ).append("\n"); 
		query.append("   AA.CNTR_TPSZ_CD,                                                                                       " ).append("\n"); 
		query.append("   AA.LSTM_CD,                                                                                           " ).append("\n"); 
		query.append("   AA.AGMT_CTY_CD,                                                                                       " ).append("\n"); 
		query.append("   AA.AGMT_NO,                                                                                           " ).append("\n"); 
		query.append("   AA.REF_NO,                                                                                            " ).append("\n"); 
		query.append("   AA.VNDR_SEQ,                                                                                          " ).append("\n"); 
		query.append("   AA.VNDR_LGL_ENG_NM,                                                                                   " ).append("\n"); 
		query.append("   AA.CNTR_STS_CD,                                                                                       " ).append("\n"); 
		query.append("   AA.CNTR_STS_EVNT_DT,                                                                                   " ).append("\n"); 
		query.append("   AA.FULL_FLG,                                                                                          " ).append("\n"); 
		query.append("   AA.CNMV_STS_CD,                                                                                       " ).append("\n"); 
		query.append("   AA.CRNT_YD_CD,                                                                                        " ).append("\n"); 
		query.append("   AA.CNMV_DT,                                                                                           " ).append("\n"); 
		query.append("   AA.CNTR_DOC_CHG_AMT AS CNTR_DRFF_AMT,                                                                                     " ).append("\n"); 
		query.append("   '' CNTR_DRFF_CR_AMT,                                                                                  " ).append("\n"); 
		query.append("   AA.CNTR_LFT_CHG_AMT,                                                                                  " ).append("\n"); 
		query.append("   AA.CNTR_LFT_CHG_CUR,  " ).append("\n"); 
		query.append("   #if (${approval_no} == '')" ).append("\n"); 
		query.append("   	#if (${st_cd} == '2')" ).append("\n"); 
		query.append("   		'' RNTL_CHG_FREE_DYS," ).append("\n"); 
		query.append("   	#else                                                                                " ).append("\n"); 
		query.append("   		AA.RNTL_CHG_FREE_DYS," ).append("\n"); 
		query.append("   	#end " ).append("\n"); 
		query.append("    '' CNTR_PKUP_CHG_AMT,                                                                                 " ).append("\n"); 
		query.append("    '' CNTR_PKUP_CR_CHG_AMT,     " ).append("\n"); 
		query.append("   #else" ).append("\n"); 
		query.append("     AA.FREE_DYS AS RNTL_CHG_FREE_DYS," ).append("\n"); 
		query.append("     AA.PKUP_CHG_AMT AS CNTR_PKUP_CHG_AMT," ).append("\n"); 
		query.append("     AA.PKUP_CHG_CR_AMT AS CNTR_PKUP_CR_CHG_AMT," ).append("\n"); 
		query.append("   #end                                                                             " ).append("\n"); 
		query.append("   '' CNTR_OLD_VAN_FLG,                                                              " ).append("\n"); 
		query.append("   '' CNTR_RMK," ).append("\n"); 
		query.append("   AA.EFF_DT," ).append("\n"); 
		query.append("   AA.EXP_DT                                                                          " ).append("\n"); 
		query.append("FROM                                                                                                  " ).append("\n"); 
		query.append("(                                                                                                     " ).append("\n"); 
		query.append("   SELECT                                                                                                " ).append("\n"); 
		query.append("      '' EEFLG," ).append("\n"); 
		query.append("      B.CNTR_NO,                                                                                            " ).append("\n"); 
		query.append("      B.CNTR_TPSZ_CD,                                                                                       " ).append("\n"); 
		query.append("      B.LSTM_CD,                                                                                            " ).append("\n"); 
		query.append("      B.AGMT_CTY_CD,                                                                                        " ).append("\n"); 
		query.append("      MST_COMMON_PKG.MST_AGMT_NO_CONV_FNC(B.AGMT_CTY_CD,B.AGMT_SEQ)  AS AGMT_NO,                            " ).append("\n"); 
		query.append("      C.REF_NO,                                                                                             " ).append("\n"); 
		query.append("      B.VNDR_SEQ,                                                                                           " ).append("\n"); 
		query.append("      D.VNDR_LGL_ENG_NM,                                                                                    " ).append("\n"); 
		query.append("      B.CNTR_STS_CD,                                                                                        " ).append("\n"); 
		query.append("      (SELECT /*+ INDEX_DESC(H XAK1MST_CNTR_STS_HIS) */ TO_CHAR(H.CNTR_STS_EVNT_DT,'YYYY-MM-DD')             " ).append("\n"); 
		query.append("      FROM MST_CNTR_STS_HIS H                                                                               " ).append("\n"); 
		query.append("      WHERE H.CNTR_NO = B.CNTR_NO                                                                           " ).append("\n"); 
		query.append("      AND   H.CNTR_STS_SEQ = B.LST_STS_SEQ                                                                   " ).append("\n"); 
		query.append("      AND   ROWNUM = 1                                                                                      " ).append("\n"); 
		query.append("      ) CNTR_STS_EVNT_DT,                                                                                   " ).append("\n"); 
		query.append("      DECODE(B.FULL_FLG, 'Y', 'F', 'N', 'M') FULL_FLG,                                                      " ).append("\n"); 
		query.append("      B.CNMV_STS_CD,                                                                                        " ).append("\n"); 
		query.append("      B.CRNT_YD_CD,                                                                                         " ).append("\n"); 
		query.append("      TO_CHAR(B.CNMV_DT, 'YYYY-MM-DD') CNMV_DT," ).append("\n"); 
		query.append("      #if (${approval_no} == '')" ).append("\n"); 
		query.append("      	NVL(MST_COMMON_PKG.MST_LSE_AGMT_RT_GET_FNC(NVL(@[agmt_cty_cd], C.AGMT_CTY_CD), NVL(@[agmt_seq], C.AGMT_SEQ), 'LOF', B.CNTR_TPSZ_CD, @[sts_evnt_yd_cd]), 0) AS CNTR_LFT_CHG_AMT," ).append("\n"); 
		query.append("      	NVL(MST_COMMON_PKG.MST_LSE_AGMT_RT_GET_FNC(NVL(@[agmt_cty_cd], C.AGMT_CTY_CD), NVL(@[agmt_seq], C.AGMT_SEQ), 'DOC', B.CNTR_TPSZ_CD, @[sts_evnt_yd_cd]), 0) AS CNTR_DOC_CHG_AMT,                                                                                                                                               " ).append("\n"); 
		query.append("      	(SELECT CURR_CD                                                                                       " ).append("\n"); 
		query.append("      		FROM LSE_AGREEMENT                                                                                    " ).append("\n"); 
		query.append("      		WHERE AGMT_CTY_CD = NVL(@[agmt_cty_cd], C.AGMT_CTY_CD)                                                                   " ).append("\n"); 
		query.append("      		AND   AGMT_SEQ    = NVL(@[agmt_seq], C.AGMT_SEQ)                                                                      " ).append("\n"); 
		query.append("      		) CNTR_LFT_CHG_CUR,                                                                                   " ).append("\n"); 
		query.append("      	(SELECT LSE_FREE_DYS                                                                                  " ).append("\n"); 
		query.append("      		FROM LSE_AGREEMENT                                                                                    " ).append("\n"); 
		query.append("      		WHERE AGMT_CTY_CD = NVL(@[agmt_cty_cd], C.AGMT_CTY_CD)                                                                    " ).append("\n"); 
		query.append("      		AND   AGMT_SEQ    = NVL(@[agmt_seq], C.AGMT_SEQ)                                                                        " ).append("\n"); 
		query.append("      		) RNTL_CHG_FREE_DYS   , " ).append("\n"); 
		query.append("      #else  " ).append("\n"); 
		query.append("        (SELECT LFT_CHG_AMT FROM LSE_ONH_APRO_QTY " ).append("\n"); 
		query.append("			WHERE CNTR_ONH_AUTH_NO 	= @[approval_no] " ).append("\n"); 
		query.append("			AND AGMT_CTY_CD 		= NVL(@[agmt_cty_cd], C.AGMT_CTY_CD)                                                                    " ).append("\n"); 
		query.append("        	AND   AGMT_SEQ    		= NVL(@[agmt_seq], C.AGMT_SEQ) " ).append("\n"); 
		query.append("			AND B.CNTR_TPSZ_CD		= CNTR_TPSZ_CD " ).append("\n"); 
		query.append("			AND NEW_VAN_TP_CD='N') AS CNTR_LFT_CHG_AMT, " ).append("\n"); 
		query.append("      " ).append("\n"); 
		query.append("        NVL(MST_COMMON_PKG.MST_LSE_AGMT_RT_GET_FNC(NVL(@[agmt_cty_cd], C.AGMT_CTY_CD), NVL(@[agmt_seq], C.AGMT_SEQ), 'DOC', B.CNTR_TPSZ_CD, @[sts_evnt_yd_cd]), 0) AS CNTR_DOC_CHG_AMT, " ).append("\n"); 
		query.append("        " ).append("\n"); 
		query.append("	    (SELECT CURR_CD                                                                                       " ).append("\n"); 
		query.append("      		FROM LSE_AGREEMENT                                                                                    " ).append("\n"); 
		query.append("      		WHERE AGMT_CTY_CD = NVL(@[agmt_cty_cd], C.AGMT_CTY_CD)                                                                   " ).append("\n"); 
		query.append("      		AND   AGMT_SEQ    = NVL(@[agmt_seq], C.AGMT_SEQ)                                                                      " ).append("\n"); 
		query.append("      		) CNTR_LFT_CHG_CUR, " ).append("\n"); 
		query.append("  " ).append("\n"); 
		query.append("        (SELECT FREE_DYS FROM LSE_ONH_APRO D WHERE 1=1 " ).append("\n"); 
		query.append("   			AND  D.CNTR_ONH_AUTH_NO = @[approval_no] " ).append("\n"); 
		query.append("   			AND  D.AGMT_CTY_CD = NVL(@[agmt_cty_cd], C.AGMT_CTY_CD)" ).append("\n"); 
		query.append("   			AND  D.AGMT_SEQ    = NVL(@[agmt_seq], C.AGMT_SEQ) " ).append("\n"); 
		query.append("		) AS  FREE_DYS , " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("		(SELECT PKUP_CHG_AMT FROM LSE_ONH_APRO D WHERE 1=1 " ).append("\n"); 
		query.append("   			AND  D.CNTR_ONH_AUTH_NO = @[approval_no] " ).append("\n"); 
		query.append("   			AND  D.AGMT_CTY_CD = NVL(@[agmt_cty_cd], C.AGMT_CTY_CD)" ).append("\n"); 
		query.append("   			AND  D.AGMT_SEQ    = NVL(@[agmt_seq], C.AGMT_SEQ)   " ).append("\n"); 
		query.append("		) AS  PKUP_CHG_AMT ," ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("		(SELECT PKUP_CHG_CR_AMT FROM LSE_ONH_APRO D WHERE 1=1 " ).append("\n"); 
		query.append("   			AND  D.CNTR_ONH_AUTH_NO = @[approval_no] " ).append("\n"); 
		query.append("            AND  D.AGMT_CTY_CD = NVL(@[agmt_cty_cd], C.AGMT_CTY_CD)" ).append("\n"); 
		query.append("   			AND  D.AGMT_SEQ    = NVL(@[agmt_seq], C.AGMT_SEQ)    " ).append("\n"); 
		query.append("		) AS  PKUP_CHG_CR_AMT,                                 " ).append("\n"); 
		query.append("      #end" ).append("\n"); 
		query.append("      TO_CHAR(C.LST_EFF_DT,'YYYY-MM-DD') AS EFF_DT ," ).append("\n"); 
		query.append("      TO_CHAR(C.LST_EXP_DT,'YYYY-MM-DD') AS EXP_DT " ).append("\n"); 
		query.append("   FROM                                                                                                  " ).append("\n"); 
		query.append("      MST_CONTAINER  B,                                                                                     " ).append("\n"); 
		query.append("      LSE_AGREEMENT C,                                                                                      " ).append("\n"); 
		query.append("      MDM_VENDOR D                                                                                          " ).append("\n"); 
		query.append("   WHERE 1 = 1                                                                                           " ).append("\n"); 
		query.append("      AND  B.CNTR_NO      =  @[hid_cntr_no]                                                                 " ).append("\n"); 
		query.append("      AND  C.AGMT_CTY_CD  =  B.AGMT_CTY_CD                                                                  " ).append("\n"); 
		query.append("      AND  C.AGMT_SEQ     =  B.AGMT_SEQ                                                                     " ).append("\n"); 
		query.append("      AND  D.VNDR_SEQ     =  B.VNDR_SEQ                                                                     " ).append("\n"); 
		query.append(") AA" ).append("\n"); 

	}
}