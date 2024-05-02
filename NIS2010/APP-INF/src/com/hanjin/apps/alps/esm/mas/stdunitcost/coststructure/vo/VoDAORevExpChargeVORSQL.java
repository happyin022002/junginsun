/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : VoDAORevExpChargeVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.02.06
*@LastModifier : 유제량
*@LastVersion : 1.0
* 2015.02.06 유제량
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.mas.stdunitcost.coststructure.vo;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Ryu Je Ryang
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class VoDAORevExpChargeVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Revenue Exception Charge의 VO를 만든다.
	  * </pre>
	  */
	public VoDAORevExpChargeVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.mas.stdunitcost.coststructure.vo").append("\n"); 
		query.append("FileName : VoDAORevExpChargeVORSQL").append("\n"); 
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
		query.append("       '' AS CNT_CD" ).append("\n"); 
		query.append("      ,'' AS CHG_CD" ).append("\n"); 
		query.append("      ,'' AS DELT_FLG      " ).append("\n"); 
		query.append("      ,'' AS CRE_USR_ID" ).append("\n"); 
		query.append("      ,'' AS CRE_DT" ).append("\n"); 
		query.append("      ,'' AS UPD_USR_ID" ).append("\n"); 
		query.append("      ,'' AS UPD_DT" ).append("\n"); 
		query.append("      ,'' F_CHG_CD" ).append("\n"); 
		query.append("      ,'' F_RDODELFLG  " ).append("\n"); 
		query.append("      ,'' CHG_CD_ORG" ).append("\n"); 
		query.append("      ,'' CNT_CD_ORG" ).append("\n"); 
		query.append("      ,'' DELT_FLG_ORG    " ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 

	}
}