/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : RailInvoiceauditDBDAOSearchRailinvoiceauditDtlRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.01.26
*@LastModifier : 박찬우
*@LastVersion : 1.0
* 2016.01.26 박찬우
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.trs.invoicemanage.railinvoiceaudit.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Chanwoo Park
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class RailInvoiceauditDBDAOSearchRailinvoiceauditDtlRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * RailInvoice에 대한 Detail 정보 조회
	  * </pre>
	  */
	public RailInvoiceauditDBDAOSearchRailinvoiceauditDtlRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("invNo",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("invVndrSeq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("railInvAudCd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.trs.invoicemanage.railinvoiceaudit.integration").append("\n"); 
		query.append("FileName : RailInvoiceauditDBDAOSearchRailinvoiceauditDtlRSQL").append("\n"); 
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
		query.append("SELECT X.TRSP_INV_CO_IND_CD" ).append("\n"); 
		query.append("      ,X.TRSP_INV_TP_CD" ).append("\n"); 
		query.append("      ,X.RAIL_BIL_DT" ).append("\n"); 
		query.append("      ,X.WBL_DT" ).append("\n"); 
		query.append("      ,X.WBL_NO" ).append("\n"); 
		query.append("      ,X.INV_RMK" ).append("\n"); 
		query.append("      ,X.SUB_INV_SEQ" ).append("\n"); 
		query.append("      ,X.TRSP_SO_OFC_CTY_CD" ).append("\n"); 
		query.append("      ,X.TRSP_SO_SEQ" ).append("\n"); 
		query.append("      ,X.SUB_RAIL_SEQ" ).append("\n"); 
		query.append("      ,X.ORG_TRSP_RAIL_INV_AUD_CD" ).append("\n"); 
		query.append("      ,X.CRNT_TRSP_RAIL_INV_AUD_CD" ).append("\n"); 
		query.append("      ,X.PAY_FLG" ).append("\n"); 
		query.append("      ,X.EQ_NO" ).append("\n"); 
		query.append("      ,X.EQ_TPSZ_CD" ).append("\n"); 
		query.append("      ,X.CGO_TP_CD" ).append("\n"); 
		query.append("      ,X.FM_NOD_CD1" ).append("\n"); 
		query.append("      ,X.FM_NOD_CD2" ).append("\n"); 
		query.append("      ,X.TO_NOD_CD1" ).append("\n"); 
		query.append("      ,X.TO_NOD_CD2" ).append("\n"); 
		query.append("      ,X.FM_NOD_CD" ).append("\n"); 
		query.append("      ,X.TO_NOD_CD" ).append("\n"); 
		query.append("      ,X.INV_ORG_NOD_NM" ).append("\n"); 
		query.append("      ,X.INV_DEST_NOD_NM" ).append("\n"); 
		query.append("      ,X.CURR_CD" ).append("\n"); 
		query.append("      ,X.BZC_AMT" ).append("\n"); 
		query.append("      ,X.FUEL_SCG_AMT" ).append("\n"); 
		query.append("      ,X.OVR_WGT_SCG_AMT" ).append("\n"); 
		query.append("      ,X.NEGO_AMT" ).append("\n"); 
		query.append("      ,X.INV_CURR_CD" ).append("\n"); 
		query.append("      ,X.INV_BZC_AMT" ).append("\n"); 
		query.append("      ,X.INV_BIL_AMT" ).append("\n"); 
		query.append("      ,X.INV_ETC_ADD_AMT" ).append("\n"); 
		query.append("      ,X.TMP_TRSP_RAIL_INV_AUD_CD" ).append("\n"); 
		query.append("      ,X.HZD_MTRL_SCG_AMT" ).append("\n"); 
		query.append("      ,X.ETC_ADD_AMT" ).append("\n"); 
		query.append("      ,X.WO_EXE_DT" ).append("\n"); 
		query.append("      ,X.ORG_GATE_OUT_DT" ).append("\n"); 
		query.append("      ,X.DEST_GATE_IN_DT" ).append("\n"); 
		query.append("      ,DECODE(X.CGO_TP_CD, 'M', X.INTER_RMK, 'F', DECODE(X.INTER_RMK_CHK, '', '', 'Y')) INTER_RMK" ).append("\n"); 
		query.append("      ,CASE" ).append("\n"); 
		query.append("         WHEN X.CGO_TP_CD = 'F' THEN '1'" ).append("\n"); 
		query.append("         ELSE '0'" ).append("\n"); 
		query.append("       END POP_IMG" ).append("\n"); 
		query.append("      ,X.BKG_NO" ).append("\n"); 
		query.append("  FROM (SELECT A.TRSP_INV_CO_IND_CD" ).append("\n"); 
		query.append("              ,A.TRSP_INV_TP_CD" ).append("\n"); 
		query.append("              ,TO_CHAR(A.RAIL_BIL_DT, 'YYYYMMDD') RAIL_BIL_DT" ).append("\n"); 
		query.append("              ,TO_CHAR(A.WBL_DT, 'YYYYMMDD') WBL_DT" ).append("\n"); 
		query.append("              ,A.WBL_NO" ).append("\n"); 
		query.append("              ,A.INV_RMK" ).append("\n"); 
		query.append("              ,A.SUB_INV_SEQ" ).append("\n"); 
		query.append("              ,A.TRSP_SO_OFC_CTY_CD" ).append("\n"); 
		query.append("              ,A.TRSP_SO_SEQ" ).append("\n"); 
		query.append("              ,A.SUB_RAIL_SEQ" ).append("\n"); 
		query.append("              ,A.ORG_TRSP_RAIL_INV_AUD_CD" ).append("\n"); 
		query.append("              ,A.CRNT_TRSP_RAIL_INV_AUD_CD" ).append("\n"); 
		query.append("              ,A.PAY_FLG" ).append("\n"); 
		query.append("              ,A.EQ_NO" ).append("\n"); 
		query.append("              ,A.EQ_TPSZ_CD" ).append("\n"); 
		query.append("              ,A.CGO_TP_CD" ).append("\n"); 
		query.append("              ,SUBSTR(A.FM_NOD_CD, 0, 5) FM_NOD_CD1" ).append("\n"); 
		query.append("              ,SUBSTR(A.FM_NOD_CD, 6, 7) FM_NOD_CD2" ).append("\n"); 
		query.append("              ,SUBSTR(A.TO_NOD_CD, 0, 5) TO_NOD_CD1" ).append("\n"); 
		query.append("              ,SUBSTR(A.TO_NOD_CD, 6, 7) TO_NOD_CD2" ).append("\n"); 
		query.append("              ,A.FM_NOD_CD" ).append("\n"); 
		query.append("              ,A.TO_NOD_CD" ).append("\n"); 
		query.append("              ,A.INV_ORG_NOD_NM" ).append("\n"); 
		query.append("              ,A.INV_DEST_NOD_NM" ).append("\n"); 
		query.append("              ,A.CURR_CD" ).append("\n"); 
		query.append("              ,A.BZC_AMT" ).append("\n"); 
		query.append("              ,A.FUEL_SCG_AMT" ).append("\n"); 
		query.append("              ,A.OVR_WGT_SCG_AMT" ).append("\n"); 
		query.append("              ,A.NEGO_AMT" ).append("\n"); 
		query.append("              ,A.INV_CURR_CD" ).append("\n"); 
		query.append("              ,A.INV_BZC_AMT" ).append("\n"); 
		query.append("              ,A.INV_BIL_AMT" ).append("\n"); 
		query.append("              ,A.INV_ETC_ADD_AMT" ).append("\n"); 
		query.append("              ,A.TMP_TRSP_RAIL_INV_AUD_CD" ).append("\n"); 
		query.append("              ,A.HZD_MTRL_SCG_AMT" ).append("\n"); 
		query.append("              ,A.ETC_ADD_AMT" ).append("\n"); 
		query.append("              ,NVL(NVL(B.ORG_GATE_OUT_DT, B.DEST_GATE_IN_DT), B.WO_EXE_DT) WO_EXE_DT" ).append("\n"); 
		query.append("              ,B.ORG_GATE_OUT_DT" ).append("\n"); 
		query.append("              ,B.DEST_GATE_IN_DT" ).append("\n"); 
		query.append("              ,B.INTER_RMK" ).append("\n"); 
		query.append("              ,(SELECT MAX(RMK.BKG_NO)" ).append("\n"); 
		query.append("                  FROM TRS_INTER_RMK RMK" ).append("\n"); 
		query.append("                 WHERE RMK.BKG_NO IN(B.BKG_NO," ).append("\n"); 
		query.append("                               'DUM000000000')" ).append("\n"); 
		query.append("                   AND NVL(RMK.EQ_NO, 'X') = NVL2(RMK.EQ_NO, B.EQ_NO, 'X')" ).append("\n"); 
		query.append("                   AND NVL(RMK.TRSP_SO_OFC_CTY_CD, 'XX') = NVL2(RMK.TRSP_SO_OFC_CTY_CD, A.TRSP_SO_OFC_CTY_CD, 'XX')" ).append("\n"); 
		query.append("                   AND NVL(RMK.TRSP_SO_SEQ, '99999') = NVL2(RMK.TRSP_SO_SEQ, A.TRSP_SO_SEQ, '99999')" ).append("\n"); 
		query.append("                   AND NVL(RMK.DELT_FLG, 'X') = 'N') AS INTER_RMK_CHK" ).append("\n"); 
		query.append("              ,B.BKG_NO" ).append("\n"); 
		query.append("          FROM TRS_TRSP_RAIL_INV_DTL A ," ).append("\n"); 
		query.append("               TRS_TRSP_RAIL_BIL_ORD B" ).append("\n"); 
		query.append("         WHERE INV_NO = @[invNo]" ).append("\n"); 
		query.append("           AND INV_VNDR_SEQ = @[invVndrSeq]" ).append("\n"); 
		query.append("           AND CRNT_TRSP_RAIL_INV_AUD_CD = @[railInvAudCd]" ).append("\n"); 
		query.append("           AND A.TRSP_SO_OFC_CTY_CD = B.TRSP_SO_OFC_CTY_CD(+)" ).append("\n"); 
		query.append("           AND A.TRSP_SO_SEQ = B.TRSP_SO_SEQ(+)" ).append("\n"); 
		query.append("     ) X" ).append("\n"); 

	}
}