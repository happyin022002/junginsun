/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : AccountReceivableEDISendDBDAOSearchPodHaulageTypeRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.12.23
*@LastModifier : 
*@LastVersion : 1.0
* 2014.12.23 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.accountreceivableedisend.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AccountReceivableEDISendDBDAOSearchPodHaulageTypeRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Search Pod Haulage Type
	  * </pre>
	  */
	public AccountReceivableEDISendDBDAOSearchPodHaulageTypeRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.accountreceivableedisend.integration").append("\n"); 
		query.append("FileName : AccountReceivableEDISendDBDAOSearchPodHaulageTypeRSQL").append("\n"); 
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
		query.append("SELECT EUR.HLG_TP_CD POD_HAULAGE" ).append("\n"); 
		query.append("    --CASE WHEN EUR.HLG_TP_CD ='C' THEN 'Y'" ).append("\n"); 
		query.append("    --ELSE 'N'" ).append("\n"); 
		query.append("    --END POD_HALUAGE" ).append("\n"); 
		query.append(" FROM BKG_BOOKING BK, BKG_EUR_TRO EUR" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND BK.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("AND BK.BKG_NO = EUR.BKG_NO(+)" ).append("\n"); 
		query.append("AND EUR.IO_BND_CD (+) = 'I'" ).append("\n"); 
		query.append("AND EUR.CXL_FLG(+) <> 'Y'" ).append("\n"); 
		query.append("AND ROWNUM =1 " ).append("\n"); 

	}
}