/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : ContainerMovementMasterDataMgtDBDAOCtmMvmtStsVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.12.14
*@LastModifier : 
*@LastVersion : 1.0
* 2015.12.14 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.ctm.equipmentmovementmgt.containermovementmasterdatamgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ContainerMovementMasterDataMgtDBDAOCtmMvmtStsVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  *    
	  * </pre>
	  */
	public ContainerMovementMasterDataMgtDBDAOCtmMvmtStsVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.ctm.equipmentmovementmgt.containermovementmasterdatamgt.integration").append("\n"); 
		query.append("FileName : ContainerMovementMasterDataMgtDBDAOCtmMvmtStsVORSQL").append("\n"); 
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
		query.append("SELECT MVMT_STS_CD," ).append("\n"); 
		query.append("       MVMT_STS_NM," ).append("\n"); 
		query.append("       DEST_YD_FLG," ).append("\n"); 
		query.append("       IO_BND_CD" ).append("\n"); 
		query.append("  FROM MDM_MVMT_STS" ).append("\n"); 
		query.append("ORDER BY DP_SEQ, MVMT_STS_CD" ).append("\n"); 

	}
}