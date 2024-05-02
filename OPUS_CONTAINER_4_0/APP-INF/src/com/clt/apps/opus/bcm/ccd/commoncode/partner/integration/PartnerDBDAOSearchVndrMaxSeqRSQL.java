/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : PartnerDBDAOSearchVndrMaxSeqRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.09.27
*@LastModifier : 
*@LastVersion : 1.0
* 2011.09.27 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.bcm.ccd.commoncode.partner.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PartnerDBDAOSearchVndrMaxSeqRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 입력된 Vendor Sequence의  Max + 1을 조회한다.
	  * </pre>
	  */
	public PartnerDBDAOSearchVndrMaxSeqRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.bcm.ccd.commoncode.partner.integration").append("\n"); 
		query.append("FileName : PartnerDBDAOSearchVndrMaxSeqRSQL").append("\n"); 
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
		query.append("SELECT MDM_VENDOR_SEQ.NEXTVAL FROM DUAL" ).append("\n"); 

	}
}