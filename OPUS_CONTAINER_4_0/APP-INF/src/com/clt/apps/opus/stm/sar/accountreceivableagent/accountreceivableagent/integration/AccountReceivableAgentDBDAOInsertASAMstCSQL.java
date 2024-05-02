/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : AccountReceivableAgentDBDAOInsertASAMstCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.06.17
*@LastModifier : 
*@LastVersion : 1.0
* 2014.06.17 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.stm.sar.accountreceivableagent.accountreceivableagent.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AccountReceivableAgentDBDAOInsertASAMstCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * insert SAR_ASA_MST
	  * </pre>
	  */
	public AccountReceivableAgentDBDAOInsertASAMstCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("asa_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("asa_sts_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("asa_fsh_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("asa_prd_to_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("asa_fsh_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("asa_no_ctnt1",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("agn_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("asa_no_ctnt2",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pre_asa_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("asa_no_ctnt3",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("asa_prd_fm_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("curr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("asa_apro_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("asa_apro_dt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("act_bal_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.stm.sar.accountreceivableagent.accountreceivableagent.integration").append("\n"); 
		query.append("FileName : AccountReceivableAgentDBDAOInsertASAMstCSQL").append("\n"); 
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
		query.append("INSERT INTO SAR_ASA_MST ( " ).append("\n"); 
		query.append("                  ASA_NO" ).append("\n"); 
		query.append("                , AGN_CD" ).append("\n"); 
		query.append("                , ASA_PRD_FM_DT" ).append("\n"); 
		query.append("                , ASA_PRD_TO_DT" ).append("\n"); 
		query.append("                , CURR_CD" ).append("\n"); 
		query.append("                , ACT_BAL_AMT" ).append("\n"); 
		query.append("                , ASA_FSH_DT" ).append("\n"); 
		query.append("                , ASA_FSH_USR_ID" ).append("\n"); 
		query.append("                , ASA_APRO_USR_ID" ).append("\n"); 
		query.append("                , ASA_APRO_DT" ).append("\n"); 
		query.append("                , ASA_NO_CTNT1" ).append("\n"); 
		query.append("                , ASA_NO_CTNT2" ).append("\n"); 
		query.append("                , ASA_NO_CTNT3" ).append("\n"); 
		query.append("                , ASA_STS_CD" ).append("\n"); 
		query.append("                , PRE_ASA_NO" ).append("\n"); 
		query.append("                , OFC_CD" ).append("\n"); 
		query.append("                , CRE_USR_ID" ).append("\n"); 
		query.append("                , CRE_DT" ).append("\n"); 
		query.append("                , UPD_USR_ID" ).append("\n"); 
		query.append("                , UPD_DT" ).append("\n"); 
		query.append("    ) VALUES ( " ).append("\n"); 
		query.append("                  @[asa_no]" ).append("\n"); 
		query.append("                , @[agn_cd]" ).append("\n"); 
		query.append("                , @[asa_prd_fm_dt]" ).append("\n"); 
		query.append("                , @[asa_prd_to_dt]" ).append("\n"); 
		query.append("                , @[curr_cd]" ).append("\n"); 
		query.append("                , @[act_bal_amt]" ).append("\n"); 
		query.append("                , TO_DATE(@[asa_fsh_dt], 'YYYYMMDD')" ).append("\n"); 
		query.append("                , @[asa_fsh_usr_id]" ).append("\n"); 
		query.append("                , @[asa_apro_usr_id]" ).append("\n"); 
		query.append("                , TO_DATE(@[asa_apro_dt], 'YYYYMMDD')" ).append("\n"); 
		query.append("                , @[asa_no_ctnt1]" ).append("\n"); 
		query.append("                , @[asa_no_ctnt2]" ).append("\n"); 
		query.append("                , @[asa_no_ctnt3]" ).append("\n"); 
		query.append("                , @[asa_sts_cd]" ).append("\n"); 
		query.append("                , @[pre_asa_no]" ).append("\n"); 
		query.append("                , @[ofc_cd]" ).append("\n"); 
		query.append("                , @[cre_usr_id]" ).append("\n"); 
		query.append("                , SYSDATE" ).append("\n"); 
		query.append("                , @[upd_usr_id]" ).append("\n"); 
		query.append("                , SYSDATE" ).append("\n"); 
		query.append("    )" ).append("\n"); 

	}
}