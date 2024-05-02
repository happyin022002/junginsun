/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : TrsInterfaceDBDAOModifyEdiAmsIfUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.02.17
*@LastModifier : 김인수
*@LastVersion : 1.0
* 2010.02.17 김인수
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.sce.common.online.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Kim In-soo
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TrsInterfaceDBDAOModifyEdiAmsIfUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * WAS restart 시 SCE_EDI_AMS_IF 의 EDI_IF_STS_CD 를 원복한다. (XX ==> 00)
	  * </pre>
	  */
	public TrsInterfaceDBDAOModifyEdiAmsIfUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.sce.common.online.integration ").append("\n"); 
		query.append("FileName : TrsInterfaceDBDAOModifyEdiAmsIfUSQL").append("\n"); 
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
		query.append("UPDATE SCE_EDI_AMS_IF" ).append("\n"); 
		query.append("SET EDI_IF_STS_CD = '00'" ).append("\n"); 
		query.append("WHERE (EDI_RCV_DT," ).append("\n"); 
		query.append("EDI_RCV_SEQ) IN (" ).append("\n"); 
		query.append("SELECT EDI_RCV_DT," ).append("\n"); 
		query.append("EDI_RCV_SEQ" ).append("\n"); 
		query.append("FROM SCE_EDI_AMS_IF" ).append("\n"); 
		query.append("WHERE EDI_IF_STS_CD = 'XX'" ).append("\n"); 
		query.append("AND EDI_RCV_DT > TO_CHAR(SYSDATE- 1, 'YYYYMMDD') )" ).append("\n"); 

	}
}