/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : GeneralARInvoiceMasterDataMgtDBDAOsearchSurchargeDescriptionListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.05.28
*@LastModifier : 
*@LastVersion : 1.0
* 2013.05.28 
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

public class GeneralARInvoiceMasterDataMgtDBDAOsearchSurchargeDescriptionListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchSurchargeDescriptionList
	  * </pre>
	  */
	public GeneralARInvoiceMasterDataMgtDBDAOsearchSurchargeDescriptionListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("chg_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ar_hd_qtr_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemasterdatamgt.generalarinvoicemasterdatamgt.integration").append("\n"); 
		query.append("FileName : GeneralARInvoiceMasterDataMgtDBDAOsearchSurchargeDescriptionListRSQL").append("\n"); 
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
		query.append("SELECT MO.AR_HD_QTR_OFC_CD," ).append("\n"); 
		query.append("       ICDC.AR_OFC_CD," ).append("\n"); 
		query.append("       ICDC.CHG_CD," ).append("\n"); 
		query.append("       MC.CHG_NM," ).append("\n"); 
		query.append("       ICDC.CHG_DESC_CONV_CTNT," ).append("\n"); 
		query.append("       MAX(ICDC.CHG_SEQ) CHG_SEQ" ).append("\n"); 
		query.append("FROM  MDM_ORGANIZATION MO," ).append("\n"); 
		query.append("      MDM_CHARGE MC," ).append("\n"); 
		query.append("      INV_CHG_DESC_CONV ICDC" ).append("\n"); 
		query.append("WHERE MO.OFC_CD = ICDC.AR_OFC_CD" ).append("\n"); 
		query.append("AND   MC.CHG_CD = ICDC.CHG_CD" ).append("\n"); 
		query.append("#if (${ar_hd_qtr_ofc_cd} != '')" ).append("\n"); 
		query.append("AND   MO.AR_HD_QTR_OFC_CD = @[ar_hd_qtr_ofc_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${ar_ofc_cd} != '')" ).append("\n"); 
		query.append("AND   ICDC.AR_OFC_CD = @[ar_ofc_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${chg_cd} != '')" ).append("\n"); 
		query.append("AND   ICDC.CHG_CD = @[chg_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("AND   NVL(ICDC.DELT_FLG, 'N') <> 'Y'" ).append("\n"); 
		query.append("GROUP BY MO.AR_HD_QTR_OFC_CD," ).append("\n"); 
		query.append("       ICDC.AR_OFC_CD," ).append("\n"); 
		query.append("       ICDC.CHG_CD, " ).append("\n"); 
		query.append("       MC.CHG_NM, " ).append("\n"); 
		query.append("       ICDC.CHG_DESC_CONV_CTNT" ).append("\n"); 

	}
}