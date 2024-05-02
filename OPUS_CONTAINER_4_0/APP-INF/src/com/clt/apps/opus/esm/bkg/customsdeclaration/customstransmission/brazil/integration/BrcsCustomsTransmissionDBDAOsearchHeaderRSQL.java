/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : BrcsCustomsTransmissionDBDAOsearchHeaderRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.09.01
*@LastModifier : 
*@LastVersion : 1.0
* 2014.09.01 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.brazil.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BrcsCustomsTransmissionDBDAOsearchHeaderRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 헤더정보 조회
	  * </pre>
	  */
	public BrcsCustomsTransmissionDBDAOsearchHeaderRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.brazil.integration").append("\n"); 
		query.append("FileName : BrcsCustomsTransmissionDBDAOsearchHeaderRSQL").append("\n"); 
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
		query.append("SELECT       " ).append("\n"); 
		query.append("    RPAD(NVL(TRIM(COM_ConstantMgr_PKG.COM_getCompanyCode_FNC()),' '),20,' ')||" ).append("\n"); 
		query.append("    RPAD(NVL(TRIM('BRSAO'),' '),20,' ')||" ).append("\n"); 
		query.append("    RPAD(NVL(TRIM('COPRAR'),' '),10,' ')||" ).append("\n"); 
		query.append("    RPAD('BKC' || TO_CHAR(SYSDATE, 'YYMMDD') || LTRIM(TO_CHAR(BKG_CSTM_EDI_SEQ.NEXTVAL,'000009')),15,' ') HEADER" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 

	}
}