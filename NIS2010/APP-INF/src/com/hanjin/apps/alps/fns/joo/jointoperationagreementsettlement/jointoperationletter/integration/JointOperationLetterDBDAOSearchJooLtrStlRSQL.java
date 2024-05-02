/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : JointOperationLetterDBDAOSearchJooLtrStlRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.12.30
*@LastModifier : 장강철
*@LastVersion : 1.0
* 2009.12.30 장강철
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.jointoperationletter.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author jang kang cheol
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class JointOperationLetterDBDAOSearchJooLtrStlRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * DESC Enter..
	  * </pre>
	  */
	public JointOperationLetterDBDAOSearchJooLtrStlRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("jo_ltr_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.jointoperationletter.integration").append("\n"); 
		query.append("FileName : JointOperationLetterDBDAOSearchJooLtrStlRSQL").append("\n"); 
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
		query.append("SELECT  A.ACCT_YRMON," ).append("\n"); 
		query.append("A.JO_CRR_CD," ).append("\n"); 
		query.append("M.ofc_addr," ).append("\n"); 
		query.append("M.N1ST_STMT_CTNT," ).append("\n"); 
		query.append("M.N2ND_STMT_CTNT," ).append("\n"); 
		query.append("M.N3RD_STMT_CTNT," ).append("\n"); 
		query.append("M.SIG_STMT_CTNT," ).append("\n"); 
		query.append("A.JO_LTR_SEQ      ," ).append("\n"); 
		query.append("A.JO_LTR_STL_SEQ  ," ).append("\n"); 
		query.append("A.VSL_SLAN_CD     ," ).append("\n"); 
		query.append("A.VSL_SLAN_CD   RLANE_CD," ).append("\n"); 
		query.append("A.TTL_AMT         ," ).append("\n"); 
		query.append("A.JO_HJS_AMT      ," ).append("\n"); 
		query.append("A.JO_PRNR_AMT     ," ).append("\n"); 
		query.append("A.JO_BAL_AMT      ," ).append("\n"); 
		query.append("A.STL_RMK" ).append("\n"); 
		query.append("FROM  JOO_LETTER M," ).append("\n"); 
		query.append("JOO_LTR_STL  A" ).append("\n"); 
		query.append("WHERE  M.JO_LTR_SEQ = A.JO_LTR_SEQ" ).append("\n"); 
		query.append("AND  A.JO_LTR_SEQ= @[jo_ltr_seq]" ).append("\n"); 

	}
}