/*=========================================================
*Copyright(c) 2018 SM Line
*@FileName : MstMgmtDBDAOSearchCustMaxSeqRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2018.04.02
*@LastModifier : 
*@LastVersion : 1.0
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.bcm.ccd.commoncode.mstmgmt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class MstMgmtDBDAOSearchCustMaxSeqRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * MDM_CUST_SEQ_MGMT 테이블에서 CNT_CD별 CUST_MAX_SEQ 값을 조회한다.
	  * </pre>
	  */
	public MstMgmtDBDAOSearchCustMaxSeqRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.bcm.ccd.commoncode.mstmgmt.integration").append("\n"); 
		query.append("FileName : MstMgmtDBDAOSearchCustMaxSeqRSQL").append("\n"); 
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
		query.append("SELECT LPAD(NVL(MAX(CUST_MAX_SEQ), 0) + 1, 6, '0') CUST_MAX_SEQ" ).append("\n"); 
		query.append("  FROM MDM_CUST_SEQ_MGMT" ).append("\n"); 
		query.append(" WHERE CNT_CD = @[cnt_cd] " ).append("\n"); 

	}
}