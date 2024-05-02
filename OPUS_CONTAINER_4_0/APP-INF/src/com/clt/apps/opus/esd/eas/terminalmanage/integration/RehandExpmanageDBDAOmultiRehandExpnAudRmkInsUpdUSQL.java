/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : RehandExpmanageDBDAOmultiRehandExpnAudRmkInsUpdUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.25
*@LastModifier : 양봉준
*@LastVersion : 1.0
* 2009.11.25 양봉준
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.eas.terminalmanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Bongjun Yang
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class RehandExpmanageDBDAOmultiRehandExpnAudRmkInsUpdUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * multiRehandExpnAudRmkInsUpd
	  * </pre>
	  */
	public RehandExpmanageDBDAOmultiRehandExpnAudRmkInsUpdUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("expntpcd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("etntseq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("creofc",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkgno",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("updusrid",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ctnt",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.eas.terminalmanage.integration").append("\n"); 
		query.append("FileName : RehandExpmanageDBDAOmultiRehandExpnAudRmkInsUpdUSQL").append("\n"); 
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
		query.append("UPDATE TRS_EXPN_AUD_RMK" ).append("\n"); 
		query.append("SET" ).append("\n"); 
		query.append("RMK_CTNT		= @[ctnt]," ).append("\n"); 
		query.append("UPD_USR_ID		= @[updusrid]," ).append("\n"); 
		query.append("UPD_DT 			= GLOBALDATE_PKG.TIME_LOCAL_OFC_FNC(@[creofc])," ).append("\n"); 
		query.append("CRE_OFC_CD		= @[creofc]" ).append("\n"); 
		query.append("WHERE	BKG_NO			= @[bkgno]" ).append("\n"); 
		query.append("AND	EAS_EXPN_TP_CD		= @[expntpcd]" ).append("\n"); 
		query.append("AND	RMK_CTNT_SEQ		= @[etntseq]" ).append("\n"); 

	}
}