/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CSRIssueTransferSlipManageDBDAOCreateApInvDTRBASANoCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.16
*@LastModifier : 김진
*@LastVersion : 1.0
* 2009.10.16 김진
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.trs.invoicemanage.csrissuetranferslip.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author KIM JIN
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CSRIssueTransferSlipManageDBDAOCreateApInvDTRBASANoCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * AP DTRB 테이블에 자료 입력
	  * </pre>
	  */
	public CSRIssueTransferSlipManageDBDAOCreateApInvDTRBASANoCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("CSR_NO",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ACCT_CD",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ISS_DT",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("LOC_CD",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("LINE_SEQ",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("COST_OFC_CD",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("TOTAL_AMT",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("CRE_USR_ID",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("INV_NO",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("VNDR_SEQ",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("LINE_NO",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.trs.invoicemanage.csrissuetranferslip.integration").append("\n"); 
		query.append("FileName : CSRIssueTransferSlipManageDBDAOCreateApInvDTRBASANoCSQL").append("\n"); 
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
		query.append("INSERT INTO 	AP_INV_DTRB (" ).append("\n"); 
		query.append("CSR_NO" ).append("\n"); 
		query.append(",	LINE_SEQ" ).append("\n"); 
		query.append(",	LINE_NO" ).append("\n"); 
		query.append(",	LINE_TP_LU_CD" ).append("\n"); 
		query.append(",	INV_AMT" ).append("\n"); 
		query.append(",	INV_DESC" ).append("\n"); 
		query.append(",	INV_TAX_CD" ).append("\n"); 
		query.append(",	DTRB_COA_CO_CD" ).append("\n"); 
		query.append(",	DTRB_COA_RGN_CD" ).append("\n"); 
		query.append(",	DTRB_COA_CTR_CD" ).append("\n"); 
		query.append(",	DTRB_COA_ACCT_CD" ).append("\n"); 
		query.append(",	DTRB_COA_VVD_CD" ).append("\n"); 
		query.append(",	DTRB_COA_INTER_CO_CD" ).append("\n"); 
		query.append(",	DTRB_COA_FTU_N1ST_CD" ).append("\n"); 
		query.append(",	DTRB_COA_FTU_N2ND_CD" ).append("\n"); 
		query.append(",	ATTR_CATE_NM" ).append("\n"); 
		query.append(",	ATTR_CTNT1" ).append("\n"); 
		query.append(",	ATTR_CTNT2" ).append("\n"); 
		query.append(",	ATTR_CTNT3" ).append("\n"); 
		query.append(",	ATTR_CTNT4" ).append("\n"); 
		query.append(",	ATTR_CTNT5" ).append("\n"); 
		query.append(",	ATTR_CTNT6" ).append("\n"); 
		query.append(",	ATTR_CTNT7" ).append("\n"); 
		query.append(",	ATTR_CTNT8" ).append("\n"); 
		query.append(",	ATTR_CTNT9" ).append("\n"); 
		query.append(",	ATTR_CTNT10" ).append("\n"); 
		query.append(",	ATTR_CTNT11" ).append("\n"); 
		query.append(",	ATTR_CTNT12" ).append("\n"); 
		query.append(",	ATTR_CTNT13" ).append("\n"); 
		query.append(",	ATTR_CTNT14" ).append("\n"); 
		query.append(",	ATTR_CTNT15" ).append("\n"); 
		query.append(",	BKG_NO" ).append("\n"); 
		query.append(",	CNTR_TPSZ_CD" ).append("\n"); 
		query.append(",	ACT_VVD_CD" ).append("\n"); 
		query.append(",	PLN_SCTR_DIV_CD" ).append("\n"); 
		query.append(",	SO_CRR_CD" ).append("\n"); 
		query.append(",	YD_CD" ).append("\n"); 
		query.append(",	FTU_USE_CTNT1" ).append("\n"); 
		query.append(",	FTU_USE_CTNT2" ).append("\n"); 
		query.append(",	FTU_USE_CTNT3" ).append("\n"); 
		query.append(",	FTU_USE_CTNT4" ).append("\n"); 
		query.append(",	FTU_USE_CTNT5" ).append("\n"); 
		query.append(",	CRE_DT" ).append("\n"); 
		query.append(",	CRE_USR_ID" ).append("\n"); 
		query.append(",	EAI_EVNT_DT" ).append("\n"); 
		query.append(") VALUES (" ).append("\n"); 
		query.append("@[CSR_NO]" ).append("\n"); 
		query.append(",	@[LINE_SEQ]" ).append("\n"); 
		query.append(",	@[LINE_NO]" ).append("\n"); 
		query.append(",	'ITEM'" ).append("\n"); 
		query.append(",	@[TOTAL_AMT]" ).append("\n"); 
		query.append(",	(SELECT ACCT_ENG_NM FROM MDM_ACCOUNT WHERE ACCT_CD = @[ACCT_CD])" ).append("\n"); 
		query.append(",	''" ).append("\n"); 
		query.append(",	'01'" ).append("\n"); 
		query.append(",	(SELECT FINC_RGN_CD FROM MDM_ORGANIZATION WHERE OFC_CD = @[COST_OFC_CD] AND NVL(DELT_FLG,'N') = 'N')" ).append("\n"); 
		query.append(",	(SELECT AP_CTR_CD 	FROM MDM_ORGANIZATION WHERE OFC_CD = @[COST_OFC_CD] AND NVL(DELT_FLG,'N') = 'N')" ).append("\n"); 
		query.append(",	@[ACCT_CD]" ).append("\n"); 
		query.append(",	'0000000000'" ).append("\n"); 
		query.append(",	(SELECT NVL(SUBS_CO_CD, '00') FROM MDM_VENDOR WHERE VNDR_SEQ = @[VNDR_SEQ])" ).append("\n"); 
		query.append(",	'000000'" ).append("\n"); 
		query.append(",	'000000'" ).append("\n"); 
		query.append(",	@[ACCT_CD]" ).append("\n"); 
		query.append(",	@[INV_NO]" ).append("\n"); 
		query.append(",	@[ISS_DT]" ).append("\n"); 
		query.append(",	@[LOC_CD]" ).append("\n"); 
		query.append(",	''" ).append("\n"); 
		query.append(",	''" ).append("\n"); 
		query.append(",	''" ).append("\n"); 
		query.append(",	''" ).append("\n"); 
		query.append(",	''" ).append("\n"); 
		query.append(",	''" ).append("\n"); 
		query.append(",	''" ).append("\n"); 
		query.append(",	''" ).append("\n"); 
		query.append(",	''" ).append("\n"); 
		query.append(",	''" ).append("\n"); 
		query.append(",	''" ).append("\n"); 
		query.append(",	''" ).append("\n"); 
		query.append(",	''" ).append("\n"); 
		query.append(",	''" ).append("\n"); 
		query.append(",	''" ).append("\n"); 
		query.append(",	'O'" ).append("\n"); 
		query.append(",	''" ).append("\n"); 
		query.append(",	''" ).append("\n"); 
		query.append(",	''" ).append("\n"); 
		query.append(",	''" ).append("\n"); 
		query.append(",	''" ).append("\n"); 
		query.append(",	''" ).append("\n"); 
		query.append(",	''" ).append("\n"); 
		query.append(",	SYSDATE" ).append("\n"); 
		query.append(",	@[CRE_USR_ID]" ).append("\n"); 
		query.append(",	SYSDATE" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}