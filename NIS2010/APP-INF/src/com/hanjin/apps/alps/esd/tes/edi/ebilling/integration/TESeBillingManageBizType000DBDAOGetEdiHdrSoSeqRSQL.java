/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : TESeBillingManageDetailType000DBDAOGetEdiHdrSoSeqRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.06.13
*@LastModifier : 
*@LastVersion : 1.0
* 2012.06.13 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.tes.edi.ebilling.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TESeBillingManageBizType000DBDAOGetEdiHdrSoSeqRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * EDI SO SEQ생성
	  * </pre>
	  */
	public TESeBillingManageBizType000DBDAOGetEdiHdrSoSeqRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.tes.edi.ebilling.integration ").append("\n"); 
		query.append("FileName : TESeBillingManageDetailType000DBDAOGetEdiHdrSoSeqRSQL").append("\n"); 
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
		query.append("SELECT TES_EDI_SO_HDR_SEQ.NEXTVAL EDI_HDR_SO_MAX_SEQ FROM DUAL" ).append("\n"); 

	}
}