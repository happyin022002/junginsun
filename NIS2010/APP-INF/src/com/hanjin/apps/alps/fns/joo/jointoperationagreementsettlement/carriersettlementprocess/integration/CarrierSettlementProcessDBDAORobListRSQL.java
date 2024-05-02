/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : CarrierSettlementProcessDBDAORobListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.10.10
*@LastModifier : 
*@LastVersion : 1.0
* 2016.10.10 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.carriersettlementprocess.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CarrierSettlementProcessDBDAORobListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Container Loading/Discharging List 조회
	  * </pre>
	  */
	public CarrierSettlementProcessDBDAORobListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pol_split_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("in_rc_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("in_awk_cgo_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("in_rd_cgo_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("in_pol_yd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("in_hot_de_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("in_vvd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("in_bb_cgo_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("in_prct_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("in_dcgo_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("in_soc_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("in_pol_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("in_hngr_flg",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.carriersettlementprocess.integration").append("\n"); 
		query.append("FileName : CarrierSettlementProcessDBDAORobListRSQL").append("\n"); 
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
		query.append("WITH PRE_VVD AS ( " ).append("\n"); 
		query.append("SELECT DISTINCT " ).append("\n"); 
		query.append("   VSL_CD" ).append("\n"); 
		query.append("  ,TURN_SKD_VOY_NO AS SKD_VOY_NO" ).append("\n"); 
		query.append("  ,TURN_SKD_DIR_CD AS SKD_DIR_CD" ).append("\n"); 
		query.append("FROM VSK_VSL_PORT_SKD" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND LEVEL <= FLOOR(TO_NUMBER('3')/2)" ).append("\n"); 
		query.append("AND (TURN_SKD_VOY_NO IS NOT NULL OR TURN_SKD_DIR_CD IS NOT NULL) START WITH VSL_CD = SUBSTR(@[in_vvd_cd],1,4)" ).append("\n"); 
		query.append("AND SKD_VOY_NO = SUBSTR(@[in_vvd_cd],5,4)" ).append("\n"); 
		query.append("AND SKD_DIR_CD = SUBSTR(@[in_vvd_cd],9,1)" ).append("\n"); 
		query.append("AND TURN_PORT_IND_CD IN ('Y','N') CONNECT BY PRIOR TURN_SKD_VOY_NO = SKD_VOY_NO" ).append("\n"); 
		query.append("AND PRIOR TURN_SKD_DIR_CD = SKD_DIR_CD" ).append("\n"); 
		query.append("AND PRIOR VSL_CD = VSL_CD" ).append("\n"); 
		query.append("AND TURN_PORT_IND_CD IN ('Y','N')" ).append("\n"); 
		query.append("AND LEVEL <= FLOOR(TO_NUMBER('3')/2)" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append(", VSL_SKD AS (" ).append("\n"); 
		query.append("    SELECT" ).append("\n"); 
		query.append("    S.*" ).append("\n"); 
		query.append("    FROM" ).append("\n"); 
		query.append("    (       " ).append("\n"); 
		query.append("        SELECT  " ).append("\n"); 
		query.append("          '1' AS GUBUN" ).append("\n"); 
		query.append("         ,(SELECT VSL_CD||SKD_VOY_NO||SKD_DIR_CD FROM PRE_VVD) AS VVD" ).append("\n"); 
		query.append("         ,T2.CLPT_SEQ" ).append("\n"); 
		query.append("         ,T2.VPS_PORT_CD" ).append("\n"); 
		query.append("         ,T2.YD_CD" ).append("\n"); 
		query.append("         ,DECODE(T2.YD_CD, NULL, '', SUBSTR(T2.YD_CD, 6, 2)) AS TML_CD" ).append("\n"); 
		query.append("		 ,T2.CLPT_IND_SEQ" ).append("\n"); 
		query.append("        FROM VSK_VSL_SKD T1" ).append("\n"); 
		query.append("           , VSK_VSL_PORT_SKD T2" ).append("\n"); 
		query.append("        WHERE 1=1" ).append("\n"); 
		query.append("        AND T1.VSL_CD      = T2.VSL_CD" ).append("\n"); 
		query.append("        AND T1.SKD_VOY_NO    = T2.SKD_VOY_NO" ).append("\n"); 
		query.append("        AND T1.SKD_DIR_CD    = T2.SKD_DIR_CD" ).append("\n"); 
		query.append("        AND T1.VSL_CD     = SUBSTR((SELECT VSL_CD||SKD_VOY_NO||SKD_DIR_CD FROM PRE_VVD),1,4)" ).append("\n"); 
		query.append("        AND T1.SKD_VOY_NO = SUBSTR((SELECT VSL_CD||SKD_VOY_NO||SKD_DIR_CD FROM PRE_VVD),5,4)" ).append("\n"); 
		query.append("        AND T1.SKD_DIR_CD = SUBSTR((SELECT VSL_CD||SKD_VOY_NO||SKD_DIR_CD FROM PRE_VVD),9,1)                     " ).append("\n"); 
		query.append("        AND T2.TURN_PORT_IND_CD NOT IN ('D','V','F')   " ).append("\n"); 
		query.append("        AND NVL(T2.SKD_CNG_STS_CD, 'A') <>  'S'          " ).append("\n"); 
		query.append("        UNION ALL" ).append("\n"); 
		query.append("        SELECT  " ).append("\n"); 
		query.append("          '2' AS GUBUN" ).append("\n"); 
		query.append("         ,@[in_vvd_cd] AS VVD" ).append("\n"); 
		query.append("         ,T2.CLPT_SEQ" ).append("\n"); 
		query.append("         ,T2.VPS_PORT_CD" ).append("\n"); 
		query.append("         ,T2.YD_CD" ).append("\n"); 
		query.append("         ,DECODE(T2.YD_CD, NULL, '', SUBSTR(T2.YD_CD, 6, 2)) AS TML_CD" ).append("\n"); 
		query.append("		 ,T2.CLPT_IND_SEQ" ).append("\n"); 
		query.append("        FROM VSK_VSL_SKD T1" ).append("\n"); 
		query.append("           , VSK_VSL_PORT_SKD T2" ).append("\n"); 
		query.append("        WHERE 1=1" ).append("\n"); 
		query.append("        AND T1.VSL_CD      = T2.VSL_CD" ).append("\n"); 
		query.append("        AND T1.SKD_VOY_NO    = T2.SKD_VOY_NO" ).append("\n"); 
		query.append("        AND T1.SKD_DIR_CD    = T2.SKD_DIR_CD" ).append("\n"); 
		query.append("        AND T1.VSL_CD     = SUBSTR(@[in_vvd_cd],1,4)" ).append("\n"); 
		query.append("        AND T1.SKD_VOY_NO = SUBSTR(@[in_vvd_cd],5,4)" ).append("\n"); 
		query.append("        AND T1.SKD_DIR_CD = SUBSTR(@[in_vvd_cd],9,1)                     " ).append("\n"); 
		query.append("        AND T2.TURN_PORT_IND_CD NOT IN ('D','V','F')   -- ???? ??" ).append("\n"); 
		query.append("        AND NVL(T2.SKD_CNG_STS_CD, 'A') <>  'S'   " ).append("\n"); 
		query.append("    ) S" ).append("\n"); 
		query.append("    ORDER BY S.GUBUN ASC, S.CLPT_SEQ ASC" ).append("\n"); 
		query.append(")   " ).append("\n"); 
		query.append(", ROB_LIST AS (" ).append("\n"); 
		query.append("	SELECT	" ).append("\n"); 
		query.append("		CNTR_NO, " ).append("\n"); 
		query.append("		CNTR_TPSZ_CD, " ).append("\n"); 
		query.append("		CNTR_WGT, " ).append("\n"); 
		query.append("		TO_CHAR(A_CNTR_WGT,'9,999,990.00') A_CNTR_WGT," ).append("\n"); 
		query.append("		ROUND((round(nvl(ACT_WGT, 0) * decode(substr(CNTR_TPSZ_CD, 2, 1), '2', 1, 2) / TOT, 2) + " ).append("\n"); 
		query.append("		NVL(CNTR_VOL_QTY, 1) * DECODE(NVL(MST_TARE,0), 0, DECODE(NVL(MDM_TARE,0), 0, 0, MDM_TARE), MST_TARE))/1000, 2) E_CNTR_WGT," ).append("\n"); 
		query.append("		POL_CD," ).append("\n"); 
		query.append("		POL_YD_CD," ).append("\n"); 
		query.append("		POD_CD," ).append("\n"); 
		query.append("		POD_YD_CD,        " ).append("\n"); 
		query.append("		A_POL_CD, " ).append("\n"); 
		query.append("		POL_NOD_CD," ).append("\n"); 
		query.append("		A_POD_CD,    " ).append("\n"); 
		query.append("		POD_NOD_CD,    " ).append("\n"); 
		query.append("		RCV_TERM_CD," ).append("\n"); 
		query.append("		DE_TERM_CD," ).append("\n"); 
		query.append("		TS_CD,	" ).append("\n"); 
		query.append("		BKG_CGO_TP_CD," ).append("\n"); 
		query.append("		HOT_DE_FLG," ).append("\n"); 
		query.append("		'' SPCL_CGO_DESC_TYPE," ).append("\n"); 
		query.append("		'' SPCL_CGO_DESC" ).append("\n"); 
		query.append("		,SLAN_CD" ).append("\n"); 
		query.append("		,DCGO_FLG" ).append("\n"); 
		query.append("		,RC_FLG" ).append("\n"); 
		query.append("		,AWK_CGO_FLG" ).append("\n"); 
		query.append("		,PRCT_FLG" ).append("\n"); 
		query.append("		,RD_CGO_FLG" ).append("\n"); 
		query.append("		,HNGR_FLG    " ).append("\n"); 
		query.append("		,VVD_CD" ).append("\n"); 
		query.append("		,BKG_NO" ).append("\n"); 
		query.append("		,POL_YD_CD2" ).append("\n"); 
		query.append("	    ,POD_YD_CD2" ).append("\n"); 
		query.append("	    ,BL_NO" ).append("\n"); 
		query.append("        ,VSL_SEQ " ).append("\n"); 
		query.append("        ,POL_CLPT_IND_SEQ " ).append("\n"); 
		query.append("        ,POD_CLPT_IND_SEQ   " ).append("\n"); 
		query.append("	FROM (" ).append("\n"); 
		query.append("		SELECT	 " ).append("\n"); 
		query.append("			CNTR.CNTR_NO,  " ).append("\n"); 
		query.append("			CNTR.CNTR_TPSZ_CD, " ).append("\n"); 
		query.append("			CNTR.CNTR_WGT  A_CNTR_WGT," ).append("\n"); 
		query.append("			ROUND(CNTR.CNTR_WGT/1000,0) CNTR_WGT,         " ).append("\n"); 
		query.append("			DOC.ACT_WGT," ).append("\n"); 
		query.append("			(" ).append("\n"); 
		query.append("				SELECT SUM(DECODE(SUBSTR(CNTR_TPSZ_CD,2,1),'2',1,2)) TOT " ).append("\n"); 
		query.append("				FROM BKG_CONTAINER BC" ).append("\n"); 
		query.append("				WHERE BC.BKG_NO = BKG.BKG_NO" ).append("\n"); 
		query.append("			) TOT,        " ).append("\n"); 
		query.append("			DECODE(NVL(CNTR.CNTR_VOL_QTY, 0), 0, 1, CNTR.CNTR_VOL_QTY) CNTR_VOL_QTY,  " ).append("\n"); 
		query.append("		   (SELECT NVL(SPEC.TARE_WGT, 0) MST_WGT" ).append("\n"); 
		query.append("			  FROM MST_CONTAINER MST," ).append("\n"); 
		query.append("				   MST_CNTR_SPEC SPEC" ).append("\n"); 
		query.append("			 WHERE MST.CNTR_NO = CNTR.CNTR_NO" ).append("\n"); 
		query.append("			   AND MST.CNTR_SPEC_NO = SPEC.CNTR_SPEC_NO ) MST_TARE," ).append("\n"); 
		query.append("		   (SELECT NVL(MDM.CNTR_TPSZ_TARE_WGT, 0) MDM_WGT" ).append("\n"); 
		query.append("             FROM MDM_CNTR_TP_SZ MDM         " ).append("\n"); 
		query.append("             WHERE MDM.CNTR_TPSZ_CD = CNTR.CNTR_TPSZ_CD  " ).append("\n"); 
		query.append("			) MDM_TARE,       " ).append("\n"); 
		query.append("			VVD.POL_CD," ).append("\n"); 
		query.append("			SUBSTR(VVD.POL_YD_CD,6,2) POL_YD_CD," ).append("\n"); 
		query.append("			VVD.POD_CD," ).append("\n"); 
		query.append("			SUBSTR(VVD.POD_YD_CD,6,2) POD_YD_CD," ).append("\n"); 
		query.append("			BKG.POL_CD A_POL_CD,        " ).append("\n"); 
		query.append("			SUBSTR(BKG.POL_NOD_CD,6,2) POL_NOD_CD," ).append("\n"); 
		query.append("			BKG.POD_CD A_POD_CD," ).append("\n"); 
		query.append("			SUBSTR(BKG.POD_NOD_CD,6,2) POD_NOD_CD        " ).append("\n"); 
		query.append("			,CNTR.RCV_TERM_CD        " ).append("\n"); 
		query.append("			,CNTR.DE_TERM_CD        " ).append("\n"); 
		query.append("			,DECODE(BKG.POL_CD,VVD.POL_CD,'L','T') TS_CD        " ).append("\n"); 
		query.append("			,BKG.BKG_CGO_TP_CD" ).append("\n"); 
		query.append("			,BKG.HOT_DE_FLG        " ).append("\n"); 
		query.append("			,VVD.SLAN_CD" ).append("\n"); 
		query.append("			,CNTR.DCGO_FLG" ).append("\n"); 
		query.append("			,CNTR.RC_FLG" ).append("\n"); 
		query.append("			,CNTR.AWK_CGO_FLG" ).append("\n"); 
		query.append("			,BKG.PRCT_FLG   " ).append("\n"); 
		query.append("			,CNTR.RD_CGO_FLG RD_CGO_FLG         " ).append("\n"); 
		query.append("			,CNTR.HNGR_FLG" ).append("\n"); 
		query.append("			,VVD.VSL_CD||VVD.SKD_VOY_NO||VVD.SKD_DIR_CD VVD_CD        " ).append("\n"); 
		query.append("			,BKG.BKG_NO" ).append("\n"); 
		query.append("            ,VVD.POL_YD_CD AS POL_YD_CD2" ).append("\n"); 
		query.append("			,VVD.POD_YD_CD AS POD_YD_CD2" ).append("\n"); 
		query.append("			,BKG.BL_NO||BKG.BL_TP_CD BL_NO" ).append("\n"); 
		query.append("            ,VVD.VSL_SEQ " ).append("\n"); 
		query.append("            ,VVD.POL_CLPT_IND_SEQ " ).append("\n"); 
		query.append("            ,VVD.POD_CLPT_IND_SEQ " ).append("\n"); 
		query.append("		FROM	" ).append("\n"); 
		query.append("			BKG_BOOKING BKG, " ).append("\n"); 
		query.append("			BKG_CONTAINER CNTR, " ).append("\n"); 
		query.append("			BKG_BL_DOC DOC," ).append("\n"); 
		query.append("			BKG_VVD VVD, " ).append("\n"); 
		query.append("			BKG_CUSTOMER BCS, " ).append("\n"); 
		query.append("			MDM_LOCATION MDM" ).append("\n"); 
		query.append("			,(SELECT TRIM(COLUMN_VALUE) AS VVD_CD FROM TABLE(BKG_SPLIT_FNC((SELECT VSL_CD || SKD_VOY_NO || SKD_DIR_CD AS PRE_VVD FROM PRE_VVD) || ',' || @[in_vvd_cd],','))) TEMP " ).append("\n"); 
		query.append("		WHERE	1=1" ).append("\n"); 
		query.append("		AND (    " ).append("\n"); 
		query.append("			 (" ).append("\n"); 
		query.append("					VVD.VSL_CD = SUBSTR(TEMP.VVD_CD,1,4)" ).append("\n"); 
		query.append("				AND VVD.SKD_VOY_NO = SUBSTR(TEMP.VVD_CD,5,4)" ).append("\n"); 
		query.append("				AND VVD.SKD_DIR_CD = SUBSTR(TEMP.VVD_CD,9,1)" ).append("\n"); 
		query.append("				AND VVD.SKD_DIR_CD <> SUBSTR(@[in_vvd_cd],9,1)            " ).append("\n"); 
		query.append("				AND VVD.POL_CD IN (SELECT VPS_PORT_CD FROM VSL_SKD WHERE GUBUN = 1)    " ).append("\n"); 
		query.append("				AND VVD.POD_CD NOT IN (SELECT VPS_PORT_CD FROM VSL_SKD WHERE GUBUN = 1)            " ).append("\n"); 
		query.append("				AND BKG.BKG_STS_CD  <> 'S'	    " ).append("\n"); 
		query.append("				AND BKG.BKG_NO = VVD.BKG_NO" ).append("\n"); 
		query.append("				AND BKG.BKG_NO = CNTR.BKG_NO" ).append("\n"); 
		query.append("				AND BKG.BKG_NO = DOC.BKG_NO	" ).append("\n"); 
		query.append("				AND BKG.BKG_NO = BCS.BKG_NO" ).append("\n"); 
		query.append("				AND BCS.BKG_CUST_TP_CD = 'S'" ).append("\n"); 
		query.append("				AND NVL(BKG.BKG_STS_CD,' ') NOT IN ('X','A')" ).append("\n"); 
		query.append("				AND MDM.LOC_CD = BKG.DEL_CD               " ).append("\n"); 
		query.append("			 ) " ).append("\n"); 
		query.append("			 OR         " ).append("\n"); 
		query.append("			 (" ).append("\n"); 
		query.append("					VVD.VSL_CD = SUBSTR(TEMP.VVD_CD,1,4)" ).append("\n"); 
		query.append("				AND VVD.SKD_VOY_NO = SUBSTR(TEMP.VVD_CD,5,4)" ).append("\n"); 
		query.append("				AND VVD.SKD_DIR_CD = SUBSTR(TEMP.VVD_CD,9,1)         " ).append("\n"); 
		query.append("				AND VVD.VSL_CD = SUBSTR(@[in_vvd_cd],1,4)" ).append("\n"); 
		query.append("				AND VVD.SKD_VOY_NO = SUBSTR(@[in_vvd_cd],5,4)" ).append("\n"); 
		query.append("				AND VVD.SKD_DIR_CD = SUBSTR(@[in_vvd_cd],9,1)" ).append("\n"); 
		query.append("				AND (VVD.POL_YD_CD, VVD.POL_CLPT_IND_SEQ) IN (" ).append("\n"); 
		query.append("																SELECT YD_CD, CLPT_IND_SEQ FROM VSL_SKD " ).append("\n"); 
		query.append("																WHERE 1=1" ).append("\n"); 
		query.append("																AND GUBUN = 2" ).append("\n"); 
		query.append("																AND CLPT_SEQ <= (" ).append("\n"); 
		query.append("															                    SELECT NVL(CLPT_SEQ,0) FROM VSL_SKD V" ).append("\n"); 
		query.append("										                					    WHERE 1=1" ).append("\n"); 
		query.append("															                    AND V.GUBUN = 2" ).append("\n"); 
		query.append("															                    AND V.YD_CD = @[in_pol_cd] || @[in_pol_yd_cd]" ).append("\n"); 
		query.append("																				AND V.CLPT_IND_SEQ = @[pol_split_no]" ).append("\n"); 
		query.append("													                )" ).append("\n"); 
		query.append("															 )" ).append("\n"); 
		query.append("				AND BKG.BKG_STS_CD  <> 'S'	    " ).append("\n"); 
		query.append("				AND BKG.BKG_NO = VVD.BKG_NO" ).append("\n"); 
		query.append("				AND BKG.BKG_NO = CNTR.BKG_NO" ).append("\n"); 
		query.append("				AND BKG.BKG_NO = DOC.BKG_NO	" ).append("\n"); 
		query.append("				AND BKG.BKG_NO = BCS.BKG_NO" ).append("\n"); 
		query.append("				AND BCS.BKG_CUST_TP_CD = 'S'" ).append("\n"); 
		query.append("				AND NVL(BKG.BKG_STS_CD,' ') NOT IN ('X','A')" ).append("\n"); 
		query.append("				AND MDM.LOC_CD = BKG.DEL_CD               " ).append("\n"); 
		query.append("			 )" ).append("\n"); 
		query.append("		)   " ).append("\n"); 
		query.append("		AND (VVD.POD_YD_CD, VVD.POD_CLPT_IND_SEQ) NOT IN (" ).append("\n"); 
		query.append("															SELECT YD_CD, CLPT_IND_SEQ FROM VSL_SKD " ).append("\n"); 
		query.append("															WHERE 1=1" ).append("\n"); 
		query.append("															AND GUBUN = 2                                        " ).append("\n"); 
		query.append("															AND CLPT_SEQ <= (" ).append("\n"); 
		query.append("										                    					SELECT NVL(CLPT_SEQ,0) FROM VSL_SKD V" ).append("\n"); 
		query.append("															                    WHERE 1=1" ).append("\n"); 
		query.append("															                    AND V.GUBUN = 2" ).append("\n"); 
		query.append("															                    AND V.YD_CD = @[in_pol_cd] || @[in_pol_yd_cd]" ).append("\n"); 
		query.append("																				AND V.CLPT_IND_SEQ = @[pol_split_no]" ).append("\n"); 
		query.append("										                					)" ).append("\n"); 
		query.append("								  						)" ).append("\n"); 
		query.append("	#if (${in_dcgo_flg} == '' && ${in_rc_flg} == '' && ${in_awk_cgo_flg} == '' && ${in_bb_cgo_flg} == '' && ${in_stwg_cd} == '' && ${in_hot_de_flg} == '' && ${in_rd_cgo_flg} == '' && ${in_soc_flg} == '' && ${in_prct_flg} == '' && ${in_hngr_flg} == '')" ).append("\n"); 
		query.append("		AND '1' = '1'" ).append("\n"); 
		query.append("	#else" ).append("\n"); 
		query.append("		AND ( '1' = '2' " ).append("\n"); 
		query.append("		#if (${in_dcgo_flg} != '' ) " ).append("\n"); 
		query.append("			OR CNTR.DCGO_FLG = @[in_dcgo_flg]" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("		#if (${in_rc_flg} != '' ) " ).append("\n"); 
		query.append("			OR CNTR.RC_FLG = @[in_rc_flg]" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("		#if (${in_awk_cgo_flg} != '' ) " ).append("\n"); 
		query.append("			OR CNTR.AWK_CGO_FLG = @[in_awk_cgo_flg]" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("		#if (${in_bb_cgo_flg} != '' ) " ).append("\n"); 
		query.append("			OR CNTR.BB_CGO_FLG = @[in_bb_cgo_flg]" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("		#if (${in_stwg_cd} != '' ) " ).append("\n"); 
		query.append("			OR BKG.STWG_CD IS NOT NULL" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("		#if (${in_hot_de_flg} != '' ) " ).append("\n"); 
		query.append("			OR BKG.HOT_DE_FLG = @[in_hot_de_flg]" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("		#if (${in_rd_cgo_flg} != '' ) " ).append("\n"); 
		query.append("			OR CNTR.RD_CGO_FLG = @[in_rd_cgo_flg]" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("		#if (${in_soc_flg} != '' ) " ).append("\n"); 
		query.append("			OR CNTR.SOC_FLG = @[in_soc_flg]" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("		#if (${in_prct_flg} != '' ) " ).append("\n"); 
		query.append("			OR BKG.PRCT_FLG = @[in_prct_flg]" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("		#if (${in_hngr_flg} != '' ) " ).append("\n"); 
		query.append("			OR CNTR.HNGR_FLG = @[in_hngr_flg]" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("		)" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("	) TB1" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append(", CNTR_OVERLAP AS (" ).append("\n"); 
		query.append("    SELECT CNTR_NO FROM ROB_LIST" ).append("\n"); 
		query.append("    GROUP BY CNTR_NO" ).append("\n"); 
		query.append("    HAVING COUNT(CNTR_NO) > 1" ).append("\n"); 
		query.append(") " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("SELECT ROWNUM SEQ, A.*" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("  SELECT DISTINCT" ).append("\n"); 
		query.append("     DECODE(A.OVERLAP,'D',A.CNTR_NO || '(' || A.OVERLAP || ')',A.CNTR_NO) AS CNTR_NO " ).append("\n"); 
		query.append("    ,A.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("    ,A.CNTR_WGT" ).append("\n"); 
		query.append("    ,A.A_CNTR_WGT" ).append("\n"); 
		query.append("    ,A.E_CNTR_WGT" ).append("\n"); 
		query.append("    ,A.POL_CD" ).append("\n"); 
		query.append("    ,DECODE(POL_CLPT_IND_SEQ,1,A.POL_YD_CD,A.POL_YD_CD||'('||POL_CLPT_IND_SEQ||')') AS POL_YD_CD " ).append("\n"); 
		query.append("    ,A.POD_CD" ).append("\n"); 
		query.append("    ,DECODE(POD_CLPT_IND_SEQ,1,A.POD_YD_CD,A.POD_YD_CD||'('||POD_CLPT_IND_SEQ||')') AS POD_YD_CD " ).append("\n"); 
		query.append("    ,A.A_POL_CD " ).append("\n"); 
		query.append("    ,A.POL_NOD_CD" ).append("\n"); 
		query.append("    ,A.A_POD_CD    " ).append("\n"); 
		query.append("    ,A.POD_NOD_CD    " ).append("\n"); 
		query.append("    ,A.RCV_TERM_CD" ).append("\n"); 
		query.append("    ,A.DE_TERM_CD" ).append("\n"); 
		query.append("    ,A.TS_CD	" ).append("\n"); 
		query.append("    ,A.BKG_CGO_TP_CD" ).append("\n"); 
		query.append("    ,A.HOT_DE_FLG" ).append("\n"); 
		query.append("    ,A.SPCL_CGO_DESC_TYPE" ).append("\n"); 
		query.append("    ,A.SPCL_CGO_DESC" ).append("\n"); 
		query.append("    ,SLAN_CD" ).append("\n"); 
		query.append("    ,DCGO_FLG" ).append("\n"); 
		query.append("    ,RC_FLG" ).append("\n"); 
		query.append("    ,AWK_CGO_FLG" ).append("\n"); 
		query.append("    ,PRCT_FLG" ).append("\n"); 
		query.append("    ,RD_CGO_FLG" ).append("\n"); 
		query.append("    ,HNGR_FLG    " ).append("\n"); 
		query.append("    ,VVD_CD" ).append("\n"); 
		query.append("    ,BKG_NO" ).append("\n"); 
		query.append("    ,POL_YD_CD2" ).append("\n"); 
		query.append("    ,POD_YD_CD2" ).append("\n"); 
		query.append("    ,BL_NO" ).append("\n"); 
		query.append("    ,(" ).append("\n"); 
		query.append("        SELECT  SUBSTR(TO_CHAR(C.CNMV_EVNT_DT,'YYYYMMDDHH24MISS'),0,4) || '-' ||" ).append("\n"); 
		query.append("                SUBSTR(TO_CHAR(C.CNMV_EVNT_DT,'YYYYMMDDHH24MISS'),5,2) || '-' ||" ).append("\n"); 
		query.append("                SUBSTR(TO_CHAR(C.CNMV_EVNT_DT,'YYYYMMDDHH24MISS'),7,2) || ' ' ||" ).append("\n"); 
		query.append("                SUBSTR(TO_CHAR(C.CNMV_EVNT_DT,'YYYYMMDDHH24MISS'),9,2) || ':' ||" ).append("\n"); 
		query.append("                SUBSTR(TO_CHAR(C.CNMV_EVNT_DT,'YYYYMMDDHH24MISS'),11,2) || ':' ||" ).append("\n"); 
		query.append("                SUBSTR(TO_CHAR(C.CNMV_EVNT_DT,'YYYYMMDDHH24MISS'),13,2) AS CNMV_EVNT_DT" ).append("\n"); 
		query.append("        FROM CTM_MOVEMENT C" ).append("\n"); 
		query.append("        WHERE 1=1" ).append("\n"); 
		query.append("        AND C.MVMT_STS_CD = 'VD'" ).append("\n"); 
		query.append("        AND C.CRNT_VSL_CD     = SUBSTR(@[in_vvd_cd],1,4)" ).append("\n"); 
		query.append("        AND C.CRNT_SKD_VOY_NO = SUBSTR(@[in_vvd_cd],5,4)" ).append("\n"); 
		query.append("        AND C.CNTR_NO = A.CNTR_NO" ).append("\n"); 
		query.append("    	AND C.INP_YD_CD = A.POD_YD_CD2" ).append("\n"); 
		query.append("    ) CNMV_EVNT_DT" ).append("\n"); 
		query.append("    FROM" ).append("\n"); 
		query.append("    (" ).append("\n"); 
		query.append("        SELECT " ).append("\n"); 
		query.append("     	      TB1.*" ).append("\n"); 
		query.append("             ,DECODE(TB1.CNTR_NO,CO.CNTR_NO,'D','') AS OVERLAP" ).append("\n"); 
		query.append("             ,TB2.GUBUN" ).append("\n"); 
		query.append("             ,TB2.CLPT_SEQ" ).append("\n"); 
		query.append("        FROM ROB_LIST TB1, VSL_SKD TB2, CNTR_OVERLAP CO" ).append("\n"); 
		query.append("        WHERE 1=1" ).append("\n"); 
		query.append("        AND TB1.VVD_CD = TB2.VVD" ).append("\n"); 
		query.append("        AND TB1.POL_YD_CD2 = TB2.YD_CD" ).append("\n"); 
		query.append("        AND TB1.CNTR_NO = CO.CNTR_NO(+)" ).append("\n"); 
		query.append("        --ORDER BY TB2.GUBUN ASC, TB2.CLPT_SEQ ASC, TB1.CNTR_NO ASC" ).append("\n"); 
		query.append("    ) A" ).append("\n"); 
		query.append("    ORDER BY CNTR_NO" ).append("\n"); 
		query.append(") A" ).append("\n"); 

	}
}