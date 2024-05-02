/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : PerformanceReportDBDAODocQueueBkgHistListVOCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.12.16
*@LastModifier : 
*@LastVersion : 1.0
* 2011.12.16 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PerformanceReportDBDAODocQueueBkgHistListVOCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 2011.11.11 정선용 [CHM-201113594] DPCS-SI Turn Time레포트 및 Draft B/L전송후 Amendment S/I PIC변경
	  *                 SR Amend Type 조회로직 수정 
	  * </pre>
	  */
	public PerformanceReportDBDAODocQueueBkgHistListVOCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sr_amd_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fax_log_ref_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.NUMERIC + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bl_split_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("img_pg_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("img_file_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bl_split_ttl_knt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sr_knd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sr_urg_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.NUMERIC + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sr_amd_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sr_amd_knd_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("sr_no",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("split_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("diff_rmk",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.DATE + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sr_due_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fnt_ofc_eml",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.integration").append("\n"); 
		query.append("FileName : PerformanceReportDBDAODocQueueBkgHistListVOCSQL").append("\n"); 
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
		query.append("INSERT INTO BKG_SR_CRNT_RQST (" ).append("\n"); 
		query.append("	SR_KND_CD" ).append("\n"); 
		query.append(",	SR_NO" ).append("\n"); 
		query.append(",	BKG_NO" ).append("\n"); 
		query.append(",	SR_AMD_TP_CD" ).append("\n"); 
		query.append(",	SR_AMD_SEQ" ).append("\n"); 
		query.append(",	SR_URG_CD" ).append("\n"); 
		query.append(",	SR_AMD_KND_CD" ).append("\n"); 
		query.append(",	IMG_PG_NO" ).append("\n"); 
		query.append(",	DIFF_RMK" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("--,   SR_WRK_STS_DT" ).append("\n"); 
		query.append("--,   SR_WRK_STS_CD" ).append("\n"); 
		query.append("--,   SR_WRK_STS_USR_ID" ).append("\n"); 
		query.append(",	RCV_OFC_CD" ).append("\n"); 
		query.append(",	IMG_FILE_IP" ).append("\n"); 
		query.append(",	IMG_FILE_PATH_CTNT" ).append("\n"); 
		query.append(",	IMG_FILE_NM" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(",	CRE_FLG" ).append("\n"); 
		query.append(",	CUST_INP_FLG" ).append("\n"); 
		query.append(",	CHG_INP_FLG" ).append("\n"); 
		query.append(",	CNTR_INP_FLG" ).append("\n"); 
		query.append(",	CNTR_MF_INP_FLG" ).append("\n"); 
		query.append(",	DCGO_INP_FLG" ).append("\n"); 
		query.append(",	AWK_CGO_INP_FLG" ).append("\n"); 
		query.append(",	RC_INP_FLG" ).append("\n"); 
		query.append(",	BB_CGO_INP_FLG" ).append("\n"); 
		query.append(",	RLY_PORT_INP_FLG" ).append("\n"); 
		query.append(",	NEW_BKG_CRE_FLG" ).append("\n"); 
		query.append(",	SPLIT_FLG" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(",	BL_INFO_INP_FLG" ).append("\n"); 
		query.append(",	BL_RT_FLG" ).append("\n"); 
		query.append(",	BL_AUD_FLG" ).append("\n"); 
		query.append(",	BL_DRFT_FAX_OUT_FLG" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(",	HBL_INFO_INP_FLG" ).append("\n"); 
		query.append(",	MK_DESC_INP_FLG" ).append("\n"); 
		query.append(",	CRE_USR_ID" ).append("\n"); 
		query.append(",	CRE_DT" ).append("\n"); 
		query.append(",	UPD_USR_ID" ).append("\n"); 
		query.append(",	UPD_DT" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(",	FAX_LOG_REF_NO" ).append("\n"); 
		query.append(",  SPLIT_STS_CD" ).append("\n"); 
		query.append(",  BL_SPLIT_NO" ).append("\n"); 
		query.append(",  BL_SPLIT_TTL_KNT" ).append("\n"); 
		query.append(",  SR_DUE_DT" ).append("\n"); 
		query.append(",  FNT_OFC_EML" ).append("\n"); 
		query.append(") SELECT " ).append("\n"); 
		query.append("	@[sr_knd_cd]" ).append("\n"); 
		query.append(",	@[sr_no]" ).append("\n"); 
		query.append(",	@[bkg_no]" ).append("\n"); 
		query.append(",   (SELECT CASE WHEN @[sr_amd_tp_cd] IN ('O','A','R') THEN DECODE(CORR_FLG,'R','R','N',SR_AMD_TP)" ).append("\n"); 
		query.append("			     ELSE @[sr_amd_tp_cd]" ).append("\n"); 
		query.append("			     END SR_AMD_TP_CD" ).append("\n"); 
		query.append("	 FROM ( SELECT (SELECT DECODE(COUNT(*),0,'O','A') " ).append("\n"); 
		query.append("			        FROM BKG_SR_CRNT_RQST " ).append("\n"); 
		query.append("			        WHERE BKG_NO = @[bkg_no]) SR_AMD_TP," ).append("\n"); 
		query.append("			       NVL((SELECT CASE WHEN BL_AUD_FLG = 'Y' AND  BL_DRFT_FAX_OUT_FLG = 'Y' THEN 'R'" ).append("\n"); 
		query.append("                                    ELSE 'N'" ).append("\n"); 
		query.append("                                    END " ).append("\n"); 
		query.append("			            FROM BKG_SR_CRNT_RQST" ).append("\n"); 
		query.append("			            WHERE BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("			            AND SR_AMD_SEQ = (SELECT MAX(SR_AMD_SEQ) " ).append("\n"); 
		query.append("			                              FROM BKG_SR_CRNT_RQST" ).append("\n"); 
		query.append("			                              WHERE BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("									      AND BL_AUD_FLG = 'Y'" ).append("\n"); 
		query.append("										  AND BL_DRFT_FAX_OUT_FLG = 'Y')),'N') CORR_FLG" ).append("\n"); 
		query.append("			FROM DUAL))" ).append("\n"); 
		query.append(",	@[sr_amd_seq]" ).append("\n"); 
		query.append(",	@[sr_urg_cd]" ).append("\n"); 
		query.append(",	@[sr_amd_knd_cd]" ).append("\n"); 
		query.append(",	@[img_pg_no]" ).append("\n"); 
		query.append(",	@[diff_rmk]" ).append("\n"); 
		query.append(",	rcv_ofc_cd" ).append("\n"); 
		query.append(",	img_file_ip" ).append("\n"); 
		query.append(",	img_file_path_ctnt" ).append("\n"); 
		query.append(",	@[img_file_nm]" ).append("\n"); 
		query.append(",	'N'" ).append("\n"); 
		query.append(",	'N'" ).append("\n"); 
		query.append(",	'N'" ).append("\n"); 
		query.append(",	'N'" ).append("\n"); 
		query.append(",	'N'" ).append("\n"); 
		query.append(",	'N'" ).append("\n"); 
		query.append(",	'N'" ).append("\n"); 
		query.append(",	'N'" ).append("\n"); 
		query.append(",	'N'" ).append("\n"); 
		query.append(",	'N'" ).append("\n"); 
		query.append(",	'N'" ).append("\n"); 
		query.append(",	'N'" ).append("\n"); 
		query.append(",	'N'" ).append("\n"); 
		query.append(",	'N'" ).append("\n"); 
		query.append(",	'N'" ).append("\n"); 
		query.append(",	'N'" ).append("\n"); 
		query.append(",	'N'" ).append("\n"); 
		query.append(",	'N'" ).append("\n"); 
		query.append(",	@[upd_usr_id]" ).append("\n"); 
		query.append(",	SYSDATE" ).append("\n"); 
		query.append(",	@[upd_usr_id]" ).append("\n"); 
		query.append(",	SYSDATE" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(",	FAX_LOG_REF_NO" ).append("\n"); 
		query.append(",  @[split_flg]" ).append("\n"); 
		query.append(",  @[bl_split_no]" ).append("\n"); 
		query.append(",  to_number(@[bl_split_ttl_knt])" ).append("\n"); 
		query.append(",  @[sr_due_dt]" ).append("\n"); 
		query.append(",  @[fnt_ofc_eml]" ).append("\n"); 
		query.append("FROM	BKG_SR_FAX" ).append("\n"); 
		query.append("WHERE 	SR_NO =@[sr_no]" ).append("\n"); 
		query.append("AND		SR_KND_CD = 'F'" ).append("\n"); 
		query.append("AND     FAX_LOG_REF_NO = @[fax_log_ref_no]" ).append("\n"); 

	}
}