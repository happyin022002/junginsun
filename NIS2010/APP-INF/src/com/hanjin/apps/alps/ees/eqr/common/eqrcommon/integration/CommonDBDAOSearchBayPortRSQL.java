/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CommonDBDAOSearchBayPortRSQL.java
*@FileTitle : Bay PLAN
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.04
*@LastModifier : 채창호
*@LastVersion : 1.0
* 2009.09.04 채창호
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.eqr.common.eqrcommon.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Chae Change Ho
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CommonDBDAOSearchBayPortRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 해당 VVD에 대한 BayPort List
	  * </pre>
	  */
	public CommonDBDAOSearchBayPortRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vvd_48",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vvd_04",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vvd_89",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.eqr.common.eqrcommon.integration").append("\n"); 
		query.append("FileName : CommonDBDAOSearchBayPortRSQL").append("\n"); 
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
		query.append("SELECT" ).append("\n"); 
		query.append("VPS_PORT_CD || '|' || SEQ AS NAME" ).append("\n"); 
		query.append(", VPS_PORT_CD AS CODE" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("DISTINCT VPS_PORT_CD" ).append("\n"); 
		query.append(", ROW_NUMBER() OVER(ORDER BY MAX(CRE_DT)) SEQ" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("OPF_BAY_PLN_LDIS" ).append("\n"); 
		query.append("WHERE" ).append("\n"); 
		query.append("VSL_CD				    = @[vvd_04]" ).append("\n"); 
		query.append("AND	SKD_VOY_NO			= @[vvd_48]" ).append("\n"); 
		query.append("AND	SKD_DIR_CD			= @[vvd_89]" ).append("\n"); 
		query.append("AND   FULL_MTY_CD		= 'E'" ).append("\n"); 
		query.append("AND   LODG_DCHG_IND_CD	in ( 'C','L')" ).append("\n"); 
		query.append("GROUP BY" ).append("\n"); 
		query.append("VPS_PORT_CD" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}