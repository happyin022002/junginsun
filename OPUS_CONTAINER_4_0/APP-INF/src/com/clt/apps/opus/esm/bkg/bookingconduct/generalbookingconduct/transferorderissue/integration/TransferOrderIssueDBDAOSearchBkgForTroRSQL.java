/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : TransferOrderIssueDBDAOSearchBkgForTroRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.12.27
*@LastModifier : 
*@LastVersion : 1.0
* 2016.12.27 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.transferorderissue.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TransferOrderIssueDBDAOSearchBkgForTroRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * esm_bkg_0907_02a
	  * </pre>
	  */
	public TransferOrderIssueDBDAOSearchBkgForTroRSQL(){
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
		params.put("io_bnd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.transferorderissue.integration").append("\n"); 
		query.append("FileName : TransferOrderIssueDBDAOSearchBkgForTroRSQL").append("\n"); 
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
		query.append("SELECT BK.BKG_NO " ).append("\n"); 
		query.append("	, BK.BKG_CGO_TP_CD " ).append("\n"); 
		query.append("	, DECODE(@[io_bnd_cd], 'O', BK.RCV_TERM_CD, BK.DE_TERM_CD) TERM " ).append("\n"); 
		query.append("	, CUST.CUST_CNT_CD " ).append("\n"); 
		query.append("	, BK.BL_NO||BK.BL_TP_CD BL_NO " ).append("\n"); 
		query.append("	, BK.BKG_STS_CD " ).append("\n"); 
		query.append("	, (SELECT ORG.CONTI_CD FROM MDM_LOCATION ORG WHERE BK.POR_CD = ORG.LOC_CD) CONTI_CD" ).append("\n"); 
		query.append("	, BK.CMDT_CD " ).append("\n"); 
		query.append("    , (SELECT CMD.CMDT_NM FROM MDM_COMMODITY CMD WHERE BK.CMDT_CD = CMD.CMDT_CD) CMDT_NM" ).append("\n"); 
		query.append("    , BK.REP_CMDT_CD BKG_REP_CMDT_CD " ).append("\n"); 
		query.append("    , (SELECT REP.REP_CMDT_NM FROM MDM_REP_CMDT REP WHERE BK.REP_CMDT_CD = REP.REP_CMDT_CD) BKG_REP_CMDT_NM" ).append("\n"); 
		query.append("	, BK.VSL_CD " ).append("\n"); 
		query.append("	, BK.SKD_VOY_NO " ).append("\n"); 
		query.append("	, BK.SKD_DIR_CD " ).append("\n"); 
		query.append("	, BK.POR_CD " ).append("\n"); 
		query.append("    , SUBSTR(BK.POR_NOD_CD, 6, 2) POR_NOD_CD " ).append("\n"); 
		query.append("	, BK.POL_CD " ).append("\n"); 
		query.append("	, BK.POD_CD " ).append("\n"); 
		query.append("	, BK.DEL_CD " ).append("\n"); 
		query.append("	--조용인 수석님 수정 부분" ).append("\n"); 
		query.append("    --------------------------------------------------------" ).append("\n"); 
		query.append("    , DECODE(@[io_bnd_cd], 'O', NVL(COP_DTL_OBD.PICK_UP_CY, BK.FULL_RTN_YD_CD), NVL(COP_DTL_IBD.MTY_YD,     BK.MTY_RTN_YD_CD)) RETURN_CY " ).append("\n"); 
		query.append("    , DECODE(@[io_bnd_cd], 'O', NVL(COP_DTL_OBD.MTY_YD,     BK.MTY_PKUP_YD_CD), NVL(COP_DTL_IBD.PICK_UP_CY, BK.FULL_PKUP_YD_CD)) PICKUP_CY" ).append("\n"); 
		query.append("    --------------------------------------------------------" ).append("\n"); 
		query.append("    , TO_CHAR(DECODE(@[io_bnd_cd], 'O', BK.MTY_DOR_ARR_DT, IB_DOR_DT.DOR_ARR_DT), 'YYYY-MM-DD') DOR_ARR_DT " ).append("\n"); 
		query.append("    , TO_CHAR(DECODE(@[io_bnd_cd], 'O', BK.MTY_DOR_ARR_DT, IB_DOR_DT.DOR_ARR_DT), 'HH24:MI')    DOR_ARR_DT_HHMI " ).append("\n"); 
		query.append("    , DECODE(@[io_bnd_cd], 'O', TO_CHAR(OB_RTN_DT.RTN_DT, 'YYYY-MM-DD'), '')   RTN_DT " ).append("\n"); 
		query.append("    , DECODE(@[io_bnd_cd], 'O', TO_CHAR(OB_RTN_DT.RTN_DT, 'HH24:MI'),    '')   RTN_DT_HHMI " ).append("\n"); 
		query.append("    , DECODE(@[io_bnd_cd], 'O', '', TO_CHAR(IB_PKUP_DT.PKUP_DT, 'YYYY-MM-DD')) PKUP_DT " ).append("\n"); 
		query.append("    , DECODE(@[io_bnd_cd], 'O', '', TO_CHAR(IB_PKUP_DT.PKUP_DT,    'HH24:MI')) PKUP_DT_HHMI " ).append("\n"); 
		query.append("	, BK.DCGO_FLG " ).append("\n"); 
		query.append("    , NVL((SELECT HCDG_FLG " ).append("\n"); 
		query.append("             FROM BKG_DG_CGO DG" ).append("\n"); 
		query.append("            WHERE DG.BKG_NO = BK.BKG_NO" ).append("\n"); 
		query.append("              AND HCDG_FLG = 'Y'" ).append("\n"); 
		query.append("              AND ROWNUM = 1), 'N') HCDG" ).append("\n"); 
		query.append("	, BK.RC_FLG " ).append("\n"); 
		query.append("	, BK.AWK_CGO_FLG " ).append("\n"); 
		query.append("	, BK.BB_CGO_FLG" ).append("\n"); 
		query.append("	, BK.RD_CGO_FLG " ).append("\n"); 
		query.append("    , BK.FD_GRD_FLG" ).append("\n"); 
		query.append("	, BK.SPCL_HIDE_FLG" ).append("\n"); 
		query.append("	, CUST.CUST_SEQ " ).append("\n"); 
		query.append("	, CUST.CUST_NM " ).append("\n"); 
		query.append("    , ( SELECT TO_CHAR(MAX(SKD.VPS_ETB_DT), 'YYYYMMDDHH24MI')" ).append("\n"); 
		query.append("          FROM BKG_VVD VVD, " ).append("\n"); 
		query.append("               VSK_VSL_PORT_SKD SKD" ).append("\n"); 
		query.append("         WHERE VVD.BKG_NO = BK.BKG_NO " ).append("\n"); 
		query.append("           AND VVD.POL_CD = BK.POL_CD " ).append("\n"); 
		query.append("           AND VVD.VSL_PRE_PST_CD in ('S', 'T')" ).append("\n"); 
		query.append("           AND VVD.VSL_CD       = SKD.VSL_CD" ).append("\n"); 
		query.append("           AND VVD.SKD_VOY_NO   = SKD.SKD_VOY_NO" ).append("\n"); 
		query.append("           AND VVD.SKD_DIR_CD   = SKD.SKD_DIR_CD" ).append("\n"); 
		query.append("           AND VVD.POL_CD       = SKD.VPS_PORT_CD" ).append("\n"); 
		query.append("		   AND NVL(VVD.POL_CLPT_IND_SEQ, 1) = SKD.CLPT_IND_SEQ" ).append("\n"); 
		query.append("      ) ETB_DT " ).append("\n"); 
		query.append("    , BL.ACT_WGT" ).append("\n"); 
		query.append("    , BL.WGT_UT_CD" ).append("\n"); 
		query.append("	, (SELECT REP_ZN_CD FROM MDM_LOCATION WHERE LOC_CD = BK.POR_CD ) REP_ZN_CD" ).append("\n"); 
		query.append("	, BK.FLEX_HGT_FLG" ).append("\n"); 
		query.append("FROM BKG_BOOKING BK " ).append("\n"); 
		query.append("	, BKG_CUSTOMER CUST " ).append("\n"); 
		query.append("    , BKG_BL_DOC BL" ).append("\n"); 
		query.append("    --, (SELECT nvl(MNL_SET_DT, SYS_SET_DT) RTN_DT" ).append("\n"); 
		query.append("    , (SELECT BK.BKG_NO, NVL(MAX(MNL_SET_DT), MAX(SYS_SET_DT)) RTN_DT" ).append("\n"); 
		query.append("         FROM BKG_CLZ_TM CLZ, BKG_BOOKING BK " ).append("\n"); 
		query.append("        WHERE BK.BKG_NO     = CLZ.BKG_NO" ).append("\n"); 
		query.append("#if (${bkg_no} != '') " ).append("\n"); 
		query.append("  		  AND BK.BKG_NO = @[bkg_no] " ).append("\n"); 
		query.append("#else " ).append("\n"); 
		query.append(" 		  AND BK.BL_NO = SUBSTR(@[bl_no], 0, 12)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("          AND CLZ.CLZ_TP_CD = 'R'" ).append("\n"); 
		query.append("		GROUP BY BK.BKG_NO) OB_RTN_DT" ).append("\n"); 
		query.append("    , (SELECT BK.BKG_NO, MAX(ARR_ST_DT) PKUP_DT" ).append("\n"); 
		query.append("         FROM PRD_PROD_CTL_ROUT_DTL DTL, BKG_BOOKING BK" ).append("\n"); 
		query.append("        WHERE BK.PCTL_NO         = DTL.PCTL_NO" ).append("\n"); 
		query.append("#if (${bkg_no} != '') " ).append("\n"); 
		query.append("  		  AND BK.BKG_NO = @[bkg_no] " ).append("\n"); 
		query.append("#else " ).append("\n"); 
		query.append("  		  AND BK.BL_NO = SUBSTR(@[bl_no], 0, 12)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("          AND DTL.PCTL_IO_BND_CD = 'I'	" ).append("\n"); 
		query.append("          AND DTL.NOD_LNK_DIV_CD = 'N' 	" ).append("\n"); 
		query.append("          AND DTL.MTY_YD_FLG     = 'N'" ).append("\n"); 
		query.append("		GROUP BY BK.BKG_NO) IB_PKUP_DT" ).append("\n"); 
		query.append("    , (SELECT BK.BKG_NO, MIN(ESTM_DT) DOR_ARR_DT" ).append("\n"); 
		query.append("         FROM SCE_COP_HDR HDR, SCE_COP_DTL DTL, BKG_BOOKING BK" ).append("\n"); 
		query.append("        WHERE HDR.COP_NO = DTL.COP_NO" ).append("\n"); 
		query.append("		  AND HDR.BKG_NO = BK.BKG_NO" ).append("\n"); 
		query.append("#if (${bkg_no} != '') " ).append("\n"); 
		query.append("  		  AND BK.BKG_NO = @[bkg_no] " ).append("\n"); 
		query.append("#else " ).append("\n"); 
		query.append("  		  AND BK.BL_NO = SUBSTR(@[bl_no], 0, 12)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("          AND (DTL.ACT_CD LIKE 'FI__A_' OR DTL.ACT_CD LIKE 'FU__U_')" ).append("\n"); 
		query.append("		GROUP BY BK.BKG_NO) IB_DOR_DT" ).append("\n"); 
		query.append("		--조용인 수석님 수정 부분" ).append("\n"); 
		query.append("        --------------------------------------------------------" ).append("\n"); 
		query.append("           ,(SELECT BKG.BKG_NO, PRD.FULL_RTN_YD_CD PICK_UP_CY ,PRD.MTY_PKUP_YD_CD MTY_YD, ESTM_DT PICK_UP_DT" ).append("\n"); 
		query.append("               FROM BKG_BOOKING BKG, SCE_COP_HDR HDR, SCE_COP_DTL DTL, PRD_PROD_CTL_MST PRD" ).append("\n"); 
		query.append("              WHERE BKG.BKG_NO = HDR.BKG_NO" ).append("\n"); 
		query.append("#if (${bkg_no} != '') " ).append("\n"); 
		query.append("  		  AND BKG.BKG_NO = @[bkg_no] " ).append("\n"); 
		query.append("#else " ).append("\n"); 
		query.append("  		  AND BKG.BL_NO = SUBSTR(@[bl_no], 0, 12)" ).append("\n"); 
		query.append("#end			" ).append("\n"); 
		query.append("                AND HDR.COP_STS_CD IN ('C', 'T', 'F')" ).append("\n"); 
		query.append("                AND HDR.COP_NO = DTL.COP_NO " ).append("\n"); 
		query.append("                AND DTL.ACT_CD IN ('FLWMLO','FLVMLO')        " ).append("\n"); 
		query.append("        		AND NVL(HDR.OB_TRO_FLG,'N') = 'N'" ).append("\n"); 
		query.append("        		AND PRD.PCTL_NO = HDR.PCTL_NO" ).append("\n"); 
		query.append("                AND ROWNUM = 1) COP_DTL_OBD" ).append("\n"); 
		query.append("           ,(SELECT BKG.BKG_NO, PRD.FULL_PKUP_YD_CD PICK_UP_CY ,PRD.MTY_RTN_YD_CD MTY_YD, ESTM_DT PICK_UP_DT" ).append("\n"); 
		query.append("               FROM BKG_BOOKING BKG, SCE_COP_HDR HDR, SCE_COP_DTL DTL, PRD_PROD_CTL_MST PRD" ).append("\n"); 
		query.append("              WHERE BKG.BKG_NO = HDR.BKG_NO" ).append("\n"); 
		query.append("#if (${bkg_no} != '') " ).append("\n"); 
		query.append("  		  AND BKG.BKG_NO = @[bkg_no] " ).append("\n"); 
		query.append("#else " ).append("\n"); 
		query.append("  		  AND BKG.BL_NO = SUBSTR(@[bl_no], 0, 12)" ).append("\n"); 
		query.append("#end			" ).append("\n"); 
		query.append("                AND HDR.COP_STS_CD IN ('C', 'T', 'F')" ).append("\n"); 
		query.append("                AND HDR.COP_NO = DTL.COP_NO " ).append("\n"); 
		query.append("                AND DTL.ACT_CD IN ('FUWMUD','FUVMUD')" ).append("\n"); 
		query.append("        		AND NVL(HDR.IB_TRO_FLG,'N') = 'N'" ).append("\n"); 
		query.append("        		AND PRD.PCTL_NO = HDR.PCTL_NO" ).append("\n"); 
		query.append("                AND ROWNUM = 1) COP_DTL_IBD" ).append("\n"); 
		query.append("      --------------------------------------------------------" ).append("\n"); 
		query.append("WHERE BK.BKG_NO = CUST.BKG_NO " ).append("\n"); 
		query.append("  AND BK.BKG_NO = BL.BKG_NO" ).append("\n"); 
		query.append("  AND CUST.BKG_CUST_TP_CD = DECODE(@[io_bnd_cd], 'O',  'S', DECODE(BK.CUST_TO_ORD_FLG, 'Y', 'N', 'C')) " ).append("\n"); 
		query.append("  AND BK.BKG_NO = OB_RTN_DT.BKG_NO(+)" ).append("\n"); 
		query.append("  AND BK.BKG_NO = IB_PKUP_DT.BKG_NO(+)" ).append("\n"); 
		query.append("  AND BK.BKG_NO = IB_DOR_DT.BKG_NO(+)" ).append("\n"); 
		query.append("  AND BK.BKG_NO = COP_DTL_OBD.BKG_NO(+)" ).append("\n"); 
		query.append("  AND BK.BKG_NO = COP_DTL_IBD.BKG_NO(+)" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${bkg_no} != '') " ).append("\n"); 
		query.append("  AND BK.BKG_NO = @[bkg_no] " ).append("\n"); 
		query.append("#else " ).append("\n"); 
		query.append("  AND BK.BL_NO = SUBSTR(@[bl_no], 0, 12)" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}