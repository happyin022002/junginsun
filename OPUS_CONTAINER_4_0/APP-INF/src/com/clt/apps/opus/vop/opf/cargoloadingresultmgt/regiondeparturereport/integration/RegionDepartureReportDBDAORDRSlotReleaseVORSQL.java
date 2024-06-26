/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : RegionDepartureReportDBDAORDRSlotReleaseVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.03.14
*@LastModifier : 장강철
*@LastVersion : 1.0
* 2010.03.14 장강철
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

public class RegionDepartureReportDBDAORDRSlotReleaseVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * RDRSlotReleaseVO Select Query
	  * </pre>
	  */
	public RegionDepartureReportDBDAORDRSlotReleaseVORSQL(){
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
		query.append("FileName : RegionDepartureReportDBDAORDRSlotReleaseVORSQL").append("\n"); 
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
		query.append("SELECT M.OPR_CD      AS FM_CARR_CD," ).append("\n"); 
		query.append("V.CRR_NM 	 AS FM_CARR_NM," ).append("\n"); 
		query.append("M.TO_OPR      AS TO_CARR_CD," ).append("\n"); 
		query.append("T.CRR_NM      AS TO_CARR_NM," ).append("\n"); 
		query.append("SUM(M.SLOT)   AS TEU," ).append("\n"); 
		query.append("SUM(M.WEIGHT) AS WEIGHT," ).append("\n"); 
		query.append("A.BSA_TYPE    AS TYPE" ).append("\n"); 
		query.append("FROM   RDR_HEADER H, RDR_SLOT_RELEASE M, RDR_ALLOCATION A, MDM_CARRIER V, MDM_CARRIER T" ).append("\n"); 
		query.append("WHERE  H.VSL_CD     = @[vsl_cd]" ).append("\n"); 
		query.append("AND    H.VOY_NO     = @[voy_no]" ).append("\n"); 
		query.append("AND    H.DIR_CD     = @[dir_cd]" ).append("\n"); 
		query.append("AND    H.REGION  	= @[region]" ).append("\n"); 
		query.append("#if (${opr_cd} != '' && ${opr_cd} != 'All')" ).append("\n"); 
		query.append("AND    M.OPR_CD    = @[opr_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${port_cd} != '')" ).append("\n"); 
		query.append("AND    H.PORT_CD    = @[port_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("AND    H.VSL_CD     = M.VSL_CD" ).append("\n"); 
		query.append("AND    H.VOY_NO     = M.VOY_NO" ).append("\n"); 
		query.append("AND    H.DIR_CD     = M.DIR_CD" ).append("\n"); 
		query.append("AND    H.REGION     = M.REGION" ).append("\n"); 
		query.append("AND    M.OPR_CD     = V.CRR_CD" ).append("\n"); 
		query.append("AND    M.TO_OPR     = T.CRR_CD" ).append("\n"); 
		query.append("AND    M.OPR_CD		= A.OPR_CD" ).append("\n"); 
		query.append("AND    H.VSL_CD     = A.VSL_CD" ).append("\n"); 
		query.append("AND    H.VOY_NO     = A.VOY_NO" ).append("\n"); 
		query.append("AND    H.DIR_CD     = A.DIR_CD" ).append("\n"); 
		query.append("AND    H.REGION     = A.REGION" ).append("\n"); 
		query.append("GROUP BY M.OPR_CD, V.CRR_NM, M.TO_OPR, T.CRR_NM, A.BSA_TYPE" ).append("\n"); 
		query.append("ORDER BY M.OPR_CD, M.TO_OPR" ).append("\n"); 

	}
}