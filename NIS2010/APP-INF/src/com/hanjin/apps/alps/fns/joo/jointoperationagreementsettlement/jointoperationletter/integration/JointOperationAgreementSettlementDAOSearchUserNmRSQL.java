/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : JointOperationAgreementSettlementDAOSearchUserNmRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.16
*@LastModifier : 장강철
*@LastVersion : 1.0
* 2009.10.16 장강철
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

public class JointOperationAgreementSettlementDAOSearchUserNmRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * DESC Enter..
	  * </pre>
	  */
	public JointOperationAgreementSettlementDAOSearchUserNmRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		query.append("FileName : JointOperationAgreementSettlementDAOSearchUserNmRSQL").append("\n"); 
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
		query.append("SELECT Z.*" ).append("\n"); 
		query.append("FROM(" ).append("\n"); 
		query.append("SELECT USR_ID,USR_NM  FROM COM_USER A WHERE A.USR_ID=@[usr_id] UNION ALL" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("b.usr_id," ).append("\n"); 
		query.append("B.USR_NM" ).append("\n"); 
		query.append("FROM    JOO_LTR_TMPLT A, COM_USER B" ).append("\n"); 
		query.append("WHERE" ).append("\n"); 
		query.append("A.CRE_USR_ID = B.USR_ID" ).append("\n"); 
		query.append("#if (${ofc_cd} != '')" ).append("\n"); 
		query.append("AND   a.ofc_cd = @[ofc_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${jo_ltr_tp_cd} != '')" ).append("\n"); 
		query.append("AND   a.jo_ltr_tp_cd = @[jo_ltr_tp_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(")Z" ).append("\n"); 
		query.append("GROUP BY     usr_id, usr_nm" ).append("\n"); 
		query.append("ORDER BY     usr_id , usr_nm" ).append("\n"); 

	}
}