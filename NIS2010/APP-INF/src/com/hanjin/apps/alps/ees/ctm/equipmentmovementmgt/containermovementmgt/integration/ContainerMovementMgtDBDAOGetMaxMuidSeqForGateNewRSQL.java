/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ContainerMovementMgtDBDAOGetMaxMuidSeqForGateNewRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.10
*@LastModifier : 김상수
*@LastVersion : 1.0
* 2009.11.10 김상수
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.ctm.equipmentmovementmgt.containermovementmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author KIM, Sang Soo
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ContainerMovementMgtDBDAOGetMaxMuidSeqForGateNewRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 
	  * </pre>
	  */
	public ContainerMovementMgtDBDAOGetMaxMuidSeqForGateNewRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mvmt_edi_msg_area_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.ctm.equipmentmovementmgt.containermovementmgt.integration").append("\n"); 
		query.append("FileName : ContainerMovementMgtDBDAOGetMaxMuidSeqForGateNewRSQL").append("\n"); 
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
		query.append("SELECT DECODE (@[mvmt_edi_msg_area_cd]," ).append("\n"); 
		query.append("'KOR', CTM_KOR_EDI_MSG_SEQ.NEXTVAL," ).append("\n"); 
		query.append("'SWA', CTM_SWA_EDI_MSG_SEQ.NEXTVAL," ).append("\n"); 
		query.append("'CHN', CTM_CHN_EDI_MSG_SEQ.NEXTVAL," ).append("\n"); 
		query.append("'EUR', CTM_EUR_EDI_MSG_SEQ.NEXTVAL," ).append("\n"); 
		query.append("'USA', CTM_USA_EDI_MSG_SEQ.NEXTVAL," ).append("\n"); 
		query.append("CTM_KOR_EDI_MSG_SEQ.NEXTVAL" ).append("\n"); 
		query.append(") AS MVMT_EDI_MSG_SEQ" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 

	}
}