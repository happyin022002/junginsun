/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : ACMSimulationDBDAOGetVslSvcLaneInfoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.03.13
*@LastModifier : 
*@LastVersion : 1.0
* 2014.03.13 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.acm.acmsimulation.acmsimulation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ACMSimulationDBDAOGetVslSvcLaneInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * GetVslSvcLaneInfo
	  * </pre>
	  */
	public ACMSimulationDBDAOGetVslSvcLaneInfoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.acm.acmsimulation.acmsimulation.integration").append("\n"); 
		query.append("FileName : ACMSimulationDBDAOGetVslSvcLaneInfoRSQL").append("\n"); 
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
		query.append("    SUM(PRE) AS PRE_FEEDER_CHECK," ).append("\n"); 
		query.append("    SUM(PST) AS PST_FEEDER_CHECK" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("    SELECT " ).append("\n"); 
		query.append("        CASE WHEN VSL_PRE_PST_CD = 'S' AND M.VSL_SVC_TP_CD = 'O' THEN 1 ELSE 0 END AS PRE," ).append("\n"); 
		query.append("        CASE WHEN VSL_PRE_PST_CD <>'S' AND VSL_SEQ != 0 AND M.VSL_SVC_TP_CD = 'O' THEN 1 ELSE 0 END AS PST" ).append("\n"); 
		query.append("    FROM BKG_VVD V, MDM_VSL_SVC_LANE M" ).append("\n"); 
		query.append("    WHERE 1=1" ).append("\n"); 
		query.append("    AND V.BKG_NO  = @[bkg_no]" ).append("\n"); 
		query.append("    AND V.SLAN_CD = M.VSL_SLAN_CD(+)  " ).append("\n"); 
		query.append("    ) " ).append("\n"); 

	}
}