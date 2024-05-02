/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : DualTypeExceptionMgtDBDAOSearchDualTypeExceptionAppliedByRFARSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.01.28
*@LastModifier : 
*@LastVersion : 1.0
* 2010.01.28 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.dmt.dmtexceptionmgt.dualtypeexceptionmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class DualTypeExceptionMgtDBDAOSearchDualTypeExceptionAppliedByRFARSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Dual Type Exception 이 적용된 RFA 데이터를 조회하는 쿼리
	  * </pre>
	  */
	public DualTypeExceptionMgtDBDAOSearchDualTypeExceptionAppliedByRFARSQL(){
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
		params.put("exp_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("io_bnd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("loc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dmdt_cntr_cgo_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ste_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rgn_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.dmt.dmtexceptionmgt.dualtypeexceptionmgt.integration").append("\n"); 
		query.append("FileName : DualTypeExceptionMgtDBDAOSearchDualTypeExceptionAppliedByRFARSQL").append("\n"); 
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
		query.append("SELECT	DISTINCT RP_HDR.RFA_NO" ).append("\n"); 
		query.append(",	RFA_TRF.PROP_NO" ).append("\n"); 
		query.append(",	RFA_TRF.RFA_EXPT_DAR_NO DAR_NO" ).append("\n"); 
		query.append(",	LPAD(RFA_TRF.RFA_EXPT_VER_SEQ, 3, '0') VER" ).append("\n"); 
		query.append(",	RFA_TRF.RFA_EXPT_APRO_NO APVL_NO" ).append("\n"); 
		query.append(",	CD_DTL.INTG_CD_VAL_DP_DESC STATUS" ).append("\n"); 
		query.append(",	TO_CHAR(RFA_TRF_DTL.EFF_DT, 'YYYY-MM-DD') EFF_DT" ).append("\n"); 
		query.append(",	TO_CHAR(RFA_TRF_DTL.EXP_DT, 'YYYY-MM-DD') EXP_DT" ).append("\n"); 
		query.append(",	SUBSTR(RFA_TRF_DTL.DMDT_TRF_CD, 3, 1) IO_BND_CD" ).append("\n"); 
		query.append(",	RFA_CVRG.CVRG_CNT_CD CNT_CD" ).append("\n"); 
		query.append(",	CASE" ).append("\n"); 
		query.append("WHEN RFA_CVRG.CVRG_CNT_CD IN ('CA', 'US')" ).append("\n"); 
		query.append("THEN RFA_CVRG.CVRG_STE_CD" ).append("\n"); 
		query.append("ELSE RFA_CVRG.CVRG_RGN_CD" ).append("\n"); 
		query.append("END RGN_CD" ).append("\n"); 
		query.append(",	RFA_CVRG.CVRG_LOC_CD LOC_CD" ).append("\n"); 
		query.append(",	CASE" ).append("\n"); 
		query.append("WHEN RFA_TRF_DTL.DMDT_CNTR_TP_CD IS NOT NULL AND RFA_TRF_DTL.DMDT_CGO_TP_CD IS NOT NULL" ).append("\n"); 
		query.append("THEN RFA_TRF_DTL.DMDT_CNTR_TP_CD || ':' || RFA_TRF_DTL.DMDT_CGO_TP_CD" ).append("\n"); 
		query.append("ELSE ''" ).append("\n"); 
		query.append("END DMDT_CNTR_CGO_TP_CD" ).append("\n"); 
		query.append(",	(" ).append("\n"); 
		query.append("SELECT	DECODE(DMDT_CALC_TP_CD, 'D', 'Dual', 'C', 'Combined', '')" ).append("\n"); 
		query.append("FROM	DMT_CALC_TP" ).append("\n"); 
		query.append("WHERE	IO_BND_CD = SUBSTR(RFA_TRF_DTL.DMDT_TRF_CD, 3, 1)" ).append("\n"); 
		query.append("AND	EXP_DT IS NULL" ).append("\n"); 
		query.append("AND	(" ).append("\n"); 
		query.append("( CNT_CD = RFA_CVRG.CVRG_CNT_CD AND RGN_CD = NVL(RFA_CVRG.CVRG_RGN_CD, ' ') AND STE_CD = NVL(RFA_CVRG.CVRG_STE_CD, ' ') AND LOC_CD = NVL(RFA_CVRG.CVRG_LOC_CD, ' ')	)" ).append("\n"); 
		query.append("OR" ).append("\n"); 
		query.append("( CNT_CD = RFA_CVRG.CVRG_CNT_CD AND RGN_CD = NVL(RFA_CVRG.CVRG_RGN_CD, ' ') AND STE_CD = NVL(RFA_CVRG.CVRG_STE_CD, ' ')	)" ).append("\n"); 
		query.append("OR" ).append("\n"); 
		query.append("( CNT_CD = RFA_CVRG.CVRG_CNT_CD	)" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("AND ROWNUM = 1" ).append("\n"); 
		query.append(") LOC_TP" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("FROM    PRI_RP_MN RP_MN" ).append("\n"); 
		query.append(",   PRI_RP_HDR RP_HDR" ).append("\n"); 
		query.append(",   DMT_RFA_EXPT_TRF RFA_TRF" ).append("\n"); 
		query.append(",	DMT_RFA_EXPT_TRF_DTL RFA_TRF_DTL" ).append("\n"); 
		query.append(",	DMT_RFA_EXPT_CVRG_CMB RFA_CVRG" ).append("\n"); 
		query.append(",	COM_INTG_CD_DTL CD_DTL" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("WHERE   RP_MN.CTRT_CUST_CNT_CD = SUBSTR(@[cust_cd], 0, 2)" ).append("\n"); 
		query.append("AND RP_MN.CTRT_CUST_SEQ = SUBSTR(@[cust_cd], 3)" ).append("\n"); 
		query.append("AND RP_MN.AMDT_SEQ =" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT	/*+	INDEX_DESC(PRI_RP_MN XPKPRI_RP_MN)*/ AMDT_SEQ" ).append("\n"); 
		query.append("FROM	PRI_RP_MN" ).append("\n"); 
		query.append("WHERE	PROP_NO = RP_MN.PROP_NO" ).append("\n"); 
		query.append("AND	ROWNUM = 1" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("AND RP_MN.PROP_NO = RP_HDR.PROP_NO" ).append("\n"); 
		query.append("AND RP_HDR.PROP_NO = RFA_TRF.PROP_NO" ).append("\n"); 
		query.append("AND RFA_TRF.DMDT_EXPT_RQST_STS_CD IN ('A', 'O', 'R')" ).append("\n"); 
		query.append("AND RFA_TRF.RFA_EXPT_DAR_NO = RFA_TRF_DTL.RFA_EXPT_DAR_NO" ).append("\n"); 
		query.append("AND RFA_TRF.RFA_EXPT_MAPG_SEQ = RFA_TRF_DTL.RFA_EXPT_MAPG_SEQ" ).append("\n"); 
		query.append("AND RFA_TRF.RFA_EXPT_VER_SEQ = RFA_TRF_DTL.RFA_EXPT_VER_SEQ" ).append("\n"); 
		query.append("AND RFA_TRF_DTL.EFF_DT >= TO_DATE(@[eff_dt], 'YYYY-MM-DD')" ).append("\n"); 
		query.append("#if(${exp_dt} != '')" ).append("\n"); 
		query.append("AND RFA_TRF_DTL.EXP_DT <= TO_DATE(@[exp_dt], 'YYYY-MM-DD') + 0.999999" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${io_bnd_cd} != '')" ).append("\n"); 
		query.append("AND SUBSTR(RFA_TRF_DTL.DMDT_TRF_CD, 3, 1) = @[io_bnd_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${dmdt_cntr_cgo_tp_cd} != '')" ).append("\n"); 
		query.append("AND RFA_TRF_DTL.DMDT_CNTR_TP_CD = SUBSTR(@[dmdt_cntr_cgo_tp_cd], 0, 1)" ).append("\n"); 
		query.append("AND RFA_TRF_DTL.DMDT_CGO_TP_CD = SUBSTR(@[dmdt_cntr_cgo_tp_cd], 3)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("AND	RFA_TRF_DTL.DMDT_TRF_CD LIKE 'C%'" ).append("\n"); 
		query.append("AND RFA_TRF_DTL.RFA_EXPT_DAR_NO = RFA_CVRG.RFA_EXPT_DAR_NO" ).append("\n"); 
		query.append("AND RFA_TRF_DTL.RFA_EXPT_MAPG_SEQ = RFA_CVRG.RFA_EXPT_MAPG_SEQ" ).append("\n"); 
		query.append("AND RFA_TRF_DTL.RFA_EXPT_VER_SEQ = RFA_CVRG.RFA_EXPT_VER_SEQ" ).append("\n"); 
		query.append("AND	RFA_TRF_DTL.RFA_RQST_DTL_SEQ = RFA_CVRG.RFA_RQST_DTL_SEQ" ).append("\n"); 
		query.append("#if(${cnt_cd} != '')" ).append("\n"); 
		query.append("AND RFA_CVRG.CVRG_CNT_CD = @[cnt_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${rgn_cd} != '')" ).append("\n"); 
		query.append("AND RFA_CVRG.CVRG_RGN_CD = @[rgn_cd]" ).append("\n"); 
		query.append("AND RFA_CVRG.CVRG_STE_CD = ' '" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${ste_cd} != '')" ).append("\n"); 
		query.append("AND RFA_CVRG.CVRG_STE_CD = @[ste_cd]" ).append("\n"); 
		query.append("AND RFA_CVRG.CVRG_RGN_CD = ' '" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${loc_cd} != '')" ).append("\n"); 
		query.append("AND RFA_CVRG.CVRG_LOC_CD = @[loc_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("AND RFA_TRF.DMDT_EXPT_RQST_STS_CD = CD_DTL.INTG_CD_VAL_CTNT" ).append("\n"); 
		query.append("AND CD_DTL.INTG_CD_ID = 'CD02069'" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("ORDER BY RFA_NO, DAR_NO ASC, VER DESC, CNT_CD, RGN_CD, LOC_CD ASC" ).append("\n"); 

	}
}