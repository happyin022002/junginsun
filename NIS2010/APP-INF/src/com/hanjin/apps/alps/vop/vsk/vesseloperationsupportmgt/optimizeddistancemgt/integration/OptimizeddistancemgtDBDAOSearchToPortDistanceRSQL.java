/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : OptimizeddistancemgtDBDAOSearchToPortDistanceRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.05.14
*@LastModifier : 
*@LastVersion : 1.0
* 2014.05.14 
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

public class OptimizeddistancemgtDBDAOSearchToPortDistanceRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * To Port 입력시에 해당 Distance정보를 조회한다.
	  * </pre>
	  */
	public OptimizeddistancemgtDBDAOSearchToPortDistanceRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fm_date",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sheet_to_port_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("to_date",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fm_port_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.vop.vsk.vesseloperationsupportmgt.optimizeddistancemgt.integration").append("\n"); 
		query.append("FileName : OptimizeddistancemgtDBDAOSearchToPortDistanceRSQL").append("\n"); 
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
		query.append("SELECT   D.GMT_TD_HRS" ).append("\n"); 
		query.append("      ,  D.STND_DIST  " ).append("\n"); 
		query.append("      ,  (SELECT AVG(P.PORT_TO_PORT_MLG_DIST) " ).append("\n"); 
		query.append("            FROM VSK_PASG_PLN_RPT P " ).append("\n"); 
		query.append("			   , MDM_VSL_CNTR     VC" ).append("\n"); 
		query.append("           WHERE 1=1" ).append("\n"); 
		query.append("             AND P.VSL_CD      = VC.VSL_CD" ).append("\n"); 
		query.append("             AND P.DEP_PORT_CD = @[fm_port_cd]" ).append("\n"); 
		query.append("             AND P.ARR_PORT_CD = @[sheet_to_port_cd]" ).append("\n"); 
		query.append("             AND P.PASG_PLN_DT BETWEEN TO_DATE(@[fm_date],'YYYY-MM-DD') AND TO_DATE(@[to_date],'YYYY-MM-DD')) AS VMS_AVG_DIST" ).append("\n"); 
		query.append("      ,  (SELECT MIN(P.PORT_TO_PORT_MLG_DIST) " ).append("\n"); 
		query.append("            FROM VSK_PASG_PLN_RPT P " ).append("\n"); 
		query.append("			   , MDM_VSL_CNTR     VC" ).append("\n"); 
		query.append("           WHERE 1=1" ).append("\n"); 
		query.append("             AND P.VSL_CD      = VC.VSL_CD" ).append("\n"); 
		query.append("             AND P.DEP_PORT_CD = @[fm_port_cd]" ).append("\n"); 
		query.append("             AND P.ARR_PORT_CD = @[sheet_to_port_cd]" ).append("\n"); 
		query.append("             AND P.PASG_PLN_DT BETWEEN TO_DATE(@[fm_date],'YYYY-MM-DD') AND TO_DATE(@[to_date],'YYYY-MM-DD')) AS VMS_SHTG_DIST" ).append("\n"); 
		query.append("  FROM   VSK_PORT_DIST D      " ).append("\n"); 
		query.append(" WHERE   1=1" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("   AND   D.FM_LOC_CD = @[fm_port_cd]" ).append("\n"); 
		query.append("   AND   D.TO_LOC_CD = @[sheet_to_port_cd]" ).append("\n"); 

	}
}