/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : CommonCodeDBDAOSearchLevelRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.02.22
*@LastModifier : 변종건
*@LastVersion : 1.0
* 2011.02.22 변종건
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.tpb.common.combo.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author JongGeonByeon
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CommonCodeDBDAOSearchLevelRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchLevel
	  * </pre>
	  */
	public CommonCodeDBDAOSearchLevelRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.tpb.common.combo.integration").append("\n"); 
		query.append("FileName : CommonCodeDBDAOSearchLevelRSQL").append("\n"); 
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
		query.append("SELECT LVL" ).append("\n"); 
		query.append(",OFC_CD" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("SELECT OFC_CD, 'H' AS LVL FROM MDM_OFC_GRP_MAPG WHERE OFC_GRP_ID = '000003' AND SUB_SYS_CD='TPB'" ).append("\n"); 
		query.append("UNION" ).append("\n"); 
		query.append("SELECT OFC_CD, 'R' AS LVL FROM MDM_OFC_GRP_MAPG WHERE OFC_GRP_ID = '000004' AND SUB_SYS_CD='COM'" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("WHERE OFC_CD = @[ofc_cd]" ).append("\n"); 

	}
}