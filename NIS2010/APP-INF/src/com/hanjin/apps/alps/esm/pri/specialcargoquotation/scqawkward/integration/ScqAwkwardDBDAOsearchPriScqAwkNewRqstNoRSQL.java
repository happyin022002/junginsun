/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : ScqAwkwardDBDAOsearchPriScqAwkNewRqstNoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.03.20
*@LastModifier : 문동선
*@LastVersion : 1.0
* 2013.03.20 문동선
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.specialcargoquotation.scqawkward.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Dong-sun Moon
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ScqAwkwardDBDAOsearchPriScqAwkNewRqstNoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * PRI_SCQ_AWK_MN
	  * 새로운 Request No 조회
	  * </pre>
	  */
	public ScqAwkwardDBDAOsearchPriScqAwkNewRqstNoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rqst_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.pri.specialcargoquotation.scqawkward.integration").append("\n"); 
		query.append("FileName : ScqAwkwardDBDAOsearchPriScqAwkNewRqstNoRSQL").append("\n"); 
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
		query.append("SELECT SUBSTR(@[rqst_ofc_cd],1,3)||TO_CHAR(SYSDATE,'YYYYMMDD')||LPAD(NVL(MAX(SUBSTR(SCQ_RQST_NO,12,4)),0)+1,4,'0') AS SCQ_RQST_NO" ).append("\n"); 
		query.append("  FROM PRI_SCQ_AWK_MN" ).append("\n"); 
		query.append(" WHERE SCQ_RQST_NO LIKE SUBSTR(@[rqst_ofc_cd],1,3)||TO_CHAR(SYSDATE,'YYYYMMDD')||'%'" ).append("\n"); 

	}
}