/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : AgreementCorrectionDBDAOConfirmAgmtBtnRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.05.28
*@LastModifier : 최종혁
*@LastVersion : 1.0
* 2014.05.28 최종혁
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.trs.agreementmanage.agreementmanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author CJH
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AgreementCorrectionDBDAOConfirmAgmtBtnRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Agreement Confirm 권한 버튼 활성화
	  * </pre>
	  */
	public AgreementCorrectionDBDAOConfirmAgmtBtnRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cfm_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.trs.agreementmanage.agreementmanage.integration").append("\n"); 
		query.append("FileName : AgreementCorrectionDBDAOConfirmAgmtBtnRSQL").append("\n"); 
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
		query.append("SELECT COUNT(1) CNT" ).append("\n"); 
		query.append("  FROM TRS_AGMT_APRO_MGMT" ).append("\n"); 
		query.append(" WHERE CFM_USR_ID = @[cfm_usr_id]" ).append("\n"); 

	}
}