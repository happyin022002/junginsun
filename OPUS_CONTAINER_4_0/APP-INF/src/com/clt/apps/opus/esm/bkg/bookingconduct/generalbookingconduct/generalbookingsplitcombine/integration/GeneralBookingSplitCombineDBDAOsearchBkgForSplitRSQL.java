/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : GeneralBookingSplitCombineDBDAOsearchBkgForSplitRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.12.11
*@LastModifier : 정인선
*@LastVersion : 1.0
* 2015.12.11 정인선
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsplitcombine.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author jung in sun
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
		query.append("Path : com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsplitcombine.integration").append("\n"); 
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
		query.append("        , DECODE(NVL(ST.STWG_CD,         'N'), 'N', 'N', 'Y') STWG_CD" ).append("\n"); 
		query.append("        , BK.HNGR_FLG" ).append("\n"); 
		query.append("        , DECODE(NVL(BK.STOP_OFF_LOC_CD, 'N'), 'N', 'N', 'Y') STOP_OFF_LOC_CD" ).append("\n"); 
		query.append("        , DECODE(NVL(BK.RAIL_BLK_CD,     'N'), 'N', 'N', 'Y') RAIL_BLK_CD" ).append("\n"); 
		query.append("        , BK.HOT_DE_FLG " ).append("\n"); 
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
		query.append("            WHERE LOC_CD = BK.POL_CD) TRO_TP		, NVL((SELECT 'Y'" ).append("\n"); 
		query.append("    		     FROM BKG_VVD VVD, BKG_COFF_TM COFF" ).append("\n"); 
		query.append("    		    WHERE BK.BKG_NO          = VVD.BKG_NO" ).append("\n"); 
		query.append("    		      AND BK.POL_CD          = VVD.POL_CD" ).append("\n"); 
		query.append("    		      AND VVD.VSL_PRE_PST_CD IN ('S', 'T')" ).append("\n"); 
		query.append("    		      AND COFF.VSL_CD        = VVD.VSL_CD" ).append("\n"); 
		query.append("    		      AND COFF.SKD_VOY_NO    = VVD.SKD_VOY_NO" ).append("\n"); 
		query.append("    		      AND COFF.SKD_DIR_CD    = VVD.SKD_DIR_CD" ).append("\n"); 
		query.append("    		      AND COFF.POL_CD        = VVD.POL_CD" ).append("\n"); 
		query.append("    		      AND COFF.CLPT_IND_SEQ  = VVD.POL_CLPT_IND_SEQ" ).append("\n"); 
		query.append("				  AND ROWNUM = 1), 'N') BKG_CLOSE" ).append("\n"); 
		query.append("		, NVL(ISS.OBL_ISS_FLG, 'N') OBL_ISS_FLG" ).append("\n"); 
		query.append("		, BK.BKG_WT_CHK_FLG" ).append("\n"); 
		query.append("		, BK.EDI_HLD_FLG" ).append("\n"); 
		query.append("  FROM BKG_BOOKING BK, BKG_BL_DOC BL, BKG_BL_ISS ISS, BKG_STWG_CGO ST" ).append("\n"); 
		query.append(" WHERE BK.BKG_NO = BL.BKG_NO" ).append("\n"); 
		query.append("   AND BK.BKG_NO = ISS.BKG_NO(+)" ).append("\n"); 
		query.append("   AND BK.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("   AND BK.BKG_NO = ST.BKG_NO(+)" ).append("\n"); 
		query.append("   AND 1         = ST.STWG_SEQ(+)" ).append("\n"); 

	}
}