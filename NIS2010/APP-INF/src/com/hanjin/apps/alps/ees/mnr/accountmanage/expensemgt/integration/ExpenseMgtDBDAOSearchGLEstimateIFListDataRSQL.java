/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : ExpenseMgtDBDAOSearchGLEstimateIFListDataRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.06.11
*@LastModifier : 박명신
*@LastVersion : 1.0
* 2010.06.11 박명신
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.mnr.accountmanage.expensemgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author park myoung sin
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ExpenseMgtDBDAOSearchGLEstimateIFListDataRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchGLEstimateIFListData
	  * </pre>
	  */
	public ExpenseMgtDBDAOSearchGLEstimateIFListDataRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("exe_month",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.mnr.accountmanage.expensemgt.integration").append("\n"); 
		query.append("FileName : ExpenseMgtDBDAOSearchGLEstimateIFListDataRSQL").append("\n"); 
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
		query.append("SELECT GE.EXE_YRMON," ).append("\n"); 
		query.append("GE.SYS_SRC_ID," ).append("\n"); 
		query.append("GE.REV_YRMON," ).append("\n"); 
		query.append("GE.ACCT_CD," ).append("\n"); 
		query.append("GE.BIZ_UT_ID," ).append("\n"); 
		query.append("GE.LOC_CD," ).append("\n"); 
		query.append("GE.VSL_CD," ).append("\n"); 
		query.append("GE.SKD_VOY_NO," ).append("\n"); 
		query.append("GE.SKD_DIR_CD," ).append("\n"); 
		query.append("GE.REV_DIR_CD," ).append("\n"); 
		query.append("GE.CNTR_TPSZ_CD AS CNTR_TP_SZ_CD," ).append("\n"); 
		query.append("GE.CNTR_QTY," ).append("\n"); 
		query.append("GE.ESTM_AMT," ).append("\n"); 
		query.append("GE.ACT_AMT AS ACTU_AMT," ).append("\n"); 
		query.append("GE.ACCL_AMT," ).append("\n"); 
		query.append("GE.ESTM_VVD_TP_CD," ).append("\n"); 
		query.append("GE.ESTM_IOC_DIV_CD," ).append("\n"); 
		query.append("GE.ESTM_BC_DIV_CD" ).append("\n"); 
		query.append("FROM  GL_ESTM_IF_ERP GE" ).append("\n"); 
		query.append("WHERE  GE.EXE_YRMON  = REPLACE(@[exe_month], '-', '')" ).append("\n"); 
		query.append("AND    GE.SYS_SRC_ID = 'MNR'" ).append("\n"); 

	}
}