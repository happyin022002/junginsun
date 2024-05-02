/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : PortInformationMgtDBDAOVskPortCnlPassCondVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.04.28
*@LastModifier : 
*@LastVersion : 1.0
* 2015.04.28 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.vsk.vesseloperationsupportmgt.portinformationmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PortInformationMgtDBDAOVskPortCnlPassCondVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  *    
	  * </pre>
	  */
	public PortInformationMgtDBDAOVskPortCnlPassCondVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("loc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.vop.vsk.vesseloperationsupportmgt.portinformationmgt.integration").append("\n"); 
		query.append("FileName : PortInformationMgtDBDAOVskPortCnlPassCondVORSQL").append("\n"); 
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
		query.append("	LOC_CD" ).append("\n"); 
		query.append(",	PORT_SEQ" ).append("\n"); 
		query.append(",	SVC_SCP_BND_CD" ).append("\n"); 
		query.append(",   CNL_TZ_SEQ_CD" ).append("\n"); 
		query.append(",	SCG_EXPT_LMT_HRMNT" ).append("\n"); 
		query.append(",	SCG_FM_LMT_HRMNT" ).append("\n"); 
		query.append(",	SCG_TO_LMT_HRMNT" ).append("\n"); 
		query.append(",	LMT_TM_SCG_RTO" ).append("\n"); 
		query.append(",	CNL_RMK" ).append("\n"); 
		query.append(",	CRE_USR_ID" ).append("\n"); 
		query.append(",	CRE_DT" ).append("\n"); 
		query.append(",	UPD_USR_ID" ).append("\n"); 
		query.append(",	TO_CHAR(UPD_DT,'yyyy-mm-dd hh24:mi') UPD_DT" ).append("\n"); 
		query.append("FROM VSK_PORT_CNL_PASS_COND" ).append("\n"); 
		query.append("WHERE	LOC_CD = @[loc_cd]" ).append("\n"); 
		query.append("ORDER BY SVC_SCP_BND_CD, SCG_FM_LMT_HRMNT, SCG_TO_LMT_HRMNT ASC" ).append("\n"); 

	}
}