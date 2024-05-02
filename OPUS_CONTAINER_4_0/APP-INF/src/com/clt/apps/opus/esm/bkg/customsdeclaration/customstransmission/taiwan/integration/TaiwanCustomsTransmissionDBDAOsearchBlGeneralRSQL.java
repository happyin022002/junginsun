/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : TaiwanCustomsTransmissionDBDAOsearchBlGeneralRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.01.21
*@LastModifier : 
*@LastVersion : 1.0
* 2015.01.21 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.taiwan.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TaiwanCustomsTransmissionDBDAOsearchBlGeneralRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 대만세관 신고용 Manifest B/L General 정보를 조회한다.
	  * </pre>
	  */
	public TaiwanCustomsTransmissionDBDAOsearchBlGeneralRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pol_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("skd_dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("skd_voy_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.taiwan.integration").append("\n"); 
		query.append("FileName : TaiwanCustomsTransmissionDBDAOsearchBlGeneralRSQL").append("\n"); 
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
		query.append("SELECT  BKG.VSL_CD||BKG.SKD_VOY_NO||BKG.SKD_DIR_CD vvd_number," ).append("\n"); 
		query.append("            NVL(BKG.BL_NO,' ')||NVL(BKG.BL_TP_CD,' ') blnbr," ).append("\n"); 
		query.append("            NVL(BKG.POL_CD,' ') blpol," ).append("\n"); 
		query.append("           NVL(BKG.POD_CD,' ') blpod," ).append("\n"); 
		query.append("           NVL(BKG.POR_CD,' ') blpor," ).append("\n"); 
		query.append("           NVL(BKG.DEL_CD,' ') bldel," ).append("\n"); 
		query.append("           DECODE(@[pol_cd],null,NVL(BKG.PST_RLY_PORT_CD,' '),NVL(BKG.PRE_RLY_PORT_CD,' ')) blrly," ).append("\n"); 
		query.append("           NVL(OFC.LOC_CD,' ') blplace," ).append("\n"); 
		query.append("           NVL(TO_CHAR(BL.OBL_ISS_DT,'RRMMDD'),' ') bldate," ).append("\n"); 
		query.append("              SCE_TOKEN_NL_FNC(BCS.CUST_NM,1) shpr1," ).append("\n"); 
		query.append("              SCE_TOKEN_NL_FNC(BCS.CUST_NM,2) shpr2," ).append("\n"); 
		query.append("              SCE_TOKEN_NL_FNC(BCS.CUST_ADDR,1) shpr3," ).append("\n"); 
		query.append("              SCE_TOKEN_NL_FNC(BCS.CUST_ADDR,2) shpr4," ).append("\n"); 
		query.append("              SCE_TOKEN_NL_FNC(BCS.CUST_ADDR,3) shpr5," ).append("\n"); 
		query.append("              SCE_TOKEN_NL_FNC(BCC.CUST_NM,1) cnee1," ).append("\n"); 
		query.append("              SCE_TOKEN_NL_FNC(BCC.CUST_NM,2) cnee2," ).append("\n"); 
		query.append("              SCE_TOKEN_NL_FNC(BCC.CUST_ADDR,1) cnee3," ).append("\n"); 
		query.append("              SCE_TOKEN_NL_FNC(BCC.CUST_ADDR,2) cnee4," ).append("\n"); 
		query.append("              SCE_TOKEN_NL_FNC(BCC.CUST_ADDR,3) cnee5," ).append("\n"); 
		query.append("              SCE_TOKEN_NL_FNC(BCN.CUST_NM,1) ntfy1," ).append("\n"); 
		query.append("              SCE_TOKEN_NL_FNC(BCN.CUST_NM,2) ntfy2," ).append("\n"); 
		query.append("              SCE_TOKEN_NL_FNC(BCN.CUST_ADDR,1) ntfy3," ).append("\n"); 
		query.append("              SCE_TOKEN_NL_FNC(BCN.CUST_ADDR,2) ntfy4," ).append("\n"); 
		query.append("              SCE_TOKEN_NL_FNC(BCN.CUST_ADDR,3) ntfy5," ).append("\n"); 
		query.append("              SCE_TOKEN_NL_FNC(BCA.CUST_NM,1) ntfy21," ).append("\n"); 
		query.append("              SCE_TOKEN_NL_FNC(BCA.CUST_NM,2) ntfy22," ).append("\n"); 
		query.append("              SCE_TOKEN_NL_FNC(BCA.CUST_NM,3) ntfy23," ).append("\n"); 
		query.append("              SCE_TOKEN_NL_FNC(BCA.CUST_NM,4) ntfy24," ).append("\n"); 
		query.append("              SCE_TOKEN_NL_FNC(BCA.CUST_NM,5) ntfy25," ).append("\n"); 
		query.append("              SCE_TOKEN_NL_FNC(BCF.CUST_NM,1) ffwd1," ).append("\n"); 
		query.append("              SCE_TOKEN_NL_FNC(BCF.CUST_NM,2) ffwd2," ).append("\n"); 
		query.append("              SCE_TOKEN_NL_FNC(BCF.CUST_NM,3) ffwd3," ).append("\n"); 
		query.append("              SCE_TOKEN_NL_FNC(BCF.CUST_NM,4) ffwd4," ).append("\n"); 
		query.append("              SCE_TOKEN_NL_FNC(BCF.CUST_NM,5) ffwd5," ).append("\n"); 
		query.append("              SCE_TOKEN_NL_FNC(BCE.CUST_NM,1) expo1," ).append("\n"); 
		query.append("              SCE_TOKEN_NL_FNC(BCE.CUST_NM,2) expo2," ).append("\n"); 
		query.append("              SCE_TOKEN_NL_FNC(BCE.CUST_NM,3) expo3," ).append("\n"); 
		query.append("              SCE_TOKEN_NL_FNC(BCE.CUST_NM,4) expo4," ).append("\n"); 
		query.append("              SCE_TOKEN_NL_FNC(BCE.CUST_NM,5) expo5," ).append("\n"); 
		query.append("              NVL(BL.BL_CPY_KNT,0) blcopy," ).append("\n"); 
		query.append("           '1' blorg," ).append("\n"); 
		query.append("           NVL(DOC.PCK_QTY,0) blpkg," ).append("\n"); 
		query.append("           NVL(CNV.CSTMS_PCK_TP_CD, DOC.PCK_TP_CD) blpkgu," ).append("\n"); 
		query.append("           DECODE(NVL(DOC.WGT_UT_CD,' '),'LBS',ROUND(NVL(DOC.ACT_WGT,0)*0.4536,3),NVL(DOC.ACT_WGT,0)) blwgt," ).append("\n"); 
		query.append("           DECODE(NVL(DOC.MEAS_UT_CD,' '),'CBF',ROUND(NVL(DOC.MEAS_QTY,0)*0.0283,3),NVL(DOC.MEAS_QTY,0)) blmea," ).append("\n"); 
		query.append("          NVL(BKG.RCV_TERM_CD,' ')||NVL(BKG.DE_TERM_CD,' ') rdtype," ).append("\n"); 
		query.append("           NVL(BKG.BKG_CGO_TP_CD,' ') cargotype," ).append("\n"); 
		query.append("           NVL(BKG.CMDT_CD,' ') commodity," ).append("\n"); 
		query.append("           TRANSLATE(NVL(BKG.XTER_RMK,' '),CHR(10),' ') remark," ).append("\n"); 
		query.append("           ' ' ausquar," ).append("\n"); 
		query.append("           NVL(BKG.BKG_NO,' ') bkg_no," ).append("\n"); 
		query.append("           NVL(BKG.BKG_CGO_TP_CD,' ') bkgCgoTp," ).append("\n"); 
		query.append("           DECODE(NVL(BKG.DCGO_FLG,' '),'N','0','Y','1','','') bkgSpeDg,DECODE(NVL(BKG.RC_FLG,' '),'N','0','Y','1','','') bkgSpeRf," ).append("\n"); 
		query.append("           DECODE(NVL(BKG.AWK_CGO_FLG,' '),'N','0','Y','1','','') bkgSpeAk,DECODE(NVL(BKG.BB_CGO_FLG,' '),'N','0','Y','1','','') bkgSpeBb," ).append("\n"); 
		query.append("           DECODE(NVL(BKG.RD_CGO_FLG,' '),'N','0','Y','1','','') bkgSpeRd,NVL(BKG.CMDT_CD,' ') cmdtCd," ).append("\n"); 
		query.append("           TRANSLATE(NVL(COM.CMDT_NM,' '),CHR(10),' ') cmdtDesc" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("      FROM MDM_ORGANIZATION OFC," ).append("\n"); 
		query.append("           MDM_COMMODITY COM," ).append("\n"); 
		query.append("           BKG_BOOKING BKG," ).append("\n"); 
		query.append("           BKG_BL_DOC DOC," ).append("\n"); 
		query.append("           BKG_BL_ISS BL," ).append("\n"); 
		query.append("           BKG_VVD VVD," ).append("\n"); 
		query.append("           BKG_CUSTOMER BCC," ).append("\n"); 
		query.append("           BKG_CUSTOMER BCS," ).append("\n"); 
		query.append("           BKG_CUSTOMER BCN," ).append("\n"); 
		query.append("           BKG_CUSTOMER BCA," ).append("\n"); 
		query.append("           BKG_CUSTOMER BCF," ).append("\n"); 
		query.append("           BKG_CUSTOMER BCE," ).append("\n"); 
		query.append("           BKG_CSTMS_PCK_TP_CONV CNV" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("    WHERE VVD.VSL_CD         = @[vsl_cd]" ).append("\n"); 
		query.append("        AND VVD.SKD_VOY_NO  =  @[skd_voy_no]" ).append("\n"); 
		query.append("        AND VVD.SKD_DIR_CD     = @[skd_dir_cd]" ).append("\n"); 
		query.append("#if (${pol_cd}!= '')" ).append("\n"); 
		query.append("        AND VVD.POL_CD = @[pol_cd]  -- 입력된 pol code 존재 시" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${pod_cd}!= '')" ).append("\n"); 
		query.append("        AND VVD.POD_CD = @[pod_cd]  -- 입력된 pod code 존재 시" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("        AND BKG.BKG_STS_CD           != 'X'" ).append("\n"); 
		query.append("        AND BKG.BKG_STS_CD           != 'S'" ).append("\n"); 
		query.append("        AND BKG.BKG_NO = BL.BKG_NO(+)" ).append("\n"); 
		query.append("        AND BKG.BKG_NO = VVD.BKG_NO" ).append("\n"); 
		query.append("        AND BKG.BKG_NO = DOC.BKG_NO" ).append("\n"); 
		query.append("        AND BL.OBL_ISS_OFC_CD = OFC.OFC_CD(+)" ).append("\n"); 
		query.append("        AND BKG.CMDT_CD = COM.CMDT_CD(+)" ).append("\n"); 
		query.append("        AND BCC.BKG_CUST_TP_CD = 'C'" ).append("\n"); 
		query.append("        AND BKG.BKG_NO=BCC.BKG_NO" ).append("\n"); 
		query.append("        AND BKG.BKG_NO=BCS.BKG_NO" ).append("\n"); 
		query.append("        AND BCS.BKG_CUST_TP_CD = 'S'" ).append("\n"); 
		query.append("        AND BKG.BKG_NO=BCN.BKG_NO" ).append("\n"); 
		query.append("        AND BCN.BKG_CUST_TP_CD = 'N'" ).append("\n"); 
		query.append("        AND BKG.BKG_NO=BCA.BKG_NO" ).append("\n"); 
		query.append("        AND BCA.BKG_CUST_TP_CD = 'A'" ).append("\n"); 
		query.append("        AND BKG.BKG_NO=BCF.BKG_NO" ).append("\n"); 
		query.append("        AND BCF.BKG_CUST_TP_CD = 'F'" ).append("\n"); 
		query.append("        AND BKG.BKG_NO=BCE.BKG_NO" ).append("\n"); 
		query.append("        AND BCE.BKG_CUST_TP_CD = 'E'" ).append("\n"); 
		query.append("        AND DOC.PCK_TP_CD = CNV.PCK_TP_CD(+)" ).append("\n"); 
		query.append("        AND CNV.CNT_CD(+) = 'TW'" ).append("\n"); 

	}
}