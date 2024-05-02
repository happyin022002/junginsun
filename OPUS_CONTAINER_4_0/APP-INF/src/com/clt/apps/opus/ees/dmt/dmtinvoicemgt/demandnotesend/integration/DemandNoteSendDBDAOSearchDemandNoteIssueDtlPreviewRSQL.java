/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : DemandNoteSendDBDAOSearchDemandNoteIssueDtlPreviewRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.18
*@LastModifier : 최성환
*@LastVersion : 1.0
* 2009.11.18 최성환
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.dmt.dmtinvoicemgt.demandnotesend.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Choi Sung Hwan
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class DemandNoteSendDBDAOSearchDemandNoteIssueDtlPreviewRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchDemandNoteIssueDtlPreview
	  * </pre>
	  */
	public DemandNoteSendDBDAOSearchDemandNoteIssueDtlPreviewRSQL(){
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
		params.put("dmdt_trf_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.dmt.dmtinvoicemgt.demandnotesend.integration").append("\n"); 
		query.append("FileName : DemandNoteSendDBDAOSearchDemandNoteIssueDtlPreviewRSQL").append("\n"); 
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
		query.append("#if (${call_to_rd_tp} == 'group')" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("SELECT B.VSL_CD" ).append("\n"); 
		query.append("|| B.SKD_VOY_NO" ).append("\n"); 
		query.append("|| B.SKD_DIR_CD AS VVD_CD" ).append("\n"); 
		query.append(",B.BL_NO" ).append("\n"); 
		query.append(",CASE" ).append("\n"); 
		query.append("WHEN C.DMDT_TRF_CD IN ('DMIF', 'DMOF')" ).append("\n"); 
		query.append("THEN SUBSTR (C.FM_MVMT_YD_CD,1,5)" ).append("\n"); 
		query.append("WHEN C.DMDT_TRF_CD IN ('DTIC', 'CTIC')" ).append("\n"); 
		query.append("THEN B.DEL_CD" ).append("\n"); 
		query.append("ELSE B.POR_CD" ).append("\n"); 
		query.append("END AS LOC" ).append("\n"); 
		query.append(",B.CNTR_NO" ).append("\n"); 
		query.append(",B.CNTR_TPSZ_CD" ).append("\n"); 
		query.append(",TO_CHAR (C.FM_MVMT_DT, 'DDMonYY', 'NLS_DATE_LANGUAGE = American') AS FM_MVMT_DT" ).append("\n"); 
		query.append(",TO_CHAR (C.TO_MVMT_DT, 'DDMonYY', 'NLS_DATE_LANGUAGE = American') AS TO_MVMT_DT" ).append("\n"); 
		query.append(",TO_CHAR (C.FT_CMNC_DT, 'DDMonYY', 'NLS_DATE_LANGUAGE = American') AS FT_CMNC_DT" ).append("\n"); 
		query.append(",TO_CHAR (C.FT_END_DT,  'DDMonYY', 'NLS_DATE_LANGUAGE = American') AS FT_END_DT" ).append("\n"); 
		query.append(",C.FT_DYS" ).append("\n"); 
		query.append(",C.FX_FT_OVR_DYS" ).append("\n"); 
		query.append(",C.BZC_TRF_CURR_CD" ).append("\n"); 
		query.append(",C.ORG_CHG_AMT" ).append("\n"); 
		query.append(",NVL (C.SC_RFA_EXPT_AMT, 0) + NVL (C.CMDT_EXPT_AMT, 0) AS EXPT_AMT" ).append("\n"); 
		query.append(",C.AFT_EXPT_DC_AMT" ).append("\n"); 
		query.append(",C.BIL_AMT" ).append("\n"); 
		query.append(",DECODE (C.CHG_SEQ,'1', 'G','B') AS GB" ).append("\n"); 
		query.append(",C.SYS_AREA_GRP_ID AS SVR_ID" ).append("\n"); 
		query.append(",C.CNTR_CYC_NO" ).append("\n"); 
		query.append(",C.DMDT_TRF_CD" ).append("\n"); 
		query.append(",C.DMDT_CHG_LOC_DIV_CD" ).append("\n"); 
		query.append(",C.CHG_SEQ" ).append("\n"); 
		query.append(",C.BZC_TRF_SEQ" ).append("\n"); 
		query.append(",C.BZC_TRF_GRP_SEQ" ).append("\n"); 
		query.append(",C.DMDT_CHG_STS_CD" ).append("\n"); 
		query.append(",C.ACT_CNT_CD" ).append("\n"); 
		query.append(",C.ACT_CUST_SEQ" ).append("\n"); 
		query.append("FROM DMT_CHG_BKG_CNTR B" ).append("\n"); 
		query.append(",DMT_CHG_CALC C" ).append("\n"); 
		query.append("WHERE B.SYS_AREA_GRP_ID = C.SYS_AREA_GRP_ID" ).append("\n"); 
		query.append("AND B.CNTR_NO = C.CNTR_NO" ).append("\n"); 
		query.append("AND B.CNTR_CYC_NO = C.CNTR_CYC_NO" ).append("\n"); 
		query.append("AND C.DMDT_TRF_CD = @[dmdt_trf_cd]  ##'DMIF'" ).append("\n"); 
		query.append("##   AND C.DMDT_CHG_STS_CD IN ('A', 'F', 'L', 'U', 'C', 'I')" ).append("\n"); 
		query.append("#if (${dmdt_chg_sts_cd} != '')" ).append("\n"); 
		query.append("AND C.DMDT_CHG_STS_CD IN (" ).append("\n"); 
		query.append("#foreach( $chg_sts_cd in ${chg_sts_cd_list} )" ).append("\n"); 
		query.append("#if($velocityCount < $chg_sts_cd_list.size()) '$chg_sts_cd', #else '$chg_sts_cd' #end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("##   AND B.BKG_NO IN ('ALCY7300003', 'ALCY8030005B1')" ).append("\n"); 
		query.append("#if (${bkg_no} != '')" ).append("\n"); 
		query.append("AND B.BKG_NO IN (" ).append("\n"); 
		query.append("#foreach( $bkg_cd in ${bkg_no_list} )" ).append("\n"); 
		query.append("#if($velocityCount < $bkg_no_list.size()) '$bkg_cd', #else '$bkg_cd' #end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("## group 호출 finish" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("SELECT CNTR_NO" ).append("\n"); 
		query.append(",CNTR_TPSZ_CD" ).append("\n"); 
		query.append(",FM_MVMT_DT" ).append("\n"); 
		query.append(",TO_MVMT_DT" ).append("\n"); 
		query.append(",FT_CMNC_DT" ).append("\n"); 
		query.append(",FT_END_DT" ).append("\n"); 
		query.append(",FT_DYS" ).append("\n"); 
		query.append(",FT_OVR_UND_DYS" ).append("\n"); 
		query.append(",RT_AMT" ).append("\n"); 
		query.append(",FX_FT_OVR_DYS" ).append("\n"); 
		query.append(",RT_AMOUNT" ).append("\n"); 
		query.append(",BZC_TRF_CURR_CD" ).append("\n"); 
		query.append("FROM (SELECT B.CNTR_NO" ).append("\n"); 
		query.append(",B.CNTR_TPSZ_CD" ).append("\n"); 
		query.append(",TO_CHAR (C.FM_MVMT_DT, 'DDMonYY', 'NLS_DATE_LANGUAGE = American') AS FM_MVMT_DT" ).append("\n"); 
		query.append(",TO_CHAR (C.TO_MVMT_DT, 'DDMonYY', 'NLS_DATE_LANGUAGE = American') AS TO_MVMT_DT" ).append("\n"); 
		query.append(",TO_CHAR (C.FT_CMNC_DT, 'DDMonYY', 'NLS_DATE_LANGUAGE = American') AS FT_CMNC_DT" ).append("\n"); 
		query.append(",TO_CHAR (C.FT_END_DT,  'DDMonYY', 'NLS_DATE_LANGUAGE = American') AS FT_END_DT" ).append("\n"); 
		query.append(",C.FT_DYS" ).append("\n"); 
		query.append(", R.FT_OVR_DYS" ).append("\n"); 
		query.append("|| ' - '" ).append("\n"); 
		query.append("|| R.FT_UND_DYS AS FT_OVR_UND_DYS" ).append("\n"); 
		query.append(",DECODE (SUBSTR (B.CNTR_TPSZ_CD" ).append("\n"); 
		query.append(",2" ).append("\n"); 
		query.append(",1" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append(",'2', R.CNTR_20FT_RT_AMT" ).append("\n"); 
		query.append(",'4', R.CNTR_40FT_RT_AMT" ).append("\n"); 
		query.append(",'5', R.CNTR_HC_RT_AMT" ).append("\n"); 
		query.append(",'7', R.CNTR_45FT_RT_AMT" ).append("\n"); 
		query.append(") AS RT_AMT" ).append("\n"); 
		query.append(",C.FX_FT_OVR_DYS" ).append("\n"); 
		query.append(", (DECODE (SUBSTR (B.CNTR_TPSZ_CD" ).append("\n"); 
		query.append(",2" ).append("\n"); 
		query.append(",1" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append(",'2', R.CNTR_20FT_RT_AMT" ).append("\n"); 
		query.append(",'4', R.CNTR_40FT_RT_AMT" ).append("\n"); 
		query.append(",'5', R.CNTR_HC_RT_AMT" ).append("\n"); 
		query.append(",'7', R.CNTR_45FT_RT_AMT" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("* C.FX_FT_OVR_DYS" ).append("\n"); 
		query.append(") AS RT_AMOUNT" ).append("\n"); 
		query.append(",C.BZC_TRF_CURR_CD" ).append("\n"); 
		query.append(",C.DMDT_TRF_APLY_TP_CD" ).append("\n"); 
		query.append("FROM DMT_CHG_BKG_CNTR B" ).append("\n"); 
		query.append(",DMT_CHG_CALC C" ).append("\n"); 
		query.append(",DMT_TRF_RT R" ).append("\n"); 
		query.append("WHERE B.SYS_AREA_GRP_ID = C.SYS_AREA_GRP_ID" ).append("\n"); 
		query.append("AND B.CNTR_NO = C.CNTR_NO" ).append("\n"); 
		query.append("AND B.CNTR_CYC_NO = C.CNTR_CYC_NO" ).append("\n"); 
		query.append("AND C.DMDT_TRF_APLY_TP_CD = 'G'" ).append("\n"); 
		query.append("AND C.SYS_AREA_GRP_ID = R.SYS_AREA_GRP_ID" ).append("\n"); 
		query.append("AND C.DMDT_TRF_CD = R.DMDT_TRF_CD" ).append("\n"); 
		query.append("AND C.BZC_TRF_SEQ = R.TRF_SEQ" ).append("\n"); 
		query.append("AND C.BZC_TRF_GRP_SEQ = R.TRF_GRP_SEQ" ).append("\n"); 
		query.append("AND C.DMDT_TRF_CD = @[dmdt_trf_cd]" ).append("\n"); 
		query.append("AND B.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT B.CNTR_NO" ).append("\n"); 
		query.append(",B.CNTR_TPSZ_CD" ).append("\n"); 
		query.append(",TO_CHAR (C.FM_MVMT_DT, 'DDMMYY') AS FM_MVMT_DT" ).append("\n"); 
		query.append(",TO_CHAR (C.TO_MVMT_DT, 'DDMMYY') AS TO_MVMT_DT" ).append("\n"); 
		query.append(",TO_CHAR (C.FT_CMNC_DT, 'DDMMYY') AS FT_CMNC_DT" ).append("\n"); 
		query.append(",TO_CHAR (C.FT_END_DT, 'DDMMYY') AS FT_END_DT" ).append("\n"); 
		query.append(",C.FT_DYS" ).append("\n"); 
		query.append(", R.FT_FM_DYS" ).append("\n"); 
		query.append("|| ' - '" ).append("\n"); 
		query.append("|| R.FT_TO_DYS AS FT_OVR_UND_DYS" ).append("\n"); 
		query.append(",DECODE (SUBSTR (B.CNTR_TPSZ_CD" ).append("\n"); 
		query.append(",2" ).append("\n"); 
		query.append(",1" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append(",'2', R.CNTR_20FT_RT_AMT" ).append("\n"); 
		query.append(",'4', R.CNTR_40FT_RT_AMT" ).append("\n"); 
		query.append(",'5', R.CNTR_HC_RT_AMT" ).append("\n"); 
		query.append(",'7', R.CNTR_45FT_RT_AMT" ).append("\n"); 
		query.append(") AS RT_AMT" ).append("\n"); 
		query.append(",C.FX_FT_OVR_DYS" ).append("\n"); 
		query.append(", (DECODE (SUBSTR (B.CNTR_TPSZ_CD" ).append("\n"); 
		query.append(",2" ).append("\n"); 
		query.append(",1" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append(",'2', R.CNTR_20FT_RT_AMT" ).append("\n"); 
		query.append(",'4', R.CNTR_40FT_RT_AMT" ).append("\n"); 
		query.append(",'5', R.CNTR_HC_RT_AMT" ).append("\n"); 
		query.append(",'7', R.CNTR_45FT_RT_AMT" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("* C.FX_FT_OVR_DYS" ).append("\n"); 
		query.append(") AS RT_AMOUNT" ).append("\n"); 
		query.append(",C.BZC_TRF_CURR_CD" ).append("\n"); 
		query.append(",C.DMDT_TRF_APLY_TP_CD" ).append("\n"); 
		query.append("FROM DMT_CHG_BKG_CNTR B" ).append("\n"); 
		query.append(",DMT_CHG_CALC C" ).append("\n"); 
		query.append(",DMT_SC_EXPT_RT_ADJ R" ).append("\n"); 
		query.append(",PRI_SP_HDR P" ).append("\n"); 
		query.append("WHERE B.SYS_AREA_GRP_ID = C.SYS_AREA_GRP_ID" ).append("\n"); 
		query.append("AND B.CNTR_NO = C.CNTR_NO" ).append("\n"); 
		query.append("AND B.CNTR_CYC_NO = C.CNTR_CYC_NO" ).append("\n"); 
		query.append("AND C.DMDT_TRF_APLY_TP_CD = 'S'" ).append("\n"); 
		query.append("AND C.SC_NO = P.SC_NO" ).append("\n"); 
		query.append("AND P.PROP_NO = R.PROP_NO" ).append("\n"); 
		query.append("AND C.SC_EXPT_VER_SEQ = R.SC_EXPT_VER_SEQ" ).append("\n"); 
		query.append("AND C.SC_EXPT_GRP_SEQ = R.SC_EXPT_GRP_SEQ" ).append("\n"); 
		query.append("AND C.DMDT_TRF_CD = @[dmdt_trf_cd]" ).append("\n"); 
		query.append("AND B.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT B.CNTR_NO" ).append("\n"); 
		query.append(",B.CNTR_TPSZ_CD" ).append("\n"); 
		query.append(",TO_CHAR (C.FM_MVMT_DT, 'DDMMYY') AS FM_MVMT_DT" ).append("\n"); 
		query.append(",TO_CHAR (C.TO_MVMT_DT, 'DDMMYY') AS TO_MVMT_DT" ).append("\n"); 
		query.append(",TO_CHAR (C.FT_CMNC_DT, 'DDMMYY') AS FT_CMNC_DT" ).append("\n"); 
		query.append(",TO_CHAR (C.FT_END_DT, 'DDMMYY') AS FT_END_DT" ).append("\n"); 
		query.append(",C.FT_DYS" ).append("\n"); 
		query.append(", R.FT_OVR_DYS" ).append("\n"); 
		query.append("|| ' - '" ).append("\n"); 
		query.append("|| R.FT_UND_DYS AS FT_OVR_UND_DYS" ).append("\n"); 
		query.append(",DECODE (SUBSTR (B.CNTR_TPSZ_CD" ).append("\n"); 
		query.append(",2" ).append("\n"); 
		query.append(",1" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append(",'2', R.CNTR_20FT_RT_AMT" ).append("\n"); 
		query.append(",'4', R.CNTR_40FT_RT_AMT" ).append("\n"); 
		query.append(",'5', R.CNTR_HC_RT_AMT" ).append("\n"); 
		query.append(",'7', R.CNTR_45FT_RT_AMT" ).append("\n"); 
		query.append(") AS RT_AMT" ).append("\n"); 
		query.append(",C.FX_FT_OVR_DYS" ).append("\n"); 
		query.append(", (DECODE (SUBSTR (B.CNTR_TPSZ_CD" ).append("\n"); 
		query.append(",2" ).append("\n"); 
		query.append(",1" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append(",'2', R.CNTR_20FT_RT_AMT" ).append("\n"); 
		query.append(",'4', R.CNTR_40FT_RT_AMT" ).append("\n"); 
		query.append(",'5', R.CNTR_HC_RT_AMT" ).append("\n"); 
		query.append(",'7', R.CNTR_45FT_RT_AMT" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("* C.FX_FT_OVR_DYS" ).append("\n"); 
		query.append(") AS RT_AMOUNT" ).append("\n"); 
		query.append(",C.BZC_TRF_CURR_CD" ).append("\n"); 
		query.append(",C.DMDT_TRF_APLY_TP_CD" ).append("\n"); 
		query.append("FROM DMT_CHG_BKG_CNTR B" ).append("\n"); 
		query.append(",DMT_CHG_CALC C" ).append("\n"); 
		query.append(",DMT_RFA_EXPT_RT R" ).append("\n"); 
		query.append("WHERE B.SYS_AREA_GRP_ID = C.SYS_AREA_GRP_ID" ).append("\n"); 
		query.append("AND B.CNTR_NO = C.CNTR_NO" ).append("\n"); 
		query.append("AND B.CNTR_CYC_NO = C.CNTR_CYC_NO" ).append("\n"); 
		query.append("AND C.DMDT_TRF_APLY_TP_CD = 'B'" ).append("\n"); 
		query.append("AND R.RFA_EXPT_DAR_NO = C.RFA_EXPT_DAR_NO" ).append("\n"); 
		query.append("AND R.RFA_EXPT_MAPG_SEQ = C.RFA_EXPT_MAPG_SEQ" ).append("\n"); 
		query.append("AND R.RFA_EXPT_VER_SEQ = C.RFA_EXPT_VER_SEQ" ).append("\n"); 
		query.append("AND R.RFA_RQST_DTL_SEQ = C.RFA_RQST_DTL_SEQ" ).append("\n"); 
		query.append("AND C.DMDT_TRF_CD = @[dmdt_trf_cd]" ).append("\n"); 
		query.append("AND B.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("## booking 호출 finish" ).append("\n"); 

	}
}