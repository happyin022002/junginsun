/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : TESeBillingManageBizType000DBDAOConvertEDIInvoiceGetTMLSoSeqRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.06.22
*@LastModifier : 
*@LastVersion : 1.0
* 2012.06.22 
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

public class TESeBillingManageBizType000DBDAOConvertEDIInvoiceGetTMLSoSeqRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 일반 TML invoice의 seq. 따기
	  * </pre>
	  */
	public TESeBillingManageBizType000DBDAOConvertEDIInvoiceGetTMLSoSeqRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("tml_edi_so_ofc_cty_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.tes.edi.ebilling.integration ").append("\n"); 
		query.append("FileName : TESeBillingManageBizType000DBDAOConvertEDIInvoiceGetTMLSoSeqRSQL").append("\n"); 
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
		query.append("SELECT TO_NUMBER(NVL(MAX(TML_SO_SEQ),'0'))+1 SEQ" ).append("\n"); 
		query.append("FROM TES_TML_SO_HDR" ).append("\n"); 
		query.append("WHERE TML_SO_OFC_CTY_CD = @[tml_edi_so_ofc_cty_cd]" ).append("\n"); 

	}
}