/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : OwnDangerousCargoApprovalDBDAOUndeclaredHistoryCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.01.21
*@LastModifier : 
*@LastVersion : 1.0
* 2016.01.21 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.scg.cargoloadingapproval.owndangerouscargoapproval.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class OwnDangerousCargoApprovalDBDAOUndeclaredHistoryCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * OwnDangerousCargoApprovalDBDAOUndeclaredHistory
	  * </pre>
	  */
	public OwnDangerousCargoApprovalDBDAOUndeclaredHistoryCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rslt_rmk2",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("file_sav_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inter_rmk",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("slan_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_mf_gds_desc",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("xter_rmk",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rqst_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rslt_rmk1",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cmdt_ctnt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("on_brd_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cstms_desc",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cst_cmdt_desc",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("file_nm",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("upd_usr_id",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.vop.scg.cargoloadingapproval.owndangerouscargoapproval.integration").append("\n"); 
		query.append("FileName : OwnDangerousCargoApprovalDBDAOUndeclaredHistoryCSQL").append("\n"); 
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
		query.append("INSERT INTO SCG_NON_DG_CGO_UDECL_HIS " ).append("\n"); 
		query.append("(	BKG_NO" ).append("\n"); 
		query.append("	, RQST_DT" ).append("\n"); 
		query.append("	, NON_DCGO_RQST_SEQ" ).append("\n"); 
		query.append("	, UDECL_DT" ).append("\n"); 
		query.append("	, RQST_OFC_CD" ).append("\n"); 
		query.append("	, VSL_CD" ).append("\n"); 
		query.append("	, SKD_VOY_NO" ).append("\n"); 
		query.append("	, SKD_DIR_CD" ).append("\n"); 
		query.append("	, SLAN_CD" ).append("\n"); 
		query.append("	, ON_BRD_FLG" ).append("\n"); 
		query.append("	, CSTMS_DESC" ).append("\n"); 
		query.append("	, CNTR_MF_GDS_DESC" ).append("\n"); 
		query.append("	, CMDT_DESC" ).append("\n"); 
		query.append("	, XTER_RMK" ).append("\n"); 
		query.append("	, INTER_RMK" ).append("\n"); 
		query.append("	, CMDT_CTNT" ).append("\n"); 
		query.append("	, RSLT_RMK1" ).append("\n"); 
		query.append("	, RSLT_RMK2" ).append("\n"); 
		query.append("	, FILE_SAV_ID" ).append("\n"); 
		query.append("	, FILE_NM" ).append("\n"); 
		query.append("	, CRE_USR_ID" ).append("\n"); 
		query.append("	, CRE_DT" ).append("\n"); 
		query.append("	, UPD_USR_ID" ).append("\n"); 
		query.append("	, UPD_DT" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("VALUES" ).append("\n"); 
		query.append("( 	@[bkg_no]" ).append("\n"); 
		query.append("	, SYSDATE --[rqst_dt]" ).append("\n"); 
		query.append("	, (SELECT NVL(MAX(NON_DCGO_RQST_SEQ),0)+1 FROM SCG_NON_DG_CGO_UDECL_HIS) --[non_dcgo_rqst_seq]" ).append("\n"); 
		query.append("	, SYSDATE --[udecl_dt]" ).append("\n"); 
		query.append("	, @[rqst_ofc_cd]" ).append("\n"); 
		query.append("	, @[vsl_cd]" ).append("\n"); 
		query.append("	, @[skd_voy_no]" ).append("\n"); 
		query.append("	, @[skd_dir_cd]" ).append("\n"); 
		query.append("	, @[slan_cd]" ).append("\n"); 
		query.append("	, @[on_brd_flg]" ).append("\n"); 
		query.append("	, @[cstms_desc]" ).append("\n"); 
		query.append("	, @[cntr_mf_gds_desc]" ).append("\n"); 
		query.append("	, @[cst_cmdt_desc]" ).append("\n"); 
		query.append("	, @[xter_rmk]" ).append("\n"); 
		query.append("	, @[inter_rmk]" ).append("\n"); 
		query.append("	, @[cmdt_ctnt]" ).append("\n"); 
		query.append("	, @[rslt_rmk1]" ).append("\n"); 
		query.append("	, @[rslt_rmk2]" ).append("\n"); 
		query.append("	, @[file_sav_id]" ).append("\n"); 
		query.append("	, @[file_nm]" ).append("\n"); 
		query.append("	, @[cre_usr_id]" ).append("\n"); 
		query.append("	, SYSDATE" ).append("\n"); 
		query.append("	, @[upd_usr_id]" ).append("\n"); 
		query.append("	, SYSDATE" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}