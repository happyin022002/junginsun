/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : NetworkCostDBDAOCreateDailyHireFromIFTableCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.08.08
*@LastModifier :  최덕우
*@LastVersion : 1.0
* 2016.08.08  최덕우
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.mas.weeklypfmc.networkcost.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author CHOI Duk-Woo
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class NetworkCostDBDAOCreateDailyHireFromIFTableCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 2012.07.05 이석준 [CHM-201218728-01] Dailyhire by Cht-VSL (PA) Create 기능 추가
	  * 2015.07.01  김시몬 없을 경우 가장최근월가져오도록 보완
	  * </pre>
	  */
	public NetworkCostDBDAOCreateDailyHireFromIFTableCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_yearweek",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("user_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.mas.weeklypfmc.networkcost.integration").append("\n"); 
		query.append("FileName : NetworkCostDBDAOCreateDailyHireFromIFTableCSQL").append("\n"); 
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
		query.append("INSERT INTO MAS_CHRG_VSL_DLY_HIR                   " ).append("\n"); 
		query.append("SELECT @[f_yearweek] --parameter" ).append("\n"); 
		query.append("      ,VSL_CD" ).append("\n"); 
		query.append("      ,RATE     " ).append("\n"); 
		query.append("      ,@[user_id] --parameter" ).append("\n"); 
		query.append("      ,SYSDATE " ).append("\n"); 
		query.append("      ,@[user_id] --parameter" ).append("\n"); 
		query.append("      ,SYSDATE " ).append("\n"); 
		query.append("FROM (SELECT A.VSL_CD" ).append("\n"); 
		query.append("            ,SUM (A.RATE / DECODE (A.CURR_CD, 'USD', 1, NVL (B.USD_LOCL_XCH_RT, 0))) RATE" ).append("\n"); 
		query.append("        FROM (SELECT  VSL_CD" ).append("\n"); 
		query.append("                     ,DECODE(NO,1,N1ST_HIR_RT,N2ND_HIR_RT) RATE" ).append("\n"); 
		query.append("                     ,DECODE(NO,1,N1ST_CURR_CD,N2ND_CURR_CD) CURR_CD" ).append("\n"); 
		query.append("                     ,CTRT_EFF_FM_DT" ).append("\n"); 
		query.append("                     ,CTRT_EFF_TO_DT" ).append("\n"); 
		query.append("                     ,ROW_NUMBER() OVER (PARTITION BY VSL_CD ORDER BY VSL_CD, CTRT_EFF_FM_DT DESC) VSL_SEQ" ).append("\n"); 
		query.append("                FROM (     " ).append("\n"); 
		query.append("                        SELECT   A.VSL_CD " ).append("\n"); 
		query.append("                                ,DECODE(N2ND_CURR_CD,NULL,1,2) SEQ " ).append("\n"); 
		query.append("                                ,N1ST_HIR_RT" ).append("\n"); 
		query.append("                                ,N2ND_HIR_RT" ).append("\n"); 
		query.append("                                ,N1ST_CURR_CD" ).append("\n"); 
		query.append("                                ,N2ND_CURR_CD " ).append("\n"); 
		query.append("                                ,TO_DATE (A.CTRT_EFF_FM_DT, 'YYYYMMDD') CTRT_EFF_FM_DT " ).append("\n"); 
		query.append("                                ,TO_DATE (A.CTRT_EFF_TO_DT, 'YYYYMMDD') CTRT_EFF_TO_DT " ).append("\n"); 
		query.append("                        FROM MAS_VSL_CHRG_IF A" ).append("\n"); 
		query.append("                            ,MAS_VSL_RGST B " ).append("\n"); 
		query.append("                            ,( SELECT   COST_YRMON " ).append("\n"); 
		query.append("                                        ,VSL_CD " ).append("\n"); 
		query.append("                                        ,CHRG_CTRT_NO " ).append("\n"); 
		query.append("                                        ,MAX (CHRG_CTRT_SEQ) CHRG_CTRT_SEQ_MAX " ).append("\n"); 
		query.append("                                FROM    MAS_VSL_CHRG_IF X1 " ).append("\n"); 
		query.append("                                WHERE   COST_YRMON = @[f_yearweek] --parameter" ).append("\n"); 
		query.append("                                GROUP BY COST_YRMON, VSL_CD, CHRG_CTRT_NO" ).append("\n"); 
		query.append("                              ) C " ).append("\n"); 
		query.append("                        WHERE   A.VSL_CD          = B.VSL_CD " ).append("\n"); 
		query.append("                        AND     A.COST_YRMON      = C.COST_YRMON " ).append("\n"); 
		query.append("                        AND     A.VSL_CD          = C.VSL_CD " ).append("\n"); 
		query.append("                        AND     A.CHRG_CTRT_NO    = C.CHRG_CTRT_NO " ).append("\n"); 
		query.append("                        AND     A.CHRG_CTRT_SEQ   = C.CHRG_CTRT_SEQ_MAX " ).append("\n"); 
		query.append("                        AND     A.COST_YRMON      = @[f_yearweek] --parameter" ).append("\n"); 
		query.append("                        AND     NVL(B.DELT_FLG, 'N')  = 'N' " ).append("\n"); 
		query.append("                        AND     B.LST_FLG         = 'Y'" ).append("\n"); 
		query.append("                        AND     B.VSL_TP_CD       = 'C'" ).append("\n"); 
		query.append("                    )" ).append("\n"); 
		query.append("                  , (SELECT CPY_NO NO FROM COM_CPY_NO WHERE CPY_NO BETWEEN 1 AND 2) " ).append("\n"); 
		query.append("                WHERE SEQ >= NO ) A" ).append("\n"); 
		query.append("              , GL_MON_XCH_RT B " ).append("\n"); 
		query.append("        WHERE   A.CURR_CD               = B.CURR_CD " ).append("\n"); 
		query.append("        AND     B.ACCT_XCH_RT_LVL       = '1' " ).append("\n"); 
		query.append("        AND     A.VSL_SEQ = 1" ).append("\n"); 
		query.append("        AND     B.ACCT_XCH_RT_YRMON     = (SELECT MAX(ACCT_XCH_RT_YRMON)" ).append("\n"); 
		query.append("                                             FROM GL_MON_XCH_RT D" ).append("\n"); 
		query.append("                                            WHERE D.ACCT_XCH_RT_LVL = '1'" ).append("\n"); 
		query.append("                                              AND D.ACCT_XCH_RT_YRMON <= @[f_yearweek] --parameter" ).append("\n"); 
		query.append("                                          )" ).append("\n"); 
		query.append("        GROUP BY A.VSL_CD  " ).append("\n"); 
		query.append("      )" ).append("\n"); 

	}
}