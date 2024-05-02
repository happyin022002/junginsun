/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : RegionDepartureReportDBDAOSearchRdrHeaderCheckRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.03.22
*@LastModifier : 
*@LastVersion : 1.0
* 2011.03.22 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.opf.cargoloadingresultmgt.regiondeparturereport.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class RegionDepartureReportDBDAOSearchRdrHeaderCheckRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * DESC Enter..
	  * </pre>
	  */
	public RegionDepartureReportDBDAOSearchRdrHeaderCheckRSQL(){
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
		query.append("FileName : RegionDepartureReportDBDAOSearchRdrHeaderCheckRSQL").append("\n"); 
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
		query.append("SELECT  A.VSL_CD" ).append("\n"); 
		query.append(",       A.VOY_NO" ).append("\n"); 
		query.append(",       A.DIR_CD" ).append("\n"); 
		query.append(",       A.REGION" ).append("\n"); 
		query.append(",       A.PORT_CD" ).append("\n"); 
		query.append(",       A.RDR_DATE" ).append("\n"); 
		query.append(",       A.RDR_USER" ).append("\n"); 
		query.append(",       A.REMARK" ).append("\n"); 
		query.append(",       A.UPDATE_USER" ).append("\n"); 
		query.append(",       A.UPDATE_TIME" ).append("\n"); 
		query.append(",       A.NEXT_PORT" ).append("\n"); 
		query.append("FROM    RDR_HEADER A " ).append("\n"); 
		query.append("WHERE   A.VSL_CD    = @[vsl_cd]" ).append("\n"); 
		query.append("AND     A.VOY_NO    = @[voy_no] " ).append("\n"); 
		query.append("AND     A.DIR_CD    = @[dir_cd] " ).append("\n"); 
		query.append("AND     A.REGION    = @[region]" ).append("\n"); 

	}
}