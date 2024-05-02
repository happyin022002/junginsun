/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : AccountPayableCommonDBDAOsearchPopInvoiceTypeListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.03.20
*@LastModifier : 
*@LastVersion : 1.0
* 2014.03.20 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.stm.sap.accountpayablecommon.accountpayablecommon.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AccountPayableCommonDBDAOsearchPopInvoiceTypeListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * STM_SAP_0003의 검색조건 VO
	  * </pre>
	  */
	public AccountPayableCommonDBDAOsearchPopInvoiceTypeListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inv_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.stm.sap.accountpayablecommon.accountpayablecommon.integration").append("\n"); 
		query.append("FileName : AccountPayableCommonDBDAOsearchPopInvoiceTypeListRSQL").append("\n"); 
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
		query.append("SELECT  sld.lu_cd AS lu_cd" ).append("\n"); 
		query.append("      , sld.lu_desc AS lu_desc" ).append("\n"); 
		query.append("FROM    sco_lu_hdr slh" ).append("\n"); 
		query.append("      , sco_lu_dtl sld" ).append("\n"); 
		query.append("WHERE   slh.lu_tp_cd = sld.lu_tp_cd " ).append("\n"); 
		query.append("AND     slh.lu_tp_cd = 'INVOICE TYPE'" ).append("\n"); 
		query.append("AND     NVL(sld.enbl_flg, 'Y') = 'Y'" ).append("\n"); 
		query.append("AND     NVL(sld.lu_st_dt, TRIM(SYSDATE)) >= TRIM(SYSDATE) " ).append("\n"); 
		query.append("#if (${inv_tp_cd} != '')" ).append("\n"); 
		query.append("AND sld.lu_cd LIKE '%' || @[inv_tp_cd] || '%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}