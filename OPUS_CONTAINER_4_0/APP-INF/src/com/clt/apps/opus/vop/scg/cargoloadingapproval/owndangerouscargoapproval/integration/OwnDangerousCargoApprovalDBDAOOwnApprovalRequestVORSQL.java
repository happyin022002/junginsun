/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : OwnDangerousCargoApprovalDBDAOOwnApprovalRequestVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.04.05
*@LastModifier : 
*@LastVersion : 1.0
* 2016.04.05 
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

public class OwnDangerousCargoApprovalDBDAOOwnApprovalRequestVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Mail Preview 항목들을 조회한다.
	  * </pre>
	  */
	public OwnDangerousCargoApprovalDBDAOOwnApprovalRequestVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_ref_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("send_type",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
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
		params.put("vsl_pre_pst_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("scg_flg",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("rgn_shp_opr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("user_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("crr_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("prnr_cgo_rqst_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("spcl_cgo_rqst_seq",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("pol_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.vop.scg.cargoloadingapproval.owndangerouscargoapproval.integration").append("\n"); 
		query.append("FileName : OwnDangerousCargoApprovalDBDAOOwnApprovalRequestVORSQL").append("\n"); 
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
		query.append("#if (${send_type} != '' && ${send_type} == 'P0')" ).append("\n"); 
		query.append("--2016-01-28 FNC 분리 Partner Mail Contents " ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("   M.FROM_PSN" ).append("\n"); 
		query.append(" , M.TO_PSN" ).append("\n"); 
		query.append(" , M.CC_PSN" ).append("\n"); 
		query.append(" , M.SUBJECT" ).append("\n"); 
		query.append(" , M.ATTACH_FILE" ).append("\n"); 
		query.append(" , M.BODY_HEADER" ).append("\n"); 
		query.append(" , M.BODY_FOOTER" ).append("\n"); 
		query.append(" , M.BODY_CONTS" ).append("\n"); 
		query.append(" , '' CRR_CD" ).append("\n"); 
		query.append(" , '' BKG_REF_NO" ).append("\n"); 
		query.append(" , '' SPCL_CGO_RQST_SEQ" ).append("\n"); 
		query.append(" --, '' BKG_NO" ).append("\n"); 
		query.append(" --, '' SPCL_CGO_APRO_RQST_SEQ" ).append("\n"); 
		query.append(" , '' PRNR_CGO_RQST_SEQ" ).append("\n"); 
		query.append(" --, '' VSL_PRE_PST_CD" ).append("\n"); 
		query.append(" --, '' VSL_SEQ" ).append("\n"); 
		query.append(" , '' RGN_SHP_OPR_CD" ).append("\n"); 
		query.append(" , '' VSL_CD" ).append("\n"); 
		query.append(" , '' SKD_VOY_NO" ).append("\n"); 
		query.append(" , '' SKD_DIR_CD" ).append("\n"); 
		query.append(" , '' POL_CD" ).append("\n"); 
		query.append(" , '' POD_CD" ).append("\n"); 
		query.append(" , '' SCG_FLG" ).append("\n"); 
		query.append(" , '' SEND_TYPE" ).append("\n"); 
		query.append(" , '' USER_ID" ).append("\n"); 
		query.append("FROM TABLE(SCG_PRNR_RQST_MAIL_INFO_FNC(@[crr_cd],@[bkg_ref_no],@[spcl_cgo_rqst_seq],@[prnr_cgo_rqst_seq],@[rgn_shp_opr_cd],@[vsl_cd],@[skd_voy_no],@[skd_dir_cd],SUBSTR(@[pol_cd],0,5),SUBSTR(@[pod_cd],0,5),@[scg_flg],@[send_type],@[user_id])) M" ).append("\n"); 
		query.append("#else " ).append("\n"); 
		query.append("--2016-01-28 FNC 분리 OWN Mail Contents " ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("   M.FROM_PSN" ).append("\n"); 
		query.append(" , M.TO_PSN" ).append("\n"); 
		query.append(" , M.CC_PSN" ).append("\n"); 
		query.append(" , M.SUBJECT" ).append("\n"); 
		query.append(" , M.ATTACH_FILE" ).append("\n"); 
		query.append(" , M.BODY_HEADER" ).append("\n"); 
		query.append(" , M.BODY_FOOTER" ).append("\n"); 
		query.append(" , M.BODY_CONTS" ).append("\n"); 
		query.append(" , '' CRR_CD" ).append("\n"); 
		query.append(" , '' BKG_REF_NO" ).append("\n"); 
		query.append(" , '' SPCL_CGO_RQST_SEQ" ).append("\n"); 
		query.append(" , '' BKG_NO" ).append("\n"); 
		query.append(" , '' SPCL_CGO_APRO_RQST_SEQ" ).append("\n"); 
		query.append(" , '' VSL_PRE_PST_CD" ).append("\n"); 
		query.append(" , '' VSL_SEQ" ).append("\n"); 
		query.append(" , '' RGN_SHP_OPR_CD" ).append("\n"); 
		query.append(" , '' SCG_FLG" ).append("\n"); 
		query.append(" , '' SEND_TYPE" ).append("\n"); 
		query.append(" , '' USER_ID" ).append("\n"); 
		query.append("FROM TABLE(SCG_OWN_MAIL_INFO_FNC(@[crr_cd],@[bkg_ref_no],@[spcl_cgo_rqst_seq],@[bkg_no],@[spcl_cgo_apro_rqst_seq],@[vsl_pre_pst_cd],@[vsl_seq],@[rgn_shp_opr_cd],@[scg_flg],@[send_type],@[user_id])) M" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}