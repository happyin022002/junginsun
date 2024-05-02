/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : PRICommonDBDAOScgGrpCmdtCdListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.01.22
*@LastModifier : CHLOE MIJIN SEO
*@LastVersion : 1.0
* 2015.01.22 CHLOE MIJIN SEO
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.pri.pricommon.pricommon.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author CHLOE MIJIN SEO
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PRICommonDBDAOScgGrpCmdtCdListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * PRI_SCG_GRP_CMDT 테이블 조회
	  * </pre>
	  */
	public PRICommonDBDAOScgGrpCmdtCdListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("etc1",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("etc2",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.pri.pricommon.pricommon.integration").append("\n"); 
		query.append("FileName : PRICommonDBDAOScgGrpCmdtCdListRSQL").append("\n"); 
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
		query.append("SELECT SCG_GRP_CMDT_CD AS CD," ).append("\n"); 
		query.append("	   SCG_GRP_CMDT_DESC AS NM" ).append("\n"); 
		query.append("  FROM PRI_SCG_GRP_CMDT" ).append("\n"); 
		query.append(" WHERE SVC_SCP_CD = @[etc1]" ).append("\n"); 
		query.append("   AND CHG_CD = NVL(@[etc2], 'OFT')" ).append("\n"); 
		query.append("   AND DELT_FLG = 'N'" ).append("\n"); 

	}
}