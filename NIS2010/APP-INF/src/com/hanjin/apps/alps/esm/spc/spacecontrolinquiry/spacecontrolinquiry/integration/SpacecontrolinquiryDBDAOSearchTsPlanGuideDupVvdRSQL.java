/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : SpacecontrolinquiryDBDAOSearchTsPlanGuideDupVvdRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.04.25
*@LastModifier : 
*@LastVersion : 1.0
* 2016.04.25 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.spc.spacecontrolinquiry.spacecontrolinquiry.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SpacecontrolinquiryDBDAOSearchTsPlanGuideDupVvdRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * [T/S Plan & guide Main]을 [Insert] 전에 VSK 와 겹치는 목록이 있는지 확인한다.
	  * </pre>
	  */
	public SpacecontrolinquiryDBDAOSearchTsPlanGuideDupVvdRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("irr_yd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vvd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("irr_port_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("crr_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.spc.spacecontrolinquiry.spacecontrolinquiry.integration ").append("\n"); 
		query.append("FileName : SpacecontrolinquiryDBDAOSearchTsPlanGuideDupVvdRSQL").append("\n"); 
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
		query.append("SELECT DISTINCT " ).append("\n"); 
		query.append("       A2.VSL_CD||A2.SKD_VOY_NO||A2.SKD_DIR_CD AS VVD_CD                                                                           " ).append("\n"); 
		query.append("     , A2.IRR_PORT_CD" ).append("\n"); 
		query.append("     , A2.IRR_YD_CD" ).append("\n"); 
		query.append("     , A2.CRR_CD                                      " ).append("\n"); 
		query.append("FROM MAS_MON_VVD A1, " ).append("\n"); 
		query.append("     (" ).append("\n"); 
		query.append("     SELECT  DISTINCT V2.SLAN_CD" ).append("\n"); 
		query.append("                        , V2.VSL_CD" ).append("\n"); 
		query.append("                        , V2.SKD_VOY_NO" ).append("\n"); 
		query.append("                        , V2.SKD_DIR_CD" ).append("\n"); 
		query.append("                        , V2.VPS_PORT_CD AS IRR_PORT_CD" ).append("\n"); 
		query.append("                        , SUBSTR(V2.YD_CD, -2) AS IRR_YD_CD" ).append("\n"); 
		query.append("                        , NVL(V1.ACT_CRR_CD, M.CRR_CD) AS CRR_CD " ).append("\n"); 
		query.append("                FROM      VSK_VSL_SKD V1" ).append("\n"); 
		query.append("                        , VSK_VSL_PORT_SKD V2" ).append("\n"); 
		query.append("                        , MDM_VSL_CNTR M" ).append("\n"); 
		query.append("                WHERE   1=1" ).append("\n"); 
		query.append("                AND     V1.VSL_SLAN_CD = V2.SLAN_CD" ).append("\n"); 
		query.append("                AND     V1.VSL_CD      = V2.VSL_CD" ).append("\n"); 
		query.append("                AND     V1.SKD_VOY_NO  = V2.SKD_VOY_NO" ).append("\n"); 
		query.append("                AND     V1.SKD_DIR_CD  = V2.SKD_DIR_CD" ).append("\n"); 
		query.append("                AND     V1.VSL_CD      = M.VSL_CD" ).append("\n"); 
		query.append("                AND     NVL(V2.SKD_CNG_STS_CD, '*') IN ('S', 'O')" ).append("\n"); 
		query.append("                AND     V2.TURN_PORT_IND_CD NOT IN ('D', 'V', 'F')" ).append("\n"); 
		query.append("                AND     V2.PORT_SKP_TP_CD <> ' '" ).append("\n"); 
		query.append("                ORDER BY SLAN_CD, VSL_CD, SKD_VOY_NO, SKD_DIR_CD, IRR_PORT_CD, IRR_YD_CD" ).append("\n"); 
		query.append("             ) A2" ).append("\n"); 
		query.append("        WHERE A1.VSL_CD(+)     = A2.VSL_CD" ).append("\n"); 
		query.append("          AND A1.SKD_VOY_NO(+) = A2.SKD_VOY_NO" ).append("\n"); 
		query.append("          AND A1.DIR_CD(+)     = A2.SKD_DIR_CD" ).append("\n"); 
		query.append("          AND A1.DELT_FLG      = 'N'" ).append("\n"); 
		query.append("          AND A1.TRD_CD        = SPC_GET_REP_TRD_FNC(A1.RLANE_CD)" ).append("\n"); 
		query.append("          AND A1.SUB_TRD_CD    = SPC_GET_REP_SUB_TRD_FNC(A1.RLANE_CD)" ).append("\n"); 
		query.append("          --------------------------" ).append("\n"); 
		query.append("          AND A2.VSL_CD     = SUBSTR(@[vvd_cd], 1, 4)" ).append("\n"); 
		query.append("          AND A2.SKD_VOY_NO = SUBSTR(@[vvd_cd], 5, 4)" ).append("\n"); 
		query.append("          AND A2.SKD_DIR_CD = SUBSTR(@[vvd_cd], 9, 1)" ).append("\n"); 
		query.append("          AND A2.IRR_PORT_CD = @[irr_port_cd]" ).append("\n"); 
		query.append("          AND A2.IRR_YD_CD 	 = @[irr_yd_cd]" ).append("\n"); 
		query.append("          AND A2.CRR_CD      = @[crr_cd]" ).append("\n"); 

	}
}