/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : RegionDepartureReportDBDAOSearchRdrSltWgtUtilRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.04.28
*@LastModifier : 장강철
*@LastVersion : 1.0
* 2010.04.28 장강철
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

public class RegionDepartureReportDBDAOSearchRdrSltWgtUtilRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * RDR Slot/WGT Util 정보를 조회한다. (메인 조회)
	  * </pre>
	  */
	public RegionDepartureReportDBDAOSearchRdrSltWgtUtilRSQL(){
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
		query.append("Path : com.hanjin.apps.alps.vop.opf.cargoloadingresultmgt.regiondeparturereport.integration").append("\n"); 
		query.append("FileName : RegionDepartureReportDBDAOSearchRdrSltWgtUtilRSQL").append("\n"); 
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
		query.append("/*****EXT*****/" ).append("\n"); 
		query.append("SELECT M.OPR_CD																				 AS OPR_CD" ).append("\n"); 
		query.append(",       SUM(DECODE(M.TYPE,'F',M.SLOT_QTY,0))                                                  AS FULL" ).append("\n"); 
		query.append(",       SUM(DECODE(M.TYPE,'E',M.SLOT_QTY,0))                                                  AS EMPTY" ).append("\n"); 
		query.append(",       SUM(DECODE(M.TYPE,'A',M.SLOT_QTY,0))                                                  AS AKBB" ).append("\n"); 
		query.append(",       SUM(DECODE(M.TYPE,'3',M.SLOT_QTY,'H',M.SLOT_QTY,'L',M.SLOT_QTY,0))                                   AS HC45" ).append("\n"); 
		query.append(",       SUM(DECODE(M.TYPE,'F',M.SLOT_QTY,0))+SUM(DECODE(M.TYPE,'E',M.SLOT_QTY,0))+" ).append("\n"); 
		query.append("+SUM(DECODE(M.TYPE,'A',M.SLOT_QTY,0))+SUM(DECODE(M.TYPE,'3',M.SLOT_QTY,0))+SUM(DECODE(M.TYPE,'H',M.SLOT_QTY,'L',M.SLOT_QTY,0)) AS TOTAL_SLOT" ).append("\n"); 
		query.append(",       SUM(DECODE(M.TYPE,'F',M.WEIGHT,0))                AS total_wgt" ).append("\n"); 
		query.append("FROM   RDR_HEADER H, RDR_UTILIZE M" ).append("\n"); 
		query.append("WHERE  H.VSL_CD     = @[vsl_cd]" ).append("\n"); 
		query.append("AND    H.VOY_NO     = @[voy_no]" ).append("\n"); 
		query.append("AND    H.DIR_CD     = @[dir_cd]" ).append("\n"); 
		query.append("AND    H.REGION  	= @[region]" ).append("\n"); 
		query.append("#if (${port_cd} != '')" ).append("\n"); 
		query.append("AND    H.PORT_CD  = @[port_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("AND    H.VSL_CD    = M.VSL_CD" ).append("\n"); 
		query.append("AND    H.VOY_NO    = M.VOY_NO" ).append("\n"); 
		query.append("AND    H.DIR_CD    = M.DIR_CD" ).append("\n"); 
		query.append("AND    H.REGION    = M.REGION" ).append("\n"); 
		query.append("GROUP BY M.OPR_CD" ).append("\n"); 
		query.append("HAVING" ).append("\n"); 
		query.append("SUM( CASE WHEN M.TYPE IN ('F','E','A') THEN M.SLOT_QTY ELSE 0 END ) > 0" ).append("\n"); 
		query.append("OR   SUM( NVL(M.SLOT_HC20,0) )+SUM( NVL(M.SLOT_HC,0)  )+SUM( NVL(M.SLOT_45,0) ) >0" ).append("\n"); 
		query.append("ORDER  BY M.OPR_CD" ).append("\n"); 

	}
}