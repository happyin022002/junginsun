/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : JointOperationMasterDataMgtDBDAOJooStlVvdVOCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.12.23
*@LastModifier : 
*@LastVersion : 1.0
* 2010.12.23 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.fns.joo.jointoperationmasterdatamgt.jointoperationmasterdatamgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class JointOperationMasterDataMgtDBDAOJooStlVvdVOCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  *    
	  * </pre>
	  */
	public JointOperationMasterDataMgtDBDAOJooStlVvdVOCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("re_divr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("jo_mnu_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("stl_bzc_port_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pair_port_eta_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("agmt_mon_cond_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trd_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("agmt_port_tp_cond_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("uc_bss_port_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("proc_jb_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bzc_port_etd_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pair_port_etd_dt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("jo_stl_cfm_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("acct_yrmon",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("stl_pair_port_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("jo_stl_itm_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("rlane_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("agmt_port_cond_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("uc_bss_port_etd_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bzc_port_eta_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("agmt_op_tp_cond_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("stl_rmk",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("stl_tgt_vvd_bss_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.fns.joo.jointoperationmasterdatamgt.jointoperationmasterdatamgt.integration").append("\n"); 
		query.append("FileName : JointOperationMasterDataMgtDBDAOJooStlVvdVOCSQL").append("\n"); 
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
		query.append("INSERT INTO JOO_STL_VVD (" ).append("\n"); 
		query.append("	ACCT_YRMON" ).append("\n"); 
		query.append(",	STL_VVD_SEQ" ).append("\n"); 
		query.append(",	TRD_CD" ).append("\n"); 
		query.append(",	JO_CRR_CD" ).append("\n"); 
		query.append(",	RLANE_CD" ).append("\n"); 
		query.append(",	RE_DIVR_CD" ).append("\n"); 
		query.append(",	JO_STL_ITM_CD" ).append("\n"); 
		query.append(",	JO_MNU_NM" ).append("\n"); 
		query.append(",	VSL_CD" ).append("\n"); 
		query.append(",	SKD_VOY_NO" ).append("\n"); 
		query.append(",	SKD_DIR_CD" ).append("\n"); 
		query.append(",	REV_DIR_CD" ).append("\n"); 
		query.append(",	STL_BZC_PORT_CD" ).append("\n"); 
		query.append(",	BZC_PORT_ETA_DT" ).append("\n"); 
		query.append(",	BZC_PORT_ETD_DT" ).append("\n"); 
		query.append(",	STL_PAIR_PORT_CD" ).append("\n"); 
		query.append(",	PAIR_PORT_ETA_DT" ).append("\n"); 
		query.append(",	PAIR_PORT_ETD_DT" ).append("\n"); 
		query.append(",	STL_TGT_VVD_BSS_CD" ).append("\n"); 
		query.append(",	JO_STL_CFM_CD" ).append("\n"); 
		query.append(",	PROC_JB_FLG" ).append("\n"); 
		query.append(",	STL_RMK" ).append("\n"); 
		query.append(",   UC_BSS_PORT_CD" ).append("\n"); 
		query.append(",   UC_BSS_PORT_ETD_DT" ).append("\n"); 
		query.append(",   AGMT_MON_COND_CD" ).append("\n"); 
		query.append(",   AGMT_PORT_COND_CD" ).append("\n"); 
		query.append(",   AGMT_PORT_TP_COND_CD" ).append("\n"); 
		query.append(",   AGMT_OP_TP_COND_CD" ).append("\n"); 
		query.append(",	CRE_DT" ).append("\n"); 
		query.append(",	CRE_USR_ID" ).append("\n"); 
		query.append(",	UPD_DT" ).append("\n"); 
		query.append(",	UPD_USR_ID" ).append("\n"); 
		query.append(") VALUES( " ).append("\n"); 
		query.append("	@[acct_yrmon]" ).append("\n"); 
		query.append(",	NVL((SELECT /*+INDEX_DESC(X XPKJOO_STL_VVD)*/ X.STL_VVD_SEQ+1 FROM JOO_STL_VVD X WHERE X.ACCT_YRMON = @[acct_yrmon] AND ROWNUM = 1),1)" ).append("\n"); 
		query.append(",	@[trd_cd]" ).append("\n"); 
		query.append(",	@[jo_crr_cd]" ).append("\n"); 
		query.append(",	@[rlane_cd]" ).append("\n"); 
		query.append(",	@[re_divr_cd]" ).append("\n"); 
		query.append(",	@[jo_stl_itm_cd]" ).append("\n"); 
		query.append(",	@[jo_mnu_nm]" ).append("\n"); 
		query.append(",	@[vsl_cd]" ).append("\n"); 
		query.append(",	@[skd_voy_no]" ).append("\n"); 
		query.append(",	@[skd_dir_cd]" ).append("\n"); 
		query.append(",	@[rev_dir_cd]" ).append("\n"); 
		query.append(",	@[stl_bzc_port_cd]" ).append("\n"); 
		query.append(",	TO_DATE(@[bzc_port_eta_dt],'YYYYMMDDHH24MISS')" ).append("\n"); 
		query.append(",	TO_DATE(@[bzc_port_etd_dt],'YYYYMMDDHH24MISS')" ).append("\n"); 
		query.append(",	@[stl_pair_port_cd]" ).append("\n"); 
		query.append(",	TO_DATE(@[pair_port_eta_dt],'YYYYMMDDHH24MISS')" ).append("\n"); 
		query.append(",	TO_DATE(@[pair_port_etd_dt],'YYYYMMDDHH24MISS')" ).append("\n"); 
		query.append(",	@[stl_tgt_vvd_bss_cd]" ).append("\n"); 
		query.append(",	@[jo_stl_cfm_cd]" ).append("\n"); 
		query.append(",	NVL(@[proc_jb_flg],'N')" ).append("\n"); 
		query.append(",	@[stl_rmk]" ).append("\n"); 
		query.append(",   @[uc_bss_port_cd]" ).append("\n"); 
		query.append(",   TO_DATE(nvl(@[uc_bss_port_etd_dt],@[bzc_port_eta_dt]),'YYYYMMDDHH24MISS')" ).append("\n"); 
		query.append(",	@[agmt_mon_cond_cd]" ).append("\n"); 
		query.append(",	@[agmt_port_cond_cd]" ).append("\n"); 
		query.append(",	@[agmt_port_tp_cond_cd]" ).append("\n"); 
		query.append(",	@[agmt_op_tp_cond_cd]" ).append("\n"); 
		query.append(",	SYSDATE" ).append("\n"); 
		query.append(",	@[cre_usr_id]" ).append("\n"); 
		query.append(",	SYSDATE" ).append("\n"); 
		query.append(",	@[cre_usr_id]" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}