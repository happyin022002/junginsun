/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ChargeOfficeTransferMgtDBDAOSearchOfficeTransferToServerIDRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.12
*@LastModifier : 황효근
*@LastVersion : 1.0
* 2009.11.12 황효근
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.dmt.dmtclosing.chargeofficetransfermgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Hwang HyoKeun
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ChargeOfficeTransferMgtDBDAOSearchOfficeTransferToServerIDRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * .
	  * </pre>
	  */
	public ChargeOfficeTransferMgtDBDAOSearchOfficeTransferToServerIDRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fm_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("to_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.dmt.dmtclosing.chargeofficetransfermgt.integration").append("\n"); 
		query.append("FileName : ChargeOfficeTransferMgtDBDAOSearchOfficeTransferToServerIDRSQL").append("\n"); 
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
		query.append("SELECT	'N' AS RHQ_CHK_FLG" ).append("\n"); 
		query.append("FROM    MDM_ORGANIZATION" ).append("\n"); 
		query.append("WHERE   OFC_CD = @[fm_ofc_cd]  -- FROM" ).append("\n"); 
		query.append("AND     AR_HD_QTR_OFC_CD = (SELECT  AR_HD_QTR_OFC_CD" ).append("\n"); 
		query.append("FROM    MDM_ORGANIZATION" ).append("\n"); 
		query.append("WHERE   OFC_CD = @[to_ofc_cd] ) -- TO" ).append("\n"); 

	}
}