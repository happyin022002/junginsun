/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : DualTypeExceptionMgtDBDAOSCOrDARListInputVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.25
*@LastModifier : 
*@LastVersion : 1.0
* 2009.08.25 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.dmt.dmtexceptionmgt.dualtypeexceptionmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class DualTypeExceptionMgtDBDAOSCOrDARListInputVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Dual Type Exception Applied 데이터를 조회시 조회조건에 해당되는 파라미터 정보를 저장할 VO 객체
	  * </pre>
	  */
	public DualTypeExceptionMgtDBDAOSCOrDARListInputVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.dmt.dmtexceptionmgt.dualtypeexceptionmgt.integration").append("\n"); 
		query.append("FileName : DualTypeExceptionMgtDBDAOSCOrDARListInputVORSQL").append("\n"); 
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
		query.append("SELECT	'' CUST_CD" ).append("\n"); 
		query.append(",	'' DMDT_CTRT_EXPT_TP_CD" ).append("\n"); 
		query.append(",	'' EFF_DT" ).append("\n"); 
		query.append(",	'' EXP_DT" ).append("\n"); 
		query.append(",	'' IO_BND_CD" ).append("\n"); 
		query.append(",	'' CNT_CD" ).append("\n"); 
		query.append(",	'' RGN_CD" ).append("\n"); 
		query.append(",	'' STE_CD" ).append("\n"); 
		query.append(",	'' LOC_CD" ).append("\n"); 
		query.append(",	'' DMDT_CNTR_CGO_TP_CD" ).append("\n"); 
		query.append(",	'' INTG_CD_ID" ).append("\n"); 
		query.append(",	'' CODE1" ).append("\n"); 
		query.append(",	'' CODE2" ).append("\n"); 
		query.append("FROM	DUAL" ).append("\n"); 

	}
}