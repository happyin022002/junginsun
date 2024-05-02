/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : CarrierSettlementProcessDBDAOSearchCntrStandardFormatReportRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.10.19
*@LastModifier : 
*@LastVersion : 1.0
* 2016.10.19 
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

public class CarrierSettlementProcessDBDAOSearchCntrStandardFormatReportRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Standard Format Report
	  * [2015.07.21]Virtual Add Calling 처리. VSK_VSL_PORT_SKD.NVL(VT_ADD_CALL_FLG, 'N') = 'N'
	  * </pre>
	  */
	public CarrierSettlementProcessDBDAOSearchCntrStandardFormatReportRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pre_vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("pre_voy_no",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("lst_port",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("empty_tpsz_cd11",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("lst_clpt_ind_seq",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("pre_dir_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("FileName : CarrierSettlementProcessDBDAOSearchCntrStandardFormatReportRSQL").append("\n"); 
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
		query.append("WITH " ).append("\n"); 
		query.append("V_VVD AS(" ).append("\n"); 
		query.append("   SELECT VPS.*" ).append("\n"); 
		query.append("     FROM (SELECT /*+ ORDERED */ VPS.VSL_CD" ).append("\n"); 
		query.append("             , VPS.SKD_VOY_NO AS SKD_VOY_NO" ).append("\n"); 
		query.append("             , VPS.SKD_DIR_CD AS SKD_DIR_CD" ).append("\n"); 
		query.append("             , VPS.VPS_PORT_CD AS VPS_PORT_CD" ).append("\n"); 
		query.append("             , VPS.CLPT_SEQ AS CLPT_SEQ" ).append("\n"); 
		query.append("             , VPS.CLPT_IND_SEQ AS CLPT_IND_SEQ" ).append("\n"); 
		query.append("             , VPS.VPS_ETD_DT" ).append("\n"); 
		query.append("             , VPS.TURN_SKD_VOY_NO" ).append("\n"); 
		query.append("             , VPS.TURN_SKD_DIR_CD" ).append("\n"); 
		query.append("             , VPS.TURN_CLPT_IND_SEQ " ).append("\n"); 
		query.append("             , VSL.VSL_SLAN_CD" ).append("\n"); 
		query.append("          FROM VSK_VSL_SKD VSL" ).append("\n"); 
		query.append("             , MDM_VSL_CNTR MVL" ).append("\n"); 
		query.append("             , VSK_VSL_PORT_SKD VPS" ).append("\n"); 
		query.append("             , MDM_VSL_SVC_LANE_DIR MVS" ).append("\n"); 
		query.append("         WHERE 1=1" ).append("\n"); 
		query.append("           AND VSL.VSL_CD = @[vsl_cd]" ).append("\n"); 
		query.append("           AND VSL.SKD_VOY_NO = @[voy_no]" ).append("\n"); 
		query.append("#if (${dir_cd} != '') " ).append("\n"); 
		query.append("		   AND VSL.SKD_DIR_CD = @[dir_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("           AND VSL.VSL_CD = MVL.VSL_CD" ).append("\n"); 
		query.append("           AND VSL.VSL_CD = VPS.VSL_CD" ).append("\n"); 
		query.append("           AND VSL.SKD_VOY_NO = VPS.SKD_VOY_NO" ).append("\n"); 
		query.append("           AND VSL.SKD_DIR_CD = VPS.SKD_DIR_CD" ).append("\n"); 
		query.append("           AND (VPS.TURN_PORT_IND_CD IS NULL OR VPS.TURN_PORT_IND_CD NOT IN ('D', 'V', 'F'))" ).append("\n"); 
		query.append("           AND (VPS.SKD_CNG_STS_CD IS NULL   OR VPS.SKD_CNG_STS_CD != 'S')" ).append("\n"); 
		query.append("           AND NVL(VPS.VT_ADD_CALL_FLG, 'N') = 'N' /*2015.07.21 Add*/" ).append("\n"); 
		query.append("           AND VSL.VSL_SLAN_CD = MVS.VSL_SLAN_CD" ).append("\n"); 
		query.append("           AND VSL.SKD_DIR_CD = MVS.VSL_SLAN_DIR_CD" ).append("\n"); 
		query.append("         ORDER BY MVS.VSL_SLAN_DIR_SEQ, VPS.CLPT_SEQ ) VPS" ).append("\n"); 
		query.append(" WHERE ROWNUM = 1" ).append("\n"); 
		query.append(") " ).append("\n"); 
		query.append("/*TEST Default VVD*/" ).append("\n"); 
		query.append("--SELECT * FROM V_VVD;" ).append("\n"); 
		query.append(",V_LVL_VVD AS (" ).append("\n"); 
		query.append("        /* 조회 조건의 이전 항차 */" ).append("\n"); 
		query.append("        SELECT DISTINCT -LEVEL AS LVL, VPS.VSL_CD, VPS.TURN_SKD_VOY_NO AS SKD_VOY_NO, VPS.TURN_SKD_DIR_CD AS SKD_DIR_CD,'LAG' AS DIR_TP" ).append("\n"); 
		query.append("          FROM VSK_VSL_PORT_SKD VPS, V_VVD VVD" ).append("\n"); 
		query.append("         WHERE LEVEL <= FLOOR(TO_NUMBER('3')/2)" ).append("\n"); 
		query.append("           AND (VPS.TURN_SKD_VOY_NO IS NOT NULL OR VPS.TURN_SKD_DIR_CD IS NOT NULL)" ).append("\n"); 
		query.append("         START WITH VPS.VSL_CD = VVD.VSL_CD " ).append("\n"); 
		query.append("           AND VPS.SKD_VOY_NO = VVD.SKD_VOY_NO " ).append("\n"); 
		query.append("           AND VPS.SKD_DIR_CD = VVD.SKD_DIR_CD " ).append("\n"); 
		query.append("           AND VPS.TURN_PORT_IND_CD IN ('Y', 'N')" ).append("\n"); 
		query.append("           AND NVL(VPS.VT_ADD_CALL_FLG, 'N') = 'N' /*2015.07.21 Add*/" ).append("\n"); 
		query.append("         CONNECT BY PRIOR VPS.TURN_SKD_VOY_NO = VPS.SKD_VOY_NO" ).append("\n"); 
		query.append("           AND PRIOR VPS.TURN_SKD_DIR_CD = VPS.SKD_DIR_CD  " ).append("\n"); 
		query.append("           AND PRIOR VPS.VSL_CD          = VPS.VSL_CD" ).append("\n"); 
		query.append("           AND VPS.TURN_PORT_IND_CD IN ('Y', 'N')" ).append("\n"); 
		query.append("           AND NVL(VPS.VT_ADD_CALL_FLG, 'N') = 'N' /*2015.07.21 Add*/" ).append("\n"); 
		query.append("           AND LEVEL <= FLOOR(TO_NUMBER('3')/2)" ).append("\n"); 
		query.append("        UNION ALL" ).append("\n"); 
		query.append("        /* 조회 조건의 항차 */ " ).append("\n"); 
		query.append("        SELECT 0 AS LVL, VSL_CD, SKD_VOY_NO, SKD_DIR_CD, 'NOW' AS DIR_TP FROM V_VVD" ).append("\n"); 
		query.append("        UNION ALL" ).append("\n"); 
		query.append("        /* 조회 조건의 이후 항차 */" ).append("\n"); 
		query.append("        SELECT DISTINCT LEVEL AS LVL, VPS.VSL_CD, VPS.TURN_SKD_VOY_NO AS SKD_VOY_NO, VPS.TURN_SKD_DIR_CD AS SKD_DIR_CD, 'LEAD' AS DIR_TP" ).append("\n"); 
		query.append("          FROM VSK_VSL_PORT_SKD VPS, V_VVD VVD " ).append("\n"); 
		query.append("         WHERE LEVEL <= FLOOR(TO_NUMBER('3')/2)" ).append("\n"); 
		query.append("           AND (VPS.TURN_SKD_VOY_NO IS NOT NULL OR VPS.TURN_SKD_DIR_CD IS NOT NULL)" ).append("\n"); 
		query.append("         START WITH VPS.VSL_CD = VVD.VSL_CD " ).append("\n"); 
		query.append("           AND VPS.SKD_VOY_NO = VVD.SKD_VOY_NO " ).append("\n"); 
		query.append("           AND VPS.SKD_DIR_CD = VVD.SKD_DIR_CD " ).append("\n"); 
		query.append("           AND VPS.TURN_PORT_IND_CD IN ('D', 'V', 'F')" ).append("\n"); 
		query.append("           AND NVL(VPS.VT_ADD_CALL_FLG, 'N') = 'N' /*2015.07.21 Add*/" ).append("\n"); 
		query.append("         CONNECT BY PRIOR VPS.TURN_SKD_VOY_NO  = VPS.SKD_VOY_NO " ).append("\n"); 
		query.append("           AND PRIOR VPS.TURN_SKD_DIR_CD = VPS.SKD_DIR_CD" ).append("\n"); 
		query.append("           AND PRIOR VPS.VSL_CD          = VPS.VSL_CD" ).append("\n"); 
		query.append("           AND VPS.TURN_PORT_IND_CD IN ('D', 'V', 'F')" ).append("\n"); 
		query.append("           AND NVL(VPS.VT_ADD_CALL_FLG, 'N') = 'N' /*2015.07.21 Add*/" ).append("\n"); 
		query.append("           AND LEVEL <= FLOOR(TO_NUMBER('3')/2)" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("/*TEST 3Level VVD*/" ).append("\n"); 
		query.append("--SELECT * FROM V_LVL_VVD;" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(",V_PORT_LIST_TMP AS(" ).append("\n"); 
		query.append("/*조회 조건 이전/현재/이후 항차의 Port 조회*/" ).append("\n"); 
		query.append("        SELECT A.*" ).append("\n"); 
		query.append("             , LAG(A.VSL_CD||A.SKD_VOY_NO||A.SKD_DIR_CD) OVER (ORDER BY A.ORD ) LAG_VVD" ).append("\n"); 
		query.append("             , LAG(A.VPS_PORT_CD) OVER (ORDER BY A.ORD ) LAG_VPS_PORT_CD" ).append("\n"); 
		query.append("             , LAG(A.CLPT_IND_SEQ) OVER (ORDER BY A.ORD ) LAG_CLPT_IND_SEQ" ).append("\n"); 
		query.append("          FROM (" ).append("\n"); 
		query.append("                /*이전항차의 마지막 port 를 구한다.*/" ).append("\n"); 
		query.append("                SELECT /*+ ORDERED */ 0 ORD" ).append("\n"); 
		query.append("                     , MAX(VPS.SLAN_CD) AS SLAN_CD" ).append("\n"); 
		query.append("                     , MAX(VPS.VSL_CD) AS VSL_CD" ).append("\n"); 
		query.append("                     , MAX(VPS.SKD_VOY_NO) AS SKD_VOY_NO" ).append("\n"); 
		query.append("                     , MAX(VPS.SKD_DIR_CD) AS SKD_DIR_CD" ).append("\n"); 
		query.append("                     , MAX(VPS.VPS_PORT_CD) AS VPS_PORT_CD" ).append("\n"); 
		query.append("                     , MAX(VPS.CLPT_SEQ) AS CLPT_SEQ" ).append("\n"); 
		query.append("                     , MIN(VPS.CLPT_IND_SEQ) AS CLPT_IND_SEQ" ).append("\n"); 
		query.append("                     , MIN(VPS.VPS_ETD_DT) AS VPS_ETD_DT" ).append("\n"); 
		query.append("                     , MIN(VPS.TURN_SKD_VOY_NO) AS TURN_SKD_VOY_NO" ).append("\n"); 
		query.append("                     , MIN(VPS.TURN_SKD_DIR_CD) AS TURN_SKD_DIR_CD" ).append("\n"); 
		query.append("                     , MIN(VPS.TURN_CLPT_IND_SEQ) AS TURN_CLPT_IND_SEQ" ).append("\n"); 
		query.append("                     , MIN(VPS.IB_CSSM_VOY_NO) AS IB_CSSM_VOY_NO" ).append("\n"); 
		query.append("                     , MIN(VPS.OB_CSSM_VOY_NO) AS OB_CSSM_VOY_NO" ).append("\n"); 
		query.append("                  FROM VSK_VSL_SKD VSL" ).append("\n"); 
		query.append("                     , MDM_VSL_CNTR MVL" ).append("\n"); 
		query.append("                     , VSK_VSL_PORT_SKD VPS" ).append("\n"); 
		query.append("                     , MDM_VSL_SVC_LANE_DIR MVS" ).append("\n"); 
		query.append("                 WHERE 1=1" ).append("\n"); 
		query.append("                   AND VPS.VSL_CD = @[pre_vsl_cd]" ).append("\n"); 
		query.append("                   AND VPS.SKD_VOY_NO = @[pre_voy_no]" ).append("\n"); 
		query.append("                   AND VPS.SKD_DIR_CD = @[pre_dir_cd]" ).append("\n"); 
		query.append("                   AND VPS.VPS_PORT_CD = @[lst_port]" ).append("\n"); 
		query.append("                   AND VPS.CLPT_IND_SEQ = @[lst_clpt_ind_seq]" ).append("\n"); 
		query.append("                   AND VSL.VSL_CD = MVL.VSL_CD" ).append("\n"); 
		query.append("                   AND VSL.VSL_CD = VPS.VSL_CD" ).append("\n"); 
		query.append("                   AND VSL.SKD_VOY_NO = VPS.SKD_VOY_NO" ).append("\n"); 
		query.append("                   AND VSL.SKD_DIR_CD = VPS.SKD_DIR_CD" ).append("\n"); 
		query.append("                   AND (VPS.TURN_PORT_IND_CD IS NULL OR VPS.TURN_PORT_IND_CD NOT IN ('D' , 'V', 'F'))" ).append("\n"); 
		query.append("                   AND (VPS.SKD_CNG_STS_CD IS NULL   OR VPS.SKD_CNG_STS_CD != 'S')" ).append("\n"); 
		query.append("                   AND NVL(VPS.VT_ADD_CALL_FLG, 'N') = 'N' /*2015.07.21 Add*/" ).append("\n"); 
		query.append("                 UNION ALL" ).append("\n"); 
		query.append("                 /*현재항차 전체를 구한다.*/" ).append("\n"); 
		query.append("                SELECT ROWNUM ORD" ).append("\n"); 
		query.append("                     , VPS.*" ).append("\n"); 
		query.append("                  FROM (SELECT /*+ ORDERED */ VPS.SLAN_CD AS SLAN_CD" ).append("\n"); 
		query.append("                             , VPS.VSL_CD" ).append("\n"); 
		query.append("                             , VPS.SKD_VOY_NO AS SKD_VOY_NO" ).append("\n"); 
		query.append("                             , VPS.SKD_DIR_CD AS SKD_DIR_CD" ).append("\n"); 
		query.append("                             , VPS.VPS_PORT_CD AS VPS_PORT_CD" ).append("\n"); 
		query.append("                             , VPS.CLPT_SEQ AS CLPT_SEQ" ).append("\n"); 
		query.append("                             , VPS.CLPT_IND_SEQ AS CLPT_IND_SEQ" ).append("\n"); 
		query.append("                             , VPS.VPS_ETD_DT" ).append("\n"); 
		query.append("                             , VPS.TURN_SKD_VOY_NO" ).append("\n"); 
		query.append("                             , VPS.TURN_SKD_DIR_CD" ).append("\n"); 
		query.append("                             , VPS.TURN_CLPT_IND_SEQ " ).append("\n"); 
		query.append("                             , VPS.IB_CSSM_VOY_NO" ).append("\n"); 
		query.append("                             , VPS.OB_CSSM_VOY_NO" ).append("\n"); 
		query.append("                          FROM VSK_VSL_SKD VSL" ).append("\n"); 
		query.append("                             , MDM_VSL_CNTR MVL" ).append("\n"); 
		query.append("                             , VSK_VSL_PORT_SKD VPS" ).append("\n"); 
		query.append("                             , MDM_VSL_SVC_LANE_DIR MVS" ).append("\n"); 
		query.append("                             , V_LVL_VVD VVD" ).append("\n"); 
		query.append("                         WHERE 1=1" ).append("\n"); 
		query.append("                           AND VVD.DIR_TP = 'NOW'" ).append("\n"); 
		query.append("                           AND VPS.VSL_CD = VVD.VSL_CD" ).append("\n"); 
		query.append("                           AND VPS.SKD_VOY_NO = VVD.SKD_VOY_NO" ).append("\n"); 
		query.append("                           --AND VPS.SKD_DIR_CD = SVV.SKD_DIR_CD" ).append("\n"); 
		query.append("                           AND VSL.VSL_CD = MVL.VSL_CD" ).append("\n"); 
		query.append("                           AND VSL.VSL_CD = VPS.VSL_CD" ).append("\n"); 
		query.append("                           AND VSL.SKD_VOY_NO = VPS.SKD_VOY_NO" ).append("\n"); 
		query.append("                           AND VSL.SKD_DIR_CD = VPS.SKD_DIR_CD" ).append("\n"); 
		query.append("                           AND (VPS.TURN_PORT_IND_CD IS NULL OR VPS.TURN_PORT_IND_CD NOT IN ('D', 'V', 'F'))" ).append("\n"); 
		query.append("                           AND (VPS.SKD_CNG_STS_CD IS NULL   OR VPS.SKD_CNG_STS_CD != 'S')" ).append("\n"); 
		query.append("                           AND NVL(VPS.VT_ADD_CALL_FLG, 'N') = 'N' /*2015.07.21 Add*/" ).append("\n"); 
		query.append("                           AND VSL.VSL_SLAN_CD = MVS.VSL_SLAN_CD" ).append("\n"); 
		query.append("                           AND VSL.SKD_DIR_CD = MVS.VSL_SLAN_DIR_CD" ).append("\n"); 
		query.append("                         ORDER BY MVS.VSL_SLAN_DIR_SEQ, VPS.CLPT_SEQ ) VPS" ).append("\n"); 
		query.append("              ) A" ).append("\n"); 
		query.append("ORDER BY A.ORD" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("/*TEST V_PORT Checked.*/" ).append("\n"); 
		query.append("--SELECT * FROM V_PORT_LIST_TMP; -- 42" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(",V_TP AS (" ).append("\n"); 
		query.append("    SELECT 'D' AS TP, 1 AS TP_ORD FROM DUAL" ).append("\n"); 
		query.append("     UNION ALL" ).append("\n"); 
		query.append("    SELECT 'L' AS TP, 2 AS TP_ORD FROM DUAL" ).append("\n"); 
		query.append("     UNION ALL" ).append("\n"); 
		query.append("    SELECT 'B' AS TP, 3 AS TP_ORD FROM DUAL " ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(",V_PORT_LIST AS(" ).append("\n"); 
		query.append("/*조회 조건 이전/현재/이후 항차의 Port 조회*/" ).append("\n"); 
		query.append("SELECT A.*" ).append("\n"); 
		query.append("     , B.TP" ).append("\n"); 
		query.append("     , B.TP_ORD" ).append("\n"); 
		query.append("  FROM (SELECT VPS.ORD" ).append("\n"); 
		query.append("             , VPS.SLAN_CD" ).append("\n"); 
		query.append("             , VPS.VSL_CD" ).append("\n"); 
		query.append("             , VPS.SKD_VOY_NO" ).append("\n"); 
		query.append("             , VPS.SKD_DIR_CD" ).append("\n"); 
		query.append("             , VPS.VPS_PORT_CD" ).append("\n"); 
		query.append("             , VPS.CLPT_SEQ" ).append("\n"); 
		query.append("             , VPS.CLPT_IND_SEQ" ).append("\n"); 
		query.append("             , VPS.VPS_ETD_DT" ).append("\n"); 
		query.append("             , VPS.TURN_SKD_VOY_NO" ).append("\n"); 
		query.append("             , VPS.TURN_SKD_DIR_CD" ).append("\n"); 
		query.append("             , VPS.TURN_CLPT_IND_SEQ" ).append("\n"); 
		query.append("             , VPS.LAG_VVD" ).append("\n"); 
		query.append("             , VPS.LAG_VPS_PORT_CD" ).append("\n"); 
		query.append("             , VPS.LAG_CLPT_IND_SEQ" ).append("\n"); 
		query.append("             , VPS.IB_CSSM_VOY_NO" ).append("\n"); 
		query.append("             , VPS.OB_CSSM_VOY_NO" ).append("\n"); 
		query.append("             , C.RLANE_CD" ).append("\n"); 
		query.append("             , D.TRD_CD" ).append("\n"); 
		query.append("          FROM (SELECT S1.*" ).append("\n"); 
		query.append("                     , L1.CONTI_CD" ).append("\n"); 
		query.append("                     , LEAD(CONTI_CD) OVER (PARTITION BY S1.VSL_CD,S1.SKD_VOY_NO,S1.SKD_DIR_CD ORDER BY S1.CLPT_SEQ) LEAD_CONTI_CD" ).append("\n"); 
		query.append("                  FROM V_PORT_LIST_TMP S1" ).append("\n"); 
		query.append("                     , MDM_LOCATION L1" ).append("\n"); 
		query.append("                 WHERE 1=1" ).append("\n"); 
		query.append("                   AND S1.VPS_PORT_CD = L1.LOC_CD" ).append("\n"); 
		query.append("                 ORDER BY S1.ORD " ).append("\n"); 
		query.append("               ) VPS" ).append("\n"); 
		query.append("             , MDM_LOCATION F" ).append("\n"); 
		query.append("             , MDM_REV_LANE C" ).append("\n"); 
		query.append("             , MDM_DTL_REV_LANE D" ).append("\n"); 
		query.append("         WHERE VPS.VPS_PORT_CD = F.LOC_CD" ).append("\n"); 
		query.append("           AND VPS.CONTI_CD = F.CONTI_CD" ).append("\n"); 
		query.append("           AND VPS.CONTI_CD = D.FM_CONTI_CD" ).append("\n"); 
		query.append("           AND NVL(LEAD_CONTI_CD, VPS.CONTI_CD) = D.TO_CONTI_CD" ).append("\n"); 
		query.append("           AND C.VSL_SLAN_CD = VPS.SLAN_CD" ).append("\n"); 
		query.append("           AND C.RLANE_CD = D.RLANE_CD" ).append("\n"); 
		query.append("           AND D.VSL_SLAN_DIR_CD = NVL(VPS.SKD_DIR_CD, D.VSL_SLAN_DIR_CD)" ).append("\n"); 
		query.append("           AND D.DELT_FLG = 'N' " ).append("\n"); 
		query.append("       ) A" ).append("\n"); 
		query.append("     , V_TP B" ).append("\n"); 
		query.append(" ORDER BY A.ORD, B.TP_ORD" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("/*TEST V_PORT_LIST Checked.*/" ).append("\n"); 
		query.append("--SELECT * FROM V_PORT_LIST; -- 42" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("/*TP/SZ Normal(OPUS), Laden TP/SZ, Empty TP/SZ, RF TP/SZ */" ).append("\n"); 
		query.append(",V_COM_TOT_SZ_TP AS(" ).append("\n"); 
		query.append("        SELECT CNTR_TP_CD" ).append("\n"); 
		query.append("             , NMR_CNTR_TPSZ_CD" ).append("\n"); 
		query.append("             , CNTR_TPSZ_CD" ).append("\n"); 
		query.append("             , RAD_CNTR_TPSZ_CD" ).append("\n"); 
		query.append("             , DP_SEQ" ).append("\n"); 
		query.append("          FROM (SELECT DISTINCT '0' AS ORD" ).append("\n"); 
		query.append("                     , 'F' AS CNTR_TP_CD" ).append("\n"); 
		query.append("                     , ATTR_CTNT1 AS NMR_CNTR_TPSZ_CD" ).append("\n"); 
		query.append("                     , ATTR_CTNT2 AS CNTR_TPSZ_CD" ).append("\n"); 
		query.append("                     , ATTR_CTNT3 AS RAD_CNTR_TPSZ_CD" ).append("\n"); 
		query.append("                     , MIN(LINE_SEQ) OVER (PARTITION BY ATTR_CTNT2) AS DP_SEQ" ).append("\n"); 
		query.append("                  FROM JOO_COM_PPT" ).append("\n"); 
		query.append("                 WHERE 1=1" ).append("\n"); 
		query.append("                   AND PPT_CD = 'TPSZ MAP'" ).append("\n"); 
		query.append("                   AND ATTR_CTNT2 IS NOT NULL" ).append("\n"); 
		query.append("                 UNION ALL" ).append("\n"); 
		query.append("                SELECT DISTINCT '1' AS ORD" ).append("\n"); 
		query.append("                     , 'E' AS CNTR_TP_CD" ).append("\n"); 
		query.append("                     , ATTR_CTNT1 AS NMR_CNTR_TPSZ_CD" ).append("\n"); 
		query.append("                     , ATTR_CTNT4 AS CNTR_TPSZ_CD" ).append("\n"); 
		query.append("                     , ATTR_CTNT3 AS RAD_CNTR_TPSZ_CD" ).append("\n"); 
		query.append("                     , MIN(LINE_SEQ) OVER (PARTITION BY ATTR_CTNT4) AS DP_SEQ" ).append("\n"); 
		query.append("                  FROM JOO_COM_PPT" ).append("\n"); 
		query.append("                 WHERE 1=1" ).append("\n"); 
		query.append("                   AND PPT_CD = 'TPSZ MAP'" ).append("\n"); 
		query.append("                   AND ATTR_CTNT4 IS NOT NULL )" ).append("\n"); 
		query.append("         ORDER BY ORD, DP_SEQ" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("/*TEST V_COM_SZ_TP*/" ).append("\n"); 
		query.append("--SELECT * FROM V_COM_TOT_SZ_TP;" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(",V_COM_TEU AS(" ).append("\n"); 
		query.append("        SELECT DISTINCT DFT.CNTR_TP_CD" ).append("\n"); 
		query.append("             , DFT.SLAN_CD" ).append("\n"); 
		query.append("             , DFT.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("             , TEU.RAD_CNTR_TPSZ_CD" ).append("\n"); 
		query.append("             , NVL(TEU.TEU, DFT.TEU) AS TEU" ).append("\n"); 
		query.append("          FROM ( SELECT VP.SLAN_CD" ).append("\n"); 
		query.append("                      , DFT.ATTR_CTNT1 AS CNTR_TP_CD" ).append("\n"); 
		query.append("                      , DFT.ATTR_CTNT2 AS CNTR_TPSZ_CD" ).append("\n"); 
		query.append("                      , DFT.ATTR_CTNT3 AS TEU" ).append("\n"); 
		query.append("                      , DFT.ATTR_CTNT4 AS RF_PLUG_FLG " ).append("\n"); 
		query.append("                      , DFT.LINE_SEQ   AS DP_SEQ" ).append("\n"); 
		query.append("                   FROM JOO_COM_PPT DFT" ).append("\n"); 
		query.append("                      , (SELECT DISTINCT SLAN_CD FROM V_PORT_LIST) VP" ).append("\n"); 
		query.append("                  WHERE DFT.PPT_CD       = 'DEFAULT TPSZ'" ).append("\n"); 
		query.append("                    AND DFT.ATTR_CTNT1   IN ('F','E')" ).append("\n"); 
		query.append("               ) DFT" ).append("\n"); 
		query.append("              ,(" ).append("\n"); 
		query.append("                SELECT SZ.CNTR_TP_CD" ).append("\n"); 
		query.append("                     , COM.SLAN_CD" ).append("\n"); 
		query.append("                     , COM.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("                     , SZ.RAD_CNTR_TPSZ_CD" ).append("\n"); 
		query.append("                     , COM.TEU" ).append("\n"); 
		query.append("                     , SZ.NMR_CNTR_TPSZ_CD" ).append("\n"); 
		query.append("                     , SZ.DP_SEQ" ).append("\n"); 
		query.append("                  FROM (" ).append("\n"); 
		query.append("                        SELECT DISTINCT ATTR_CTNT1 AS SLAN_CD" ).append("\n"); 
		query.append("                             , ATTR_CTNT2 AS CNTR_TPSZ_CD" ).append("\n"); 
		query.append("                             , ATTR_CTNT3 AS TEU" ).append("\n"); 
		query.append("                          FROM JOO_COM_PPT COM" ).append("\n"); 
		query.append("                             , (SELECT DISTINCT SLAN_CD FROM V_PORT_LIST ) VP" ).append("\n"); 
		query.append("                         WHERE 1=1" ).append("\n"); 
		query.append("                           AND COM.PPT_CD = 'TEU CONVERSION'" ).append("\n"); 
		query.append("                           AND COM.ATTR_CTNT2 IS NOT NULL     " ).append("\n"); 
		query.append("                           AND COM.ATTR_CTNT1 = VP.SLAN_CD" ).append("\n"); 
		query.append("                       ) COM" ).append("\n"); 
		query.append("                     , V_COM_TOT_SZ_TP SZ" ).append("\n"); 
		query.append("                 WHERE 1=1" ).append("\n"); 
		query.append("                   AND COM.CNTR_TPSZ_CD = SZ.CNTR_TPSZ_CD " ).append("\n"); 
		query.append("                   AND SZ.CNTR_TP_CD IN ('F','E') " ).append("\n"); 
		query.append("               ) TEU" ).append("\n"); 
		query.append("         WHERE 1=1" ).append("\n"); 
		query.append("           AND DFT.CNTR_TP_CD   = TEU.CNTR_TP_CD    (+)" ).append("\n"); 
		query.append("           AND DFT.CNTR_TPSZ_CD = TEU.CNTR_TPSZ_CD  (+)" ).append("\n"); 
		query.append("           AND DFT.SLAN_CD      = TEU.SLAN_CD       (+)" ).append("\n"); 
		query.append("         ORDER BY DFT.CNTR_TP_CD, DFT.SLAN_CD" ).append("\n"); 
		query.append("    ) " ).append("\n"); 
		query.append("/*TEST V_COM_TEU*/" ).append("\n"); 
		query.append("--SELECT * FROM V_COM_TEU;" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(",V_COM_VOID AS(" ).append("\n"); 
		query.append("        SELECT SLAN_CD" ).append("\n"); 
		query.append("             , OR_FLG" ).append("\n"); 
		query.append("             , OL_FLG" ).append("\n"); 
		query.append("             , OH_FLG" ).append("\n"); 
		query.append("             , VOID_CNT" ).append("\n"); 
		query.append("          FROM (SELECT LINE_SEQ AS DP_SEQ" ).append("\n"); 
		query.append("                     , ATTR_CTNT1 AS SLAN_CD" ).append("\n"); 
		query.append("                     , ATTR_CTNT2 AS OR_FLG" ).append("\n"); 
		query.append("                     , ATTR_CTNT3 AS OL_FLG" ).append("\n"); 
		query.append("                     , ATTR_CTNT4 AS OH_FLG" ).append("\n"); 
		query.append("                     , ATTR_CTNT5 AS VOID_CNT" ).append("\n"); 
		query.append("                  FROM JOO_COM_PPT COM" ).append("\n"); 
		query.append("                 WHERE 1=1" ).append("\n"); 
		query.append("                   AND COM.PPT_CD = 'VOID CONVERSION'" ).append("\n"); 
		query.append("                   AND COM.ATTR_CTNT5 IS NOT NULL" ).append("\n"); 
		query.append("               )" ).append("\n"); 
		query.append("         ORDER BY SLAN_CD, DP_SEQ" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("/*TEST V_COM_TEU*/" ).append("\n"); 
		query.append("--SELECT * FROM V_COM_VOID;" ).append("\n"); 
		query.append("SELECT P.ORD" ).append("\n"); 
		query.append("     , P.VSL_CD" ).append("\n"); 
		query.append("     , P.SKD_VOY_NO||P.SKD_DIR_CD AS SKD_VOY_NO" ).append("\n"); 
		query.append("     , P.IB_CSSM_VOY_NO" ).append("\n"); 
		query.append("     , P.OB_CSSM_VOY_NO" ).append("\n"); 
		query.append("     , P.VPS_PORT_CD" ).append("\n"); 
		query.append("     , P.CLPT_SEQ" ).append("\n"); 
		query.append("     , P.CLPT_IND_SEQ" ).append("\n"); 
		query.append("     , P.TYPE" ).append("\n"); 
		query.append("     , P.TP_ORD" ).append("\n"); 
		query.append("     , NVL(P.VOID_QTY, 0) AS VOID_QTY" ).append("\n"); 
		query.append("     , NVL(P.WEIGHT, 0) AS WEIGHT" ).append("\n"); 
		query.append("     , NVL(P.TOTAL , 0) AS TOTAL" ).append("\n"); 
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
		query.append("     , NVL(SUM_TOTAL_TEU, 0) AS SUM_TOTAL_TEU" ).append("\n"); 
		query.append("     , NVL(SUM_LDN_TEU, 0) AS SUM_LDN_TEU " ).append("\n"); 
		query.append("     , NVL(SUM_ETY_TEU, 0) AS SUM_ETY_TEU" ).append("\n"); 
		query.append("     , NVL(SUM_WGT_TON, 0) AS SUM_WGT_TON" ).append("\n"); 
		query.append("     , NVL(SUM_WGT_TEU, 0) AS SUM_WGT_TEU" ).append("\n"); 
		query.append("     , NVL(SUM_TEU_BY_WGT, 0) AS SUM_TEU_BY_WGT" ).append("\n"); 
		query.append("     , NVL(SUM_RF_PLUG, 0) AS SUM_RF_PLUG" ).append("\n"); 
		query.append("     , NVL(ALLOC_SLOT, 0) AS ALLOC_SLOT" ).append("\n"); 
		query.append("     , NVL(ALLOC_RF, 0) AS ALLOC_RF" ).append("\n"); 
		query.append("     , NVL(OPTION_A, 'OPTION1') AS OPTION_A" ).append("\n"); 
		query.append("     , NVL(OPTION_B, 'OPTION1') AS OPTION_B " ).append("\n"); 
		query.append("       /*EXC_TEU_TOTAL :(Summary by Port (Total TEU) - Allocation (Slot)) > 0 */   " ).append("\n"); 
		query.append("     , CASE WHEN OPTION_A = 'OPTION1' THEN CEIL ( EXC_TEU_TOTAL * 10) / 10 -- ROUND( EXC_TEU_TOTAL , 1)" ).append("\n"); 
		query.append("            WHEN OPTION_A = 'OPTION2' THEN ROUND( EXC_TEU_TOTAL , 2)" ).append("\n"); 
		query.append("            WHEN OPTION_A = 'OPTION3' THEN TRUNC( EXC_TEU_TOTAL , 1)" ).append("\n"); 
		query.append("            WHEN OPTION_A = 'OPTION4' THEN TRUNC( EXC_TEU_TOTAL , 2)" ).append("\n"); 
		query.append("            ELSE 0" ).append("\n"); 
		query.append("       END AS EXC_TEU_TOTAL" ).append("\n"); 
		query.append("       /*EXC_TEU_LDN : EXC_TEU_TOTAL - EXC_TEU_ETY*/" ).append("\n"); 
		query.append("     , CASE WHEN OPTION_A = 'OPTION1' THEN CEIL ( (EXC_TEU_TOTAL - EXC_TEU_ETY) * 10) / 10 --ROUND( EXC_TEU_TOTAL - EXC_TEU_ETY , 1)" ).append("\n"); 
		query.append("            WHEN OPTION_A = 'OPTION2' THEN ROUND( EXC_TEU_TOTAL - EXC_TEU_ETY , 2)" ).append("\n"); 
		query.append("            WHEN OPTION_A = 'OPTION3' THEN TRUNC( EXC_TEU_TOTAL - EXC_TEU_ETY , 1)" ).append("\n"); 
		query.append("            WHEN OPTION_A = 'OPTION4' THEN TRUNC( EXC_TEU_TOTAL - EXC_TEU_ETY , 2)" ).append("\n"); 
		query.append("            ELSE 0" ).append("\n"); 
		query.append("       END AS EXC_TEU_LDN" ).append("\n"); 
		query.append("       /*EXC_TEU_ETY : Excess TEU(Total) - Excess TEU(Empty)*/" ).append("\n"); 
		query.append("     , CASE WHEN OPTION_A = 'OPTION1' THEN CEIL ( EXC_TEU_ETY * 10) / 10 -- ROUND( EXC_TEU_ETY , 1)" ).append("\n"); 
		query.append("            WHEN OPTION_A = 'OPTION2' THEN ROUND( EXC_TEU_ETY , 2)" ).append("\n"); 
		query.append("            WHEN OPTION_A = 'OPTION3' THEN TRUNC( EXC_TEU_ETY , 1)" ).append("\n"); 
		query.append("            WHEN OPTION_A = 'OPTION4' THEN TRUNC( EXC_TEU_ETY , 2)" ).append("\n"); 
		query.append("            ELSE 0" ).append("\n"); 
		query.append("       END AS EXC_TEU_ETY" ).append("\n"); 
		query.append("       /*EXC_DWT_TEU :(Summary by Port(TEU by Wgt) - Allocation(Slot)) > 0*/" ).append("\n"); 
		query.append("     , CASE WHEN OPTION_A = 'OPTION1' THEN CEIL ( EXC_DWT_TEU * 10) / 10 -- ROUND( EXC_DWT_TEU , 1)" ).append("\n"); 
		query.append("            WHEN OPTION_A = 'OPTION2' THEN ROUND( EXC_DWT_TEU , 2)" ).append("\n"); 
		query.append("            WHEN OPTION_A = 'OPTION3' THEN TRUNC( EXC_DWT_TEU , 1)" ).append("\n"); 
		query.append("            WHEN OPTION_A = 'OPTION4' THEN TRUNC( EXC_DWT_TEU , 2)" ).append("\n"); 
		query.append("            ELSE 0" ).append("\n"); 
		query.append("       END AS EXC_DWT_TEU" ).append("\n"); 
		query.append("       /*EXC_DWT_RF : (Summary by Port (RF Pulg) - Allocation(RF) - Buy&Sell(RF : Default 0) ) > 0*/" ).append("\n"); 
		query.append("     , CASE WHEN OPTION_A = 'OPTION1' THEN CEIL ( EXC_DWT_RF * 10) / 10 -- ROUND( EXC_DWT_RF , 1)" ).append("\n"); 
		query.append("            WHEN OPTION_A = 'OPTION2' THEN ROUND( EXC_DWT_RF , 2)" ).append("\n"); 
		query.append("            WHEN OPTION_A = 'OPTION3' THEN TRUNC( EXC_DWT_RF , 1)" ).append("\n"); 
		query.append("            WHEN OPTION_A = 'OPTION4' THEN TRUNC( EXC_DWT_RF , 2)" ).append("\n"); 
		query.append("            ELSE 0" ).append("\n"); 
		query.append("       END AS EXC_DWT_RF                                       " ).append("\n"); 
		query.append("     /* Price(Slot):0, Price(Plug):0, Buy&Sell(Slot):0, Buy&Sell(RF):0*/" ).append("\n"); 
		query.append("     , (CASE WHEN EXC_TEU_TOTAL > EXC_DWT_TEU THEN  ((EXC_TEU_TOTAL - EXC_TEU_ETY) * PRI_SLOT ) /*(EXC_TEU_TOTAL - EXC_TEU_ETY) * Price(Slot) */ + " ).append("\n"); 
		query.append("                                                   + (EXC_TEU_ETY * (PRI_SLOT/2)) /*EXC_TEU_ETY * (Price(Slot) / 2) */" ).append("\n"); 
		query.append("             ELSE EXC_DWT_TEU * PRI_SLOT /*EXC_DWT_TEU * Price(Slot)*/" ).append("\n"); 
		query.append("        END) + (BS_SLOT * PRI_SLOT) AS AMT_BUY_EXC_SLOTS" ).append("\n"); 
		query.append("     , (SUM_RF_PLUG + EXC_DWT_RF + BS_RF) * PRI_PLUG AS AMT_USED_PLUGS" ).append("\n"); 
		query.append("  FROM (" ).append("\n"); 
		query.append("        SELECT P.ORD" ).append("\n"); 
		query.append("             , P.VSL_CD" ).append("\n"); 
		query.append("             , P.SKD_VOY_NO" ).append("\n"); 
		query.append("             , P.SKD_DIR_CD" ).append("\n"); 
		query.append("             , P.IB_CSSM_VOY_NO" ).append("\n"); 
		query.append("             , P.OB_CSSM_VOY_NO" ).append("\n"); 
		query.append("             , P.VPS_PORT_CD" ).append("\n"); 
		query.append("             , P.CLPT_SEQ" ).append("\n"); 
		query.append("             , P.CLPT_IND_SEQ" ).append("\n"); 
		query.append("             , DECODE(P.TP,'D','Discharge','L','Load','B','Balance') AS TYPE" ).append("\n"); 
		query.append("             , P.TP_ORD" ).append("\n"); 
		query.append("             , NVL(V.VOID, 0) AS VOID_QTY" ).append("\n"); 
		query.append("             , NVL(L.WEIGHT, 0) AS WEIGHT" ).append("\n"); 
		query.append("             , NVL(L.TOTAL , 0) AS TOTAL" ).append("\n"); 
		query.append("             , NVL(F_QTY1 , 0) AS F_QTY1" ).append("\n"); 
		query.append("             , NVL(F_QTY2 , 0) AS F_QTY2" ).append("\n"); 
		query.append("             , NVL(F_QTY3 , 0) AS F_QTY3" ).append("\n"); 
		query.append("             , NVL(F_QTY4 , 0) AS F_QTY4" ).append("\n"); 
		query.append("             , NVL(F_QTY5 , 0) AS F_QTY5" ).append("\n"); 
		query.append("             , NVL(F_QTY6 , 0) AS F_QTY6" ).append("\n"); 
		query.append("             , NVL(F_QTY7 , 0) AS F_QTY7" ).append("\n"); 
		query.append("             , NVL(F_QTY8 , 0) AS F_QTY8" ).append("\n"); 
		query.append("             , NVL(F_QTY9 , 0) AS F_QTY9" ).append("\n"); 
		query.append("             , NVL(F_QTY10 , 0) AS F_QTY10" ).append("\n"); 
		query.append("             , NVL(F_QTY11 , 0) AS F_QTY11" ).append("\n"); 
		query.append("             , NVL(F_QTY12 , 0) AS F_QTY12" ).append("\n"); 
		query.append("             , NVL(F_QTY13 , 0) AS F_QTY13" ).append("\n"); 
		query.append("             , NVL(F_QTY14 , 0) AS F_QTY14" ).append("\n"); 
		query.append("             , NVL(F_QTY15 , 0) AS F_QTY15" ).append("\n"); 
		query.append("             , NVL(F_QTY16 , 0) AS F_QTY16" ).append("\n"); 
		query.append("             , NVL(F_QTY17 , 0) AS F_QTY17" ).append("\n"); 
		query.append("             , NVL(F_QTY18 , 0) AS F_QTY18" ).append("\n"); 
		query.append("             , NVL(F_QTY19 , 0) AS F_QTY19" ).append("\n"); 
		query.append("             , NVL(F_QTY20 , 0) AS F_QTY20" ).append("\n"); 
		query.append("             , NVL(F_QTY21 , 0) AS F_QTY21" ).append("\n"); 
		query.append("             , NVL(F_QTY22 , 0) AS F_QTY22" ).append("\n"); 
		query.append("             , NVL(F_QTY23 , 0) AS F_QTY23" ).append("\n"); 
		query.append("             , NVL(F_QTY24 , 0) AS F_QTY24" ).append("\n"); 
		query.append("             , NVL(F_QTY25 , 0) AS F_QTY25" ).append("\n"); 
		query.append("             , NVL(F_QTY26 , 0) AS F_QTY26" ).append("\n"); 
		query.append("             , NVL(F_QTY27 , 0) AS F_QTY27" ).append("\n"); 
		query.append("             , NVL(F_QTY28 , 0) AS F_QTY28" ).append("\n"); 
		query.append("             , NVL(F_QTY29 , 0) AS F_QTY29" ).append("\n"); 
		query.append("             , NVL(F_QTY30 , 0) AS F_QTY30" ).append("\n"); 
		query.append("             , NVL(E_QTY1 , 0) AS E_QTY1" ).append("\n"); 
		query.append("             , NVL(E_QTY2 , 0) AS E_QTY2" ).append("\n"); 
		query.append("             , NVL(E_QTY3 , 0) AS E_QTY3" ).append("\n"); 
		query.append("             , NVL(E_QTY4 , 0) AS E_QTY4" ).append("\n"); 
		query.append("             , NVL(E_QTY5 , 0) AS E_QTY5" ).append("\n"); 
		query.append("             , NVL(E_QTY6 , 0) AS E_QTY6" ).append("\n"); 
		query.append("             , NVL(E_QTY7 , 0) AS E_QTY7" ).append("\n"); 
		query.append("             , NVL(E_QTY8 , 0) AS E_QTY8" ).append("\n"); 
		query.append("             , NVL(E_QTY9 , 0) AS E_QTY9" ).append("\n"); 
		query.append("             , NVL(E_QTY10 , 0) AS E_QTY10" ).append("\n"); 
		query.append("             , NVL(E_QTY11 , 0) AS E_QTY11" ).append("\n"); 
		query.append("             , NVL(E_QTY12 , 0) AS E_QTY12" ).append("\n"); 
		query.append("             , NVL(E_QTY13 , 0) AS E_QTY13" ).append("\n"); 
		query.append("             , NVL(E_QTY14 , 0) AS E_QTY14" ).append("\n"); 
		query.append("             , NVL(E_QTY15 , 0) AS E_QTY15" ).append("\n"); 
		query.append("             , NVL(E_QTY16 , 0) AS E_QTY16" ).append("\n"); 
		query.append("             , NVL(E_QTY17 , 0) AS E_QTY17" ).append("\n"); 
		query.append("             , NVL(E_QTY18 , 0) AS E_QTY18" ).append("\n"); 
		query.append("             , NVL(E_QTY19 , 0) AS E_QTY19" ).append("\n"); 
		query.append("             , NVL(E_QTY20 , 0) AS E_QTY20" ).append("\n"); 
		query.append("             , NVL(E_QTY21 , 0) AS E_QTY21" ).append("\n"); 
		query.append("             , NVL(E_QTY22 , 0) AS E_QTY22" ).append("\n"); 
		query.append("             , NVL(E_QTY23 , 0) AS E_QTY23" ).append("\n"); 
		query.append("             , NVL(E_QTY24 , 0) AS E_QTY24" ).append("\n"); 
		query.append("             , NVL(E_QTY25 , 0) AS E_QTY25" ).append("\n"); 
		query.append("             , NVL(E_QTY26 , 0) AS E_QTY26" ).append("\n"); 
		query.append("             , NVL(E_QTY27 , 0) AS E_QTY27" ).append("\n"); 
		query.append("             , NVL(E_QTY28 , 0) AS E_QTY28" ).append("\n"); 
		query.append("             , NVL(E_QTY29 , 0) AS E_QTY29" ).append("\n"); 
		query.append("             , NVL(E_QTY30 , 0) AS E_QTY30" ).append("\n"); 
		query.append("             , NVL(S.SUM_TOTAL_TEU, 0) AS SUM_TOTAL_TEU" ).append("\n"); 
		query.append("             , NVL(S.SUM_LDN_TEU, 0) AS SUM_LDN_TEU " ).append("\n"); 
		query.append("             , NVL(S.SUM_ETY_TEU, 0) AS SUM_ETY_TEU" ).append("\n"); 
		query.append("             , NVL(S.SUM_WGT_TON, 0) AS SUM_WGT_TON" ).append("\n"); 
		query.append("             , NVL(S.SUM_WGT_TEU, 0) AS SUM_WGT_TEU" ).append("\n"); 
		query.append("             , NVL(S.SUM_TEU_BY_WGT, 0) AS SUM_TEU_BY_WGT" ).append("\n"); 
		query.append("             , NVL(S.SUM_RF_PLUG, 0) AS SUM_RF_PLUG" ).append("\n"); 
		query.append("             , NVL(S.ALLOC_SLOT, 0) AS ALLOC_SLOT" ).append("\n"); 
		query.append("             , NVL(S.ALLOC_RF, 0) AS ALLOC_RF" ).append("\n"); 
		query.append("             , NVL(S.OPTION_A, 'OPTION1') AS OPTION_A" ).append("\n"); 
		query.append("             , NVL(S.OPTION_B, 'OPTION1') AS OPTION_B" ).append("\n"); 
		query.append("             /*(Summary by Port (Total TEU) - Allocation (Slot)) > 0 */" ).append("\n"); 
		query.append("             , CASE WHEN ( NVL(S.SUM_TOTAL_TEU, 0) - NVL(S.ALLOC_SLOT, 0) ) > 0 THEN NVL(S.SUM_TOTAL_TEU, 0) - NVL(S.ALLOC_SLOT, 0)" ).append("\n"); 
		query.append("                    ELSE 0" ).append("\n"); 
		query.append("               END AS EXC_TEU_TOTAL" ).append("\n"); 
		query.append("             /*(Summary by Port(Total TEU) - Allocation(Slot)) > 0 */  " ).append("\n"); 
		query.append("             , CASE WHEN ( NVL(S.SUM_LDN_TEU, 0) - NVL(S.ALLOC_SLOT, 0) ) > 0 THEN NVL(S.SUM_LDN_TEU, 0) - NVL(S.ALLOC_SLOT, 0)" ).append("\n"); 
		query.append("                    ELSE 0" ).append("\n"); 
		query.append("               END AS EXC_TEU_LDN" ).append("\n"); 
		query.append("               /*Excess TEU(Total) - Excess TEU(Empty)*/" ).append("\n"); 
		query.append("             , CASE WHEN NVL(S.SUM_ETY_TEU, 0) < (NVL(S.SUM_TOTAL_TEU, 0) - NVL(S.ALLOC_SLOT, 0)) THEN NVL(S.SUM_ETY_TEU, 0)" ).append("\n"); 
		query.append("                    ELSE CASE WHEN (NVL(S.SUM_TOTAL_TEU, 0) - NVL(S.ALLOC_SLOT, 0)) > 0 THEN (NVL(S.SUM_TOTAL_TEU, 0) - NVL(S.ALLOC_SLOT, 0))" ).append("\n"); 
		query.append("                              ELSE 0" ).append("\n"); 
		query.append("                         END" ).append("\n"); 
		query.append("               END AS EXC_TEU_ETY" ).append("\n"); 
		query.append("               /*(Summary by Port(TEU by Wgt) - Allocation(Slot)) > 0*/" ).append("\n"); 
		query.append("             , CASE WHEN (NVL(S.SUM_TEU_BY_WGT, 0) - NVL(S.ALLOC_SLOT, 0)) > 0 THEN (NVL(S.SUM_TEU_BY_WGT, 0) - NVL(S.ALLOC_SLOT, 0))" ).append("\n"); 
		query.append("                    ELSE 0" ).append("\n"); 
		query.append("               END AS EXC_DWT_TEU " ).append("\n"); 
		query.append("               /*(Summary by Port (RF Pulg) - Allocation(RF) - Buy&Sell(RF : Default 0) ) > 0*/" ).append("\n"); 
		query.append("             , CASE WHEN (NVL(S.SUM_RF_PLUG, 0) - NVL(S.ALLOC_RF, 0) - 0 ) > 0 THEN (NVL(S.SUM_RF_PLUG, 0) - NVL(S.ALLOC_RF, 0) - 0 )" ).append("\n"); 
		query.append("                    ELSE 0" ).append("\n"); 
		query.append("               END AS EXC_DWT_RF" ).append("\n"); 
		query.append("             , 0 AS BS_SLOT" ).append("\n"); 
		query.append("             , 0 AS BS_RF" ).append("\n"); 
		query.append("             , 0 AS PRI_SLOT" ).append("\n"); 
		query.append("             , 0 AS PRI_PLUG" ).append("\n"); 
		query.append("          FROM V_PORT_LIST P" ).append("\n"); 
		query.append("             , (" ).append("\n"); 
		query.append("                 /*1.Discharge*/" ).append("\n"); 
		query.append("                SELECT A.VSL_CD" ).append("\n"); 
		query.append("                     , A.VOY_NO" ).append("\n"); 
		query.append("                     , A.DIR_CD" ).append("\n"); 
		query.append("                     , A.PORT_CD" ).append("\n"); 
		query.append("                     , A.TYPE" ).append("\n"); 
		query.append("                     , SUM(A.WEIGHT) AS WEIGHT" ).append("\n"); 
		query.append("                     , NVL(SUM(A.CNT),0) AS TOTAL" ).append("\n"); 
		query.append("					 , SUM(DECODE(A.CNTR_TPSZ_CD,@[laden_tpsz_cd1]  ,A.CNT,0)) F_QTY1" ).append("\n"); 
		query.append("					 , SUM(DECODE(A.CNTR_TPSZ_CD,@[laden_tpsz_cd2]  ,A.CNT,0)) F_QTY2" ).append("\n"); 
		query.append("					 , SUM(DECODE(A.CNTR_TPSZ_CD,@[laden_tpsz_cd3]  ,A.CNT,0)) F_QTY3" ).append("\n"); 
		query.append("					 , SUM(DECODE(A.CNTR_TPSZ_CD,@[laden_tpsz_cd4]  ,A.CNT,0)) F_QTY4" ).append("\n"); 
		query.append("					 , SUM(DECODE(A.CNTR_TPSZ_CD,@[laden_tpsz_cd5]  ,A.CNT,0)) F_QTY5" ).append("\n"); 
		query.append("					 , SUM(DECODE(A.CNTR_TPSZ_CD,@[laden_tpsz_cd6]  ,A.CNT,0)) F_QTY6" ).append("\n"); 
		query.append("					 , SUM(DECODE(A.CNTR_TPSZ_CD,@[laden_tpsz_cd7]  ,A.CNT,0)) F_QTY7" ).append("\n"); 
		query.append("					 , SUM(DECODE(A.CNTR_TPSZ_CD,@[laden_tpsz_cd8]  ,A.CNT,0)) F_QTY8" ).append("\n"); 
		query.append("					 , SUM(DECODE(A.CNTR_TPSZ_CD,@[laden_tpsz_cd9]  ,A.CNT,0)) F_QTY9" ).append("\n"); 
		query.append("					 , SUM(DECODE(A.CNTR_TPSZ_CD,@[laden_tpsz_cd10] ,A.CNT,0)) F_QTY10" ).append("\n"); 
		query.append("					 , SUM(DECODE(A.CNTR_TPSZ_CD,@[laden_tpsz_cd11] ,A.CNT,0)) F_QTY11" ).append("\n"); 
		query.append("					 , SUM(DECODE(A.CNTR_TPSZ_CD,@[laden_tpsz_cd12] ,A.CNT,0)) F_QTY12" ).append("\n"); 
		query.append("					 , SUM(DECODE(A.CNTR_TPSZ_CD,@[laden_tpsz_cd13] ,A.CNT,0)) F_QTY13" ).append("\n"); 
		query.append("					 , SUM(DECODE(A.CNTR_TPSZ_CD,@[laden_tpsz_cd14] ,A.CNT,0)) F_QTY14" ).append("\n"); 
		query.append("					 , SUM(DECODE(A.CNTR_TPSZ_CD,@[laden_tpsz_cd15] ,A.CNT,0)) F_QTY15" ).append("\n"); 
		query.append("					 , SUM(DECODE(A.CNTR_TPSZ_CD,@[laden_tpsz_cd16] ,A.CNT,0)) F_QTY16" ).append("\n"); 
		query.append("					 , SUM(DECODE(A.CNTR_TPSZ_CD,@[laden_tpsz_cd17] ,A.CNT,0)) F_QTY17" ).append("\n"); 
		query.append("					 , SUM(DECODE(A.CNTR_TPSZ_CD,@[laden_tpsz_cd18] ,A.CNT,0)) F_QTY18" ).append("\n"); 
		query.append("					 , SUM(DECODE(A.CNTR_TPSZ_CD,@[laden_tpsz_cd19] ,A.CNT,0)) F_QTY19" ).append("\n"); 
		query.append("					 , SUM(DECODE(A.CNTR_TPSZ_CD,@[laden_tpsz_cd20] ,A.CNT,0)) F_QTY20" ).append("\n"); 
		query.append("					 , SUM(DECODE(A.CNTR_TPSZ_CD,@[laden_tpsz_cd21] ,A.CNT,0)) F_QTY21" ).append("\n"); 
		query.append("					 , SUM(DECODE(A.CNTR_TPSZ_CD,@[laden_tpsz_cd22] ,A.CNT,0)) F_QTY22" ).append("\n"); 
		query.append("					 , SUM(DECODE(A.CNTR_TPSZ_CD,@[laden_tpsz_cd23] ,A.CNT,0)) F_QTY23" ).append("\n"); 
		query.append("					 , SUM(DECODE(A.CNTR_TPSZ_CD,@[laden_tpsz_cd24] ,A.CNT,0)) F_QTY24" ).append("\n"); 
		query.append("					 , SUM(DECODE(A.CNTR_TPSZ_CD,@[laden_tpsz_cd25] ,A.CNT,0)) F_QTY25" ).append("\n"); 
		query.append("					 , SUM(DECODE(A.CNTR_TPSZ_CD,@[laden_tpsz_cd26] ,A.CNT,0)) F_QTY26" ).append("\n"); 
		query.append("					 , SUM(DECODE(A.CNTR_TPSZ_CD,@[laden_tpsz_cd27] ,A.CNT,0)) F_QTY27" ).append("\n"); 
		query.append("					 , SUM(DECODE(A.CNTR_TPSZ_CD,@[laden_tpsz_cd28] ,A.CNT,0)) F_QTY28" ).append("\n"); 
		query.append("					 , SUM(DECODE(A.CNTR_TPSZ_CD,@[laden_tpsz_cd29] ,A.CNT,0)) F_QTY29" ).append("\n"); 
		query.append("					 , SUM(DECODE(A.CNTR_TPSZ_CD,@[laden_tpsz_cd30] ,A.CNT,0)) F_QTY30" ).append("\n"); 
		query.append("					 , SUM(DECODE(A.CNTR_TPSZ_CD,@[empty_tpsz_cd1]  ,A.CNT,0)) E_QTY1" ).append("\n"); 
		query.append("					 , SUM(DECODE(A.CNTR_TPSZ_CD,@[empty_tpsz_cd2]  ,A.CNT,0)) E_QTY2" ).append("\n"); 
		query.append("					 , SUM(DECODE(A.CNTR_TPSZ_CD,@[empty_tpsz_cd3]  ,A.CNT,0)) E_QTY3" ).append("\n"); 
		query.append("					 , SUM(DECODE(A.CNTR_TPSZ_CD,@[empty_tpsz_cd4]  ,A.CNT,0)) E_QTY4" ).append("\n"); 
		query.append("					 , SUM(DECODE(A.CNTR_TPSZ_CD,@[empty_tpsz_cd5]  ,A.CNT,0)) E_QTY5" ).append("\n"); 
		query.append("					 , SUM(DECODE(A.CNTR_TPSZ_CD,@[empty_tpsz_cd6]  ,A.CNT,0)) E_QTY6" ).append("\n"); 
		query.append("					 , SUM(DECODE(A.CNTR_TPSZ_CD,@[empty_tpsz_cd7]  ,A.CNT,0)) E_QTY7" ).append("\n"); 
		query.append("					 , SUM(DECODE(A.CNTR_TPSZ_CD,@[empty_tpsz_cd8]  ,A.CNT,0)) E_QTY8" ).append("\n"); 
		query.append("					 , SUM(DECODE(A.CNTR_TPSZ_CD,@[empty_tpsz_cd9]  ,A.CNT,0)) E_QTY9" ).append("\n"); 
		query.append("					 , SUM(DECODE(A.CNTR_TPSZ_CD,@[empty_tpsz_cd10] ,A.CNT,0)) E_QTY10" ).append("\n"); 
		query.append("					 , SUM(DECODE(A.CNTR_TPSZ_CD,@[empty_tpsz_cd11] ,A.CNT,0)) E_QTY11" ).append("\n"); 
		query.append("					 , SUM(DECODE(A.CNTR_TPSZ_CD,@[empty_tpsz_cd12] ,A.CNT,0)) E_QTY12" ).append("\n"); 
		query.append("					 , SUM(DECODE(A.CNTR_TPSZ_CD,@[empty_tpsz_cd13] ,A.CNT,0)) E_QTY13" ).append("\n"); 
		query.append("					 , SUM(DECODE(A.CNTR_TPSZ_CD,@[empty_tpsz_cd14] ,A.CNT,0)) E_QTY14" ).append("\n"); 
		query.append("					 , SUM(DECODE(A.CNTR_TPSZ_CD,@[empty_tpsz_cd15] ,A.CNT,0)) E_QTY15" ).append("\n"); 
		query.append("					 , SUM(DECODE(A.CNTR_TPSZ_CD,@[empty_tpsz_cd16] ,A.CNT,0)) E_QTY16" ).append("\n"); 
		query.append("					 , SUM(DECODE(A.CNTR_TPSZ_CD,@[empty_tpsz_cd17] ,A.CNT,0)) E_QTY17" ).append("\n"); 
		query.append("					 , SUM(DECODE(A.CNTR_TPSZ_CD,@[empty_tpsz_cd18] ,A.CNT,0)) E_QTY18" ).append("\n"); 
		query.append("					 , SUM(DECODE(A.CNTR_TPSZ_CD,@[empty_tpsz_cd19] ,A.CNT,0)) E_QTY19" ).append("\n"); 
		query.append("					 , SUM(DECODE(A.CNTR_TPSZ_CD,@[empty_tpsz_cd20] ,A.CNT,0)) E_QTY20" ).append("\n"); 
		query.append("					 , SUM(DECODE(A.CNTR_TPSZ_CD,@[empty_tpsz_cd21] ,A.CNT,0)) E_QTY21" ).append("\n"); 
		query.append("					 , SUM(DECODE(A.CNTR_TPSZ_CD,@[empty_tpsz_cd22] ,A.CNT,0)) E_QTY22" ).append("\n"); 
		query.append("					 , SUM(DECODE(A.CNTR_TPSZ_CD,@[empty_tpsz_cd23] ,A.CNT,0)) E_QTY23" ).append("\n"); 
		query.append("					 , SUM(DECODE(A.CNTR_TPSZ_CD,@[empty_tpsz_cd24] ,A.CNT,0)) E_QTY24" ).append("\n"); 
		query.append("					 , SUM(DECODE(A.CNTR_TPSZ_CD,@[empty_tpsz_cd25] ,A.CNT,0)) E_QTY25" ).append("\n"); 
		query.append("					 , SUM(DECODE(A.CNTR_TPSZ_CD,@[empty_tpsz_cd26] ,A.CNT,0)) E_QTY26" ).append("\n"); 
		query.append("					 , SUM(DECODE(A.CNTR_TPSZ_CD,@[empty_tpsz_cd27] ,A.CNT,0)) E_QTY27" ).append("\n"); 
		query.append("					 , SUM(DECODE(A.CNTR_TPSZ_CD,@[empty_tpsz_cd28] ,A.CNT,0)) E_QTY28" ).append("\n"); 
		query.append("					 , SUM(DECODE(A.CNTR_TPSZ_CD,@[empty_tpsz_cd29] ,A.CNT,0)) E_QTY29" ).append("\n"); 
		query.append("					 , SUM(DECODE(A.CNTR_TPSZ_CD,@[empty_tpsz_cd30] ,A.CNT,0)) E_QTY30" ).append("\n"); 
		query.append("                  FROM (" ).append("\n"); 
		query.append("                        SELECT A.TP AS TYPE" ).append("\n"); 
		query.append("                             , A.VSL_CD" ).append("\n"); 
		query.append("                             , A.VOY_NO" ).append("\n"); 
		query.append("                             , A.DIR_CD" ).append("\n"); 
		query.append("                             , A.PORT_CD" ).append("\n"); 
		query.append("                             , A.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("                             , NVL(A.WEIGHT,0) AS WEIGHT" ).append("\n"); 
		query.append("                             , NVL(A.CNT, 0) AS CNT" ).append("\n"); 
		query.append("                          FROM (SELECT BAY.TP" ).append("\n"); 
		query.append("                                     , BAY.VSL_CD" ).append("\n"); 
		query.append("                                     , BAY.VOY_NO AS VOY_NO" ).append("\n"); 
		query.append("                                     , BAY.DIR_CD AS DIR_CD" ).append("\n"); 
		query.append("                                     , BAY.POD AS PORT_CD" ).append("\n"); 
		query.append("                                     , BAY.CNTR_TPSZ_CD AS CNTR_TPSZ_CD" ).append("\n"); 
		query.append("                                     , SUM(BAY.WEIGHT) AS WEIGHT" ).append("\n"); 
		query.append("                                     , COUNT(BAY.CNTR_TPSZ_CD) AS CNT" ).append("\n"); 
		query.append("                                  FROM (SELECT /*+ LEADING(VPS) INDEX(BAY XAK2BAY_PLAN) */ -- TUNING(2016/10/07)" ).append("\n"); 
		query.append("                                               VPS.TP" ).append("\n"); 
		query.append("                                             , VPS.VSL_CD" ).append("\n"); 
		query.append("                                             , VPS.SKD_VOY_NO AS VOY_NO" ).append("\n"); 
		query.append("                                             , VPS.SKD_DIR_CD AS DIR_CD" ).append("\n"); 
		query.append("                                             , BAY.POD" ).append("\n"); 
		query.append("                                             , CASE WHEN BAY.FE = 'F' AND BAY.CNTR_TYPE = 'R' AND BAY.TEMP IS NULL THEN BAY.FE||COM.RAD_CNTR_TPSZ_CD" ).append("\n"); 
		query.append("                                                    ELSE BAY.FE||COM.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("                                               END AS CNTR_TPSZ_CD" ).append("\n"); 
		query.append("                                             , BAY.WEIGHT" ).append("\n"); 
		query.append("                                          FROM V_PORT_LIST      VPS" ).append("\n"); 
		query.append("                                             , BAY_PLAN         BAY" ).append("\n"); 
		query.append("                                             , V_COM_TOT_SZ_TP  COM" ).append("\n"); 
		query.append("                                         WHERE 1=1" ).append("\n"); 
		query.append("                                           AND VPS.TP               = 'D'" ).append("\n"); 
		query.append("                                           AND VPS.ORD              > 0" ).append("\n"); 
		query.append("                                           ---------------- -- TUNING(2016/10/07) ------------" ).append("\n"); 
		query.append("                                           /*AND VPS.LAG_VVD          = BAY.VSL_CD|| BAY.VOY_NO|| BAY.DIR_CD*/" ).append("\n"); 
		query.append("                                           AND SUBSTR(VPS.LAG_VVD, 1, 4) = BAY.VSL_CD" ).append("\n"); 
		query.append("                                           AND SUBSTR(VPS.LAG_VVD, 5, 4) = BAY.VOY_NO" ).append("\n"); 
		query.append("                                           AND SUBSTR(VPS.LAG_VVD, 9, 1) = BAY.DIR_CD" ).append("\n"); 
		query.append("                                           ---------------------------------------------------" ).append("\n"); 
		query.append("                                           AND VPS.LAG_VPS_PORT_CD  = BAY.PORT_CD" ).append("\n"); 
		query.append("                                           AND VPS.LAG_CLPT_IND_SEQ = BAY.CALL_IND" ).append("\n"); 
		query.append("                                           AND VPS.VPS_PORT_CD      = BAY.POD" ).append("\n"); 
		query.append("                                           AND BAY.POL IS NOT NULL" ).append("\n"); 
		query.append("                                           AND BAY.POD IS NOT NULL" ).append("\n"); 
		query.append("				                           AND BAY.OPR_CD 			= @[slan_cd]" ).append("\n"); 
		query.append("                                           AND BAY.FE               IN ('F','E') " ).append("\n"); 
		query.append("                                           --AND BAY.FE               = 'F' -- Full" ).append("\n"); 
		query.append("                                           AND BAY.FE               = COM.CNTR_TP_CD " ).append("\n"); 
		query.append("                                           AND BAY.SZTP             = COM.NMR_CNTR_TPSZ_CD" ).append("\n"); 
		query.append("                                      ) BAY" ).append("\n"); 
		query.append("                                 WHERE 1=1" ).append("\n"); 
		query.append("                                 GROUP BY BAY.TP" ).append("\n"); 
		query.append("                                     , BAY.VSL_CD" ).append("\n"); 
		query.append("                                     , BAY.VOY_NO" ).append("\n"); 
		query.append("                                     , BAY.DIR_CD" ).append("\n"); 
		query.append("                                     , BAY.POD" ).append("\n"); 
		query.append("                                     , BAY.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("                               ) A" ).append("\n"); 
		query.append("                       ) A" ).append("\n"); 
		query.append("                 GROUP BY A.VSL_CD" ).append("\n"); 
		query.append("                     , A.VOY_NO" ).append("\n"); 
		query.append("                     , A.DIR_CD" ).append("\n"); 
		query.append("                     , A.PORT_CD" ).append("\n"); 
		query.append("                     , A.TYPE" ).append("\n"); 
		query.append("                 /*2.Load*/" ).append("\n"); 
		query.append("                 UNION ALL" ).append("\n"); 
		query.append("                SELECT A.VSL_CD" ).append("\n"); 
		query.append("                     , A.VOY_NO" ).append("\n"); 
		query.append("                     , A.DIR_CD" ).append("\n"); 
		query.append("                     , A.PORT_CD" ).append("\n"); 
		query.append("                     , A.TYPE" ).append("\n"); 
		query.append("                     , SUM(A.WEIGHT) AS WEIGHT" ).append("\n"); 
		query.append("                     , NVL(SUM(A.CNT),0) AS TOTAL" ).append("\n"); 
		query.append("					 , SUM(DECODE(A.CNTR_TPSZ_CD,@[laden_tpsz_cd1]  ,A.CNT,0)) F_QTY1" ).append("\n"); 
		query.append("					 , SUM(DECODE(A.CNTR_TPSZ_CD,@[laden_tpsz_cd2]  ,A.CNT,0)) F_QTY2" ).append("\n"); 
		query.append("					 , SUM(DECODE(A.CNTR_TPSZ_CD,@[laden_tpsz_cd3]  ,A.CNT,0)) F_QTY3" ).append("\n"); 
		query.append("					 , SUM(DECODE(A.CNTR_TPSZ_CD,@[laden_tpsz_cd4]  ,A.CNT,0)) F_QTY4" ).append("\n"); 
		query.append("					 , SUM(DECODE(A.CNTR_TPSZ_CD,@[laden_tpsz_cd5]  ,A.CNT,0)) F_QTY5" ).append("\n"); 
		query.append("					 , SUM(DECODE(A.CNTR_TPSZ_CD,@[laden_tpsz_cd6]  ,A.CNT,0)) F_QTY6" ).append("\n"); 
		query.append("					 , SUM(DECODE(A.CNTR_TPSZ_CD,@[laden_tpsz_cd7]  ,A.CNT,0)) F_QTY7" ).append("\n"); 
		query.append("					 , SUM(DECODE(A.CNTR_TPSZ_CD,@[laden_tpsz_cd8]  ,A.CNT,0)) F_QTY8" ).append("\n"); 
		query.append("					 , SUM(DECODE(A.CNTR_TPSZ_CD,@[laden_tpsz_cd9]  ,A.CNT,0)) F_QTY9" ).append("\n"); 
		query.append("					 , SUM(DECODE(A.CNTR_TPSZ_CD,@[laden_tpsz_cd10] ,A.CNT,0)) F_QTY10" ).append("\n"); 
		query.append("					 , SUM(DECODE(A.CNTR_TPSZ_CD,@[laden_tpsz_cd11] ,A.CNT,0)) F_QTY11" ).append("\n"); 
		query.append("					 , SUM(DECODE(A.CNTR_TPSZ_CD,@[laden_tpsz_cd12] ,A.CNT,0)) F_QTY12" ).append("\n"); 
		query.append("					 , SUM(DECODE(A.CNTR_TPSZ_CD,@[laden_tpsz_cd13] ,A.CNT,0)) F_QTY13" ).append("\n"); 
		query.append("					 , SUM(DECODE(A.CNTR_TPSZ_CD,@[laden_tpsz_cd14] ,A.CNT,0)) F_QTY14" ).append("\n"); 
		query.append("					 , SUM(DECODE(A.CNTR_TPSZ_CD,@[laden_tpsz_cd15] ,A.CNT,0)) F_QTY15" ).append("\n"); 
		query.append("					 , SUM(DECODE(A.CNTR_TPSZ_CD,@[laden_tpsz_cd16] ,A.CNT,0)) F_QTY16" ).append("\n"); 
		query.append("					 , SUM(DECODE(A.CNTR_TPSZ_CD,@[laden_tpsz_cd17] ,A.CNT,0)) F_QTY17" ).append("\n"); 
		query.append("					 , SUM(DECODE(A.CNTR_TPSZ_CD,@[laden_tpsz_cd18] ,A.CNT,0)) F_QTY18" ).append("\n"); 
		query.append("					 , SUM(DECODE(A.CNTR_TPSZ_CD,@[laden_tpsz_cd19] ,A.CNT,0)) F_QTY19" ).append("\n"); 
		query.append("					 , SUM(DECODE(A.CNTR_TPSZ_CD,@[laden_tpsz_cd20] ,A.CNT,0)) F_QTY20" ).append("\n"); 
		query.append("					 , SUM(DECODE(A.CNTR_TPSZ_CD,@[laden_tpsz_cd21] ,A.CNT,0)) F_QTY21" ).append("\n"); 
		query.append("					 , SUM(DECODE(A.CNTR_TPSZ_CD,@[laden_tpsz_cd22] ,A.CNT,0)) F_QTY22" ).append("\n"); 
		query.append("					 , SUM(DECODE(A.CNTR_TPSZ_CD,@[laden_tpsz_cd23] ,A.CNT,0)) F_QTY23" ).append("\n"); 
		query.append("					 , SUM(DECODE(A.CNTR_TPSZ_CD,@[laden_tpsz_cd24] ,A.CNT,0)) F_QTY24" ).append("\n"); 
		query.append("					 , SUM(DECODE(A.CNTR_TPSZ_CD,@[laden_tpsz_cd25] ,A.CNT,0)) F_QTY25" ).append("\n"); 
		query.append("					 , SUM(DECODE(A.CNTR_TPSZ_CD,@[laden_tpsz_cd26] ,A.CNT,0)) F_QTY26" ).append("\n"); 
		query.append("					 , SUM(DECODE(A.CNTR_TPSZ_CD,@[laden_tpsz_cd27] ,A.CNT,0)) F_QTY27" ).append("\n"); 
		query.append("					 , SUM(DECODE(A.CNTR_TPSZ_CD,@[laden_tpsz_cd28] ,A.CNT,0)) F_QTY28" ).append("\n"); 
		query.append("					 , SUM(DECODE(A.CNTR_TPSZ_CD,@[laden_tpsz_cd29] ,A.CNT,0)) F_QTY29" ).append("\n"); 
		query.append("					 , SUM(DECODE(A.CNTR_TPSZ_CD,@[laden_tpsz_cd30] ,A.CNT,0)) F_QTY30" ).append("\n"); 
		query.append("					 , SUM(DECODE(A.CNTR_TPSZ_CD,@[empty_tpsz_cd1]  ,A.CNT,0)) E_QTY1" ).append("\n"); 
		query.append("					 , SUM(DECODE(A.CNTR_TPSZ_CD,@[empty_tpsz_cd2]  ,A.CNT,0)) E_QTY2" ).append("\n"); 
		query.append("					 , SUM(DECODE(A.CNTR_TPSZ_CD,@[empty_tpsz_cd3]  ,A.CNT,0)) E_QTY3" ).append("\n"); 
		query.append("					 , SUM(DECODE(A.CNTR_TPSZ_CD,@[empty_tpsz_cd4]  ,A.CNT,0)) E_QTY4" ).append("\n"); 
		query.append("					 , SUM(DECODE(A.CNTR_TPSZ_CD,@[empty_tpsz_cd5]  ,A.CNT,0)) E_QTY5" ).append("\n"); 
		query.append("					 , SUM(DECODE(A.CNTR_TPSZ_CD,@[empty_tpsz_cd6]  ,A.CNT,0)) E_QTY6" ).append("\n"); 
		query.append("					 , SUM(DECODE(A.CNTR_TPSZ_CD,@[empty_tpsz_cd7]  ,A.CNT,0)) E_QTY7" ).append("\n"); 
		query.append("					 , SUM(DECODE(A.CNTR_TPSZ_CD,@[empty_tpsz_cd8]  ,A.CNT,0)) E_QTY8" ).append("\n"); 
		query.append("					 , SUM(DECODE(A.CNTR_TPSZ_CD,@[empty_tpsz_cd9]  ,A.CNT,0)) E_QTY9" ).append("\n"); 
		query.append("					 , SUM(DECODE(A.CNTR_TPSZ_CD,@[empty_tpsz_cd10] ,A.CNT,0)) E_QTY10" ).append("\n"); 
		query.append("					 , SUM(DECODE(A.CNTR_TPSZ_CD,@[empty_tpsz_cd11] ,A.CNT,0)) E_QTY11" ).append("\n"); 
		query.append("					 , SUM(DECODE(A.CNTR_TPSZ_CD,@[empty_tpsz_cd12] ,A.CNT,0)) E_QTY12" ).append("\n"); 
		query.append("					 , SUM(DECODE(A.CNTR_TPSZ_CD,@[empty_tpsz_cd13] ,A.CNT,0)) E_QTY13" ).append("\n"); 
		query.append("					 , SUM(DECODE(A.CNTR_TPSZ_CD,@[empty_tpsz_cd14] ,A.CNT,0)) E_QTY14" ).append("\n"); 
		query.append("					 , SUM(DECODE(A.CNTR_TPSZ_CD,@[empty_tpsz_cd15] ,A.CNT,0)) E_QTY15" ).append("\n"); 
		query.append("					 , SUM(DECODE(A.CNTR_TPSZ_CD,@[empty_tpsz_cd16] ,A.CNT,0)) E_QTY16" ).append("\n"); 
		query.append("					 , SUM(DECODE(A.CNTR_TPSZ_CD,@[empty_tpsz_cd17] ,A.CNT,0)) E_QTY17" ).append("\n"); 
		query.append("					 , SUM(DECODE(A.CNTR_TPSZ_CD,@[empty_tpsz_cd18] ,A.CNT,0)) E_QTY18" ).append("\n"); 
		query.append("					 , SUM(DECODE(A.CNTR_TPSZ_CD,@[empty_tpsz_cd19] ,A.CNT,0)) E_QTY19" ).append("\n"); 
		query.append("					 , SUM(DECODE(A.CNTR_TPSZ_CD,@[empty_tpsz_cd20] ,A.CNT,0)) E_QTY20" ).append("\n"); 
		query.append("					 , SUM(DECODE(A.CNTR_TPSZ_CD,@[empty_tpsz_cd21] ,A.CNT,0)) E_QTY21" ).append("\n"); 
		query.append("					 , SUM(DECODE(A.CNTR_TPSZ_CD,@[empty_tpsz_cd22] ,A.CNT,0)) E_QTY22" ).append("\n"); 
		query.append("					 , SUM(DECODE(A.CNTR_TPSZ_CD,@[empty_tpsz_cd23] ,A.CNT,0)) E_QTY23" ).append("\n"); 
		query.append("					 , SUM(DECODE(A.CNTR_TPSZ_CD,@[empty_tpsz_cd24] ,A.CNT,0)) E_QTY24" ).append("\n"); 
		query.append("					 , SUM(DECODE(A.CNTR_TPSZ_CD,@[empty_tpsz_cd25] ,A.CNT,0)) E_QTY25" ).append("\n"); 
		query.append("					 , SUM(DECODE(A.CNTR_TPSZ_CD,@[empty_tpsz_cd26] ,A.CNT,0)) E_QTY26" ).append("\n"); 
		query.append("					 , SUM(DECODE(A.CNTR_TPSZ_CD,@[empty_tpsz_cd27] ,A.CNT,0)) E_QTY27" ).append("\n"); 
		query.append("					 , SUM(DECODE(A.CNTR_TPSZ_CD,@[empty_tpsz_cd28] ,A.CNT,0)) E_QTY28" ).append("\n"); 
		query.append("					 , SUM(DECODE(A.CNTR_TPSZ_CD,@[empty_tpsz_cd29] ,A.CNT,0)) E_QTY29" ).append("\n"); 
		query.append("					 , SUM(DECODE(A.CNTR_TPSZ_CD,@[empty_tpsz_cd30] ,A.CNT,0)) E_QTY30" ).append("\n"); 
		query.append("                  FROM (" ).append("\n"); 
		query.append("                        SELECT A.TP AS TYPE" ).append("\n"); 
		query.append("                             , A.VSL_CD" ).append("\n"); 
		query.append("                             , A.VOY_NO" ).append("\n"); 
		query.append("                             , A.DIR_CD" ).append("\n"); 
		query.append("                             , A.PORT_CD" ).append("\n"); 
		query.append("                             , A.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("                             , NVL(A.WEIGHT,0) AS WEIGHT" ).append("\n"); 
		query.append("                             , NVL(A.CNT, 0) AS CNT" ).append("\n"); 
		query.append("                          FROM (SELECT BAY.TP" ).append("\n"); 
		query.append("                                     , BAY.VSL_CD" ).append("\n"); 
		query.append("                                     , BAY.VOY_NO AS VOY_NO" ).append("\n"); 
		query.append("                                     , BAY.DIR_CD AS DIR_CD" ).append("\n"); 
		query.append("                                     , BAY.POL AS PORT_CD" ).append("\n"); 
		query.append("                                     , BAY.CNTR_TPSZ_CD AS CNTR_TPSZ_CD" ).append("\n"); 
		query.append("                                     , SUM(BAY.WEIGHT) AS WEIGHT" ).append("\n"); 
		query.append("                                     , COUNT(CNTR_TPSZ_CD) AS CNT" ).append("\n"); 
		query.append("                                  FROM (SELECT /*+ LEADING(VPS) INDEX(BAY XAK2BAY_PLAN) */ -- TUNING(2016/10/07)" ).append("\n"); 
		query.append("                                               VPS.TP" ).append("\n"); 
		query.append("                                             , VPS.VSL_CD" ).append("\n"); 
		query.append("                                             , VPS.SKD_VOY_NO AS VOY_NO" ).append("\n"); 
		query.append("                                             , VPS.SKD_DIR_CD AS DIR_CD" ).append("\n"); 
		query.append("                                             , BAY.POL" ).append("\n"); 
		query.append("                                             , CASE WHEN BAY.FE = 'F' AND BAY.CNTR_TYPE = 'R' AND BAY.TEMP IS NULL THEN BAY.FE||COM.RAD_CNTR_TPSZ_CD" ).append("\n"); 
		query.append("                                                    ELSE BAY.FE||COM.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("                                               END AS CNTR_TPSZ_CD" ).append("\n"); 
		query.append("                                             , BAY.WEIGHT" ).append("\n"); 
		query.append("                                          FROM V_PORT_LIST      VPS" ).append("\n"); 
		query.append("                                             , BAY_PLAN         BAY" ).append("\n"); 
		query.append("                                             , V_COM_TOT_SZ_TP  COM" ).append("\n"); 
		query.append("                                         WHERE 1=1" ).append("\n"); 
		query.append("                                           AND VPS.TP               = 'L'" ).append("\n"); 
		query.append("                                           AND VPS.ORD              > 0" ).append("\n"); 
		query.append("                                           AND VPS.VSL_CD           = BAY.VSL_CD" ).append("\n"); 
		query.append("                                           AND VPS.SKD_VOY_NO       = BAY.VOY_NO" ).append("\n"); 
		query.append("                                           AND VPS.SKD_DIR_CD       = BAY.DIR_CD" ).append("\n"); 
		query.append("                                           AND VPS.VPS_PORT_CD      = BAY.PORT_CD" ).append("\n"); 
		query.append("                                           AND VPS.CLPT_IND_SEQ     = BAY.CALL_IND" ).append("\n"); 
		query.append("                                           AND VPS.VPS_PORT_CD      = BAY.POL -- LOAD 조건." ).append("\n"); 
		query.append("                                           AND BAY.POL IS NOT NULL" ).append("\n"); 
		query.append("                                           AND BAY.POD IS NOT NULL" ).append("\n"); 
		query.append("				                           AND BAY.OPR_CD 			= @[slan_cd]" ).append("\n"); 
		query.append("                                           AND BAY.FE               IN ('F','E') " ).append("\n"); 
		query.append("                                           AND BAY.FE               = COM.CNTR_TP_CD " ).append("\n"); 
		query.append("                                           AND BAY.SZTP             = COM.NMR_CNTR_TPSZ_CD" ).append("\n"); 
		query.append("                                      ) BAY" ).append("\n"); 
		query.append("                                 WHERE 1=1" ).append("\n"); 
		query.append("                                 GROUP BY BAY.TP" ).append("\n"); 
		query.append("                                     , BAY.VSL_CD" ).append("\n"); 
		query.append("                                     , BAY.VOY_NO" ).append("\n"); 
		query.append("                                     , BAY.DIR_CD" ).append("\n"); 
		query.append("                                     , BAY.POL" ).append("\n"); 
		query.append("                                     , BAY.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("                                 ) A" ).append("\n"); 
		query.append("                       ) A" ).append("\n"); 
		query.append("                 GROUP BY A.VSL_CD" ).append("\n"); 
		query.append("                     , A.VOY_NO" ).append("\n"); 
		query.append("                     , A.DIR_CD" ).append("\n"); 
		query.append("                     , A.PORT_CD" ).append("\n"); 
		query.append("                     , A.TYPE" ).append("\n"); 
		query.append("                UNION ALL                     " ).append("\n"); 
		query.append("                /*3.Balance*/" ).append("\n"); 
		query.append("                SELECT A.VSL_CD" ).append("\n"); 
		query.append("                     , A.VOY_NO" ).append("\n"); 
		query.append("                     , A.DIR_CD" ).append("\n"); 
		query.append("                     , A.PORT_CD" ).append("\n"); 
		query.append("                     , A.TYPE" ).append("\n"); 
		query.append("                     , SUM(A.WEIGHT) AS WEIGHT" ).append("\n"); 
		query.append("                     , NVL(SUM(A.CNT),0) AS TOTAL" ).append("\n"); 
		query.append("					 , SUM(DECODE(A.CNTR_TPSZ_CD,@[laden_tpsz_cd1]  ,A.CNT,0)) F_QTY1" ).append("\n"); 
		query.append("					 , SUM(DECODE(A.CNTR_TPSZ_CD,@[laden_tpsz_cd2]  ,A.CNT,0)) F_QTY2" ).append("\n"); 
		query.append("					 , SUM(DECODE(A.CNTR_TPSZ_CD,@[laden_tpsz_cd3]  ,A.CNT,0)) F_QTY3" ).append("\n"); 
		query.append("					 , SUM(DECODE(A.CNTR_TPSZ_CD,@[laden_tpsz_cd4]  ,A.CNT,0)) F_QTY4" ).append("\n"); 
		query.append("					 , SUM(DECODE(A.CNTR_TPSZ_CD,@[laden_tpsz_cd5]  ,A.CNT,0)) F_QTY5" ).append("\n"); 
		query.append("					 , SUM(DECODE(A.CNTR_TPSZ_CD,@[laden_tpsz_cd6]  ,A.CNT,0)) F_QTY6" ).append("\n"); 
		query.append("					 , SUM(DECODE(A.CNTR_TPSZ_CD,@[laden_tpsz_cd7]  ,A.CNT,0)) F_QTY7" ).append("\n"); 
		query.append("					 , SUM(DECODE(A.CNTR_TPSZ_CD,@[laden_tpsz_cd8]  ,A.CNT,0)) F_QTY8" ).append("\n"); 
		query.append("					 , SUM(DECODE(A.CNTR_TPSZ_CD,@[laden_tpsz_cd9]  ,A.CNT,0)) F_QTY9" ).append("\n"); 
		query.append("					 , SUM(DECODE(A.CNTR_TPSZ_CD,@[laden_tpsz_cd10] ,A.CNT,0)) F_QTY10" ).append("\n"); 
		query.append("					 , SUM(DECODE(A.CNTR_TPSZ_CD,@[laden_tpsz_cd11] ,A.CNT,0)) F_QTY11" ).append("\n"); 
		query.append("					 , SUM(DECODE(A.CNTR_TPSZ_CD,@[laden_tpsz_cd12] ,A.CNT,0)) F_QTY12" ).append("\n"); 
		query.append("					 , SUM(DECODE(A.CNTR_TPSZ_CD,@[laden_tpsz_cd13] ,A.CNT,0)) F_QTY13" ).append("\n"); 
		query.append("					 , SUM(DECODE(A.CNTR_TPSZ_CD,@[laden_tpsz_cd14] ,A.CNT,0)) F_QTY14" ).append("\n"); 
		query.append("					 , SUM(DECODE(A.CNTR_TPSZ_CD,@[laden_tpsz_cd15] ,A.CNT,0)) F_QTY15" ).append("\n"); 
		query.append("					 , SUM(DECODE(A.CNTR_TPSZ_CD,@[laden_tpsz_cd16] ,A.CNT,0)) F_QTY16" ).append("\n"); 
		query.append("					 , SUM(DECODE(A.CNTR_TPSZ_CD,@[laden_tpsz_cd17] ,A.CNT,0)) F_QTY17" ).append("\n"); 
		query.append("					 , SUM(DECODE(A.CNTR_TPSZ_CD,@[laden_tpsz_cd18] ,A.CNT,0)) F_QTY18" ).append("\n"); 
		query.append("					 , SUM(DECODE(A.CNTR_TPSZ_CD,@[laden_tpsz_cd19] ,A.CNT,0)) F_QTY19" ).append("\n"); 
		query.append("					 , SUM(DECODE(A.CNTR_TPSZ_CD,@[laden_tpsz_cd20] ,A.CNT,0)) F_QTY20" ).append("\n"); 
		query.append("					 , SUM(DECODE(A.CNTR_TPSZ_CD,@[laden_tpsz_cd21] ,A.CNT,0)) F_QTY21" ).append("\n"); 
		query.append("					 , SUM(DECODE(A.CNTR_TPSZ_CD,@[laden_tpsz_cd22] ,A.CNT,0)) F_QTY22" ).append("\n"); 
		query.append("					 , SUM(DECODE(A.CNTR_TPSZ_CD,@[laden_tpsz_cd23] ,A.CNT,0)) F_QTY23" ).append("\n"); 
		query.append("					 , SUM(DECODE(A.CNTR_TPSZ_CD,@[laden_tpsz_cd24] ,A.CNT,0)) F_QTY24" ).append("\n"); 
		query.append("					 , SUM(DECODE(A.CNTR_TPSZ_CD,@[laden_tpsz_cd25] ,A.CNT,0)) F_QTY25" ).append("\n"); 
		query.append("					 , SUM(DECODE(A.CNTR_TPSZ_CD,@[laden_tpsz_cd26] ,A.CNT,0)) F_QTY26" ).append("\n"); 
		query.append("					 , SUM(DECODE(A.CNTR_TPSZ_CD,@[laden_tpsz_cd27] ,A.CNT,0)) F_QTY27" ).append("\n"); 
		query.append("					 , SUM(DECODE(A.CNTR_TPSZ_CD,@[laden_tpsz_cd28] ,A.CNT,0)) F_QTY28" ).append("\n"); 
		query.append("					 , SUM(DECODE(A.CNTR_TPSZ_CD,@[laden_tpsz_cd29] ,A.CNT,0)) F_QTY29" ).append("\n"); 
		query.append("					 , SUM(DECODE(A.CNTR_TPSZ_CD,@[laden_tpsz_cd30] ,A.CNT,0)) F_QTY30" ).append("\n"); 
		query.append("					 , SUM(DECODE(A.CNTR_TPSZ_CD,@[empty_tpsz_cd1]  ,A.CNT,0)) E_QTY1" ).append("\n"); 
		query.append("					 , SUM(DECODE(A.CNTR_TPSZ_CD,@[empty_tpsz_cd2]  ,A.CNT,0)) E_QTY2" ).append("\n"); 
		query.append("					 , SUM(DECODE(A.CNTR_TPSZ_CD,@[empty_tpsz_cd3]  ,A.CNT,0)) E_QTY3" ).append("\n"); 
		query.append("					 , SUM(DECODE(A.CNTR_TPSZ_CD,@[empty_tpsz_cd4]  ,A.CNT,0)) E_QTY4" ).append("\n"); 
		query.append("					 , SUM(DECODE(A.CNTR_TPSZ_CD,@[empty_tpsz_cd5]  ,A.CNT,0)) E_QTY5" ).append("\n"); 
		query.append("					 , SUM(DECODE(A.CNTR_TPSZ_CD,@[empty_tpsz_cd6]  ,A.CNT,0)) E_QTY6" ).append("\n"); 
		query.append("					 , SUM(DECODE(A.CNTR_TPSZ_CD,@[empty_tpsz_cd7]  ,A.CNT,0)) E_QTY7" ).append("\n"); 
		query.append("					 , SUM(DECODE(A.CNTR_TPSZ_CD,@[empty_tpsz_cd8]  ,A.CNT,0)) E_QTY8" ).append("\n"); 
		query.append("					 , SUM(DECODE(A.CNTR_TPSZ_CD,@[empty_tpsz_cd9]  ,A.CNT,0)) E_QTY9" ).append("\n"); 
		query.append("					 , SUM(DECODE(A.CNTR_TPSZ_CD,@[empty_tpsz_cd10] ,A.CNT,0)) E_QTY10" ).append("\n"); 
		query.append("					 , SUM(DECODE(A.CNTR_TPSZ_CD,@[empty_tpsz_cd11] ,A.CNT,0)) E_QTY11" ).append("\n"); 
		query.append("					 , SUM(DECODE(A.CNTR_TPSZ_CD,@[empty_tpsz_cd12] ,A.CNT,0)) E_QTY12" ).append("\n"); 
		query.append("					 , SUM(DECODE(A.CNTR_TPSZ_CD,@[empty_tpsz_cd13] ,A.CNT,0)) E_QTY13" ).append("\n"); 
		query.append("					 , SUM(DECODE(A.CNTR_TPSZ_CD,@[empty_tpsz_cd14] ,A.CNT,0)) E_QTY14" ).append("\n"); 
		query.append("					 , SUM(DECODE(A.CNTR_TPSZ_CD,@[empty_tpsz_cd15] ,A.CNT,0)) E_QTY15" ).append("\n"); 
		query.append("					 , SUM(DECODE(A.CNTR_TPSZ_CD,@[empty_tpsz_cd16] ,A.CNT,0)) E_QTY16" ).append("\n"); 
		query.append("					 , SUM(DECODE(A.CNTR_TPSZ_CD,@[empty_tpsz_cd17] ,A.CNT,0)) E_QTY17" ).append("\n"); 
		query.append("					 , SUM(DECODE(A.CNTR_TPSZ_CD,@[empty_tpsz_cd18] ,A.CNT,0)) E_QTY18" ).append("\n"); 
		query.append("					 , SUM(DECODE(A.CNTR_TPSZ_CD,@[empty_tpsz_cd19] ,A.CNT,0)) E_QTY19" ).append("\n"); 
		query.append("					 , SUM(DECODE(A.CNTR_TPSZ_CD,@[empty_tpsz_cd20] ,A.CNT,0)) E_QTY20" ).append("\n"); 
		query.append("					 , SUM(DECODE(A.CNTR_TPSZ_CD,@[empty_tpsz_cd21] ,A.CNT,0)) E_QTY21" ).append("\n"); 
		query.append("					 , SUM(DECODE(A.CNTR_TPSZ_CD,@[empty_tpsz_cd22] ,A.CNT,0)) E_QTY22" ).append("\n"); 
		query.append("					 , SUM(DECODE(A.CNTR_TPSZ_CD,@[empty_tpsz_cd23] ,A.CNT,0)) E_QTY23" ).append("\n"); 
		query.append("					 , SUM(DECODE(A.CNTR_TPSZ_CD,@[empty_tpsz_cd24] ,A.CNT,0)) E_QTY24" ).append("\n"); 
		query.append("					 , SUM(DECODE(A.CNTR_TPSZ_CD,@[empty_tpsz_cd25] ,A.CNT,0)) E_QTY25" ).append("\n"); 
		query.append("					 , SUM(DECODE(A.CNTR_TPSZ_CD,@[empty_tpsz_cd26] ,A.CNT,0)) E_QTY26" ).append("\n"); 
		query.append("					 , SUM(DECODE(A.CNTR_TPSZ_CD,@[empty_tpsz_cd27] ,A.CNT,0)) E_QTY27" ).append("\n"); 
		query.append("					 , SUM(DECODE(A.CNTR_TPSZ_CD,@[empty_tpsz_cd28] ,A.CNT,0)) E_QTY28" ).append("\n"); 
		query.append("					 , SUM(DECODE(A.CNTR_TPSZ_CD,@[empty_tpsz_cd29] ,A.CNT,0)) E_QTY29" ).append("\n"); 
		query.append("					 , SUM(DECODE(A.CNTR_TPSZ_CD,@[empty_tpsz_cd30] ,A.CNT,0)) E_QTY30" ).append("\n"); 
		query.append("                  FROM (" ).append("\n"); 
		query.append("                        SELECT A.TP AS TYPE" ).append("\n"); 
		query.append("                             , A.VSL_CD" ).append("\n"); 
		query.append("                             , A.VOY_NO" ).append("\n"); 
		query.append("                             , A.DIR_CD" ).append("\n"); 
		query.append("                             , A.PORT_CD" ).append("\n"); 
		query.append("                             , A.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("                             , NVL(A.WEIGHT,0) AS WEIGHT" ).append("\n"); 
		query.append("                             , NVL(A.CNT, 0) AS CNT" ).append("\n"); 
		query.append("                          FROM (SELECT BAY.TP" ).append("\n"); 
		query.append("                                     , BAY.VSL_CD" ).append("\n"); 
		query.append("                                     , BAY.VOY_NO AS VOY_NO" ).append("\n"); 
		query.append("                                     , BAY.DIR_CD AS DIR_CD" ).append("\n"); 
		query.append("                                     , BAY.PORT_CD AS PORT_CD" ).append("\n"); 
		query.append("                                     , BAY.CNTR_TPSZ_CD AS CNTR_TPSZ_CD" ).append("\n"); 
		query.append("                                     , SUM(BAY.WEIGHT) AS WEIGHT" ).append("\n"); 
		query.append("                                     , COUNT(BAY.CNTR_TPSZ_CD) AS CNT" ).append("\n"); 
		query.append("                                  FROM (SELECT /*+ LEADING(VPS) INDEX(BAY XAK2BAY_PLAN) */ -- TUNING(2016/10/07)" ).append("\n"); 
		query.append("                                               VPS.TP" ).append("\n"); 
		query.append("                                             , VPS.VSL_CD" ).append("\n"); 
		query.append("                                             , VPS.SKD_VOY_NO AS VOY_NO" ).append("\n"); 
		query.append("                                             , VPS.SKD_DIR_CD AS DIR_CD" ).append("\n"); 
		query.append("                                             , BAY.PORT_CD" ).append("\n"); 
		query.append("                                             , CASE WHEN BAY.FE = 'F' AND BAY.CNTR_TYPE = 'R' AND BAY.TEMP IS NULL THEN BAY.FE||COM.RAD_CNTR_TPSZ_CD" ).append("\n"); 
		query.append("                                                    ELSE BAY.FE||COM.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("                                               END AS CNTR_TPSZ_CD" ).append("\n"); 
		query.append("                                             , BAY.WEIGHT" ).append("\n"); 
		query.append("                                          FROM V_PORT_LIST      VPS" ).append("\n"); 
		query.append("                                             , BAY_PLAN         BAY" ).append("\n"); 
		query.append("                                             , V_COM_TOT_SZ_TP  COM" ).append("\n"); 
		query.append("                                         WHERE 1=1" ).append("\n"); 
		query.append("                                           AND VPS.TP               = 'B'" ).append("\n"); 
		query.append("                                           AND VPS.ORD              > 0" ).append("\n"); 
		query.append("                                           AND VPS.VSL_CD           = BAY.VSL_CD" ).append("\n"); 
		query.append("                                           AND VPS.SKD_VOY_NO       = BAY.VOY_NO" ).append("\n"); 
		query.append("                                           AND VPS.SKD_DIR_CD       = BAY.DIR_CD" ).append("\n"); 
		query.append("                                           AND VPS.VPS_PORT_CD      = BAY.PORT_CD" ).append("\n"); 
		query.append("                                           AND VPS.CLPT_IND_SEQ     = BAY.CALL_IND" ).append("\n"); 
		query.append("                                           AND BAY.POL IS NOT NULL" ).append("\n"); 
		query.append("                                           AND BAY.POD IS NOT NULL" ).append("\n"); 
		query.append("				                           AND BAY.OPR_CD 			= @[slan_cd]" ).append("\n"); 
		query.append("                                           AND BAY.FE               IN ('F','E') " ).append("\n"); 
		query.append("                                           AND BAY.FE               = COM.CNTR_TP_CD " ).append("\n"); 
		query.append("                                           AND BAY.SZTP             = COM.NMR_CNTR_TPSZ_CD" ).append("\n"); 
		query.append("                                      ) BAY" ).append("\n"); 
		query.append("                                 WHERE 1=1" ).append("\n"); 
		query.append("                                 GROUP BY BAY.TP" ).append("\n"); 
		query.append("                                     , BAY.VSL_CD" ).append("\n"); 
		query.append("                                     , BAY.VOY_NO" ).append("\n"); 
		query.append("                                     , BAY.DIR_CD" ).append("\n"); 
		query.append("                                     , BAY.PORT_CD" ).append("\n"); 
		query.append("                                     , BAY.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("                                 ) A" ).append("\n"); 
		query.append("                     ) A" ).append("\n"); 
		query.append("               GROUP BY A.VSL_CD" ).append("\n"); 
		query.append("                      , A.VOY_NO" ).append("\n"); 
		query.append("                      , A.DIR_CD" ).append("\n"); 
		query.append("                      , A.PORT_CD" ).append("\n"); 
		query.append("                      , A.TYPE" ).append("\n"); 
		query.append("                      " ).append("\n"); 
		query.append("               ) L" ).append("\n"); 
		query.append("             , (" ).append("\n"); 
		query.append("                 /*Void*/" ).append("\n"); 
		query.append("                SELECT A.TYPE" ).append("\n"); 
		query.append("                     , A.VSL_CD" ).append("\n"); 
		query.append("                     , A.VOY_NO" ).append("\n"); 
		query.append("                     , A.DIR_CD" ).append("\n"); 
		query.append("                     , A.PORT_CD" ).append("\n"); 
		query.append("                     , SUM(A.VOID) AS VOID" ).append("\n"); 
		query.append("                  FROM (" ).append("\n"); 
		query.append("                        /*Discharge - Void*/" ).append("\n"); 
		query.append("                        SELECT /*+ LEADING(VPS) INDEX(BAY XAK2BAY_PLAN) */ --TUNING(2016/10/07)" ).append("\n"); 
		query.append("                               VPS.TP AS TYPE" ).append("\n"); 
		query.append("                             , VPS.VSL_CD" ).append("\n"); 
		query.append("                             , VPS.SKD_VOY_NO AS VOY_NO" ).append("\n"); 
		query.append("                             , VPS.SKD_DIR_CD AS DIR_CD" ).append("\n"); 
		query.append("                             , BAY.POD AS PORT_CD" ).append("\n"); 
		query.append("                             , (SELECT VOID_CNT" ).append("\n"); 
		query.append("                                  FROM V_COM_VOID V" ).append("\n"); 
		query.append("                                 WHERE V.SLAN_CD = VPS.SLAN_CD" ).append("\n"); 
		query.append("                                   AND V.OR_FLG = DECODE(BAY.OVS, NULL, 'N', 'Y')" ).append("\n"); 
		query.append("                                   AND V.OL_FLG = DECODE(BAY.OVP, NULL, 'N', 'Y')" ).append("\n"); 
		query.append("                                   AND V.OH_FLG = DECODE(BAY.OVH, NULL, 'N', 'Y')" ).append("\n"); 
		query.append("                               ) AS VOID" ).append("\n"); 
		query.append("                             --, NVL(BAY.OVH_SLOT,0) + NVL(BAY.OVP_SLOT,0) + NVL(BAY.OVS_SLOT,0) + NVL(BAY.OVF_SLOT,0) + NVL(BAY.OVA_SLOT,0) AS VOID" ).append("\n"); 
		query.append("                          FROM V_PORT_LIST  VPS" ).append("\n"); 
		query.append("                             , BAY_PLAN     BAY" ).append("\n"); 
		query.append("                         WHERE 1=1" ).append("\n"); 
		query.append("                           AND VPS.TP               = 'D'" ).append("\n"); 
		query.append("                           AND VPS.ORD              > 0" ).append("\n"); 
		query.append("                           -------------- TUNING(2016/10/07) ----------------" ).append("\n"); 
		query.append("                           /*AND VPS.LAG_VVD          = BAY.VSL_CD|| BAY.VOY_NO|| BAY.DIR_CD*/" ).append("\n"); 
		query.append("                           AND SUBSTR(VPS.LAG_VVD, 1, 4) = BAY.VSL_CD" ).append("\n"); 
		query.append("                           AND SUBSTR(VPS.LAG_VVD, 5, 4) = BAY.VOY_NO" ).append("\n"); 
		query.append("                           AND SUBSTR(VPS.LAG_VVD, 9, 1) = BAY.DIR_CD" ).append("\n"); 
		query.append("                           --------------------------------------------------" ).append("\n"); 
		query.append("                           AND VPS.LAG_VPS_PORT_CD  = BAY.PORT_CD" ).append("\n"); 
		query.append("                           AND VPS.LAG_CLPT_IND_SEQ = BAY.CALL_IND" ).append("\n"); 
		query.append("                           AND VPS.VPS_PORT_CD      = BAY.POD	" ).append("\n"); 
		query.append("                           AND BAY.POL IS NOT NULL" ).append("\n"); 
		query.append("                           AND BAY.POD IS NOT NULL					   " ).append("\n"); 
		query.append("                           AND BAY.FE               = 'F' --Laden" ).append("\n"); 
		query.append("				           AND BAY.OPR_CD 		= @[slan_cd]" ).append("\n"); 
		query.append("                         UNION ALL                 " ).append("\n"); 
		query.append("                        /*Load - Void*/" ).append("\n"); 
		query.append("                        SELECT /*+ LEADING(VPS) INDEX(BAY XAK2BAY_PLAN) */ -- TUNING(2016/10/07)" ).append("\n"); 
		query.append("                               VPS.TP AS TYPE" ).append("\n"); 
		query.append("                             , VPS.VSL_CD" ).append("\n"); 
		query.append("                             , VPS.SKD_VOY_NO AS VOY_NO" ).append("\n"); 
		query.append("                             , VPS.SKD_DIR_CD AS DIR_CD" ).append("\n"); 
		query.append("                             , BAY.POL AS PORT_CD" ).append("\n"); 
		query.append("                             , (SELECT VOID_CNT" ).append("\n"); 
		query.append("                                  FROM V_COM_VOID V" ).append("\n"); 
		query.append("                                 WHERE V.SLAN_CD = VPS.SLAN_CD" ).append("\n"); 
		query.append("                                   AND V.OR_FLG = DECODE(BAY.OVS, NULL, 'N', 'Y')" ).append("\n"); 
		query.append("                                   AND V.OL_FLG = DECODE(BAY.OVP, NULL, 'N', 'Y')" ).append("\n"); 
		query.append("                                   AND V.OH_FLG = DECODE(BAY.OVH, NULL, 'N', 'Y')" ).append("\n"); 
		query.append("                               ) AS VOID" ).append("\n"); 
		query.append("                             --, NVL(BAY.OVH_SLOT,0) + NVL(BAY.OVP_SLOT,0) + NVL(BAY.OVS_SLOT,0) + NVL(BAY.OVF_SLOT,0) + NVL(BAY.OVA_SLOT,0) AS VOID" ).append("\n"); 
		query.append("                          FROM V_PORT_LIST  VPS" ).append("\n"); 
		query.append("                             , BAY_PLAN     BAY" ).append("\n"); 
		query.append("                         WHERE 1=1" ).append("\n"); 
		query.append("                           AND VPS.TP               = 'L'" ).append("\n"); 
		query.append("                           AND VPS.ORD              > 0" ).append("\n"); 
		query.append("                           AND VPS.VSL_CD           = BAY.VSL_CD" ).append("\n"); 
		query.append("                           AND VPS.SKD_VOY_NO       = BAY.VOY_NO" ).append("\n"); 
		query.append("                           AND VPS.SKD_DIR_CD       = BAY.DIR_CD" ).append("\n"); 
		query.append("                           AND VPS.VPS_PORT_CD      = BAY.PORT_CD" ).append("\n"); 
		query.append("                           AND VPS.CLPT_IND_SEQ     = BAY.CALL_IND" ).append("\n"); 
		query.append("                           AND VPS.VPS_PORT_CD      = BAY.POL" ).append("\n"); 
		query.append("                           AND BAY.POL IS NOT NULL" ).append("\n"); 
		query.append("                           AND BAY.POD IS NOT NULL" ).append("\n"); 
		query.append("                           AND BAY.FE               = 'F' --Laden" ).append("\n"); 
		query.append("				           AND BAY.OPR_CD 		= @[slan_cd]" ).append("\n"); 
		query.append("                         UNION ALL                 " ).append("\n"); 
		query.append("                        /*Balance - Void*/" ).append("\n"); 
		query.append("                        SELECT /*+ LEADING(VPS) INDEX(BAY XAK2BAY_PLAN) */ -- TUNING(2016/10/07)" ).append("\n"); 
		query.append("                               VPS.TP AS TYPE" ).append("\n"); 
		query.append("                             , VPS.VSL_CD" ).append("\n"); 
		query.append("                             , VPS.SKD_VOY_NO AS VOY_NO" ).append("\n"); 
		query.append("                             , VPS.SKD_DIR_CD AS DIR_CD" ).append("\n"); 
		query.append("                             , BAY.PORT_CD AS PORT_CD" ).append("\n"); 
		query.append("                             , (SELECT VOID_CNT" ).append("\n"); 
		query.append("                                  FROM V_COM_VOID V" ).append("\n"); 
		query.append("                                 WHERE V.SLAN_CD = VPS.SLAN_CD" ).append("\n"); 
		query.append("                                   AND V.OR_FLG = DECODE(BAY.OVS, NULL, 'N', 'Y')" ).append("\n"); 
		query.append("                                   AND V.OL_FLG = DECODE(BAY.OVP, NULL, 'N', 'Y')" ).append("\n"); 
		query.append("                                   AND V.OH_FLG = DECODE(BAY.OVH, NULL, 'N', 'Y')" ).append("\n"); 
		query.append("                               ) AS VOID" ).append("\n"); 
		query.append("                             --, NVL(BAY.OVH_SLOT,0) + NVL(BAY.OVP_SLOT,0) + NVL(BAY.OVS_SLOT,0) + NVL(BAY.OVF_SLOT,0) + NVL(BAY.OVA_SLOT,0) AS VOID" ).append("\n"); 
		query.append("                          FROM V_PORT_LIST  VPS" ).append("\n"); 
		query.append("                             , BAY_PLAN     BAY" ).append("\n"); 
		query.append("                         WHERE 1=1" ).append("\n"); 
		query.append("                           AND VPS.TP           = 'B'" ).append("\n"); 
		query.append("                           AND VPS.ORD          > 0" ).append("\n"); 
		query.append("                           AND VPS.VSL_CD       = BAY.VSL_CD" ).append("\n"); 
		query.append("                           AND VPS.SKD_VOY_NO   = BAY.VOY_NO" ).append("\n"); 
		query.append("                           AND VPS.SKD_DIR_CD   = BAY.DIR_CD" ).append("\n"); 
		query.append("                           AND VPS.VPS_PORT_CD  = BAY.PORT_CD" ).append("\n"); 
		query.append("                           AND VPS.CLPT_IND_SEQ = BAY.CALL_IND" ).append("\n"); 
		query.append("                           AND BAY.POL IS NOT NULL" ).append("\n"); 
		query.append("                           AND BAY.POD IS NOT NULL" ).append("\n"); 
		query.append("                           AND BAY.FE           = 'F' --Laden" ).append("\n"); 
		query.append("				           AND BAY.OPR_CD 		= @[slan_cd]" ).append("\n"); 
		query.append("                        ) A" ).append("\n"); 
		query.append("                 GROUP BY A.TYPE" ).append("\n"); 
		query.append("                     , A.VSL_CD" ).append("\n"); 
		query.append("                     , A.VOY_NO" ).append("\n"); 
		query.append("                     , A.DIR_CD" ).append("\n"); 
		query.append("                     , A.PORT_CD" ).append("\n"); 
		query.append("                 ) V" ).append("\n"); 
		query.append("               , (" ).append("\n"); 
		query.append("                /*Summary By Port - Ldn TEU, Ety TEU, Wgt(Ton), Wgt/TEU, RF Plug*/" ).append("\n"); 
		query.append("                SELECT TP.TP AS TYPE" ).append("\n"); 
		query.append("                     , SP.*" ).append("\n"); 
		query.append("                  FROM (" ).append("\n"); 
		query.append("                        SELECT V.SLAN_CD" ).append("\n"); 
		query.append("                             , V.VSL_CD" ).append("\n"); 
		query.append("                             , V.VOY_NO" ).append("\n"); 
		query.append("                             , V.DIR_CD" ).append("\n"); 
		query.append("                             , V.PORT_CD     " ).append("\n"); 
		query.append("                             , P.SUM_TOTAL_TEU" ).append("\n"); 
		query.append("                             , P.SUM_LDN_TEU " ).append("\n"); 
		query.append("                             , P.SUM_ETY_TEU" ).append("\n"); 
		query.append("                             , P.SUM_WGT_TON" ).append("\n"); 
		query.append("                             , P.SUM_RF_PLUG --Option1 : on board, Option2 : load " ).append("\n"); 
		query.append("                             , V.WGT_TEU AS SUM_WGT_TEU                          " ).append("\n"); 
		query.append("                             , CASE WHEN NVL(V.WGT_TEU, 0) > 0 " ).append("\n"); 
		query.append("                                         THEN CASE WHEN P.OPTION_A = 'OPTION1' THEN CEIL ( NVL(P.SUM_WGT_TON, 0)/NVL(V.WGT_TEU, 0) * 10) / 10 -- ROUND( NVL(P.SUM_WGT_TON, 0)/NVL(V.WGT_TEU, 0) , 1)" ).append("\n"); 
		query.append("                                                   WHEN P.OPTION_A = 'OPTION2' THEN ROUND( NVL(P.SUM_WGT_TON, 0)/NVL(V.WGT_TEU, 0) , 2)" ).append("\n"); 
		query.append("                                                   WHEN P.OPTION_A = 'OPTION3' THEN TRUNC( NVL(P.SUM_WGT_TON, 0)/NVL(V.WGT_TEU, 0) , 1)" ).append("\n"); 
		query.append("                                                   WHEN P.OPTION_A = 'OPTION4' THEN TRUNC( NVL(P.SUM_WGT_TON, 0)/NVL(V.WGT_TEU, 0) , 2)" ).append("\n"); 
		query.append("                                                   ELSE 0" ).append("\n"); 
		query.append("                                              END" ).append("\n"); 
		query.append("                                    ELSE 0" ).append("\n"); 
		query.append("                               END AS SUM_TEU_BY_WGT" ).append("\n"); 
		query.append("                             , P.OPTION_A" ).append("\n"); 
		query.append("                             , P.OPTION_B" ).append("\n"); 
		query.append("                             , V.ALLOC_SLOT" ).append("\n"); 
		query.append("                             , V.ALLOC_RF" ).append("\n"); 
		query.append("                          FROM (" ).append("\n"); 
		query.append("                                SELECT VPS.SLAN_CD" ).append("\n"); 
		query.append("                                     , VPS.VSL_CD" ).append("\n"); 
		query.append("                                     , VPS.VOY_NO" ).append("\n"); 
		query.append("                                     , VPS.DIR_CD" ).append("\n"); 
		query.append("                                     , VPS.PORT_CD" ).append("\n"); 
		query.append("                                     , NVL(VPS.WGT_TEU, 0) AS WGT_TEU" ).append("\n"); 
		query.append("                                     , CASE WHEN VPS.ALLOC_PORT_SLOT > 0 AND VPS.ALLOC_PORT_SLOT IS NOT NULL THEN VPS.ALLOC_PORT_SLOT" ).append("\n"); 
		query.append("                                            ELSE VPS.ALLOC_VVD_SLOT" ).append("\n"); 
		query.append("                                       END AS ALLOC_SLOT" ).append("\n"); 
		query.append("                                     , NVL(VPS.ALLOC_RF, 0) AS ALLOC_RF" ).append("\n"); 
		query.append("                                  FROM (" ).append("\n"); 
		query.append("                                        SELECT DISTINCT VPS.TP" ).append("\n"); 
		query.append("                                             , VPS.SLAN_CD" ).append("\n"); 
		query.append("                                             , VPS.RLANE_CD" ).append("\n"); 
		query.append("                                             , VPS.VSL_CD" ).append("\n"); 
		query.append("                                             , VPS.SKD_VOY_NO AS VOY_NO" ).append("\n"); 
		query.append("                                             , VPS.SKD_DIR_CD AS DIR_CD" ).append("\n"); 
		query.append("                                             , VPS.VPS_PORT_CD AS PORT_CD" ).append("\n"); 
		query.append("                                             /*Wgt/TEU 구하는 부분. BSA_VVD_OTR_CRR 008 구분값으로 구한다 by VVD.*/ " ).append("\n"); 
		query.append("                                             , (SELECT NVL(SUM(DECODE(D.CRR_CD, @[slan_cd], D.CRR_BSA_CAPA)), 0) FNL_CO_BSA_CAPA" ).append("\n"); 
		query.append("                                                  FROM BSA_VVD_MST C" ).append("\n"); 
		query.append("                                                     , BSA_VVD_OTR_CRR D" ).append("\n"); 
		query.append("                                                 WHERE 1=1" ).append("\n"); 
		query.append("                                                   AND C.TRD_CD         = D.TRD_CD(+)" ).append("\n"); 
		query.append("                                                   AND C.RLANE_CD       = D.RLANE_CD(+)" ).append("\n"); 
		query.append("                                                   AND C.VSL_CD         = D.VSL_CD(+)" ).append("\n"); 
		query.append("                                                   AND C.SKD_VOY_NO     = D.SKD_VOY_NO(+)" ).append("\n"); 
		query.append("                                                   AND C.SKD_DIR_CD     = D.SKD_DIR_CD(+)" ).append("\n"); 
		query.append("                                                   AND D.BSA_OP_JB_CD(+)= '008'" ).append("\n"); 
		query.append("                                                   AND C.RLANE_CD       = VPS.RLANE_CD" ).append("\n"); 
		query.append("                                                   AND C.VSL_CD         = VPS.VSL_CD" ).append("\n"); 
		query.append("                                                   AND C.SKD_VOY_NO     = VPS.SKD_VOY_NO" ).append("\n"); 
		query.append("                                                   AND C.SKD_DIR_CD     = VPS.SKD_DIR_CD" ).append("\n"); 
		query.append("                                                 GROUP BY C.RLANE_CD" ).append("\n"); 
		query.append("                                                     , C.VSL_CD" ).append("\n"); 
		query.append("                                                     , C.SKD_VOY_NO" ).append("\n"); 
		query.append("                                                     , C.SKD_DIR_CD) AS WGT_TEU" ).append("\n"); 
		query.append("                                                /*Allocation RF by VVD구하기.*/  " ).append("\n"); 
		query.append("                                              , (SELECT NVL(SUM(DECODE(D.CRR_CD, @[slan_cd], D.CRR_BSA_CAPA)), 0) FNL_CO_BSA_CAPA" ).append("\n"); 
		query.append("                                                   FROM BSA_VVD_MST BSA " ).append("\n"); 
		query.append("                                                      , BSA_VVD_OTR_CRR D" ).append("\n"); 
		query.append("                                                      , BSA_VVD_SWAP_INFO F " ).append("\n"); 
		query.append("                                                   WHERE 1=1" ).append("\n"); 
		query.append("                                                     AND BSA.TRD_CD     = D.TRD_CD(+) " ).append("\n"); 
		query.append("                                                     AND BSA.RLANE_CD   = D.RLANE_CD(+) " ).append("\n"); 
		query.append("                                                     AND BSA.VSL_CD     = D.VSL_CD(+) " ).append("\n"); 
		query.append("                                                     AND BSA.SKD_VOY_NO = D.SKD_VOY_NO(+) " ).append("\n"); 
		query.append("                                                     AND BSA.SKD_DIR_CD = D.SKD_DIR_CD(+) " ).append("\n"); 
		query.append("                                                     AND D.TRD_CD       = F.TRD_CD(+) " ).append("\n"); 
		query.append("                                                     AND D.RLANE_CD     = F.RLANE_CD(+) " ).append("\n"); 
		query.append("                                                     AND D.VSL_CD       = F.VSL_CD(+) " ).append("\n"); 
		query.append("                                                     AND D.SKD_VOY_NO   = F.SKD_VOY_NO(+) " ).append("\n"); 
		query.append("                                                     AND D.SKD_DIR_CD   = F.SKD_DIR_CD(+) " ).append("\n"); 
		query.append("                                                     AND D.BSA_OP_JB_CD = F.BSA_OP_JB_CD(+) " ).append("\n"); 
		query.append("                                                     AND D.CRR_CD       = F.CRR_CD(+) " ).append("\n"); 
		query.append("                                                     AND D.BSA_OP_JB_CD(+) = '010'" ).append("\n"); 
		query.append("                                                     --AND BSA.TRD_CD     = VPS.TRD_CD" ).append("\n"); 
		query.append("                                                     AND BSA.RLANE_CD   = VPS.RLANE_CD " ).append("\n"); 
		query.append("                                                     AND BSA.VSL_CD     = VPS.VSL_CD " ).append("\n"); 
		query.append("                                                     AND BSA.SKD_VOY_NO = VPS.SKD_VOY_NO" ).append("\n"); 
		query.append("                                                     AND BSA.SKD_DIR_CD = VPS.SKD_DIR_CD" ).append("\n"); 
		query.append("                                                   GROUP BY BSA.TRD_CD, " ).append("\n"); 
		query.append("                                                            BSA.RLANE_CD, " ).append("\n"); 
		query.append("                                                            BSA.VSL_CD, " ).append("\n"); 
		query.append("                                                            BSA.SKD_VOY_NO, " ).append("\n"); 
		query.append("                                                            BSA.SKD_DIR_CD,  " ).append("\n"); 
		query.append("                                                            BSA.CRR_CD" ).append("\n"); 
		query.append("                                                    ) AS ALLOC_RF" ).append("\n"); 
		query.append("                                                /*Allocation Slot by VVD구하기.*/" ).append("\n"); 
		query.append("                                              , (SELECT NVL(SUM(DECODE(D.CRR_CD, @[slan_cd], D.CRR_BSA_CAPA)), 0) FNL_CO_BSA_CAPA" ).append("\n"); 
		query.append("                                                   FROM BSA_VVD_MST BSA" ).append("\n"); 
		query.append("                                                      , BSA_VVD_OTR_CRR D" ).append("\n"); 
		query.append("                                                  WHERE 1=1" ).append("\n"); 
		query.append("                                                    AND BSA.TRD_CD       = D.TRD_CD(+)" ).append("\n"); 
		query.append("                                                    AND BSA.RLANE_CD     = D.RLANE_CD(+)" ).append("\n"); 
		query.append("                                                    AND BSA.VSL_CD       = D.VSL_CD(+)" ).append("\n"); 
		query.append("                                                    AND BSA.SKD_VOY_NO   = D.SKD_VOY_NO(+)" ).append("\n"); 
		query.append("                                                    AND BSA.SKD_DIR_CD   = D.SKD_DIR_CD(+)" ).append("\n"); 
		query.append("                                                    AND D.BSA_OP_JB_CD(+)= '007'" ).append("\n"); 
		query.append("                                                    AND BSA.RLANE_CD     = VPS.RLANE_CD " ).append("\n"); 
		query.append("                                                    AND BSA.VSL_CD       = VPS.VSL_CD " ).append("\n"); 
		query.append("                                                    AND BSA.SKD_VOY_NO   = VPS.SKD_VOY_NO" ).append("\n"); 
		query.append("                                                    AND BSA.SKD_DIR_CD   = VPS.SKD_DIR_CD" ).append("\n"); 
		query.append("                                                  GROUP BY BSA.RLANE_CD" ).append("\n"); 
		query.append("                                                         , BSA.VSL_CD" ).append("\n"); 
		query.append("                                                         , BSA.SKD_VOY_NO" ).append("\n"); 
		query.append("                                                         , BSA.SKD_DIR_CD" ).append("\n"); 
		query.append("                                                ) AS ALLOC_VVD_SLOT" ).append("\n"); 
		query.append("                                                /*Allocation Slot by Port구하기.*/" ).append("\n"); 
		query.append("                                             , (SELECT BSA.PORT_BSA_CAPA " ).append("\n"); 
		query.append("                                                  FROM BSA_VVD_PORT_DWN BSA" ).append("\n"); 
		query.append("                                                 WHERE 1=1 " ).append("\n"); 
		query.append("                                                   AND BSA.BSA_OP_JB_CD = '007' " ).append("\n"); 
		query.append("                                                   AND BSA.PORT_SEQ     <> 999" ).append("\n"); 
		query.append("                                                   --AND BSA.TRD_CD       = VPS.TRD_CD" ).append("\n"); 
		query.append("                                                   AND BSA.RLANE_CD     = VPS.RLANE_CD " ).append("\n"); 
		query.append("                                                   AND BSA.VSL_CD       = VPS.VSL_CD " ).append("\n"); 
		query.append("                                                   AND BSA.SKD_VOY_NO   = VPS.SKD_VOY_NO" ).append("\n"); 
		query.append("                                                   AND BSA.SKD_DIR_CD   = VPS.SKD_DIR_CD" ).append("\n"); 
		query.append("                                                   AND BSA.CRR_CD       = @[slan_cd]" ).append("\n"); 
		query.append("                                                   AND BSA.PORT_CD      = VPS.VPS_PORT_CD" ).append("\n"); 
		query.append("                                               ) AS ALLOC_PORT_SLOT" ).append("\n"); 
		query.append("                                          FROM V_PORT_LIST VPS" ).append("\n"); 
		query.append("                                         WHERE 1=1" ).append("\n"); 
		query.append("                                           AND VPS.TP = 'B'" ).append("\n"); 
		query.append("                                           AND VPS.ORD > 0" ).append("\n"); 
		query.append("                                        ) VPS" ).append("\n"); 
		query.append("                               ) V" ).append("\n"); 
		query.append("                             , (                 " ).append("\n"); 
		query.append("                                SELECT SP.SLAN_CD" ).append("\n"); 
		query.append("                                     , SP.VSL_CD" ).append("\n"); 
		query.append("                                     , SP.VOY_NO" ).append("\n"); 
		query.append("                                     , SP.DIR_CD" ).append("\n"); 
		query.append("                                     , SP.PORT_CD" ).append("\n"); 
		query.append("                                     , DECODE(SP.OPTION_B, 'OPTION1', NVL(SP.B_LDN_TEU + SP.B_ETY_TEU, 0), NVL(SP.L_LDN_TEU + SP.L_ETY_TEU, 0))  AS SUM_TOTAL_TEU" ).append("\n"); 
		query.append("                                     , DECODE(SP.OPTION_B, 'OPTION1', SP.B_LDN_TEU , SP.L_LDN_TEU) AS SUM_LDN_TEU " ).append("\n"); 
		query.append("                                     , DECODE(SP.OPTION_B, 'OPTION1', SP.B_ETY_TEU , SP.L_ETY_TEU) AS SUM_ETY_TEU" ).append("\n"); 
		query.append("                                     , DECODE(SP.OPTION_B, 'OPTION1', SP.B_WEIGHT  , SP.L_WEIGHT) AS SUM_WGT_TON" ).append("\n"); 
		query.append("                                     , DECODE(SP.OPTION_B, 'OPTION1', SP.B_RF      , SP.L_RF) AS SUM_RF_PLUG --Option1 : on board, Option2 : load " ).append("\n"); 
		query.append("                                     , SP.OPTION_A" ).append("\n"); 
		query.append("                                     , SP.OPTION_B" ).append("\n"); 
		query.append("                                  FROM (SELECT SP.TP" ).append("\n"); 
		query.append("                                             , SP.SLAN_CD" ).append("\n"); 
		query.append("                                             , SP.VSL_CD" ).append("\n"); 
		query.append("                                             , SP.VOY_NO" ).append("\n"); 
		query.append("                                             , SP.DIR_CD" ).append("\n"); 
		query.append("                                             , SP.PORT_CD" ).append("\n"); 
		query.append("                                             , NVL((SELECT NVL(OP.ATTR_CTNT2,'OPTION1')" ).append("\n"); 
		query.append("                                                  FROM JOO_COM_PPT OP" ).append("\n"); 
		query.append("                                                 WHERE OP.PPT_CD     = 'OPTION'" ).append("\n"); 
		query.append("                                                   AND OP.ATTR_CTNT1 = SP.SLAN_CD" ).append("\n"); 
		query.append("                                                   AND OP.ATTR_CTNT1 IS NOT NULL" ).append("\n"); 
		query.append("                                                   AND OP.ATTR_CTNT2 IS NOT NULL" ).append("\n"); 
		query.append("                                                   AND ROWNUM = 1" ).append("\n"); 
		query.append("                                                ), 'OPTION1') AS OPTION_A" ).append("\n"); 
		query.append("                                             , NVL((SELECT NVL(OP.ATTR_CTNT3,'OPTION1')" ).append("\n"); 
		query.append("                                                  FROM JOO_COM_PPT OP" ).append("\n"); 
		query.append("                                                 WHERE OP.PPT_CD     = 'OPTION'" ).append("\n"); 
		query.append("                                                   AND OP.ATTR_CTNT1 = SP.SLAN_CD" ).append("\n"); 
		query.append("                                                   AND OP.ATTR_CTNT1 IS NOT NULL" ).append("\n"); 
		query.append("                                                   AND OP.ATTR_CTNT3 IS NOT NULL" ).append("\n"); 
		query.append("                                                   AND ROWNUM = 1" ).append("\n"); 
		query.append("                                                ), 'OPTION1') AS OPTION_B" ).append("\n"); 
		query.append("                                             , NVL(SUM(SP.B_LDN_TEU),0) AS B_LDN_TEU" ).append("\n"); 
		query.append("                                             , NVL(SUM(SP.B_ETY_TEU),0) AS B_ETY_TEU" ).append("\n"); 
		query.append("                                             , NVL(SUM(SP.B_WEIGHT),0) AS B_WEIGHT" ).append("\n"); 
		query.append("                                             , NVL(SUM(SP.B_RF),0) AS B_RF" ).append("\n"); 
		query.append("                                             , NVL(SUM(SP.L_LDN_TEU),0) AS L_LDN_TEU" ).append("\n"); 
		query.append("                                             , NVL(SUM(SP.L_ETY_TEU),0) AS L_ETY_TEU" ).append("\n"); 
		query.append("                                             , NVL(SUM(SP.L_WEIGHT),0) AS L_WEIGHT" ).append("\n"); 
		query.append("                                             , NVL(SUM(SP.L_RF),0) AS L_RF" ).append("\n"); 
		query.append("                                          FROM (" ).append("\n"); 
		query.append("                                                /*Balnace : Summary By Port -Ldn TEU, Ety TEU, Wgt(Ton), RF Plug*/" ).append("\n"); 
		query.append("                                                SELECT /*+ LEADING(BAY) */ -- TUNING(2016/10/07)" ).append("\n"); 
		query.append("                                                       'B' AS TP" ).append("\n"); 
		query.append("                                                     , BAY.SLAN_CD" ).append("\n"); 
		query.append("                                                     , BAY.VSL_CD" ).append("\n"); 
		query.append("                                                     , BAY.VOY_NO" ).append("\n"); 
		query.append("                                                     , BAY.DIR_CD" ).append("\n"); 
		query.append("                                                     , BAY.PORT_CD" ).append("\n"); 
		query.append("                                                     , DECODE(BAY.FE, 'F', TEU.TEU, 0) AS B_LDN_TEU" ).append("\n"); 
		query.append("                                                     , DECODE(BAY.FE, 'E', TEU.TEU, 0) AS B_ETY_TEU" ).append("\n"); 
		query.append("                                                     , BAY.B_WEIGHT" ).append("\n"); 
		query.append("                                                     , BAY.B_RF" ).append("\n"); 
		query.append("                                                     , NULL AS L_LDN_TEU" ).append("\n"); 
		query.append("                                                     , NULL AS L_ETY_TEU" ).append("\n"); 
		query.append("                                                     , NULL AS L_WEIGHT" ).append("\n"); 
		query.append("                                                     , NULL AS L_RF" ).append("\n"); 
		query.append("                                                     , BAY.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("                                                  FROM V_COM_TEU TEU" ).append("\n"); 
		query.append("                                                     , (" ).append("\n"); 
		query.append("                                                        SELECT /*+ NO_MERGE LEADING(VPS) INDEX(BAY XAK2BAY_PLAN) */ -- TUNING(2016/10/07)" ).append("\n"); 
		query.append("                                                               VPS.SLAN_CD" ).append("\n"); 
		query.append("                                                             , VPS.VSL_CD" ).append("\n"); 
		query.append("                                                             , VPS.SKD_VOY_NO AS VOY_NO" ).append("\n"); 
		query.append("                                                             , VPS.SKD_DIR_CD AS DIR_CD" ).append("\n"); 
		query.append("                                                             , BAY.PORT_CD" ).append("\n"); 
		query.append("                                                             , BAY.FE" ).append("\n"); 
		query.append("                                                             , BAY.WEIGHT AS B_WEIGHT" ).append("\n"); 
		query.append("                                                             , CASE WHEN BAY.FE = 'F' AND BAY.CNTR_TYPE = 'R' AND BAY.TEMP IS NOT NULL THEN 1" ).append("\n"); 
		query.append("                                                                    ELSE 0" ).append("\n"); 
		query.append("                                                               END  AS B_RF" ).append("\n"); 
		query.append("                                                             , CASE WHEN BAY.FE = 'F' AND BAY.CNTR_TYPE = 'R' AND BAY.TEMP IS NULL THEN BAY.FE||SZTP.RAD_CNTR_TPSZ_CD" ).append("\n"); 
		query.append("                                                                    ELSE BAY.FE||SZTP.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("                                                               END AS CNTR_TPSZ_CD" ).append("\n"); 
		query.append("                                                          FROM V_PORT_LIST VPS" ).append("\n"); 
		query.append("                                                             , BAY_PLAN BAY" ).append("\n"); 
		query.append("                                                             , V_COM_TOT_SZ_TP SZTP" ).append("\n"); 
		query.append("                                                         WHERE 1=1" ).append("\n"); 
		query.append("                                                           AND VPS.TP           = 'B'" ).append("\n"); 
		query.append("                                                           AND VPS.ORD          > 0" ).append("\n"); 
		query.append("                                                           AND VPS.VSL_CD       = BAY.VSL_CD" ).append("\n"); 
		query.append("                                                           AND VPS.SKD_VOY_NO   = BAY.VOY_NO" ).append("\n"); 
		query.append("                                                           AND VPS.SKD_DIR_CD   = BAY.DIR_CD" ).append("\n"); 
		query.append("                                                           AND VPS.VPS_PORT_CD  = BAY.PORT_CD" ).append("\n"); 
		query.append("                                                           AND VPS.CLPT_IND_SEQ = BAY.CALL_IND" ).append("\n"); 
		query.append("                                                           AND BAY.FE           IN ( 'F' , 'E')" ).append("\n"); 
		query.append("                                                           AND BAY.FE           = SZTP.CNTR_TP_CD" ).append("\n"); 
		query.append("                                                           AND BAY.SZTP         = SZTP.NMR_CNTR_TPSZ_CD" ).append("\n"); 
		query.append("                                                           AND BAY.OPR_CD 		= @[slan_cd]" ).append("\n"); 
		query.append("                                                           AND BAY.POL IS NOT NULL" ).append("\n"); 
		query.append("                                                           AND BAY.POD IS NOT NULL" ).append("\n"); 
		query.append("                                                       ) BAY" ).append("\n"); 
		query.append("                                                 WHERE 1=1" ).append("\n"); 
		query.append("                                                   AND TEU.CNTR_TP_CD || TEU.CNTR_TPSZ_CD   = BAY.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("                                                   AND TEU.SLAN_CD                          = BAY.SLAN_CD" ).append("\n"); 
		query.append("                                                 UNION ALL" ).append("\n"); 
		query.append("                                                /*Loding : Summary By Port -Ldn TEU, Ety TEU, Wgt(Ton), RF Plug*/ " ).append("\n"); 
		query.append("                                                SELECT /*+ LEADING(BAY) */ -- TUNING(2016/10/07)" ).append("\n"); 
		query.append("                                                       'B' AS TP" ).append("\n"); 
		query.append("                                                     , BAY.SLAN_CD" ).append("\n"); 
		query.append("                                                     , BAY.VSL_CD" ).append("\n"); 
		query.append("                                                     , BAY.VOY_NO" ).append("\n"); 
		query.append("                                                     , BAY.DIR_CD" ).append("\n"); 
		query.append("                                                     , BAY.PORT_CD" ).append("\n"); 
		query.append("                                                     , NULL AS B_LDN_TEU" ).append("\n"); 
		query.append("                                                     , NULL AS B_ETY_TEU" ).append("\n"); 
		query.append("                                                     , NULL AS B_WEIGHT" ).append("\n"); 
		query.append("                                                     , NULL AS B_RF" ).append("\n"); 
		query.append("                                                     , DECODE(BAY.FE, 'F', TEU.TEU, 0) AS L_LDN_TEU" ).append("\n"); 
		query.append("                                                     , DECODE(BAY.FE, 'E', TEU.TEU, 0) AS L_ETY_TEU" ).append("\n"); 
		query.append("                                                     , BAY.L_WEIGHT" ).append("\n"); 
		query.append("                                                     , BAY.L_RF" ).append("\n"); 
		query.append("                                                     , BAY.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("                                                  FROM V_COM_TEU TEU" ).append("\n"); 
		query.append("                                                     , (" ).append("\n"); 
		query.append("                                                        SELECT /*+ NO_MERGE LEADING(VPS) INDEX(BAY XAK2BAY_PLAN) */ -- TUNING(2016/10/07)" ).append("\n"); 
		query.append("                                                               VPS.SLAN_CD" ).append("\n"); 
		query.append("                                                             , VPS.VSL_CD" ).append("\n"); 
		query.append("                                                             , VPS.SKD_VOY_NO AS VOY_NO" ).append("\n"); 
		query.append("                                                             , VPS.SKD_DIR_CD AS DIR_CD" ).append("\n"); 
		query.append("                                                             , BAY.PORT_CD" ).append("\n"); 
		query.append("                                                             , BAY.FE" ).append("\n"); 
		query.append("                                                             , BAY.WEIGHT AS L_WEIGHT" ).append("\n"); 
		query.append("                                                             , CASE WHEN BAY.FE = 'F' AND BAY.CNTR_TYPE = 'R' AND BAY.TEMP IS NOT NULL THEN 1" ).append("\n"); 
		query.append("                                                                    ELSE 0" ).append("\n"); 
		query.append("                                                               END  AS L_RF" ).append("\n"); 
		query.append("                                                             , CASE WHEN BAY.FE = 'F' AND BAY.CNTR_TYPE = 'R' AND BAY.TEMP IS NULL THEN BAY.FE||SZTP.RAD_CNTR_TPSZ_CD" ).append("\n"); 
		query.append("                                                                    ELSE BAY.FE||SZTP.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("                                                               END AS CNTR_TPSZ_CD" ).append("\n"); 
		query.append("                                                          FROM V_PORT_LIST VPS" ).append("\n"); 
		query.append("                                                             , BAY_PLAN BAY" ).append("\n"); 
		query.append("                                                             , V_COM_TOT_SZ_TP SZTP" ).append("\n"); 
		query.append("                                                         WHERE 1=1" ).append("\n"); 
		query.append("                                                           AND VPS.TP           = 'L'" ).append("\n"); 
		query.append("                                                           AND VPS.ORD          > 0" ).append("\n"); 
		query.append("                                                           AND VPS.VSL_CD       = BAY.VSL_CD" ).append("\n"); 
		query.append("                                                           AND VPS.SKD_VOY_NO   = BAY.VOY_NO" ).append("\n"); 
		query.append("                                                           AND VPS.SKD_DIR_CD   = BAY.DIR_CD" ).append("\n"); 
		query.append("                                                           AND VPS.VPS_PORT_CD  = BAY.PORT_CD" ).append("\n"); 
		query.append("                                                           AND VPS.CLPT_IND_SEQ = BAY.CALL_IND" ).append("\n"); 
		query.append("                                                           AND VPS.VPS_PORT_CD  = BAY.POL       /*Loding Condition*/" ).append("\n"); 
		query.append("                                                           AND BAY.FE           IN ( 'F' , 'E')" ).append("\n"); 
		query.append("                                                           AND BAY.FE           = SZTP.CNTR_TP_CD" ).append("\n"); 
		query.append("                                                           AND BAY.SZTP         = SZTP.NMR_CNTR_TPSZ_CD" ).append("\n"); 
		query.append("                                                           AND BAY.OPR_CD 		= @[slan_cd]" ).append("\n"); 
		query.append("                                                           AND BAY.POL IS NOT NULL" ).append("\n"); 
		query.append("                                                           AND BAY.POD IS NOT NULL" ).append("\n"); 
		query.append("                                                       ) BAY" ).append("\n"); 
		query.append("                                                 WHERE 1=1" ).append("\n"); 
		query.append("                                                   AND TEU.CNTR_TP_CD || TEU.CNTR_TPSZ_CD   = BAY.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("                                                   AND TEU.SLAN_CD                          = BAY.SLAN_CD" ).append("\n"); 
		query.append("                                                 ) SP" ).append("\n"); 
		query.append("                                        GROUP BY SP.TP" ).append("\n"); 
		query.append("                                                 , SP.SLAN_CD" ).append("\n"); 
		query.append("                                                 , SP.VSL_CD" ).append("\n"); 
		query.append("                                                 , SP.VOY_NO" ).append("\n"); 
		query.append("                                                 , SP.DIR_CD" ).append("\n"); 
		query.append("                                                 , SP.PORT_CD" ).append("\n"); 
		query.append("                                    ) SP" ).append("\n"); 
		query.append("                               ) P" ).append("\n"); 
		query.append("                        WHERE 1=1      " ).append("\n"); 
		query.append("                          AND V.SLAN_CD = P.SLAN_CD(+)" ).append("\n"); 
		query.append("                          AND V.VSL_CD  = P.VSL_CD(+)" ).append("\n"); 
		query.append("                          AND V.VOY_NO  = P.VOY_NO(+)" ).append("\n"); 
		query.append("                          AND V.DIR_CD  = P.DIR_CD(+)" ).append("\n"); 
		query.append("                          AND V.PORT_CD = P.PORT_CD(+) " ).append("\n"); 
		query.append("                      ) SP" ).append("\n"); 
		query.append("                    , V_TP TP" ).append("\n"); 
		query.append("               ) S" ).append("\n"); 
		query.append("         WHERE 1=1" ).append("\n"); 
		query.append("           AND P.ORD            > 0 -- 이전항차는 보여줄 필요가 없다. 이미 안에서 구한 부분입니다." ).append("\n"); 
		query.append("           AND P.TP             = L.TYPE(+)" ).append("\n"); 
		query.append("           AND P.VSL_CD         = L.VSL_CD (+)" ).append("\n"); 
		query.append("           AND P.SKD_VOY_NO     = L.VOY_NO (+)" ).append("\n"); 
		query.append("           AND P.SKD_DIR_CD     = L.DIR_CD (+)" ).append("\n"); 
		query.append("           AND P.VPS_PORT_CD    = L.PORT_CD(+)" ).append("\n"); 
		query.append("           AND P.TP             = V.TYPE(+)" ).append("\n"); 
		query.append("           AND P.VSL_CD         = V.VSL_CD (+)" ).append("\n"); 
		query.append("           AND P.SKD_VOY_NO     = V.VOY_NO (+)" ).append("\n"); 
		query.append("           AND P.SKD_DIR_CD     = V.DIR_CD (+)" ).append("\n"); 
		query.append("           AND P.VPS_PORT_CD    = V.PORT_CD(+)" ).append("\n"); 
		query.append("           AND P.TP             = S.TYPE(+)" ).append("\n"); 
		query.append("           AND P.VSL_CD         = S.VSL_CD (+)" ).append("\n"); 
		query.append("           AND P.SKD_VOY_NO     = S.VOY_NO (+)" ).append("\n"); 
		query.append("           AND P.SKD_DIR_CD     = S.DIR_CD (+)" ).append("\n"); 
		query.append("           AND P.VPS_PORT_CD    = S.PORT_CD(+)" ).append("\n"); 
		query.append("         ORDER BY P.ORD, P.CLPT_SEQ, P.TP_ORD" ).append("\n"); 
		query.append("    ) P" ).append("\n"); 
		query.append(" ORDER BY P.ORD, P.CLPT_SEQ, P.TP_ORD" ).append("\n"); 

	}
}