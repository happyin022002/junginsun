/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : EacMgtDBDAOAddAutoAuditFileNoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.11.19
*@LastModifier : 최종혁
*@LastVersion : 1.0
* 2015.11.19 최종혁
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.eas.eac.eacmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author CJH
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class EacMgtDBDAOAddAutoAuditFileNoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * EAS_ATCH_FILE 저장시 사용 할 ATCH_FILE_LNK_ID 채번
	  * </pre>
	  */
	public EacMgtDBDAOAddAutoAuditFileNoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mdl_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.eas.eac.eacmgt.integration").append("\n"); 
		query.append("FileName : EacMgtDBDAOAddAutoAuditFileNoRSQL").append("\n"); 
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
		query.append("SELECT @[mdl_tp_cd]||LPAD(TO_CHAR(NVL((" ).append("\n"); 
		query.append("        SELECT /*+ INDEX_DESC(A XPKEAS_ATCH_FILE) */" ).append("\n"); 
		query.append("               TO_NUMBER(SUBSTR(ATCH_FILE_LNK_ID,4)) AS ATCH_FILE_LNK_ID" ).append("\n"); 
		query.append("          FROM EAS_ATCH_FILE A" ).append("\n"); 
		query.append("         WHERE ATCH_FILE_LNK_ID LIKE @[mdl_tp_cd]||'%'" ).append("\n"); 
		query.append("           AND ROWNUM = 1" ).append("\n"); 
		query.append("       ),0)+1),7,'0') ATCH_FILE_LNK_ID" ).append("\n"); 
		query.append("  FROM DUAL" ).append("\n"); 

	}
}