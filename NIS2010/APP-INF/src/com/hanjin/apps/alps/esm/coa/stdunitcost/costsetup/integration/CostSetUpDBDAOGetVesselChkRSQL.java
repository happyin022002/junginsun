/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : CostSetUpDBDAOGetVesselChkRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.07.21
*@LastModifier : 최덕우
*@LastVersion : 1.0
* 2014.07.21 최덕우
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.coa.stdunitcost.costsetup.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Choi Duk Woo
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CostSetUpDBDAOGetVesselChkRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * vessel check
	  * </pre>
	  */
	public CostSetUpDBDAOGetVesselChkRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.coa.stdunitcost.costsetup.integration").append("\n"); 
		query.append("FileName : CostSetUpDBDAOGetVesselChkRSQL").append("\n"); 
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
		query.append("SELECT COUNT(VSL_CD) AS VSL_CNT FROM COA_VSL_RGST" ).append("\n"); 
		query.append("WHERE VSL_CD = @[vsl_cd]" ).append("\n"); 

	}
}