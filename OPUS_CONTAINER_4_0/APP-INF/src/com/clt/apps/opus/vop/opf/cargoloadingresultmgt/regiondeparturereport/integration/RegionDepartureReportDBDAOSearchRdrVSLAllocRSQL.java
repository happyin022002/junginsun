/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : RegionDepartureReportDBDAOSearchRdrVSLAllocRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.03.11
*@LastModifier : 장강철
*@LastVersion : 1.0
* 2010.03.11 장강철
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

public class RegionDepartureReportDBDAOSearchRdrVSLAllocRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * RDR VSL ALLOCATION 조회
	  * </pre>
	  */
	public RegionDepartureReportDBDAOSearchRdrVSLAllocRSQL(){
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
		query.append("FileName : RegionDepartureReportDBDAOSearchRdrVSLAllocRSQL").append("\n"); 
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
		query.append("SELECT M.OPR_CD                                                                   AS OPR_CD," ).append("\n"); 
		query.append("SUM(M.BSA_SLOT)                                                           AS BASIC_SLOT," ).append("\n"); 
		query.append("SUM(M.RELEASE_SLOT)                                                       AS RELEASE_SLOT," ).append("\n"); 
		query.append("SUM(M.SWAP_SLOT)                                                          AS SWAP_SLOT," ).append("\n"); 
		query.append("NVL(SUM(M.BSA_SLOT),0)+NVL(SUM(M.RELEASE_SLOT),0)+NVL(SUM(M.SWAP_SLOT),0) AS TOT_ALLOC," ).append("\n"); 
		query.append("SUM(M.BSA_WGT)                                                            AS BASIC_WGT," ).append("\n"); 
		query.append("SUM(M.RELEASE_WGT)                                                        AS RELEASE_WGT," ).append("\n"); 
		query.append("SUM(M.SWAP_WGT)                                                           AS SWAP_WGT," ).append("\n"); 
		query.append("NVL(SUM(M.BSA_WGT),0)+NVL(SUM(M.RELEASE_WGT),0)+NVL(SUM(M.SWAP_WGT),0)    AS TOT_WGT," ).append("\n"); 
		query.append("M.BSA_TYPE                                                                AS BSA_TYPE," ).append("\n"); 
		query.append("SUM(NVL(B.TEU_WGT,0))                                                     AS TEU_WGT" ).append("\n"); 
		query.append("FROM   RDR_HEADER H, RDR_ALLOCATION M, RDR_BSA B" ).append("\n"); 
		query.append("WHERE  H.VSL_CD     = @[vsl_cd]" ).append("\n"); 
		query.append("AND    H.VOY_NO     = @[voy_no]" ).append("\n"); 
		query.append("AND    H.DIR_CD     = @[dir_cd]" ).append("\n"); 
		query.append("AND    H.REGION  	= @[region]" ).append("\n"); 
		query.append("#if (${port_cd} != '')" ).append("\n"); 
		query.append("AND    H.PORT_CD  	= @[port_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("AND    H.VSL_CD     = M.VSL_CD" ).append("\n"); 
		query.append("AND    H.VOY_NO     = M.VOY_NO" ).append("\n"); 
		query.append("AND    H.DIR_CD     = M.DIR_CD" ).append("\n"); 
		query.append("AND    H.REGION     = M.REGION" ).append("\n"); 
		query.append("AND    M.VSL_CD     = B.VSL_CD(+)" ).append("\n"); 
		query.append("AND    M.VOY_NO     = B.VOY_NO(+)" ).append("\n"); 
		query.append("AND    M.DIR_CD     = B.DIR_CD(+)" ).append("\n"); 
		query.append("AND    M.REGION     = B.REGION(+)" ).append("\n"); 
		query.append("AND    M.OPR_CD     = B.OPR_CD(+)" ).append("\n"); 
		query.append("GROUP BY M.OPR_CD, M.BSA_TYPE" ).append("\n"); 
		query.append("ORDER BY M.OPR_CD" ).append("\n"); 

	}
}