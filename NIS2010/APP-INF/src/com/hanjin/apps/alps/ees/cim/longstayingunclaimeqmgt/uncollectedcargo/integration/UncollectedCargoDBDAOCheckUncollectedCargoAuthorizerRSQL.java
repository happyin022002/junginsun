/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : UncollectedCargoDBDAOCheckUncollectedCargoAuthorizerRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.10.21
*@LastModifier : 
*@LastVersion : 1.0
* 2014.10.21 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.cim.longstayingunclaimeqmgt.uncollectedcargo.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class UncollectedCargoDBDAOCheckUncollectedCargoAuthorizerRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Check UncollectedCargoAuthorizer
	  * </pre>
	  */
	public UncollectedCargoDBDAOCheckUncollectedCargoAuthorizerRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("uc_auth_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("uc_auth_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.cim.longstayingunclaimeqmgt.uncollectedcargo.integration").append("\n"); 
		query.append("FileName : UncollectedCargoDBDAOCheckUncollectedCargoAuthorizerRSQL").append("\n"); 
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
		query.append("--'SELCOE' 아닌 경우 " ).append("\n"); 
		query.append("SELECT AA.AR_HD_QTR_OFC_CD" ).append("\n"); 
		query.append("     , AA.USR_ID" ).append("\n"); 
		query.append("     , (SELECT USR_NM FROM COM_USER WHERE USR_ID = AA.USR_ID) USR_NM" ).append("\n"); 
		query.append("     , CASE WHEN CNT = 0 THEN NVL((SELECT '2' FROM COM_USER WHERE USR_ID= AA.USR_ID AND OFC_CD = AA.AR_HD_QTR_OFC_CD),'0') " ).append("\n"); 
		query.append("            ELSE TO_CHAR(CNT) " ).append("\n"); 
		query.append("       END AS CNT" ).append("\n"); 
		query.append("     , (SELECT COUNT(1) FROM CIM_UC_CGO_AUTH WHERE UC_AUTH_USR_ID=AA.USR_ID AND UC_AUTH_OFC_CD = AA.AR_HD_QTR_OFC_CD) AS ISFALG" ).append("\n"); 
		query.append("FROM   (" ).append("\n"); 
		query.append("       SELECT COUNT(1) AS CNT" ).append("\n"); 
		query.append("            , @[uc_auth_ofc_cd] AS AR_HD_QTR_OFC_CD" ).append("\n"); 
		query.append("            , @[uc_auth_usr_id] AS USR_ID" ).append("\n"); 
		query.append("       FROM   MDM_ORGANIZATION A" ).append("\n"); 
		query.append("            , COM_USER B " ).append("\n"); 
		query.append("       WHERE 1 = 1 " ).append("\n"); 
		query.append("       AND A.DELT_FLG = 'N' " ).append("\n"); 
		query.append("       AND A.OFC_CD = B.OFC_CD " ).append("\n"); 
		query.append("       AND A.AR_HD_QTR_OFC_CD = @[uc_auth_ofc_cd] " ).append("\n"); 
		query.append("       AND B.USR_ID = @[uc_auth_usr_id]" ).append("\n"); 
		query.append("      ) AA" ).append("\n"); 

	}
}