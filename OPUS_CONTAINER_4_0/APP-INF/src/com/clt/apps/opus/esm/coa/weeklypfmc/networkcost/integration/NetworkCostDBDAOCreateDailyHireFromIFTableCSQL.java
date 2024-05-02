/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : NetworkCostDBDAOCreateDailyHireFromIFTableCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.03.05
*@LastModifier : 
*@LastVersion : 1.0
* 2015.03.05 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.coa.weeklypfmc.networkcost.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
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
	  * 2014.07.28 SJH Dailyhire by Cht-VSL (PA) Create 기능 추가
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
		query.append("Path : com.clt.apps.opus.esm.coa.weeklypfmc.networkcost.integration").append("\n"); 
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
		query.append("INSERT INTO COA_CHRG_VSL_DLY_HIR" ).append("\n"); 
		query.append("(COST_YRMON, VSL_CD, CHRG_DHIR_AMT, CRE_USR_ID, CRE_DT, UPD_USR_ID, UPD_DT)           " ).append("\n"); 
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
		query.append("                FROM (     " ).append("\n"); 
		query.append("                        SELECT   A.VSL_CD " ).append("\n"); 
		query.append("                                ,DECODE(N2ND_CURR_CD,NULL,1,2) SEQ " ).append("\n"); 
		query.append("                                ,N1ST_HIR_RT" ).append("\n"); 
		query.append("                                ,N2ND_HIR_RT" ).append("\n"); 
		query.append("                                ,N1ST_CURR_CD" ).append("\n"); 
		query.append("                                ,N2ND_CURR_CD " ).append("\n"); 
		query.append("                                ,TO_DATE (A.CTRT_EFF_FM_DT, 'YYYYMMDD') CTRT_EFF_FM_DT " ).append("\n"); 
		query.append("                                ,TO_DATE (A.CTRT_EFF_TO_DT, 'YYYYMMDD') CTRT_EFF_TO_DT " ).append("\n"); 
		query.append("                        FROM COA_VSL_CHRG_IF A" ).append("\n"); 
		query.append("                            ,COA_VSL_RGST B " ).append("\n"); 
		query.append("                            ,( SELECT   COST_YRMON " ).append("\n"); 
		query.append("                                        ,VSL_CD " ).append("\n"); 
		query.append("                                        ,CHRG_CTRT_NO " ).append("\n"); 
		query.append("                                        ,MAX (CHRG_CTRT_SEQ) CHRG_CTRT_SEQ_MAX " ).append("\n"); 
		query.append("                                FROM    COA_VSL_CHRG_IF X1 " ).append("\n"); 
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
		query.append("        AND     B.ACCT_XCH_RT_YRMON     = @[f_yearweek] --parameter" ).append("\n"); 
		query.append("        GROUP BY A.VSL_CD  " ).append("\n"); 
		query.append("      )" ).append("\n"); 

	}
}