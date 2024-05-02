/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : TrsInterfaceDBDAOModifyClmIfUSQL.java
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

public class TrsInterfaceDBDAOModifyClmIfUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * WAS restart 시 SCE_CLM_IF 의 SO_MAPG_STS_CD 를 원복한다. (XX ==> 00)
	  * </pre>
	  */
	public TrsInterfaceDBDAOModifyClmIfUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.sce.common.online.integration ").append("\n"); 
		query.append("FileName : TrsInterfaceDBDAOModifyClmIfUSQL").append("\n"); 
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
		query.append("update sce_clm_if" ).append("\n"); 
		query.append("set so_mapg_sts_cd = '00'" ).append("\n"); 
		query.append("where (CNTR_NO," ).append("\n"); 
		query.append("CNMV_YR," ).append("\n"); 
		query.append("CNMV_ID_NO," ).append("\n"); 
		query.append("CLM_SEQ) in (" ).append("\n"); 
		query.append("select CNTR_NO," ).append("\n"); 
		query.append("CNMV_YR," ).append("\n"); 
		query.append("CNMV_ID_NO," ).append("\n"); 
		query.append("CLM_SEQ" ).append("\n"); 
		query.append("from SCE_CLM_IF" ).append("\n"); 
		query.append("where SO_MAPG_STS_CD = 'XX'" ).append("\n"); 
		query.append("and upd_dt > sysdate - 3/24 )" ).append("\n"); 

	}
}