/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SpperformancEvaluationDBDAOmultiTrsTrspVndrPerfEvVpeDSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.16
*@LastModifier : 
*@LastVersion : 1.0
* 2009.09.16 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.trs.soinquiry.spperformancevaluation.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SpperformancEvaluationDBDAOmultiTrsTrspVndrPerfEvVpeDSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * TRS_TRSP_VNDR_PERF_EV테이블의 데이타 삭제
	  * </pre>
	  */
	public SpperformancEvaluationDBDAOmultiTrsTrspVndrPerfEvVpeDSQL(){
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
		query.append("Path : com.hanjin.apps.alps.esd.trs.soinquiry.spperformancevaluation.integration ").append("\n"); 
		query.append("FileName : SpperformancEvaluationDBDAOmultiTrsTrspVndrPerfEvVpeDSQL").append("\n"); 
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
		query.append("DELETE FROM  TRS_TRSP_VNDR_PERF_EV" ).append("\n"); 
		query.append("WHERE  trsp_wo_ofc_cty_cd	 = @[trsp_wo_ofc_cty_cd]" ).append("\n"); 
		query.append("AND  trsp_wo_seq	 = @[trsp_wo_seq]" ).append("\n"); 

	}
}