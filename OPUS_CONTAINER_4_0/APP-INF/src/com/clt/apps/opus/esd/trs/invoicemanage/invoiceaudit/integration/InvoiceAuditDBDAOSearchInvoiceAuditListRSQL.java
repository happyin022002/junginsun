/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : InvoiceAuditDBDAOSearchInvoiceAuditListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.12.01
*@LastModifier : 김성욱
*@LastVersion : 1.0
* 2016.12.01 김성욱
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.trs.invoicemanage.invoiceaudit.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Sung-Wook Kim
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class InvoiceAuditDBDAOSearchInvoiceAuditListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * invoice 대상 리스트 가져오기
	  * </pre>
	  */
	public InvoiceAuditDBDAOSearchInvoiceAuditListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.NUMERIC + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("paymt_sp_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("issue_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("apply_currency",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.trs.invoicemanage.invoiceaudit.integration").append("\n"); 
		query.append("FileName : InvoiceAuditDBDAOSearchInvoiceAuditListRSQL").append("\n"); 
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
		query.append("SELECT		" ).append("\n"); 
		query.append(" 	CASE WHEN A.EQ_NO IS NULL AND A.TRSP_SO_TP_CD || A.TRSP_COST_DTL_MOD_CD IN ('YCY', 'YLS', 'YTS') THEN DECODE(SCE.CNTR_NO, 'COMU0000000', '', SCE.CNTR_NO)" ).append("\n"); 
		query.append("		 ELSE A.EQ_NO" ).append("\n"); 
		query.append("	END  EQ_NO" ).append("\n"); 
		query.append(" ,	CASE WHEN A.EQ_NO IS NULL AND A.TRSP_SO_TP_CD || A.TRSP_COST_DTL_MOD_CD IN ('YCY', 'YLS', 'YTS') THEN DECODE(SCE.CNTR_NO, 'COMU0000000', '', SCE.CNTR_NO)" ).append("\n"); 
		query.append("		 ELSE A.EQ_NO" ).append("\n"); 
		query.append("	END  ORG_EQ_NO" ).append("\n"); 
		query.append(" ,	A.EQ_TPSZ_CD" ).append("\n"); 
		query.append(" ,	A.ORG_EQ_TPSZ_CD				" ).append("\n"); 
		query.append(" ,	A.EQ_KND_CD" ).append("\n"); 
		query.append(" ,	SUBSTR(A.FM_NOD_CD,1,5) FM_LOC_VALUE		" ).append("\n"); 
		query.append(" ,	SUBSTR(A.FM_NOD_CD,6,2) FM_YARD_VALUE		" ).append("\n"); 
		query.append(" ,	SUBSTR(A.VIA_NOD_CD,1,5) VIA_LOC_VALUE	 	" ).append("\n"); 
		query.append(" ,	SUBSTR(A.VIA_NOD_CD,6,2) VIA_YARD_VALUE	 	" ).append("\n"); 
		query.append(" ,	SUBSTR(A.TO_NOD_CD,1,5) TO_LOC_VALUE		" ).append("\n"); 
		query.append(" ,	SUBSTR(A.TO_NOD_CD,6,2) TO_YARD_VALUE		" ).append("\n"); 
		query.append(" ,	SUBSTR(A.DOR_NOD_CD,1,5) DOR_LOC_VALUE	 	" ).append("\n"); 
		query.append(" ,	SUBSTR(A.DOR_NOD_CD,6,2) DOR_YARD_VALUE	 	" ).append("\n"); 
		query.append(" ,	A.CUST_CNT_CD" ).append("\n"); 
		query.append(" ,	A.CUST_SEQ" ).append("\n"); 
		query.append(" ,	A.DOR_DE_ADDR" ).append("\n"); 
		query.append(" ,	A.CURR_CD	" ).append("\n"); 
		query.append(" ,	A.BZC_AMT	" ).append("\n"); 
		query.append(" ,	A.NEGO_AMT" ).append("\n"); 
		query.append(" ,	A.FUEL_SCG_AMT				" ).append("\n"); 
		query.append(" ,	A.ETC_ADD_AMT" ).append("\n"); 
		query.append(" ,  (SELECT CASE WHEN MAX(A.CURR_CD) <> MAX(NVL(D.CURR_CD, A.CURR_CD)) OR MAX(A.CURR_CD) <> MIN(NVL(D.CURR_CD, A.CURR_CD)) THEN 'Y'" ).append("\n"); 
		query.append("                 ELSE 'N'" ).append("\n"); 
		query.append("            END" ).append("\n"); 
		query.append("       FROM TRS_TRSP_SCG_DTL D" ).append("\n"); 
		query.append("      WHERE A.TRSP_SO_OFC_CTY_CD = D.TRSP_SO_OFC_CTY_CD" ).append("\n"); 
		query.append("        AND A.TRSP_SO_SEQ = D.TRSP_SO_SEQ" ).append("\n"); 
		query.append("    ) AS MULTI_CURR_YN" ).append("\n"); 
		query.append(" ,	( NVL(A.BZC_AMT,0)+	NVL(A.NEGO_AMT,0)+NVL(A.FUEL_SCG_AMT,0)+NVL(A.ETC_ADD_AMT,0)) AS WO_TOT_AMT	 			" ).append("\n"); 
		query.append(" ,	NVL(A.TRSP_INV_CALC_LGC_TP_CD, 'TM') TRSP_INV_CALC_LGC_TP_CD" ).append("\n"); 
		query.append(" ,	NVL(A.INV_XCH_RT, ( SELECT ROUND((X1.USD_LOCL_XCH_RT / X2.USD_LOCL_XCH_RT),6) AS RATE" ).append("\n"); 
		query.append("                          FROM GL_MON_XCH_RT X1" ).append("\n"); 
		query.append("                             , GL_MON_XCH_RT X2" ).append("\n"); 
		query.append("                         WHERE X1.ACCT_XCH_RT_YRMON = REPLACE(SUBSTR(@[issue_dt],1,6),'-','') -- Issue/Receive Date" ).append("\n"); 
		query.append("                           AND X1.ACCT_XCH_RT_LVL = '1'" ).append("\n"); 
		query.append("                           AND X1.CURR_CD = @[apply_currency] -- INV Currency" ).append("\n"); 
		query.append("                           AND X2.ACCT_XCH_RT_YRMON = REPLACE(SUBSTR(@[issue_dt],1,6),'-','') -- Issue/Receive Date" ).append("\n"); 
		query.append("                           AND X2.ACCT_XCH_RT_LVL = '1'" ).append("\n"); 
		query.append("                           AND X2.CURR_CD = A.CURR_CD -- W/O Currency" ).append("\n"); 
		query.append("                           AND X1.DELT_FLG = 'N'" ).append("\n"); 
		query.append("                           AND X2.DELT_FLG = 'N' )" ).append("\n"); 
		query.append("       ) INV_XCH_RT" ).append("\n"); 
		query.append(" ,  A.INV_ADJ_BZC_AMT" ).append("\n"); 
		query.append(" ,	A.INV_CURR_CD" ).append("\n"); 
		query.append(" ,	CASE WHEN ( A.INV_BZC_AMT IS NULL OR A.INV_BZC_AMT = 0)	THEN ( NVL(A.BZC_AMT,0)+ NVL(A.NEGO_AMT,0)+ NVL(A.FUEL_SCG_AMT,0)+NVL(A.ETC_ADD_AMT,0)) 	 				" ).append("\n"); 
		query.append(" 	     ELSE A.INV_BZC_AMT		" ).append("\n"); 
		query.append(" 	END AS INV_BZC_AMT			" ).append("\n"); 
		query.append(" ,	A.INV_ETC_ADD_AMT				" ).append("\n"); 
		query.append(" ,	A.TRSP_WO_OFC_CTY_CD			" ).append("\n"); 
		query.append(" ,	A.TRSP_WO_SEQ" ).append("\n"); 
		query.append(" ,	A.TRSP_WO_OFC_CTY_CD||A.TRSP_WO_SEQ AS TRSP_WO_OFC_CTY_CD_SEQ  	" ).append("\n"); 
		query.append(" ,	TO_CHAR(A.LOCL_CRE_DT, 'YYYYMMDD')	CRE_DT		" ).append("\n"); 
		query.append(" ,	TO_CHAR(A.LOCL_CRE_DT, 'HH24:MI:SS')	CRE_TM		" ).append("\n"); 
		query.append(" ,	(CASE WHEN A.TRSP_SO_TP_CD = 'Y' THEN NVL(TO_CHAR(A.ORG_GATE_OUT_DT, 'YYYY-MM-DD HH24:MI:SS'),TO_CHAR(A.DEST_GATE_IN_DT, 'YYYY-MM-DD HH24:MI:SS'))" ).append("\n"); 
		query.append("           ELSE TO_CHAR(A.WO_EXE_DT, 'YYYY-MM-DD HH24:MI:SS')" ).append("\n"); 
		query.append("     END) COP_EXE_DT" ).append("\n"); 
		query.append(" ,	A.BKG_NO	" ).append("\n"); 
		query.append(" ,	A.BL_NO BL_NO	 	" ).append("\n"); 
		query.append(" ,	A.CGO_TP_CD" ).append("\n"); 
		query.append(" ,	A.SPCL_CGO_CNTR_TP_CD			" ).append("\n"); 
		query.append(" ,	A.TRSP_BND_CD" ).append("\n"); 
		query.append(" ,	A.TRSP_COST_DTL_MOD_CD		" ).append("\n"); 
		query.append(" ,	A.DOR_SVC_TP_CD				" ).append("\n"); 
		query.append(" ,	A.N3PTY_BIL_FLG				" ).append("\n"); 
		query.append(" ,	A.INV_RMK	" ).append("\n"); 
		query.append(" ,	DECODE(A.TRSP_SO_TP_CD, 'M', A.INTER_RMK, 'H', A.INTER_RMK, 'O', A.INTER_RMK, " ).append("\n"); 
		query.append("	DECODE((SELECT MAX(RMK.BKG_NO)" ).append("\n"); 
		query.append("              FROM TRS_INTER_RMK RMK" ).append("\n"); 
		query.append("             WHERE RMK.BKG_NO IN(A.BKG_NO, 'DUM000000000')" ).append("\n"); 
		query.append("               AND NVL(RMK.EQ_NO, 'X') = NVL2(RMK.EQ_NO, A.EQ_NO, 'X')" ).append("\n"); 
		query.append("               AND NVL(RMK.TRSP_SO_OFC_CTY_CD, 'XX') = NVL2(RMK.TRSP_SO_OFC_CTY_CD, A.TRSP_SO_OFC_CTY_CD, 'XX')" ).append("\n"); 
		query.append("               AND NVL(RMK.TRSP_SO_SEQ, '99999') = NVL2(RMK.TRSP_SO_SEQ, A.TRSP_SO_SEQ, '99999')" ).append("\n"); 
		query.append("               AND NVL(RMK.DELT_FLG, 'X') = 'N'), '', '', 'Y')) INTER_RMK" ).append("\n"); 
		query.append(" ,  DECODE(A.TRSP_SO_TP_CD, 'M', '', 'H', '', 'O', '', '1') INTER_RMK_IMG" ).append("\n"); 
		query.append(" ,	A.SPCL_INSTR_RMK				" ).append("\n"); 
		query.append(" ,	A.CNTR_NO	" ).append("\n"); 
		query.append(" ,	A.CNTR_TPSZ_CD" ).append("\n"); 
		query.append(" ,	TO_CHAR(A.ORG_GATE_OUT_DT, 'YYYY-MM-DD HH24:MI:SS')				" ).append("\n"); 
		query.append(" 	AS ORG_GATE_OUT_DT				" ).append("\n"); 
		query.append(" ,	TO_CHAR(A.DEST_GATE_IN_DT, 'YYYY-MM-DD HH24:MI:SS')				" ).append("\n"); 
		query.append(" 	AS DEST_GATE_IN_DT				" ).append("\n"); 
		query.append(" ,	A.TRSP_SO_OFC_CTY_CD||A.TRSP_SO_SEQ TRSP_SO_OFC_CTY_CD_SEQ		" ).append("\n"); 
		query.append(" ,	A.TRSP_SO_OFC_CTY_CD			" ).append("\n"); 
		query.append(" ,	A.TRSP_SO_SEQ" ).append("\n"); 
		query.append(" ,	A.TRSP_SO_SEQ SURCHARGE_KEY		" ).append("\n"); 
		query.append(" ,	A.TRSP_MTY_COST_MOD_CD			" ).append("\n"); 
		query.append(" ,	A.TRSP_SO_TP_CD" ).append("\n"); 
		query.append(" ,	A.CRE_OFC_CD" ).append("\n"); 
		query.append(" ,	A.COST_ACT_GRP_CD" ).append("\n"); 
		query.append(" ,	NVL(A.TRSP_FRST_FLG,'N') TRSP_FRST_FLG" ).append("\n"); 
		query.append(" ,	A.REF_INV_NO" ).append("\n"); 
		query.append(" ,  A.INV_ADJ_BZC_AMT	" ).append("\n"); 
		query.append(" ,  A.INV_BZC_AMT ORG_INV_BZC_AMT" ).append("\n"); 
		query.append(" ,  A.REF_ID" ).append("\n"); 
		query.append(" FROM TRS_TRSP_SVC_ORD A, SCE_COP_HDR SCE" ).append("\n"); 
		query.append(" WHERE 		" ).append("\n"); 
		query.append(" 	  A.VNDR_SEQ IN" ).append("\n"); 
		query.append("		(   SELECT F.VNDR_SEQ FROM MDM_VENDOR F		" ).append("\n"); 
		query.append("			WHERE F.VNDR_SEQ			= @[paymt_sp_cd]" ).append("\n"); 
		query.append("			UNION" ).append("\n"); 
		query.append("			SELECT F.VNDR_SEQ FROM MDM_VENDOR F		" ).append("\n"); 
		query.append("			WHERE F.PRNT_VNDR_SEQ		= @[paymt_sp_cd]" ).append("\n"); 
		query.append("		)		" ).append("\n"); 
		query.append(" AND A.TRSP_SO_STS_CD = 'I'		" ).append("\n"); 
		query.append(" AND A.TRSP_INV_ACT_STS_CD IS NULL	" ).append("\n"); 
		query.append(" AND A.CRE_OFC_CD IN 				" ).append("\n"); 
		query.append(" (	SELECT OFC_CD FROM	TRS_TRSP_INV_OFC			" ).append("\n"); 
		query.append(" 	WHERE  INV_OFC_CD = @[ofc_cd]				" ).append("\n"); 
		query.append(" )	" ).append("\n"); 
		query.append(" AND A.DELT_FLG = 'N' " ).append("\n"); 
		query.append(" AND A.COP_NO = SCE.COP_NO(+)" ).append("\n"); 
		query.append(" AND SCE.COP_STS_CD(+) IN ('C', 'T', 'F') 		" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if($soArr.size() > 0) " ).append("\n"); 
		query.append("AND ( (A.TRSP_SO_OFC_CTY_CD, A.TRSP_SO_SEQ) IN (" ).append("\n"); 
		query.append("#foreach( ${key} in ${soArr}) " ).append("\n"); 
		query.append("#if($velocityCount == 1)" ).append("\n"); 
		query.append("        ( '${key.trspSoOfcCtyCd}', ${key.trspSoSeq} )" ).append("\n"); 
		query.append("#else " ).append("\n"); 
		query.append("      , ( '${key.trspSoOfcCtyCd}', ${key.trspSoSeq} )" ).append("\n"); 
		query.append("#end " ).append("\n"); 
		query.append("#end  " ).append("\n"); 
		query.append("      )" ).append("\n"); 
		query.append("    )" ).append("\n"); 
		query.append("#end " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if($woArr.size() > 0) " ).append("\n"); 
		query.append("AND ( (A.TRSP_WO_OFC_CTY_CD, A.TRSP_WO_SEQ) IN (" ).append("\n"); 
		query.append("#foreach( ${key} in ${woArr}) " ).append("\n"); 
		query.append("#if($velocityCount == 1)" ).append("\n"); 
		query.append("        ( '${key.trspWoOfcCtyCd}' , ${key.trspWoSeq} )	" ).append("\n"); 
		query.append("#else " ).append("\n"); 
		query.append(" 		, ( '${key.trspWoOfcCtyCd}' , ${key.trspWoSeq} )	" ).append("\n"); 
		query.append("#end " ).append("\n"); 
		query.append("#end " ).append("\n"); 
		query.append("		)" ).append("\n"); 
		query.append("	)" ).append("\n"); 
		query.append("#end " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if($bkgNoArr.size() > 0) " ).append("\n"); 
		query.append(" AND A.BKG_NO IN (" ).append("\n"); 
		query.append("#foreach( ${key} in ${bkgNoArr}) " ).append("\n"); 
		query.append("#if($velocityCount == 1)" ).append("\n"); 
		query.append(" '${key}'	" ).append("\n"); 
		query.append("#else " ).append("\n"); 
		query.append(" ,'${key}'" ).append("\n"); 
		query.append("#end " ).append("\n"); 
		query.append("#end " ).append("\n"); 
		query.append(" )" ).append("\n"); 
		query.append("#end " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if($blNoArr.size() > 0) " ).append("\n"); 
		query.append(" AND A.BL_NO IN (" ).append("\n"); 
		query.append("#foreach( ${key} in ${blNoArr}) " ).append("\n"); 
		query.append("#if($velocityCount == 1)" ).append("\n"); 
		query.append(" '${key}'	" ).append("\n"); 
		query.append("#else " ).append("\n"); 
		query.append(" ,'${key}'" ).append("\n"); 
		query.append("#end " ).append("\n"); 
		query.append("#end " ).append("\n"); 
		query.append(" )" ).append("\n"); 
		query.append("#end " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if($eqNoArr.size() > 0) " ).append("\n"); 
		query.append(" AND A.EQ_NO IN (" ).append("\n"); 
		query.append("#foreach( ${key} in ${eqNoArr}) " ).append("\n"); 
		query.append("#if($velocityCount == 1)" ).append("\n"); 
		query.append(" '${key}'	" ).append("\n"); 
		query.append("#else " ).append("\n"); 
		query.append(" ,'${key}'" ).append("\n"); 
		query.append("#end " ).append("\n"); 
		query.append("#end " ).append("\n"); 
		query.append(" )" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}