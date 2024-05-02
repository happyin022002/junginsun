/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : RehandExpmanageDBDAOmultiRehandExpnAudRmkInsCSQL.java
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

public class RehandExpmanageDBDAOmultiRehandExpnAudRmkInsCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * multiRehandExpnAudRmkIns
	  * </pre>
	  */
	public RehandExpmanageDBDAOmultiRehandExpnAudRmkInsCSQL(){
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
		params.put("bkgno",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("updusrid",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("creusrid",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ctnt",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.eas.terminalmanage.integration").append("\n"); 
		query.append("FileName : RehandExpmanageDBDAOmultiRehandExpnAudRmkInsCSQL").append("\n"); 
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
		query.append("INSERT INTO TRS_EXPN_AUD_RMK" ).append("\n"); 
		query.append("(BKG_NO," ).append("\n"); 
		query.append("EAS_EXPN_TP_CD," ).append("\n"); 
		query.append("RMK_CTNT_SEQ," ).append("\n"); 
		query.append("RMK_CTNT," ).append("\n"); 
		query.append("CRE_OFC_CD," ).append("\n"); 
		query.append("CRE_DT," ).append("\n"); 
		query.append("UPD_DT," ).append("\n"); 
		query.append("CRE_USR_ID," ).append("\n"); 
		query.append("UPD_USR_ID)" ).append("\n"); 
		query.append("VALUES (" ).append("\n"); 
		query.append("@[bkgno]," ).append("\n"); 
		query.append("@[expntpcd]," ).append("\n"); 
		query.append("@[etntseq]," ).append("\n"); 
		query.append("@[ctnt]," ).append("\n"); 
		query.append("@[creofc]," ).append("\n"); 
		query.append("GLOBALDATE_PKG.TIME_LOCAL_OFC_FNC(@[creofc])," ).append("\n"); 
		query.append("GLOBALDATE_PKG.TIME_LOCAL_OFC_FNC(@[creofc])," ).append("\n"); 
		query.append("@[creusrid]," ).append("\n"); 
		query.append("@[updusrid])" ).append("\n"); 

	}
}