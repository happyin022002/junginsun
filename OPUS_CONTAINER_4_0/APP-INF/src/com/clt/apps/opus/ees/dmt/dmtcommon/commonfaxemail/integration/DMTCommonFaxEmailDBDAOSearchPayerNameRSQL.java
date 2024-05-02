/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : DMTCommonFaxEmailDBDAOSearchPayerNameRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.01.16
*@LastModifier : 김성욱
*@LastVersion : 1.0
* 2015.01.16 김성욱
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.dmt.dmtcommon.commonfaxemail.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Sung-Wook Kim
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class DMTCommonFaxEmailDBDAOSearchPayerNameRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * FAX 발송할 수신자(Payer)의  이름을 조회
	  * </pre>
	  */
	public DMTCommonFaxEmailDBDAOSearchPayerNameRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.dmt.dmtcommon.commonfaxemail.integration").append("\n"); 
		query.append("FileName : DMTCommonFaxEmailDBDAOSearchPayerNameRSQL").append("\n"); 
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
		query.append("SELECT CUST_LGL_ENG_NM AS PAYER_NM, OFC_CD FROM MDM_CUSTOMER " ).append("\n"); 
		query.append("WHERE CUST_CNT_CD||CUST_SEQ = @[cust_cd]" ).append("\n"); 

	}
}