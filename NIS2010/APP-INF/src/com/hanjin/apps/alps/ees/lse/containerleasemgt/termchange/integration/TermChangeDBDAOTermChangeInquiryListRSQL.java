/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : TermChangeDBDAOTermChangeInquiryListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.02.22
*@LastModifier : 장준우
*@LastVersion : 1.0
* 2010.02.22 장준우
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.lse.containerleasemgt.termchange.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Jang Jun-Woo
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TermChangeDBDAOTermChangeInquiryListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Term Change Creation 장비 처리이력을 조회한다.
	  * </pre>
	  */
	public TermChangeDBDAOTermChangeInquiryListRSQL(){
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
		query.append("Path : com.hanjin.apps.alps.ees.lse.containerleasemgt.termchange.integration").append("\n"); 
		query.append("FileName : TermChangeDBDAOTermChangeInquiryListRSQL").append("\n"); 
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
		query.append("SELECT  BEF_CNTR_STS_SEQ, AFT_CNTR_STS_SEQ," ).append("\n"); 
		query.append("		CNTR_NO, CNTR_TPSZ_CD, CRE_DT, CNMV_STS_CD," ).append("\n"); 
		query.append("        BEF_AGMT_NO, BEF_LSTM_CD, BEF_REF_NO," ).append("\n"); 
		query.append("        BEF_VNDR_ABBR_NM, BEF_LST_BEF_DT, BEF_LST_EXP_DT," ).append("\n"); 
		query.append("        AFT_AGMT_NO, AFT_LSTM_CD, AFT_REF_NO," ).append("\n"); 
		query.append("        AFT_VNDR_ABBR_NM, AFT_FA_IF_DT, AFT_FA_IF_STS_CD" ).append("\n"); 
		query.append("FROM   (SELECT  Z.BEF_CNTR_STS_SEQ, Z.AFT_CNTR_STS_SEQ," ).append("\n"); 
		query.append("				A.CNTR_NO, A.CNTR_TPSZ_CD, A.CNMV_STS_CD," ).append("\n"); 
		query.append("                Z.CNTR_CRE_DT AS CRE_DT," ).append("\n"); 
		query.append("                D.AGMT_CTY_CD||LPAD(D.AGMT_SEQ, 6,'0') AS BEF_AGMT_NO," ).append("\n"); 
		query.append("                D.LSTM_CD AS BEF_LSTM_CD," ).append("\n"); 
		query.append("                D.REF_NO AS BEF_REF_NO," ).append("\n"); 
		query.append("                F.VNDR_ABBR_NM AS BEF_VNDR_ABBR_NM," ).append("\n"); 
		query.append("                TO_CHAR(D.LST_EFF_DT,'YYYY-MM-DD') AS BEF_LST_BEF_DT," ).append("\n"); 
		query.append("                TO_CHAR(D.LST_EXP_DT,'YYYY-MM-DD') AS BEF_LST_EXP_DT," ).append("\n"); 
		query.append("                E.AGMT_CTY_CD||LPAD(E.AGMT_SEQ, 6,'0') AS AFT_AGMT_NO," ).append("\n"); 
		query.append("                E.LSTM_CD AS AFT_LSTM_CD," ).append("\n"); 
		query.append("                E.REF_NO AS AFT_REF_NO," ).append("\n"); 
		query.append("                G.VNDR_ABBR_NM AS AFT_VNDR_ABBR_NM," ).append("\n"); 
		query.append("                TO_CHAR(A.FA_IF_DT,'YYYY-MM-DD') AS AFT_FA_IF_DT," ).append("\n"); 
		query.append("                A.FA_IF_STS_CD AS AFT_FA_IF_STS_CD" ).append("\n"); 
		query.append("        FROM   (" ).append("\n"); 
		query.append("#if (${sts_flag} == 'B') " ).append("\n"); 
		query.append("			    SELECT  CNTR_NO, AGMT_CTY_CD AS BEF_AGMT_CTY_CD, " ).append("\n"); 
		query.append("                        AGMT_SEQ AS BEF_AGMT_SEQ, VNDR_SEQ, STS_FLAG," ).append("\n"); 
		query.append("                        TRIM(SUBSTR(TMP, 1, 3)) AS AFT_AGMT_CTY_CD," ).append("\n"); 
		query.append("                        TRIM(SUBSTR(TMP, 4, 6)) AS AFT_AGMT_SEQ," ).append("\n"); 
		query.append("                        TRIM(SUBSTR(TMP,10,10)) AS CNTR_CRE_DT," ).append("\n"); 
		query.append("						CNTR_STS_SEQ AS BEF_CNTR_STS_SEQ," ).append("\n"); 
		query.append("						TRIM(SUBSTR(TMP, 20, 9)) AS AFT_CNTR_STS_SEQ                        " ).append("\n"); 
		query.append("                FROM   (SELECT  A.CNTR_NO, A.CNTR_STS_EVNT_DT, A.CNTR_STS_SEQ," ).append("\n"); 
		query.append("                               (SELECT  /*+ INDEX(B XPKMST_CNTR_STS_HIS) */" ).append("\n"); 
		query.append("                                        LPAD(AGMT_CTY_CD,3)||LPAD(AGMT_SEQ,6)||" ).append("\n"); 
		query.append("                                        TO_CHAR(CNTR_STS_EVNT_DT, 'YYYY-MM-DD')||LPAD(CNTR_STS_SEQ,9)" ).append("\n"); 
		query.append("                                FROM    MST_CNTR_STS_HIS B" ).append("\n"); 
		query.append("                                WHERE   A.CNTR_NO = B.CNTR_NO" ).append("\n"); 
		query.append("                                AND     A.CNTR_STS_SEQ < B.CNTR_STS_SEQ" ).append("\n"); 
		query.append("                                AND     B.CNTR_STS_CD IN ('DII','LSI','OWN')" ).append("\n"); 
		query.append("                                AND     B.CNTR_LSTM_CNG_FLG = 'Y'" ).append("\n"); 
		query.append("                                AND     ROWNUM = 1) AS TMP," ).append("\n"); 
		query.append("                                A.AGMT_CTY_CD, A.AGMT_SEQ, P.VNDR_SEQ, P.STS_FLAG" ).append("\n"); 
		query.append("                		FROM   (SELECT  @[agmt_cty_cd]   AS AGMT_CTY_CD," ).append("\n"); 
		query.append("					    		        @[agmt_seq1]     AS AGMT_SEQ," ).append("\n"); 
		query.append("					            		DECODE(@[dcond_tp],'01',@[vndr_seq1],@[vndr_seq2])     AS VNDR_SEQ," ).append("\n"); 
		query.append("							            @[sts_flag]      AS STS_FLAG" ).append("\n"); 
		query.append("							    FROM    DUAL) P, " ).append("\n"); 
		query.append("                		        MST_CNTR_STS_HIS A" ).append("\n"); 
		query.append("		                WHERE   1 = 1" ).append("\n"); 
		query.append("        		        AND     A.AGMT_CTY_CD = P.AGMT_CTY_CD" ).append("\n"); 
		query.append("	#if (${agmt_seq1} != '') " ).append("\n"); 
		query.append("		                AND     A.AGMT_SEQ = P.AGMT_SEQ" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("		                AND     A.CNTR_STS_CD IN ('MUO','LSO','DIO')" ).append("\n"); 
		query.append("		                AND     A.CNTR_LSTM_CNG_FLG = 'Y')" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("				SELECT  CNTR_NO, AGMT_CTY_CD AS AFT_AGMT_CTY_CD, " ).append("\n"); 
		query.append("                        AGMT_SEQ AS AFT_AGMT_SEQ, VNDR_SEQ, STS_FLAG," ).append("\n"); 
		query.append("                        TRIM(SUBSTR(TMP, 1, 3)) AS BEF_AGMT_CTY_CD," ).append("\n"); 
		query.append("                        TRIM(SUBSTR(TMP, 4, 6)) AS BEF_AGMT_SEQ," ).append("\n"); 
		query.append("                        TO_CHAR(CNTR_STS_EVNT_DT, 'YYYY-MM-DD') AS CNTR_CRE_DT," ).append("\n"); 
		query.append("						TRIM(SUBSTR(TMP, 20, 9)) AS BEF_CNTR_STS_SEQ," ).append("\n"); 
		query.append("						CNTR_STS_SEQ AS AFT_CNTR_STS_SEQ                        " ).append("\n"); 
		query.append("                FROM   (SELECT  A.CNTR_NO, A.CNTR_STS_EVNT_DT, A.CNTR_STS_SEQ," ).append("\n"); 
		query.append("                               (SELECT  /*+ INDEX_DESC(B XPKMST_CNTR_STS_HIS) */" ).append("\n"); 
		query.append("                                        LPAD(AGMT_CTY_CD,3)||LPAD(AGMT_SEQ,6)||" ).append("\n"); 
		query.append("                                        TO_CHAR(CNTR_STS_EVNT_DT, 'YYYY-MM-DD')||LPAD(CNTR_STS_SEQ,9)" ).append("\n"); 
		query.append("                                FROM    MST_CNTR_STS_HIS B" ).append("\n"); 
		query.append("                                WHERE   A.CNTR_NO = B.CNTR_NO" ).append("\n"); 
		query.append("                                AND     A.CNTR_STS_SEQ > B.CNTR_STS_SEQ" ).append("\n"); 
		query.append("                                AND     B.CNTR_STS_CD IN ('MUO','LSO','DIO')" ).append("\n"); 
		query.append("                                AND     B.CNTR_LSTM_CNG_FLG = 'Y'" ).append("\n"); 
		query.append("                                AND     ROWNUM = 1) AS TMP," ).append("\n"); 
		query.append("                                A.AGMT_CTY_CD, A.AGMT_SEQ, P.VNDR_SEQ, P.STS_FLAG" ).append("\n"); 
		query.append("		                FROM   (SELECT  @[agmt_cty_cd]   AS AGMT_CTY_CD," ).append("\n"); 
		query.append("							            @[agmt_seq1]     AS AGMT_SEQ," ).append("\n"); 
		query.append("							            DECODE(@[dcond_tp],'01',@[vndr_seq1],@[vndr_seq2])     AS VNDR_SEQ," ).append("\n"); 
		query.append("					    		        @[sts_flag]      AS STS_FLAG" ).append("\n"); 
		query.append("							    FROM    DUAL) P, " ).append("\n"); 
		query.append("        		                MST_CNTR_STS_HIS A" ).append("\n"); 
		query.append("                		WHERE   1 = 1" ).append("\n"); 
		query.append("		                AND     A.AGMT_CTY_CD = P.AGMT_CTY_CD" ).append("\n"); 
		query.append("	#if (${agmt_seq1} != '') " ).append("\n"); 
		query.append("        		        AND     A.AGMT_SEQ = P.AGMT_SEQ" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("		                AND     A.CNTR_STS_CD IN ('DII','LSI','OWN')" ).append("\n"); 
		query.append("        		        AND     A.CNTR_LSTM_CNG_FLG = 'Y')" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("                ) Z,        " ).append("\n"); 
		query.append("                MST_CONTAINER A," ).append("\n"); 
		query.append("                LSE_AGREEMENT D," ).append("\n"); 
		query.append("                LSE_AGREEMENT E," ).append("\n"); 
		query.append("                MDM_VENDOR F," ).append("\n"); 
		query.append("                MDM_VENDOR G                " ).append("\n"); 
		query.append("        WHERE   Z.CNTR_NO = A.CNTR_NO" ).append("\n"); 
		query.append("        AND     Z.BEF_AGMT_CTY_CD = D.AGMT_CTY_CD" ).append("\n"); 
		query.append("        AND     Z.BEF_AGMT_SEQ = D.AGMT_SEQ" ).append("\n"); 
		query.append("        AND     Z.AFT_AGMT_CTY_CD = E.AGMT_CTY_CD" ).append("\n"); 
		query.append("        AND     Z.AFT_AGMT_SEQ = E.AGMT_SEQ" ).append("\n"); 
		query.append("        AND     D.VNDR_SEQ = F.VNDR_SEQ" ).append("\n"); 
		query.append("        AND     E.VNDR_SEQ = G.VNDR_SEQ   " ).append("\n"); 
		query.append("#if (${sts_flag} == 'B') " ).append("\n"); 
		query.append("        AND     D.VNDR_SEQ = Z.VNDR_SEQ" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("		AND     E.VNDR_SEQ = Z.VNDR_SEQ" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("        )" ).append("\n"); 
		query.append("WHERE   1 = 1                     " ).append("\n"); 
		query.append("ORDER BY CRE_DT, BEF_LST_BEF_DT" ).append("\n"); 

	}
}