/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : AgreementRegistrationDBDAOremoveLeaseAgmtRateWithTPSZDSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.11.09
*@LastModifier : 이주현
*@LastVersion : 1.0
* 2015.11.09 이주현
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.lse.containerleaseagreementregistration.agreementregistration.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author LEE JU HYUN
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AgreementRegistrationDBDAOremoveLeaseAgmtRateWithTPSZDSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Lease Agreement 내 Type Size별로 없는 값들은 삭제하는 SQL
	  * </pre>
	  */
	public AgreementRegistrationDBDAOremoveLeaseAgmtRateWithTPSZDSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("agmt_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("agmt_cty_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.lse.containerleaseagreementregistration.agreementregistration.integration").append("\n"); 
		query.append("FileName : AgreementRegistrationDBDAOremoveLeaseAgmtRateWithTPSZDSQL").append("\n"); 
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
		query.append("DELETE LSE_AGMT_RT RT" ).append("\n"); 
		query.append("WHERE  RT.AGMT_CTY_CD = @[agmt_cty_cd]" ).append("\n"); 
		query.append("AND    RT.AGMT_SEQ   = @[agmt_seq] " ).append("\n"); 
		query.append("AND    NOT EXISTS ( SELECT 'X'" ).append("\n"); 
		query.append("                      FROM LSE_AGMT_RT SUB" ).append("\n"); 
		query.append("                     WHERE RT.AGMT_CTY_CD = SUB.AGMT_CTY_CD" ).append("\n"); 
		query.append("                       AND RT.AGMT_SEQ    = SUB.AGMT_SEQ" ).append("\n"); 
		query.append("                       AND SUB.CNTR_RNTL_CHG_TP_CD = 'GENV'" ).append("\n"); 
		query.append("                       AND RT.CNTR_TPSZ_CD = SUB.CNTR_TPSZ_CD)" ).append("\n"); 

	}
}