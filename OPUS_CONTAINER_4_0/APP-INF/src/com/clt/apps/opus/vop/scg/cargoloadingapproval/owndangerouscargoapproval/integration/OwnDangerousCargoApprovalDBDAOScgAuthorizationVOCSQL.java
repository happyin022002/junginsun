/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : OwnDangerousCargoApprovalDBDAOScgAuthorizationVOCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.08.12
*@LastModifier : 
*@LastVersion : 1.0
* 2015.08.12 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.scg.cargoloadingapproval.owndangerouscargoapproval.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class OwnDangerousCargoApprovalDBDAOScgAuthorizationVOCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SCG_AUTHORIZATION 생성
	  * </pre>
	  */
	public OwnDangerousCargoApprovalDBDAOScgAuthorizationVOCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("spcl_cgo_auth_rmk",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("spcl_cgo_auth_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_pre_pst_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("auth_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.NUMERIC + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dcgo_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.NUMERIC + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bb_cgo_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rgn_shp_opr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("spcl_cgo_cate_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("stwg_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.NUMERIC + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("awk_cgo_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.NUMERIC + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rc_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.NUMERIC + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("spcl_cgo_apro_rqst_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("apro_ref_no",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("spcl_cgo_auth_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("spcl_cgo_auth_rjct_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("auth_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("vsl_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.vop.scg.cargoloadingapproval.owndangerouscargoapproval.integration").append("\n"); 
		query.append("FileName : OwnDangerousCargoApprovalDBDAOScgAuthorizationVOCSQL").append("\n"); 
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
		query.append("INSERT INTO SCG_AUTHORIZATION (" ).append("\n"); 
		query.append("	BKG_NO" ).append("\n"); 
		query.append(",	SPCL_CGO_APRO_RQST_SEQ" ).append("\n"); 
		query.append(",	VSL_PRE_PST_CD" ).append("\n"); 
		query.append(",	VSL_SEQ" ).append("\n"); 
		query.append(",	SPCL_CGO_AUTH_SEQ" ).append("\n"); 
		query.append(",	SPCL_CGO_CATE_CD" ).append("\n"); 
		query.append(",	DCGO_SEQ" ).append("\n"); 
		query.append(",	RC_SEQ" ).append("\n"); 
		query.append(",	BB_CGO_SEQ" ).append("\n"); 
		query.append(",	AWK_CGO_SEQ" ).append("\n"); 
		query.append(",   STWG_CGO_SEQ" ).append("\n"); 
		query.append(",	RGN_SHP_OPR_CD" ).append("\n"); 
		query.append(",	SPCL_CGO_AUTH_CD" ).append("\n"); 
		query.append(",	AUTH_OFC_CD" ).append("\n"); 
		query.append(",	AUTH_USR_ID" ).append("\n"); 
		query.append(",	AUTH_DT" ).append("\n"); 
		query.append(",	AUTH_GDT" ).append("\n"); 
		query.append(",	SPCL_CGO_AUTH_NO" ).append("\n"); 
		query.append(",	SPCL_CGO_AUTH_RJCT_CD" ).append("\n"); 
		query.append(",	APRO_REF_NO" ).append("\n"); 
		query.append(",	SPCL_CGO_AUTH_RMK" ).append("\n"); 
		query.append(",	CRE_USR_ID" ).append("\n"); 
		query.append(",	CRE_DT" ).append("\n"); 
		query.append(",	UPD_USR_ID" ).append("\n"); 
		query.append(",	UPD_DT" ).append("\n"); 
		query.append(") VALUES( " ).append("\n"); 
		query.append("	@[bkg_no]" ).append("\n"); 
		query.append(",	@[spcl_cgo_apro_rqst_seq]" ).append("\n"); 
		query.append(",	@[vsl_pre_pst_cd]" ).append("\n"); 
		query.append(",	@[vsl_seq]" ).append("\n"); 
		query.append(",	( 	SELECT NVL(MAX(SPCL_CGO_AUTH_SEQ)+1,1) FROM SCG_AUTHORIZATION " ).append("\n"); 
		query.append("		WHERE BKG_NO = @[bkg_no] AND SPCL_CGO_APRO_RQST_SEQ = @[spcl_cgo_apro_rqst_seq] AND VSL_PRE_PST_CD = @[vsl_pre_pst_cd] AND VSL_SEQ = @[vsl_seq] )" ).append("\n"); 
		query.append(",	@[spcl_cgo_cate_cd]" ).append("\n"); 
		query.append(",	@[dcgo_seq]" ).append("\n"); 
		query.append(",	@[rc_seq]" ).append("\n"); 
		query.append(",	@[bb_cgo_seq]" ).append("\n"); 
		query.append(",	@[awk_cgo_seq]" ).append("\n"); 
		query.append(",   @[stwg_seq]" ).append("\n"); 
		query.append(",	@[rgn_shp_opr_cd]" ).append("\n"); 
		query.append(",	@[spcl_cgo_auth_cd]" ).append("\n"); 
		query.append(",	@[auth_ofc_cd]" ).append("\n"); 
		query.append(",	@[auth_usr_id]" ).append("\n"); 
		query.append(",	NVL(GLOBALDATE_PKG.TIME_CONV_FNC(COM_ConstantMgr_PKG.COM_getBaseLocationCode_FNC(),SYSDATE,BKG_COM_USER_LOC_FNC(@[cre_usr_id])), SYSDATE)" ).append("\n"); 
		query.append(",	NVL(GLOBALDATE_PKG.TIME_CONV_FNC(COM_ConstantMgr_PKG.COM_getBaseLocationCode_FNC(),SYSDATE,'GMT'), SYSDATE)" ).append("\n"); 
		query.append(",	@[spcl_cgo_auth_no]" ).append("\n"); 
		query.append(",	@[spcl_cgo_auth_rjct_cd]" ).append("\n"); 
		query.append(",	@[apro_ref_no]" ).append("\n"); 
		query.append(",	@[spcl_cgo_auth_rmk]" ).append("\n"); 
		query.append(",	@[cre_usr_id]" ).append("\n"); 
		query.append(",	sysdate" ).append("\n"); 
		query.append(",	@[cre_usr_id]" ).append("\n"); 
		query.append(",	sysdate" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}