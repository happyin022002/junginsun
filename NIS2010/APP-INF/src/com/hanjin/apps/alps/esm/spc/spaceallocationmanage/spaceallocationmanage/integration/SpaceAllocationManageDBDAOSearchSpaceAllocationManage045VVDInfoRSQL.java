/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : SpaceAllocationManageDBDAOSearchSpaceAllocationManage045VVDInfoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.06.13
*@LastModifier : 진마리아
*@LastVersion : 1.0
* 2013.06.13 진마리아
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.spc.spaceallocationmanage.spaceallocationmanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Maria Chin
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SpaceAllocationManageDBDAOSearchSpaceAllocationManage045VVDInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 2013.06.13 진마리아 SELCDO 팀코드 변경 (SELCTY)
	  * </pre>
	  */
	public SpaceAllocationManageDBDAOSearchSpaceAllocationManage045VVDInfoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("in_vvd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.spc.spaceallocationmanage.spaceallocationmanage.integration").append("\n"); 
		query.append("FileName : SpaceAllocationManageDBDAOSearchSpaceAllocationManage045VVDInfoRSQL").append("\n"); 
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
		query.append("SELECT COST_YRWK,RLANE_CD,VVD,RHQ" ).append("\n"); 
		query.append("  FROM ( " ).append("\n"); 
		query.append("SELECT DISTINCT SUBSTR(MV.SLS_YRMON, 1, 4)||MV.COST_WK     AS COST_YRWK," ).append("\n"); 
		query.append("       MV.RLANE_CD AS RLANE_CD," ).append("\n"); 
		query.append("       MV.VSL_CD|| MV.SKD_VOY_NO|| MV.DIR_CD VVD," ).append("\n"); 
		query.append("       (SELECT NVL(N2ND_PRNT_OFC_CD, OFC_CD) " ).append("\n"); 
		query.append("         FROM SPC_OFC_LVL " ).append("\n"); 
		query.append("        WHERE OFC_CD = @[ofc_cd]" ).append("\n"); 
		query.append("          AND SUBSTR(MV.SLS_YRMON, 1, 4)||MV.COST_WK BETWEEN OFC_APLY_FM_YRWK AND OFC_APLY_TO_YRWK) RHQ," ).append("\n"); 
		query.append("       MV.DIR_CD," ).append("\n"); 
		query.append("       RL.VSL_SLAN_CD" ).append("\n"); 
		query.append("    FROM VSK_VSL_SKD      TVPS," ).append("\n"); 
		query.append("         VSK_VSL_PORT_SKD VPS ," ).append("\n"); 
		query.append("         MAS_MON_VVD      MV  ," ).append("\n"); 
		query.append("         MDM_REV_LANE     RL" ).append("\n"); 
		query.append("   WHERE TVPS.VSL_CD    (+) = VPS.VSL_CD" ).append("\n"); 
		query.append("     AND TVPS.SKD_VOY_NO(+) = VPS.TURN_SKD_VOY_NO" ).append("\n"); 
		query.append("     AND TVPS.SKD_DIR_CD(+) = VPS.TURN_SKD_DIR_CD" ).append("\n"); 
		query.append("     AND VPS.VSL_CD         = MV.VSL_CD" ).append("\n"); 
		query.append("     AND VPS.SKD_VOY_NO     = MV.SKD_VOY_NO" ).append("\n"); 
		query.append("     AND VPS.SKD_DIR_CD     = MV.DIR_CD" ).append("\n"); 
		query.append("     AND (VPS.SKD_CNG_STS_CD IS NULL OR VPS.SKD_CNG_STS_CD <> 'S')" ).append("\n"); 
		query.append("     AND MV.DELT_FLG  = 'N'" ).append("\n"); 
		query.append("     AND MV.RLANE_CD  = RL.RLANE_CD" ).append("\n"); 
		query.append("     AND MV.TRD_CD    = RL.REP_TRD_CD" ).append("\n"); 
		query.append("     AND RL.VSL_TP_CD = 'C' " ).append("\n"); 
		query.append("     AND MV.VSL_CD     = SUBSTR(@[in_vvd],1,4)" ).append("\n"); 
		query.append("     and MV.SKD_VOY_NO = SUBSTR(@[in_vvd],5,4)" ).append("\n"); 
		query.append("     and MV.DIR_CD     = SUBSTR(@[in_vvd],9,1)" ).append("\n"); 
		query.append(")     " ).append("\n"); 
		query.append("WHERE RHQ IN ( " ).append("\n"); 
		query.append("  DECODE(RLANE_CD, 'IMUTA', DECODE(DIR_CD, 'W', 'HAMRU', 'E', 'NYCRA'), " ).append("\n"); 
		query.append("                   'IMUAE', DECODE(DIR_CD, 'E', 'HAMRU', 'W', 'SHARC')) " ).append("\n"); 
		query.append(", DECODE(RLANE_CD ,'IMUAE', DECODE(DIR_CD, 'W', 'SINRS')) " ).append("\n"); 
		query.append(", DECODE(RLANE_CD ,'IMUAE', DECODE(DIR_CD, 'W', 'SELCDO'))" ).append("\n"); 
		query.append(", DECODE(RLANE_CD ,'IMUAE', DECODE(DIR_CD, 'W', 'SELCTY'))" ).append("\n"); 
		query.append(", DECODE(VSL_SLAN_CD,'IMU','XXXXX',RHQ) -- IMU가 아닐때" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}
