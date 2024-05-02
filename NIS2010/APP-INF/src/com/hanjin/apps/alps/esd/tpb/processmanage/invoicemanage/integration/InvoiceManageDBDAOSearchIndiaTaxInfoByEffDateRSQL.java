/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : InvoiceManageDBDAOSearchIndiaTaxInfoByEffDateRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.05.18
*@LastModifier : 
*@LastVersion : 1.0
* 2016.05.18 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.tpb.processmanage.invoicemanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class InvoiceManageDBDAOSearchIndiaTaxInfoByEffDateRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchIndiaTaxInfoByEffDate
	  * </pre>
	  */
	public InvoiceManageDBDAOSearchIndiaTaxInfoByEffDateRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("user_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_eff_dt",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.tpb.processmanage.invoicemanage.integration").append("\n"); 
		query.append("FileName : InvoiceManageDBDAOSearchIndiaTaxInfoByEffDateRSQL").append("\n"); 
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
		query.append("SELECT ida_tax_seq" ).append("\n"); 
		query.append("	  ,ofc_cd" ).append("\n"); 
		query.append("	  ,TO_CHAR(TPB_GET_LCL_DATE_FNC(eff_dt,@[user_ofc_cd]),'YYYY-MM-DD HH24:MI') eff_dt" ).append("\n"); 
		query.append("	  ,expn_tax" ).append("\n"); 
		query.append("	  ,edu_tax" ).append("\n"); 
		query.append("	  ,high_edu_tax" ).append("\n"); 
		query.append("	  ,tax_rgst_no" ).append("\n"); 
		query.append("	  ,svc_cate_rmk" ).append("\n"); 
		query.append("      ,pmnt_acct_no" ).append("\n"); 
		query.append("	  ,cre_usr_id" ).append("\n"); 
		query.append("	  ,TO_CHAR(TPB_GET_LCL_DATE_FNC(cre_dt,@[user_ofc_cd]),'YYYY-MM-DD HH24:MI') cre_dt" ).append("\n"); 
		query.append("	  ,upd_usr_id" ).append("\n"); 
		query.append("	  ,TO_CHAR(TPB_GET_LCL_DATE_FNC(upd_dt,@[user_ofc_cd]),'YYYY-MM-DD HH24:MI') upd_dt" ).append("\n"); 
		query.append("	  ,(SELECT COUNT(0) FROM TPB_INV_RVIS WHERE ida_tax_seq=a.ida_tax_seq) editable" ).append("\n"); 
		query.append("      ,locl_tax_rt" ).append("\n"); 
		query.append("      ,n2nd_locl_tax_rt" ).append("\n"); 
		query.append("  FROM TPB_IDA_TAX a" ).append("\n"); 
		query.append(" WHERE 1 = 1" ).append("\n"); 
		query.append("#if (${s_eff_dt} != '') " ).append("\n"); 
		query.append("   AND eff_dt IN (  SELECT MAX(eff_dt) eff_dt" ).append("\n"); 
		query.append("                      FROM TPB_IDA_TAX " ).append("\n"); 
		query.append("                     WHERE 1 = 1" ).append("\n"); 
		query.append("    #if (${s_ofc_cd} != '') " ).append("\n"); 
		query.append("                       AND ofc_cd = @[s_ofc_cd]" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("                       AND eff_dt <= TO_DATE(@[s_eff_dt],'YYYY-MM-DD') + (3.5/24)" ).append("\n"); 
		query.append("                       AND (delt_flg != 'Y' OR delt_flg IS NULL)" ).append("\n"); 
		query.append("                  GROUP BY OFC_CD" ).append("\n"); 
		query.append("                  )" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("   AND (delt_flg != 'Y' OR delt_flg IS NULL)" ).append("\n"); 

	}
}