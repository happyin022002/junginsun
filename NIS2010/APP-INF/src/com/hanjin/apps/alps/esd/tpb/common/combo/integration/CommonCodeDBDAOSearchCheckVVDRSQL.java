/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : CommonCodeDBDAOSearchCheckVVDRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.05.14
*@LastModifier : 최 선
*@LastVersion : 1.0
* 2010.05.14 최 선
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.tpb.common.combo.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Sun, Choi
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CommonCodeDBDAOSearchCheckVVDRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchCheckVVD
	  * </pre>
	  */
	public CommonCodeDBDAOSearchCheckVVDRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_skd_voy_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_if_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_skd_dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.tpb.common.combo.integration").append("\n"); 
		query.append("FileName : CommonCodeDBDAOSearchCheckVVDRSQL").append("\n"); 
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
		query.append("SELECT COUNT(1), COUNT(1)" ).append("\n"); 
		query.append("FROM VSK_VSL_PORT_SKD" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND VSL_CD = @[s_vsl_cd]" ).append("\n"); 
		query.append("AND SKD_VOY_NO = @[s_skd_voy_no]" ).append("\n"); 
		query.append("AND SKD_DIR_CD = @[s_skd_dir_cd]" ).append("\n"); 
		query.append("AND VPS_PORT_CD IN (SELECT C.LOC_CD" ).append("\n"); 
		query.append("FROM MDM_ORGANIZATION O," ).append("\n"); 
		query.append("MDM_LOCATION L," ).append("\n"); 
		query.append("MDM_LOCATION C" ).append("\n"); 
		query.append("WHERE O.LOC_CD = L.LOC_CD" ).append("\n"); 
		query.append("AND L.CNT_CD = C.CNT_CD" ).append("\n"); 
		query.append("AND O.OFC_CD = @[s_if_ofc_cd]" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("AND (SKD_CNG_STS_CD != 'S' OR SKD_CNG_STS_CD IS NULL OR SKD_CNG_STS_CD = '')" ).append("\n"); 

	}
}