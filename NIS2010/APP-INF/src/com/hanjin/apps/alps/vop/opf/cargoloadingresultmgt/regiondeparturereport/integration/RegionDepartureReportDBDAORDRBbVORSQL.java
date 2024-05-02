/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : RegionDepartureReportDBDAORDRBbVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.03.20
*@LastModifier : 장강철
*@LastVersion : 1.0
* 2010.03.20 장강철
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

public class RegionDepartureReportDBDAORDRBbVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * RDRBbVO Select Query
	  * </pre>
	  */
	public RegionDepartureReportDBDAORDRBbVORSQL(){
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
		query.append("Path : com.hanjin.apps.alps.vop.opf.cargoloadingresultmgt.regiondeparturereport.integration").append("\n"); 
		query.append("FileName : RegionDepartureReportDBDAORDRBbVORSQL").append("\n"); 
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
		query.append("SELECT M.OPR_CD    AS OPR_CD," ).append("\n"); 
		query.append("M.POL       AS POL," ).append("\n"); 
		query.append("M.POD_ISO   AS POD," ).append("\n"); 
		query.append("M.CNTR_NO   AS CNTR_NO," ).append("\n"); 
		query.append("M.SZTP      AS TYPE_SIZE," ).append("\n"); 
		query.append("M.POSITION  AS CELL_NO," ).append("\n"); 
		query.append("M.DML       AS DML," ).append("\n"); 
		query.append("M.DMB       AS DMB," ).append("\n"); 
		query.append("M.DMH       AS DMH," ).append("\n"); 
		query.append("M.WEIGHT    AS WEIGHT," ).append("\n"); 
		query.append("UNIT        AS UNIT," ).append("\n"); 
		query.append("M.SLOT      AS SLOT," ).append("\n"); 
		query.append("M.CRANE     AS CRANE," ).append("\n"); 
		query.append("M.COMMENCE  AS FM_WORK," ).append("\n"); 
		query.append("M.COMPLETE  AS TO_WORK" ).append("\n"); 
		query.append("FROM   RDR_HEADER H, RDR_CNTR_DETAIL M" ).append("\n"); 
		query.append("WHERE  H.VSL_CD     = @[vsl_cd]" ).append("\n"); 
		query.append("AND    H.VOY_NO     = @[voy_no]" ).append("\n"); 
		query.append("AND    H.DIR_CD     = @[dir_cd]" ).append("\n"); 
		query.append("AND    H.REGION  	= @[region]" ).append("\n"); 
		query.append("#if (${opr_cd} != '' && ${opr_cd} != 'All')" ).append("\n"); 
		query.append("AND    M.OPR_CD    = @[opr_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${port_cd} != '' )" ).append("\n"); 
		query.append("AND    H.PORT_CD    = @[port_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("AND    H.VSL_CD     = M.VSL_CD" ).append("\n"); 
		query.append("AND    H.VOY_NO     = M.VOY_NO" ).append("\n"); 
		query.append("AND    H.DIR_CD     = M.DIR_CD" ).append("\n"); 
		query.append("AND    H.REGION     = M.REGION" ).append("\n"); 
		query.append("AND    M.CARGO_TYPE = 'BB'" ).append("\n"); 
		query.append("ORDER BY M.OPR_CD, M.POL, M.POD, M.CNTR_NO, M.SZTP" ).append("\n"); 

	}
}