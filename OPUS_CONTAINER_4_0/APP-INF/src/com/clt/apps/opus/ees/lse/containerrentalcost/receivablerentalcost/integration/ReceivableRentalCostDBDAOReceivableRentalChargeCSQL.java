/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : ReceivableRentalCostDBDAOReceivableRentalChargeCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.10.19
*@LastModifier : 
*@LastVersion : 1.0
* 2015.10.19 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.lse.containerrentalcost.receivablerentalcost.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ReceivableRentalCostDBDAOReceivableRentalChargeCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 계약번호별 Receivable Rental Charge Creation 자료를 생성합니다.
	  * </pre>
	  */
	public ReceivableRentalCostDBDAOReceivableRentalChargeCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eff_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("exp_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.NUMERIC + ",N";
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
		params.put("ref_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.NUMERIC + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("agmt_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("qty_yrmon",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("lstm_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cost_yrmon",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vndr_abbr_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("agmt_cty_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.lse.containerrentalcost.receivablerentalcost.integration").append("\n"); 
		query.append("FileName : ReceivableRentalCostDBDAOReceivableRentalChargeCSQL").append("\n"); 
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
		query.append("INSERT INTO LSE_RCV_RNTL_CHG (" ).append("\n"); 
		query.append("    COST_YRMON, AGMT_CTY_CD, AGMT_SEQ, " ).append("\n"); 
		query.append("    RCV_RNTL_SEQ, QTY_YRMON, VNDR_SEQ, " ).append("\n"); 
		query.append("    VNDR_ABBR_NM, LSTM_CD, " ).append("\n"); 
		query.append("    CURR_CD, LSE_CNTR_CHG_STS_CD, " ).append("\n"); 
		query.append("	REF_NO, RGST_OFC_CD, EFF_DT, EXP_DT, " ).append("\n"); 
		query.append("    CRE_USR_ID, CRE_DT, UPD_USR_ID, UPD_DT," ).append("\n"); 
		query.append("    RCV_AMT_BAL_CD, CXL_FLG, AUTO_INP_FLG, INV_TAX_RT" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("SELECT  P.COST_YRMON, P.AGMT_CTY_CD, P.AGMT_SEQ,         " ).append("\n"); 
		query.append("       (SELECT  NVL(MAX(RCV_RNTL_SEQ), 0) +1" ).append("\n"); 
		query.append("        FROM    LSE_RCV_RNTL_CHG" ).append("\n"); 
		query.append("        WHERE   COST_YRMON  = P.COST_YRMON),       " ).append("\n"); 
		query.append("        P.QTY_YRMON, P.VNDR_SEQ, P.VNDR_ABBR_NM, P.LSTM_CD," ).append("\n"); 
		query.append("        'USD', 'C', P.REF_NO, P.OFC_CD,  " ).append("\n"); 
		query.append("		TO_DATE(P.EFF_DT, 'YYYYMMDD'), " ).append("\n"); 
		query.append("		TO_DATE(P.EXP_DT, 'YYYYMMDD'), 		" ).append("\n"); 
		query.append("        P.CRE_USR_ID, SYSDATE, P.CRE_USR_ID, SYSDATE," ).append("\n"); 
		query.append("		'N','N','N',0" ).append("\n"); 
		query.append("FROM   (SELECT  @[cost_yrmon]     AS COST_YRMON, " ).append("\n"); 
		query.append("	            @[agmt_cty_cd]    AS AGMT_CTY_CD,   " ).append("\n"); 
		query.append("    	        @[agmt_seq]       AS AGMT_SEQ," ).append("\n"); 
		query.append("        	    @[qty_yrmon]      AS QTY_YRMON," ).append("\n"); 
		query.append("	            @[vndr_seq]       AS VNDR_SEQ," ).append("\n"); 
		query.append("    	        @[vndr_abbr_nm]   AS VNDR_ABBR_NM," ).append("\n"); 
		query.append("        	    @[lstm_cd]        AS LSTM_CD," ).append("\n"); 
		query.append("	            @[eff_dt]         AS EFF_DT," ).append("\n"); 
		query.append("    	        @[exp_dt]         AS EXP_DT," ).append("\n"); 
		query.append("        	    @[ref_no]         AS REF_NO,  " ).append("\n"); 
		query.append("	            @[ofc_cd]         AS OFC_CD, " ).append("\n"); 
		query.append("    	        @[cre_usr_id]     AS CRE_USR_ID    " ).append("\n"); 
		query.append("	    FROM    DUAL) P" ).append("\n"); 

	}
}