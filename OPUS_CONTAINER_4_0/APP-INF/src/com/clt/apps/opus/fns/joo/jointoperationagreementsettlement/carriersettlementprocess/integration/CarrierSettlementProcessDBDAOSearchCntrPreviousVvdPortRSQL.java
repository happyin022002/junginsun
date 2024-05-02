/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : CarrierSettlementProcessDBDAOSearchCntrPreviousVvdPortRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.07.21
*@LastModifier : 
*@LastVersion : 1.0
* 2015.07.21 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.fns.joo.jointoperationagreementsettlement.carriersettlementprocess.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CarrierSettlementProcessDBDAOSearchCntrPreviousVvdPortRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * previous VVD and Port search
	  * [2015.07.21]Virtual Add Calling 처리. VSK_VSL_PORT_SKD.NVL(VT_ADD_CALL_FLG, 'N') = 'N'
	  * </pre>
	  */
	public CarrierSettlementProcessDBDAOSearchCntrPreviousVvdPortRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("voy_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.fns.joo.jointoperationagreementsettlement.carriersettlementprocess.integration").append("\n"); 
		query.append("FileName : CarrierSettlementProcessDBDAOSearchCntrPreviousVvdPortRSQL").append("\n"); 
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
		query.append("WITH V_VVD AS(" ).append("\n"); 
		query.append("        SELECT VPS.*" ).append("\n"); 
		query.append("          FROM (SELECT VPS.VSL_CD" ).append("\n"); 
		query.append("                     , VPS.SKD_VOY_NO AS SKD_VOY_NO" ).append("\n"); 
		query.append("                     , VPS.SKD_DIR_CD AS SKD_DIR_CD" ).append("\n"); 
		query.append("                     , VPS.VPS_PORT_CD AS VPS_PORT_CD" ).append("\n"); 
		query.append("                     , VPS.CLPT_SEQ AS CLPT_SEQ" ).append("\n"); 
		query.append("                     , VPS.CLPT_IND_SEQ AS CLPT_IND_SEQ" ).append("\n"); 
		query.append("                     , VPS.VPS_ETD_DT" ).append("\n"); 
		query.append("                     , VPS.TURN_SKD_VOY_NO" ).append("\n"); 
		query.append("                     , VPS.TURN_SKD_DIR_CD" ).append("\n"); 
		query.append("                     , VPS.TURN_CLPT_IND_SEQ" ).append("\n"); 
		query.append("                  FROM VSK_VSL_SKD VSL" ).append("\n"); 
		query.append("                     , MDM_VSL_CNTR MVL" ).append("\n"); 
		query.append("                     , VSK_VSL_PORT_SKD VPS" ).append("\n"); 
		query.append("                     , MDM_VSL_SVC_LANE_DIR MVS" ).append("\n"); 
		query.append("                 WHERE 1=1" ).append("\n"); 
		query.append("                   AND VSL.VSL_CD = @[vsl_cd]" ).append("\n"); 
		query.append("                   AND VSL.SKD_VOY_NO = @[voy_no]" ).append("\n"); 
		query.append("				   #if (${dir_cd} != '') " ).append("\n"); 
		query.append("				   AND VSL.SKD_DIR_CD = @[dir_cd]" ).append("\n"); 
		query.append("				   #end" ).append("\n"); 
		query.append("                   AND VSL.VSL_CD = MVL.VSL_CD" ).append("\n"); 
		query.append("                   AND VSL.VSL_CD = VPS.VSL_CD" ).append("\n"); 
		query.append("                   AND VSL.SKD_VOY_NO = VPS.SKD_VOY_NO" ).append("\n"); 
		query.append("                   AND VSL.SKD_DIR_CD = VPS.SKD_DIR_CD" ).append("\n"); 
		query.append("                   AND (VPS.TURN_PORT_IND_CD IS NULL OR VPS.TURN_PORT_IND_CD NOT IN ('D', 'V', 'F'))" ).append("\n"); 
		query.append("                   AND (VPS.SKD_CNG_STS_CD IS NULL   OR VPS.SKD_CNG_STS_CD != 'S')" ).append("\n"); 
		query.append("                   AND NVL(VPS.VT_ADD_CALL_FLG, 'N') = 'N' /*2015.07.21 Add*/" ).append("\n"); 
		query.append("                   AND VSL.VSL_SLAN_CD = MVS.VSL_SLAN_CD" ).append("\n"); 
		query.append("                   AND VSL.SKD_DIR_CD = MVS.VSL_SLAN_DIR_CD" ).append("\n"); 
		query.append("                 ORDER BY MVS.VSL_SLAN_DIR_SEQ, VPS.CLPT_SEQ ) VPS" ).append("\n"); 
		query.append("         WHERE ROWNUM = 1 )" ).append("\n"); 
		query.append("SELECT VPS.VSL_CD" ).append("\n"); 
		query.append("     , VPS.SKD_VOY_NO AS SKD_VOY_NO" ).append("\n"); 
		query.append("     , VPS.SKD_DIR_CD AS SKD_DIR_CD" ).append("\n"); 
		query.append("     , VPS.VPS_PORT_CD AS VPS_PORT_CD" ).append("\n"); 
		query.append("     , VPS.CLPT_SEQ AS CLPT_SEQ" ).append("\n"); 
		query.append("     , VPS.CLPT_IND_SEQ AS CLPT_IND_SEQ" ).append("\n"); 
		query.append("     , VPS.VPS_ETD_DT" ).append("\n"); 
		query.append("     , VPS.TURN_SKD_VOY_NO" ).append("\n"); 
		query.append("     , VPS.TURN_SKD_DIR_CD" ).append("\n"); 
		query.append("     , VPS.TURN_CLPT_IND_SEQ" ).append("\n"); 
		query.append("  FROM VSK_VSL_SKD VSL" ).append("\n"); 
		query.append("     , MDM_VSL_CNTR MVL" ).append("\n"); 
		query.append("     , VSK_VSL_PORT_SKD VPS" ).append("\n"); 
		query.append("     , MDM_VSL_SVC_LANE_DIR MVS" ).append("\n"); 
		query.append("     , V_VVD SVV" ).append("\n"); 
		query.append(" WHERE 1=1" ).append("\n"); 
		query.append("   AND VPS.VSL_CD = SVV.VSL_CD" ).append("\n"); 
		query.append("   AND VPS.SKD_VOY_NO = SVV.TURN_SKD_VOY_NO" ).append("\n"); 
		query.append("   AND VPS.SKD_DIR_CD = SVV.TURN_SKD_DIR_CD" ).append("\n"); 
		query.append("   AND VSL.VSL_CD = MVL.VSL_CD" ).append("\n"); 
		query.append("   AND VSL.VSL_CD = VPS.VSL_CD" ).append("\n"); 
		query.append("   AND VSL.SKD_VOY_NO = VPS.SKD_VOY_NO" ).append("\n"); 
		query.append("   AND VSL.SKD_DIR_CD = VPS.SKD_DIR_CD" ).append("\n"); 
		query.append("   AND VPS.CLPT_SEQ = ( SELECT MAX(CLPT_SEQ)" ).append("\n"); 
		query.append("                          FROM VSK_VSL_PORT_SKD V" ).append("\n"); 
		query.append("                         WHERE V.VSL_CD = VPS.VSL_CD" ).append("\n"); 
		query.append("                           AND V.SKD_VOY_NO = VPS.SKD_VOY_NO" ).append("\n"); 
		query.append("                           AND V.SKD_DIR_CD = VPS.SKD_DIR_CD" ).append("\n"); 
		query.append("                           AND (V.TURN_PORT_IND_CD IS NULL OR V.TURN_PORT_IND_CD NOT IN ('D', 'V', 'F'))" ).append("\n"); 
		query.append("                           AND (V.SKD_CNG_STS_CD IS NULL   OR V.SKD_CNG_STS_CD != 'S')" ).append("\n"); 
		query.append("                           AND NVL(V.VT_ADD_CALL_FLG, 'N') = 'N' /*2015.07.21 Add*/ )" ).append("\n"); 
		query.append("   AND (VPS.TURN_PORT_IND_CD IS NULL OR VPS.TURN_PORT_IND_CD NOT IN ('D', 'V', 'F'))" ).append("\n"); 
		query.append("   AND (VPS.SKD_CNG_STS_CD IS NULL   OR VPS.SKD_CNG_STS_CD != 'S')" ).append("\n"); 
		query.append("   AND NVL(VPS.VT_ADD_CALL_FLG, 'N') = 'N' /*2015.07.21 Add*/" ).append("\n"); 
		query.append("   AND ROWNUM = 1" ).append("\n"); 

	}
}