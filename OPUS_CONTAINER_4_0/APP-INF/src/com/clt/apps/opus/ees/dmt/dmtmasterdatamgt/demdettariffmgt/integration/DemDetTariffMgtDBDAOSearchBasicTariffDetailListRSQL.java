/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : DemDetTariffMgtDBDAOSearchBasicTariffDetailListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.12.16
*@LastModifier : 김태균
*@LastVersion : 1.0
* 2009.12.16 김태균
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.dmt.dmtmasterdatamgt.demdettariffmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Kim Tae Kyun
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class DemDetTariffMgtDBDAOSearchBasicTariffDetailListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 
	  * </pre>
	  */
	public DemDetTariffMgtDBDAOSearchBasicTariffDetailListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("org_dest_conti_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cvrg_rgn_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cvrg_loc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("org_dest_rgn_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cvrg_cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("org_dest_cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cvrg_yd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cvrg_conti_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("org_dest_loc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.dmt.dmtmasterdatamgt.demdettariffmgt.integration").append("\n"); 
		query.append("FileName : DemDetTariffMgtDBDAOSearchBasicTariffDetailListRSQL").append("\n"); 
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
		query.append("SELECT A.DMDT_TRF_CD" ).append("\n"); 
		query.append(",CASE WHEN TRIM(A.CVRG_YD_CD) IS NULL THEN" ).append("\n"); 
		query.append("(CASE WHEN TRIM(A.CVRG_LOC_CD) IS NULL THEN" ).append("\n"); 
		query.append("(CASE WHEN TRIM(A.CVRG_STE_CD) IS NULL THEN" ).append("\n"); 
		query.append("(CASE WHEN TRIM(A.CVRG_RGN_CD) IS NULL THEN A.CVRG_CNT_CD ELSE A.CVRG_RGN_CD END)" ).append("\n"); 
		query.append("ELSE A.CVRG_STE_CD" ).append("\n"); 
		query.append("END)" ).append("\n"); 
		query.append("ELSE A.CVRG_LOC_CD" ).append("\n"); 
		query.append("END)" ).append("\n"); 
		query.append("ELSE A.CVRG_YD_CD" ).append("\n"); 
		query.append("END COVRG" ).append("\n"); 
		query.append(",A.DMDT_TRF_CD" ).append("\n"); 
		query.append(",CASE WHEN TRIM(A.ORG_DEST_LOC_CD) IS NULL THEN" ).append("\n"); 
		query.append("(CASE WHEN TRIM(A.ORG_DEST_STE_CD) IS NULL THEN" ).append("\n"); 
		query.append("(CASE WHEN TRIM(A.ORG_DEST_RGN_CD) IS NULL THEN" ).append("\n"); 
		query.append("(CASE WHEN TRIM(A.ORG_DEST_CNT_CD) IS NULL THEN A.ORG_DEST_CONTI_CD ELSE A.ORG_DEST_CNT_CD END)" ).append("\n"); 
		query.append("ELSE A.ORG_DEST_RGN_CD" ).append("\n"); 
		query.append("END)" ).append("\n"); 
		query.append("ELSE A.ORG_DEST_STE_CD" ).append("\n"); 
		query.append("END)" ).append("\n"); 
		query.append("ELSE A.ORG_DEST_LOC_CD" ).append("\n"); 
		query.append("END ORG_DEST" ).append("\n"); 
		query.append(", B.TRF_GRP_SEQ" ).append("\n"); 
		query.append(", CASE WHEN B.DMDT_TRF_GRP_TP_CD = 'N' THEN 'Exempted'" ).append("\n"); 
		query.append("ELSE B.DMDT_BZC_TRF_GRP_NM END DMDT_BZC_TRF_GRP_NM" ).append("\n"); 
		query.append(",TO_CHAR(B.EFF_DT,'YYYY-MM-DD') AS EFF_DT" ).append("\n"); 
		query.append(",TO_CHAR(B.EXP_DT,'YYYY-MM-DD') AS EXP_DT" ).append("\n"); 
		query.append(",(SELECT INTG_CD_VAL_DESC FROM COM_INTG_CD_DTL WHERE INTG_CD_ID = 'CD01964' AND INTG_CD_VAL_CTNT = B.DMDT_CHG_CMNC_TP_CD ) AS DMDT_CHG_CMNC_TP_CD" ).append("\n"); 
		query.append(",F.INTG_CD_VAL_DP_DESC AS DMDT_CNTR_TP_CD" ).append("\n"); 
		query.append(",G.INTG_CD_VAL_DP_DESC AS DMDT_CGO_TP_CD" ).append("\n"); 
		query.append(",B.XCLD_SAT_FLG" ).append("\n"); 
		query.append(",B.XCLD_SUN_FLG" ).append("\n"); 
		query.append(",B.XCLD_HOL_FLG" ).append("\n"); 
		query.append(",D.FT_FM_QTY ||'-'|| DECODE(D.FT_TO_QTY,0,'',D.FT_TO_QTY ) AS FREE_TIME" ).append("\n"); 
		query.append(",D.FT_DYS" ).append("\n"); 
		query.append(",B.CURR_CD" ).append("\n"); 
		query.append(",E.FT_OVR_DYS ||'-'|| DECODE(E.FT_UND_DYS,0,'',E.FT_UND_DYS) AS OVER_DAY" ).append("\n"); 
		query.append(",E.CNTR_20FT_RT_AMT" ).append("\n"); 
		query.append(",E.CNTR_40FT_RT_AMT" ).append("\n"); 
		query.append(",E.CNTR_HC_RT_AMT" ).append("\n"); 
		query.append(",E.CNTR_45FT_RT_AMT" ).append("\n"); 
		query.append(",CASE WHEN TO_CHAR(EXP_DT,'YYYYMMDD') <= TO_CHAR(SYSDATE,'YYYYMMDD') THEN 'Y'" ).append("\n"); 
		query.append("ELSE 'N'" ).append("\n"); 
		query.append("END EXPIRE_CHK" ).append("\n"); 
		query.append(",CASE WHEN (SELECT WKND_TP_CD FROM DMT_WEEKEND WHERE CNT_CD = A.CVRG_CNT_CD) = 'TF' THEN 'THU'" ).append("\n"); 
		query.append("WHEN (SELECT WKND_TP_CD FROM DMT_WEEKEND WHERE CNT_CD = A.CVRG_CNT_CD) = 'FS' THEN 'FRI'" ).append("\n"); 
		query.append("ELSE 'SAT'" ).append("\n"); 
		query.append("END WKND1" ).append("\n"); 
		query.append(",CASE WHEN (SELECT WKND_TP_CD FROM DMT_WEEKEND WHERE CNT_CD = A.CVRG_CNT_CD) = 'TF' THEN 'FRI'" ).append("\n"); 
		query.append("WHEN (SELECT WKND_TP_CD FROM DMT_WEEKEND WHERE CNT_CD = A.CVRG_CNT_CD) = 'FS' THEN 'SAT'" ).append("\n"); 
		query.append("ELSE 'SUN'" ).append("\n"); 
		query.append("END WKND2" ).append("\n"); 
		query.append("FROM DMT_TRF_RGN A, DMT_TRF_GRP B, DMT_TRF_CMB C, DMT_TRF_FREE_TM D, DMT_TRF_RT E, COM_INTG_CD_DTL F, COM_INTG_CD_DTL G" ).append("\n"); 
		query.append("WHERE A.SYS_AREA_GRP_ID = B.SYS_AREA_GRP_ID" ).append("\n"); 
		query.append("AND A.DMDT_TRF_CD = B.DMDT_TRF_CD" ).append("\n"); 
		query.append("AND A.TRF_SEQ = B.TRF_SEQ" ).append("\n"); 
		query.append("AND B.SYS_AREA_GRP_ID = C.SYS_AREA_GRP_ID" ).append("\n"); 
		query.append("AND B.DMDT_TRF_CD = C.DMDT_TRF_CD" ).append("\n"); 
		query.append("AND B.TRF_SEQ = C.TRF_SEQ" ).append("\n"); 
		query.append("AND B.TRF_GRP_SEQ = C.TRF_GRP_SEQ" ).append("\n"); 
		query.append("AND B.SYS_AREA_GRP_ID = D.SYS_AREA_GRP_ID(+)" ).append("\n"); 
		query.append("AND B.DMDT_TRF_CD = D.DMDT_TRF_CD(+)" ).append("\n"); 
		query.append("AND B.TRF_SEQ = D.TRF_SEQ(+)" ).append("\n"); 
		query.append("AND B.TRF_GRP_SEQ = D.TRF_GRP_SEQ(+)" ).append("\n"); 
		query.append("AND B.SYS_AREA_GRP_ID = E.SYS_AREA_GRP_ID(+)" ).append("\n"); 
		query.append("AND B.DMDT_TRF_CD = E.DMDT_TRF_CD(+)" ).append("\n"); 
		query.append("AND B.TRF_SEQ = E.TRF_SEQ(+)" ).append("\n"); 
		query.append("AND B.TRF_GRP_SEQ = E.TRF_GRP_SEQ(+)" ).append("\n"); 
		query.append("AND F.INTG_CD_VAL_CTNT = C.DMDT_CNTR_TP_CD" ).append("\n"); 
		query.append("AND G.INTG_CD_VAL_CTNT = C.DMDT_CGO_TP_CD" ).append("\n"); 
		query.append("AND F.INTG_CD_ID = 'CD02053'" ).append("\n"); 
		query.append("AND G.INTG_CD_ID = 'CD01963'" ).append("\n"); 
		query.append("AND B.CFM_FLG = 'Y'" ).append("\n"); 
		query.append("#if (${ui_code} == '1004')" ).append("\n"); 
		query.append("AND A.SUTH_CHN_USE_FLG = 'N'" ).append("\n"); 
		query.append("#elseif (${ui_code} == '4015')" ).append("\n"); 
		query.append("AND A.SUTH_CHN_USE_FLG = 'Y'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${cvrg_conti_cd} != '')" ).append("\n"); 
		query.append("AND A.CVRG_CONTI_CD = @[cvrg_conti_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${cvrg_cnt_cd} != '')" ).append("\n"); 
		query.append("AND A.CVRG_CNT_CD = @[cvrg_cnt_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${cvrg_cnt_cd} == 'US' || ${cvrg_cnt_cd} == 'CA')" ).append("\n"); 
		query.append("#if (${cvrg_rgn_cd} != '')" ).append("\n"); 
		query.append("AND A.CVRG_STE_CD = @[cvrg_rgn_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("#if (${cvrg_rgn_cd} != '')" ).append("\n"); 
		query.append("AND A.CVRG_RGN_CD = @[cvrg_rgn_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${cvrg_loc_cd} != '')" ).append("\n"); 
		query.append("AND A.CVRG_LOC_CD = @[cvrg_loc_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${cvrg_yd_cd} != '')" ).append("\n"); 
		query.append("AND A.CVRG_YD_CD = @[cvrg_yd_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${org_dest_conti_cd} != '')" ).append("\n"); 
		query.append("AND A.ORG_DEST_CONTI_CD = @[org_dest_conti_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${org_dest_cnt_cd} != '')" ).append("\n"); 
		query.append("AND A.ORG_DEST_CNT_CD = @[org_dest_cnt_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${org_dest_cnt_cd} == 'US' || ${org_dest_cnt_cd} == 'CA')" ).append("\n"); 
		query.append("#if (${org_dest_rgn_cd} != '')" ).append("\n"); 
		query.append("AND A.ORG_DEST_STE_CD = @[org_dest_rgn_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("#if (${org_dest_rgn_cd} != '')" ).append("\n"); 
		query.append("AND A.ORG_DEST_RGN_CD = @[org_dest_rgn_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${org_dest_loc_cd} != '')" ).append("\n"); 
		query.append("AND A.ORG_DEST_LOC_CD = @[org_dest_loc_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${dmdt_trf_cd_in} == 'Y')" ).append("\n"); 
		query.append("AND A.DMDT_TRF_CD IN (" ).append("\n"); 
		query.append("#foreach( $dmdt_trf_cd in ${dmdt_trf_cd_list})" ).append("\n"); 
		query.append("#if($velocityCount < $dmdt_trf_cd_list.size())" ).append("\n"); 
		query.append("'$dmdt_trf_cd'," ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("'$dmdt_trf_cd'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${dmdt_cntr_tp_cd_in} == 'Y')" ).append("\n"); 
		query.append("AND C.DMDT_CNTR_TP_CD IN (" ).append("\n"); 
		query.append("#foreach( $dmdt_cntr_tp_cd in ${dmdt_cntr_tp_list})" ).append("\n"); 
		query.append("#if($velocityCount < $dmdt_cntr_tp_list.size())" ).append("\n"); 
		query.append("'$dmdt_cntr_tp_cd'," ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("'$dmdt_cntr_tp_cd'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${dmdt_cgo_tp_cd_in} == 'Y')" ).append("\n"); 
		query.append("AND C.DMDT_CGO_TP_CD IN (" ).append("\n"); 
		query.append("#foreach( $dmdt_cgo_tp_cd in ${dmdt_cgo_tp_list})" ).append("\n"); 
		query.append("#if($velocityCount < $dmdt_cgo_tp_list.size())" ).append("\n"); 
		query.append("'$dmdt_cgo_tp_cd'," ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("'$dmdt_cgo_tp_cd'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${validity1} != '')" ).append("\n"); 
		query.append("AND ( TO_CHAR(EFF_DT,'YYYYMMDD') <= TO_CHAR(SYSDATE,'YYYYMMDD')" ).append("\n"); 
		query.append("AND NVL(TO_CHAR(EXP_DT,'YYYYMMDD'),'99991231') >= TO_CHAR(SYSDATE,'YYYYMMDD')" ).append("\n"); 
		query.append("#if (${validity2} != '')" ).append("\n"); 
		query.append("OR (TO_CHAR(EFF_DT,'YYYYMMDD') > TO_CHAR(SYSDATE,'YYYYMMDD')" ).append("\n"); 
		query.append("AND NVL(TO_CHAR(EXP_DT,'YYYYMMDD'),'99991231') >= TO_CHAR(SYSDATE,'YYYYMMDD'))" ).append("\n"); 
		query.append("#if (${validity3} != '')" ).append("\n"); 
		query.append("OR (TO_CHAR(EXP_DT,'YYYYMMDD') <= TO_CHAR(SYSDATE,'YYYYMMDD'))" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("#if (${validity3} != '')" ).append("\n"); 
		query.append("OR (TO_CHAR(EXP_DT,'YYYYMMDD') <= TO_CHAR(SYSDATE,'YYYYMMDD'))" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("AND (" ).append("\n"); 
		query.append("#if (${validity2} != '')" ).append("\n"); 
		query.append("TO_CHAR(EFF_DT,'YYYYMMDD') > TO_CHAR(SYSDATE,'YYYYMMDD')" ).append("\n"); 
		query.append("AND NVL(TO_CHAR(EXP_DT,'YYYYMMDD'),'99991231') >= TO_CHAR(SYSDATE,'YYYYMMDD')" ).append("\n"); 
		query.append("#if (${validity3} != '')" ).append("\n"); 
		query.append("OR (TO_CHAR(EXP_DT,'YYYYMMDD') <= TO_CHAR(SYSDATE,'YYYYMMDD'))" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("TO_CHAR(EXP_DT,'YYYYMMDD') <= TO_CHAR(SYSDATE,'YYYYMMDD')" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("ORDER BY A.DMDT_TRF_CD, LENGTH(COVRG),COVRG, LENGTH(ORG_DEST), ORG_DEST, B.EFF_DT, B.EXP_DT, F.INTG_CD_VAL_DP_SEQ, G.INTG_CD_VAL_DP_SEQ" ).append("\n"); 

	}
}