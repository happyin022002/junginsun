/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : ReplanManageDBDAOSearchVOTmpRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.03.09
*@LastModifier : 김인수
*@LastVersion : 1.0
* 2010.03.09 김인수
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.sce.replanmanage.replanmanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Kim In-soo
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ReplanManageDBDAOSearchVOTmpRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * tmp
	  * </pre>
	  */
	public ReplanManageDBDAOSearchVOTmpRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.sce.replanmanage.replanmanage.integration").append("\n"); 
		query.append("FileName : ReplanManageDBDAOSearchVOTmpRSQL").append("\n"); 
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
		query.append("SELECT" ).append("\n"); 
		query.append("''  UMCH_FLG," ).append("\n"); 
		query.append("''  TRSP_SO_OFC_CTY_CD," ).append("\n"); 
		query.append("''  TRSP_SO_SEQ," ).append("\n"); 
		query.append("''  FM_NOD_CD," ).append("\n"); 
		query.append("''  TO_NOD_CD," ).append("\n"); 
		query.append("''  COP_NO," ).append("\n"); 
		query.append("'' COST_ACT_GRP_SEQ," ).append("\n"); 
		query.append("'' UPD_RMK," ).append("\n"); 
		query.append("'' RPLN_RSLT_FLG" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 

	}
}