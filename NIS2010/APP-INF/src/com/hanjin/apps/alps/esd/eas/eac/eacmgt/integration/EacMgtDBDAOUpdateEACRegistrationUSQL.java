/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : EacMgtDBDAOUpdateEACRegistrationUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.12.11
*@LastModifier : 최종혁
*@LastVersion : 1.0
* 2015.12.11 최종혁
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.eas.eac.eacmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author CJH
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class EacMgtDBDAOUpdateEACRegistrationUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * EAC Registration 데이터를 수정한다.
	  * </pre>
	  */
	public EacMgtDBDAOUpdateEACRegistrationUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vndr_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("n3pty_src_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("n3pty_src_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("kpi_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eac_cost_desc",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("respb_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eac_cmpl_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eml_ctnt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("curr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eac_bil_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eac_inter_rmk",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vndr_cntc_pnt_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("yd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inv_aud_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eac_rsn_desc",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eac_apro_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("audr_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vvd_cd_ctnt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eac_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inv_cng_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("expn_evid_desc",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eac_expn_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eac_rjct_desc",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eac_rsn_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eml_subj_ctnt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inv_aud_usd_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inv_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("stl_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eac_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eac_yrmon",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eac_desc",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("wo_no_ctnt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eac_inp_dt",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.eas.eac.eacmgt.integration").append("\n"); 
		query.append("FileName : EacMgtDBDAOUpdateEACRegistrationUSQL").append("\n"); 
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
		query.append("UPDATE EAS_EXPN_AUD_CS_MGMT" ).append("\n"); 
		query.append("SET    EAC_INP_DT        = TO_DATE(REPLACE(@[eac_inp_dt], '-', '') ,'YYYYMMDD') " ).append("\n"); 
		query.append("     , EAC_EXPN_TP_CD    = @[eac_expn_tp_cd]" ).append("\n"); 
		query.append("     , EAC_TP_CD         = @[eac_tp_cd]  " ).append("\n"); 
		query.append("     , EAC_BIL_TP_CD     = @[eac_bil_tp_cd] " ).append("\n"); 
		query.append("     , EAC_COST_DESC     = @[eac_cost_desc] " ).append("\n"); 
		query.append("     , VNDR_SEQ          = @[vndr_seq]   " ).append("\n"); 
		query.append("     , N3PTY_SRC_NO      = @[n3pty_src_no]  " ).append("\n"); 
		query.append("     , N3PTY_SRC_DT      = TO_DATE(REPLACE(@[n3pty_src_dt], '-', '') ,'YYYYMMDD')" ).append("\n"); 
		query.append("     , YD_CD             = @[yd_cd]      " ).append("\n"); 
		query.append("     , RESPB_OFC_CD      = @[respb_ofc_cd] " ).append("\n"); 
		query.append("     , CURR_CD           = @[curr_cd]    " ).append("\n"); 
		query.append("     , INV_AMT           = replace(@[inv_amt],',','')        " ).append("\n"); 
		query.append("     , INV_CNG_AMT       = replace(@[inv_cng_amt],',','')    " ).append("\n"); 
		query.append("     , INV_AUD_AMT       = replace(@[inv_aud_amt],',','')    " ).append("\n"); 
		query.append("     , INV_AUD_USD_AMT   = replace(@[inv_aud_usd_amt],',','')" ).append("\n"); 
		query.append("     , EAC_YRMON         = replace(@[eac_yrmon],'-','')      " ).append("\n"); 
		query.append("     , EAC_RSN_CD        = @[eac_rsn_cd]" ).append("\n"); 
		query.append("     , EAC_DESC          = @[eac_desc]" ).append("\n"); 
		query.append("     , EAC_RJCT_RSN      = @[eac_rjct_desc]   " ).append("\n"); 
		query.append("     , EAC_INTER_RMK     = @[eac_inter_rmk] " ).append("\n"); 
		query.append("     , EAC_RSN_DESC      = @[eac_rsn_desc]  " ).append("\n"); 
		query.append("     , EAC_CMPL_CD       = @[eac_cmpl_cd]" ).append("\n"); 
		query.append("     , EAC_CMPL_DT       = SYSDATE   -- eac_cmpl_dt          " ).append("\n"); 
		query.append("     , EML_SUBJ_CTNT     = @[eml_subj_ctnt] " ).append("\n"); 
		query.append("     , EML_CTNT          = @[eml_ctnt]   " ).append("\n"); 
		query.append("     , VVD_CD_CTNT       = @[vvd_cd_ctnt]" ).append("\n"); 
		query.append("     , EAC_APRO_TP_CD    = DECODE(EAC_STS_CD,'IS',@[eac_apro_tp_cd],EAC_APRO_TP_CD)" ).append("\n"); 
		query.append("     , STL_AMT           = replace(@[stl_amt],',','')        " ).append("\n"); 
		query.append("     , EXPN_EVID_DESC    = @[expn_evid_desc]       " ).append("\n"); 
		query.append("     , WO_NO_CTNT        = @[wo_no_ctnt] " ).append("\n"); 
		query.append("     , VNDR_CNTC_PNT_SEQ = @[vndr_cntc_pnt_nm]" ).append("\n"); 
		query.append("     , UPD_USR_ID        = @[audr_usr_id]" ).append("\n"); 
		query.append("     , UPD_DT            = SYSDATE" ).append("\n"); 
		query.append("     , KPI_OFC_CD        = @[kpi_ofc_cd]" ).append("\n"); 
		query.append("     , EAC_CMPL_USR_ID   = CASE WHEN EAC_CMPL_CD IN ('C', 'H') AND @[eac_cmpl_cd] IN ( 'C', 'H') THEN EAC_CMPL_USR_ID -- Update전에 이미 Complete,Pending 상태일 경우 유저 정보를 변경하지 않음." ).append("\n"); 
		query.append("                                WHEN EAC_CMPL_CD IN ('C', 'H') AND @[eac_cmpl_cd] NOT IN ('C', 'H') THEN NULL" ).append("\n"); 
		query.append("                                WHEN EAC_CMPL_CD NOT IN ('C', 'H') AND @[eac_cmpl_cd] IN ('C', 'H') THEN @[audr_usr_id]" ).append("\n"); 
		query.append("                                ELSE NULL" ).append("\n"); 
		query.append("                           END" ).append("\n"); 
		query.append("WHERE  EAC_NO            = @[eac_no]" ).append("\n"); 

	}
}