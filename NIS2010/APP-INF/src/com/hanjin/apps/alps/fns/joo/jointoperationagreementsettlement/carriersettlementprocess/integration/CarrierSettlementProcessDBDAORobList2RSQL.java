/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : CarrierSettlementProcessDBDAORobList2RSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.07.21
*@LastModifier : 민정호
*@LastVersion : 1.0
* 2015.07.21 민정호
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.carriersettlementprocess.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Jung Ho Min
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CarrierSettlementProcessDBDAORobList2RSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ROB 조회 목록
	  *     - 더블콜링 발생시에 
	  *     - VVD 스케줄상에 SKIP이 발생시에 
	  * 수정 버전
	  * </pre>
	  */
	public CarrierSettlementProcessDBDAORobList2RSQL(){
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
		query.append("FileName : CarrierSettlementProcessDBDAORobList2RSQL").append("\n"); 
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
		query.append("	SELECT DISTINCT  " ).append("\n"); 
		query.append("	   VSL_CD" ).append("\n"); 
		query.append("	  ,TURN_SKD_VOY_NO AS SKD_VOY_NO" ).append("\n"); 
		query.append("	  ,TURN_SKD_DIR_CD AS SKD_DIR_CD" ).append("\n"); 
		query.append("	FROM VSK_VSL_PORT_SKD" ).append("\n"); 
		query.append("	WHERE 1=1" ).append("\n"); 
		query.append("	AND LEVEL <= FLOOR(TO_NUMBER('3')/2)" ).append("\n"); 
		query.append("	AND (TURN_SKD_VOY_NO IS NOT NULL OR TURN_SKD_DIR_CD IS NOT NULL) START WITH VSL_CD = SUBSTR(@[in_vvd_cd],1,4)" ).append("\n"); 
		query.append("	AND SKD_VOY_NO = SUBSTR(@[in_vvd_cd],5,4)" ).append("\n"); 
		query.append("	AND SKD_DIR_CD = SUBSTR(@[in_vvd_cd],9,1)" ).append("\n"); 
		query.append("	AND TURN_PORT_IND_CD IN ('Y','N') CONNECT BY PRIOR TURN_SKD_VOY_NO = SKD_VOY_NO" ).append("\n"); 
		query.append("	AND PRIOR TURN_SKD_DIR_CD = SKD_DIR_CD" ).append("\n"); 
		query.append("	AND PRIOR VSL_CD = VSL_CD" ).append("\n"); 
		query.append("	AND TURN_PORT_IND_CD IN ('Y','N')" ).append("\n"); 
		query.append("	AND LEVEL <= FLOOR(TO_NUMBER('3')/2)" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append(",VPS_ETD AS (" ).append("\n"); 
		query.append("	SELECT T1.VPS_ETD_DT" ).append("\n"); 
		query.append("	FROM VSK_VSL_PORT_SKD T1" ).append("\n"); 
		query.append("	WHERE 1=1" ).append("\n"); 
		query.append("	AND T1.VSL_CD     = SUBSTR(@[in_vvd_cd],1,4)" ).append("\n"); 
		query.append("	AND T1.SKD_VOY_NO = SUBSTR(@[in_vvd_cd],5,4)" ).append("\n"); 
		query.append("	AND T1.SKD_DIR_CD = SUBSTR(@[in_vvd_cd],9,1)  " ).append("\n"); 
		query.append("	AND T1.VPS_PORT_CD = @[in_pol_cd]" ).append("\n"); 
		query.append("	AND T1.CLPT_IND_SEQ = @[pol_split_no]" ).append("\n"); 
		query.append("	AND T1.YD_CD = @[in_pol_cd] || @[in_pol_yd_cd]  " ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append(", CTM_LIST AS (" ).append("\n"); 
		query.append("        SELECT" ).append("\n"); 
		query.append("         AA.CRNT_VSL_CD         AS VSL_CD" ).append("\n"); 
		query.append("        ,AA.CRNT_SKD_VOY_NO     AS SKD_VOY_NO" ).append("\n"); 
		query.append("        ,AA.CRNT_SKD_DIR_CD     AS SKD_DIR_CD    " ).append("\n"); 
		query.append("        ,AA.CNTR_NO" ).append("\n"); 
		query.append("        ,MAX(DECODE(AA.MVMT_STS_CD,'VL',AA.CNTR_TPSZ_CD,'')) AS CNTR_TPSZ_CD" ).append("\n"); 
		query.append("        ,MAX(DECODE(AA.MVMT_STS_CD,'VL',AA.CNMV_EVNT_DT,'')) AS CNMV_EVNT_DT_VL" ).append("\n"); 
		query.append("        ,NVL(MAX(DECODE(AA.MVMT_STS_CD,'VD',AA.CNMV_EVNT_DT,'')),TO_DATE('999912312359','YYYYMMDDHH24MISS')) AS CNMV_EVNT_DT_VD" ).append("\n"); 
		query.append("        ,MAX(DECODE(AA.MVMT_STS_CD,'VL',AA.BKG_NO,AA.BKG_NO)) AS BKG_NO" ).append("\n"); 
		query.append("        ,MAX(DECODE(AA.MVMT_STS_CD,'VL',AA.BL_NO,AA.BL_NO)) AS BL_NO         " ).append("\n"); 
		query.append("        ,MAX(DECODE(AA.MVMT_STS_CD,'VL',AA.INP_YD_CD,'')) AS POL" ).append("\n"); 
		query.append("        ,MAX(DECODE(AA.MVMT_STS_CD,'VD',AA.INP_YD_CD,'')) AS POD        " ).append("\n"); 
		query.append("        FROM" ).append("\n"); 
		query.append("        (" ).append("\n"); 
		query.append("            SELECT   A.CNTR_NO" ).append("\n"); 
		query.append("                    ,A.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("                    ,A.MVMT_STS_CD" ).append("\n"); 
		query.append("                    ,A.CNMV_EVNT_DT" ).append("\n"); 
		query.append("                    ,A.CRNT_VSL_CD" ).append("\n"); 
		query.append("                    ,A.CRNT_SKD_VOY_NO" ).append("\n"); 
		query.append("                    ,A.CRNT_SKD_DIR_CD" ).append("\n"); 
		query.append("                    ,A.BKG_NO" ).append("\n"); 
		query.append("                    ,A.BL_NO" ).append("\n"); 
		query.append("                    ,A.INP_YD_CD" ).append("\n"); 
		query.append("            FROM CTM_MOVEMENT A" ).append("\n"); 
		query.append("            WHERE 1=1 " ).append("\n"); 
		query.append("            AND A.CRNT_VSL_CD = SUBSTR(@[in_vvd_cd],1,4)" ).append("\n"); 
		query.append("            AND A.CRNT_SKD_VOY_NO = SUBSTR(@[in_vvd_cd],5,4)" ).append("\n"); 
		query.append("            AND A.CRNT_SKD_DIR_CD = SUBSTR(@[in_vvd_cd],9,1)" ).append("\n"); 
		query.append("            UNION" ).append("\n"); 
		query.append("            SELECT   A.CNTR_NO" ).append("\n"); 
		query.append("                    ,A.CNTR_TPSZ_CD            " ).append("\n"); 
		query.append("                    ,A.MVMT_STS_CD" ).append("\n"); 
		query.append("                    ,A.CNMV_EVNT_DT" ).append("\n"); 
		query.append("                    ,A.CRNT_VSL_CD" ).append("\n"); 
		query.append("                    ,A.CRNT_SKD_VOY_NO" ).append("\n"); 
		query.append("                    ,A.CRNT_SKD_DIR_CD" ).append("\n"); 
		query.append("                    ,A.BKG_NO" ).append("\n"); 
		query.append("                    ,A.BL_NO" ).append("\n"); 
		query.append("                    ,A.INP_YD_CD" ).append("\n"); 
		query.append("            FROM CTM_MOVEMENT A" ).append("\n"); 
		query.append("            WHERE 1=1" ).append("\n"); 
		query.append("            AND A.CRNT_VSL_CD       = (SELECT VSL_CD FROM PRE_VVD)" ).append("\n"); 
		query.append("            AND A.CRNT_SKD_VOY_NO   = (SELECT SKD_VOY_NO FROM PRE_VVD)" ).append("\n"); 
		query.append("            AND A.CRNT_SKD_DIR_CD   = (SELECT SKD_DIR_CD FROM PRE_VVD)" ).append("\n"); 
		query.append("        ) AA    " ).append("\n"); 
		query.append("        GROUP BY AA.CNTR_NO" ).append("\n"); 
		query.append("                ,AA.CRNT_VSL_CD" ).append("\n"); 
		query.append("                ,AA.CRNT_SKD_VOY_NO" ).append("\n"); 
		query.append("                ,AA.CRNT_SKD_DIR_CD " ).append("\n"); 
		query.append(")      " ).append("\n"); 
		query.append(", CTM_LIST2 AS (" ).append("\n"); 
		query.append("    SELECT C.* " ).append("\n"); 
		query.append("    FROM CTM_LIST C" ).append("\n"); 
		query.append("    WHERE C.CNMV_EVNT_DT_VD > TO_DATE((SELECT TO_CHAR(VPS_ETD_DT,'YYYYMMDDHH24MISS') FROM VPS_ETD),'YYYYMMDDHH24MISS')" ).append("\n"); 
		query.append("    AND   C.CNMV_EVNT_DT_VL <= TO_DATE((SELECT TO_CHAR(VPS_ETD_DT,'YYYYMMDDHH24MISS') FROM VPS_ETD),'YYYYMMDDHH24MISS')   " ).append("\n"); 
		query.append(") " ).append("\n"); 
		query.append(", ROB_LIST AS (" ).append("\n"); 
		query.append("	SELECT	" ).append("\n"); 
		query.append("		CNTR_NO, " ).append("\n"); 
		query.append("		CNTR_TPSZ_CD, " ).append("\n"); 
		query.append("		CNTR_WGT, " ).append("\n"); 
		query.append("		TO_CHAR(A_CNTR_WGT,'9,999,990.00') A_CNTR_WGT," ).append("\n"); 
		query.append("		ROUND((round(nvl(ACT_WGT, 0) * decode(substr(CNTR_TPSZ_CD, 2, 1), '2', 1, 2) / TOT) + " ).append("\n"); 
		query.append("		NVL(CNTR_VOL_QTY, 1)* decode(nvl(mst_tare,0), 0, decode(nvl(mdm_tare,0), 0, 2500, mdm_tare), mst_tare))/1000) E_CNTR_WGT," ).append("\n"); 
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
		query.append("        ,POD_YD_CD2 --추가" ).append("\n"); 
		query.append("	    ,BL_NO" ).append("\n"); 
		query.append("        ,VSL_SEQ " ).append("\n"); 
		query.append("        ,POL_CLPT_IND_SEQ " ).append("\n"); 
		query.append("        ,POD_CLPT_IND_SEQ   " ).append("\n"); 
		query.append("        ,CNMV_EVNT_DT_VL" ).append("\n"); 
		query.append("        ,CNMV_EVNT_DT_VD" ).append("\n"); 
		query.append("	FROM (" ).append("\n"); 
		query.append("            SELECT      " ).append("\n"); 
		query.append("                 CTM.CNTR_NO" ).append("\n"); 
		query.append("                ,CTM.CNTR_TPSZ_CD            " ).append("\n"); 
		query.append("                ,CNTR.CNTR_WGT  A_CNTR_WGT" ).append("\n"); 
		query.append("                ,ROUND(CNTR.CNTR_WGT/1000,0) CNTR_WGT" ).append("\n"); 
		query.append("                ,DOC.ACT_WGT" ).append("\n"); 
		query.append("                ,(" ).append("\n"); 
		query.append("                    SELECT SUM(DECODE(SUBSTR(CNTR_TPSZ_CD,2,1),'2',1,2)) TOT " ).append("\n"); 
		query.append("                    FROM BKG_CONTAINER BC" ).append("\n"); 
		query.append("                    WHERE BC.BKG_NO = BKG.BKG_NO" ).append("\n"); 
		query.append("                ) TOT" ).append("\n"); 
		query.append("                ,CNTR.CNTR_VOL_QTY     " ).append("\n"); 
		query.append("                ,(select max(nvl(spec.tare_wgt, 0)) mst_wgt" ).append("\n"); 
		query.append("                        from mst_container mst," ).append("\n"); 
		query.append("                          mst_cntr_spec spec" ).append("\n"); 
		query.append("                        where mst.cntr_no = cntr.CNTR_NO" ).append("\n"); 
		query.append("                          and mst.cntr_spec_no = spec.cntr_spec_no ) mst_tare" ).append("\n"); 
		query.append("                ,(" ).append("\n"); 
		query.append("                    select max(nvl(mdm.CNTR_TPSZ_TARE_WGT, 0)) mdm_wgt" ).append("\n"); 
		query.append("                    from mdm_cntr_tp_sz mdm" ).append("\n"); 
		query.append("                    where mdm.cntr_tpsz_cd = CNTR.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("                ) mdm_tare                   " ).append("\n"); 
		query.append("                ,SUBSTR(CTM.POL,1,5) AS POL_CD" ).append("\n"); 
		query.append("                ,SUBSTR(CTM.POL,6,2) AS POL_YD_CD" ).append("\n"); 
		query.append("                ,SUBSTR(CTM.POD,1,5) AS POD_CD" ).append("\n"); 
		query.append("                ,SUBSTR(CTM.POD,6,2) AS POD_YD_CD                        " ).append("\n"); 
		query.append("                ,'' AS A_POL_CD     /* BKG */      " ).append("\n"); 
		query.append("                ,'' AS POL_NOD_CD   /* BKG */      " ).append("\n"); 
		query.append("                ,'' AS A_POD_CD     /* BKG */      " ).append("\n"); 
		query.append("                ,'' AS POD_NOD_CD   /* BKG */          " ).append("\n"); 
		query.append("                ,CNTR.RCV_TERM_CD        " ).append("\n"); 
		query.append("                ,CNTR.DE_TERM_CD        " ).append("\n"); 
		query.append("                ,DECODE(BKG.POL_CD,VVD.POL_CD,'L','T') TS_CD        " ).append("\n"); 
		query.append("                ,BKG.BKG_CGO_TP_CD" ).append("\n"); 
		query.append("                ,BKG.HOT_DE_FLG        " ).append("\n"); 
		query.append("                ,VVD.SLAN_CD" ).append("\n"); 
		query.append("                ,CNTR.DCGO_FLG" ).append("\n"); 
		query.append("                ,CNTR.RC_FLG" ).append("\n"); 
		query.append("                ,CNTR.AWK_CGO_FLG" ).append("\n"); 
		query.append("                ,BKG.PRCT_FLG   " ).append("\n"); 
		query.append("                ,CNTR.RD_CGO_FLG RD_CGO_FLG         " ).append("\n"); 
		query.append("                ,CNTR.HNGR_FLG" ).append("\n"); 
		query.append("                ,VVD.VSL_CD||VVD.SKD_VOY_NO||VVD.SKD_DIR_CD VVD_CD                    " ).append("\n"); 
		query.append("                ,CTM.BKG_NO" ).append("\n"); 
		query.append("                ,CTM.POL AS POL_YD_CD2  " ).append("\n"); 
		query.append("                ,CTM.POD AS POD_YD_CD2" ).append("\n"); 
		query.append("                ,CTM.BL_NO" ).append("\n"); 
		query.append("                ,VVD.VSL_SEQ " ).append("\n"); 
		query.append("                ,VVD.POL_CLPT_IND_SEQ " ).append("\n"); 
		query.append("                ,VVD.POD_CLPT_IND_SEQ " ).append("\n"); 
		query.append("                ,CTM.CNMV_EVNT_DT_VL" ).append("\n"); 
		query.append("                ,CTM.CNMV_EVNT_DT_VD" ).append("\n"); 
		query.append("            FROM     CTM_LIST2 CTM" ).append("\n"); 
		query.append("                    ,BKG_BOOKING BKG" ).append("\n"); 
		query.append("                    ,BKG_CONTAINER CNTR" ).append("\n"); 
		query.append("                    ,BKG_BL_DOC DOC" ).append("\n"); 
		query.append("                    ,BKG_VVD VVD" ).append("\n"); 
		query.append("                    ,MDM_LOCATION MDM        " ).append("\n"); 
		query.append("            WHERE 1=1" ).append("\n"); 
		query.append("            AND CTM.BKG_NO = BKG.BKG_NO" ).append("\n"); 
		query.append("            AND CTM.BKG_NO = CNTR.BKG_NO" ).append("\n"); 
		query.append("            AND CTM.CNTR_NO = CNTR.CNTR_NO" ).append("\n"); 
		query.append("            AND CTM.VSL_CD      = VVD.VSL_CD" ).append("\n"); 
		query.append("            AND CTM.SKD_VOY_NO  = VVD.SKD_VOY_NO" ).append("\n"); 
		query.append("            AND CTM.SKD_DIR_CD  = VVD.SKD_DIR_CD" ).append("\n"); 
		query.append("            AND BKG.BKG_STS_CD  <> 'S'	    " ).append("\n"); 
		query.append("            AND CTM.BKG_NO = VVD.BKG_NO" ).append("\n"); 
		query.append("            AND CTM.BKG_NO = DOC.BKG_NO	" ).append("\n"); 
		query.append("    /*        AND NVL(BKG.BKG_STS_CD,' ') NOT IN ('X','A')		*/" ).append("\n"); 
		query.append("            AND MDM.LOC_CD = BKG.DEL_CD      " ).append("\n"); 
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
		query.append("SELECT" ).append("\n"); 
		query.append(" ROWNUM SEQ" ).append("\n"); 
		query.append(",DECODE(A.OVERLAP,'D',A.CNTR_NO || '(' || A.OVERLAP || ')',A.CNTR_NO) AS CNTR_NO " ).append("\n"); 
		query.append(",A.CNTR_TPSZ_CD" ).append("\n"); 
		query.append(",A.CNTR_WGT" ).append("\n"); 
		query.append(",A.A_CNTR_WGT" ).append("\n"); 
		query.append(",A.E_CNTR_WGT" ).append("\n"); 
		query.append(",A.POL_CD" ).append("\n"); 
		query.append(",DECODE(POL_CLPT_IND_SEQ,1,A.POL_YD_CD,A.POL_YD_CD||'('||POL_CLPT_IND_SEQ||')') AS POL_YD_CD " ).append("\n"); 
		query.append(",A.POD_CD" ).append("\n"); 
		query.append(",DECODE(POD_CLPT_IND_SEQ,1,A.POD_YD_CD,A.POD_YD_CD||'('||POD_CLPT_IND_SEQ||')') AS POD_YD_CD " ).append("\n"); 
		query.append(",A.A_POL_CD " ).append("\n"); 
		query.append(",A.POL_NOD_CD" ).append("\n"); 
		query.append(",A.A_POD_CD    " ).append("\n"); 
		query.append(",A.POD_NOD_CD    " ).append("\n"); 
		query.append(",A.RCV_TERM_CD" ).append("\n"); 
		query.append(",A.DE_TERM_CD" ).append("\n"); 
		query.append(",A.TS_CD	" ).append("\n"); 
		query.append(",A.BKG_CGO_TP_CD" ).append("\n"); 
		query.append(",A.HOT_DE_FLG" ).append("\n"); 
		query.append(",A.SPCL_CGO_DESC_TYPE" ).append("\n"); 
		query.append(",A.SPCL_CGO_DESC" ).append("\n"); 
		query.append(",SLAN_CD" ).append("\n"); 
		query.append(",DCGO_FLG" ).append("\n"); 
		query.append(",RC_FLG" ).append("\n"); 
		query.append(",AWK_CGO_FLG" ).append("\n"); 
		query.append(",PRCT_FLG" ).append("\n"); 
		query.append(",RD_CGO_FLG" ).append("\n"); 
		query.append(",HNGR_FLG    " ).append("\n"); 
		query.append(",VVD_CD" ).append("\n"); 
		query.append(",BKG_NO" ).append("\n"); 
		query.append(",POL_YD_CD2" ).append("\n"); 
		query.append(",POD_YD_CD2" ).append("\n"); 
		query.append(",BL_NO" ).append("\n"); 
		query.append(",TO_CHAR(CNMV_EVNT_DT_VL,'YYYY-MM-DD HH24:MI:SS') || ' ~ ' || TO_CHAR(CNMV_EVNT_DT_VD,'YYYY-MM-DD HH24:MI:SS') AS CNMV_EVNT_DT" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("    SELECT " ).append("\n"); 
		query.append(" 	      TB1.*" ).append("\n"); 
		query.append("         ,DECODE(TB1.CNTR_NO,CO.CNTR_NO,'D','') AS OVERLAP" ).append("\n"); 
		query.append("    FROM ROB_LIST TB1, CNTR_OVERLAP CO" ).append("\n"); 
		query.append("    WHERE 1=1" ).append("\n"); 
		query.append("    AND TB1.CNTR_NO = CO.CNTR_NO(+)" ).append("\n"); 
		query.append("    ORDER BY TB1.CNMV_EVNT_DT_VL ASC" ).append("\n"); 
		query.append(") A" ).append("\n"); 

	}
}