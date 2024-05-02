/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : ContainerSupplyDemandPlanDBDAOEqPriceDetailVOUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.05.20
*@LastModifier : 이호선
*@LastVersion : 1.0
* 2010.05.20 이호선
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

public class ContainerSupplyDemandPlanDBDAOEqPriceDetailVOUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Container Purchasing Trend by Year & input & update
	  * </pre>
	  */
	public ContainerSupplyDemandPlanDBDAOEqPriceDetailVOUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.NUMERIC + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vndr_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("loc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bse_yrmon",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.FLOAT + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dryg_amt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("eq_knd_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("eq_tpsz_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.NUMERIC + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eq_qty",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.FLOAT + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pur_prc",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.FLOAT + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pur_ut_prc",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.mst.equipmentoperationplan.containersupplydemandplan.integration").append("\n"); 
		query.append("FileName : ContainerSupplyDemandPlanDBDAOEqPriceDetailVOUSQL").append("\n"); 
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
		query.append("UPDATE MST_EQ_PUR_PRC SET " ).append("\n"); 
		query.append("	BSE_YRMON = REPLACE(@[bse_yrmon],'-','')" ).append("\n"); 
		query.append(",	LOC_CD = @[loc_cd]" ).append("\n"); 
		query.append(",	EQ_TPSZ_CD = @[eq_tpsz_cd]" ).append("\n"); 
		query.append(",	VNDR_SEQ = @[vndr_seq]" ).append("\n"); 
		query.append(",	EQ_KND_CD = @[eq_knd_cd]" ).append("\n"); 
		query.append(",	EQ_QTY = @[eq_qty]" ).append("\n"); 
		query.append(",	PUR_PRC = @[pur_prc]" ).append("\n"); 
		query.append(",	PUR_UT_PRC = @[pur_ut_prc]" ).append("\n"); 
		query.append(",	DRYG_AMT = @[dryg_amt]" ).append("\n"); 
		query.append(",	UPD_USR_ID = @[upd_usr_id]" ).append("\n"); 
		query.append(",	UPD_DT = SYSDATE" ).append("\n"); 
		query.append(",   DIFF_RMK = @[diff_rmk]" ).append("\n"); 
		query.append("WHERE	BSE_YRMON = REPLACE(@[bse_yrmon],'-','')" ).append("\n"); 
		query.append("AND	LOC_CD = @[loc_cd]" ).append("\n"); 
		query.append("AND	EQ_TPSZ_CD = @[eq_tpsz_cd]" ).append("\n"); 
		query.append("AND	VNDR_SEQ = @[vndr_seq]" ).append("\n"); 

	}
}