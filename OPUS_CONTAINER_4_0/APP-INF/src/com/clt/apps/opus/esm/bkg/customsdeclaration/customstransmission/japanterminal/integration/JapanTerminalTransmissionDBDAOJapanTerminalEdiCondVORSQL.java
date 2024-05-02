/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : JapanTerminalTransmissionDBDAOJapanTerminalEdiCondVORSQL.java
*@FileTitle :
*Open Issues :
*Change history :
*@LastModifyDate : 2012.03.16
*@LastModifier : 조원주
*@LastVersion : 1.0
* 2012.03.16 조원주
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.japanterminal.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author CHO WON-JOO
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class JapanTerminalTransmissionDBDAOJapanTerminalEdiCondVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();

	Logger log =Logger.getLogger(this.getClass());

	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;

	/**
	  * <pre>
	  * JapanTerminalEdiCondVO 생성 쿼리
	  * </pre>
	  */
	public JapanTerminalTransmissionDBDAOJapanTerminalEdiCondVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n");
		query.append("Path : com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.japanterminal.integration").append("\n");
		query.append("FileName : JapanTerminalTransmissionDBDAOJapanTerminalEdiCondVORSQL").append("\n");
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
		query.append("'' IN_VSL_CD," ).append("\n");
		query.append("'' IN_SKD_VOY_NO," ).append("\n");
		query.append("'' IN_SKD_DIR_CD," ).append("\n");
		query.append("'' IN_VVD_CD," ).append("\n");
		query.append("'' IN_POL_CD," ).append("\n");
		query.append("'' IN_POR_CD," ).append("\n");
		query.append("'' IN_BAT_SKD_PRD_FM_DT," ).append("\n");
		query.append("'' IN_BAT_SKD_PRD_TO_DT," ).append("\n");
		query.append("'' IN_EDI_SND_USR_ID," ).append("\n");
		query.append("'' IN_SKD_DELT_FLG," ).append("\n");
		query.append("'' BKG_NO" ).append("\n");
		query.append("FROM DUAL" ).append("\n");

	}
}