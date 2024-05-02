/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : BlRatingDBDAOSearchXchRtRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.03.19
*@LastModifier : 김태경
*@LastVersion : 1.0
* 2010.03.19 김태경
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.outbounddocumentation.blrating.blrating.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author kim tae kyoung
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BlRatingDBDAOSearchXchRtRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 환율 정보를 조회한다. -- UI_BKG-0945
	  * </pre>
	  */
	public BlRatingDBDAOSearchXchRtRSQL(){
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
		query.append("Path : com.hanjin.apps.alps.esm.bkg.outbounddocumentation.blrating.blrating.integration").append("\n"); 
		query.append("FileName : BlRatingDBDAOSearchXchRtRSQL").append("\n"); 
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
		query.append("SELECT DISTINCT 'p_' AS TYPE ," ).append("\n"); 
		query.append("  BKG.BKG_NO BKG_NO," ).append("\n"); 
		query.append("  --NM.LOCL_CURR_CD CURR_CD," ).append("\n"); 
		query.append("  CHG.CURR_CD CURR_CD," ).append("\n"); 
		query.append("  NM.LOCL_CURR_CD L_CURR_CD," ).append("\n"); 
		query.append("  CHG.INV_XCH_RT INV_XCH_RT," ).append("\n"); 
		query.append("  VVD.POL_CD VPS_PORT_CD," ).append("\n"); 
		query.append("  VVD.VSL_CD||VVD.SKD_VOY_NO||VVD.SKD_DIR_CD VSL," ).append("\n"); 
		query.append("  TO_CHAR(VPS_ETD_DT, 'YYYY-MM-DD') VPS_ETD_DT" ).append("\n"); 
		query.append("FROM BKG_BOOKING BKG," ).append("\n"); 
		query.append("  BKG_VVD VVD," ).append("\n"); 
		query.append("  BKG_RATE RATE ," ).append("\n"); 
		query.append("  VSK_VSL_PORT_SKD SKD," ).append("\n"); 
		query.append("  INV_AR_CHG CHG," ).append("\n"); 
		query.append("  (" ).append("\n"); 
		query.append("    SELECT MAX(AR_IF_NO) AR_IF_NO," ).append("\n"); 
		query.append("      AR_OFC_CD," ).append("\n"); 
		query.append("      LOCL_CURR_CD" ).append("\n"); 
		query.append("    FROM INV_AR_MN" ).append("\n"); 
		query.append("    WHERE BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("      and IO_BND_CD = 'O'" ).append("\n"); 
		query.append("    GROUP BY AR_OFC_CD, LOCL_CURR_CD ) NM," ).append("\n"); 
		query.append("  MDM_ORGANIZATION ORA" ).append("\n"); 
		query.append("WHERE BKG.BKG_NO = VVD.BKG_NO" ).append("\n"); 
		query.append("  AND BKG.POL_CD = VVD.POL_CD" ).append("\n"); 
		query.append("  AND BKG.BKG_NO = RATE.BKG_NO" ).append("\n"); 
		query.append("  AND NM.AR_IF_NO = CHG.AR_IF_NO" ).append("\n"); 
		query.append("  AND BKG.bkg_no = @[bkg_no]" ).append("\n"); 
		query.append("  AND VVD.VSL_CD = SKD.VSL_CD" ).append("\n"); 
		query.append("  AND VVD.SKD_VOY_NO = SKD.SKD_VOY_NO" ).append("\n"); 
		query.append("  AND VVD.SKD_DIR_CD = SKD.SKD_DIR_CD" ).append("\n"); 
		query.append("  AND VVD.POL_CD = SKD.VPS_PORT_CD" ).append("\n"); 
		query.append("  AND VVD.POL_CLPT_IND_SEQ = SKD.CLPT_IND_SEQ" ).append("\n"); 
		query.append("  AND RATE.PPD_RCV_OFC_CD = ORA.OFC_CD" ).append("\n"); 
		query.append("  AND NM.AR_OFC_CD = RATE.PPD_RCV_OFC_CD" ).append("\n"); 
		query.append("  AND CHG.CURR_CD <> NM.LOCL_CURR_CD" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT DISTINCT 'c_' AS TYPE ," ).append("\n"); 
		query.append("  BKG.BKG_NO BKG_NO," ).append("\n"); 
		query.append("  --NM.LOCL_CURR_CD CURR_CD," ).append("\n"); 
		query.append("  CHG.CURR_CD CURR_CD," ).append("\n"); 
		query.append("  NM.LOCL_CURR_CD L_CURR_CD," ).append("\n"); 
		query.append("  CHG.INV_XCH_RT INV_XCH_RT," ).append("\n"); 
		query.append("  VVD.POD_CD VPS_PORT_CD," ).append("\n"); 
		query.append("  VVD.VSL_CD||VVD.SKD_VOY_NO||VVD.SKD_DIR_CD VSL," ).append("\n"); 
		query.append("  TO_CHAR(VPS_ETD_DT, 'YYYY-MM-DD') VPS_ETD_DT" ).append("\n"); 
		query.append("FROM BKG_BOOKING BKG," ).append("\n"); 
		query.append("  BKG_VVD VVD," ).append("\n"); 
		query.append("  BKG_RATE RATE ," ).append("\n"); 
		query.append("  VSK_VSL_PORT_SKD SKD," ).append("\n"); 
		query.append("  INV_AR_CHG CHG," ).append("\n"); 
		query.append("  (" ).append("\n"); 
		query.append("    SELECT MAX(AR_IF_NO) AR_IF_NO," ).append("\n"); 
		query.append("      AR_OFC_CD," ).append("\n"); 
		query.append("      LOCL_CURR_CD" ).append("\n"); 
		query.append("    FROM INV_AR_MN" ).append("\n"); 
		query.append("    WHERE BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("      and IO_BND_CD = 'I'" ).append("\n"); 
		query.append("    GROUP BY AR_OFC_CD, LOCL_CURR_CD ) NM," ).append("\n"); 
		query.append("  MDM_ORGANIZATION ORA" ).append("\n"); 
		query.append("WHERE BKG.BKG_NO = VVD.BKG_NO" ).append("\n"); 
		query.append("  AND BKG.POL_CD = VVD.POL_CD" ).append("\n"); 
		query.append("  AND BKG.BKG_NO = RATE.BKG_NO" ).append("\n"); 
		query.append("  AND NM.AR_IF_NO = CHG.AR_IF_NO" ).append("\n"); 
		query.append("  AND BKG.bkg_no = @[bkg_no]" ).append("\n"); 
		query.append("  AND VVD.VSL_CD = SKD.VSL_CD" ).append("\n"); 
		query.append("  AND VVD.SKD_VOY_NO = SKD.SKD_VOY_NO" ).append("\n"); 
		query.append("  AND VVD.SKD_DIR_CD = SKD.SKD_DIR_CD" ).append("\n"); 
		query.append("  AND VVD.POD_CD = SKD.VPS_PORT_CD" ).append("\n"); 
		query.append("  AND VVD.POD_CLPT_IND_SEQ = SKD.CLPT_IND_SEQ" ).append("\n"); 
		query.append("  AND RATE.CLT_OFC_CD = ORA.OFC_CD" ).append("\n"); 
		query.append("  AND NM.AR_OFC_CD = RATE.CLT_OFC_CD" ).append("\n"); 
		query.append("  AND CHG.CURR_CD <> NM.LOCL_CURR_CD" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT DISTINCT 'tp_' AS TYPE ," ).append("\n"); 
		query.append("  BKG.BKG_NO BKG_NO," ).append("\n"); 
		query.append("  --NM.LOCL_CURR_CD CURR_CD," ).append("\n"); 
		query.append("  CHG.CURR_CD CURR_CD," ).append("\n"); 
		query.append("  NM.LOCL_CURR_CD L_CURR_CD," ).append("\n"); 
		query.append("  CHG.INV_XCH_RT INV_XCH_RT," ).append("\n"); 
		query.append("  VVD.POL_CD VPS_PORT_CD," ).append("\n"); 
		query.append("  VVD.VSL_CD||VVD.SKD_VOY_NO||VVD.SKD_DIR_CD VSL," ).append("\n"); 
		query.append("  TO_CHAR(VPS_ETD_DT, 'YYYY-MM-DD') VPS_ETD_DT" ).append("\n"); 
		query.append("FROM BKG_BOOKING BKG," ).append("\n"); 
		query.append("  BKG_VVD VVD," ).append("\n"); 
		query.append("  (" ).append("\n"); 
		query.append("    SELECT DISTINCT N3PTY_RCV_OFC_CD PPD_RCV_OFC_CD" ).append("\n"); 
		query.append("    FROM BKG_CHG_RT" ).append("\n"); 
		query.append("    WHERE BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("      AND FRT_TERM_CD = 'P'" ).append("\n"); 
		query.append("      AND TRIM(N3PTY_RCV_OFC_CD) IS NOT NULL) RATE ," ).append("\n"); 
		query.append("  VSK_VSL_PORT_SKD SKD," ).append("\n"); 
		query.append("  INV_AR_CHG CHG," ).append("\n"); 
		query.append("  (" ).append("\n"); 
		query.append("    SELECT MAX(AR_IF_NO) AR_IF_NO," ).append("\n"); 
		query.append("      AR_OFC_CD," ).append("\n"); 
		query.append("      LOCL_CURR_CD" ).append("\n"); 
		query.append("    FROM INV_AR_MN" ).append("\n"); 
		query.append("    WHERE BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("      and IO_BND_CD = 'O'" ).append("\n"); 
		query.append("    GROUP BY AR_OFC_CD, LOCL_CURR_CD ) NM," ).append("\n"); 
		query.append("  MDM_ORGANIZATION ORA" ).append("\n"); 
		query.append("WHERE BKG.BKG_NO = VVD.BKG_NO" ).append("\n"); 
		query.append("  AND BKG.POL_CD = VVD.POL_CD" ).append("\n"); 
		query.append("  AND NM.AR_IF_NO = CHG.AR_IF_NO" ).append("\n"); 
		query.append("  AND BKG.bkg_no = @[bkg_no]" ).append("\n"); 
		query.append("  AND VVD.VSL_CD = SKD.VSL_CD" ).append("\n"); 
		query.append("  AND VVD.SKD_VOY_NO = SKD.SKD_VOY_NO" ).append("\n"); 
		query.append("  AND VVD.SKD_DIR_CD = SKD.SKD_DIR_CD" ).append("\n"); 
		query.append("  AND VVD.POL_CD = SKD.VPS_PORT_CD" ).append("\n"); 
		query.append("  AND VVD.POL_CLPT_IND_SEQ = SKD.CLPT_IND_SEQ" ).append("\n"); 
		query.append("  AND RATE.PPD_RCV_OFC_CD = ORA.OFC_CD" ).append("\n"); 
		query.append("  AND NM.AR_OFC_CD = RATE.PPD_RCV_OFC_CD" ).append("\n"); 
		query.append("  AND CHG.CURR_CD <> NM.LOCL_CURR_CD" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT DISTINCT 'cp_' AS TYPE ," ).append("\n"); 
		query.append("  BKG.BKG_NO BKG_NO," ).append("\n"); 
		query.append("  --NM.LOCL_CURR_CD CURR_CD," ).append("\n"); 
		query.append("  CHG.CURR_CD CURR_CD," ).append("\n"); 
		query.append("  NM.LOCL_CURR_CD L_CURR_CD," ).append("\n"); 
		query.append("  CHG.INV_XCH_RT INV_XCH_RT," ).append("\n"); 
		query.append("  VVD.POD_CD VPS_PORT_CD," ).append("\n"); 
		query.append("  VVD.VSL_CD||VVD.SKD_VOY_NO||VVD.SKD_DIR_CD VSL," ).append("\n"); 
		query.append("  TO_CHAR(VPS_ETD_DT, 'YYYY-MM-DD') VPS_ETD_DT" ).append("\n"); 
		query.append("FROM BKG_BOOKING BKG," ).append("\n"); 
		query.append("  BKG_VVD VVD," ).append("\n"); 
		query.append("  (" ).append("\n"); 
		query.append("    SELECT DISTINCT N3PTY_RCV_OFC_CD PPD_RCV_OFC_CD" ).append("\n"); 
		query.append("    FROM BKG_CHG_RT" ).append("\n"); 
		query.append("    WHERE BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("      AND FRT_TERM_CD = 'C'" ).append("\n"); 
		query.append("      AND TRIM(N3PTY_RCV_OFC_CD) IS NOT NULL) RATE ," ).append("\n"); 
		query.append("  VSK_VSL_PORT_SKD SKD," ).append("\n"); 
		query.append("  INV_AR_CHG CHG," ).append("\n"); 
		query.append("  (" ).append("\n"); 
		query.append("    SELECT MAX(AR_IF_NO) AR_IF_NO," ).append("\n"); 
		query.append("      AR_OFC_CD," ).append("\n"); 
		query.append("      LOCL_CURR_CD" ).append("\n"); 
		query.append("    FROM INV_AR_MN" ).append("\n"); 
		query.append("    WHERE BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("      and IO_BND_CD = 'I'" ).append("\n"); 
		query.append("    GROUP BY AR_OFC_CD, LOCL_CURR_CD ) NM," ).append("\n"); 
		query.append("  MDM_ORGANIZATION ORA" ).append("\n"); 
		query.append("WHERE BKG.BKG_NO = VVD.BKG_NO" ).append("\n"); 
		query.append("  AND BKG.POL_CD = VVD.POL_CD" ).append("\n"); 
		query.append("  AND NM.AR_IF_NO = CHG.AR_IF_NO" ).append("\n"); 
		query.append("  AND BKG.bkg_no = @[bkg_no]" ).append("\n"); 
		query.append("  AND VVD.VSL_CD = SKD.VSL_CD" ).append("\n"); 
		query.append("  AND VVD.SKD_VOY_NO = SKD.SKD_VOY_NO" ).append("\n"); 
		query.append("  AND VVD.SKD_DIR_CD = SKD.SKD_DIR_CD" ).append("\n"); 
		query.append("  AND VVD.POD_CD = SKD.VPS_PORT_CD" ).append("\n"); 
		query.append("  AND VVD.POD_CLPT_IND_SEQ = SKD.CLPT_IND_SEQ" ).append("\n"); 
		query.append("  AND RATE.PPD_RCV_OFC_CD = ORA.OFC_CD" ).append("\n"); 
		query.append("  AND NM.AR_OFC_CD = RATE.PPD_RCV_OFC_CD" ).append("\n"); 
		query.append("  AND CHG.CURR_CD <> NM.LOCL_CURR_CD" ).append("\n"); 

	}
}