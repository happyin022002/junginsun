/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : QtaAdjustmentDBDAOSearchApplyWeekRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.12.24
*@LastModifier : 
*@LastVersion : 1.0
* 2015.12.24 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.sqm.adjustment.qtaadjustment.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class QtaAdjustmentDBDAOSearchApplyWeekRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * [Portion Adjustment by Head Office, RHQ]에서 vvd의 주차를 [조회] 합니다.
	  * 
	  * * 2015.02.11 이혜민 VVD Adjustment 시 Week 기준으로 조회하던 것을 Revenue month기준으로 변경
	  * * 2015.06.15 김용습 [CHM-201536164] 주간 MAS Open에 따른 타모듈 프로그램 적용 요청
	  * * 2015.08.18 김용습 [CHM-201537647] SLS_YRMON이 아니라 COST_YRMON을 가져오도록 변경, 1Q시 50~53주차의 경우 YEAR를 1년 차감해서 값을 가져오도록 함
	  * * 2015.10.06 김용습 [CHM-201538196] Portion Adjustment by RHQ, Head Office 화면 내 해당 분기 값만 입력 가능토록 Validation 설정
	  * 2015.12.24 [CHM-201539388] From/To VVD가 바라보는 Source 변경 로직 변경 - MAS_MON_VVD가 아닌 SQM_CFM_TGT_VVD를 바라보게 변경
	  * </pre>
	  */
	public QtaAdjustmentDBDAOSearchApplyWeekRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vvd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_bse_yr",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_trd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_rlane_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.sqm.adjustment.qtaadjustment.integration").append("\n"); 
		query.append("FileName : QtaAdjustmentDBDAOSearchApplyWeekRSQL").append("\n"); 
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
		query.append("SELECT  " ).append("\n"); 
		query.append("#if (${f_bse_qtr_cd} == '1Q')" ).append("\n"); 
		query.append("    CASE WHEN SLS_YRMON LIKE '%01' AND BSE_WK IN(50, 51, 52, 53) THEN SUBSTR(SLS_YRMON,0,4)-1||BSE_WK" ).append("\n"); 
		query.append("        ELSE SUBSTR(SLS_YRMON,0,4)||BSE_WK " ).append("\n"); 
		query.append("        END AS BSE_WK " ).append("\n"); 
		query.append("    , SLS_YRMON" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("    SUBSTR(SLS_YRMON,0,4)||BSE_WK AS BSE_WK" ).append("\n"); 
		query.append("    , SLS_YRMON" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("  FROM SQM_CFM_TGT_VVD " ).append("\n"); 
		query.append("WHERE SLS_YRMON   LIKE @[f_bse_yr]||'%'" ).append("\n"); 
		query.append("  AND TRD_CD      = @[f_trd_cd]" ).append("\n"); 
		query.append("  AND RLANE_CD    = @[f_rlane_cd]" ).append("\n"); 
		query.append("  AND DIR_CD      = @[f_dir_cd]" ).append("\n"); 
		query.append("  AND VSL_CD      = SUBSTR(@[vvd],0,4)" ).append("\n"); 
		query.append("  AND SKD_VOY_NO  = SUBSTR(@[vvd],5,4)" ).append("\n"); 
		query.append("  AND DIR_CD  = SUBSTR(@[vvd],9,1)" ).append("\n"); 
		query.append("  AND ROWNUM = 1" ).append("\n"); 
		query.append("  ORDER BY QTA_RLSE_VER_NO DESC" ).append("\n"); 

	}
}