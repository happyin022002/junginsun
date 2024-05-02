/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : AgreementRegistrationDBDAOAgreementRateHistoryCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.08.18
*@LastModifier : 이주현
*@LastVersion : 1.0
* 2016.08.18 이주현
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

public class AgreementRegistrationDBDAOAgreementRateHistoryCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  *    
	  * </pre>
	  */
	public AgreementRegistrationDBDAOAgreementRateHistoryCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.NUMERIC + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("agmt_ver_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("usr_id",new String[]{arrTmp[0],arrTmp[1]});

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

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.lse.containerleaseagreementregistration.agreementregistration.integration").append("\n"); 
		query.append("FileName : AgreementRegistrationDBDAOAgreementRateHistoryCSQL").append("\n"); 
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
		query.append("INSERT INTO LSE_AGMT_RT_HIS (" ).append("\n"); 
		query.append("       AGMT_CTY_CD" ).append("\n"); 
		query.append("     , AGMT_SEQ" ).append("\n"); 
		query.append("     , AGMT_VER_SEQ" ).append("\n"); 
		query.append("     , LOC_CD" ).append("\n"); 
		query.append("     , CNTR_TPSZ_CD" ).append("\n"); 
		query.append("     , CNTR_RNTL_CHG_TP_CD" ).append("\n"); 
		query.append("     , AGMT_CHG_VAL" ).append("\n"); 
		query.append("     , N1ST_CHG_AMT" ).append("\n"); 
		query.append("     , N2ND_CHG_AMT" ).append("\n"); 
		query.append("     , AGMT_CHG_DYS" ).append("\n"); 
		query.append("     , CNTR_SPEC_NO" ).append("\n"); 
		query.append("     , GEN_RMK" ).append("\n"); 
		query.append("     , EQ_LOC_TP_CD" ).append("\n"); 
		query.append("     , CRE_USR_ID" ).append("\n"); 
		query.append("     , CRE_DT" ).append("\n"); 
		query.append("     , UPD_USR_ID" ).append("\n"); 
		query.append("     , UPD_DT" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("SELECT @[agmt_cty_cd]  AS AGMT_CTY_CD" ).append("\n"); 
		query.append("     , @[agmt_seq]     AS AGMT_SEQ" ).append("\n"); 
		query.append("     , @[agmt_ver_seq] AS AGMT_VER_SEQ" ).append("\n"); 
		query.append("     , LOC_CD" ).append("\n"); 
		query.append("     , CNTR_TPSZ_CD" ).append("\n"); 
		query.append("     , CNTR_RNTL_CHG_TP_CD" ).append("\n"); 
		query.append("     , AGMT_CHG_VAL" ).append("\n"); 
		query.append("     , N1ST_CHG_AMT" ).append("\n"); 
		query.append("     , N2ND_CHG_AMT" ).append("\n"); 
		query.append("     , AGMT_CHG_DYS" ).append("\n"); 
		query.append("     , CNTR_SPEC_NO" ).append("\n"); 
		query.append("     , GEN_RMK" ).append("\n"); 
		query.append("     , EQ_LOC_TP_CD" ).append("\n"); 
		query.append("     , @[usr_id] AS CRE_USR_ID" ).append("\n"); 
		query.append("     , SYSDATE AS CRE_DT" ).append("\n"); 
		query.append("     , @[usr_id] AS UPD_USR_ID" ).append("\n"); 
		query.append("     , SYSDATE AS UPD_DT" ).append("\n"); 
		query.append("FROM   LSE_AGMT_RT" ).append("\n"); 
		query.append("WHERE  AGMT_CTY_CD = @[agmt_cty_cd]" ).append("\n"); 
		query.append("AND    AGMT_SEQ = @[agmt_seq]" ).append("\n"); 

	}
}