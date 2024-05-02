/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : CommonDBDAOSearchSaqMonthlyGamerCreCheckListRSQL.java
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

public class CommonDBDAOSearchSaqMonthlyGamerCreCheckListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 분기 GAMer : GAMer Create이 가능한 상태인지 체크한다.(trade의 01step(=03step),02step이 모두 'FN'또는 'QN'또는 'QF'이여야 한다.)
	  * </pre>
	  */
	public CommonDBDAOSearchSaqMonthlyGamerCreCheckListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bseQtrCd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bseYr",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.saq.common.common.integration").append("\n"); 
		query.append("FileName : CommonDBDAOSearchSaqMonthlyGamerCreCheckListRSQL").append("\n"); 
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
		query.append("SELECT  SUM(DECODE(KEY_CNT, FN, 0, 1)) * SUM(DECODE(KEY_CNT, QN, 0, 1)) * SUM(DECODE(KEY_CNT, QF, 0, 1)) CODE		,                           " ).append("\n"); 
		query.append("		   SUM(DECODE(KEY_CNT, FN, 0, 1)) * SUM(DECODE(KEY_CNT, QN, 0, 1)) * SUM(DECODE(KEY_CNT, QF, 0, 1)) TEXT                                    " ).append("\n"); 
		query.append("FROM    (SELECT MQTA_STEP_CD                                                                                                             ,       " ).append("\n"); 
		query.append("                COUNT(DISTINCT TRD_CD || DIR_CD || CRE_OFC_CD)                                                                  KEY_CNT  ,       " ).append("\n"); 
		query.append("                DECODE(MQTA_STEP_CD, '01', SUM(DECODE(SVR.SAQ_STS_CD, 'FN', 1, 0)), SUM(DECODE(SVR.SAQ_STS_CD, 'FC', 1, 0)))    FN       ,       " ).append("\n"); 
		query.append("                SUM(DECODE(SVR.SAQ_STS_CD, 'QN', 1, 0))                                                                         QN       ,       " ).append("\n"); 
		query.append("                SUM(DECODE(SVR.SAQ_STS_CD, 'QF', 1, 0))                                                                         QF               " ).append("\n"); 
		query.append("         FROM   SAQ_MON_QTA_STEP_VER SVR                                                                                                         " ).append("\n"); 
		query.append("         WHERE  MQTA_STEP_CD       IN ('01', '02')                                                                                               " ).append("\n"); 
		query.append("         AND    SVR.BSE_YR         = @[bseYr]                                                                                                           " ).append("\n"); 
		query.append("         AND    SVR.BSE_QTR_CD     = @[bseQtrCd]                                                                                                           " ).append("\n"); 
		query.append("         AND    SVR.SAQ_STS_CD     <> 'XX'                                                                                                       " ).append("\n"); 
		query.append("         GROUP  BY MQTA_STEP_CD                  )      " ).append("\n"); 

	}
}