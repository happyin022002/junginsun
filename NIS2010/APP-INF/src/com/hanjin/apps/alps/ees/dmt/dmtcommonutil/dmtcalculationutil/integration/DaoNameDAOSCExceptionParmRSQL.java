/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : DaoNameDAOSCExceptionParmRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.12.29
*@LastModifier : 최성환
*@LastVersion : 1.0
* 2009.12.29 최성환
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.dmt.dmtcommonutil.dmtcalculationutil.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Choi Sung Hwan
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class DaoNameDAOSCExceptionParmRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SCExceptionParm
	  * </pre>
	  */
	public DaoNameDAOSCExceptionParmRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.dmt.dmtcommonutil.dmtcalculationutil.integration").append("\n"); 
		query.append("FileName : DaoNameDAOSCExceptionParmRSQL").append("\n"); 
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
		query.append("'' SC_NO" ).append("\n"); 
		query.append(",'' DTT_CODE" ).append("\n"); 
		query.append(",'' IO_BND_CD" ).append("\n"); 
		query.append(",'' CNTR_TP" ).append("\n"); 
		query.append(",'' CGO_TP" ).append("\n"); 
		query.append(",'' CNTR_CGO_TP" ).append("\n"); 
		query.append(",'' EFFT_DT" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(",'' POL_CONTI_CD" ).append("\n"); 
		query.append(",'' POL_CNT_CD" ).append("\n"); 
		query.append(",'' POL_RGN_CD" ).append("\n"); 
		query.append(",'' POL_STE_CD" ).append("\n"); 
		query.append(",'' POL_LOC_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(",'' DEL_CONTI_CD" ).append("\n"); 
		query.append(",'' DEL_CNT_CD" ).append("\n"); 
		query.append(",'' DEL_RGN_CD" ).append("\n"); 
		query.append(",'' DEL_STE_CD" ).append("\n"); 
		query.append(",'' DEL_LOC_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(",'' POR_CONTI_CD" ).append("\n"); 
		query.append(",'' POR_CNT_CD" ).append("\n"); 
		query.append(",'' POR_RGN_CD" ).append("\n"); 
		query.append(",'' POR_STE_CD" ).append("\n"); 
		query.append(",'' POR_LOC_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(",'' YRD_CONTI_CD" ).append("\n"); 
		query.append(",'' YRD_CNT_CD" ).append("\n"); 
		query.append(",'' YRD_RGN_CD" ).append("\n"); 
		query.append(",'' YRD_STE_CD" ).append("\n"); 
		query.append(",'' YRD_LOC_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(",'' CMDT_CD" ).append("\n"); 
		query.append(",'' CMDT_TLI_NO" ).append("\n"); 
		query.append(",'' REP_CMDT_CD" ).append("\n"); 
		query.append(",'' CUST_CNT_CD" ).append("\n"); 
		query.append(",'' CUST_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(",'' ACT_CUST_CNT_CD" ).append("\n"); 
		query.append(",'' ACT_CUST_SEQ" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(",'' PAR_CONTI_CD" ).append("\n"); 
		query.append(",'' PAR_CNT_CD" ).append("\n"); 
		query.append(",'' PAR_RGN_CD" ).append("\n"); 
		query.append(",'' PAR_STE_CD" ).append("\n"); 
		query.append(",'' PAR_LOC_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(",'' BB_RCV_TERM_CD" ).append("\n"); 
		query.append(",'' BB_DE_TERM_CD" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 

	}
}