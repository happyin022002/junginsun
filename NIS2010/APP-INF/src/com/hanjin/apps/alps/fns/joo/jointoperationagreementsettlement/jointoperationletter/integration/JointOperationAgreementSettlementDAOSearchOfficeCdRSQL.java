/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : JointOperationAgreementSettlementDAOSearchOfficeCdRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.01
*@LastModifier : 장강철
*@LastVersion : 1.0
* 2009.10.01 장강철
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

public class JointOperationAgreementSettlementDAOSearchOfficeCdRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * DESC Enter..
	  * </pre>
	  */
	public JointOperationAgreementSettlementDAOSearchOfficeCdRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		query.append("FileName : JointOperationAgreementSettlementDAOSearchOfficeCdRSQL").append("\n"); 
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
		query.append("SELECT Z.OFC_CD" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("(SELECT @[ofc_cd] OFC_CD  FROM DUAL  UNION ALL" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("A.OFC_CD" ).append("\n"); 
		query.append("FROM    JOO_LTR_TMPLT A" ).append("\n"); 
		query.append("WHERE" ).append("\n"); 
		query.append("JO_LTR_TP_CD = @[jo_ltr_tp_cd])Z" ).append("\n"); 
		query.append("GROUP BY    Z.OFC_CD" ).append("\n"); 
		query.append("ORDER BY Z.OFC_CD" ).append("\n"); 

	}
}