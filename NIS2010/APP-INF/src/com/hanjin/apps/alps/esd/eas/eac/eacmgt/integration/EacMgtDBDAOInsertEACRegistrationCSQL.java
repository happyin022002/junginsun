/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : EacMgtDBDAOInsertEACRegistrationCSQL.java
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

public class EacMgtDBDAOInsertEACRegistrationCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * EAC Registration 데이터를 저장한다.
	  * </pre>
	  */
	public EacMgtDBDAOInsertEACRegistrationCSQL(){
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
		params.put("audr_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("ntc_his_seq",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("vvd_cd_ctnt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("eac_rsn_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("eml_subj_ctnt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("eac_sys_if_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eac_inp_dt",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.eas.eac.eacmgt.integration").append("\n"); 
		query.append("FileName : EacMgtDBDAOInsertEACRegistrationCSQL").append("\n"); 
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
		query.append("INSERT INTO EAS_EXPN_AUD_CS_MGMT( EAC_NO" ).append("\n"); 
		query.append("                                , EAC_INP_DT" ).append("\n"); 
		query.append("                                , AUDR_OFC_CD" ).append("\n"); 
		query.append("                                , AUDR_USR_ID" ).append("\n"); 
		query.append("                                , EAC_EXPN_TP_CD " ).append("\n"); 
		query.append("                                , EAC_TP_CD" ).append("\n"); 
		query.append("                                , EAC_BIL_TP_CD" ).append("\n"); 
		query.append("                                , EAC_COST_DESC" ).append("\n"); 
		query.append("                                , VNDR_SEQ" ).append("\n"); 
		query.append("                                , N3PTY_SRC_NO" ).append("\n"); 
		query.append("                                , N3PTY_SRC_DT" ).append("\n"); 
		query.append("                                , YD_CD" ).append("\n"); 
		query.append("                                , RESPB_OFC_CD                                " ).append("\n"); 
		query.append("                                , CURR_CD" ).append("\n"); 
		query.append("                                , INV_AMT" ).append("\n"); 
		query.append("                                , INV_CNG_AMT" ).append("\n"); 
		query.append("                                , INV_AUD_AMT" ).append("\n"); 
		query.append("                                , INV_AUD_USD_AMT" ).append("\n"); 
		query.append("                                , EAC_YRMON" ).append("\n"); 
		query.append("                                , EAC_RSN_CD" ).append("\n"); 
		query.append("                                , EAC_STS_CD" ).append("\n"); 
		query.append("                                , EAC_DESC" ).append("\n"); 
		query.append("                                , EAC_RJCT_RSN " ).append("\n"); 
		query.append("                                , EAC_INTER_RMK" ).append("\n"); 
		query.append("                                , EAC_RSN_DESC" ).append("\n"); 
		query.append("                                , EAC_CMPL_CD" ).append("\n"); 
		query.append("                                , EAC_CMPL_DT" ).append("\n"); 
		query.append("                                , NTC_HIS_SEQ" ).append("\n"); 
		query.append("                                , EML_SUBJ_CTNT" ).append("\n"); 
		query.append("                                , EML_CTNT" ).append("\n"); 
		query.append("                                , VVD_CD_CTNT" ).append("\n"); 
		query.append("                                , EAC_APRO_TP_CD" ).append("\n"); 
		query.append("                                , STL_AMT" ).append("\n"); 
		query.append("                                , EXPN_EVID_DESC" ).append("\n"); 
		query.append("                                , EAC_SYS_IF_CD" ).append("\n"); 
		query.append("                                , WO_NO_CTNT" ).append("\n"); 
		query.append("                                , VNDR_CNTC_PNT_SEQ" ).append("\n"); 
		query.append("                                , KPI_OFC_CD" ).append("\n"); 
		query.append("                                , CRE_USR_ID" ).append("\n"); 
		query.append("                                , CRE_DT" ).append("\n"); 
		query.append("                                , UPD_USR_ID" ).append("\n"); 
		query.append("                                , UPD_DT" ).append("\n"); 
		query.append("                                , EAC_CMPL_USR_ID" ).append("\n"); 
		query.append("                                )VALUES(" ).append("\n"); 
		query.append("                                   @[eac_no]" ).append("\n"); 
		query.append("                                ,  to_date(replace(@[eac_inp_dt],'-',''),'YYYYMMDD')" ).append("\n"); 
		query.append("                                ,  @[audr_ofc_cd]" ).append("\n"); 
		query.append("                                ,  @[audr_usr_id]" ).append("\n"); 
		query.append("                                ,  @[eac_expn_tp_cd]" ).append("\n"); 
		query.append("                                ,  @[eac_tp_cd]" ).append("\n"); 
		query.append("                                ,  @[eac_bil_tp_cd]" ).append("\n"); 
		query.append("                                ,  @[eac_cost_desc]" ).append("\n"); 
		query.append("                                ,  @[vndr_seq]" ).append("\n"); 
		query.append("                                ,  @[n3pty_src_no]" ).append("\n"); 
		query.append("                                ,  to_date(replace(@[n3pty_src_dt],'-',''),'YYYYMMDD')" ).append("\n"); 
		query.append("                                ,  @[yd_cd]" ).append("\n"); 
		query.append("                                ,  @[respb_ofc_cd]" ).append("\n"); 
		query.append("                                ,  @[curr_cd]" ).append("\n"); 
		query.append("                                ,  replace(@[inv_amt],',','')" ).append("\n"); 
		query.append("                                ,  replace(@[inv_cng_amt],',','')" ).append("\n"); 
		query.append("                                ,  replace(@[inv_aud_amt],',','')" ).append("\n"); 
		query.append("                                ,  replace(@[inv_aud_usd_amt],',','')" ).append("\n"); 
		query.append("                                ,  replace(@[eac_yrmon],'-','')" ).append("\n"); 
		query.append("                                ,  @[eac_rsn_cd]" ).append("\n"); 
		query.append("                                ,  'IS'" ).append("\n"); 
		query.append("                                ,  @[eac_desc]" ).append("\n"); 
		query.append("                                ,  @[eac_desc]" ).append("\n"); 
		query.append("                                ,  @[eac_inter_rmk]" ).append("\n"); 
		query.append("                                ,  @[eac_rsn_desc]" ).append("\n"); 
		query.append("                                ,  @[eac_cmpl_cd]" ).append("\n"); 
		query.append("                                ,  SYSDATE   -- eac_cmpl_dt" ).append("\n"); 
		query.append("                                ,  @[ntc_his_seq]" ).append("\n"); 
		query.append("                                ,  @[eml_subj_ctnt]" ).append("\n"); 
		query.append("                                ,  @[eml_ctnt]" ).append("\n"); 
		query.append("                                ,  @[vvd_cd_ctnt]" ).append("\n"); 
		query.append("                                ,  @[eac_apro_tp_cd]" ).append("\n"); 
		query.append("                                ,  replace(@[stl_amt],',','')" ).append("\n"); 
		query.append("                                ,  @[expn_evid_desc]" ).append("\n"); 
		query.append("                                ,  @[eac_sys_if_cd]" ).append("\n"); 
		query.append("                                ,  @[wo_no_ctnt]" ).append("\n"); 
		query.append("                                ,  @[vndr_cntc_pnt_nm]" ).append("\n"); 
		query.append("                                ,  (SELECT X.KPI_OFC_CD FROM EAS_EXPN_AUD_CS_PSON_CFG X WHERE X.EAC_USR_ID = @[audr_usr_id])" ).append("\n"); 
		query.append("                                ,  @[audr_usr_id]" ).append("\n"); 
		query.append("                                ,  SYSDATE" ).append("\n"); 
		query.append("                                ,  @[audr_usr_id]" ).append("\n"); 
		query.append("                                ,  SYSDATE" ).append("\n"); 
		query.append("                                ,  DECODE(@[eac_cmpl_cd], 'C', @[audr_usr_id], 'H', @[audr_usr_id], NULL)" ).append("\n"); 
		query.append("                                )" ).append("\n"); 

	}
}