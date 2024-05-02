/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : AccountReceivableAgentDBDAOUpdateASAMstUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.09.22
*@LastModifier : 
*@LastVersion : 1.0
* 2016.09.22 
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

public class AccountReceivableAgentDBDAOUpdateASAMstUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Update SAR_ASA_MST
	  * </pre>
	  */
	public AccountReceivableAgentDBDAOUpdateASAMstUSQL(){
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
		params.put("asa_no_ctnt2",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("pre_asa_no",new String[]{arrTmp[0],arrTmp[1]});

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

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.stm.sar.accountreceivableagent.accountreceivableagent.integration").append("\n"); 
		query.append("FileName : AccountReceivableAgentDBDAOUpdateASAMstUSQL").append("\n"); 
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
		query.append("UPDATE SAR_ASA_MST" ).append("\n"); 
		query.append("    SET" ).append("\n"); 
		query.append("           UPD_DT = SYSDATE" ).append("\n"); 
		query.append("           #if( ${asa_prd_fm_dt} != '' )" ).append("\n"); 
		query.append("           , ASA_PRD_FM_DT = REPLACE(@[asa_prd_fm_dt], '-','')" ).append("\n"); 
		query.append("           #end" ).append("\n"); 
		query.append("           #if( ${asa_prd_to_dt} != '' )" ).append("\n"); 
		query.append("           , ASA_PRD_TO_DT = REPLACE(@[asa_prd_to_dt], '-', '')" ).append("\n"); 
		query.append("           #end" ).append("\n"); 
		query.append("           #if( ${curr_cd} != '' )" ).append("\n"); 
		query.append("           , CURR_CD = @[curr_cd]" ).append("\n"); 
		query.append("           #end" ).append("\n"); 
		query.append("           #if( ${act_bal_amt} != '' )" ).append("\n"); 
		query.append("           , ACT_BAL_AMT = TO_NUMBER(@[act_bal_amt])" ).append("\n"); 
		query.append("           #end" ).append("\n"); 
		query.append("           #if( ${asa_fsh_dt} != '')" ).append("\n"); 
		query.append("             #if( ${asa_fsh_dt} == 'null')   " ).append("\n"); 
		query.append("           , ASA_FSH_DT = NULL " ).append("\n"); 
		query.append("             #else" ).append("\n"); 
		query.append("           , ASA_FSH_DT = TO_DATE(@[asa_fsh_dt], 'YYYYMMDDHHMISS')" ).append("\n"); 
		query.append("             #end" ).append("\n"); 
		query.append("           #end" ).append("\n"); 
		query.append("           #if( ${asa_fsh_usr_id} != '' )" ).append("\n"); 
		query.append("             #if( ${asa_fsh_dt} == 'null')   " ).append("\n"); 
		query.append("           , ASA_FSH_USR_ID = NULL" ).append("\n"); 
		query.append("             #else" ).append("\n"); 
		query.append("           , ASA_FSH_USR_ID = @[asa_fsh_usr_id]" ).append("\n"); 
		query.append("             #end" ).append("\n"); 
		query.append("           #end" ).append("\n"); 
		query.append("           #if( ${asa_apro_usr_id} != '' )" ).append("\n"); 
		query.append("           , ASA_APRO_USR_ID = @[asa_apro_usr_id]" ).append("\n"); 
		query.append("           #end" ).append("\n"); 
		query.append("           #if( ${asa_apro_dt} != '' )" ).append("\n"); 
		query.append("           , ASA_APRO_DT = TO_DATE(@[asa_apro_dt], 'YYYYMMDDHHMISS')" ).append("\n"); 
		query.append("           #end" ).append("\n"); 
		query.append("           #if( ${asa_no_ctnt1} != '' )" ).append("\n"); 
		query.append("           , ASA_NO_CTNT1 = @[asa_no_ctnt1]" ).append("\n"); 
		query.append("           #end" ).append("\n"); 
		query.append("           #if( ${asa_no_ctnt2} != '' )" ).append("\n"); 
		query.append("           , ASA_NO_CTNT2 = @[asa_no_ctnt2]" ).append("\n"); 
		query.append("           #end" ).append("\n"); 
		query.append("           #if( ${asa_no_ctnt3} != '' )" ).append("\n"); 
		query.append("           , ASA_NO_CTNT3 = @[asa_no_ctnt3]" ).append("\n"); 
		query.append("           #end" ).append("\n"); 
		query.append("           #if( ${asa_sts_cd} != '' )" ).append("\n"); 
		query.append("           , ASA_STS_CD = @[asa_sts_cd]" ).append("\n"); 
		query.append("           #end" ).append("\n"); 
		query.append("           #if( ${pre_asa_no} != '' )" ).append("\n"); 
		query.append("           , PRE_ASA_NO = @[pre_asa_no]" ).append("\n"); 
		query.append("           #end" ).append("\n"); 
		query.append("           #if( ${ofc_cd} != '' )" ).append("\n"); 
		query.append("           , OFC_CD = @[ofc_cd]" ).append("\n"); 
		query.append("           #end" ).append("\n"); 
		query.append("           #if( ${upd_usr_id} != '' )" ).append("\n"); 
		query.append("           , UPD_USR_ID = @[upd_usr_id]" ).append("\n"); 
		query.append("           #end " ).append("\n"); 
		query.append("    WHERE  1=1" ).append("\n"); 
		query.append("    AND    ASA_NO = @[asa_no]" ).append("\n"); 

	}
}