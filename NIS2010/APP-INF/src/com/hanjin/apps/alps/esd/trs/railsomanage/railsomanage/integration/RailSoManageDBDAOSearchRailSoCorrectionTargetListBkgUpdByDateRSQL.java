/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : RailSoManageDBDAOSearchRailSoCorrectionTargetListBkgUpdByDateRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.12.29
*@LastModifier : 
*@LastVersion : 1.0
* 2010.12.29 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.trs.railsomanage.railsomanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class RailSoManageDBDAOSearchRailSoCorrectionTargetListBkgUpdByDateRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SO 발행 된 건들 중 BKG UPDAT(DATE 조회)E에 대한 조회 SQL
	  * </pre>
	  */
	public RailSoManageDBDAOSearchRailSoCorrectionTargetListBkgUpdByDateRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("stoLocationCd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sctrlOfcCd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sselStatus",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("selRailRoad",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("splanToDate",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("comboSvcProvider",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("splanFromDate",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sselBnd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sfromLocationCd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sselEdikind",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sselThrough",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.trs.railsomanage.railsomanage.integration").append("\n"); 
		query.append("FileName : RailSoManageDBDAOSearchRailSoCorrectionTargetListBkgUpdByDateRSQL").append("\n"); 
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
		query.append("SELECT" ).append("\n"); 
		query.append("TMP.TRSP_SO_OFC_CTY_CD," ).append("\n"); 
		query.append("TMP.TRSP_SO_SEQ," ).append("\n"); 
		query.append("TMP.BIL_ISS_KNT," ).append("\n"); 
		query.append("MAX(TMP.BIL_ISS_STS_CD) BIL_ISS_STS_CD," ).append("\n"); 
		query.append("MAX(" ).append("\n"); 
		query.append("CASE WHEN (TMP.TRSP_SO_STS_CD = 'I' AND TMP.BKG_NO_RVIS_FLG IS NOT NULL AND NVL(TMP.TRSP_BND_CD, 'O') = 'O'" ).append("\n"); 
		query.append("AND DECODE(TMP.CGO_TP_CD, 'F', TMP.POL_NOD_CD, 'M', TMP.TO_NOD_CD||TMP.TO_NOD_YARD) = 'USLGBPT')" ).append("\n"); 
		query.append("OR (TMP.TRSP_SO_STS_CD = 'I' AND TMP.BKG_NO_RVIS_FLG IS NOT NULL AND NVL(TMP.TRSP_BND_CD, 'O') = 'O'" ).append("\n"); 
		query.append("AND DECODE(TMP.CGO_TP_CD, 'F', TMP.POL_NOD_CD, 'M', TMP.TO_NOD_CD||TMP.TO_NOD_YARD) = 'USLAXYM')" ).append("\n"); 
		query.append("OR (TMP.TRSP_SO_STS_CD = 'I' AND NVL(TMP.TRSP_BND_CD, 'O') = 'I' AND TMP.CGO_TP_CD = 'F' AND TMP.FM_NOD_CD||TMP.FM_NOD_YARD = 'USLGBPT')" ).append("\n"); 
		query.append("OR (TMP.TRSP_SO_STS_CD = 'I' AND NVL(TMP.TRSP_BND_CD, 'O') = 'I' AND TMP.CGO_TP_CD = 'F' AND TMP.FM_NOD_CD||TMP.FM_NOD_YARD = 'USLAXYM')" ).append("\n"); 
		query.append("OR (TMP.TRSP_SO_STS_CD = 'I' AND NVL(TMP.TRSP_BND_CD, 'O') = 'O' AND TMP.CGO_TP_CD = 'F' AND TMP.TO_NOD_CD||TMP.TO_NOD_YARD = 'USLGBPT')" ).append("\n"); 
		query.append("OR (TMP.TRSP_SO_STS_CD = 'I' AND NVL(TMP.TRSP_BND_CD, 'O') = 'O' AND TMP.CGO_TP_CD = 'F' AND TMP.TO_NOD_CD||TMP.TO_NOD_YARD = 'USLAXYM')THEN" ).append("\n"); 
		query.append("CASE WHEN SUBSTR(TMP.WO, INSTR(TMP.WO, '$', 1, 1) + 1, INSTR(TMP.WO, '$', 1, 2) - INSTR(TMP.WO, '$', 1, 1) - 1) = 'A' THEN DECODE(TMP.BKG_NO, SUBSTR(TMP.WO, INSTR(TMP.WO, '$', 1, 2) + 1), 'Y', 'N')" ).append("\n"); 
		query.append("WHEN SUBSTR(TMP.WO, INSTR(TMP.WO, '$', 1, 1) + 1, INSTR(TMP.WO, '$', 1, 2) - INSTR(TMP.WO, '$', 1, 1) - 1) = 'N' THEN 'N'" ).append("\n"); 
		query.append("WHEN SUBSTR(TMP.WO, INSTR(TMP.WO, '$', 1, 1) + 1, INSTR(TMP.WO, '$', 1, 2) - INSTR(TMP.WO, '$', 1, 1) - 1) IS NULL AND SUBSTR(TMP.WO, 1, INSTR(TMP.WO, '$', 1, 1) - 1) IS NOT NULL THEN DECODE(TMP.BKG_NO, SUBSTR(TMP.WO, INSTR(TMP.WO, '$', 1, 2) + 1), 'Y', 'N')" ).append("\n"); 
		query.append("WHEN SUBSTR(TMP.WO, INSTR(TMP.WO, '$', 1, 1) + 1, INSTR(TMP.WO, '$', 1, 2) - INSTR(TMP.WO, '$', 1, 1) - 1) IS NULL AND SUBSTR(TMP.WO, 1, INSTR(TMP.WO, '$', 1, 1) - 1) IS NULL THEN 'N'" ).append("\n"); 
		query.append("ELSE ''" ).append("\n"); 
		query.append("END" ).append("\n"); 
		query.append("WHEN ((TMP.TRSP_SO_STS_CD = 'C' OR TMP.TRSP_SO_STS_CD = 'R') AND NVL(TMP.TRSP_BND_CD, 'O') = 'I'" ).append("\n"); 
		query.append("AND TMP.CGO_TP_CD = 'F' AND TMP.FM_NOD_CD||TMP.FM_NOD_YARD = 'USLGBPT')" ).append("\n"); 
		query.append("OR ((TMP.TRSP_SO_STS_CD = 'C' OR TMP.TRSP_SO_STS_CD = 'R') AND NVL(TMP.TRSP_BND_CD, 'O') = 'I'" ).append("\n"); 
		query.append("AND TMP.CGO_TP_CD = 'F' AND TMP.FM_NOD_CD||TMP.FM_NOD_YARD = 'USLAXYM')" ).append("\n"); 
		query.append("OR ((TMP.TRSP_SO_STS_CD = 'C' OR TMP.TRSP_SO_STS_CD = 'R') AND NVL(TMP.TRSP_BND_CD, 'O') = 'O'" ).append("\n"); 
		query.append("AND TMP.CGO_TP_CD = 'F' AND TMP.TO_NOD_CD||TMP.TO_NOD_YARD = 'USLGBPT')" ).append("\n"); 
		query.append("OR ((TMP.TRSP_SO_STS_CD = 'C' OR TMP.TRSP_SO_STS_CD = 'R') AND NVL(TMP.TRSP_BND_CD, 'O') = 'O'" ).append("\n"); 
		query.append("AND TMP.CGO_TP_CD = 'F' AND TMP.TO_NOD_CD||TMP.TO_NOD_YARD = 'USLAXYM') THEN" ).append("\n"); 
		query.append("CASE WHEN SUBSTR(TMP.REWO, INSTR(TMP.REWO, '$', 1, 1) + 1) = 'N' THEN 'N'" ).append("\n"); 
		query.append("WHEN SUBSTR(TMP.REWO, INSTR(TMP.REWO, '$', 1, 1) + 1) IS NULL AND SUBSTR(TMP.REWO, 1, INSTR(TMP.REWO, '$', 1, 1) - 1) IS NOT NULL THEN 'Y'" ).append("\n"); 
		query.append("WHEN SUBSTR(TMP.REWO, INSTR(TMP.REWO, '$', 1, 1) + 1) IS NULL AND SUBSTR(TMP.REWO, 1, INSTR(TMP.REWO, '$', 1, 1) - 1) IS NULL THEN 'N'" ).append("\n"); 
		query.append("ELSE ''" ).append("\n"); 
		query.append("END" ).append("\n"); 
		query.append("ELSE ''" ).append("\n"); 
		query.append("END" ).append("\n"); 
		query.append(") EDI_RESENT," ).append("\n"); 
		query.append("MAX(" ).append("\n"); 
		query.append("CASE WHEN (TMP.TRSP_SO_STS_CD = 'I' AND TMP.BKG_NO_RVIS_FLG IS NOT NULL AND NVL(TMP.TRSP_BND_CD, 'O') = 'O'" ).append("\n"); 
		query.append("AND DECODE(TMP.CGO_TP_CD, 'F', TMP.POL_NOD_CD, 'M', TMP.TO_NOD_CD||TMP.TO_NOD_YARD) = 'USLGBPT')" ).append("\n"); 
		query.append("OR (TMP.TRSP_SO_STS_CD = 'I' AND TMP.BKG_NO_RVIS_FLG IS NOT NULL AND NVL(TMP.TRSP_BND_CD, 'O') = 'O'" ).append("\n"); 
		query.append("AND DECODE(TMP.CGO_TP_CD, 'F', TMP.POL_NOD_CD, 'M', TMP.TO_NOD_CD||TMP.TO_NOD_YARD) = 'USLAXYM')" ).append("\n"); 
		query.append("OR (TMP.TRSP_SO_STS_CD = 'I' AND NVL(TMP.TRSP_BND_CD, 'O') = 'I' AND TMP.CGO_TP_CD = 'F' AND TMP.FM_NOD_CD||TMP.FM_NOD_YARD = 'USLGBPT')" ).append("\n"); 
		query.append("OR (TMP.TRSP_SO_STS_CD = 'I' AND NVL(TMP.TRSP_BND_CD, 'O') = 'I' AND TMP.CGO_TP_CD = 'F' AND TMP.FM_NOD_CD||TMP.FM_NOD_YARD = 'USLAXYM')" ).append("\n"); 
		query.append("OR (TMP.TRSP_SO_STS_CD = 'I' AND NVL(TMP.TRSP_BND_CD, 'O') = 'O' AND TMP.CGO_TP_CD = 'F' AND TMP.TO_NOD_CD||TMP.TO_NOD_YARD = 'USLGBPT')" ).append("\n"); 
		query.append("OR (TMP.TRSP_SO_STS_CD = 'I' AND NVL(TMP.TRSP_BND_CD, 'O') = 'O' AND TMP.CGO_TP_CD = 'F' AND TMP.TO_NOD_CD||TMP.TO_NOD_YARD = 'USLAXYM')THEN" ).append("\n"); 
		query.append("CASE WHEN SUBSTR(TMP.WO, INSTR(TMP.WO, '$', 1, 1) + 1, INSTR(TMP.WO, '$', 1, 2) - INSTR(TMP.WO, '$', 1, 1) - 1) = 'A' THEN DECODE(TMP.BKG_NO, SUBSTR(TMP.WO, INSTR(TMP.WO, '$', 1, 2) + 1), 'N', 'Y')" ).append("\n"); 
		query.append("WHEN SUBSTR(TMP.WO, INSTR(TMP.WO, '$', 1, 1) + 1, INSTR(TMP.WO, '$', 1, 2) - INSTR(TMP.WO, '$', 1, 1) - 1) = 'N' THEN 'Y'" ).append("\n"); 
		query.append("WHEN SUBSTR(TMP.WO, INSTR(TMP.WO, '$', 1, 1) + 1, INSTR(TMP.WO, '$', 1, 2) - INSTR(TMP.WO, '$', 1, 1) - 1) IS NULL AND SUBSTR(TMP.WO, 1, INSTR(TMP.WO, '$', 1, 1) - 1) IS NOT NULL THEN DECODE(TMP.BKG_NO, SUBSTR(TMP.WO, INSTR(TMP.WO, '$', 1, 2) + 1), 'N', 'Y')" ).append("\n"); 
		query.append("WHEN SUBSTR(TMP.WO, INSTR(TMP.WO, '$', 1, 1) + 1, INSTR(TMP.WO, '$', 1, 2) - INSTR(TMP.WO, '$', 1, 1) - 1) IS NULL AND SUBSTR(TMP.WO, 1, INSTR(TMP.WO, '$', 1, 1) - 1) IS NULL THEN 'Y'" ).append("\n"); 
		query.append("ELSE 'X'" ).append("\n"); 
		query.append("END" ).append("\n"); 
		query.append("WHEN ((TMP.TRSP_SO_STS_CD = 'C' OR TMP.TRSP_SO_STS_CD = 'R') AND NVL(TMP.TRSP_BND_CD, 'O') = 'I'" ).append("\n"); 
		query.append("AND TMP.CGO_TP_CD = 'F' AND TMP.FM_NOD_CD||TMP.FM_NOD_YARD = 'USLGBPT')" ).append("\n"); 
		query.append("OR ((TMP.TRSP_SO_STS_CD = 'C' OR TMP.TRSP_SO_STS_CD = 'R') AND NVL(TMP.TRSP_BND_CD, 'O') = 'I'" ).append("\n"); 
		query.append("AND TMP.CGO_TP_CD = 'F' AND TMP.FM_NOD_CD||TMP.FM_NOD_YARD = 'USLAXYM')" ).append("\n"); 
		query.append("OR ((TMP.TRSP_SO_STS_CD = 'C' OR TMP.TRSP_SO_STS_CD = 'R') AND NVL(TMP.TRSP_BND_CD, 'O') = 'O'" ).append("\n"); 
		query.append("AND TMP.CGO_TP_CD = 'F' AND TMP.TO_NOD_CD||TMP.TO_NOD_YARD = 'USLGBPT')" ).append("\n"); 
		query.append("OR ((TMP.TRSP_SO_STS_CD = 'C' OR TMP.TRSP_SO_STS_CD = 'R') AND NVL(TMP.TRSP_BND_CD, 'O') = 'O'" ).append("\n"); 
		query.append("AND TMP.CGO_TP_CD = 'F' AND TMP.TO_NOD_CD||TMP.TO_NOD_YARD = 'USLAXYM') THEN" ).append("\n"); 
		query.append("CASE WHEN SUBSTR(TMP.REWO, INSTR(TMP.REWO, '$', 1, 1) + 1) = 'N' THEN 'Y'" ).append("\n"); 
		query.append("WHEN SUBSTR(TMP.REWO, INSTR(TMP.REWO, '$', 1, 1) + 1) IS NULL AND SUBSTR(TMP.REWO, 1, INSTR(TMP.REWO, '$', 1, 1) - 1) IS NOT NULL THEN 'N'" ).append("\n"); 
		query.append("WHEN SUBSTR(TMP.REWO, INSTR(TMP.REWO, '$', 1, 1) + 1) IS NULL AND SUBSTR(TMP.REWO, 1, INSTR(TMP.REWO, '$', 1, 1) - 1) IS NULL THEN 'Y'" ).append("\n"); 
		query.append("ELSE 'X'" ).append("\n"); 
		query.append("END" ).append("\n"); 
		query.append("ELSE 'X'" ).append("\n"); 
		query.append("END" ).append("\n"); 
		query.append(") EDI_RESEND_TARGET_FLAG," ).append("\n"); 
		query.append("MAX(TMP.BLK_FLG) BLK_FLG," ).append("\n"); 
		query.append("MAX(TMP.STEL_WIRE_FLG) STEL_WIRE_FLG," ).append("\n"); 
		query.append("MAX(TMP.COIL_SHP_FLG) COIL_SHP_FLG," ).append("\n"); 
		query.append("MAX(TMP.FUMG_FLG) FUMG_FLG," ).append("\n"); 
		query.append("MAX(TMP.COP_NO) COP_NO," ).append("\n"); 
		query.append("MAX(TMP.STATUS) STATUS," ).append("\n"); 
		query.append("MAX(TMP.COST_ACT_GRP_SEQ) COST_ACT_GRP_SEQ," ).append("\n"); 
		query.append("MAX(TMP.EQ_NO) EQ_NO," ).append("\n"); 
		query.append("MAX(TMP.EQ_TPSZ_CD) EQ_TPSZ_CD," ).append("\n"); 
		query.append("MAX(TMP.REPO_PLN_ID) REPO_PLN_ID," ).append("\n"); 
		query.append("MAX(TMP.PLN_YRWK) PLN_YRWK," ).append("\n"); 
		query.append("MAX(TMP.REF_SEQ) REF_SEQ," ).append("\n"); 
		query.append("MAX(TMP.REF_ID) REF_ID," ).append("\n"); 
		query.append("MAX(TMP.CGO_TP_CD) CGO_TP_CD," ).append("\n"); 
		query.append("MAX(TMP.TRSP_BND_CD) TRSP_BND_CD," ).append("\n"); 
		query.append("MAX(TMP.CXL_RQST_FLG) CXL_RQST_FLG," ).append("\n"); 
		query.append("MAX(TMP.THROUGH) THROUGH," ).append("\n"); 
		query.append("MAX(TMP.TRSP_RAIL_BIL_TP_CD) TRSP_RAIL_BIL_TP_CD," ).append("\n"); 
		query.append("MAX(TMP.IBD_IPI_LOCL_IND_CD) IBD_IPI_LOCL_IND_CD," ).append("\n"); 
		query.append("MAX(TMP.BL_NO) BL_NO," ).append("\n"); 
		query.append("MAX(TMP.BKG_BKG_STS_CD) BKG_STS_CD," ).append("\n"); 
		query.append("MAX(NVL(TMP.BKG_RCVDE_TERM_CD, DECODE(TMP.TRSP_BND_CD ," ).append("\n"); 
		query.append("'I', TMP.BKG_DE_TERM_CD, 'O', TMP.BKG_RCV_TERM_CD) )) BKG_RCVDE_TERM_CD," ).append("\n"); 
		query.append("MAX(DECODE(TMP.BIL_ISS_STS_CD , 'I', SUBSTR(TMP.WO, INSTR(TMP.WO, '$', 1, 2) + 1), TMP.BKG_NO)) BKG_NO," ).append("\n"); 
		query.append("MAX(TMP.REVISED_BKG_NO) REVISED_BKG_NO," ).append("\n"); 
		query.append("MAX(TMP.PODPOR_CD) PODPOR_CD," ).append("\n"); 
		query.append("MAX(TMP.PODPOR_YARD) PODPOR_YARD," ).append("\n"); 
		query.append("MAX(TMP.FM_NOD_CD) FM_NOD_CD," ).append("\n"); 
		query.append("MAX(TMP.FM_NOD_YARD) FM_NOD_YARD," ).append("\n"); 
		query.append("MAX(TMP.TO_NOD_CD) TO_NOD_CD," ).append("\n"); 
		query.append("MAX(TMP.TO_NOD_YARD) TO_NOD_YARD," ).append("\n"); 
		query.append("MAX(TMP.ORG_FM_NOD_CD) ORG_FM_NOD_CD," ).append("\n"); 
		query.append("MAX(TMP.ORG_FM_NOD_YARD) ORG_FM_NOD_YARD," ).append("\n"); 
		query.append("MAX(TMP.ORG_TO_NOD_CD) ORG_TO_NOD_CD," ).append("\n"); 
		query.append("MAX(TMP.ORG_TO_NOD_YARD) ORG_TO_NOD_YARD," ).append("\n"); 
		query.append("MAX(TMP.POLDEL_CD) POLDEL_CD," ).append("\n"); 
		query.append("MAX(TMP.POLDEL_YARD) POLDEL_YARD," ).append("\n"); 
		query.append("MAX(TMP.POL_CD) POL_CD," ).append("\n"); 
		query.append("MAX(TMP.IBD_CSTMS_CLR_LOC_CD) IBD_CSTMS_CLR_LOC_CD," ).append("\n"); 
		query.append("MAX(TMP.EDI) IBD_NO," ).append("\n"); 
		query.append("CASE WHEN MAX(NVL(TMP.TRUNKVVD, 'N/A')) = MAX(NVL(BKG_VVD, 'N/A')) THEN 'N'" ).append("\n"); 
		query.append("ELSE 'Y'" ).append("\n"); 
		query.append("END UNMATCH_VVD," ).append("\n"); 
		query.append("CASE WHEN MAX(NVL(TMP.POD_CD, 'N/A')) = MAX(NVL(TMP.BKG_POD_CD, 'N/A')) THEN 'N'" ).append("\n"); 
		query.append("ELSE 'Y'" ).append("\n"); 
		query.append("END UNMATCH_POD," ).append("\n"); 
		query.append("MAX(TMP.TRUNKVVD) TRUNKVVD," ).append("\n"); 
		query.append("MAX(TMP.BKG_VVD) TRUNKVVD_REVISED," ).append("\n"); 
		query.append("MAX(TMP.POD_CD) POD_CD," ).append("\n"); 
		query.append("MAX(TMP.BKG_POD_CD) POD_CD_REVISED," ).append("\n"); 
		query.append("MAX(MVMT_YARD) MVMT_YARD," ).append("\n"); 
		query.append("MAX(MVMT_STATUS) MVMT_STATUS," ).append("\n"); 
		query.append("MAX(TMP.BKG_SPE) BKG_SPE," ).append("\n"); 
		query.append("MAX(TMP.VNDR) VNDR_ABBR_NM," ).append("\n"); 
		query.append("MAX(TMP.REQUEST_SP) REQUEST_SP," ).append("\n"); 
		query.append("MAX(TMP.VNDR_SEQ) VNDR_SEQ," ).append("\n"); 
		query.append("'' COST_MONTH," ).append("\n"); 
		query.append("MAX(TMP.CRE_DT) CRE_DT," ).append("\n"); 
		query.append("MAX(TMP.CRE_DT_HMS) CRE_DT_HMS," ).append("\n"); 
		query.append("MAX(DECODE(TMP.TRSP_BND_CD, 'O', TMP.BKG_UPDATED_DT, '')) BKG_UPDATED_DT," ).append("\n"); 
		query.append("MAX(DECODE(TMP.TRSP_BND_CD, 'O', TMP.BKG_UPDATED_DT_HMS, '')) BKG_UPDATED_DT_HMS," ).append("\n"); 
		query.append("MAX(TMP.CXL_RQST_DT) CXL_RQST_DT," ).append("\n"); 
		query.append("MAX(TMP.CXL_RQST_DT_HMS) CXL_RQST_DT_HMS," ).append("\n"); 
		query.append("MAX(TMP.CXL_RQST_RSN) CXL_RQST_RSN," ).append("\n"); 
		query.append("MAX(TMP.CXL_RQST_RJCT_DT) CXL_RQST_RJCT_DT," ).append("\n"); 
		query.append("MAX(TMP.CXL_RQST_RJCT_DT_HMS) CXL_RQST_RJCT_DT_HMS," ).append("\n"); 
		query.append("MAX(TMP.RQST_RJCT_RSN) RQST_RJCT_RSN," ).append("\n"); 
		query.append("MAX(TMP.INTER_RMK) INTER_RMK," ).append("\n"); 
		query.append("MAX(TMP.SPCL_INSTR_RMK) SPCL_INSTR_RMK," ).append("\n"); 
		query.append("MAX(TMP.ROUT_ORG_NOD_CD) ROUT_ORG_NOD_CD," ).append("\n"); 
		query.append("MAX(TMP.ROUT_DEST_NOD_CD) ROUT_DEST_NOD_CD," ).append("\n"); 
		query.append("MAX(TMP.ROUT_SEQ) ROUT_SEQ," ).append("\n"); 
		query.append("MAX(TMP.MSG) ERR_DESC," ).append("\n"); 
		query.append("MAX(TMP.ROUT_PLN_CD) ROUT_PLN_CD," ).append("\n"); 
		query.append("MAX(TMP.INLND_ROUT_RMK) INLND_ROUT_RMK," ).append("\n"); 
		query.append("MAX(TMP.INV_BIL_PATT_DIV_FLG) INV_BIL_PATT_DIV_FLG," ).append("\n"); 
		query.append("MAX(TMP.RAIL_CMB_THRU_TP_CD) RAIL_CMB_THRU_TP_CD," ).append("\n"); 
		query.append("MAX(DECODE(TMP.SUB_RAIL_SEQ, 1 , AGMT.AGMT_REF_NO) || DECODE(TMP.VNDR_SET_TO_NOD_CD, NULL, '' , TMP.TO_NOD_CD||TMP.TO_NOD_YARD, '', ' / ')) ||" ).append("\n"); 
		query.append("MAX(DECODE(TMP.SUB_RAIL_SEQ, 2 , AGMT.AGMT_REF_NO) || DECODE(TMP.VNDR_SET_TO_NOD_CD, NULL, '' , TMP.TO_NOD_CD||TMP.TO_NOD_YARD, '', ' / ')) ||" ).append("\n"); 
		query.append("MAX(DECODE(TMP.SUB_RAIL_SEQ, 3 , AGMT.AGMT_REF_NO)) REF_NO," ).append("\n"); 
		query.append("MAX(TMP.MDM_CO) CMDT_NAME," ).append("\n"); 
		query.append("ROUND(MAX(TMP.CNTR_WGT)) CNTR_WGT," ).append("\n"); 
		query.append("MAX(TMP.ACT_GRP_CD) ACT_GRP_CD" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("X.*" ).append("\n"); 
		query.append(",(" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("NVL(C.BIL_EDI_RSND_DT, '') || '$' || NVL(C.BIL_EDI_RSND_RCV_RSLT_CD, '') || '$' ||" ).append("\n"); 
		query.append("NVL(C.BKG_NO, '')" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("TRS_TRSP_EDI_RAIL_ORD C" ).append("\n"); 
		query.append("WHERE X.TRSP_SO_OFC_CTY_CD = C.TRSP_SO_OFC_CTY_CD" ).append("\n"); 
		query.append("AND   X.TRSP_SO_SEQ = C.TRSP_SO_SEQ" ).append("\n"); 
		query.append("AND   X.BIL_ISS_KNT = C.BIL_ISS_KNT" ).append("\n"); 
		query.append(") WO" ).append("\n"); 
		query.append(",(" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("NVL(C1.BIL_EDI_RSND_DT, '') || '$' || NVL(C1.BIL_EDI_RSND_RCV_RSLT_CD, '')" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("TRS_TRSP_EDI_RAIL_ORD_RSND C1" ).append("\n"); 
		query.append("WHERE X.TRSP_SO_OFC_CTY_CD = C1.TRSP_SO_OFC_CTY_CD" ).append("\n"); 
		query.append("AND   X.TRSP_SO_SEQ = C1.TRSP_SO_SEQ" ).append("\n"); 
		query.append(") REWO" ).append("\n"); 
		query.append(",(" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("EDI.IBD_TRSP_NO" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("BKG_CSTMS_ADV_IBD EDI" ).append("\n"); 
		query.append("WHERE X.BL_NO = EDI.BL_NO" ).append("\n"); 
		query.append(") EDI" ).append("\n"); 
		query.append(",(" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("DECODE(X.SUB_RAIL_SEQ, 1, V.VNDR_ABBR_NM) VNDR_ABBR_NM" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("MDM_VENDOR V" ).append("\n"); 
		query.append("WHERE X.VNDR_SEQ = V.VNDR_SEQ" ).append("\n"); 
		query.append(") VNDR" ).append("\n"); 
		query.append(",(" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("CASE WHEN X.TRSP_RAIL_BIL_TP_CD = 'W' AND X.TRSP_SO_STS_CD = 'C' AND X.DELT_FLG ='N' AND X.SPND_FLG ='N' THEN 'GOOD/EDI Failure'" ).append("\n"); 
		query.append("ELSE REPLACE(Z.ERR_DESC, CHR(13)||CHR(10), ' ')" ).append("\n"); 
		query.append("END ERR_DESC" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("COM_ERR_MSG Z" ).append("\n"); 
		query.append("WHERE X.SPND_ERR_MSG_CD = Z.ERR_MSG_CD" ).append("\n"); 
		query.append("AND   X.SPND_LANG_TP_CD = Z.LANG_TP_CD" ).append("\n"); 
		query.append(") MSG" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT /*+ ORDERED USE_NL(SKD A) */" ).append("\n"); 
		query.append("MAX(A1.INV_NO) OVER (PARTITION BY A.TRSP_SO_OFC_CTY_CD, A.TRSP_SO_SEQ, A.BIL_ISS_KNT) MAX_CHK," ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("REPLACE(MDM_CO.CMDT_NM, CHR(13)||CHR(10), ' ') CMDT_NAME" ).append("\n"); 
		query.append("FROM MDM_COMMODITY MDM_CO" ).append("\n"); 
		query.append("WHERE B.CMDT_CD = MDM_CO.CMDT_CD" ).append("\n"); 
		query.append(") MDM_CO," ).append("\n"); 
		query.append("A.TRSP_SO_OFC_CTY_CD AS TRSP_SO_OFC_CTY_CD," ).append("\n"); 
		query.append("A.TRSP_SO_SEQ AS TRSP_SO_SEQ," ).append("\n"); 
		query.append("A.BIL_ISS_KNT AS BIL_ISS_KNT," ).append("\n"); 
		query.append("A.TRSP_SO_STS_CD AS TRSP_SO_STS_CD," ).append("\n"); 
		query.append("A.BKG_NO_RVIS_FLG AS BKG_NO_RVIS_FLG," ).append("\n"); 
		query.append("A.POL_NOD_CD AS POL_NOD_CD," ).append("\n"); 
		query.append("A.BKG_NO AS BKG_NO," ).append("\n"); 
		query.append("A.BLK_FLG AS BLK_FLG," ).append("\n"); 
		query.append("A.STEL_WIRE_FLG AS STEL_WIRE_FLG," ).append("\n"); 
		query.append("A.COIL_SHP_FLG AS COIL_SHP_FLG," ).append("\n"); 
		query.append("A.FUMG_FLG AS FUMG_FLG," ).append("\n"); 
		query.append("A.COP_NO AS COP_NO," ).append("\n"); 
		query.append("DECODE(A.TRSP_SO_STS_CD, 'C', 'S/O Created', 'R', 'S/O Corrected', 'I', 'EDI Sent', '') AS STATUS," ).append("\n"); 
		query.append("A.COST_ACT_GRP_SEQ AS COST_ACT_GRP_SEQ," ).append("\n"); 
		query.append("A.EQ_NO AS EQ_NO," ).append("\n"); 
		query.append("A.EQ_TPSZ_CD AS EQ_TPSZ_CD," ).append("\n"); 
		query.append("A.REPO_PLN_ID AS REPO_PLN_ID," ).append("\n"); 
		query.append("A.PLN_YRWK AS PLN_YRWK," ).append("\n"); 
		query.append("A.REF_SEQ AS REF_SEQ," ).append("\n"); 
		query.append("A.REF_ID AS REF_ID," ).append("\n"); 
		query.append("A.CGO_TP_CD AS CGO_TP_CD," ).append("\n"); 
		query.append("A.TRSP_BND_CD AS TRSP_BND_CD," ).append("\n"); 
		query.append("A.CXL_RQST_FLG AS CXL_RQST_FLG," ).append("\n"); 
		query.append("DECODE(A.TRSP_RAIL_BIL_TP_CD, 'E', 'ALPS', 'W', 'WRS', '') AS THROUGH," ).append("\n"); 
		query.append("A.TRSP_RAIL_BIL_TP_CD AS TRSP_RAIL_BIL_TP_CD," ).append("\n"); 
		query.append("A.IBD_IPI_LOCL_IND_CD AS IBD_IPI_LOCL_IND_CD," ).append("\n"); 
		query.append("A.BL_NO AS BL_NO," ).append("\n"); 
		query.append("A.BKG_RCVDE_TERM_CD AS BKG_RCVDE_TERM_CD," ).append("\n"); 
		query.append("A.BIL_ISS_STS_CD AS BIL_ISS_STS_CD," ).append("\n"); 
		query.append("DECODE(A.BKG_NO_RVIS_FLG, NULL, '', A.BKG_NO) AS REVISED_BKG_NO," ).append("\n"); 
		query.append("SUBSTR( DECODE(A.TRSP_BND_CD, 'I', NVL(A.POD_NOD_CD, A.POD_CD) , 'O', A.POR_NOD_CD, '') , 1, 5) AS PODPOR_CD," ).append("\n"); 
		query.append("SUBSTR( DECODE(A.TRSP_BND_CD, 'I', NVL(A.POD_NOD_CD, A.POD_CD) , 'O', A.POR_NOD_CD, '') , 6) AS PODPOR_YARD," ).append("\n"); 
		query.append("SUBSTR(A.FM_NOD_CD, 1, 5) AS FM_NOD_CD," ).append("\n"); 
		query.append("SUBSTR(A.FM_NOD_CD, 6) AS FM_NOD_YARD," ).append("\n"); 
		query.append("SUBSTR(A.TO_NOD_CD, 1, 5) AS TO_NOD_CD," ).append("\n"); 
		query.append("SUBSTR(A.TO_NOD_CD, 6) AS TO_NOD_YARD," ).append("\n"); 
		query.append("SUBSTR(A.FM_NOD_CD, 1, 5) AS ORG_FM_NOD_CD," ).append("\n"); 
		query.append("SUBSTR(A.FM_NOD_CD, 6) AS ORG_FM_NOD_YARD," ).append("\n"); 
		query.append("SUBSTR(A.TO_NOD_CD, 1, 5) AS ORG_TO_NOD_CD," ).append("\n"); 
		query.append("SUBSTR(A.TO_NOD_CD, 6) AS ORG_TO_NOD_YARD," ).append("\n"); 
		query.append("SUBSTR(DECODE(A.TRSP_BND_CD, 'I', A.DEL_NOD_CD, 'O', NVL(A.POL_NOD_CD, A.POL_CD) , '') , 1, 5) AS POLDEL_CD," ).append("\n"); 
		query.append("SUBSTR(DECODE(A.TRSP_BND_CD, 'I', A.DEL_NOD_CD, 'O', NVL(A.POL_NOD_CD, A.POL_CD) , '') , 6) AS POLDEL_YARD," ).append("\n"); 
		query.append("A.POL_CD AS POL_CD," ).append("\n"); 
		query.append("A.IBD_CSTMS_CLR_LOC_CD AS IBD_CSTMS_CLR_LOC_CD," ).append("\n"); 
		query.append("A.VSL_CD||A.SKD_VOY_NO||A.SKD_DIR_CD AS TRUNKVVD," ).append("\n"); 
		query.append("A.POD_CD AS POD_CD," ).append("\n"); 
		query.append("A1.SUB_RAIL_SEQ AS SUB_RAIL_SEQ," ).append("\n"); 
		query.append("A.PROV_VNDR_SEQ AS REQUEST_SP," ).append("\n"); 
		query.append("A1.VNDR_SEQ AS VNDR_SEQ," ).append("\n"); 
		query.append("'' AS COST_MONTH," ).append("\n"); 
		query.append("TO_CHAR(A.LOCL_CRE_DT, 'YYYYMMDD') AS CRE_DT," ).append("\n"); 
		query.append("TO_CHAR(A.LOCL_CRE_DT, 'HH24:MI:SS') AS CRE_DT_HMS," ).append("\n"); 
		query.append("TO_CHAR(A.CXL_RQST_DT, 'YYYYMMDD') AS CXL_RQST_DT," ).append("\n"); 
		query.append("TO_CHAR(A.CXL_RQST_DT, 'HH24:MI:SS') AS CXL_RQST_DT_HMS," ).append("\n"); 
		query.append("A.CXL_RQST_RSN AS CXL_RQST_RSN," ).append("\n"); 
		query.append("TO_CHAR(A.CXL_RQST_RJCT_DT, 'YYYYMMDD') AS CXL_RQST_RJCT_DT," ).append("\n"); 
		query.append("TO_CHAR(A.CXL_RQST_RJCT_DT, 'HH24:MI:SS') AS CXL_RQST_RJCT_DT_HMS," ).append("\n"); 
		query.append("A.CXL_RQST_RJCT_RSN AS RQST_RJCT_RSN," ).append("\n"); 
		query.append("A.INTER_RMK AS INTER_RMK," ).append("\n"); 
		query.append("A.SPCL_INSTR_RMK AS SPCL_INSTR_RMK," ).append("\n"); 
		query.append("A.ROUT_ORG_NOD_CD AS ROUT_ORG_NOD_CD," ).append("\n"); 
		query.append("A.ROUT_DEST_NOD_CD AS ROUT_DEST_NOD_CD," ).append("\n"); 
		query.append("NVL(A.ROUT_SEQ, 0) AS ROUT_SEQ," ).append("\n"); 
		query.append("A.DELT_FLG AS DELT_FLG," ).append("\n"); 
		query.append("A.SPND_FLG AS SPND_FLG," ).append("\n"); 
		query.append("A.ROUT_PLN_CD AS ROUT_PLN_CD," ).append("\n"); 
		query.append("A.INLND_ROUT_RMK AS INLND_ROUT_RMK," ).append("\n"); 
		query.append("A.INV_BIL_PATT_DIV_FLG AS INV_BIL_PATT_DIV_FLG," ).append("\n"); 
		query.append("A.RAIL_CMB_THRU_TP_CD AS RAIL_CMB_THRU_TP_CD," ).append("\n"); 
		query.append("A1.TO_NOD_CD AS VNDR_SET_TO_NOD_CD," ).append("\n"); 
		query.append("ROUND(A.CNTR_WGT) AS CNTR_WGT," ).append("\n"); 
		query.append("A.SPND_ERR_MSG_CD AS SPND_ERR_MSG_CD," ).append("\n"); 
		query.append("A.SPND_LANG_TP_CD AS SPND_LANG_TP_CD," ).append("\n"); 
		query.append("A1.TRSP_AGMT_OFC_CTY_CD AS TRSP_AGMT_OFC_CTY_CD," ).append("\n"); 
		query.append("A1.TRSP_AGMT_SEQ AS TRSP_AGMT_SEQ," ).append("\n"); 
		query.append("A1.INV_NO AS INV_NO," ).append("\n"); 
		query.append("A.COST_ACT_GRP_CD AS ACT_GRP_CD," ).append("\n"); 
		query.append("A.SPCL_CGO_CNTR_TP_CD AS SPCL_CGO_CNTR_TP_CD," ).append("\n"); 
		query.append("B.BKG_STS_CD AS BKG_BKG_STS_CD," ).append("\n"); 
		query.append("B.DE_TERM_CD AS BKG_DE_TERM_CD," ).append("\n"); 
		query.append("B.RCV_TERM_CD AS BKG_RCV_TERM_CD," ).append("\n"); 
		query.append("B.VSL_CD||B.SKD_VOY_NO||B.SKD_DIR_CD AS BKG_VVD," ).append("\n"); 
		query.append("B.POD_CD AS BKG_POD_CD," ).append("\n"); 
		query.append("B.BKG_NO AS BKG_BKG_NO," ).append("\n"); 
		query.append("TO_CHAR(SKD.EVNT_DT, 'YYYYMMDD') AS BKG_UPDATED_DT," ).append("\n"); 
		query.append("TO_CHAR(SKD.EVNT_DT, 'HH24:MI:SS') AS BKG_UPDATED_DT_HMS," ).append("\n"); 
		query.append("DECODE( B.DCGO_FLG , 'Y', 'DG ') ||" ).append("\n"); 
		query.append("DECODE( B.RC_FLG , 'Y', 'RF ') ||" ).append("\n"); 
		query.append("DECODE( B.AWK_CGO_FLG , 'Y', 'AK ') ||" ).append("\n"); 
		query.append("DECODE( B.BB_CGO_FLG , 'Y', 'BB ') ||" ).append("\n"); 
		query.append("DECODE( B.SPCL_HIDE_FLG , 'Y', 'HD ') ||" ).append("\n"); 
		query.append("DECODE( B.FD_GRD_FLG , 'Y', 'FG ') ||" ).append("\n"); 
		query.append("DECODE( B.RAIL_BLK_CD , '', '', 'RB ') AS BKG_SPE," ).append("\n"); 
		query.append("D.DCGO_FLG AS CNTR_DCGO_FLG," ).append("\n"); 
		query.append("D.BB_CGO_FLG AS CNTR_BB_CGO_FLG," ).append("\n"); 
		query.append("D.AWK_CGO_FLG AS CNTR_AWK_CGO_FLG," ).append("\n"); 
		query.append("D.RC_FLG AS CNTR_RC_FLG," ).append("\n"); 
		query.append("D.RD_CGO_FLG AS CNTR_RD_CGO_FLG," ).append("\n"); 
		query.append("SUBSTR(MVMT.ORG_YD_CD, 1, 5) AS MVMT_YARD," ).append("\n"); 
		query.append("MVMT.MVMT_STS_CD AS MVMT_STATUS" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("( SELECT SKD.BKG_NO , MAX(EVNT_DT)  EVNT_DT FROM BKG_DOC_PROC_SKD SKD" ).append("\n"); 
		query.append("WHERE  SKD.EVNT_DT BETWEEN TO_DATE(@[splanFromDate], 'YYYYMMDD') AND TO_DATE(@[splanToDate], 'YYYYMMDD') + 0.99999" ).append("\n"); 
		query.append("GROUP BY SKD.BKG_NO" ).append("\n"); 
		query.append(") SKD ," ).append("\n"); 
		query.append("TRS_TRSP_RAIL_BIL_ORD A," ).append("\n"); 
		query.append("TRS_TRSP_RAIL_BIL_VNDR_SET A1," ).append("\n"); 
		query.append("BKG_BOOKING B," ).append("\n"); 
		query.append("BKG_CONTAINER D," ).append("\n"); 
		query.append("CTM_MOVEMENT MVMT" ).append("\n"); 
		query.append("WHERE A.TRSP_SO_OFC_CTY_CD = A1.TRSP_SO_OFC_CTY_CD" ).append("\n"); 
		query.append("AND   A.TRSP_SO_SEQ = A1.TRSP_SO_SEQ" ).append("\n"); 
		query.append("AND   A.BKG_NO = B.BKG_NO" ).append("\n"); 
		query.append("AND   A.BKG_NO = SKD.BKG_NO" ).append("\n"); 
		query.append("AND   A.BKG_NO = D.BKG_NO (+)" ).append("\n"); 
		query.append("AND   A.EQ_NO = D.CNTR_NO (+)" ).append("\n"); 
		query.append("AND   D.CNTR_NO = MVMT.CNTR_NO(+)" ).append("\n"); 
		query.append("AND   D.CNMV_YR = MVMT.CNMV_YR(+)" ).append("\n"); 
		query.append("AND   D.CNMV_ID_NO = MVMT.CNMV_ID_NO(+)" ).append("\n"); 
		query.append("AND   A.CRE_OFC_CD IN (@[sctrlOfcCd], 'SYSTEM')" ).append("\n"); 
		query.append("AND   A.DELT_FLG = 'N'" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if($vvd.size() > 0)" ).append("\n"); 
		query.append("AND ((A.VSL_CD, A.SKD_VOY_NO, A.SKD_DIR_CD) IN (" ).append("\n"); 
		query.append("#foreach($key IN ${vvd})" ).append("\n"); 
		query.append("#if($velocityCount == 1)" ).append("\n"); 
		query.append("( SUBSTR('$key', 1, 4), SUBSTR('$key', 5, 4), SUBSTR('$key', 9))" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append(", ( SUBSTR('$key', 1, 4), SUBSTR('$key', 5, 4), SUBSTR('$key', 9))" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if($bkg.size() > 0)" ).append("\n"); 
		query.append("AND A.BKG_NO IN (" ).append("\n"); 
		query.append("#foreach($key IN ${bkg})" ).append("\n"); 
		query.append("#if($velocityCount == 1)" ).append("\n"); 
		query.append("'$key'" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append(",'$key'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if($bl.size() > 0)" ).append("\n"); 
		query.append("AND A.BL_NO IN (" ).append("\n"); 
		query.append("#foreach($key IN ${bl})" ).append("\n"); 
		query.append("#if($velocityCount == 1)" ).append("\n"); 
		query.append("'$key'" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append(",'$key'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if($cntr.size() > 0)" ).append("\n"); 
		query.append("AND A.EQ_NO IN (" ).append("\n"); 
		query.append("#foreach($key IN ${cntr})" ).append("\n"); 
		query.append("#if($velocityCount == 1)" ).append("\n"); 
		query.append("'$key'" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append(",'$key'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if(${sselStatus} == \"ALL\")" ).append("\n"); 
		query.append("AND A.TRSP_SO_STS_CD IN ('C', 'R','I')" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("AND A.TRSP_SO_STS_CD = @[sselStatus]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if(${sfromLocationCd} != \"\")" ).append("\n"); 
		query.append("AND A.FM_NOD_CD LIKE @[sfromLocationCd]||'%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if(${stoLocationCd} != \"\")" ).append("\n"); 
		query.append("AND A.TO_NOD_CD LIKE @[stoLocationCd]||'%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if(${sselEdikind} == \"ALL\")" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("AND A.CGO_TP_CD = @[sselEdikind]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if(${sselBnd} == \"ALL\")" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("AND A.TRSP_BND_CD = @[sselBnd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if(${sselThrough} == \"ALL\")" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("AND A.TRSP_RAIL_BIL_TP_CD = @[sselThrough]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if(${sselLimtinq} == \"ALL\")" ).append("\n"); 
		query.append("#elseif(${sselLimtinq} == 'X')" ).append("\n"); 
		query.append("AND A.TRSP_RAIL_BIL_TP_CD='W'" ).append("\n"); 
		query.append("AND NVL(A.CXL_RQST_RJCT_FLG, 'N') = 'N'" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("AND A.CXL_RQST_RJCT_FLG='Y'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if(${radVendor} == \"V2\" && ${comboSvcProvider} != \"\")" ).append("\n"); 
		query.append("AND A.PROV_VNDR_SEQ = @[comboSvcProvider]" ).append("\n"); 
		query.append("#elseif(${radVendor} == \"V1\" && ${selRailRoad} != \"ALL\")" ).append("\n"); 
		query.append("AND A1.VNDR_SEQ = @[selRailRoad]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if(${sselUnmatch} == \"ALL\")" ).append("\n"); 
		query.append("#elseif(${sselUnmatch} == 'N')" ).append("\n"); 
		query.append("AND NVL(A.VSL_CD||A.SKD_VOY_NO||A.SKD_DIR_CD, 'N/A') = NVL(B.VSL_CD||B.SKD_VOY_NO||B.SKD_DIR_CD, 'N/A')" ).append("\n"); 
		query.append("AND NVL(A.POD_CD, 'N/A') = NVL(B.POD_CD, 'N/A')" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("AND ( NVL(A.VSL_CD||A.SKD_VOY_NO||A.SKD_DIR_CD, 'N/A') <> NVL(B.VSL_CD||B.SKD_VOY_NO||B.SKD_DIR_CD, 'N/A')" ).append("\n"); 
		query.append("OR NVL(A.POD_CD, 'N/A') <> NVL(B.POD_CD, 'N/A'))" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(") X" ).append("\n"); 
		query.append("WHERE X.MAX_CHK IS NULL" ).append("\n"); 
		query.append(") TMP," ).append("\n"); 
		query.append("TRS_AGMT_HDR AGMT" ).append("\n"); 
		query.append("WHERE TMP.TRSP_AGMT_OFC_CTY_CD = AGMT.TRSP_AGMT_OFC_CTY_CD(+)" ).append("\n"); 
		query.append("AND   TMP.TRSP_AGMT_SEQ = AGMT.TRSP_AGMT_SEQ(+)" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("AND (NVL(TMP.SPCL_CGO_CNTR_TP_CD, 'NN') <> CASE WHEN TMP.CNTR_DCGO_FLG='Y' THEN 'DG'" ).append("\n"); 
		query.append("WHEN TMP.CNTR_BB_CGO_FLG ='Y' THEN 'BB'" ).append("\n"); 
		query.append("WHEN TMP.CNTR_AWK_CGO_FLG='Y' THEN 'AK'" ).append("\n"); 
		query.append("WHEN TMP.CNTR_RC_FLG='Y' THEN 'RF'" ).append("\n"); 
		query.append("WHEN TMP.CNTR_RD_CGO_FLG='Y' THEN 'RD'" ).append("\n"); 
		query.append("ELSE 'XY'" ).append("\n"); 
		query.append("END" ).append("\n"); 
		query.append("OR NVL(DECODE(TMP.TRSP_BND_CD, 'O', TMP.TRUNKVVD, ''), '') <> NVL(DECODE(TMP.TRSP_BND_CD, 'O', TMP.BKG_VVD, ''), '')" ).append("\n"); 
		query.append("OR NVL(DECODE(TMP.TRSP_BND_CD, 'O', TMP.POL_CD, ''), '') <> NVL(DECODE(TMP.TRSP_BND_CD, 'O', TMP.BKG_POD_CD, ''), '')" ).append("\n"); 
		query.append("OR NVL(DECODE(TMP.TRSP_BND_CD, 'O', TMP.BKG_NO, ''), '') <> DECODE(TMP.TRSP_BND_CD, 'O', TMP.BKG_BKG_NO, ''))" ).append("\n"); 
		query.append("GROUP BY" ).append("\n"); 
		query.append("TMP.TRSP_SO_OFC_CTY_CD," ).append("\n"); 
		query.append("TMP.TRSP_SO_SEQ," ).append("\n"); 
		query.append("TMP.BIL_ISS_KNT" ).append("\n"); 
		query.append("HAVING MAX(TMP.INV_NO) IS NULL" ).append("\n"); 

	}
}