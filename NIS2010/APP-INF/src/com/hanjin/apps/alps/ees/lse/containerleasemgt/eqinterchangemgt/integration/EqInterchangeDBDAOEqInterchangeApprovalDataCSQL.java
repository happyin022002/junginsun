/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : EqInterchangeDBDAOEqInterchangeApprovalDataCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.07.09
*@LastModifier : 
*@LastVersion : 1.0
* 2015.07.09 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.lse.containerleasemgt.eqinterchangemgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class EqInterchangeDBDAOEqInterchangeApprovalDataCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * EQ interchange Approval Data를 입력한다
	  * </pre>
	  */
	public EqInterchangeDBDAOEqInterchangeApprovalDataCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("req_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pcr_cost",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("auth_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("req_seq",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("free_dd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("auth_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rqst_qty",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("auth_vol",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("puc_cost",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.lse.containerleasemgt.eqinterchangemgt.integration").append("\n"); 
		query.append("FileName : EqInterchangeDBDAOEqInterchangeApprovalDataCSQL").append("\n"); 
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
		query.append("INSERT INTO LSE_EQ_ITCHG(" ).append("\n"); 
		query.append("  LSE_ITCHG_AUTH_NO  ," ).append("\n"); 
		query.append("  LSE_ITCHG_AUTH_SEQ ," ).append("\n"); 
		query.append("  AGMT_CTY_CD        ," ).append("\n"); 
		query.append("  AGMT_SEQ           ," ).append("\n"); 
		query.append("  LSE_ITCHG_OFFR_QTY ," ).append("\n"); 
		query.append("  LSE_ITCHG_AUTH_QTY ," ).append("\n"); 
		query.append("  LSE_FREE_DYS       ," ).append("\n"); 
		query.append("  PKUP_UT_AMT        ," ).append("\n"); 
		query.append("  PKUP_CR_AMT        ," ).append("\n"); 
		query.append("  DELT_FLG           ," ).append("\n"); 
		query.append("  LSE_ITCHG_RQST_NO  ," ).append("\n"); 
		query.append("  LSE_ITCHG_RQST_SEQ ," ).append("\n"); 
		query.append("  CRE_USR_ID         ," ).append("\n"); 
		query.append("  CRE_DT             ," ).append("\n"); 
		query.append("  UPD_USR_ID         ," ).append("\n"); 
		query.append("  UPD_DT             )" ).append("\n"); 
		query.append("VALUES (" ).append("\n"); 
		query.append("@[auth_no]," ).append("\n"); 
		query.append("@[auth_seq]," ).append("\n"); 
		query.append("'HHO',          " ).append("\n"); 
		query.append("NVL(@[agmt_seq],0),  " ).append("\n"); 
		query.append("@[rqst_qty],  " ).append("\n"); 
		query.append("@[auth_vol],    " ).append("\n"); 
		query.append("@[free_dd],   " ).append("\n"); 
		query.append("@[puc_cost],   " ).append("\n"); 
		query.append("@[pcr_cost],    " ).append("\n"); 
		query.append("'N',    " ).append("\n"); 
		query.append("@[req_no],   " ).append("\n"); 
		query.append("@[req_seq] ," ).append("\n"); 
		query.append("@[upd_usr_id]," ).append("\n"); 
		query.append("SYSDATE," ).append("\n"); 
		query.append("@[upd_usr_id]," ).append("\n"); 
		query.append("SYSDATE " ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}