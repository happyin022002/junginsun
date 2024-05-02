/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : OnTimeResultAnalysisDBDAOSearchDrwTrdInfoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.02.17
*@LastModifier : 
*@LastVersion : 1.0
* 2016.02.17 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.vsk.actualschedulemanagement.ontimeresultanalysis.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class OnTimeResultAnalysisDBDAOSearchDrwTrdInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Drewry Target Trade 정보를 조회한다.
	  * </pre>
	  */
	public OnTimeResultAnalysisDBDAOSearchDrwTrdInfoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.vop.vsk.actualschedulemanagement.ontimeresultanalysis.integration").append("\n"); 
		query.append("FileName : OnTimeResultAnalysisDBDAOSearchDrwTrdInfoRSQL").append("\n"); 
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
		query.append("SELECT    D.DRW_TRD_CD" ).append("\n"); 
		query.append("        , D.FM_RGN_CD" ).append("\n"); 
		query.append("        , C1.CONTI_NM   AS FM_RGN_NM" ).append("\n"); 
		query.append("        , D.TO_RGN_CD" ).append("\n"); 
		query.append("        , C2.CONTI_NM   AS TO_RGN_NM" ).append("\n"); 
		query.append("        , D.DELT_FLG" ).append("\n"); 
		query.append("        , D.CRE_USR_ID" ).append("\n"); 
		query.append("        , D.CRE_DT" ).append("\n"); 
		query.append("        , D.UPD_USR_ID" ).append("\n"); 
		query.append("        , D.UPD_DT" ).append("\n"); 
		query.append("FROM      VSK_DRW_TGT_TRD D" ).append("\n"); 
		query.append("        , MDM_CONTINENT C1" ).append("\n"); 
		query.append("        , MDM_CONTINENT C2" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND     D.DELT_FLG = 'N'" ).append("\n"); 
		query.append("AND     D.FM_RGN_CD = C1.CONTI_CD " ).append("\n"); 
		query.append("AND     D.TO_RGN_CD = C2.CONTI_CD " ).append("\n"); 

	}
}