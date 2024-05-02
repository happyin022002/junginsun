/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : AgreementRegistrationDBDAOAgreementRatesDSQL.java
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

public class AgreementRegistrationDBDAOAgreementRatesDSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Lease Agreement Rate Data Delete
	  * </pre>
	  */
	public AgreementRegistrationDBDAOAgreementRatesDSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("loc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("agmt_chg_val",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_tpsz_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.NUMERIC + ",N";
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

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_rntl_chg_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.lse.containerleaseagreementregistration.agreementregistration.integration").append("\n"); 
		query.append("FileName : AgreementRegistrationDBDAOAgreementRatesDSQL").append("\n"); 
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
		query.append("DELETE LSE_AGMT_RT" ).append("\n"); 
		query.append("WHERE  AGMT_CTY_CD = @[agmt_cty_cd]" ).append("\n"); 
		query.append("AND    AGMT_SEQ = @[agmt_seq]" ).append("\n"); 
		query.append("#if ( ${loc_cd} != '' )" ).append("\n"); 
		query.append("AND    LOC_CD = DECODE(@[cntr_rntl_chg_tp_cd], 'GENV', LOC_CD, @[loc_cd])" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if ( ${cntr_tpsz_cd} != '' )" ).append("\n"); 
		query.append("AND    CNTR_TPSZ_CD = @[cntr_tpsz_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if ( ${cntr_rntl_chg_tp_cd} != '' )" ).append("\n"); 
		query.append("AND    CNTR_RNTL_CHG_TP_CD = @[cntr_rntl_chg_tp_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if ( ${agmt_chg_val} != '' )" ).append("\n"); 
		query.append("AND    AGMT_CHG_VAL = @[agmt_chg_val] " ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}