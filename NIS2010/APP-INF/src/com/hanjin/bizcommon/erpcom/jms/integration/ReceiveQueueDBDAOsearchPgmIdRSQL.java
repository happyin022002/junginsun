/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : ReceiveQueueDBDAOsearchPgmIdRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.10.12
*@LastModifier : 민정호
*@LastVersion : 1.0
* 2011.10.12 민정호
* 1.0 Creation
=========================================================*/
package com.hanjin.bizcommon.erpcom.jms.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Min Jung Ho
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ReceiveQueueDBDAOsearchPgmIdRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * GET AP_PGM_NO
	  * </pre>
	  */
	public ReceiveQueueDBDAOsearchPgmIdRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("csr_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.bizcommon.erpcom.jms.integration ").append("\n"); 
		query.append("FileName : ReceiveQueueDBDAOsearchPgmIdRSQL").append("\n"); 
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
		query.append("SELECT SRC_CTNT" ).append("\n"); 
		query.append("FROM AP_INV_HDR" ).append("\n"); 
		query.append("WHERE CSR_NO = @[csr_no]" ).append("\n"); 
		query.append("AND ROWNUM = 1" ).append("\n"); 

	}
}