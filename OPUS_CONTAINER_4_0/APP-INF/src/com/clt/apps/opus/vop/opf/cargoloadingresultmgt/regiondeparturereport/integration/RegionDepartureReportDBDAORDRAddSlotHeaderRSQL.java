/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : RegionDepartureReportDBDAORDRAddSlotHeaderRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.03.04
*@LastModifier : 
*@LastVersion : 1.0
* 2011.03.04 
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

public class RegionDepartureReportDBDAORDRAddSlotHeaderRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * RDRAddSlotHeader Select Query
	  * </pre>
	  */
	public RegionDepartureReportDBDAORDRAddSlotHeaderRSQL(){
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
		query.append("FileName : RegionDepartureReportDBDAORDRAddSlotHeaderRSQL").append("\n"); 
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
		query.append("SELECT DISTINCT D.OPR_CD" ).append("\n"); 
		query.append("FROM   RDR_HEADER H, RDR_CNTR_DETAIL D" ).append("\n"); 
		query.append("WHERE  H.VSL_CD  = @[vsl_cd]" ).append("\n"); 
		query.append("AND    H.VOY_NO  = @[voy_no]" ).append("\n"); 
		query.append("AND    H.DIR_CD  = @[dir_cd]" ).append("\n"); 
		query.append("AND    H.REGION  = @[region] " ).append("\n"); 
		query.append("#if (${opr_cd} != '' && ${opr_cd} != 'All') " ).append("\n"); 
		query.append("AND    D.OPR_CD  = @[opr_cd] " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${port_cd} != '')" ).append("\n"); 
		query.append("AND    H.PORT_CD    = @[port_cd] " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("AND    H.VSL_CD  = D.VSL_CD" ).append("\n"); 
		query.append("AND    H.VOY_NO  = D.VOY_NO" ).append("\n"); 
		query.append("AND    H.DIR_CD  = D.DIR_CD" ).append("\n"); 
		query.append("AND    H.REGION  = D.REGION" ).append("\n"); 
		query.append("AND    D.CARGO_TYPE IN ('AK','BB')" ).append("\n"); 
		query.append("ORDER	BY D.OPR_CD" ).append("\n"); 

	}
}