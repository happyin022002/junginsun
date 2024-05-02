/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : RegionDepartureReportDBDAORDRRemarkVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.03.29
*@LastModifier : 장강철
*@LastVersion : 1.0
* 2010.03.29 장강철
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

public class RegionDepartureReportDBDAORDRRemarkVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * RDRRemark Select Query
	  * </pre>
	  */
	public RegionDepartureReportDBDAORDRRemarkVORSQL(){
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
		query.append("FileName : RegionDepartureReportDBDAORDRRemarkVORSQL").append("\n"); 
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
		query.append("SELECT H.REMARK," ).append("\n"); 
		query.append("H.PORT_CD," ).append("\n"); 
		query.append("(SELECT LOC_NM" ).append("\n"); 
		query.append("FROM   MDM_LOCATION" ).append("\n"); 
		query.append("WHERE  LOC_CD = H.PORT_CD ) PORT_CD_NM" ).append("\n"); 
		query.append("FROM   RDR_HEADER H" ).append("\n"); 
		query.append("WHERE  H.VSL_CD  = @[vsl_cd]" ).append("\n"); 
		query.append("AND    H.VOY_NO  = @[voy_no]" ).append("\n"); 
		query.append("AND    H.DIR_CD  = @[dir_cd]" ).append("\n"); 
		query.append("AND    H.REGION  = @[region]" ).append("\n"); 
		query.append("AND    ROWNUM = 1" ).append("\n"); 

	}
}