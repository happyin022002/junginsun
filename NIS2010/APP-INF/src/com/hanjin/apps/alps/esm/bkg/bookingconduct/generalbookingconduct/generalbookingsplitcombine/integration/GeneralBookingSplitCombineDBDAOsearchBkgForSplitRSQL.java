/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : GeneralBookingSplitCombineDBDAOsearchBkgForSplitRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.12.15
*@LastModifier : 김진주
*@LastVersion : 1.0
* 2014.12.15 김진주
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsplitcombine.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Kim Jin Joo
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class GeneralBookingSplitCombineDBDAOsearchBkgForSplitRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * booking split 화면에서 split시 참고할 data를 조회한다.
	  * 2011.06.08 이일민 [CHM-201110982-01] e-SI & DPCS BKG Split & Combine 기능 구현 요청
	  * 2011.08.11 김용진 [CHM-201112840] BKG Split-특정조건시 Time out제약 예외처리
	  * </pre>
	  */
	public GeneralBookingSplitCombineDBDAOsearchBkgForSplitRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsplitcombine.integration").append("\n"); 
		query.append("FileName : GeneralBookingSplitCombineDBDAOsearchBkgForSplitRSQL").append("\n"); 
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
		query.append("SELECT BK.BKG_NO" ).append("\n"); 
		query.append("        , BK.BL_NO" ).append("\n"); 
		query.append("		, BK.BKG_CGO_TP_CD" ).append("\n"); 
		query.append("        , BK.VSL_CD||BK.SKD_VOY_NO||BK.SKD_DIR_CD TVVD" ).append("\n"); 
		query.append("		, (SELECT VVD.VSL_CD||VVD.SKD_VOY_NO||VVD.SKD_DIR_CD " ).append("\n"); 
		query.append("			 FROM BKG_VVD VVD" ).append("\n"); 
		query.append("  		    WHERE BK.BKG_NO          = VVD.BKG_NO" ).append("\n"); 
		query.append("   		      AND BK.POL_CD          = VVD.POL_CD" ).append("\n"); 
		query.append("   		      AND VVD.VSL_PRE_PST_CD IN ('S', 'T')) FIRST_VVD" ).append("\n"); 
		query.append("        , BK.POR_CD" ).append("\n"); 
		query.append("        , BK.POL_CD" ).append("\n"); 
		query.append("        , BK.POD_CD" ).append("\n"); 
		query.append("        , BK.DEL_CD" ).append("\n"); 
		query.append("        , DECODE(NVL(BK.STWG_CD,         'N'), 'N', 'N', 'Y') STWG_CD" ).append("\n"); 
		query.append("        , BK.HNGR_FLG" ).append("\n"); 
		query.append("        , DECODE(NVL(BK.STOP_OFF_LOC_CD, 'N'), 'N', 'N', 'Y') STOP_OFF_LOC_CD" ).append("\n"); 
		query.append("        , DECODE(NVL(BK.RAIL_BLK_CD,     'N'), 'N', 'N', 'Y') RAIL_BLK_CD" ).append("\n"); 
		query.append("        , BK.SPCL_HIDE_FLG " ).append("\n"); 
		query.append("        , BK.FD_GRD_FLG " ).append("\n"); 
		query.append("        , BK.PRCT_FLG " ).append("\n"); 
		query.append("        , DECODE(NVL(BK.XTER_RMK,        'N'), 'N', 'N', 'Y') REMARK" ).append("\n"); 
		query.append("        , BL.ACT_WGT" ).append("\n"); 
		query.append("        , BL.WGT_UT_CD" ).append("\n"); 
		query.append("        , TRUNC(BL.PCK_QTY) PCK_QTY" ).append("\n"); 
		query.append("        , BL.PCK_TP_CD" ).append("\n"); 
		query.append("        , BL.MEAS_QTY" ).append("\n"); 
		query.append("        , BL.MEAS_UT_CD" ).append("\n"); 
		query.append("        , NVL((SELECT 'Y' FROM BKG_DG_CGO  DG WHERE DG.BKG_NO = BK.BKG_NO AND ROWNUM = 1), 'N') DG" ).append("\n"); 
		query.append("        , NVL((SELECT 'Y' FROM BKG_RF_CGO  RF WHERE RF.BKG_NO = BK.BKG_NO AND ROWNUM = 1), 'N') RF" ).append("\n"); 
		query.append("        , NVL((SELECT 'Y' FROM BKG_AWK_CGO AK WHERE AK.BKG_NO = BK.BKG_NO AND ROWNUM = 1), 'N') AK" ).append("\n"); 
		query.append("        , NVL((SELECT 'Y' FROM BKG_BB_CGO  BB WHERE BB.BKG_NO = BK.BKG_NO AND ROWNUM = 1), 'N') BB" ).append("\n"); 
		query.append("        , BK.PCTL_NO" ).append("\n"); 
		query.append("        , BL.BDR_FLG" ).append("\n"); 
		query.append("        , NVL((SELECT 'Y' FROM BKG_TRO     WHERE CFM_FLG = 'Y' AND BKG_NO = BK.BKG_NO AND ROWNUM = 1" ).append("\n"); 
		query.append("                UNION" ).append("\n"); 
		query.append("               SELECT 'Y' FROM BKG_EUR_TRO WHERE CFM_FLG = 'Y' AND BKG_NO = BK.BKG_NO AND ROWNUM = 1), 'N') TRO_FLG" ).append("\n"); 
		query.append("        , BK.ADV_SHTG_CD" ).append("\n"); 
		query.append("		, BK.SPLIT_FLG" ).append("\n"); 
		query.append("        , BK.BKG_STS_CD" ).append("\n"); 
		query.append("		, (SELECT DECODE(CONTI_CD, 'E', 'EUR', 'GEN')" ).append("\n"); 
		query.append("             FROM MDM_LOCATION " ).append("\n"); 
		query.append("            WHERE LOC_CD = BK.POL_CD) TRO_TP		" ).append("\n"); 
		query.append("        , NVL((SELECT 'Y'" ).append("\n"); 
		query.append("    		     FROM BKG_VVD VVD" ).append("\n"); 
		query.append("    		         ,BKG_COFF_TM COFF" ).append("\n"); 
		query.append("    		    WHERE BK.BKG_NO          = VVD.BKG_NO" ).append("\n"); 
		query.append("    		      AND BK.POL_CD          = VVD.POL_CD" ).append("\n"); 
		query.append("    		      AND VVD.VSL_PRE_PST_CD IN ('S', 'T')" ).append("\n"); 
		query.append("    		      AND COFF.VSL_CD        = VVD.VSL_CD" ).append("\n"); 
		query.append("    		      AND COFF.SKD_VOY_NO    = VVD.SKD_VOY_NO" ).append("\n"); 
		query.append("    		      AND COFF.SKD_DIR_CD    = VVD.SKD_DIR_CD" ).append("\n"); 
		query.append("    		      AND COFF.POL_CD        = VVD.POL_CD" ).append("\n"); 
		query.append("    		      AND COFF.CLPT_IND_SEQ  = VVD.POL_CLPT_IND_SEQ" ).append("\n"); 
		query.append("    		      AND COFF.BKG_CLZ_STS_CD = 'C'" ).append("\n"); 
		query.append("    		      AND ROWNUM =1), 'N') BKG_CLOSE" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("		, NVL(ISS.OBL_ISS_FLG, 'N') OBL_ISS_FLG" ).append("\n"); 
		query.append("        , CASE WHEN SYSDATE>BKG_REV_APLY_DT_PKG.BKG_GET_ETD_DT_FNC(BK.BKG_NO,'N')" ).append("\n"); 
		query.append("                AND BK.POL_CD IN ('USLGB','USOAK','USSEA')" ).append("\n"); 
		query.append("               THEN 'Y' ELSE 'N' END AS EDI_HLD_FLG" ).append("\n"); 
		query.append("		, (NVL(CASE WHEN SC_NO IN ('GLO902011', 'AEN200201', 'GLO020110', 'AEN20823', 'AEN130000', 'AEN111248')" ).append("\n"); 
		query.append("                     AND 'A' = (SELECT LOC.CONTI_CD FROM MDM_LOCATION LOC WHERE LOC.LOC_CD = BK.POR_CD)" ).append("\n"); 
		query.append("                     AND 'M' = (SELECT LOC.CONTI_CD FROM MDM_LOCATION LOC WHERE LOC.LOC_CD = BK.DEL_CD) " ).append("\n"); 
		query.append("                    THEN 'Y'" ).append("\n"); 
		query.append("                    WHEN RFA_NO IN ('SFO12A0001', 'SFO12A0018')" ).append("\n"); 
		query.append("                     AND 'A' = (SELECT LOC.CONTI_CD FROM MDM_LOCATION LOC WHERE LOC.LOC_CD = BK.POR_CD)" ).append("\n"); 
		query.append("                     AND 'E' = (SELECT LOC.CONTI_CD FROM MDM_LOCATION LOC WHERE LOC.LOC_CD = BK.DEL_CD)" ).append("\n"); 
		query.append("                    THEN 'Y'" ).append("\n"); 
		query.append("                    ELSE 'N'" ).append("\n"); 
		query.append("               END" ).append("\n"); 
		query.append("           , 'N')) AS LT_FLG" ).append("\n"); 
		query.append("        , BK.SPCL_HIDE_FLG " ).append("\n"); 
		query.append("        , DECODE(NVL(BK.FUMG_LOC_CD, 'N'), 'N', 'N', 'Y') FUMG_LOC_CD" ).append("\n"); 
		query.append("        , CRR_SOC_FLG" ).append("\n"); 
		query.append("        , VEH_CMDT_FLG" ).append("\n"); 
		query.append("  FROM BKG_BOOKING BK, BKG_BL_DOC BL, BKG_BL_ISS ISS" ).append("\n"); 
		query.append(" WHERE BK.BKG_NO = BL.BKG_NO" ).append("\n"); 
		query.append("   AND BK.BKG_NO = ISS.BKG_NO(+)" ).append("\n"); 
		query.append("   AND BK.BKG_NO = @[bkg_no]" ).append("\n"); 

	}
}