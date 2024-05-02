/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : EqInterchangeDBDAOEqInterchangeRequestDataCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.07.10
*@LastModifier : 
*@LastVersion : 1.0
* 2015.07.10 
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

public class EqInterchangeDBDAOEqInterchangeRequestDataCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Container Movement를 입력한다
	  * </pre>
	  */
	public EqInterchangeDBDAOEqInterchangeRequestDataCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("loc_grp",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vndr_seq",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("del_cost",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("por_cost",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("add_cost",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pcr_credit",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sbi_cost",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("puc_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("loc_to",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("free_day",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("loc_fm",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("req_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("tpsz_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("sbo_cost",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("gto_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("lstm_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.lse.containerleasemgt.eqinterchangemgt.integration").append("\n"); 
		query.append("FileName : EqInterchangeDBDAOEqInterchangeRequestDataCSQL").append("\n"); 
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
		query.append("INSERT INTO LSE_EQ_ITCHG_RQST(" ).append("\n"); 
		query.append("  LSE_ITCHG_RQST_NO  ," ).append("\n"); 
		query.append("  LSE_ITCHG_RQST_SEQ ," ).append("\n"); 
		query.append("  LSTM_CD            ," ).append("\n"); 
		query.append("  LR_VNDR_SEQ        ," ).append("\n"); 
		query.append("  FM_LOC_CD          ," ).append("\n"); 
		query.append("  CNTR_TPSZ_CD       ," ).append("\n"); 
		query.append("  LSE_LOC_GRP_CD     ," ).append("\n"); 
		query.append("  TO_LOC_CD          ," ).append("\n"); 
		query.append("  FM_COST_AMT        ," ).append("\n"); 
		query.append("  TO_COST_AMT        ," ).append("\n"); 
		query.append("  LSE_ITCHG_RQST_QTY ," ).append("\n"); 
		query.append("  LSE_FREE_DYS       ," ).append("\n"); 
		query.append("  PKUP_UT_AMT        ," ).append("\n"); 
		query.append("  ADD_TTL_COST_AMT   ," ).append("\n"); 
		query.append("  PKUP_CR_AMT        ," ).append("\n"); 
		query.append("  TTL_SAV_AMT        ," ).append("\n"); 
		query.append("  LSE_ITCHG_AUTH_NO  ," ).append("\n"); 
		query.append("  LSE_ITCHG_AUTH_SEQ ," ).append("\n"); 
		query.append("  CRE_USR_ID         ," ).append("\n"); 
		query.append("  CRE_DT             ," ).append("\n"); 
		query.append("  UPD_USR_ID         ," ).append("\n"); 
		query.append("  UPD_DT             ," ).append("\n"); 
		query.append("  SCC_CD             ," ).append("\n"); 
		query.append("  LCC_CD             ," ).append("\n"); 
		query.append("  RCC_CD             )" ).append("\n"); 
		query.append("VALUES (" ).append("\n"); 
		query.append("@[req_no]," ).append("\n"); 
		query.append("@[req_seq]," ).append("\n"); 
		query.append("@[lstm_cd],          " ).append("\n"); 
		query.append("@[vndr_seq],  " ).append("\n"); 
		query.append("@[loc_fm],    " ).append("\n"); 
		query.append("@[tpsz_cd],   " ).append("\n"); 
		query.append("@[loc_grp],   " ).append("\n"); 
		query.append("@[loc_to],    " ).append("\n"); 
		query.append("Decode(@[lstm_cd],'OF', NVL(@[por_cost],0), NVL(@[sbo_cost],0)),  " ).append("\n"); 
		query.append("Decode(@[lstm_cd],'OF', NVL(@[del_cost],0), NVL(@[sbi_cost],0)),    " ).append("\n"); 
		query.append("NVL(@[rqst_qty],0),  " ).append("\n"); 
		query.append("NVL(@[free_day],0),  " ).append("\n"); 
		query.append("Decode(@[lstm_cd],'OF', NVL(@[puc_amt],0), NVL(@[gto_amt],0)),      " ).append("\n"); 
		query.append("NVL(@[add_cost],0),  " ).append("\n"); 
		query.append("NVL(@[pcr_credit],0)," ).append("\n"); 
		query.append("#if (${lstm_cd} == 'OF')" ).append("\n"); 
		query.append("   NVL(TO_NUMBER(@[por_cost]),0) + NVL(TO_NUMBER(@[del_cost]),0) - NVL(TO_NUMBER(@[puc_amt]),0) - NVL(TO_NUMBER(@[add_cost]),0) + NVL(TO_NUMBER(@[pcr_credit]),0)," ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("   NVL(TO_NUMBER(@[sbo_cost]),0) + NVL(TO_NUMBER(@[sbi_cost]),0) - NVL(TO_NUMBER(@[gto_amt]),0) - NVL(TO_NUMBER(@[add_cost]),0) + NVL(TO_NUMBER(@[pcr_credit]),0)," ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("@[auth_no],   " ).append("\n"); 
		query.append("@[auth_seq] ," ).append("\n"); 
		query.append("@[upd_usr_id]," ).append("\n"); 
		query.append("SYSDATE," ).append("\n"); 
		query.append("@[upd_usr_id]," ).append("\n"); 
		query.append("SYSDATE," ).append("\n"); 
		query.append("MST_LOC_FNC(@[loc_fm],'SCC')," ).append("\n"); 
		query.append("MST_LOC_FNC(@[loc_fm],'LCC')," ).append("\n"); 
		query.append("MST_LOC_FNC(@[loc_fm],'RCC')" ).append("\n"); 
		query.append(" )" ).append("\n"); 

	}
}