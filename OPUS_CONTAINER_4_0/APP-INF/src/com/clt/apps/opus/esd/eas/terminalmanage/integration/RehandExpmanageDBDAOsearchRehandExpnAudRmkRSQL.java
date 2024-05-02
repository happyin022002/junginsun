/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : RehandExpmanageDBDAOsearchRehandExpnAudRmkRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.25
*@LastModifier : 양봉준
*@LastVersion : 1.0
* 2009.11.25 양봉준
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.eas.terminalmanage.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Bongjun Yang
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class RehandExpmanageDBDAOsearchRehandExpnAudRmkRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchRehandExpnAudRmk
	  * </pre>
	  */
	public RehandExpmanageDBDAOsearchRehandExpnAudRmkRSQL(){
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
		params.put("bkgno",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.eas.terminalmanage.integration ").append("\n"); 
		query.append("FileName : RehandExpmanageDBDAOsearchRehandExpnAudRmkRSQL").append("\n"); 
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
		query.append("SELECT	BKG_NO" ).append("\n"); 
		query.append(", RMK_CTNT_SEQ" ).append("\n"); 
		query.append(", RMK_CTNT" ).append("\n"); 
		query.append(", DECODE(NVL(TO_CHAR(UPD_DT,'YYYY-MM-DD'),'0'),'0',TO_CHAR(CRE_DT,'YYYY-MM-DD'),TO_CHAR(UPD_DT,'YYYY-MM-DD')) UPD_DT" ).append("\n"); 
		query.append(", CRE_OFC_CD" ).append("\n"); 
		query.append(", DECODE(NVL(UPD_USR_ID,'0'),'0',CRE_USR_ID,UPD_USR_ID) UPD_USR_ID" ).append("\n"); 
		query.append(", BL_NO BL_NO" ).append("\n"); 
		query.append(", EAS_EXPN_TP_CD" ).append("\n"); 
		query.append("FROM		TRS_EXPN_AUD_RMK" ).append("\n"); 
		query.append("WHERE	BKG_NO			= @[bkgno]" ).append("\n"); 
		query.append("AND		EAS_EXPN_TP_CD	= @[expntpcd]" ).append("\n"); 
		query.append("ORDER BY BKG_NO, RMK_CTNT_SEQ" ).append("\n"); 

	}
}