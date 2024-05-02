/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : ChassisMgsetInvoiceDBDAOaddMGSEstimateExpenseCalcDataCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.12.08
*@LastModifier : 
*@LastVersion : 1.0
* 2011.12.08 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.cgm.chassismgsetagreementinvoice.chassismgsetinvoice.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ChassisMgsetInvoiceDBDAOaddMGSEstimateExpenseCalcDataCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * chungpa 20091012 2206 start
	  * </pre>
	  */
	public ChassisMgsetInvoiceDBDAOaddMGSEstimateExpenseCalcDataCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rev_vvd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("estm_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("agmt_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("accl_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("chss_pool_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("act_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rev_yrmon",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("agmt_lstm_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("invo_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("upd_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("acct_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("exe_yrmon",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.cgm.chassismgsetagreementinvoice.chassismgsetinvoice.integration").append("\n"); 
		query.append("FileName : ChassisMgsetInvoiceDBDAOaddMGSEstimateExpenseCalcDataCSQL").append("\n"); 
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
		query.append("INSERT INTO GL_ESTM_IF_ERP (" ).append("\n"); 
		query.append("    EXE_YRMON" ).append("\n"); 
		query.append("    , SYS_SRC_ID" ).append("\n"); 
		query.append("    , REV_YRMON" ).append("\n"); 
		query.append("    , ACCT_CD" ).append("\n"); 
		query.append("	, AGMT_NO" ).append("\n"); 
		query.append("	, CNTR_TPSZ_CD" ).append("\n"); 
		query.append("	, LOC_CD" ).append("\n"); 
		query.append("    , ESTM_SEQ_NO" ).append("\n"); 
		query.append("    , VSL_CD" ).append("\n"); 
		query.append("    , SKD_VOY_NO" ).append("\n"); 
		query.append("    , SKD_DIR_CD" ).append("\n"); 
		query.append("    , REV_DIR_CD" ).append("\n"); 
		query.append("	, WO_NO" ).append("\n"); 
		query.append("    , ESTM_AMT" ).append("\n"); 
		query.append("    , ACT_AMT" ).append("\n"); 
		query.append("    , ACCL_AMT" ).append("\n"); 
		query.append("    , CRE_USR_ID" ).append("\n"); 
		query.append("    , CRE_DT" ).append("\n"); 
		query.append("    , UPD_USR_ID" ).append("\n"); 
		query.append("    , UPD_DT" ).append("\n"); 
		query.append("	, ESTM_VVD_TP_CD" ).append("\n"); 
		query.append("	, ESTM_IOC_DIV_CD" ).append("\n"); 
		query.append("	, ESTM_VVD_HDR_ID" ).append("\n"); 
		query.append("	, ESTM_BC_DIV_CD" ).append("\n"); 
		query.append("	, BIZ_UT_ID" ).append("\n"); 
		query.append("	, VNDR_INV_NO" ).append("\n"); 
		query.append(") VALUES (" ).append("\n"); 
		query.append("    @[exe_yrmon]" ).append("\n"); 
		query.append("    , 'MGS'" ).append("\n"); 
		query.append("    , @[rev_yrmon]" ).append("\n"); 
		query.append("    , @[acct_cd]" ).append("\n"); 
		query.append("	, @[agmt_no]" ).append("\n"); 
		query.append("	, @[agmt_lstm_cd]" ).append("\n"); 
		query.append("	, @[chss_pool_cd]" ).append("\n"); 
		query.append("    , (SELECT NVL(MAX(ESTM_SEQ_NO),0)+1 " ).append("\n"); 
		query.append("		FROM GL_ESTM_IF_ERP " ).append("\n"); 
		query.append("		WHERE EXE_YRMON = @[exe_yrmon] " ).append("\n"); 
		query.append("			AND SYS_SRC_ID = 'MGS'" ).append("\n"); 
		query.append("			AND REV_YRMON = @[rev_yrmon]" ).append("\n"); 
		query.append("			AND ACCT_CD = @[acct_cd])" ).append("\n"); 
		query.append("    , 'CNTC'" ).append("\n"); 
		query.append("    , SUBSTR(@[rev_yrmon], 3, 4)" ).append("\n"); 
		query.append("    , 'M'" ).append("\n"); 
		query.append("    , 'M'" ).append("\n"); 
		query.append("	, @[rev_vvd]" ).append("\n"); 
		query.append("    , @[estm_amt]" ).append("\n"); 
		query.append("    , @[act_amt]" ).append("\n"); 
		query.append("    , @[accl_amt]" ).append("\n"); 
		query.append("    , @[cre_usr_id]" ).append("\n"); 
		query.append("    , TO_DATE(REPLACE(@[cre_dt],'-',''),'YYYYMMDD')" ).append("\n"); 
		query.append("    , @[upd_usr_id]" ).append("\n"); 
		query.append("    , SYSDATE" ).append("\n"); 
		query.append("	, 'RV'" ).append("\n"); 
		query.append("	, 'XX'" ).append("\n"); 
		query.append("	, (SELECT ESTM_VVD_HDR_ID" ).append("\n"); 
		query.append("        FROM GL_ESTM_REV_VVD" ).append("\n"); 
		query.append("        WHERE EXE_YRMON = @[exe_yrmon]" ).append("\n"); 
		query.append("           AND REV_YRMON = @[rev_yrmon]" ).append("\n"); 
		query.append("           AND VSL_CD = 'CNTC'" ).append("\n"); 
		query.append("           AND SKD_VOY_NO = SUBSTR(@[rev_yrmon], 3, 4)" ).append("\n"); 
		query.append("           AND SKD_DIR_CD = 'M'" ).append("\n"); 
		query.append("           AND REV_DIR_CD = 'M')" ).append("\n"); 
		query.append("	, 'M'" ).append("\n"); 
		query.append("	, 'CNTR'" ).append("\n"); 
		query.append("	, @[invo_no]" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}