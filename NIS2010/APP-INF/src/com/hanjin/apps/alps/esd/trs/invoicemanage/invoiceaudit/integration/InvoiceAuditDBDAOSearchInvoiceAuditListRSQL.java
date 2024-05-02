/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : InvoiceAuditDBDAOSearchInvoiceAuditListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.12.22
*@LastModifier : DONG- IL, SHIN
*@LastVersion : 1.0
* 2014.12.22 DONG- IL, SHIN
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.trs.invoicemanage.invoiceaudit.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author DONG- IL, SHIN
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
	  * 2011.04.05 김영철 [CHM-201109654-01] Frustrate 처리된 CNTR 에 대해 두번이상 S/O 가 난 건들의 Invoice 처리 가능하도록 수정요청 ( TRO_SEQ 컬럼 추가 )
	  * 2013.11.08 조인영 [CHM-201327482] W/O creation 컬럼 추가
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

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.trs.invoicemanage.invoiceaudit.integration").append("\n"); 
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
		query.append("	A.EQ_NO	" ).append("\n"); 
		query.append(" ,	A.EQ_NO AS ORG_EQ_NO		" ).append("\n"); 
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
		query.append(" ,	NVL(A.BZC_AMT,0) BZC_AMT	" ).append("\n"); 
		query.append(" ,	NVL(A.NEGO_AMT,0) NEGO_AMT" ).append("\n"); 
		query.append(" ,	NVL(A.FUEL_SCG_AMT,0) FUEL_SCG_AMT" ).append("\n"); 
		query.append(" ,	NVL(A.SCG_VAT_AMT,0) SCG_VAT_AMT				" ).append("\n"); 
		query.append(" ,	NVL(A.ETC_ADD_AMT,0) ETC_ADD_AMT" ).append("\n"); 
		query.append(" ,  NVL(A.TOLL_FEE_AMT,0) TOLL_FEE_AMT		" ).append("\n"); 
		query.append(" ,	(	 	" ).append("\n"); 
		query.append("		NVL(A.BZC_AMT,0)	+ 	" ).append("\n"); 
		query.append("		NVL(A.NEGO_AMT,0)	+ 	" ).append("\n"); 
		query.append("		NVL(A.FUEL_SCG_AMT,0)	+ " ).append("\n"); 
		query.append("		NVL(A.SCG_VAT_AMT,0)	+	" ).append("\n"); 
		query.append("		NVL(A.ETC_ADD_AMT,0)    +" ).append("\n"); 
		query.append("		NVL(A.TOLL_FEE_AMT,0)		" ).append("\n"); 
		query.append("	) AS WO_TOT_AMT	 			" ).append("\n"); 
		query.append(" ,	NVL(A.TRSP_INV_CALC_LGC_TP_CD, 'TM') TRSP_INV_CALC_LGC_TP_CD	" ).append("\n"); 
		query.append(" ,	NVL(A.INV_XCH_RT, 1) INV_XCH_RT	" ).append("\n"); 
		query.append(" ,	A.INV_CURR_CD" ).append("\n"); 
		query.append(" ,	CASE WHEN ( A.INV_BZC_AMT IS NULL OR A.INV_BZC_AMT = 0)			" ).append("\n"); 
		query.append(" 	   THEN (	" ).append("\n"); 
		query.append(" 				NVL(A.BZC_AMT,0)+ 	" ).append("\n"); 
		query.append(" 				NVL(A.NEGO_AMT,0)+ 	" ).append("\n"); 
		query.append(" 				NVL(A.FUEL_SCG_AMT,0)+ " ).append("\n"); 
		query.append("				NVL(A.SCG_VAT_AMT,0)+ 	" ).append("\n"); 
		query.append(" 				NVL(A.ETC_ADD_AMT,0) +" ).append("\n"); 
		query.append("                NVL(A.TOLL_FEE_AMT,0)		 	" ).append("\n"); 
		query.append(" 			) 	 				" ).append("\n"); 
		query.append(" 	   ELSE A.INV_BZC_AMT		" ).append("\n"); 
		query.append(" END AS INV_BZC_AMT			" ).append("\n"); 
		query.append(" ,	A.INV_ETC_ADD_AMT				" ).append("\n"); 
		query.append(" ,	A.TRSP_WO_OFC_CTY_CD			" ).append("\n"); 
		query.append(" ,	A.TRSP_WO_SEQ" ).append("\n"); 
		query.append(" ,	A.TRSP_WO_OFC_CTY_CD||A.TRSP_WO_SEQ AS TRSP_WO_OFC_CTY_CD_SEQ  	" ).append("\n"); 
		query.append(" ,  B.CRE_USR_ID WO_ISS_ID" ).append("\n"); 
		query.append(" ,  C.USR_NM WO_ISS_NM" ).append("\n"); 
		query.append(" ,	TO_CHAR(A.LOCL_CRE_DT, 'YYYYMMDD')	CRE_DT		" ).append("\n"); 
		query.append(" ,	TO_CHAR(A.LOCL_CRE_DT, 'HH24:MI:SS')	CRE_TM		" ).append("\n"); 
		query.append(" ,	TO_CHAR(A.WO_EXE_DT, 'YYYY-MM-DD HH24:MI:SS')	COP_EXE_DT		" ).append("\n"); 
		query.append(" ,	A.BKG_NO	" ).append("\n"); 
		query.append(" ,	A.BL_NO BL_NO	 	" ).append("\n"); 
		query.append(" ,	A.CGO_TP_CD" ).append("\n"); 
		query.append(" ,	A.SPCL_CGO_CNTR_TP_CD			" ).append("\n"); 
		query.append(" ,	A.TRSP_BND_CD" ).append("\n"); 
		query.append(" ,	A.TRSP_COST_DTL_MOD_CD		" ).append("\n"); 
		query.append(" ,	A.DOR_SVC_TP_CD				" ).append("\n"); 
		query.append(" ,	A.N3PTY_BIL_FLG				" ).append("\n"); 
		query.append(" ,  A.SP_INV_RMK" ).append("\n"); 
		query.append(" ,	A.INV_RMK	" ).append("\n"); 
		query.append(" ,	A.INTER_RMK	" ).append("\n"); 
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
		query.append(" ,	NVL(A.TRSP_FRST_FLG,'N') TRSP_FRST_FLG		" ).append("\n"); 
		query.append(" ,  A.TRO_SEQ" ).append("\n"); 
		query.append(" FROM TRS_TRSP_SVC_ORD A							" ).append("\n"); 
		query.append(" ,    TRS_TRSP_WRK_ORD B		" ).append("\n"); 
		query.append(" ,    COM_USER C" ).append("\n"); 
		query.append(" WHERE 		" ).append("\n"); 
		query.append(" 	  A.VNDR_SEQ IN" ).append("\n"); 
		query.append("		(		" ).append("\n"); 
		query.append("			SELECT" ).append("\n"); 
		query.append("				F.VNDR_SEQ			" ).append("\n"); 
		query.append("			FROM" ).append("\n"); 
		query.append("				MDM_VENDOR F		" ).append("\n"); 
		query.append("			WHERE" ).append("\n"); 
		query.append("				F.VNDR_SEQ			= @[paymt_sp_cd]" ).append("\n"); 
		query.append("			UNION" ).append("\n"); 
		query.append("			SELECT" ).append("\n"); 
		query.append("				F.VNDR_SEQ			" ).append("\n"); 
		query.append("			FROM" ).append("\n"); 
		query.append("				MDM_VENDOR F		" ).append("\n"); 
		query.append("			WHERE" ).append("\n"); 
		query.append("				F.PRNT_VNDR_SEQ		= @[paymt_sp_cd]" ).append("\n"); 
		query.append("		)		" ).append("\n"); 
		query.append(" AND A.TRSP_WO_OFC_CTY_CD            = B.TRSP_WO_OFC_CTY_CD" ).append("\n"); 
		query.append(" AND A.TRSP_WO_SEQ                   = B.TRSP_WO_SEQ" ).append("\n"); 
		query.append(" AND B.CRE_USR_ID                    = C.USR_ID " ).append("\n"); 
		query.append(" AND A.TRSP_SO_STS_CD = 'I'		" ).append("\n"); 
		query.append(" AND A.TRSP_INV_ACT_STS_CD IS NULL	" ).append("\n"); 
		query.append(" AND A.CRE_OFC_CD IN 				" ).append("\n"); 
		query.append(" (	" ).append("\n"); 
		query.append(" 	SELECT OFC_CD FROM				" ).append("\n"); 
		query.append(" 		TRS_TRSP_INV_OFC			" ).append("\n"); 
		query.append(" 	WHERE		" ).append("\n"); 
		query.append(" 		INV_OFC_CD = @[ofc_cd]				" ).append("\n"); 
		query.append(" )	" ).append("\n"); 
		query.append(" AND A.DELT_FLG = 'N' 							" ).append("\n"); 
		query.append("		/* 2008.04.29 ETS OPEN */" ).append("\n"); 
		query.append(" AND A.HJL_NO IS NULL" ).append("\n"); 
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