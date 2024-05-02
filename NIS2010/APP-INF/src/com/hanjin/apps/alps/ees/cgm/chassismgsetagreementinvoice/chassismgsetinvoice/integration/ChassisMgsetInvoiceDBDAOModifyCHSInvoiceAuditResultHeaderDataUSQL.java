/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : ChassisMgsetInvoiceDBDAOModifyCHSInvoiceAuditResultHeaderDataUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.03.24
*@LastModifier : 
*@LastVersion : 1.0
* 2014.03.24 
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

public class ChassisMgsetInvoiceDBDAOModifyCHSInvoiceAuditResultHeaderDataUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ChassisMgsetInvoiceDB.ModifyCHSInvoiceAuditResultHeaderData
	  * </pre>
	  */
	public ChassisMgsetInvoiceDBDAOModifyCHSInvoiceAuditResultHeaderDataUSQL(){
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
		params.put("agmt_ofc_cty_cd",new String[]{arrTmp[0],arrTmp[1]});

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

		tmp = java.sql.Types.NUMERIC + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("chg_cre_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cost_yrmon",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.cgm.chassismgsetagreementinvoice.chassismgsetinvoice.integration").append("\n"); 
		query.append("FileName : ChassisMgsetInvoiceDBDAOModifyCHSInvoiceAuditResultHeaderDataUSQL").append("\n"); 
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
		query.append("UPDATE  CGM_LSE_CHG_HDR T" ).append("\n"); 
		query.append("SET" ).append("\n"); 
		query.append("	(INV_SMRY_AMT, CR_SMRY_AMT, TAX_SMRY_AMT) =" ).append("\n"); 
		query.append("	(" ).append("\n"); 
		query.append("	   SELECT " ).append("\n"); 
		query.append("	       NVL(SUM(INV_LSE_CHG_AMT),0) + NVL(SUM(INV_TAX_AMT),0) - ABS(NVL(SUM(INV_CR_AMT),0))," ).append("\n"); 
		query.append("	       NVL(SUM(INV_CR_AMT),0)," ).append("\n"); 
		query.append("           NVL(SUM(INV_TAX_AMT),0)" ).append("\n"); 
		query.append("	   FROM " ).append("\n"); 
		query.append("	       CGM_LSE_CHG_DTL" ).append("\n"); 
		query.append("	   WHERE " ).append("\n"); 
		query.append("	       EQ_KND_CD = T.EQ_KND_CD" ).append("\n"); 
		query.append("	       AND COST_YRMON = T.COST_YRMON" ).append("\n"); 
		query.append("	       AND AGMT_OFC_CTY_CD = T.AGMT_OFC_CTY_CD" ).append("\n"); 
		query.append("	       AND AGMT_SEQ = T.AGMT_SEQ" ).append("\n"); 
		query.append("	 )" ).append("\n"); 
		query.append("WHERE" ).append("\n"); 
		query.append("	COST_YRMON = @[cost_yrmon]" ).append("\n"); 
		query.append("	AND EQ_KND_CD = @[eq_knd_cd]" ).append("\n"); 
		query.append("	AND CHG_CRE_SEQ = @[chg_cre_seq]" ).append("\n"); 
		query.append("	AND AGMT_OFC_CTY_CD = @[agmt_ofc_cty_cd]" ).append("\n"); 
		query.append("	AND AGMT_SEQ = @[agmt_seq]" ).append("\n"); 
		query.append("    AND AGMT_VER_NO = @[agmt_ver_no]       -- ADD YONGCHAN SHIN, 20140324" ).append("\n"); 
		query.append("    AND COST_YRMON_SEQ = @[cost_yrmon_seq] -- ADD YONGCHAN SHIN, 20140324" ).append("\n"); 

	}
}