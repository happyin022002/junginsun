/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : BLIssuanceDBDAOsearchDblEdiMain3RSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.03.01
*@LastModifier : 
*@LastVersion : 1.0
* 2016.03.01 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BLIssuanceDBDAOsearchDblEdiMain3RSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * BLIssuanceDBDAOsearchDblEdiMain3RSQL
	  * </pre>
	  */
	public BLIssuanceDBDAOsearchDblEdiMain3RSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("edi_receive_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("final_eta",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("func_code",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.integration").append("\n"); 
		query.append("FileName : BLIssuanceDBDAOsearchDblEdiMain3RSQL").append("\n"); 
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
		query.append("SELECT 'FFWD1:' || CASE " ).append("\n"); 
		query.append("                    WHEN SUBSTR(@[edi_receive_id], 1, 6) = 'SDIXML' OR SUBSTR(@[edi_receive_id], 1, 6) = 'PHIXML' THEN" ).append("\n"); 
		query.append("                      BKG_TOKEN_NL_FNC(FW.CUST_NM, 1, '*:&<>\"\\/''')" ).append("\n"); 
		query.append("                    WHEN SUBSTR(@[edi_receive_id], 1, 6) = 'LEHXML' OR SUBSTR(@[edi_receive_id], 1, 6) = 'PKEXML' OR " ).append("\n"); 
		query.append("                         SUBSTR(@[edi_receive_id], 1, 6) = 'PKCXML' OR SUBSTR(@[edi_receive_id], 1, 6) = 'LGEXML' OR " ).append("\n"); 
		query.append("                         SUBSTR(@[edi_receive_id], 1, 8) = 'CNLGEXML' OR SUBSTR(@[edi_receive_id], 1, 5) = 'EIXML' OR " ).append("\n"); 
		query.append("                         SUBSTR(@[edi_receive_id], 1, 6) = 'EIXMLC' THEN" ).append("\n"); 
		query.append("                      BKG_TOKEN_NL_FNC(FW.CUST_NM, 1, '')" ).append("\n"); 
		query.append("                    ELSE " ).append("\n"); 
		query.append("                      BKG_TOKEN_NL_FNC(FW.CUST_NM, 1, '*:')" ).append("\n"); 
		query.append("                   END ||CHR(10)||" ).append("\n"); 
		query.append("			 'FFWD2:' || CASE " ).append("\n"); 
		query.append("                    WHEN SUBSTR(@[edi_receive_id], 1, 6) = 'SDIXML' OR SUBSTR(@[edi_receive_id], 1, 6) = 'PHIXML' THEN" ).append("\n"); 
		query.append("                      BKG_TOKEN_NL_FNC(FW.CUST_NM, 2, '*:&<>\"\\/''')" ).append("\n"); 
		query.append("                    WHEN SUBSTR(@[edi_receive_id], 1, 6) = 'LEHXML' OR SUBSTR(@[edi_receive_id], 1, 6) = 'PKEXML' OR " ).append("\n"); 
		query.append("                         SUBSTR(@[edi_receive_id], 1, 6) = 'PKCXML' OR SUBSTR(@[edi_receive_id], 1, 6) = 'LGEXML' OR " ).append("\n"); 
		query.append("                         SUBSTR(@[edi_receive_id], 1, 8) = 'CNLGEXML' OR SUBSTR(@[edi_receive_id], 1, 5) = 'EIXML' OR " ).append("\n"); 
		query.append("                         SUBSTR(@[edi_receive_id], 1, 6) = 'EIXMLC' THEN" ).append("\n"); 
		query.append("                      BKG_TOKEN_NL_FNC(FW.CUST_NM, 2, '')" ).append("\n"); 
		query.append("                    ELSE " ).append("\n"); 
		query.append("                      BKG_TOKEN_NL_FNC(FW.CUST_NM, 2, '*:')" ).append("\n"); 
		query.append("                   END ||CHR(10)||" ).append("\n"); 
		query.append("			 'FFWD3:' || CASE " ).append("\n"); 
		query.append("                    WHEN SUBSTR(@[edi_receive_id], 1, 6) = 'SDIXML' OR SUBSTR(@[edi_receive_id], 1, 6) = 'PHIXML' THEN" ).append("\n"); 
		query.append("                      BKG_TOKEN_NL_FNC(FW.CUST_NM, 3, '*:&<>\"\\/''')" ).append("\n"); 
		query.append("                    WHEN SUBSTR(@[edi_receive_id], 1, 6) = 'LEHXML' OR SUBSTR(@[edi_receive_id], 1, 6) = 'PKEXML' OR " ).append("\n"); 
		query.append("                         SUBSTR(@[edi_receive_id], 1, 6) = 'PKCXML' OR SUBSTR(@[edi_receive_id], 1, 6) = 'LGEXML' OR " ).append("\n"); 
		query.append("                         SUBSTR(@[edi_receive_id], 1, 8) = 'CNLGEXML' OR SUBSTR(@[edi_receive_id], 1, 5) = 'EIXML' OR " ).append("\n"); 
		query.append("                         SUBSTR(@[edi_receive_id], 1, 6) = 'EIXMLC' THEN" ).append("\n"); 
		query.append("                      BKG_TOKEN_NL_FNC(FW.CUST_NM, 3, '')" ).append("\n"); 
		query.append("                    ELSE " ).append("\n"); 
		query.append("                      BKG_TOKEN_NL_FNC(FW.CUST_NM, 3, '*:')" ).append("\n"); 
		query.append("                   END ||CHR(10)||" ).append("\n"); 
		query.append("			 'FFWD4:' || CASE " ).append("\n"); 
		query.append("                    WHEN SUBSTR(@[edi_receive_id], 1, 6) = 'SDIXML' OR SUBSTR(@[edi_receive_id], 1, 6) = 'PHIXML' THEN" ).append("\n"); 
		query.append("                      BKG_TOKEN_NL_FNC(FW.CUST_NM, 4, '*:&<>\"\\/''')" ).append("\n"); 
		query.append("                    WHEN SUBSTR(@[edi_receive_id], 1, 6) = 'LEHXML' OR SUBSTR(@[edi_receive_id], 1, 6) = 'PKEXML' OR " ).append("\n"); 
		query.append("                         SUBSTR(@[edi_receive_id], 1, 6) = 'PKCXML' OR SUBSTR(@[edi_receive_id], 1, 6) = 'LGEXML' OR " ).append("\n"); 
		query.append("                         SUBSTR(@[edi_receive_id], 1, 8) = 'CNLGEXML' OR SUBSTR(@[edi_receive_id], 1, 5) = 'EIXML' OR " ).append("\n"); 
		query.append("                         SUBSTR(@[edi_receive_id], 1, 6) = 'EIXMLC' THEN" ).append("\n"); 
		query.append("                      BKG_TOKEN_NL_FNC(FW.CUST_NM, 4, '')" ).append("\n"); 
		query.append("                    ELSE " ).append("\n"); 
		query.append("                      BKG_TOKEN_NL_FNC(FW.CUST_NM, 4, '*:')" ).append("\n"); 
		query.append("                   END ||CHR(10)||" ).append("\n"); 
		query.append("			 'FFWD5:' || CASE " ).append("\n"); 
		query.append("                    WHEN SUBSTR(@[edi_receive_id], 1, 6) = 'SDIXML' OR SUBSTR(@[edi_receive_id], 1, 6) = 'PHIXML' THEN" ).append("\n"); 
		query.append("                      BKG_TOKEN_NL_FNC(FW.CUST_NM, 5, '*:&<>\"\\/''')" ).append("\n"); 
		query.append("                    WHEN SUBSTR(@[edi_receive_id], 1, 6) = 'LEHXML' OR SUBSTR(@[edi_receive_id], 1, 6) = 'PKEXML' OR " ).append("\n"); 
		query.append("                         SUBSTR(@[edi_receive_id], 1, 6) = 'PKCXML' OR SUBSTR(@[edi_receive_id], 1, 6) = 'LGEXML' OR " ).append("\n"); 
		query.append("                         SUBSTR(@[edi_receive_id], 1, 8) = 'CNLGEXML' OR SUBSTR(@[edi_receive_id], 1, 5) = 'EIXML' OR " ).append("\n"); 
		query.append("                         SUBSTR(@[edi_receive_id], 1, 6) = 'EIXMLC' THEN" ).append("\n"); 
		query.append("                      BKG_TOKEN_NL_FNC(FW.CUST_NM, 5, '')" ).append("\n"); 
		query.append("                    ELSE " ).append("\n"); 
		query.append("                      BKG_TOKEN_NL_FNC(FW.CUST_NM, 5, '*:')" ).append("\n"); 
		query.append("                   END ||CHR(10)||" ).append("\n"); 
		query.append("			 'FF_IND:' || CHR(10)||" ).append("\n"); 
		query.append("			 'EXPO1:' || CASE " ).append("\n"); 
		query.append("                    WHEN SUBSTR(@[edi_receive_id], 1, 6) = 'SDIXML' OR SUBSTR(@[edi_receive_id], 1, 6) = 'PHIXML' THEN" ).append("\n"); 
		query.append("                      BKG_TOKEN_NL_FNC(EX.CUST_NM, 1, '*:&<>\"\\/''')" ).append("\n"); 
		query.append("                    WHEN SUBSTR(@[edi_receive_id], 1, 6) = 'LEHXML' OR SUBSTR(@[edi_receive_id], 1, 6) = 'PKEXML' OR " ).append("\n"); 
		query.append("                         SUBSTR(@[edi_receive_id], 1, 6) = 'PKCXML' OR SUBSTR(@[edi_receive_id], 1, 6) = 'LGEXML' OR " ).append("\n"); 
		query.append("                         SUBSTR(@[edi_receive_id], 1, 8) = 'CNLGEXML' OR SUBSTR(@[edi_receive_id], 1, 5) = 'EIXML' OR " ).append("\n"); 
		query.append("                         SUBSTR(@[edi_receive_id], 1, 6) = 'EIXMLC' THEN" ).append("\n"); 
		query.append("                      BKG_TOKEN_NL_FNC(EX.CUST_NM, 1, '')" ).append("\n"); 
		query.append("                    ELSE " ).append("\n"); 
		query.append("                      BKG_TOKEN_NL_FNC(EX.CUST_NM, 1, '*:')" ).append("\n"); 
		query.append("                   END ||CHR(10)||" ).append("\n"); 
		query.append("			 'EXPO2:' || CASE " ).append("\n"); 
		query.append("                    WHEN SUBSTR(@[edi_receive_id], 1, 6) = 'SDIXML' OR SUBSTR(@[edi_receive_id], 1, 6) = 'PHIXML' THEN" ).append("\n"); 
		query.append("                      BKG_TOKEN_NL_FNC(EX.CUST_NM, 2, '*:&<>\"\\/''')" ).append("\n"); 
		query.append("                    WHEN SUBSTR(@[edi_receive_id], 1, 6) = 'LEHXML' OR SUBSTR(@[edi_receive_id], 1, 6) = 'PKEXML' OR " ).append("\n"); 
		query.append("                         SUBSTR(@[edi_receive_id], 1, 6) = 'PKCXML' OR SUBSTR(@[edi_receive_id], 1, 6) = 'LGEXML' OR " ).append("\n"); 
		query.append("                         SUBSTR(@[edi_receive_id], 1, 8) = 'CNLGEXML' OR SUBSTR(@[edi_receive_id], 1, 5) = 'EIXML' OR " ).append("\n"); 
		query.append("                         SUBSTR(@[edi_receive_id], 1, 6) = 'EIXMLC' THEN" ).append("\n"); 
		query.append("                      BKG_TOKEN_NL_FNC(EX.CUST_NM, 2, '')" ).append("\n"); 
		query.append("                    ELSE " ).append("\n"); 
		query.append("                      BKG_TOKEN_NL_FNC(EX.CUST_NM, 2, '*:')" ).append("\n"); 
		query.append("                   END ||CHR(10)||" ).append("\n"); 
		query.append("			 'EXPO3:' || CASE " ).append("\n"); 
		query.append("                    WHEN SUBSTR(@[edi_receive_id], 1, 6) = 'SDIXML' OR SUBSTR(@[edi_receive_id], 1, 6) = 'PHIXML' THEN" ).append("\n"); 
		query.append("                      BKG_TOKEN_NL_FNC(EX.CUST_NM, 3, '*:&<>\"\\/''')" ).append("\n"); 
		query.append("                    WHEN SUBSTR(@[edi_receive_id], 1, 6) = 'LEHXML' OR SUBSTR(@[edi_receive_id], 1, 6) = 'PKEXML' OR " ).append("\n"); 
		query.append("                         SUBSTR(@[edi_receive_id], 1, 6) = 'PKCXML' OR SUBSTR(@[edi_receive_id], 1, 6) = 'LGEXML' OR " ).append("\n"); 
		query.append("                         SUBSTR(@[edi_receive_id], 1, 8) = 'CNLGEXML' OR SUBSTR(@[edi_receive_id], 1, 5) = 'EIXML' OR " ).append("\n"); 
		query.append("                         SUBSTR(@[edi_receive_id], 1, 6) = 'EIXMLC' THEN" ).append("\n"); 
		query.append("                      BKG_TOKEN_NL_FNC(EX.CUST_NM, 3, '')" ).append("\n"); 
		query.append("                    ELSE " ).append("\n"); 
		query.append("                      BKG_TOKEN_NL_FNC(EX.CUST_NM, 3, '*:')" ).append("\n"); 
		query.append("                   END ||CHR(10)||" ).append("\n"); 
		query.append("			 'EXPO4:' || CASE " ).append("\n"); 
		query.append("                    WHEN SUBSTR(@[edi_receive_id], 1, 6) = 'SDIXML' OR SUBSTR(@[edi_receive_id], 1, 6) = 'PHIXML' THEN" ).append("\n"); 
		query.append("                      BKG_TOKEN_NL_FNC(EX.CUST_NM, 4, '*:&<>\"\\/''')" ).append("\n"); 
		query.append("                    WHEN SUBSTR(@[edi_receive_id], 1, 6) = 'LEHXML' OR SUBSTR(@[edi_receive_id], 1, 6) = 'PKEXML' OR " ).append("\n"); 
		query.append("                         SUBSTR(@[edi_receive_id], 1, 6) = 'PKCXML' OR SUBSTR(@[edi_receive_id], 1, 6) = 'LGEXML' OR " ).append("\n"); 
		query.append("                         SUBSTR(@[edi_receive_id], 1, 8) = 'CNLGEXML' OR SUBSTR(@[edi_receive_id], 1, 5) = 'EIXML' OR " ).append("\n"); 
		query.append("                         SUBSTR(@[edi_receive_id], 1, 6) = 'EIXMLC' THEN" ).append("\n"); 
		query.append("                      BKG_TOKEN_NL_FNC(EX.CUST_NM, 4, '')" ).append("\n"); 
		query.append("                    ELSE " ).append("\n"); 
		query.append("                      BKG_TOKEN_NL_FNC(EX.CUST_NM, 4, '*:')" ).append("\n"); 
		query.append("                   END ||CHR(10)||" ).append("\n"); 
		query.append("			 'EXPO5:' || CASE " ).append("\n"); 
		query.append("                    WHEN SUBSTR(@[edi_receive_id], 1, 6) = 'SDIXML' OR SUBSTR(@[edi_receive_id], 1, 6) = 'PHIXML' THEN" ).append("\n"); 
		query.append("                      BKG_TOKEN_NL_FNC(EX.CUST_NM, 5, '*:&<>\"\\/''')" ).append("\n"); 
		query.append("                    WHEN SUBSTR(@[edi_receive_id], 1, 6) = 'LEHXML' OR SUBSTR(@[edi_receive_id], 1, 6) = 'PKEXML' OR " ).append("\n"); 
		query.append("                         SUBSTR(@[edi_receive_id], 1, 6) = 'PKCXML' OR SUBSTR(@[edi_receive_id], 1, 6) = 'LGEXML' OR " ).append("\n"); 
		query.append("                         SUBSTR(@[edi_receive_id], 1, 8) = 'CNLGEXML' OR SUBSTR(@[edi_receive_id], 1, 5) = 'EIXML' OR " ).append("\n"); 
		query.append("                         SUBSTR(@[edi_receive_id], 1, 6) = 'EIXMLC' THEN" ).append("\n"); 
		query.append("                      BKG_TOKEN_NL_FNC(EX.CUST_NM, 5, '')" ).append("\n"); 
		query.append("                    ELSE " ).append("\n"); 
		query.append("                      BKG_TOKEN_NL_FNC(EX.CUST_NM, 5, '*:')" ).append("\n"); 
		query.append("                   END ||CHR(10)||" ).append("\n"); 
		query.append("			 'EX_IND:' || CHR(10)||" ).append("\n"); 
		query.append("			 'BLCOPY:' || ISS.BL_CPY_KNT || CHR(10)||" ).append("\n"); 
		query.append("			 'BLORG:1' || CHR(10)||" ).append("\n"); 
		query.append("			 'BLPKG:' || BL.PCK_QTY						|| CHR(10)||" ).append("\n"); 
		query.append("			 'BLPKGU:' || BL.PCK_TP_CD							|| CHR(10)||" ).append("\n"); 
		query.append("			 'BLWGT:' || BL.ACT_WGT					|| CHR(10)||" ).append("\n"); 
		query.append("			 'BL_WGT_UNIT:' || BL.WGT_UT_CD						|| CHR(10)||" ).append("\n"); 
		query.append("			 'BLMEA:' || BL.MEAS_QTY						|| CHR(10)||" ).append("\n"); 
		query.append("			 'BL_MEA_UNIT:' || BL.MEAS_UT_CD						|| CHR(10)||" ).append("\n"); 
		query.append("			 'BL_RDTYPE:' || BK.RCV_TERM_CD || BK.DE_TERM_CD	|| CHR(10)||" ).append("\n"); 
		query.append("			 'CARGOTYPE:' || BK.BKG_CGO_TP_CD						|| CHR(10)||" ).append("\n"); 
		query.append("			 'COMMODITY:' || BK.CMDT_CD	|| '/' || (SELECT CMDT_NM FROM MDM_COMMODITY CMDT WHERE CMDT.CMDT_CD = BK.CMDT_CD)	|| CHR(10)||" ).append("\n"); 
		query.append("			 'REMARK:' || CASE " ).append("\n"); 
		query.append("                      WHEN SUBSTR(@[edi_receive_id], 1, 6) = 'SDIXML' OR SUBSTR(@[edi_receive_id], 1, 6) = 'PHIXML' THEN" ).append("\n"); 
		query.append("                        BKG_TOKEN_NL_FNC(BK.XTER_RMK, 0, '*:&<>\"\\/''')" ).append("\n"); 
		query.append("                      WHEN SUBSTR(@[edi_receive_id], 1, 6) = 'LEHXML' OR SUBSTR(@[edi_receive_id], 1, 6) = 'PKEXML' OR " ).append("\n"); 
		query.append("                           SUBSTR(@[edi_receive_id], 1, 6) = 'PKCXML' OR SUBSTR(@[edi_receive_id], 1, 6) = 'LGEXML' OR " ).append("\n"); 
		query.append("                           SUBSTR(@[edi_receive_id], 1, 8) = 'CNLGEXML' OR SUBSTR(@[edi_receive_id], 1, 5) = 'EIXML' OR " ).append("\n"); 
		query.append("                           SUBSTR(@[edi_receive_id], 1, 6) = 'EIXMLC' THEN" ).append("\n"); 
		query.append("                        BKG_TOKEN_NL_FNC(BK.XTER_RMK, 0, '')" ).append("\n"); 
		query.append("                      ELSE" ).append("\n"); 
		query.append("                        BKG_TOKEN_NL_FNC(BK.XTER_RMK, 0, '*:')" ).append("\n"); 
		query.append("                    END ||CHR(10)||" ).append("\n"); 
		query.append("			 'AUS_QUAR:' || CHR(10)||" ).append("\n"); 
		query.append("			 'SRNBR:' || CHR(10)||" ).append("\n"); 
		query.append("			 'BKGNBR:' || BK.BKG_NO || CHR(10)||" ).append("\n"); 
		query.append("			 'MST_BKG:' ||BK.FM_BKG_NO || CHR(10) || " ).append("\n"); 
		query.append("			 'WAYBILL_IND:' || DECODE(BK.BL_TP_CD, 'W', 'T', 'F')		|| CHR(10)||" ).append("\n"); 
		query.append("			 'CUSTREF_NUM:' || REFNO.SI_NO || CHR(10)||" ).append("\n"); 
		query.append("			 'FINAL_ETA:' || @[final_eta] || CHR(10)||" ).append("\n"); 
		query.append("			 'FUNC_CODE:' || @[func_code] || CHR(10)||" ).append("\n"); 
		query.append("			 'ONBOARD:' || NVL(TO_CHAR(BL.BL_OBRD_DT, 'RRRRMMDD'), VL.VPS_ETD_DT)		|| CHR(10)||" ).append("\n"); 
		query.append("			 'APPLICATION_DT:' || TO_CHAR(RT.RT_APLY_DT , 'YYYYMMDD') || CHR(10)||" ).append("\n"); 
		query.append("			 'INV_NO:' || REFNO.INV_NO || CHR(10)||" ).append("\n"); 
		query.append("			 'OTH_REF_NO:' || REFNO.OTHER_REF_NO || CHR(10)||" ).append("\n"); 
		query.append("			 'BLINFO_DOCNO:' || DECODE(BL.BDR_CNG_FLG, 'N', NULL, 'C/A') || '  ' ||NVL(REFNO.PSA_NO, REFNO.REF_NO) || CHR(10)||" ).append("\n"); 
		query.append("			 'BLINFO_EXPDEC:' || BK.SI_FLG || CHR(10)||" ).append("\n"); 
		query.append("			 'BLINFO_ORGIN:' || BL.ORG_CNT_NM || CHR(10)||" ).append("\n"); 
		query.append("			 'BLINFO_POINT:' || DECODE(RTRIM(REFNO.FMC_NO), '', NULL, 'FMC' || SUBSTR(REFNO.FMC_NO, 1, 6))	|| CHR(10)||" ).append("\n"); 
		query.append("			 'BLINFO_POR:' || BL.POR_NM || CHR(10)||" ).append("\n"); 
		query.append("			 'BLINFO_PREVSL:' || BL.PRE_VSL_NM || CHR(10)||" ).append("\n"); 
		query.append("			 'BLINFO_VVD:' || BL.VSL_NM || CHR(10)||" ).append("\n"); 
		query.append("			 'BLINFO_POL:' || BL.POL_NM || CHR(10)||" ).append("\n"); 
		query.append("			 'BLINFO_MOVE:' || BL.BL_MV_TP_NM || CHR(10)||" ).append("\n"); 
		query.append("			 'BLINFO_POD:' || BL.POD_NM || CHR(10)||" ).append("\n"); 
		query.append("			 'BLINFO_DEL:' || BL.DEL_NM || CHR(10)||" ).append("\n"); 
		query.append("			 'BLINFO_FDEST:'	|| BL.FNL_DEST_NM || CHR(10)||" ).append("\n"); 
		query.append("			 'BLINFO_FRTIND:' || DECODE(RT.FRT_TERM_CD, 'P', '=FREIGHT PREPAID=', 'C', '=FREIGHT COLLECT=', NULL)  || CHR(10)||" ).append("\n"); 
		query.append("			 'BLINFO_RCVTERM:' || DECODE(BK.RCV_TERM_CD, 'S', 'CFS'" ).append("\n"); 
		query.append("			                                           , 'Y', 'CY'" ).append("\n"); 
		query.append("			                                           , 'D', 'DOOR'" ).append("\n"); 
		query.append("			                                           , 'T', 'TACKLE'" ).append("\n"); 
		query.append("			                                           , 'I', 'FREE IN'" ).append("\n"); 
		query.append("			                                           , 'O', 'FREE OUT'" ).append("\n"); 
		query.append("			                                           , 'H', 'CY'" ).append("\n"); 
		query.append("			                                           , 'M', '*'" ).append("\n"); 
		query.append("			                                           ,BK.RCV_TERM_CD)	|| CHR(10)||" ).append("\n"); 
		query.append("			 'BLINFO_DLVTERM:'|| DECODE(BK.DE_TERM_CD, 'S', 'CFS'" ).append("\n"); 
		query.append("			                                         , 'Y', 'CY'" ).append("\n"); 
		query.append("			                                         , 'D', 'DOOR'" ).append("\n"); 
		query.append("			                                         , 'T', 'TACKLE'" ).append("\n"); 
		query.append("			                                         , 'I', 'FREE IN'" ).append("\n"); 
		query.append("			                                         , 'O', 'FREE OUT'" ).append("\n"); 
		query.append("			                                         , 'H', 'CY'" ).append("\n"); 
		query.append("			                                         , 'M', '*'" ).append("\n"); 
		query.append("			                                         , BK.DE_TERM_CD)	|| CHR(10)||" ).append("\n"); 
		query.append("			 'BLINFO_BKGSTS:'|| DECODE(BK.BKG_STS_CD, 'X', '** CANCELED **'" ).append("\n"); 
		query.append("			                                        , DECODE(BK.BL_TP_CD, 'W', '** SEA WAYBILL **'" ).append("\n"); 
		query.append("			                                        , DECODE(LENGTH(BK.BL_NO), 10, DECODE(BK.BL_NO_TP, '0', ''" ).append("\n"); 
		query.append("			                                                                                         , '** MEMO **')" ).append("\n"); 
		query.append("			                                                                 , '')))	|| CHR(10)||" ).append("\n"); 
		query.append("			 'BLINFO_PKG:' || BKG_TOKEN_NL_FNC(BL.TTL_PCK_DESC, 0, '')	|| CHR(10)||" ).append("\n"); 
		query.append("			 'BLINFO_NOTP:'	|| DECODE(BL.BL_OBRD_TP_CD, 'L', 'LADEN ON BOARD THE VESSEL'" ).append("\n"); 
		query.append("			                                          , 'R', 'RECEIVED FOR SHIPMENT'" ).append("\n"); 
		query.append("			                                          , 'O', 'ON BOARD'" ).append("\n"); 
		query.append("			                                          , 'A', 'ON BOARD THE RAIL'" ).append("\n"); 
		query.append("			                                          , 'B', 'ON BOARD THE BARGE'" ).append("\n"); 
		query.append("			                                          , 'T', 'ON BOARD THE TRUCK'" ).append("\n"); 
		query.append("			                                          ,NULL) || CHR(10)||" ).append("\n"); 
		query.append("			 'BLINFO_ONDATE:' || TO_CHAR(BL.BL_OBRD_DT, 'DDMonYY', 'NLS_DATE_LANGUAGE = American') || CHR(10)||" ).append("\n"); 
		query.append("			 'BLINFO_USER:' || SCR.USR_NM || CHR(10)||" ).append("\n"); 
		query.append("			 'BLINFO_ISSUELOC_CD:' || OFC.LOC_CD || CHR(10)||" ).append("\n"); 
		query.append("			 'BLINFO_ISSUELOC:' || CASE " ).append("\n"); 
		query.append("                                   WHEN SUBSTR(@[edi_receive_id], 1, 6) = 'LEHXML' OR SUBSTR(@[edi_receive_id], 1, 6) = 'PKEXML' OR " ).append("\n"); 
		query.append("                                        SUBSTR(@[edi_receive_id], 1, 6) = 'PKCXML' OR SUBSTR(@[edi_receive_id], 1, 6) = 'LGEXML' OR " ).append("\n"); 
		query.append("                                        SUBSTR(@[edi_receive_id], 1, 8) = 'CNLGEXML' OR SUBSTR(@[edi_receive_id], 1, 5) = 'EIXML' OR " ).append("\n"); 
		query.append("                                        SUBSTR(@[edi_receive_id], 1, 6) = 'EIXMLC' THEN" ).append("\n"); 
		query.append("                                     LOC.LOC_NM	||' , '||CNT.CNT_CD" ).append("\n"); 
		query.append("                                   ELSE" ).append("\n"); 
		query.append("                                     LOC.LOC_NM	||' , '||CNT.CNT_NM" ).append("\n"); 
		query.append("                                   END ||CHR(10)||" ).append("\n"); 
		query.append("			 'BLINFO_COPY:' || DECODE(ISS.OBL_ISS_KNT, 0, 'NONE'" ).append("\n"); 
		query.append("			                                         , 1, 'ONE , (1)'" ).append("\n"); 
		query.append("			                                         , 2, 'TWO , (2)'" ).append("\n"); 
		query.append("			                                         , 3, 'THREE , (3)'" ).append("\n"); 
		query.append("			                                         , 4, 'FOUR , (4)'" ).append("\n"); 
		query.append("			                                         , 5, 'FIVE , (5)'" ).append("\n"); 
		query.append("			                                         , 6, 'SIX , (6)'" ).append("\n"); 
		query.append("			                                         , NULL) || CHR(10)||" ).append("\n"); 
		query.append("			 'BLINFO_ISSUEDATE:' || TO_CHAR(ISS.OBL_ISS_DT, 'DDMonYY', 'NLS_DATE_LANGUAGE = American') || CHR(10)||" ).append("\n"); 
		query.append("			 'BKG_STF:' || BK.DOC_USR_ID || CHR(10)||" ).append("\n"); 
		query.append("			 'CONTACT_NAME:' || CP.CNTC_PSON_NM || CHR(10)||" ).append("\n"); 
		query.append("			 'CONTACT_TEL:'		|| CP.CNTC_PSON_PHN_NO || CHR(10)||" ).append("\n"); 
		query.append("			 'CONTACT_MOBILE:' || CP.CNTC_PSON_MPHN_NO || CHR(10)||" ).append("\n"); 
		query.append("			 'BKG_LC_NO:' || REFNO.LC_NO || CHR(10)||" ).append("\n"); 
		query.append("			 'OBLPRT:' || DECODE(ISS.OBL_PRN_FLG, 'N', '', ISS.OBL_PRN_FLG) || CHR(10)||" ).append("\n"); 
		query.append("			 'TRAN_TP:' || CHR(10)||" ).append("\n"); 
		query.append("			 'EQPICKDT:' ||TO_CHAR(BK.MTY_PKUP_DT,'RRRRMMDDHH24MI') || CHR(10)|| " ).append("\n"); 
		query.append("			 'BKG_OFC:' || BK.BKG_OFC_CD || CHR(10)||" ).append("\n"); 
		query.append("			 'BLKSTWG:' || BK.BLCK_STWG_CD || CHR(10)" ).append("\n"); 
		query.append("  FROM BKG_BOOKING BK" ).append("\n"); 
		query.append("      ,BKG_BL_DOC BL" ).append("\n"); 
		query.append("      ,BKG_BL_ISS ISS" ).append("\n"); 
		query.append("      ,BKG_RATE RT" ).append("\n"); 
		query.append("      ,(SELECT BKG_NO" ).append("\n"); 
		query.append("              ,MAX(DECODE(BKG_REF_TP_CD, 'EBRF', CUST_REF_NO_CTNT)) AS REF_NO" ).append("\n"); 
		query.append("              ,MAX(DECODE(BKG_REF_TP_CD, 'ESRF', CUST_REF_NO_CTNT)) AS SI_NO" ).append("\n"); 
		query.append("              ,MAX(DECODE(BKG_REF_TP_CD, 'HINV', CUST_REF_NO_CTNT)) AS INV_NO" ).append("\n"); 
		query.append("              ,MAX(DECODE(BKG_REF_TP_CD, 'LCNO', CUST_REF_NO_CTNT)) AS LC_NO" ).append("\n"); 
		query.append("              ,MAX(DECODE(BKG_REF_TP_CD, 'FMCN', CUST_REF_NO_CTNT)) AS FMC_NO" ).append("\n"); 
		query.append("              ,MAX(DECODE(BKG_REF_TP_CD, 'PSAN', CUST_REF_NO_CTNT)) AS PSA_NO" ).append("\n"); 
		query.append("			  ,MAX(DECODE(BKG_REF_TP_CD, 'OTHR', CUST_REF_NO_CTNT)) AS OTHER_REF_NO" ).append("\n"); 
		query.append("          FROM BKG_REFERENCE   " ).append("\n"); 
		query.append("         WHERE 1=1" ).append("\n"); 
		query.append("           AND BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("         GROUP BY BKG_NO) REFNO" ).append("\n"); 
		query.append("      ,BKG_CUSTOMER FW" ).append("\n"); 
		query.append("      ,BKG_CUSTOMER EX" ).append("\n"); 
		query.append("      ,COM_USER SCR" ).append("\n"); 
		query.append("      ,MDM_COUNTRY CNT" ).append("\n"); 
		query.append("      ,MDM_ORGANIZATION OFC" ).append("\n"); 
		query.append("      ,MDM_LOCATION LOC" ).append("\n"); 
		query.append("      ,BKG_CNTC_PSON CP" ).append("\n"); 
		query.append("      ,(SELECT BKG_NO" ).append("\n"); 
		query.append("              ,TO_CHAR(VPS_ETD_DT, 'RRRRMMDD') AS VPS_ETD_DT" ).append("\n"); 
		query.append("          FROM (SELECT VVD.BKG_NO" ).append("\n"); 
		query.append("                      ,VSK.VPS_ETD_DT" ).append("\n"); 
		query.append("                  FROM BKG_VVD VVD" ).append("\n"); 
		query.append("                      ,VSK_VSL_PORT_SKD VSK" ).append("\n"); 
		query.append("                 WHERE VVD.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("                   AND (VVD.VSL_PRE_PST_CD || VVD.VSL_SEQ) IN ('S1', 'T0')" ).append("\n"); 
		query.append("                   AND VVD.VSL_CD = VSK.VSL_CD" ).append("\n"); 
		query.append("                   AND VVD.SKD_VOY_NO = VSK.SKD_VOY_NO" ).append("\n"); 
		query.append("                   AND VVD.SKD_DIR_CD = VSK.SKD_DIR_CD" ).append("\n"); 
		query.append("                   AND VSK.AUTO_SKD_CNG_FLG <> 'S'" ).append("\n"); 
		query.append("                   AND VVD.POL_CD = VSK.VPS_PORT_CD" ).append("\n"); 
		query.append("                   AND VVD.POL_CLPT_IND_SEQ = CLPT_IND_SEQ" ).append("\n"); 
		query.append("--                   AND NVL(VVD.POL_CLPT_IND_SEQ, 1) = VSK.CLPT_SEQ" ).append("\n"); 
		query.append("                 ORDER BY VVD.VSL_PRE_PST_CD" ).append("\n"); 
		query.append("                      ,VVD.VSL_SEQ" ).append("\n"); 
		query.append("              )" ).append("\n"); 
		query.append("         WHERE ROWNUM = 1) VL" ).append("\n"); 
		query.append(" WHERE BK.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("   AND BK.BKG_NO = BL.BKG_NO" ).append("\n"); 
		query.append("   AND BK.BKG_NO = RT.BKG_NO(+)" ).append("\n"); 
		query.append("   AND BK.BKG_NO = CP.BKG_NO(+)" ).append("\n"); 
		query.append("   AND CP.BKG_CNTC_PSON_TP_CD(+) = 'BK'" ).append("\n"); 
		query.append("   AND BK.BKG_NO = REFNO.BKG_NO(+)" ).append("\n"); 
		query.append("   AND BK.BKG_NO = ISS.BKG_NO(+)" ).append("\n"); 
		query.append("   AND BK.BKG_NO = FW.BKG_NO(+)" ).append("\n"); 
		query.append("   AND FW.BKG_CUST_TP_CD(+) = 'F'" ).append("\n"); 
		query.append("   AND BK.BKG_NO = EX.BKG_NO(+)" ).append("\n"); 
		query.append("   AND EX.BKG_CUST_TP_CD(+) = 'E'" ).append("\n"); 
		query.append("   AND ISS.OBL_ISS_USR_ID = SCR.USR_ID(+)" ).append("\n"); 
		query.append("   AND ISS.OBL_ISS_OFC_CD = OFC.OFC_CD(+)" ).append("\n"); 
		query.append("   AND OFC.LOC_CD = LOC.LOC_CD(+)" ).append("\n"); 
		query.append("   AND LOC.CNT_CD = CNT.CNT_CD(+)" ).append("\n"); 
		query.append("   AND BK.BKG_NO = VL.BKG_NO(+)" ).append("\n"); 

	}
}