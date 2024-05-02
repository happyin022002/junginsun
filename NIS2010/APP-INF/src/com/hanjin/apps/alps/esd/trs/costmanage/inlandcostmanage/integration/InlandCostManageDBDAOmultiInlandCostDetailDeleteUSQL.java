/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : InlandCostManageDBDAOmultiInlandCostDetailDeleteUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.06.26
*@LastModifier : 김종옥
*@LastVersion : 1.0
* 2012.06.26 김종옥
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

public class InlandCostManageDBDAOmultiInlandCostDetailDeleteUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * multiInlandCostDetailDelete
	  * </pre>
	  */
	public InlandCostManageDBDAOmultiInlandCostDetailDeleteUSQL(){
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
		params.put("upd_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.trs.costmanage.inlandcostmanage.integration").append("\n"); 
		query.append("FileName : InlandCostManageDBDAOmultiInlandCostDetailDeleteUSQL").append("\n"); 
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
		query.append("UPDATE TRS_INLND_COST_TRF" ).append("\n"); 
		query.append("SET DELT_FLG = 'Y'" ).append("\n"); 
		query.append(",UPD_USR_ID        = @[upd_usr_id]" ).append("\n"); 
		query.append(",UPD_DT            = SYSDATE" ).append("\n"); 
		query.append("WHERE COST_TRF_NO = @[cost_trf_no]" ).append("\n"); 
		query.append("AND COST_TRF_ROUT_SEQ = @[cost_trf_rout_seq]" ).append("\n"); 

	}
}