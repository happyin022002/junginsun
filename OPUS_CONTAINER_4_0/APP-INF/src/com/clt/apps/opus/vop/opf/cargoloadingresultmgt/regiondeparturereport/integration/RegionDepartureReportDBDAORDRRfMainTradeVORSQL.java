/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : RegionDepartureReportDBDAORDRRfMainTradeVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.11.29
*@LastModifier : 
*@LastVersion : 1.0
* 2016.11.29 
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

public class RegionDepartureReportDBDAORDRRfMainTradeVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * RDRRfMainTradeVO
	  * </pre>
	  */
	public RegionDepartureReportDBDAORDRRfMainTradeVORSQL(){
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
		params.put("opr_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("FileName : RegionDepartureReportDBDAORDRRfMainTradeVORSQL").append("\n"); 
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
		query.append("SELECT M.OPR_CD                                     AS OPR_CD," ).append("\n"); 
		query.append("       M.POL                                        AS POL," ).append("\n"); 
		query.append("       M.POD                                        AS POD," ).append("\n"); 
		query.append("       SUM(DECODE(M.CNTR_SIZE,'2',1,'3',1,'A',1,0))       AS QTY_20," ).append("\n"); 
		query.append("       SUM(DECODE(M.CNTR_SIZE,'4',1,'H',1,'L',1,'B',1,0)) AS QTY_40" ).append("\n"); 
		query.append("FROM   RDR_HEADER H, RDR_CNTR_DETAIL M" ).append("\n"); 
		query.append("WHERE  H.VSL_CD     = @[vsl_cd] " ).append("\n"); 
		query.append("AND    H.VOY_NO     = @[voy_no] " ).append("\n"); 
		query.append("AND    H.DIR_CD     = @[dir_cd] " ).append("\n"); 
		query.append("AND    H.REGION  	= @[region] " ).append("\n"); 
		query.append("#if (${opr_cd} != '' && ${opr_cd} != 'All') " ).append("\n"); 
		query.append("AND    M.OPR_CD    = @[opr_cd] " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${port_cd} != '')" ).append("\n"); 
		query.append("AND    H.PORT_CD    = @[port_cd] " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("AND    H.VSL_CD     = M.VSL_CD" ).append("\n"); 
		query.append("AND    H.VOY_NO     = M.VOY_NO" ).append("\n"); 
		query.append("AND    H.DIR_CD     = M.DIR_CD" ).append("\n"); 
		query.append("AND    H.REGION     = M.REGION" ).append("\n"); 
		query.append("AND    M.TEMP IS NOT NULL" ).append("\n"); 
		query.append("AND    M.CARGO_TYPE != 'IR'" ).append("\n"); 
		query.append("GROUP BY M.OPR_CD, M.POL, M.POD" ).append("\n"); 
		query.append("/*** 2. Internally ****/" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT S.OPR_CD" ).append("\n"); 
		query.append(",      S.POL" ).append("\n"); 
		query.append(",      S.POD" ).append("\n"); 
		query.append(",      SUM(DECODE(S.CNTR_SIZE,'2',QTY,'A',QTY,0)) QTY_20" ).append("\n"); 
		query.append(",      SUM(DECODE(S.CNTR_SIZE,'4',QTY,'B',QTY,0)) QTY_40" ).append("\n"); 
		query.append("FROM   RDR_HEADER H, RDR_SUMMARY S" ).append("\n"); 
		query.append("WHERE  H.VSL_CD     = @[vsl_cd] " ).append("\n"); 
		query.append("AND    H.VOY_NO     = @[voy_no] " ).append("\n"); 
		query.append("AND    H.DIR_CD     = @[dir_cd] " ).append("\n"); 
		query.append("AND    H.REGION  	= @[region] " ).append("\n"); 
		query.append("#if (${opr_cd} != '' && ${opr_cd} != 'All') " ).append("\n"); 
		query.append("AND    S.OPR_CD    = @[opr_cd] " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${port_cd} != '')" ).append("\n"); 
		query.append("AND    H.PORT_CD    = @[port_cd] " ).append("\n"); 
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