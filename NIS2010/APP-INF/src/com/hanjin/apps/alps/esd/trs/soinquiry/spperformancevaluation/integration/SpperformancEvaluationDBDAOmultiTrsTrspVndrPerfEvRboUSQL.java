/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SpperformancEvaluationDBDAOmultiTrsTrspVndrPerfEvRboUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.17
*@LastModifier : 
*@LastVersion : 1.0
* 2009.09.17 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.trs.soinquiry.spperformancevaluation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SpperformancEvaluationDBDAOmultiTrsTrspVndrPerfEvRboUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * TRS_TRSP_RAIL_BIL_ORD 업데이트
	  * </pre>
	  */
	public SpperformancEvaluationDBDAOmultiTrsTrspVndrPerfEvRboUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trsp_wo_ofc_cty_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trsp_wo_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.trs.soinquiry.spperformancevaluation.integration").append("\n"); 
		query.append("FileName : SpperformancEvaluationDBDAOmultiTrsTrspVndrPerfEvRboUSQL").append("\n"); 
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
		query.append("UPDATE   TRS_TRSP_RAIL_BIL_ORD" ).append("\n"); 
		query.append("SET	trsp_so_sts_cd	 	= 'E'" ).append("\n"); 
		query.append("WHERE  trsp_so_ofc_cty_cd	 = @[trsp_wo_ofc_cty_cd]" ).append("\n"); 
		query.append("AND  trsp_so_seq	 = @[trsp_wo_seq]" ).append("\n"); 

	}
}