/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : SpaceAllocationManageDBDAOSearchSpaceAllocation0033BSACapaByPortRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.01.23
*@LastModifier : Arie
*@LastVersion : 1.0
* 2017.01.23 Arie
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.spc.spaceallocationmanage.spaceallocationmanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Arie
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SpaceAllocationManageDBDAOSearchSpaceAllocation0033BSACapaByPortRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchSpaceAllocation0033BSACapaByPort
	  * 
	  * 2013.11.26 진마리아 [CHM-201326854] SAQ project로 인한 SPC 변경건_FNC 우선제거
	  * 2017.1.23 SM상선 전환에 따른 소스변경
	  * </pre>
	  */
	public SpaceAllocationManageDBDAOSearchSpaceAllocation0033BSACapaByPortRSQL(){
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
		params.put("rep_trd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sub_trd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rlane_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eff_to_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eff_fm_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pol_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.spc.spaceallocationmanage.spaceallocationmanage.integration").append("\n"); 
		query.append("FileName : SpaceAllocationManageDBDAOSearchSpaceAllocation0033BSACapaByPortRSQL").append("\n"); 
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
		query.append("         A.PORT_BSA_CAPA AS CODE," ).append("\n"); 
		query.append("		 A.PORT_BSA_CAPA AS NAME" ).append("\n"); 
		query.append("    FROM BSA_VVD_PORT_DWN A," ).append("\n"); 
		query.append("         MAS_LANE_RGST    B," ).append("\n"); 
		query.append("         (" ).append("\n"); 
		query.append("            SELECT /*+ INDEX (P, XPKMAS_WK_PRD) */" ).append("\n"); 
		query.append("                   P.COST_YR||P.COST_WK AS COST_YRWK" ).append("\n"); 
		query.append("              FROM MAS_WK_PRD P" ).append("\n"); 
		query.append("             WHERE P.SLS_FM_DT >= REPLACE(@[eff_fm_dt],'-','')" ).append("\n"); 
		query.append("               AND P.SLS_TO_DT <= REPLACE(@[eff_to_dt],'-','')" ).append("\n"); 
		query.append("         ) P," ).append("\n"); 
		query.append("         MAS_MON_VVD     M" ).append("\n"); 
		query.append("   WHERE SUBSTR(M.SLS_YRMON, 1, 4)||M.COST_WK = P.COST_YRWK" ).append("\n"); 
		query.append("     AND (M.DELT_FLG IS NULL OR M.DELT_FLG = 'N')" ).append("\n"); 
		query.append("     AND SPC_GET_REP_TRD_FNC(M.RLANE_CD)   = @[rep_trd_cd]" ).append("\n"); 
		query.append("     AND M.SUB_TRD_CD   = @[sub_trd_cd]" ).append("\n"); 
		query.append("     AND M.RLANE_CD     = @[rlane_cd]" ).append("\n"); 
		query.append("     --AND M.RLANE_CD    IN ('IMUAE','IMUTA','PSGIA','PSGTP')" ).append("\n"); 
		query.append("     AND A.PORT_CD      = @[pol_cd]" ).append("\n"); 
		query.append("     AND B.TRD_CD       = A.TRD_CD" ).append("\n"); 
		query.append("     AND B.RLANE_CD     = A.RLANE_CD" ).append("\n"); 
		query.append("     AND B.DIR_CD       = A.SKD_DIR_CD" ).append("\n"); 
		query.append("     AND M.TRD_CD       = A.TRD_CD    " ).append("\n"); 
		query.append("     AND M.RLANE_CD     = A.RLANE_CD  " ).append("\n"); 
		query.append("     AND M.VSL_CD       = A.VSL_CD    " ).append("\n"); 
		query.append("     AND M.SKD_VOY_NO   = A.SKD_VOY_NO" ).append("\n"); 
		query.append("     AND M.DIR_CD       = A.SKD_DIR_CD" ).append("\n"); 
		query.append("     AND A.BSA_OP_JB_CD = '007' " ).append("\n"); 
		query.append("     AND B.STUP_FLG     = 'Y'" ).append("\n"); 
		query.append("     AND A.CRR_CD       = 'SML'" ).append("\n"); 
		query.append("     AND A.PORT_CD     != 'XXXXX'" ).append("\n"); 
		query.append("#if (${vvd} != '')                 " ).append("\n"); 
		query.append("     AND M.VSL_CD       = NVL( SUBSTR(@[vvd],1,4) ,M.VSL_CD)      -- 변수처리" ).append("\n"); 
		query.append("     AND M.SKD_VOY_NO   = NVL( SUBSTR(@[vvd],5,4) ,M.SKD_VOY_NO)  -- 변수처리" ).append("\n"); 
		query.append("     AND M.DIR_CD       = NVL( SUBSTR(@[vvd],9,1),M.DIR_CD)         -- 변수처리" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("     AND NOT (A.PORT_BSA_CAPA IS NULL OR A.PORT_BSA_CAPA = 0)" ).append("\n"); 
		query.append("ORDER BY CODE" ).append("\n"); 

	}
}