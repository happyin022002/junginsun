/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : BkgCopManageDBDAOSearchBkgEurTroRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.12.30
*@LastModifier : 김인수
*@LastVersion : 1.0
* 2009.12.30 김인수
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.sce.bkgcopmanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Kim In-soo
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BkgCopManageDBDAOSearchBkgEurTroRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * BKG_EUR_TRO 정보를 조회한다.
	  * </pre>
	  */
	public BkgCopManageDBDAOSearchBkgEurTroRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("tro_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.sce.bkgcopmanage.integration").append("\n"); 
		query.append("FileName : BkgCopManageDBDAOSearchBkgEurTroRSQL").append("\n"); 
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
		query.append("SELECT 	CNTR_CFM_USR_ID," ).append("\n"); 
		query.append("BKG_NO," ).append("\n"); 
		query.append("CNTR_CFM_FLG," ).append("\n"); 
		query.append("IO_BND_CD," ).append("\n"); 
		query.append("TRO_SEQ," ).append("\n"); 
		query.append("RQST_SUB_SEQ," ).append("\n"); 
		query.append("CNTR_NO," ).append("\n"); 
		query.append("CNTR_TPSZ_CD," ).append("\n"); 
		query.append("DCGO_SEQ," ).append("\n"); 
		query.append("RC_SEQ," ).append("\n"); 
		query.append("AWK_CGO_SEQ," ).append("\n"); 
		query.append("HLG_TP_CD," ).append("\n"); 
		query.append("CGO_WGT," ).append("\n"); 
		query.append("CNTR_PKUP_YD_CD," ).append("\n"); 
		query.append("TO_CHAR(CNTR_PKUP_DT, 'YYYYMMDDHH24MISS') AS CNTR_PKUP_DT," ).append("\n"); 
		query.append("CNTR_RTN_YD_CD," ).append("\n"); 
		query.append("TO_CHAR(CNTR_RTN_DT, 'YYYYMMDDHH24MISS') AS CNTR_RTN_DT," ).append("\n"); 
		query.append("EUR_TRNS_TP_CD," ).append("\n"); 
		query.append("DRP_OFF_PKUP_YD_CD," ).append("\n"); 
		query.append("CMDT_CD," ).append("\n"); 
		query.append("REP_CMDT_CD," ).append("\n"); 
		query.append("REP_CMDT_DESC," ).append("\n"); 
		query.append("BKG_TRSP_MZD_CD," ).append("\n"); 
		query.append("SPCL_INSTR_RMK," ).append("\n"); 
		query.append("TRO_PROC_CD," ).append("\n"); 
		query.append("CXL_FLG," ).append("\n"); 
		query.append("CSTMS_CLR_NO," ).append("\n"); 
		query.append("CURR_CD," ).append("\n"); 
		query.append("VAT_FLG," ).append("\n"); 
		query.append("T1_DOC_FLG," ).append("\n"); 
		query.append("TRNS_REV_AMT," ).append("\n"); 
		query.append("SO_CTY_CD," ).append("\n"); 
		query.append("SO_SEQ_NO," ).append("\n"); 
		query.append("ACT_CNT_CD," ).append("\n"); 
		query.append("ACT_CUST_SEQ," ).append("\n"); 
		query.append("CORR_NO," ).append("\n"); 
		query.append("CORR_FLG," ).append("\n"); 
		query.append("CFM_FLG," ).append("\n"); 
		query.append("CFM_USR_ID," ).append("\n"); 
		query.append("CFM_OFC_CD," ).append("\n"); 
		query.append("TO_CHAR(CFM_DT, 'YYYYMMDDHH24MISS') AS CFM_DT," ).append("\n"); 
		query.append("TO_CHAR(CFM_UPD_DT, 'YYYYMMDDHH24MISS') AS CFM_UPD_DT," ).append("\n"); 
		query.append("CFM_HLG_TP_CD," ).append("\n"); 
		query.append("CFM_CURR_CD," ).append("\n"); 
		query.append("CFM_REV_AMT," ).append("\n"); 
		query.append("CFM_VAT_FLG," ).append("\n"); 
		query.append("PCTL_NO," ).append("\n"); 
		query.append("CRE_OFC_CD" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("BKG_EUR_TRO" ).append("\n"); 
		query.append("WHERE" ).append("\n"); 
		query.append("BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("and IO_BND_CD = @[io_bnd_cd]" ).append("\n"); 
		query.append("and TRO_SEQ = @[tro_seq]" ).append("\n"); 

	}
}