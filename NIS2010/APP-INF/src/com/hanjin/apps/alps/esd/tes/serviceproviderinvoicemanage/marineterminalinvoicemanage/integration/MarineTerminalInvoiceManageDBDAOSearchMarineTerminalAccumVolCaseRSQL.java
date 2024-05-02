/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : MarineTerminalInvoiceManageDBDAOSearchMarineTerminalAccumVolCaseRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.09
*@LastModifier : 박재흥
*@LastVersion : 1.0
* 2009.09.09 박재흥
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.tes.serviceproviderinvoicemanage.marineterminalinvoicemanage.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author park chae heung
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class MarineTerminalInvoiceManageDBDAOSearchMarineTerminalAccumVolCaseRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchMarineTerminalAccumVolCase
	  * </pre>
	  */
	public MarineTerminalInvoiceManageDBDAOSearchMarineTerminalAccumVolCaseRSQL(){
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
		params.put("yd_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.tes.serviceproviderinvoicemanage.marineterminalinvoicemanage.integration ").append("\n"); 
		query.append("FileName : MarineTerminalInvoiceManageDBDAOSearchMarineTerminalAccumVolCaseRSQL").append("\n"); 
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
		query.append("SELECT CASE WHEN COUNT(A.ACCM_SEQ) > 0 THEN'U'ELSE 'I' END RESULT" ).append("\n"); 
		query.append("FROM 	TES_TML_SO_ACCM A, TES_TML_SO_ACCM_YD Y, TES_TML_SO_ACCM_MZD M" ).append("\n"); 
		query.append("WHERE 	A.vndr_seq 	= @[vndr_seq]" ).append("\n"); 
		query.append("AND 	Y.yd_cd		= @[yd_cd]" ).append("\n"); 
		query.append("AND    M.VNDR_SEQ  = Y.VNDR_SEQ" ).append("\n"); 
		query.append("AND    M.ACCM_SEQ  = Y.ACCM_SEQ" ).append("\n"); 

	}
}