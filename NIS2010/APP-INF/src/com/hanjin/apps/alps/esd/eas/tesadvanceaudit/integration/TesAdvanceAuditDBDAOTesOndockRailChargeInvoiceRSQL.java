/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : TesAdvanceAuditDBDAOTesOndockRailChargeInvoiceRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.07.17
*@LastModifier : 김종옥
*@LastVersion : 1.0
* 2015.07.17 김종옥
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.eas.tesadvanceaudit.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Jong Ock, Kim
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TesAdvanceAuditDBDAOTesOndockRailChargeInvoiceRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * TesOndockRailChargeInvoice
	  * </pre>
	  */
	public TesAdvanceAuditDBDAOTesOndockRailChargeInvoiceRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_yd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_vndr_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_inv_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.eas.tesadvanceaudit.integration").append("\n"); 
		query.append("FileName : TesAdvanceAuditDBDAOTesOndockRailChargeInvoiceRSQL").append("\n"); 
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
		query.append("SELECT   D.LGS_COST_CD " ).append("\n"); 
		query.append("  , D.CALC_TP_CD" ).append("\n"); 
		query.append("  , D.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("  , D.TML_WRK_DY_CD " ).append("\n"); 
		query.append("  , DECODE(NVL(D.DCGO_IND_CD, 'N'), 'N', 'N', 'Y') AS DCGO_IND_CD" ).append("\n"); 
		query.append("  , D.CALC_VOL_QTY" ).append("\n"); 
		query.append("  , D.RVIS_VOL_QTY" ).append("\n"); 
		query.append("  , D.VOL_TR_UT_CD" ).append("\n"); 
		query.append("  , D.CTRT_RT" ).append("\n"); 
		query.append("  , H.CURR_CD" ).append("\n"); 
		query.append("  , D.INV_XCH_RT" ).append("\n"); 
		query.append("  , D.INV_AMT" ).append("\n"); 
		query.append("  , D.CALC_AMT" ).append("\n"); 
		query.append("  , D.CALC_RMK" ).append("\n"); 
		query.append("  , D.N3PTY_FLG" ).append("\n"); 
		query.append("  , CASE WHEN CALC_VOL_QTY <> RVIS_VOL_QTY THEN 'Y' END AS VOL_DIFF_FLG" ).append("\n"); 
		query.append("  , CASE WHEN CALC_TP_CD = 'M' THEN 'Y' END AS CALC_TP_CD_AUD" ).append("\n"); 
		query.append("  , ( SELECT WM_CONCAT(DISTINCT X.DSCR_IND_CD)" ).append("\n"); 
		query.append("   FROM TES_TML_SO_CNTR_LIST X" ).append("\n"); 
		query.append("   WHERE X.TML_SO_OFC_CTY_CD   = D.TML_SO_OFC_CTY_CD" ).append("\n"); 
		query.append("   AND  X.TML_SO_SEQ          = D.TML_SO_SEQ" ).append("\n"); 
		query.append("   AND  NVL(X.CNTR_TPSZ_CD, 'N')  = NVL(D.CNTR_TPSZ_CD, 'N')" ).append("\n"); 
		query.append("   AND  NVL(X.IO_BND_CD, 'N')  = NVL(D.IO_BND_CD, 'N')" ).append("\n"); 
		query.append("   AND  NVL(X.IOC_CD, 'N')   = NVL(D.IOC_CD, 'N')" ).append("\n"); 
		query.append("   AND  NVL(X.LANE_CD, 'N')   = NVL(D.LANE_CD, 'N')" ).append("\n"); 
		query.append("   AND  DECODE(X.CNTR_STY_CD, 'F', 'F', 'M') = SUBSTR(D.LGS_COST_CD, 6, 1)" ).append("\n"); 
		query.append("   AND  NVL(X.DCGO_CLSS_CD, 'N') = NVL(D.DCGO_IND_CD, 'N')" ).append("\n"); 
		query.append("   AND  DECODE(TO_CHAR(X.WRK_DT,'DY'),'SAT','SA','SUN','SU','HOL','HO','WD') = D.TML_WRK_DY_CD " ).append("\n"); 
		query.append("   AND  (X.VRFY_RSLT_IND_CD = 'CO' AND X.MODI_FLG = 'Y')" ).append("\n"); 
		query.append("    ) AS DSCR_CTNT" ).append("\n"); 
		query.append("  , DECODE(( SELECT EAC_NO" ).append("\n"); 
		query.append("   FROM   EAS_TML_AUD E" ).append("\n"); 
		query.append("       , EAS_TML_AUD_DTL EA" ).append("\n"); 
		query.append("   WHERE  1 = 1" ).append("\n"); 
		query.append("   AND    E.INV_NO      = H.INV_NO" ).append("\n"); 
		query.append("   AND    E.YD_CD       = H.YD_CD" ).append("\n"); 
		query.append("   AND    E.VNDR_SEQ    = H.VNDR_SEQ" ).append("\n"); 
		query.append("   AND    E.INV_CFM_DT  = H.INV_CFM_DT" ).append("\n"); 
		query.append("   AND    E.INV_NO      = EA.INV_NO(+)" ).append("\n"); 
		query.append("   AND    E.VNDR_SEQ    = EA.VNDR_SEQ(+)" ).append("\n"); 
		query.append("   AND    E.INV_CFM_DT  = EA.INV_CFM_DT(+)" ).append("\n"); 
		query.append("   AND    E.EXPN_AUD_SEQ = EA.EXPN_AUD_SEQ(+)" ).append("\n"); 
		query.append("   AND    D.CALC_TP_CD = EA.CALC_TP_CD(+)" ).append("\n"); 
		query.append("   AND    D.LGS_COST_CD = EA.LGS_COST_CD(+)" ).append("\n"); 
		query.append("   AND    D.CNTR_TPSZ_CD = EA.CNTR_TPSZ_CD(+)" ).append("\n"); 
		query.append("   AND    D.TML_WRK_DY_CD= EA.TML_WRK_DY_CD(+)" ).append("\n"); 
		query.append("   AND    DECODE(D.DCGO_IND_CD, NULL, 'N', 'N', 'N', 'Y') = EA.DCGO_FLG(+)" ).append("\n"); 
		query.append("    ), NULL, 'N', 'Y') AS EAC_FLG" ).append("\n"); 
		query.append("  , ( SELECT EXPN_AUD_SEQ" ).append("\n"); 
		query.append("   FROM EAS_TML_AUD E" ).append("\n"); 
		query.append("   WHERE  1    = 1" ).append("\n"); 
		query.append("   AND    E.INV_NO      = H.INV_NO" ).append("\n"); 
		query.append("   AND    E.YD_CD       = H.YD_CD" ).append("\n"); 
		query.append("   AND    E.VNDR_SEQ    = H.VNDR_SEQ" ).append("\n"); 
		query.append("   AND    E.INV_CFM_DT  = H.INV_CFM_DT" ).append("\n"); 
		query.append("    ) AS EXPN_AUD_SEQ" ).append("\n"); 
		query.append("  , H.YD_CD" ).append("\n"); 
		query.append("  , H.INV_OFC_CD" ).append("\n"); 
		query.append("  , (SELECT YD_NM FROM MDM_YARD WHERE YD_CD = H.YD_CD) AS YD_NM" ).append("\n"); 
		query.append("  , H.INV_NO" ).append("\n"); 
		query.append("  , H.VNDR_SEQ" ).append("\n"); 
		query.append("  , (SELECT VNDR_LGL_ENG_NM FROM MDM_VENDOR WHERE VNDR_SEQ = H.VNDR_SEQ) AS VNDR_NM  " ).append("\n"); 
		query.append("  , TO_CHAR(H.INV_CFM_DT, 'YYYYMMDDHH24MISS') AS INV_CFM_DT" ).append("\n"); 
		query.append("  , H.TML_INV_TP_CD" ).append("\n"); 
		query.append("  , D.TML_AGMT_OFC_CTY_CD" ).append("\n"); 
		query.append("  , D.TML_AGMT_SEQ" ).append("\n"); 
		query.append("  , D.TML_AGMT_VER_NO" ).append("\n"); 
		query.append("  , D.TML_AGMT_OFC_CTY_CD || LPAD(D.TML_AGMT_SEQ, 5, '0') AS AGMT_NO" ).append("\n"); 
		query.append("  , SUBSTR(LPAD(D.TML_AGMT_VER_NO, 4, '0'), 0, 2 ) || '.' || SUBSTR(LPAD(D.TML_AGMT_VER_NO, 4, '0'), 3, 2 ) AS AGMT_VER_NO" ).append("\n"); 
		query.append("FROM    TES_TML_SO_HDR H" ).append("\n"); 
		query.append("  , TES_TML_SO_DTL D" ).append("\n"); 
		query.append("WHERE 1 = 1" ).append("\n"); 
		query.append("AND  H.TML_SO_OFC_CTY_CD  = D.TML_SO_OFC_CTY_CD" ).append("\n"); 
		query.append("AND  H.TML_SO_SEQ   = D.TML_SO_SEQ" ).append("\n"); 
		query.append("AND  NVL(H.DELT_FLG, 'N') <> 'Y'" ).append("\n"); 
		query.append("AND  H.TML_INV_STS_CD  <> 'R'" ).append("\n"); 
		query.append("AND  H.TML_INV_RJCT_STS_CD <> 'RJ'" ).append("\n"); 
		query.append("AND  H.TML_INV_TP_CD   = 'ON'" ).append("\n"); 
		query.append("AND  H.YD_CD      = @[s_yd_cd]" ).append("\n"); 
		query.append("AND  H.VNDR_SEQ   = @[s_vndr_seq]" ).append("\n"); 
		query.append("AND  H.INV_NO     = @[s_inv_no]" ).append("\n"); 

	}
}