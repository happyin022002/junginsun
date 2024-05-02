/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : KorCustomsTransmissionDBDAOSearchSysDateRSQL.java
*@FileTitle :
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.02
*@LastModifier : 손윤석
*@LastVersion : 1.0
* 2009.07.02 손윤석
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.korea.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Son Yun Seuk
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class KorCustomsTransmissionDBDAOSearchSysDateRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();

	Logger log =Logger.getLogger(this.getClass());

	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;

	/**
	  * <pre>
	  * searchSysDate
	  * </pre>
	  */
	public KorCustomsTransmissionDBDAOSearchSysDateRSQL(){
		setQuery();

		params = new HashMap<String,String[]>();
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
		query.append("SELECT TO_CHAR(SYSDATE, 'YYYYMMDD hh24:mi:ss') KS_DATE" ).append("\n");
		query.append("FROM    DUAL" ).append("\n");

		query.append("/*").append("\n");
		query.append("Path : com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.korea.integration ").append("\n");
		query.append("FileName : KorCustomsTransmissionDBDAOSearchSysDateRSQL").append("\n");
		query.append("*/").append("\n");
	}
}