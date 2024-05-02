/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : CommonDBDAOSearchVVDListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.03.03
*@LastModifier : 
*@LastVersion : 1.0
* 2011.03.03 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.saq.common.common.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CommonDBDAOSearchVVDListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 
	  * </pre>
	  */
	public CommonDBDAOSearchVVDListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vvd_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.saq.common.common.integration").append("\n"); 
		query.append("FileName : CommonDBDAOSearchVVDListRSQL").append("\n"); 
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
		query.append("SELECT VVD CODE, SLAN_CD TEXT" ).append("\n"); 
		query.append("FROM (SELECT ROW_NUMBER() OVER (	" ).append("\n"); 
		query.append("ORDER BY SLAN_CD	" ).append("\n"); 
		query.append(", VSL_CD || SKD_VOY_NO || SKD_DIR_CD" ).append("\n"); 
		query.append(", TO_NUMBER(CLPT_SEQ)" ).append("\n"); 
		query.append(") NO," ).append("\n"); 
		query.append("SLAN_CD" ).append("\n"); 
		query.append(", VSL_CD || SKD_VOY_NO || SKD_DIR_CD VVD	" ).append("\n"); 
		query.append(", VPS_PORT_CD" ).append("\n"); 
		query.append(", VPS_ETA_DT" ).append("\n"); 
		query.append(", VPS_ETD_DT" ).append("\n"); 
		query.append("FROM VSK_VSL_PORT_SKD" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND VSL_CD || SKD_VOY_NO || SKD_DIR_CD = @[vvd_cd] " ).append("\n"); 
		query.append("AND NVL(CNG_STS_CD, ' ') <> 'S'" ).append("\n"); 
		query.append("AND CLPT_IND_SEQ = '1'		" ).append("\n"); 
		query.append(") A	" ).append("\n"); 
		query.append("WHERE no BETWEEN 1 AND 50" ).append("\n"); 

	}
}