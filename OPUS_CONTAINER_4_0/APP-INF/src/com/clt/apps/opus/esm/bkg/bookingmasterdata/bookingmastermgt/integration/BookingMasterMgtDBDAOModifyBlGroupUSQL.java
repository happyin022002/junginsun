/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : BookingMasterMgtDBDAOModifyBlGroupUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.01.12
*@LastModifier : 
*@LastVersion : 1.0
* 2017.01.12 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingmasterdata.bookingmastermgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BookingMasterMgtDBDAOModifyBlGroupUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * modify BL Group
	  * </pre>
	  */
	public BookingMasterMgtDBDAOModifyBlGroupUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ftp_svr_pwd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("old_bl_grp_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bl_grp_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ftp_svr_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ftp_dir_ctnt3",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ftp_dir_ctnt2",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ftp_dir_ctnt4",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("wbl_prn_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("scs_ntc_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("xpt_file_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("altn_de_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bl_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("obl_prn_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ntfy_prf_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ctrl_pty_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ntfy_prn_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("obl_prf_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ntfy_auto_wbl_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ftp_svr_dir_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rty_itval_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eml_cust_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("non_nego_prn_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eml_pdf_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eml_cust_addr",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ftp_svr_usr_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ftp_dir_ctnt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("err_ntc_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bl_vw_rt_tp_cd4",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("wbl_prf_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rty_knt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eml_pdf_addr",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bl_vw_rt_tp_cd1",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bl_vw_rt_tp_cd2",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bl_vw_rt_tp_cd3",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.bookingmasterdata.bookingmastermgt.integration").append("\n"); 
		query.append("FileName : BookingMasterMgtDBDAOModifyBlGroupUSQL").append("\n"); 
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
		query.append("UPDATE BKG_CTRL_PTY_BL_GRP" ).append("\n"); 
		query.append("SET BL_VW_RT_TP_CD		= CASE WHEN @[bl_vw_rt_tp_cd1] = '1' THEN 'U'" ).append("\n"); 
		query.append("					       WHEN @[bl_vw_rt_tp_cd2] = '1' THEN 'F'" ).append("\n"); 
		query.append("					       WHEN @[bl_vw_rt_tp_cd3] = '1' THEN 'P'" ).append("\n"); 
		query.append("					       WHEN @[bl_vw_rt_tp_cd4] = '1' THEN 'C'" ).append("\n"); 
		query.append("					  	ELSE ''     " ).append("\n"); 
		query.append("					  	END,  " ).append("\n"); 
		query.append("    OBL_PRF_FLG			= DECODE(@[obl_prf_flg],'1','Y','N'),     " ).append("\n"); 
		query.append("    WBL_PRF_FLG			= DECODE(@[wbl_prf_flg],'1','Y','N'),    " ).append("\n"); 
		query.append("    OBL_PRN_FLG			= DECODE(@[obl_prn_flg],'1','Y','N'),     " ).append("\n"); 
		query.append("    WBL_PRN_FLG			= DECODE(@[wbl_prn_flg],'1','Y','N'),    " ).append("\n"); 
		query.append("    NON_NEGO_PRN_FLG	= DECODE(@[non_nego_prn_flg],'1','Y','N')," ).append("\n"); 
		query.append("    NTFY_PRF_FLG		= DECODE(@[ntfy_prf_flg],'1','Y','N'),    " ).append("\n"); 
		query.append("    NTFY_PRN_FLG		= DECODE(@[ntfy_prn_flg],'1','Y','N'),    " ).append("\n"); 
		query.append("    NTFY_AUTO_WBL_FLG	= DECODE(@[ntfy_auto_wbl_flg],'1','Y','N')," ).append("\n"); 
		query.append("    UPD_USR_ID			= @[upd_usr_id]," ).append("\n"); 
		query.append("    UPD_DT				= SYSDATE," ).append("\n"); 
		query.append("	FTP_SVR_NM      	=  @[ftp_svr_nm]," ).append("\n"); 
		query.append("	FTP_SVR_USR_NM  	=  @[ftp_svr_usr_nm]," ).append("\n"); 
		query.append("	FTP_SVR_PWD	    	=  @[ftp_svr_pwd]," ).append("\n"); 
		query.append("	FTP_SVR_DIR_NM  	=  @[ftp_svr_dir_nm]," ).append("\n"); 
		query.append("	RTY_KNT         	=  @[rty_knt]," ).append("\n"); 
		query.append("	RTY_ITVAL_NO    	=  @[rty_itval_no]," ).append("\n"); 
		query.append("	EML_CUST_FLG    	=  DECODE(@[eml_cust_flg],'1','Y','N')," ).append("\n"); 
		query.append("	EML_CUST_ADDR   	=  @[eml_cust_addr]," ).append("\n"); 
		query.append("	EML_PDF_FLG     	=  DECODE(@[eml_pdf_flg],'1','Y','N')," ).append("\n"); 
		query.append("	EML_PDF_ADDR    	=  @[eml_pdf_addr]," ).append("\n"); 
		query.append("	BL_TP_CD        	=  @[bl_tp_cd]," ).append("\n"); 
		query.append("	ALTN_DE_FLG     	=  DECODE(@[altn_de_flg],'1','Y','N')," ).append("\n"); 
		query.append("	BL_GRP_SEQ      	= @[bl_grp_seq]," ).append("\n"); 
		query.append("	XPT_FILE_NM      	= @[xpt_file_nm]," ).append("\n"); 
		query.append("	FTP_DIR_CTNT      	= @[ftp_dir_ctnt]," ).append("\n"); 
		query.append("	ERR_NTC_FLG     	=  DECODE(@[err_ntc_flg],'1','Y','N')," ).append("\n"); 
		query.append("	SCS_NTC_FLG     	=  DECODE(@[scs_ntc_flg],'1','Y','N')," ).append("\n"); 
		query.append("	FTP_DIR_CTNT2      	= @[ftp_dir_ctnt2]," ).append("\n"); 
		query.append("	FTP_DIR_CTNT3      	= @[ftp_dir_ctnt3]," ).append("\n"); 
		query.append("	FTP_DIR_CTNT4      	= @[ftp_dir_ctnt4]" ).append("\n"); 
		query.append("WHERE     " ).append("\n"); 
		query.append("    CTRL_PTY_SEQ    	= @[ctrl_pty_seq]" ).append("\n"); 
		query.append("AND BL_GRP_SEQ      	= @[old_bl_grp_seq]" ).append("\n"); 

	}
}