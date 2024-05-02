/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : JointOperationConsultationDBDAOCmbConditionVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.03.24
*@LastModifier : 박희동
*@LastVersion : 1.0
* 2011.03.24 박희동
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.fns.joo.jointoperationagreementsettlement.jointoperationconsultation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Park Hee Dong
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class JointOperationConsultationDBDAOCmbConditionVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * CmbConditionVO 생성
	  * </pre>
	  */
	public JointOperationConsultationDBDAOCmbConditionVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.fns.joo.jointoperationagreementsettlement.jointoperationconsultation.integration").append("\n"); 
		query.append("FileName : JointOperationConsultationDBDAOCmbConditionVORSQL").append("\n"); 
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
		query.append("SELECT " ).append("\n"); 
		query.append("       A.ACCT_YRMON, " ).append("\n"); 
		query.append("       A.JO_CRR_CD, " ).append("\n"); 
		query.append("       A.TRD_CD, " ).append("\n"); 
		query.append("       A.RLANE_CD, " ).append("\n"); 
		query.append("       A.RE_DIVR_CD," ).append("\n"); 
		query.append("       A.UPD_USR_ID," ).append("\n"); 
		query.append("       A.CRE_USR_ID, " ).append("\n"); 
		query.append("       TO_CHAR(B.STL_CMB_SEQ) STL_CMB_SEQ," ).append("\n"); 
		query.append("       (select ofc_cd from table(COM_OfficeCodeMgr_PKG.COM_getOfficeCodeList_FNC('000001', 'JOO')) where rownum = 1) AS OFC_CD" ).append("\n"); 
		query.append("FROM   JOO_SETTLEMENT A, " ).append("\n"); 
		query.append("       JOO_STL_CMB_DTL B" ).append("\n"); 
		query.append("WHERE  A.ACCT_YRMON = B.ACCT_YRMON" ).append("\n"); 
		query.append("AND    A.STL_VVD_SEQ = B.STL_VVD_SEQ" ).append("\n"); 
		query.append("AND    A.STL_SEQ     = B.STL_SEQ" ).append("\n"); 
		query.append("AND    1 = 0" ).append("\n"); 

	}
}