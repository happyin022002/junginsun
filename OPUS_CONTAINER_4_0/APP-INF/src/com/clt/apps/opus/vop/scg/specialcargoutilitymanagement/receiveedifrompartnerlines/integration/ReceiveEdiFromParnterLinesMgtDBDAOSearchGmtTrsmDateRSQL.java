/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : ReceiveEdiFromParnterLinesMgtDBDAOSearchGmtTrsmDateRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.09.21
*@LastModifier : 
*@LastVersion : 1.0
* 2016.09.21 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.scg.specialcargoutilitymanagement.receiveedifrompartnerlines.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ReceiveEdiFromParnterLinesMgtDBDAOSearchGmtTrsmDateRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * APEARK 생성 GMT 날짜
	  * </pre>
	  */
	public ReceiveEdiFromParnterLinesMgtDBDAOSearchGmtTrsmDateRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.vop.scg.specialcargoutilitymanagement.receiveedifrompartnerlines.integration ").append("\n"); 
		query.append("FileName : ReceiveEdiFromParnterLinesMgtDBDAOSearchGmtTrsmDateRSQL").append("\n"); 
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
		query.append("SELECT TO_CHAR(GLOBALDATE_PKG.TIME_CONV_FNC" ).append("\n"); 
		query.append("				(COM_ConstantMgr_PKG.COM_getBaseLocationCode_FNC(),SYSDATE,'GMT')" ).append("\n"); 
		query.append("				, 'YYYYMMDDHH24MI') TRSM_GMT_DATE " ).append("\n"); 
		query.append("   		FROM DUAL" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 

	}
}