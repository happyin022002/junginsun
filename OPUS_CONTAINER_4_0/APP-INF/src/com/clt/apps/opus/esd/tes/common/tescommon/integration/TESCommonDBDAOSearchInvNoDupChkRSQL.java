/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : TESCommonDBDAOSearchInvNoDupChkRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.10.17
*@LastModifier : 
*@LastVersion : 1.0
* 2014.10.17 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.tes.common.tescommon.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TESCommonDBDAOSearchInvNoDupChkRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Invoice Duplication Check
	  * </pre>
	  */
	public TESCommonDBDAOSearchInvNoDupChkRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vndr_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inv_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.tes.common.tescommon.integration ").append("\n"); 
		query.append("FileName : TESCommonDBDAOSearchInvNoDupChkRSQL").append("\n"); 
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
		query.append("SELECT 'Y' INV_DUP_CHK" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 
		query.append("WHERE EXISTS (" ).append("\n"); 
		query.append("    SELECT 'X'" ).append("\n"); 
		query.append("    FROM AP_INV_HDR A, AP_INV_DTRB B" ).append("\n"); 
		query.append("    WHERE A.CSR_NO      = B.CSR_NO" ).append("\n"); 
		query.append("    AND   B.ATTR_CTNT1  = @[inv_no]" ).append("\n"); 
		query.append("    AND   A.VNDR_NO     = @[vndr_seq] " ).append("\n"); 
		query.append("    AND   A.AFT_ACT_FLG NOT IN ('N', 'X'))  " ).append("\n"); 

	}
}