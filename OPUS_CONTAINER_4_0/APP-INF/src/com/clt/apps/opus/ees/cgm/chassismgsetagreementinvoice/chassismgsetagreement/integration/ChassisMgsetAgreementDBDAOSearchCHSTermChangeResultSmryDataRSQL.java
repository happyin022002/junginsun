/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : ChassisMgsetAgreementDBDAOSearchCHSTermChangeResultSmryDataRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.01.19
*@LastModifier : 박광석
*@LastVersion : 1.0
* 2015.01.19 박광석
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.cgm.chassismgsetagreementinvoice.chassismgsetagreement.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author PARK KWANG SEOK
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ChassisMgsetAgreementDBDAOSearchCHSTermChangeResultSmryDataRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ChassisMgsetAgreementDB.SearchCHSTermChangeResultSmryData
	  * </pre>
	  */
	public ChassisMgsetAgreementDBDAOSearchCHSTermChangeResultSmryDataRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sts_evnt_dt_fr",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eq_knd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sts_evnt_dt_to",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.cgm.chassismgsetagreementinvoice.chassismgsetagreement.integration").append("\n"); 
		query.append("FileName : ChassisMgsetAgreementDBDAOSearchCHSTermChangeResultSmryDataRSQL").append("\n"); 
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
		query.append("SELECT " ).append("\n"); 
		query.append("       T1.STS_EVNT_OFC_CD, " ).append("\n"); 
		query.append("       MIN(T2.VNDR_SEQ) AS OLD_VNDR_SEQ, " ).append("\n"); 
		query.append("       T2.AGMT_OFC_CTY_CD || LPAD(T2.AGMT_SEQ,6,'0') AS OLD_AGMT_NO," ).append("\n"); 
		query.append("       MIN(T2.AGMT_LSTM_CD) AS OLD_AGMT_LSTM_CD," ).append("\n"); 
		query.append("       MIN(T3.VNDR_SEQ) AS NEW_VNDR_SEQ, " ).append("\n"); 
		query.append("       T3.AGMT_OFC_CTY_CD || LPAD(T3.AGMT_SEQ,6,'0') AS NEW_AGMT_NO," ).append("\n"); 
		query.append("       MIN(T3.AGMT_LSTM_CD) AS NEW_AGMT_LSTM_CD," ).append("\n"); 
		query.append("		NVL(SUM(EQ_TPSZ_CD1),0) AS EQ_TPSZ_CD1," ).append("\n"); 
		query.append("		NVL(SUM(EQ_TPSZ_CD2),0) AS EQ_TPSZ_CD2," ).append("\n"); 
		query.append("		NVL(SUM(EQ_TPSZ_CD3),0) AS EQ_TPSZ_CD3," ).append("\n"); 
		query.append("		NVL(SUM(EQ_TPSZ_CD4),0) AS EQ_TPSZ_CD4," ).append("\n"); 
		query.append("		NVL(SUM(EQ_TPSZ_CD5),0) AS EQ_TPSZ_CD5," ).append("\n"); 
		query.append("		NVL(SUM(EQ_TPSZ_CD6),0) AS EQ_TPSZ_CD6," ).append("\n"); 
		query.append("		NVL(SUM(EQ_TPSZ_CD7),0) AS EQ_TPSZ_CD7," ).append("\n"); 
		query.append("		NVL(SUM(EQ_TPSZ_CD8),0) AS EQ_TPSZ_CD8," ).append("\n"); 
		query.append("		NVL(SUM(EQ_TPSZ_CD9),0) AS EQ_TPSZ_CD9," ).append("\n"); 
		query.append("		NVL(SUM(EQ_TPSZ_CD10),0) AS EQ_TPSZ_CD10," ).append("\n"); 
		query.append("		NVL(SUM(EQ_TPSZ_CD11),0) AS EQ_TPSZ_CD11," ).append("\n"); 
		query.append("		NVL(SUM(EQ_TPSZ_CD12),0) AS EQ_TPSZ_CD12," ).append("\n"); 
		query.append("		NVL(SUM(EQ_TPSZ_CD13),0) AS EQ_TPSZ_CD13," ).append("\n"); 
		query.append("		NVL(SUM(EQ_TPSZ_CD14),0) AS EQ_TPSZ_CD14," ).append("\n"); 
		query.append("		NVL(SUM(EQ_TPSZ_CD15),0) AS EQ_TPSZ_CD15," ).append("\n"); 
		query.append("		NVL(SUM(EQ_TPSZ_CD16),0) AS EQ_TPSZ_CD16," ).append("\n"); 
		query.append("		NVL(SUM(EQ_TPSZ_CD17),0) AS EQ_TPSZ_CD17," ).append("\n"); 
		query.append("		NVL(SUM(EQ_TPSZ_CD18),0) AS EQ_TPSZ_CD18," ).append("\n"); 
		query.append("		NVL(SUM(EQ_TPSZ_CD19),0) AS EQ_TPSZ_CD19," ).append("\n"); 
		query.append("		NVL(SUM(EQ_TPSZ_CD20),0) AS EQ_TPSZ_CD20" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("    ( " ).append("\n"); 
		query.append("    SELECT A.TERM_CNG_SEQ," ).append("\n"); 
		query.append("           MIN(A.EQ_NO) AS EQ_NO," ).append("\n"); 
		query.append("           MIN(DECODE(A.EQ_ASET_STS_CD, 'LSO', A.AGMT_OFC_CTY_CD)) AS OLD_AGMT_OFC_CTY_CD," ).append("\n"); 
		query.append("           MIN(DECODE(A.EQ_ASET_STS_CD, 'LSO', A.AGMT_SEQ))        AS OLD_AGMT_SEQ," ).append("\n"); 
		query.append("           MIN(DECODE(A.EQ_ASET_STS_CD, 'LSI', A.AGMT_OFC_CTY_CD)) AS NEW_AGMT_OFC_CTY_CD," ).append("\n"); 
		query.append("           MIN(DECODE(A.EQ_ASET_STS_CD, 'LSI', A.AGMT_SEQ))        AS NEW_AGMT_SEQ," ).append("\n"); 
		query.append("           MIN(A.STS_EVNT_OFC_CD) AS STS_EVNT_OFC_CD," ).append("\n"); 
		query.append("	 	   MIN(B.EQ_TPSZ_CD)      AS EQ_TPSZ_CD," ).append("\n"); 
		query.append("			MIN(CASE WHEN G.DP_SEQ = '1' THEN 1 END) AS EQ_TPSZ_CD1," ).append("\n"); 
		query.append("			MIN(CASE WHEN G.DP_SEQ = '2' THEN 1 END) AS EQ_TPSZ_CD2," ).append("\n"); 
		query.append("			MIN(CASE WHEN G.DP_SEQ = '3' THEN 1 END) AS EQ_TPSZ_CD3," ).append("\n"); 
		query.append("			MIN(CASE WHEN G.DP_SEQ = '4' THEN 1 END) AS EQ_TPSZ_CD4," ).append("\n"); 
		query.append("			MIN(CASE WHEN G.DP_SEQ = '5' THEN 1 END) AS EQ_TPSZ_CD5," ).append("\n"); 
		query.append("			MIN(CASE WHEN G.DP_SEQ = '6' THEN 1 END) AS EQ_TPSZ_CD6," ).append("\n"); 
		query.append("			MIN(CASE WHEN G.DP_SEQ = '7' THEN 1 END) AS EQ_TPSZ_CD7," ).append("\n"); 
		query.append("			MIN(CASE WHEN G.DP_SEQ = '8' THEN 1 END) AS EQ_TPSZ_CD8," ).append("\n"); 
		query.append("			MIN(CASE WHEN G.DP_SEQ = '9' THEN 1 END) AS EQ_TPSZ_CD9," ).append("\n"); 
		query.append("			MIN(CASE WHEN G.DP_SEQ = '10' THEN 1 END) AS EQ_TPSZ_CD10," ).append("\n"); 
		query.append("			MIN(CASE WHEN G.DP_SEQ = '11' THEN 1 END) AS EQ_TPSZ_CD11," ).append("\n"); 
		query.append("			MIN(CASE WHEN G.DP_SEQ = '12' THEN 1 END) AS EQ_TPSZ_CD12," ).append("\n"); 
		query.append("			MIN(CASE WHEN G.DP_SEQ = '13' THEN 1 END) AS EQ_TPSZ_CD13," ).append("\n"); 
		query.append("			MIN(CASE WHEN G.DP_SEQ = '14' THEN 1 END) AS EQ_TPSZ_CD14," ).append("\n"); 
		query.append("			MIN(CASE WHEN G.DP_SEQ = '15' THEN 1 END) AS EQ_TPSZ_CD15," ).append("\n"); 
		query.append("			MIN(CASE WHEN G.DP_SEQ = '16' THEN 1 END) AS EQ_TPSZ_CD16," ).append("\n"); 
		query.append("			MIN(CASE WHEN G.DP_SEQ = '17' THEN 1 END) AS EQ_TPSZ_CD17," ).append("\n"); 
		query.append("			MIN(CASE WHEN G.DP_SEQ = '18' THEN 1 END) AS EQ_TPSZ_CD18," ).append("\n"); 
		query.append("			MIN(CASE WHEN G.DP_SEQ = '19' THEN 1 END) AS EQ_TPSZ_CD19," ).append("\n"); 
		query.append("			MIN(CASE WHEN G.DP_SEQ = '20' THEN 1 END) AS EQ_TPSZ_CD20" ).append("\n"); 
		query.append("    FROM CGM_EQ_STS_HIS A, CGM_EQUIPMENT B," ).append("\n"); 
		query.append("		(SELECT EQ_TPSZ_CD,ROW_NUMBER() OVER (ORDER BY EQ_TPSZ_REP_CD,EQ_TPSZ_CD) DP_SEQ " ).append("\n"); 
		query.append("  		   FROM CGM_EQ_TP_SZ WHERE EQ_KND_CD = 'Z' GROUP BY EQ_TPSZ_REP_CD,EQ_TPSZ_CD) G" ).append("\n"); 
		query.append("    WHERE A.EQ_NO = B.EQ_NO" ).append("\n"); 
		query.append("		  AND B.EQ_TPSZ_CD = G.EQ_TPSZ_CD" ).append("\n"); 
		query.append("          AND A.EQ_KND_CD = @[eq_knd_cd]" ).append("\n"); 
		query.append("          AND A.TERM_CNG_SEQ > 0" ).append("\n"); 
		query.append("		  AND A.STS_EVNT_DT >= TO_DATE(@[sts_evnt_dt_fr],'YYYYMMDD')" ).append("\n"); 
		query.append("          AND A.STS_EVNT_DT < TO_DATE(@[sts_evnt_dt_to],'YYYYMMDD') + 1" ).append("\n"); 
		query.append("#if (${sts_evnt_ofc_cd} != '') " ).append("\n"); 
		query.append("		  AND A.STS_EVNT_OFC_CD IN ($sts_evnt_ofc_cd)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("    GROUP BY A.TERM_CNG_SEQ" ).append("\n"); 
		query.append("    ) T1," ).append("\n"); 
		query.append("    CGM_AGREEMENT T2," ).append("\n"); 
		query.append("    CGM_AGREEMENT T3" ).append("\n"); 
		query.append("WHERE" ).append("\n"); 
		query.append("    T1.OLD_AGMT_OFC_CTY_CD = T2.AGMT_OFC_CTY_CD(+)" ).append("\n"); 
		query.append("    AND T1.OLD_AGMT_SEQ = T2.AGMT_SEQ(+)" ).append("\n"); 
		query.append("    AND T1.NEW_AGMT_OFC_CTY_CD = T3.AGMT_OFC_CTY_CD(+)" ).append("\n"); 
		query.append("    AND T1.NEW_AGMT_SEQ = T3.AGMT_SEQ(+)" ).append("\n"); 
		query.append("    AND T2.LST_VER_FLG(+) = 'Y'" ).append("\n"); 
		query.append("    AND T3.LST_VER_FLG(+) = 'Y'" ).append("\n"); 
		query.append("#if (${vndr_seq} != '') " ).append("\n"); 
		query.append("	AND (T2.VNDR_SEQ IN ($vndr_seq) OR T3.VNDR_SEQ IN ($vndr_seq))" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${old_agmt_lstm_cd} != '') " ).append("\n"); 
		query.append("    AND T2.AGMT_LSTM_CD IN ($old_agmt_lstm_cd)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${new_agmt_lstm_cd} != '') " ).append("\n"); 
		query.append("    AND T3.AGMT_LSTM_CD IN ($new_agmt_lstm_cd)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("GROUP BY T1.STS_EVNT_OFC_CD, " ).append("\n"); 
		query.append("         T2.AGMT_OFC_CTY_CD, " ).append("\n"); 
		query.append("         T2.AGMT_SEQ," ).append("\n"); 
		query.append("         T3.AGMT_OFC_CTY_CD, " ).append("\n"); 
		query.append("         T3.AGMT_SEQ" ).append("\n"); 
		query.append("ORDER BY T1.STS_EVNT_OFC_CD, " ).append("\n"); 
		query.append("         T2.AGMT_OFC_CTY_CD, " ).append("\n"); 
		query.append("         T2.AGMT_SEQ," ).append("\n"); 
		query.append("         T3.AGMT_OFC_CTY_CD, " ).append("\n"); 
		query.append("         T3.AGMT_SEQ" ).append("\n"); 

	}
}