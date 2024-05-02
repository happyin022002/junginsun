/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : UsaACECustomsTransmissionDBDAOsearchAmsAceDivCdRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.06.05
*@LastModifier : 김보배
*@LastVersion : 1.0
* 2012.06.05 김보배
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.usa.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author BOBAE KIM
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class UsaACECustomsTransmissionDBDAOsearchAmsAceDivCdRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * AMS/ACE 구분 조회
	  * </pre>
	  */
	public UsaACECustomsTransmissionDBDAOsearchAmsAceDivCdRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.usa.integration").append("\n"); 
		query.append("FileName : UsaACECustomsTransmissionDBDAOsearchAmsAceDivCdRSQL").append("\n"); 
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
		query.append("SELECT ATTR_CTNT1 FROM BKG_CSTMS_CD_CONV_CTNT" ).append("\n"); 
		query.append("WHERE CNT_CD = 'US'" ).append("\n"); 
		query.append("AND CSTMS_DIV_ID = 'AMS_ACE_DIV'" ).append("\n"); 
		query.append("AND CSTMS_DIV_ID_SEQ = 1" ).append("\n"); 

	}
}