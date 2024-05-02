/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : ReceivableRentalCostDBDAOsearchReceivableRentalChargeSeqbyManualDataRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.05.11
*@LastModifier : 이주현
*@LastVersion : 1.0
* 2016.05.11 이주현
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.lse.containerrentalcost.receivablerentalcost.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author LEE JU HYUN
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ReceivableRentalCostDBDAOsearchReceivableRentalChargeSeqbyManualDataRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchReceivableRentalChargeSeqbyManualData
	  * </pre>
	  */
	public ReceivableRentalCostDBDAOsearchReceivableRentalChargeSeqbyManualDataRSQL(){
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
		params.put("ref_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
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
		query.append("FileName : ReceivableRentalCostDBDAOsearchReceivableRentalChargeSeqbyManualDataRSQL").append("\n"); 
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
		query.append("SELECT  CHG.RCV_RNTL_SEQ" ).append("\n"); 
		query.append("FROM    LSE_RCV_RNTL_CHG CHG" ).append("\n"); 
		query.append("    , (SELECT  @[cost_yrmon]     AS COST_YRMON, " ).append("\n"); 
		query.append("	            @[agmt_cty_cd]    AS AGMT_CTY_CD,    " ).append("\n"); 
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
		query.append("WHERE CHG.COST_YRMON  = P.COST_YRMON " ).append("\n"); 
		query.append("AND   CHG.AGMT_CTY_CD = P.AGMT_CTY_CD" ).append("\n"); 
		query.append("AND   CHG.AGMT_SEQ    = P.AGMT_SEQ" ).append("\n"); 
		query.append("AND   ROWNUM          = 1" ).append("\n"); 

	}
}