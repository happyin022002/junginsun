/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : RFAReportDBDAOMasterRFAConditionRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.04.08
*@LastModifier : 김종옥
*@LastVersion : 1.0
* 2016.04.08 김종옥
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.rfareport.rfareport.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Jong Ock, Kim
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class RFAReportDBDAOMasterRFAConditionRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * MasterRFACondition
	  * </pre>
	  */
	public RFAReportDBDAOMasterRFAConditionRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.pri.rfareport.rfareport.integration").append("\n"); 
		query.append("FileName : RFAReportDBDAOMasterRFAConditionRSQL").append("\n"); 
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
		query.append("SELECT '' AS SC_NO" ).append("\n"); 
		query.append("     , '' AS SC_NO_INPUT" ).append("\n"); 
		query.append("     , '' AS SVC_SCP_CD" ).append("\n"); 
		query.append("     , '' AS RHQ" ).append("\n"); 
		query.append("     , '' AS PROP_SCP_OFC_CD" ).append("\n"); 
		query.append("     , '' AS EFF_DT" ).append("\n"); 
		query.append("     , '' AS EXP_DT" ).append("\n"); 
		query.append("     , '' AS ROUT_PNT_LOC_DEF_CD_ORI" ).append("\n"); 
		query.append("     , '' AS ROUT_VIA_PORT_DEF_CD_ORI" ).append("\n"); 
		query.append("     , '' AS ROUT_VIA_PORT_DEF_CD_DEST" ).append("\n"); 
		query.append("     , '' AS ROUT_PNT_LOC_DEF_CD_DEST" ).append("\n"); 
		query.append("     , '' AS PRC_CMDT_DEF_CD" ).append("\n"); 
		query.append("     , '' AS T_S" ).append("\n"); 
		query.append("     , '' AS T_S_PORT" ).append("\n"); 
		query.append("     , '' AS QTTN_STATUS" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 

	}
}