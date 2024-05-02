/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : RegionDepartureReportDBDAORDRAddSlotVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.04.06
*@LastModifier : 
*@LastVersion : 1.0
* 2016.04.06 
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

public class RegionDepartureReportDBDAORDRAddSlotVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * RDRAddSlotVO Select Query
	  * </pre>
	  */
	public RegionDepartureReportDBDAORDRAddSlotVORSQL(){
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
		params.put("opt_opr_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("FileName : RegionDepartureReportDBDAORDRAddSlotVORSQL").append("\n"); 
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
		query.append("SELECT	POL, POD" ).append("\n"); 
		query.append("#foreach($key IN ${opr_cd}) " ).append("\n"); 
		query.append("	#if($velocityCount < 10)" ).append("\n"); 
		query.append("		, SUM(CASE WHEN	OPR_CD	= '$key' THEN QTY ELSE null END) AS opr_qty_0$velocityCount" ).append("\n"); 
		query.append("	#else" ).append("\n"); 
		query.append("		, SUM(CASE WHEN	OPR_CD	= '$key' THEN QTY ELSE null END) AS opr_qty_$velocityCount" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("#end " ).append("\n"); 
		query.append("		, SUM(QTY) AS total" ).append("\n"); 
		query.append("FROM(" ).append("\n"); 
		query.append("	SELECT M.POL, M.POD, M.OPR_CD, SUM(SLOT) QTY, 1 ROW_NUM                                      " ).append("\n"); 
		query.append("	FROM   RDR_HEADER H, RDR_CNTR_DETAIL M" ).append("\n"); 
		query.append("	WHERE  H.VSL_CD  = @[vsl_cd] " ).append("\n"); 
		query.append("	AND    H.VOY_NO  = @[voy_no] " ).append("\n"); 
		query.append("	AND    H.DIR_CD  = @[dir_cd]" ).append("\n"); 
		query.append("	AND    H.REGION  = @[region]" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${opt_opr_cd} != '' && ${opt_opr_cd} != 'All')" ).append("\n"); 
		query.append("AND    M.OPR_CD    = @[opt_opr_cd] " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${port_cd} != '') " ).append("\n"); 
		query.append("	AND    H.PORT_CD  = @[port_cd] " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("	AND    H.VSL_CD  = M.VSL_CD                                                                      " ).append("\n"); 
		query.append("	AND    H.VOY_NO  = M.VOY_NO                                                                      " ).append("\n"); 
		query.append("	AND    H.DIR_CD  = M.DIR_CD                                                                      " ).append("\n"); 
		query.append("	AND    H.REGION  = M.REGION                                                                      " ).append("\n"); 
		query.append("	AND    M.CARGO_TYPE IN ('AK','BB')                                                               " ).append("\n"); 
		query.append("	GROUP BY M.POL, M.POD, M.OPR_CD" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("GROUP BY POL, POD" ).append("\n"); 
		query.append("ORDER BY POL, POD" ).append("\n"); 

	}
}