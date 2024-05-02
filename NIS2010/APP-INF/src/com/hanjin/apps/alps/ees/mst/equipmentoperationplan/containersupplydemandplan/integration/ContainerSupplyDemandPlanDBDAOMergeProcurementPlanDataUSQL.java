/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ContainerSupplyDemandPlanDBDAOMergeProcurementPlanDataUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.24
*@LastModifier : 민정호
*@LastVersion : 1.0
* 2009.07.24 민정호
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

public class ContainerSupplyDemandPlanDBDAOMergeProcurementPlanDataUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * MergeProcurementPlanData
	  * </pre>
	  */
	public ContainerSupplyDemandPlanDBDAOMergeProcurementPlanDataUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pln_yr",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("n1",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("n10",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("n12",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("n11",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("n5",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("n4",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("n3",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("n2",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_tpsz_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("n9",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("n8",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("n7",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("n6",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("upd_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.mst.equipmentoperationplan.containersupplydemandplan.integration").append("\n"); 
		query.append("FileName : ContainerSupplyDemandPlanDBDAOMergeProcurementPlanDataUSQL").append("\n"); 
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
		query.append("MERGE INTO MST_CNTR_PROCU_PLN A" ).append("\n"); 
		query.append("USING DUAL" ).append("\n"); 
		query.append("ON (" ).append("\n"); 
		query.append("A.PLN_YR = @[pln_yr]" ).append("\n"); 
		query.append("AND A.CNTR_TPSZ_CD = @[cntr_tpsz_cd]" ).append("\n"); 
		query.append("AND A.CNTR_PROCU_PLN_CD = @[cntr_procu_pln_cd]" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("WHEN MATCHED THEN" ).append("\n"); 
		query.append("UPDATE SET  CNTR_JAN_QTY = @[n1]," ).append("\n"); 
		query.append("CNTR_FEB_QTY = @[n2]," ).append("\n"); 
		query.append("CNTR_MAR_QTY = @[n3]," ).append("\n"); 
		query.append("CNTR_APR_QTY = @[n4]," ).append("\n"); 
		query.append("CNTR_MAY_QTY = @[n5]," ).append("\n"); 
		query.append("CNTR_JUN_QTY = @[n6]," ).append("\n"); 
		query.append("CNTR_JUL_QTY = @[n7]," ).append("\n"); 
		query.append("CNTR_AUG_QTY = @[n8]," ).append("\n"); 
		query.append("CNTR_SEP_QTY = @[n9]," ).append("\n"); 
		query.append("CNTR_OCT_QTY = @[n10]," ).append("\n"); 
		query.append("CNTR_NOV_QTY = @[n11]," ).append("\n"); 
		query.append("CNTR_DEC_QTY = @[n12]," ).append("\n"); 
		query.append("UPD_USR_ID   = @[upd_usr_id]," ).append("\n"); 
		query.append("UPD_DT       = SYSDATE" ).append("\n"); 
		query.append("WHEN NOT MATCHED THEN" ).append("\n"); 
		query.append("INSERT (    PLN_YR, CNTR_TPSZ_CD, CNTR_PROCU_PLN_CD," ).append("\n"); 
		query.append("CNTR_JAN_QTY ," ).append("\n"); 
		query.append("CNTR_FEB_QTY ," ).append("\n"); 
		query.append("CNTR_MAR_QTY ," ).append("\n"); 
		query.append("CNTR_APR_QTY ," ).append("\n"); 
		query.append("CNTR_MAY_QTY ," ).append("\n"); 
		query.append("CNTR_JUN_QTY ," ).append("\n"); 
		query.append("CNTR_JUL_QTY ," ).append("\n"); 
		query.append("CNTR_AUG_QTY ," ).append("\n"); 
		query.append("CNTR_SEP_QTY ," ).append("\n"); 
		query.append("CNTR_OCT_QTY ," ).append("\n"); 
		query.append("CNTR_NOV_QTY ," ).append("\n"); 
		query.append("CNTR_DEC_QTY ," ).append("\n"); 
		query.append("CRE_USR_ID   ," ).append("\n"); 
		query.append("CRE_DT       ," ).append("\n"); 
		query.append("UPD_USR_ID   ," ).append("\n"); 
		query.append("UPD_DT" ).append("\n"); 
		query.append(") VALUES (" ).append("\n"); 
		query.append("@[pln_yr],@[cntr_tpsz_cd],@[cntr_procu_pln_cd]," ).append("\n"); 
		query.append("@[n1],@[n2],@[n3],@[n4],@[n5],@[n6]," ).append("\n"); 
		query.append("@[n7],@[n8],@[n9],@[n10],@[n11],@[n12]," ).append("\n"); 
		query.append("@[cre_usr_id],SYSDATE," ).append("\n"); 
		query.append("@[upd_usr_id],SYSDATE" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}