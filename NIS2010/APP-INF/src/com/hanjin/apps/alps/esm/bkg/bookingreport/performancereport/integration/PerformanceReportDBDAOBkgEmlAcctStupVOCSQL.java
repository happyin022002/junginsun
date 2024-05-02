/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : PerformanceReportDBDAOBkgEmlAcctStupVOCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.04.26
*@LastModifier : 김기종
*@LastVersion : 1.0
* 2011.04.26 김기종
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Kim Ki Jong
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PerformanceReportDBDAOBkgEmlAcctStupVOCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  *    
	  * </pre>
	  */
	public PerformanceReportDBDAOBkgEmlAcctStupVOCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pol_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eml_cpy_to_eml",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dpcs_eml_stnd_grp_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dpcs_eml_svc_knd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eml_prio_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("del_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eml_acct_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vbs_ctnt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("del_dpcs_eml_loc_grp_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("pol_dpcs_eml_loc_grp_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("incl_sub_ofc_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rgn_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.integration").append("\n"); 
		query.append("FileName : PerformanceReportDBDAOBkgEmlAcctStupVOCSQL").append("\n"); 
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
		query.append("MERGE  INTO BKG_EML_ACCT_STUP A" ).append("\n"); 
		query.append("USING DUAL ON (BKG_OFC_CD = @[bkg_ofc_cd] AND EML_ACCT_SEQ = @[eml_acct_seq] AND DELT_FLG = 'Y')" ).append("\n"); 
		query.append("WHEN MATCHED THEN" ).append("\n"); 
		query.append("	UPDATE SET " ).append("\n"); 
		query.append("    	VBS_CTNT = @[vbs_ctnt]" ).append("\n"); 
		query.append("    ,	EML_CPY_TO_EML = @[eml_cpy_to_eml]" ).append("\n"); 
		query.append("    ,	EML_PRIO_NO = @[eml_prio_no]" ).append("\n"); 
		query.append("    ,	INCL_SUB_OFC_FLG = DECODE(@[incl_sub_ofc_flg],'1','Y','N')" ).append("\n"); 
		query.append("    ,	DPCS_EML_SVC_KND_CD = @[dpcs_eml_svc_knd_cd]" ).append("\n"); 
		query.append("    ,	DPCS_EML_STND_GRP_TP_CD = @[dpcs_eml_stnd_grp_tp_cd]" ).append("\n"); 
		query.append("    ,	POL_DPCS_EML_LOC_GRP_TP_CD = @[pol_dpcs_eml_loc_grp_tp_cd]" ).append("\n"); 
		query.append("    ,	POL_CD = @[pol_cd]" ).append("\n"); 
		query.append("    ,	DEL_DPCS_EML_LOC_GRP_TP_CD = @[del_dpcs_eml_loc_grp_tp_cd]" ).append("\n"); 
		query.append("    ,	DEL_CD = @[del_cd]" ).append("\n"); 
		query.append("    ,	UPD_USR_ID = @[upd_usr_id]" ).append("\n"); 
		query.append("    ,	UPD_DT = SYSDATE" ).append("\n"); 
		query.append("	,	RGN_OFC_CD = @[rgn_ofc_cd]" ).append("\n"); 
		query.append("    WHERE	EML_ACCT_SEQ = @[eml_acct_seq]" ).append("\n"); 
		query.append("    AND		BKG_OFC_CD = @[bkg_ofc_cd]" ).append("\n"); 
		query.append("WHEN NOT MATCHED THEN" ).append("\n"); 
		query.append("	INSERT (" ).append("\n"); 
		query.append("    	VBS_CTNT" ).append("\n"); 
		query.append("    ,	EML_CPY_TO_EML" ).append("\n"); 
		query.append("    ,	EML_ACCT_SEQ" ).append("\n"); 
		query.append("    ,	BKG_OFC_CD" ).append("\n"); 
		query.append("    ,	EML_PRIO_NO" ).append("\n"); 
		query.append("    ,	INCL_SUB_OFC_FLG" ).append("\n"); 
		query.append("    ,	DPCS_EML_SVC_KND_CD" ).append("\n"); 
		query.append("    ,	DPCS_EML_STND_GRP_TP_CD" ).append("\n"); 
		query.append("    ,	POL_DPCS_EML_LOC_GRP_TP_CD" ).append("\n"); 
		query.append("    ,	POL_CD" ).append("\n"); 
		query.append("    ,	DEL_DPCS_EML_LOC_GRP_TP_CD" ).append("\n"); 
		query.append("    ,	DEL_CD" ).append("\n"); 
		query.append("    ,	DELT_FLG" ).append("\n"); 
		query.append("    ,	CRE_USR_ID" ).append("\n"); 
		query.append("    ,	CRE_DT" ).append("\n"); 
		query.append("    ,	UPD_USR_ID" ).append("\n"); 
		query.append("    ,	UPD_DT" ).append("\n"); 
		query.append("	,	RGN_OFC_CD" ).append("\n"); 
		query.append("    ) VALUES( " ).append("\n"); 
		query.append("    	@[vbs_ctnt]" ).append("\n"); 
		query.append("    ,	@[eml_cpy_to_eml]" ).append("\n"); 
		query.append("    ,	(SELECT NVL(MAX(EML_ACCT_SEQ),0)+1 AS EML_ACCT_SEQ FROM BKG_EML_ACCT_STUP WHERE BKG_OFC_CD = @[bkg_ofc_cd])" ).append("\n"); 
		query.append("    ,	@[bkg_ofc_cd]" ).append("\n"); 
		query.append("    ,	@[eml_prio_no]" ).append("\n"); 
		query.append("    ,	DECODE(@[incl_sub_ofc_flg],'1','Y','N')" ).append("\n"); 
		query.append("    ,	@[dpcs_eml_svc_knd_cd]" ).append("\n"); 
		query.append("    ,	@[dpcs_eml_stnd_grp_tp_cd]" ).append("\n"); 
		query.append("    ,	@[pol_dpcs_eml_loc_grp_tp_cd]" ).append("\n"); 
		query.append("    ,	@[pol_cd]" ).append("\n"); 
		query.append("    ,	@[del_dpcs_eml_loc_grp_tp_cd]" ).append("\n"); 
		query.append("    ,	@[del_cd]" ).append("\n"); 
		query.append("    ,	'N'" ).append("\n"); 
		query.append("    ,	@[upd_usr_id]" ).append("\n"); 
		query.append("    ,	SYSDATE" ).append("\n"); 
		query.append("    ,	@[upd_usr_id]" ).append("\n"); 
		query.append("    ,	SYSDATE" ).append("\n"); 
		query.append("	,	@[rgn_ofc_cd]" ).append("\n"); 
		query.append("    )" ).append("\n"); 

	}
}