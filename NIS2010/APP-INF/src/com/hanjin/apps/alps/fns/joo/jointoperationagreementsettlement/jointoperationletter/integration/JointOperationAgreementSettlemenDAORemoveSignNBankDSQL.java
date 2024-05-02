/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : JointOperationAgreementSettlemenDAORemoveSignNBankDSQL.java
*@FileTitle : Bank detail & Signature
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.29
*@LastModifier : 장강철
*@LastVersion : 1.0
* 2009.09.29 장강철
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.jointoperationletter.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author jang kang cheol
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class JointOperationAgreementSettlemenDAORemoveSignNBankDSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * DESC Enter..
	  * </pre>
	  */
	public JointOperationAgreementSettlemenDAORemoveSignNBankDSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("jo_ltr_tmplt_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.jointoperationletter.integration ").append("\n"); 
		query.append("FileName : JointOperationAgreementSettlemenDAORemoveSignNBankDSQL").append("\n"); 
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
		query.append("DELETE FROM JOO_LTR_TMPLT" ).append("\n"); 
		query.append("WHERE JO_LTR_TMPLT_SEQ	    = @[jo_ltr_tmplt_seq]" ).append("\n"); 

	}
}