/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : TCharterIOEstimatedDAOCustomEstmIfVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.07
*@LastModifier : 윤세영
*@LastVersion : 1.0
* 2009.07.07 윤세영
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioestimated.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Yoon, Seyeong
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TCharterIOEstimatedDAOCustomEstmIfVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * GL_ESTM_IF_ERP
	  * </pre>
	  */
	public TCharterIOEstimatedDAOCustomEstmIfVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.nis2010.esm.fms.timecharterinoutaccounting.tcharterioestimated.integration").append("\n"); 
		query.append("FileName : TCharterIOEstimatedDAOCustomEstmIfVORSQL").append("\n"); 
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
		query.append("SELECT 	'' EXE_YRMON," ).append("\n"); 
		query.append("'' REV_YRMON," ).append("\n"); 
		query.append("0 ESTM_SEQ_NO," ).append("\n"); 
		query.append("'' FLET_CTRT_TP_CD," ).append("\n"); 
		query.append("'' VVD_CD," ).append("\n"); 
		query.append("'' VSL_CD," ).append("\n"); 
		query.append("'' SKD_VOY_NO," ).append("\n"); 
		query.append("'' SKD_DIR_CD," ).append("\n"); 
		query.append("'' REV_DIR_CD," ).append("\n"); 
		query.append("'' VST_DT," ).append("\n"); 
		query.append("'' VED_DT," ).append("\n"); 
		query.append("'' ESTM_IOC_DIV_CD," ).append("\n"); 
		query.append("0 DAYS," ).append("\n"); 
		query.append("0 HIRE_AMT," ).append("\n"); 
		query.append("0 EST_AMT," ).append("\n"); 
		query.append("0 ACT_AMT," ).append("\n"); 
		query.append("0 ACC_AMT," ).append("\n"); 
		query.append("'' SLP_OFC_CD," ).append("\n"); 
		query.append("'' CRE_USR_ID" ).append("\n"); 
		query.append("FROM    DUAL" ).append("\n"); 

	}
}