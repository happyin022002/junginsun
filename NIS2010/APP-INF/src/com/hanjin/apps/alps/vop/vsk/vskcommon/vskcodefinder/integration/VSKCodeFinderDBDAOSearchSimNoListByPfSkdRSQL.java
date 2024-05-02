/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : VSKCodeFinderDBDAOSearchSimNoListByPfSkdRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.07.28
*@LastModifier : 
*@LastVersion : 1.0
* 2014.07.28 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.vsk.vskcommon.vskcodefinder.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class VSKCodeFinderDBDAOSearchSimNoListByPfSkdRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchSimNoListByPfSkd
	  * </pre>
	  */
	public VSKCodeFinderDBDAOSearchSimNoListByPfSkdRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_slan_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.vop.vsk.vskcommon.vskcodefinder.integration").append("\n"); 
		query.append("FileName : VSKCodeFinderDBDAOSearchSimNoListByPfSkdRSQL").append("\n"); 
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
		query.append("SELECT T1.SLAN_CD AS VSL_SLAN_CD" ).append("\n"); 
		query.append("       , T2.VSL_SLAN_NM AS VSL_SLAN_NM" ).append("\n"); 
		query.append("       , SUBSTR(T1.SIM_DT,0,4) ||'-' ||SUBSTR(T1.SIM_DT,5,2) ||'-' ||SUBSTR(T1.SIM_DT,7,2) ||'-' || DECODE(Length(T1.SIM_NO),0,'',1,'00'||T1.SIM_NO,2,'0'||T1.SIM_NO,T1.SIM_NO) AS SIMUL_NO" ).append("\n"); 
		query.append("       , TO_CHAR(T1.CRE_DT,'YYYYMMDD HH24:MI') AS CRE_DT" ).append("\n"); 
		query.append("       , T1.SIM_RMK AS PF_SKD_RMK" ).append("\n"); 
		query.append("FROM   VSK_SIM_INFO T1, MDM_VSL_SVC_LANE T2" ).append("\n"); 
		query.append("WHERE  T1.SLAN_CD = T2.VSL_SLAN_CD (+)" ).append("\n"); 
		query.append("AND    T1.SLAN_CD LIKE @[vsl_slan_cd]||'%'" ).append("\n"); 
		query.append("AND    NVL(T2.VSL_TP_CD,'C') = 'C' /*컨테이너선*/" ).append("\n"); 
		query.append("AND    EXISTS (	SELECT 'X'" ).append("\n"); 
		query.append("    			FROM VSK_SIM_TML_INFO S" ).append("\n"); 
		query.append("			    WHERE 1 = 1" ).append("\n"); 
		query.append("			    AND  T1.SIM_DT   = S.SIM_DT" ).append("\n"); 
		query.append("			    AND  T1.SIM_NO   = S.SIM_NO" ).append("\n"); 
		query.append("			   )" ).append("\n"); 
		query.append("ORDER BY SIM_DT || SIM_NO DESC " ).append("\n"); 

	}
}