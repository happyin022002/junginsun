/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : BlRatingDBDAOSearchScCustInformRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.04.08
*@LastModifier : 김태경
*@LastVersion : 1.0
* 2010.04.08 김태경
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.outbounddocumentation.blrating.blrating.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author kim tae kyoung
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BlRatingDBDAOSearchScCustInformRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchScCustInform
	  * </pre>
	  */
	public BlRatingDBDAOSearchScCustInformRSQL(){
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
		params.put("sc_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.outbounddocumentation.blrating.blrating.integration").append("\n"); 
		query.append("FileName : BlRatingDBDAOSearchScCustInformRSQL").append("\n"); 
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
		query.append("#if(${ca_flg} == 'Y') " ).append("\n"); 
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
		query.append("		PTY.CUST_CNT_CD, " ).append("\n"); 
		query.append(" 		PTY.CUST_SEQ CUST_SEQ, " ).append("\n"); 
		query.append("		PTY.CTRT_PTY_NM  CUST_NM" ).append("\n"); 
		query.append("		FROM PRI_SP_CTRT_PTY PTY," ).append("\n"); 
		query.append("		(SELECT MN.PROP_NO PROP_NO, MAX(MN.AMDT_SEQ) AMDT_SEQ" ).append("\n"); 
		query.append("		FROM PRI_SP_MN MN, PRI_SP_HDR HDR" ).append("\n"); 
		query.append("		WHERE 1=1" ).append("\n"); 
		query.append("		AND   HDR.SC_NO = @[sc_no]" ).append("\n"); 
		query.append("		AND   MN.PROP_NO = HDR.PROP_NO" ).append("\n"); 
		query.append("		AND   HDR.PRC_MST_PROP_TP_CD = 'P'" ).append("\n"); 
		query.append("		GROUP BY MN.PROP_NO) PRO" ).append("\n"); 
		query.append("		WHERE 1=1" ).append("\n"); 
		query.append("		AND PTY.PROP_NO = PRO.PROP_NO" ).append("\n"); 
		query.append("		AND PTY.AMDT_SEQ = PRO.AMDT_SEQ" ).append("\n"); 
		query.append("		AND PTY.PRC_CTRT_PTY_TP_CD ='C'" ).append("\n"); 
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
		query.append("		BKG_CUSTOMER " ).append("\n"); 
		query.append("	WHERE " ).append("\n"); 
		query.append("		BKG_NO= @[bkg_no]" ).append("\n"); 
		query.append("		AND BKG_CUST_TP_CD IN ('S','C','N','A')" ).append("\n"); 
		query.append("	UNION ALL " ).append("\n"); 
		query.append("	SELECT" ).append("\n"); 
		query.append("		@[bkg_no] AS BKG_NO," ).append("\n"); 
		query.append("		'P' BKG_CUST_TP_CD," ).append("\n"); 
		query.append("		PTY.CUST_CNT_CD, " ).append("\n"); 
		query.append(" 		PTY.CUST_SEQ CUST_SEQ, " ).append("\n"); 
		query.append("		PTY.CTRT_PTY_NM  CUST_NM" ).append("\n"); 
		query.append("		FROM PRI_SP_CTRT_PTY PTY," ).append("\n"); 
		query.append("		(SELECT MN.PROP_NO PROP_NO, MAX(MN.AMDT_SEQ) AMDT_SEQ" ).append("\n"); 
		query.append("		FROM PRI_SP_MN MN, PRI_SP_HDR HDR" ).append("\n"); 
		query.append("		WHERE 1=1" ).append("\n"); 
		query.append("		AND   HDR.SC_NO = @[sc_no]" ).append("\n"); 
		query.append("		AND   MN.PROP_NO = HDR.PROP_NO" ).append("\n"); 
		query.append("		AND   HDR.PRC_MST_PROP_TP_CD = 'P'" ).append("\n"); 
		query.append("		GROUP BY MN.PROP_NO) PRO" ).append("\n"); 
		query.append("		WHERE 1=1" ).append("\n"); 
		query.append("		AND PTY.PROP_NO = PRO.PROP_NO" ).append("\n"); 
		query.append("		AND PTY.AMDT_SEQ = PRO.AMDT_SEQ" ).append("\n"); 
		query.append("		AND PTY.PRC_CTRT_PTY_TP_CD ='C'" ).append("\n"); 
		query.append("	)" ).append("\n"); 
		query.append("GROUP BY BKG_NO" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}