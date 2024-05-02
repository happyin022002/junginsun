/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : CommonDBDAOSearchMonthlyQuotaModelVersionListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.03.03
*@LastModifier : 
*@LastVersion : 1.0
* 2011.03.03 
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

public class CommonDBDAOSearchMonthlyQuotaModelVersionListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchLaneBoundSwitchRlaneList 목록 조회
	  * </pre>
	  */
	public CommonDBDAOSearchMonthlyQuotaModelVersionListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bse_qtr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("year",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.saq.common.common.integration").append("\n"); 
		query.append("FileName : CommonDBDAOSearchMonthlyQuotaModelVersionListRSQL").append("\n"); 
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
		query.append("SELECT  MQTA_MDL_VER_NO AS CODE, " ).append("\n"); 
		query.append("        MQTA_MDL_VER_NO||DECODE(FNL_VER_FLG, 'Y', '-F', '') AS TEXT " ).append("\n"); 
		query.append("FROM SAQ_MON_QTA_MDL_EXE " ).append("\n"); 
		query.append("WHERE BSE_YR = @[year]  " ).append("\n"); 
		query.append("AND   BSE_QTR_CD = @[bse_qtr_cd] " ).append("\n"); 
		query.append("ORDER BY MQTA_MDL_VER_NO DESC " ).append("\n"); 

	}
}