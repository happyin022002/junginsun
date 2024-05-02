/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : CostSetUpDBDAOGeneralExpenseVOUSQL.java
*@FileTitle : General Expense
*Open Issues :
*Change history :
*@LastModifyDate : 2013.09.27
*@LastModifier : 최성민
*@LastVersion : 1.0
* 2013.09.27 최성민
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.coa.stdunitcost.costsetup.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Sung-Min CHOI
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CostSetUpDBDAOGeneralExpenseVOUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * merge
	  * </pre>
	  */
	public CostSetUpDBDAOGeneralExpenseVOUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rhq_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ofc_vw_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("gen_expn_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cost_yrmon",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("gen_expn_rto",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.coa.stdunitcost.costsetup.integration").append("\n"); 
		query.append("FileName : CostSetUpDBDAOGeneralExpenseVOUSQL").append("\n"); 
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
		query.append("MERGE INTO COA_GEN_EXPN_POTN A USING " ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("        SELECT @[cost_yrmon] COST_YRMON" ).append("\n"); 
		query.append("              , @[rhq_cd] RHQ_CD" ).append("\n"); 
		query.append("              , @[ofc_vw_cd] OFC_VW_CD" ).append("\n"); 
		query.append("              , @[gen_expn_rto] GEN_EXPN_RTO" ).append("\n"); 
		query.append("              , @[gen_expn_amt] GEN_EXPN_AMT" ).append("\n"); 
		query.append("           FROM DUAL " ).append("\n"); 
		query.append(") B " ).append("\n"); 
		query.append("ON (    " ).append("\n"); 
		query.append("        A.COST_YRMON = B.COST_YRMON " ).append("\n"); 
		query.append("    AND A.RHQ_CD = B.RHQ_CD " ).append("\n"); 
		query.append("    AND A.OFC_VW_CD = B.OFC_VW_CD " ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("WHEN MATCHED THEN" ).append("\n"); 
		query.append(" UPDATE" ).append("\n"); 
		query.append("    SET A.GEN_EXPN_RTO     = GEN_EXPN_RTO" ).append("\n"); 
		query.append("      , A.GEN_EXPN_AMT = GEN_EXPN_AMT" ).append("\n"); 
		query.append("      , A.UPD_USR_ID   = @[upd_usr_id]" ).append("\n"); 
		query.append("      , A.UPD_DT       = SYSDATE " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("WHEN NOT MATCHED THEN" ).append("\n"); 
		query.append(" INSERT" ).append("\n"); 
		query.append("        (" ).append("\n"); 
		query.append("                COST_YRMON" ).append("\n"); 
		query.append("              , RHQ_CD" ).append("\n"); 
		query.append("              , OFC_VW_CD" ).append("\n"); 
		query.append("              , GEN_EXPN_RTO" ).append("\n"); 
		query.append("              , GEN_EXPN_AMT" ).append("\n"); 
		query.append("              , CRE_USR_ID" ).append("\n"); 
		query.append("              , CRE_DT" ).append("\n"); 
		query.append("              , UPD_USR_ID" ).append("\n"); 
		query.append("              , UPD_DT" ).append("\n"); 
		query.append("        )" ).append("\n"); 
		query.append("        VALUES" ).append("\n"); 
		query.append("        (" ).append("\n"); 
		query.append("                B.COST_YRMON" ).append("\n"); 
		query.append("              , B.RHQ_CD" ).append("\n"); 
		query.append("              , B.OFC_VW_CD" ).append("\n"); 
		query.append("              , B.GEN_EXPN_RTO" ).append("\n"); 
		query.append("              , B.GEN_EXPN_AMT" ).append("\n"); 
		query.append("              , @[upd_usr_id]" ).append("\n"); 
		query.append("              , sysdate" ).append("\n"); 
		query.append("              , @[cre_usr_id]" ).append("\n"); 
		query.append("              , sysdate" ).append("\n"); 
		query.append("        )" ).append("\n"); 

	}
}