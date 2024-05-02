/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : RegionDepartureReportDBDAORDRCreVslMvmtRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.03.12
*@LastModifier : 장강철
*@LastVersion : 1.0
* 2010.03.12 장강철
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.opf.cargoloadingresultmgt.regiondeparturereport.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author jang kang cheol
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class RegionDepartureReportDBDAORDRCreVslMvmtRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * DESC Enter..
	  * </pre>
	  */
	public RegionDepartureReportDBDAORDRCreVslMvmtRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("region",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("port_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("voy_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.vop.opf.cargoloadingresultmgt.regiondeparturereport.integration").append("\n"); 
		query.append("FileName : RegionDepartureReportDBDAORDRCreVslMvmtRSQL").append("\n"); 
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
		query.append("SELECT M.PORT_CD  ," ).append("\n"); 
		query.append("TO_CHAR(M.ARRIVAL_DATE,'YYYY-MM-DD HH24:MI')   AS ARR_TIME," ).append("\n"); 
		query.append("TO_CHAR(M.BERTH_DATE,'YYYY-MM-DD HH24:MI')     AS BERTH_TIME," ).append("\n"); 
		query.append("TO_CHAR(M.UNBERTH_DATE,'YYYY-MM-DD HH24:MI')   AS UNBERTH_TIME," ).append("\n"); 
		query.append("TO_CHAR(M.DEPARTURE_DATE,'YYYY-MM-DD HH24:MI') AS DEP_TIME," ).append("\n"); 
		query.append("M.CALL_IND" ).append("\n"); 
		query.append("FROM   RDR_HEADER H, RDR_MOVE M" ).append("\n"); 
		query.append("WHERE  H.VSL_CD  = @[vsl_cd]" ).append("\n"); 
		query.append("AND    H.VOY_NO  = @[voy_no]" ).append("\n"); 
		query.append("AND    H.DIR_CD  = @[dir_cd]" ).append("\n"); 
		query.append("AND    H.REGION  = @[region]" ).append("\n"); 
		query.append("#if (${port_cd} != '')" ).append("\n"); 
		query.append("AND    H.PORT_CD  = @[port_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("AND    H.VSL_CD  = M.VSL_CD" ).append("\n"); 
		query.append("AND    H.VOY_NO  = M.VOY_NO" ).append("\n"); 
		query.append("AND    H.DIR_CD  = M.DIR_CD" ).append("\n"); 
		query.append("AND    H.REGION  = M.REGION" ).append("\n"); 
		query.append("ORDER  BY M.CALL_IND" ).append("\n"); 

	}
}