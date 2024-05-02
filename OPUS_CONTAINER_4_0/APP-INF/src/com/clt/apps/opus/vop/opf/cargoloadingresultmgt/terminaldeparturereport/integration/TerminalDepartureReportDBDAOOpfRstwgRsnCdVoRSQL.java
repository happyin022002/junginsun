/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : TerminalDepartureReportDBDAOOpfRstwgRsnCdVoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.20
*@LastModifier : 
*@LastVersion : 1.0
* 2009.08.20 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.opf.cargoloadingresultmgt.terminaldeparturereport.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TerminalDepartureReportDBDAOOpfRstwgRsnCdVoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * DESC Enter..
	  * </pre>
	  */
	public TerminalDepartureReportDBDAOOpfRstwgRsnCdVoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rstwg_rsn_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.vop.opf.cargoloadingresultmgt.terminaldeparturereport.integration ").append("\n"); 
		query.append("FileName : TerminalDepartureReportDBDAOOpfRstwgRsnCdVoRSQL").append("\n"); 
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
		query.append("RSTWG_RSN_CD" ).append("\n"); 
		query.append(",	MAX(RSTWG_RSN_CD_FULL_DESC) AS RSTWG_RSN_CD_FULL_DESC" ).append("\n"); 
		query.append(",	DELT_FLG" ).append("\n"); 
		query.append("FROM OPF_RSTWG_RSN_CD" ).append("\n"); 
		query.append("WHERE DELT_FLG = 'N'" ).append("\n"); 
		query.append("AND	RSTWG_RSN_CD = @[rstwg_rsn_cd]" ).append("\n"); 
		query.append("GROUP BY RSTWG_RSN_CD, DELT_FLG" ).append("\n"); 
		query.append("ORDER BY RSTWG_RSN_CD" ).append("\n"); 

	}
}