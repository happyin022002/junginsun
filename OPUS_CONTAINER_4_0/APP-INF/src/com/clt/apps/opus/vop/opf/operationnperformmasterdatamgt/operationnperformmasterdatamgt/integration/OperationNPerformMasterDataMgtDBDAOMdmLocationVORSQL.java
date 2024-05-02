/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : OperationNPerformMasterDataMgtDBDAOMdmLocationVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.04.06
*@LastModifier : 
*@LastVersion : 1.0
* 2015.04.06 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.opf.operationnperformmasterdatamgt.operationnperformmasterdatamgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class OperationNPerformMasterDataMgtDBDAOMdmLocationVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  *    
	  * </pre>
	  */
	public OperationNPerformMasterDataMgtDBDAOMdmLocationVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.vop.opf.operationnperformmasterdatamgt.operationnperformmasterdatamgt.integration").append("\n"); 
		query.append("FileName : OperationNPerformMasterDataMgtDBDAOMdmLocationVORSQL").append("\n"); 
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
		query.append("SELECT     DISTINCT" ).append("\n"); 
		query.append("           ML.LOC_CD" ).append("\n"); 
		query.append("      ,    NVL(ML.VOP_PORT_RHQ_CD,MO.AR_HD_QTR_OFC_CD)  AS VOP_PORT_RHQ_CD" ).append("\n"); 
		query.append("      ,    'N'     										AS VOP_PORT_FLG" ).append("\n"); 
		query.append("FROM       MDM_LOCATION  		ML" ).append("\n"); 
		query.append("      ,    MDM_ORGANIZATION 	MO" ).append("\n"); 
		query.append("WHERE      1 = 1" ).append("\n"); 
		query.append("AND        ML.LOC_CD        	= MO.LOC_CD" ).append("\n"); 
		query.append("AND        ML.DELT_FLG   		= 'N'" ).append("\n"); 
		query.append("AND        ML.CALL_PORT_FLG   	= 'Y' " ).append("\n"); 
		query.append("AND        MO.AR_HD_QTR_OFC_CD 	<> 'SINHO'   " ).append("\n"); 
		query.append("--AND        ML.VOP_PORT_RHQ_CD IS NOT NULL" ).append("\n"); 
		query.append("ORDER BY   ML.LOC_CD			ASC" ).append("\n"); 

	}
}