/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : BlRatingDBDAOSearchTaaCustInformRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.05.15
*@LastModifier : 
*@LastVersion : 1.0
* 2012.05.15 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.outbounddocumentation.blrating.blrating.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BlRatingDBDAOSearchTaaCustInformRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * BlRatingDBDAOSearchTaaCustInform - TAA Customer 정보 조회
	  * </pre>
	  */
	public BlRatingDBDAOSearchTaaCustInformRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("taa_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.outbounddocumentation.blrating.blrating.integration").append("\n"); 
		query.append("FileName : BlRatingDBDAOSearchTaaCustInformRSQL").append("\n"); 
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
		query.append("#if (${ca_flg} == 'Y') " ).append("\n"); 
		query.append("SELECT " ).append("\n"); 
		query.append("	BKG_NO ," ).append("\n"); 
		query.append("	MAX(DECODE(BKG_CUST_TP_CD,'S',CUST_CNT_CD,'')) S_CUST_CNT_CD," ).append("\n"); 
		query.append("	MAX(DECODE(BKG_CUST_TP_CD,'S',CUST_SEQ,'')) S_CUST_SEQ," ).append("\n"); 
		query.append("	MAX(DECODE(BKG_CUST_TP_CD,'S',CUST_NM,'')) S_CUST_NM," ).append("\n"); 
		query.append("	MAX(DECODE(BKG_CUST_TP_CD,'C',CUST_CNT_CD,'')) C_CUST_CNT_CD," ).append("\n"); 
		query.append("	MAX(DECODE(BKG_CUST_TP_CD,'C',CUST_SEQ,'')) C_CUST_SEQ," ).append("\n"); 
		query.append("	MAX(DECODE(BKG_CUST_TP_CD,'C',CUST_NM,'')) C_CUST_NM," ).append("\n"); 
		query.append("	MAX(DECODE(BKG_CUST_TP_CD,'N',CUST_CNT_CD,'')) N_CUST_CNT_CD," ).append("\n"); 
		query.append("	MAX(DECODE(BKG_CUST_TP_CD,'N',CUST_SEQ,'')) N_CUST_SEQ," ).append("\n"); 
		query.append("	MAX(DECODE(BKG_CUST_TP_CD,'N',CUST_NM,'')) N_CUST_NM," ).append("\n"); 
		query.append("	MAX(DECODE(BKG_CUST_TP_CD,'A',CUST_CNT_CD,'')) A_CUST_CNT_CD," ).append("\n"); 
		query.append("	MAX(DECODE(BKG_CUST_TP_CD,'A',CUST_SEQ,'')) A_CUST_SEQ," ).append("\n"); 
		query.append("	MAX(DECODE(BKG_CUST_TP_CD,'A',CUST_NM,'')) A_CUST_NM," ).append("\n"); 
		query.append("	MAX(DECODE(BKG_CUST_TP_CD,'P',CUST_CNT_CD,'')) P_CUST_CNT_CD," ).append("\n"); 
		query.append("	MAX(DECODE(BKG_CUST_TP_CD,'P',CUST_SEQ,'')) P_CUST_SEQ," ).append("\n"); 
		query.append("	MAX(DECODE(BKG_CUST_TP_CD,'P',CUST_NM,'')) P_CUST_NM" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("	SELECT " ).append("\n"); 
		query.append("		BKG_NO" ).append("\n"); 
		query.append("		,BKG_CUST_TP_CD" ).append("\n"); 
		query.append("		,CUST_CNT_CD" ).append("\n"); 
		query.append("		,CUST_SEQ" ).append("\n"); 
		query.append("		,CUST_NM" ).append("\n"); 
		query.append("	FROM " ).append("\n"); 
		query.append("		BKG_CUST_HIS " ).append("\n"); 
		query.append("	WHERE " ).append("\n"); 
		query.append("		BKG_NO= @[bkg_no]" ).append("\n"); 
		query.append("		AND BKG_CUST_TP_CD IN ('S','C','N','A')" ).append("\n"); 
		query.append("		AND CORR_NO ='TMP0000001'" ).append("\n"); 
		query.append("	UNION ALL " ).append("\n"); 
		query.append("	SELECT" ).append("\n"); 
		query.append("		@[bkg_no] AS BKG_NO," ).append("\n"); 
		query.append("		'P' BKG_CUST_TP_CD," ).append("\n"); 
		query.append("		MN.CTRT_CUST_CNT_CD CUST_CNT_CD ,MN.CTRT_CUST_SEQ CUST_SEQ," ).append("\n"); 
		query.append("        (SELECT CUST_LGL_ENG_NM FROM MDM_CUSTOMER " ).append("\n"); 
		query.append("         WHERE CUST_CNT_CD = MN.CTRT_CUST_CNT_CD" ).append("\n"); 
		query.append("           AND CUST_SEQ = MN.CTRT_CUST_SEQ) CUST_NM" ).append("\n"); 
		query.append("	 FROM PRI_TAA_MN MN, PRI_TAA_HDR HDR" ).append("\n"); 
		query.append("	 WHERE 1=1" ).append("\n"); 
		query.append("	   AND HDR.TAA_NO =@[taa_no] -- KEY가 TAA NO 가 아니네? " ).append("\n"); 
		query.append("	   AND MN.TAA_PROP_NO = HDR.TAA_PROP_NO" ).append("\n"); 
		query.append("	   AND MN.CFM_FLG = 'Y'" ).append("\n"); 
		query.append("	   AND MN.AMDT_SEQ = (SELECT MAX(K.AMDT_SEQ) " ).append("\n"); 
		query.append("    	                  FROM PRI_TAA_MN K, PRI_TAA_HDR HD" ).append("\n"); 
		query.append("        	              WHERE 1=1" ).append("\n"); 
		query.append("            	            AND HD.TAA_NO =@[taa_no] -- KEY가 TAA NO 가 아니네? " ).append("\n"); 
		query.append("                	        AND K.TAA_PROP_NO = HD.TAA_PROP_NO" ).append("\n"); 
		query.append("                    	    AND MN.CFM_FLG = 'Y' )" ).append("\n"); 
		query.append("	)" ).append("\n"); 
		query.append("GROUP BY BKG_NO" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("SELECT " ).append("\n"); 
		query.append("	BKG_NO ," ).append("\n"); 
		query.append("	MAX(DECODE(BKG_CUST_TP_CD,'S',CUST_CNT_CD,'')) S_CUST_CNT_CD," ).append("\n"); 
		query.append("	MAX(DECODE(BKG_CUST_TP_CD,'S',CUST_SEQ,'')) S_CUST_SEQ," ).append("\n"); 
		query.append("	MAX(DECODE(BKG_CUST_TP_CD,'S',CUST_NM,'')) S_CUST_NM," ).append("\n"); 
		query.append("	MAX(DECODE(BKG_CUST_TP_CD,'C',CUST_CNT_CD,'')) C_CUST_CNT_CD," ).append("\n"); 
		query.append("	MAX(DECODE(BKG_CUST_TP_CD,'C',CUST_SEQ,'')) C_CUST_SEQ," ).append("\n"); 
		query.append("	MAX(DECODE(BKG_CUST_TP_CD,'C',CUST_NM,'')) C_CUST_NM," ).append("\n"); 
		query.append("	MAX(DECODE(BKG_CUST_TP_CD,'N',CUST_CNT_CD,'')) N_CUST_CNT_CD," ).append("\n"); 
		query.append("	MAX(DECODE(BKG_CUST_TP_CD,'N',CUST_SEQ,'')) N_CUST_SEQ," ).append("\n"); 
		query.append("	MAX(DECODE(BKG_CUST_TP_CD,'N',CUST_NM,'')) N_CUST_NM," ).append("\n"); 
		query.append("	MAX(DECODE(BKG_CUST_TP_CD,'A',CUST_CNT_CD,'')) A_CUST_CNT_CD," ).append("\n"); 
		query.append("	MAX(DECODE(BKG_CUST_TP_CD,'A',CUST_SEQ,'')) A_CUST_SEQ," ).append("\n"); 
		query.append("	MAX(DECODE(BKG_CUST_TP_CD,'A',CUST_NM,'')) A_CUST_NM," ).append("\n"); 
		query.append("	MAX(DECODE(BKG_CUST_TP_CD,'P',CUST_CNT_CD,'')) P_CUST_CNT_CD," ).append("\n"); 
		query.append("	MAX(DECODE(BKG_CUST_TP_CD,'P',CUST_SEQ,'')) P_CUST_SEQ," ).append("\n"); 
		query.append("	MAX(DECODE(BKG_CUST_TP_CD,'P',CUST_NM,'')) P_CUST_NM" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("	SELECT " ).append("\n"); 
		query.append("		BKG_NO" ).append("\n"); 
		query.append("		,BKG_CUST_TP_CD" ).append("\n"); 
		query.append("		,CUST_CNT_CD" ).append("\n"); 
		query.append("		,CUST_SEQ" ).append("\n"); 
		query.append("		,CUST_NM" ).append("\n"); 
		query.append("	FROM " ).append("\n"); 
		query.append("		BKG_CUSTOMER" ).append("\n"); 
		query.append("	WHERE " ).append("\n"); 
		query.append("		BKG_NO= @[bkg_no]" ).append("\n"); 
		query.append("		AND BKG_CUST_TP_CD IN ('S','C','N','A')" ).append("\n"); 
		query.append("	UNION ALL " ).append("\n"); 
		query.append("	SELECT" ).append("\n"); 
		query.append("		@[bkg_no] AS BKG_NO," ).append("\n"); 
		query.append("		'P' BKG_CUST_TP_CD," ).append("\n"); 
		query.append("		MN.CTRT_CUST_CNT_CD CUST_CNT_CD ,MN.CTRT_CUST_SEQ CUST_SEQ," ).append("\n"); 
		query.append("        (SELECT CUST_LGL_ENG_NM FROM MDM_CUSTOMER " ).append("\n"); 
		query.append("         WHERE CUST_CNT_CD = MN.CTRT_CUST_CNT_CD" ).append("\n"); 
		query.append("           AND CUST_SEQ = MN.CTRT_CUST_SEQ) CUST_NM" ).append("\n"); 
		query.append("	 FROM PRI_TAA_MN MN, PRI_TAA_HDR HDR" ).append("\n"); 
		query.append("	 WHERE 1=1" ).append("\n"); 
		query.append("	   AND HDR.TAA_NO =@[taa_no] -- KEY가 TAA NO 가 아니네? " ).append("\n"); 
		query.append("	   AND MN.TAA_PROP_NO = HDR.TAA_PROP_NO" ).append("\n"); 
		query.append("	   AND MN.CFM_FLG = 'Y'" ).append("\n"); 
		query.append("	   AND MN.AMDT_SEQ = (SELECT MAX(K.AMDT_SEQ) " ).append("\n"); 
		query.append("    	                  FROM PRI_TAA_MN K, PRI_TAA_HDR HD" ).append("\n"); 
		query.append("        	              WHERE 1=1" ).append("\n"); 
		query.append("            	            AND HD.TAA_NO =@[taa_no] -- KEY가 TAA NO 가 아니네? " ).append("\n"); 
		query.append("                	        AND K.TAA_PROP_NO = HD.TAA_PROP_NO" ).append("\n"); 
		query.append("                    	    AND MN.CFM_FLG = 'Y' )" ).append("\n"); 
		query.append("	)" ).append("\n"); 
		query.append("GROUP BY BKG_NO" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}