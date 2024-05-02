/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : TaiwanCustomsTransmissionDBDAOsearchSubMsgHeaderRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.01.22
*@LastModifier : 
*@LastVersion : 1.0
* 2010.01.22 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.taiwan.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TaiwanCustomsTransmissionDBDAOsearchSubMsgHeaderRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * sub header
	  * </pre>
	  */
	public TaiwanCustomsTransmissionDBDAOsearchSubMsgHeaderRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.taiwan.integration").append("\n"); 
		query.append("FileName : TaiwanCustomsTransmissionDBDAOsearchSubMsgHeaderRSQL").append("\n"); 
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
		query.append("SELECT 'IFTMCSNISBKG            '||" ).append("\n"); 
		query.append("'KORCUS            '||" ).append("\n"); 
		query.append("'1NIFTMCS'||" ).append("\n"); 
		query.append("TO_CHAR(sysdate,'rrmmdd')||" ).append("\n"); 
		query.append("LTRIM(TO_CHAR(BKG_CSTM_EDI_SEQ.NEXTVAL,'00009'),' ')||" ).append("\n"); 
		query.append("'O'||TO_CHAR(sysdate,'yyyymmddhh24miss')  sub_msg_header" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 

	}
}