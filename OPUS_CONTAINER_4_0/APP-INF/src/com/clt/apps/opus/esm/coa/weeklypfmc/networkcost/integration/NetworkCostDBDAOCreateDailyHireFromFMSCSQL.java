/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : NetworkCostDBDAOCreateDailyHireFromFMSCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.07.28
*@LastModifier : 
*@LastVersion : 1.0
* 2014.07.28 
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

public class NetworkCostDBDAOCreateDailyHireFromFMSCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 2014.07.28 SJH Dailyhire by Cht-VSL (PA) Create 기능 추가
	  * </pre>
	  */
	public NetworkCostDBDAOCreateDailyHireFromFMSCSQL(){
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
		query.append("FileName : NetworkCostDBDAOCreateDailyHireFromFMSCSQL").append("\n"); 
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
		query.append("INSERT INTO COA_VSL_CHRG_IF " ).append("\n"); 
		query.append("           (COST_YRMON" ).append("\n"); 
		query.append("           ,VSL_CD" ).append("\n"); 
		query.append("           ,CHRG_CTRT_NO" ).append("\n"); 
		query.append("           ,CHRG_CTRT_SEQ" ).append("\n"); 
		query.append("           ,CTRT_EFF_FM_DT" ).append("\n"); 
		query.append("           ,CTRT_EFF_TO_DT" ).append("\n"); 
		query.append("           ,N1ST_HIR_RT" ).append("\n"); 
		query.append("           ,N1ST_CURR_CD" ).append("\n"); 
		query.append("           ,N2ND_HIR_RT" ).append("\n"); 
		query.append("           ,N2ND_CURR_CD" ).append("\n"); 
		query.append("           ,CRE_USR_ID" ).append("\n"); 
		query.append("           ,CRE_DT" ).append("\n"); 
		query.append("           ,UPD_USR_ID" ).append("\n"); 
		query.append("           ,UPD_DT) " ).append("\n"); 
		query.append("(SELECT @[f_yearweek]  COST_YRMON --parameter" ).append("\n"); 
		query.append("        ,VSL_CD" ).append("\n"); 
		query.append("        ,FLET_CTRT_NO" ).append("\n"); 
		query.append("        ,SEQ" ).append("\n"); 
		query.append("        ,HIRE_FM_DT" ).append("\n"); 
		query.append("        ,HIRE_TO_DT" ).append("\n"); 
		query.append("        ,HIR_RT_N1ST_AMT        " ).append("\n"); 
		query.append("        ,HIR_CURR_N1ST_CD " ).append("\n"); 
		query.append("        ,HIR_RT_N2ND_AMT " ).append("\n"); 
		query.append("        ,HIR_CURR_N2ND_CD  " ).append("\n"); 
		query.append("        ,@[user_id] --parameter" ).append("\n"); 
		query.append("        ,sysdate " ).append("\n"); 
		query.append("        ,@[user_id] --parameter" ).append("\n"); 
		query.append("        ,sysdate " ).append("\n"); 
		query.append("  FROM (SELECT FLET_CTRT_NO" ).append("\n"); 
		query.append("              ,VSL_CD" ).append("\n"); 
		query.append("              ,SEQ " ).append("\n"); 
		query.append("              ,HIRE_FM_DT" ).append("\n"); 
		query.append("              ,DECODE(NVL(NEXT_HIRE_STDD, EXP_DT)" ).append("\n"); 
		query.append("                     ,NEXT_HIRE_STDD, TO_CHAR(TO_DATE(NEXT_HIRE_STDD, 'YYYYMMDD') - 1, 'YYYYMMDD')" ).append("\n"); 
		query.append("                     ,NVL(NEXT_HIRE_STDD, EXP_DT)" ).append("\n"); 
		query.append("                     ) HIRE_TO_DT" ).append("\n"); 
		query.append("              ,HIR_RT_N1ST_AMT " ).append("\n"); 
		query.append("              ,HIR_CURR_N1ST_CD" ).append("\n"); 
		query.append("              ,HIR_RT_N2ND_AMT" ).append("\n"); 
		query.append("              ,HIR_CURR_N2ND_CD " ).append("\n"); 
		query.append("          FROM (SELECT FLET_CTRT_NO " ).append("\n"); 
		query.append("                      ,VSL_CD" ).append("\n"); 
		query.append("                      ,SEQ" ).append("\n"); 
		query.append("                      ,EFF_DT HIRE_FM_DT" ).append("\n"); 
		query.append("                      ,EXP_DT" ).append("\n"); 
		query.append("                      ,LEAD(EFF_DT) OVER(PARTITION BY FLET_CTRT_NO, VSL_CD ORDER BY FLET_CTRT_NO, VSL_CD, EFF_DT) NEXT_HIRE_STDD" ).append("\n"); 
		query.append("                      ,HIR_RT_N1ST_AMT" ).append("\n"); 
		query.append("                      ,HIR_CURR_N1ST_CD" ).append("\n"); 
		query.append("                      ,HIR_RT_N2ND_AMT" ).append("\n"); 
		query.append("                      ,HIR_CURR_N2ND_CD" ).append("\n"); 
		query.append("                  FROM (SELECT M.FLET_CTRT_NO" ).append("\n"); 
		query.append("                              ,M.VSL_CD" ).append("\n"); 
		query.append("                              ,ROW_NUMBER() OVER(PARTITION BY M.FLET_CTRT_NO ORDER BY M.FLET_CTRT_NO, M.VSL_CD) SEQ" ).append("\n"); 
		query.append("                             ,TO_CHAR(D.EFF_DT, 'YYYYMMDD') EFF_DT" ).append("\n"); 
		query.append("                             ,TO_CHAR(D.EXP_DT, 'YYYYMMDD') EXP_DT" ).append("\n"); 
		query.append("                             ,D.HIR_RT_N1ST_AMT " ).append("\n"); 
		query.append("                             ,D.HIR_CURR_N1ST_CD " ).append("\n"); 
		query.append("                             ,D.HIR_RT_N2ND_AMT " ).append("\n"); 
		query.append("                             ,D.HIR_CURR_N2ND_CD" ).append("\n"); 
		query.append("                         FROM  FMS_CONTRACT M" ).append("\n"); 
		query.append("                              ,FMS_HIRE D           " ).append("\n"); 
		query.append("                         WHERE M.FLET_CTRT_FACT_CD ='ACT'    --실계약" ).append("\n"); 
		query.append("                           AND M.FLET_CTRT_NO = D.FLET_CTRT_NO" ).append("\n"); 
		query.append("                           AND M.FLET_CTRT_TP_CD = 'TI'       --용선TI 대선TO " ).append("\n"); 
		query.append("                           AND D.EFF_DT <= TO_DATE(SUBSTR( @[f_yearweek] ,1,4) || '1231', 'YYYYMMDD')" ).append("\n"); 
		query.append("                           AND D.EXP_DT >= TO_DATE(SUBSTR( @[f_yearweek] ,1,4) || '0101', 'YYYYMMDD')" ).append("\n"); 
		query.append("                        )" ).append("\n"); 
		query.append("                )" ).append("\n"); 
		query.append("         )" ).append("\n"); 
		query.append(" WHERE  @[f_yearweek]  || '31' >= HIRE_FM_DT" ).append("\n"); 
		query.append("   AND  @[f_yearweek]  || '01' <= HIRE_TO_DT" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}