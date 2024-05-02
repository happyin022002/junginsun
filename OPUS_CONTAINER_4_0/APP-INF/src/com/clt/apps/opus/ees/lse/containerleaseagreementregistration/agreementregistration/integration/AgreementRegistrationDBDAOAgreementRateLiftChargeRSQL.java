/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : AgreementRegistrationDBDAOAgreementRateLiftChargeRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.05.20
*@LastModifier : 
*@LastVersion : 1.0
* 2015.05.20 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.lse.containerleaseagreementregistration.agreementregistration.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AgreementRegistrationDBDAOAgreementRateLiftChargeRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Lease Agreement Lifting Charges Rate Search
	  * </pre>
	  */
	public AgreementRegistrationDBDAOAgreementRateLiftChargeRSQL(){
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
		query.append("FileName : AgreementRegistrationDBDAOAgreementRateLiftChargeRSQL").append("\n"); 
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
		query.append("SELECT *" ).append("\n"); 
		query.append("FROM   (" ).append("\n"); 
		query.append("		SELECT A.AGMT_CTY_CD" ).append("\n"); 
		query.append("		     , A.AGMT_SEQ" ).append("\n"); 
		query.append("			 , A.EQ_LOC_TP_CD" ).append("\n"); 
		query.append("		     , A.LOC_CD" ).append("\n"); 
		query.append("		     , A.AGMT_CHG_VAL" ).append("\n"); 
		query.append("#foreach($key IN ${cntr_tpsz_cd_seq})" ).append("\n"); 
		query.append("#set ($col_name1='CNTR'+$velocityCount+'_N1_AMT')" ).append("\n"); 
		query.append("#set ($col_name2='CNTR'+$velocityCount+'_N2_AMT')" ).append("\n"); 
		query.append("		     , SUM(DECODE(A.CNTR_TPSZ_CD, '$key', A.N1ST_CHG_AMT)) AS $col_name1" ).append("\n"); 
		query.append("		     , SUM(DECODE(A.CNTR_TPSZ_CD, '$key', A.N2ND_CHG_AMT)) AS $col_name2" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("		FROM   LSE_AGMT_RT A" ).append("\n"); 
		query.append("		     , LSE_AGREEMENT B" ).append("\n"); 
		query.append("		WHERE  A.CNTR_RNTL_CHG_TP_CD = 'LIFV'" ).append("\n"); 
		query.append("		AND    A.AGMT_SEQ    = B.AGMT_SEQ" ).append("\n"); 
		query.append("        AND    A.AGMT_CTY_CD = B.AGMT_CTY_CD" ).append("\n"); 
		query.append("        AND    B.AGMT_LST_VER_SEQ = NVL(@[agmt_ver_seq], B.AGMT_LST_VER_SEQ)" ).append("\n"); 
		query.append("        AND    B.AGMT_SEQ    = @[agmt_seq]" ).append("\n"); 
		query.append("        AND    B.AGMT_CTY_CD = @[agmt_cty_cd]" ).append("\n"); 
		query.append("		GROUP  BY A.AGMT_CTY_CD" ).append("\n"); 
		query.append("		        , A.AGMT_SEQ" ).append("\n"); 
		query.append("				, A.EQ_LOC_TP_CD" ).append("\n"); 
		query.append("		        , A.LOC_CD" ).append("\n"); 
		query.append("		        , A.AGMT_CHG_VAL" ).append("\n"); 
		query.append("		UNION ALL" ).append("\n"); 
		query.append("		SELECT A.AGMT_CTY_CD" ).append("\n"); 
		query.append("		     , A.AGMT_SEQ" ).append("\n"); 
		query.append("			 , A.EQ_LOC_TP_CD" ).append("\n"); 
		query.append("		     , A.LOC_CD" ).append("\n"); 
		query.append("		     , A.AGMT_CHG_VAL" ).append("\n"); 
		query.append("#foreach($key IN ${cntr_tpsz_cd_seq})" ).append("\n"); 
		query.append("#set ($col_name1='CNTR'+$velocityCount+'_N1_AMT')" ).append("\n"); 
		query.append("#set ($col_name2='CNTR'+$velocityCount+'_N2_AMT')" ).append("\n"); 
		query.append("		     , SUM(DECODE(A.CNTR_TPSZ_CD, '$key', A.N1ST_CHG_AMT)) AS $col_name1" ).append("\n"); 
		query.append("		     , SUM(DECODE(A.CNTR_TPSZ_CD, '$key', A.N2ND_CHG_AMT)) AS $col_name2" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("		FROM   LSE_AGMT_RT_HIS A" ).append("\n"); 
		query.append("		     , LSE_AGREEMENT B" ).append("\n"); 
		query.append("		WHERE  A.CNTR_RNTL_CHG_TP_CD = 'LIFV'" ).append("\n"); 
		query.append("        AND    A.AGMT_VER_SEQ = DECODE(B.AGMT_LST_VER_SEQ, @[agmt_ver_seq], 9999, @[agmt_ver_seq])" ).append("\n"); 
		query.append("        AND    A.AGMT_SEQ    = B.AGMT_SEQ" ).append("\n"); 
		query.append("        AND    A.AGMT_CTY_CD = B.AGMT_CTY_CD" ).append("\n"); 
		query.append("        AND    B.AGMT_SEQ    = @[agmt_seq]" ).append("\n"); 
		query.append("        AND    B.AGMT_CTY_CD = @[agmt_cty_cd]" ).append("\n"); 
		query.append("		GROUP  BY A.AGMT_CTY_CD" ).append("\n"); 
		query.append("		        , A.AGMT_SEQ" ).append("\n"); 
		query.append("				, A.EQ_LOC_TP_CD" ).append("\n"); 
		query.append("		        , A.LOC_CD" ).append("\n"); 
		query.append("		        , A.AGMT_CHG_VAL" ).append("\n"); 
		query.append("       ) A" ).append("\n"); 
		query.append("ORDER  BY A.AGMT_CTY_CD" ).append("\n"); 
		query.append("        , A.AGMT_SEQ" ).append("\n"); 
		query.append("        , A.LOC_CD" ).append("\n"); 

	}
}