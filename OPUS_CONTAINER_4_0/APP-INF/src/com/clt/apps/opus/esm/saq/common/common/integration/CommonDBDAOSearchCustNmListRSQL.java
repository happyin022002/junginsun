/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : CommonDBDAOSearchCustNmListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.03.04
*@LastModifier : 
*@LastVersion : 1.0
* 2011.03.04 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.saq.common.common.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CommonDBDAOSearchCustNmListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * y & Multi Trade Acct 판매목표 수립관련
	  * </pre>
	  */
	public CommonDBDAOSearchCustNmListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("qta_tgt_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.saq.common.common.integration").append("\n"); 
		query.append("FileName : CommonDBDAOSearchCustNmListRSQL").append("\n"); 
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
		query.append("SELECT  DISTINCT B.CUST_GRP_ID CODE           " ).append("\n"); 
		query.append("       ,B.CUST_GRP_NM TEXT                    " ).append("\n"); 
		query.append("FROM    MDM_CUSTOMER      C   ,               " ).append("\n"); 
		query.append("        MDM_CUST_PERF_GRP B                   " ).append("\n"); 
		query.append("WHERE   C.CUST_GRP_ID     = B.CUST_GRP_ID(+)  " ).append("\n"); 
		query.append("AND     C.DELT_FLG        = 'N'               " ).append("\n"); 
		query.append("AND     DECODE(@[qta_tgt_cd],'G',C.KEY_ACCT_FLG,'M',MLT_TRD_ACCT_FLG) = 'Y' " ).append("\n"); 
		query.append("AND     C.CUST_GRP_ID IS NOT NULL             " ).append("\n"); 
		query.append("ORDER BY B.CUST_GRP_NM    " ).append("\n"); 

	}
}