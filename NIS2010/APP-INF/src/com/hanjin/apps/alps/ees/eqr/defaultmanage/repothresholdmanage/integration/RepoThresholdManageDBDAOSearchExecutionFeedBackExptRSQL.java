/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : RepoThresholdManageDBDAOSearchExecutionFeedBackExptRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.20
*@LastModifier : 
*@LastVersion : 1.0
* 2009.07.20 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.eqr.defaultmanage.repothresholdmanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class RepoThresholdManageDBDAOSearchExecutionFeedBackExptRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * EQR_REPO_EXE_PLN_FB_EXPT 테이블의 데이터 조회
	  * </pre>
	  */
	public RepoThresholdManageDBDAOSearchExecutionFeedBackExptRSQL(){
		setQuery();
		
		params = new HashMap<String,String[]>();
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
		query.append("SELECT" ).append("\n"); 
		query.append("MAX(DECODE ( RUMM , 1 ,LOC_GRP_CD, LOC_GRP_CD)) LOC_GRP_CD" ).append("\n"); 
		query.append(",MAX(DECODE ( RUMM , 1 ,LOC_CD, LOC_CD))LOC_CD" ).append("\n"); 
		query.append(",FB_ITM_CD" ).append("\n"); 
		query.append(",FB_ITM_BSE_CD" ).append("\n"); 
		query.append("#foreach( $key in ${tpszarr})" ).append("\n"); 
		query.append(",MAX(DECODE ( CNTR_TPSZ_CD , '$key' , FB_RTO ))    ${key}FB_RTO" ).append("\n"); 
		query.append(",MAX(DECODE ( CNTR_TPSZ_CD , '$key' , CNTR_VOL_QTY))       ${key}CNTR_VOL_QTY" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(",MAX(DECODE(CRE_DT,UPD_DT, 'N', 'Y')) AS TIMEGAP" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("LOC_GRP_CD" ).append("\n"); 
		query.append(", LOC_CD" ).append("\n"); 
		query.append(",FB_ITM_CD" ).append("\n"); 
		query.append(",FB_ITM_BSE_CD" ).append("\n"); 
		query.append(",CNTR_TPSZ_CD" ).append("\n"); 
		query.append(",FB_RTO" ).append("\n"); 
		query.append(",CNTR_VOL_QTY" ).append("\n"); 
		query.append(",UPD_USR_ID" ).append("\n"); 
		query.append(",UPD_DT" ).append("\n"); 
		query.append(",CRE_DT" ).append("\n"); 
		query.append(",ROW_NUMBER() OVER (PARTITION BY FB_ITM_CD,FB_ITM_BSE_CD, CNTR_TPSZ_CD ORDER BY ROWNUM) RUMM" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("LOC_GRP_CD" ).append("\n"); 
		query.append(",LOC_CD" ).append("\n"); 
		query.append(",FB.FB_ITM_CD" ).append("\n"); 
		query.append(",FB.FB_ITM_BSE_CD" ).append("\n"); 
		query.append(",FB.CNTR_TPSZ_CD" ).append("\n"); 
		query.append(",FB.FB_RTO" ).append("\n"); 
		query.append(",FB.CNTR_VOL_QTY" ).append("\n"); 
		query.append(",FB.UPD_USR_ID" ).append("\n"); 
		query.append(",FB.UPD_DT" ).append("\n"); 
		query.append(",FB.CRE_DT" ).append("\n"); 
		query.append("FROM EQR_REPO_EXE_PLN_FB_EXPT FB" ).append("\n"); 
		query.append("ORDER BY LOC_GRP_CD DESC" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("GROUP BY  RUMM , FB_ITM_CD, FB_ITM_BSE_CD" ).append("\n"); 
		query.append("ORDER BY  FB_ITM_CD, FB_ITM_BSE_CD, LOC_GRP_CD DESC" ).append("\n"); 

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.nis2010.ees.eqr.defaultmanage.repothresholdmanage.integration").append("\n"); 
		query.append("FileName : RepoThresholdManageDBDAOSearchExecutionFeedBackExptRSQL").append("\n"); 
		query.append("*/").append("\n"); 
	}
}