/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : DualTypeExceptionMgtDBDAOSCOrDARListVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.27
*@LastModifier : 
*@LastVersion : 1.0
* 2009.10.27 
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

public class DualTypeExceptionMgtDBDAOSCOrDARListVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 조회된 Dual Type Exception Applied 데이터를 저장할 VO 객체
	  * </pre>
	  */
	public DualTypeExceptionMgtDBDAOSCOrDARListVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.dmt.dmtexceptionmgt.dualtypeexceptionmgt.integration").append("\n"); 
		query.append("FileName : DualTypeExceptionMgtDBDAOSCOrDARListVORSQL").append("\n"); 
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
		query.append("SELECT	'' SC_NO" ).append("\n"); 
		query.append(",	'' RFA_NO" ).append("\n"); 
		query.append(",	'' PROP_NO" ).append("\n"); 
		query.append(",	'' DAR_NO" ).append("\n"); 
		query.append(",	'' VER" ).append("\n"); 
		query.append(",	'' APVL_NO" ).append("\n"); 
		query.append(",	'' STATUS" ).append("\n"); 
		query.append(",	'' EFF_DT" ).append("\n"); 
		query.append(",	'' EXP_DT" ).append("\n"); 
		query.append(",	'' IO_BND_CD" ).append("\n"); 
		query.append(",	'' CNT_CD" ).append("\n"); 
		query.append(",	'' RGN_CD" ).append("\n"); 
		query.append(",	'' STE_CD" ).append("\n"); 
		query.append(",	'' LOC_CD" ).append("\n"); 
		query.append(",	'' DMDT_CNTR_CGO_TP_CD" ).append("\n"); 
		query.append(",	'' DMDT_CNTR_CGO_TP_ALL_CD" ).append("\n"); 
		query.append(",	'' DMDT_CNTR_CGO_TP_ALL_NM" ).append("\n"); 
		query.append(",	'' LOC_TP" ).append("\n"); 
		query.append("FROM	DUAL" ).append("\n"); 

	}
}