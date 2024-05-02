/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : PRICommonDBDAOCmpbGroupCommodityNmRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.08
*@LastModifier : 이승준
*@LastVersion : 1.0
* 2009.09.08 이승준
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.pricommon.pricommon.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Seung-Jun,Lee
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PRICommonDBDAOCmpbGroupCommodityNmRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * cmpb group commodity name select
	  * </pre>
	  */
	public PRICommonDBDAOCmpbGroupCommodityNmRSQL(){
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
		params.put("etc3",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("etc2",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.pri.pricommon.pricommon.integration").append("\n"); 
		query.append("FileName : PRICommonDBDAOCmpbGroupCommodityNmRSQL").append("\n"); 
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
		query.append("SELECT  PRC_GRP_CMDT_DESC" ).append("\n"); 
		query.append("#if (${etc5} == 'CMPB')" ).append("\n"); 
		query.append("FROM	PRI_CMPB_GRP_CMDT" ).append("\n"); 
		query.append("WHERE	SVC_SCP_CD = @[etc1]" ).append("\n"); 
		query.append("AND		CRE_OFC_CD = @[etc2]" ).append("\n"); 
		query.append("AND		GLINE_SEQ = @[etc3]" ).append("\n"); 
		query.append("AND		PRC_GRP_CMDT_CD = @[cd]" ).append("\n"); 
		query.append("AND		ROWNUM = 1" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${etc5} == 'SQ')" ).append("\n"); 
		query.append("FROM	PRI_SQ_GRP_CMDT" ).append("\n"); 
		query.append("WHERE	QTTN_NO = @[etc1]" ).append("\n"); 
		query.append("AND		QTTN_VER_NO = @[etc2]" ).append("\n"); 
		query.append("AND		PRC_GRP_CMDT_CD = @[cd]" ).append("\n"); 
		query.append("AND		ROWNUM = 1" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${etc5} == 'RQ')" ).append("\n"); 
		query.append("FROM	PRI_RQ_GRP_CMDT" ).append("\n"); 
		query.append("WHERE	QTTN_NO = @[etc1]" ).append("\n"); 
		query.append("AND		QTTN_VER_NO = @[etc2]" ).append("\n"); 
		query.append("AND		PRC_GRP_CMDT_CD = @[cd]" ).append("\n"); 
		query.append("AND		ROWNUM = 1" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}