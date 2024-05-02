/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : ContainerMovementMasterDataMgtDBDAOCntrMvmtSeqVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.04.18
*@LastModifier : 
*@LastVersion : 1.0
* 2012.04.18 
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

public class ContainerMovementMasterDataMgtDBDAOCntrMvmtSeqVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Retrieveing Cntr Movement Sequence
	  * </pre>
	  */
	public ContainerMovementMasterDataMgtDBDAOCntrMvmtSeqVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.ctm.equipmentmovementmgt.containermovementmasterdatamgt.integration").append("\n"); 
		query.append("FileName : ContainerMovementMasterDataMgtDBDAOCntrMvmtSeqVORSQL").append("\n"); 
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
		query.append("SELECT BKG_CGO_TP_CD," ).append("\n"); 
		query.append("MVMT_STS_CD," ).append("\n"); 
		query.append("CNMV_LVL_NO," ).append("\n"); 
		query.append("CNMV_ST_PSN_FLG," ).append("\n"); 
		query.append("CNMV_END_PSN_FLG," ).append("\n"); 
		query.append("FCNTR_FLG" ).append("\n"); 
		query.append("FROM CTM_MVMT_SEQ" ).append("\n"); 
		query.append("ORDER BY BKG_CGO_TP_CD, CNMV_LVL_NO" ).append("\n"); 

	}
}