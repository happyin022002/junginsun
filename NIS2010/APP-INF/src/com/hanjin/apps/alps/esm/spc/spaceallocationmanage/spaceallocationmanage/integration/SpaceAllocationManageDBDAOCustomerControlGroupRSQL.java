/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : SpaceAllocationManageDBDAOCustomerControlGroupRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.04.07
*@LastModifier : 
*@LastVersion : 1.0
* 2015.04.07 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.spc.spaceallocationmanage.spaceallocationmanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SpaceAllocationManageDBDAOCustomerControlGroupRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * VO용
	  * </pre>
	  */
	public SpaceAllocationManageDBDAOCustomerControlGroupRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("yrwk",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trd_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.spc.spaceallocationmanage.spaceallocationmanage.integration").append("\n"); 
		query.append("FileName : SpaceAllocationManageDBDAOCustomerControlGroupRSQL").append("\n"); 
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
		query.append("SELECT SUBSTR(CUST_CTRL_CD,1,1) || " ).append("\n"); 
		query.append("       SUBSTR(CUST_CTRL_CD,2)   AS CUST_CTRL_CD," ).append("\n"); 
		query.append("TRD_CD , '' AS YRWK" ).append("\n"); 
		query.append("FROM SPC_MDL_CUST_CTRL_GRP G" ).append("\n"); 
		query.append("WHERE " ).append("\n"); 
		query.append("	TRD_CD = @[trd_cd]   AND " ).append("\n"); 
		query.append("	COST_YRWK = NVL(null, (" ).append("\n"); 
		query.append("        SELECT /*+INDEX_DESC (M XPKSPC_MDL_VER_MST) */" ).append("\n"); 
		query.append("            M.COST_YRWK" ).append("\n"); 
		query.append("        FROM SPC_MDL_VER_MST M" ).append("\n"); 
		query.append("        WHERE @[yrwk] BETWEEN M.VER_ST_YRWK AND M.VER_END_YRWK" ).append("\n"); 
		query.append("        	AND M.CFM_FLG = 'Y'" ).append("\n"); 
		query.append("	        AND M.TRD_CD  = G.TRD_CD" ).append("\n"); 
		query.append("    	    AND ROWNUM    = 1" ).append("\n"); 
		query.append("        )" ).append("\n"); 
		query.append("    )" ).append("\n"); 

	}
}