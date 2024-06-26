/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : ChassisMgsetInvoiceDBDAOModifyCHSPayableInvoiceSeqDataUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.03.25
*@LastModifier : 
*@LastVersion : 1.0
* 2014.03.25 
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

public class ChassisMgsetInvoiceDBDAOModifyCHSPayableInvoiceSeqDataUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ChassisMgsetInvoiceDB.ModifyCHSPayableInvoiceSeqData
	  * </pre>
	  */
	public ChassisMgsetInvoiceDBDAOModifyCHSPayableInvoiceSeqDataUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("parent_cost_yrmon_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("upd_usr_id",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("chg_cre_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cost_yrmon",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.cgm.chassismgsetagreementinvoice.chassismgsetinvoice.integration").append("\n"); 
		query.append("FileName : ChassisMgsetInvoiceDBDAOModifyCHSPayableInvoiceSeqDataUSQL").append("\n"); 
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
		query.append("UPDATE CGM_LSE_CHG_DTL T" ).append("\n"); 
		query.append("SET" ).append("\n"); 
		query.append("	PAY_INV_SEQ = (SELECT PAY_INV_SEQ " ).append("\n"); 
		query.append("				   FROM CGM_PAY_INV" ).append("\n"); 
		query.append("                   WHERE COST_YRMON = @[cost_yrmon]" ).append("\n"); 
		query.append("					     AND CHG_CRE_SEQ = @[chg_cre_seq]" ).append("\n"); 
		query.append("				         AND INV_NO = T.INV_NO)," ).append("\n"); 
		query.append("	UPD_USR_ID = @[upd_usr_id]," ).append("\n"); 
		query.append("	UPD_DT = SYSDATE" ).append("\n"); 
		query.append("WHERE" ).append("\n"); 
		query.append("	COST_YRMON = @[cost_yrmon]" ).append("\n"); 
		query.append("	AND EQ_KND_CD = @[eq_knd_cd]" ).append("\n"); 
		query.append("    AND (AGMT_OFC_CTY_CD,AGMT_SEQ) IN (" ).append("\n"); 
		query.append("     				SELECT AGMT_OFC_CTY_CD,AGMT_SEQ" ).append("\n"); 
		query.append("				    FROM CGM_LSE_CHG_HDR" ).append("\n"); 
		query.append("                    WHERE COST_YRMON = @[cost_yrmon]" ).append("\n"); 
		query.append("					     AND CHG_CRE_SEQ = @[chg_cre_seq]" ).append("\n"); 
		query.append("					)" ).append("\n"); 
		query.append("    AND COST_YRMON_SEQ = @[parent_cost_yrmon_seq] -- ADD YONGCHAN SHIN, 20140324" ).append("\n"); 

	}
}