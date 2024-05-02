/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : GeneralARInvoiceMasterDataMgtDBDAOInvArStupOfcVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.10.06
*@LastModifier : 
*@LastVersion : 1.0
* 2014.10.06 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.fns.inv.accountreceivableinvoicemasterdatamgt.generalarinvoicemasterdatamgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class GeneralARInvoiceMasterDataMgtDBDAOInvArStupOfcVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  *    
	  * </pre>
	  */
	public GeneralARInvoiceMasterDataMgtDBDAOInvArStupOfcVORSQL(){
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

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.fns.inv.accountreceivableinvoicemasterdatamgt.generalarinvoicemasterdatamgt.integration").append("\n"); 
		query.append("FileName : GeneralARInvoiceMasterDataMgtDBDAOInvArStupOfcVORSQL").append("\n"); 
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
		query.append("	AR_OFC_CD" ).append("\n"); 
		query.append(",	INV_ISS_TP_CD" ).append("\n"); 
		query.append(",	INV_SND_TP_CD" ).append("\n"); 
		query.append(",	DMDT_AR_INV_ISS_FLG" ).append("\n"); 
		query.append(",	N3PTY_BIL_AR_INV_FLG" ).append("\n"); 
		query.append(",	DMDT_INV_APLY_BL_FLG" ).append("\n"); 
		query.append(",	CPY_INV_KNT" ).append("\n"); 
		query.append(",	XCH_RT_RVS_FLG" ).append("\n"); 
		query.append(",	XCH_RT_USD_TP_CD" ).append("\n"); 
		query.append(",	XCH_RT_N3RD_TP_CD" ).append("\n"); 
		query.append(",	TML_INV_ISS_FLG" ).append("\n"); 
		query.append(",	OTS_SMRY_CD" ).append("\n"); 
		query.append(",	DELT_FLG" ).append("\n"); 
		query.append(",	CRE_USR_ID" ).append("\n"); 
		query.append(",	CRE_DT" ).append("\n"); 
		query.append(",	UPD_USR_ID" ).append("\n"); 
		query.append(",	UPD_DT" ).append("\n"); 
		query.append(",	INV_DUP_FLG" ).append("\n"); 
		query.append(",	INV_MLT_BL_ISS_FLG" ).append("\n"); 
		query.append(",	INV_VAT_CHG_CD" ).append("\n"); 
		query.append(",	INV_VAT_CHG_RT" ).append("\n"); 
		query.append(",	'' CHG_CD" ).append("\n"); 
		query.append(",	MNR_AR_INV_ISS_FLG" ).append("\n"); 
		query.append(",	INV_TOP_RMK" ).append("\n"); 
		query.append(",	INV_BTM_RMK" ).append("\n"); 
		query.append("FROM INV_AR_STUP_OFC" ).append("\n"); 
		query.append("WHERE	AR_OFC_CD = @[ar_ofc_cd]" ).append("\n"); 

	}
}