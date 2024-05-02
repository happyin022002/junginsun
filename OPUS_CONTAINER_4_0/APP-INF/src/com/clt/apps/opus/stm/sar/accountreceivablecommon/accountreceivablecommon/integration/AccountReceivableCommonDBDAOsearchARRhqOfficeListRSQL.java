/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : AccountReceivableCommonDBDAOsearchARRhqOfficeListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.04.28
*@LastModifier : 
*@LastVersion : 1.0
* 2014.04.28 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.stm.sar.accountreceivablecommon.accountreceivablecommon.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AccountReceivableCommonDBDAOsearchARRhqOfficeListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Office in RHQ List
	  * </pre>
	  */
	public AccountReceivableCommonDBDAOsearchARRhqOfficeListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ar_rhq_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.stm.sar.accountreceivablecommon.accountreceivablecommon.integration").append("\n"); 
		query.append("FileName : AccountReceivableCommonDBDAOsearchARRhqOfficeListRSQL").append("\n"); 
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
		query.append("SELECT '' OTS_OFC_CD,  '' AR_RHQ_CD " ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT ARMO.OFC_CD OTS_OFC_CD," ).append("\n"); 
		query.append("    '' AR_RHQ_CD" ).append("\n"); 
		query.append("FROM MDM_ORGANIZATION ARMO" ).append("\n"); 
		query.append("WHERE " ).append("\n"); 
		query.append(" EXISTS " ).append("\n"); 
		query.append("        (SELECT " ).append("\n"); 
		query.append("                * " ).append("\n"); 
		query.append("          FROM MDM_ORGANIZATION MO" ).append("\n"); 
		query.append("         WHERE ARMO.OFC_CD  = MO.AR_OFC_CD)" ).append("\n"); 
		query.append("           AND ARMO.AR_HD_QTR_OFC_CD =  " ).append("\n"); 
		query.append("               decode(@[ar_rhq_cd] , 'ALL' , ARMO.AR_HD_QTR_OFC_CD , '' , ARMO.AR_HD_QTR_OFC_CD , @[ar_rhq_cd] )" ).append("\n"); 

	}
}