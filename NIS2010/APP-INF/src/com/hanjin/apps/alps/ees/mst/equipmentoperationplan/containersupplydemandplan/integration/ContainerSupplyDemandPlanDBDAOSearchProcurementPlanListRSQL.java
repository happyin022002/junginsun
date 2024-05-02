/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ContainerSupplyDemandPlanDBDAOSearchProcurementPlanListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.12.23
*@LastModifier : 이호선
*@LastVersion : 1.0
* 2009.12.23 이호선
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.mst.equipmentoperationplan.containersupplydemandplan.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Lee Ho Sun
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ContainerSupplyDemandPlanDBDAOSearchProcurementPlanListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchProcurementPlanList
	  * </pre>
	  */
	public ContainerSupplyDemandPlanDBDAOSearchProcurementPlanListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("input_pln_yr",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_procu_pln_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.mst.equipmentoperationplan.containersupplydemandplan.integration").append("\n"); 
		query.append("FileName : ContainerSupplyDemandPlanDBDAOSearchProcurementPlanListRSQL").append("\n"); 
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
		query.append("A.PLN_YR," ).append("\n"); 
		query.append("A.BSE_YRMON AS H_BSE_YRMON," ).append("\n"); 
		query.append("A.CNTR_PROCU_PLN_CD," ).append("\n"); 
		query.append("A.D2_QTY," ).append("\n"); 
		query.append("A.D4_QTY," ).append("\n"); 
		query.append("A.D5_QTY," ).append("\n"); 
		query.append("A.D7_QTY," ).append("\n"); 
		query.append("A.R2_QTY," ).append("\n"); 
		query.append("A.R4_QTY," ).append("\n"); 
		query.append("A.R5_QTY," ).append("\n"); 
		query.append("A.O2_QTY," ).append("\n"); 
		query.append("A.O4_QTY," ).append("\n"); 
		query.append("A.F2_QTY," ).append("\n"); 
		query.append("A.F4_QTY" ).append("\n"); 
		query.append("FROM MST_CNTR_PROCU_PLN A" ).append("\n"); 
		query.append("WHERE A.PLN_YR = @[input_pln_yr]" ).append("\n"); 
		query.append("#if (${input_sw} == 'S')" ).append("\n"); 
		query.append("AND A.CNTR_PROCU_PLN_CD = @[cntr_procu_pln_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("ORDER BY A.CNTR_PROCU_PLN_CD" ).append("\n"); 

	}
}