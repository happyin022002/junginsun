/*=========================================================
*Copyright(c) 2018 CyberLogitec
*@FileName : PayableRentalCostDBDAOPayableChargeCreationMasterCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2018.05.24
*@LastModifier : 
*@LastVersion : 1.0
* 2018.05.24 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.lse.containerrentalcost.payablerentalcost.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PayableRentalCostDBDAOPayableChargeCreationMasterCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Payable Charge Creation Data Insert
	  * </pre>
	  */
	public PayableRentalCostDBDAOPayableChargeCreationMasterCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("chg_cost_yrmon",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.NUMERIC + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("chg_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.NUMERIC + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("agmt_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.lse.containerrentalcost.payablerentalcost.integration").append("\n"); 
		query.append("FileName : PayableRentalCostDBDAOPayableChargeCreationMasterCSQL").append("\n"); 
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
		query.append("INSERT INTO LSE_PAY_RNTL_CHG" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("         AGMT_CTY_CD" ).append("\n"); 
		query.append("       , AGMT_SEQ" ).append("\n"); 
		query.append("       , CHG_SEQ" ).append("\n"); 
		query.append("       , CHG_COST_YRMON" ).append("\n"); 
		query.append("       , VNDR_SEQ" ).append("\n"); 
		query.append("       , PAY_LR_CD" ).append("\n"); 
		query.append("       , LSTM_CD" ).append("\n"); 
		query.append("       , AGMT_REF_NO" ).append("\n"); 
		query.append("       , CURR_CD" ).append("\n"); 
		query.append("       , TTL_COST_AMT" ).append("\n"); 
		query.append("       , CR_TTL_AMT" ).append("\n"); 
		query.append("       , PAY_RNTL_COST_AMT" ).append("\n"); 
		query.append("       , SO_ISS_COST_AMT" ).append("\n"); 
		query.append("       , CRE_OFC_CD" ).append("\n"); 
		query.append("       , LSE_PAY_RNTL_STS_CD" ).append("\n"); 
		query.append("       , EFF_DT" ).append("\n"); 
		query.append("       , EXP_DT" ).append("\n"); 
		query.append("       , CONV_COST_AMT" ).append("\n"); 
		query.append("       , CONV_RT_AMT" ).append("\n"); 
		query.append("       , CONV_CR_COST_AMT" ).append("\n"); 
		query.append("       , CONV_TAX_AMT" ).append("\n"); 
		query.append("       , CRE_USR_ID" ).append("\n"); 
		query.append("       , CRE_DT" ).append("\n"); 
		query.append("       , UPD_USR_ID" ).append("\n"); 
		query.append("       , UPD_DT" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("SELECT   BB.AGMT_CTY_CD" ).append("\n"); 
		query.append("       , BB.AGMT_SEQ" ).append("\n"); 
		query.append("       , @[chg_seq]" ).append("\n"); 
		query.append("       , @[chg_cost_yrmon]" ).append("\n"); 
		query.append("       , BB.VNDR_SEQ" ).append("\n"); 
		query.append("       , SUBSTR(CC.VNDR_ABBR_NM, 0, 3) AS PAY_LR_CD" ).append("\n"); 
		query.append("       , BB.LSTM_CD" ).append("\n"); 
		query.append("       , BB.REF_NO AS AGMT_REF_NO" ).append("\n"); 
		query.append("       , BB.CURR_CD" ).append("\n"); 
		query.append("       , 0 AS TTL_COST_AMT" ).append("\n"); 
		query.append("       , 0 AS CR_TTL_AMT" ).append("\n"); 
		query.append("       , 0 AS PAY_RNTL_COST_AMT" ).append("\n"); 
		query.append("       , 0 AS SO_ISS_COST_AMT" ).append("\n"); 
		query.append("       , @[cre_ofc_cd]" ).append("\n"); 
		query.append("       , 'H'" ).append("\n"); 
		query.append("       , DD.EFF_DT" ).append("\n"); 
		query.append("       , BB.LST_EXP_DT" ).append("\n"); 
		query.append("       , 0 AS CONV_COST_AMT" ).append("\n"); 
		query.append("       , 0 AS CONV_RT_AMT" ).append("\n"); 
		query.append("       , 0 AS CONV_CR_COST_AMT" ).append("\n"); 
		query.append("       , 0 AS CONV_TAX_AMT" ).append("\n"); 
		query.append("       , @[usr_id]" ).append("\n"); 
		query.append("       , SYSDATE" ).append("\n"); 
		query.append("       , @[usr_id]" ).append("\n"); 
		query.append("       , SYSDATE" ).append("\n"); 
		query.append("FROM     LSE_AGREEMENT  BB" ).append("\n"); 
		query.append("       , MDM_VENDOR     CC" ).append("\n"); 
		query.append("       , LSE_AGMT_VER   DD" ).append("\n"); 
		query.append("WHERE    DD.AGMT_VER_SEQ = 1" ).append("\n"); 
		query.append("AND      DD.AGMT_CTY_CD  = BB.AGMT_CTY_CD" ).append("\n"); 
		query.append("AND      DD.AGMT_SEQ     = BB.AGMT_SEQ" ).append("\n"); 
		query.append("AND      CC.VNDR_SEQ     = BB.VNDR_SEQ" ).append("\n"); 
		query.append("AND      BB.AGMT_CTY_CD  = @[agmt_cty_cd]" ).append("\n"); 
		query.append("AND      BB.AGMT_SEQ     = @[agmt_seq]" ).append("\n"); 

	}
}