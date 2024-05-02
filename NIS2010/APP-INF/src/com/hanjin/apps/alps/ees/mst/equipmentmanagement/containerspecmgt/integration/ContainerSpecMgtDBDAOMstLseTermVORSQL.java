/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ContainerSpecMgtDBDAOMstLseTermVORSQL.java
*@FileTitle : Lease Term Code Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.05
*@LastModifier : 이호선
*@LastVersion : 1.0
* 2009.06.05 이호선
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.mst.equipmentmanagement.containerspecmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Lee Ho Sun
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ContainerSpecMgtDBDAOMstLseTermVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  *   MASTER LEASE TERM SELECT
	  * </pre>
	  */
	public ContainerSpecMgtDBDAOMstLseTermVORSQL(){
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
		query.append("A.LSTM_CD" ).append("\n"); 
		query.append(",	A.LSTM_NM" ).append("\n"); 
		query.append(",	A.LSE_PRD_CTNT" ).append("\n"); 
		query.append(",	A.PUR_OPT_FLG" ).append("\n"); 
		query.append(",	A.PUR_PRC" ).append("\n"); 
		query.append(",	A.DP_SEQ" ).append("\n"); 
		query.append(",	A.DIFF_RMK" ).append("\n"); 
		query.append(",	A.CRE_USR_ID" ).append("\n"); 
		query.append(",	A.CRE_DT" ).append("\n"); 
		query.append(",	A.UPD_USR_ID" ).append("\n"); 
		query.append(",	A.UPD_DT" ).append("\n"); 
		query.append("FROM MST_LSE_TERM A" ).append("\n"); 
		query.append("ORDER BY A.DP_SEQ" ).append("\n"); 

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.nis2010.ees.mst.equipmentmanagement.containerspecmgt.integration").append("\n"); 
		query.append("FileName : ContainerSpecMgtDBDAOMstLseTermVORSQL").append("\n"); 
		query.append("*/").append("\n"); 
	}
}