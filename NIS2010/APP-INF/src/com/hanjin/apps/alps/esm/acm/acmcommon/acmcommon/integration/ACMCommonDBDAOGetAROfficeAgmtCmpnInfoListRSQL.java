/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : ACMCommonDBDAOGetAROfficeAgmtCmpnInfoListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.05.15
*@LastModifier : 김상수
*@LastVersion : 1.0
* 2012.05.15 김상수
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.acm.acmcommon.acmcommon.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author KIM, Sang-Soo
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ACMCommonDBDAOGetAROfficeAgmtCmpnInfoListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * GetAROfficeAgmtCmpnInfoList
	  * </pre>
	  */
	public ACMCommonDBDAOGetAROfficeAgmtCmpnInfoListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("value0",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.acm.acmcommon.acmcommon.integration").append("\n"); 
		query.append("FileName : ACMCommonDBDAOGetAROfficeAgmtCmpnInfoListRSQL").append("\n"); 
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
		query.append("SELECT OR2.AR_OFC_CD VALUE0" ).append("\n"); 
		query.append("  FROM MDM_ORGANIZATION ORG," ).append("\n"); 
		query.append("       MDM_ORGANIZATION OR2," ).append("\n"); 
		query.append("       ACM_SPCL_AGMT CAR" ).append("\n"); 
		query.append(" WHERE OR2.AR_OFC_CD IS NOT NULL" ).append("\n"); 
		query.append("   AND OR2.OFC_CD IN (CASE WHEN ORG.AR_OFC_CD = OR2.AR_HD_QTR_OFC_CD" ).append("\n"); 
		query.append("                              THEN OR2.OFC_CD" ).append("\n"); 
		query.append("                           WHEN ORG.AR_OFC_CD = OR2.AR_OFC_CD" ).append("\n"); 
		query.append("                              THEN OR2.OFC_CD" ).append("\n"); 
		query.append("                           ELSE ORG.OFC_CD" ).append("\n"); 
		query.append("                      END)" ).append("\n"); 
		query.append("   AND OR2.AR_OFC_CD = CAR.SPCL_OFC_CD" ).append("\n"); 
		query.append("   AND ORG.OFC_CD = @[value0]" ).append("\n"); 
		query.append(" GROUP BY OR2.AR_OFC_CD" ).append("\n"); 
		query.append(" ORDER BY OR2.AR_OFC_CD" ).append("\n"); 

	}
}