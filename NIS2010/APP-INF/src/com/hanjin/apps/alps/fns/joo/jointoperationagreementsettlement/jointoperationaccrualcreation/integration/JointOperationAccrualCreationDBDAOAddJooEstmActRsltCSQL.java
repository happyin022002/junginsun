/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : JointOperationAccrualCreationDBDAOAddJooEstmActRsltCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.03.11
*@LastModifier : 민정호
*@LastVersion : 1.0
* 2015.03.11 민정호
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.jointoperationaccrualcreation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Jung Ho Min
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class JointOperationAccrualCreationDBDAOAddJooEstmActRsltCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 2011.06.30 [CHM-201111621-01]
	  * 개발자 : 이준범
	  * 제   목 : Esitmate Perfomance Creation 기능 보완 요청
	  * 내   용 : 항목 및 항목별 조회 조건 추가
	  *            - Adjust, Adjusted BSA, Adjusted Slot Cost, Adjuest Estimated Cost, Adjuest Actual Cost, Remark, ADJ_RLSE_RMK, ADJ_RSLT_CD
	  * 2011.08.22 [CHM-201112985-01]
	  * 개발자 : 김영오
	  * 제   목 : Esitmate Perfomance Creation 기능 보완 요청
	  * 내   용 : 항목 및 항목별 조회 조건 추가
	  *            - ADJ_RLSE_RMK, ADJ_RSLT_CD
	  * </pre>
	  */
	public JointOperationAccrualCreationDBDAOAddJooEstmActRsltCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("adj_accl_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_blk_div_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("jo_stl_jb_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bsa_qty",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("accl_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("estm_vvd_hdr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("act_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("estm_act_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("accl_amt_corr_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("exe_yrmon",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("estm_vvd_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("adj_rslt_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("jo_crr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sys_src_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rlane_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("jo_cntr_div_ctnt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("estm_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("adj_rlse_rmk",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("adj_estm_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("adj_bsa_slt_prc",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rev_yrmon",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("adj_bsa_qty",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("adj_estm_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bsa_slt_prc",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("adj_rmk",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("skd_voy_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("jo_ioc_div_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("acct_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.jointoperationaccrualcreation.integration").append("\n"); 
		query.append("FileName : JointOperationAccrualCreationDBDAOAddJooEstmActRsltCSQL").append("\n"); 
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
		query.append("INSERT INTO JOO_ESTM_ACT_RSLT (" ).append("\n"); 
		query.append(" EXE_YRMON" ).append("\n"); 
		query.append(",REV_YRMON" ).append("\n"); 
		query.append(",JO_CRR_CD" ).append("\n"); 
		query.append(",RLANE_CD" ).append("\n"); 
		query.append(",VSL_CD" ).append("\n"); 
		query.append(",SKD_VOY_NO" ).append("\n"); 
		query.append(",SKD_DIR_CD" ).append("\n"); 
		query.append(",REV_DIR_CD" ).append("\n"); 
		query.append(",ESTM_VVD_TP_CD" ).append("\n"); 
		query.append(",ACCT_CD" ).append("\n"); 
		query.append(",ESTM_ACT_SEQ" ).append("\n"); 
		query.append(",BSA_QTY" ).append("\n"); 
		query.append(",BSA_SLT_PRC" ).append("\n"); 
		query.append(",ESTM_AMT" ).append("\n"); 
		query.append(",ACT_AMT" ).append("\n"); 
		query.append(",ACCL_AMT" ).append("\n"); 
		query.append(",SYS_SRC_ID" ).append("\n"); 
		query.append(",LOC_CD" ).append("\n"); 
		query.append(",JO_IOC_DIV_CD" ).append("\n"); 
		query.append(",ESTM_VVD_HDR_ID" ).append("\n"); 
		query.append(",JO_CNTR_DIV_CTNT" ).append("\n"); 
		query.append(",CNTR_BLK_DIV_CD" ).append("\n"); 
		query.append(",ACCL_AMT_CORR_FLG" ).append("\n"); 
		query.append(",JO_STL_JB_CD" ).append("\n"); 
		query.append(",ADJ_ESTM_FLG" ).append("\n"); 
		query.append(",ADJ_BSA_QTY" ).append("\n"); 
		query.append(",ADJ_BSA_SLT_PRC" ).append("\n"); 
		query.append(",ADJ_ESTM_AMT" ).append("\n"); 
		query.append(",ADJ_ACCL_AMT" ).append("\n"); 
		query.append(",ADJ_RMK" ).append("\n"); 
		query.append(",CRE_DT" ).append("\n"); 
		query.append(",CRE_USR_ID" ).append("\n"); 
		query.append(",UPD_DT" ).append("\n"); 
		query.append(",UPD_USR_ID" ).append("\n"); 
		query.append(",ADJ_RLSE_RMK" ).append("\n"); 
		query.append(",ADJ_RSLT_CD" ).append("\n"); 
		query.append(")VALUES(" ).append("\n"); 
		query.append(" REPLACE(@[exe_yrmon],'-','')" ).append("\n"); 
		query.append(",REPLACE(@[rev_yrmon],'-','')" ).append("\n"); 
		query.append(",@[jo_crr_cd]" ).append("\n"); 
		query.append(",@[rlane_cd]" ).append("\n"); 
		query.append(",@[vsl_cd]" ).append("\n"); 
		query.append(",@[skd_voy_no]" ).append("\n"); 
		query.append(",@[skd_dir_cd]" ).append("\n"); 
		query.append(",@[rev_dir_cd]" ).append("\n"); 
		query.append(",@[estm_vvd_tp_cd]" ).append("\n"); 
		query.append(",@[acct_cd]" ).append("\n"); 
		query.append(",TO_NUMBER(@[estm_act_seq])" ).append("\n"); 
		query.append(",NVL(@[bsa_qty],0)" ).append("\n"); 
		query.append(",NVL(@[bsa_slt_prc],0)" ).append("\n"); 
		query.append(",@[estm_amt]" ).append("\n"); 
		query.append(",@[act_amt]" ).append("\n"); 
		query.append(",@[accl_amt]" ).append("\n"); 
		query.append(",@[sys_src_id]" ).append("\n"); 
		query.append(",@[loc_cd]" ).append("\n"); 
		query.append(",@[jo_ioc_div_cd]" ).append("\n"); 
		query.append(",@[estm_vvd_hdr_id]" ).append("\n"); 
		query.append(",@[jo_cntr_div_ctnt]" ).append("\n"); 
		query.append(",@[cntr_blk_div_cd]" ).append("\n"); 
		query.append(",@[accl_amt_corr_flg]" ).append("\n"); 
		query.append(",@[jo_stl_jb_cd]" ).append("\n"); 
		query.append(",@[adj_estm_flg]" ).append("\n"); 
		query.append(",@[adj_bsa_qty]" ).append("\n"); 
		query.append(",@[adj_bsa_slt_prc]" ).append("\n"); 
		query.append(",@[adj_estm_amt]" ).append("\n"); 
		query.append(",@[adj_accl_amt]" ).append("\n"); 
		query.append(",@[adj_rmk]" ).append("\n"); 
		query.append(",SYSDATE" ).append("\n"); 
		query.append(",@[cre_usr_id]" ).append("\n"); 
		query.append(",SYSDATE" ).append("\n"); 
		query.append(",@[cre_usr_id]" ).append("\n"); 
		query.append(",@[adj_rlse_rmk]" ).append("\n"); 
		query.append(",@[adj_rslt_cd]" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}