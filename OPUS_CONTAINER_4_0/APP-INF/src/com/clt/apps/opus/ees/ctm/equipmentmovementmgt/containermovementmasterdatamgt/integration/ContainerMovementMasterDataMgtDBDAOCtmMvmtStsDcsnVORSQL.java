/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : ContainerMovementMasterDataMgtDBDAOCtmMvmtStsDcsnVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.04.19
*@LastModifier : 
*@LastVersion : 1.0
* 2012.04.19 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.ctm.equipmentmovementmgt.containermovementmasterdatamgt.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ContainerMovementMasterDataMgtDBDAOCtmMvmtStsDcsnVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * CTM_MVMT_STS_DCSN
	  * </pre>
	  */
	public ContainerMovementMasterDataMgtDBDAOCtmMvmtStsDcsnVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.ctm.equipmentmovementmgt.containermovementmasterdatamgt.integration ").append("\n"); 
		query.append("FileName : ContainerMovementMasterDataMgtDBDAOCtmMvmtStsDcsnVORSQL").append("\n"); 
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
		query.append("SELECT MVMT_EDI_MSG_TP_ID," ).append("\n"); 
		query.append("MVMT_EDI_IO_BND_CD," ).append("\n"); 
		query.append("MVMT_EDI_CNTR_STS_CD," ).append("\n"); 
		query.append("MVMT_EDI_GATE_IO_CD," ).append("\n"); 
		query.append("MVMT_STS_CD" ).append("\n"); 
		query.append("FROM CTM_MVMT_STS_DCSN" ).append("\n"); 
		query.append("ORDER BY MVMT_EDI_MSG_TP_ID, MVMT_EDI_IO_BND_CD" ).append("\n"); 

	}
}