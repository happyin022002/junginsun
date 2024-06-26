/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : CommonDBDAOSearchSaqUserOfcCheckListRSQL.java
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

public class CommonDBDAOSearchSaqUserOfcCheckListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ofcCd로 소속 구분하기("":SELCDS, Trade, RHQ, RGN)
	  * </pre>
	  */
	public CommonDBDAOSearchSaqUserOfcCheckListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ofcCd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.saq.common.common.integration").append("\n"); 
		query.append("FileName : CommonDBDAOSearchSaqUserOfcCheckListRSQL").append("\n"); 
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
		query.append("SELECT 'TRADE'||'-'||SAQ_TGT_GRP_CD AS CODE,               " ).append("\n"); 
		query.append("       'TRADE'||'-'||SAQ_TGT_GRP_CD AS TEXT                " ).append("\n"); 
		query.append("  FROM SAQ_TGT_GRP                                         " ).append("\n"); 
		query.append(" WHERE OFC_CD           = @[ofcCd]                                " ).append("\n"); 
		query.append("UNION ALL                                                  " ).append("\n"); 
		query.append("SELECT 'RHQ'||'-'||OFC_CD AS CODE,                         " ).append("\n"); 
		query.append("       'RHQ'||'-'||OFC_CD AS TEXT                          " ).append("\n"); 
		query.append("  FROM SAQ_ORGANIZATION_V                                  " ).append("\n"); 
		query.append(" WHERE OFC_CD           = @[ofcCd]                                " ).append("\n"); 
		query.append("   AND N2ND_PRNT_OFC_CD = @[ofcCd]                                " ).append("\n"); 
		query.append("UNION ALL                                                  " ).append("\n"); 
		query.append("SELECT 'RGN'||'-'||N2ND_PRNT_OFC_CD||'-'||OFC_CD AS CODE,  " ).append("\n"); 
		query.append("       'RGN'||'-'||N2ND_PRNT_OFC_CD||'-'||OFC_CD AS TEXT   " ).append("\n"); 
		query.append("  FROM SAQ_ORGANIZATION_V                                  " ).append("\n"); 
		query.append(" WHERE OFC_CD           = @[ofcCd]                                " ).append("\n"); 
		query.append("   AND N4TH_PRNT_OFC_CD = @[ofcCd]                 " ).append("\n"); 

	}
}