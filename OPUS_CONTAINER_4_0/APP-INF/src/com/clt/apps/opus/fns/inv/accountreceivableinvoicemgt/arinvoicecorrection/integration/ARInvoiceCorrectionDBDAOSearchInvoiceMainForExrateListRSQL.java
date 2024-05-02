/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : ARInvoiceCorrectionDBDAOSearchInvoiceMainForExrateListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.08.02
*@LastModifier : 
*@LastVersion : 1.0
* 2016.08.02 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.arinvoicecorrection.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ARInvoiceCorrectionDBDAOSearchInvoiceMainForExrateListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 
	  * </pre>
	  */
	public ARInvoiceCorrectionDBDAOSearchInvoiceMainForExrateListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vvd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("fm_if_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inv_cust_cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bl_src_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("to_if_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inv_cust_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.arinvoicecorrection.integration").append("\n"); 
		query.append("FileName : ARInvoiceCorrectionDBDAOSearchInvoiceMainForExrateListRSQL").append("\n"); 
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
		query.append("#if (${run_opt} == 'N')" ).append("\n"); 
		query.append("SELECT MN.AR_IF_NO," ).append("\n"); 
		query.append("       MN.INV_CUST_CNT_CD,  " ).append("\n"); 
		query.append("       MN.INV_CUST_SEQ, " ).append("\n"); 
		query.append("       MN.AR_OFC_CD, " ).append("\n"); 
		query.append("       MN.LOCL_CURR_CD," ).append("\n"); 
		query.append("       MN.SAIL_DT,  " ).append("\n"); 
		query.append("       MN.VSL_CD, " ).append("\n"); 
		query.append("       MN.SKD_VOY_NO, " ).append("\n"); 
		query.append("       MN.SKD_DIR_CD, " ).append("\n"); 
		query.append("       MN.IO_BND_CD, " ).append("\n"); 
		query.append("       MN.POL_CD, " ).append("\n"); 
		query.append("       MN.POD_CD," ).append("\n"); 
		query.append("       MN.BKG_NO, " ).append("\n"); 
		query.append("       MN.INV_SVC_SCP_CD SVC_SCP_CD," ).append("\n"); 
		query.append("	   MN.BL_INV_CFM_DT," ).append("\n"); 
		query.append("       'N' ISS_FLG," ).append("\n"); 
		query.append("       MN.ACT_CUST_CNT_CD," ).append("\n"); 
		query.append("       MN.ACT_CUST_SEQ," ).append("\n"); 
		query.append("       MN.SAIL_ARR_DT," ).append("\n"); 
		query.append("       MN.REV_TP_CD," ).append("\n"); 
		query.append("       MN.REV_SRC_CD," ).append("\n"); 
		query.append("       MN.BL_SRC_NO" ).append("\n"); 
		query.append("  FROM INV_AR_MN MN" ).append("\n"); 
		query.append(" WHERE MN.AR_OFC_CD = @[ofc_cd]   " ).append("\n"); 
		query.append("   AND MN.BL_INV_IF_DT BETWEEN REPLACE(@[fm_if_dt],'-','') AND REPLACE(@[to_if_dt],'-','')" ).append("\n"); 
		query.append("   AND NVL(MN.INV_DELT_DIV_CD,'N') <> 'Y'" ).append("\n"); 
		query.append("   AND MN.BL_INV_CFM_DT IS NULL" ).append("\n"); 
		query.append("   AND MN.OTS_PAY_CD IS NULL AND MN.ORG_INV_NO IS NULL --Except migration data" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#elseif (${run_opt} == 'V')" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("SELECT MN.AR_IF_NO," ).append("\n"); 
		query.append("       MN.INV_CUST_CNT_CD,  " ).append("\n"); 
		query.append("       MN.INV_CUST_SEQ, " ).append("\n"); 
		query.append("       MN.AR_OFC_CD, " ).append("\n"); 
		query.append("       MN.LOCL_CURR_CD," ).append("\n"); 
		query.append("       MN.SAIL_DT,  " ).append("\n"); 
		query.append("       MN.VSL_CD, " ).append("\n"); 
		query.append("       MN.SKD_VOY_NO, " ).append("\n"); 
		query.append("       MN.SKD_DIR_CD, " ).append("\n"); 
		query.append("       MN.IO_BND_CD, " ).append("\n"); 
		query.append("       MN.POL_CD, " ).append("\n"); 
		query.append("       MN.POD_CD," ).append("\n"); 
		query.append("       MN.BKG_NO, " ).append("\n"); 
		query.append("       MN.INV_SVC_SCP_CD SVC_SCP_CD," ).append("\n"); 
		query.append("       MN.BL_INV_CFM_DT," ).append("\n"); 
		query.append("       NVL(MN.INV_ISS_FLG,'N') ISS_FLG," ).append("\n"); 
		query.append("       MN.ACT_CUST_CNT_CD," ).append("\n"); 
		query.append("       MN.ACT_CUST_SEQ," ).append("\n"); 
		query.append("       MN.SAIL_ARR_DT," ).append("\n"); 
		query.append("	   MN.REV_TP_CD," ).append("\n"); 
		query.append("       MN.REV_SRC_CD," ).append("\n"); 
		query.append("       MN.BL_SRC_NO," ).append("\n"); 
		query.append("       OFC.OTS_SMRY_CD," ).append("\n"); 
		query.append("	   OFC.DMDT_AR_INV_ISS_FLG," ).append("\n"); 
		query.append("	   MN.XCH_RT_USD_TP_CD," ).append("\n"); 
		query.append("	   MN.INV_CLR_FLG     " ).append("\n"); 
		query.append("  FROM INV_AR_MN MN," ).append("\n"); 
		query.append("       INV_AR_STUP_OFC OFC" ).append("\n"); 
		query.append(" WHERE MN.AR_OFC_CD = @[ofc_cd]   " ).append("\n"); 
		query.append("   AND MN.VSL_CD = SUBSTR(@[vvd],1,4)" ).append("\n"); 
		query.append("   AND MN.SKD_VOY_NO= SUBSTR(@[vvd],5,4)" ).append("\n"); 
		query.append("   AND MN.SKD_DIR_CD = SUBSTR(@[vvd],9,1)" ).append("\n"); 
		query.append("   AND MN.AR_OFC_CD = OFC.AR_OFC_CD" ).append("\n"); 
		query.append("   --AND NVL(MN.INV_CLR_FLG,'N') ='N'" ).append("\n"); 
		query.append("   AND MN.XCH_RT_USD_TP_CD ='V'" ).append("\n"); 
		query.append("   AND NVL(MN.INV_DELT_DIV_CD,'N') <> 'Y'" ).append("\n"); 
		query.append("   AND MN.BL_INV_CFM_DT IS NOT NULL" ).append("\n"); 
		query.append("   AND MN.OTS_PAY_CD IS NULL AND MN.ORG_INV_NO IS NULL --Except migration data" ).append("\n"); 
		query.append("   AND (EXISTS (SELECT 'X' " ).append("\n"); 
		query.append("               FROM INV_VVD_XCH_RT VVD, INV_AR_CHG CHG2" ).append("\n"); 
		query.append("               WHERE VVD.VSL_CD     = MN.VSL_CD" ).append("\n"); 
		query.append("               AND   VVD.SKD_VOY_NO = MN.SKD_VOY_NO" ).append("\n"); 
		query.append("               AND   VVD.SKD_DIR_CD = MN.SKD_DIR_CD" ).append("\n"); 
		query.append("               AND   VVD.IO_BND_CD  = MN.IO_BND_CD" ).append("\n"); 
		query.append("               AND   VVD.PORT_CD    = DECODE(MN.IO_BND_CD,'O',MN.POL_CD,MN.POD_CD)" ).append("\n"); 
		query.append("               AND   VVD.SVC_SCP_CD   = MN.INV_SVC_SCP_CD" ).append("\n"); 
		query.append("			   AND   VVD.AR_OFC_CD  = MN.AR_OFC_CD" ).append("\n"); 
		query.append("               AND   VVD.LOCL_CURR_CD = MN.LOCL_CURR_CD" ).append("\n"); 
		query.append("               AND   MN.AR_IF_NO = CHG2.AR_IF_NO" ).append("\n"); 
		query.append("               AND   VVD.CHG_CURR_CD  = CHG2.CURR_CD" ).append("\n"); 
		query.append("               AND   VVD.INV_XCH_RT <> NVL(CHG2.INV_XCH_RT,0)" ).append("\n"); 
		query.append("               AND   VVD.INV_XCH_RT <> 0 )" ).append("\n"); 
		query.append("	OR EXISTS (SELECT 'X' " ).append("\n"); 
		query.append("               FROM INV_VVD_XCH_RT VVD, INV_AR_CHG CHG2" ).append("\n"); 
		query.append("               WHERE VVD.VSL_CD     = MN.VSL_CD" ).append("\n"); 
		query.append("               AND   VVD.SKD_VOY_NO = MN.SKD_VOY_NO" ).append("\n"); 
		query.append("               AND   VVD.SKD_DIR_CD = MN.SKD_DIR_CD" ).append("\n"); 
		query.append("               AND   VVD.IO_BND_CD  = MN.IO_BND_CD" ).append("\n"); 
		query.append("               AND   VVD.PORT_CD    = DECODE(MN.IO_BND_CD,'O',MN.POL_CD,MN.POD_CD)" ).append("\n"); 
		query.append("               AND   VVD.SVC_SCP_CD   = MN.INV_SVC_SCP_CD" ).append("\n"); 
		query.append("			   AND   VVD.AR_OFC_CD  = MN.AR_OFC_CD" ).append("\n"); 
		query.append("               AND   VVD.LOCL_CURR_CD = 'USD'" ).append("\n"); 
		query.append("               AND   MN.AR_IF_NO = CHG2.AR_IF_NO" ).append("\n"); 
		query.append("               AND   VVD.CHG_CURR_CD  = CHG2.CURR_CD" ).append("\n"); 
		query.append("               AND   VVD.INV_XCH_RT <> NVL(CHG2.USD_XCH_RT,0)" ).append("\n"); 
		query.append("               AND   VVD.INV_XCH_RT <> 0 ))" ).append("\n"); 
		query.append("#if (${io_bnd_cd} != '')" ).append("\n"); 
		query.append("   AND MN.IO_BND_CD= @[io_bnd_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(" UNION" ).append("\n"); 
		query.append("SELECT MN.AR_IF_NO," ).append("\n"); 
		query.append("       MN.INV_CUST_CNT_CD,  " ).append("\n"); 
		query.append("       MN.INV_CUST_SEQ, " ).append("\n"); 
		query.append("       MN.AR_OFC_CD, " ).append("\n"); 
		query.append("       MN.LOCL_CURR_CD," ).append("\n"); 
		query.append("       MN.SAIL_DT,  " ).append("\n"); 
		query.append("       MN.VSL_CD, " ).append("\n"); 
		query.append("       MN.SKD_VOY_NO, " ).append("\n"); 
		query.append("       MN.SKD_DIR_CD, " ).append("\n"); 
		query.append("       MN.IO_BND_CD, " ).append("\n"); 
		query.append("       MN.POL_CD, " ).append("\n"); 
		query.append("       MN.POD_CD," ).append("\n"); 
		query.append("       MN.BKG_NO, " ).append("\n"); 
		query.append("       MN.INV_SVC_SCP_CD SVC_SCP_CD," ).append("\n"); 
		query.append("       MN.BL_INV_CFM_DT," ).append("\n"); 
		query.append("       NVL(MN.INV_ISS_FLG,'N') ISS_FLG," ).append("\n"); 
		query.append("       MN.ACT_CUST_CNT_CD," ).append("\n"); 
		query.append("       MN.ACT_CUST_SEQ," ).append("\n"); 
		query.append("       MN.SAIL_ARR_DT," ).append("\n"); 
		query.append("	   MN.REV_TP_CD," ).append("\n"); 
		query.append("       MN.REV_SRC_CD," ).append("\n"); 
		query.append("       MN.BL_SRC_NO," ).append("\n"); 
		query.append("	   OFC.OTS_SMRY_CD," ).append("\n"); 
		query.append("	   OFC.DMDT_AR_INV_ISS_FLG," ).append("\n"); 
		query.append("	   MN.XCH_RT_USD_TP_CD," ).append("\n"); 
		query.append("	   MN.INV_CLR_FLG      " ).append("\n"); 
		query.append("  FROM INV_AR_MN MN," ).append("\n"); 
		query.append("       INV_AR_STUP_OFC OFC" ).append("\n"); 
		query.append(" WHERE MN.AR_OFC_CD = @[ofc_cd]   " ).append("\n"); 
		query.append("   AND MN.VSL_CD = SUBSTR(@[vvd],1,4)" ).append("\n"); 
		query.append("   AND MN.SKD_VOY_NO= SUBSTR(@[vvd],5,4)" ).append("\n"); 
		query.append("   AND MN.SKD_DIR_CD = SUBSTR(@[vvd],9,1)" ).append("\n"); 
		query.append("   AND MN.AR_OFC_CD = OFC.AR_OFC_CD" ).append("\n"); 
		query.append("   --AND NVL(MN.INV_CLR_FLG,'N') ='N'" ).append("\n"); 
		query.append("   AND MN.XCH_RT_USD_TP_CD ='V'" ).append("\n"); 
		query.append("   AND NVL(MN.INV_DELT_DIV_CD,'N') <> 'Y'" ).append("\n"); 
		query.append("   AND MN.BL_INV_CFM_DT IS NOT NULL" ).append("\n"); 
		query.append("   AND MN.OTS_PAY_CD IS NULL AND MN.ORG_INV_NO IS NULL --Except migration data" ).append("\n"); 
		query.append("   AND EXISTS (SELECT 'X' " ).append("\n"); 
		query.append("               FROM INV_VVD_XCH_RT VVD" ).append("\n"); 
		query.append("               WHERE VVD.VSL_CD     = MN.VSL_CD" ).append("\n"); 
		query.append("               AND   VVD.SKD_VOY_NO = MN.SKD_VOY_NO" ).append("\n"); 
		query.append("               AND   VVD.SKD_DIR_CD = MN.SKD_DIR_CD" ).append("\n"); 
		query.append("               AND   VVD.IO_BND_CD  = MN.IO_BND_CD" ).append("\n"); 
		query.append("               AND   VVD.PORT_CD    = DECODE(MN.IO_BND_CD,'O',MN.POL_CD,MN.POD_CD)" ).append("\n"); 
		query.append("               AND   VVD.SVC_SCP_CD   = MN.INV_SVC_SCP_CD" ).append("\n"); 
		query.append("			   AND   VVD.AR_OFC_CD  = MN.AR_OFC_CD" ).append("\n"); 
		query.append("               AND   VVD.LOCL_CURR_CD = MN.LOCL_CURR_CD" ).append("\n"); 
		query.append("               AND   VVD.CHG_CURR_CD  = 'USD'" ).append("\n"); 
		query.append("               AND   VVD.INV_XCH_RT <> NVL(MN.USD_XCH_RT,0)" ).append("\n"); 
		query.append("               AND   VVD.INV_XCH_RT <> 0 )" ).append("\n"); 
		query.append("#if (${io_bnd_cd} != '')" ).append("\n"); 
		query.append("   AND MN.IO_BND_CD= @[io_bnd_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#elseif  (${run_opt} == 'C')" ).append("\n"); 
		query.append("SELECT MN.AR_IF_NO," ).append("\n"); 
		query.append("       MN.INV_CUST_CNT_CD,  " ).append("\n"); 
		query.append("       MN.INV_CUST_SEQ, " ).append("\n"); 
		query.append("       MN.AR_OFC_CD, " ).append("\n"); 
		query.append("       MN.LOCL_CURR_CD," ).append("\n"); 
		query.append("       MN.SAIL_DT,  " ).append("\n"); 
		query.append("       MN.VSL_CD, " ).append("\n"); 
		query.append("       MN.SKD_VOY_NO, " ).append("\n"); 
		query.append("       MN.SKD_DIR_CD, " ).append("\n"); 
		query.append("       MN.IO_BND_CD, " ).append("\n"); 
		query.append("       MN.POL_CD, " ).append("\n"); 
		query.append("       MN.POD_CD," ).append("\n"); 
		query.append("       MN.BKG_NO, " ).append("\n"); 
		query.append("       MN.INV_SVC_SCP_CD SVC_SCP_CD," ).append("\n"); 
		query.append("       MN.BL_INV_CFM_DT," ).append("\n"); 
		query.append("       NVL(MN.INV_ISS_FLG,'N') ISS_FLG," ).append("\n"); 
		query.append("       MN.ACT_CUST_CNT_CD," ).append("\n"); 
		query.append("       MN.ACT_CUST_SEQ," ).append("\n"); 
		query.append("       MN.SAIL_ARR_DT," ).append("\n"); 
		query.append("       MN.REV_TP_CD," ).append("\n"); 
		query.append("       MN.REV_SRC_CD," ).append("\n"); 
		query.append("       MN.BL_SRC_NO," ).append("\n"); 
		query.append("	   OFC.OTS_SMRY_CD," ).append("\n"); 
		query.append("	   OFC.DMDT_AR_INV_ISS_FLG," ).append("\n"); 
		query.append("	   MN.XCH_RT_USD_TP_CD," ).append("\n"); 
		query.append("	   MN.INV_CLR_FLG           " ).append("\n"); 
		query.append("  FROM INV_AR_MN MN," ).append("\n"); 
		query.append("       INV_AR_STUP_OFC OFC," ).append("\n"); 
		query.append("	   MDM_CR_CUST CU," ).append("\n"); 
		query.append("       BKG_BOOKING BO," ).append("\n"); 
		query.append("       BKG_BL_DOC BK," ).append("\n"); 
		query.append("       BKG_RATE RT" ).append("\n"); 
		query.append(" WHERE MN.AR_OFC_CD = @[ofc_cd]   " ).append("\n"); 
		query.append("   AND MN.INV_CUST_CNT_CD = @[inv_cust_cnt_cd]" ).append("\n"); 
		query.append("   AND MN.INV_CUST_SEQ= @[inv_cust_seq]" ).append("\n"); 
		query.append("   AND MN.AR_OFC_CD = OFC.AR_OFC_CD" ).append("\n"); 
		query.append("   AND MN.INV_CUST_CNT_CD = CU.CUST_CNT_CD" ).append("\n"); 
		query.append("   AND MN.INV_CUST_SEQ = CU.CUST_SEQ" ).append("\n"); 
		query.append("   AND MN.BL_SRC_NO = BO.BL_NO(+)" ).append("\n"); 
		query.append("   AND BO.BKG_NO = BK.BKG_NO(+)" ).append("\n"); 
		query.append("   AND BO.BKG_NO = RT.BKG_NO(+)" ).append("\n"); 
		query.append("   AND NVL(MN.INV_DELT_DIV_CD,'N') <> 'Y'" ).append("\n"); 
		query.append("   AND MN.BL_INV_CFM_DT IS NOT NULL" ).append("\n"); 
		query.append("   AND MN.XCH_RT_USD_TP_CD ='I'" ).append("\n"); 
		query.append("   AND MN.OTS_PAY_CD IS NULL AND MN.ORG_INV_NO IS NULL --Except migration data" ).append("\n"); 
		query.append("   AND DECODE(CU.CNG_INDIV_CD, 'B', TO_CHAR(BK.BL_OBRD_DT,'YYYYMMDD'), 'C', TO_CHAR(RT.CGO_RCV_DT,'YYYYMMDD'), 'O', MN.SAIL_DT, MN.SAIL_ARR_DT ) BETWEEN REPLACE(@[fm_if_dt],'-','') AND REPLACE(@[to_if_dt],'-','') " ).append("\n"); 
		query.append("   AND (EXISTS (SELECT 'X' " ).append("\n"); 
		query.append("               FROM INV_CUST_AND_DLY_XCH_RT CUST, INV_AR_CHG CHG2" ).append("\n"); 
		query.append("               WHERE CUST.CUST_CNT_CD = MN.INV_CUST_CNT_CD" ).append("\n"); 
		query.append("               AND   CUST.CUST_SEQ     = MN.INV_CUST_SEQ" ).append("\n"); 
		query.append("               AND   CUST.IO_BND_CD   = MN.IO_BND_CD" ).append("\n"); 
		query.append("               AND	 XCH_RT_TP_CD = 'I'" ).append("\n"); 
		query.append("               AND   DECODE(CU.CNG_INDIV_CD, 'B', TO_CHAR(BK.BL_OBRD_DT,'YYYYMMDD'), 'C', TO_CHAR(RT.CGO_RCV_DT,'YYYYMMDD'), 'O', MN.SAIL_DT, MN.SAIL_ARR_DT ) between FM_DT and TO_DT" ).append("\n"); 
		query.append("               AND   CUST.LOCL_CURR_CD = MN.LOCL_CURR_CD" ).append("\n"); 
		query.append("               AND   MN.AR_IF_NO = CHG2.AR_IF_NO" ).append("\n"); 
		query.append("               AND   CUST.CHG_CURR_CD  = CHG2.CURR_CD" ).append("\n"); 
		query.append("               AND   CUST.INV_XCH_RT <> NVL(CHG2.INV_XCH_RT,0)" ).append("\n"); 
		query.append("               AND   CUST.INV_XCH_RT <> 0 )" ).append("\n"); 
		query.append("	OR EXISTS (SELECT 'X' " ).append("\n"); 
		query.append("               FROM INV_CUST_AND_DLY_XCH_RT CUST, INV_AR_CHG CHG2" ).append("\n"); 
		query.append("               WHERE CUST.CUST_CNT_CD = MN.INV_CUST_CNT_CD" ).append("\n"); 
		query.append("               AND   CUST.CUST_SEQ     = MN.INV_CUST_SEQ" ).append("\n"); 
		query.append("               AND   CUST.IO_BND_CD   = MN.IO_BND_CD" ).append("\n"); 
		query.append("               AND	 XCH_RT_TP_CD = 'I'" ).append("\n"); 
		query.append("               AND   DECODE(CU.CNG_INDIV_CD, 'B', TO_CHAR(BK.BL_OBRD_DT,'YYYYMMDD'), 'C', TO_CHAR(RT.CGO_RCV_DT,'YYYYMMDD'), 'O', MN.SAIL_DT, MN.SAIL_ARR_DT ) between FM_DT and TO_DT" ).append("\n"); 
		query.append("               AND   CUST.LOCL_CURR_CD = 'USD'" ).append("\n"); 
		query.append("               AND   MN.AR_IF_NO = CHG2.AR_IF_NO" ).append("\n"); 
		query.append("               AND   CUST.CHG_CURR_CD  = CHG2.CURR_CD" ).append("\n"); 
		query.append("               AND   CUST.INV_XCH_RT <> NVL(CHG2.USD_XCH_RT,0)" ).append("\n"); 
		query.append("               AND   CUST.INV_XCH_RT <> 0 )" ).append("\n"); 
		query.append("	OR EXISTS (SELECT 'X' " ).append("\n"); 
		query.append("               FROM INV_CUST_AND_DLY_XCH_RT CUST" ).append("\n"); 
		query.append("               WHERE CUST.CUST_CNT_CD = MN.INV_CUST_CNT_CD" ).append("\n"); 
		query.append("               AND   CUST.CUST_SEQ     = MN.INV_CUST_SEQ" ).append("\n"); 
		query.append("               AND   CUST.IO_BND_CD   = MN.IO_BND_CD" ).append("\n"); 
		query.append("               AND	 XCH_RT_TP_CD = 'I'" ).append("\n"); 
		query.append("               AND   DECODE(CU.CNG_INDIV_CD, 'B', TO_CHAR(BK.BL_OBRD_DT,'YYYYMMDD'), 'C', TO_CHAR(RT.CGO_RCV_DT,'YYYYMMDD'), 'O', MN.SAIL_DT, MN.SAIL_ARR_DT ) between FM_DT and TO_DT" ).append("\n"); 
		query.append("               AND   CUST.LOCL_CURR_CD = MN.LOCL_CURR_CD" ).append("\n"); 
		query.append("               AND   CUST.CHG_CURR_CD  = 'USD'" ).append("\n"); 
		query.append("               AND   CUST.INV_XCH_RT <> NVL(MN.USD_XCH_RT,0)" ).append("\n"); 
		query.append("               AND   CUST.INV_XCH_RT <> 0 ))" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#elseif  (${run_opt} == 'B')" ).append("\n"); 
		query.append("SELECT MN.AR_IF_NO," ).append("\n"); 
		query.append("       MN.INV_CUST_CNT_CD,  " ).append("\n"); 
		query.append("       MN.INV_CUST_SEQ, " ).append("\n"); 
		query.append("       MN.AR_OFC_CD, " ).append("\n"); 
		query.append("       MN.LOCL_CURR_CD," ).append("\n"); 
		query.append("       MN.SAIL_DT,  " ).append("\n"); 
		query.append("       MN.VSL_CD, " ).append("\n"); 
		query.append("       MN.SKD_VOY_NO, " ).append("\n"); 
		query.append("       MN.SKD_DIR_CD, " ).append("\n"); 
		query.append("       MN.IO_BND_CD, " ).append("\n"); 
		query.append("       MN.POL_CD, " ).append("\n"); 
		query.append("       MN.POD_CD," ).append("\n"); 
		query.append("       MN.BKG_NO, " ).append("\n"); 
		query.append("       MN.INV_SVC_SCP_CD SVC_SCP_CD," ).append("\n"); 
		query.append("       MN.BL_INV_CFM_DT," ).append("\n"); 
		query.append("       NVL(MN.INV_ISS_FLG,'N') ISS_FLG," ).append("\n"); 
		query.append("       MN.ACT_CUST_CNT_CD," ).append("\n"); 
		query.append("       MN.ACT_CUST_SEQ," ).append("\n"); 
		query.append("       MN.SAIL_ARR_DT," ).append("\n"); 
		query.append("       MN.REV_TP_CD," ).append("\n"); 
		query.append("       MN.REV_SRC_CD," ).append("\n"); 
		query.append("       MN.BL_SRC_NO," ).append("\n"); 
		query.append("	   OFC.OTS_SMRY_CD," ).append("\n"); 
		query.append("	   OFC.DMDT_AR_INV_ISS_FLG," ).append("\n"); 
		query.append("	   MN.XCH_RT_USD_TP_CD," ).append("\n"); 
		query.append("	   MN.INV_CLR_FLG           " ).append("\n"); 
		query.append("  FROM INV_AR_MN MN," ).append("\n"); 
		query.append("       INV_AR_STUP_OFC OFC" ).append("\n"); 
		query.append(" WHERE MN.AR_OFC_CD = @[ofc_cd]   " ).append("\n"); 
		query.append("   AND MN.BL_SRC_NO = @[bl_src_no]" ).append("\n"); 
		query.append("   AND MN.AR_OFC_CD = OFC.AR_OFC_CD" ).append("\n"); 
		query.append("   --AND NVL(MN.INV_CLR_FLG,'N') ='N'" ).append("\n"); 
		query.append("   AND MN.XCH_RT_USD_TP_CD ='V'" ).append("\n"); 
		query.append("   AND NVL(MN.INV_DELT_DIV_CD,'N') <> 'Y'" ).append("\n"); 
		query.append("   AND MN.BL_INV_CFM_DT IS NOT NULL" ).append("\n"); 
		query.append("   AND MN.OTS_PAY_CD IS NULL AND MN.ORG_INV_NO IS NULL --Except migration data" ).append("\n"); 
		query.append("   AND (EXISTS (SELECT 'X' " ).append("\n"); 
		query.append("               FROM INV_VVD_XCH_RT VVD, INV_AR_CHG CHG2" ).append("\n"); 
		query.append("               WHERE VVD.VSL_CD     = MN.VSL_CD" ).append("\n"); 
		query.append("               AND   VVD.SKD_VOY_NO = MN.SKD_VOY_NO" ).append("\n"); 
		query.append("               AND   VVD.SKD_DIR_CD = MN.SKD_DIR_CD" ).append("\n"); 
		query.append("               AND   VVD.IO_BND_CD  = MN.IO_BND_CD" ).append("\n"); 
		query.append("               AND   VVD.PORT_CD    = DECODE(MN.IO_BND_CD,'O',MN.POL_CD,MN.POD_CD)" ).append("\n"); 
		query.append("               AND   VVD.SVC_SCP_CD   = MN.INV_SVC_SCP_CD" ).append("\n"); 
		query.append("			   AND   VVD.AR_OFC_CD  = MN.AR_OFC_CD" ).append("\n"); 
		query.append("               AND   VVD.LOCL_CURR_CD = MN.LOCL_CURR_CD" ).append("\n"); 
		query.append("               AND   MN.AR_IF_NO = CHG2.AR_IF_NO" ).append("\n"); 
		query.append("               AND   VVD.CHG_CURR_CD  = CHG2.CURR_CD" ).append("\n"); 
		query.append("               AND   VVD.INV_XCH_RT <> NVL(CHG2.INV_XCH_RT,0) " ).append("\n"); 
		query.append("			   AND   VVD.INV_XCH_RT <> 0 )" ).append("\n"); 
		query.append("	OR EXISTS (SELECT 'X' " ).append("\n"); 
		query.append("               FROM INV_VVD_XCH_RT VVD, INV_AR_CHG CHG2" ).append("\n"); 
		query.append("               WHERE VVD.VSL_CD     = MN.VSL_CD" ).append("\n"); 
		query.append("               AND   VVD.SKD_VOY_NO = MN.SKD_VOY_NO" ).append("\n"); 
		query.append("               AND   VVD.SKD_DIR_CD = MN.SKD_DIR_CD" ).append("\n"); 
		query.append("               AND   VVD.IO_BND_CD  = MN.IO_BND_CD" ).append("\n"); 
		query.append("               AND   VVD.PORT_CD    = DECODE(MN.IO_BND_CD,'O',MN.POL_CD,MN.POD_CD)" ).append("\n"); 
		query.append("               AND   VVD.SVC_SCP_CD   = MN.INV_SVC_SCP_CD" ).append("\n"); 
		query.append("			   AND   VVD.AR_OFC_CD  = MN.AR_OFC_CD" ).append("\n"); 
		query.append("               AND   VVD.LOCL_CURR_CD = 'USD'" ).append("\n"); 
		query.append("               AND   MN.AR_IF_NO = CHG2.AR_IF_NO" ).append("\n"); 
		query.append("               AND   VVD.CHG_CURR_CD  = CHG2.CURR_CD" ).append("\n"); 
		query.append("               AND   VVD.INV_XCH_RT <> NVL(CHG2.USD_XCH_RT,0) " ).append("\n"); 
		query.append("			   AND   VVD.INV_XCH_RT <> 0 ))" ).append("\n"); 
		query.append(" UNION" ).append("\n"); 
		query.append("SELECT MN.AR_IF_NO," ).append("\n"); 
		query.append("       MN.INV_CUST_CNT_CD,  " ).append("\n"); 
		query.append("       MN.INV_CUST_SEQ, " ).append("\n"); 
		query.append("       MN.AR_OFC_CD, " ).append("\n"); 
		query.append("       MN.LOCL_CURR_CD," ).append("\n"); 
		query.append("       MN.SAIL_DT,  " ).append("\n"); 
		query.append("       MN.VSL_CD, " ).append("\n"); 
		query.append("       MN.SKD_VOY_NO, " ).append("\n"); 
		query.append("       MN.SKD_DIR_CD, " ).append("\n"); 
		query.append("       MN.IO_BND_CD, " ).append("\n"); 
		query.append("       MN.POL_CD, " ).append("\n"); 
		query.append("       MN.POD_CD," ).append("\n"); 
		query.append("       MN.BKG_NO, " ).append("\n"); 
		query.append("       MN.INV_SVC_SCP_CD SVC_SCP_CD," ).append("\n"); 
		query.append("       MN.BL_INV_CFM_DT," ).append("\n"); 
		query.append("       NVL(MN.INV_ISS_FLG,'N') ISS_FLG," ).append("\n"); 
		query.append("       MN.ACT_CUST_CNT_CD," ).append("\n"); 
		query.append("       MN.ACT_CUST_SEQ," ).append("\n"); 
		query.append("       MN.SAIL_ARR_DT," ).append("\n"); 
		query.append("	   MN.REV_TP_CD," ).append("\n"); 
		query.append("       MN.REV_SRC_CD," ).append("\n"); 
		query.append("       MN.BL_SRC_NO," ).append("\n"); 
		query.append("	   OFC.OTS_SMRY_CD," ).append("\n"); 
		query.append("	   OFC.DMDT_AR_INV_ISS_FLG," ).append("\n"); 
		query.append("	   MN.XCH_RT_USD_TP_CD," ).append("\n"); 
		query.append("	   MN.INV_CLR_FLG           " ).append("\n"); 
		query.append("  FROM INV_AR_MN MN," ).append("\n"); 
		query.append("       INV_AR_STUP_OFC OFC" ).append("\n"); 
		query.append(" WHERE MN.AR_OFC_CD = @[ofc_cd]  " ).append("\n"); 
		query.append("   AND MN.BL_SRC_NO = @[bl_src_no]" ).append("\n"); 
		query.append("   AND MN.AR_OFC_CD = OFC.AR_OFC_CD" ).append("\n"); 
		query.append("   --AND NVL(MN.INV_CLR_FLG,'N') ='N'" ).append("\n"); 
		query.append("   AND MN.XCH_RT_USD_TP_CD ='V'" ).append("\n"); 
		query.append("   AND NVL(MN.INV_DELT_DIV_CD,'N') <> 'Y'" ).append("\n"); 
		query.append("   AND MN.BL_INV_CFM_DT IS NOT NULL" ).append("\n"); 
		query.append("   AND MN.OTS_PAY_CD IS NULL AND MN.ORG_INV_NO IS NULL --Except migration data" ).append("\n"); 
		query.append("   AND EXISTS (SELECT 'X' " ).append("\n"); 
		query.append("               FROM INV_VVD_XCH_RT VVD" ).append("\n"); 
		query.append("               WHERE VVD.VSL_CD     = MN.VSL_CD" ).append("\n"); 
		query.append("               AND   VVD.SKD_VOY_NO = MN.SKD_VOY_NO" ).append("\n"); 
		query.append("               AND   VVD.SKD_DIR_CD = MN.SKD_DIR_CD" ).append("\n"); 
		query.append("               AND   VVD.IO_BND_CD  = MN.IO_BND_CD" ).append("\n"); 
		query.append("               AND   VVD.PORT_CD    = DECODE(MN.IO_BND_CD,'O',MN.POL_CD,MN.POD_CD)" ).append("\n"); 
		query.append("               AND   VVD.SVC_SCP_CD   = MN.INV_SVC_SCP_CD" ).append("\n"); 
		query.append("			   AND   VVD.AR_OFC_CD  = MN.AR_OFC_CD" ).append("\n"); 
		query.append("               AND   VVD.LOCL_CURR_CD = MN.LOCL_CURR_CD" ).append("\n"); 
		query.append("               AND   VVD.CHG_CURR_CD  = 'USD'" ).append("\n"); 
		query.append("               AND   VVD.INV_XCH_RT <> NVL(MN.USD_XCH_RT,0)" ).append("\n"); 
		query.append("               AND   VVD.INV_XCH_RT <> 0 )" ).append("\n"); 
		query.append(" UNION" ).append("\n"); 
		query.append("SELECT MN.AR_IF_NO," ).append("\n"); 
		query.append("       MN.INV_CUST_CNT_CD,  " ).append("\n"); 
		query.append("       MN.INV_CUST_SEQ, " ).append("\n"); 
		query.append("       MN.AR_OFC_CD, " ).append("\n"); 
		query.append("       MN.LOCL_CURR_CD," ).append("\n"); 
		query.append("       MN.SAIL_DT,  " ).append("\n"); 
		query.append("       MN.VSL_CD, " ).append("\n"); 
		query.append("       MN.SKD_VOY_NO, " ).append("\n"); 
		query.append("       MN.SKD_DIR_CD, " ).append("\n"); 
		query.append("       MN.IO_BND_CD, " ).append("\n"); 
		query.append("       MN.POL_CD, " ).append("\n"); 
		query.append("       MN.POD_CD," ).append("\n"); 
		query.append("       MN.BKG_NO, " ).append("\n"); 
		query.append("       MN.INV_SVC_SCP_CD SVC_SCP_CD," ).append("\n"); 
		query.append("       MN.BL_INV_CFM_DT," ).append("\n"); 
		query.append("       NVL(MN.INV_ISS_FLG,'N') ISS_FLG," ).append("\n"); 
		query.append("       MN.ACT_CUST_CNT_CD," ).append("\n"); 
		query.append("       MN.ACT_CUST_SEQ," ).append("\n"); 
		query.append("       MN.SAIL_ARR_DT," ).append("\n"); 
		query.append("       MN.REV_TP_CD," ).append("\n"); 
		query.append("       MN.REV_SRC_CD," ).append("\n"); 
		query.append("       MN.BL_SRC_NO," ).append("\n"); 
		query.append("	   OFC.OTS_SMRY_CD," ).append("\n"); 
		query.append("	   OFC.DMDT_AR_INV_ISS_FLG," ).append("\n"); 
		query.append("	   MN.XCH_RT_USD_TP_CD," ).append("\n"); 
		query.append("	   MN.INV_CLR_FLG           " ).append("\n"); 
		query.append("  FROM INV_AR_MN MN," ).append("\n"); 
		query.append("       INV_AR_STUP_OFC OFC" ).append("\n"); 
		query.append(" WHERE MN.AR_OFC_CD = @[ofc_cd]   " ).append("\n"); 
		query.append("   AND MN.BL_SRC_NO = @[bl_src_no]" ).append("\n"); 
		query.append("   AND MN.AR_OFC_CD = OFC.AR_OFC_CD" ).append("\n"); 
		query.append("   --AND NVL(MN.INV_CLR_FLG,'N') ='N'" ).append("\n"); 
		query.append("   AND NVL(MN.INV_DELT_DIV_CD,'N') <> 'Y'" ).append("\n"); 
		query.append("   AND MN.BL_INV_CFM_DT IS NOT NULL" ).append("\n"); 
		query.append("   AND MN.XCH_RT_USD_TP_CD ='I'" ).append("\n"); 
		query.append("   AND MN.OTS_PAY_CD IS NULL AND MN.ORG_INV_NO IS NULL --Except migration data" ).append("\n"); 
		query.append("   AND (EXISTS (SELECT 'X' " ).append("\n"); 
		query.append("               FROM INV_CUST_AND_DLY_XCH_RT CUST, INV_AR_CHG CHG2" ).append("\n"); 
		query.append("               WHERE CUST.CUST_CNT_CD = MN.INV_CUST_CNT_CD" ).append("\n"); 
		query.append("               AND   CUST.CUST_SEQ     = MN.INV_CUST_SEQ" ).append("\n"); 
		query.append("               AND   CUST.IO_BND_CD   = MN.IO_BND_CD" ).append("\n"); 
		query.append("               AND	 XCH_RT_TP_CD = 'I'" ).append("\n"); 
		query.append("               AND   MN.XCH_RT_DT BETWEEN FM_DT AND TO_DT" ).append("\n"); 
		query.append("               AND   CUST.LOCL_CURR_CD = MN.LOCL_CURR_CD" ).append("\n"); 
		query.append("               AND   MN.AR_IF_NO = CHG2.AR_IF_NO" ).append("\n"); 
		query.append("               AND   CUST.CHG_CURR_CD  = CHG2.CURR_CD" ).append("\n"); 
		query.append("               AND   CUST.INV_XCH_RT <> NVL(CHG2.INV_XCH_RT,0)" ).append("\n"); 
		query.append("               AND   CUST.INV_XCH_RT <> 0 )" ).append("\n"); 
		query.append("	OR EXISTS (SELECT 'X' " ).append("\n"); 
		query.append("               FROM INV_CUST_AND_DLY_XCH_RT CUST, INV_AR_CHG CHG2" ).append("\n"); 
		query.append("               WHERE CUST.CUST_CNT_CD = MN.INV_CUST_CNT_CD" ).append("\n"); 
		query.append("               AND   CUST.CUST_SEQ     = MN.INV_CUST_SEQ" ).append("\n"); 
		query.append("               AND   CUST.IO_BND_CD   = MN.IO_BND_CD" ).append("\n"); 
		query.append("               AND	 XCH_RT_TP_CD = 'I'" ).append("\n"); 
		query.append("               AND   MN.XCH_RT_DT BETWEEN FM_DT AND TO_DT" ).append("\n"); 
		query.append("               AND   CUST.LOCL_CURR_CD = 'USD'" ).append("\n"); 
		query.append("               AND   MN.AR_IF_NO = CHG2.AR_IF_NO" ).append("\n"); 
		query.append("               AND   CUST.CHG_CURR_CD  = CHG2.CURR_CD" ).append("\n"); 
		query.append("               AND   CUST.INV_XCH_RT <> NVL(CHG2.USD_XCH_RT,0)" ).append("\n"); 
		query.append("               AND   CUST.INV_XCH_RT <> 0 ))" ).append("\n"); 
		query.append(" UNION" ).append("\n"); 
		query.append("SELECT MN.AR_IF_NO," ).append("\n"); 
		query.append("       MN.INV_CUST_CNT_CD,  " ).append("\n"); 
		query.append("       MN.INV_CUST_SEQ, " ).append("\n"); 
		query.append("       MN.AR_OFC_CD, " ).append("\n"); 
		query.append("       MN.LOCL_CURR_CD," ).append("\n"); 
		query.append("       MN.SAIL_DT,  " ).append("\n"); 
		query.append("       MN.VSL_CD, " ).append("\n"); 
		query.append("       MN.SKD_VOY_NO, " ).append("\n"); 
		query.append("       MN.SKD_DIR_CD, " ).append("\n"); 
		query.append("       MN.IO_BND_CD, " ).append("\n"); 
		query.append("       MN.POL_CD, " ).append("\n"); 
		query.append("       MN.POD_CD," ).append("\n"); 
		query.append("       MN.BKG_NO, " ).append("\n"); 
		query.append("       MN.INV_SVC_SCP_CD SVC_SCP_CD," ).append("\n"); 
		query.append("       MN.BL_INV_CFM_DT," ).append("\n"); 
		query.append("       NVL(MN.INV_ISS_FLG,'N') ISS_FLG," ).append("\n"); 
		query.append("       MN.ACT_CUST_CNT_CD," ).append("\n"); 
		query.append("       MN.ACT_CUST_SEQ," ).append("\n"); 
		query.append("       MN.SAIL_ARR_DT," ).append("\n"); 
		query.append("       MN.REV_TP_CD," ).append("\n"); 
		query.append("       MN.REV_SRC_CD," ).append("\n"); 
		query.append("       MN.BL_SRC_NO," ).append("\n"); 
		query.append("	   OFC.OTS_SMRY_CD," ).append("\n"); 
		query.append("	   OFC.DMDT_AR_INV_ISS_FLG," ).append("\n"); 
		query.append("	   MN.XCH_RT_USD_TP_CD," ).append("\n"); 
		query.append("	   MN.INV_CLR_FLG           " ).append("\n"); 
		query.append("  FROM INV_AR_MN MN," ).append("\n"); 
		query.append("       INV_AR_STUP_OFC OFC" ).append("\n"); 
		query.append(" WHERE MN.AR_OFC_CD = @[ofc_cd]   " ).append("\n"); 
		query.append("   AND MN.BL_SRC_NO = @[bl_src_no]" ).append("\n"); 
		query.append("   AND MN.AR_OFC_CD = OFC.AR_OFC_CD" ).append("\n"); 
		query.append("   --AND NVL(MN.INV_CLR_FLG,'N') ='N'" ).append("\n"); 
		query.append("   AND NVL(MN.INV_DELT_DIV_CD,'N') <> 'Y'" ).append("\n"); 
		query.append("   AND MN.BL_INV_CFM_DT IS NOT NULL" ).append("\n"); 
		query.append("   AND MN.XCH_RT_USD_TP_CD ='I'" ).append("\n"); 
		query.append("   AND MN.OTS_PAY_CD IS NULL AND MN.ORG_INV_NO IS NULL --Except migration data" ).append("\n"); 
		query.append("   AND EXISTS (SELECT 'X' " ).append("\n"); 
		query.append("               FROM INV_CUST_AND_DLY_XCH_RT CUST" ).append("\n"); 
		query.append("               WHERE CUST.CUST_CNT_CD = MN.INV_CUST_CNT_CD" ).append("\n"); 
		query.append("               AND   CUST.CUST_SEQ     = MN.INV_CUST_SEQ" ).append("\n"); 
		query.append("               AND   CUST.IO_BND_CD   = MN.IO_BND_CD" ).append("\n"); 
		query.append("               AND	 XCH_RT_TP_CD = 'I'" ).append("\n"); 
		query.append("               AND   MN.XCH_RT_DT BETWEEN FM_DT AND TO_DT" ).append("\n"); 
		query.append("               AND   CUST.LOCL_CURR_CD = MN.LOCL_CURR_CD" ).append("\n"); 
		query.append("               AND   CUST.CHG_CURR_CD  = 'USD'" ).append("\n"); 
		query.append("               AND   CUST.INV_XCH_RT <> NVL(MN.USD_XCH_RT,0)" ).append("\n"); 
		query.append("               AND   CUST.INV_XCH_RT <> 0 )" ).append("\n"); 
		query.append("UNION" ).append("\n"); 
		query.append("SELECT MN.AR_IF_NO," ).append("\n"); 
		query.append("       MN.INV_CUST_CNT_CD,  " ).append("\n"); 
		query.append("       MN.INV_CUST_SEQ, " ).append("\n"); 
		query.append("       MN.AR_OFC_CD, " ).append("\n"); 
		query.append("       MN.LOCL_CURR_CD," ).append("\n"); 
		query.append("       MN.SAIL_DT,  " ).append("\n"); 
		query.append("       MN.VSL_CD, " ).append("\n"); 
		query.append("       MN.SKD_VOY_NO, " ).append("\n"); 
		query.append("       MN.SKD_DIR_CD, " ).append("\n"); 
		query.append("       MN.IO_BND_CD, " ).append("\n"); 
		query.append("       MN.POL_CD, " ).append("\n"); 
		query.append("       MN.POD_CD," ).append("\n"); 
		query.append("       MN.BKG_NO, " ).append("\n"); 
		query.append("       MN.INV_SVC_SCP_CD SVC_SCP_CD," ).append("\n"); 
		query.append("       MN.BL_INV_CFM_DT," ).append("\n"); 
		query.append("       NVL(MN.INV_ISS_FLG,'N') ISS_FLG," ).append("\n"); 
		query.append("       MN.ACT_CUST_CNT_CD," ).append("\n"); 
		query.append("       MN.ACT_CUST_SEQ," ).append("\n"); 
		query.append("       MN.SAIL_ARR_DT," ).append("\n"); 
		query.append("       MN.REV_TP_CD," ).append("\n"); 
		query.append("       MN.REV_SRC_CD," ).append("\n"); 
		query.append("       MN.BL_SRC_NO," ).append("\n"); 
		query.append("	   OFC.OTS_SMRY_CD," ).append("\n"); 
		query.append("	   OFC.DMDT_AR_INV_ISS_FLG," ).append("\n"); 
		query.append("	   MN.XCH_RT_USD_TP_CD," ).append("\n"); 
		query.append("	   MN.INV_CLR_FLG           " ).append("\n"); 
		query.append("  FROM INV_AR_MN MN," ).append("\n"); 
		query.append("       INV_AR_STUP_OFC OFC" ).append("\n"); 
		query.append(" WHERE MN.AR_OFC_CD = @[ofc_cd]   " ).append("\n"); 
		query.append("   AND MN.BL_SRC_NO = @[bl_src_no]" ).append("\n"); 
		query.append("   AND MN.AR_OFC_CD = OFC.AR_OFC_CD" ).append("\n"); 
		query.append("   AND NVL(MN.INV_DELT_DIV_CD,'N') <> 'Y'" ).append("\n"); 
		query.append("   AND MN.BL_INV_CFM_DT IS NOT NULL" ).append("\n"); 
		query.append("   AND MN.XCH_RT_USD_TP_CD = 'D'" ).append("\n"); 
		query.append("   AND MN.OTS_PAY_CD IS NULL AND MN.ORG_INV_NO IS NULL --Except migration data" ).append("\n"); 
		query.append("   AND (EXISTS (SELECT 'X' " ).append("\n"); 
		query.append("               FROM INV_CUST_AND_DLY_XCH_RT CUST, INV_AR_CHG CHG2" ).append("\n"); 
		query.append("               WHERE CUST.CUST_CNT_CD = 'XX'" ).append("\n"); 
		query.append("               AND   CUST.CUST_SEQ  = '0'" ).append("\n"); 
		query.append("               AND   CUST.IO_BND_CD   = MN.IO_BND_CD" ).append("\n"); 
		query.append("               AND	 XCH_RT_TP_CD = 'D'" ).append("\n"); 
		query.append("               AND   MN.XCH_RT_DT BETWEEN FM_DT AND TO_DT" ).append("\n"); 
		query.append("               AND   CUST.LOCL_CURR_CD = MN.LOCL_CURR_CD" ).append("\n"); 
		query.append("               AND   MN.AR_IF_NO = CHG2.AR_IF_NO" ).append("\n"); 
		query.append("			   AND   CUST.AR_OFC_CD = MN.AR_OFC_CD" ).append("\n"); 
		query.append("               AND   CUST.CHG_CURR_CD  = CHG2.CURR_CD" ).append("\n"); 
		query.append("               AND   CUST.INV_XCH_RT <> NVL(CHG2.INV_XCH_RT,0)" ).append("\n"); 
		query.append("               AND   CUST.INV_XCH_RT <> 0 )" ).append("\n"); 
		query.append("	OR EXISTS (SELECT 'X' " ).append("\n"); 
		query.append("               FROM INV_CUST_AND_DLY_XCH_RT CUST, INV_AR_CHG CHG2" ).append("\n"); 
		query.append("               WHERE CUST.CUST_CNT_CD = 'XX'" ).append("\n"); 
		query.append("               AND   CUST.CUST_SEQ  = '0'" ).append("\n"); 
		query.append("               AND   CUST.IO_BND_CD   = MN.IO_BND_CD" ).append("\n"); 
		query.append("               AND	 XCH_RT_TP_CD = 'D'" ).append("\n"); 
		query.append("               AND   MN.XCH_RT_DT BETWEEN FM_DT AND TO_DT" ).append("\n"); 
		query.append("               AND   CUST.LOCL_CURR_CD = 'USD'" ).append("\n"); 
		query.append("               AND   MN.AR_IF_NO = CHG2.AR_IF_NO" ).append("\n"); 
		query.append("			   AND   CUST.AR_OFC_CD = MN.AR_OFC_CD" ).append("\n"); 
		query.append("               AND   CUST.CHG_CURR_CD  = CHG2.CURR_CD" ).append("\n"); 
		query.append("               AND   CUST.INV_XCH_RT <> NVL(CHG2.USD_XCH_RT,0)" ).append("\n"); 
		query.append("               AND   CUST.INV_XCH_RT <> 0 ))" ).append("\n"); 
		query.append("UNION" ).append("\n"); 
		query.append("SELECT MN.AR_IF_NO," ).append("\n"); 
		query.append("       MN.INV_CUST_CNT_CD,  " ).append("\n"); 
		query.append("       MN.INV_CUST_SEQ, " ).append("\n"); 
		query.append("       MN.AR_OFC_CD, " ).append("\n"); 
		query.append("       MN.LOCL_CURR_CD," ).append("\n"); 
		query.append("       MN.SAIL_DT,  " ).append("\n"); 
		query.append("       MN.VSL_CD, " ).append("\n"); 
		query.append("       MN.SKD_VOY_NO, " ).append("\n"); 
		query.append("       MN.SKD_DIR_CD, " ).append("\n"); 
		query.append("       MN.IO_BND_CD, " ).append("\n"); 
		query.append("       MN.POL_CD, " ).append("\n"); 
		query.append("       MN.POD_CD," ).append("\n"); 
		query.append("       MN.BKG_NO, " ).append("\n"); 
		query.append("       MN.INV_SVC_SCP_CD SVC_SCP_CD," ).append("\n"); 
		query.append("       MN.BL_INV_CFM_DT," ).append("\n"); 
		query.append("       NVL(MN.INV_ISS_FLG,'N') ISS_FLG," ).append("\n"); 
		query.append("       MN.ACT_CUST_CNT_CD," ).append("\n"); 
		query.append("       MN.ACT_CUST_SEQ," ).append("\n"); 
		query.append("       MN.SAIL_ARR_DT," ).append("\n"); 
		query.append("       MN.REV_TP_CD," ).append("\n"); 
		query.append("       MN.REV_SRC_CD," ).append("\n"); 
		query.append("       MN.BL_SRC_NO," ).append("\n"); 
		query.append("	   OFC.OTS_SMRY_CD," ).append("\n"); 
		query.append("	   OFC.DMDT_AR_INV_ISS_FLG," ).append("\n"); 
		query.append("	   MN.XCH_RT_USD_TP_CD," ).append("\n"); 
		query.append("	   MN.INV_CLR_FLG           " ).append("\n"); 
		query.append("  FROM INV_AR_MN MN," ).append("\n"); 
		query.append("       INV_AR_STUP_OFC OFC" ).append("\n"); 
		query.append(" WHERE MN.AR_OFC_CD = @[ofc_cd]  " ).append("\n"); 
		query.append("   AND MN.BL_SRC_NO = @[bl_src_no]" ).append("\n"); 
		query.append("   AND MN.AR_OFC_CD = OFC.AR_OFC_CD" ).append("\n"); 
		query.append("   AND NVL(MN.INV_DELT_DIV_CD,'N') <> 'Y'" ).append("\n"); 
		query.append("   AND MN.BL_INV_CFM_DT IS NOT NULL" ).append("\n"); 
		query.append("   AND MN.XCH_RT_USD_TP_CD = 'D'" ).append("\n"); 
		query.append("   AND MN.OTS_PAY_CD IS NULL AND MN.ORG_INV_NO IS NULL --Except migration data" ).append("\n"); 
		query.append("   AND EXISTS (SELECT 'X' " ).append("\n"); 
		query.append("               FROM INV_CUST_AND_DLY_XCH_RT CUST" ).append("\n"); 
		query.append("               WHERE CUST.CUST_CNT_CD = 'XX'" ).append("\n"); 
		query.append("               AND   CUST.CUST_SEQ  = '0'" ).append("\n"); 
		query.append("               AND   CUST.IO_BND_CD   = MN.IO_BND_CD" ).append("\n"); 
		query.append("               AND	 XCH_RT_TP_CD = 'D'" ).append("\n"); 
		query.append("               AND   MN.XCH_RT_DT BETWEEN FM_DT AND TO_DT" ).append("\n"); 
		query.append("			   AND   CUST.AR_OFC_CD = MN.AR_OFC_CD" ).append("\n"); 
		query.append("               AND   CUST.LOCL_CURR_CD = MN.LOCL_CURR_CD" ).append("\n"); 
		query.append("               AND   CUST.CHG_CURR_CD  = 'USD'" ).append("\n"); 
		query.append("               AND   CUST.INV_XCH_RT <> NVL(MN.USD_XCH_RT,0)" ).append("\n"); 
		query.append("               AND   CUST.INV_XCH_RT <> 0 )" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}