/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : BookingMasterMgtDBDAOAddBlGroupCSQL.java
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

public class BookingMasterMgtDBDAOAddBlGroupCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * add BL Group
	  * </pre>
	  */
	public BookingMasterMgtDBDAOAddBlGroupCSQL(){
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
		params.put("ntfy_prn_flg",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("obl_prf_flg",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("bl_vw_rt_tp_cd1",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("bl_vw_rt_tp_cd2",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bl_vw_rt_tp_cd3",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.bookingmasterdata.bookingmastermgt.integration").append("\n"); 
		query.append("FileName : BookingMasterMgtDBDAOAddBlGroupCSQL").append("\n"); 
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
		query.append("INSERT INTO BKG_CTRL_PTY_BL_GRP" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("    CTRL_PTY_SEQ," ).append("\n"); 
		query.append("    BL_GRP_SEQ," ).append("\n"); 
		query.append("    BL_VW_RT_TP_CD," ).append("\n"); 
		query.append("    OBL_PRF_FLG," ).append("\n"); 
		query.append("    WBL_PRF_FLG," ).append("\n"); 
		query.append("    OBL_PRN_FLG," ).append("\n"); 
		query.append("    WBL_PRN_FLG," ).append("\n"); 
		query.append("    NON_NEGO_PRN_FLG," ).append("\n"); 
		query.append("    NTFY_PRF_FLG," ).append("\n"); 
		query.append("    NTFY_PRN_FLG," ).append("\n"); 
		query.append("    NTFY_AUTO_WBL_FLG," ).append("\n"); 
		query.append("    CRE_USR_ID," ).append("\n"); 
		query.append("    CRE_DT," ).append("\n"); 
		query.append("    UPD_USR_ID," ).append("\n"); 
		query.append("    UPD_DT," ).append("\n"); 
		query.append("	FTP_SVR_NM," ).append("\n"); 
		query.append("	FTP_SVR_USR_NM," ).append("\n"); 
		query.append("	FTP_SVR_PWD," ).append("\n"); 
		query.append("	FTP_SVR_DIR_NM," ).append("\n"); 
		query.append("	RTY_KNT," ).append("\n"); 
		query.append("	RTY_ITVAL_NO," ).append("\n"); 
		query.append("	EML_CUST_FLG," ).append("\n"); 
		query.append("	EML_CUST_ADDR," ).append("\n"); 
		query.append("	EML_PDF_FLG," ).append("\n"); 
		query.append("	EML_PDF_ADDR," ).append("\n"); 
		query.append("	BL_TP_CD," ).append("\n"); 
		query.append("	ALTN_DE_FLG," ).append("\n"); 
		query.append("	XPT_FILE_NM," ).append("\n"); 
		query.append("	FTP_DIR_CTNT," ).append("\n"); 
		query.append("	ERR_NTC_FLG," ).append("\n"); 
		query.append("	SCS_NTC_FLG," ).append("\n"); 
		query.append("    FTP_DIR_CTNT2," ).append("\n"); 
		query.append("    FTP_DIR_CTNT3," ).append("\n"); 
		query.append("    FTP_DIR_CTNT4" ).append("\n"); 
		query.append(")VALUES" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("    @[ctrl_pty_seq]," ).append("\n"); 
		query.append("    @[bl_grp_seq]," ).append("\n"); 
		query.append("	CASE WHEN @[bl_vw_rt_tp_cd1] = '1' THEN 'U'" ).append("\n"); 
		query.append("	     WHEN @[bl_vw_rt_tp_cd2] = '1' THEN 'F'" ).append("\n"); 
		query.append("	     WHEN @[bl_vw_rt_tp_cd3] = '1' THEN 'P'" ).append("\n"); 
		query.append("	     WHEN @[bl_vw_rt_tp_cd4] = '1' THEN 'C'" ).append("\n"); 
		query.append("	ELSE ''     " ).append("\n"); 
		query.append("	END," ).append("\n"); 
		query.append("    DECODE(@[obl_prf_flg],'1','Y','N')," ).append("\n"); 
		query.append("    DECODE(@[wbl_prf_flg],'1','Y','N')," ).append("\n"); 
		query.append("    DECODE(@[obl_prn_flg],'1','Y','N')," ).append("\n"); 
		query.append("    DECODE(@[wbl_prn_flg],'1','Y','N')," ).append("\n"); 
		query.append("    DECODE(@[non_nego_prn_flg],'1','Y','N')," ).append("\n"); 
		query.append("    DECODE(@[ntfy_prf_flg],'1','Y','N')," ).append("\n"); 
		query.append("    DECODE(@[ntfy_prn_flg],'1','Y','N')," ).append("\n"); 
		query.append("    DECODE(@[ntfy_auto_wbl_flg],'1','Y','N')," ).append("\n"); 
		query.append("    @[cre_usr_id]," ).append("\n"); 
		query.append("    SYSDATE," ).append("\n"); 
		query.append("    @[upd_usr_id]," ).append("\n"); 
		query.append("    SYSDATE," ).append("\n"); 
		query.append("	@[ftp_svr_nm]," ).append("\n"); 
		query.append("	@[ftp_svr_usr_nm]," ).append("\n"); 
		query.append("	@[ftp_svr_pwd]," ).append("\n"); 
		query.append("	@[ftp_svr_dir_nm]," ).append("\n"); 
		query.append("	@[rty_knt]," ).append("\n"); 
		query.append("	@[rty_itval_no]," ).append("\n"); 
		query.append("	DECODE(@[eml_cust_flg],'1','Y','N')," ).append("\n"); 
		query.append("	@[eml_cust_addr]," ).append("\n"); 
		query.append("	DECODE(@[eml_pdf_flg],'1','Y','N')," ).append("\n"); 
		query.append("	@[eml_pdf_addr]," ).append("\n"); 
		query.append("	@[bl_tp_cd]," ).append("\n"); 
		query.append("	DECODE(@[altn_de_flg],'1','Y','N')," ).append("\n"); 
		query.append("	@[xpt_file_nm]," ).append("\n"); 
		query.append("	@[ftp_dir_ctnt]," ).append("\n"); 
		query.append("	DECODE(@[err_ntc_flg],'1','Y','N')," ).append("\n"); 
		query.append("	DECODE(@[scs_ntc_flg],'1','Y','N')," ).append("\n"); 
		query.append("	@[ftp_dir_ctnt2]," ).append("\n"); 
		query.append("	@[ftp_dir_ctnt3]," ).append("\n"); 
		query.append("	@[ftp_dir_ctnt4]" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}