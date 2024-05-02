/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : SCExceptionTariffMgtDBDAOCheckDualTypeCoverageRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.11.03
*@LastModifier : 
*@LastVersion : 1.0
* 2017.11.03 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.dmt.dmtexceptionmgt.scexceptiontariffmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SCExceptionTariffMgtDBDAOCheckDualTypeCoverageRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 선택한 Tariff Type 과 Coverage 에 맞는 Dual Type 이 존재하는지 조회하는 쿼리
	  * </pre>
	  */
	public SCExceptionTariffMgtDBDAOCheckDualTypeCoverageRSQL(){
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
		params.put("dmdt_ctrt_expt_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cust_seq",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("io_bnd_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("dmdt_cntr_cgo_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("prop_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.dmt.dmtexceptionmgt.scexceptiontariffmgt.integration").append("\n"); 
		query.append("FileName : SCExceptionTariffMgtDBDAOCheckDualTypeCoverageRSQL").append("\n"); 
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
		query.append("SELECT  COUNT(CUST_CNT_CD) AS CNT" ).append("\n"); 
		query.append("  FROM  DMT_DUL_TP_EXPT" ).append("\n"); 
		query.append(" WHERE  CUST_CNT_CD       = @[cust_cnt_cd]" ).append("\n"); 
		query.append("   AND  CUST_SEQ          = @[cust_seq]" ).append("\n"); 
		query.append("   AND  DUL_EXPT_DELT_FLG = 'N'" ).append("\n"); 
		query.append("   AND  (" ).append("\n"); 
		query.append("			(DUL_EXPT_EFF_DT >= TO_DATE(@[dul_expt_eff_dt], 'YYYYMMDD') AND DUL_EXPT_EFF_DT <= TO_DATE(NVL(@[dul_expt_exp_dt], '99991231'), 'YYYYMMDD'))" ).append("\n"); 
		query.append("			OR" ).append("\n"); 
		query.append("			(DUL_EXPT_EFF_DT <= TO_DATE(@[dul_expt_eff_dt], 'YYYYMMDD') AND NVL(DUL_EXPT_EXP_DT, TO_DATE('99991231', 'YYYYMMDD')) >= TO_DATE(@[dul_expt_eff_dt], 'YYYYMMDD'))" ).append("\n"); 
		query.append("		)" ).append("\n"); 
		query.append("   " ).append("\n"); 
		query.append("   #if(${dmdt_ctrt_expt_tp_cd} == 'B')" ).append("\n"); 
		query.append("   AND  NVL(DMDT_CNTR_TP_CD, SUBSTR(@[dmdt_cntr_cgo_tp_cd], 1, 1)) = SUBSTR(@[dmdt_cntr_cgo_tp_cd], 1, 1)" ).append("\n"); 
		query.append("   AND  NVL(DMDT_CGO_TP_CD,  SUBSTR(@[dmdt_cntr_cgo_tp_cd], 3))    = SUBSTR(@[dmdt_cntr_cgo_tp_cd], 3)" ).append("\n"); 
		query.append("   #else" ).append("\n"); 
		query.append("   AND  NVL(DMDT_CNTR_CGO_TP_CD, @[dmdt_cntr_cgo_tp_cd]) = @[dmdt_cntr_cgo_tp_cd]" ).append("\n"); 
		query.append("   #end" ).append("\n"); 
		query.append("   " ).append("\n"); 
		query.append("   AND  NVL(IO_BND_CD, @[io_bnd_cd]) = @[io_bnd_cd]" ).append("\n"); 
		query.append("   AND  DMDT_CTRT_EXPT_TP_CD         = NVL(@[dmdt_ctrt_expt_tp_cd], 'S')" ).append("\n"); 
		query.append("   AND  DECODE(CVRG_CNT_CD,     ' ', NVL(@[cvrg_cnt_cd],     ' '), CVRG_CNT_CD)     = NVL(@[cvrg_cnt_cd],     ' ')" ).append("\n"); 
		query.append("   AND  DECODE(CVRG_RGN_STE_CD, ' ', NVL(@[cvrg_rgn_ste_cd], ' '), CVRG_RGN_STE_CD) = NVL(@[cvrg_rgn_ste_cd], ' ')" ).append("\n"); 
		query.append("   AND  DECODE(CVRG_LOC_CD,     ' ', NVL(@[cvrg_loc_cd],     ' '), CVRG_LOC_CD)     = NVL(@[cvrg_loc_cd],     ' ')" ).append("\n"); 
		query.append("   AND  NVL(PROP_NO, @[prop_no])  = @[prop_no]	" ).append("\n"); 

	}
}