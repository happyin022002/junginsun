/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : CntrMtyBkgCreateDBDAOSearchCntrMtyBkgListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.03.06
*@LastModifier : 
*@LastVersion : 1.0
* 2014.03.06 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.eqr.cntrmtybkgmanage.cntrmtybkgcreate.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CntrMtyBkgCreateDBDAOSearchCntrMtyBkgListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * BKG NO 조회 및 PLAN 조회
	  * </pre>
	  */
	public CntrMtyBkgCreateDBDAOSearchCntrMtyBkgListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fromdate",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("todate",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vvdname",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("lane",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.eqr.cntrmtybkgmanage.cntrmtybkgcreate.integration").append("\n"); 
		query.append("FileName : CntrMtyBkgCreateDBDAOSearchCntrMtyBkgListRSQL").append("\n"); 
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
		query.append("SELECT DECODE(A.EQR_STS_CD, 'X', 'X', DECODE(A.BKG_STS_CD, 'X', 'S', A.BKG_STS_CD)) BKG_STS_CD  -- X : bkg cancel, S : Bkg vol=0, F : split or bkg vol>0" ).append("\n"); 
		query.append("      ,A.TRSP_MOD_CD" ).append("\n"); 
		query.append("      ,DECODE(A.VL_VD_DIV, 0, 'PLAN', 1, 'REPO BKG(VL)', 3, 'REPO BKG(VL)', 2, 'REPO BKG(VD)') DIV" ).append("\n"); 
		query.append("      ,A.MTY_BKG_NO" ).append("\n"); 
		query.append("      ,A.VSL_LANE_CD" ).append("\n"); 
		query.append("      ,A.VSL_CD||SKD_VOY_NO||SKD_DIR_CD VVD" ).append("\n"); 
		query.append("      ,A.MTY_ROB_FLG" ).append("\n"); 
		query.append("      ,A.POL_CD                         FM_YD_CD" ).append("\n"); 
		query.append("      ,A.VPS_ETD_DT                     FM_ETD_DT" ).append("\n"); 
		query.append("      ,A.POD_CD                         TO_YD_CD" ).append("\n"); 
		query.append("      ,A.VPS_ETB_DT                     TO_ETA_DT" ).append("\n"); 
		query.append("      ,A.CNTR_IMG" ).append("\n"); 
		query.append("      ,NULL TOTAL_VOL" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	#foreach( $key in ${arrtpsz}) " ).append("\n"); 
		query.append("      ,A.QTY_$key" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("      ,A.EQ_REPO_PURP_CD" ).append("\n"); 
		query.append("      ,A.REPO_PLN_FB_RSN_CD" ).append("\n"); 
		query.append("      ,A.REPO_PLN_FB_RMK" ).append("\n"); 
		query.append("      ,B.OFC_CD   UPD_OFC" ).append("\n"); 
		query.append("      ,B.USR_NM    UPD_NAME" ).append("\n"); 
		query.append("      ,TO_CHAR(A.UPD_DT,'YYYY-MM-DD HH24:MI:SS') UPD_DT" ).append("\n"); 
		query.append("      " ).append("\n"); 
		query.append("      -- HIDDEN (PK)" ).append("\n"); 
		query.append("      ,A.VSL_CD" ).append("\n"); 
		query.append("      ,A.SKD_VOY_NO" ).append("\n"); 
		query.append("      ,A.SKD_DIR_CD" ).append("\n"); 
		query.append("      ,A.BKG_EXE_SEQ" ).append("\n"); 
		query.append("      " ).append("\n"); 
		query.append("      -- HIDDEN (OTHER)" ).append("\n"); 
		query.append("      ,A.MTY_BKG_FLG" ).append("\n"); 
		query.append("      ,A.MTY_BKG_SPLIT_FLG" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("      -- SORT" ).append("\n"); 
		query.append("      ,A.ORD_SEQ   -- PLAN / EXEC 구분 (1 / 2)" ).append("\n"); 
		query.append("      ,A.VL_VD_DIV -- VL/ VD 구분 (1 / 2)" ).append("\n"); 
		query.append("      ,A.ORG_TO_LOC_CD" ).append("\n"); 
		query.append("      ,A.POL_CLPT_IND_SEQ" ).append("\n"); 
		query.append("      ,A.POD_CLPT_IND_SEQ" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("    SELECT 1 ORD_SEQ" ).append("\n"); 
		query.append("          ,DECODE(E.VSL_SVC_TP_CD, NULL, 'W', 'O', 'W', 'V') TRSP_MOD_CD" ).append("\n"); 
		query.append("          ,A.VSL_CD" ).append("\n"); 
		query.append("          ,A.SKD_VOY_NO" ).append("\n"); 
		query.append("          ,A.SKD_DIR_CD" ).append("\n"); 
		query.append("          ,NULL BKG_EXE_SEQ" ).append("\n"); 
		query.append("          ,C.SLAN_CD VSL_LANE_CD" ).append("\n"); 
		query.append("          ,A.POL_CD" ).append("\n"); 
		query.append("          ,A.POD_CD" ).append("\n"); 
		query.append("          ,TO_CHAR(C.VPS_ETD_DT,'YYYY-MM-DD HH24:MI:SS') VPS_ETD_DT" ).append("\n"); 
		query.append("          ,TO_CHAR(D.VPS_ETB_DT,'YYYY-MM-DD HH24:MI:SS') VPS_ETB_DT" ).append("\n"); 
		query.append("          ,NULL MTY_BKG_FLG" ).append("\n"); 
		query.append("          ,NULL MTY_BKG_SPLIT_FLG " ).append("\n"); 
		query.append("          ,NULL MTY_ROB_FLG " ).append("\n"); 
		query.append("          ,9    CNTR_IMG    -- PLAN 은 이미지 표현 없애기 위해 9" ).append("\n"); 
		query.append("          ,0    VL_VD_DIV" ).append("\n"); 
		query.append("          ,NULL MTY_BKG_NO" ).append("\n"); 
		query.append("          ,NULL OLD_BKG_GRP_NO" ).append("\n"); 
		query.append("          ,NULL EQ_REPO_PURP_CD" ).append("\n"); 
		query.append("          ,NULL REPO_PLN_FB_RSN_CD" ).append("\n"); 
		query.append("          ,NULL REPO_PLN_FB_RMK" ).append("\n"); 
		query.append("    " ).append("\n"); 
		query.append("	#foreach( $key in ${arrtpsz}) " ).append("\n"); 
		query.append("         ,NVL(SUM(DECODE(B.CNTR_TPSZ_CD, '$key', B.CNTR_QTY)),0) QTY_$key" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("    	" ).append("\n"); 
		query.append("          ,A.UPD_USR_ID " ).append("\n"); 
		query.append("          ,A.UPD_DT   " ).append("\n"); 
		query.append("          " ).append("\n"); 
		query.append("          ,A.POL_CD ECC_CD" ).append("\n"); 
		query.append("          ,A.POD_CD ORG_TO_LOC_CD" ).append("\n"); 
		query.append("          ,NULL BKG_STS_CD" ).append("\n"); 
		query.append("          ,NULL EQR_STS_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("          ,NULL POL_CLPT_IND_SEQ" ).append("\n"); 
		query.append("          ,NULL POD_CLPT_IND_SEQ" ).append("\n"); 
		query.append("    FROM EQR_CTRL_MTY_DCHG_PLN     A" ).append("\n"); 
		query.append("        ,EQR_CTRL_MTY_DCHG_PLN_QTY B " ).append("\n"); 
		query.append("        ,VSK_VSL_PORT_SKD          C" ).append("\n"); 
		query.append("        ,VSK_VSL_PORT_SKD          D" ).append("\n"); 
		query.append("        ,MDM_VSL_SVC_LANE          E" ).append("\n"); 
		query.append("    WHERE A.VSL_CD     = B.VSL_CD" ).append("\n"); 
		query.append("    AND   A.SKD_VOY_NO = B.SKD_VOY_NO" ).append("\n"); 
		query.append("    AND   A.SKD_DIR_CD = B.SKD_DIR_CD " ).append("\n"); 
		query.append("    AND   A.POL_YD_CD  = B.POL_YD_CD" ).append("\n"); 
		query.append("    AND   A.POD_YD_CD  = B.POD_YD_CD" ).append("\n"); 
		query.append("    " ).append("\n"); 
		query.append("    AND   A.VSL_CD     = C.VSL_CD(+)" ).append("\n"); 
		query.append("    AND   A.SKD_VOY_NO = C.SKD_VOY_NO(+)" ).append("\n"); 
		query.append("    AND   A.SKD_DIR_CD = C.SKD_DIR_CD(+) " ).append("\n"); 
		query.append("    AND   A.POL_CD     = C.VPS_PORT_CD(+) " ).append("\n"); 
		query.append("    AND   C.CLPT_IND_SEQ = 1" ).append("\n"); 
		query.append("    " ).append("\n"); 
		query.append("    AND   A.VSL_CD     = D.VSL_CD(+)" ).append("\n"); 
		query.append("    AND   A.SKD_VOY_NO = D.SKD_VOY_NO(+)" ).append("\n"); 
		query.append("    AND   A.SKD_DIR_CD = D.SKD_DIR_CD(+) " ).append("\n"); 
		query.append("    AND   A.POD_CD     = D.VPS_PORT_CD(+) " ).append("\n"); 
		query.append("    AND   D.CLPT_IND_SEQ = 1      -- HARD CODING" ).append("\n"); 
		query.append("    " ).append("\n"); 
		query.append("    AND   C.SLAN_CD    = E.VSL_SLAN_CD(+)" ).append("\n"); 
		query.append("       " ).append("\n"); 
		query.append("    AND   A.MTY_PLN_SHW_FLG = 'Y' -- HARD CODING" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("    #if ( ${divflag} == 1 )" ).append("\n"); 
		query.append("	    #if ( ${divdate} == 'F' )" ).append("\n"); 
		query.append("    -- < 검색조건 - PERIOD FM> -----------------" ).append("\n"); 
		query.append("    AND   C.VPS_ETD_DT BETWEEN TO_DATE(@[fromdate], 'YYYY-MM-DD') AND TO_DATE(@[todate], 'YYYY-MM-DD')+0.99999" ).append("\n"); 
		query.append("	    #else" ).append("\n"); 
		query.append("    -- < 검색조건 - PERIOD TO> -----------------" ).append("\n"); 
		query.append("    AND   D.VPS_ETB_DT BETWEEN TO_DATE(@[fromdate], 'YYYY-MM-DD') AND TO_DATE(@[todate], 'YYYY-MM-DD')+0.99999" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("    #else" ).append("\n"); 
		query.append("	    " ).append("\n"); 
		query.append("    -- < 검색조건 - VVD> -----------------" ).append("\n"); 
		query.append("    AND   A.VSL_CD     = SUBSTR(@[vvdname],0,4)" ).append("\n"); 
		query.append("    AND   A.SKD_VOY_NO = SUBSTR(@[vvdname],5,4) " ).append("\n"); 
		query.append("    AND   A.SKD_DIR_CD = SUBSTR(@[vvdname],9,1)" ).append("\n"); 
		query.append("	    " ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("    #if ( ${lane} != '' )" ).append("\n"); 
		query.append("    ---- < 검색조건 - LANE> -----------------" ).append("\n"); 
		query.append("    AND   C.SLAN_CD  = @[lane]" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("    #if ( ${fromlocation} != '') -- FROM LOCATION 있거나 " ).append("\n"); 
		query.append("    -- < 검색조건 - FROM LOCATION> -----------------" ).append("\n"); 
		query.append("    AND   A.POL_YD_CD IN (" ).append("\n"); 
		query.append("                            SELECT DISTINCT C.YD_CD" ).append("\n"); 
		query.append("                            FROM MDM_EQ_ORZ_CHT A" ).append("\n"); 
		query.append("                                ,MDM_LOCATION B" ).append("\n"); 
		query.append("                                ,MDM_YARD C               	    " ).append("\n"); 
		query.append("                            WHERE A.SCC_CD = B.SCC_CD " ).append("\n"); 
		query.append("                            AND   B.LOC_CD = C.LOC_CD  " ).append("\n"); 
		query.append("                            AND   A.DELT_FLG = 'N'" ).append("\n"); 
		query.append("                            AND   B.DELT_FLG = 'N' " ).append("\n"); 
		query.append("                            AND   C.DELT_FLG = 'N' " ).append("\n"); 
		query.append("                        " ).append("\n"); 
		query.append("	    #if 	( ${fromstatus} == 'R' )" ).append("\n"); 
		query.append("                            AND   A.RCC_CD IN ( ${fromLocationText} )" ).append("\n"); 
		query.append("	    #elseif ( ${fromstatus} == 'L' )" ).append("\n"); 
		query.append("                            AND   A.LCC_CD IN ( ${fromLocationText} )" ).append("\n"); 
		query.append("	    #elseif ( ${fromstatus} == 'E' ) " ).append("\n"); 
		query.append("                            AND   A.ECC_CD IN ( ${fromLocationText} )" ).append("\n"); 
		query.append("	    #elseif ( ${fromstatus} == 'S' )" ).append("\n"); 
		query.append("                            AND   A.SCC_CD IN ( ${fromLocationText} )" ).append("\n"); 
		query.append("	    #else" ).append("\n"); 
		query.append("                            AND   C.YD_CD  IN ( ${fromLocationText} )      " ).append("\n"); 
		query.append("	    #end                 " ).append("\n"); 
		query.append("                         )" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("    #if ( ${tolocation} != '') -- TO LOCATION 있거나" ).append("\n"); 
		query.append("    -- < 검색조건 - TO LOCATION> -----------------" ).append("\n"); 
		query.append("    AND   A.POD_YD_CD IN (" ).append("\n"); 
		query.append("                            SELECT DISTINCT C.YD_CD" ).append("\n"); 
		query.append("                            FROM MDM_EQ_ORZ_CHT A" ).append("\n"); 
		query.append("                                ,MDM_LOCATION B" ).append("\n"); 
		query.append("                                ,MDM_YARD C               	    " ).append("\n"); 
		query.append("                            WHERE A.SCC_CD = B.SCC_CD " ).append("\n"); 
		query.append("                            AND   B.LOC_CD = C.LOC_CD  " ).append("\n"); 
		query.append("                            AND   A.DELT_FLG = 'N'" ).append("\n"); 
		query.append("                            AND   B.DELT_FLG = 'N' " ).append("\n"); 
		query.append("                            AND   C.DELT_FLG = 'N' " ).append("\n"); 
		query.append("	   	#if 	( ${tostatus} == 'R' )                        " ).append("\n"); 
		query.append("                            AND   A.RCC_CD IN ( ${toLocationText} )" ).append("\n"); 
		query.append("	   	#elseif ( ${tostatus} == 'L' )" ).append("\n"); 
		query.append("                            AND   A.LCC_CD IN ( ${toLocationText} )" ).append("\n"); 
		query.append("	   	#elseif ( ${tostatus} == 'E' ) " ).append("\n"); 
		query.append("                            AND   A.ECC_CD IN ( ${toLocationText} )" ).append("\n"); 
		query.append("	   	#elseif ( ${tostatus} == 'S' )" ).append("\n"); 
		query.append("                            AND   A.SCC_CD IN ( ${toLocationText} )" ).append("\n"); 
		query.append("	   	#else" ).append("\n"); 
		query.append("                            AND   C.YD_CD  IN ( ${toLocationText} )      " ).append("\n"); 
		query.append("	   	#end                               " ).append("\n"); 
		query.append("                         )" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("  	    " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("    GROUP BY A.VSL_CD" ).append("\n"); 
		query.append("          ,A.SKD_VOY_NO" ).append("\n"); 
		query.append("          ,A.SKD_DIR_CD" ).append("\n"); 
		query.append("          ,C.SLAN_CD" ).append("\n"); 
		query.append("          ,A.POL_CD" ).append("\n"); 
		query.append("          ,A.POD_CD" ).append("\n"); 
		query.append("          ,TO_CHAR(C.VPS_ETD_DT,'YYYY-MM-DD HH24:MI:SS')" ).append("\n"); 
		query.append("          ,TO_CHAR(D.VPS_ETB_DT,'YYYY-MM-DD HH24:MI:SS')" ).append("\n"); 
		query.append("          ,E.VSL_SVC_TP_CD" ).append("\n"); 
		query.append("          ,A.UPD_USR_ID " ).append("\n"); 
		query.append("          ,A.UPD_DT  " ).append("\n"); 
		query.append("              " ).append("\n"); 
		query.append("    UNION ALL" ).append("\n"); 
		query.append("    " ).append("\n"); 
		query.append("    -- BOOKING EXECUTE" ).append("\n"); 
		query.append("    SELECT 2 ORD_SEQ" ).append("\n"); 
		query.append("          ,A.TRSP_MOD_CD" ).append("\n"); 
		query.append("          ,A.VSL_CD" ).append("\n"); 
		query.append("          ,A.SKD_VOY_NO" ).append("\n"); 
		query.append("          ,A.SKD_DIR_CD" ).append("\n"); 
		query.append("          ,A.BKG_EXE_SEQ" ).append("\n"); 
		query.append("          ,A.VSL_LANE_CD" ).append("\n"); 
		query.append("          ,A.POL_YD_CD" ).append("\n"); 
		query.append("          ,A.POD_YD_CD" ).append("\n"); 
		query.append("          ,TO_CHAR(A.POL_ETD_DT,'YYYY-MM-DD HH24:MI:SS') POL_ETD_DT" ).append("\n"); 
		query.append("          ,TO_CHAR(A.POD_ETB_DT,'YYYY-MM-DD HH24:MI:SS') POD_ETB_DT" ).append("\n"); 
		query.append("    " ).append("\n"); 
		query.append("          ,A.MTY_BKG_FLG" ).append("\n"); 
		query.append("          ,A.MTY_BKG_SPLIT_FLG" ).append("\n"); 
		query.append("          ,A.MTY_ROB_FLG" ).append("\n"); 
		query.append("          " ).append("\n"); 
		query.append("          ,CASE WHEN A.MTY_BKG_NO IS NULL THEN 9" ).append("\n"); 
		query.append("                WHEN (SELECT COUNT(1) FROM BKG_CONTAINER X WHERE X.BKG_NO = A.MTY_BKG_NO ) > 0 THEN 0 ELSE 1" ).append("\n"); 
		query.append("           END CNTR_IMG" ).append("\n"); 
		query.append("    " ).append("\n"); 
		query.append("          ,CASE WHEN A.MTY_BKG_FLG = 'Y' AND A.MTY_BKG_SPLIT_FLG = 'Y' THEN 2" ).append("\n"); 
		query.append("                WHEN A.MTY_BKG_FLG = 'Y' AND A.MTY_BKG_SPLIT_FLG = 'N' THEN 1" ).append("\n"); 
		query.append("                WHEN A.MTY_BKG_FLG = 'N' AND A.MTY_BKG_SPLIT_FLG = 'N' THEN 3" ).append("\n"); 
		query.append("           END VL_VD_DIV     " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("          ,A.MTY_BKG_NO" ).append("\n"); 
		query.append("          ,A.OLD_BKG_GRP_NO " ).append("\n"); 
		query.append("          ,A.EQ_REPO_PURP_CD" ).append("\n"); 
		query.append("          ,A.REPO_PLN_FB_RSN_CD" ).append("\n"); 
		query.append("          ,A.REPO_PLN_FB_RMK" ).append("\n"); 
		query.append("  " ).append("\n"); 
		query.append("	#foreach( $key in ${arrtpsz})" ).append("\n"); 
		query.append("          ,NVL(SUM(DECODE(A.CNTR_TPSZ_CD, '$key', DECODE(A.MTY_BKG_FLG, 'Y', C.OP_CNTR_QTY, A.CNTR_QTY))),0) QTY_$key" ).append("\n"); 
		query.append("	#end          	      " ).append("\n"); 
		query.append("          " ).append("\n"); 
		query.append("          ,DECODE(A.MTY_BKG_NO, NULL, A.UPD_USR_ID, D.UPD_USR_ID) UPD_USR_ID " ).append("\n"); 
		query.append("          ,DECODE(A.MTY_BKG_NO, NULL, A.UPD_DT,     D.UPD_DT)     UPD_DT   " ).append("\n"); 
		query.append("    " ).append("\n"); 
		query.append("          ,A.ECC_CD    " ).append("\n"); 
		query.append("          ,DECODE(A.ORG_TO_ECC_CD, NULL, SUBSTR(A.POD_YD_CD, 0, 5), A.ORG_TO_ECC_CD) ORG_TO_ECC_CD" ).append("\n"); 
		query.append("          ,D.BKG_STS_CD" ).append("\n"); 
		query.append("          ,A.BKG_STS_CD EQR_STS_CD" ).append("\n"); 
		query.append("          ,A.POL_CLPT_IND_SEQ" ).append("\n"); 
		query.append("          ,A.POD_CLPT_IND_SEQ  " ).append("\n"); 
		query.append("    FROM (" ).append("\n"); 
		query.append("            SELECT A.TRSP_MOD_CD" ).append("\n"); 
		query.append("                  ,A.VSL_CD" ).append("\n"); 
		query.append("                  ,A.SKD_VOY_NO" ).append("\n"); 
		query.append("                  ,A.SKD_DIR_CD" ).append("\n"); 
		query.append("                  ,A.BKG_EXE_SEQ" ).append("\n"); 
		query.append("                  ,A.VSL_LANE_CD" ).append("\n"); 
		query.append("                  ,A.POL_YD_CD" ).append("\n"); 
		query.append("                  ,A.POD_YD_CD" ).append("\n"); 
		query.append("                  ,A.POL_ETD_DT" ).append("\n"); 
		query.append("                  ,A.POD_ETB_DT" ).append("\n"); 
		query.append("                  ,A.MTY_BKG_FLG" ).append("\n"); 
		query.append("                  ,A.MTY_BKG_SPLIT_FLG" ).append("\n"); 
		query.append("                  ,DECODE(A.MTY_ROB_FLG, 'N', '0', NULL, '0', 'Y', '1') MTY_ROB_FLG" ).append("\n"); 
		query.append("                  ,A.BKG_STS_CD" ).append("\n"); 
		query.append("                  ,A.MTY_BKG_NO" ).append("\n"); 
		query.append("                  ,A.OLD_BKG_GRP_NO " ).append("\n"); 
		query.append("                  ,A.EQ_REPO_PURP_CD" ).append("\n"); 
		query.append("                  ,A.REPO_PLN_FB_RSN_CD" ).append("\n"); 
		query.append("                  ,A.REPO_PLN_FB_RMK" ).append("\n"); 
		query.append("                  ,B.CNTR_TPSZ_CD     " ).append("\n"); 
		query.append("                  ,B.CNTR_QTY " ).append("\n"); 
		query.append("                  ,A.UPD_DT" ).append("\n"); 
		query.append("                  ,A.UPD_USR_ID" ).append("\n"); 
		query.append("                  ,C.LOC_CD ECC_CD" ).append("\n"); 
		query.append("                  ,(" ).append("\n"); 
		query.append("                       SELECT DISTINCT B.LOC_CD" ).append("\n"); 
		query.append("                       FROM MDM_LOCATION B" ).append("\n"); 
		query.append("                           ,MDM_YARD C               	    " ).append("\n"); 
		query.append("                       WHERE B.LOC_CD = C.LOC_CD   " ).append("\n"); 
		query.append("                       AND   C.YD_CD  = (                    " ).append("\n"); 
		query.append("                                           SELECT X.POD_YD_CD " ).append("\n"); 
		query.append("                                           FROM EQR_CTRL_MTY_BKG_EXE X " ).append("\n"); 
		query.append("                                           WHERE X.MTY_BKG_NO = A.OLD_BKG_GRP_NO" ).append("\n"); 
		query.append("                                           AND ROWNUM=1" ).append("\n"); 
		query.append("                                        )" ).append("\n"); 
		query.append("                   ) ORG_TO_ECC_CD" ).append("\n"); 
		query.append("                  ,A.POL_CLPT_IND_SEQ" ).append("\n"); 
		query.append("                  ,A.POD_CLPT_IND_SEQ                   " ).append("\n"); 
		query.append("            FROM EQR_CTRL_MTY_BKG_EXE     A" ).append("\n"); 
		query.append("                ,EQR_CTRL_MTY_BKG_EXE_QTY B" ).append("\n"); 
		query.append("                ,(" ).append("\n"); 
		query.append("                            SELECT DISTINCT B.LOC_CD, C.YD_CD" ).append("\n"); 
		query.append("                            FROM MDM_LOCATION B" ).append("\n"); 
		query.append("                                ,MDM_YARD C               	    " ).append("\n"); 
		query.append("                            WHERE B.LOC_CD = C.LOC_CD            " ).append("\n"); 
		query.append("                 ) C" ).append("\n"); 
		query.append("            WHERE A.TRSP_MOD_CD= B.TRSP_MOD_CD" ).append("\n"); 
		query.append("            AND   A.VSL_CD     = B.VSL_CD" ).append("\n"); 
		query.append("            AND   A.SKD_VOY_NO = B.SKD_VOY_NO" ).append("\n"); 
		query.append("            AND   A.SKD_DIR_CD = B.SKD_DIR_CD" ).append("\n"); 
		query.append("            AND   A.BKG_EXE_SEQ= B.BKG_EXE_SEQ " ).append("\n"); 
		query.append("            AND   A.POL_YD_CD  = C.YD_CD(+)" ).append("\n"); 
		query.append("            " ).append("\n"); 
		query.append("            #if ( ${divflag} == 1 )" ).append("\n"); 
		query.append("            	#if ( ${divdate} == 'F' )" ).append("\n"); 
		query.append("            -- < 검색조건 - PERIOD FM> -----------------" ).append("\n"); 
		query.append("            AND   A.POL_ETD_DT BETWEEN TO_DATE(@[fromdate], 'YYYY-MM-DD') AND TO_DATE(@[todate], 'YYYY-MM-DD')+0.99999" ).append("\n"); 
		query.append("            	#else" ).append("\n"); 
		query.append("            -- < 검색조건 - PERIOD TO> -----------------" ).append("\n"); 
		query.append("            AND   A.POD_ETB_DT BETWEEN TO_DATE(@[fromdate], 'YYYY-MM-DD') AND TO_DATE(@[todate], 'YYYY-MM-DD')+0.99999" ).append("\n"); 
		query.append("                #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("            #else" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("            -- < 검색조건 - VVD> -----------------" ).append("\n"); 
		query.append("            AND   A.VSL_CD     = SUBSTR(@[vvdname],0,4)" ).append("\n"); 
		query.append("            AND   A.SKD_VOY_NO = SUBSTR(@[vvdname],5,4)" ).append("\n"); 
		query.append("            AND   A.SKD_DIR_CD = SUBSTR(@[vvdname],9,1)" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("            #end   " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("            #if ( ${lane} != '' )" ).append("\n"); 
		query.append("            ---- < 검색조건 - LANE> -----------------" ).append("\n"); 
		query.append("            AND   A.VSL_LANE_CD = @[lane]" ).append("\n"); 
		query.append("            #end" ).append("\n"); 
		query.append("            " ).append("\n"); 
		query.append("            #if ( ${fromlocation} != '') -- FROM LOCATION 있거나 FROM 선택이면 " ).append("\n"); 
		query.append("            -- < 검색조건 - FROM LOCATION> -----------------" ).append("\n"); 
		query.append("            AND   A.POL_YD_CD IN (" ).append("\n"); 
		query.append("                                    SELECT DISTINCT C.YD_CD" ).append("\n"); 
		query.append("                                    FROM MDM_EQ_ORZ_CHT A" ).append("\n"); 
		query.append("                                        ,MDM_LOCATION B" ).append("\n"); 
		query.append("                                        ,MDM_YARD C               	    " ).append("\n"); 
		query.append("                                    WHERE A.SCC_CD = B.SCC_CD " ).append("\n"); 
		query.append("                                    AND   B.LOC_CD = C.LOC_CD  " ).append("\n"); 
		query.append("                                    AND   A.DELT_FLG = 'N'" ).append("\n"); 
		query.append("                                    AND   B.DELT_FLG = 'N' " ).append("\n"); 
		query.append("                                    AND   C.DELT_FLG = 'N' " ).append("\n"); 
		query.append("                                    " ).append("\n"); 
		query.append("            	#if 	( ${fromstatus} == 'R' )" ).append("\n"); 
		query.append("                                    AND   A.RCC_CD IN ( ${fromLocationText} )" ).append("\n"); 
		query.append("            	#elseif ( ${fromstatus} == 'L' )" ).append("\n"); 
		query.append("                                    AND   A.LCC_CD IN ( ${fromLocationText} )" ).append("\n"); 
		query.append("            	#elseif ( ${fromstatus} == 'E' ) " ).append("\n"); 
		query.append("                                    AND   A.ECC_CD IN ( ${fromLocationText} )" ).append("\n"); 
		query.append("            	#elseif ( ${fromstatus} == 'S' )" ).append("\n"); 
		query.append("                                    AND   A.SCC_CD IN ( ${fromLocationText} )" ).append("\n"); 
		query.append("            	#else" ).append("\n"); 
		query.append("                                    AND   C.YD_CD  IN ( ${fromLocationText} )      " ).append("\n"); 
		query.append("            	#end                 " ).append("\n"); 
		query.append("                                 )" ).append("\n"); 
		query.append("            #end" ).append("\n"); 
		query.append("            " ).append("\n"); 
		query.append("            	" ).append("\n"); 
		query.append("            #if ( ${tolocation} != '') -- TO LOCATION 있거나 TO 선택이면" ).append("\n"); 
		query.append("            -- < 검색조건 - TO LOCATION> -----------------" ).append("\n"); 
		query.append("            AND   A.POD_YD_CD IN (" ).append("\n"); 
		query.append("                                    SELECT DISTINCT C.YD_CD" ).append("\n"); 
		query.append("                                    FROM MDM_EQ_ORZ_CHT A" ).append("\n"); 
		query.append("                                        ,MDM_LOCATION B" ).append("\n"); 
		query.append("                                        ,MDM_YARD C               	    " ).append("\n"); 
		query.append("                                    WHERE A.SCC_CD = B.SCC_CD " ).append("\n"); 
		query.append("                                    AND   B.LOC_CD = C.LOC_CD  " ).append("\n"); 
		query.append("                                    AND   A.DELT_FLG = 'N'" ).append("\n"); 
		query.append("                                    AND   B.DELT_FLG = 'N' " ).append("\n"); 
		query.append("                                    AND   C.DELT_FLG = 'N' " ).append("\n"); 
		query.append("            	#if 	( ${tostatus} == 'R' )                        " ).append("\n"); 
		query.append("                                    AND   A.RCC_CD IN ( ${toLocationText} )" ).append("\n"); 
		query.append("            	#elseif ( ${tostatus} == 'L' )" ).append("\n"); 
		query.append("                                    AND   A.LCC_CD IN ( ${toLocationText} )" ).append("\n"); 
		query.append("            	#elseif ( ${tostatus} == 'E' ) " ).append("\n"); 
		query.append("                                    AND   A.ECC_CD IN ( ${toLocationText} )" ).append("\n"); 
		query.append("            	#elseif ( ${tostatus} == 'S' )" ).append("\n"); 
		query.append("                                    AND   A.SCC_CD IN ( ${toLocationText} )" ).append("\n"); 
		query.append("            	#else" ).append("\n"); 
		query.append("                                    AND   C.YD_CD  IN ( ${toLocationText} )      " ).append("\n"); 
		query.append("            	#end                               " ).append("\n"); 
		query.append("                                 )" ).append("\n"); 
		query.append("            #end     " ).append("\n"); 
		query.append("            " ).append("\n"); 
		query.append("         " ).append("\n"); 
		query.append("          " ).append("\n"); 
		query.append("         " ).append("\n"); 
		query.append("        ) A" ).append("\n"); 
		query.append("        ,BKG_QUANTITY             C" ).append("\n"); 
		query.append("        ,BKG_BOOKING              D" ).append("\n"); 
		query.append("    WHERE A.MTY_BKG_NO   = C.BKG_NO(+)" ).append("\n"); 
		query.append("    AND   A.CNTR_TPSZ_CD = C.CNTR_TPSZ_CD(+)" ).append("\n"); 
		query.append("    AND   A.MTY_BKG_NO   = D.BKG_NO(+)" ).append("\n"); 
		query.append("    " ).append("\n"); 
		query.append("    GROUP BY A.TRSP_MOD_CD" ).append("\n"); 
		query.append("            ,A.VSL_CD" ).append("\n"); 
		query.append("            ,A.SKD_VOY_NO" ).append("\n"); 
		query.append("            ,A.SKD_DIR_CD" ).append("\n"); 
		query.append("            ,A.BKG_EXE_SEQ" ).append("\n"); 
		query.append("            ,A.VSL_LANE_CD" ).append("\n"); 
		query.append("            ,A.POL_YD_CD" ).append("\n"); 
		query.append("            ,A.POD_YD_CD" ).append("\n"); 
		query.append("            ,TO_CHAR(A.POL_ETD_DT,'YYYY-MM-DD HH24:MI:SS')" ).append("\n"); 
		query.append("            ,TO_CHAR(A.POD_ETB_DT,'YYYY-MM-DD HH24:MI:SS')" ).append("\n"); 
		query.append("            ,A.MTY_BKG_FLG " ).append("\n"); 
		query.append("            ,A.MTY_BKG_SPLIT_FLG" ).append("\n"); 
		query.append("            ,A.MTY_ROB_FLG" ).append("\n"); 
		query.append("            ,A.MTY_BKG_NO" ).append("\n"); 
		query.append("            ,A.OLD_BKG_GRP_NO " ).append("\n"); 
		query.append("            ,A.EQ_REPO_PURP_CD" ).append("\n"); 
		query.append("            ,A.REPO_PLN_FB_RSN_CD" ).append("\n"); 
		query.append("            ,A.REPO_PLN_FB_RMK" ).append("\n"); 
		query.append("            ,A.ECC_CD   " ).append("\n"); 
		query.append("            ,A.ORG_TO_ECC_CD" ).append("\n"); 
		query.append("            ,D.BKG_STS_CD" ).append("\n"); 
		query.append("            ,A.BKG_STS_CD" ).append("\n"); 
		query.append("            ,DECODE(A.MTY_BKG_NO, NULL, A.UPD_USR_ID, D.UPD_USR_ID) " ).append("\n"); 
		query.append("            ,DECODE(A.MTY_BKG_NO, NULL, A.UPD_DT,     D.UPD_DT)  " ).append("\n"); 
		query.append("            ,A.POL_CLPT_IND_SEQ" ).append("\n"); 
		query.append("            ,A.POD_CLPT_IND_SEQ   " ).append("\n"); 
		query.append(") A" ).append("\n"); 
		query.append(",COM_USER B" ).append("\n"); 
		query.append("WHERE   A.UPD_USR_ID   = B.USR_ID(+)" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if ( ${itemNameText} != '' )" ).append("\n"); 
		query.append("-- < 검색조건 - ITEM> -----------------" ).append("\n"); 
		query.append("AND  A.TRSP_MOD_CD IN ( ${itemNameText} ) -- V/W" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("ORDER BY A.VSL_CD" ).append("\n"); 
		query.append("        ,A.SKD_VOY_NO" ).append("\n"); 
		query.append("        ,A.SKD_DIR_CD" ).append("\n"); 
		query.append("        ,A.ECC_CD        -- FROM" ).append("\n"); 
		query.append("        ,A.ORG_TO_LOC_CD -- TO" ).append("\n"); 
		query.append("        ,A.ORD_SEQ" ).append("\n"); 
		query.append("        ,A.MTY_BKG_NO" ).append("\n"); 
		query.append("        ,A.BKG_EXE_SEQ" ).append("\n"); 
		query.append("        ,A.VPS_ETD_DT                     " ).append("\n"); 
		query.append("        ,A.VPS_ETB_DT" ).append("\n"); 

	}
}