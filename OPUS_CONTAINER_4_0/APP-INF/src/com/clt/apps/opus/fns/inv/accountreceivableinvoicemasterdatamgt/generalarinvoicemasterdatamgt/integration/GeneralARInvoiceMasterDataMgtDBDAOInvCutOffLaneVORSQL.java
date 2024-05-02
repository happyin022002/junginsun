/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : GeneralARInvoiceMasterDataMgtDBDAOInvCutOffLaneVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.12.23
*@LastModifier : 한동훈
*@LastVersion : 1.0
* 2009.12.23 한동훈
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.fns.inv.accountreceivableinvoicemasterdatamgt.generalarinvoicemasterdatamgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Han Dong Hoon
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class GeneralARInvoiceMasterDataMgtDBDAOInvCutOffLaneVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  *    
	  * </pre>
	  */
	public GeneralARInvoiceMasterDataMgtDBDAOInvCutOffLaneVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("new_ar_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("old_ar_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.fns.inv.accountreceivableinvoicemasterdatamgt.generalarinvoicemasterdatamgt.integration").append("\n"); 
		query.append("FileName : GeneralARInvoiceMasterDataMgtDBDAOInvCutOffLaneVORSQL").append("\n"); 
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
		query.append("SELECT" ).append("\n"); 
		query.append("APLY_DT" ).append("\n"); 
		query.append(",	OFC_RMK" ).append("\n"); 
		query.append(",	CRE_USR_ID" ).append("\n"); 
		query.append(",	TO_CHAR(CRE_DT,'YYYY-MM-DD') CRE_DT" ).append("\n"); 
		query.append(",	UPD_USR_ID" ).append("\n"); 
		query.append(",	TO_CHAR(UPD_DT,'YYYY-MM-DD') UPD_DT" ).append("\n"); 
		query.append(",	OLD_AR_OFC_CD" ).append("\n"); 
		query.append(",	IO_BND_CD" ).append("\n"); 
		query.append(",	SLAN_CD" ).append("\n"); 
		query.append(",	PORT_CD" ).append("\n"); 
		query.append(",	VSL_CD||SKD_VOY_NO||SKD_DIR_CD VVD_CD" ).append("\n"); 
		query.append(",	VSL_CD" ).append("\n"); 
		query.append(",	SKD_VOY_NO" ).append("\n"); 
		query.append(",	SKD_DIR_CD" ).append("\n"); 
		query.append(",	NEW_AR_OFC_CD" ).append("\n"); 
		query.append(",	CUT_OFF_APLY_DT_TP_CD" ).append("\n"); 
		query.append("FROM INV_CUT_OFF_LANE" ).append("\n"); 
		query.append("WHERE	OLD_AR_OFC_CD = UPPER(@[old_ar_ofc_cd])" ).append("\n"); 
		query.append("AND	NEW_AR_OFC_CD = UPPER(@[new_ar_ofc_cd])" ).append("\n"); 
		query.append("ORDER BY UPD_DT" ).append("\n"); 

	}
}