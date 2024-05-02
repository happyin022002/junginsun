/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : JapanTerminalTransmissionDBDAOVvdJapanTerminalEdiVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.03.15
*@LastModifier : 조원주
*@LastVersion : 1.0
* 2012.03.15 조원주
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.japanterminal.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author CHO WON-JOO
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class JapanTerminalTransmissionDBDAOVvdJapanTerminalEdiVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * VvdJapanTerminalEdiVO 생성 쿼리
	  * </pre>
	  */
	public JapanTerminalTransmissionDBDAOVvdJapanTerminalEdiVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.japanterminal.integration").append("\n"); 
		query.append("FileName : JapanTerminalTransmissionDBDAOVvdJapanTerminalEdiVORSQL").append("\n"); 
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
		query.append("SELECT" ).append("\n"); 
		query.append("'' VSL_CD," ).append("\n"); 
		query.append("'' SKD_VOY_NO," ).append("\n"); 
		query.append("'' SKD_DIR_CD," ).append("\n"); 
		query.append("'' VVD_CD," ).append("\n"); 
		query.append("'' POL_CD," ).append("\n"); 
		query.append("'' POL_YD_CD," ).append("\n"); 
		query.append("'' POR_CD," ).append("\n"); 
		query.append("'' POR_YD_CD," ).append("\n"); 
		query.append("'' CALL_SGN_NO," ).append("\n"); 
		query.append("'' OTR_NTFY_YD_CD," ).append("\n"); 
		query.append("'' BAT_SKD_PRD_FM_DT," ).append("\n"); 
		query.append("'' BAT_SKD_PRD_TO_DT," ).append("\n"); 
		query.append("'' VSL_PRE_PST_CD," ).append("\n"); 
		query.append("'' VSL_SEQ," ).append("\n"); 
		query.append("'' EDI_SND_OFC_CD," ).append("\n"); 
		query.append("'' EDI_SND_USR_ID," ).append("\n"); 
		query.append("'' SKD_DELT_FLG," ).append("\n"); 
		query.append("'' DELT_USR_ID," ).append("\n"); 
		query.append("'' CRE_USR_ID," ).append("\n"); 
		query.append("'' CRE_DT," ).append("\n"); 
		query.append("'' UPD_USR_ID," ).append("\n"); 
		query.append("'' UPD_DT," ).append("\n"); 
		query.append("'' SAVE_FLG" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 

	}
}