/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : EurCustomsTransmissionDBDAOsearchBlCustomerInfoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.10.09
*@LastModifier : 윤태승
*@LastVersion : 1.0
* 2012.10.09 윤태승
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.eur.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author yuntaeseung
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class EurCustomsTransmissionDBDAOsearchBlCustomerInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * B/L정보를 조회한다.
	  * 1. 2011.01.10 이수진 [CHM-201007774] EUR 24HR 관련 구주 세관 시스템 MRN 정보 추가 요청
	  *    : IND_AGREE, VALUE_AGREE 정보 추가 (RFA/TAA No. 정보)
	  * </pre>
	  */
	public EurCustomsTransmissionDBDAOsearchBlCustomerInfoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rep_cmdt_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cmdt_nm",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("pod_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.eur.integration").append("\n"); 
		query.append("FileName : EurCustomsTransmissionDBDAOsearchBlCustomerInfoRSQL").append("\n"); 
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
		query.append("BKG_GET_TOKEN_FNC(SHPR_CNEE_NTFY_TXID,1) SHPRTXID," ).append("\n"); 
		query.append("BKG_GET_TOKEN_FNC(SHPR_CNEE_NTFY_TXID,2) CNEETXID," ).append("\n"); 
		query.append("BKG_GET_TOKEN_FNC(SHPR_CNEE_NTFY_TXID,3) NTFYTXID," ).append("\n"); 
		query.append("X.*" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("( SELECT NVL(MAX(I_S),MAX(O_S))||','||NVL(MAX(I_C),MAX(O_C))||','||NVL(MAX(I_N),MAX(O_N))" ).append("\n"); 
		query.append("FROM ( SELECT DECODE(IO_BND_CD ,'I', DECODE(MAX(CNT_CD), 'TR', MAX(TR_SHPR_TAX_ID), 'IL',MAX(IL_SHPR_TAX_ID), 'LB',MAX(LB_SHPR_TAX_ID), ''), '') I_S" ).append("\n"); 
		query.append(", DECODE(IO_BND_CD ,'O', DECODE(MAX(CNT_CD), 'TR', MAX(TR_SHPR_TAX_ID), 'IL',MAX(IL_SHPR_TAX_ID), 'LB',MAX(LB_SHPR_TAX_ID), ''), '') O_S" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(", DECODE(IO_BND_CD ,'I', DECODE(MAX(CNT_CD), 'TR', MAX(TR_CNEE_TAX_ID), 'IL',MAX(IL_CNEE_TAX_ID), 'LB',MAX(LB_CNEE_TAX_ID), ''), '') I_C" ).append("\n"); 
		query.append(", DECODE(IO_BND_CD ,'O', DECODE(MAX(CNT_CD), 'TR', MAX(TR_CNEE_TAX_ID), 'IL',MAX(IL_CNEE_TAX_ID), 'LB',MAX(LB_CNEE_TAX_ID), ''), '') O_C" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(", DECODE(IO_BND_CD ,'I', DECODE(MAX(CNT_CD), 'TR', MAX(TR_NTFY_TAX_ID), 'IL',MAX(IL_NTFY_TAX_ID), 'LB',MAX(LB_NTFY_TAX_ID), ''), '') I_N" ).append("\n"); 
		query.append(", DECODE(IO_BND_CD ,'O', DECODE(MAX(CNT_CD), 'TR', MAX(TR_NTFY_TAX_ID), 'IL',MAX(IL_NTFY_TAX_ID), 'LB',MAX(LB_NTFY_TAX_ID), ''), '') O_N" ).append("\n"); 
		query.append("FROM BKG_XPT_IMP_LIC L" ).append("\n"); 
		query.append("WHERE BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("AND IO_BND_CD IN ('I','O')" ).append("\n"); 
		query.append("AND CNT_CD IN (SUBSTR(@[pol_cd], 1, 2), SUBSTR(@[pod_cd], 1, 2))" ).append("\n"); 
		query.append("AND  XPT_IMP_SEQ = ( SELECT MAX(XPT_IMP_SEQ)" ).append("\n"); 
		query.append("FROM BKG_XPT_IMP_LIC" ).append("\n"); 
		query.append("WHERE BKG_NO    = L.BKG_NO" ).append("\n"); 
		query.append("AND IO_BND_CD = L.IO_BND_CD" ).append("\n"); 
		query.append("AND CNT_CD IN (SUBSTR(@[pol_cd], 1, 2), SUBSTR(@[pod_cd], 1, 2))" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("GROUP BY IO_BND_CD" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append(") AS SHPR_CNEE_NTFY_TXID" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(",BK.BL_NO || DECODE(BK.BL_TP_CD, 'W', BK.BL_TP_CD)			   BLNBR" ).append("\n"); 
		query.append(",BK.POL_CD       					   BLPOL" ).append("\n"); 
		query.append(",LOC1.LOC_AMS_PORT_CD                 POL_AMS" ).append("\n"); 
		query.append(",LOC1.LOC_NM                          POL_FULLNAME" ).append("\n"); 
		query.append(",BK.POD_CD       					   BLPOD" ).append("\n"); 
		query.append(",LOC2.LOC_AMS_PORT_CD                 POD_AMS" ).append("\n"); 
		query.append(",LOC2.LOC_NM                          POD_FULLNAME" ).append("\n"); 
		query.append(",BK.POR_CD       					   BLPOR" ).append("\n"); 
		query.append(",LOC3.LOC_AMS_PORT_CD                 POR_AMS" ).append("\n"); 
		query.append(",LOC3.LOC_NM                          POR_FULLNAME" ).append("\n"); 
		query.append(",BK.DEL_CD       					   BLDEL" ).append("\n"); 
		query.append(",LOC4.LOC_AMS_PORT_CD                 DEL_AMS" ).append("\n"); 
		query.append(",LOC4.LOC_NM                          DEL_FULLNAME" ).append("\n"); 
		query.append(",DECODE(NVL(@[pol_cd],''), '', NVL(LOC5.UN_LOC_CD, BK.PST_RLY_PORT_CD), NVL(LOC5.UN_LOC_CD, BK.PRE_RLY_PORT_CD)) BLRLY" ).append("\n"); 
		query.append(",LOC5.LOC_AMS_PORT_CD RLY_AMS" ).append("\n"); 
		query.append(",LOC5.LOC_NM        RLY_FULLNAME" ).append("\n"); 
		query.append(",OFC.LOC_CD         BLPLACE" ).append("\n"); 
		query.append(",NVL(TO_CHAR(BBI.OBL_ISS_DT,'RRMMDD'),' ') BLDATE" ).append("\n"); 
		query.append(",BCS.CUST_CNT_CD    SHPRCN" ).append("\n"); 
		query.append(",BCS.CUST_SEQ       SHPRCD" ).append("\n"); 
		query.append(",SCE_TOKEN_NL_FNC(BCS.CUST_NM, 1)        SHPR1" ).append("\n"); 
		query.append(",SCE_TOKEN_NL_FNC(BCS.CUST_NM, 2)        SHPR2" ).append("\n"); 
		query.append(",SCE_TOKEN_NL_FNC(BCS.CUST_ADDR, 1)      SHPR3" ).append("\n"); 
		query.append(",SCE_TOKEN_NL_FNC(BCS.CUST_ADDR, 2)      SHPR4" ).append("\n"); 
		query.append(",SCE_TOKEN_NL_FNC(BCS.CUST_ADDR, 3)      SHPR5" ).append("\n"); 
		query.append(",BCC.CUST_CNT_CD    CNEECN" ).append("\n"); 
		query.append(",BCC.CUST_SEQ       CNEECD" ).append("\n"); 
		query.append(",SCE_TOKEN_NL_FNC(BCC.CUST_NM, 1)        CNEE1" ).append("\n"); 
		query.append(",SCE_TOKEN_NL_FNC(BCC.CUST_NM, 2)        CNEE2" ).append("\n"); 
		query.append(",SCE_TOKEN_NL_FNC(BCC.CUST_ADDR, 1)      CNEE3" ).append("\n"); 
		query.append(",SCE_TOKEN_NL_FNC(BCC.CUST_ADDR, 2)      CNEE4" ).append("\n"); 
		query.append(",SCE_TOKEN_NL_FNC(BCC.CUST_ADDR, 3)      CNEE5" ).append("\n"); 
		query.append(",BCN.CUST_CNT_CD    NTFYCN" ).append("\n"); 
		query.append(",BCN.CUST_SEQ       NTFYCD" ).append("\n"); 
		query.append(",SCE_TOKEN_NL_FNC(BCN.CUST_NM, 1)        NTFY1" ).append("\n"); 
		query.append(",SCE_TOKEN_NL_FNC(BCN.CUST_NM, 2)        NTFY2" ).append("\n"); 
		query.append(",SCE_TOKEN_NL_FNC(BCN.CUST_ADDR, 1)      NTFY3" ).append("\n"); 
		query.append(",SCE_TOKEN_NL_FNC(BCN.CUST_ADDR, 2)      NTFY4" ).append("\n"); 
		query.append(",SCE_TOKEN_NL_FNC(BCN.CUST_ADDR, 3)      NTFY5" ).append("\n"); 
		query.append(",BCA.CUST_CNT_CD    NTFY2CN" ).append("\n"); 
		query.append(",BCA.CUST_SEQ      NTFY2CD" ).append("\n"); 
		query.append(",SCE_TOKEN_NL_FNC(BCA.CUST_NM, 1)       NTFY21" ).append("\n"); 
		query.append(",SCE_TOKEN_NL_FNC(BCA.CUST_NM, 2)       NTFY22" ).append("\n"); 
		query.append(",SCE_TOKEN_NL_FNC(BCA.CUST_NM, 3)       NTFY23" ).append("\n"); 
		query.append(",SCE_TOKEN_NL_FNC(BCA.CUST_NM, 4)       NTFY24" ).append("\n"); 
		query.append(",SCE_TOKEN_NL_FNC(BCA.CUST_NM, 5)       NTFY25" ).append("\n"); 
		query.append(",BCF.CUST_CNT_CD   FFWDCN" ).append("\n"); 
		query.append(",BCF.CUST_SEQ      FFWDCD" ).append("\n"); 
		query.append(",SCE_TOKEN_NL_FNC(BCF.CUST_NM, 1)       FFWD1" ).append("\n"); 
		query.append(",SCE_TOKEN_NL_FNC(BCF.CUST_NM, 2)       FFWD2" ).append("\n"); 
		query.append(",SCE_TOKEN_NL_FNC(BCF.CUST_NM, 3)     	 FFWD3" ).append("\n"); 
		query.append(",SCE_TOKEN_NL_FNC(BCF.CUST_NM, 4)       FFWD4" ).append("\n"); 
		query.append(",SCE_TOKEN_NL_FNC(BCF.CUST_NM, 5)       FFWD5" ).append("\n"); 
		query.append(",''             EXPOCN" ).append("\n"); 
		query.append(",''             EXPOCD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(",SCE_TOKEN_NL_FNC(BCE.CUST_NM, 1)       EXPO1" ).append("\n"); 
		query.append(",SCE_TOKEN_NL_FNC(BCE.CUST_NM, 2)       EXPO2" ).append("\n"); 
		query.append(",SCE_TOKEN_NL_FNC(BCE.CUST_NM, 3)       EXPO3" ).append("\n"); 
		query.append(",SCE_TOKEN_NL_FNC(BCE.CUST_NM, 4)       EXPO4" ).append("\n"); 
		query.append(",SCE_TOKEN_NL_FNC(BCE.CUST_NM, 5)       EXPO5" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(",BBI.BL_CPY_KNT            BLCOPY" ).append("\n"); 
		query.append(",'1'                       BLORG" ).append("\n"); 
		query.append(",BBD.PCK_QTY               BLPKG" ).append("\n"); 
		query.append(",BBD.PCK_TP_CD             BLPKGU" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(",NVL(BBD.ACT_WGT, 0)        BLWGT" ).append("\n"); 
		query.append(",NVL(BBD.MEAS_QTY, 0)       BLMEA" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(",BBD.WGT_UT_CD             BL_WGT_UNIT" ).append("\n"); 
		query.append(",BBD.MEAS_UT_CD            BL_MEA_UNIT" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(",NVL(BK.RCV_TERM_CD, '') || NVL(BK.DE_TERM_CD, '') RDTYPE" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(",BK.BKG_CGO_TP_CD          CARGOTYPE" ).append("\n"); 
		query.append(",NVL(BK.CMDT_CD, '')       COMMODITY" ).append("\n"); 
		query.append(",@[cmdt_nm]       BLCMD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(",BK.REP_CMDT_CD    BLREPCMDCD" ).append("\n"); 
		query.append(",@[rep_cmdt_nm]    BLREPCMD" ).append("\n"); 
		query.append(",TRANSLATE(NVL(bk.XTER_RMK,' '),CHR(13)||CHR(10),' ') REMARK" ).append("\n"); 
		query.append(",'' AUS_QUAR -- B.bkg_aus_no" ).append("\n"); 
		query.append(",'' SRNBR" ).append("\n"); 
		query.append(",NVL(BK.BKG_NO, '') BKGNBR" ).append("\n"); 
		query.append(",'' RGN_BKGNBR -- bkg_psa_no" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(",NVL(BR.PPD_RCV_OFC_CD, '')    PPDOFC" ).append("\n"); 
		query.append(",NVL(BR.CLT_OFC_CD, '')        CCTOFC" ).append("\n"); 
		query.append(",''                            THDOFC" ).append("\n"); 
		query.append(",NVL(BK.SC_NO, '')             SCNO" ).append("\n"); 
		query.append(",NVL(BK.RFA_NO, '')            RFANO" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(",''                            WAYBILL_IND" ).append("\n"); 
		query.append(",''                            CUSTREF_NUM" ).append("\n"); 
		query.append(",''                            FINAL_ETA" ).append("\n"); 
		query.append(",''                            FUNC_CODE" ).append("\n"); 
		query.append(",NVL(TO_CHAR(BBD.BL_OBRD_DT,'YYYYMMDDHH24MI'),'') ONBOARD" ).append("\n"); 
		query.append(",''                            INV_NO" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(",NVL(BK.BL_NO,' ') IN_BL_NO" ).append("\n"); 
		query.append(",NVL(BK.BKG_NO,' ') IN_BKG_NO" ).append("\n"); 
		query.append(",NVL(BK.BKG_CGO_TP_CD,' ') IN_BKG_CGO_TP_CD" ).append("\n"); 
		query.append(",NVL(BK.DCGO_FLG,' ') IN_DCGO_FLG" ).append("\n"); 
		query.append(",NVL(BK.RC_FLG,' ') IN_RC_FLG" ).append("\n"); 
		query.append(",NVL(BK.AWK_CGO_FLG,' ') IN_AWK_CGO_FLG" ).append("\n"); 
		query.append(",NVL(BK.BB_CGO_FLG,' ') IN_BB_CGO_FLG" ).append("\n"); 
		query.append(",NVL(BK.RD_CGO_FLG,' ') IN_RD_CGO_FLG" ).append("\n"); 
		query.append(",NVL(BK.CMDT_CD,' ') IN_CMDT_CD" ).append("\n"); 
		query.append(",@[cmdt_nm] IN_CMDT_DESC" ).append("\n"); 
		query.append(",DECODE(RFA_NO, NULL, DECODE(TAA_NO, NULL, NULL, 'TAA'), 'RFA') IND_AGREE" ).append("\n"); 
		query.append(",DECODE(RFA_NO, NULL, TAA_NO, RFA_NO) VALUE_AGREE" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("BKG_VVD BV" ).append("\n"); 
		query.append(",BKG_BOOKING BK" ).append("\n"); 
		query.append(",BKG_BL_ISS  BBI" ).append("\n"); 
		query.append(",BKG_BL_DOC  BBD" ).append("\n"); 
		query.append(",BKG_RATE    BR" ).append("\n"); 
		query.append(",BKG_CUSTOMER BCS" ).append("\n"); 
		query.append(",BKG_CUSTOMER BCC" ).append("\n"); 
		query.append(",BKG_CUSTOMER BCN" ).append("\n"); 
		query.append(",BKG_CUSTOMER BCF" ).append("\n"); 
		query.append(",BKG_CUSTOMER BCA" ).append("\n"); 
		query.append(",BKG_CUSTOMER BCE" ).append("\n"); 
		query.append(",BKG_CSTMS_CMDT   CMD" ).append("\n"); 
		query.append(",MDM_LOCATION     LOC0" ).append("\n"); 
		query.append(",MDM_LOCATION     LOC1" ).append("\n"); 
		query.append(",MDM_LOCATION     LOC2" ).append("\n"); 
		query.append(",MDM_LOCATION     LOC3" ).append("\n"); 
		query.append(",MDM_LOCATION     LOC4" ).append("\n"); 
		query.append(",MDM_LOCATION     LOC5" ).append("\n"); 
		query.append(",MDM_ORGANIZATION OFC" ).append("\n"); 
		query.append(",MDM_COMMODITY    COM" ).append("\n"); 
		query.append("WHERE   BK.BKG_NO          =   @[bkg_no]" ).append("\n"); 
		query.append("AND   BK.BKG_NO          =   BV.BKG_NO" ).append("\n"); 
		query.append("AND   BK.BKG_NO          =   BBI.BKG_NO      (+)" ).append("\n"); 
		query.append("AND   BK.BKG_NO          =   BBD.BKG_NO      (+)" ).append("\n"); 
		query.append("AND   BK.BKG_NO          =   BR.BKG_NO       (+)" ).append("\n"); 
		query.append("AND   BK.BKG_NO          =   BCS.BKG_NO      (+)" ).append("\n"); 
		query.append("AND   BCS.BKG_CUST_TP_CD =   'S'" ).append("\n"); 
		query.append("AND   BK.BKG_NO          =   BCC.BKG_NO      (+)" ).append("\n"); 
		query.append("AND   BCC.BKG_CUST_TP_CD(+) =   'C'" ).append("\n"); 
		query.append("AND   BK.BKG_NO          =   BCN.BKG_NO      (+)" ).append("\n"); 
		query.append("AND   BCN.BKG_CUST_TP_CD(+) =   'N'" ).append("\n"); 
		query.append("AND   BK.BKG_NO          =   BCF.BKG_NO      (+)" ).append("\n"); 
		query.append("AND   BCF.BKG_CUST_TP_CD(+) =   'F'" ).append("\n"); 
		query.append("AND   BK.BKG_NO          =   BCA.BKG_NO      (+)" ).append("\n"); 
		query.append("AND   BCA.BKG_CUST_TP_CD(+) =   'A'" ).append("\n"); 
		query.append("AND   BK.BKG_NO          =   BCE.BKG_NO      (+)" ).append("\n"); 
		query.append("AND   BCE.BKG_CUST_TP_CD(+) =   'E'" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("AND   LOC0.LOC_CD(+)     =   DECODE(NVL(@[pol_cd],''), '', BV.POL_CD, BV.POD_CD)" ).append("\n"); 
		query.append("AND   BK.POR_CD         =   LOC3.LOC_CD  (+)" ).append("\n"); 
		query.append("AND   BK.POL_CD         =   LOC1.LOC_CD  (+)" ).append("\n"); 
		query.append("AND   BK.POD_CD         =   LOC2.LOC_CD  (+)" ).append("\n"); 
		query.append("AND   BK.DEL_CD         =   LOC4.LOC_CD  (+)" ).append("\n"); 
		query.append("AND   LOC5.LOC_CD(+)    = DECODE(NVL(@[pol_cd],''), '', NVL(BK.PST_RLY_PORT_CD,' '),NVL(BK.PRE_RLY_PORT_CD,' '))" ).append("\n"); 
		query.append("AND   BBI.OBL_ISS_OFC_CD      = OFC.OFC_CD(+)" ).append("\n"); 
		query.append("AND   BK.CMDT_CD         = COM.CMDT_CD(+)" ).append("\n"); 
		query.append("AND   BK.CMDT_CD         = CMD.MF_CMDT_CD(+)" ).append("\n"); 
		query.append("AND   ROWNUM = 1" ).append("\n"); 
		query.append(") X" ).append("\n"); 

	}
}