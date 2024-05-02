/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : ScgUtilEAIDAOSearchEdiSendHeaderRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.05.02
*@LastModifier : 
*@LastVersion : 1.0
* 2016.05.02 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.scg.scgcommon.scgutileai.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ScgUtilEAIDAOSearchEdiSendHeaderRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ScgUtilEAIDAOSearchEdiSendHeaderR
	  * </pre>
	  */
	public ScgUtilEAIDAOSearchEdiSendHeaderRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("loc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("crr_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.vop.scg.scgcommon.scgutileai.integration").append("\n"); 
		query.append("FileName : ScgUtilEAIDAOSearchEdiSendHeaderRSQL").append("\n"); 
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
		query.append("SELECT '$$$MSGSTART:' AS HEADER" ).append("\n"); 
		query.append("     , RPAD(NVL(COM_ConstantMgr_PKG.COM_getCompanyCode_FNC(),' '),20,' ') AS SENDER_ID" ).append("\n"); 
		query.append("     , RPAD(NVL(CASE WHEN @[crr_cd] IN ('HLC','HSD') THEN " ).append("\n"); 
		query.append("                     (SELECT 'HLC'|| DECODE(CONTI_CD, 'A', 'AS', 'E', 'EU', 'M', 'US') " ).append("\n"); 
		query.append("                        FROM MDM_LOCATION " ).append("\n"); 
		query.append("                       WHERE LOC_CD = @[loc_cd] " ).append("\n"); 
		query.append("                         AND NVL(DELT_FLG,'N') <> 'Y'" ).append("\n"); 
		query.append("                     ) " ).append("\n"); 
		query.append("                ELSE @[crr_cd] END ,' '),20,' ') AS RECEIVER_ID" ).append("\n"); 
		query.append("     , RPAD(NVL('IFTMBF',' '),10,' ')            AS MESSAGE_TYPE" ).append("\n"); 
		query.append("  FROM DUAL" ).append("\n"); 

	}
}