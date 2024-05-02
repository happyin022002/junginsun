/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : BLIssuanceDBDAOManageBlIssInfoUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.01.06
*@LastModifier : 문경일
*@LastVersion : 1.0
* 2016.01.06 문경일
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author KYOUNGIL MOON
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BLIssuanceDBDAOManageBlIssInfoUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ManageBlIssInfo
	  * </pre>
	  */
	public BLIssuanceDBDAOManageBlIssInfoUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bl_ready_by",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bl_issue_by",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bl_proofbyshipper_checkbox",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bl_ready_office",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bl_proofbyshipper_by",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trd_ppd_rcv_user_office",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trd_cct_rcv_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ppd_confirm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bl_ready_date",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cct_confirm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cct_rcv_user_office",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ppd_rcv_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bl_iss_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bl_issue_date",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bl_proofbyshipper_office",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trd_cct_rcv_user_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trd_cct_confirm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trd_ppd_rcv_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trd_ppd_rcv_user_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trd_cct_rcv_user_office",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("bl_issue_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ppd_rcv_user_office",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ppd_rcv_user_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bl_proofbyshipper_date",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inet_ctrl_pty_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bl_ready_type",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cct_rcv_user_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("obl_iss_rmk",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inet_ctrl_pty_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trd_ppd_confirm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bl_ready_checkbox",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bl_cpy_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bl_issue_at",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cct_rcv_dt",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.integration").append("\n"); 
		query.append("FileName : BLIssuanceDBDAOManageBlIssInfoUSQL").append("\n"); 
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
		query.append("#if (${sql_type} == 'count') " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("SELECT COUNT(BKG_NO) FROM BKG_BL_ISS  WHERE BKG_NO= @[bkg_no]" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#elseif (${sql_type} == 'insert') " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("INSERT INTO " ).append("\n"); 
		query.append("BKG_BL_ISS (" ).append("\n"); 
		query.append("	BKG_NO" ).append("\n"); 
		query.append("	,ORG_PPD_RCV_CD	" ).append("\n"); 
		query.append("	,ORG_N3PTY_PPD_CD" ).append("\n"); 
		query.append("	,DEST_CLT_RCV_CD" ).append("\n"); 
		query.append("	,DEST_N3PTY_CLT_CD	" ).append("\n"); 
		query.append("	,BL_RDY_FLG		" ).append("\n"); 
		query.append("	,BL_RDY_USR_ID		" ).append("\n"); 
		query.append("	,BL_PRF_SHPR_FLG	" ).append("\n"); 
		query.append("	,BL_PRF_SHPR_OFC_CD	" ).append("\n"); 
		query.append("	,BL_PRF_SHPR_USR_ID	" ).append("\n"); 
		query.append(" 	,BL_PRF_SHPR_DT		" ).append("\n"); 
		query.append(" 	,BL_RDY_DT	" ).append("\n"); 
		query.append("	,BL_RDY_OFC_CD		" ).append("\n"); 
		query.append("	,BL_RDY_TP_CD		" ).append("\n"); 
		query.append("	,BL_CPY_KNT		" ).append("\n"); 
		query.append("	,BL_CPY_NO" ).append("\n"); 
		query.append("	,OBL_ISS_OFC_CD		" ).append("\n"); 
		query.append("	,OBL_ISS_USR_ID		" ).append("\n"); 
		query.append(" 	,OBL_ISS_DT		" ).append("\n"); 
		query.append("	,ORG_PPD_RCV_UPD_USR_ID	" ).append("\n"); 
		query.append("	,ORG_N3PTY_PPD_UPD_USR_ID " ).append("\n"); 
		query.append("	,DEST_CLT_RCV_UPD_USR_ID  " ).append("\n"); 
		query.append("	,DEST_N3PTY_CLT_UPD_USR_ID " ).append("\n"); 
		query.append("	,ORG_PPD_RCV_UPD_OFC_CD " ).append("\n"); 
		query.append("	,ORG_N3PTY_PPD_UPD_OFC_CD " ).append("\n"); 
		query.append("	,DEST_CLT_RCV_UPD_OFC_CD  " ).append("\n"); 
		query.append("	,DEST_N3PTY_CLT_UPD_OFC_CD " ).append("\n"); 
		query.append(" 	,ORG_PPD_RCV_UPD_DT	" ).append("\n"); 
		query.append(" 	,ORG_N3PTY_PPD_UPD_DT		" ).append("\n"); 
		query.append(" 	,DEST_CLT_RCV_UPD_DT 	" ).append("\n"); 
		query.append(" 	,DEST_N3PTY_CLT_UPD_DT" ).append("\n"); 
		query.append("	,CRE_USR_ID" ).append("\n"); 
		query.append("	,CRE_DT" ).append("\n"); 
		query.append("	,UPD_USR_ID         " ).append("\n"); 
		query.append("	,UPD_DT    " ).append("\n"); 
		query.append("	,OBL_ISS_RMK" ).append("\n"); 
		query.append("	,INET_CTRL_PTY_NM" ).append("\n"); 
		query.append("	,INET_CTRL_PTY_NO" ).append("\n"); 
		query.append("	,BL_ISS_TP_CD        " ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("VALUES (" ).append("\n"); 
		query.append("	  @[bkg_no]" ).append("\n"); 
		query.append("	, @[ppd_confirm]" ).append("\n"); 
		query.append("	, @[trd_ppd_confirm]" ).append("\n"); 
		query.append("	, @[cct_confirm]" ).append("\n"); 
		query.append("	, @[trd_cct_confirm]" ).append("\n"); 
		query.append("	, @[bl_ready_checkbox]" ).append("\n"); 
		query.append("	, @[bl_ready_by] " ).append("\n"); 
		query.append("	, @[bl_proofbyshipper_checkbox] " ).append("\n"); 
		query.append("	, @[bl_proofbyshipper_office] " ).append("\n"); 
		query.append("	, @[bl_proofbyshipper_by] " ).append("\n"); 
		query.append("#if ('000000' != ${bl_proofbyshipper_date})" ).append("\n"); 
		query.append("	,TO_DATE(replace(substr(@[bl_proofbyshipper_date],1,10),'-',''),'YYYY-MM-DD HH24:MI:SS')" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append(" 	,NULL" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if ('000000'!=${bl_ready_date})" ).append("\n"); 
		query.append("	,TO_DATE(replace(substr(@[bl_ready_date],1,10),'-',''),'YYYY-MM-DD HH24:MI:SS')" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append(" 	,NULL" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("	, @[bl_ready_office]" ).append("\n"); 
		query.append("	, @[bl_ready_type]" ).append("\n"); 
		query.append("	, @[bl_issue_no]" ).append("\n"); 
		query.append("	, @[bl_cpy_no]" ).append("\n"); 
		query.append("	, @[bl_issue_at]" ).append("\n"); 
		query.append("	, @[bl_issue_by] " ).append("\n"); 
		query.append("#if ('000000'!=${bl_issue_date})" ).append("\n"); 
		query.append(" 	, TO_DATE(@[bl_issue_date],'YYYY-MM-DD HH24:MI:SS')" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append(" 	,NULL" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("	, @[ppd_rcv_user_id]" ).append("\n"); 
		query.append("	, @[trd_ppd_rcv_user_id]" ).append("\n"); 
		query.append("	, @[cct_rcv_user_id]" ).append("\n"); 
		query.append("	, @[trd_cct_rcv_user_id]" ).append("\n"); 
		query.append("	, @[ppd_rcv_user_office]" ).append("\n"); 
		query.append("	, @[trd_ppd_rcv_user_office]" ).append("\n"); 
		query.append("	, @[cct_rcv_user_office]" ).append("\n"); 
		query.append("	, @[trd_cct_rcv_user_office]" ).append("\n"); 
		query.append("#if (${ppd_rcv_dt} != '')" ).append("\n"); 
		query.append(" 	, TO_DATE(replace(substr(@[ppd_rcv_dt],1,10),'-',''),'YYYY-MM-DD HH24:MI:SS')" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append(" 	,NULL" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${trd_ppd_rcv_dt} != '')" ).append("\n"); 
		query.append(" 	, TO_DATE(replace(substr(@[trd_ppd_rcv_dt],1,10) ,'-',''),'YYYY-MM-DD HH24:MI:SS')" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append(" 	,NULL" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${cct_rcv_dt} != '')" ).append("\n"); 
		query.append(" 	, TO_DATE(replace(substr(@[cct_rcv_dt],1,10) ,'-',''),'YYYY-MM-DD HH24:MI:SS')" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append(" 	,NULL" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${trd_cct_rcv_dt} != '')" ).append("\n"); 
		query.append(" 	, TO_DATE(replace(substr(@[trd_cct_rcv_dt],1,10) ,'-',''),'YYYY-MM-DD HH24:MI:SS')" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append(" 	,NULL" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("	, @[upd_usr_id]" ).append("\n"); 
		query.append("	, sysdate" ).append("\n"); 
		query.append("	, @[upd_usr_id]" ).append("\n"); 
		query.append("	, sysdate" ).append("\n"); 
		query.append("	, @[obl_iss_rmk]" ).append("\n"); 
		query.append("	, @[inet_ctrl_pty_nm]" ).append("\n"); 
		query.append("	, @[inet_ctrl_pty_no]" ).append("\n"); 
		query.append("	, @[bl_iss_tp_cd]" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#elseif (${sql_type} == 'update') " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("UPDATE " ).append("\n"); 
		query.append("	BKG_BL_ISS" ).append("\n"); 
		query.append(" SET   " ).append("\n"); 
		query.append("	ORG_PPD_RCV_CD		= @[ppd_confirm]" ).append("\n"); 
		query.append("	,ORG_N3PTY_PPD_CD	= @[trd_ppd_confirm]" ).append("\n"); 
		query.append("	,DEST_CLT_RCV_CD	= @[cct_confirm]" ).append("\n"); 
		query.append("	,DEST_N3PTY_CLT_CD	= @[trd_cct_confirm]" ).append("\n"); 
		query.append("	,BL_RDY_FLG			= @[bl_ready_checkbox]" ).append("\n"); 
		query.append("	,BL_RDY_USR_ID		= @[bl_ready_by] " ).append("\n"); 
		query.append("	,BL_PRF_SHPR_FLG	= @[bl_proofbyshipper_checkbox] " ).append("\n"); 
		query.append("	,BL_PRF_SHPR_OFC_CD	= @[bl_proofbyshipper_office] " ).append("\n"); 
		query.append("	,BL_PRF_SHPR_USR_ID	= @[bl_proofbyshipper_by] " ).append("\n"); 
		query.append("#if ('000000' != ${bl_proofbyshipper_date})" ).append("\n"); 
		query.append("	,BL_PRF_SHPR_DT		= TO_DATE(@[bl_proofbyshipper_date],'YYYY-MM-DD HH24:MI:SS')" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append(" 	,BL_PRF_SHPR_DT		= NULL" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if ('000000'!=${bl_ready_date})" ).append("\n"); 
		query.append("    ,BL_RDY_DT			= TO_DATE(@[bl_ready_date],'YYYY-MM-DD HH24:MI:SS')" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append(" 	,BL_RDY_DT	= NULL" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("	,BL_RDY_OFC_CD		= @[bl_ready_office]" ).append("\n"); 
		query.append("	,BL_RDY_TP_CD		= @[bl_ready_type]" ).append("\n"); 
		query.append("	,BL_CPY_KNT			= @[bl_issue_no]" ).append("\n"); 
		query.append("	,BL_CPY_NO			= @[bl_cpy_no]" ).append("\n"); 
		query.append("	,OBL_ISS_OFC_CD		= @[bl_issue_at]" ).append("\n"); 
		query.append("	,OBL_ISS_USR_ID		= @[bl_issue_by] " ).append("\n"); 
		query.append("#if ('000000'!=${bl_issue_date})" ).append("\n"); 
		query.append("    ,OBL_ISS_DT			= TO_DATE(@[bl_issue_date],'YYYY-MM-DD HH24:MI:SS')" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append(" 	,OBL_ISS_DT		= NULL" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("	,ORG_PPD_RCV_UPD_USR_ID	= @[ppd_rcv_user_id]" ).append("\n"); 
		query.append("	,ORG_N3PTY_PPD_UPD_USR_ID = @[trd_ppd_rcv_user_id]" ).append("\n"); 
		query.append("	,DEST_CLT_RCV_UPD_USR_ID  = @[cct_rcv_user_id]" ).append("\n"); 
		query.append("	,DEST_N3PTY_CLT_UPD_USR_ID = @[trd_cct_rcv_user_id]" ).append("\n"); 
		query.append("	,ORG_PPD_RCV_UPD_OFC_CD = @[ppd_rcv_user_office]" ).append("\n"); 
		query.append("	,ORG_N3PTY_PPD_UPD_OFC_CD = @[trd_ppd_rcv_user_office]" ).append("\n"); 
		query.append("	,DEST_CLT_RCV_UPD_OFC_CD  = @[cct_rcv_user_office]" ).append("\n"); 
		query.append("	,DEST_N3PTY_CLT_UPD_OFC_CD = @[trd_cct_rcv_user_office]" ).append("\n"); 
		query.append("#if (${ppd_rcv_dt} != '')" ).append("\n"); 
		query.append(",ORG_PPD_RCV_UPD_DT = TO_DATE(replace(substr(@[ppd_rcv_dt],1,10),'-',''),'YYYY-MM-DD HH24:MI:SS')" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append(" 	,ORG_PPD_RCV_UPD_DT	= NULL" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${trd_ppd_rcv_dt} != '')" ).append("\n"); 
		query.append(",ORG_N3PTY_PPD_UPD_DT = TO_DATE(replace(substr(@[trd_ppd_rcv_dt],1,10) ,'-',''),'YYYY-MM-DD HH24:MI:SS')" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append(" 	,ORG_N3PTY_PPD_UPD_DT		= NULL" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${cct_rcv_dt} != '')" ).append("\n"); 
		query.append(",DEST_CLT_RCV_UPD_DT = TO_DATE(replace(substr(@[cct_rcv_dt],1,10) ,'-',''),'YYYY-MM-DD HH24:MI:SS')" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append(" 	,DEST_CLT_RCV_UPD_DT 	= NULL" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${trd_cct_rcv_dt} != '')" ).append("\n"); 
		query.append(",DEST_N3PTY_CLT_UPD_DT = TO_DATE(replace(substr(@[trd_cct_rcv_dt],1,10) ,'-',''),'YYYY-MM-DD HH24:MI:SS')" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append(" 	,DEST_N3PTY_CLT_UPD_DT	= NULL" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("	,UPD_USR_ID         = @[upd_usr_id]" ).append("\n"); 
		query.append("	,UPD_DT             = sysdate" ).append("\n"); 
		query.append("	,OBL_ISS_RMK 		= @[obl_iss_rmk]" ).append("\n"); 
		query.append("	,INET_CTRL_PTY_NM   = @[inet_ctrl_pty_nm]" ).append("\n"); 
		query.append("	,INET_CTRL_PTY_NO	= @[inet_ctrl_pty_no]" ).append("\n"); 
		query.append("	,BL_ISS_TP_CD 			= @[bl_iss_tp_cd]" ).append("\n"); 
		query.append("WHERE  " ).append("\n"); 
		query.append("	BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}