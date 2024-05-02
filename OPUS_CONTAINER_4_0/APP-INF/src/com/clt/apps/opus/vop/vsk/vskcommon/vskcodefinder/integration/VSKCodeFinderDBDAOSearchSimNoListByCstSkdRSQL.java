/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : VSKCodeFinderDBDAOSearchSimNoListByCstSkdRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.05.19
*@LastModifier : 유혁
*@LastVersion : 1.0
* 2010.05.19 유혁
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.vsk.vskcommon.vskcodefinder.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Ryu Hyuk
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class VSKCodeFinderDBDAOSearchSimNoListByCstSkdRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchSimNoListByCstSkd
	  * </pre>
	  */
	public VSKCodeFinderDBDAOSearchSimNoListByCstSkdRSQL(){
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
		query.append("Path : com.clt.apps.opus.vop.vsk.vskcommon.vskcodefinder.integration").append("\n"); 
		query.append("FileName : VSKCodeFinderDBDAOSearchSimNoListByCstSkdRSQL").append("\n"); 
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
		query.append("SELECT	T2.SLAN_CD AS VSL_SLAN_CD,T3.VSL_SLAN_NM" ).append("\n"); 
		query.append("		, TO_CHAR(T1.SIM_DT, 'YYYY-MM-DD') ||'-'|| LTRIM(TO_CHAR(T1.SIM_NO, '000')) AS SIMUL_NO" ).append("\n"); 
		query.append("        , TO_CHAR(T2.CRE_DT,'YYYYMMDD HH24:MI') AS CRE_DT" ).append("\n"); 
		query.append("        , T1.DIFF_RMK AS PF_SKD_RMK" ).append("\n"); 
		query.append("FROM   VSK_SWAP_CST_SIM T1, VSK_SWAP_CST_VVD T2,MDM_VSL_SVC_LANE T3" ).append("\n"); 
		query.append("WHERE  T1.SIM_DT = T2.SIM_DT" ).append("\n"); 
		query.append("AND    T1.SIM_NO = T2.SIM_NO" ).append("\n"); 
		query.append("AND    T2.SLAN_CD = T3.VSL_SLAN_CD" ).append("\n"); 
		query.append("AND    T2.SLAN_CD LIKE @[vsl_slan_cd]||'%'" ).append("\n"); 
		query.append("AND    T1.VSL_SIM_TP_CD = 'C'" ).append("\n"); 
		query.append("AND    T3.VSL_TP_CD = 'C' /*컨테이너선*/" ).append("\n"); 
		query.append("AND    T3.DELT_FLG = 'N'" ).append("\n"); 
		query.append("AND    T2.SIM_DT IS NOT NULL" ).append("\n"); 
		query.append("AND    T2.SIM_NO IS NOT NULL" ).append("\n"); 
		query.append("ORDER BY TO_CHAR(T1.SIM_DT, 'YYYY-MM-DD') ||'-'|| LTRIM(TO_CHAR(T1.SIM_NO, '000')) DESC" ).append("\n"); 

	}
}