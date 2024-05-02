/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : OffdockCYInvoiceManageDBDAOSearchCNTRNumber2RSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.03.19
*@LastModifier : 
*@LastVersion : 1.0
* 2014.03.19 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.tes.serviceproviderinvoicemanage.offdockcyinvoicemanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class OffdockCYInvoiceManageDBDAOSearchCNTRNumber2RSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * OffdockCYInvoiceManageDBDAO SearchCNTRNumber2
	  * </pre>
	  */
	public OffdockCYInvoiceManageDBDAOSearchCNTRNumber2RSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("tml_so_ofc_cty_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("tml_so_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.tes.serviceproviderinvoicemanage.offdockcyinvoicemanage.integration").append("\n"); 
		query.append("FileName : OffdockCYInvoiceManageDBDAOSearchCNTRNumber2RSQL").append("\n"); 
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
		query.append("SELECT P.TML_SO_OFC_CTY_CD, P.TML_SO_SEQ, P.TML_SO_CNTR_LIST_SEQ, P.CNTR_NO TMP_CNTR_NO, C.CNTR_NO" ).append("\n"); 
		query.append("FROM   TES_TML_SO_CNTR_LIST P, MST_CONTAINER C  " ).append("\n"); 
		query.append("WHERE  P.TML_SO_OFC_CTY_CD = @[tml_so_ofc_cty_cd]" ).append("\n"); 
		query.append("AND    P.TML_SO_SEQ        = @[tml_so_seq]" ).append("\n"); 
		query.append("AND	   P.CNTR_NO IS NOT NULL" ).append("\n"); 
		query.append("AND    C.CNTR_NO LIKE SUBSTR(P.CNTR_NO,1,10)||'%'" ).append("\n"); 
		query.append("AND    LENGTH(P.CNTR_NO)<=10" ).append("\n"); 
		query.append("--AND    SUBSTR(P.CNTR_NO,1,10) = SUBSTR(C.CNTR_NO,1,10)" ).append("\n"); 

	}
}