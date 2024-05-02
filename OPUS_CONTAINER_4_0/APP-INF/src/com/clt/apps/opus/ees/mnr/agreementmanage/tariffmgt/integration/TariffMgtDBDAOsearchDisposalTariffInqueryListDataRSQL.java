/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : TariffMgtDBDAOsearchDisposalTariffInqueryListDataRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.05.27
*@LastModifier : 박명신
*@LastVersion : 1.0
* 2010.05.27 박명신
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.mnr.agreementmanage.tariffmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author park myoung sin
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TariffMgtDBDAOsearchDisposalTariffInqueryListDataRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchDisposalTariffInqueryListData
	  * </pre>
	  */
	public TariffMgtDBDAOsearchDisposalTariffInqueryListDataRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eff_dt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("mnr_disp_trf_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mnr_disp_trf_grp_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.mnr.agreementmanage.tariffmgt.integration").append("\n"); 
		query.append("FileName : TariffMgtDBDAOsearchDisposalTariffInqueryListDataRSQL").append("\n"); 
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
		query.append("WITH EQ_LIST" ).append("\n"); 
		query.append("AS (" ).append("\n"); 
		query.append("SELECT EQ_KIND," ).append("\n"); 
		query.append("MAX(DECODE(RNK, 1, TPSZ)) TS01, MAX(DECODE(RNK, 2, TPSZ)) TS02, MAX(DECODE(RNK, 3, TPSZ)) TS03, MAX(DECODE(RNK, 4, TPSZ)) TS04, MAX(DECODE(RNK, 5, TPSZ)) TS05," ).append("\n"); 
		query.append("MAX(DECODE(RNK, 6, TPSZ)) TS06, MAX(DECODE(RNK, 7, TPSZ)) TS07, MAX(DECODE(RNK, 8, TPSZ)) TS08, MAX(DECODE(RNK, 9, TPSZ)) TS09, MAX(DECODE(RNK, 10, TPSZ)) TS10," ).append("\n"); 
		query.append("MAX(DECODE(RNK, 11, TPSZ)) TS11, MAX(DECODE(RNK, 12, TPSZ)) TS12, MAX(DECODE(RNK, 13, TPSZ)) TS13, MAX(DECODE(RNK, 14, TPSZ)) TS14, MAX(DECODE(RNK, 15, TPSZ)) TS15," ).append("\n"); 
		query.append("MAX(DECODE(RNK, 16, TPSZ)) TS16, MAX(DECODE(RNK, 17, TPSZ)) TS17, MAX(DECODE(RNK, 18, TPSZ)) TS18, MAX(DECODE(RNK, 19, TPSZ)) TS19, MAX(DECODE(RNK, 20, TPSZ)) TS20," ).append("\n"); 
		query.append("MAX(DECODE(RNK, 21, TPSZ)) TS21, MAX(DECODE(RNK, 22, TPSZ)) TS22, MAX(DECODE(RNK, 23, TPSZ)) TS23, MAX(DECODE(RNK, 24, TPSZ)) TS24, MAX(DECODE(RNK, 25, TPSZ)) TS25," ).append("\n"); 
		query.append("MAX(DECODE(RNK, 26, TPSZ)) TS26, MAX(DECODE(RNK, 27, TPSZ)) TS27, MAX(DECODE(RNK, 28, TPSZ)) TS28, MAX(DECODE(RNK, 29, TPSZ)) TS29, MAX(DECODE(RNK, 30, TPSZ)) TS30" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("SELECT  EQ_KIND, TPSZ, ROW_NUMBER() OVER(ORDER BY EQ_KIND, DP_SEQ) RNK" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT 'U' EQ_KIND,  A.CNTR_TPSZ_CD    TPSZ, A.RPT_DP_SEQ DP_SEQ" ).append("\n"); 
		query.append("FROM MDM_CNTR_TP_SZ A" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND   'U' = @[eq_knd_cd]" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT A.EQ_KND_CD EQ_KIND, A.EQ_TPSZ_CD    TPSZ, A.DP_SEQ DP_SEQ" ).append("\n"); 
		query.append("FROM CGM_EQ_TP_SZ A" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND   A.EQ_KND_CD = @[eq_knd_cd]" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("GROUP BY EQ_KIND" ).append("\n"); 
		query.append(")," ).append("\n"); 
		query.append("LV_PFMC AS" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("A.MNR_DISP_TRF_SEQ" ).append("\n"); 
		query.append(",A.MNR_DISP_TRF_GRP_CD" ).append("\n"); 
		query.append(",A.CTRL_OFC_CD" ).append("\n"); 
		query.append(",A.LOC_CD" ).append("\n"); 
		query.append(",A.CURR_CD" ).append("\n"); 
		query.append(",TO_CHAR(B.EFF_DT, 'YYYY-MM-DD') EFF_DT" ).append("\n"); 
		query.append(",B.MNR_DISP_TRF_STS_CD" ).append("\n"); 
		query.append(",B.MNR_DISP_TRF_TP_CD" ).append("\n"); 
		query.append(",MAX(DECODE(P.TS01, A.EQ_TPSZ_CD, A.MNR_DISP_TRF_AMT)) TS01_P" ).append("\n"); 
		query.append(",MAX(DECODE(P.TS02, A.EQ_TPSZ_CD, A.MNR_DISP_TRF_AMT)) TS02_P" ).append("\n"); 
		query.append(",MAX(DECODE(P.TS03, A.EQ_TPSZ_CD, A.MNR_DISP_TRF_AMT)) TS03_P" ).append("\n"); 
		query.append(",MAX(DECODE(P.TS04, A.EQ_TPSZ_CD, A.MNR_DISP_TRF_AMT)) TS04_P" ).append("\n"); 
		query.append(",MAX(DECODE(P.TS05, A.EQ_TPSZ_CD, A.MNR_DISP_TRF_AMT)) TS05_P" ).append("\n"); 
		query.append(",MAX(DECODE(P.TS06, A.EQ_TPSZ_CD, A.MNR_DISP_TRF_AMT)) TS06_P" ).append("\n"); 
		query.append(",MAX(DECODE(P.TS07, A.EQ_TPSZ_CD, A.MNR_DISP_TRF_AMT)) TS07_P" ).append("\n"); 
		query.append(",MAX(DECODE(P.TS08, A.EQ_TPSZ_CD, A.MNR_DISP_TRF_AMT)) TS08_P" ).append("\n"); 
		query.append(",MAX(DECODE(P.TS09, A.EQ_TPSZ_CD, A.MNR_DISP_TRF_AMT)) TS09_P" ).append("\n"); 
		query.append(",MAX(DECODE(P.TS10, A.EQ_TPSZ_CD, A.MNR_DISP_TRF_AMT)) TS10_P" ).append("\n"); 
		query.append(",MAX(DECODE(P.TS11, A.EQ_TPSZ_CD, A.MNR_DISP_TRF_AMT)) TS11_P" ).append("\n"); 
		query.append(",MAX(DECODE(P.TS12, A.EQ_TPSZ_CD, A.MNR_DISP_TRF_AMT)) TS12_P" ).append("\n"); 
		query.append(",MAX(DECODE(P.TS13, A.EQ_TPSZ_CD, A.MNR_DISP_TRF_AMT)) TS13_P" ).append("\n"); 
		query.append(",MAX(DECODE(P.TS14, A.EQ_TPSZ_CD, A.MNR_DISP_TRF_AMT)) TS14_P" ).append("\n"); 
		query.append(",MAX(DECODE(P.TS15, A.EQ_TPSZ_CD, A.MNR_DISP_TRF_AMT)) TS15_P" ).append("\n"); 
		query.append(",MAX(DECODE(P.TS16, A.EQ_TPSZ_CD, A.MNR_DISP_TRF_AMT)) TS16_P" ).append("\n"); 
		query.append(",MAX(DECODE(P.TS17, A.EQ_TPSZ_CD, A.MNR_DISP_TRF_AMT)) TS17_P" ).append("\n"); 
		query.append(",MAX(DECODE(P.TS18, A.EQ_TPSZ_CD, A.MNR_DISP_TRF_AMT)) TS18_P" ).append("\n"); 
		query.append(",MAX(DECODE(P.TS19, A.EQ_TPSZ_CD, A.MNR_DISP_TRF_AMT)) TS19_P" ).append("\n"); 
		query.append(",MAX(DECODE(P.TS20, A.EQ_TPSZ_CD, A.MNR_DISP_TRF_AMT)) TS20_P" ).append("\n"); 
		query.append(",MAX(DECODE(P.TS21, A.EQ_TPSZ_CD, A.MNR_DISP_TRF_AMT)) TS21_P" ).append("\n"); 
		query.append(",MAX(DECODE(P.TS22, A.EQ_TPSZ_CD, A.MNR_DISP_TRF_AMT)) TS22_P" ).append("\n"); 
		query.append(",MAX(DECODE(P.TS23, A.EQ_TPSZ_CD, A.MNR_DISP_TRF_AMT)) TS23_P" ).append("\n"); 
		query.append(",MAX(DECODE(P.TS24, A.EQ_TPSZ_CD, A.MNR_DISP_TRF_AMT)) TS24_P" ).append("\n"); 
		query.append(",MAX(DECODE(P.TS25, A.EQ_TPSZ_CD, A.MNR_DISP_TRF_AMT)) TS25_P" ).append("\n"); 
		query.append(",MAX(DECODE(P.TS26, A.EQ_TPSZ_CD, A.MNR_DISP_TRF_AMT)) TS26_P" ).append("\n"); 
		query.append(",MAX(DECODE(P.TS27, A.EQ_TPSZ_CD, A.MNR_DISP_TRF_AMT)) TS27_P" ).append("\n"); 
		query.append(",MAX(DECODE(P.TS28, A.EQ_TPSZ_CD, A.MNR_DISP_TRF_AMT)) TS28_P" ).append("\n"); 
		query.append(",MAX(DECODE(P.TS29, A.EQ_TPSZ_CD, A.MNR_DISP_TRF_AMT)) TS29_P" ).append("\n"); 
		query.append(",MAX(DECODE(P.TS30, A.EQ_TPSZ_CD, A.MNR_DISP_TRF_AMT)) TS30_P" ).append("\n"); 
		query.append("FROM MNR_DISP_TRF_DTL A, MNR_DISP_TRF_HDR B, EQ_LIST P" ).append("\n"); 
		query.append("WHERE A.MNR_DISP_TRF_SEQ = B.MNR_DISP_TRF_SEQ" ).append("\n"); 
		query.append("AND B.EQ_KND_CD = @[eq_knd_cd]" ).append("\n"); 
		query.append("#if (${mnr_disp_trf_tp_cd} != 'ALL')" ).append("\n"); 
		query.append("AND B.MNR_DISP_TRF_TP_CD = @[mnr_disp_trf_tp_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${mnr_disp_trf_grp_cd} != 'ALL')" ).append("\n"); 
		query.append("AND A.MNR_DISP_TRF_GRP_CD = @[mnr_disp_trf_grp_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${eff_dt} != 'ALL')" ).append("\n"); 
		query.append("AND B.MNR_DISP_TRF_SEQ = @[eff_dt]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("GROUP BY" ).append("\n"); 
		query.append("A.MNR_DISP_TRF_SEQ" ).append("\n"); 
		query.append(",A.MNR_DISP_TRF_GRP_CD" ).append("\n"); 
		query.append(",A.CTRL_OFC_CD" ).append("\n"); 
		query.append(",A.LOC_CD" ).append("\n"); 
		query.append(",A.CURR_CD" ).append("\n"); 
		query.append(",TO_CHAR(B.EFF_DT, 'YYYY-MM-DD')" ).append("\n"); 
		query.append(",B.MNR_DISP_TRF_STS_CD" ).append("\n"); 
		query.append(",B.MNR_DISP_TRF_TP_CD" ).append("\n"); 
		query.append("ORDER BY A.MNR_DISP_TRF_SEQ,A.MNR_DISP_TRF_GRP_CD,A.LOC_CD,A.CURR_CD" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("RSV.MNR_DISP_TRF_SEQ" ).append("\n"); 
		query.append(",RSV.MNR_DISP_TRF_GRP_CD" ).append("\n"); 
		query.append(",RSV.MNR_DISP_TRF_GRP_NM" ).append("\n"); 
		query.append(",DECODE(RSV.MNR_DISP_TRF_GRP_CD,'CNT',RSV.LOC_CD,RSV.CTRL_OFC_CD) AS CTRL_OFC_CD" ).append("\n"); 
		query.append(",RSV.LOC_CD" ).append("\n"); 
		query.append(",RSV.CURR_CD" ).append("\n"); 
		query.append(",RSV.EFF_DT" ).append("\n"); 
		query.append(",RSV.MNR_DISP_TRF_STS_CD" ).append("\n"); 
		query.append(",RSV.MNR_DISP_TRF_STS_NM" ).append("\n"); 
		query.append(",RSV.MNR_DISP_TRF_TP_CD" ).append("\n"); 
		query.append(",RSV.MNR_DISP_TRF_TP_NM" ).append("\n"); 
		query.append(",DECODE(CTRL_OFC_CD,'TITLE', NVL(P.TS01,'N') || '|' || NVL(P.TS02,'N') || '|' ||" ).append("\n"); 
		query.append("NVL(P.TS03,'N') || '|' || NVL(P.TS04,'N') || '|' ||" ).append("\n"); 
		query.append("NVL(P.TS05,'N') || '|' || NVL(P.TS06,'N') || '|' ||" ).append("\n"); 
		query.append("NVL(P.TS07,'N') || '|' || NVL(P.TS08,'N') || '|' ||" ).append("\n"); 
		query.append("NVL(P.TS09,'N') || '|' || NVL(P.TS10,'N') || '|' ||" ).append("\n"); 
		query.append("NVL(P.TS11,'N') || '|' || NVL(P.TS12,'N') || '|' ||" ).append("\n"); 
		query.append("NVL(P.TS13,'N') || '|' || NVL(P.TS14,'N') || '|' ||" ).append("\n"); 
		query.append("NVL(P.TS15,'N') || '|' || NVL(P.TS16,'N') || '|' ||" ).append("\n"); 
		query.append("NVL(P.TS17,'N') || '|' || NVL(P.TS18,'N') || '|' ||" ).append("\n"); 
		query.append("NVL(P.TS19,'N') || '|' || NVL(P.TS20,'N') || '|' ||" ).append("\n"); 
		query.append("NVL(P.TS21,'N') || '|' || NVL(P.TS22,'N') || '|' ||" ).append("\n"); 
		query.append("NVL(P.TS23,'N') || '|' || NVL(P.TS24,'N') || '|' ||" ).append("\n"); 
		query.append("NVL(P.TS25,'N') || '|' || NVL(P.TS26,'N') || '|' ||" ).append("\n"); 
		query.append("NVL(P.TS27,'N') || '|' || NVL(P.TS28,'N') || '|' ||" ).append("\n"); 
		query.append("NVL(P.TS29,'N') || '|' || NVL(P.TS30,'N'),'') AS TITLE," ).append("\n"); 
		query.append("RSV.TS01  ,RSV.TS02" ).append("\n"); 
		query.append(",RSV.TS03  ,RSV.TS04" ).append("\n"); 
		query.append(",RSV.TS05  ,RSV.TS06" ).append("\n"); 
		query.append(",RSV.TS07  ,RSV.TS08" ).append("\n"); 
		query.append(",RSV.TS09  ,RSV.TS10" ).append("\n"); 
		query.append(",RSV.TS11  ,RSV.TS12" ).append("\n"); 
		query.append(",RSV.TS13  ,RSV.TS14" ).append("\n"); 
		query.append(",RSV.TS15  ,RSV.TS16" ).append("\n"); 
		query.append(",RSV.TS17  ,RSV.TS18" ).append("\n"); 
		query.append(",RSV.TS19  ,RSV.TS20" ).append("\n"); 
		query.append(",RSV.TS21  ,RSV.TS22" ).append("\n"); 
		query.append(",RSV.TS23  ,RSV.TS24" ).append("\n"); 
		query.append(",RSV.TS25  ,RSV.TS26" ).append("\n"); 
		query.append(",RSV.TS27  ,RSV.TS28" ).append("\n"); 
		query.append(",RSV.TS29  ,RSV.TS30" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("0 AS MNR_DISP_TRF_SEQ," ).append("\n"); 
		query.append("'' AS MNR_DISP_TRF_GRP_CD," ).append("\n"); 
		query.append("'' AS MNR_DISP_TRF_GRP_NM," ).append("\n"); 
		query.append("'TITLE' AS CTRL_OFC_CD," ).append("\n"); 
		query.append("'' AS LOC_CD," ).append("\n"); 
		query.append("'' AS CURR_CD," ).append("\n"); 
		query.append("'' AS EFF_DT," ).append("\n"); 
		query.append("'' AS MNR_DISP_TRF_STS_CD," ).append("\n"); 
		query.append("'' AS MNR_DISP_TRF_STS_NM," ).append("\n"); 
		query.append("'' AS MNR_DISP_TRF_TP_CD," ).append("\n"); 
		query.append("'' AS MNR_DISP_TRF_TP_NM," ).append("\n"); 
		query.append("NVL(P.TS01,'N') AS TS01,  NVL(P.TS02,'N') AS TS02," ).append("\n"); 
		query.append("NVL(P.TS03,'N') AS TS03,  NVL(P.TS04,'N') AS TS04," ).append("\n"); 
		query.append("NVL(P.TS05,'N') AS TS05,  NVL(P.TS06,'N') AS TS06," ).append("\n"); 
		query.append("NVL(P.TS07,'N') AS TS07,  NVL(P.TS08,'N') AS TS08," ).append("\n"); 
		query.append("NVL(P.TS09,'N') AS TS09,  NVL(P.TS10,'N') AS TS10," ).append("\n"); 
		query.append("NVL(P.TS11,'N') AS TS11,  NVL(P.TS12,'N') AS TS12," ).append("\n"); 
		query.append("NVL(P.TS13,'N') AS TS13,  NVL(P.TS14,'N') AS TS14," ).append("\n"); 
		query.append("NVL(P.TS15,'N') AS TS15,  NVL(P.TS16,'N') AS TS16," ).append("\n"); 
		query.append("NVL(P.TS17,'N') AS TS17,  NVL(P.TS18,'N') AS TS18," ).append("\n"); 
		query.append("NVL(P.TS19,'N') AS TS19,  NVL(P.TS20,'N') AS TS20," ).append("\n"); 
		query.append("NVL(P.TS21,'N') AS TS21,  NVL(P.TS22,'N') AS TS22," ).append("\n"); 
		query.append("NVL(P.TS23,'N') AS TS23,  NVL(P.TS24,'N') AS TS24," ).append("\n"); 
		query.append("NVL(P.TS25,'N') AS TS25,  NVL(P.TS26,'N') AS TS26," ).append("\n"); 
		query.append("NVL(P.TS27,'N') AS TS27,  NVL(P.TS28,'N') AS TS28," ).append("\n"); 
		query.append("NVL(P.TS29,'N') AS TS29,  NVL(P.TS30,'N') AS TS30" ).append("\n"); 
		query.append("FROM EQ_LIST P" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("A.MNR_DISP_TRF_SEQ" ).append("\n"); 
		query.append(",A.MNR_DISP_TRF_GRP_CD" ).append("\n"); 
		query.append(",(SELECT MNR_CD_DESC FROM MNR_GEN_CD GD" ).append("\n"); 
		query.append("WHERE GD.PRNT_CD_ID = 'CD00048'" ).append("\n"); 
		query.append("AND GD.MNR_CD_ID = A.MNR_DISP_TRF_GRP_CD) AS MNR_DISP_TRF_GRP_NM" ).append("\n"); 
		query.append(",A.CTRL_OFC_CD" ).append("\n"); 
		query.append(",A.LOC_CD" ).append("\n"); 
		query.append(",A.CURR_CD" ).append("\n"); 
		query.append(",A.EFF_DT" ).append("\n"); 
		query.append(",A.MNR_DISP_TRF_STS_CD" ).append("\n"); 
		query.append(",DECODE(A.MNR_DISP_TRF_STS_CD,'S','Save','C','Confirm','New') AS MNR_DISP_TRF_STS_NM" ).append("\n"); 
		query.append(",MNR_DISP_TRF_TP_CD" ).append("\n"); 
		query.append(",(SELECT MNR_CD_DESC FROM MNR_GEN_CD GD" ).append("\n"); 
		query.append("WHERE GD.PRNT_CD_ID = 'CD00047'" ).append("\n"); 
		query.append("AND GD.MNR_CD_ID = A.MNR_DISP_TRF_TP_CD) AS MNR_DISP_TRF_TP_NM" ).append("\n"); 
		query.append(",TO_CHAR(A.TS01_P) AS TS01  ,TO_CHAR(A.TS02_P) AS TS02" ).append("\n"); 
		query.append(",TO_CHAR(A.TS03_P) AS TS03  ,TO_CHAR(A.TS04_P) AS TS04" ).append("\n"); 
		query.append(",TO_CHAR(A.TS05_P) AS TS05  ,TO_CHAR(A.TS06_P) AS TS06" ).append("\n"); 
		query.append(",TO_CHAR(A.TS07_P) AS TS07  ,TO_CHAR(A.TS08_P) AS TS08" ).append("\n"); 
		query.append(",TO_CHAR(A.TS09_P) AS TS09  ,TO_CHAR(A.TS10_P) AS TS10" ).append("\n"); 
		query.append(",TO_CHAR(A.TS11_P) AS TS11  ,TO_CHAR(A.TS12_P) AS TS12" ).append("\n"); 
		query.append(",TO_CHAR(A.TS13_P) AS TS13  ,TO_CHAR(A.TS14_P) AS TS14" ).append("\n"); 
		query.append(",TO_CHAR(A.TS15_P) AS TS15  ,TO_CHAR(A.TS16_P) AS TS16" ).append("\n"); 
		query.append(",TO_CHAR(A.TS17_P) AS TS17  ,TO_CHAR(A.TS18_P) AS TS18" ).append("\n"); 
		query.append(",TO_CHAR(A.TS19_P) AS TS19  ,TO_CHAR(A.TS20_P) AS TS20" ).append("\n"); 
		query.append(",TO_CHAR(A.TS21_P) AS TS21  ,TO_CHAR(A.TS22_P) AS TS22" ).append("\n"); 
		query.append(",TO_CHAR(A.TS23_P) AS TS23  ,TO_CHAR(A.TS24_P) AS TS24" ).append("\n"); 
		query.append(",TO_CHAR(A.TS25_P) AS TS25  ,TO_CHAR(A.TS26_P) AS TS26" ).append("\n"); 
		query.append(",TO_CHAR(A.TS27_P) AS TS27  ,TO_CHAR(A.TS28_P) AS TS28" ).append("\n"); 
		query.append(",TO_CHAR(A.TS29_P) AS TS29  ,TO_CHAR(A.TS30_P) AS TS30" ).append("\n"); 
		query.append("FROM LV_PFMC A" ).append("\n"); 
		query.append(") RSV,EQ_LIST P" ).append("\n"); 

	}
}