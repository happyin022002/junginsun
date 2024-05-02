/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : BasicDataDBDAOSearchAddPolPodPairForSectorRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.06.15
*@LastModifier : 
*@LastVersion : 1.0
* 2015.06.15 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.sqm.datamanage.basicdata.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BasicDataDBDAOSearchAddPolPodPairForSectorRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Pol Pod Pair를 추가로 생성해야 할 List를 조회합니다.
	  * 
	  * History
	  * 2014.06.30 PEJ [CHM-201430925] Lane Master에서 한 bound만 설정하여 판매목표 수립 후, 나머지 bound를 분기 중 추가
	  *                                                 Add Creation 대상 조회시 Bound 만 추가된 경우도 인지하도록 로직변경(화면에 Bound 컬럼 추가)
	  * 2015.06.15 김용습 [CHM-201536164] 주간 MAS Open에 따른 타모듈 프로그램 적용 요청
	  * </pre>
	  */
	public BasicDataDBDAOSearchAddPolPodPairForSectorRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_ias_rgn_cd",new String[]{arrTmp[0],arrTmp[1]});

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

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_sub_trd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_rlane_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.sqm.datamanage.basicdata.integration").append("\n"); 
		query.append("FileName : BasicDataDBDAOSearchAddPolPodPairForSectorRSQL").append("\n"); 
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
		query.append("SELECT DISTINCT" ).append("\n"); 
		query.append("       A1.BSE_TP_CD" ).append("\n"); 
		query.append("      ,A1.BSE_YR" ).append("\n"); 
		query.append("      ,A1.BSE_QTR_CD" ).append("\n"); 
		query.append("      ,A1.TRD_CD" ).append("\n"); 
		query.append("      ,A1.SUB_TRD_CD" ).append("\n"); 
		query.append("      ,(SELECT INTG_CD_VAL_DP_DESC" ).append("\n"); 
		query.append("          FROM COM_INTG_CD_DTL" ).append("\n"); 
		query.append("         WHERE INTG_CD_ID       = 'CD03218'" ).append("\n"); 
		query.append("           AND INTG_CD_VAL_CTNT = A3.IAS_RGN_CD" ).append("\n"); 
		query.append("       ) AS IAS_RGN_CD" ).append("\n"); 
		query.append("      ,A1.RLANE_CD" ).append("\n"); 
		query.append("      ,A1.PF_GRP_CD" ).append("\n"); 
		query.append("      ,A1.PF_SVC_TP_CD" ).append("\n"); 
		query.append("      ,A1.PF_ROUT_DESC" ).append("\n"); 
		query.append("      ,NVL((" ).append("\n"); 
		query.append("            SELECT DECODE(COUNT(*),0, 'Y', 'N')" ).append("\n"); 
		query.append("              FROM SQM_SCTR_PAIR_MGMT S1" ).append("\n"); 
		query.append("             WHERE S1.BSE_TP_CD  = A1.BSE_TP_CD" ).append("\n"); 
		query.append("               AND S1.BSE_YR     = A1.BSE_YR" ).append("\n"); 
		query.append("               AND S1.BSE_QTR_CD = A1.BSE_QTR_CD" ).append("\n"); 
		query.append("               AND S1.RLANE_CD   = A1.RLANE_CD" ).append("\n"); 
		query.append("           )" ).append("\n"); 
		query.append("          , 'Y') AS NEW_RLANE_FLG" ).append("\n"); 
		query.append("      ,DECODE(COUNT(*) OVER(PARTITION BY A3.TRD_CD, A3.RLANE_CD, A1.PF_GRP_CD, A1.PF_SVC_TP_CD), 2, A2.LANE_DIR_CD, A3.DIR_CD) AS DIR_CD" ).append("\n"); 
		query.append("  FROM SQM_SCTR_PF_GRP A1" ).append("\n"); 
		query.append("      ,SQM_QTA_LANE_MGMT A2" ).append("\n"); 
		query.append("      ,MAS_LANE_RGST A3" ).append("\n"); 
		query.append(" WHERE 1=1" ).append("\n"); 
		query.append("   AND A1.TRD_CD       = A3.TRD_CD" ).append("\n"); 
		query.append("   AND A1.SUB_TRD_CD   = A3.SUB_TRD_CD" ).append("\n"); 
		query.append("   AND A1.RLANE_CD     = A3.RLANE_CD" ).append("\n"); 
		query.append("   AND A3.TRD_CD       = A2.TRD_CD" ).append("\n"); 
		query.append("   AND A3.RLANE_CD     = A2.RLANE_CD" ).append("\n"); 
		query.append("   AND A3.SUB_TRD_CD   = A2.SUB_TRD_CD" ).append("\n"); 
		query.append("   AND A3.DIR_CD       = NVL(A2.LANE_DIR_CD, A3.DIR_CD)" ).append("\n"); 
		query.append("   AND A2.SQM_ACT_FLG  = 'Y'" ).append("\n"); 
		query.append("   AND A2.IAS_SCTR_FLG IS NOT NULL" ).append("\n"); 
		query.append("   AND A1.BSE_TP_CD    = @[f_bse_tp_cd]" ).append("\n"); 
		query.append("   AND A1.BSE_YR       = @[f_bse_yr]" ).append("\n"); 
		query.append("   AND A1.BSE_QTR_CD   = DECODE(@[f_bse_tp_cd],'Y','00',@[f_bse_qtr_cd])" ).append("\n"); 
		query.append("   AND A1.SUB_TRD_CD   = @[f_sub_trd_cd]" ).append("\n"); 
		query.append("   AND A1.RLANE_CD     = @[f_rlane_cd]" ).append("\n"); 
		query.append("#if (${f_ias_rgn_cd} != '' && ${f_ias_rgn_cd} != 'All')" ).append("\n"); 
		query.append("   AND A3.IAS_RGN_CD   = @[f_ias_rgn_cd]" ).append("\n"); 
		query.append("#end   " ).append("\n"); 
		query.append("   AND NOT EXISTS (" ).append("\n"); 
		query.append("               SELECT *" ).append("\n"); 
		query.append("                 FROM SQM_SCTR_PAIR_MGMT S1" ).append("\n"); 
		query.append("                WHERE S1.BSE_TP_CD  = A1.BSE_TP_CD" ).append("\n"); 
		query.append("                  AND S1.BSE_YR     = A1.BSE_YR" ).append("\n"); 
		query.append("                  AND S1.BSE_QTR_CD = A1.BSE_QTR_CD" ).append("\n"); 
		query.append("                  AND S1.RLANE_CD   = A1.RLANE_CD" ).append("\n"); 
		query.append("                  AND S1.PF_GRP_CD  = A1.PF_GRP_CD" ).append("\n"); 
		query.append("                  AND S1.DIR_CD     = A3.DIR_CD" ).append("\n"); 
		query.append("              )" ).append("\n"); 
		query.append(" ORDER BY  A1.SUB_TRD_CD, IAS_RGN_CD, A1.RLANE_CD, A1.PF_GRP_CD, A1.PF_SVC_TP_CD" ).append("\n"); 

	}
}