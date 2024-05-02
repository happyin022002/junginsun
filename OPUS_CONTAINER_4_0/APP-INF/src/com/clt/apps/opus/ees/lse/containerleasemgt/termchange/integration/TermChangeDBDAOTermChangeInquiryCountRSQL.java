/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : TermChangeDBDAOTermChangeInquiryCountRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.12.30
*@LastModifier : 장준우
*@LastVersion : 1.0
* 2009.12.30 장준우
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.lse.containerleasemgt.termchange.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Jang Jun-Woo
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TermChangeDBDAOTermChangeInquiryCountRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Term Change Creation 장비 이력목록 전체건수를 조회한다.
	  * </pre>
	  */
	public TermChangeDBDAOTermChangeInquiryCountRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.NUMERIC + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("agmt_seq1",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.NUMERIC + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vndr_seq2",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sts_flag",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dcond_tp",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.NUMERIC + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vndr_seq1",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("agmt_cty_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.lse.containerleasemgt.termchange.integration").append("\n"); 
		query.append("FileName : TermChangeDBDAOTermChangeInquiryCountRSQL").append("\n"); 
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
		query.append("SELECT  COUNT(*) TOTAL_CNT" ).append("\n"); 
		query.append("FROM    MST_CONTAINER A," ).append("\n"); 
		query.append("MST_CNTR_STS_HIS B," ).append("\n"); 
		query.append("MST_CNTR_STS_HIS C," ).append("\n"); 
		query.append("LSE_AGREEMENT D," ).append("\n"); 
		query.append("LSE_AGREEMENT E," ).append("\n"); 
		query.append("MDM_VENDOR F," ).append("\n"); 
		query.append("MDM_VENDOR G," ).append("\n"); 
		query.append("(SELECT  @[agmt_cty_cd]   AS AGMT_CTY_CD," ).append("\n"); 
		query.append("@[agmt_seq1]     AS AGMT_SEQ," ).append("\n"); 
		query.append("DECODE(@[dcond_tp],'01',@[vndr_seq1],@[vndr_seq2])     AS VNDR_SEQ," ).append("\n"); 
		query.append("@[sts_flag]      AS STS_FLAG" ).append("\n"); 
		query.append("FROM    DUAL) P" ).append("\n"); 
		query.append("WHERE   A.CNTR_NO = B.CNTR_NO" ).append("\n"); 
		query.append("AND     A.CNTR_NO = C.CNTR_NO" ).append("\n"); 
		query.append("AND     B.AGMT_CTY_CD = D.AGMT_CTY_CD" ).append("\n"); 
		query.append("AND     B.AGMT_SEQ = D.AGMT_SEQ" ).append("\n"); 
		query.append("AND     C.AGMT_CTY_CD = E.AGMT_CTY_CD" ).append("\n"); 
		query.append("AND     C.AGMT_SEQ = E.AGMT_SEQ" ).append("\n"); 
		query.append("AND     D.VNDR_SEQ = F.VNDR_SEQ" ).append("\n"); 
		query.append("AND     E.VNDR_SEQ = G.VNDR_SEQ" ).append("\n"); 
		query.append("AND     B.CNTR_LSTM_CNG_FLG = 'Y'" ).append("\n"); 
		query.append("AND     C.CNTR_LSTM_CNG_FLG = 'Y'" ).append("\n"); 
		query.append("AND     B.CNTR_STS_CD in ('MUI','LSO','DIO')" ).append("\n"); 
		query.append("AND     C.CNTR_STS_CD in ('DII','LSI','OWN')" ).append("\n"); 
		query.append("#if (${sts_flag} == \"B\")" ).append("\n"); 
		query.append("AND     D.VNDR_SEQ = P.VNDR_SEQ" ).append("\n"); 
		query.append("AND     B.AGMT_CTY_CD = P.AGMT_CTY_CD" ).append("\n"); 
		query.append("#if (${agmt_seq1} != \"\")" ).append("\n"); 
		query.append("AND     B.AGMT_SEQ = P.AGMT_SEQ" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("AND     E.VNDR_SEQ = P.VNDR_SEQ" ).append("\n"); 
		query.append("AND     C.AGMT_CTY_CD = P.AGMT_CTY_CD" ).append("\n"); 
		query.append("#if (${agmt_seq1} != \"\")" ).append("\n"); 
		query.append("AND     C.AGMT_SEQ = P.AGMT_SEQ" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}