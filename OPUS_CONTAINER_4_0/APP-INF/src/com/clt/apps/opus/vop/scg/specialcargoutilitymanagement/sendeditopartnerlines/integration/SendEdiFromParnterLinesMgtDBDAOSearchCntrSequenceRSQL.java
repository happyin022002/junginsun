/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : SendEdiFromParnterLinesMgtDBDAOSearchCntrSequenceRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.04.27
*@LastModifier : 
*@LastVersion : 1.0
* 2016.04.27 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.scg.specialcargoutilitymanagement.sendeditopartnerlines.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SendEdiFromParnterLinesMgtDBDAOSearchCntrSequenceRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 
	  * </pre>
	  */
	public SendEdiFromParnterLinesMgtDBDAOSearchCntrSequenceRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.vop.scg.specialcargoutilitymanagement.sendeditopartnerlines.integration").append("\n"); 
		query.append("FileName : SendEdiFromParnterLinesMgtDBDAOSearchCntrSequenceRSQL").append("\n"); 
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
		query.append("SELECT 'DUMY' || LPAD(SCG_PRNR_SPCL_CGO_CNTR_DMY_SEQ.NEXTVAL, 7, '0') FROM DUAL" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("--:2016-04-27:--SELECT 'NYKU' || LPAD(SCG_PRNR_SPCL_CGO_CNTR_DMY_SEQ.NEXTVAL, 10, '0') FROM DUAL" ).append("\n"); 

	}
}