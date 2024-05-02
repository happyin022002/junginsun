/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : RegionDepartureReportDBDAOSearchRdrRfListMainTradeRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.03.16
*@LastModifier : 장강철
*@LastVersion : 1.0
* 2010.03.16 장강철
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

public class RegionDepartureReportDBDAOSearchRdrRfListMainTradeRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * DESC Enter..
	  * </pre>
	  */
	public RegionDepartureReportDBDAOSearchRdrRfListMainTradeRSQL(){
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
		query.append("FileName : RegionDepartureReportDBDAOSearchRdrRfListMainTradeRSQL").append("\n"); 
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
		query.append("/*** 1. Externally ****/" ).append("\n"); 
		query.append("SELECT  M.OPR_CD                                     AS OPR_CD," ).append("\n"); 
		query.append("M.POL                                        AS POL," ).append("\n"); 
		query.append("M.POD_ISO                                    AS POD," ).append("\n"); 
		query.append("SUM(DECODE(M.CNTR_SIZE,'2',1,'3',1,0))       AS QTY_20," ).append("\n"); 
		query.append("SUM(DECODE(M.CNTR_SIZE,'4',1,'H',1,'L',1,0)) AS QTY_40" ).append("\n"); 
		query.append("FROM   RDR_HEADER H, RDR_CNTR_DETAIL M" ).append("\n"); 
		query.append("WHERE  H.VSL_CD     = @[vsl_cd]" ).append("\n"); 
		query.append("AND    H.VOY_NO     = @[voy_no]" ).append("\n"); 
		query.append("AND    H.DIR_CD     = @[dir_cd]" ).append("\n"); 
		query.append("AND    H.REGION     = @[region]" ).append("\n"); 
		query.append("#if (${port_cd} != '')" ).append("\n"); 
		query.append("AND    H.PORT_CD  = @[port_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("AND    H.VSL_CD     = M.VSL_CD" ).append("\n"); 
		query.append("AND    H.VOY_NO     = M.VOY_NO" ).append("\n"); 
		query.append("AND    H.DIR_CD     = M.DIR_CD" ).append("\n"); 
		query.append("AND    H.REGION     = M.REGION" ).append("\n"); 
		query.append("AND    M.TEMP IS NOT NULL" ).append("\n"); 
		query.append("AND    M.CARGO_TYPE != 'IR'" ).append("\n"); 
		query.append("GROUP BY M.OPR_CD, M.POL, M.POD_ISO" ).append("\n"); 
		query.append("/*** 2. Internally ****/" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT S.OPR_CD," ).append("\n"); 
		query.append("S.POL," ).append("\n"); 
		query.append("S.POD," ).append("\n"); 
		query.append("SUM(DECODE(S.CNTR_SIZE,'2',QTY,0)) QTY_20," ).append("\n"); 
		query.append("SUM(DECODE(S.CNTR_SIZE,'4',QTY,0)) QTY_40" ).append("\n"); 
		query.append("FROM   RDR_HEADER H, RDR_SUMMARY S" ).append("\n"); 
		query.append("WHERE  H.VSL_CD     = @[vsl_cd]" ).append("\n"); 
		query.append("AND    H.VOY_NO     = @[voy_no]" ).append("\n"); 
		query.append("AND    H.DIR_CD     = @[dir_cd]" ).append("\n"); 
		query.append("AND    H.REGION     = @[region]" ).append("\n"); 
		query.append("#if (${port_cd} != '')" ).append("\n"); 
		query.append("AND    H.PORT_CD  = @[port_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("AND    H.VSL_CD     = S.VSL_CD" ).append("\n"); 
		query.append("AND    H.VOY_NO     = S.VOY_NO" ).append("\n"); 
		query.append("AND    H.DIR_CD     = S.DIR_CD" ).append("\n"); 
		query.append("AND    H.REGION     = S.REGION" ).append("\n"); 
		query.append("AND    S.CNTR_TYPE  = 'T'" ).append("\n"); 
		query.append("GROUP BY S.OPR_CD, S.POL, S.POD" ).append("\n"); 
		query.append("ORDER BY  OPR_CD,  POL, POD" ).append("\n"); 

	}
}