/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : ChassisMgsetAgreementDBDAOSearchCHSTermChangeResultSmryDataRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.02.26
*@LastModifier : 조재성
*@LastVersion : 1.0
* 2010.02.26 조재성
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.cgm.chassismgsetagreementinvoice.chassismgsetagreement.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author ChaeShung Cho
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
		query.append("Path : com.hanjin.apps.alps.ees.cgm.chassismgsetagreementinvoice.chassismgsetagreement.integration").append("\n"); 
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
		query.append("SELECT" ).append("\n"); 
		query.append("T1.STS_EVNT_OFC_CD," ).append("\n"); 
		query.append("MIN(T2.VNDR_SEQ) AS OLD_VNDR_SEQ," ).append("\n"); 
		query.append("T2.AGMT_OFC_CTY_CD || LPAD(T2.AGMT_SEQ,6,'0') AS OLD_AGMT_NO," ).append("\n"); 
		query.append("MIN(T2.AGMT_LSTM_CD) AS OLD_AGMT_LSTM_CD," ).append("\n"); 
		query.append("MIN(T3.VNDR_SEQ) AS NEW_VNDR_SEQ," ).append("\n"); 
		query.append("T3.AGMT_OFC_CTY_CD || LPAD(T3.AGMT_SEQ,6,'0') AS NEW_AGMT_NO," ).append("\n"); 
		query.append("MIN(T3.AGMT_LSTM_CD) AS NEW_AGMT_LSTM_CD," ).append("\n"); 
		query.append("NVL(SUM(EQ_TPSZ_CD_SF2),0) AS EQ_TPSZ_CD_SF2," ).append("\n"); 
		query.append("NVL(SUM(EQ_TPSZ_CD_SL2),0) AS EQ_TPSZ_CD_SL2," ).append("\n"); 
		query.append("NVL(SUM(EQ_TPSZ_CD_TA2),0) AS EQ_TPSZ_CD_TA2," ).append("\n"); 
		query.append("NVL(SUM(EQ_TPSZ_CD_SF4),0) AS EQ_TPSZ_CD_SF4," ).append("\n"); 
		query.append("NVL(SUM(EQ_TPSZ_CD_GN4),0) AS EQ_TPSZ_CD_GN4," ).append("\n"); 
		query.append("NVL(SUM(EQ_TPSZ_CD_CB4),0) AS EQ_TPSZ_CD_CB4," ).append("\n"); 
		query.append("NVL(SUM(EQ_TPSZ_CD_EG5),0) AS EQ_TPSZ_CD_EG5," ).append("\n"); 
		query.append("NVL(SUM(EQ_TPSZ_CD_EG8),0) AS EQ_TPSZ_CD_EG8," ).append("\n"); 
		query.append("NVL(SUM(EQ_TPSZ_CD_GN5),0) AS EQ_TPSZ_CD_GN5," ).append("\n"); 
		query.append("NVL(SUM(EQ_TPSZ_CD_ZT4),0) AS EQ_TPSZ_CD_ZT4" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT A.TERM_CNG_SEQ," ).append("\n"); 
		query.append("MIN(A.EQ_NO) AS EQ_NO," ).append("\n"); 
		query.append("MIN(DECODE(A.EQ_ASET_STS_CD, 'LSO', A.AGMT_OFC_CTY_CD)) AS OLD_AGMT_OFC_CTY_CD," ).append("\n"); 
		query.append("MIN(DECODE(A.EQ_ASET_STS_CD, 'LSO', A.AGMT_SEQ))        AS OLD_AGMT_SEQ," ).append("\n"); 
		query.append("MIN(DECODE(A.EQ_ASET_STS_CD, 'LSI', A.AGMT_OFC_CTY_CD)) AS NEW_AGMT_OFC_CTY_CD," ).append("\n"); 
		query.append("MIN(DECODE(A.EQ_ASET_STS_CD, 'LSI', A.AGMT_SEQ))        AS NEW_AGMT_SEQ," ).append("\n"); 
		query.append("MIN(A.STS_EVNT_OFC_CD) AS STS_EVNT_OFC_CD," ).append("\n"); 
		query.append("MIN(B.EQ_TPSZ_CD)      AS EQ_TPSZ_CD," ).append("\n"); 
		query.append("MIN(DECODE(B.EQ_TPSZ_CD,'SF2',1)) AS EQ_TPSZ_CD_SF2," ).append("\n"); 
		query.append("MIN(DECODE(B.EQ_TPSZ_CD,'SL2',1)) AS EQ_TPSZ_CD_SL2," ).append("\n"); 
		query.append("MIN(DECODE(B.EQ_TPSZ_CD,'TA2',1)) AS EQ_TPSZ_CD_TA2," ).append("\n"); 
		query.append("MIN(DECODE(B.EQ_TPSZ_CD,'SF4',1)) AS EQ_TPSZ_CD_SF4," ).append("\n"); 
		query.append("MIN(DECODE(B.EQ_TPSZ_CD,'GN4',1)) AS EQ_TPSZ_CD_GN4," ).append("\n"); 
		query.append("MIN(DECODE(B.EQ_TPSZ_CD,'CB4',1)) AS EQ_TPSZ_CD_CB4," ).append("\n"); 
		query.append("MIN(DECODE(B.EQ_TPSZ_CD,'EG5',1)) AS EQ_TPSZ_CD_EG5," ).append("\n"); 
		query.append("MIN(DECODE(B.EQ_TPSZ_CD,'EG8',1)) AS EQ_TPSZ_CD_EG8," ).append("\n"); 
		query.append("MIN(DECODE(B.EQ_TPSZ_CD,'GN5',1)) AS EQ_TPSZ_CD_GN5," ).append("\n"); 
		query.append("MIN(DECODE(B.EQ_TPSZ_CD,'ZT4',1)) AS EQ_TPSZ_CD_ZT4" ).append("\n"); 
		query.append("FROM CGM_EQ_STS_HIS A, CGM_EQUIPMENT B" ).append("\n"); 
		query.append("WHERE A.EQ_NO = B.EQ_NO" ).append("\n"); 
		query.append("AND A.EQ_KND_CD = @[eq_knd_cd]" ).append("\n"); 
		query.append("AND A.TERM_CNG_SEQ > 0" ).append("\n"); 
		query.append("AND A.STS_EVNT_DT >= TO_DATE(@[sts_evnt_dt_fr],'YYYYMMDD')" ).append("\n"); 
		query.append("AND A.STS_EVNT_DT < TO_DATE(@[sts_evnt_dt_to],'YYYYMMDD') + 1" ).append("\n"); 
		query.append("#if (${sts_evnt_ofc_cd} != '')" ).append("\n"); 
		query.append("AND A.STS_EVNT_OFC_CD IN ($sts_evnt_ofc_cd)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("GROUP BY A.TERM_CNG_SEQ" ).append("\n"); 
		query.append(") T1," ).append("\n"); 
		query.append("CGM_AGREEMENT T2," ).append("\n"); 
		query.append("CGM_AGREEMENT T3" ).append("\n"); 
		query.append("WHERE" ).append("\n"); 
		query.append("T1.OLD_AGMT_OFC_CTY_CD = T2.AGMT_OFC_CTY_CD(+)" ).append("\n"); 
		query.append("AND T1.OLD_AGMT_SEQ = T2.AGMT_SEQ(+)" ).append("\n"); 
		query.append("AND T1.NEW_AGMT_OFC_CTY_CD = T3.AGMT_OFC_CTY_CD(+)" ).append("\n"); 
		query.append("AND T1.NEW_AGMT_SEQ = T3.AGMT_SEQ(+)" ).append("\n"); 
		query.append("AND T2.LST_VER_FLG(+) = 'Y'" ).append("\n"); 
		query.append("AND T3.LST_VER_FLG(+) = 'Y'" ).append("\n"); 
		query.append("#if (${vndr_seq} != '')" ).append("\n"); 
		query.append("AND (T2.VNDR_SEQ IN ($vndr_seq) OR T3.VNDR_SEQ IN ($vndr_seq))" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${old_agmt_lstm_cd} != '')" ).append("\n"); 
		query.append("AND T2.AGMT_LSTM_CD IN ($old_agmt_lstm_cd)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${new_agmt_lstm_cd} != '')" ).append("\n"); 
		query.append("AND T3.AGMT_LSTM_CD IN ($new_agmt_lstm_cd)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("GROUP BY T1.STS_EVNT_OFC_CD," ).append("\n"); 
		query.append("T2.AGMT_OFC_CTY_CD," ).append("\n"); 
		query.append("T2.AGMT_SEQ," ).append("\n"); 
		query.append("T3.AGMT_OFC_CTY_CD," ).append("\n"); 
		query.append("T3.AGMT_SEQ" ).append("\n"); 
		query.append("ORDER BY T1.STS_EVNT_OFC_CD," ).append("\n"); 
		query.append("T2.AGMT_OFC_CTY_CD," ).append("\n"); 
		query.append("T2.AGMT_SEQ," ).append("\n"); 
		query.append("T3.AGMT_OFC_CTY_CD," ).append("\n"); 
		query.append("T3.AGMT_SEQ" ).append("\n"); 

	}
}