/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : JointOperationConsultationDBDAOSlipConditionVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.19
*@LastModifier : 함대성
*@LastVersion : 1.0
* 2009.06.19 함대성
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.fns.joo.jointoperationagreementsettlement.jointoperationconsultation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author HAM DAE SUNG
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class JointOperationConsultationDBDAOSlipConditionVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SlipConditionVO
	  * </pre>
	  */
	public JointOperationConsultationDBDAOSlipConditionVORSQL(){
		setQuery();
		
		params = new HashMap<String,String[]>();
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
		query.append("select '' csr_no" ).append("\n"); 
		query.append(",'' fr_dt" ).append("\n"); 
		query.append(",'' to_dt" ).append("\n"); 
		query.append(",'' gubun" ).append("\n"); 
		query.append(",'' slp_ofc_cd2" ).append("\n"); 
		query.append(",'' slp_ofc_cd" ).append("\n"); 
		query.append(",'' slp_ofc_cd_sel" ).append("\n"); 
		query.append("from dual" ).append("\n"); 

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.fns.joo.jointoperationagreementsettlement.jointoperationconsultation.integration").append("\n"); 
		query.append("FileName : JointOperationConsultationDBDAOSlipConditionVORSQL").append("\n"); 
		query.append("*/").append("\n"); 
	}
}