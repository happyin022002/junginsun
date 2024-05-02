/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : PRISimulationDBDAOSearchPriSimRtListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.07.27
*@LastModifier : 
*@LastVersion : 1.0
* 2016.07.27 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.pri.prisimulation.prisimulation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PRISimulationDBDAOSearchPriSimRtListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 
	  * </pre>
	  */
	public PRISimulationDBDAOSearchPriSimRtListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_pctl_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.pri.prisimulation.prisimulation.integration").append("\n"); 
		query.append("FileName : PRISimulationDBDAOSearchPriSimRtListRSQL").append("\n"); 
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
		query.append("SELECT B.CNTR_TPSZ_CD AS CNTR_SZ_CD" ).append("\n"); 
		query.append("      ,P.PCTL_NO" ).append("\n"); 
		query.append("      ,P.SVC_SCP_CD" ).append("\n"); 
		query.append("  FROM PRI_SIM_PARA P" ).append("\n"); 
		query.append("      ,MDM_CNTR_TP_SZ       B" ).append("\n"); 
		query.append(" WHERE P.PCTL_NO LIKE @[f_pctl_no]||'%'" ).append("\n"); 
		query.append("   AND P.EQ_TP_CD = B.CNTR_TP_CD" ).append("\n"); 
		query.append("   --AND B.CNTR_SZ_CD IN ('2','4','5', '7')" ).append("\n"); 
		query.append("   AND B.DELT_FLG = 'N'" ).append("\n"); 

	}
}