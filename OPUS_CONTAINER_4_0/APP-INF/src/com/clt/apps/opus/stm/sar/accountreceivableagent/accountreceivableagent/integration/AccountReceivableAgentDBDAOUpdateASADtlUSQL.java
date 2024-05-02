/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : AccountReceivableAgentDBDAOUpdateASADtlUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.05.12
*@LastModifier : 
*@LastVersion : 1.0
* 2014.05.12 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.stm.sar.accountreceivableagent.accountreceivableagent.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AccountReceivableAgentDBDAOUpdateASADtlUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Update SAR_ASA_DTL
	  * </pre>
	  */
	public AccountReceivableAgentDBDAOUpdateASADtlUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("asa_cr_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eff_dt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("asa_dtl_desc",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("asa_dr_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("asa_dtl_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("asa_dtl_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.stm.sar.accountreceivableagent.accountreceivableagent.integration ").append("\n"); 
		query.append("FileName : AccountReceivableAgentDBDAOUpdateASADtlUSQL").append("\n"); 
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
		query.append("    UPDATE SAR_ASA_DTL" ).append("\n"); 
		query.append("    SET" ).append("\n"); 
		query.append("           UPD_DT = SYSDATE" ).append("\n"); 
		query.append("           #if( ${asa_dtl_desc} != '' )" ).append("\n"); 
		query.append("           , ASA_DTL_DESC = @[asa_dtl_desc]" ).append("\n"); 
		query.append("           #end" ).append("\n"); 
		query.append("           #if( ${asa_dr_amt} != '' )" ).append("\n"); 
		query.append("           , ASA_DR_AMT = @[asa_dr_amt]" ).append("\n"); 
		query.append("           #end" ).append("\n"); 
		query.append("           #if( ${asa_cr_amt} != '' )" ).append("\n"); 
		query.append("           , ASA_CR_AMT = @[asa_cr_amt]" ).append("\n"); 
		query.append("           #end" ).append("\n"); 
		query.append("           #if( ${eff_dt} != '' )" ).append("\n"); 
		query.append("           , EFF_DT = @[eff_dt]" ).append("\n"); 
		query.append("           #end" ).append("\n"); 
		query.append("           #if( ${asa_dtl_tp_cd} != '' )" ).append("\n"); 
		query.append("           , ASA_DTL_TP_CD = @[asa_dtl_tp_cd]" ).append("\n"); 
		query.append("           #end" ).append("\n"); 
		query.append("           #if( ${upd_usr_id} != '' )" ).append("\n"); 
		query.append("           , UPD_USR_ID = @[upd_usr_id]" ).append("\n"); 
		query.append("           #end" ).append("\n"); 
		query.append("    WHERE  1=1" ).append("\n"); 
		query.append("    AND    ASA_NO = @[asa_no]" ).append("\n"); 
		query.append("    AND    ASA_DTL_SEQ = @[asa_dtl_seq]" ).append("\n"); 

	}
}