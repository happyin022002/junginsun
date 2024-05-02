/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : AgreementRegistrationDBDAOAgreementRatesCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.05.21
*@LastModifier : 
*@LastVersion : 1.0
* 2015.05.21 
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

public class AgreementRegistrationDBDAOAgreementRatesCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Lease Agreement Rate Data Insert
	  * </pre>
	  */
	public AgreementRegistrationDBDAOAgreementRatesCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("gen_rmk",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.FLOAT + ",N";
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
		params.put("cntr_spec_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("agmt_chg_dys",new String[]{arrTmp[0],arrTmp[1]});

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

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eq_loc_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("loc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.FLOAT + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("n1st_chg_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("upd_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.FLOAT + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("n2nd_chg_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.lse.containerleaseagreementregistration.agreementregistration.integration").append("\n"); 
		query.append("FileName : AgreementRegistrationDBDAOAgreementRatesCSQL").append("\n"); 
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
		query.append("INSERT INTO LSE_AGMT_RT (" ).append("\n"); 
		query.append("    AGMT_CTY_CD" ).append("\n"); 
		query.append("  , AGMT_SEQ" ).append("\n"); 
		query.append("  , LOC_CD" ).append("\n"); 
		query.append("  , CNTR_TPSZ_CD" ).append("\n"); 
		query.append("  , CNTR_RNTL_CHG_TP_CD" ).append("\n"); 
		query.append("  , AGMT_CHG_VAL" ).append("\n"); 
		query.append("  , N1ST_CHG_AMT" ).append("\n"); 
		query.append("  , N2ND_CHG_AMT" ).append("\n"); 
		query.append("  , AGMT_CHG_DYS" ).append("\n"); 
		query.append("  , CNTR_SPEC_NO  " ).append("\n"); 
		query.append("  , GEN_RMK" ).append("\n"); 
		query.append("  , CRE_USR_ID " ).append("\n"); 
		query.append("  , CRE_DT" ).append("\n"); 
		query.append("  , UPD_USR_ID" ).append("\n"); 
		query.append("  , UPD_DT" ).append("\n"); 
		query.append("  , EQ_LOC_TP_CD" ).append("\n"); 
		query.append(") VALUES ( " ).append("\n"); 
		query.append("    @[agmt_cty_cd]" ).append("\n"); 
		query.append("  , @[agmt_seq]" ).append("\n"); 
		query.append("  , @[loc_cd]" ).append("\n"); 
		query.append("  , @[cntr_tpsz_cd]" ).append("\n"); 
		query.append("  , @[cntr_rntl_chg_tp_cd]" ).append("\n"); 
		query.append("  , @[agmt_chg_val]" ).append("\n"); 
		query.append("  , @[n1st_chg_amt]" ).append("\n"); 
		query.append("  , @[n2nd_chg_amt]" ).append("\n"); 
		query.append("  , NVL(@[agmt_chg_dys], '0')" ).append("\n"); 
		query.append("  , @[cntr_spec_no]" ).append("\n"); 
		query.append("  , @[gen_rmk]" ).append("\n"); 
		query.append("  , @[cre_usr_id]" ).append("\n"); 
		query.append("  , SYSDATE" ).append("\n"); 
		query.append("  , @[upd_usr_id]" ).append("\n"); 
		query.append("  , SYSDATE" ).append("\n"); 
		query.append("  , NVL(@[eq_loc_tp_cd], 'SC')" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}