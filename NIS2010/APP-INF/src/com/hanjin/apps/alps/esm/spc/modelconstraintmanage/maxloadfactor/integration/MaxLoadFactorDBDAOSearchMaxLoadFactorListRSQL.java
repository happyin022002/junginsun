/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : MaxLoadFactorDBDAOSearchMaxLoadFactorListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.02.03
*@LastModifier : 최윤성
*@LastVersion : 1.0
* 2010.02.03 최윤성
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.spc.modelconstraintmanage.maxloadfactor.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author CHOI Yun Sung
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class MaxLoadFactorDBDAOSearchMaxLoadFactorListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * MAX L/F 데이터 조회
	  * </pre>
	  */
	public MaxLoadFactorDBDAOSearchMaxLoadFactorListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rep_trade",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sub_trade",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("year",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bound",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("lane",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.spc.modelconstraintmanage.maxloadfactor.integration").append("\n"); 
		query.append("FileName : MaxLoadFactorDBDAOSearchMaxLoadFactorListRSQL").append("\n"); 
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
		query.append("  SELECT /*+ INDEX(B) */" ).append("\n"); 
		query.append("         A.TRD_CD          AS TRD_CD    ," ).append("\n"); 
		query.append("         A.SUB_TRD_CD      AS SUB_TRD_CD," ).append("\n"); 
		query.append("         A.RLANE_CD        AS RLANE_CD  ," ).append("\n"); 
		query.append("         A.VSL_SLAN_DIR_CD AS DIR_CD    ," ).append("\n"); 
		query.append("         DECODE(B.BSE_YR, NULL, 100, MAX(DECODE(B.VOY_DIFF_WK, '01', B.MAX_LDF_RTO))) AS LDF_01," ).append("\n"); 
		query.append("         DECODE(B.BSE_YR, NULL, 100, MAX(DECODE(B.VOY_DIFF_WK, '02', B.MAX_LDF_RTO))) AS LDF_02," ).append("\n"); 
		query.append("         DECODE(B.BSE_YR, NULL, 100, MAX(DECODE(B.VOY_DIFF_WK, '03', B.MAX_LDF_RTO))) AS LDF_03," ).append("\n"); 
		query.append("         DECODE(B.BSE_YR, NULL, 100, MAX(DECODE(B.VOY_DIFF_WK, '04', B.MAX_LDF_RTO))) AS LDF_04," ).append("\n"); 
		query.append("         DECODE(B.BSE_YR, NULL, 100, MAX(DECODE(B.VOY_DIFF_WK, '05', B.MAX_LDF_RTO))) AS LDF_05," ).append("\n"); 
		query.append("         DECODE(B.BSE_YR, NULL, 'I', 'R') AS STAT_CD," ).append("\n"); 
		query.append("         'Y'      AS PROTECT_FLG," ).append("\n"); 
		query.append("          @[year] AS BSE_YR" ).append("\n"); 
		query.append("    FROM (" ).append("\n"); 
		query.append("            SELECT /*+ INDEX(BB) INDEX(CC) */" ).append("\n"); 
		query.append("                   DISTINCT" ).append("\n"); 
		query.append("                   BB.TRD_CD         ," ).append("\n"); 
		query.append("                   BB.SUB_TRD_CD     ," ).append("\n"); 
		query.append("                   AA.RLANE_CD       ," ).append("\n"); 
		query.append("                   BB.VSL_SLAN_DIR_CD," ).append("\n"); 
		query.append("                   AA.DELT_FLG" ).append("\n"); 
		query.append("              FROM MDM_REV_LANE     AA," ).append("\n"); 
		query.append("                   MDM_DTL_REV_LANE BB," ).append("\n"); 
		query.append("                   MDM_VSL_SVC_LANE CC" ).append("\n"); 
		query.append("             WHERE AA.RLANE_CD        = BB.RLANE_CD" ).append("\n"); 
		query.append("               AND AA.VSL_TP_CD       = 'C'" ).append("\n"); 
		query.append("               AND BB.VSL_SLAN_DIR_CD > '!'" ).append("\n"); 
		query.append("               AND AA.REP_TRD_CD      = BB.TRD_CD" ).append("\n"); 
		query.append("               AND BB.TRD_CD         <> 'COM'" ).append("\n"); 
		query.append("               AND AA.VSL_SLAN_CD     = CC.VSL_SLAN_CD" ).append("\n"); 
		query.append("               AND CC.VSL_SVC_TP_CD  <> 'O'" ).append("\n"); 
		query.append("               AND DECODE(CC.VSL_SVC_TP_CD, 'I', CC.CO_CD, '1') = DECODE(CC.VSL_SVC_TP_CD, 'I', 'H', '1')" ).append("\n"); 
		query.append("         ) A," ).append("\n"); 
		query.append("         SPC_MAX_LOD_FCTR B" ).append("\n"); 
		query.append("   WHERE B.BSE_YR      (+) = @[year]" ).append("\n"); 
		query.append("     AND B.VOY_DIFF_WK (+) > '0'" ).append("\n"); 
		query.append("     AND B.RLANE_CD    (+) = A.RLANE_CD" ).append("\n"); 
		query.append("     AND B.DIR_CD      (+) = A.VSL_SLAN_DIR_CD" ).append("\n"); 
		query.append("     AND DECODE(B.BSE_YR, NULL, A.DELT_FLG, '1') = DECODE(B.BSE_YR, NULL, 'N', '1')" ).append("\n"); 
		query.append("#if (${rep_trade} != '')" ).append("\n"); 
		query.append("     AND A.TRD_CD = @[rep_trade]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${sub_trade} != '')" ).append("\n"); 
		query.append("     AND A.SUB_TRD_CD = @[sub_trade]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${lane} != '')" ).append("\n"); 
		query.append("     AND A.RLANE_CD = @[lane]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${bound} != '')" ).append("\n"); 
		query.append("     AND A.VSL_SLAN_DIR_CD = @[bound]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("GROUP BY A.TRD_CD         ," ).append("\n"); 
		query.append("         A.SUB_TRD_CD     ," ).append("\n"); 
		query.append("         A.RLANE_CD       ," ).append("\n"); 
		query.append("         A.VSL_SLAN_DIR_CD," ).append("\n"); 
		query.append("         B.BSE_YR" ).append("\n"); 
		query.append("ORDER BY A.TRD_CD    ," ).append("\n"); 
		query.append("         A.SUB_TRD_CD," ).append("\n"); 
		query.append("         A.RLANE_CD  ," ).append("\n"); 
		query.append("         A.VSL_SLAN_DIR_CD" ).append("\n"); 

	}
}