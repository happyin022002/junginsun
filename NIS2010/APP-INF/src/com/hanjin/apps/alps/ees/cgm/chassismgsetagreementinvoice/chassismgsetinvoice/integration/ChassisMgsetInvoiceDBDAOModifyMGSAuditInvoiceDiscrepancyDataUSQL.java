/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : ChassisMgsetInvoiceDBDAOModifyMGSAuditInvoiceDiscrepancyDataUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.05.08
*@LastModifier : 
*@LastVersion : 1.0
* 2014.05.08 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.cgm.chassismgsetagreementinvoice.chassismgsetinvoice.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ChassisMgsetInvoiceDBDAOModifyMGSAuditInvoiceDiscrepancyDataUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ChassisMgsetInvoiceDB.ModifyMGSAuditInvoiceDiscrepancyData
	  * </pre>
	  */
	public ChassisMgsetInvoiceDBDAOModifyMGSAuditInvoiceDiscrepancyDataUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("agmt_ver_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cost_yrmon_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pay_chg_aud_rmk",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("agmt_ofc_cty_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("chg_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eq_knd_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("chg_seq",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("eq_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.cgm.chassismgsetagreementinvoice.chassismgsetinvoice.integration").append("\n"); 
		query.append("FileName : ChassisMgsetInvoiceDBDAOModifyMGSAuditInvoiceDiscrepancyDataUSQL").append("\n"); 
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
		query.append("UPDATE CGM_LSE_CHG_DTL" ).append("\n"); 
		query.append("SET" ).append("\n"); 
		query.append("	PAY_LSE_CHG_STS_CD = 'D'," ).append("\n"); 
		query.append("	PAY_CHG_AUD_RMK = @[pay_chg_aud_rmk]" ).append("\n"); 
		query.append("WHERE" ).append("\n"); 
		query.append("	AGMT_OFC_CTY_CD = @[agmt_ofc_cty_cd]" ).append("\n"); 
		query.append("	AND AGMT_SEQ = @[agmt_seq]" ).append("\n"); 
		query.append("    AND AGMT_VER_NO = @[agmt_ver_no]  -- ADD YONGCHAN SHIN, 20140508" ).append("\n"); 
		query.append("	AND COST_YRMON = @[cost_yrmon]" ).append("\n"); 
		query.append("	AND EQ_NO = @[eq_no]	" ).append("\n"); 
		query.append("	AND CHG_CD = @[chg_cd]" ).append("\n"); 
		query.append("	AND CHG_SEQ = @[chg_seq]" ).append("\n"); 
		query.append("	AND EQ_KND_CD = @[eq_knd_cd]" ).append("\n"); 
		query.append("    AND COST_YRMON_SEQ = @[cost_yrmon_seq] -- ADD YONGCHAN SHIN, 20140508" ).append("\n"); 

	}
}