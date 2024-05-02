/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : AccountReceivalbeAgentDBDAOaddAgentCollectionTempListCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.07.16
*@LastModifier : 
*@LastVersion : 1.0
* 2015.07.16 
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

public class AccountReceivalbeAgentDBDAOaddAgentCollectionTempListCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * addAgentCollectionTempList
	  * </pre>
	  */
	public AccountReceivalbeAgentDBDAOaddAgentCollectionTempListCSQL(){
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
		params.put("asa_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ar_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inv_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bl_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("chg_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.stm.sar.accountreceivableagent.accountreceivableagent.integration ").append("\n"); 
		query.append("FileName : AccountReceivalbeAgentDBDAOaddAgentCollectionTempListCSQL").append("\n"); 
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
		query.append("INSERT INTO SAR_AGN_CLT_RFND_TMP " ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append(" ASA_NO" ).append("\n"); 
		query.append(",AR_OFC_CD" ).append("\n"); 
		query.append(",BL_NO" ).append("\n"); 
		query.append(",INV_NO " ).append("\n"); 
		query.append(",CHG_TP_CD " ).append("\n"); 
		query.append(",ASA_TP_CD" ).append("\n"); 
		query.append(",CRE_USR_ID" ).append("\n"); 
		query.append(",CRE_DT" ).append("\n"); 
		query.append(",UPD_USR_ID" ).append("\n"); 
		query.append(",UPD_DT" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("VALUES" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append(" @[asa_no]" ).append("\n"); 
		query.append(",@[ar_ofc_cd]" ).append("\n"); 
		query.append(",@[bl_no]           " ).append("\n"); 
		query.append(",@[inv_no]       " ).append("\n"); 
		query.append(",@[chg_tp_cd]   " ).append("\n"); 
		query.append(",@[asa_tp_cd]" ).append("\n"); 
		query.append(",@[usr_id]" ).append("\n"); 
		query.append(",SYSDATE" ).append("\n"); 
		query.append(",@[usr_id]" ).append("\n"); 
		query.append(",SYSDATE" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}