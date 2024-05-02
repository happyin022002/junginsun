/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : TESeBillingManageBizType002DBDAOGetEDInvoiceToUpdateCntrListVVDRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.09.14
*@LastModifier : 
*@LastVersion : 1.0
* 2012.09.14 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.tes.edi.ebilling.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TESeBillingManageBizType002DBDAOGetEDInvoiceToUpdateCntrListVVDRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 정규 VVD가 없어서 CALL SIGN / LLOYD CD / BKG REF NO로 VVD Update해야 할 CNTR LIST 대상 조회
	  * </pre>
	  */
	public TESeBillingManageBizType002DBDAOGetEDInvoiceToUpdateCntrListVVDRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("tml_edi_so_ofc_cty_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("tml_edi_so_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.tes.edi.ebilling.integration").append("\n"); 
		query.append("FileName : TESeBillingManageBizType002DBDAOGetEDInvoiceToUpdateCntrListVVDRSQL").append("\n"); 
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
		query.append("Y.TML_EDI_SO_OFC_CTY_CD, Y.TML_EDI_SO_SEQ, Y.TML_EDI_SO_CNTR_LIST_SEQ," ).append("\n"); 
		query.append("CASE" ).append("\n"); 
		query.append("WHEN Y.VVD IS NOT NULL AND LENGTH(Y.VVD) = 9" ).append("\n"); 
		query.append("THEN SUBSTR(Y.VVD,1,4)" ).append("\n"); 
		query.append("ELSE ''" ).append("\n"); 
		query.append("END VSL_CD," ).append("\n"); 
		query.append("CASE" ).append("\n"); 
		query.append("WHEN Y.VVD IS NOT NULL AND LENGTH(Y.VVD) = 9" ).append("\n"); 
		query.append("THEN SUBSTR(Y.VVD,5,4)" ).append("\n"); 
		query.append("ELSE ''" ).append("\n"); 
		query.append("END SKD_VOY_NO," ).append("\n"); 
		query.append("CASE" ).append("\n"); 
		query.append("WHEN Y.VVD IS NOT NULL AND LENGTH(Y.VVD) = 9" ).append("\n"); 
		query.append("THEN SUBSTR(Y.VVD,9)" ).append("\n"); 
		query.append("ELSE ''" ).append("\n"); 
		query.append("END SKD_DIR_CD," ).append("\n"); 
		query.append("Y.VVD_SRC CNTR_RMK" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("X.TML_EDI_SO_OFC_CTY_CD, X.TML_EDI_SO_SEQ, X.TML_EDI_SO_CNTR_LIST_SEQ," ).append("\n"); 
		query.append("CASE" ).append("\n"); 
		query.append("WHEN X.ORG_VVD IS NOT NULL AND LENGTH(X.ORG_VVD) = 9" ).append("\n"); 
		query.append("THEN X.ORG_VVD" ).append("\n"); 
		query.append("ELSE" ).append("\n"); 
		query.append("CASE" ).append("\n"); 
		query.append("WHEN X.SKD_EDI_LOG_VVD IS NOT NULL AND LENGTH(X.SKD_EDI_LOG_VVD) = 9" ).append("\n"); 
		query.append("THEN X.SKD_EDI_LOG_VVD" ).append("\n"); 
		query.append("WHEN X.BKG_NO_VVD IS NOT NULL AND LENGTH(X.BKG_NO_VVD) = 9" ).append("\n"); 
		query.append("THEN X.BKG_NO_VVD" ).append("\n"); 
		query.append("WHEN X.BKG_CNTR_VVD IS NOT NULL AND LENGTH(X.BKG_CNTR_VVD) = 9" ).append("\n"); 
		query.append("THEN X.BKG_CNTR_VVD" ).append("\n"); 
		query.append("WHEN X.BKG_REF_VVD IS NOT NULL AND LENGTH(X.BKG_REF_VVD) = 9" ).append("\n"); 
		query.append("THEN X.BKG_REF_VVD" ).append("\n"); 
		query.append("WHEN X.MST_CNTR_VVD IS NOT NULL AND LENGTH(X.MST_CNTR_VVD) = 9" ).append("\n"); 
		query.append("THEN X.MST_CNTR_VVD" ).append("\n"); 
		query.append("WHEN X.PORT_SKD_VVD IS NOT NULL AND LENGTH(X.PORT_SKD_VVD) = 9" ).append("\n"); 
		query.append("THEN X.PORT_SKD_VVD" ).append("\n"); 
		query.append("END" ).append("\n"); 
		query.append("END VVD," ).append("\n"); 
		query.append("CASE" ).append("\n"); 
		query.append("WHEN X.ORG_VVD IS NOT NULL AND LENGTH(X.ORG_VVD) = 9" ).append("\n"); 
		query.append("THEN 'ORG_VVD'" ).append("\n"); 
		query.append("ELSE" ).append("\n"); 
		query.append("CASE" ).append("\n"); 
		query.append("WHEN X.SKD_EDI_LOG_VVD IS NOT NULL AND LENGTH(X.SKD_EDI_LOG_VVD) = 9" ).append("\n"); 
		query.append("THEN 'SKD_EDI_LOG_VVD'" ).append("\n"); 
		query.append("WHEN X.BKG_NO_VVD IS NOT NULL AND LENGTH(X.BKG_NO_VVD) = 9" ).append("\n"); 
		query.append("THEN 'BKG_NO_VVD'" ).append("\n"); 
		query.append("WHEN X.BKG_CNTR_VVD IS NOT NULL AND LENGTH(X.BKG_CNTR_VVD) = 9" ).append("\n"); 
		query.append("THEN 'BKG_CNTR_VVD'" ).append("\n"); 
		query.append("WHEN X.BKG_REF_VVD IS NOT NULL AND LENGTH(X.BKG_REF_VVD) = 9" ).append("\n"); 
		query.append("THEN 'BKG_REF_VVD'" ).append("\n"); 
		query.append("WHEN X.MST_CNTR_VVD IS NOT NULL AND LENGTH(X.MST_CNTR_VVD) = 9" ).append("\n"); 
		query.append("THEN 'MST_CNTR_VVD'" ).append("\n"); 
		query.append("WHEN X.PORT_SKD_VVD IS NOT NULL AND LENGTH(X.PORT_SKD_VVD) = 9" ).append("\n"); 
		query.append("THEN 'PORT_SKD_VVD'" ).append("\n"); 
		query.append("END" ).append("\n"); 
		query.append("END VVD_SRC" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("D.TML_EDI_SO_OFC_CTY_CD, D.TML_EDI_SO_SEQ, D.TML_EDI_SO_CNTR_LIST_SEQ, D.VSL_CD||D.SKD_VOY_NO||D.SKD_DIR_CD ORG_VVD, D.MDM_VSL_CD," ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("V.VSL_CD||V.SKD_VOY_NO||V.SKD_DIR_CD VVD" ).append("\n"); 
		query.append("FROM VSK_ACT_PORT_SKD_EDI_LOG V" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND V.RCV_DT >= TO_DATE('190001010000','YYYYMMDDHH24MI')" ).append("\n"); 
		query.append("AND V.RCV_SEQ >= 1" ).append("\n"); 
		query.append("AND V.YD_CD = D.YD_CD" ).append("\n"); 
		query.append("AND NVL(V.SCS_FLG,'N')='Y'" ).append("\n"); 
		query.append("AND NVL(V.CALL_SGN_NO,'N') = NVL(D.CALL_SGN_NO,'N')" ).append("\n"); 
		query.append("AND NVL(V.LLOYD_NO,'N') = NVL(D.LLOYD_NO,'N')" ).append("\n"); 
		query.append("AND ROWNUM = 1" ).append("\n"); 
		query.append(") SKD_EDI_LOG_VVD" ).append("\n"); 
		query.append("," ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("V.VSL_CD||V.SKD_VOY_NO||V.SKD_DIR_CD VVD" ).append("\n"); 
		query.append("FROM BKG_BOOKING B, BKG_VVD V" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND B.BKG_NO = V.BKG_NO(+)" ).append("\n"); 
		query.append("AND B.BKG_NO = D.BKG_NO" ).append("\n"); 
		query.append("AND B.BKG_STS_CD IN ('F','W')" ).append("\n"); 
		query.append("AND DECODE(D.IO_BND_CD,'I',V.POD_CD,V.POL_CD) = SUBSTR(D.YD_CD,1, 5)" ).append("\n"); 
		query.append("AND CASE" ).append("\n"); 
		query.append("WHEN (D.CALL_SGN_NO IS NOT NULL OR D.LLOYD_NO IS NOT NULL OR D.VSL_NM IS NOT NULL)" ).append("\n"); 
		query.append("THEN NVL(V.VSL_CD,'X')" ).append("\n"); 
		query.append("ELSE 'X'" ).append("\n"); 
		query.append("END =" ).append("\n"); 
		query.append("CASE" ).append("\n"); 
		query.append("WHEN (D.CALL_SGN_NO IS NOT NULL OR D.LLOYD_NO IS NOT NULL OR D.VSL_NM IS NOT NULL)" ).append("\n"); 
		query.append("THEN NVL(D.MDM_VSL_CD,'X')" ).append("\n"); 
		query.append("ELSE 'N' --//VSL_CD를 정확히 못찾으면 버려야함" ).append("\n"); 
		query.append("END" ).append("\n"); 
		query.append("AND ROWNUM = 1" ).append("\n"); 
		query.append(") BKG_NO_VVD" ).append("\n"); 
		query.append("," ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("V.VSL_CD||V.SKD_VOY_NO||V.SKD_DIR_CD VVD" ).append("\n"); 
		query.append("FROM BKG_BOOKING B, BKG_CONTAINER C, BKG_VVD V" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND DECODE(D.IO_BND_CD,'I',V.POD_CD,V.POL_CD) = SUBSTR(D.YD_CD,1, 5)" ).append("\n"); 
		query.append("AND B.BKG_NO = C.BKG_NO(+)" ).append("\n"); 
		query.append("AND C.BKG_NO = V.BKG_NO(+)" ).append("\n"); 
		query.append("AND B.BKG_STS_CD IN ('F','W')" ).append("\n"); 
		query.append("AND C.CNTR_NO = D.CNTR_NO" ).append("\n"); 
		query.append("AND CASE" ).append("\n"); 
		query.append("WHEN (D.CALL_SGN_NO IS NOT NULL OR D.LLOYD_NO IS NOT NULL OR D.VSL_NM IS NOT NULL)" ).append("\n"); 
		query.append("THEN NVL(V.VSL_CD,'X')" ).append("\n"); 
		query.append("ELSE 'X'" ).append("\n"); 
		query.append("END =" ).append("\n"); 
		query.append("CASE" ).append("\n"); 
		query.append("WHEN (D.CALL_SGN_NO IS NOT NULL OR D.LLOYD_NO IS NOT NULL OR D.VSL_NM IS NOT NULL)" ).append("\n"); 
		query.append("THEN NVL(D.MDM_VSL_CD,'X')" ).append("\n"); 
		query.append("ELSE 'N' --//VSL_CD를 정확히 못찾으면 버려야함" ).append("\n"); 
		query.append("END" ).append("\n"); 
		query.append("AND ROWNUM = 1" ).append("\n"); 
		query.append(") BKG_CNTR_VVD" ).append("\n"); 
		query.append("," ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("DISTINCT" ).append("\n"); 
		query.append("V.VSL_CD||V.SKD_VOY_NO||V.SKD_DIR_CD VVD" ).append("\n"); 
		query.append("FROM BKG_REFERENCE R, BKG_VVD V" ).append("\n"); 
		query.append("WHERE R.BKG_NO = V.BKG_NO" ).append("\n"); 
		query.append("AND R.CUST_REF_NO_CTNT = D.CUST_REF_NO_CTNT" ).append("\n"); 
		query.append("AND DECODE(D.IO_BND_CD,'I',V.POD_CD,V.POL_CD) = SUBSTR(D.YD_CD,1, 5)" ).append("\n"); 
		query.append("AND CASE" ).append("\n"); 
		query.append("WHEN (D.CALL_SGN_NO IS NOT NULL OR D.LLOYD_NO IS NOT NULL OR D.VSL_NM IS NOT NULL)" ).append("\n"); 
		query.append("THEN NVL(V.VSL_CD,'X')" ).append("\n"); 
		query.append("ELSE 'X'" ).append("\n"); 
		query.append("END =" ).append("\n"); 
		query.append("CASE" ).append("\n"); 
		query.append("WHEN (D.CALL_SGN_NO IS NOT NULL OR D.LLOYD_NO IS NOT NULL OR D.VSL_NM IS NOT NULL)" ).append("\n"); 
		query.append("THEN NVL(D.MDM_VSL_CD,'X')" ).append("\n"); 
		query.append("ELSE 'N' --//VSL_CD를 정확히 못찾으면 버려야함" ).append("\n"); 
		query.append("END" ).append("\n"); 
		query.append("AND ROWNUM = 1" ).append("\n"); 
		query.append(") BKG_REF_VVD" ).append("\n"); 
		query.append("," ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT M.VSL_CD||M.SKD_VOY_NO||M.SKD_DIR_CD VVD" ).append("\n"); 
		query.append("FROM MST_CONTAINER M" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND M.CNTR_NO = D.CNTR_NO" ).append("\n"); 
		query.append("AND CASE" ).append("\n"); 
		query.append("WHEN (D.CALL_SGN_NO IS NOT NULL OR D.LLOYD_NO IS NOT NULL OR D.VSL_NM IS NOT NULL)" ).append("\n"); 
		query.append("THEN NVL(M.VSL_CD,'X')" ).append("\n"); 
		query.append("ELSE 'X'" ).append("\n"); 
		query.append("END =" ).append("\n"); 
		query.append("CASE" ).append("\n"); 
		query.append("WHEN (D.CALL_SGN_NO IS NOT NULL OR D.LLOYD_NO IS NOT NULL OR D.VSL_NM IS NOT NULL)" ).append("\n"); 
		query.append("THEN NVL(D.MDM_VSL_CD,'X')" ).append("\n"); 
		query.append("ELSE 'X' --//VSL_CD를 정확히 못찾아도 CONTAINER NO.별로 유일함에 넘긴다." ).append("\n"); 
		query.append("END" ).append("\n"); 
		query.append("AND ROWNUM = 1" ).append("\n"); 
		query.append(") MST_CNTR_VVD" ).append("\n"); 
		query.append("," ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("P.VSL_CD||P.SKD_VOY_NO||P.SKD_DIR_CD VVD" ).append("\n"); 
		query.append("FROM VSK_VSL_PORT_SKD P" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND P.YD_CD = D.YD_CD" ).append("\n"); 
		query.append("AND P.VPS_ETA_DT BETWEEN TO_DATE(D.ATA_DT,'YYYYMMDD') AND  TO_DATE(D.ATA_DT,'YYYYMMDD') + 0.99999" ).append("\n"); 
		query.append("AND CASE" ).append("\n"); 
		query.append("WHEN (D.CALL_SGN_NO IS NOT NULL OR D.LLOYD_NO IS NOT NULL OR D.VSL_NM IS NOT NULL)" ).append("\n"); 
		query.append("THEN NVL(P.VSL_CD,'X')" ).append("\n"); 
		query.append("ELSE 'X'" ).append("\n"); 
		query.append("END =" ).append("\n"); 
		query.append("CASE" ).append("\n"); 
		query.append("WHEN (D.CALL_SGN_NO IS NOT NULL OR D.LLOYD_NO IS NOT NULL OR D.VSL_NM IS NOT NULL)" ).append("\n"); 
		query.append("THEN NVL(D.MDM_VSL_CD,'X')" ).append("\n"); 
		query.append("ELSE 'N' --//VSL_CD를 정확히 못찾으면 버려야함" ).append("\n"); 
		query.append("END" ).append("\n"); 
		query.append("AND ROWNUM = 1" ).append("\n"); 
		query.append(") PORT_SKD_VVD" ).append("\n"); 
		query.append(", D.CNTR_NO, D.YD_CD, D.IO_BND_CD" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("H.YD_CD, D.*," ).append("\n"); 
		query.append("(SELECT DISTINCT V.VSL_CD FROM MDM_VSL_CNTR V" ).append("\n"); 
		query.append("WHERE (V.CALL_SGN_NO=D.CALL_SGN_NO OR V.LLOYD_NO=D.LLOYD_NO OR UPPER(V.VSL_ENG_NM)=UPPER(D.VSL_NM))" ).append("\n"); 
		query.append("AND V.EAI_EVNT_DT = (" ).append("\n"); 
		query.append("SELECT MAX(V2.EAI_EVNT_DT)" ).append("\n"); 
		query.append("FROM MDM_VSL_CNTR V2 WHERE (V2.CALL_SGN_NO=D.CALL_SGN_NO OR V2.LLOYD_NO=D.LLOYD_NO OR UPPER(V2.VSL_ENG_NM)=UPPER(D.VSL_NM))" ).append("\n"); 
		query.append("AND NVL(V2.DELT_FLG,'N') <> 'Y')" ).append("\n"); 
		query.append("AND ROWNUM = 1) MDM_VSL_CD" ).append("\n"); 
		query.append("FROM TES_EDI_SO_HDR H, TES_EDI_SO_CNTR_LIST D" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND H.TML_EDI_SO_OFC_CTY_CD = D.TML_EDI_SO_OFC_CTY_CD" ).append("\n"); 
		query.append("AND H.TML_EDI_SO_SEQ = D.TML_EDI_SO_SEQ" ).append("\n"); 
		query.append("AND NVL(H.DELT_FLG,'N') <> 'Y'" ).append("\n"); 
		query.append("AND H.TML_INV_TP_CD = 'TM'" ).append("\n"); 
		query.append("AND H.TML_SO_OFC_CTY_CD IS NULL" ).append("\n"); 
		query.append("AND H.TML_SO_SEQ IS NULL" ).append("\n"); 
		query.append("AND (  D.VSL_CD IS NULL OR D.SKD_VOY_NO IS NULL OR D.SKD_DIR_CD IS NULL OR NVL(LENGTH(D.VSL_CD||D.SKD_VOY_NO||D.SKD_DIR_CD),0) <> 9  )" ).append("\n"); 
		query.append("AND H.TML_EDI_SO_OFC_CTY_CD = @[tml_edi_so_ofc_cty_cd]" ).append("\n"); 
		query.append("AND H.TML_EDI_SO_SEQ = @[tml_edi_so_seq]" ).append("\n"); 
		query.append(") D" ).append("\n"); 
		query.append(") X" ).append("\n"); 
		query.append(") Y" ).append("\n"); 

	}
}