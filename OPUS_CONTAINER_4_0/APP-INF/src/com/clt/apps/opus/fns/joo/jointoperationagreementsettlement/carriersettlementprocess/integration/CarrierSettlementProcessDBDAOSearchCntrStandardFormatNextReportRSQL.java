/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : CarrierSettlementProcessDBDAOSearchCntrStandardFormatNextReportRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.07.22
*@LastModifier : 
*@LastVersion : 1.0
* 2015.07.22 
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

public class CarrierSettlementProcessDBDAOSearchCntrStandardFormatNextReportRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ROB to next voyage
	  * [2015.07.21]Virtual Add Calling 처리. VSK_VSL_PORT_SKD.NVL(VT_ADD_CALL_FLG, 'N') = 'N'
	  * </pre>
	  */
	public CarrierSettlementProcessDBDAOSearchCntrStandardFormatNextReportRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("empty_tpsz_cd30",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("laden_tpsz_cd30",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("laden_tpsz_cd7",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("laden_tpsz_cd6",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("laden_tpsz_cd9",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("laden_tpsz_cd8",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("empty_tpsz_cd5",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("empty_tpsz_cd6",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("empty_tpsz_cd3",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("empty_tpsz_cd4",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("empty_tpsz_cd9",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("empty_tpsz_cd7",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("empty_tpsz_cd8",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("empty_tpsz_cd21",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("empty_tpsz_cd22",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("slan_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("empty_tpsz_cd20",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("empty_tpsz_cd1",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("empty_tpsz_cd25",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("empty_tpsz_cd2",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("empty_tpsz_cd26",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("empty_tpsz_cd23",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("empty_tpsz_cd24",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("empty_tpsz_cd29",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("empty_tpsz_cd28",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("empty_tpsz_cd27",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("laden_tpsz_cd14",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("laden_tpsz_cd13",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("laden_tpsz_cd16",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("laden_tpsz_cd15",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("laden_tpsz_cd18",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("laden_tpsz_cd17",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("laden_tpsz_cd19",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("empty_tpsz_cd12",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("empty_tpsz_cd13",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("empty_tpsz_cd14",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("empty_tpsz_cd15",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("laden_tpsz_cd10",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("laden_tpsz_cd12",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("empty_tpsz_cd10",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("laden_tpsz_cd11",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("voy_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("empty_tpsz_cd11",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("empty_tpsz_cd17",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("empty_tpsz_cd16",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("empty_tpsz_cd19",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("empty_tpsz_cd18",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("laden_tpsz_cd27",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("laden_tpsz_cd1",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("laden_tpsz_cd26",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("laden_tpsz_cd25",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("laden_tpsz_cd24",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("laden_tpsz_cd5",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("laden_tpsz_cd4",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("laden_tpsz_cd29",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("laden_tpsz_cd3",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("laden_tpsz_cd28",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("laden_tpsz_cd2",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("laden_tpsz_cd23",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("laden_tpsz_cd22",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("laden_tpsz_cd21",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("laden_tpsz_cd20",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.fns.joo.jointoperationagreementsettlement.carriersettlementprocess.integration").append("\n"); 
		query.append("FileName : CarrierSettlementProcessDBDAOSearchCntrStandardFormatNextReportRSQL").append("\n"); 
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
		query.append("                     , VSL.VSL_SLAN_CD" ).append("\n"); 
		query.append("                  FROM VSK_VSL_SKD VSL" ).append("\n"); 
		query.append("                     , MDM_VSL_CNTR MVL" ).append("\n"); 
		query.append("                     , VSK_VSL_PORT_SKD VPS" ).append("\n"); 
		query.append("                     , MDM_VSL_SVC_LANE_DIR MVS" ).append("\n"); 
		query.append("                 WHERE 1=1" ).append("\n"); 
		query.append("                   AND VSL.VSL_CD = @[vsl_cd]" ).append("\n"); 
		query.append("                   AND VSL.SKD_VOY_NO = @[voy_no]" ).append("\n"); 
		query.append("#if (${dir_cd} != '') " ).append("\n"); 
		query.append("				   AND VSL.SKD_DIR_CD = @[dir_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("                   AND VSL.VSL_CD = MVL.VSL_CD" ).append("\n"); 
		query.append("                   AND VSL.VSL_CD = VPS.VSL_CD" ).append("\n"); 
		query.append("                   AND VSL.SKD_VOY_NO = VPS.SKD_VOY_NO" ).append("\n"); 
		query.append("                   AND VSL.SKD_DIR_CD = VPS.SKD_DIR_CD" ).append("\n"); 
		query.append("                   AND (VPS.TURN_PORT_IND_CD IS NULL OR VPS.TURN_PORT_IND_CD NOT IN ('D', 'V', 'F'))" ).append("\n"); 
		query.append("                   AND (VPS.SKD_CNG_STS_CD IS NULL OR VPS.SKD_CNG_STS_CD != 'S')" ).append("\n"); 
		query.append("                   AND NVL(VPS.VT_ADD_CALL_FLG, 'N') = 'N' /*2015.07.21 Add*/" ).append("\n"); 
		query.append("                   AND VSL.VSL_SLAN_CD = MVS.VSL_SLAN_CD" ).append("\n"); 
		query.append("                   AND VSL.SKD_DIR_CD = MVS.VSL_SLAN_DIR_CD" ).append("\n"); 
		query.append("                 ORDER BY MVS.VSL_SLAN_DIR_SEQ DESC" ).append("\n"); 
		query.append("                     , VPS.CLPT_SEQ DESC) VPS" ).append("\n"); 
		query.append("         WHERE 1=1" ).append("\n"); 
		query.append("           AND ROWNUM = 1 " ).append("\n"); 
		query.append("        )" ).append("\n"); 
		query.append(",V_LVL_VVD AS (" ).append("\n"); 
		query.append("        /* 조회 조건의 이전 항차 */" ).append("\n"); 
		query.append("        SELECT DISTINCT -LEVEL AS LVL, VPS.VSL_CD, VPS.TURN_SKD_VOY_NO AS SKD_VOY_NO, VPS.TURN_SKD_DIR_CD AS SKD_DIR_CD,'LAG' AS DIR_TP" ).append("\n"); 
		query.append("         FROM VSK_VSL_PORT_SKD VPS, V_VVD VVD" ).append("\n"); 
		query.append("        WHERE LEVEL <= FLOOR(TO_NUMBER('3')/2)" ).append("\n"); 
		query.append("          AND (VPS.TURN_SKD_VOY_NO IS NOT NULL OR VPS.TURN_SKD_DIR_CD IS NOT NULL)" ).append("\n"); 
		query.append("        START WITH VPS.VSL_CD = VVD.VSL_CD " ).append("\n"); 
		query.append("          AND VPS.SKD_VOY_NO = VVD.SKD_VOY_NO " ).append("\n"); 
		query.append("          AND VPS.SKD_DIR_CD = VVD.SKD_DIR_CD " ).append("\n"); 
		query.append("          AND VPS.TURN_PORT_IND_CD IN ('Y', 'N')" ).append("\n"); 
		query.append("          AND NVL(VPS.VT_ADD_CALL_FLG, 'N') = 'N' /*2015.07.21 Add*/" ).append("\n"); 
		query.append("        CONNECT BY PRIOR VPS.TURN_SKD_VOY_NO = VPS.SKD_VOY_NO" ).append("\n"); 
		query.append("          AND PRIOR VPS.TURN_SKD_DIR_CD = VPS.SKD_DIR_CD  " ).append("\n"); 
		query.append("          AND PRIOR VPS.VSL_CD          = VPS.VSL_CD" ).append("\n"); 
		query.append("          AND VPS.TURN_PORT_IND_CD IN ('Y', 'N')" ).append("\n"); 
		query.append("          AND NVL(VPS.VT_ADD_CALL_FLG, 'N') = 'N' /*2015.07.21 Add*/" ).append("\n"); 
		query.append("          AND LEVEL <= FLOOR(TO_NUMBER('3')/2)" ).append("\n"); 
		query.append("        UNION ALL" ).append("\n"); 
		query.append("        /* 조회 조건의 항차 */ " ).append("\n"); 
		query.append("        SELECT 0 AS LVL, VSL_CD, SKD_VOY_NO, SKD_DIR_CD, 'NOW' AS DIR_TP FROM V_VVD" ).append("\n"); 
		query.append("        UNION ALL" ).append("\n"); 
		query.append("        /* 조회 조건의 이후 항차 */" ).append("\n"); 
		query.append("        SELECT DISTINCT LEVEL AS LVL, VPS.VSL_CD, VPS.TURN_SKD_VOY_NO AS SKD_VOY_NO, VPS.TURN_SKD_DIR_CD AS SKD_DIR_CD, 'LEAD' AS DIR_TP" ).append("\n"); 
		query.append("         FROM VSK_VSL_PORT_SKD VPS, V_VVD VVD " ).append("\n"); 
		query.append("        WHERE LEVEL <= FLOOR(TO_NUMBER('3')/2)" ).append("\n"); 
		query.append("          AND (VPS.TURN_SKD_VOY_NO IS NOT NULL OR VPS.TURN_SKD_DIR_CD IS NOT NULL)" ).append("\n"); 
		query.append("        START WITH VPS.VSL_CD = VVD.VSL_CD " ).append("\n"); 
		query.append("          AND VPS.SKD_VOY_NO = VVD.SKD_VOY_NO " ).append("\n"); 
		query.append("          AND VPS.SKD_DIR_CD = VVD.SKD_DIR_CD " ).append("\n"); 
		query.append("          AND VPS.TURN_PORT_IND_CD IN ('D', 'V', 'F')" ).append("\n"); 
		query.append("          AND NVL(VPS.VT_ADD_CALL_FLG, 'N') = 'N' /*2015.07.21 Add*/" ).append("\n"); 
		query.append("        CONNECT BY PRIOR VPS.TURN_SKD_VOY_NO  = VPS.SKD_VOY_NO " ).append("\n"); 
		query.append("          AND PRIOR VPS.TURN_SKD_DIR_CD = VPS.SKD_DIR_CD" ).append("\n"); 
		query.append("          AND PRIOR VPS.VSL_CD          = VPS.VSL_CD" ).append("\n"); 
		query.append("          AND VPS.TURN_PORT_IND_CD IN ('D', 'V', 'F')" ).append("\n"); 
		query.append("          AND NVL(VPS.VT_ADD_CALL_FLG, 'N') = 'N' /*2015.07.21 Add*/" ).append("\n"); 
		query.append("          AND LEVEL <= FLOOR(TO_NUMBER('3')/2)" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append(",V_PORT_LIST AS (" ).append("\n"); 
		query.append("        SELECT A.*" ).append("\n"); 
		query.append("             , B.TP" ).append("\n"); 
		query.append("             , B.TP_ORD" ).append("\n"); 
		query.append("          FROM (" ).append("\n"); 
		query.append("                SELECT A.*" ).append("\n"); 
		query.append("                     , LAG(A.VSL_CD||A.SKD_VOY_NO||A.SKD_DIR_CD) OVER (ORDER BY A.ORD ) LAG_VVD" ).append("\n"); 
		query.append("                     , LAG(A.VPS_PORT_CD) OVER (ORDER BY A.ORD ) LAG_VPS_PORT_CD" ).append("\n"); 
		query.append("                     , LAG(A.CLPT_IND_SEQ) OVER (ORDER BY A.ORD ) LAG_CLPT_IND_SEQ" ).append("\n"); 
		query.append("                  FROM (SELECT 0 ORD" ).append("\n"); 
		query.append("                             , MAX(VPS.VSL_CD) AS VSL_CD" ).append("\n"); 
		query.append("                             , MAX(VPS.SKD_VOY_NO) AS SKD_VOY_NO" ).append("\n"); 
		query.append("                             , MAX(VPS.SKD_DIR_CD) AS SKD_DIR_CD" ).append("\n"); 
		query.append("                             , MAX(VPS.VPS_PORT_CD) AS VPS_PORT_CD" ).append("\n"); 
		query.append("                             , MAX(VPS.CLPT_SEQ) AS CLPT_SEQ" ).append("\n"); 
		query.append("                             , MIN(VPS.CLPT_IND_SEQ) AS CLPT_IND_SEQ" ).append("\n"); 
		query.append("                             , MIN(VPS.VPS_ETD_DT) AS VPS_ETD_DT" ).append("\n"); 
		query.append("                             , MIN(VPS.TURN_SKD_VOY_NO) AS TURN_SKD_VOY_NO" ).append("\n"); 
		query.append("                             , MIN(VPS.TURN_SKD_DIR_CD) AS TURN_SKD_DIR_CD" ).append("\n"); 
		query.append("                             , MIN(VPS.TURN_CLPT_IND_SEQ) AS TURN_CLPT_IND_SEQ" ).append("\n"); 
		query.append("                          FROM VSK_VSL_SKD VSL" ).append("\n"); 
		query.append("                             , MDM_VSL_CNTR MVL" ).append("\n"); 
		query.append("                             , VSK_VSL_PORT_SKD VPS" ).append("\n"); 
		query.append("                             , MDM_VSL_SVC_LANE_DIR MVS" ).append("\n"); 
		query.append("                             , V_VVD V" ).append("\n"); 
		query.append("                         WHERE 1=1" ).append("\n"); 
		query.append("                           AND VPS.VSL_CD = V.VSL_CD" ).append("\n"); 
		query.append("                           AND VPS.SKD_VOY_NO = V.SKD_VOY_NO" ).append("\n"); 
		query.append("                           AND VPS.SKD_DIR_CD = V.SKD_DIR_CD" ).append("\n"); 
		query.append("                           AND VPS.VPS_PORT_CD = V.VPS_PORT_CD" ).append("\n"); 
		query.append("                           AND VSL.VSL_CD = MVL.VSL_CD" ).append("\n"); 
		query.append("                           AND VSL.VSL_CD = VPS.VSL_CD" ).append("\n"); 
		query.append("                           AND VSL.SKD_VOY_NO = VPS.SKD_VOY_NO" ).append("\n"); 
		query.append("                           AND VSL.SKD_DIR_CD = VPS.SKD_DIR_CD" ).append("\n"); 
		query.append("                           AND (VPS.TURN_PORT_IND_CD IS NULL OR VPS.TURN_PORT_IND_CD NOT IN ('D', 'V', 'F'))" ).append("\n"); 
		query.append("                           AND (VPS.SKD_CNG_STS_CD IS NULL OR VPS.SKD_CNG_STS_CD != 'S')" ).append("\n"); 
		query.append("                           AND NVL(VPS.VT_ADD_CALL_FLG, 'N') = 'N' /*2015.07.21 Add*/" ).append("\n"); 
		query.append("                         UNION ALL" ).append("\n"); 
		query.append("                    SELECT ROWNUM ORD" ).append("\n"); 
		query.append("                             , VPS.*" ).append("\n"); 
		query.append("                          FROM (SELECT VPS.VSL_CD" ).append("\n"); 
		query.append("                                     , VPS.SKD_VOY_NO AS SKD_VOY_NO" ).append("\n"); 
		query.append("                                     , VPS.SKD_DIR_CD AS SKD_DIR_CD" ).append("\n"); 
		query.append("                                     , VPS.VPS_PORT_CD AS VPS_PORT_CD" ).append("\n"); 
		query.append("                                     , VPS.CLPT_SEQ AS CLPT_SEQ" ).append("\n"); 
		query.append("                                     , VPS.CLPT_IND_SEQ AS CLPT_IND_SEQ" ).append("\n"); 
		query.append("                                     , VPS.VPS_ETD_DT" ).append("\n"); 
		query.append("                                     , VPS.TURN_SKD_VOY_NO" ).append("\n"); 
		query.append("                                     , VPS.TURN_SKD_DIR_CD" ).append("\n"); 
		query.append("                                     , VPS.TURN_CLPT_IND_SEQ" ).append("\n"); 
		query.append("                                  FROM VSK_VSL_SKD VSL" ).append("\n"); 
		query.append("                                     , MDM_VSL_CNTR MVL" ).append("\n"); 
		query.append("                                     , VSK_VSL_PORT_SKD VPS" ).append("\n"); 
		query.append("                                     , MDM_VSL_SVC_LANE_DIR MVS" ).append("\n"); 
		query.append("                                     , V_LVL_VVD V" ).append("\n"); 
		query.append("                                 WHERE 1=1" ).append("\n"); 
		query.append("                                   AND V.DIR_TP = 'LEAD'" ).append("\n"); 
		query.append("                                   AND VPS.VSL_CD = V.VSL_CD" ).append("\n"); 
		query.append("                                   AND VPS.SKD_VOY_NO = V.SKD_VOY_NO" ).append("\n"); 
		query.append("                                   AND VPS.SKD_DIR_CD = V.SKD_DIR_CD" ).append("\n"); 
		query.append("                                   AND VSL.VSL_CD = MVL.VSL_CD" ).append("\n"); 
		query.append("                                   AND VSL.VSL_CD = VPS.VSL_CD" ).append("\n"); 
		query.append("                                   AND VSL.SKD_VOY_NO = VPS.SKD_VOY_NO" ).append("\n"); 
		query.append("                                   AND VSL.SKD_DIR_CD = VPS.SKD_DIR_CD" ).append("\n"); 
		query.append("                                   AND (VPS.TURN_PORT_IND_CD IS NULL OR VPS.TURN_PORT_IND_CD NOT IN ('D', 'V', 'F'))" ).append("\n"); 
		query.append("                                   AND (VPS.SKD_CNG_STS_CD IS NULL OR VPS.SKD_CNG_STS_CD != 'S')" ).append("\n"); 
		query.append("                                   AND NVL(VPS.VT_ADD_CALL_FLG, 'N') = 'N' /*2015.07.21 Add*/" ).append("\n"); 
		query.append("                                   AND VSL.VSL_SLAN_CD = MVS.VSL_SLAN_CD" ).append("\n"); 
		query.append("                                   AND VSL.SKD_DIR_CD = MVS.VSL_SLAN_DIR_CD" ).append("\n"); 
		query.append("                                 ORDER BY MVS.VSL_SLAN_DIR_SEQ" ).append("\n"); 
		query.append("                                     , VPS.CLPT_SEQ ) VPS ) A" ).append("\n"); 
		query.append("                            ORDER BY A.ORD " ).append("\n"); 
		query.append("                ) A" ).append("\n"); 
		query.append("             , (SELECT 'D' AS TP, 1 AS TP_ORD FROM DUAL UNION ALL" ).append("\n"); 
		query.append("                SELECT 'L' AS TP, 2 AS TP_ORD FROM DUAL UNION ALL" ).append("\n"); 
		query.append("                SELECT 'B' AS TP, 3 AS TP_ORD FROM DUAL ) B" ).append("\n"); 
		query.append("         ORDER BY A.ORD , B.TP_ORD" ).append("\n"); 
		query.append("                " ).append("\n"); 
		query.append("         )" ).append("\n"); 
		query.append("      /*컨테이너 사이즈 : 테이블 정해지면 변경해야함.*/   " ).append("\n"); 
		query.append("    ,V_SZ_TP AS(" ).append("\n"); 
		query.append("        SELECT CNTR_TPSZ_CD" ).append("\n"); 
		query.append("             , DP_SEQ" ).append("\n"); 
		query.append("          FROM (SELECT DISTINCT 'F'||ATTR_CTNT2 AS CNTR_TPSZ_CD" ).append("\n"); 
		query.append("                     , MIN(LINE_SEQ) OVER (PARTITION BY ATTR_CTNT2) AS DP_SEQ" ).append("\n"); 
		query.append("                  FROM JOO_COM_PPT" ).append("\n"); 
		query.append("                 WHERE 1=1" ).append("\n"); 
		query.append("                   AND PPT_CD = 'TPSZ MAP'" ).append("\n"); 
		query.append("                   AND ATTR_CTNT2 IS NOT NULL" ).append("\n"); 
		query.append("                 UNION ALL" ).append("\n"); 
		query.append("        SELECT DISTINCT 'E'||ATTR_CTNT4 AS CNTR_TPSZ_CD" ).append("\n"); 
		query.append("                     , MIN(LINE_SEQ) OVER (PARTITION BY ATTR_CTNT4) AS DP_SEQ" ).append("\n"); 
		query.append("                  FROM JOO_COM_PPT" ).append("\n"); 
		query.append("                 WHERE 1=1" ).append("\n"); 
		query.append("                   AND PPT_CD = 'TPSZ MAP'" ).append("\n"); 
		query.append("                   AND ATTR_CTNT4 IS NOT NULL )" ).append("\n"); 
		query.append("         ORDER BY SUBSTR(CNTR_TPSZ_CD,1,1) DESC, DP_SEQ" ).append("\n"); 
		query.append("    )" ).append("\n"); 
		query.append("    /*TEST TPSZ */" ).append("\n"); 
		query.append("    --SELECT * FROM V_SZ_TP;" ).append("\n"); 
		query.append("/*TEST V_PORT Checked.*/" ).append("\n"); 
		query.append("--SELECT * FROM V_PORT_LIST;" ).append("\n"); 
		query.append("/*TEST BAY_PLAN*/" ).append("\n"); 
		query.append("/*" ).append("\n"); 
		query.append("SELECT VPS.VSL_CD" ).append("\n"); 
		query.append("     , VPS.SKD_VOY_NO AS VOY_NO" ).append("\n"); 
		query.append("     , VPS.SKD_DIR_CD AS DIR_CD" ).append("\n"); 
		query.append("     , BAY.POD" ).append("\n"); 
		query.append("     , BAY.FE" ).append("\n"); 
		query.append("     , BAY.SZTP" ).append("\n"); 
		query.append("     , BAY.WEIGHT" ).append("\n"); 
		query.append("  FROM V_PORT_LIST VPS" ).append("\n"); 
		query.append("     , BAY_PLAN BAY" ).append("\n"); 
		query.append(" WHERE 1=1" ).append("\n"); 
		query.append("   AND VPS.TP = 'D'" ).append("\n"); 
		query.append("   AND VPS.LAG_VVD = BAY.VSL_CD|| BAY.VOY_NO|| BAY.DIR_CD" ).append("\n"); 
		query.append("   AND VPS.LAG_VPS_PORT_CD = BAY.PORT_CD" ).append("\n"); 
		query.append("   AND VPS.LAG_CLPT_IND_SEQ = BAY.CALL_IND" ).append("\n"); 
		query.append("   AND VPS.VPS_PORT_CD = BAY.POD " ).append("\n"); 
		query.append(";" ).append("\n"); 
		query.append("*/" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("SELECT P.ORD" ).append("\n"); 
		query.append("     , P.VSL_CD" ).append("\n"); 
		query.append("     , P.SKD_VOY_NO" ).append("\n"); 
		query.append("     , P.SKD_DIR_CD" ).append("\n"); 
		query.append("     , P.VPS_PORT_CD" ).append("\n"); 
		query.append("     , P.CLPT_SEQ" ).append("\n"); 
		query.append("     , P.CLPT_IND_SEQ" ).append("\n"); 
		query.append("     , DECODE(P.TP,'D','Discharge','L','Load','B','Balance') AS TYPE" ).append("\n"); 
		query.append("     , P.TP_ORD" ).append("\n"); 
		query.append("     , NVL(V.VOID, 0) AS VOID_QTY" ).append("\n"); 
		query.append("     , NVL(L.WEIGHT, 0) AS WEIGHT" ).append("\n"); 
		query.append("     , NVL(L.TOTAL , 0) AS TOTAL" ).append("\n"); 
		query.append("     , NVL(F_QTY1 , 0) AS F_QTY1" ).append("\n"); 
		query.append("     , NVL(F_QTY2 , 0) AS F_QTY2" ).append("\n"); 
		query.append("     , NVL(F_QTY3 , 0) AS F_QTY3" ).append("\n"); 
		query.append("     , NVL(F_QTY4 , 0) AS F_QTY4" ).append("\n"); 
		query.append("     , NVL(F_QTY5 , 0) AS F_QTY5" ).append("\n"); 
		query.append("     , NVL(F_QTY6 , 0) AS F_QTY6" ).append("\n"); 
		query.append("     , NVL(F_QTY7 , 0) AS F_QTY7" ).append("\n"); 
		query.append("     , NVL(F_QTY8 , 0) AS F_QTY8" ).append("\n"); 
		query.append("     , NVL(F_QTY9 , 0) AS F_QTY9" ).append("\n"); 
		query.append("     , NVL(F_QTY10 , 0) AS F_QTY10" ).append("\n"); 
		query.append("     , NVL(F_QTY11 , 0) AS F_QTY11" ).append("\n"); 
		query.append("     , NVL(F_QTY12 , 0) AS F_QTY12" ).append("\n"); 
		query.append("     , NVL(F_QTY13 , 0) AS F_QTY13" ).append("\n"); 
		query.append("     , NVL(F_QTY14 , 0) AS F_QTY14" ).append("\n"); 
		query.append("     , NVL(F_QTY15 , 0) AS F_QTY15" ).append("\n"); 
		query.append("     , NVL(F_QTY16 , 0) AS F_QTY16" ).append("\n"); 
		query.append("     , NVL(F_QTY17 , 0) AS F_QTY17" ).append("\n"); 
		query.append("     , NVL(F_QTY18 , 0) AS F_QTY18" ).append("\n"); 
		query.append("     , NVL(F_QTY19 , 0) AS F_QTY19" ).append("\n"); 
		query.append("     , NVL(F_QTY20 , 0) AS F_QTY20" ).append("\n"); 
		query.append("     , NVL(F_QTY21 , 0) AS F_QTY21" ).append("\n"); 
		query.append("     , NVL(F_QTY22 , 0) AS F_QTY22" ).append("\n"); 
		query.append("     , NVL(F_QTY23 , 0) AS F_QTY23" ).append("\n"); 
		query.append("     , NVL(F_QTY24 , 0) AS F_QTY24" ).append("\n"); 
		query.append("     , NVL(F_QTY25 , 0) AS F_QTY25" ).append("\n"); 
		query.append("     , NVL(F_QTY26 , 0) AS F_QTY26" ).append("\n"); 
		query.append("     , NVL(F_QTY27 , 0) AS F_QTY27" ).append("\n"); 
		query.append("     , NVL(F_QTY28 , 0) AS F_QTY28" ).append("\n"); 
		query.append("     , NVL(F_QTY29 , 0) AS F_QTY29" ).append("\n"); 
		query.append("     , NVL(F_QTY30 , 0) AS F_QTY30" ).append("\n"); 
		query.append("     , NVL(E_QTY1 , 0) AS E_QTY1" ).append("\n"); 
		query.append("     , NVL(E_QTY2 , 0) AS E_QTY2" ).append("\n"); 
		query.append("     , NVL(E_QTY3 , 0) AS E_QTY3" ).append("\n"); 
		query.append("     , NVL(E_QTY4 , 0) AS E_QTY4" ).append("\n"); 
		query.append("     , NVL(E_QTY5 , 0) AS E_QTY5" ).append("\n"); 
		query.append("     , NVL(E_QTY6 , 0) AS E_QTY6" ).append("\n"); 
		query.append("     , NVL(E_QTY7 , 0) AS E_QTY7" ).append("\n"); 
		query.append("     , NVL(E_QTY8 , 0) AS E_QTY8" ).append("\n"); 
		query.append("     , NVL(E_QTY9 , 0) AS E_QTY9" ).append("\n"); 
		query.append("     , NVL(E_QTY10 , 0) AS E_QTY10" ).append("\n"); 
		query.append("     , NVL(E_QTY11 , 0) AS E_QTY11" ).append("\n"); 
		query.append("     , NVL(E_QTY12 , 0) AS E_QTY12" ).append("\n"); 
		query.append("     , NVL(E_QTY13 , 0) AS E_QTY13" ).append("\n"); 
		query.append("     , NVL(E_QTY14 , 0) AS E_QTY14" ).append("\n"); 
		query.append("     , NVL(E_QTY15 , 0) AS E_QTY15" ).append("\n"); 
		query.append("     , NVL(E_QTY16 , 0) AS E_QTY16" ).append("\n"); 
		query.append("     , NVL(E_QTY17 , 0) AS E_QTY17" ).append("\n"); 
		query.append("     , NVL(E_QTY18 , 0) AS E_QTY18" ).append("\n"); 
		query.append("     , NVL(E_QTY19 , 0) AS E_QTY19" ).append("\n"); 
		query.append("     , NVL(E_QTY20 , 0) AS E_QTY20" ).append("\n"); 
		query.append("     , NVL(E_QTY21 , 0) AS E_QTY21" ).append("\n"); 
		query.append("     , NVL(E_QTY22 , 0) AS E_QTY22" ).append("\n"); 
		query.append("     , NVL(E_QTY23 , 0) AS E_QTY23" ).append("\n"); 
		query.append("     , NVL(E_QTY24 , 0) AS E_QTY24" ).append("\n"); 
		query.append("     , NVL(E_QTY25 , 0) AS E_QTY25" ).append("\n"); 
		query.append("     , NVL(E_QTY26 , 0) AS E_QTY26" ).append("\n"); 
		query.append("     , NVL(E_QTY27 , 0) AS E_QTY27" ).append("\n"); 
		query.append("     , NVL(E_QTY28 , 0) AS E_QTY28" ).append("\n"); 
		query.append("     , NVL(E_QTY29 , 0) AS E_QTY29" ).append("\n"); 
		query.append("     , NVL(E_QTY30 , 0) AS E_QTY30" ).append("\n"); 
		query.append("  FROM V_PORT_LIST P" ).append("\n"); 
		query.append("     , (SELECT A.VSL_CD" ).append("\n"); 
		query.append("             , A.VOY_NO" ).append("\n"); 
		query.append("             , A.DIR_CD" ).append("\n"); 
		query.append("             , A.PORT_CD" ).append("\n"); 
		query.append("             , A.TYPE" ).append("\n"); 
		query.append("             , SUM(A.WEIGHT) AS WEIGHT" ).append("\n"); 
		query.append("             , NVL(SUM(A.CNT),0) AS TOTAL" ).append("\n"); 
		query.append("             , SUM(DECODE(A.CNTR_TPSZ_CD,@[laden_tpsz_cd1]  ,A.CNT,0)) F_QTY1" ).append("\n"); 
		query.append("             , SUM(DECODE(A.CNTR_TPSZ_CD,@[laden_tpsz_cd2]  ,A.CNT,0)) F_QTY2" ).append("\n"); 
		query.append("             , SUM(DECODE(A.CNTR_TPSZ_CD,@[laden_tpsz_cd3]  ,A.CNT,0)) F_QTY3" ).append("\n"); 
		query.append("             , SUM(DECODE(A.CNTR_TPSZ_CD,@[laden_tpsz_cd4]  ,A.CNT,0)) F_QTY4" ).append("\n"); 
		query.append("             , SUM(DECODE(A.CNTR_TPSZ_CD,@[laden_tpsz_cd5]  ,A.CNT,0)) F_QTY5" ).append("\n"); 
		query.append("             , SUM(DECODE(A.CNTR_TPSZ_CD,@[laden_tpsz_cd6]  ,A.CNT,0)) F_QTY6" ).append("\n"); 
		query.append("             , SUM(DECODE(A.CNTR_TPSZ_CD,@[laden_tpsz_cd7]  ,A.CNT,0)) F_QTY7" ).append("\n"); 
		query.append("             , SUM(DECODE(A.CNTR_TPSZ_CD,@[laden_tpsz_cd8]  ,A.CNT,0)) F_QTY8" ).append("\n"); 
		query.append("             , SUM(DECODE(A.CNTR_TPSZ_CD,@[laden_tpsz_cd9]  ,A.CNT,0)) F_QTY9" ).append("\n"); 
		query.append("             , SUM(DECODE(A.CNTR_TPSZ_CD,@[laden_tpsz_cd10] ,A.CNT,0)) F_QTY10" ).append("\n"); 
		query.append("             , SUM(DECODE(A.CNTR_TPSZ_CD,@[laden_tpsz_cd11] ,A.CNT,0)) F_QTY11" ).append("\n"); 
		query.append("             , SUM(DECODE(A.CNTR_TPSZ_CD,@[laden_tpsz_cd12] ,A.CNT,0)) F_QTY12" ).append("\n"); 
		query.append("             , SUM(DECODE(A.CNTR_TPSZ_CD,@[laden_tpsz_cd13] ,A.CNT,0)) F_QTY13" ).append("\n"); 
		query.append("             , SUM(DECODE(A.CNTR_TPSZ_CD,@[laden_tpsz_cd14] ,A.CNT,0)) F_QTY14" ).append("\n"); 
		query.append("             , SUM(DECODE(A.CNTR_TPSZ_CD,@[laden_tpsz_cd15] ,A.CNT,0)) F_QTY15" ).append("\n"); 
		query.append("             , SUM(DECODE(A.CNTR_TPSZ_CD,@[laden_tpsz_cd16] ,A.CNT,0)) F_QTY16" ).append("\n"); 
		query.append("             , SUM(DECODE(A.CNTR_TPSZ_CD,@[laden_tpsz_cd17] ,A.CNT,0)) F_QTY17" ).append("\n"); 
		query.append("             , SUM(DECODE(A.CNTR_TPSZ_CD,@[laden_tpsz_cd18] ,A.CNT,0)) F_QTY18" ).append("\n"); 
		query.append("             , SUM(DECODE(A.CNTR_TPSZ_CD,@[laden_tpsz_cd19] ,A.CNT,0)) F_QTY19" ).append("\n"); 
		query.append("             , SUM(DECODE(A.CNTR_TPSZ_CD,@[laden_tpsz_cd20] ,A.CNT,0)) F_QTY20" ).append("\n"); 
		query.append("             , SUM(DECODE(A.CNTR_TPSZ_CD,@[laden_tpsz_cd21] ,A.CNT,0)) F_QTY21" ).append("\n"); 
		query.append("             , SUM(DECODE(A.CNTR_TPSZ_CD,@[laden_tpsz_cd22] ,A.CNT,0)) F_QTY22" ).append("\n"); 
		query.append("             , SUM(DECODE(A.CNTR_TPSZ_CD,@[laden_tpsz_cd23] ,A.CNT,0)) F_QTY23" ).append("\n"); 
		query.append("             , SUM(DECODE(A.CNTR_TPSZ_CD,@[laden_tpsz_cd24] ,A.CNT,0)) F_QTY24" ).append("\n"); 
		query.append("             , SUM(DECODE(A.CNTR_TPSZ_CD,@[laden_tpsz_cd25] ,A.CNT,0)) F_QTY25" ).append("\n"); 
		query.append("             , SUM(DECODE(A.CNTR_TPSZ_CD,@[laden_tpsz_cd26] ,A.CNT,0)) F_QTY26" ).append("\n"); 
		query.append("             , SUM(DECODE(A.CNTR_TPSZ_CD,@[laden_tpsz_cd27] ,A.CNT,0)) F_QTY27" ).append("\n"); 
		query.append("             , SUM(DECODE(A.CNTR_TPSZ_CD,@[laden_tpsz_cd28] ,A.CNT,0)) F_QTY28" ).append("\n"); 
		query.append("             , SUM(DECODE(A.CNTR_TPSZ_CD,@[laden_tpsz_cd29] ,A.CNT,0)) F_QTY29" ).append("\n"); 
		query.append("             , SUM(DECODE(A.CNTR_TPSZ_CD,@[laden_tpsz_cd30] ,A.CNT,0)) F_QTY30" ).append("\n"); 
		query.append("             , SUM(DECODE(A.CNTR_TPSZ_CD,@[empty_tpsz_cd1]  ,A.CNT,0)) E_QTY1" ).append("\n"); 
		query.append("             , SUM(DECODE(A.CNTR_TPSZ_CD,@[empty_tpsz_cd2]  ,A.CNT,0)) E_QTY2" ).append("\n"); 
		query.append("             , SUM(DECODE(A.CNTR_TPSZ_CD,@[empty_tpsz_cd3]  ,A.CNT,0)) E_QTY3" ).append("\n"); 
		query.append("             , SUM(DECODE(A.CNTR_TPSZ_CD,@[empty_tpsz_cd4]  ,A.CNT,0)) E_QTY4" ).append("\n"); 
		query.append("             , SUM(DECODE(A.CNTR_TPSZ_CD,@[empty_tpsz_cd5]  ,A.CNT,0)) E_QTY5" ).append("\n"); 
		query.append("             , SUM(DECODE(A.CNTR_TPSZ_CD,@[empty_tpsz_cd6]  ,A.CNT,0)) E_QTY6" ).append("\n"); 
		query.append("             , SUM(DECODE(A.CNTR_TPSZ_CD,@[empty_tpsz_cd7]  ,A.CNT,0)) E_QTY7" ).append("\n"); 
		query.append("             , SUM(DECODE(A.CNTR_TPSZ_CD,@[empty_tpsz_cd8]  ,A.CNT,0)) E_QTY8" ).append("\n"); 
		query.append("             , SUM(DECODE(A.CNTR_TPSZ_CD,@[empty_tpsz_cd9]  ,A.CNT,0)) E_QTY9" ).append("\n"); 
		query.append("             , SUM(DECODE(A.CNTR_TPSZ_CD,@[empty_tpsz_cd10] ,A.CNT,0)) E_QTY10" ).append("\n"); 
		query.append("             , SUM(DECODE(A.CNTR_TPSZ_CD,@[empty_tpsz_cd11] ,A.CNT,0)) E_QTY11" ).append("\n"); 
		query.append("             , SUM(DECODE(A.CNTR_TPSZ_CD,@[empty_tpsz_cd12] ,A.CNT,0)) E_QTY12" ).append("\n"); 
		query.append("             , SUM(DECODE(A.CNTR_TPSZ_CD,@[empty_tpsz_cd13] ,A.CNT,0)) E_QTY13" ).append("\n"); 
		query.append("             , SUM(DECODE(A.CNTR_TPSZ_CD,@[empty_tpsz_cd14] ,A.CNT,0)) E_QTY14" ).append("\n"); 
		query.append("             , SUM(DECODE(A.CNTR_TPSZ_CD,@[empty_tpsz_cd15] ,A.CNT,0)) E_QTY15" ).append("\n"); 
		query.append("             , SUM(DECODE(A.CNTR_TPSZ_CD,@[empty_tpsz_cd16] ,A.CNT,0)) E_QTY16" ).append("\n"); 
		query.append("             , SUM(DECODE(A.CNTR_TPSZ_CD,@[empty_tpsz_cd17] ,A.CNT,0)) E_QTY17" ).append("\n"); 
		query.append("             , SUM(DECODE(A.CNTR_TPSZ_CD,@[empty_tpsz_cd18] ,A.CNT,0)) E_QTY18" ).append("\n"); 
		query.append("             , SUM(DECODE(A.CNTR_TPSZ_CD,@[empty_tpsz_cd19] ,A.CNT,0)) E_QTY19" ).append("\n"); 
		query.append("             , SUM(DECODE(A.CNTR_TPSZ_CD,@[empty_tpsz_cd20] ,A.CNT,0)) E_QTY20" ).append("\n"); 
		query.append("             , SUM(DECODE(A.CNTR_TPSZ_CD,@[empty_tpsz_cd21] ,A.CNT,0)) E_QTY21" ).append("\n"); 
		query.append("             , SUM(DECODE(A.CNTR_TPSZ_CD,@[empty_tpsz_cd22] ,A.CNT,0)) E_QTY22" ).append("\n"); 
		query.append("             , SUM(DECODE(A.CNTR_TPSZ_CD,@[empty_tpsz_cd23] ,A.CNT,0)) E_QTY23" ).append("\n"); 
		query.append("             , SUM(DECODE(A.CNTR_TPSZ_CD,@[empty_tpsz_cd24] ,A.CNT,0)) E_QTY24" ).append("\n"); 
		query.append("             , SUM(DECODE(A.CNTR_TPSZ_CD,@[empty_tpsz_cd25] ,A.CNT,0)) E_QTY25" ).append("\n"); 
		query.append("             , SUM(DECODE(A.CNTR_TPSZ_CD,@[empty_tpsz_cd26] ,A.CNT,0)) E_QTY26" ).append("\n"); 
		query.append("             , SUM(DECODE(A.CNTR_TPSZ_CD,@[empty_tpsz_cd27] ,A.CNT,0)) E_QTY27" ).append("\n"); 
		query.append("             , SUM(DECODE(A.CNTR_TPSZ_CD,@[empty_tpsz_cd28] ,A.CNT,0)) E_QTY28" ).append("\n"); 
		query.append("             , SUM(DECODE(A.CNTR_TPSZ_CD,@[empty_tpsz_cd29] ,A.CNT,0)) E_QTY29" ).append("\n"); 
		query.append("             , SUM(DECODE(A.CNTR_TPSZ_CD,@[empty_tpsz_cd30] ,A.CNT,0)) E_QTY30" ).append("\n"); 
		query.append("          FROM (" ).append("\n"); 
		query.append("                SELECT 'D' AS TYPE" ).append("\n"); 
		query.append("                     , A.VSL_CD" ).append("\n"); 
		query.append("                     , A.VOY_NO" ).append("\n"); 
		query.append("                     , A.DIR_CD" ).append("\n"); 
		query.append("                     , A.PORT_CD" ).append("\n"); 
		query.append("                     , S.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("                     , NVL(A.WEIGHT,0) AS WEIGHT" ).append("\n"); 
		query.append("                     , NVL(A.CNT, 0) AS CNT" ).append("\n"); 
		query.append("                  FROM (SELECT BAY.VSL_CD" ).append("\n"); 
		query.append("                             , BAY.VOY_NO AS VOY_NO" ).append("\n"); 
		query.append("                             , BAY.DIR_CD AS DIR_CD" ).append("\n"); 
		query.append("                             , BAY.POD AS PORT_CD" ).append("\n"); 
		query.append("                             , BAY.CNTR_TPSZ_CD AS CNTR_TPSZ_CD" ).append("\n"); 
		query.append("                             , SUM(BAY.WEIGHT) AS WEIGHT" ).append("\n"); 
		query.append("                             , COUNT(BAY.CNTR_TPSZ_CD) AS CNT" ).append("\n"); 
		query.append("                          FROM (SELECT VPS.VSL_CD" ).append("\n"); 
		query.append("                                     , VPS.SKD_VOY_NO AS VOY_NO" ).append("\n"); 
		query.append("                                     , VPS.SKD_DIR_CD AS DIR_CD" ).append("\n"); 
		query.append("                                     , BAY.POD" ).append("\n"); 
		query.append("                                     , BAY.FE||COM.ATTR_CTNT2 AS CNTR_TPSZ_CD" ).append("\n"); 
		query.append("                                     , BAY.WEIGHT" ).append("\n"); 
		query.append("                                  FROM V_PORT_LIST VPS" ).append("\n"); 
		query.append("                                     , BAY_PLAN BAY" ).append("\n"); 
		query.append("                                     , JOO_COM_PPT COM" ).append("\n"); 
		query.append("                                 WHERE 1=1" ).append("\n"); 
		query.append("                                   AND VPS.TP = 'D'" ).append("\n"); 
		query.append("                                   AND VPS.ORD > 0" ).append("\n"); 
		query.append("                                   AND VPS.LAG_VVD = BAY.VSL_CD|| BAY.VOY_NO|| BAY.DIR_CD" ).append("\n"); 
		query.append("                                   AND VPS.LAG_VPS_PORT_CD = BAY.PORT_CD" ).append("\n"); 
		query.append("                                   AND VPS.LAG_CLPT_IND_SEQ = BAY.CALL_IND" ).append("\n"); 
		query.append("                                   AND VPS.VPS_PORT_CD = BAY.POD" ).append("\n"); 
		query.append("#if (${slan_cd} != '') " ).append("\n"); 
		query.append("				                   AND BAY.OPR_CD = @[slan_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("                                   AND BAY.FE = 'F' --Full" ).append("\n"); 
		query.append("                                   AND COM.PPT_CD = 'TPSZ MAP'" ).append("\n"); 
		query.append("                                   AND COM.ATTR_CTNT2 IS NOT NULL" ).append("\n"); 
		query.append("                                   AND BAY.SZTP = COM.ATTR_CTNT1" ).append("\n"); 
		query.append("                               UNION ALL" ).append("\n"); 
		query.append("                                SELECT VPS.VSL_CD" ).append("\n"); 
		query.append("                                     , VPS.SKD_VOY_NO AS VOY_NO" ).append("\n"); 
		query.append("                                     , VPS.SKD_DIR_CD AS DIR_CD" ).append("\n"); 
		query.append("                                     , BAY.POD" ).append("\n"); 
		query.append("                                     , BAY.FE || COM.ATTR_CTNT3 AS CNTR_TPSZ_CD" ).append("\n"); 
		query.append("                                     , BAY.WEIGHT" ).append("\n"); 
		query.append("                                  FROM V_PORT_LIST VPS" ).append("\n"); 
		query.append("                                     , BAY_PLAN BAY" ).append("\n"); 
		query.append("                                     , JOO_COM_PPT COM" ).append("\n"); 
		query.append("                                 WHERE 1=1" ).append("\n"); 
		query.append("                                   AND VPS.TP = 'D'" ).append("\n"); 
		query.append("                                   AND VPS.ORD > 0" ).append("\n"); 
		query.append("                                   AND VPS.LAG_VVD = BAY.VSL_CD|| BAY.VOY_NO|| BAY.DIR_CD" ).append("\n"); 
		query.append("                                   AND VPS.LAG_VPS_PORT_CD = BAY.PORT_CD" ).append("\n"); 
		query.append("                                   AND VPS.LAG_CLPT_IND_SEQ = BAY.CALL_IND" ).append("\n"); 
		query.append("                                   AND VPS.VPS_PORT_CD = BAY.POD" ).append("\n"); 
		query.append("#if (${slan_cd} != '') " ).append("\n"); 
		query.append("				                   AND BAY.OPR_CD = @[slan_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("                                   AND BAY.FE = 'E' --Empty" ).append("\n"); 
		query.append("                                   AND COM.PPT_CD = 'TPSZ MAP'" ).append("\n"); 
		query.append("                                   AND COM.ATTR_CTNT3 IS NOT NULL" ).append("\n"); 
		query.append("                                   AND BAY.SZTP = COM.ATTR_CTNT1" ).append("\n"); 
		query.append("                               ) BAY" ).append("\n"); 
		query.append("                         WHERE 1=1" ).append("\n"); 
		query.append("                         GROUP BY BAY.VSL_CD" ).append("\n"); 
		query.append("                             , BAY.VOY_NO" ).append("\n"); 
		query.append("                             , BAY.DIR_CD" ).append("\n"); 
		query.append("                             , BAY.POD" ).append("\n"); 
		query.append("                             , BAY.CNTR_TPSZ_CD) A" ).append("\n"); 
		query.append("                     , V_SZ_TP S" ).append("\n"); 
		query.append("                 WHERE A.CNTR_TPSZ_CD = S.CNTR_TPSZ_CD) A" ).append("\n"); 
		query.append("                 GROUP BY A.VSL_CD" ).append("\n"); 
		query.append("                     , A.VOY_NO" ).append("\n"); 
		query.append("                     , A.DIR_CD" ).append("\n"); 
		query.append("                     , A.PORT_CD" ).append("\n"); 
		query.append("               ) L" ).append("\n"); 
		query.append("     , (" ).append("\n"); 
		query.append("         /*Void*/" ).append("\n"); 
		query.append("        SELECT A.TYPE" ).append("\n"); 
		query.append("             , A.VSL_CD" ).append("\n"); 
		query.append("             , A.VOY_NO" ).append("\n"); 
		query.append("             , A.DIR_CD" ).append("\n"); 
		query.append("             , A.PORT_CD" ).append("\n"); 
		query.append("             , SUM(A.VOID) AS VOID" ).append("\n"); 
		query.append("          FROM (" ).append("\n"); 
		query.append("                /*Discharge - Void*/" ).append("\n"); 
		query.append("                SELECT VPS.TP AS TYPE" ).append("\n"); 
		query.append("                     , VPS.VSL_CD" ).append("\n"); 
		query.append("                     , VPS.SKD_VOY_NO AS VOY_NO" ).append("\n"); 
		query.append("                     , VPS.SKD_DIR_CD AS DIR_CD" ).append("\n"); 
		query.append("                     , BAY.POD AS PORT_CD" ).append("\n"); 
		query.append("                     , NVL(BAY.OVH_SLOT,0) + NVL(BAY.OVP_SLOT,0) + NVL(BAY.OVS_SLOT,0) + NVL(BAY.OVF_SLOT,0) + NVL(BAY.OVA_SLOT,0) AS VOID" ).append("\n"); 
		query.append("                  FROM V_PORT_LIST VPS" ).append("\n"); 
		query.append("                     , BAY_PLAN BAY" ).append("\n"); 
		query.append("                 WHERE 1=1" ).append("\n"); 
		query.append("                   AND VPS.TP = 'D'" ).append("\n"); 
		query.append("                   AND VPS.ORD > 0" ).append("\n"); 
		query.append("                   AND VPS.LAG_VVD = BAY.VSL_CD|| BAY.VOY_NO|| BAY.DIR_CD" ).append("\n"); 
		query.append("                   AND VPS.LAG_VPS_PORT_CD = BAY.PORT_CD" ).append("\n"); 
		query.append("                   AND VPS.LAG_CLPT_IND_SEQ = BAY.CALL_IND" ).append("\n"); 
		query.append("                   AND VPS.VPS_PORT_CD = BAY.POD" ).append("\n"); 
		query.append("                   AND BAY.FE = 'F' --Laden" ).append("\n"); 
		query.append("                ) A" ).append("\n"); 
		query.append("         GROUP BY A.TYPE" ).append("\n"); 
		query.append("             , A.VSL_CD" ).append("\n"); 
		query.append("             , A.VOY_NO" ).append("\n"); 
		query.append("             , A.DIR_CD" ).append("\n"); 
		query.append("             , A.PORT_CD" ).append("\n"); 
		query.append("         ) V" ).append("\n"); 
		query.append(" WHERE 1=1" ).append("\n"); 
		query.append("   AND P.TP = 'D'" ).append("\n"); 
		query.append("   AND P.ORD > 0 -- 이전항차는 보여줄 필요가 없다. 이미 안에서 구한 부분입니다." ).append("\n"); 
		query.append("   AND P.VSL_CD = L.VSL_CD (+)" ).append("\n"); 
		query.append("   AND P.SKD_VOY_NO = L.VOY_NO (+)" ).append("\n"); 
		query.append("   AND P.SKD_DIR_CD = L.DIR_CD (+)" ).append("\n"); 
		query.append("   AND P.VPS_PORT_CD = L.PORT_CD(+)" ).append("\n"); 
		query.append("   AND P.TP = V.TYPE(+)" ).append("\n"); 
		query.append("   AND P.VSL_CD = V.VSL_CD (+)" ).append("\n"); 
		query.append("   AND P.SKD_VOY_NO = V.VOY_NO (+)" ).append("\n"); 
		query.append("   AND P.SKD_DIR_CD = V.DIR_CD (+)" ).append("\n"); 
		query.append("   AND P.VPS_PORT_CD = V.PORT_CD(+)" ).append("\n"); 
		query.append(" ORDER BY P.ORD, P.CLPT_SEQ" ).append("\n"); 

	}
}