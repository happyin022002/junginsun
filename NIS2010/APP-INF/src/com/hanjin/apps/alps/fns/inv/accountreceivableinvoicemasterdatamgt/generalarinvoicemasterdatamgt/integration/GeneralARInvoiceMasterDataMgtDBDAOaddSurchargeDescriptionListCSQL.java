/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : GeneralARInvoiceMasterDataMgtDBDAOaddSurchargeDescriptionListCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.05.21
*@LastModifier : 
*@LastVersion : 1.0
* 2013.05.21 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemasterdatamgt.generalarinvoicemasterdatamgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class GeneralARInvoiceMasterDataMgtDBDAOaddSurchargeDescriptionListCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * addSurchargeDescriptionList
	  * </pre>
	  */
	public GeneralARInvoiceMasterDataMgtDBDAOaddSurchargeDescriptionListCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("chg_desc_conv_ctnt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ar_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("chg_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemasterdatamgt.generalarinvoicemasterdatamgt.integration").append("\n"); 
		query.append("FileName : GeneralARInvoiceMasterDataMgtDBDAOaddSurchargeDescriptionListCSQL").append("\n"); 
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
		query.append("INSERT INTO INV_CHG_DESC_CONV " ).append("\n"); 
		query.append("( AR_OFC_CD," ).append("\n"); 
		query.append("  CHG_CD," ).append("\n"); 
		query.append("  CHG_SEQ," ).append("\n"); 
		query.append("  CHG_DESC_CONV_CTNT," ).append("\n"); 
		query.append("  DELT_FLG," ).append("\n"); 
		query.append("  CRE_USR_ID," ).append("\n"); 
		query.append("  CRE_DT," ).append("\n"); 
		query.append("  UPD_USR_ID," ).append("\n"); 
		query.append("  UPD_DT )" ).append("\n"); 
		query.append("VALUES " ).append("\n"); 
		query.append("( @[ar_ofc_cd]," ).append("\n"); 
		query.append("  @[chg_cd]," ).append("\n"); 
		query.append("  NVL((SELECT MAX(CHG_SEQ) + 1 FROM INV_CHG_DESC_CONV WHERE AR_OFC_CD = @[ar_ofc_cd] AND CHG_CD = @[chg_cd]),1)," ).append("\n"); 
		query.append("  SUBSTR(@[chg_desc_conv_ctnt],0,100)," ).append("\n"); 
		query.append("  'N'," ).append("\n"); 
		query.append("  @[cre_usr_id]," ).append("\n"); 
		query.append("  SYSDATE," ).append("\n"); 
		query.append("  @[upd_usr_id]," ).append("\n"); 
		query.append("  SYSDATE )" ).append("\n"); 

	}
}