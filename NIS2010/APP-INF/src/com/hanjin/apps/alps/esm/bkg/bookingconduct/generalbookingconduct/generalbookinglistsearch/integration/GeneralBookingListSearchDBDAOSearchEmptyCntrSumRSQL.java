/*=========================================================
*Copyright(c) 2018 CyberLogitec
*@FileName : GeneralBookingListSearchDBDAOSearchEmptyCntrSumRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2018.05.02
*@LastModifier : 
*@LastVersion : 1.0
* 2018.05.02 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookinglistsearch.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class GeneralBookingListSearchDBDAOSearchEmptyCntrSumRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Repo Container별 합계
	  * 
	  * 2011.06.13 나상보 [CHM-201111555-01] [EQR] R9 코드 생성에 따른 EQR 모듈 보완 작업 요청
	  * 2015.07.30 신용찬 [CHM-201537230] Empty Repo BKG Inquiry 화면 조회옵션 추가
	  * 2016.01.26 문동선 [CHM-201539624] A5 컨테이너 타입 추가에 따른 BKG/DOC 시스템 보완
	  * </pre>
	  */
	public GeneralBookingListSearchDBDAOSearchEmptyCntrSumRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bl_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_from_dt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("pst_rly_port_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_no2",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_no1",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_to_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pol_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pre_rly_port_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookinglistsearch.integration").append("\n"); 
		query.append("FileName : GeneralBookingListSearchDBDAOSearchEmptyCntrSumRSQL").append("\n"); 
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
		query.append("SELECT   SUM(D2) || CASE WHEN SUM(D2_H) > 0 THEN '('||SUM(D2_H)||')' END SUM_D2" ).append("\n"); 
		query.append("       , SUM(D4) || CASE WHEN SUM(D4_H) > 0 THEN '('||SUM(D4_H)||')' END SUM_D4" ).append("\n"); 
		query.append("       , SUM(D5) || CASE WHEN SUM(D5_H) > 0 THEN '('||SUM(D5_H)||')' END SUM_D5" ).append("\n"); 
		query.append("       , SUM(D7) || CASE WHEN SUM(D7_H) > 0 THEN '('||SUM(D7_H)||')' END SUM_D7" ).append("\n"); 
		query.append("       , SUM(DX) SUM_DX" ).append("\n"); 
		query.append("       , SUM(R2) SUM_R2" ).append("\n"); 
		query.append("       , SUM(R5) SUM_R5" ).append("\n"); 
		query.append("       , SUM(R9) SUM_R9" ).append("\n"); 
		query.append("       , SUM(F2) SUM_F2" ).append("\n"); 
		query.append("       , SUM(F4) SUM_F4" ).append("\n"); 
		query.append("       , SUM(F5) SUM_F5" ).append("\n"); 
		query.append("       , SUM(O2) SUM_O2" ).append("\n"); 
		query.append("       , SUM(O4) SUM_O4" ).append("\n"); 
		query.append("	   , SUM(O5) SUM_O5" ).append("\n"); 
		query.append("	   , SUM(O7) SUM_O7" ).append("\n"); 
		query.append("       , SUM(A2) SUM_A2" ).append("\n"); 
		query.append("       , SUM(A4) SUM_A4" ).append("\n"); 
		query.append("       , SUM(A5) SUM_A5" ).append("\n"); 
		query.append("       , SUM(S2) SUM_S2" ).append("\n"); 
		query.append("       , SUM(S4) SUM_S4   " ).append("\n"); 
		query.append("FROM     (" ).append("\n"); 
		query.append("	       SELECT   (SELECT COUNT(1) FROM BKG_CONTAINER CNTR WHERE BK.BKG_NO = CNTR.BKG_NO AND CNTR.CNTR_TPSZ_CD = 'D2') D2" ).append("\n"); 
		query.append("                  , (SELECT COUNT(1) FROM MST_CONTAINER MST, BKG_CONTAINER CNTR WHERE BK.BKG_NO = CNTR.BKG_NO AND MST.CNTR_NO = CNTR.CNTR_NO AND CNTR.CNTR_TPSZ_CD = 'D2' AND MST.CNTR_HNGR_RCK_CD IS NOT NULL) D2_H" ).append("\n"); 
		query.append("                  , (SELECT COUNT(1) FROM BKG_CONTAINER CNTR WHERE BK.BKG_NO = CNTR.BKG_NO AND CNTR.CNTR_TPSZ_CD = 'D4') D4" ).append("\n"); 
		query.append("                  , (SELECT COUNT(1) FROM MST_CONTAINER MST, BKG_CONTAINER CNTR WHERE BK.BKG_NO = CNTR.BKG_NO AND MST.CNTR_NO = CNTR.CNTR_NO AND CNTR.CNTR_TPSZ_CD = 'D4' AND MST.CNTR_HNGR_RCK_CD IS NOT NULL) D4_H" ).append("\n"); 
		query.append("                  , (SELECT COUNT(1) FROM BKG_CONTAINER CNTR WHERE BK.BKG_NO = CNTR.BKG_NO AND CNTR.CNTR_TPSZ_CD = 'D5') D5" ).append("\n"); 
		query.append("                  , (SELECT COUNT(1) FROM MST_CONTAINER MST, BKG_CONTAINER CNTR WHERE BK.BKG_NO = CNTR.BKG_NO AND MST.CNTR_NO = CNTR.CNTR_NO AND CNTR.CNTR_TPSZ_CD = 'D5' AND MST.CNTR_HNGR_RCK_CD IS NOT NULL) D5_H" ).append("\n"); 
		query.append("                  , (SELECT COUNT(1) FROM BKG_CONTAINER CNTR WHERE BK.BKG_NO = CNTR.BKG_NO AND CNTR.CNTR_TPSZ_CD = 'D7') D7" ).append("\n"); 
		query.append("                  , (SELECT COUNT(1) FROM MST_CONTAINER MST, BKG_CONTAINER CNTR WHERE BK.BKG_NO = CNTR.BKG_NO AND MST.CNTR_NO = CNTR.CNTR_NO AND CNTR.CNTR_TPSZ_CD = 'D7' AND MST.CNTR_HNGR_RCK_CD IS NOT NULL) D7_H" ).append("\n"); 
		query.append("                  , (SELECT COUNT(1) FROM BKG_CONTAINER CNTR WHERE BK.BKG_NO = CNTR.BKG_NO AND CNTR.CNTR_TPSZ_CD = 'R2') R2" ).append("\n"); 
		query.append("                  , (SELECT COUNT(1) FROM BKG_CONTAINER CNTR WHERE BK.BKG_NO = CNTR.BKG_NO AND CNTR.CNTR_TPSZ_CD = 'DX') DX" ).append("\n"); 
		query.append("                  , (SELECT COUNT(1) FROM BKG_CONTAINER CNTR WHERE BK.BKG_NO = CNTR.BKG_NO AND CNTR.CNTR_TPSZ_CD = 'R5') R5" ).append("\n"); 
		query.append("                  , (SELECT COUNT(1) FROM BKG_CONTAINER CNTR WHERE BK.BKG_NO = CNTR.BKG_NO AND CNTR.CNTR_TPSZ_CD = 'R9') R9" ).append("\n"); 
		query.append("                  , (SELECT COUNT(1) FROM BKG_CONTAINER CNTR WHERE BK.BKG_NO = CNTR.BKG_NO AND CNTR.CNTR_TPSZ_CD = 'F2') F2" ).append("\n"); 
		query.append("                  , (SELECT COUNT(1) FROM BKG_CONTAINER CNTR WHERE BK.BKG_NO = CNTR.BKG_NO AND CNTR.CNTR_TPSZ_CD = 'F4') F4" ).append("\n"); 
		query.append("                  , (SELECT COUNT(1) FROM BKG_CONTAINER CNTR WHERE BK.BKG_NO = CNTR.BKG_NO AND CNTR.CNTR_TPSZ_CD = 'F5') F5" ).append("\n"); 
		query.append("                  , (SELECT COUNT(1) FROM BKG_CONTAINER CNTR WHERE BK.BKG_NO = CNTR.BKG_NO AND CNTR.CNTR_TPSZ_CD = 'O2') O2" ).append("\n"); 
		query.append("                  , (SELECT COUNT(1) FROM BKG_CONTAINER CNTR WHERE BK.BKG_NO = CNTR.BKG_NO AND CNTR.CNTR_TPSZ_CD = 'O4') O4" ).append("\n"); 
		query.append("                  , (SELECT COUNT(1) FROM BKG_CONTAINER CNTR WHERE BK.BKG_NO = CNTR.BKG_NO AND CNTR.CNTR_TPSZ_CD = 'O5') O5" ).append("\n"); 
		query.append("				  , (SELECT COUNT(1) FROM BKG_CONTAINER CNTR WHERE BK.BKG_NO = CNTR.BKG_NO AND CNTR.CNTR_TPSZ_CD = 'O7') O7" ).append("\n"); 
		query.append("                  , (SELECT COUNT(1) FROM BKG_CONTAINER CNTR WHERE BK.BKG_NO = CNTR.BKG_NO AND CNTR.CNTR_TPSZ_CD = 'A2') A2" ).append("\n"); 
		query.append("                  , (SELECT COUNT(1) FROM BKG_CONTAINER CNTR WHERE BK.BKG_NO = CNTR.BKG_NO AND CNTR.CNTR_TPSZ_CD = 'A4') A4" ).append("\n"); 
		query.append("                  , (SELECT COUNT(1) FROM BKG_CONTAINER CNTR WHERE BK.BKG_NO = CNTR.BKG_NO AND CNTR.CNTR_TPSZ_CD = 'A5') A5" ).append("\n"); 
		query.append("                  , (SELECT COUNT(1) FROM BKG_CONTAINER CNTR WHERE BK.BKG_NO = CNTR.BKG_NO AND CNTR.CNTR_TPSZ_CD = 'S2') S2" ).append("\n"); 
		query.append("                  , (SELECT COUNT(1) FROM BKG_CONTAINER CNTR WHERE BK.BKG_NO = CNTR.BKG_NO AND CNTR.CNTR_TPSZ_CD = 'S4') S4" ).append("\n"); 
		query.append("	       FROM     (" ).append("\n"); 
		query.append("                      SELECT   DISTINCT BK.BKG_NO" ).append("\n"); 
		query.append("		              FROM     BKG_BOOKING BK" ).append("\n"); 
		query.append("				             , (" ).append("\n"); 
		query.append("                                 SELECT   BK.BKG_NO" ).append("\n"); 
		query.append("                                        , BK.FM_BKG_NO" ).append("\n"); 
		query.append("				                 FROM     BKG_BOOKING BK" ).append("\n"); 
		query.append("#if (${bkg_no} == '' && ${bl_no} == '')      " ).append("\n"); 
		query.append("	#if (${vvd_cd} != '')  " ).append("\n"); 
		query.append("                                        , BKG_VVD VVD  " ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	#if (${cntr_no1} != '')   " ).append("\n"); 
		query.append("                                        , BKG_CONTAINER CNTR" ).append("\n"); 
		query.append("    #elseif (${cntr_no1} == '' && (${cntrTpsz} != '' && ${tpsztype} != ''))  " ).append("\n"); 
		query.append("                                        , BKG_CONTAINER CNTR" ).append("\n"); 
		query.append("                                        , BKG_QUANTITY  QTY" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	#if (${pod_cd} != '') " ).append("\n"); 
		query.append("                                        , EQR_CTRL_MTY_BKG_EXE EQ" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	#if (${bkg_date_tp} == 'E')" ).append("\n"); 
		query.append("                                        , (" ).append("\n"); 
		query.append("                                            SELECT   SKD.VPS_ETA_DT" ).append("\n"); 
		query.append("                                                   , BK.BKG_NO" ).append("\n"); 
		query.append("                                                   , VVD.POD_CD" ).append("\n"); 
		query.append("                                            FROM     BKG_BOOKING BK" ).append("\n"); 
		query.append("                                                   , BKG_VVD VVD" ).append("\n"); 
		query.append("                                                   , VSK_VSL_PORT_SKD SKD" ).append("\n"); 
		query.append("                                            WHERE BK.BKG_NO            = VVD.BKG_NO" ).append("\n"); 
		query.append("                                            AND BK.POD_CD            = VVD.POD_CD" ).append("\n"); 
		query.append("                                            AND VVD.VSL_PRE_PST_CD   IN ('T','U')" ).append("\n"); 
		query.append("                                            AND VVD.VSL_CD           = SKD.VSL_CD" ).append("\n"); 
		query.append("                                            AND VVD.SKD_VOY_NO       = SKD.SKD_VOY_NO" ).append("\n"); 
		query.append("                                            AND VVD.SKD_DIR_CD       = SKD.SKD_DIR_CD" ).append("\n"); 
		query.append("                                            AND VVD.POD_CD           = SKD.VPS_PORT_CD" ).append("\n"); 
		query.append("                                            AND VVD.POD_CLPT_IND_SEQ = SKD.CLPT_IND_SEQ" ).append("\n"); 
		query.append("		#if (${vvd_cd} != '')" ).append("\n"); 
		query.append("                                            AND VVD.VSL_CD     = SUBSTR(@[vvd_cd], 1, 4)" ).append("\n"); 
		query.append("                                            AND VVD.SKD_VOY_NO = SUBSTR(@[vvd_cd], 5, 4)" ).append("\n"); 
		query.append("                                            AND VVD.SKD_DIR_CD = SUBSTR(@[vvd_cd], 9, 1)  " ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("		#if (${cre_from_dt} != '') " ).append("\n"); 
		query.append("				   		AND SKD.VPS_ETA_DT >= TO_DATE(@[cre_from_dt]|| '00:00:00','YYYY-MM-DD HH24:MI:SS')" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("		#if (${cre_to_dt} != '') " ).append("\n"); 
		query.append("				  		AND SKD.VPS_ETA_DT <= TO_DATE(@[cre_to_dt]|| '23:59:59','YYYY-MM-DD HH24:MI:SS')" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("				) eta" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("		 WHERE BK.BKG_CGO_TP_CD = 'P'" ).append("\n"); 
		query.append("		   AND 'Y' = CASE WHEN BK.SPLIT_FLG = 'Y' AND BK.BKG_STS_CD = 'X' THEN 'Y'--SPLIT인데 CANCEL된 건 -> MASTER BKG -> 조회됨" ).append("\n"); 
		query.append("						  WHEN BK.SPLIT_FLG = 'N' AND BK.BKG_STS_CD = 'X' THEN 'N'--SPLIT이 아닌데 CANCEL된 건 -> 일반 CANCEL -> 조회안됨" ).append("\n"); 
		query.append("						  ELSE 'Y' END --그외 조회됨" ).append("\n"); 
		query.append("#if (${bkg_no} != '')    " ).append("\n"); 
		query.append("		   AND BK.BKG_NO LIKE @[bkg_no]||'%'" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("		   AND BK.BKG_STS_CD <> 'X'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if  (${bl_no} != '')    " ).append("\n"); 
		query.append("		   AND BK.BL_NO LIKE @[bl_no]||'%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${bkg_ofc_cd} != '')  " ).append("\n"); 
		query.append("		   AND BK.BKG_OFC_CD = @[bkg_ofc_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${bkg_no} == '' && ${bl_no} == '')      " ).append("\n"); 
		query.append("	#if (${vvd_cd} != '')" ).append("\n"); 
		query.append("		   AND BK.BKG_NO     = VVD.BKG_NO   " ).append("\n"); 
		query.append("		   AND VVD.VSL_CD     = SUBSTR(@[vvd_cd], 1, 4)" ).append("\n"); 
		query.append("		   AND VVD.SKD_VOY_NO = SUBSTR(@[vvd_cd], 5, 4)" ).append("\n"); 
		query.append("		   AND VVD.SKD_DIR_CD = SUBSTR(@[vvd_cd], 9, 1)  " ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	#if (${cntr_no1} != '') " ).append("\n"); 
		query.append("	    AND BK.BKG_NO = CNTR.BKG_NO" ).append("\n"); 
		query.append("	    AND CNTR.CNTR_NO = @[cntr_no1]||@[cntr_no2]" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("    #elseif (${cntr_no1} == '' && (${cntrTpsz} != '' && ${tpsztype} != '')) " ).append("\n"); 
		query.append("        AND BK.BKG_NO = CNTR.BKG_NO (+)" ).append("\n"); 
		query.append("        AND BK.BKG_NO = QTY.BKG_NO(+)" ).append("\n"); 
		query.append("	    AND (CNTR.CNTR_TPSZ_CD IN ( ${tpszTypeText} ) OR QTY.CNTR_TPSZ_CD IN ( ${tpszTypeText} ))" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	#if (${pol_cd} != '') " ).append("\n"); 
		query.append("		   AND BK.POL_CD LIKE @[pol_cd]||'%'" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	#if (${pod_cd} != '')         " ).append("\n"); 
		query.append("	    --and bk.pod_cd LIKE pod_cd||'%'" ).append("\n"); 
		query.append("        AND BK.BKG_NO = EQ.MTY_BKG_NO(+)" ).append("\n"); 
		query.append("        AND EQ.POD_YD_CD LIKE @[pod_cd]||'%'" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	#if (${pre_rly_port_cd} != '') " ).append("\n"); 
		query.append("		   AND BK.PRE_RLY_PORT_CD LIKE @[pre_rly_port_cd]||'%'" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("	#if (${pst_rly_port_cd} != '') " ).append("\n"); 
		query.append("		   AND BK.PST_RLY_PORT_CD LIKE @[pst_rly_port_cd]||'%'" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("	#if (${vvd_cd} == '')" ).append("\n"); 
		query.append("		#if (${bkg_date_tp} != 'E')		" ).append("\n"); 
		query.append("			#if (${cre_from_dt} != '') " ).append("\n"); 
		query.append("    	   AND BK.BKG_CRE_DT >= TO_DATE(@[cre_from_dt]|| '00:00:00','YYYY-MM-DD HH24:MI:SS')" ).append("\n"); 
		query.append("			#end" ).append("\n"); 
		query.append("			#if (${cre_to_dt} != '') " ).append("\n"); 
		query.append("		   AND BK.BKG_CRE_DT <= TO_DATE(@[cre_to_dt]|| '23:59:59','YYYY-MM-DD HH24:MI:SS')" ).append("\n"); 
		query.append("			#end" ).append("\n"); 
		query.append("		#else" ).append("\n"); 
		query.append("			AND BK.BKG_NO = ETA.BKG_NO" ).append("\n"); 
		query.append("			AND BK.POD_CD = ETA.POD_CD" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("	#if (${vvd_cd_flg} == 'E')  " ).append("\n"); 
		query.append("		 	AND VVD.VSL_PRE_PST_CD = 'T'" ).append("\n"); 
		query.append("	#end " ).append("\n"); 
		query.append("	#if (${cntr_attach} == 'Y')  " ).append("\n"); 
		query.append("			AND (SELECT COUNT(1) FROM BKG_CONTAINER BCNTR WHERE BK.BKG_NO = BCNTR.BKG_NO AND ROWNUM = 1) > 0" ).append("\n"); 
		query.append("	#elseif  (${cntr_attach} == 'N')  " ).append("\n"); 
		query.append("		    AND (SELECT COUNT(1) FROM BKG_CONTAINER BCNTR WHERE BK.BKG_NO = BCNTR.BKG_NO AND ROWNUM = 1) = 0   " ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	#if (${bkg_status} == 'D')  -- VD" ).append("\n"); 
		query.append("        AND NVL(BK.BKG_CRE_TP_CD, 'X') = 'S' -- S:SPLIT" ).append("\n"); 
		query.append("    #elseif  (${bkg_status} == 'L') -- VL" ).append("\n"); 
		query.append("        AND NVL(BK.BKG_CRE_TP_CD, 'X') = 'X' -- L : VL" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("		) MST_BKG" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${bkg_no} == '' && ${bl_no} == '') " ).append("\n"); 
		query.append(" WHERE BK.BKG_NO = MST_BKG.BKG_NO" ).append("\n"); 
		query.append("#else " ).append("\n"); 
		query.append(" WHERE (BK.BKG_NO = MST_BKG.BKG_NO OR BK.FM_BKG_NO = MST_BKG.BKG_NO OR MST_BKG.FM_BKG_NO = BK.BKG_NO)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(") BK" ).append("\n"); 
		query.append("    )" ).append("\n"); 

	}
}