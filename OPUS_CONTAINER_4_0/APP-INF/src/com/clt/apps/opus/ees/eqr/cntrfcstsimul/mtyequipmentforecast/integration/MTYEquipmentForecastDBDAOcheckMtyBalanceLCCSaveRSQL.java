/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : MTYEquipmentForecastDBDAOcheckMtyBalanceLCCSaveRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.02.20
*@LastModifier : 
*@LastVersion : 1.0
* 2013.02.20 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.eqr.cntrfcstsimul.mtyequipmentforecast.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class MTYEquipmentForecastDBDAOcheckMtyBalanceLCCSaveRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ECC 조회 시점, 해당 REPO ID 포함 4주치에 대한 O/B FCST D.TTL(Dry TTL)이 0 이상인지 조회
	  * </pre>
	  */
	public MTYEquipmentForecastDBDAOcheckMtyBalanceLCCSaveRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("loc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fcast_yrwk",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.eqr.mtyequipmentforecast.mtyequipmentforecast.integration").append("\n"); 
		query.append("FileName : MTYEquipmentForecastDBDAOcheckMtyBalanceLCCSaveRSQL").append("\n"); 
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
		query.append("/*" ).append("\n"); 
		query.append("Balance Report 메인쿼리 조회후에 조회합니다." ).append("\n"); 
		query.append("ECC/SCC 일때만 호출합니다. (LCC 는 호출 안함)" ).append("\n"); 
		query.append("checkMtyBalanceLCCSave 에서 호출하는 쿼리" ).append("\n"); 
		query.append("1. 2013-02-20   으로 항상 수정가능하도록 T로 변경함." ).append("\n"); 
		query.append("*/" ).append("\n"); 
		query.append("-- 2013-02-20 원본" ).append("\n"); 
		query.append("--SELECT CASE WHEN SUM(SUM_COUNT) = 4 THEN 'T' " ).append("\n"); 
		query.append("--                                    ELSE 'F' " ).append("\n"); 
		query.append("--            END SAVE_FLAG" ).append("\n"); 
		query.append("SELECT 'T' SAVE_FLAG" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("    SELECT " ).append("\n"); 
		query.append("           B.WK_SEQ" ).append("\n"); 
		query.append("          ,B.FCAST_YRWK" ).append("\n"); 
		query.append("          ,NVL(A.DRY_SUM,0) DRY_SUM" ).append("\n"); 
		query.append("          ,CASE WHEN NVL(A.DRY_SUM,0) > 0 THEN 1 " ).append("\n"); 
		query.append("                                          ELSE 0" ).append("\n"); 
		query.append("                END SUM_COUNT                                           " ).append("\n"); 
		query.append("    FROM      " ).append("\n"); 
		query.append("    (" ).append("\n"); 
		query.append("        SELECT FCAST_YRWK" ).append("\n"); 
		query.append("              ,(" ).append("\n"); 
		query.append("                NVL(D2_FCAST_QTY,0) + " ).append("\n"); 
		query.append("                NVL(D4_FCAST_QTY,0) + " ).append("\n"); 
		query.append("                NVL(D5_FCAST_QTY,0) + " ).append("\n"); 
		query.append("                NVL(D7_FCAST_QTY,0)" ).append("\n"); 
		query.append("               ) AS DRY_SUM" ).append("\n"); 
		query.append("              " ).append("\n"); 
		query.append("        FROM EQR_CTRL_MTY_BAL_RPT" ).append("\n"); 
		query.append("        WHERE INP_YRWK = (" ).append("\n"); 
		query.append("                             SELECT /*+ INDEX_DESC(A XPKEQR_WK_PRD) */ PLN_YR||PLN_WK" ).append("\n"); 
		query.append("                             FROM EQR_WK_PRD A" ).append("\n"); 
		query.append("                             WHERE PLN_YR||PLN_WK < @[fcast_yrwk]" ).append("\n"); 
		query.append("                             AND   ROWNUM = 1 -- 과거1주" ).append("\n"); 
		query.append("                         )" ).append("\n"); 
		query.append("        AND   LOC_GRP_CD    = 'L' -- hard coding" ).append("\n"); 
		query.append("        AND   MTY_BAL_TP_CD = '3' -- hard coding" ).append("\n"); 
		query.append("        AND   LOC_CD = (" ).append("\n"); 
		query.append("                           SELECT DISTINCT LCC_CD " ).append("\n"); 
		query.append("                           FROM MDM_EQ_ORZ_CHT" ).append("\n"); 
		query.append("        #if (${loc_grp_cd} == 'E')                    " ).append("\n"); 
		query.append("                           WHERE ECC_CD = @[loc_cd]" ).append("\n"); 
		query.append("        #else  -- SCC 일때 사용          " ).append("\n"); 
		query.append("                           WHERE SCC_CD = @[loc_cd]" ).append("\n"); 
		query.append("        #end                   " ).append("\n"); 
		query.append("                       )" ).append("\n"); 
		query.append("    ) A," ).append("\n"); 
		query.append("    (" ).append("\n"); 
		query.append("        SELECT /*+ INDEX(A XPKEQR_WK_PRD) */ ROWNUM WK_SEQ" ).append("\n"); 
		query.append("              ,PLN_YR||PLN_WK AS FCAST_YRWK" ).append("\n"); 
		query.append("        FROM EQR_WK_PRD A" ).append("\n"); 
		query.append("        WHERE PLN_YR||PLN_WK >= @[fcast_yrwk]" ).append("\n"); 
		query.append("        AND   ROWNUM <=4  -- hard coding   " ).append("\n"); 
		query.append("    ) B" ).append("\n"); 
		query.append("    WHERE A.FCAST_YRWK(+) = B.FCAST_YRWK" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}