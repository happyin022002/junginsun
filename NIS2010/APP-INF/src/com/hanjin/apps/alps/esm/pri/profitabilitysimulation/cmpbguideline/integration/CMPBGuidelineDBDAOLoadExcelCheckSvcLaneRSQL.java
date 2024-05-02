/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CMPBGuidelineDBDAOLoadExcelCheckSvcLaneRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.15
*@LastModifier : 이승준
*@LastVersion : 1.0
* 2009.10.15 이승준
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.profitabilitysimulation.cmpbguideline.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Seung-Jun,Lee
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CMPBGuidelineDBDAOLoadExcelCheckSvcLaneRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * LoadExcelCheckSvcLane
	  * </pre>
	  */
	public CMPBGuidelineDBDAOLoadExcelCheckSvcLaneRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("svc_scp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.pri.profitabilitysimulation.cmpbguideline.integration ").append("\n"); 
		query.append("FileName : CMPBGuidelineDBDAOLoadExcelCheckSvcLaneRSQL").append("\n"); 
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
		query.append("SELECT 	A1.VSL_SLAN_CD AS CD" ).append("\n"); 
		query.append("FROM    MDM_SVC_SCP_LANE A1" ).append("\n"); 
		query.append(",       MDM_VSL_SVC_LANE B1" ).append("\n"); 
		query.append("WHERE   A1.VSL_SLAN_CD = B1.VSL_SLAN_CD" ).append("\n"); 
		query.append("AND     A1.SVC_SCP_CD = @[svc_scp_cd]" ).append("\n"); 
		query.append("AND     A1.DELT_FLG = 'N'" ).append("\n"); 
		query.append("AND     B1.DELT_FLG = 'N'" ).append("\n"); 
		query.append("AND     B1.VSL_TP_CD = 'C'" ).append("\n"); 
		query.append("AND	A1.VSL_SLAN_CD = @[cd]" ).append("\n"); 

	}
}