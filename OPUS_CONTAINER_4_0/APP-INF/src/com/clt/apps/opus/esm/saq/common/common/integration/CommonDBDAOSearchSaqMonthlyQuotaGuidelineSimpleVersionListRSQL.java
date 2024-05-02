/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : CommonDBDAOSearchSaqMonthlyQuotaGuidelineSimpleVersionListRSQL.java
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

public class CommonDBDAOSearchSaqMonthlyQuotaGuidelineSimpleVersionListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 
	  * </pre>
	  */
	public CommonDBDAOSearchSaqMonthlyQuotaGuidelineSimpleVersionListRSQL(){
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

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("targetGrp",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.saq.common.common.integration").append("\n"); 
		query.append("FileName : CommonDBDAOSearchSaqMonthlyQuotaGuidelineSimpleVersionListRSQL").append("\n"); 
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
		query.append("SELECT  GLINE_VER_NO AS CODE, " ).append("\n"); 
		query.append("        SUBSTR(GLINE_VER_NO, LENGTH(CRE_OFC_CD)+1) AS TEXT " ).append("\n"); 
		query.append("FROM SAQ_MON_QTA_GLINE_VER " ).append("\n"); 
		query.append("WHERE BSE_YR = @[year] " ).append("\n"); 
		query.append("AND   BSE_QTR_CD = @[bse_qtr_cd] " ).append("\n"); 
		query.append("AND   SAQ_TGT_GRP_CD = @[targetGrp] " ).append("\n"); 
		query.append("AND   SAQ_STS_CD IN ('FN', 'QN', 'QF') " ).append("\n"); 
		query.append("ORDER BY GLINE_VER_NO DESC " ).append("\n"); 

	}
}