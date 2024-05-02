/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : ReceivableRentalCostDBDAOReceivableInvoiceCostCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.03.24
*@LastModifier : 장준우
*@LastVersion : 1.0
* 2010.03.24 장준우
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.lse.containerrentalcost.receivablerentalcost.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Jang Jun-Woo
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ReceivableRentalCostDBDAOReceivableInvoiceCostCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Receivable Rental Invoice Cost 내역을 등록합니다.
	  * </pre>
	  */
	public ReceivableRentalCostDBDAOReceivableInvoiceCostCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.FLOAT + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cr_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.NUMERIC + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bil_dys",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("offh_loc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("onh_loc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_tpsz_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("offh_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("agmt_cty_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("onh_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.NUMERIC + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("free_dys",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("lse_rcv_chg_cre_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("lse_rcv_chg_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_no",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.FLOAT + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cost_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.NUMERIC + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rcv_rntl_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.lse.containerrentalcost.receivablerentalcost.integration").append("\n"); 
		query.append("FileName : ReceivableRentalCostDBDAOReceivableInvoiceCostCSQL").append("\n"); 
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
		query.append("INSERT INTO LSE_RCV_RNTL_CHG_DTL (" ).append("\n"); 
		query.append("    COST_YRMON, AGMT_CTY_CD, AGMT_SEQ, " ).append("\n"); 
		query.append("    RCV_RNTL_SEQ, RCV_RNTL_DTL_SEQ, LSTM_CD, " ).append("\n"); 
		query.append("    CNTR_NO, CNTR_TPSZ_CD, LSE_RCV_CHG_TP_CD," ).append("\n"); 
		query.append("    ONH_DT, ONH_LOC_CD, OFFH_DT, OFFH_LOC_CD, " ).append("\n"); 
		query.append("    BIL_FM_DT, BIL_TO_DT," ).append("\n"); 
		query.append("    TTL_DYS, FREE_DYS, BIL_DYS, CHG_RT_AMT, " ).append("\n"); 
		query.append("    COST_AMT, CR_AMT, LSE_RCV_CHG_CRE_CD, AUTO_INP_FLG," ).append("\n"); 
		query.append("    RGST_OFC_CD, RGST_USR_ID, RGST_DT, " ).append("\n"); 
		query.append("    CRE_USR_ID, CRE_DT, UPD_USR_ID, UPD_DT    " ).append("\n"); 
		query.append(") " ).append("\n"); 
		query.append("SELECT  P.COST_YRMON, P.AGMT_CTY_CD, P.AGMT_SEQ, P.RCV_RNTL_SEQ," ).append("\n"); 
		query.append("       (SELECT  NVL(MAX(RCV_RNTL_DTL_SEQ), 0) +1" ).append("\n"); 
		query.append("        FROM    LSE_RCV_RNTL_CHG_DTL" ).append("\n"); 
		query.append("        WHERE   COST_YRMON  = P.COST_YRMON" ).append("\n"); 
		query.append("        AND     AGMT_CTY_CD = P.AGMT_CTY_CD" ).append("\n"); 
		query.append("        AND     AGMT_SEQ    = P.AGMT_SEQ" ).append("\n"); 
		query.append("        AND     RCV_RNTL_SEQ = P.RCV_RNTL_SEQ) AS RCV_RNTL_DTL_SEQ," ).append("\n"); 
		query.append("        P.LSTM_CD, P.CNTR_NO, NVL(P.CNTR_TPSZ_CD, 'BX') AS CNTR_TPSZ_CD, " ).append("\n"); 
		query.append("		P.LSE_RCV_CHG_TP_CD," ).append("\n"); 
		query.append("        TO_DATE(P.ONH_DT, 'YYYYMMDD') AS ONH_DT, P.ONH_LOC_CD, " ).append("\n"); 
		query.append("        TO_DATE(P.OFFH_DT,'YYYYMMDD') AS OFFH_DT, P.OFFH_LOC_CD, " ).append("\n"); 
		query.append("        ADD_MONTHS(TO_DATE(P.COST_YRMON,'RRRRMM'), -1) AS BIL_FM_DT," ).append("\n"); 
		query.append("        LAST_DAY(ADD_MONTHS(TO_DATE(P.COST_YRMON,'RRRRMM'), -1)) AS BIL_TO_DT," ).append("\n"); 
		query.append("        0 TTL_DYS, P.FREE_DYS, P.BIL_DYS, P.COST_AMT AS CHG_RT_AMT, " ).append("\n"); 
		query.append("        P.COST_AMT, P.CR_AMT, P.LSE_RCV_CHG_CRE_CD, 'N' AS AUTO_INP_FLG," ).append("\n"); 
		query.append("        P.OFC_CD AS RGST_OFC_CD, P.CRE_USR_ID AS RGST_USR_ID, SYSDATE AS RGST_DT, " ).append("\n"); 
		query.append("        P.CRE_USR_ID AS CRE_USR_ID, SYSDATE AS CRE_DT, " ).append("\n"); 
		query.append("        P.CRE_USR_ID AS UPD_USR_ID, SYSDATE AS UPD_DT     " ).append("\n"); 
		query.append("FROM   (SELECT  @[cost_yrmon]     AS COST_YRMON, " ).append("\n"); 
		query.append("            	@[agmt_cty_cd]    AS AGMT_CTY_CD,   " ).append("\n"); 
		query.append("	            @[agmt_seq]       AS AGMT_SEQ, " ).append("\n"); 
		query.append("    	        @[rcv_rntl_seq]   AS RCV_RNTL_SEQ," ).append("\n"); 
		query.append("        	    @[lstm_cd]        AS LSTM_CD, " ).append("\n"); 
		query.append("	            @[cntr_no]        AS CNTR_NO, " ).append("\n"); 
		query.append("    	        @[cntr_tpsz_cd]   AS CNTR_TPSZ_CD, " ).append("\n"); 
		query.append("        	    @[lse_rcv_chg_tp_cd] AS LSE_RCV_CHG_TP_CD," ).append("\n"); 
		query.append("	            @[onh_dt]         AS ONH_DT, " ).append("\n"); 
		query.append("    	        @[onh_loc_cd]     AS ONH_LOC_CD, " ).append("\n"); 
		query.append("        	    @[offh_dt]        AS OFFH_DT, " ).append("\n"); 
		query.append("	            @[offh_loc_cd]    AS OFFH_LOC_CD," ).append("\n"); 
		query.append("    	        @[free_dys]       AS FREE_DYS, " ).append("\n"); 
		query.append("        	    @[bil_dys]        AS BIL_DYS, " ).append("\n"); 
		query.append("	            @[cost_amt]       AS COST_AMT," ).append("\n"); 
		query.append("    	        @[cr_amt]         AS CR_AMT," ).append("\n"); 
		query.append("				@[lse_rcv_chg_cre_cd] AS LSE_RCV_CHG_CRE_CD," ).append("\n"); 
		query.append("	            @[ofc_cd]         AS OFC_CD, " ).append("\n"); 
		query.append("    	        @[cre_usr_id]     AS CRE_USR_ID    " ).append("\n"); 
		query.append("	    FROM    DUAL) P" ).append("\n"); 

	}
}