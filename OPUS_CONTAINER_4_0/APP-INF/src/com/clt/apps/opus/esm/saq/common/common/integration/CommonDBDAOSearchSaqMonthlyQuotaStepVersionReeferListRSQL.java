/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : CommonDBDAOSearchSaqMonthlyQuotaStepVersionReeferListRSQL.java
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

public class CommonDBDAOSearchSaqMonthlyQuotaStepVersionReeferListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 분기 냉동컨테이너 버전 가져오기
	  * </pre>
	  */
	public CommonDBDAOSearchSaqMonthlyQuotaStepVersionReeferListRSQL(){
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

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("qtaTgtCd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("quarter",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.saq.common.common.integration").append("\n"); 
		query.append("FileName : CommonDBDAOSearchSaqMonthlyQuotaStepVersionReeferListRSQL").append("\n"); 
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
		query.append("SELECT MQTA_STEP_CD      || '|' || MQTA_VER_NO    || '|' ||            " ).append("\n"); 
		query.append("       SLS_FCAST_PUB_NO  || '|' || MQTA_MDL_VER_NO           AS CODE,  " ).append("\n"); 
		query.append("       SUBSTR(MQTA_VER_NO,1,LENGTH(MQTA_VER_NO)-2)                     " ).append("\n"); 
		query.append("       || '-' || SUBSTR(MQTA_VER_NO,LENGTH(MQTA_VER_NO)-1,2)           " ).append("\n"); 
		query.append("       || DECODE(SAQ_STS_CD,'00','','-'||SAQ_STS_CD)         AS TEXT   " ).append("\n"); 
		query.append("FROM   SAQ_MON_QTA_STEP_VER_RF                                         " ).append("\n"); 
		query.append("WHERE  1 = 1                				                              " ).append("\n"); 
		query.append("AND    MQTA_STEP_CD = ( SELECT MAX(MQTA_STEP_CD) 				      " ).append("\n"); 
		query.append("                        FROM   SAQ_MON_QTA_STEP_VER_RF				  " ).append("\n"); 
		query.append("                        WHERE  1=1				                      " ).append("\n"); 
		query.append("                        AND    BSE_YR       = @[year]                        " ).append("\n"); 
		query.append("                        AND    BSE_QTR_CD   = @[quarter]                        " ).append("\n"); 
		query.append("                        AND    QTA_TGT_CD   = @[qtaTgtCd]                        " ).append("\n"); 
		query.append("                        AND    CRE_OFC_CD   LIKE @[ofcCd] || '%'              " ).append("\n"); 
		query.append("                        AND    MQTA_STEP_CD <> '07'  )                 " ).append("\n"); 
		query.append("AND    BSE_YR       = @[year]                                                " ).append("\n"); 
		query.append("AND    BSE_QTR_CD   = @[quarter]                                                " ).append("\n"); 
		query.append("AND    QTA_TGT_CD   = @[qtaTgtCd]                                                " ).append("\n"); 
		query.append("AND    CRE_OFC_CD   LIKE @[ofcCd] || '%'     " ).append("\n"); 

	}
}