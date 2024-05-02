/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : GeneralInvoiceAuditDBDAOaddPsoChargeDetailCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.03.05
*@LastModifier : 
*@LastVersion : 1.0
* 2015.03.05 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.pso.estimateinvoiceaudit.generalinvoiceaudit.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class GeneralInvoiceAuditDBDAOaddPsoChargeDetailCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Invoice creation시 PSO_CHG_DTL 정보를 저장합니다.
	  * 
	  * ===================================
	  * History
	  * * 2012.11.26 진마리아 CHM-201220618-01 TPB 비용 정보 지정시 해당 정보를 TPB IF용 테이블에 저장하고 제어함
	  * </pre>
	  */
	public GeneralInvoiceAuditDBDAOaddPsoChargeDetailCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("org_so_dtl_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("xpr_desc",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inv_cond_desc",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.FLOAT + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("adj_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("skd_dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cost_calc_eff_fm_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cost_calc_eff_to_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_dt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("foml_desc",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("upd_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.FLOAT + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("usd_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("n3pty_bil_if_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("diff_rmk",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.NUMERIC + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("so_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dp_io_bnd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("lgs_cost_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rlane_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.NUMERIC + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("yd_chg_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mnl_inp_xch_rt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.FLOAT + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("calc_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ar_yrmon",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("iss_cty_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.FLOAT + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("locl_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.NUMERIC + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("yd_chg_ver_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rev_dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("upd_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("skd_voy_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.vop.pso.estimateinvoiceaudit.generalinvoiceaudit.integration").append("\n"); 
		query.append("FileName : GeneralInvoiceAuditDBDAOaddPsoChargeDetailCSQL").append("\n"); 
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
		query.append("INSERT INTO PSO_CHG_DTL (" ).append("\n"); 
		query.append("	DP_IO_BND_CD" ).append("\n"); 
		query.append(",	ORG_SO_DTL_SEQ" ).append("\n"); 
		query.append(",	INV_COND_DESC" ).append("\n"); 
		query.append(",	ISS_CTY_CD" ).append("\n"); 
		query.append(",	SO_SEQ" ).append("\n"); 
		query.append(",	SO_DTL_SEQ" ).append("\n"); 
		query.append(",	VSL_CD" ).append("\n"); 
		query.append(",	SKD_VOY_NO" ).append("\n"); 
		query.append(",	SKD_DIR_CD" ).append("\n"); 
		query.append(",	REV_DIR_CD" ).append("\n"); 
		query.append(",	RLANE_CD" ).append("\n"); 
		query.append(",	LGS_COST_CD" ).append("\n"); 
		query.append(",	IO_BND_CD" ).append("\n"); 
		query.append(",	LOCL_AMT" ).append("\n"); 
		query.append(",	USD_AMT" ).append("\n"); 
		query.append(",	CALC_AMT" ).append("\n"); 
		query.append(",	ADJ_AMT" ).append("\n"); 
		query.append(",	XPR_DESC" ).append("\n"); 
		query.append(",	FOML_DESC" ).append("\n"); 
		query.append(",	YD_CHG_VER_SEQ" ).append("\n"); 
		query.append(",	YD_CHG_NO" ).append("\n"); 
		query.append(",	DIFF_RMK" ).append("\n"); 
		query.append(",	AR_YRMON" ).append("\n"); 
		query.append(",	CRE_USR_ID" ).append("\n"); 
		query.append(",	CRE_DT" ).append("\n"); 
		query.append(",	UPD_USR_ID" ).append("\n"); 
		query.append(",	UPD_DT" ).append("\n"); 
		query.append(",	N3PTY_BIL_IF_FLG" ).append("\n"); 
		query.append(",	MNL_INP_XCH_RT" ).append("\n"); 
		query.append(",   COST_CALC_EFF_FM_DT" ).append("\n"); 
		query.append(",   COST_CALC_EFF_TO_DT" ).append("\n"); 
		query.append(") VALUES( " ).append("\n"); 
		query.append("	@[dp_io_bnd_cd]" ).append("\n"); 
		query.append(",	DECODE(@[org_so_dtl_seq], '-999', (SELECT /*+INDEX_DESC(T1 XPKPSO_CHG_DTL)*/" ).append("\n"); 
		query.append("	SO_DTL_SEQ FROM PSO_CHG_DTL T1" ).append("\n"); 
		query.append("	WHERE T1.ISS_CTY_CD = @[iss_cty_cd]" ).append("\n"); 
		query.append("	AND T1.SO_SEQ = NVL(@[so_seq], (SELECT /*+INDEX_DESC(T1 XPKPSO_CHARGE)*/" ).append("\n"); 
		query.append("	SO_SEQ FROM PSO_CHARGE T1" ).append("\n"); 
		query.append("	WHERE T1.ISS_CTY_CD = @[iss_cty_cd]" ).append("\n"); 
		query.append("	AND T1.SO_SEQ >= 0 " ).append("\n"); 
		query.append("	AND ROWNUM<=1))" ).append("\n"); 
		query.append("	AND T1.SO_DTL_SEQ >= 0 " ).append("\n"); 
		query.append("	AND ROWNUM<=1),	(nvl((SELECT /*+INDEX_DESC(T1 XPKPSO_CHG_DTL)*/" ).append("\n"); 
		query.append("	SO_DTL_SEQ FROM PSO_CHG_DTL T1" ).append("\n"); 
		query.append("	WHERE T1.ISS_CTY_CD = @[iss_cty_cd]" ).append("\n"); 
		query.append("	AND T1.SO_SEQ = NVL(@[so_seq], (SELECT /*+INDEX_DESC(T1 XPKPSO_CHARGE)*/" ).append("\n"); 
		query.append("	SO_SEQ FROM PSO_CHARGE T1" ).append("\n"); 
		query.append("	WHERE T1.ISS_CTY_CD = @[iss_cty_cd]" ).append("\n"); 
		query.append("	AND T1.SO_SEQ >= 0 " ).append("\n"); 
		query.append("	AND ROWNUM<=1))" ).append("\n"); 
		query.append("	AND T1.SO_DTL_SEQ >= 0 " ).append("\n"); 
		query.append("	AND ROWNUM<=1),0)+1))" ).append("\n"); 
		query.append(",	@[inv_cond_desc]" ).append("\n"); 
		query.append(",	@[iss_cty_cd]" ).append("\n"); 
		query.append(",	DECODE(@[so_seq], null, (SELECT /*+INDEX_DESC(T1 XPKPSO_CHARGE)*/" ).append("\n"); 
		query.append("	SO_SEQ FROM PSO_CHARGE T1" ).append("\n"); 
		query.append("	WHERE T1.ISS_CTY_CD = @[iss_cty_cd]" ).append("\n"); 
		query.append("	AND T1.SO_SEQ >= 0 " ).append("\n"); 
		query.append("	AND ROWNUM<=1), @[so_seq])" ).append("\n"); 
		query.append(",	nvl((SELECT /*+INDEX_DESC(T1 XPKPSO_CHG_DTL)*/" ).append("\n"); 
		query.append("	SO_DTL_SEQ FROM PSO_CHG_DTL T1" ).append("\n"); 
		query.append("	WHERE T1.ISS_CTY_CD = @[iss_cty_cd]" ).append("\n"); 
		query.append("	AND T1.SO_SEQ = NVL(@[so_seq], (SELECT /*+INDEX_DESC(T1 XPKPSO_CHARGE)*/" ).append("\n"); 
		query.append("	SO_SEQ FROM PSO_CHARGE T1" ).append("\n"); 
		query.append("	WHERE T1.ISS_CTY_CD = @[iss_cty_cd]" ).append("\n"); 
		query.append("	AND T1.SO_SEQ >= 0 " ).append("\n"); 
		query.append("	AND ROWNUM<=1))" ).append("\n"); 
		query.append("	AND T1.SO_DTL_SEQ >= 0 " ).append("\n"); 
		query.append("	AND ROWNUM<=1),0)+1" ).append("\n"); 
		query.append(",	@[vsl_cd]" ).append("\n"); 
		query.append(",	@[skd_voy_no]" ).append("\n"); 
		query.append(",	@[skd_dir_cd]" ).append("\n"); 
		query.append(",	@[rev_dir_cd]" ).append("\n"); 
		query.append(",	@[rlane_cd]" ).append("\n"); 
		query.append(",	@[lgs_cost_cd]" ).append("\n"); 
		query.append(",	@[io_bnd_cd]" ).append("\n"); 
		query.append(",	@[locl_amt]" ).append("\n"); 
		query.append(",	@[usd_amt]" ).append("\n"); 
		query.append(",	@[calc_amt]" ).append("\n"); 
		query.append(",	@[adj_amt]" ).append("\n"); 
		query.append(",	@[xpr_desc]" ).append("\n"); 
		query.append(",	@[foml_desc]" ).append("\n"); 
		query.append(",	@[yd_chg_ver_seq]" ).append("\n"); 
		query.append(",	@[yd_chg_no]" ).append("\n"); 
		query.append(",	@[diff_rmk]" ).append("\n"); 
		query.append(",	@[ar_yrmon]" ).append("\n"); 
		query.append(",	@[cre_usr_id]" ).append("\n"); 
		query.append(",	decode(@[cre_dt], null, sysdate, TO_DATE(@[cre_dt],'YYYY-MM-DD') ) " ).append("\n"); 
		query.append(",	@[upd_usr_id]" ).append("\n"); 
		query.append(",	decode(@[upd_dt], null, sysdate, TO_DATE(@[upd_dt],'YYYY-MM-DD') )" ).append("\n"); 
		query.append(",	@[n3pty_bil_if_flg]" ).append("\n"); 
		query.append(",	@[mnl_inp_xch_rt]" ).append("\n"); 
		query.append(",   TO_DATE(@[cost_calc_eff_fm_dt],'YYYY-MM-DD') " ).append("\n"); 
		query.append(",   TO_DATE(@[cost_calc_eff_to_dt],'YYYY-MM-DD') " ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}