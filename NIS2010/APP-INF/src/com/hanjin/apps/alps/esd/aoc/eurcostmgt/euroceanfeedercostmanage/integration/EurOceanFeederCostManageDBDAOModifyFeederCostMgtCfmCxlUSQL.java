/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : EurOceanFeederCostManageDBDAOModifyFeederCostMgtCfmCxlUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.10.04
*@LastModifier : 
*@LastVersion : 1.0
* 2012.10.04 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.aoc.eurcostmgt.euroceanfeedercostmanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class EurOceanFeederCostManageDBDAOModifyFeederCostMgtCfmCxlUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * modifyFeederCostMgtCfmCxl
	  * </pre>
	  */
	public EurOceanFeederCostManageDBDAOModifyFeederCostMgtCfmCxlUSQL(){
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

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("usr_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("upd_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.aoc.eurcostmgt.euroceanfeedercostmanage.integration").append("\n"); 
		query.append("FileName : EurOceanFeederCostManageDBDAOModifyFeederCostMgtCfmCxlUSQL").append("\n"); 
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
		query.append("UPDATE  AOC_EUR_FDR_TRF_HDR" ).append("\n"); 
		query.append("SET     COST_TRF_STS_CD = 'U'" ).append("\n"); 
		query.append("      , UPD_USR_ID      = @[upd_usr_id]" ).append("\n"); 
		query.append("      , UPD_DT          = SYSDATE" ).append("\n"); 
		query.append("      , LOCL_UPD_DT     = GLOBALDATE_PKG.TIME_LOCAL_OFC_FNC(@[usr_ofc_cd])" ).append("\n"); 
		query.append("      , EFF_FM_DT       = NULL" ).append("\n"); 
		query.append("      , EFF_TO_DT       = NULL" ).append("\n"); 
		query.append("WHERE   COST_TRF_STS_CD = 'C'" ).append("\n"); 
		query.append("AND     COST_TRF_NO = @[in_cost_trf_no]" ).append("\n"); 

	}
}