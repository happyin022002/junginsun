/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : DualTypeExceptionMgtDBDAOCheckDuplicateDualTypeExceptionRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.12.08
*@LastModifier : 
*@LastVersion : 1.0
* 2009.12.08 
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

public class DualTypeExceptionMgtDBDAOCheckDuplicateDualTypeExceptionRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 입력한 Dual Type Exception 의 중복여부를 체크하기 위한 조회용 쿼리
	  * </pre>
	  */
	public DualTypeExceptionMgtDBDAOCheckDuplicateDualTypeExceptionRSQL(){
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
		params.put("io_bnd_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cvrg_rgn_ste_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dmdt_ctrt_expt_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.dmt.dmtexceptionmgt.dualtypeexceptionmgt.integration").append("\n"); 
		query.append("FileName : DualTypeExceptionMgtDBDAOCheckDuplicateDualTypeExceptionRSQL").append("\n"); 
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
		query.append("SELECT	TO_CHAR(DUL_EXPT_EFF_DT, 'YYYY-MM-DD') DUL_EXPT_EFF_DT" ).append("\n"); 
		query.append(",	TO_CHAR(NVL(DUL_EXPT_EXP_DT, ''), 'YYYY-MM-DD') DUL_EXPT_EXP_DT" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("FROM	DMT_DUL_TP_EXPT" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("WHERE	CUST_CNT_CD = SUBSTR(@[cust_cd], 1, 2)" ).append("\n"); 
		query.append("AND	CUST_SEQ = SUBSTR(@[cust_cd], 3)" ).append("\n"); 
		query.append("AND DUL_EXPT_DELT_FLG = 'N'" ).append("\n"); 
		query.append("AND (" ).append("\n"); 
		query.append("(DUL_EXPT_EFF_DT >= TO_DATE(@[dul_expt_eff_dt], 'YYYYMMDD') AND DUL_EXPT_EFF_DT <= TO_DATE(NVL(@[dul_expt_exp_dt], '99991231'), 'YYYYMMDD'))" ).append("\n"); 
		query.append("OR" ).append("\n"); 
		query.append("(DUL_EXPT_EFF_DT <= TO_DATE(@[dul_expt_eff_dt], 'YYYYMMDD') AND NVL(DUL_EXPT_EXP_DT, TO_DATE('99991231', 'YYYYMMDD')) >= TO_DATE(@[dul_expt_eff_dt], 'YYYYMMDD'))" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("AND IO_BND_CD = @[io_bnd_cd]" ).append("\n"); 
		query.append("AND DMDT_CTRT_EXPT_TP_CD = @[dmdt_ctrt_expt_tp_cd]" ).append("\n"); 
		query.append("AND CVRG_CNT_CD = NVL(@[cvrg_cnt_cd], ' ')" ).append("\n"); 
		query.append("AND CVRG_RGN_STE_CD = NVL(@[cvrg_rgn_ste_cd], ' ')" ).append("\n"); 
		query.append("AND CVRG_LOC_CD = NVL(@[cvrg_loc_cd], ' ')" ).append("\n"); 
		query.append("#if(${dmdt_ctrt_expt_tp_cd} == 'S')" ).append("\n"); 
		query.append("#if(${dmdt_cntr_cgo_tp_cd} != '')" ).append("\n"); 
		query.append("AND DMDT_CNTR_CGO_TP_CD = @[dmdt_cntr_cgo_tp_cd]" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("AND DMDT_CNTR_CGO_TP_CD IS NULL" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#elseif(${dmdt_ctrt_expt_tp_cd} == 'B')" ).append("\n"); 
		query.append("#if(${dmdt_cntr_cgo_tp_cd} != '')" ).append("\n"); 
		query.append("AND	DMDT_CNTR_TP_CD = SUBSTR(@[dmdt_cntr_cgo_tp_cd], 0, 1)" ).append("\n"); 
		query.append("AND	DMDT_CGO_TP_CD = SUBSTR(@[dmdt_cntr_cgo_tp_cd], 3)" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("AND	DMDT_CNTR_TP_CD IS NULL" ).append("\n"); 
		query.append("AND	DMDT_CGO_TP_CD IS NULL" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}