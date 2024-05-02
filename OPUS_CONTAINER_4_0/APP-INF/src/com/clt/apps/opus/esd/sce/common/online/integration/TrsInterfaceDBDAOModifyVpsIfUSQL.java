/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : TrsInterfaceDBDAOModifyVpsIfUSQL.java
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

public class TrsInterfaceDBDAOModifyVpsIfUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * WAS restart 시 SCE_VPS_IF 의 VPS_IF_STS_CD 를 원복시킨다. (XX ~> 00)
	  * </pre>
	  */
	public TrsInterfaceDBDAOModifyVpsIfUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.sce.common.online.integration ").append("\n"); 
		query.append("FileName : TrsInterfaceDBDAOModifyVpsIfUSQL").append("\n"); 
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
		query.append("update SCE_VPS_IF" ).append("\n"); 
		query.append("set VPS_IF_STS_CD = '00'" ).append("\n"); 
		query.append("where ( VPS_RCV_DT," ).append("\n"); 
		query.append("VPS_RCV_NO," ).append("\n"); 
		query.append("VSL_CD," ).append("\n"); 
		query.append("SKD_VOY_NO," ).append("\n"); 
		query.append("SKD_DIR_CD," ).append("\n"); 
		query.append("VPS_PORT_CD," ).append("\n"); 
		query.append("CLPT_IND_SEQ) in (" ).append("\n"); 
		query.append("select VPS_RCV_DT," ).append("\n"); 
		query.append("VPS_RCV_NO," ).append("\n"); 
		query.append("VSL_CD," ).append("\n"); 
		query.append("SKD_VOY_NO," ).append("\n"); 
		query.append("SKD_DIR_CD," ).append("\n"); 
		query.append("VPS_PORT_CD," ).append("\n"); 
		query.append("CLPT_IND_SEQ" ).append("\n"); 
		query.append("from SCE_VPS_IF" ).append("\n"); 
		query.append("where VPS_IF_STS_CD = 'XX'" ).append("\n"); 
		query.append("and VPS_RCV_DT > to_char(sysdate- 1, 'yyyymmdd') )" ).append("\n"); 

	}
}