/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : CIMCommonDBDAORemoveCntrTypeSizeDivDSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.04.16
*@LastModifier : 김창헌
*@LastVersion : 1.0
* 2012.04.16 김창헌
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.cim.cimcommon.cimcommon.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Chang Hun Kim
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CIMCommonDBDAORemoveCntrTypeSizeDivDSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * CIM Container Type Size Division Remove
	  * </pre>
	  */
	public CIMCommonDBDAORemoveCntrTypeSizeDivDSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dp_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.cim.cimcommon.cimcommon.integration ").append("\n"); 
		query.append("FileName : CIMCommonDBDAORemoveCntrTypeSizeDivDSQL").append("\n"); 
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
		query.append("DELETE FROM CIM_TP_SZ_DP_SEQ" ).append("\n"); 
		query.append("WHERE	DP_SEQ = @[dp_seq]" ).append("\n"); 

	}
}