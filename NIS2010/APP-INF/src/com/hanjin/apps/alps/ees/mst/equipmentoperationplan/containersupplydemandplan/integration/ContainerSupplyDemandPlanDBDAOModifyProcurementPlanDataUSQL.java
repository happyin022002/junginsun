/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ContainerSupplyDemandPlanDBDAOModifyProcurementPlanDataUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.17
*@LastModifier : 민정호
*@LastVersion : 1.0
* 2009.09.17 민정호
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.mst.equipmentoperationplan.containersupplydemandplan.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Jung Ho Min
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ContainerSupplyDemandPlanDBDAOModifyProcurementPlanDataUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ModifyProcurementPlanData
	  * </pre>
	  */
	public ContainerSupplyDemandPlanDBDAOModifyProcurementPlanDataUSQL(){
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
		params.put("r2_qty",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f2_qty",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("o4_qty",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("d2_qty",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("d7_qty",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_procu_pln_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("d4_qty",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("r4_qty",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f4_qty",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("h_bse_yrmon",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("o2_qty",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("d5_qty",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("r5_qty",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("diff_rmk",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.mst.equipmentoperationplan.containersupplydemandplan.integration").append("\n"); 
		query.append("FileName : ContainerSupplyDemandPlanDBDAOModifyProcurementPlanDataUSQL").append("\n"); 
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
		query.append("UPDATE MST_CNTR_PROCU_PLN A" ).append("\n"); 
		query.append("SET" ).append("\n"); 
		query.append("A.BSE_YRMON =         	@[h_bse_yrmon]  ," ).append("\n"); 
		query.append("A.D2_QTY =            	@[d2_qty]       ," ).append("\n"); 
		query.append("A.D4_QTY =            	@[d4_qty]       ," ).append("\n"); 
		query.append("A.D5_QTY =            	@[d5_qty]       ," ).append("\n"); 
		query.append("A.D7_QTY =            	@[d7_qty]       ," ).append("\n"); 
		query.append("A.R2_QTY =            	@[r2_qty]       ," ).append("\n"); 
		query.append("A.R4_QTY =            	@[r4_qty]       ," ).append("\n"); 
		query.append("A.R5_QTY =            	@[r5_qty]       ," ).append("\n"); 
		query.append("A.O2_QTY =            	@[o2_qty]       ," ).append("\n"); 
		query.append("A.O4_QTY =            	@[o4_qty]       ," ).append("\n"); 
		query.append("A.F2_QTY =            	@[f2_qty]       ," ).append("\n"); 
		query.append("A.F4_QTY =            	@[f4_qty]       ," ).append("\n"); 
		query.append("A.DIFF_RMK =          	@[diff_rmk]     ," ).append("\n"); 
		query.append("A.UPD_USR_ID =        	@[cre_usr_id]	," ).append("\n"); 
		query.append("A.UPD_DT     =			SYSDATE" ).append("\n"); 
		query.append("WHERE A.PLN_YR	          = @[input_pln_yr]" ).append("\n"); 
		query.append("AND   A.CNTR_PROCU_PLN_CD = @[cntr_procu_pln_cd]" ).append("\n"); 

	}
}