/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : AccountReceivableCollectIFDBDAOmodifyHoldingStatusUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.05.17
*@LastModifier : 
*@LastVersion : 1.0
* 2016.05.17 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.stm.sar.accountreceivablecollect.accountreceivablecollectif.intergration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AccountReceivableCollectIFDBDAOmodifyHoldingStatusUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * modifyHoldingStatus
	  * </pre>
	  */
	public AccountReceivableCollectIFDBDAOmodifyHoldingStatusUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("if_seq_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.stm.sar.accountreceivablecollect.accountreceivablecollectif.intergration").append("\n"); 
		query.append("FileName : AccountReceivableCollectIFDBDAOmodifyHoldingStatusUSQL").append("\n"); 
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
		query.append("UPDATE SAR_AR_IF" ).append("\n"); 
		query.append("SET IF_FLG = 'H'" ).append("\n"); 
		query.append("WHERE IF_SEQ_NO = @[if_seq_no] " ).append("\n"); 
		query.append("AND ( ( LOCL_AMT + DOC_AMT = 0  )" ).append("\n"); 
		query.append("  OR (REC_TP_CD,ASGN_NO,NVL(COST_CTR_CD,' ') ,NVL(GL_ACCT_NO,' '),NVL(CUST_NO,' '),NVL(PFITCTR_CD,' '),NVL(ALTN_ACCT_NO,' '),NVL(BIZ_PRNR_REF_KEY_CD1,' '), NVL(PLN_DT,' ')) " ).append("\n"); 
		query.append("    IN (" ).append("\n"); 
		query.append("        SELECT  MAX(REC_TP_CD), MAX(ASGN_NO), MAX(NVL(COST_CTR_CD,' ')) ,MAX(NVL(GL_ACCT_NO,' ')),MAX(NVL(CUST_NO,' ')),MAX(NVL(PFITCTR_CD,' ')), MAX(NVL(ALTN_ACCT_NO,' ')),MAX(NVL(BIZ_PRNR_REF_KEY_CD1,' ')), MAX(NVL(PLN_DT,' '))" ).append("\n"); 
		query.append("        FROM SAR_AR_IF A" ).append("\n"); 
		query.append("        WHERE IF_SEQ_NO = @[if_seq_no]" ).append("\n"); 
		query.append("        GROUP BY " ).append("\n"); 
		query.append("        ACCT_CO_CD, " ).append("\n"); 
		query.append("        IF_DOC_TP_CD," ).append("\n"); 
		query.append("        DOC_DT," ).append("\n"); 
		query.append("        PST_DT," ).append("\n"); 
		query.append("        REF_DOC_NO," ).append("\n"); 
		query.append("        DOC_HDR_CD," ).append("\n"); 
		query.append("        CURR_CD," ).append("\n"); 
		query.append("        TAX_CALC_AUTO_FLG," ).append("\n"); 
		query.append("        VAT_TAX_CD," ).append("\n"); 
		query.append("        ASGN_NO," ).append("\n"); 
		query.append("        ITM_DESC," ).append("\n"); 
		query.append("        PLN_DT," ).append("\n"); 
		query.append("        COST_CTR_CD," ).append("\n"); 
		query.append("        ORD_NO," ).append("\n"); 
		query.append("        MN_ASET_NO," ).append("\n"); 
		query.append("        SUB_ASET_NO," ).append("\n"); 
		query.append("        ASET_TJ_TP_CD," ).append("\n"); 
		query.append("        ASET_VAL_DT," ).append("\n"); 
		query.append("        GL_ACCT_NO," ).append("\n"); 
		query.append("        CUST_NO," ).append("\n"); 
		query.append("        VNDR_CRTR_ACCT_NO," ).append("\n"); 
		query.append("        DUE_DT_CALC_BSEL_DT," ).append("\n"); 
		query.append("        PAY_MZD_CD," ).append("\n"); 
		query.append("        STE_CNTRL_BANK_IND_CD," ).append("\n"); 
		query.append("        MTRL_NO," ).append("\n"); 
		query.append("        FUEL_LAND_QTY," ).append("\n"); 
		query.append("        MEAS_BSE_UT_CD," ).append("\n"); 
		query.append("        PFITCTR_CD," ).append("\n"); 
		query.append("        ALTN_ACCT_NO," ).append("\n"); 
		query.append("        BIZ_PRNR_REF_KEY_CD1," ).append("\n"); 
		query.append("        BIZ_PRNR_REF_KEY_CD2," ).append("\n"); 
		query.append("        LINE_ITM_REF_KEY_CD," ).append("\n"); 
		query.append("        INSTR_KEY_CD1," ).append("\n"); 
		query.append("        INSTR_KEY_CD2," ).append("\n"); 
		query.append("        INSTR_KEY_CD3," ).append("\n"); 
		query.append("        PAY_REF_CD," ).append("\n"); 
		query.append("        AUTOMTC_PAY_CURR_CD," ).append("\n"); 
		query.append("        PAY_CURR_AMT," ).append("\n"); 
		query.append("        CTRT_NO," ).append("\n"); 
		query.append("        CTRT_TP_CD," ).append("\n"); 
		query.append("        PAY_RSN_CD," ).append("\n"); 
		query.append("        CLSS_CD," ).append("\n"); 
		query.append("        ACT_PLC_CD," ).append("\n"); 
		query.append("        ENTR_EXPN_ID," ).append("\n"); 
		query.append("        BUD_MGMT_DIV_CD," ).append("\n"); 
		query.append("        ACT_DT," ).append("\n"); 
		query.append("        VSL_CD," ).append("\n"); 
		query.append("        VVL_CD," ).append("\n"); 
		query.append("        HUS_BANK_ID," ).append("\n"); 
		query.append("        PAY_BLCK_KEY_CD," ).append("\n"); 
		query.append("        REC_TP_CD" ).append("\n"); 
		query.append("        HAVING (SUM(DECODE(PST_KEY_CD,'01',NVL(LOCL_AMT,0),40,NVL(LOCL_AMT,0),11,NVL(LOCL_AMT,0)*(-1), 50,NVL(LOCL_AMT,0)*(-1)))=0)" ).append("\n"); 
		query.append("                AND (SUM(DECODE(PST_KEY_CD,'01',NVL(DOC_AMT,0),40,NVL(DOC_AMT,0),11,NVL(DOC_AMT,0)*(-1), 50,NVL(DOC_AMT,0)*(-1)))=0)" ).append("\n"); 
		query.append("                AND COUNT(*)>=2" ).append("\n"); 
		query.append("        )" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}