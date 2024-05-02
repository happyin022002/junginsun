/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : ContainerSpecMgtDBDAOSearchCntrTypeSizeCodeListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.03.21
*@LastModifier : 
*@LastVersion : 1.0
* 2011.03.21 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.mst.equipmentmanagement.containerspecmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ContainerSpecMgtDBDAOSearchCntrTypeSizeCodeListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ContainerSpecMgtDBDAOSearchCntrTypeSizeCodeListRSQL
	  * </pre>
	  */
	public ContainerSpecMgtDBDAOSearchCntrTypeSizeCodeListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.mst.equipmentmanagement.containerspecmgt.integration").append("\n"); 
		query.append("FileName : ContainerSpecMgtDBDAOSearchCntrTypeSizeCodeListRSQL").append("\n"); 
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
		query.append("SELECT " ).append("\n"); 
		query.append("a.CNTR_TPSZ_CD" ).append("\n"); 
		query.append(",a.CNTR_TPSZ_DESC" ).append("\n"); 
		query.append(",a.CNTR_TPSZ_ISO_CD" ).append("\n"); 
		query.append(",b.ISO_CNTR_TPSZ_NM" ).append("\n"); 
		query.append(",c.CNTR_SZ_TEU_CAPA" ).append("\n"); 
		query.append(",decode(a.CNTR_TPSZ_GRP_CD,'D','DRY','S','SPE','R','RFR') AS CNTR_TPSZ_GRP_CD" ).append("\n"); 
		query.append(",a.RPT_DP_SEQ" ).append("\n"); 
		query.append(",a.ACIAC_DIV_CD" ).append("\n"); 
		query.append("FROM MDM_CNTR_TP_SZ a, MST_ISO_CNTR_TP_SZ b, MDM_CNTR_SZ c" ).append("\n"); 
		query.append("WHERE a.CNTR_TPSZ_ISO_CD = b.ISO_CNTR_TPSZ_CD" ).append("\n"); 
		query.append("AND a.CNTR_SZ_CD = c.CNTR_SZ_CD" ).append("\n"); 
		query.append("ORDER BY RPT_DP_SEQ" ).append("\n"); 

	}
}