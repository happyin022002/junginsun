/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : UnmatchBLDBDAOCreateRfaRevenueAuditSurchargeRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.01.06
*@LastModifier : 김대호
*@LastVersion : 1.0
* 2010.01.06 김대호
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.revenueaudit.unmatchbl.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author day-hoh Kim
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class UnmatchBLDBDAOCreateRfaRevenueAuditSurchargeRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * createRfaRevenueAuditSurcharge
	  * </pre>
	  */
	public UnmatchBLDBDAOCreateRfaRevenueAuditSurchargeRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.revenueaudit.unmatchbl.integration").append("\n"); 
		query.append("FileName : UnmatchBLDBDAOCreateRfaRevenueAuditSurchargeRSQL").append("\n"); 
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
		query.append("NULL AS BKG_NO" ).append("\n"); 
		query.append(",NULL AS OFT_CMB_SEQ" ).append("\n"); 
		query.append(",NULL AS CHG_RT_SEQ" ).append("\n"); 
		query.append(",NULL AS CHG_CD" ).append("\n"); 
		query.append(",NULL AS RAT_UT_CD" ).append("\n"); 
		query.append(",NULL AS CURR_CD" ).append("\n"); 
		query.append(",NULL AS CHG_UT_AMT" ).append("\n"); 
		query.append(",NULL AS RAT_AS_QTY" ).append("\n"); 
		query.append(",NULL AS CHG_AMT" ).append("\n"); 
		query.append(",NULL AS CGO_CATE_CD" ).append("\n"); 
		query.append(",NULL AS CGO_TP_CD  -- CGO_CATE_CD <- CGO_TP_CD" ).append("\n"); 
		query.append(",NULL AS RCV_TERM_CD" ).append("\n"); 
		query.append(",NULL AS DE_TERM_CD" ).append("\n"); 
		query.append(",NULL AS CRE_USR_ID" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 

	}
}