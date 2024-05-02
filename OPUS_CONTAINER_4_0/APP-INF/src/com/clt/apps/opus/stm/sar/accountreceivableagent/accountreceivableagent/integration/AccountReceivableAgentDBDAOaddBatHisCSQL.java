/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : AccountReceivableAgentDBDAOaddBatHisCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.12.11
*@LastModifier : 
*@LastVersion : 1.0
* 2014.12.11 
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

public class AccountReceivableAgentDBDAOaddBatHisCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * addBatHis
	  * </pre>
	  */
	public AccountReceivableAgentDBDAOaddBatHisCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bat_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bat_rslt_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bat_pgm_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bat_para_ctnt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("pgm_sub_sys_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("appl_pgm_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.stm.sar.accountreceivableagent.accountreceivableagent.integration").append("\n"); 
		query.append("FileName : AccountReceivableAgentDBDAOaddBatHisCSQL").append("\n"); 
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
		query.append("INSERT INTO SCO_BAT_HIS" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("    BAT_SEQ," ).append("\n"); 
		query.append("    PGM_SUB_SYS_CD," ).append("\n"); 
		query.append("    BAT_PGM_NO," ).append("\n"); 
		query.append("    APPL_PGM_NO," ).append("\n"); 
		query.append("    BAT_PARA_CTNT," ).append("\n"); 
		query.append("    BAT_ST_DT," ).append("\n"); 
		query.append("    BAT_END_DT," ).append("\n"); 
		query.append("    BAT_RSLT_CD," ).append("\n"); 
		query.append("    BAT_RSLT_DESC," ).append("\n"); 
		query.append("    CRE_USR_ID," ).append("\n"); 
		query.append("    CRE_DT," ).append("\n"); 
		query.append("    UPD_USR_ID," ).append("\n"); 
		query.append("    UPD_DT" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("VALUES" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("	@[bat_seq]," ).append("\n"); 
		query.append("	@[pgm_sub_sys_cd]," ).append("\n"); 
		query.append("	@[bat_pgm_no]," ).append("\n"); 
		query.append("	@[appl_pgm_no]," ).append("\n"); 
		query.append("	@[bat_para_ctnt]," ).append("\n"); 
		query.append("	sysdate," ).append("\n"); 
		query.append("	null," ).append("\n"); 
		query.append("	@[bat_rslt_cd]," ).append("\n"); 
		query.append("	null," ).append("\n"); 
		query.append("	@[cre_usr_id]," ).append("\n"); 
		query.append("	sysdate," ).append("\n"); 
		query.append("	@[upd_usr_id]," ).append("\n"); 
		query.append("	sysdate" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}