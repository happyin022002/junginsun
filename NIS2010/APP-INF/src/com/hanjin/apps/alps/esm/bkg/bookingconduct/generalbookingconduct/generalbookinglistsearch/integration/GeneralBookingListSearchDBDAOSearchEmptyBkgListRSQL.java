/*=========================================================
*Copyright(c) 2018 CyberLogitec
*@FileName : GeneralBookingListSearchDBDAOSearchEmptyBkgListRSQL.java
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

public class GeneralBookingListSearchDBDAOSearchEmptyBkgListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Empty REPO BKG Inquiry
	  * 2011.05.16 이일민 [CHM-201110731] EQR > Empty Repo BKG Inquiry의 POL,POD date 컬럼 추가
	  * 2011.06.13 나상보 [CHM-201111555-01] [EQR] R9 코드 생성에 따른 EQR 모듈 보완 작업 요청
	  * 2013.10.10 최문환 [CHM-201326810] MT BKG Inquiry 화면 상 GOH CNTR 대수 표시 방법 변경
	  * 2014.09.13 신용찬 [ ] ETA, ETB DATE 로직보완 수정(DOUBLE CALLING 적용)
	  * 2015.07.30 신용찬 [CHM-201537230] Empty Repo BKG Inquiry 화면 조회옵션 추가
	  * 2016.01.26 문동선 [CHM-201539624] A5 컨테이너 타입 추가에 따른 BKG/DOC 시스템 보완
	  * </pre>
	  */
	public GeneralBookingListSearchDBDAOSearchEmptyBkgListRSQL(){
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
		query.append("FileName : GeneralBookingListSearchDBDAOSearchEmptyBkgListRSQL").append("\n"); 
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
		query.append("SELECT DISTINCT BK.BKG_NO" ).append("\n"); 
		query.append("      ,BK.BL_NO" ).append("\n"); 
		query.append("      ,BK.MTY_BKG_STS_CD    IND" ).append("\n"); 
		query.append("      ,DECODE(BK.MTY_BKG_STS_CD, 'S', 'SOUND', 'H', 'HANGER RACK', 'D', 'DAMAGED') IND_DESC" ).append("\n"); 
		query.append("      ,NVL((" ).append("\n"); 
		query.append("              SELECT 'Y' " ).append("\n"); 
		query.append("              FROM BKG_CONTAINER CNTR " ).append("\n"); 
		query.append("              WHERE BK.BKG_NO = CNTR.BKG_NO " ).append("\n"); 
		query.append("              AND   MCNTR_BDL_NO IS NOT NULL " ).append("\n"); 
		query.append("              AND   ROWNUM = 1" ).append("\n"); 
		query.append("            )" ).append("\n"); 
		query.append("            ,'N'" ).append("\n"); 
		query.append("          ) BUNDLE" ).append("\n"); 
		query.append("      ,CASE WHEN (" ).append("\n"); 
		query.append("                   SELECT COUNT(1) " ).append("\n"); 
		query.append("                   FROM BKG_VVD VVD " ).append("\n"); 
		query.append("                   WHERE BK.BKG_NO = VVD.BKG_NO" ).append("\n"); 
		query.append("                  ) > 1 " ).append("\n"); 
		query.append("            THEN 'Y' " ).append("\n"); 
		query.append("            ELSE 'N' " ).append("\n"); 
		query.append("       END TS" ).append("\n"); 
		query.append("      ,BK.VSL_CD||BK.SKD_VOY_NO||BK.SKD_DIR_CD VVD" ).append("\n"); 
		query.append("      ,(" ).append("\n"); 
		query.append("          SELECT BK.SLAN_CD " ).append("\n"); 
		query.append("          FROM VSK_VSL_SKD SKD " ).append("\n"); 
		query.append("          WHERE SKD.VSL_CD     = BK.VSL_CD " ).append("\n"); 
		query.append("          AND   SKD.SKD_VOY_NO = BK.SKD_VOY_NO " ).append("\n"); 
		query.append("          AND   SKD_DIR_CD     = BK.SKD_DIR_CD" ).append("\n"); 
		query.append("       ) LANE" ).append("\n"); 
		query.append("      ,BK.MTY_SPLIT_AVAL_CD EMT" ).append("\n"); 
		query.append("      ,DECODE(BK.MTY_SPLIT_AVAL_CD, 'W', 'WATER', 'Z', 'SINGLE POD', 'C', 'MULTI POD') EMT_DESC" ).append("\n"); 
		query.append("      ,BK.POL_CD||SUBSTR(BK.POL_NOD_CD, 6, 2) POL_CD" ).append("\n"); 
		query.append("      " ).append("\n"); 
		query.append("      -- 2015.07.30 신용찬 [CHM-201537230] Empty Repo BKG Inquiry 화면 조회옵션 추가" ).append("\n"); 
		query.append("      -- S: SPLIT 이면 BKG_BOOKING 에서 조회, 아니면 EQR 에서 POD 조회 (XXXXX 처리 보완 요청)" ).append("\n"); 
		query.append("      --,BK.POD_CD||SUBSTR(BK.POD_NOD_CD, 6, 2) POD_CD" ).append("\n"); 
		query.append("      ,DECODE(BK.BKG_CRE_TP_CD, 'S', BK.POD_CD||SUBSTR(BK.POD_NOD_CD, 6, 2), EQ.POD_YD_CD) POD_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("      ,NVL(" ).append("\n"); 
		query.append("			      (" ).append("\n"); 
		query.append("			          SELECT SUM(DECODE(SUBSTR(CNTR_TPSZ_CD, 2, 1), '2', 1, 0)) " ).append("\n"); 
		query.append("                FROM BKG_CONTAINER CNTR" ).append("\n"); 
		query.append("                WHERE BK.BKG_NO = CNTR.BKG_NO" ).append("\n"); 
		query.append("            )" ).append("\n"); 
		query.append("			     ,(" ).append("\n"); 
		query.append("			          SELECT SUM(DECODE(SUBSTR(CNTR_TPSZ_CD, 2, 1), '2', OP_CNTR_QTY, 0)) " ).append("\n"); 
		query.append("                FROM BKG_QUANTITY QTY" ).append("\n"); 
		query.append("                WHERE BK.BKG_NO = QTY.BKG_NO" ).append("\n"); 
		query.append("            )" ).append("\n"); 
		query.append("			) TEU        " ).append("\n"); 
		query.append("      ,NVL(" ).append("\n"); 
		query.append("			      (" ).append("\n"); 
		query.append("			          SELECT SUM(DECODE(SUBSTR(CNTR_TPSZ_CD, 2, 1), '2', 0, 1)) " ).append("\n"); 
		query.append("                FROM BKG_CONTAINER CNTR" ).append("\n"); 
		query.append("                WHERE BK.BKG_NO = CNTR.BKG_NO" ).append("\n"); 
		query.append("            )" ).append("\n"); 
		query.append("			     ,(" ).append("\n"); 
		query.append("			          SELECT SUM(DECODE(SUBSTR(CNTR_TPSZ_CD, 2, 1), '2', 0, OP_CNTR_QTY)) " ).append("\n"); 
		query.append("                FROM BKG_QUANTITY QTY" ).append("\n"); 
		query.append("                WHERE BK.BKG_NO = QTY.BKG_NO" ).append("\n"); 
		query.append("            )" ).append("\n"); 
		query.append("			) FEU" ).append("\n"); 
		query.append("		  ,NVL(" ).append("\n"); 
		query.append("			      (" ).append("\n"); 
		query.append("			          SELECT SUM(DECODE(SUBSTR(CNTR_TPSZ_CD, 2, 1), '2', 1, 0)) " ).append("\n"); 
		query.append("                FROM BKG_CONTAINER CNTR" ).append("\n"); 
		query.append("                WHERE BK.BKG_NO = CNTR.BKG_NO" ).append("\n"); 
		query.append("            )" ).append("\n"); 
		query.append("			     ,(" ).append("\n"); 
		query.append("			          SELECT SUM(DECODE(SUBSTR(CNTR_TPSZ_CD, 2, 1), '2', OP_CNTR_QTY, 0)) " ).append("\n"); 
		query.append("                FROM BKG_QUANTITY QTY" ).append("\n"); 
		query.append("                WHERE BK.BKG_NO = QTY.BKG_NO" ).append("\n"); 
		query.append("            )" ).append("\n"); 
		query.append("		   ) " ).append("\n"); 
		query.append("		  + " ).append("\n"); 
		query.append("		  (" ).append("\n"); 
		query.append("		   NVL(" ).append("\n"); 
		query.append("			      (" ).append("\n"); 
		query.append("			          SELECT SUM(DECODE(SUBSTR(CNTR_TPSZ_CD, 2, 1), '2', 0, 1)) " ).append("\n"); 
		query.append("                FROM BKG_CONTAINER CNTR" ).append("\n"); 
		query.append("                WHERE BK.BKG_NO = CNTR.BKG_NO" ).append("\n"); 
		query.append("            )" ).append("\n"); 
		query.append("			     ,(" ).append("\n"); 
		query.append("			          SELECT SUM(DECODE(SUBSTR(CNTR_TPSZ_CD, 2, 1), '2', 0, OP_CNTR_QTY)) " ).append("\n"); 
		query.append("                FROM BKG_QUANTITY QTY" ).append("\n"); 
		query.append("                WHERE BK.BKG_NO = QTY.BKG_NO" ).append("\n"); 
		query.append("            )" ).append("\n"); 
		query.append("		    ) * 2  " ).append("\n"); 
		query.append("		  ) GTTL" ).append("\n"); 
		query.append("      ,BK.BKG_OFC_CD" ).append("\n"); 
		query.append("      ,SUBSTR(BKG_JOIN_FNC(CURSOR(" ).append("\n"); 
		query.append("                                  SELECT CNTR_TPSZ_CD||':'||SUM(OP_CNTR_QTY)" ).append("\n"); 
		query.append("                                  FROM BKG_QUANTITY QTY" ).append("\n"); 
		query.append("                                  WHERE BK.BKG_NO = QTY.BKG_NO" ).append("\n"); 
		query.append("                                  GROUP BY CNTR_TPSZ_CD" ).append("\n"); 
		query.append("                                 )" ).append("\n"); 
		query.append("                          ), 1, 200" ).append("\n"); 
		query.append("             ) CNTR_VOLUMN" ).append("\n"); 
		query.append("      ,TO_CHAR(BK.BKG_CRE_DT, 'YYYYMMDD HH24:MI') BOOKING_DATE" ).append("\n"); 
		query.append("      ,NVL(" ).append("\n"); 
		query.append("            (" ).append("\n"); 
		query.append("                SELECT TO_CHAR(MAX(CNTR.CGO_RCV_DT), 'YYYYMMDD HH24:MI')" ).append("\n"); 
		query.append("	              FROM BKG_CONTAINER CNTR" ).append("\n"); 
		query.append("	              WHERE BK.BKG_NO = CNTR.BKG_NO" ).append("\n"); 
		query.append("	          )			" ).append("\n"); 
		query.append("			     ,(" ).append("\n"); 
		query.append("			          SELECT TO_CHAR(BKG_CRE_DT, 'YYYYMMDD HH24:MI')" ).append("\n"); 
		query.append("				        FROM BKG_BOOKING DT, BKG_CONTAINER CNTR" ).append("\n"); 
		query.append("				        WHERE DT.BKG_NO = BK.BKG_NO" ).append("\n"); 
		query.append("                AND   DT.BKG_NO = CNTR.BKG_NO" ).append("\n"); 
		query.append("				        AND   ROWNUM    = 1" ).append("\n"); 
		query.append("				    )" ).append("\n"); 
		query.append("			 ) CNTR_ATTACH_DATE				  " ).append("\n"); 
		query.append("      ,(" ).append("\n"); 
		query.append("           SELECT MAX(SKD.VPS_ETB_DT)" ).append("\n"); 
		query.append("           FROM VSK_VSL_PORT_SKD SKD" ).append("\n"); 
		query.append("           WHERE SKD.VSL_CD      = BK.VSL_CD" ).append("\n"); 
		query.append("           AND   SKD.SKD_VOY_NO  = BK.SKD_VOY_NO" ).append("\n"); 
		query.append("           AND   SKD.SKD_DIR_CD  = BK.SKD_DIR_CD" ).append("\n"); 
		query.append("           AND   SKD.VPS_PORT_CD = BK.POL_CD" ).append("\n"); 
		query.append("       ) AS POL_ETB" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("-- ROB SPLIT 의 ETB 를 정확히 추출하기 위해 수정, 신용찬, 2015-12-15, 송현애 과장 요청" ).append("\n"); 
		query.append("--      ,(" ).append("\n"); 
		query.append("--           SELECT MIN(SKD.VPS_ETB_DT)" ).append("\n"); 
		query.append("--           FROM VSK_VSL_PORT_SKD SKD" ).append("\n"); 
		query.append("--           WHERE SKD.VSL_CD      = BK.VSL_CD" ).append("\n"); 
		query.append("--           AND   SKD.SKD_VOY_NO  = BK.SKD_VOY_NO" ).append("\n"); 
		query.append("--           AND   SKD.SKD_DIR_CD  = BK.SKD_DIR_CD" ).append("\n"); 
		query.append("--           -- 2015.07.30 신용찬 [CHM-201537230] Empty Repo BKG Inquiry 화면 조회옵션 추가" ).append("\n"); 
		query.append("--           --AND   SKD.VPS_PORT_CD = BK.POD_CD" ).append("\n"); 
		query.append("--           AND SKD.VPS_PORT_CD = DECODE(BK.BKG_CRE_TP_CD, 'S', BK.POD_CD, SUBSTR(EQ.POD_YD_CD,0,5))" ).append("\n"); 
		query.append("--       ) AS POD_ETA " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("      ,CASE WHEN EQ.MTY_BKG_SPLIT_FLG = 'Y' AND EQ.MTY_ROB_FLG = 'Y' " ).append("\n"); 
		query.append("            THEN" ).append("\n"); 
		query.append("            (" ).append("\n"); 
		query.append("                 SELECT POD_ETB_DT " ).append("\n"); 
		query.append("                 FROM EQR_CTRL_MTY_BKG_EXE" ).append("\n"); 
		query.append("                 WHERE MTY_BKG_NO = BK.BKG_NO" ).append("\n"); 
		query.append("             )             " ).append("\n"); 
		query.append("            ELSE" ).append("\n"); 
		query.append("            (" ).append("\n"); 
		query.append("                 SELECT MIN(SKD.VPS_ETB_DT)" ).append("\n"); 
		query.append("                 FROM VSK_VSL_PORT_SKD SKD" ).append("\n"); 
		query.append("                 WHERE SKD.VSL_CD      = BK.VSL_CD" ).append("\n"); 
		query.append("                 AND   SKD.SKD_VOY_NO  = BK.SKD_VOY_NO" ).append("\n"); 
		query.append("                 AND   SKD.SKD_DIR_CD  = BK.SKD_DIR_CD" ).append("\n"); 
		query.append("                 -- 2015.07.30 신용찬 [CHM-201537230] Empty Repo BKG Inquiry 화면 조회옵션 추가" ).append("\n"); 
		query.append("                 --AND   SKD.VPS_PORT_CD = BK.POD_CD" ).append("\n"); 
		query.append("                 AND SKD.VPS_PORT_CD = DECODE(BK.BKG_CRE_TP_CD, 'S', BK.POD_CD, SUBSTR(EQ.POD_YD_CD,0,5))" ).append("\n"); 
		query.append("             ) " ).append("\n"); 
		query.append("        END  POD_ETA  " ).append("\n"); 
		query.append("             				  " ).append("\n"); 
		query.append("      ,(SELECT COUNT(1) FROM BKG_CONTAINER CNTR WHERE BK.BKG_NO = CNTR.BKG_NO AND CNTR.CNTR_TPSZ_CD = 'D2') D2" ).append("\n"); 
		query.append("      ,(SELECT COUNT(1) FROM BKG_CONTAINER CNTR WHERE BK.BKG_NO = CNTR.BKG_NO AND CNTR.CNTR_TPSZ_CD = 'D4') D4" ).append("\n"); 
		query.append("      ,(SELECT COUNT(1) FROM BKG_CONTAINER CNTR WHERE BK.BKG_NO = CNTR.BKG_NO AND CNTR.CNTR_TPSZ_CD = 'D5') D5" ).append("\n"); 
		query.append("      ,(SELECT COUNT(1) FROM BKG_CONTAINER CNTR WHERE BK.BKG_NO = CNTR.BKG_NO AND CNTR.CNTR_TPSZ_CD = 'D7') D7" ).append("\n"); 
		query.append("      ,(SELECT COUNT(1) FROM BKG_CONTAINER CNTR WHERE BK.BKG_NO = CNTR.BKG_NO AND CNTR.CNTR_TPSZ_CD = 'DX') DX" ).append("\n"); 
		query.append("      ,(SELECT COUNT(1) FROM BKG_CONTAINER CNTR WHERE BK.BKG_NO = CNTR.BKG_NO AND CNTR.CNTR_TPSZ_CD = 'R2') R2" ).append("\n"); 
		query.append("      ,(SELECT COUNT(1) FROM BKG_CONTAINER CNTR WHERE BK.BKG_NO = CNTR.BKG_NO AND CNTR.CNTR_TPSZ_CD = 'R5') R5" ).append("\n"); 
		query.append("      ,(SELECT COUNT(1) FROM BKG_CONTAINER CNTR WHERE BK.BKG_NO = CNTR.BKG_NO AND CNTR.CNTR_TPSZ_CD = 'R9') R9" ).append("\n"); 
		query.append("      ,(SELECT COUNT(1) FROM BKG_CONTAINER CNTR WHERE BK.BKG_NO = CNTR.BKG_NO AND CNTR.CNTR_TPSZ_CD = 'F2') F2" ).append("\n"); 
		query.append("      ,(SELECT COUNT(1) FROM BKG_CONTAINER CNTR WHERE BK.BKG_NO = CNTR.BKG_NO AND CNTR.CNTR_TPSZ_CD = 'F4') F4" ).append("\n"); 
		query.append("      ,(SELECT COUNT(1) FROM BKG_CONTAINER CNTR WHERE BK.BKG_NO = CNTR.BKG_NO AND CNTR.CNTR_TPSZ_CD = 'F5') F5" ).append("\n"); 
		query.append("      ,(SELECT COUNT(1) FROM BKG_CONTAINER CNTR WHERE BK.BKG_NO = CNTR.BKG_NO AND CNTR.CNTR_TPSZ_CD = 'O2') O2" ).append("\n"); 
		query.append("      ,(SELECT COUNT(1) FROM BKG_CONTAINER CNTR WHERE BK.BKG_NO = CNTR.BKG_NO AND CNTR.CNTR_TPSZ_CD = 'O4') O4" ).append("\n"); 
		query.append("	  ,(SELECT COUNT(1) FROM BKG_CONTAINER CNTR WHERE BK.BKG_NO = CNTR.BKG_NO AND CNTR.CNTR_TPSZ_CD = 'O5') O5" ).append("\n"); 
		query.append("      ,(SELECT COUNT(1) FROM BKG_CONTAINER CNTR WHERE BK.BKG_NO = CNTR.BKG_NO AND CNTR.CNTR_TPSZ_CD = 'O7') O7" ).append("\n"); 
		query.append("      ,(SELECT COUNT(1) FROM BKG_CONTAINER CNTR WHERE BK.BKG_NO = CNTR.BKG_NO AND CNTR.CNTR_TPSZ_CD = 'A2') A2" ).append("\n"); 
		query.append("      ,(SELECT COUNT(1) FROM BKG_CONTAINER CNTR WHERE BK.BKG_NO = CNTR.BKG_NO AND CNTR.CNTR_TPSZ_CD = 'A4') A4" ).append("\n"); 
		query.append("      ,(SELECT COUNT(1) FROM BKG_CONTAINER CNTR WHERE BK.BKG_NO = CNTR.BKG_NO AND CNTR.CNTR_TPSZ_CD = 'A5') A5" ).append("\n"); 
		query.append("      ,(SELECT COUNT(1) FROM BKG_CONTAINER CNTR WHERE BK.BKG_NO = CNTR.BKG_NO AND CNTR.CNTR_TPSZ_CD = 'S2') S2" ).append("\n"); 
		query.append("      ,(SELECT COUNT(1) FROM BKG_CONTAINER CNTR WHERE BK.BKG_NO = CNTR.BKG_NO AND CNTR.CNTR_TPSZ_CD = 'S4') S4" ).append("\n"); 
		query.append("	  ,(SELECT COUNT(1) FROM MST_CONTAINER MST, BKG_CONTAINER CNTR WHERE BK.BKG_NO = CNTR.BKG_NO AND MST.CNTR_NO = CNTR.CNTR_NO AND CNTR.CNTR_TPSZ_CD = 'D2' AND MST.CNTR_HNGR_RCK_CD IS NOT NULL) D2_H" ).append("\n"); 
		query.append("      ,(SELECT COUNT(1) FROM MST_CONTAINER MST, BKG_CONTAINER CNTR WHERE BK.BKG_NO = CNTR.BKG_NO AND MST.CNTR_NO = CNTR.CNTR_NO AND CNTR.CNTR_TPSZ_CD = 'D4' AND MST.CNTR_HNGR_RCK_CD IS NOT NULL) D4_H" ).append("\n"); 
		query.append("      ,(SELECT COUNT(1) FROM MST_CONTAINER MST, BKG_CONTAINER CNTR WHERE BK.BKG_NO = CNTR.BKG_NO AND MST.CNTR_NO = CNTR.CNTR_NO AND CNTR.CNTR_TPSZ_CD = 'D5' AND MST.CNTR_HNGR_RCK_CD IS NOT NULL) D5_H" ).append("\n"); 
		query.append("      ,(SELECT COUNT(1) FROM MST_CONTAINER MST, BKG_CONTAINER CNTR WHERE BK.BKG_NO = CNTR.BKG_NO AND MST.CNTR_NO = CNTR.CNTR_NO AND CNTR.CNTR_TPSZ_CD = 'D7' AND MST.CNTR_HNGR_RCK_CD IS NOT NULL) D7_H" ).append("\n"); 
		query.append("      " ).append("\n"); 
		query.append("      ,SUBSTR(BK.INTER_RMK, 1, 300) REMARK" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("FROM BKG_BOOKING BK, " ).append("\n"); 
		query.append("    (" ).append("\n"); 
		query.append("        SELECT BK.BKG_NO" ).append("\n"); 
		query.append("              ,BK.FM_BKG_NO" ).append("\n"); 
		query.append("        FROM BKG_BOOKING BK" ).append("\n"); 
		query.append("#if (${bkg_no} == '' && ${bl_no} == '')      " ).append("\n"); 
		query.append("	#if (${vvd_cd} != '')  " ).append("\n"); 
		query.append("	          ,BKG_VVD VVD  " ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("	#if (${cntr_no1} != '')   " ).append("\n"); 
		query.append("	          ,BKG_CONTAINER CNTR" ).append("\n"); 
		query.append("    #elseif (${cntr_no1} == '' && (${cntrTpsz} != '' && ${tpsztype} != ''))  " ).append("\n"); 
		query.append("	          ,BKG_CONTAINER CNTR" ).append("\n"); 
		query.append("              ,BKG_QUANTITY  QTY" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("	#if (${pod_cd} != '') " ).append("\n"); 
		query.append("              ,EQR_CTRL_MTY_BKG_EXE EQ" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("	#if (${bkg_date_tp} == 'E')" ).append("\n"); 
		query.append("		        ,(" ).append("\n"); 
		query.append("                 SELECT SKD.VPS_ETA_DT" ).append("\n"); 
		query.append("                       ,BK.BKG_NO" ).append("\n"); 
		query.append("                       ,VVD.POD_CD" ).append("\n"); 
		query.append("                 FROM BKG_BOOKING BK" ).append("\n"); 
		query.append("                     ,BKG_VVD VVD" ).append("\n"); 
		query.append("                     ,VSK_VSL_PORT_SKD SKD" ).append("\n"); 
		query.append("                 WHERE BK.BKG_NO            = VVD.BKG_NO" ).append("\n"); 
		query.append("                 AND   BK.POD_CD            = VVD.POD_CD" ).append("\n"); 
		query.append("                 AND   VVD.VSL_PRE_PST_CD   IN ('T','U')" ).append("\n"); 
		query.append("                 AND   VVD.VSL_CD           = SKD.VSL_CD" ).append("\n"); 
		query.append("                 AND   VVD.SKD_VOY_NO       = SKD.SKD_VOY_NO" ).append("\n"); 
		query.append("                 AND   VVD.SKD_DIR_CD       = SKD.SKD_DIR_CD" ).append("\n"); 
		query.append("                 AND   VVD.POD_CD           = SKD.VPS_PORT_CD" ).append("\n"); 
		query.append("                 AND   VVD.POD_CLPT_IND_SEQ = SKD.CLPT_IND_SEQ" ).append("\n"); 
		query.append("			#if (${vvd_cd} != '')" ).append("\n"); 
		query.append("			           AND VVD.VSL_CD             = SUBSTR(@[vvd_cd], 1, 4)" ).append("\n"); 
		query.append("			           AND VVD.SKD_VOY_NO         = SUBSTR(@[vvd_cd], 5, 4)" ).append("\n"); 
		query.append("			           AND VVD.SKD_DIR_CD         = SUBSTR(@[vvd_cd], 9, 1)  " ).append("\n"); 
		query.append("			#end" ).append("\n"); 
		query.append("			#if (${cre_from_dt} != '') " ).append("\n"); 
		query.append("		   		       AND SKD.VPS_ETA_DT         >= TO_DATE(@[cre_from_dt]|| '00:00:00','YYYY-MM-DD HH24:MI:SS')" ).append("\n"); 
		query.append("			#end" ).append("\n"); 
		query.append("			#if (${cre_to_dt} != '') " ).append("\n"); 
		query.append("		   		       AND SKD.VPS_ETA_DT         <= TO_DATE(@[cre_to_dt]|| '23:59:59','YYYY-MM-DD HH24:MI:SS')" ).append("\n"); 
		query.append("			#end" ).append("\n"); 
		query.append("		         ) ETA" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("        WHERE BK.BKG_CGO_TP_CD = 'P'" ).append("\n"); 
		query.append("        AND 'Y' = CASE WHEN BK.SPLIT_FLG = 'Y' AND BK.BKG_STS_CD = 'X' THEN 'Y'   --SPLIT인데 CANCEL된 건      -> MASTER BKG  -> 조회됨" ).append("\n"); 
		query.append("				       WHEN BK.SPLIT_FLG = 'N' AND BK.BKG_STS_CD = 'X' THEN 'N'   --SPLIT이 아닌데 CANCEL된 건 -> 일반 CANCEL -> 조회안됨" ).append("\n"); 
		query.append("				       ELSE 'Y' " ).append("\n"); 
		query.append("				  END --그외 조회됨" ).append("\n"); 
		query.append("#if (${bkg_no} != '')    " ).append("\n"); 
		query.append("        AND BK.BKG_NO LIKE @[bkg_no]||'%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if  (${bl_no} != '')    " ).append("\n"); 
		query.append("        AND BK.BL_NO LIKE @[bl_no]||'%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${bkg_ofc_cd} != '')  " ).append("\n"); 
		query.append("        AND BK.BKG_OFC_CD = @[bkg_ofc_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${bkg_no} == '' && ${bl_no} == '')      " ).append("\n"); 
		query.append("	#if (${vvd_cd} != '')" ).append("\n"); 
		query.append("	    AND BK.BKG_NO      = VVD.BKG_NO   " ).append("\n"); 
		query.append("	    AND VVD.VSL_CD     = SUBSTR(@[vvd_cd], 1, 4)" ).append("\n"); 
		query.append("	    AND VVD.SKD_VOY_NO = SUBSTR(@[vvd_cd], 5, 4)" ).append("\n"); 
		query.append("	    AND VVD.SKD_DIR_CD = SUBSTR(@[vvd_cd], 9, 1)  " ).append("\n"); 
		query.append("	#end" ).append("\n"); 
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
		query.append("	#if (${pol_cd} != '') " ).append("\n"); 
		query.append("	    AND BK.POL_CD LIKE @[pol_cd]||'%'" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("	#if (${pod_cd} != '')         " ).append("\n"); 
		query.append("	    --AND BK.POD_CD LIKE pod_cd||'%'" ).append("\n"); 
		query.append("        AND BK.BKG_NO = EQ.MTY_BKG_NO(+)" ).append("\n"); 
		query.append("        AND EQ.POD_YD_CD LIKE @[pod_cd]||'%'" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("	#if (${pre_rly_port_cd} != '') " ).append("\n"); 
		query.append("	    AND BK.PRE_RLY_PORT_CD LIKE @[pre_rly_port_cd]||'%'" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("	#if (${pst_rly_port_cd} != '') " ).append("\n"); 
		query.append("	    AND BK.PST_RLY_PORT_CD LIKE @[pst_rly_port_cd]||'%'" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("	#if (${vvd_cd} == '')" ).append("\n"); 
		query.append("		#if (${bkg_date_tp} != 'E')		" ).append("\n"); 
		query.append("			#if (${cre_from_dt} != '') " ).append("\n"); 
		query.append("	    AND BK.BKG_CRE_DT >= TO_DATE(@[cre_from_dt]|| '00:00:00','YYYY-MM-DD HH24:MI:SS')" ).append("\n"); 
		query.append("			#end" ).append("\n"); 
		query.append("			#if (${cre_to_dt} != '') " ).append("\n"); 
		query.append("		AND BK.BKG_CRE_DT <= TO_DATE(@[cre_to_dt]|| '23:59:59','YYYY-MM-DD HH24:MI:SS')" ).append("\n"); 
		query.append("			#end" ).append("\n"); 
		query.append("		#else" ).append("\n"); 
		query.append("	    AND BK.BKG_NO = ETA.BKG_NO" ).append("\n"); 
		query.append("		AND BK.POD_CD = ETA.POD_CD" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("	#if (${vvd_cd_flg} == 'E')  " ).append("\n"); 
		query.append("	    AND VVD.VSL_PRE_PST_CD = 'T'" ).append("\n"); 
		query.append("	#end " ).append("\n"); 
		query.append("	#if (${cntr_attach} == 'Y')  " ).append("\n"); 
		query.append("	    AND (SELECT COUNT(1) FROM BKG_CONTAINER BCNTR WHERE BK.BKG_NO = BCNTR.BKG_NO AND ROWNUM = 1) > 0" ).append("\n"); 
		query.append("	#elseif  (${cntr_attach} == 'N')  " ).append("\n"); 
		query.append("	    AND (SELECT COUNT(1) FROM BKG_CONTAINER BCNTR WHERE BK.BKG_NO = BCNTR.BKG_NO AND ROWNUM = 1) = 0   " ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("    " ).append("\n"); 
		query.append("	#if (${bkg_status} == 'D')  -- VD" ).append("\n"); 
		query.append("        AND NVL(BK.BKG_CRE_TP_CD, 'X') = 'S' -- S:SPLIT" ).append("\n"); 
		query.append("    #elseif  (${bkg_status} == 'L') -- VL" ).append("\n"); 
		query.append("        AND NVL(BK.BKG_CRE_TP_CD, 'X') = 'X' -- L : VL" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("    ) MST_BKG" ).append("\n"); 
		query.append("   ,EQR_CTRL_MTY_BKG_EXE EQ" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${bkg_no} == '' && ${bl_no} == '') " ).append("\n"); 
		query.append("WHERE BK.BKG_NO = MST_BKG.BKG_NO" ).append("\n"); 
		query.append("#else " ).append("\n"); 
		query.append("WHERE (BK.BKG_NO = MST_BKG.BKG_NO OR BK.FM_BKG_NO = MST_BKG.BKG_NO OR MST_BKG.FM_BKG_NO = BK.BKG_NO)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("AND   BK.BKG_NO = EQ.MTY_BKG_NO(+)" ).append("\n"); 

	}
}