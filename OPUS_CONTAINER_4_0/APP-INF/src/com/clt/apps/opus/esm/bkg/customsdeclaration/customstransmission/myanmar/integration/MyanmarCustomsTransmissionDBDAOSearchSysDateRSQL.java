/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : MyanmarCustomsTransmissionDBDAOSearchSysDateRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.11.20
*@LastModifier : 
*@LastVersion : 1.0
* 2012.11.20 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.myanmar.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class MyanmarCustomsTransmissionDBDAOSearchSysDateRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * MyanmarCustomsTransmissionDBDAOSearchSysDateRSQL
	  * </pre>
	  */
	public MyanmarCustomsTransmissionDBDAOSearchSysDateRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.myanmar.integration ").append("\n"); 
		query.append("FileName : MyanmarCustomsTransmissionDBDAOSearchSysDateRSQL").append("\n"); 
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
		query.append("SELECT TO_CHAR(SYSDATE, 'YYYYMMDD hh24:mi:ss') KS_DATE" ).append("\n"); 
		query.append("FROM    DUAL" ).append("\n"); 

	}
}