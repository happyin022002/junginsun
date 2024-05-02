/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CodeMgtDBDAOSearchVvdSkdListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.04
*@LastModifier : 진윤오
*@LastVersion : 1.0
* 2009.11.04 진윤오
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.cps.cni.codemgt.codemgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author J.Y.O
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CodeMgtDBDAOSearchVvdSkdListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * vessel skd 검색
	  * </pre>
	  */
	public CodeMgtDBDAOSearchVvdSkdListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pol",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("skd_dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("skd_voy_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pod",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.cps.cni.codemgt.codemgt.integration").append("\n"); 
		query.append("FileName : CodeMgtDBDAOSearchVvdSkdListRSQL").append("\n"); 
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
		query.append("A.VSL_CD || A.SKD_VOY_NO || A.SKD_DIR_CD VVD" ).append("\n"); 
		query.append(", B.SLAN_CD" ).append("\n"); 
		query.append(", A.VPS_PORT_CD POL" ).append("\n"); 
		query.append(", B.VPS_PORT_CD POD" ).append("\n"); 
		query.append(", TO_CHAR (A.VPS_ETD_DT, 'YYYY-MM-DD HH24:MI') VPS_ETD_DT" ).append("\n"); 
		query.append(", TO_CHAR (B.VPS_ETB_DT, 'YYYY-MM-DD HH24:MI') VPS_ETB_DT" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("VSK_VSL_PORT_SKD A" ).append("\n"); 
		query.append(", VSK_VSL_PORT_SKD B" ).append("\n"); 
		query.append("WHERE" ).append("\n"); 
		query.append("A.VSL_CD         = B.VSL_CD" ).append("\n"); 
		query.append("AND A.SKD_VOY_NO = B.SKD_VOY_NO" ).append("\n"); 
		query.append("AND A.SKD_DIR_CD = B.SKD_DIR_CD" ).append("\n"); 
		query.append("AND A.VSL_CD     = @[vsl_cd]" ).append("\n"); 
		query.append("AND A.SKD_VOY_NO = @[skd_voy_no]" ).append("\n"); 
		query.append("AND A.SKD_DIR_CD = @[skd_dir_cd]" ).append("\n"); 
		query.append("AND A.CLPT_SEQ   <  B.CLPT_SEQ" ).append("\n"); 
		query.append("#if (${pol} != '')" ).append("\n"); 
		query.append("AND A.VPS_PORT_CD = @[pol]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${pod} != '')" ).append("\n"); 
		query.append("AND B.VPS_PORT_CD = @[pod]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("ORDER BY" ).append("\n"); 
		query.append("A.VSL_CD" ).append("\n"); 
		query.append(", A.SKD_VOY_NO" ).append("\n"); 
		query.append(", A.SKD_DIR_CD" ).append("\n"); 
		query.append(", A.CLPT_SEQ" ).append("\n"); 
		query.append(", B.CLPT_SEQ" ).append("\n"); 

	}
}