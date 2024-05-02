/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : DualTypeExceptionMgtDBDAOSearchDualTypeExceptionAppliedBySCRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.12.29
*@LastModifier : 
*@LastVersion : 1.0
* 2015.12.29 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.dmt.dmtexceptionmgt.dualtypeexceptionmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class DualTypeExceptionMgtDBDAOSearchDualTypeExceptionAppliedBySCRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Dual Type Exception 이 적용된 S/C 데이터를 조회하는 쿼리
	  * </pre>
	  */
	public DualTypeExceptionMgtDBDAOSearchDualTypeExceptionAppliedBySCRSQL(){
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
		params.put("prop_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rgn_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.dmt.dmtexceptionmgt.dualtypeexceptionmgt.integration").append("\n"); 
		query.append("FileName : DualTypeExceptionMgtDBDAOSearchDualTypeExceptionAppliedBySCRSQL").append("\n"); 
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
		query.append("SELECT	DISTINCT SP_HDR.SC_NO" ).append("\n"); 
		query.append("	,	LPAD(SC_VER.SC_EXPT_VER_SEQ, 3, '0') VER" ).append("\n"); 
		query.append("	,	SC_VER.PROP_NO" ).append("\n"); 
		query.append("	,	CD_DTL.INTG_CD_VAL_DP_DESC STATUS" ).append("\n"); 
		query.append("	,	TO_CHAR(SC_GRP.EFF_DT, 'YYYY-MM-DD') EFF_DT" ).append("\n"); 
		query.append("	,	TO_CHAR(SC_GRP.EXP_DT, 'YYYY-MM-DD') EXP_DT" ).append("\n"); 
		query.append("	,	SUBSTR(SC_GRP.DMDT_TRF_CD, 3, 1) IO_BND_CD" ).append("\n"); 
		query.append("	,	SC_CVRG.CNT_CD" ).append("\n"); 
		query.append("	,	CASE " ).append("\n"); 
		query.append("			WHEN SC_CVRG.CNT_CD IN ('CA', 'US') THEN SC_CVRG.STE_CD ELSE SC_CVRG.RGN_CD" ).append("\n"); 
		query.append("		END RGN_CD" ).append("\n"); 
		query.append("	,	SC_CVRG.LOC_CD" ).append("\n"); 
		query.append("	,	SC_GRP.DMDT_CNTR_CGO_TP_CD" ).append("\n"); 
		query.append("	,	(" ).append("\n"); 
		query.append("			SELECT	DECODE(DMDT_CALC_TP_CD, 'D', 'Dual', 'C', 'Combined', '')" ).append("\n"); 
		query.append("			FROM	DMT_CALC_TP" ).append("\n"); 
		query.append("			WHERE	IO_BND_CD = SUBSTR(SC_GRP.DMDT_TRF_CD, 3, 1)" ).append("\n"); 
		query.append("				AND	EXP_DT IS NULL" ).append("\n"); 
		query.append("				AND	(" ).append("\n"); 
		query.append("				        ( CNT_CD = SC_CVRG.CNT_CD AND RGN_CD = NVL(SC_CVRG.RGN_CD, ' ') AND STE_CD = NVL(SC_CVRG.STE_CD, ' ') AND LOC_CD = NVL(SC_CVRG.LOC_CD, ' ')	)" ).append("\n"); 
		query.append("				        OR" ).append("\n"); 
		query.append("				        ( CNT_CD = SC_CVRG.CNT_CD AND RGN_CD = NVL(SC_CVRG.RGN_CD, ' ') AND STE_CD = NVL(SC_CVRG.STE_CD, ' ')	)" ).append("\n"); 
		query.append("				        OR" ).append("\n"); 
		query.append("				        ( CNT_CD = SC_CVRG.CNT_CD	)" ).append("\n"); 
		query.append("					)" ).append("\n"); 
		query.append("				AND ROWNUM = 1" ).append("\n"); 
		query.append("		) LOC_TP" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("FROM	PRI_SP_CTRT_PTY SP_PTY" ).append("\n"); 
		query.append("	,	PRI_SP_HDR SP_HDR" ).append("\n"); 
		query.append("    ,   DMT_SC_EXPT_VER SC_VER" ).append("\n"); 
		query.append("    ,   DMT_SC_EXPT_GRP SC_GRP" ).append("\n"); 
		query.append("    ,   DMT_SC_EXPT_CVRG SC_CVRG" ).append("\n"); 
		query.append("	,	COM_INTG_CD_DTL CD_DTL" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("WHERE	SP_PTY.CUST_CNT_CD = SUBSTR(@[cust_cd], 0, 2)" ).append("\n"); 
		query.append("    AND SP_PTY.CUST_SEQ = SUBSTR(@[cust_cd], 3)" ).append("\n"); 
		query.append("	AND SP_PTY.AMDT_SEQ = " ).append("\n"); 
		query.append("    	(" ).append("\n"); 
		query.append("        	SELECT  /*+ INDEX_DESC(PRI_SP_CTRT_PTY XPKPRI_SP_CTRT_PTY)*/ AMDT_SEQ" ).append("\n"); 
		query.append("        	FROM    PRI_SP_CTRT_PTY" ).append("\n"); 
		query.append("			WHERE   PROP_NO = SP_PTY.PROP_NO" ).append("\n"); 
		query.append("				AND PRC_CTRT_PTY_TP_CD = 'C'" ).append("\n"); 
		query.append("            	AND ROWNUM = 1" ).append("\n"); 
		query.append("    	)" ).append("\n"); 
		query.append("	AND SP_PTY.PRC_CTRT_PTY_TP_CD = 'C'" ).append("\n"); 
		query.append("    AND SP_PTY.PROP_NO = SP_HDR.PROP_NO" ).append("\n"); 
		query.append("	AND SP_HDR.PROP_NO = SC_VER.PROP_NO" ).append("\n"); 
		query.append("    AND SC_VER.DMDT_EXPT_VER_STS_CD IN ('A', 'L', 'R')" ).append("\n"); 
		query.append("    AND SC_VER.DELT_FLG = 'N'" ).append("\n"); 
		query.append("    AND SC_VER.PROP_NO = SC_GRP.PROP_NO" ).append("\n"); 
		query.append("    AND SC_VER.SC_EXPT_VER_SEQ = SC_GRP.SC_EXPT_VER_SEQ" ).append("\n"); 
		query.append("    AND SC_GRP.EFF_DT >= TO_DATE(@[eff_dt], 'YYYY-MM-DD')" ).append("\n"); 
		query.append("#if(${exp_dt} != '')" ).append("\n"); 
		query.append("	AND SC_GRP.EXP_DT <= TO_DATE(@[exp_dt], 'YYYY-MM-DD') + 0.999999" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${io_bnd_cd} != '')" ).append("\n"); 
		query.append("	AND SUBSTR(SC_GRP.DMDT_TRF_CD, 3, 1) = @[io_bnd_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${dmdt_cntr_cgo_tp_cd} != '')" ).append("\n"); 
		query.append("	AND SC_GRP.DMDT_CNTR_CGO_TP_CD = @[dmdt_cntr_cgo_tp_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("	AND	SC_GRP.DMDT_TRF_CD LIKE 'C%'" ).append("\n"); 
		query.append("	AND SC_GRP.PROP_NO = SC_CVRG.PROP_NO" ).append("\n"); 
		query.append("	AND SC_GRP.SC_EXPT_VER_SEQ = SC_CVRG.SC_EXPT_VER_SEQ" ).append("\n"); 
		query.append("	AND SC_GRP.SC_EXPT_GRP_SEQ = SC_CVRG.SC_EXPT_GRP_SEQ" ).append("\n"); 
		query.append("#if(${cnt_cd} != '')" ).append("\n"); 
		query.append("	AND SC_CVRG.CNT_CD = @[cnt_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${rgn_cd} != '')" ).append("\n"); 
		query.append("	AND SC_CVRG.RGN_CD = @[rgn_cd]" ).append("\n"); 
		query.append("	AND SC_CVRG.STE_CD = ' '" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${ste_cd} != '')" ).append("\n"); 
		query.append("	AND SC_CVRG.STE_CD = @[ste_cd]" ).append("\n"); 
		query.append("	AND SC_CVRG.RGN_CD = ' '" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${loc_cd} != '')" ).append("\n"); 
		query.append("	AND SC_CVRG.LOC_CD = @[loc_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${prop_no} != '')" ).append("\n"); 
		query.append("	AND SC_GRP.PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("	AND SC_VER.DMDT_EXPT_VER_STS_CD = CD_DTL.INTG_CD_VAL_CTNT" ).append("\n"); 
		query.append("	AND CD_DTL.INTG_CD_ID = 'CD01972'" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("ORDER BY SC_NO ASC, VER DESC, CNT_CD, RGN_CD, LOC_CD ASC" ).append("\n"); 

	}
}