/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : GEMPlanningPerformanceDBDAOModifyChangeOfficesRsltSmryOfficeUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.05.09
*@LastModifier : 이준범
*@LastVersion : 1.0
* 2011.05.09 이준범
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.cps.gem.gemplanningperformance.gemplanningperformance.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Jun-bum, Lee
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class GEMPlanningPerformanceDBDAOModifyChangeOfficesRsltSmryOfficeUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 2011.04.18 [CHM-201108838-01] 이준범
	  * Title : OFC code Change 설정 시 Assigned Expense Data 변경 요청
	  * DESC :  Summary의 OFC_CD 를 변경한다.
	  * </pre>
	  */
	public GEMPlanningPerformanceDBDAOModifyChangeOfficesRsltSmryOfficeUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bfr_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("stnd_dt",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.cps.gem.gemplanningperformance.gemplanningperformance.integration").append("\n"); 
		query.append("FileName : GEMPlanningPerformanceDBDAOModifyChangeOfficesRsltSmryOfficeUSQL").append("\n"); 
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
		query.append("UPDATE GEM_RSLT_SMRY" ).append("\n"); 
		query.append("   SET OFC_CD = @[bfr_ofc_cd]" ).append("\n"); 
		query.append("      ,OFC_CO_DIV_CD = ( " ).append("\n"); 
		query.append("                        SELECT OFC_CO_DIV_CD" ).append("\n"); 
		query.append("                          FROM GEM_OFFICE" ).append("\n"); 
		query.append("                         WHERE OFC_CD = @[bfr_ofc_cd]" ).append("\n"); 
		query.append("                           AND DELT_FLG = 'N'" ).append("\n"); 
		query.append("                       )" ).append("\n"); 
		query.append("      ,UPD_USR_ID = @[usr_id]" ).append("\n"); 
		query.append("      ,UPD_DT     = SYSDATE" ).append("\n"); 
		query.append(" WHERE RSLT_YRMON LIKE SUBSTR(@[stnd_dt], 1, 4)||'%'" ).append("\n"); 
		query.append("   AND OFC_CD = @[ofc_cd]" ).append("\n"); 

	}
}