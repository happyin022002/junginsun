/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : AgreementTrsAgmtEqTpRuleDBDAORemoveTrsAgmtEqTpRuleDSQL.java
*@FileTitle : TRS_AGMT_EQ_TP_RULE
*Open Issues :
*Change history :
*@LastModifyDate : 2012.04.25
*@LastModifier : 이준근
*@LastVersion : 1.0
* 2012.04.25 이준근
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.trs.agreementmanage.agreementmanage.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author LeeJunKun
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AgreementTrsAgmtEqTpRuleDBDAORemoveTrsAgmtEqTpRuleDSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * RemoveTrsAgmtEqTpRule
	  * </pre>
	  */
	public AgreementTrsAgmtEqTpRuleDBDAORemoveTrsAgmtEqTpRuleDSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trsp_agmt_rule_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.trs.agreementmanage.agreementmanage.integration ").append("\n"); 
		query.append("FileName : AgreementTrsAgmtEqTpRuleDBDAORemoveTrsAgmtEqTpRuleDSQL").append("\n"); 
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
		query.append("DELETE TRS_AGMT_EQ_TP_RULE" ).append("\n"); 
		query.append(" WHERE TRSP_AGMT_RULE_SEQ = @[trsp_agmt_rule_seq]" ).append("\n"); 

	}
}