/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CodSimulateDBDAOSearchBasisPortRSQL.java
*@FileTitle : Bay PLAN
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.04
*@LastModifier : 채창호
*@LastVersion : 1.0
* 2009.09.04 채창호
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.eqr.simulationmanage.codsimulate.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Chae Change Ho
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CodSimulateDBDAOSearchBasisPortRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * OPF_BAY_PLN_LDIS에서 calling port 정보 검색
	  * </pre>
	  */
	public CodSimulateDBDAOSearchBasisPortRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("skd_dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("skd_voy_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.eqr.simulationmanage.codsimulate.integration").append("\n"); 
		query.append("FileName : CodSimulateDBDAOSearchBasisPortRSQL").append("\n"); 
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
		query.append("SELECT	VPS_PORT_CD AS BASIS" ).append("\n"); 
		query.append("FROM	(" ).append("\n"); 
		query.append("SELECT  DISTINCT VPS_PORT_CD" ).append("\n"); 
		query.append(", ROW_NUMBER() OVER(ORDER BY MAX(CRE_DT)) SEQ" ).append("\n"); 
		query.append("FROM    OPF_BAY_PLN_LDIS" ).append("\n"); 
		query.append("WHERE   VSL_CD			= @[vsl_cd]" ).append("\n"); 
		query.append("AND	    SKD_VOY_NO		= @[skd_voy_no]" ).append("\n"); 
		query.append("AND	    SKD_DIR_CD		= @[skd_dir_cd]" ).append("\n"); 
		query.append("AND     FULL_MTY_CD		= 'E'" ).append("\n"); 
		query.append("AND     LODG_DCHG_IND_CD	in  ('C','L')" ).append("\n"); 
		query.append("GROUP BY VPS_PORT_CD" ).append("\n"); 
		query.append("ORDER BY SEQ DESC )" ).append("\n"); 
		query.append("WHERE	ROWNUM = 1" ).append("\n"); 

	}
}