/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : CommonDBDAOSearchCoaSaqRlaneListRSQL.java
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

public class CommonDBDAOSearchCoaSaqRlaneListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * COA_MON_VVD, SAQ_MON_CFM_TGT_VVD의 Rlane List 조회 
	  * </pre>
	  */
	public CommonDBDAOSearchCoaSaqRlaneListRSQL(){
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
		params.put("bse_yr",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mqta_rlse_ver_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.saq.common.common.integration").append("\n"); 
		query.append("FileName : CommonDBDAOSearchCoaSaqRlaneListRSQL").append("\n"); 
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
		query.append("WITH  COA_MON_VVD_V AS (" ).append("\n"); 
		query.append("              SELECT V.TRD_CD    , V.RLANE_CD            , V.VSL_CD   ," ).append("\n"); 
		query.append("                     V.SKD_VOY_NO, V.DIR_CD              , V.SLS_YRMON," ).append("\n"); 
		query.append("                     V.COST_WK   , V.SUB_TRD_CD          , V.IOC_CD   ," ).append("\n"); 
		query.append("                     V.VVD_SEQ   , V.LST_LODG_PORT_ETD_DT" ).append("\n"); 
		query.append("                FROM COA_MON_VVD V" ).append("\n"); 
		query.append("               WHERE V.SLS_YRMON BETWEEN (@[bse_yr]||DECODE(@[bse_qtr_cd], '1Q', '01', '2Q', '04', '3Q', '07', '4Q', '10'))" ).append("\n"); 
		query.append("                                     AND (@[bse_yr]||DECODE(@[bse_qtr_cd], '1Q', '03', '2Q', '06', '3Q', '09', '4Q', '12'))" ).append("\n"); 
		query.append("                 AND V.TRD_CD = @[trd_cd]" ).append("\n"); 
		query.append("                 AND V.DIR_CD = @[dir_cd]" ).append("\n"); 
		query.append("                 AND V.RLANE_CD <> 'RBCCO'" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                 AND (V.DELT_FLG IS NULL OR V.DELT_FLG = 'N')    )," ).append("\n"); 
		query.append("      EXCEPT_VVD AS (" ).append("\n"); 
		query.append("              SELECT CHKQTR_VVD.TRD_CD, CHKQTR_VVD.DIR_CD, CHKQTR_VVD.VSL_CD, CHKQTR_VVD.SKD_VOY_NO, CHKQTR_VVD.SKD_DIR_CD" ).append("\n"); 
		query.append("                FROM (                    -- 현분기에 없는 VVD" ).append("\n"); 
		query.append("                       SELECT TRD_CD, DIR_CD, VSL_CD, SKD_VOY_NO, DIR_CD AS SKD_DIR_CD" ).append("\n"); 
		query.append("                         FROM COA_MON_VVD_V" ).append("\n"); 
		query.append("                        MINUS" ).append("\n"); 
		query.append("                       SELECT TRD_CD, DIR_CD, VSL_CD, SKD_VOY_NO, SKD_DIR_CD" ).append("\n"); 
		query.append("                         FROM SAQ_MON_CFM_TGT_VVD" ).append("\n"); 
		query.append("                        WHERE 1=1" ).append("\n"); 
		query.append("                          AND MQTA_RLSE_VER_NO = @[mqta_rlse_ver_no]" ).append("\n"); 
		query.append("                          AND TRD_CD           = @[trd_cd]" ).append("\n"); 
		query.append("                          AND DIR_CD           = @[dir_cd]" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                     ) CHKQTR_VVD," ).append("\n"); 
		query.append("                     (                    -- 이전 분기 VVD" ).append("\n"); 
		query.append("                       SELECT TRD_CD, DIR_CD, VSL_CD, SKD_VOY_NO, SKD_DIR_CD" ).append("\n"); 
		query.append("                         FROM SAQ_MON_CFM_TGT_VVD" ).append("\n"); 
		query.append("                        WHERE 1=1" ).append("\n"); 
		query.append("                          AND MQTA_RLSE_VER_NO = ( SELECT MQTA_RLSE_VER_NO" ).append("\n"); 
		query.append("                                                     FROM SAQ_MON_QTA_RLSE" ).append("\n"); 
		query.append("                                                    WHERE 1=1" ).append("\n"); 
		query.append("                                                      AND BSE_YR     = DECODE(@[bse_qtr_cd], '1Q', @[bse_yr] -1, @[bse_yr])" ).append("\n"); 
		query.append("                                                      AND BSE_QTR_CD = DECODE(@[bse_qtr_cd], '1Q', '4Q'," ).append("\n"); 
		query.append("                                                                                 '2Q', '1Q'," ).append("\n"); 
		query.append("                                                                                 '3Q', '2Q'," ).append("\n"); 
		query.append("                                                                                 '4Q', '3Q' )" ).append("\n"); 
		query.append("                                                      AND QTA_RLSE_STS_CD    = 'R'                )" ).append("\n"); 
		query.append("                          AND TRD_CD           = @[trd_cd]" ).append("\n"); 
		query.append("                          AND DIR_CD           = @[dir_cd]" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                     ) PREQTR_VVD" ).append("\n"); 
		query.append("               WHERE 1=1" ).append("\n"); 
		query.append("               AND   CHKQTR_VVD.TRD_CD     = PREQTR_VVD.TRD_CD" ).append("\n"); 
		query.append("               AND   CHKQTR_VVD.DIR_CD     = PREQTR_VVD.DIR_CD" ).append("\n"); 
		query.append("               AND   CHKQTR_VVD.VSL_CD     = PREQTR_VVD.VSL_CD" ).append("\n"); 
		query.append("               AND   CHKQTR_VVD.SKD_VOY_NO = PREQTR_VVD.SKD_VOY_NO" ).append("\n"); 
		query.append("               AND   CHKQTR_VVD.SKD_DIR_CD = PREQTR_VVD.SKD_DIR_CD  )" ).append("\n"); 
		query.append("    SELECT  DISTINCT A.RLANE_CD AS TEXT" ).append("\n"); 
		query.append("           ,A.RLANE_CD AS CODE" ).append("\n"); 
		query.append("     FROM (" ).append("\n"); 
		query.append("             SELECT  DISTINCT" ).append("\n"); 
		query.append("                     SUB_TRD_CD" ).append("\n"); 
		query.append("                    ,RLANE_CD" ).append("\n"); 
		query.append("               FROM  SAQ_MON_CFM_TGT_VVD" ).append("\n"); 
		query.append("              WHERE  1 = 1" ).append("\n"); 
		query.append("                AND  MQTA_RLSE_VER_NO    = @[mqta_rlse_ver_no]" ).append("\n"); 
		query.append("                AND  TRD_CD              = @[trd_cd]" ).append("\n"); 
		query.append("                AND  DIR_CD              = @[dir_cd]" ).append("\n"); 
		query.append("                AND  RLANE_CD            <> 'RBCCO'" ).append("\n"); 
		query.append("             UNION ALL" ).append("\n"); 
		query.append("             SELECT DISTINCT" ).append("\n"); 
		query.append("                    V.SUB_TRD_CD," ).append("\n"); 
		query.append("                    V.RLANE_CD" ).append("\n"); 
		query.append("               FROM COA_MON_VVD_V   V ," ).append("\n"); 
		query.append("                    BSA_VVD_MST M" ).append("\n"); 
		query.append("              WHERE V.TRD_CD     = M.TRD_CD(+)" ).append("\n"); 
		query.append("                AND V.RLANE_CD   = M.RLANE_CD(+)" ).append("\n"); 
		query.append("                AND V.VSL_CD     = M.VSL_CD(+)" ).append("\n"); 
		query.append("                AND V.SKD_VOY_NO = M.SKD_VOY_NO(+)" ).append("\n"); 
		query.append("                AND V.DIR_CD     = M.SKD_DIR_CD(+)" ).append("\n"); 
		query.append("                AND NOT EXISTS ( SELECT VSL_CD, SKD_VOY_NO, DIR_CD" ).append("\n"); 
		query.append("                                   FROM EXCEPT_VVD" ).append("\n"); 
		query.append("                                  WHERE 1=1" ).append("\n"); 
		query.append("                                  AND   TRD_CD     = V.TRD_CD" ).append("\n"); 
		query.append("                                  AND   DIR_CD     = V.DIR_CD" ).append("\n"); 
		query.append("                                  AND   VSL_CD     = V.VSL_CD" ).append("\n"); 
		query.append("                                  AND   SKD_VOY_NO = V.SKD_VOY_NO" ).append("\n"); 
		query.append("                                  AND   SKD_DIR_CD = V.DIR_CD" ).append("\n"); 
		query.append("                                 UNION" ).append("\n"); 
		query.append("                                 SELECT VSL_CD, SKD_VOY_NO, DIR_CD" ).append("\n"); 
		query.append("                                   FROM SAQ_MON_TGT_VVD" ).append("\n"); 
		query.append("                                  WHERE 1=1" ).append("\n"); 
		query.append("                                  AND   BSE_YR     = @[bse_yr]" ).append("\n"); 
		query.append("                                  AND   BSE_QTR_CD = @[bse_qtr_cd]" ).append("\n"); 
		query.append("                                  AND   TRD_CD     = V.TRD_CD" ).append("\n"); 
		query.append("                                  AND   DIR_CD     = V.DIR_CD" ).append("\n"); 
		query.append("                                  AND   VSL_CD     = V.VSL_CD" ).append("\n"); 
		query.append("                                  AND   SKD_VOY_NO = V.SKD_VOY_NO" ).append("\n"); 
		query.append("                                  AND   SKD_DIR_CD = V.DIR_CD" ).append("\n"); 
		query.append("                                  AND   DELT_FLG   = 'Y'             )            ) a" ).append("\n"); 
		query.append(" ORDER BY A.RLANE_CD" ).append("\n"); 

	}
}