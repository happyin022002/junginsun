/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : OptimizeddistancemgtDBDAOSearchYardGroupRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.02.19
*@LastModifier : 
*@LastVersion : 1.0
* 2014.02.19 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.vsk.vesseloperationsupportmgt.optimizeddistancemgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class OptimizeddistancemgtDBDAOSearchYardGroupRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Port정보를 통해 해당 Yard그룹정보를 조회한다.
	  * </pre>
	  */
	public OptimizeddistancemgtDBDAOSearchYardGroupRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("port_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.vop.vsk.vesseloperationsupportmgt.optimizeddistancemgt.integration").append("\n"); 
		query.append("FileName : OptimizeddistancemgtDBDAOSearchYardGroupRSQL").append("\n"); 
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
		query.append("SELECT   SUBSTR(A.YD_CD, 1, 5) AS PORT_CD" ).append("\n"); 
		query.append("       , SUBSTR(A.YD_CD, 6, 7) AS TMNL_CD" ).append("\n"); 
		query.append("	   , A.YD_CD AS YD_CD" ).append("\n"); 
		query.append("       , A.YD_NM AS YD_NM" ).append("\n"); 
		query.append("       , B.YD_GRP_ID AS YD_GRP_ID" ).append("\n"); 
		query.append("  FROM MDM_YARD A, VSK_YD_GRP B " ).append("\n"); 
		query.append(" WHERE 1=1" ).append("\n"); 
		query.append("   AND A.YD_CD = B.YD_CD (+)" ).append("\n"); 
		query.append("   AND A.YD_FCTY_TP_MRN_TML_FLG = 'Y' " ).append("\n"); 
		query.append("   AND A.DELT_FLG = 'N'" ).append("\n"); 
		query.append("   AND A.LOC_CD LIKE @[port_cd] " ).append("\n"); 
		query.append("   ORDER BY B.YD_GRP_ID " ).append("\n"); 

	}
}