/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : ActualCostCalcManageDBDAOLogActualCostCalcErrMsgUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.04.22
*@LastModifier : 
*@LastVersion : 1.0
* 2013.04.22 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.trs.specialcargoquotationmanage.actualcostmanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ActualCostCalcManageDBDAOLogActualCostCalcErrMsgUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * error log처리
	  * </pre>
	  */
	public ActualCostCalcManageDBDAOLogActualCostCalcErrMsgUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("err_rmk",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trsp_act_cost_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.trs.specialcargoquotationmanage.actualcostmanage.integration").append("\n"); 
		query.append("FileName : ActualCostCalcManageDBDAOLogActualCostCalcErrMsgUSQL").append("\n"); 
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
		query.append("UPDATE TRS_ACT_COST_HDR A" ).append("\n"); 
		query.append("SET A.EXE_STS_CD = 'E', A.EXE_TO_DT = SYSDATE, A.ERR_RMK = SUBSTRB(@[err_rmk]||DECODE(TRIM(A.ERR_RMK),NULL,'','','',' -- ')||A.ERR_RMK,1,4000)" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND A.TRSP_ACT_COST_SEQ = @[trsp_act_cost_seq]" ).append("\n"); 

	}
}