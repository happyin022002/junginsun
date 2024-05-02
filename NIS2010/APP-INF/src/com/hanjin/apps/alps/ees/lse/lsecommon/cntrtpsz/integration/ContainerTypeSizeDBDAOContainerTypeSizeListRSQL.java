/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ContainerTypeSizeDBDAOContainerTypeSizeListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.13
*@LastModifier : 노정용
*@LastVersion : 1.0
* 2009.05.13 노정용
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.lse.lsecommon.cntrtpsz.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Nho Jung Yong
 * @see DAO 참조
 * @since J2EE 1.4
 */

public class ContainerTypeSizeDBDAOContainerTypeSizeListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Container Type/Size Search
	  * </pre>
	  */
	public ContainerTypeSizeDBDAOContainerTypeSizeListRSQL(){
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
		query.append("SELECT CNTR_TPSZ_CD," ).append("\n"); 
		query.append("CNTR_SZ_CD," ).append("\n"); 
		query.append("CNTR_TP_CD," ).append("\n"); 
		query.append("CNTR_TPSZ_DESC," ).append("\n"); 
		query.append("CNTR_TPSZ_RMK," ).append("\n"); 
		query.append("CNTR_TPSZ_ISO_CD," ).append("\n"); 
		query.append("CNTR_TPSZ_GRP_CD" ).append("\n"); 
		query.append("FROM MDM_CNTR_TP_SZ" ).append("\n"); 
		query.append("WHERE DELT_FLG='N'" ).append("\n"); 
		query.append("AND ACIAC_DIV_CD='A'" ).append("\n"); 
		query.append("ORDER BY RPT_DP_SEQ" ).append("\n"); 

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.lse.lsecommon.cntrtpsz.integration").append("\n"); 
		query.append("FileName : ContainerTypeSizeDBDAOContainerTypeSizeListRSQL").append("\n"); 
		query.append("*/").append("\n"); 
	}
}