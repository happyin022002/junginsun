/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : InlandCostManageDBDAOmultiCntDefaultCurrDSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.05.29
*@LastModifier : 김종옥
*@LastVersion : 1.0
* 2012.05.29 김종옥
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.trs.costmanage.inlandcostmanage.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Kim Jong Ock
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class InlandCostManageDBDAOmultiCntDefaultCurrDSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * multiCntDefaultCurr
	  * </pre>
	  */
	public InlandCostManageDBDAOmultiCntDefaultCurrDSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.trs.costmanage.inlandcostmanage.integration ").append("\n"); 
		query.append("FileName : InlandCostManageDBDAOmultiCntDefaultCurrDSQL").append("\n"); 
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
		query.append("DELETE FROM TRS_COST_TRF_CURR" ).append("\n"); 
		query.append("WHERE CNT_CD = @[cnt_cd]" ).append("\n"); 

	}
}