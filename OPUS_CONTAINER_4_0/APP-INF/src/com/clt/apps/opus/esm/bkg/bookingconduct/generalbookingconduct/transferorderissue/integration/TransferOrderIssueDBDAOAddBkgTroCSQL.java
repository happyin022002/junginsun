/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : TransferOrderIssueDBDAOAddBkgTroCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.03.16
*@LastModifier : 
*@LastVersion : 1.0
* 2016.03.16 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.transferorderissue.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TransferOrderIssueDBDAOAddBkgTroCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * TransferOrderIssueDB::AddBkgTro
	  * </pre>
	  */
	public TransferOrderIssueDBDAOAddBkgTroCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rcv_term_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cfm_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntc_fax_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rqst_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cfm_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dor_loc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("act_shpr_cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cxl_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntc_pson_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dor_pst_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("act_shpr_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("drp_and_pk_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("tri_axl_req_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ownr_trk_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("zn_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.NUMERIC + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("act_shpr_seq",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cntc_mphn_no",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("act_shpr_addr",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("biz_rgst_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.NUMERIC + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("tro_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("so_flg",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("io_bnd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rtn_tro_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntc_phn_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.transferorderissue.integration").append("\n"); 
		query.append("FileName : TransferOrderIssueDBDAOAddBkgTroCSQL").append("\n"); 
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
		query.append("INSERT INTO BKG_TRO (" ).append("\n"); 
		query.append("	BKG_NO" ).append("\n"); 
		query.append(",	IO_BND_CD" ).append("\n"); 
		query.append(",	RTN_TRO_FLG" ).append("\n"); 
		query.append(",	TRO_SEQ" ).append("\n"); 
		query.append(",	RCV_TERM_CD" ).append("\n"); 
		query.append(",	RQST_DT" ).append("\n"); 
		query.append(",	RQST_USR_ID" ).append("\n"); 
		query.append(",	ACT_SHPR_CNT_CD" ).append("\n"); 
		query.append(",	ACT_SHPR_SEQ" ).append("\n"); 
		query.append(",	ACT_SHPR_NM" ).append("\n"); 
		query.append(",	ACT_SHPR_PHN_NO" ).append("\n"); 
		query.append(",	ACT_SHPR_ADDR" ).append("\n"); 
		query.append(",	ZN_CD" ).append("\n"); 
		query.append(",	DOR_LOC_CD" ).append("\n"); 
		query.append(",	DOR_PST_NO" ).append("\n"); 
		query.append(",	CFM_FLG" ).append("\n"); 
		query.append(",	CFM_DT" ).append("\n"); 
		query.append(",	DIFF_RMK" ).append("\n"); 
		query.append(",	CNTC_PSON_NM" ).append("\n"); 
		query.append(",	CNTC_FAX_NO" ).append("\n"); 
		query.append(",	CNTC_MPHN_NO" ).append("\n"); 
		query.append(",	CXL_FLG" ).append("\n"); 
		query.append(",   SO_FLG" ).append("\n"); 
		query.append(",   OWNR_TRK_FLG" ).append("\n"); 
		query.append(",   BIZ_RGST_NO " ).append("\n"); 
		query.append(",	CRE_USR_ID" ).append("\n"); 
		query.append(",	CRE_DT" ).append("\n"); 
		query.append(",	UPD_USR_ID" ).append("\n"); 
		query.append(",	UPD_DT" ).append("\n"); 
		query.append(",   XTER_TRO_SEQ" ).append("\n"); 
		query.append(", 	DRP_AND_PK_FLG" ).append("\n"); 
		query.append(",   TRI_AXL_REQ_FLG" ).append("\n"); 
		query.append(") VALUES( " ).append("\n"); 
		query.append("	@[bkg_no]" ).append("\n"); 
		query.append(",	@[io_bnd_cd]" ).append("\n"); 
		query.append(",	NVL(@[rtn_tro_flg], 'N')" ).append("\n"); 
		query.append(",	@[tro_seq]" ).append("\n"); 
		query.append(",	@[rcv_term_cd]" ).append("\n"); 
		query.append(",	sysdate" ).append("\n"); 
		query.append(",	@[rqst_usr_id]" ).append("\n"); 
		query.append(",	@[act_shpr_cnt_cd]" ).append("\n"); 
		query.append(",	@[act_shpr_seq]" ).append("\n"); 
		query.append(",	@[act_shpr_nm]" ).append("\n"); 
		query.append(",	@[cntc_phn_no]" ).append("\n"); 
		query.append(",	@[act_shpr_addr]" ).append("\n"); 
		query.append("#if (${zn_cd} != '') " ).append("\n"); 
		query.append(",	@[dor_loc_cd]||@[zn_cd]" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append(",	@[zn_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(",	@[dor_loc_cd]" ).append("\n"); 
		query.append(",	@[dor_pst_no]" ).append("\n"); 
		query.append(",	NVL(@[cfm_flg], 'N')" ).append("\n"); 
		query.append(",	TO_DATE(@[cfm_dt], 'YYYY-MM-DD HH24:MI')" ).append("\n"); 
		query.append(",	@[diff_rmk]" ).append("\n"); 
		query.append(",	@[cntc_pson_nm]" ).append("\n"); 
		query.append(",	@[cntc_fax_no]" ).append("\n"); 
		query.append(",	@[cntc_mphn_no]" ).append("\n"); 
		query.append(",	NVL(@[cxl_flg], 'N')" ).append("\n"); 
		query.append(",   NVL(@[so_flg], 'N')" ).append("\n"); 
		query.append(",   NVL(@[ownr_trk_flg], 'N')" ).append("\n"); 
		query.append(",   @[biz_rgst_no]" ).append("\n"); 
		query.append(",	@[cre_usr_id]" ).append("\n"); 
		query.append(",	sysdate" ).append("\n"); 
		query.append(",	@[upd_usr_id]" ).append("\n"); 
		query.append(",	sysdate" ).append("\n"); 
		query.append(",	@[tro_seq]" ).append("\n"); 
		query.append(",   @[drp_and_pk_flg]" ).append("\n"); 
		query.append(",   @[tri_axl_req_flg]" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}