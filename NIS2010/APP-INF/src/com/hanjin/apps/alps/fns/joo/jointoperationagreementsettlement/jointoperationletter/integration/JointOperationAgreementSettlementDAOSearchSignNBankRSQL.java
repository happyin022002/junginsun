/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : JointOperationAgreementSettlementDAOSearchSignNBankRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.26
*@LastModifier : 장강철
*@LastVersion : 1.0
* 2009.10.26 장강철
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

public class JointOperationAgreementSettlementDAOSearchSignNBankRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * DESC Enter..
	  * </pre>
	  */
	public JointOperationAgreementSettlementDAOSearchSignNBankRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("jo_tmplt_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("jo_ltr_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.jointoperationletter.integration").append("\n"); 
		query.append("FileName : JointOperationAgreementSettlementDAOSearchSignNBankRSQL").append("\n"); 
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
		query.append("a.jo_ltr_tmplt_seq," ).append("\n"); 
		query.append("a.jo_tmplt_no," ).append("\n"); 
		query.append("a.ofc_cd," ).append("\n"); 
		query.append("a.jo_ltr_tp_cd," ).append("\n"); 
		query.append("a.ofc_addr," ).append("\n"); 
		query.append("a.sig_stmt_ctnt," ).append("\n"); 
		query.append("a.bank_stmt_ctnt" ).append("\n"); 
		query.append("FROM   joo_ltr_tmplt a" ).append("\n"); 
		query.append("WHERE   a.ofc_cd      = @[ofc_cd]" ).append("\n"); 
		query.append("AND   a.jo_tmplt_no = @[jo_tmplt_no]" ).append("\n"); 
		query.append("AND   a.cre_usr_id  = @[usr_id]" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${jo_ltr_tp_cd} != '')" ).append("\n"); 
		query.append("AND    a.jo_ltr_tp_cd  = @[jo_ltr_tp_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}