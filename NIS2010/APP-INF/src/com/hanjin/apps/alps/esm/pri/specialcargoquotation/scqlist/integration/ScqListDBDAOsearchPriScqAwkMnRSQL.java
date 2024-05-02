/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : ScqListDBDAOsearchPriScqAwkMnRSQL.java
*@FileTitle : Awkward and Break Bulk Cargo Quotation List
*Open Issues :
*Change history :
*@LastModifyDate : 2013.02.19
*@LastModifier : 문동선
*@LastVersion : 1.0
* 2013.02.19 문동선
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.specialcargoquotation.scqlist.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Dong-sun Moon
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ScqListDBDAOsearchPriScqAwkMnRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * PRI_SCQ_AWK_MN
	  * </pre>
	  */
	public ScqListDBDAOsearchPriScqAwkMnRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.pri.specialcargoquotation.scqlist.integration ").append("\n"); 
		query.append("FileName : ScqListDBDAOsearchPriScqAwkMnRSQL").append("\n"); 
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
		query.append("SELECT SCQ_RQST_NO       " ).append("\n"); 
		query.append("     , SCQ_VER_NO        " ).append("\n"); 
		query.append("     , PROG_STS_CD       " ).append("\n"); 
		query.append("     , RQST_OFC_CD       " ).append("\n"); 
		query.append("     , RQST_SREP_CD      " ).append("\n"); 
		query.append("     , POR_CD            " ).append("\n"); 
		query.append("     , POL_CD            " ).append("\n"); 
		query.append("     , POL_YD_CD         " ).append("\n"); 
		query.append("     , POD_CD            " ).append("\n"); 
		query.append("     , POD_YD_CD         " ).append("\n"); 
		query.append("     , DEL_CD            " ).append("\n"); 
		query.append("     , SVC_SCP_CD        " ).append("\n"); 
		query.append("     , CUST_CNT_CD       " ).append("\n"); 
		query.append("     , CUST_SEQ          " ).append("\n"); 
		query.append("     , RCV_TERM_CD       " ).append("\n"); 
		query.append("     , DE_TERM_CD        " ).append("\n"); 
		query.append("     , PROP_EFF_DT       " ).append("\n"); 
		query.append("     , PROP_EXP_DT       " ).append("\n"); 
		query.append("     , APRO_EFF_DT       " ).append("\n"); 
		query.append("     , APRO_EXP_DT       " ).append("\n"); 
		query.append("     , DELT_FLG          " ).append("\n"); 
		query.append("     , CRE_USR_ID        " ).append("\n"); 
		query.append("     , CRE_DT            " ).append("\n"); 
		query.append("     , UPD_USR_ID        " ).append("\n"); 
		query.append("     , UPD_DT            " ).append("\n"); 
		query.append("  FROM PRI_SCQ_AWK_MN" ).append("\n"); 

	}
}