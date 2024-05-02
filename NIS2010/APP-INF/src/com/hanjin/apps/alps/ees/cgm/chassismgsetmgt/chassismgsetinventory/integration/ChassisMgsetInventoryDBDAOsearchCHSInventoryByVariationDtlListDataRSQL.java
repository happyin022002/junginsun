/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : ChassisMgsetInventoryDBDAOsearchCHSInventoryByVariationDtlListDataRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.01.13
*@LastModifier : 조재성
*@LastVersion : 1.0
* 2010.01.13 조재성
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

public class ChassisMgsetInventoryDBDAOsearchCHSInventoryByVariationDtlListDataRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * chungpa 20090810 1103 start
	  * </pre>
	  */
	public ChassisMgsetInventoryDBDAOsearchCHSInventoryByVariationDtlListDataRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inq_fm_dys",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eq_tpsz_cd_size",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inq_to_dys",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("crnt_loc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.cgm.chassismgsetmgt.chassismgsetinventory.integration").append("\n"); 
		query.append("FileName : ChassisMgsetInventoryDBDAOsearchCHSInventoryByVariationDtlListDataRSQL").append("\n"); 
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
		query.append("SELECT T1.EQ_NO ," ).append("\n"); 
		query.append("T2.EQ_TPSZ_CD ," ).append("\n"); 
		query.append("T2.ONH_OFC_CD ," ).append("\n"); 
		query.append("SUBSTR(T7.PK, 18, 3) AS PRE_EQ_ASET_STS_CD ," ).append("\n"); 
		query.append("SUBSTR(T7.PK, 1, 10) AS PRE_STS_EVENT_DT ," ).append("\n"); 
		query.append("SUBSTR(T7.PK, 21, 5) AS PRE_STS_EVENT_LOC_CD ," ).append("\n"); 
		query.append("SUBSTR(T7.PK, 21, 7) AS PRE_STS_EVNT_YD_CD ," ).append("\n"); 
		query.append("T1.EQ_ASET_STS_CD AS EQ_ASET_STS_CD ," ).append("\n"); 
		query.append("TO_CHAR( T1.STS_EVNT_DT, 'YYYY-MM-DD' ) AS STS_EVENT_DT ," ).append("\n"); 
		query.append("T1.STS_EVNT_LOC_CD AS STS_EVENT_LOC_CD ," ).append("\n"); 
		query.append("T1.STS_EVNT_YD_CD AS STS_EVNT_YD_CD" ).append("\n"); 
		query.append("FROM CGM_EQ_STS_HIS T1 ," ).append("\n"); 
		query.append("CGM_EQUIPMENT T2 ," ).append("\n"); 
		query.append("MDM_LOCATION T3 ," ).append("\n"); 
		query.append("MDM_EQ_ORZ_CHT T4 ," ).append("\n"); 
		query.append("CGM_EQ_TP_SZ T5 ," ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT EQ_NO," ).append("\n"); 
		query.append("MAX(TO_CHAR(STS_EVNT_DT, 'YYYY-MM-DD-HH24MISS')||EQ_ASET_STS_CD||STS_EVNT_YD_CD||TO_CHAR(CRE_DT, 'YYYY-MM-DD-HH24MISS') ) PK" ).append("\n"); 
		query.append("FROM CGM_EQ_STS_HIS A" ).append("\n"); 
		query.append("WHERE A.STS_EVNT_DT < TO_DATE( @[inq_fm_dys], 'YYYYMMDD' )" ).append("\n"); 
		query.append("GROUP BY EQ_NO ) T7" ).append("\n"); 
		query.append("WHERE T2.EQ_TPSZ_CD = T5.EQ_TPSZ_CD" ).append("\n"); 
		query.append("AND T1.STS_EVNT_LOC_CD = T3.LOC_CD" ).append("\n"); 
		query.append("AND T3.SCC_CD = T4.SCC_CD" ).append("\n"); 
		query.append("AND T3.DELT_FLG = 'N'" ).append("\n"); 
		query.append("AND T4.DELT_FLG = 'N'" ).append("\n"); 
		query.append("AND T1.EQ_KND_CD = @[eq_knd_cd]" ).append("\n"); 
		query.append("AND T2.EQ_NO = T7.EQ_NO(+)" ).append("\n"); 
		query.append("AND T1.STS_EVNT_LOC_CD IN (" ).append("\n"); 
		query.append("SELECT AA.LOC_CD" ).append("\n"); 
		query.append("FROM MDM_LOCATION AA," ).append("\n"); 
		query.append("MDM_EQ_ORZ_CHT BB" ).append("\n"); 
		query.append("WHERE AA.SCC_CD = BB.SCC_CD" ).append("\n"); 
		query.append("AND AA.DELT_FLG = 'N'" ).append("\n"); 
		query.append("AND BB.DELT_FLG = 'N' #if ( ${location} == 'RCC' )" ).append("\n"); 
		query.append("AND BB.RCC_CD = (@[crnt_loc_cd]) #elseif ( ${location} == 'LCC' )" ).append("\n"); 
		query.append("AND BB.LCC_CD = (@[crnt_loc_cd]) #elseif ( ${location} == 'SCC' )" ).append("\n"); 
		query.append("AND BB.SCC_CD = (@[crnt_loc_cd]) #end )" ).append("\n"); 
		query.append("AND T1.EQ_NO = T2.EQ_NO" ).append("\n"); 
		query.append("AND T1.ROWID = (" ).append("\n"); 
		query.append("SELECT /*+ INDEX_DESC(A XPKCGM_EQ_STS_HIS) */" ).append("\n"); 
		query.append("A.ROWID" ).append("\n"); 
		query.append("FROM CGM_EQ_STS_HIS A" ).append("\n"); 
		query.append("WHERE A.STS_EVNT_DT <= TO_DATE( @[inq_to_dys], 'YYYYMMDD' )" ).append("\n"); 
		query.append("AND A.STS_EVNT_DT >= TO_DATE( @[inq_fm_dys], 'YYYYMMDD' )" ).append("\n"); 
		query.append("AND A.EQ_NO = T1.EQ_NO" ).append("\n"); 
		query.append("AND ROWNUM = 1 )" ).append("\n"); 
		query.append("AND T1.EQ_ASET_STS_CD <> NVL( SUBSTR( T7.PK, 18, 3), 'XX')" ).append("\n"); 
		query.append("AND (T1.EQ_ASET_STS_CD," ).append("\n"); 
		query.append("NVL( SUBSTR( T7.PK, 18, 3), 'XX')) NOT IN ( ('LST'," ).append("\n"); 
		query.append("'TLL') ," ).append("\n"); 
		query.append("('LSI'," ).append("\n"); 
		query.append("'FND') ," ).append("\n"); 
		query.append("('LST'," ).append("\n"); 
		query.append("'LSO')," ).append("\n"); 
		query.append("('TLL'," ).append("\n"); 
		query.append("'LSO')," ).append("\n"); 
		query.append("('FND'," ).append("\n"); 
		query.append("'LSI') )" ).append("\n"); 
		query.append("AND T1.TERM_CNG_SEQ IS NULL #if (${include_np} != 'Y')" ).append("\n"); 
		query.append("AND T2.AGMT_LSTM_CD <>'NP' #end #if ( ${eq_tpsz_cd_size} != '' )" ).append("\n"); 
		query.append("AND T5.EQ_TPSZ_REP_CD = @[eq_tpsz_cd_size] #end #if (${include_en} == 'Y')" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("CASE" ).append("\n"); 
		query.append("WHEN LCC1 IS NULL THEN TRIM(SUBSTR(LCC2, 6, 14))" ).append("\n"); 
		query.append("ELSE TRIM(SUBSTR(LCC1, 6, 14))" ).append("\n"); 
		query.append("END AS EQ_NO ," ).append("\n"); 
		query.append("CASE" ).append("\n"); 
		query.append("WHEN LCC1 IS NULL THEN TRIM(SUBSTR(LCC2, 20, 4))" ).append("\n"); 
		query.append("ELSE TRIM(SUBSTR(LCC1, 20, 4))" ).append("\n"); 
		query.append("END AS EQ_TPSZ_CD ," ).append("\n"); 
		query.append("'EN' AS ONH_OFC_CD ," ).append("\n"); 
		query.append("'' AS PRE_EQ_ASET_STS_CD ," ).append("\n"); 
		query.append("CASE" ).append("\n"); 
		query.append("WHEN LCC2 IS NULL THEN ''" ).append("\n"); 
		query.append("ELSE TRIM(SUBSTR(LCC2, 31, 14))" ).append("\n"); 
		query.append("END AS PRE_STS_EVENT_DT ," ).append("\n"); 
		query.append("CASE" ).append("\n"); 
		query.append("WHEN LCC2 IS NULL THEN ''" ).append("\n"); 
		query.append("ELSE TRIM(SUBSTR(LCC2, 1, 5))" ).append("\n"); 
		query.append("END AS PRE_STS_EVNET_LOC_CD ," ).append("\n"); 
		query.append("CASE" ).append("\n"); 
		query.append("WHEN LCC2 IS NULL THEN ''" ).append("\n"); 
		query.append("ELSE TRIM(SUBSTR(LCC2, 24, 7))" ).append("\n"); 
		query.append("END AS PRE_STS_EVNT_YD_CD ," ).append("\n"); 
		query.append("'' AS EQ_ASET_STS_CD ," ).append("\n"); 
		query.append("CASE" ).append("\n"); 
		query.append("WHEN LCC1 IS NULL THEN ''" ).append("\n"); 
		query.append("ELSE TRIM(SUBSTR(LCC1, 31, 14))" ).append("\n"); 
		query.append("END AS STS_EVENT_DT ," ).append("\n"); 
		query.append("CASE" ).append("\n"); 
		query.append("WHEN LCC1 IS NULL THEN ''" ).append("\n"); 
		query.append("ELSE TRIM(SUBSTR(LCC1, 1, 5))" ).append("\n"); 
		query.append("END AS STS_EVNET_LOC_CD ," ).append("\n"); 
		query.append("CASE" ).append("\n"); 
		query.append("WHEN LCC1 IS NULL THEN ''" ).append("\n"); 
		query.append("ELSE TRIM(SUBSTR(LCC1, 24, 7))" ).append("\n"); 
		query.append("END AS STS_EVNT_YD_CD" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("SELECT A.LCC1 AS LCC1 ," ).append("\n"); 
		query.append("A.LCC2 AS LCC2" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("SELECT /*+ FULL(EQ) */" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT /*+ INDEX_DESC(A XAK2CGM_CHSS_MVMT_HIS)   */" ).append("\n"); 
		query.append("RPAD(NVL(A.LCC_CD, ' '), 5, ' ')||RPAD(EQ.EQ_NO, 14, ' ')||RPAD(EQ.EQ_TPSZ_CD, 4, ' ')||RPAD(A.YD_CD, 7, ' ')||RPAD(TO_CHAR(A.MVMT_DT, 'YYYY-MM-DD'), 14, ' ')" ).append("\n"); 
		query.append("FROM CGM_CHSS_MVMT_HIS A" ).append("\n"); 
		query.append("WHERE A.MVMT_DT BETWEEN TO_DATE( @[inq_fm_dys], 'YYYYMMDD' ) AND TO_DATE( @[inq_to_dys] , 'YYYYMMDD' )" ).append("\n"); 
		query.append("AND A.CHSS_NO = EQ.EQ_NO" ).append("\n"); 
		query.append("AND ROWNUM = 1) LCC1," ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT /*+ INDEX_DESC(A XAK2CGM_CHSS_MVMT_HIS)   */" ).append("\n"); 
		query.append("RPAD(NVL(A.LCC_CD, ' '), 5, ' ')||RPAD(EQ.EQ_NO, 14, ' ')||RPAD(EQ.EQ_TPSZ_CD, 4, ' ')||RPAD(A.YD_CD, 7, ' ')||RPAD(TO_CHAR(A.MVMT_DT, 'YYYY-MM-DD'), 14, ' ')" ).append("\n"); 
		query.append("FROM CGM_CHSS_MVMT_HIS A" ).append("\n"); 
		query.append("WHERE A.MVMT_DT < TO_DATE( @[inq_fm_dys], 'YYYYMMDD' )" ).append("\n"); 
		query.append("AND A.CHSS_NO = EQ.EQ_NO" ).append("\n"); 
		query.append("AND ROWNUM = 1) LCC2," ).append("\n"); 
		query.append("EQ.EQ_NO," ).append("\n"); 
		query.append("EQ.EQ_TPSZ_CD" ).append("\n"); 
		query.append("FROM CGM_EQUIPMENT EQ" ).append("\n"); 
		query.append("WHERE EQ.EQ_KND_cD = @[eq_knd_cd] #if (${include_np} != 'Y')" ).append("\n"); 
		query.append("AND EQ.AGMT_LSTM_CD <>'NP' #end ) A" ).append("\n"); 
		query.append("WHERE LCC1 IS NOT NULL" ).append("\n"); 
		query.append("AND SUBSTR(LCC1, 1, 5) <> NVL( SUBSTR(LCC2, 1, 5) , 'NIL')" ).append("\n"); 
		query.append("GROUP BY (A.LCC1 ," ).append("\n"); 
		query.append("A.LCC2) ) A" ).append("\n"); 
		query.append("WHERE (SUBSTR(LCC1, 1, 5) IN (" ).append("\n"); 
		query.append("SELECT LCC_CD" ).append("\n"); 
		query.append("FROM MDM_EQ_ORZ_CHT M" ).append("\n"); 
		query.append("WHERE #if ( ${location} == 'RCC' ) M.RCC_CD = (@[crnt_loc_cd]) #elseif ( ${location} == 'LCC' ) M.LCC_CD = (@[crnt_loc_cd]) #elseif ( ${location} == 'SCC' ) M.SCC_CD = (@[crnt_loc_cd]) #end )" ).append("\n"); 
		query.append("OR SUBSTR(LCC2, 1, 5) IN (" ).append("\n"); 
		query.append("SELECT LCC_CD" ).append("\n"); 
		query.append("FROM MDM_EQ_ORZ_CHT M" ).append("\n"); 
		query.append("WHERE #if ( ${location} == 'RCC' ) M.RCC_CD = (@[crnt_loc_cd]) #elseif ( ${location} == 'LCC' ) M.LCC_CD = (@[crnt_loc_cd]) #elseif ( ${location} == 'SCC' ) M.SCC_CD = (@[crnt_loc_cd]) #end ) ) #end" ).append("\n"); 
		query.append("ORDER BY ONH_OFC_CD, EQ_NO, EQ_TPSZ_CD" ).append("\n"); 

	}
}