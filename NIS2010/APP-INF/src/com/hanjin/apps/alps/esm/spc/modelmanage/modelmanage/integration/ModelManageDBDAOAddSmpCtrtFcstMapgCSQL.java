/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : ModelManageDBDAOAddSmpCtrtFcstMapgCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.05.23
*@LastModifier : 
*@LastVersion : 1.0
* 2014.05.23 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.spc.modelmanage.modelmanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ModelManageDBDAOAddSmpCtrtFcstMapgCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SMP Confirm시 해당 season/version의 화주를 SPC_CTRT_FCAST_OFC_MAPG에 저장합니다.
	  * [CHM-201322502-01] SPC 프로젝트 - 성수기 선복운영 개선을 위한 T/F추진
	  * 2014.02.04 [CHM-201428383-01] RFA 로직 추가
	  * 2014.05.16 [CHM-201430353] SMP / AES 보완요청 - SC 입력 기능 추가
	  * </pre>
	  */
	public ModelManageDBDAOAddSmpCtrtFcstMapgCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ver_seq",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cost_yrwk",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.spc.modelmanage.modelmanage.integration").append("\n"); 
		query.append("FileName : ModelManageDBDAOAddSmpCtrtFcstMapgCSQL").append("\n"); 
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
		query.append("INSERT INTO SPC_CTRT_FCAST_OFC_MAPG (" ).append("\n"); 
		query.append("    TRD_CD        ," ).append("\n"); 
		query.append("    SUB_TRD_CD    ," ).append("\n"); 
		query.append("    RLANE_CD      ," ).append("\n"); 
		query.append("    DIR_CD        ," ).append("\n"); 
		query.append("    IOC_TS_CD     ," ).append("\n"); 
		query.append("    CTRT_OFC_CD   ," ).append("\n"); 
		query.append("    CUST_CNT_CD   ," ).append("\n"); 
		query.append("    CUST_SEQ      ," ).append("\n"); 
		query.append("    FCAST_SEQ     ," ).append("\n"); 
		query.append("    SLS_RGN_OFC_CD," ).append("\n"); 
		query.append("    SC_NO         ," ).append("\n"); 
		query.append("    RFA_NO        ," ).append("\n"); 
		query.append("    CRE_USR_ID    ," ).append("\n"); 
		query.append("    CRE_DT        ," ).append("\n"); 
		query.append("    UPD_USR_ID    ," ).append("\n"); 
		query.append("    UPD_DT" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("SELECT DISTINCT" ).append("\n"); 
		query.append("       A.TRD_CD," ).append("\n"); 
		query.append("       A.SUB_TRD_CD," ).append("\n"); 
		query.append("       A.RLANE_CD," ).append("\n"); 
		query.append("       B.DIR_CD," ).append("\n"); 
		query.append("       DECODE(SUBSTR(A.TRD_CD,1,1), 'I', 'I', 'O') AS IOC_TS_CD," ).append("\n"); 
		query.append("       CTRT_OFC_CD," ).append("\n"); 
		query.append("       CUST_CNT_CD," ).append("\n"); 
		query.append("       CUST_SEQ," ).append("\n"); 
		query.append("       NVL((SELECT MAX(FCAST_SEQ)" ).append("\n"); 
		query.append("              FROM SPC_CTRT_FCAST_OFC_MAPG C" ).append("\n"); 
		query.append("             WHERE C.TRD_CD      = A.TRD_CD" ).append("\n"); 
		query.append("               AND C.SUB_TRD_CD  = A.SUB_TRD_CD" ).append("\n"); 
		query.append("               AND C.RLANE_CD    = A.RLANE_CD" ).append("\n"); 
		query.append("               AND C.DIR_CD      = B.DIR_CD" ).append("\n"); 
		query.append("               AND C.IOC_TS_CD   = DECODE(SUBSTR(A.TRD_CD,1,1), 'I', 'I', 'O')" ).append("\n"); 
		query.append("               AND C.CTRT_OFC_CD = A.CTRT_OFC_CD" ).append("\n"); 
		query.append("               AND C.CUST_CNT_CD = A.CUST_CNT_CD" ).append("\n"); 
		query.append("               AND C.CUST_SEQ    = A.CUST_SEQ" ).append("\n"); 
		query.append("               AND C.SLS_RGN_OFC_CD = A.SLS_RGN_OFC_CD" ).append("\n"); 
		query.append("            ), 0) + ROW_NUMBER() OVER (PARTITION BY A.TRD_CD, A.SUB_TRD_CD, A.RLANE_CD, B.DIR_CD, DECODE(SUBSTR(A.TRD_CD,1,1), 'I', 'I', 'O'), CTRT_OFC_CD, CUST_CNT_CD, CUST_SEQ, SLS_RGN_OFC_CD ORDER BY A.TRD_CD) AS FCAST_SEQ," ).append("\n"); 
		query.append("       SLS_RGN_OFC_CD," ).append("\n"); 
		query.append("       SC_NO," ).append("\n"); 
		query.append("       RFA_NO," ).append("\n"); 
		query.append("       'SPC_USER' AS CRE_USR_ID," ).append("\n"); 
		query.append("       SYSDATE    AS CRE_DT    ," ).append("\n"); 
		query.append("       'SPC_USER' AS UPD_USR_ID," ).append("\n"); 
		query.append("       SYSDATE    AS UPD_DT" ).append("\n"); 
		query.append("  FROM SPC_MDL_CUST_REV_LANE A," ).append("\n"); 
		query.append("       SPC_HD_HUL_MST        B" ).append("\n"); 
		query.append(" WHERE A.TRD_CD        = @[trd_cd]" ).append("\n"); 
		query.append("   AND A.COST_YRWK     = @[cost_yrwk]" ).append("\n"); 
		query.append("   AND A.VER_SEQ       = @[ver_seq]" ).append("\n"); 
		query.append("   AND A.TRD_CD        = B.TRD_CD" ).append("\n"); 
		query.append("   AND A.RLANE_CD      = B.RLANE_CD" ).append("\n"); 
		query.append("   AND A.SUB_TRD_CD    = B.SUB_TRD_CD" ).append("\n"); 
		query.append("--   AND A.RLANE_ADJ_QTY > 0" ).append("\n"); 
		query.append("   AND A.DELT_FLG      = 'N'" ).append("\n"); 
		query.append("   AND NOT EXISTS (SELECT 'X'" ).append("\n"); 
		query.append("                     FROM SPC_CTRT_FCAST_OFC_MAPG T" ).append("\n"); 
		query.append("                    WHERE TRD_CD             = A.TRD_CD" ).append("\n"); 
		query.append("                      AND SUB_TRD_CD         = A.SUB_TRD_CD" ).append("\n"); 
		query.append("                      AND RLANE_CD           = A.RLANE_CD" ).append("\n"); 
		query.append("                      AND DIR_CD             = B.DIR_CD" ).append("\n"); 
		query.append("                      AND IOC_TS_CD          = DECODE(SUBSTR(A.TRD_CD,1,1), 'I', 'I', 'O')" ).append("\n"); 
		query.append("                      AND CTRT_OFC_CD        = A.CTRT_OFC_CD" ).append("\n"); 
		query.append("                      AND CUST_CNT_CD        = A.CUST_CNT_CD" ).append("\n"); 
		query.append("                      AND CUST_SEQ           = A.CUST_SEQ" ).append("\n"); 
		query.append("                      AND NVL(T.SC_NO , 'X') = NVL(A.SC_NO , NVL(T.SC_NO, 'X'))" ).append("\n"); 
		query.append("                      AND NVL(T.RFA_NO, 'X') = NVL(A.RFA_NO, 'X')" ).append("\n"); 
		query.append("--                      AND FCAST_SEQ          = A.DTL_SEQ" ).append("\n"); 
		query.append("                      AND SLS_RGN_OFC_CD     = A.SLS_RGN_OFC_CD)" ).append("\n"); 

	}
}