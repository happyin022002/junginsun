/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : InlandCostManageDBDAOmultiCntDefaultCurrCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.05.29
*@LastModifier : 김종옥
*@LastVersion : 1.0
* 2012.05.29 김종옥
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

public class InlandCostManageDBDAOmultiCntDefaultCurrCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * multiCntDefaultCurr
	  * </pre>
	  */
	public InlandCostManageDBDAOmultiCntDefaultCurrCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("curr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rhq_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("upd_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.trs.costmanage.inlandcostmanage.integration").append("\n"); 
		query.append("FileName : InlandCostManageDBDAOmultiCntDefaultCurrCSQL").append("\n"); 
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
		query.append("INSERT INTO TRS_COST_TRF_CURR(" ).append("\n"); 
		query.append("CNT_CD" ).append("\n"); 
		query.append(",CURR_CD" ).append("\n"); 
		query.append(",RHQ_CD" ).append("\n"); 
		query.append(",CRE_USR_ID" ).append("\n"); 
		query.append(",CRE_DT" ).append("\n"); 
		query.append(",UPD_USR_ID" ).append("\n"); 
		query.append(",UPD_DT" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("VALUES" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("@[cnt_cd]" ).append("\n"); 
		query.append(",@[curr_cd]" ).append("\n"); 
		query.append(",@[rhq_cd]" ).append("\n"); 
		query.append(",@[upd_usr_id]" ).append("\n"); 
		query.append(",SYSDATE" ).append("\n"); 
		query.append(",@[upd_usr_id]" ).append("\n"); 
		query.append(",SYSDATE" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}