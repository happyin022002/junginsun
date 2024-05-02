/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : ChargeCalculationDBDAOSearchBookingInfoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.06.08
*@LastModifier : 
*@LastVersion : 1.0
* 2017.06.08 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.dmt.dmtclosing.chargecalculation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ChargeCalculationDBDAOSearchBookingInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ChargeCalculationDBDAOSearchBookingInfoRSQL
	  * </pre>
	  */
	public ChargeCalculationDBDAOSearchBookingInfoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("tpb_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dmdt_inv_no",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("curr_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("Path : com.hanjin.apps.alps.ees.dmt.dmtclosing.chargecalculation.integration").append("\n"); 
		query.append("FileName : ChargeCalculationDBDAOSearchBookingInfoRSQL").append("\n"); 
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
		query.append("SELECT  NVL(" ).append("\n"); 
		query.append("			( " ).append("\n"); 
		query.append("				SELECT  B.VSL_CD||B.SKD_VOY_NO||B.SKD_DIR_CD||'|'||DECODE(@[io_bnd_cd],'O',A.RCV_TERM_CD,A.DE_TERM_CD)" ).append("\n"); 
		query.append("				  FROM  BKG_BOOKING A" ).append("\n"); 
		query.append("				       ,BKG_VVD 	B" ).append("\n"); 
		query.append("				 WHERE  1 = 1" ).append("\n"); 
		query.append("				   AND  A.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("				   AND  A.BKG_NO = B.BKG_NO" ).append("\n"); 
		query.append("				   AND  CASE WHEN @[io_bnd_cd] = 'O' THEN A.POl_CD ELSE A.POD_CD END = CASE WHEN @[io_bnd_cd] = 'O' THEN B.POl_CD ELSE B.POD_CD END" ).append("\n"); 
		query.append("				   AND  ROWNUM = 1" ).append("\n"); 
		query.append("			),' | '" ).append("\n"); 
		query.append("		)||'|'||" ).append("\n"); 
		query.append("		NVL(" ).append("\n"); 
		query.append("			( " ).append("\n"); 
		query.append("				SELECT  DECODE(DMDT_INV_STS_CD,'I','Y','N') ||'|'||INV_CURR_CD ||'|'||INV_CHG_AMT" ).append("\n"); 
		query.append("						||'|'||DECODE(ACT_PAYR_CNT_CD,'00','',ACT_PAYR_CNT_CD)||TRIM(TO_CHAR(ACT_PAYR_SEQ, '000000'))" ).append("\n"); 
		query.append("						||'|'||" ).append("\n"); 
		query.append("						(" ).append("\n"); 
		query.append("							SELECT  CUST_LGL_ENG_NM " ).append("\n"); 
		query.append("							  FROM  MDM_CUSTOMER " ).append("\n"); 
		query.append("							 WHERE  CUST_CNT_CD = DECODE(A.ACT_PAYR_CNT_CD,'00','TB',A.ACT_PAYR_CNT_CD) " ).append("\n"); 
		query.append("							   AND  CUST_SEQ = A.ACT_PAYR_SEQ" ).append("\n"); 
		query.append("						)" ).append("\n"); 
		query.append("				  FROM  DMT_INV_MN A" ).append("\n"); 
		query.append("				 WHERE  DMDT_INV_NO = @[dmdt_inv_no]" ).append("\n"); 
		query.append("				   AND  ROWNUM = 1 " ).append("\n"); 
		query.append("			),'E| | | | '" ).append("\n"); 
		query.append("		)||'|'||" ).append("\n"); 
		query.append("		NVL(" ).append("\n"); 
		query.append("			( " ).append("\n"); 
		query.append("				SELECT  ( " ).append("\n"); 
		query.append("							SELECT  INTG_CD_VAL_DP_DESC " ).append("\n"); 
		query.append("							  FROM  COM_INTG_CD_DTL" ).append("\n"); 
		query.append("							 WHERE  INTG_CD_ID = 'CD00588'" ).append("\n"); 
		query.append("							   AND  INTG_CD_VAL_CTNT = C.OTS_STS_CD" ).append("\n"); 
		query.append("						) ||'|'|| B.CURR_CD ||'|'|| B.INV_AMT" ).append("\n"); 
		query.append("				  FROM  TPB_OTS_GRP_STS C" ).append("\n"); 
		query.append("				       ,TPB_OTS_GRP 	B" ).append("\n"); 
		query.append("				 WHERE  1 = 1" ).append("\n"); 
		query.append("				   AND  C.OTS_STS_LST_FLG = 'Y'" ).append("\n"); 
		query.append("				   AND  C.N3PTY_NO = @[tpb_no]" ).append("\n"); 
		query.append("				   AND  B.N3PTY_NO = C.N3PTY_NO " ).append("\n"); 
		query.append("				   AND  B.N3PTY_DELT_TP_CD IN ('N','C','S') " ).append("\n"); 
		query.append("				   AND  ROWNUM = 1 " ).append("\n"); 
		query.append("			),'E| | '" ).append("\n"); 
		query.append("		)||'|'||" ).append("\n"); 
		query.append("		NVL(" ).append("\n"); 
		query.append("			( " ).append("\n"); 
		query.append("				SELECT  DECODE(SOC_FLG,'Y','Yes','No')" ).append("\n"); 
		query.append("				  FROM  BKG_CONTAINER " ).append("\n"); 
		query.append("				 WHERE  1 = 1" ).append("\n"); 
		query.append("				   AND  BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("				   AND  CNTR_NO = @[cntr_no]" ).append("\n"); 
		query.append("				   AND  ROWNUM = 1" ).append("\n"); 
		query.append("			)," ).append("\n"); 
		query.append("			(" ).append("\n"); 
		query.append("				SELECT  DECODE(SOC_FLG,'Y','Yes','No')" ).append("\n"); 
		query.append("				  FROM  DMT_CHG_BKG_CNTR" ).append("\n"); 
		query.append("				 WHERE  BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("				   AND  CNTR_NO = @[cntr_no]" ).append("\n"); 
		query.append("                   AND  ROWNUM = 1				   " ).append("\n"); 
		query.append("			)" ).append("\n"); 
		query.append("		)||'|'||" ).append("\n"); 
		query.append("		NVL(" ).append("\n"); 
		query.append("			(             " ).append("\n"); 
		query.append("				SELECT  CHG_CD||'|'||'USD'||'|'||" ).append("\n"); 
		query.append("						TO_CHAR(SUM(" ).append("\n"); 
		query.append("									(" ).append("\n"); 
		query.append("										SELECT  ROUND( AA.CHG_AMT / F.USD_LOCL_XCH_RT , 2 )" ).append("\n"); 
		query.append("										  FROM  GL_MON_XCH_RT F" ).append("\n"); 
		query.append("										 WHERE  1 = 1" ).append("\n"); 
		query.append("										   AND  F.ACCT_XCH_RT_YRMON = TO_CHAR(SYSDATE, 'YYYYMM')" ).append("\n"); 
		query.append("										   AND  F.ACCT_XCH_RT_LVL = '1'" ).append("\n"); 
		query.append("										   AND  F.CURR_CD = AA.CURR_CD " ).append("\n"); 
		query.append("									)" ).append("\n"); 
		query.append("								)" ).append("\n"); 
		query.append("						) CHG_AMT" ).append("\n"); 
		query.append("				  FROM  (" ).append("\n"); 
		query.append("							SELECT  BKG_JOIN_FNC(CURSOR(" ).append("\n"); 
		query.append("														(" ).append("\n"); 
		query.append("															SELECT  C.CHG_CD" ).append("\n"); 
		query.append("															  FROM  INV_AR_MN 	M " ).append("\n"); 
		query.append("																   ,INV_AR_CHG 	C" ).append("\n"); 
		query.append("															 WHERE  M.AR_IF_NO = C.AR_IF_NO" ).append("\n"); 
		query.append("															   AND  M.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("															   AND  C.CHG_CD IN ('DMR','DTC','CDD')" ).append("\n"); 
		query.append("															   AND  (M.REV_TP_CD IN ('B','C') OR (M.REV_TP_CD = 'M' AND M.REV_SRC_CD NOT IN ('DM','DT','CD')))" ).append("\n"); 
		query.append("															GROUP BY C.CHG_CD" ).append("\n"); 
		query.append("														)" ).append("\n"); 
		query.append("												)" ).append("\n"); 
		query.append("									) AS CHG_CD" ).append("\n"); 
		query.append("								   ,CURR_CD" ).append("\n"); 
		query.append("								   ,SUM(CHG_AMT) AS CHG_AMT" ).append("\n"); 
		query.append("							  FROM  INV_AR_MN 	M" ).append("\n"); 
		query.append("							       ,INV_AR_CHG 	C" ).append("\n"); 
		query.append("							 WHERE  M.AR_IF_NO = C.AR_IF_NO" ).append("\n"); 
		query.append("							   AND  M.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("							   AND  C.CHG_CD IN ('DMR','DTC','CDD')" ).append("\n"); 
		query.append("							   AND  (M.REV_TP_CD IN ('B','C') OR (M.REV_TP_CD = 'M' AND M.REV_SRC_CD NOT IN ('DM','DT','CD')))" ).append("\n"); 
		query.append("							GROUP BY CURR_CD" ).append("\n"); 
		query.append("						) AA" ).append("\n"); 
		query.append("				GROUP BY CHG_CD" ).append("\n"); 
		query.append("			),' |E| '" ).append("\n"); 
		query.append("		)||'|'||" ).append("\n"); 
		query.append("		NVL(" ).append("\n"); 
		query.append("			(" ).append("\n"); 
		query.append("				SELECT  'Y' " ).append("\n"); 
		query.append("				  FROM  VSK_VSL_PORT_SKD" ).append("\n"); 
		query.append("				 WHERE  VSL_CD = SUBSTR(@[vvd_cd], 1, 4)" ).append("\n"); 
		query.append("				   AND  SKD_VOY_NO = SUBSTR(@[vvd_cd], 5, 4)" ).append("\n"); 
		query.append("				   AND  SKD_DIR_CD = SUBSTR(@[vvd_cd], 9)" ).append("\n"); 
		query.append("				   AND  ROWNUM = 1 " ).append("\n"); 
		query.append("			), 'N'" ).append("\n"); 
		query.append("		)||'|'||" ).append("\n"); 
		query.append("		NVL(" ).append("\n"); 
		query.append("			(" ).append("\n"); 
		query.append("				SELECT  CURR_CD " ).append("\n"); 
		query.append("				  FROM  MDM_CURRENCY" ).append("\n"); 
		query.append("				 WHERE  DELT_FLG = 'N'" ).append("\n"); 
		query.append("				   AND  CURR_CD = @[curr_cd]" ).append("\n"); 
		query.append("				   AND  ROWNUM = 1" ).append("\n"); 
		query.append("			),'E'" ).append("\n"); 
		query.append("		)||'|'||" ).append("\n"); 
		query.append("		NVL(" ).append("\n"); 
		query.append("			(" ).append("\n"); 
		query.append("				SELECT  MTY_PKUP_YD_CD||'|'||SVC_SCP_CD " ).append("\n"); 
		query.append("				  FROM  BKG_BOOKING" ).append("\n"); 
		query.append("				 WHERE  1 = 1" ).append("\n"); 
		query.append("				   AND  BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("				   AND  ROWNUM = 1" ).append("\n"); 
		query.append("			),'E|E'" ).append("\n"); 
		query.append("		)||'|'||" ).append("\n"); 
		query.append("		NVL(" ).append("\n"); 
		query.append("			( " ).append("\n"); 
		query.append("				SELECT  CHG_CD || '|' || SUM(CHG_AMT) " ).append("\n"); 
		query.append("				  FROM  BKG_CHG_RT" ).append("\n"); 
		query.append("				 WHERE  BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("				   AND  CURR_CD = @[curr_cd]" ).append("\n"); 
		query.append("				   AND  CHG_CD = 'SRC'" ).append("\n"); 
		query.append("				GROUP BY CHG_CD" ).append("\n"); 
		query.append("			),'E|E'" ).append("\n"); 
		query.append("		)||'|'||" ).append("\n"); 
		query.append("		NVL(" ).append("\n"); 
		query.append("			( " ).append("\n"); 
		query.append("				SELECT  NVL(TAA_NO, NVL(RFA_NO, SC_NO))||'|'||" ).append("\n"); 
		query.append("						SUBSTR(BB.PRI, INSTR(BB .PRI, ',', 1, 1)+1, INSTR(BB .PRI, ',', 1, 2)-INSTR(BB .PRI, ',', 1, 1)-1)||'|'||" ).append("\n"); 
		query.append("						SUBSTR(BB.PRI, INSTR(BB .PRI, ',', 1, 2)+1)" ).append("\n"); 
		query.append("				  FROM  (" ).append("\n"); 
		query.append("							SELECT  DISTINCT A.* " ).append("\n"); 
		query.append("								   ,CASE" ).append("\n"); 
		query.append("										WHEN A.CONTRACT_TYPE = 'SC' " ).append("\n"); 
		query.append("											THEN" ).append("\n"); 
		query.append("												(" ).append("\n"); 
		query.append("													SELECT  MN.PROP_OFC_CD||','||" ).append("\n"); 
		query.append("															CASE " ).append("\n"); 
		query.append("																WHEN REAL_CUST_CNT_CD||TRIM(TO_CHAR(REAL_CUST_SEQ, '000000')) IS NULL THEN " ).append("\n"); 
		query.append("																		PTY.CUST_CNT_CD||TRIM(TO_CHAR(PTY.CUST_SEQ, '000000'))" ).append("\n"); 
		query.append("															ELSE REAL_CUST_CNT_CD||TRIM(TO_CHAR(REAL_CUST_SEQ, '000000'))" ).append("\n"); 
		query.append("															END ||','||" ).append("\n"); 
		query.append("															CASE" ).append("\n"); 
		query.append("																WHEN REAL_CUST_CNT_CD||TRIM(TO_CHAR(REAL_CUST_SEQ, '000000')) IS NULL THEN A.CUST_LGL_ENG_NM" ).append("\n"); 
		query.append("															ELSE R.CUST_LGL_ENG_NM" ).append("\n"); 
		query.append("															END" ).append("\n"); 
		query.append("													  FROM  PRI_SP_HDR 		HDR" ).append("\n"); 
		query.append("													       ,PRI_SP_MN 		MN" ).append("\n"); 
		query.append("														   ,PRI_SP_CTRT_PTY PTY" ).append("\n"); 
		query.append("														   ,MDM_CUSTOMER 	R" ).append("\n"); 
		query.append("														   ,MDM_CUSTOMER 	A" ).append("\n"); 
		query.append("													 WHERE  1 = 1" ).append("\n"); 
		query.append("													   AND  A.SC_NO = HDR.SC_NO" ).append("\n"); 
		query.append("													   AND  HDR.PROP_NO = MN.PROP_NO" ).append("\n"); 
		query.append("													   AND  MN.PROP_STS_CD ='F'" ).append("\n"); 
		query.append("													   AND  MN.AMDT_SEQ = " ).append("\n"); 
		query.append("															(" ).append("\n"); 
		query.append("																SELECT  MAX(AMDT_SEQ)" ).append("\n"); 
		query.append("																  FROM  PRI_SP_MN" ).append("\n"); 
		query.append("																 WHERE  1 = 1" ).append("\n"); 
		query.append("																   AND  PROP_NO = MN.PROP_NO" ).append("\n"); 
		query.append("																   AND  PROP_STS_CD = MN.PROP_STS_CD" ).append("\n"); 
		query.append("															)" ).append("\n"); 
		query.append("													   AND  PTY.PROP_NO = MN.PROP_NO" ).append("\n"); 
		query.append("													   AND  PTY.AMDT_SEQ = MN.AMDT_SEQ" ).append("\n"); 
		query.append("													   AND  PTY.PRC_CTRT_PTY_TP_CD = 'C'" ).append("\n"); 
		query.append("													   AND  REAL_CUST_CNT_CD = R.CUST_CNT_CD(+)" ).append("\n"); 
		query.append("													   AND  REAL_CUST_SEQ = R.CUST_SEQ (+)" ).append("\n"); 
		query.append("													   AND  PTY.CUST_CNT_CD = A.CUST_CNT_CD(+)" ).append("\n"); 
		query.append("													   AND  PTY.CUST_SEQ = A.CUST_SEQ(+) " ).append("\n"); 
		query.append("												)" ).append("\n"); 
		query.append("										WHEN A.CONTRACT_TYPE = 'RFA' " ).append("\n"); 
		query.append("											THEN" ).append("\n"); 
		query.append("												(" ).append("\n"); 
		query.append("													SELECT  MN.PROP_OFC_CD ||','|| MN.CTRT_CUST_CNT_CD||TRIM(TO_CHAR(MN.CTRT_CUST_SEQ, '000000'))||','|| REPLACE(REPLACE(R.CUST_LGL_ENG_NM, CHR(13)||CHR(10), ' '), CHR(9), ' ')" ).append("\n"); 
		query.append("													  FROM  PRI_RP_HDR 		HDR" ).append("\n"); 
		query.append("													       ,PRI_RP_MN 		MN" ).append("\n"); 
		query.append("														   ,MDM_CUSTOMER 	R" ).append("\n"); 
		query.append("													 WHERE  1 = 1" ).append("\n"); 
		query.append("													   AND  HDR.RFA_NO = A.RFA_NO" ).append("\n"); 
		query.append("													   AND  HDR.PROP_NO = MN.PROP_NO" ).append("\n"); 
		query.append("													   AND  MN.PROP_STS_CD = 'A'" ).append("\n"); 
		query.append("													   AND  MN.AMDT_SEQ = " ).append("\n"); 
		query.append("															(" ).append("\n"); 
		query.append("																SELECT  MAX(AMDT_SEQ)" ).append("\n"); 
		query.append("																  FROM  PRI_RP_MN" ).append("\n"); 
		query.append("																 WHERE  1 = 1" ).append("\n"); 
		query.append("																   AND  PROP_NO = MN.PROP_NO" ).append("\n"); 
		query.append("																   AND  PROP_STS_CD = MN.PROP_STS_CD " ).append("\n"); 
		query.append("															)" ).append("\n"); 
		query.append("													   AND  MN.CTRT_CUST_CNT_CD = R.CUST_CNT_CD(+)" ).append("\n"); 
		query.append("													   AND  MN.CTRT_CUST_SEQ = R.CUST_SEQ(+) " ).append("\n"); 
		query.append("												)" ).append("\n"); 
		query.append("										WHEN A.CONTRACT_TYPE = 'TAA' " ).append("\n"); 
		query.append("											THEN " ).append("\n"); 
		query.append("												(" ).append("\n"); 
		query.append("													SELECT  MN.RESPB_SLS_OFC_CD||','|| MN.CTRT_CUST_CNT_CD||TRIM(TO_CHAR(MN.CTRT_CUST_SEQ, '000000')) ||','|| REPLACE(REPLACE(R.CUST_LGL_ENG_NM, CHR(13)||CHR(10), ' '), CHR(9), ' ')" ).append("\n"); 
		query.append("													  FROM  PRI_TAA_HDR 	HDR" ).append("\n"); 
		query.append("													       ,PRI_TAA_MN 		MN" ).append("\n"); 
		query.append("														   ,MDM_CUSTOMER 	R" ).append("\n"); 
		query.append("													 WHERE  1 = 1" ).append("\n"); 
		query.append("													   AND  HDR.TAA_NO = A.TAA_NO" ).append("\n"); 
		query.append("													   AND  HDR.TAA_PROP_NO = MN.TAA_PROP_NO" ).append("\n"); 
		query.append("													   AND  MN.CFM_FLG = 'Y'" ).append("\n"); 
		query.append("													   AND  MN.AMDT_SEQ = " ).append("\n"); 
		query.append("															(" ).append("\n"); 
		query.append("																SELECT  MAX(AMDT_SEQ)" ).append("\n"); 
		query.append("																  FROM  PRI_TAA_MN" ).append("\n"); 
		query.append("																 WHERE  1=1" ).append("\n"); 
		query.append("																   AND  TAA_PROP_NO = MN.TAA_PROP_NO" ).append("\n"); 
		query.append("																   AND  CFM_FLG = MN.CFM_FLG" ).append("\n"); 
		query.append("															)" ).append("\n"); 
		query.append("													   AND  MN.CTRT_CUST_CNT_CD = R.CUST_CNT_CD(+)" ).append("\n"); 
		query.append("													   AND  MN.CTRT_CUST_SEQ = R.CUST_SEQ(+) " ).append("\n"); 
		query.append("												)" ).append("\n"); 
		query.append("										ELSE 'AAA'" ).append("\n"); 
		query.append("									END PRI" ).append("\n"); 
		query.append("							  FROM  (" ).append("\n"); 
		query.append("										SELECT  CASE " ).append("\n"); 
		query.append("													WHEN SUBSTR(BK.RFA_NO, 1, 3) != 'DUM' AND BK.RFA_NO IS NOT NULL THEN 'RFA'" ).append("\n"); 
		query.append("													WHEN SUBSTR(BK.TAA_NO, 1, 3) != 'DUM' AND BK.TAA_NO IS NOT NULL THEN 'TAA'" ).append("\n"); 
		query.append("													WHEN SUBSTR(BK.SC_NO, 1, 3)  != 'DUM' AND BK.SC_NO  IS NOT NULL THEN 'SC'" ).append("\n"); 
		query.append("													ELSE 'AAA'" ).append("\n"); 
		query.append("												END AS CONTRACT_TYPE " ).append("\n"); 
		query.append("											   ,BK.RFA_NO" ).append("\n"); 
		query.append("											   ,BK.TAA_NO" ).append("\n"); 
		query.append("											   ,BK.SC_NO" ).append("\n"); 
		query.append("										  FROM  BKG_BOOKING BK" ).append("\n"); 
		query.append("										 WHERE  BKG_NO = @[bkg_no] " ).append("\n"); 
		query.append("									) A " ).append("\n"); 
		query.append("						) BB " ).append("\n"); 
		query.append("			),'E|E|E'" ).append("\n"); 
		query.append("		)||'|' AS rtnValue" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 

	}
}