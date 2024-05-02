/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : SalesAdminCommonDBDAOSearchActItemDtlListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.07.07
*@LastModifier : 김경미
*@LastVersion : 1.0
* 2015.07.07 김경미
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.sam.salesadmincommon.salesadmincommon.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Kmy(Kyeongmi) Kim
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SalesAdminCommonDBDAOSearchActItemDtlListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Sub type 조회용 쿼리
	  * </pre>
	  */
	public SalesAdminCommonDBDAOSearchActItemDtlListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sls_act_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.sam.salesadmincommon.salesadmincommon.integration").append("\n"); 
		query.append("FileName : SalesAdminCommonDBDAOSearchActItemDtlListRSQL").append("\n"); 
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
		query.append("SELECT SLS_ACT_TP_CD" ).append("\n"); 
		query.append("	   , SLS_ACT_SUB_TP_CD" ).append("\n"); 
		query.append("	   , SLS_ACT_SUB_TP_DESC" ).append("\n"); 
		query.append("FROM SAM_SLS_ACT_TP_DTL" ).append("\n"); 
		query.append("WHERE SLS_ACT_TP_CD = @[sls_act_tp_cd]" ).append("\n"); 
		query.append("ORDER BY SLS_ACT_SUB_TP_CD" ).append("\n"); 

	}
}