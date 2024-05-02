/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : TotalLossMgtDBDAOsearchTotalLossNoDataRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.24
*@LastModifier : 김완규
*@LastVersion : 1.0
* 2009.09.24 김완규
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.mnr.operationmanage.totallossmgt.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author WanGyu Kim
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TotalLossMgtDBDAOsearchTotalLossNoDataRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Total Loss Request 에서 Header 신규생성시, 신규 Total Loss No 조회
	  * </pre>
	  */
	public TotalLossMgtDBDAOsearchTotalLossNoDataRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pre_total_loss_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.mnr.operationmanage.totallossmgt.integration ").append("\n"); 
		query.append("FileName : TotalLossMgtDBDAOsearchTotalLossNoDataRSQL").append("\n"); 
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
		query.append("SELECT C.PRE_TTL_LSS_NO||" ).append("\n"); 
		query.append("DECODE(LENGTH(C.POST_TTL_LSS_NO),1,'00'||C.POST_TTL_LSS_NO" ).append("\n"); 
		query.append(",2,'0'||C.POST_TTL_LSS_NO" ).append("\n"); 
		query.append(",C.POST_TTL_LSS_NO)" ).append("\n"); 
		query.append("AS TTL_LSS_NO" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("SELECT B.PRE_TTL_LSS_NO" ).append("\n"); 
		query.append(", TO_CHAR(NVL(MAX(TO_NUMBER(SUBSTR(A.TTL_LSS_NO,LENGTH(A.TTL_LSS_NO)-2))),0)+1) AS POST_TTL_LSS_NO" ).append("\n"); 
		query.append("FROM MNR_TTL_LSS_RQST_HDR A" ).append("\n"); 
		query.append(", (SELECT @[pre_total_loss_no]||'-'||TO_CHAR(SYSDATE,'YYYYMM')||'-' AS PRE_TTL_LSS_NO" ).append("\n"); 
		query.append("FROM DUAL) B" ).append("\n"); 
		query.append("WHERE A.TTL_LSS_NO LIKE B.PRE_TTL_LSS_NO||'%'" ).append("\n"); 
		query.append(") C" ).append("\n"); 

	}
}