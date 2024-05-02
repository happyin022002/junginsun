/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ContainerSupplyDemandPlanDBDAOEqPriceDetailVODSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.17
*@LastModifier : 이호선
*@LastVersion : 1.0
* 2009.06.17 이호선
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.mst.equipmentoperationplan.containersupplydemandplan.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Lee Ho Sun
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ContainerSupplyDemandPlanDBDAOEqPriceDetailVODSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Container Purchasing Trend by Year & input & update
	  * </pre>
	  */
	public ContainerSupplyDemandPlanDBDAOEqPriceDetailVODSQL(){
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

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eq_tpsz_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("DELETE FROM MST_EQ_PUR_PRC" ).append("\n"); 
		query.append("WHERE	BSE_YRMON = @[bse_yrmon]" ).append("\n"); 
		query.append("AND	LOC_CD = @[loc_cd]" ).append("\n"); 
		query.append("AND	EQ_TPSZ_CD = @[eq_tpsz_cd]" ).append("\n"); 
		query.append("AND	VNDR_SEQ = @[vndr_seq]" ).append("\n"); 

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.nis2010.ees.mst.equipmentoperationplan.containersupplydemandplan.integration ").append("\n"); 
		query.append("FileName : ContainerSupplyDemandPlanDBDAOEqPriceDetailVODSQL").append("\n"); 
		query.append("*/").append("\n"); 
	}
}