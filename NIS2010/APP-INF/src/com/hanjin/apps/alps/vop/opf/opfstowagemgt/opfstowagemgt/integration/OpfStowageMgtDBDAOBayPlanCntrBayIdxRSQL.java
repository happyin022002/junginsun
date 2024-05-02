/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : OpfStowageMgtDBDAOBayPlanCntrBayIdxRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.12.28
*@LastModifier : 
*@LastVersion : 1.0
* 2015.12.28 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.opf.opfstowagemgt.opfstowagemgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class OpfStowageMgtDBDAOBayPlanCntrBayIdxRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * OpfStowageMgtDBDAOBayPlanCntrBayIdx
	  * </pre>
	  */
	public OpfStowageMgtDBDAOBayPlanCntrBayIdxRSQL(){
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

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("skd_dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("skd_voy_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("call_ind",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.vop.opf.opfstowagemgt.opfstowagemgt.integration").append("\n"); 
		query.append("FileName : OpfStowageMgtDBDAOBayPlanCntrBayIdxRSQL").append("\n"); 
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
		query.append("SELECT BAY AS BAY_IDX" ).append("\n"); 
		query.append("FROM BAY_PLAN " ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND (VSL_CD, VOY_NO, DIR_CD, PORT_CD, ID, CALL_IND, PLAN_TYPE) IN (SELECT VSL_CD, VOY_NO, DIR_CD, PORT_CD, ID, CALL_IND" ).append("\n"); 
		query.append("                                                                           , CASE WHEN COUNT(PLAN_TYPE) > 1 THEN 'E' ELSE 'F' END AS PLAN_TYPE" ).append("\n"); 
		query.append("                                                                    FROM BAY_PLAN A" ).append("\n"); 
		query.append("                                                                    WHERE 1=1" ).append("\n"); 
		query.append("                                                                    AND VSL_CD = @[vsl_cd]" ).append("\n"); 
		query.append("                                                                    AND VOY_NO = @[skd_voy_no]" ).append("\n"); 
		query.append("                                                                    AND DIR_CD = @[skd_dir_cd]" ).append("\n"); 
		query.append("                                                                    AND PORT_CD = @[port_cd]" ).append("\n"); 
		query.append("                                                                    AND ID = @[cntr_id]" ).append("\n"); 
		query.append("																	AND CALL_IND = @[call_ind]" ).append("\n"); 
		query.append("                                                                    GROUP BY VSL_CD, VOY_NO, DIR_CD, PORT_CD, ID, CALL_IND" ).append("\n"); 
		query.append("                                                                  )" ).append("\n"); 

	}
}