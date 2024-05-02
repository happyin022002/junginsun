/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : RegionDepartureReportDBDAOSearchRdrMoveRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.03.05
*@LastModifier : 장강철
*@LastVersion : 1.0
* 2010.03.05 장강철
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.opf.cargoloadingresultmgt.regiondeparturereport.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author jang kang cheol
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class RegionDepartureReportDBDAOSearchRdrMoveRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * DESC Enter..
	  * </pre>
	  */
	public RegionDepartureReportDBDAOSearchRdrMoveRSQL(){
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
		params.put("call_ind",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("Path : com.hanjin.apps.alps.vop.opf.cargoloadingresultmgt.regiondeparturereport.integration").append("\n"); 
		query.append("FileName : RegionDepartureReportDBDAOSearchRdrMoveRSQL").append("\n"); 
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
		query.append("SELECT   A.VOY_NO" ).append("\n"); 
		query.append(",        A.DIR_CD" ).append("\n"); 
		query.append(",        A.PORT_CD" ).append("\n"); 
		query.append(",        A.CALL_IND" ).append("\n"); 
		query.append(",        A.ARRIVAL_DATE" ).append("\n"); 
		query.append(",        A.BERTH_DATE" ).append("\n"); 
		query.append(",        A.UNBERTH_DATE" ).append("\n"); 
		query.append(",        A.DEPARTURE_DATE" ).append("\n"); 
		query.append(",        A.IDX" ).append("\n"); 
		query.append(",        A.VSL_CD" ).append("\n"); 
		query.append(",        A.REGION" ).append("\n"); 
		query.append(",        A.UPDATE_USER" ).append("\n"); 
		query.append(",        A.UPDATE_TIME" ).append("\n"); 
		query.append("FROM     RDR_MOVE A" ).append("\n"); 
		query.append("WHERE    A.VSL_CD     = @[vsl_cd]" ).append("\n"); 
		query.append("AND      A.VOY_NO     = @[voy_no]" ).append("\n"); 
		query.append("AND      A.DIR_CD     = @[dir_cd]" ).append("\n"); 
		query.append("AND      A.PORT_CD    = @[port_cd]" ).append("\n"); 
		query.append("AND      A.CALL_IND   = @[call_ind]" ).append("\n"); 
		query.append("AND      A.REGION     = @[region]" ).append("\n"); 

	}
}