/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : MultiDimensionRPTDBDAORemovePnlRptItemDSQL.java
*@FileTitle : P/L Report Item Management 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.04.19
*@LastModifier : 문동선
*@LastVersion : 1.0
* 2012.04.19 문동선
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.coa.multidimensionrpt.multidimensionrpt.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Dong-Sun Moon
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class MultiDimensionRPTDBDAORemovePnlRptItemDSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Delete Query for ESM_COA_2003
	  * </pre>
	  */
	public MultiDimensionRPTDBDAORemovePnlRptItemDSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rpt_vw_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("stnd_cost_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.coa.multidimensionrpt.multidimensionrpt.integration ").append("\n"); 
		query.append("FileName : MultiDimensionRPTDBDAORemovePnlRptItemDSQL").append("\n"); 
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
		query.append("DELETE COA_PFIT_LSS_RPT_ITM " ).append("\n"); 
		query.append("WHERE RPT_VW_CD = @[rpt_vw_cd] " ).append("\n"); 
		query.append("   AND STND_COST_CD = @[stnd_cost_cd]" ).append("\n"); 

	}
}