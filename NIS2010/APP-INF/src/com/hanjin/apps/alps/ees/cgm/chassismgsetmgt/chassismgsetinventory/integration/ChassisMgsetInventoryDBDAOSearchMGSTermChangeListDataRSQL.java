/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : ChassisMgsetInventoryDBDAOSearchMGSTermChangeListDataRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.03.24
*@LastModifier : 조재성
*@LastVersion : 1.0
* 2010.03.24 조재성
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.cgm.chassismgsetmgt.chassismgsetinventory.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author ChaeShung Cho
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ChassisMgsetInventoryDBDAOSearchMGSTermChangeListDataRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ChassisMgsetInventoryDB.SearchMGSTermChangeListData
	  * </pre>
	  */
	public ChassisMgsetInventoryDBDAOSearchMGSTermChangeListDataRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("old_agmt_ofc_cty_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("new_agmt_ofc_cty_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eq_tpsz_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.NUMERIC + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("old_agmt_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sts_evnt_dt_to",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.NUMERIC + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("new_agmt_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.cgm.chassismgsetmgt.chassismgsetinventory.integration").append("\n"); 
		query.append("FileName : ChassisMgsetInventoryDBDAOSearchMGSTermChangeListDataRSQL").append("\n"); 
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
		query.append("T1.EQ_NO," ).append("\n"); 
		query.append("T3.AGMT_OFC_CTY_CD || LPAD(T3.AGMT_SEQ,6,'0') AS AGMT_NO," ).append("\n"); 
		query.append("T3.AGMT_LSTM_CD," ).append("\n"); 
		query.append("T1.EQ_TPSZ_CD," ).append("\n"); 
		query.append("T4.VNDR_ABBR_NM," ).append("\n"); 
		query.append("T7.CHSS_NO," ).append("\n"); 
		query.append("T7.CNTR_NO," ).append("\n"); 
		query.append("T6.LCC_CD," ).append("\n"); 
		query.append("T5.SCC_CD," ).append("\n"); 
		query.append("T1.CRNT_YD_CD," ).append("\n"); 
		query.append("CASE WHEN T1.EQ_TPSZ_CD = 'UMG' THEN" ).append("\n"); 
		query.append("(SELECT CHSS_MVMT_STS_CD FROM CGM_EQUIPMENT WHERE EQ_NO = T7.CHSS_NO)" ).append("\n"); 
		query.append("ELSE" ).append("\n"); 
		query.append("(SELECT CNMV_STS_CD FROM MST_CONTAINER WHERE CNTR_NO = T7.CNTR_NO)" ).append("\n"); 
		query.append("END MVMT," ).append("\n"); 
		query.append("CASE WHEN T1.EQ_TPSZ_CD = 'UMG' THEN" ).append("\n"); 
		query.append("(SELECT CHSS_MVMT_DT FROM CGM_EQUIPMENT WHERE EQ_NO = T7.CHSS_NO)" ).append("\n"); 
		query.append("ELSE" ).append("\n"); 
		query.append("(SELECT CNMV_DT FROM MST_CONTAINER WHERE CNTR_NO = T7.CNTR_NO)" ).append("\n"); 
		query.append("END MVMT_DATE," ).append("\n"); 
		query.append("CASE WHEN T1.EQ_TPSZ_CD = 'UMG' THEN" ).append("\n"); 
		query.append("(SELECT TRUNC(SYSDATE - CHSS_MVMT_DT,0) FROM CGM_EQUIPMENT WHERE EQ_NO = T7.CHSS_NO)" ).append("\n"); 
		query.append("ELSE" ).append("\n"); 
		query.append("(SELECT TRUNC(SYSDATE - CNMV_DT,0) FROM MST_CONTAINER WHERE CNTR_NO = T7.CNTR_NO)" ).append("\n"); 
		query.append("END LSDAYS" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT A.TERM_CNG_SEQ," ).append("\n"); 
		query.append("MIN(B.EQ_TPSZ_CD) AS EQ_TPSZ_CD," ).append("\n"); 
		query.append("MIN(A.EQ_NO) AS EQ_NO," ).append("\n"); 
		query.append("MIN(DECODE(A.EQ_ASET_STS_CD, 'LSO', A.AGMT_OFC_CTY_CD)) AS OLD_AGMT_OFC_CTY_CD," ).append("\n"); 
		query.append("MIN(DECODE(A.EQ_ASET_STS_CD, 'LSO', A.AGMT_SEQ))        AS OLD_AGMT_SEQ," ).append("\n"); 
		query.append("MIN(DECODE(A.EQ_ASET_STS_CD, 'LSI', A.AGMT_OFC_CTY_CD)) AS NEW_AGMT_OFC_CTY_CD," ).append("\n"); 
		query.append("MIN(DECODE(A.EQ_ASET_STS_CD, 'LSI', A.AGMT_SEQ))        AS NEW_AGMT_SEQ," ).append("\n"); 
		query.append("MIN(A.STS_EVNT_OFC_CD) AS STS_EVNT_OFC_CD," ).append("\n"); 
		query.append("MIN(B.CHSS_MVMT_STS_CD) AS CHSS_MVMT_STS_CD," ).append("\n"); 
		query.append("MIN(B.CRNT_YD_CD) AS CRNT_YD_CD," ).append("\n"); 
		query.append("MIN(B.ONH_DT) AS ONH_DT," ).append("\n"); 
		query.append("MIN(B.CHSS_MVMT_DT) AS CHSS_MVMT_DT," ).append("\n"); 
		query.append("MIN(B.CRNT_LOC_CD) AS CRNT_LOC_CD" ).append("\n"); 
		query.append("FROM CGM_EQ_STS_HIS A, CGM_EQUIPMENT B" ).append("\n"); 
		query.append("WHERE A.EQ_NO = B.EQ_NO" ).append("\n"); 
		query.append("AND A.EQ_KND_CD = @[eq_knd_cd]" ).append("\n"); 
		query.append("AND A.TERM_CNG_SEQ > 0" ).append("\n"); 
		query.append("AND A.STS_EVNT_DT >= TO_DATE(@[sts_evnt_dt_fr],'YYYYMMDD')" ).append("\n"); 
		query.append("AND A.STS_EVNT_DT < TO_DATE(@[sts_evnt_dt_to],'YYYYMMDD') + 1" ).append("\n"); 
		query.append("GROUP BY A.TERM_CNG_SEQ" ).append("\n"); 
		query.append(") T1," ).append("\n"); 
		query.append("CGM_AGREEMENT T2," ).append("\n"); 
		query.append("CGM_AGREEMENT T3," ).append("\n"); 
		query.append("MDM_VENDOR T4," ).append("\n"); 
		query.append("MDM_LOCATION T5," ).append("\n"); 
		query.append("MDM_EQ_ORZ_CHT T6," ).append("\n"); 
		query.append("CGM_EQ_ATCH_DTCH_HIS T7" ).append("\n"); 
		query.append("WHERE" ).append("\n"); 
		query.append("T1.OLD_AGMT_OFC_CTY_CD = T2.AGMT_OFC_CTY_CD(+)" ).append("\n"); 
		query.append("AND T1.OLD_AGMT_SEQ = T2.AGMT_SEQ(+)" ).append("\n"); 
		query.append("AND T1.NEW_AGMT_OFC_CTY_CD = T3.AGMT_OFC_CTY_CD(+)" ).append("\n"); 
		query.append("AND T1.NEW_AGMT_SEQ = T3.AGMT_SEQ(+)" ).append("\n"); 
		query.append("AND T2.LST_VER_FLG(+) = 'Y'" ).append("\n"); 
		query.append("AND T3.LST_VER_FLG(+) = 'Y'" ).append("\n"); 
		query.append("AND T3.VNDR_SEQ = T4.VNDR_SEQ(+)" ).append("\n"); 
		query.append("AND T1.CRNT_LOC_CD = T5.LOC_CD(+)" ).append("\n"); 
		query.append("AND T5.SCC_CD = T6.SCC_CD(+)" ).append("\n"); 
		query.append("AND T5.DELT_FLG(+) = 'N'" ).append("\n"); 
		query.append("AND T6.DELT_FLG(+) = 'N'" ).append("\n"); 
		query.append("#if (${sts_evnt_ofc_cd} != '')" ).append("\n"); 
		query.append("AND T1.STS_EVNT_OFC_CD IN ($sts_evnt_ofc_cd)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${old_agmt_ofc_cty_cd} != '')" ).append("\n"); 
		query.append("AND T2.AGMT_OFC_CTY_CD = @[old_agmt_ofc_cty_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${old_agmt_seq} != '')" ).append("\n"); 
		query.append("AND T2.AGMT_SEQ = @[old_agmt_seq]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${new_agmt_ofc_cty_cd} != '')" ).append("\n"); 
		query.append("AND T3.AGMT_OFC_CTY_CD = @[new_agmt_ofc_cty_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${new_agmt_seq} != '')" ).append("\n"); 
		query.append("AND T3.AGMT_SEQ = @[new_agmt_seq]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${s_agmt_lstm_cd} != '')" ).append("\n"); 
		query.append("AND T2.AGMT_LSTM_CD IN ($s_agmt_lstm_cd)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${s2_agmt_lstm_cd} != '')" ).append("\n"); 
		query.append("AND T3.AGMT_LSTM_CD IN ($s2_agmt_lstm_cd)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${s_vndr_seq} != '')" ).append("\n"); 
		query.append("AND (T2.VNDR_SEQ IN ($s_vndr_seq) OR T3.VNDR_SEQ IN ($s_vndr_seq))" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("AND T1.EQ_NO = T7.EQ_NO(+)" ).append("\n"); 
		query.append("AND NVL(T7.ATCH_DT,  TO_DATE('11111111','YYYYMMDD') )= (SELECT  /*+ INDEX_DESC(B XPKCGM_EQ_ATCH_DTCH_HIS) */" ).append("\n"); 
		query.append("NVL(MAX(ATCH_DT), TO_DATE('11111111','YYYYMMDD') )" ).append("\n"); 
		query.append("FROM CGM_EQ_ATCH_DTCH_HIS B" ).append("\n"); 
		query.append("WHERE" ).append("\n"); 
		query.append("B.EQ_NO = T1.EQ_NO" ).append("\n"); 
		query.append("AND ROWNUM =1" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("#if (${eq_tpsz_cd} != '')" ).append("\n"); 
		query.append("AND T1.EQ_TPSZ_CD = @[eq_tpsz_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}