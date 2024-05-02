/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : DryWetClaimDBDAOSearchStatusListVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.04.23
*@LastModifier : 정행룡
*@LastVersion : 1.0
* 2010.04.23 정행룡
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.cps.cni.drywetclaim.drywetclaim.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author JEONG HAENG RYONG
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class DryWetClaimDBDAOSearchStatusListVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Claim 및Incident Case 접수 및 처리 현황 조회한다
	  * </pre>
	  */
	public DryWetClaimDBDAOSearchStatusListVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_eng_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inci_plc_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("to_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dw_clm_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dw_co_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("labl_pty_clm_pty_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("from_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("deft_clm_pty_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dw_clm_att_def_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("insur_clm_pty_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dw_clm_ref_vvd_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dw_clm_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dw_clm_sts_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("clmt_clm_pty_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("hdlr_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("hdlr_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.cps.cni.drywetclaim.drywetclaim.integration").append("\n"); 
		query.append("FileName : DryWetClaimDBDAOSearchStatusListVORSQL").append("\n"); 
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
		query.append("SELECT " ).append("\n"); 
		query.append("	 DW_CLM_NO" ).append("\n"); 
		query.append("	,DW_CLM_TP_CD" ).append("\n"); 
		query.append("	,DW_CO_CD" ).append("\n"); 
		query.append("	,DW_CLM_REF_VVD_NO" ).append("\n"); 
		query.append("	,VSL_ENG_NM" ).append("\n"); 
		query.append("	,INCI_PLC_TP_CD" ).append("\n"); 
		query.append("	,INCI_OCCR_DT" ).append("\n"); 
		query.append("    ,CRE_OFC_CD" ).append("\n"); 
		query.append("    ,HDLR_OFC_CD" ).append("\n"); 
		query.append("	,(SELECT USR_NM FROM COM_USER WHERE USR_ID = A.HDLR_USR_ID) HDLR_USR_NM" ).append("\n"); 
		query.append("	,TM_BAR_DT" ).append("\n"); 
		query.append("	,LIT_DT" ).append("\n"); 
		query.append("	,DW_CLM_STS_CD" ).append("\n"); 
		query.append("	,DW_CLM_ATT_DEF_TP_CD" ).append("\n"); 
		query.append("	,PRLM_CLM_NTFY_DT" ).append("\n"); 
		query.append("	,CS_CLZ_DT" ).append("\n"); 
		query.append("	,ARBT_DT" ).append("\n"); 
		query.append("    ,(SELECT PTY_NM FROM CNI_PARTY WHERE CLM_PTY_NO = A.CLMT_CLM_PTY_NO) CLMT_CLM_PTY_NM" ).append("\n"); 
		query.append("    ,(SELECT PTY_NM FROM CNI_PARTY WHERE CLM_PTY_NO = A.INSUR_CLM_PTY_NO) INSUR_CLM_PTY_NM" ).append("\n"); 
		query.append("	,TO_CHAR(DDCT_USD_AMT,'FM999,999,999,990.00') DDCT_USD_AMT" ).append("\n"); 
		query.append("    ,(SELECT PTY_NM FROM CNI_PARTY WHERE CLM_PTY_NO = A.DEFT_CLM_PTY_NO) DEFT_CLM_PTY_NM" ).append("\n"); 
		query.append("    ,(SELECT PTY_NM FROM CNI_PARTY WHERE CLM_PTY_NO = A.LABL_PTY_CLM_PTY_NO) LABL_PTY_CLM_PTY_NM" ).append("\n"); 
		query.append("	,LABL_PTY_TM_BAR_DT" ).append("\n"); 
		query.append("	,FMAL_CLM_RCV_DT" ).append("\n"); 
		query.append("	,TO_CHAR(CLM_USD_AMT,'FM999,999,999,990.00') CLM_USD_AMT" ).append("\n"); 
		query.append("	,CLM_STL_DT" ).append("\n"); 
		query.append("	,TO_CHAR(CLM_STL_USD_AMT,'FM999,999,999,990.00') CLM_STL_USD_AMT" ).append("\n"); 
		query.append("	,LABL_PTY_FILE_DT" ).append("\n"); 
		query.append("	,TO_CHAR(LABL_PTY_FILE_USD_AMT,'FM999,999,999,990.00') LABL_PTY_FILE_USD_AMT" ).append("\n"); 
		query.append("	,LABL_PTY_RCVR_DT" ).append("\n"); 
		query.append("	,TO_CHAR(LABL_PTY_RCVR_USD_AMT,'FM999,999,999,990.00') LABL_PTY_RCVR_USD_AMT" ).append("\n"); 
		query.append("	,INSUR_FILE_DT" ).append("\n"); 
		query.append("	,TO_CHAR(INSUR_FILE_USD_AMT,'FM999,999,999,990.00') INSUR_FILE_USD_AMT" ).append("\n"); 
		query.append("	,INSUR_RCVR_DT" ).append("\n"); 
		query.append("	,TO_CHAR(INSUR_RCVR_USD_AMT,'FM999,999,999,990.00') INSUR_RCVR_USD_AMT" ).append("\n"); 
		query.append("	,CRE_USR_ID" ).append("\n"); 
		query.append("	,CRE_DT" ).append("\n"); 
		query.append("	,UPD_USR_ID" ).append("\n"); 
		query.append("	,TO_CHAR(UPD_DT, 'YYYYMMDD') UPD_DT" ).append("\n"); 
		query.append("    ,(SELECT USR_NM FROM COM_USER WHERE USR_ID = A.CRE_USR_ID) CRE_USR_NM" ).append("\n"); 
		query.append("    ,(SELECT TO_CHAR(SUM(C.INV_USD_AMT),'FM999,999,999,990.00')  FROM CNI_DW_CLM_COST C WHERE C.DW_CLM_NO = A.DW_CLM_NO) INV_AMT" ).append("\n"); 
		query.append("FROM    CNI_DW_CLM A" ).append("\n"); 
		query.append("#if (${date_type} == 'DON') " ).append("\n"); 
		query.append("WHERE     PRLM_CLM_NTFY_DT BETWEEN REPLACE(@[from_dt],'-','') AND REPLACE(@[to_dt],'-','')" ).append("\n"); 
		query.append("#elseif (${date_type} == 'DOB') " ).append("\n"); 
		query.append("WHERE     ARBT_DT BETWEEN REPLACE(@[from_dt],'-','') AND REPLACE(@[to_dt],'-','')" ).append("\n"); 
		query.append("#elseif (${date_type} == 'DOC') " ).append("\n"); 
		query.append("WHERE     CS_CLZ_DT BETWEEN REPLACE(@[from_dt],'-','') AND REPLACE(@[to_dt],'-','')" ).append("\n"); 
		query.append("#elseif (${date_type} == 'DOF') " ).append("\n"); 
		query.append("WHERE     FMAL_CLM_RCV_DT BETWEEN REPLACE(@[from_dt],'-','') AND REPLACE(@[to_dt],'-','')" ).append("\n"); 
		query.append("#elseif (${date_type} == 'DOI') " ).append("\n"); 
		query.append("WHERE     INCI_OCCR_DT BETWEEN REPLACE(@[from_dt],'-','') AND REPLACE(@[to_dt],'-','')" ).append("\n"); 
		query.append("#elseif (${date_type} == 'DOLT') " ).append("\n"); 
		query.append("WHERE     LIT_DT BETWEEN REPLACE(@[from_dt],'-','') AND REPLACE(@[to_dt],'-','')" ).append("\n"); 
		query.append("#elseif (${date_type} == 'DORINS') " ).append("\n"); 
		query.append("WHERE     INSUR_RCVR_DT BETWEEN REPLACE(@[from_dt],'-','') AND REPLACE(@[to_dt],'-','')" ).append("\n"); 
		query.append("#elseif (${date_type} == 'DORLP') " ).append("\n"); 
		query.append("WHERE     LABL_PTY_RCVR_DT BETWEEN REPLACE(@[from_dt],'-','') AND REPLACE(@[to_dt],'-','')" ).append("\n"); 
		query.append("#elseif (${date_type} == 'DOS') " ).append("\n"); 
		query.append("WHERE     CLM_STL_DT BETWEEN REPLACE(@[from_dt],'-','') AND REPLACE(@[to_dt],'-','')" ).append("\n"); 
		query.append("#elseif (${date_type} == 'DOTB') " ).append("\n"); 
		query.append("WHERE     TM_BAR_DT BETWEEN REPLACE(@[from_dt],'-','') AND REPLACE(@[to_dt],'-','')" ).append("\n"); 
		query.append("#elseif (${date_type} == 'DOTBLP') " ).append("\n"); 
		query.append("WHERE     LABL_PTY_TM_BAR_DT BETWEEN REPLACE(@[from_dt],'-','') AND REPLACE(@[to_dt],'-','')" ).append("\n"); 
		query.append("#elseif (${date_type} == 'DOU') " ).append("\n"); 
		query.append("WHERE     UPD_DT >= TO_DATE(@[from_dt],'YYYY-MM-DD') AND UPD_DT < TO_DATE(@[to_dt],'YYYY-MM-DD')+1" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${dw_clm_no} != '') " ).append("\n"); 
		query.append("AND     DW_CLM_NO like @[dw_clm_no]||'%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${dw_clm_tp_cd} != '') " ).append("\n"); 
		query.append("AND     DW_CLM_TP_CD like @[dw_clm_tp_cd]||'%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${dw_clm_sts_cd} != '') " ).append("\n"); 
		query.append("AND     DW_CLM_STS_CD like @[dw_clm_sts_cd]||'%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${dw_co_cd} != '') " ).append("\n"); 
		query.append("AND     DW_CO_CD like @[dw_co_cd]||'%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${dw_clm_ref_vvd_no} != '') " ).append("\n"); 
		query.append("AND     DW_CLM_REF_VVD_NO like @[dw_clm_ref_vvd_no]||'%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${vsl_eng_nm} != '') " ).append("\n"); 
		query.append("AND     VSL_ENG_NM like @[vsl_eng_nm]||'%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${dw_clm_att_def_tp_cd} != '') " ).append("\n"); 
		query.append("AND     DW_CLM_ATT_DEF_TP_CD like @[dw_clm_att_def_tp_cd]||'%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${hdlr_ofc_cd} != '') " ).append("\n"); 
		query.append("AND     HDLR_OFC_CD = @[hdlr_ofc_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${hdlr_usr_id} != '') " ).append("\n"); 
		query.append("AND     HDLR_USR_ID like @[hdlr_usr_id]||'%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${cre_ofc_cd} != '') " ).append("\n"); 
		query.append("AND     CRE_OFC_CD like @[cre_ofc_cd]||'%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${cre_usr_id} != '') " ).append("\n"); 
		query.append("AND     CRE_USR_ID like @[cre_usr_id]||'%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${insur_clm_pty_no} != '') " ).append("\n"); 
		query.append("AND     INSUR_CLM_PTY_NO like @[insur_clm_pty_no]||'%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${clmt_clm_pty_no} != '') " ).append("\n"); 
		query.append("AND     CLMT_CLM_PTY_NO like @[clmt_clm_pty_no]||'%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${deft_clm_pty_no} != '') " ).append("\n"); 
		query.append("AND     DEFT_CLM_PTY_NO like @[deft_clm_pty_no]||'%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${labl_pty_clm_pty_no} != '') " ).append("\n"); 
		query.append("AND     LABL_PTY_CLM_PTY_NO like @[labl_pty_clm_pty_no]||'%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${inci_plc_tp_cd} != '') " ).append("\n"); 
		query.append("AND     INCI_PLC_TP_CD like @[inci_plc_tp_cd]||'%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("ORDER BY CRE_DT DESC" ).append("\n"); 

	}
}