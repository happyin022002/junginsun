/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : TESeBillingManageBizType004DBDAOValidateEDIInvoice02RSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.02.08
*@LastModifier : 
*@LastVersion : 1.0
* 2017.02.08 
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

public class TESeBillingManageBizType004DBDAOValidateEDIInvoice02RSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * EDI로 접수된 Invoice의 VVD 유효성을 체크한다.
	  * </pre>
	  */
	public TESeBillingManageBizType004DBDAOValidateEDIInvoice02RSQL(){
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
		query.append("FileName : TESeBillingManageBizType004DBDAOValidateEDIInvoice02RSQL").append("\n"); 
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
		query.append("SELECT	DISTINCT VVD_CHK" ).append("\n"); 
		query.append("FROM	(" ).append("\n"); 
		query.append("	SELECT" ).append("\n"); 
		query.append("		CASE WHEN (SUBSTR(X.TML_INV_TP_CD,1,1) = 'M' AND X.IO_IND_CD IS NOT NULL AND X.IO_IND_CD IN('I','O','B'))" ).append("\n"); 
		query.append("			THEN CASE WHEN (SELECT" ).append("\n"); 
		query.append("						(SELECT DECODE(L.VSL_SVC_TP_CD,'O',DECODE(NVL(M.CRR_CD,''),'SML','H','C'),'H')" ).append("\n"); 
		query.append("						FROM   VSK_VSL_SKD S" ).append("\n"); 
		query.append("							, MDM_VSL_SVC_LANE L" ).append("\n"); 
		query.append("							, MDM_VSL_CNTR M" ).append("\n"); 
		query.append("						WHERE  S.VSL_CD     = SUBSTR(X.VVD_CD,1,4)" ).append("\n"); 
		query.append("						AND    S.SKD_VOY_NO = SUBSTR(X.VVD_CD,5,4)" ).append("\n"); 
		query.append("						AND    S.SKD_DIR_CD = SUBSTR(X.VVD_CD,9)" ).append("\n"); 
		query.append("						AND    S.VSL_SLAN_CD    = L.VSL_SLAN_CD(+) " ).append("\n"); 
		query.append("						AND    S.VSL_CD      = M.VSL_CD(+) )||'|'" ).append("\n"); 
		query.append("								     ||TO_CHAR(V.VPS_ETB_DT,'YYYY-MM-DD')" ).append("\n"); 
		query.append("								     ||'|'||A.REV_YRMON ATB_DT" ).append("\n"); 
		query.append("					FROM	VSK_VSL_PORT_SKD V" ).append("\n"); 
		query.append("						, AR_MST_REV_VVD A" ).append("\n"); 
		query.append("					WHERE V.VSL_CD      = SUBSTR(X.VVD_CD,1,4)" ).append("\n"); 
		query.append("					AND   V.SKD_VOY_NO  = SUBSTR(X.VVD_CD,5,4)" ).append("\n"); 
		query.append("					AND   V.SKD_DIR_CD  = SUBSTR(X.VVD_CD,9)" ).append("\n"); 
		query.append("					AND   V.VPS_PORT_CD = SUBSTR(X.YD_CD,1,5)" ).append("\n"); 
		query.append("					AND   V.VSL_CD  	= A.VSL_CD(+)" ).append("\n"); 
		query.append("					AND   V.SKD_VOY_NO  = A.SKD_VOY_NO(+)" ).append("\n"); 
		query.append("					AND   V.SKD_DIR_CD  = A.SKD_DIR_CD(+) AND ROWNUM = 1" ).append("\n"); 
		query.append("					AND   X.VVD_CD IS NOT NULL" ).append("\n"); 
		query.append("					AND   SUBSTR(X.VVD_CD,1,4) <> 'CNTC'" ).append("\n"); 
		query.append("					UNION ALL" ).append("\n"); 
		query.append("					SELECT DECODE(NVL(M.DELT_FLG,'N'),'N','N','Y',NULL,NULL) CHK" ).append("\n"); 
		query.append("					FROM	AR_MST_REV_VVD M" ).append("\n"); 
		query.append("					WHERE	M.VSL_CD||M.SKD_VOY_NO||M.SKD_DIR_CD = X.VVD_CD" ).append("\n"); 
		query.append("					AND	X.VVD_CD IS NOT NULL" ).append("\n"); 
		query.append("					AND	SUBSTR(X.VVD_CD,1,4) = 'CNTC'" ).append("\n"); 
		query.append("					AND   ROWNUM = 1" ).append("\n"); 
		query.append("					) IS NULL" ).append("\n"); 
		query.append("				THEN 'WRONG VVD AT CNTR LIST'" ).append("\n"); 
		query.append("				ELSE ''" ).append("\n"); 
		query.append("			END" ).append("\n"); 
		query.append("			ELSE ''" ).append("\n"); 
		query.append("		END VVD_CHK" ).append("\n"); 
		query.append("	FROM	(" ).append("\n"); 
		query.append("        SELECT Y.TML_INV_TP_CD, Y.VNDR_SEQ, Y.YD_CD, Y.IO_IND_CD, Y.VVD_CD FROM (" ).append("\n"); 
		query.append("        SELECT DISTINCT H.TML_INV_TP_CD, H.VNDR_SEQ, H.YD_CD, H.IO_IND_CD, D.IB_VVD_CD VVD_CD" ).append("\n"); 
		query.append("        FROM TES_EDI_SO_HDR H, TES_EDI_SO_CNTR_LIST D" ).append("\n"); 
		query.append("        WHERE 1 = 1" ).append("\n"); 
		query.append("          AND H.TML_EDI_SO_OFC_CTY_CD = @[tml_edi_so_ofc_cty_cd]" ).append("\n"); 
		query.append("          AND H.TML_EDI_SO_SEQ = @[tml_edi_so_seq]" ).append("\n"); 
		query.append("          AND H.TML_EDI_SO_OFC_CTY_CD = D.TML_EDI_SO_OFC_CTY_CD" ).append("\n"); 
		query.append("          AND H.TML_EDI_SO_SEQ = D.TML_EDI_SO_SEQ" ).append("\n"); 
		query.append("          AND H.TML_INV_TP_CD IS NOT NULL" ).append("\n"); 
		query.append("          AND H.VNDR_SEQ IN ('158002','114776') AND H.TML_INV_TP_CD IN ('MA','MK') AND H.IO_IND_CD IN ('B','I')" ).append("\n"); 
		query.append("        UNION" ).append("\n"); 
		query.append("        SELECT DISTINCT H.TML_INV_TP_CD, H.VNDR_SEQ, H.YD_CD, H.IO_IND_CD, D.OB_VVD_CD VVD_CD" ).append("\n"); 
		query.append("        FROM TES_EDI_SO_HDR H, TES_EDI_SO_CNTR_LIST D" ).append("\n"); 
		query.append("        WHERE 1 = 1" ).append("\n"); 
		query.append("          AND H.TML_EDI_SO_OFC_CTY_CD = @[tml_edi_so_ofc_cty_cd]" ).append("\n"); 
		query.append("          AND H.TML_EDI_SO_SEQ = @[tml_edi_so_seq]" ).append("\n"); 
		query.append("          AND H.TML_EDI_SO_OFC_CTY_CD = D.TML_EDI_SO_OFC_CTY_CD" ).append("\n"); 
		query.append("          AND H.TML_EDI_SO_SEQ = D.TML_EDI_SO_SEQ" ).append("\n"); 
		query.append("          AND H.TML_INV_TP_CD IS NOT NULL" ).append("\n"); 
		query.append("          AND H.VNDR_SEQ IN ('158002','114776') AND H.TML_INV_TP_CD IN ('MA','MK') AND H.IO_IND_CD IN ('B','O') ) Y --// 2011-06-02: HIT/YICT만 별도 관리" ).append("\n"); 
		query.append("		) X" ).append("\n"); 
		query.append("	UNION ALL" ).append("\n"); 
		query.append("	SELECT" ).append("\n"); 
		query.append("		 CASE WHEN (SUBSTR(X.TML_INV_TP_CD,1,1) = 'M' AND X.IO_IND_CD IS NOT NULL AND X.IO_IND_CD IN('I','O','B'))" ).append("\n"); 
		query.append("			THEN CASE WHEN (SELECT" ).append("\n"); 
		query.append("						(SELECT DECODE(L.VSL_SVC_TP_CD,'O',DECODE(NVL(M.CRR_CD,''),'SML','H','C'),'H')" ).append("\n"); 
		query.append("						FROM   VSK_VSL_SKD S" ).append("\n"); 
		query.append("							, MDM_VSL_SVC_LANE L" ).append("\n"); 
		query.append("							, MDM_VSL_CNTR M" ).append("\n"); 
		query.append("						WHERE  S.VSL_CD     = SUBSTR(X.VVD_CD,1,4)" ).append("\n"); 
		query.append("						AND    S.SKD_VOY_NO = SUBSTR(X.VVD_CD,5,4)" ).append("\n"); 
		query.append("						AND    S.SKD_DIR_CD = SUBSTR(X.VVD_CD,9)" ).append("\n"); 
		query.append("						AND    S.VSL_SLAN_CD    = L.VSL_SLAN_CD(+)" ).append("\n"); 
		query.append("						AND    S.VSL_CD      = M.VSL_CD(+) )||'|'" ).append("\n"); 
		query.append("								     ||TO_CHAR(V.VPS_ETB_DT,'YYYY-MM-DD')" ).append("\n"); 
		query.append("								     ||'|'||A.REV_YRMON ATB_DT" ).append("\n"); 
		query.append("					FROM	VSK_VSL_PORT_SKD V" ).append("\n"); 
		query.append("						, AR_MST_REV_VVD A" ).append("\n"); 
		query.append("					WHERE V.VSL_CD      = SUBSTR(X.VVD_CD,1,4)" ).append("\n"); 
		query.append("					AND   V.SKD_VOY_NO  = SUBSTR(X.VVD_CD,5,4)" ).append("\n"); 
		query.append("					AND   V.SKD_DIR_CD  = SUBSTR(X.VVD_CD,9)" ).append("\n"); 
		query.append("					AND   V.VPS_PORT_CD = SUBSTR(X.YD_CD,1,5)" ).append("\n"); 
		query.append("					AND   V.VSL_CD  	= A.VSL_CD(+)" ).append("\n"); 
		query.append("					AND   V.SKD_VOY_NO  = A.SKD_VOY_NO(+)" ).append("\n"); 
		query.append("					AND   V.SKD_DIR_CD  = A.SKD_DIR_CD(+) AND ROWNUM = 1" ).append("\n"); 
		query.append("					AND   X.VVD_CD IS NOT NULL" ).append("\n"); 
		query.append("					AND   SUBSTR(X.VVD_CD,1,4) <> 'CNTC'" ).append("\n"); 
		query.append("					UNION ALL" ).append("\n"); 
		query.append("					SELECT	DECODE(NVL(M.DELT_FLG,'N'),'N','N','Y',NULL,NULL) CHK" ).append("\n"); 
		query.append("					FROM	AR_MST_REV_VVD M" ).append("\n"); 
		query.append("					WHERE	M.VSL_CD||M.SKD_VOY_NO||M.SKD_DIR_CD = X.VVD_CD" ).append("\n"); 
		query.append("					AND	X.VVD_CD IS NOT NULL" ).append("\n"); 
		query.append("					AND	  SUBSTR(X.VVD_CD,1,4) = 'CNTC'" ).append("\n"); 
		query.append("					AND   ROWNUM = 1" ).append("\n"); 
		query.append("					) IS NULL" ).append("\n"); 
		query.append("				THEN 'WRONG VVD AT DTL LIST'" ).append("\n"); 
		query.append("				ELSE ''" ).append("\n"); 
		query.append("			END" ).append("\n"); 
		query.append("			ELSE ''" ).append("\n"); 
		query.append("		END VVD_CHK" ).append("\n"); 
		query.append("	FROM" ).append("\n"); 
		query.append("		(" ).append("\n"); 
		query.append("        SELECT Y.TML_INV_TP_CD, Y.VNDR_SEQ, Y.YD_CD, Y.IO_IND_CD, Y.VVD_CD FROM (    " ).append("\n"); 
		query.append("        SELECT DISTINCT H.TML_INV_TP_CD, H.VNDR_SEQ, H.YD_CD, H.IO_IND_CD, D.IB_VVD_CD VVD_CD" ).append("\n"); 
		query.append("        FROM TES_EDI_SO_HDR H, TES_EDI_SO_DTL D" ).append("\n"); 
		query.append("        WHERE 1 = 1" ).append("\n"); 
		query.append("          AND H.TML_EDI_SO_OFC_CTY_CD = @[tml_edi_so_ofc_cty_cd]" ).append("\n"); 
		query.append("          AND H.TML_EDI_SO_SEQ = @[tml_edi_so_seq]" ).append("\n"); 
		query.append("          AND H.TML_EDI_SO_OFC_CTY_CD = D.TML_EDI_SO_OFC_CTY_CD" ).append("\n"); 
		query.append("          AND H.TML_EDI_SO_SEQ = D.TML_EDI_SO_SEQ" ).append("\n"); 
		query.append("          AND H.TML_INV_TP_CD IS NOT NULL" ).append("\n"); 
		query.append("          AND H.VNDR_SEQ IN ('158002','114776') AND H.TML_INV_TP_CD IN ('MR') AND H.IO_IND_CD IN ('B','I')" ).append("\n"); 
		query.append("        UNION" ).append("\n"); 
		query.append("        SELECT DISTINCT H.TML_INV_TP_CD, H.VNDR_SEQ, H.YD_CD, H.IO_IND_CD, D.OB_VVD_CD VVD_CD" ).append("\n"); 
		query.append("        FROM TES_EDI_SO_HDR H ," ).append("\n"); 
		query.append("          TES_EDI_SO_DTL D" ).append("\n"); 
		query.append("        WHERE 1 = 1" ).append("\n"); 
		query.append("          AND H.TML_EDI_SO_OFC_CTY_CD = @[tml_edi_so_ofc_cty_cd]" ).append("\n"); 
		query.append("          AND H.TML_EDI_SO_SEQ = @[tml_edi_so_seq]" ).append("\n"); 
		query.append("          AND H.TML_EDI_SO_OFC_CTY_CD = D.TML_EDI_SO_OFC_CTY_CD" ).append("\n"); 
		query.append("          AND H.TML_EDI_SO_SEQ = D.TML_EDI_SO_SEQ" ).append("\n"); 
		query.append("          AND H.TML_INV_TP_CD IS NOT NULL" ).append("\n"); 
		query.append("          AND H.VNDR_SEQ IN ('158002','114776') AND H.TML_INV_TP_CD IN ('MR') AND H.IO_IND_CD IN ('B','O')  ) Y --// 2011-06-02: HIT/YICT만 별도 관리" ).append("\n"); 
		query.append("		) X" ).append("\n"); 
		query.append("	)" ).append("\n"); 
		query.append("WHERE	VVD_CHK IS NOT NULL" ).append("\n"); 

	}
}