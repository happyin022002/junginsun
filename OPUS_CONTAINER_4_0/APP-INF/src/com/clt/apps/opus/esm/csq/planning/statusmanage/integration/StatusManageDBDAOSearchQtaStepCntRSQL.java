/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : StatusManageDBDAOSearchQtaStepCntRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.08.28
*@LastModifier : 최윤성
*@LastVersion : 1.0
* 2013.08.28 최윤성
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.csq.planning.statusmanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author CHOI Yun Sung
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class StatusManageDBDAOSearchQtaStepCntRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Step 별 Count 를 확인한다.
	  * </pre>
	  */
	public StatusManageDBDAOSearchQtaStepCntRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_bse_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_bse_qtr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_bse_yr",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.csq.planning.statusmanage.integration").append("\n"); 
		query.append("FileName : StatusManageDBDAOSearchQtaStepCntRSQL").append("\n"); 
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
		query.append("SELECT V.BSE_TP_CD" ).append("\n"); 
		query.append("        ,V.BSE_YR" ).append("\n"); 
		query.append("        ,V.BSE_QTR_CD" ).append("\n"); 
		query.append("        ,SUM(DECODE(QTA_STEP_CD, '01', 1, 0)) AS STEP_01_CNT                    -- STEP 01 의 개수" ).append("\n"); 
		query.append("        ,SUM(DECODE(QTA_STEP_CD, '02', 1, 0)) AS STEP_02_CNT                    -- STEP 02 의 개수" ).append("\n"); 
		query.append("        ,SUM(DECODE(QTA_STEP_CD, '03', 1, '04', 1, '05', 1, 0)) AS STEP_03_CNT  -- SETP 03, 04, 05 의 개수" ).append("\n"); 
		query.append("        ,DECODE(COUNT(1), 0, 'N'                                                -- 전체 STEP 의 개수가 0 일 경우" ).append("\n"); 
		query.append("                        , SUM(DECODE(V.CSQ_VER_STS_CD, 'C', 1, 0)), 'Y'         -- 전체 STEP 의 개수와 Confirm 의 개수가 같을 경우 " ).append("\n"); 
		query.append("                        , 'N' ) AS CONFIRM_FLG" ).append("\n"); 
		query.append("        ,DECODE(MAX(R_CNT), 0, 'N', 'Y') AS RLSE_FLG                            -- RLSE 된 Data 존재 여부" ).append("\n"); 
		query.append("        ,DECODE((SELECT COUNT(1) AS CNT" ).append("\n"); 
		query.append("                   FROM CSQ_QTA_STEP_VER" ).append("\n"); 
		query.append("                  WHERE BSE_TP_CD  = 'Q'" ).append("\n"); 
		query.append("                    AND BSE_YR     = @[f_bse_yr]" ).append("\n"); 
		query.append("                    AND BSE_QTR_CD = '1Q'), 0, 'N', 'Y') AS TRANSFER            -- 1Q Transfer 존재 여부" ).append("\n"); 
		query.append("    FROM CSQ_QTA_STEP_VER V" ).append("\n"); 
		query.append("        ,( SELECT COUNT(1) R_CNT" ).append("\n"); 
		query.append("             FROM CSQ_QTA_RLSE_VER" ).append("\n"); 
		query.append("            WHERE BSE_TP_CD      = @[f_bse_tp_cd]" ).append("\n"); 
		query.append("              AND BSE_YR         = @[f_bse_yr]" ).append("\n"); 
		query.append("              AND BSE_QTR_CD     = DECODE(@[f_bse_tp_cd], 'Y', '00', @[f_bse_qtr_cd])" ).append("\n"); 
		query.append("              AND CSQ_VER_STS_CD = 'R'" ).append("\n"); 
		query.append("         ) R" ).append("\n"); 
		query.append("   WHERE V.BSE_TP_CD  = @[f_bse_tp_cd]" ).append("\n"); 
		query.append("     AND V.BSE_YR     = @[f_bse_yr]" ).append("\n"); 
		query.append("     AND V.BSE_QTR_CD = DECODE(@[f_bse_tp_cd], 'Y', '00', @[f_bse_qtr_cd])" ).append("\n"); 
		query.append("GROUP BY V.BSE_TP_CD" ).append("\n"); 
		query.append("        ,V.BSE_YR" ).append("\n"); 
		query.append("        ,V.BSE_QTR_CD" ).append("\n"); 

	}
}