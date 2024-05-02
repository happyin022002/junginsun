/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : CSRExternalFinderDBDAOSrchInvRgstNoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.03.20
*@LastModifier : 함대성
*@LastVersion : 1.0
* 2010.03.20 함대성
* 1.0 Creation
=========================================================*/
package com.hanjin.bizcommon.csr.csrcommon.csrexternalfinder.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author HAM DAE SUNG
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CSRExternalFinderDBDAOSrchInvRgstNoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * inv_rgst_no 조회
	  * </pre>
	  */
	public CSRExternalFinderDBDAOSrchInvRgstNoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inv_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.bizcommon.csr.csrcommon.csrexternalfinder.integration").append("\n"); 
		query.append("FileName : CSRExternalFinderDBDAOSrchInvRgstNoRSQL").append("\n"); 
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
		query.append("CASE" ).append("\n"); 
		query.append("WHEN A.CNT = 0" ).append("\n"); 
		query.append("THEN SUBSTR (@[inv_ofc_cd] ,1,3 )" ).append("\n"); 
		query.append("||TO_CHAR(SYSDATE,'YYYYMM')" ).append("\n"); 
		query.append("||'00001'" ).append("\n"); 
		query.append("ELSE SUBSTR (@[inv_ofc_cd] ,1,3 )" ).append("\n"); 
		query.append("||RGST_NO" ).append("\n"); 
		query.append("END INV_RGST_NO" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("( SELECT COUNT(*) CNT" ).append("\n"); 
		query.append("FROM    AP_PAY_INV" ).append("\n"); 
		query.append("WHERE   INV_RGST_NO LIKE SUBSTR(@[inv_ofc_cd] ,1,3 ) || TO_CHAR(SYSDATE,'YYYYMM') || '%'" ).append("\n"); 
		query.append(") A" ).append("\n"); 
		query.append(", ( SELECT MAX(TO_NUMBER(SUBSTR(INV_RGST_NO,4,11)))+1 RGST_NO" ).append("\n"); 
		query.append("FROM    AP_PAY_INV" ).append("\n"); 
		query.append("WHERE   INV_RGST_NO LIKE SUBSTR(@[inv_ofc_cd] ,1,3 ) || TO_CHAR(SYSDATE,'YYYYMM') || '%'" ).append("\n"); 
		query.append(")B" ).append("\n"); 

	}
}