/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : AusCustomsTransmissionDBDAOsearchBlGeneralForMRSQL.java
*@FileTitle :
*Open Issues :
*Change history :
*@LastModifyDate : 2010.03.09
*@LastModifier : 김승민
*@LastVersion : 1.0
* 2010.03.09 김승민
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.australia.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author KIM SEUNG MIN
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AusCustomsTransmissionDBDAOsearchBlGeneralForMRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();

	Logger log =Logger.getLogger(this.getClass());

	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;

	/**
	  * <pre>
	  * 호주세관으로 전송할 Manifest B/L General 정보를 조회한다.
	  * </pre>
	  */
	public AusCustomsTransmissionDBDAOsearchBlGeneralForMRSQL(){
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
		query.append("Path : com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.australia.integration").append("\n");
		query.append("FileName : AusCustomsTransmissionDBDAOsearchBlGeneralForMRSQL").append("\n");
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
		query.append("SELECT " ).append("\n");
		query.append("           NVL(B.BL_NO,'')||DECODE(NVL(B.BL_TP_CD,''),'S','',NVL(B.BL_TP_CD,'')) blnbr," ).append("\n");
		query.append("           NVL(B.BKG_NO,'') bkgnbr," ).append("\n");
		query.append("           NVL(VVD.POL_CD,'') blpol," ).append("\n");
		query.append("           NVL(VVD.POD_CD,'') blpod," ).append("\n");
		query.append("           NVL(B.POR_CD,'') blpor," ).append("\n");
		query.append("           NVL(B.DEL_CD,'') bldel," ).append("\n");
		query.append("           DECODE(@[pol_cd],null,NVL(B.PST_RLY_PORT_CD,''),NVL(B.PRE_RLY_PORT_CD,'')) blrly," ).append("\n");
		query.append("           NVL(E.LOC_CD,'') blplace," ).append("\n");
		query.append("           NVL(TO_CHAR(BL.OBL_ISS_DT,'RRMMDD'),'') bldate," ).append("\n");
		query.append("           NVL(BCS.CUST_CNT_CD,'')||LPAD(NVL(TO_CHAR(BCS.CUST_SEQ),''),6,'0') cust_cd,           " ).append("\n");
		query.append("              DECODE(SCE_TOKEN_NL_FNC(BCS.CUST_NM,1),NULL," ).append("\n");
		query.append("              DECODE(SCE_TOKEN_NL_FNC(BCS.CUST_NM,2), NULL,  " ).append("\n");
		query.append("	            DECODE(SCE_TOKEN_NL_FNC(BCS.CUST_ADDR,1), NULL," ).append("\n");
		query.append("	            DECODE(SCE_TOKEN_NL_FNC(BCS.CUST_ADDR,2),NULL, " ).append("\n");
		query.append("	            SCE_TOKEN_NL_FNC(BCS.CUST_ADDR,3),SCE_TOKEN_NL_FNC(BCS.CUST_ADDR,2))," ).append("\n");
		query.append("	            (SCE_TOKEN_NL_FNC(BCS.CUST_ADDR,1)))," ).append("\n");
		query.append("	            SCE_TOKEN_NL_FNC(BCS.CUST_NM,2)),SCE_TOKEN_NL_FNC(BCS.CUST_NM,1)) shpr1,           " ).append("\n");
		query.append("              DECODE(SCE_TOKEN_NL_FNC(BCS.CUST_NM,2), NULL, " ).append("\n");
		query.append("              DECODE(SCE_TOKEN_NL_FNC(BCS.CUST_ADDR,1), NULL,   " ).append("\n");
		query.append("           		DECODE(SCE_TOKEN_NL_FNC(BCS.CUST_ADDR,2), NULL, " ).append("\n");
		query.append("           		SCE_TOKEN_NL_FNC(BCS.CUST_ADDR,3),SCE_TOKEN_NL_FNC(BCS.CUST_ADDR,2))," ).append("\n");
		query.append("           		SCE_TOKEN_NL_FNC(BCS.CUST_ADDR,1)),SCE_TOKEN_NL_FNC(BCS.CUST_NM,2)) shpr2,           " ).append("\n");
		query.append("              DECODE(SCE_TOKEN_NL_FNC(BCS.CUST_ADDR,1), NULL, " ).append("\n");
		query.append("              DECODE(SCE_TOKEN_NL_FNC(BCS.CUST_ADDR,2), NULL,  " ).append("\n");
		query.append("           		SCE_TOKEN_NL_FNC(BCS.CUST_ADDR,3),SCE_TOKEN_NL_FNC(BCS.CUST_ADDR,2))," ).append("\n");
		query.append("           		SCE_TOKEN_NL_FNC(BCS.CUST_ADDR,1)) shpr3,          " ).append("\n");
		query.append("              DECODE(SCE_TOKEN_NL_FNC(BCS.CUST_ADDR,2), NULL, " ).append("\n");
		query.append("              SCE_TOKEN_NL_FNC(BCS.CUST_ADDR,3),SCE_TOKEN_NL_FNC(BCS.CUST_ADDR,2)) shpr4,           " ).append("\n");
		query.append("              SCE_TOKEN_NL_FNC(BCS.CUST_ADDR,3) shpr5,          " ).append("\n");
		query.append("              DECODE(SCE_TOKEN_NL_FNC(BCC.CUST_NM,1),NULL," ).append("\n");
		query.append("	DECODE(SCE_TOKEN_NL_FNC(BCC.CUST_NM,2), NULL,  " ).append("\n");
		query.append("	            DECODE(SCE_TOKEN_NL_FNC(BCC.CUST_ADDR,1), NULL," ).append("\n");
		query.append("	            DECODE(SCE_TOKEN_NL_FNC(BCC.CUST_ADDR,2),NULL, " ).append("\n");
		query.append("	            SCE_TOKEN_NL_FNC(BCC.CUST_ADDR,3),SCE_TOKEN_NL_FNC(BCC.CUST_ADDR,2))," ).append("\n");
		query.append("	            (SCE_TOKEN_NL_FNC(BCC.CUST_ADDR,1)))," ).append("\n");
		query.append("	            SCE_TOKEN_NL_FNC(BCC.CUST_NM,2)),SCE_TOKEN_NL_FNC(BCC.CUST_NM,1)) cnee1,           " ).append("\n");
		query.append("              DECODE(SCE_TOKEN_NL_FNC(BCC.CUST_NM,2), NULL, " ).append("\n");
		query.append("              DECODE(SCE_TOKEN_NL_FNC(BCC.CUST_ADDR,1), NULL,   " ).append("\n");
		query.append("           		DECODE(SCE_TOKEN_NL_FNC(BCC.CUST_ADDR,2), NULL, " ).append("\n");
		query.append("           		SCE_TOKEN_NL_FNC(BCC.CUST_ADDR,3),SCE_TOKEN_NL_FNC(BCC.CUST_ADDR,2))," ).append("\n");
		query.append("           		SCE_TOKEN_NL_FNC(BCC.CUST_ADDR,1)),SCE_TOKEN_NL_FNC(BCC.CUST_NM,2)) cnee2,           " ).append("\n");
		query.append("              DECODE(SCE_TOKEN_NL_FNC(BCC.CUST_ADDR,1), NULL, " ).append("\n");
		query.append("              DECODE(SCE_TOKEN_NL_FNC(BCC.CUST_ADDR,2), NULL,  " ).append("\n");
		query.append("           		SCE_TOKEN_NL_FNC(BCC.CUST_ADDR,3),SCE_TOKEN_NL_FNC(BCC.CUST_ADDR,2))," ).append("\n");
		query.append("           		SCE_TOKEN_NL_FNC(BCC.CUST_ADDR,1)) cnee3,          " ).append("\n");
		query.append("              DECODE(SCE_TOKEN_NL_FNC(BCC.CUST_ADDR,2), NULL, " ).append("\n");
		query.append("              SCE_TOKEN_NL_FNC(BCC.CUST_ADDR,3),SCE_TOKEN_NL_FNC(BCC.CUST_ADDR,2))  cnee4,           " ).append("\n");
		query.append("              SCE_TOKEN_NL_FNC(BCC.CUST_ADDR,3) cnee5,           " ).append("\n");
		query.append("              DECODE(SCE_TOKEN_NL_FNC(BCN.CUST_NM,1),NULL," ).append("\n");
		query.append("              DECODE(SCE_TOKEN_NL_FNC(BCN.CUST_NM,2), NULL,  " ).append("\n");
		query.append("	            DECODE(SCE_TOKEN_NL_FNC(BCN.CUST_ADDR,1), NULL," ).append("\n");
		query.append("	            DECODE(SCE_TOKEN_NL_FNC(BCN.CUST_ADDR,2),NULL, " ).append("\n");
		query.append("	            SCE_TOKEN_NL_FNC(BCN.CUST_ADDR,3),SCE_TOKEN_NL_FNC(BCN.CUST_ADDR,2))," ).append("\n");
		query.append("	            (SCE_TOKEN_NL_FNC(BCN.CUST_ADDR,1)))," ).append("\n");
		query.append("	            SCE_TOKEN_NL_FNC(BCN.CUST_NM,2)),SCE_TOKEN_NL_FNC(BCN.CUST_NM,1)) ntfy1,           " ).append("\n");
		query.append("              DECODE(SCE_TOKEN_NL_FNC(BCN.CUST_NM,2), NULL, " ).append("\n");
		query.append("              DECODE(SCE_TOKEN_NL_FNC(BCN.CUST_ADDR,1), NULL,   " ).append("\n");
		query.append("           		DECODE(SCE_TOKEN_NL_FNC(BCN.CUST_ADDR,2), NULL, " ).append("\n");
		query.append("           		SCE_TOKEN_NL_FNC(BCN.CUST_ADDR,3),SCE_TOKEN_NL_FNC(BCN.CUST_ADDR,2))," ).append("\n");
		query.append("           		SCE_TOKEN_NL_FNC(BCN.CUST_ADDR,1)),SCE_TOKEN_NL_FNC(BCN.CUST_NM,2)) ntfy2,          " ).append("\n");
		query.append("              DECODE(SCE_TOKEN_NL_FNC(BCN.CUST_ADDR,1), NULL, " ).append("\n");
		query.append("              DECODE(SCE_TOKEN_NL_FNC(BCN.CUST_ADDR,2), NULL,  " ).append("\n");
		query.append("           		SCE_TOKEN_NL_FNC(BCN.CUST_ADDR,3),SCE_TOKEN_NL_FNC(BCN.CUST_ADDR,2))," ).append("\n");
		query.append("           		SCE_TOKEN_NL_FNC(BCN.CUST_ADDR,1)) ntfy3,           " ).append("\n");
		query.append("              DECODE(SCE_TOKEN_NL_FNC(BCN.CUST_ADDR,2), NULL, " ).append("\n");
		query.append("              SCE_TOKEN_NL_FNC(BCN.CUST_ADDR,3),SCE_TOKEN_NL_FNC(BCN.CUST_ADDR,2)) ntfy4,           " ).append("\n");
		query.append("              SCE_TOKEN_NL_FNC(BCN.CUST_ADDR,3) ntfy5,           " ).append("\n");
		query.append("              SCE_TOKEN_NL_FNC(BCA.CUST_NM,1) ntfy21,           " ).append("\n");
		query.append("              SCE_TOKEN_NL_FNC(BCA.CUST_NM,2) ntfy22,           " ).append("\n");
		query.append("              SCE_TOKEN_NL_FNC(BCA.CUST_NM,3) ntfy23,           " ).append("\n");
		query.append("              SCE_TOKEN_NL_FNC(BCA.CUST_NM,4) ntfy24,          " ).append("\n");
		query.append("              SCE_TOKEN_NL_FNC(BCA.CUST_NM,5) ntfy25,           " ).append("\n");
		query.append("              SCE_TOKEN_NL_FNC(BCF.CUST_NM,1) ffwd1,           " ).append("\n");
		query.append("              SCE_TOKEN_NL_FNC(BCF.CUST_NM,2) ffwd2,           " ).append("\n");
		query.append("              SCE_TOKEN_NL_FNC(BCF.CUST_NM,3)  ffwd3,           " ).append("\n");
		query.append("              SCE_TOKEN_NL_FNC(BCF.CUST_NM,4)  ffwd4,           " ).append("\n");
		query.append("              SCE_TOKEN_NL_FNC(BCF.CUST_NM,5)  ffwd5,          " ).append("\n");
		query.append("              SCE_TOKEN_NL_FNC(BCE.CUST_NM,1) expo1,           " ).append("\n");
		query.append("              SCE_TOKEN_NL_FNC(BCE.CUST_NM,2) expo2,           " ).append("\n");
		query.append("              SCE_TOKEN_NL_FNC(BCE.CUST_NM,3) expo3,           " ).append("\n");
		query.append("              SCE_TOKEN_NL_FNC(BCE.CUST_NM,4) expo4,           " ).append("\n");
		query.append("              SCE_TOKEN_NL_FNC(BCE.CUST_NM,5) expo5," ).append("\n");
		query.append("           NVL(BL.BL_CPY_KNT,0) blcopy," ).append("\n");
		query.append("           '1' blorg," ).append("\n");
		query.append("           NVL(DOC.PCK_QTY,0) blpkg," ).append("\n");
		query.append("           NVL(DOC.PCK_TP_CD,'') blpkgu," ).append("\n");
		query.append("           DECODE(NVL(DOC.WGT_UT_CD,''),'LBS',ROUND(NVL(DOC.ACT_WGT,0)*0.4536,3),NVL(DOC.ACT_WGT,0)) blwgt," ).append("\n");
		query.append("           DECODE(NVL(DOC.MEAS_UT_CD,''),'CBF',ROUND(NVL(DOC.MEAS_QTY,0)*0.0283,3),NVL(DOC.MEAS_QTY,0)) blmea," ).append("\n");
		query.append("           NVL(B.RCV_TERM_CD,'')||NVL(B.DE_TERM_CD,'') rdtype," ).append("\n");
		query.append("           DECODE(SUBSTR(B.POL_CD,1,2),'AU',DECODE(B.RCV_TERM_CD,'Y','FCL','S','LCL','')," ).append("\n");
		query.append("           DECODE(SUBSTR(B.POD_CD,1,2),'AU',DECODE(B.RCV_TERM_CD,'Y','FCL','S','LCL',''))) cargotype," ).append("\n");
		query.append("           NVL(CMD.CMDT_NM,'') commodity," ).append("\n");
		query.append("           TRANSLATE(NVL(B.XTER_RMK,' '),CHR(10),' ') xter_rmk," ).append("\n");
		query.append("           '' aus_quar," ).append("\n");
		query.append("           DECODE(NVL(RATE.FRT_TERM_CD,''), 'C','CLT','P','PPD','') frt_ind," ).append("\n");
		query.append("           NVL(B.BKG_NO,'') bkg_no," ).append("\n");
		query.append("           NVL(B.BKG_CGO_TP_CD,'') bkg_cgo_tp_cd," ).append("\n");
		query.append("           DECODE(NVL(B.DCGO_FLG,''),'N','0','Y','1') bkg_spe_dg,DECODE(NVL(B.RC_FLG,''),'N','0','Y','1') bkg_spe_rf," ).append("\n");
		query.append("           DECODE(NVL(B.AWK_CGO_FLG,''),'N','0','Y','1') bkg_spe_ak,DECODE(NVL(B.BB_CGO_FLG,''),'N','0','Y','1') bkg_spe_bb," ).append("\n");
		query.append("           DECODE(NVL(B.RD_CGO_FLG,''),'N','0','Y','1') bkg_spe_rd,NVL(B.REP_CMDT_CD,'') cmdt_cd," ).append("\n");
		query.append("           TRANSLATE(NVL(COM.REP_CMDT_NM,' '),CHR(10),' ') cmdt_desc      ," ).append("\n");
		query.append("			NVL(LTRIM(DOC.CSTMS_DESC),'') CSTMS_DESC " ).append("\n");
		query.append("      FROM BKG_BOOKING B, MDM_ORGANIZATION E, MDM_REP_CMDT COM, MDM_COMMODITY CMD, BKG_VVD VVD, BKG_BL_ISS BL, BKG_RATE RATE, " ).append("\n");
		query.append("           BKG_BL_DOC DOC, BKG_CUSTOMER BCC, BKG_CUSTOMER BCS, BKG_CUSTOMER BCN, BKG_CUSTOMER BCA, BKG_CUSTOMER BCF, BKG_CUSTOMER BCE" ).append("\n");
		query.append("WHERE  VVD.VSL_CD         = @[vsl_cd] " ).append("\n");
		query.append("           AND VVD.SKD_VOY_NO  = @[skd_voy_no]" ).append("\n");
		query.append("           AND VVD.SKD_DIR_CD     = @[skd_dir_cd]" ).append("\n");
		query.append("#if (${pol_cd}!= '')" ).append("\n");
		query.append("           AND VVD.POL_CD        = @[pol_cd]" ).append("\n");
		query.append("#end" ).append("\n");
		query.append("#if (${pod_cd}!= '')" ).append("\n");
		query.append("           AND VVD.POD_CD        = @[pod_cd]" ).append("\n");
		query.append("#end" ).append("\n");
		query.append("           AND B.BKG_STS_CD           != 'X'  " ).append("\n");
		query.append("           AND B.BKG_STS_CD           != 'S'  " ).append("\n");
		query.append("           AND B.REP_CMDT_CD      = COM.REP_CMDT_CD(+) " ).append("\n");
		query.append("           AND B.CMDT_CD 	= CMD.CMDT_CD(+) " ).append("\n");
		query.append("           AND B.BKG_NO = VVD.BKG_NO " ).append("\n");
		query.append("           AND B.BKG_NO = BL.BKG_NO(+)" ).append("\n");
		query.append("           AND BL.OBL_ISS_OFC_CD = E.OFC_CD(+)" ).append("\n");
		query.append("           AND B.BKG_NO = RATE.BKG_NO(+)" ).append("\n");
		query.append("           AND B.BKG_NO = DOC.BKG_NO" ).append("\n");
		query.append("           AND BCC.BKG_CUST_TP_CD(+) = 'C'" ).append("\n");
		query.append("           AND B.BKG_NO=BCC.BKG_NO(+)" ).append("\n");
		query.append("           AND B.BKG_NO=BCS.BKG_NO" ).append("\n");
		query.append("           AND BCS.BKG_CUST_TP_CD = 'S'" ).append("\n");
		query.append("           AND B.BKG_NO=BCN.BKG_NO(+)" ).append("\n");
		query.append("           AND BCN.BKG_CUST_TP_CD(+) = 'N'" ).append("\n");
		query.append("           AND B.BKG_NO=BCA.BKG_NO(+)" ).append("\n");
		query.append("           AND BCA.BKG_CUST_TP_CD(+) = 'A'" ).append("\n");
		query.append("           AND B.BKG_NO=BCF.BKG_NO(+)" ).append("\n");
		query.append("           AND BCF.BKG_CUST_TP_CD(+) = 'F'" ).append("\n");
		query.append("           AND B.BKG_NO=BCE.BKG_NO(+)" ).append("\n");
		query.append("           AND BCE.BKG_CUST_TP_CD(+) = 'E'" ).append("\n");
		query.append("           ORDER BY B.BL_NO" ).append("\n");

	}
}