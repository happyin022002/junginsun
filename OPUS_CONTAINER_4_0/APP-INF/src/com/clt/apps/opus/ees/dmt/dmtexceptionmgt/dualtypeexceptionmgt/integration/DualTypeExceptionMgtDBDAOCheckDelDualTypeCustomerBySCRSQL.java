/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : DualTypeExceptionMgtDBDAOCheckDelDualTypeCustomerBySCRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.29
*@LastModifier : 
*@LastVersion : 1.0
* 2009.11.29 
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

public class DualTypeExceptionMgtDBDAOCheckDelDualTypeCustomerBySCRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Customer 의 'Requested', 'Accepted', 'Live' 인 S/C Exception Tariff 가 있는지 확인하는 쿼리
	  * </pre>
	  */
	public DualTypeExceptionMgtDBDAOCheckDelDualTypeCustomerBySCRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dul_expt_eff_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cvrg_ste_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("dul_expt_exp_dt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cvrg_cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.dmt.dmtexceptionmgt.dualtypeexceptionmgt.integration").append("\n"); 
		query.append("FileName : DualTypeExceptionMgtDBDAOCheckDelDualTypeCustomerBySCRSQL").append("\n"); 
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
		query.append("SELECT  SP_HDR.PROP_NO" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("FROM    PRI_SP_CTRT_PTY SP_PTY" ).append("\n"); 
		query.append(",	PRI_SP_HDR SP_HDR" ).append("\n"); 
		query.append(", 	DMT_SC_EXPT_VER SC_VER" ).append("\n"); 
		query.append(",	DMT_SC_EXPT_GRP SC_GRP" ).append("\n"); 
		query.append(",	DMT_SC_EXPT_CVRG SC_CVRG" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("WHERE   SP_PTY.CUST_CNT_CD = @[cust_cnt_cd]" ).append("\n"); 
		query.append("AND SP_PTY.CUST_SEQ = TO_NUMBER(@[cust_seq])" ).append("\n"); 
		query.append("AND SP_PTY.AMDT_SEQ =" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT  /*+ INDEX_DESC(PRI_SP_CTRT_PTY XPKPRI_SP_CTRT_PTY)*/ AMDT_SEQ" ).append("\n"); 
		query.append("FROM    PRI_SP_CTRT_PTY" ).append("\n"); 
		query.append("WHERE   PROP_NO = SP_PTY.PROP_NO" ).append("\n"); 
		query.append("AND PRC_CTRT_PTY_TP_CD = 'C'" ).append("\n"); 
		query.append("AND ROWNUM = 1" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("AND SP_PTY.PRC_CTRT_PTY_TP_CD = 'C'" ).append("\n"); 
		query.append("AND SP_PTY.PROP_NO = SP_HDR.PROP_NO" ).append("\n"); 
		query.append("AND SP_HDR.PROP_NO = SC_VER.PROP_NO" ).append("\n"); 
		query.append("AND SC_VER.DMDT_EXPT_VER_STS_CD IN ('A', 'L', 'R')" ).append("\n"); 
		query.append("AND SC_VER.DELT_FLG = 'N'" ).append("\n"); 
		query.append("AND SC_VER.PROP_NO = SC_GRP.PROP_NO" ).append("\n"); 
		query.append("AND SC_VER.SC_EXPT_VER_SEQ = SC_GRP.SC_EXPT_VER_SEQ" ).append("\n"); 
		query.append("AND (" ).append("\n"); 
		query.append("(SC_GRP.EFF_DT >= TO_DATE(@[dul_expt_eff_dt], 'YYYYMMDD') AND SC_GRP.EFF_DT <= TO_DATE(NVL(@[dul_expt_exp_dt], '99991231'), 'YYYYMMDD'))" ).append("\n"); 
		query.append("OR" ).append("\n"); 
		query.append("(SC_GRP.EFF_DT <= TO_DATE(@[dul_expt_eff_dt], 'YYYYMMDD') AND SC_GRP.EXP_DT >= TO_DATE(@[dul_expt_eff_dt], 'YYYYMMDD'))" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("AND SC_GRP.DMDT_TRF_CD IN ('CTIC', 'CTOC')" ).append("\n"); 
		query.append("AND SC_GRP.PROP_NO = SC_CVRG.PROP_NO" ).append("\n"); 
		query.append("AND SC_GRP.SC_EXPT_VER_SEQ = SC_CVRG.SC_EXPT_VER_SEQ" ).append("\n"); 
		query.append("AND SC_GRP.SC_EXPT_GRP_SEQ = SC_CVRG.SC_EXPT_GRP_SEQ" ).append("\n"); 
		query.append("#if(${cvrg_cnt_cd} != '')" ).append("\n"); 
		query.append("AND	(	SC_CVRG.CNT_CD = @[cvrg_cnt_cd]" ).append("\n"); 
		query.append("#if(${cvrg_rgn_cd} != '')" ).append("\n"); 
		query.append("AND SC_CVRG.RGN_CD = @[cvrg_rgn_cd]" ).append("\n"); 
		query.append("AND SC_CVRG.STE_CD = ' '" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if(${cvrg_ste_cd} != '')" ).append("\n"); 
		query.append("AND SC_CVRG.RGN_CD = ' '" ).append("\n"); 
		query.append("AND SC_CVRG.STE_CD = @[cvrg_ste_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if(${cvrg_loc_cd} != '')" ).append("\n"); 
		query.append("AND SC_CVRG.LOC_CD = @[cvrg_loc_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}