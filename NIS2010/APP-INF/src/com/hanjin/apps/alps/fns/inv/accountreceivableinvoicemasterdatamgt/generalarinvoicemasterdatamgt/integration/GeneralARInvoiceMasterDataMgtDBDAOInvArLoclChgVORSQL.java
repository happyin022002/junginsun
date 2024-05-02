/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : GeneralARInvoiceMasterDataMgtDBDAOInvArLoclChgVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.07.11
*@LastModifier : 
*@LastVersion : 1.0
* 2016.07.11 
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

public class GeneralARInvoiceMasterDataMgtDBDAOInvArLoclChgVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  *    
	  * </pre>
	  */
	public GeneralARInvoiceMasterDataMgtDBDAOInvArLoclChgVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("loc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ar_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemasterdatamgt.generalarinvoicemasterdatamgt.integration").append("\n"); 
		query.append("FileName : GeneralARInvoiceMasterDataMgtDBDAOInvArLoclChgVORSQL").append("\n"); 
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
		query.append("SELECT " ).append("\n"); 
		query.append("	INV.AR_OFC_CD" ).append("\n"); 
		query.append(",   MO.AR_HD_QTR_OFC_CD" ).append("\n"); 
		query.append(",	INV.LOC_CD" ).append("\n"); 
		query.append(",	INV.SVC_SCP_CD" ).append("\n"); 
		query.append(",	INV.CHG_CD" ).append("\n"); 
		query.append(",	INV.IO_BND_CD" ).append("\n"); 
		query.append(",	INV.CUST_CNT_CD" ).append("\n"); 
		query.append(",	LPAD(INV.CUST_SEQ,6,'0') CUST_SEQ" ).append("\n"); 
		query.append(",	INV.CUST_CNT_CD || LPAD(INV.CUST_SEQ,6,'0') CUST_CNT_CD2" ).append("\n"); 
		query.append(",	INV.CURR_CD" ).append("\n"); 
		query.append(",	INV.TRF_RT_AMT" ).append("\n"); 
		query.append(",	INV.INV_CHG_UT_DIV_CD" ).append("\n"); 
		query.append(",	INV.LOCL_CHG_IF_AUTO_CD" ).append("\n"); 
		query.append(",	INV.CHG_RMK" ).append("\n"); 
		query.append(",	INV.ACCT_CD" ).append("\n"); 
		query.append(",	INV.CRE_USR_ID" ).append("\n"); 
		query.append(",	INV.CRE_DT" ).append("\n"); 
		query.append(",	INV.UPD_USR_ID" ).append("\n"); 
		query.append(",	INV.UPD_DT" ).append("\n"); 
		query.append("FROM INV_AR_LOCL_CHG INV" ).append("\n"); 
		query.append(", MDM_ORGANIZATION MO" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND INV.AR_OFC_CD = MO.OFC_CD" ).append("\n"); 
		query.append("#if(${ar_ofc_cd} != 'ALL')" ).append("\n"); 
		query.append("AND	INV.AR_OFC_CD = @[ar_ofc_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${loc_cd} != 'ALL')" ).append("\n"); 
		query.append("AND	INV.LOC_CD = @[loc_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}