/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : AccountReceivableAgentDBDAOInsertASANoSeqCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.05.16
*@LastModifier : 
*@LastVersion : 1.0
* 2014.05.16 
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

public class AccountReceivableAgentDBDAOInsertASANoSeqCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Insert SAR_ASA_NO_SEQ
	  * </pre>
	  */
	public AccountReceivableAgentDBDAOInsertASANoSeqCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("asa_seq",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("asa_prd_yr",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.stm.sar.accountreceivableagent.accountreceivableagent.integration").append("\n"); 
		query.append("FileName : AccountReceivableAgentDBDAOInsertASANoSeqCSQL").append("\n"); 
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
		query.append("INSERT INTO SAR_ASA_NO_SEQ ( " ).append("\n"); 
		query.append("                  OFC_CD" ).append("\n"); 
		query.append("                , AGN_CD" ).append("\n"); 
		query.append("                , ASA_PRD_YR" ).append("\n"); 
		query.append("                , ASA_SEQ" ).append("\n"); 
		query.append("                , CRE_USR_ID" ).append("\n"); 
		query.append("                , CRE_DT" ).append("\n"); 
		query.append("                , UPD_USR_ID" ).append("\n"); 
		query.append("                , UPD_DT" ).append("\n"); 
		query.append("    ) VALUES ( " ).append("\n"); 
		query.append("                  @[ofc_cd]" ).append("\n"); 
		query.append("                , @[agn_cd]" ).append("\n"); 
		query.append("                , @[asa_prd_yr]" ).append("\n"); 
		query.append("                , @[asa_seq]" ).append("\n"); 
		query.append("                , @[cre_usr_id]" ).append("\n"); 
		query.append("                , SYSDATE" ).append("\n"); 
		query.append("                , @[upd_usr_id]" ).append("\n"); 
		query.append("                , SYSDATE" ).append("\n"); 
		query.append("    )" ).append("\n"); 

	}
}