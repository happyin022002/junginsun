/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : JointOperationMasterDataMgtDBDAOSTLItemAcctVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.08
*@LastModifier : 박희동
*@LastVersion : 1.0
* 2009.09.08 박희동
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.joo.jointoperationmasterdatamgt.jointoperationmasterdatamgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Park Hee Dong
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class JointOperationMasterDataMgtDBDAOSTLItemAcctVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 정산ITEM과 Acount code list 조회
	  * </pre>
	  */
	public JointOperationMasterDataMgtDBDAOSTLItemAcctVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.fns.joo.jointoperationmasterdatamgt.jointoperationmasterdatamgt.integration").append("\n"); 
		query.append("FileName : JointOperationMasterDataMgtDBDAOSTLItemAcctVORSQL").append("\n"); 
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
		query.append("A.JO_STL_ITM_CD" ).append("\n"); 
		query.append(",A.JO_STL_ITM_NM" ).append("\n"); 
		query.append(",A.JO_AUTO_CRE_FLG" ).append("\n"); 
		query.append(",A.JO_MNL_CRE_FLG" ).append("\n"); 
		query.append(",MAX(DECODE(B.RE_DIVR_CD,'E',B.DR_ACCT_CD,'')) E_DR_ACCT_CD" ).append("\n"); 
		query.append(",MAX(DECODE(B.RE_DIVR_CD,'E',B.CR_ACCT_CD,'')) E_CR_ACCT_CD" ).append("\n"); 
		query.append(",MAX(DECODE(B.RE_DIVR_CD,'E',B.JO_ESTM_ACCT_CD,'')) E_ES_ACCT_CD" ).append("\n"); 
		query.append(",MAX(DECODE(B.RE_DIVR_CD,'R',B.DR_ACCT_CD,'')) R_DR_ACCT_CD" ).append("\n"); 
		query.append(",MAX(DECODE(B.RE_DIVR_CD,'R',B.CR_ACCT_CD,'')) R_CR_ACCT_CD" ).append("\n"); 
		query.append(",MAX(DECODE(B.RE_DIVR_CD,'R',B.JO_ESTM_ACCT_CD,'')) R_ES_ACCT_CD" ).append("\n"); 
		query.append(",'' AS USR_ID" ).append("\n"); 
		query.append(",'' AS RE_DIVR_CD" ).append("\n"); 
		query.append("FROM  JOO_STL_ITM      A," ).append("\n"); 
		query.append("JOO_STL_ITM_ACCT B" ).append("\n"); 
		query.append("WHERE A.JO_STL_ITM_CD = B.JO_STL_ITM_CD" ).append("\n"); 
		query.append("GROUP BY" ).append("\n"); 
		query.append("A.JO_STL_ITM_CD" ).append("\n"); 
		query.append(",A.JO_STL_ITM_NM" ).append("\n"); 
		query.append(",A.JO_AUTO_CRE_FLG" ).append("\n"); 
		query.append(",A.JO_MNL_CRE_FLG" ).append("\n"); 
		query.append("ORDER BY" ).append("\n"); 
		query.append("5, 3 DESC" ).append("\n"); 

	}
}