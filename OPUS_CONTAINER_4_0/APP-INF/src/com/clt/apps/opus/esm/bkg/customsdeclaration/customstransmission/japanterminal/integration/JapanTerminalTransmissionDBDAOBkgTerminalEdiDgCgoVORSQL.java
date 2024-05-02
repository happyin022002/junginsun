/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : JapanTerminalTransmissionDBDAOBkgTerminalEdiDgCgoVORSQL.java
*@FileTitle :
*Open Issues :
*Change history :
*@LastModifyDate : 2012.03.20
*@LastModifier : 조원주
*@LastVersion : 1.0
* 2012.03.20 조원주
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.japanterminal.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author CHO WON-JOO
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class JapanTerminalTransmissionDBDAOBkgTerminalEdiDgCgoVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();

	Logger log =Logger.getLogger(this.getClass());

	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;

	/**
	  * <pre>
	  * BkgTerminalEdiDgCgoVO 생성
	  * </pre>
	  */
	public JapanTerminalTransmissionDBDAOBkgTerminalEdiDgCgoVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n");
		query.append("Path : com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.japanterminal.integration ").append("\n");
		query.append("FileName : JapanTerminalTransmissionDBDAOBkgTerminalEdiDgCgoVORSQL").append("\n");
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
		query.append("SELECT " ).append("\n");
		query.append("'' IMDG_CLSS_CD," ).append("\n");
		query.append("'' IMDG_UN_NO, " ).append("\n");
		query.append("'' IMDG_PCK_GRP_CD" ).append("\n");
		query.append("FROM DUAL" ).append("\n");

	}
}