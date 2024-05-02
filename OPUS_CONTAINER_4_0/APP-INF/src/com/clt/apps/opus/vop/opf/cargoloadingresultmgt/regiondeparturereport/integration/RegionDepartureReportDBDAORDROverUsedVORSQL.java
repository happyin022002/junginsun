/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : RegionDepartureReportDBDAORDROverUsedVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.03.18
*@LastModifier : 장강철
*@LastVersion : 1.0
* 2010.03.18 장강철
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

public class RegionDepartureReportDBDAORDROverUsedVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * RDROverUsedVO Select Query
	  * </pre>
	  */
	public RegionDepartureReportDBDAORDROverUsedVORSQL(){
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
		query.append("FileName : RegionDepartureReportDBDAORDROverUsedVORSQL").append("\n"); 
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
		query.append("SELECT S.OPR_CD," ).append("\n"); 
		query.append("S.POL AS FROM_POD," ).append("\n"); 
		query.append("S.POD AS TO_POD," ).append("\n"); 
		query.append("SUM(NVL(S.QTY,0))                     OVER_SLOT," ).append("\n"); 
		query.append("SUM(NVL(S.WEIGHT,0))                    OVER_WGT," ).append("\n"); 
		query.append("S.CNTR_TYPE OVER_SET_BY" ).append("\n"); 
		query.append("FROM   RDR_HEADER H, RDR_SUMMARY S" ).append("\n"); 
		query.append("WHERE   H.VSL_CD = @[vsl_cd]" ).append("\n"); 
		query.append("AND     H.VOY_NO = @[voy_no]" ).append("\n"); 
		query.append("AND     H.DIR_CD = @[dir_cd]" ).append("\n"); 
		query.append("AND     H.REGION = @[region]" ).append("\n"); 
		query.append("#if (${port_cd} != '')" ).append("\n"); 
		query.append("AND    H.PORT_CD    = @[port_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${opr_cd} != '' && ${opr_cd} != 'All')" ).append("\n"); 
		query.append("AND    S.OPR_CD    = @[opr_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("AND    H.VSL_CD  = S.VSL_CD(+)" ).append("\n"); 
		query.append("AND    H.VOY_NO  = S.VOY_NO(+)" ).append("\n"); 
		query.append("AND    H.DIR_CD  = S.DIR_CD(+)" ).append("\n"); 
		query.append("AND    H.REGION  = S.REGION(+)" ).append("\n"); 
		query.append("AND    S.STATUS  = 'IP'" ).append("\n"); 
		query.append("GROUP BY S.OPR_CD, S.POL, S.POD, S.CNTR_TYPE" ).append("\n"); 
		query.append("ORDER BY OPR_CD" ).append("\n"); 

	}
}