/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : CgmCodeMgtDBDAOCheckFileBySCDataRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.11.14
*@LastModifier : 
*@LastVersion : 1.0
* 2013.11.14 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.cgm.cgmcommon.cgmcodemgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CgmCodeMgtDBDAOCheckFileBySCDataRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * DESC Enter..
	  * </pre>
	  */
	public CgmCodeMgtDBDAOCheckFileBySCDataRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("prop_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.cgm.cgmcommon.cgmcodemgt.integration").append("\n"); 
		query.append("FileName : CgmCodeMgtDBDAOCheckFileBySCDataRSQL").append("\n"); 
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
		query.append("	COUNT(SP.PROP_NO) CNT" ).append("\n"); 
		query.append("FROM	PRI_SP_MN SP" ).append("\n"); 
		query.append("WHERE	SP.PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("	AND	SP.PROP_STS_CD = 'F'" ).append("\n"); 
		query.append("	AND" ).append("\n"); 
		query.append("		SP.AMDT_SEQ = " ).append("\n"); 
		query.append("		(" ).append("\n"); 
		query.append("			SELECT	/*+ INDEX_DESC(PRI_SP_MN XPKPRI_SP_MN) */ AMDT_SEQ" ).append("\n"); 
		query.append("			FROM	PRI_SP_MN" ).append("\n"); 
		query.append("			WHERE	PROP_NO = SP.PROP_NO" ).append("\n"); 
		query.append("			AND	ROWNUM = 1" ).append("\n"); 
		query.append("		)" ).append("\n"); 

	}
}