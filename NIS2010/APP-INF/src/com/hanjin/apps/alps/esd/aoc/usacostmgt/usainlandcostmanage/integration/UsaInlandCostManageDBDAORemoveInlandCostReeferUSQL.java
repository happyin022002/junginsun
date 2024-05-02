/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : UsaInlandCostManageDBDAORemoveInlandCostReeferUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.10.17
*@LastModifier : 
*@LastVersion : 1.0
* 2012.10.17 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.aoc.usacostmgt.usainlandcostmanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class UsaInlandCostManageDBDAORemoveInlandCostReeferUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * EUR Inland Cost Reefer - Remove
	  * </pre>
	  */
	public UsaInlandCostManageDBDAORemoveInlandCostReeferUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cost_trf_rout_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cost_trf_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cost_trf_rf_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("upd_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.aoc.usacostmgt.usainlandcostmanage.integration").append("\n"); 
		query.append("FileName : UsaInlandCostManageDBDAORemoveInlandCostReeferUSQL").append("\n"); 
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
		query.append("UPDATE  AOC_USA_INLND_RF_TRF_DTL" ).append("\n"); 
		query.append("SET     DELT_FLG                = 'Y'" ).append("\n"); 
		query.append("      , DELT_USR_ID             = @[upd_usr_id]" ).append("\n"); 
		query.append("      , DELT_DT                 = SYSDATE" ).append("\n"); 
		query.append("WHERE   1 = 1" ).append("\n"); 
		query.append("AND     DELT_FLG                = 'N'" ).append("\n"); 
		query.append("AND     COST_TRF_NO             = @[cost_trf_no]" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${cost_trf_rf_seq} != '') " ).append("\n"); 
		query.append("AND     COST_TRF_RF_SEQ         = @[cost_trf_rf_seq]" ).append("\n"); 
		query.append("#else " ).append("\n"); 
		query.append("AND     COST_TRF_ROUT_SEQ       = @[cost_trf_rout_seq]" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}