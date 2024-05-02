/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : HongKongCustomsTransmissionDBDAOsearchBlGeneralRSQL.java
*@FileTitle :
*Open Issues :
*Change history :
*@LastModifyDate : 2014.08.22
*@LastModifier : taekyoung kim
*@LastVersion : 1.0
* 2014.08.22 taekyoung kim
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.hongkong.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author taekyoung kim
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class HongKongCustomsTransmissionDBDAOsearchBlGeneralRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();

	Logger log =Logger.getLogger(this.getClass());

	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;

	/**
	  * <pre>
	  * 홍콩세관 신고용 Manifest B/L General 정보를 조회한다.
	  * </pre>
	  */
	public HongKongCustomsTransmissionDBDAOsearchBlGeneralRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("pol_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bl_no",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("skd_dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("amend_bl",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("bkg_qty",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n");
		query.append("Path : com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.hongkong.integration").append("\n");
		query.append("FileName : HongKongCustomsTransmissionDBDAOsearchBlGeneralRSQL").append("\n");
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
		query.append("SELECT  " ).append("\n");
		query.append("           NVL(BKG.BL_NO,'')||DECODE(NVL(BKG.BL_TP_CD,''),'S','',NVL(BKG.BL_TP_CD,'')) bl_no," ).append("\n");
		query.append("           --NVL(DECODE(BKG.POL_CD,'CNHKG','HKHKG',BKG.POL_CD),'') pol_cd," ).append("\n");
		query.append("			#if (${pol_cd}!= '')" ).append("\n");
		query.append("              NVL(DECODE(@[pol_cd],'CNHKG','HKHKG',@[pol_cd]),'') pol_cd," ).append("\n");
		query.append("			#else " ).append("\n");
		query.append("              NVL(DECODE(BKG.POL_CD,'CNHKG','HKHKG',BKG.POL_CD),'') pol_cd," ).append("\n");
		query.append("			#end" ).append("\n");
		query.append("           NVL(DECODE(BKG.POD_CD,'CNHKG','HKHKG',BKG.POD_CD),'') pod_cd," ).append("\n");
		query.append("           NVL(DECODE(BKG.POR_CD,'CNHKG','HKHKG',BKG.POR_CD),'') por_cd," ).append("\n");
		query.append("           NVL(DECODE(BKG.DEL_CD,'CNHKG','HKHKG',BKG.DEL_CD),'') del_cd," ).append("\n");
		query.append("           DECODE(@[pol_cd],null,NVL(DECODE(BKG.PST_RLY_PORT_CD,'CNHKG','HKHKG',BKG.PST_RLY_PORT_CD),''),NVL(DECODE(BKG.PRE_RLY_PORT_CD,'CNHKG','HKHKG',BKG.PRE_RLY_PORT_CD),'')) BLRLY," ).append("\n");
		query.append("           NVL(DECODE(OFC.LOC_CD,'CNHKG','HKHKG',OFC.LOC_CD),'') BLPLACE," ).append("\n");
		query.append("           NVL(TO_CHAR(BL.OBL_ISS_DT,'RRMMDD'),'') BLDATE,           " ).append("\n");
		query.append("    		  REPLACE(REPLACE(REPLACE(REPLACE(REPLACE(SCE_TOKEN_NL_FNC(BCS.CUST_NM,1),'&',CHR(38)||'amp'||CHR(59)),'<',CHR(38)||'lt'||CHR(59)),'>',CHR(38)||'gt'||CHR(59)),'\"',CHR(38)||'quot'||CHR(59)),CHR(39),CHR(38)||'apos'||CHR(59)) SHPR1," ).append("\n");
		query.append("            " ).append("\n");
		query.append("    		  REPLACE(REPLACE(REPLACE(REPLACE(REPLACE(SCE_TOKEN_NL_FNC(BCS.CUST_NM,2),'&',CHR(38)||'amp'||CHR(59)),'<',CHR(38)||'lt'||CHR(59)),'>',CHR(38)||'gt'||CHR(59)),'\"',CHR(38)||'quot'||CHR(59)),CHR(39),CHR(38)||'apos'||CHR(59)) SHPR2," ).append("\n");
		query.append("           " ).append("\n");
		query.append("    		  REPLACE(REPLACE(REPLACE(REPLACE(REPLACE(SCE_TOKEN_NL_FNC(BCS.CUST_ADDR,1),'&',CHR(38)||'amp'||CHR(59)),'<',CHR(38)||'lt'||CHR(59)),'>',CHR(38)||'gt'||CHR(59)),'\"',CHR(38)||'quot'||CHR(59)),CHR(39),CHR(38)||'apos'||CHR(59)) SHPR3," ).append("\n");
		query.append("            " ).append("\n");
		query.append("    		  REPLACE(REPLACE(REPLACE(REPLACE(REPLACE(SCE_TOKEN_NL_FNC(BCS.CUST_ADDR,2),'&',CHR(38)||'amp'||CHR(59)),'<',CHR(38)||'lt'||CHR(59)),'>',CHR(38)||'gt'||CHR(59)),'\"',CHR(38)||'quot'||CHR(59)),CHR(39),CHR(38)||'apos'||CHR(59)) SHPR4," ).append("\n");
		query.append("            " ).append("\n");
		query.append("    		  REPLACE(REPLACE(REPLACE(REPLACE(REPLACE(SCE_TOKEN_NL_FNC(BCS.CUST_ADDR,3),'&',CHR(38)||'amp'||CHR(59)),'<',CHR(38)||'lt'||CHR(59)),'>',CHR(38)||'gt'||CHR(59)),'\"',CHR(38)||'quot'||CHR(59)),CHR(39),CHR(38)||'apos'||CHR(59)) SHPR5," ).append("\n");
		query.append("           " ).append("\n");
		query.append("    		  REPLACE(REPLACE(REPLACE(REPLACE(REPLACE(SCE_TOKEN_NL_FNC(BCC.CUST_NM,1),'&',CHR(38)||'amp'||CHR(59)),'<',CHR(38)||'lt'||CHR(59)),'>',CHR(38)||'gt'||CHR(59)),'\"',CHR(38)||'quot'||CHR(59)),CHR(39),CHR(38)||'apos'||CHR(59)) CNEE1," ).append("\n");
		query.append("            " ).append("\n");
		query.append("    		  REPLACE(REPLACE(REPLACE(REPLACE(REPLACE(SCE_TOKEN_NL_FNC(BCC.CUST_NM,2),'&',CHR(38)||'amp'||CHR(59)),'<',CHR(38)||'lt'||CHR(59)),'>',CHR(38)||'gt'||CHR(59)),'\"',CHR(38)||'quot'||CHR(59)),CHR(39),CHR(38)||'apos'||CHR(59)) CNEE2," ).append("\n");
		query.append("           " ).append("\n");
		query.append("    		  REPLACE(REPLACE(REPLACE(REPLACE(REPLACE(SCE_TOKEN_NL_FNC(BCC.CUST_ADDR,1),'&',CHR(38)||'amp'||CHR(59)),'<',CHR(38)||'lt'||CHR(59)),'>',CHR(38)||'gt'||CHR(59)),'\"',CHR(38)||'quot'||CHR(59)),CHR(39),CHR(38)||'apos'||CHR(59)) CNEE3," ).append("\n");
		query.append("           " ).append("\n");
		query.append("    		  REPLACE(REPLACE(REPLACE(REPLACE(REPLACE(SCE_TOKEN_NL_FNC(BCC.CUST_ADDR,2),'&',CHR(38)||'amp'||CHR(59)),'<',CHR(38)||'lt'||CHR(59)),'>',CHR(38)||'gt'||CHR(59)),'\"',CHR(38)||'quot'||CHR(59)),CHR(39),CHR(38)||'apos'||CHR(59)) CNEE4," ).append("\n");
		query.append("           " ).append("\n");
		query.append("    		  REPLACE(REPLACE(REPLACE(REPLACE(REPLACE(SCE_TOKEN_NL_FNC(BCC.CUST_ADDR,3),'&',CHR(38)||'amp'||CHR(59)),'<',CHR(38)||'lt'||CHR(59)),'>',CHR(38)||'gt'||CHR(59)),'\"',CHR(38)||'quot'||CHR(59)),CHR(39),CHR(38)||'apos'||CHR(59)) CNEE5," ).append("\n");
		query.append("            " ).append("\n");
		query.append("    		  REPLACE(REPLACE(REPLACE(REPLACE(REPLACE(SCE_TOKEN_NL_FNC(BCN.CUST_NM,1),'&',CHR(38)||'amp'||CHR(59)),'<',CHR(38)||'lt'||CHR(59)),'>',CHR(38)||'gt'||CHR(59)),'\"',CHR(38)||'quot'||CHR(59)),CHR(39),CHR(38)||'apos'||CHR(59)) NTFY1," ).append("\n");
		query.append("            " ).append("\n");
		query.append("    		  REPLACE(REPLACE(REPLACE(REPLACE(REPLACE(SCE_TOKEN_NL_FNC(BCN.CUST_NM,2),'&',CHR(38)||'amp'||CHR(59)),'<',CHR(38)||'lt'||CHR(59)),'>',CHR(38)||'gt'||CHR(59)),'\"',CHR(38)||'quot'||CHR(59)),CHR(39),CHR(38)||'apos'||CHR(59)) NTFY2," ).append("\n");
		query.append("            " ).append("\n");
		query.append("    		  REPLACE(REPLACE(REPLACE(REPLACE(REPLACE(SCE_TOKEN_NL_FNC(BCN.CUST_ADDR,1),'&',CHR(38)||'amp'||CHR(59)),'<',CHR(38)||'lt'||CHR(59)),'>',CHR(38)||'gt'||CHR(59)),'\"',CHR(38)||'quot'||CHR(59)),CHR(39),CHR(38)||'apos'||CHR(59)) NTFY3," ).append("\n");
		query.append("            " ).append("\n");
		query.append("    		  REPLACE(REPLACE(REPLACE(REPLACE(REPLACE(SCE_TOKEN_NL_FNC(BCN.CUST_ADDR,2),'&',CHR(38)||'amp'||CHR(59)),'<',CHR(38)||'lt'||CHR(59)),'>',CHR(38)||'gt'||CHR(59)),'\"',CHR(38)||'quot'||CHR(59)),CHR(39),CHR(38)||'apos'||CHR(59)) NTFY4," ).append("\n");
		query.append("           " ).append("\n");
		query.append("    		  REPLACE(REPLACE(REPLACE(REPLACE(REPLACE(SCE_TOKEN_NL_FNC(BCN.CUST_ADDR,3),'&',CHR(38)||'amp'||CHR(59)),'<',CHR(38)||'lt'||CHR(59)),'>',CHR(38)||'gt'||CHR(59)),'\"',CHR(38)||'quot'||CHR(59)),CHR(39),CHR(38)||'apos'||CHR(59)) NTFY5," ).append("\n");
		query.append("           " ).append("\n");
		query.append("    		  REPLACE(REPLACE(REPLACE(REPLACE(REPLACE(SCE_TOKEN_NL_FNC(BCA.CUST_NM,1),'&',CHR(38)||'amp'||CHR(59)),'<',CHR(38)||'lt'||CHR(59)),'>',CHR(38)||'gt'||CHR(59)),'\"',CHR(38)||'quot'||CHR(59)),CHR(39),CHR(38)||'apos'||CHR(59)) NTFY21," ).append("\n");
		query.append("            " ).append("\n");
		query.append("    		  REPLACE(REPLACE(REPLACE(REPLACE(REPLACE(SCE_TOKEN_NL_FNC(BCA.CUST_NM,2),'&',CHR(38)||'amp'||CHR(59)),'<',CHR(38)||'lt'||CHR(59)),'>',CHR(38)||'gt'||CHR(59)),'\"',CHR(38)||'quot'||CHR(59)),CHR(39),CHR(38)||'apos'||CHR(59)) NTFY22," ).append("\n");
		query.append("            " ).append("\n");
		query.append("    		  REPLACE(REPLACE(REPLACE(REPLACE(REPLACE(SCE_TOKEN_NL_FNC(BCA.CUST_NM,3),'&',CHR(38)||'amp'||CHR(59)),'<',CHR(38)||'lt'||CHR(59)),'>',CHR(38)||'gt'||CHR(59)),'\"',CHR(38)||'quot'||CHR(59)),CHR(39),CHR(38)||'apos'||CHR(59)) NTFY23," ).append("\n");
		query.append("            " ).append("\n");
		query.append("    		  REPLACE(REPLACE(REPLACE(REPLACE(REPLACE(SCE_TOKEN_NL_FNC(BCA.CUST_NM,4),'&',CHR(38)||'amp'||CHR(59)),'<',CHR(38)||'lt'||CHR(59)),'>',CHR(38)||'gt'||CHR(59)),'\"',CHR(38)||'quot'||CHR(59)),CHR(39),CHR(38)||'apos'||CHR(59)) NTFY24," ).append("\n");
		query.append("           " ).append("\n");
		query.append("    		  REPLACE(REPLACE(REPLACE(REPLACE(REPLACE(SCE_TOKEN_NL_FNC(BCA.CUST_NM,5),'&',CHR(38)||'amp'||CHR(59)),'<',CHR(38)||'lt'||CHR(59)),'>',CHR(38)||'gt'||CHR(59)),'\"',CHR(38)||'quot'||CHR(59)),CHR(39),CHR(38)||'apos'||CHR(59)) NTFY25," ).append("\n");
		query.append("            " ).append("\n");
		query.append("            " ).append("\n");
		query.append("              SCE_TOKEN_NL_FNC(BCF.CUST_NM,1) FFWD1," ).append("\n");
		query.append("           " ).append("\n");
		query.append("              SCE_TOKEN_NL_FNC(BCF.CUST_NM,2) FFWD2," ).append("\n");
		query.append("            " ).append("\n");
		query.append("              SCE_TOKEN_NL_FNC(BCF.CUST_NM,3) FFWD3," ).append("\n");
		query.append("            " ).append("\n");
		query.append("              SCE_TOKEN_NL_FNC(BCF.CUST_NM,4) FFWD4," ).append("\n");
		query.append("            " ).append("\n");
		query.append("              SCE_TOKEN_NL_FNC(BCF.CUST_NM,5) FFWD5," ).append("\n");
		query.append("           " ).append("\n");
		query.append("              SCE_TOKEN_NL_FNC(BCE.CUST_NM,1) EXPO1," ).append("\n");
		query.append("            " ).append("\n");
		query.append("              SCE_TOKEN_NL_FNC(BCE.CUST_NM,2) EXPO2," ).append("\n");
		query.append("            " ).append("\n");
		query.append("              SCE_TOKEN_NL_FNC(BCE.CUST_NM,3) EXPO3," ).append("\n");
		query.append("           " ).append("\n");
		query.append("              SCE_TOKEN_NL_FNC(BCE.CUST_NM,4) EXPO4," ).append("\n");
		query.append("            " ).append("\n");
		query.append("              SCE_TOKEN_NL_FNC(BCE.CUST_NM,5) EXPO5," ).append("\n");
		query.append("            NVL(BL.BL_CPY_KNT,0) BLCOPY," ).append("\n");
		query.append("            '1'  BLORG," ).append("\n");
		query.append("           NVL(DOC.PCK_QTY,0) BLPKG," ).append("\n");
		query.append("           NVL(DOC.PCK_TP_CD,'') BLPKGU," ).append("\n");
		query.append("           DECODE(NVL(DOC.WGT_UT_CD,''),'LBS',ROUND(NVL(DOC.ACT_WGT,0)*0.4536),ROUND(NVL(DOC.ACT_WGT,0))) BLWGT," ).append("\n");
		query.append("           DECODE(NVL(DOC.WGT_UT_CD,''),'LBS','KGM','KGM') BLWGTU," ).append("\n");
		query.append("           DECODE(NVL(DOC.MEAS_UT_CD,''),'CBF',ROUND(NVL(DOC.MEAS_QTY,0)*0.0283,3),NVL(DOC.MEAS_QTY,0)) BLMEA," ).append("\n");
		query.append("           DECODE(NVL(DOC.MEAS_UT_CD,''),'CBF','CBM',NVL(DOC.MEAS_UT_CD,'')) BLMEAU," ).append("\n");
		query.append("           @[bkg_qty] BLQTY,	-- searchBkgQty ( )에서 조회한 값" ).append("\n");
		query.append("           DECODE(@[pol_cd],'CNHKG',NVL(DECODE(BKG.RCV_TERM_CD,'S','CFS','CY'),''),NVL(DECODE(BKG.DE_TERM_CD,'S','CFS','CY'),'')) RDTYPE," ).append("\n");
		query.append("          DECODE(BKG.HOT_DE_FLG,'Y','H','') HOT," ).append("\n");
		query.append("           NVL(RATE.FRT_TERM_CD,'') FRT," ).append("\n");
		query.append("           NVL(BKG.BKG_CGO_TP_CD,'') CARGOTYPE," ).append("\n");
		query.append("           NVL(BKG.CMDT_CD,'') COMMODITY," ).append("\n");
		query.append("           TRANSLATE(NVL(BKG.XTER_RMK,''),CHR(10),'') REMARK," ).append("\n");
		query.append("           '' AUS_QUAR," ).append("\n");
		query.append("            NVL(BKG.BKG_NO,'') BKGNBR," ).append("\n");
		query.append("           '' RGN_BKGNBR," ).append("\n");
		query.append("" ).append("\n");
		query.append("	#if (${pol_cd}!= '')" ).append("\n");
		query.append("           " ).append("\n");
		query.append("		   DECODE(BKG.POR_CD ,'CNHKG', 'N', 'Y') TS_IND," ).append("\n");
		query.append("	#end" ).append("\n");
		query.append("" ).append("\n");
		query.append("	#if (${pod_cd}!= '')" ).append("\n");
		query.append("           DECODE(BKG.DEL_CD ,'CNHKG', 'N', 'Y') TS_IND," ).append("\n");
		query.append("	#end  " ).append("\n");
		query.append("" ).append("\n");
		query.append("           '' LOH," ).append("\n");
		query.append("            NVL(@[amend_bl],'N')  tmpstr2,	-- searchSentBl ( ) 에서 조회한 값" ).append("\n");
		query.append("           NVL(BKG.BKG_CGO_TP_CD,'') bkgcgotp, " ).append("\n");
		query.append("           DECODE(NVL(BKG.DCGO_FLG,''),'N','0','Y','1') bkgSpeDg, " ).append("\n");
		query.append("           DECODE(NVL(BKG.RC_FLG,''),'N','0','Y','1') bkgSpeRf, " ).append("\n");
		query.append("           DECODE(NVL(BKG.AWK_CGO_FLG,''),'N','0','Y','1') bkgSpeAk, " ).append("\n");
		query.append("           DECODE(NVL(BKG.BB_CGO_FLG,''),'N','0','Y','1') bkgSpeBb, " ).append("\n");
		query.append("           DECODE(NVL(BKG.RD_CGO_FLG,''),'N','0','Y','1') bkgSpeRd,	-- searchCntrDetail ( ) 에서 사용" ).append("\n");
		query.append("           NVL(BKG.CMDT_CD,'') cmdtCd, TRANSLATE(NVL(COM.CMDT_NM,''),CHR(10),'') CMDT_NM,	-- searchCntrDetail ( ) 에서 사용       " ).append("\n");
		query.append("		   '' MF_SND_DT" ).append("\n");
		query.append("      FROM MDM_ORGANIZATION OFC, MDM_COMMODITY COM, BKG_BOOKING BKG, BKG_BL_DOC DOC, BKG_BL_ISS BL, BKG_VVD VVD, BKG_RATE RATE, BKG_CUSTOMER BCC, BKG_CUSTOMER BCS, BKG_CUSTOMER BCN, BKG_CUSTOMER BCA, BKG_CUSTOMER BCF, BKG_CUSTOMER BCE" ).append("\n");
		query.append("      WHERE BKG.BKG_NO = @[bkg_no]" ).append("\n");
		query.append("        AND BKG.BL_NO =  @[bl_no]" ).append("\n");
		query.append("        AND BKG.BKG_NO = BL.BKG_NO(+)" ).append("\n");
		query.append("        AND BKG.BKG_NO = VVD.BKG_NO" ).append("\n");
		query.append("#if (${pol_cd}!= '')" ).append("\n");
		query.append("              AND VVD.POL_CD = @[pol_cd]" ).append("\n");
		query.append("#end" ).append("\n");
		query.append("#if (${pod_cd}!= '')" ).append("\n");
		query.append("              AND VVD.POD_CD = @[pod_cd]" ).append("\n");
		query.append("#end           " ).append("\n");
		query.append("        AND VVD.VSL_CD = @[vsl_cd]" ).append("\n");
		query.append("        AND VVD.SKD_VOY_NO = @[skd_voy_no]" ).append("\n");
		query.append("        AND VVD.SKD_DIR_CD = @[skd_dir_cd]" ).append("\n");
		query.append("        AND (BKG.BKG_STS_CD = 'F' OR BKG.BKG_STS_CD = 'W')" ).append("\n");
		query.append("        AND BKG.BKG_CGO_TP_CD <> 'P'" ).append("\n");
		query.append("        AND BKG.BL_NO IS NOT NULL" ).append("\n");
		query.append("        AND BKG.BKG_NO = DOC.BKG_NO" ).append("\n");
		query.append("        AND BL.OBL_ISS_OFC_CD = OFC.OFC_CD(+)" ).append("\n");
		query.append("        AND BKG.CMDT_CD = COM.CMDT_CD(+)" ).append("\n");
		query.append("        AND BKG.BKG_NO = RATE.BKG_NO" ).append("\n");
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
		query.append("	ORDER BY VVD.POL_CD, VVD.POD_CD,NVL(BKG.BL_NO||BKG.BL_TP_CD,'')" ).append("\n");

	}
}