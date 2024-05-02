/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : InlandCostManageDBDAOsearchInlandCostSpecialCargoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.06.28
*@LastModifier : 김종옥
*@LastVersion : 1.0
* 2012.06.28 김종옥
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.trs.costmanage.inlandcostmanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Kim Jong Ock
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class InlandCostManageDBDAOsearchInlandCostSpecialCargoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchInlandCostSpecialCargo
	  * </pre>
	  */
	public InlandCostManageDBDAOsearchInlandCostSpecialCargoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("in_cost_trf_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.trs.costmanage.inlandcostmanage.integration").append("\n"); 
		query.append("FileName : InlandCostManageDBDAOsearchInlandCostSpecialCargoRSQL").append("\n"); 
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
		query.append("SELECT TRSP_CRR_MOD_CD" ).append("\n"); 
		query.append(",CNTR_SZ_CD" ).append("\n"); 
		query.append(",RC_SVC_FLG" ).append("\n"); 
		query.append(",RF_FX_RT" ).append("\n"); 
		query.append(",RF_FX_RTO" ).append("\n"); 
		query.append(",DCGO_SVC_FLG" ).append("\n"); 
		query.append(",DG_FX_RT" ).append("\n"); 
		query.append(",DG_FX_RTO" ).append("\n"); 
		query.append(",OVWT_CGO_SVC_FLG" ).append("\n"); 
		query.append(",MIN_CGO_WGT" ).append("\n"); 
		query.append(",MAX_CGO_WGT" ).append("\n"); 
		query.append(",OVR_WGT_FX_RT" ).append("\n"); 
		query.append(",OVR_WGT_FX_RTO" ).append("\n"); 
		query.append(",COST_TRF_NO" ).append("\n"); 
		query.append(",'' CRE_USR_ID" ).append("\n"); 
		query.append(",'' UPD_USR_ID" ).append("\n"); 
		query.append("FROM TRS_INLND_SPCL_CGO" ).append("\n"); 
		query.append("WHERE COST_TRF_NO = @[in_cost_trf_no]" ).append("\n"); 

	}
}