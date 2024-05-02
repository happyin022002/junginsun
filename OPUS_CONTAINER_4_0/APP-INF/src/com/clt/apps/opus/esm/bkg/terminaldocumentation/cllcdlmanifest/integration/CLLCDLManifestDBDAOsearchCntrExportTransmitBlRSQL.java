/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : CLLCDLManifestDBDAOsearchCntrExportTransmitBlRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.12.30
*@LastModifier : 
*@LastVersion : 1.0
* 2014.12.30 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.terminaldocumentation.cllcdlmanifest.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CLLCDLManifestDBDAOsearchCntrExportTransmitBlRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Container Export EDI 전송시 BL정보를 구하는 쿼리.
	  * </pre>
	  */
	public CLLCDLManifestDBDAOsearchCntrExportTransmitBlRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("form_bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("form_term_pol",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.terminaldocumentation.cllcdlmanifest.integration").append("\n"); 
		query.append("FileName : CLLCDLManifestDBDAOsearchCntrExportTransmitBlRSQL").append("\n"); 
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
		query.append("SELECT  NVL(BK.bl_no,' ')||NVL(BK.BL_TP_CD,' ') 	BLNBR," ).append("\n"); 
		query.append("		NVL(B.POL_CD,' ') 	BLPOL," ).append("\n"); 
		query.append("		C1.LOC_AMS_PORT_CD 	POL_AMS," ).append("\n"); 
		query.append("		C1.LOC_NM POL_FULLNAME," ).append("\n"); 
		query.append("		NVL(BK.POD_CD,' ') BLPOD," ).append("\n"); 
		query.append("		C2.LOC_AMS_PORT_CD POD_AMS," ).append("\n"); 
		query.append("		C2.LOC_NM POD_FULLNAME," ).append("\n"); 
		query.append("		NVL(BK.POR_CD,' ') BLPOR," ).append("\n"); 
		query.append("		C3.LOC_AMS_PORT_CD POR_AMS," ).append("\n"); 
		query.append("		C3.LOC_NM POR_FULLNAME," ).append("\n"); 
		query.append("		NVL(BK.DEL_CD,' ') BLDEL," ).append("\n"); 
		query.append("		C4.LOC_AMS_PORT_CD DEL_AMS," ).append("\n"); 
		query.append("		C4.LOC_NM DEL_FULLNAME," ).append("\n"); 
		query.append("		decode(@[form_term_pol],null,NVL(BK.PST_RLY_PORT_CD,' '),NVL(BK.PRE_RLY_PORT_CD,' ')) BLRLY," ).append("\n"); 
		query.append("		C5.LOC_AMS_PORT_CD RLY_AMS," ).append("\n"); 
		query.append("		C5.LOC_NM RLY_FULLNAME," ).append("\n"); 
		query.append("		NVL(E.LOC_CD,' ') BLPLACE," ).append("\n"); 
		query.append("		NVL(TO_CHAR(I.OBL_ISS_DT,'RRMMDD'),' ') BLDATE," ).append("\n"); 
		query.append("		DECODE(OL.EUR_TML_PURP_CD,'3','31',OL.EUR_TML_PURP_CD) BRAC," ).append("\n"); 
		query.append("		NVL(OL.POL_CD,' ') POL," ).append("\n"); 
		query.append("		NVL(OL.POD_CD,' ') POD," ).append("\n"); 
		query.append("		DECODE(OL.HLG_TP_CD,'1','1','2','2','3','2',OL.HLG_TP_CD) HAUL_MODE," ).append("\n"); 
		query.append("		DECODE(OL.BKG_TRSP_MOD_CD,'R','2','T','3','B','8',OL.BKG_TRSP_MOD_CD) TRAN_MODE," ).append("\n"); 
		query.append("		'230'||NVL(OL.FWRD_AGN_ID,' ') FORWARD_CD," ).append("\n"); 
		query.append("		BK.OB_SLS_OFC_CD SALES_OFFICE," ).append("\n"); 
		query.append("		SREP.SREP_NM SALES_NAME," ).append("\n"); 
		query.append("		P.CNTC_PSON_NM CONTACT_NAME," ).append("\n"); 
		query.append("		SUBSTR(NVL(CUST_S.CUST_CNT_CD,'  '),1,2) SHPRCN," ).append("\n"); 
		query.append("		NVL(TO_CHAR(CUST_S.CUST_SEQ), '   ') SHPRCD," ).append("\n"); 
		query.append("		BKG_TOKEN_NL_FNC(CUST_S.CUST_NM,1,'') SHPR1," ).append("\n"); 
		query.append("		BKG_TOKEN_NL_FNC(CUST_S.CUST_NM,2,'') SHPR2," ).append("\n"); 
		query.append("		BKG_TOKEN_NL_FNC(CUST_S.CUST_ADDR,1,'') SHPR3," ).append("\n"); 
		query.append("		BKG_TOKEN_NL_FNC(CUST_S.CUST_ADDR,2,'') SHPR4," ).append("\n"); 
		query.append("		BKG_TOKEN_NL_FNC(CUST_S.CUST_ADDR,3,'') SHPR5," ).append("\n"); 
		query.append("		NVL(CUST_C.CUST_CNT_CD,'') CNEECN," ).append("\n"); 
		query.append("		DECODE(TO_CHAR(CUST_C.CUST_SEQ),'0','',TO_CHAR(CUST_C.CUST_SEQ)) CNEECD," ).append("\n"); 
		query.append("		BKG_TOKEN_NL_FNC(CUST_C.CUST_NM,1,'') CNEE1," ).append("\n"); 
		query.append("		BKG_TOKEN_NL_FNC(CUST_C.CUST_NM,2,'') CNEE2," ).append("\n"); 
		query.append("		BKG_TOKEN_NL_FNC(CUST_C.CUST_ADDR,1,'') CNEE3," ).append("\n"); 
		query.append("		BKG_TOKEN_NL_FNC(CUST_C.CUST_ADDR,2,'') CNEE4," ).append("\n"); 
		query.append("		BKG_TOKEN_NL_FNC(CUST_C.CUST_ADDR,3,'') CNEE5," ).append("\n"); 
		query.append("		NVL(CUST_N.CUST_CNT_CD,'') NTFYCN," ).append("\n"); 
		query.append("		DECODE(TO_CHAR(CUST_N.CUST_SEQ),'0','',TO_CHAR(CUST_N.CUST_SEQ)) NTFYCD," ).append("\n"); 
		query.append("		BKG_TOKEN_NL_FNC(CUST_N.CUST_NM,1,'') NTFY1," ).append("\n"); 
		query.append("		BKG_TOKEN_NL_FNC(CUST_N.CUST_NM,2,'') NTFY2," ).append("\n"); 
		query.append("		BKG_TOKEN_NL_FNC(CUST_N.CUST_ADDR,1,'') NTFY3," ).append("\n"); 
		query.append("		BKG_TOKEN_NL_FNC(CUST_N.CUST_ADDR,2,'') NTFY4," ).append("\n"); 
		query.append("		BKG_TOKEN_NL_FNC(CUST_N.CUST_ADDR,3,'') NTFY5," ).append("\n"); 
		query.append("		NVL(CUST_A.CUST_CNT_CD,'') NTFY2CN," ).append("\n"); 
		query.append("		DECODE(TO_CHAR(CUST_A.CUST_SEQ),'0','',TO_CHAR(CUST_A.CUST_SEQ)) NTFY2CD," ).append("\n"); 
		query.append("		BKG_TOKEN_NL_FNC(CUST_A.CUST_NM,1,'') NTFY21," ).append("\n"); 
		query.append("		BKG_TOKEN_NL_FNC(CUST_A.CUST_NM,2,'') NTFY22," ).append("\n"); 
		query.append("		BKG_TOKEN_NL_FNC(CUST_A.CUST_NM,3,'') NTFY23," ).append("\n"); 
		query.append("		BKG_TOKEN_NL_FNC(CUST_A.CUST_NM,4,'') NTFY24," ).append("\n"); 
		query.append("		BKG_TOKEN_NL_FNC(CUST_A.CUST_NM,5,'') NTFY25," ).append("\n"); 
		query.append("		NVL(CUST_F.CUST_CNT_CD,'') FFWDCN," ).append("\n"); 
		query.append("		DECODE(TO_CHAR(CUST_F.CUST_SEQ),'0','',TO_CHAR(CUST_F.CUST_SEQ)) FFWDCD," ).append("\n"); 
		query.append("		BKG_TOKEN_NL_FNC(CUST_F.CUST_NM,1,'') FFWD1," ).append("\n"); 
		query.append("		BKG_TOKEN_NL_FNC(CUST_F.CUST_NM,2,'') FFWD2," ).append("\n"); 
		query.append("		BKG_TOKEN_NL_FNC(CUST_F.CUST_NM,3,'') FFWD3," ).append("\n"); 
		query.append("		BKG_TOKEN_NL_FNC(CUST_F.CUST_NM,4,'') FFWD4," ).append("\n"); 
		query.append("		BKG_TOKEN_NL_FNC(CUST_F.CUST_NM,5,'') FFWD5," ).append("\n"); 
		query.append("		NVL(CUST_E.CUST_CNT_CD,'') EXPOCN," ).append("\n"); 
		query.append("		DECODE(TO_CHAR(CUST_E.CUST_SEQ),'0','',TO_CHAR(CUST_E.CUST_SEQ)) EXPOCD," ).append("\n"); 
		query.append("		BKG_TOKEN_NL_FNC(CUST_E.CUST_NM,1,'') EXPO1," ).append("\n"); 
		query.append("		BKG_TOKEN_NL_FNC(CUST_E.CUST_NM,2,'') EXPO2," ).append("\n"); 
		query.append("		BKG_TOKEN_NL_FNC(CUST_E.CUST_NM,3,'') EXPO3," ).append("\n"); 
		query.append("		BKG_TOKEN_NL_FNC(CUST_E.CUST_NM,4,'') EXPO4," ).append("\n"); 
		query.append("		BKG_TOKEN_NL_FNC(CUST_E.CUST_NM,5,'') EXPO5," ).append("\n"); 
		query.append("		NVL(ISS.BL_CPY_KNT,0) BLCOPY," ).append("\n"); 
		query.append("		'1' BLORG," ).append("\n"); 
		query.append("		NVL(F.PCK_QTY,0) BLPKG," ).append("\n"); 
		query.append("		NVL(F.PCK_TP_CD,' ') BLPKGU," ).append("\n"); 
		query.append("		NVL(F.ACT_WGT,0) BLWGT," ).append("\n"); 
		query.append("		NVL(F.WGT_UT_CD,' ') BL_WGT_UNIT," ).append("\n"); 
		query.append("		NVL(F.MEAS_QTY,0) BLMEA," ).append("\n"); 
		query.append("		NVL(F.MEAS_UT_CD,' ') BL_MEA_UNIT," ).append("\n"); 
		query.append("		NVL(BK.rcv_term_CD,' ')||NVL(BK.DE_TERM_CD,' ') RDTYPE," ).append("\n"); 
		query.append("		NVL(BK.bkg_cgo_tp_CD,' ') CARGOTYPE," ).append("\n"); 
		query.append("		NVL(BK.cmdt_cd,' ') COMMODITY," ).append("\n"); 
		query.append("		Translate(NVL(COM.CMDT_NM,' '),chr(10),' ') BLCMD," ).append("\n"); 
		query.append("		NVL(BK.REP_CMDT_CD,' ') BLREPCMDCD," ).append("\n"); 
		query.append("		NVL(REP.REP_CMDT_NM,' ') BLREPCMD," ).append("\n"); 
		query.append("		Translate(NVL(BK.XTER_RMK,' '),chr(10),' ') REMARK," ).append("\n"); 
		query.append("		NVL(X.AUS_MF_REF_NO,' ') AUS_QUAR," ).append("\n"); 
		query.append("		'' SRNBR," ).append("\n"); 
		query.append("		NVL(B.bkg_no,' ') BKGNBR," ).append("\n"); 
		query.append("		NVL(R2.CUST_REF_NO_CTNT,' ') RGN_BKGNBR," ).append("\n"); 
		query.append("		NVL(RATE.PPD_RCV_OFC_CD,' ') PPDOFC," ).append("\n"); 
		query.append("		NVL(RATE.CLT_OFC_CD,' ') CCTOFC," ).append("\n"); 
		query.append("		'com_id' THDOFC," ).append("\n"); 
		query.append("		NVL(BK.SC_NO,' ') SCNO," ).append("\n"); 
		query.append("		NVL(BK.RFA_NO,' ') RFANO," ).append("\n"); 
		query.append("		'' WAYBILL_IND," ).append("\n"); 
		query.append("		NVL(R1.CUST_REF_NO_CTNT,' ') CUSTREF_NUM," ).append("\n"); 
		query.append("		'' FINAL_ETA," ).append("\n"); 
		query.append("		'' FUNC_CODE," ).append("\n"); 
		query.append("		'' ONBOARD," ).append("\n"); 
		query.append("		'' INV_NO," ).append("\n"); 
		query.append("		'' BLTS," ).append("\n"); 
		query.append("		'' BLTP," ).append("\n"); 
		query.append("		'' MSN," ).append("\n"); 
		query.append("		'' MSNCFM," ).append("\n"); 
		query.append("		'' CMDESC," ).append("\n"); 
		query.append("		DECODE(L1.scc_CD, L2.scc_CD, DECODE(SUBSTR(BK.pod_CD,1,2), SUBSTR(BK.del_CD,1,2), 'L', 'I'), 'I') LOCAL_IPI," ).append("\n"); 
		query.append("		BK.MTY_PKUP_YD_CD EQREL," ).append("\n"); 
		query.append("		TO_CHAR(bk.MTY_PKUP_DT,'RRRRMMDDHH24MI') EQPICKDT," ).append("\n"); 
		query.append("		BK.FULL_RTN_YD_CD EQRTN," ).append("\n"); 
		query.append("		NVL(BK.BKG_CGO_TP_CD,' ') BKG_CGO_TP," ).append("\n"); 
		query.append("		NVL(BK.DCGO_FLG,' ') DG_FLAG," ).append("\n"); 
		query.append("		NVL(BK.RC_FLG,' ') RC_FLAG," ).append("\n"); 
		query.append("		NVL(BK.AWK_CGO_FLG,' ') AK_FLAG," ).append("\n"); 
		query.append("		NVL(BK.BB_CGO_FLG,' ') BB_FLAG," ).append("\n"); 
		query.append("		NVL(BK.RD_CGO_FLG,' ') RD_FLAG," ).append("\n"); 
		query.append("		NVL(BK.cmdt_cd,' ') CMDT_CD," ).append("\n"); 
		query.append("		Translate(NVL(COM.CMDT_NM,' '),chr(10),' ') CMDT_NM" ).append("\n"); 
		query.append("FROM 	BKG_VVD B," ).append("\n"); 
		query.append("        BKG_BOOKING BK," ).append("\n"); 
		query.append("        BKG_BL_DOC F," ).append("\n"); 
		query.append("        BKG_BL_ISS I," ).append("\n"); 
		query.append("        bkg_reference R1," ).append("\n"); 
		query.append("        BKG_REFERENCE R2," ).append("\n"); 
		query.append("        BKG_RATE RATE," ).append("\n"); 
		query.append("        BKG_BL_ISS ISS," ).append("\n"); 
		query.append("        bkg_cntc_pson P," ).append("\n"); 
		query.append("        BKG_XPT_IMP_LIC X," ).append("\n"); 
		query.append("        MDM_LOCATION C," ).append("\n"); 
		query.append("        MDM_LOCATION C1," ).append("\n"); 
		query.append("        MDM_LOCATION C2," ).append("\n"); 
		query.append("        MDM_LOCATION C3," ).append("\n"); 
		query.append("        MDM_LOCATION C4," ).append("\n"); 
		query.append("        MDM_LOCATION C5," ).append("\n"); 
		query.append("		MDM_LOCATION L1," ).append("\n"); 
		query.append("		MDM_LOCATION L2," ).append("\n"); 
		query.append("        BKG_CUSTOMER CUST_C," ).append("\n"); 
		query.append("        BKG_CUSTOMER CUST_S," ).append("\n"); 
		query.append("        BKG_CUSTOMER CUST_N," ).append("\n"); 
		query.append("        BKG_CUSTOMER CUST_A," ).append("\n"); 
		query.append("        BKG_CUSTOMER CUST_F," ).append("\n"); 
		query.append("        BKG_CUSTOMER CUST_E,                      " ).append("\n"); 
		query.append("        MDM_ORGANIZATION E," ).append("\n"); 
		query.append("        MDM_COMMODITY COM," ).append("\n"); 
		query.append("		MDM_REP_CMDT REP," ).append("\n"); 
		query.append("        MDM_SLS_REP SREP," ).append("\n"); 
		query.append("        BKG_CSTMS_TML_EUR_ORG_LOCL OL" ).append("\n"); 
		query.append("WHERE  	B.BKG_NO		= @[form_bkg_no] and" ).append("\n"); 
		query.append("        B.BKG_NO		= BK.BKG_NO and" ).append("\n"); 
		query.append("        B.BKG_NO		= OL.BKG_NO(+) and" ).append("\n"); 
		query.append("        B.BKG_NO		= F.BKG_NO and" ).append("\n"); 
		query.append("        B.BKG_NO     	= I.BKG_NO(+) AND" ).append("\n"); 
		query.append("        B.BKG_NO    	= R1.BKG_NO(+) AND" ).append("\n"); 
		query.append("        B.BKG_NO     	= R2.BKG_NO(+) AND" ).append("\n"); 
		query.append("        B.BKG_NO     	= RATE.BKG_NO AND" ).append("\n"); 
		query.append("        B.BKG_NO     	= ISS.BKG_NO(+) AND" ).append("\n"); 
		query.append("        B.BKG_NO     	= P.BKG_NO AND" ).append("\n"); 
		query.append("        B.BKG_NO     	= X.BKG_NO(+) AND" ).append("\n"); 
		query.append("        C.loc_cd(+) 	= decode(@[form_term_pol] ,null,B.POL_CD,B.POD_CD) and" ).append("\n"); 
		query.append("        BK.POL_CD 		= C1.loc_cd(+) and" ).append("\n"); 
		query.append("        BK.POD_CD 		= C2.loc_cd(+) and" ).append("\n"); 
		query.append("        BK.POR_CD 		= C3.loc_cd(+) and" ).append("\n"); 
		query.append("        BK.DEL_CD 		= C4.loc_cd(+) and" ).append("\n"); 
		query.append("        DECODE(@[form_term_pol],null,NVL(BK.PST_RLY_PORT_CD,' '),NVL(BK.PRE_RLY_PORT_CD,' ')) = C5.loc_cd(+) and" ).append("\n"); 
		query.append("		BK.POD_CD		= L1.LOC_CD(+) AND" ).append("\n"); 
		query.append("		BK.DEL_CD		= L2.LOC_CD(+) AND" ).append("\n"); 
		query.append("        B.BKG_NO                 	= CUST_C.BKG_NO(+) AND" ).append("\n"); 
		query.append("        CUST_C.BKG_CUST_TP_CD(+) 	= 'C' AND" ).append("\n"); 
		query.append("        B.BKG_NO                 	= CUST_S.BKG_NO(+) AND" ).append("\n"); 
		query.append("        CUST_S.BKG_CUST_TP_CD(+) 	= 'S' AND" ).append("\n"); 
		query.append("        B.BKG_NO                 	= CUST_N.BKG_NO(+) AND" ).append("\n"); 
		query.append("        CUST_N.BKG_CUST_TP_CD(+) 	= 'N' AND" ).append("\n"); 
		query.append("        B.BKG_NO                 	= CUST_A.BKG_NO(+) AND" ).append("\n"); 
		query.append("        CUST_A.BKG_CUST_TP_CD(+) 	= 'A' AND" ).append("\n"); 
		query.append("        B.BKG_NO 					= CUST_F.BKG_NO(+) AND" ).append("\n"); 
		query.append("        CUST_F.BKG_CUST_TP_CD(+) 	= 'F' AND" ).append("\n"); 
		query.append("        B.BKG_NO 					= CUST_E.BKG_NO(+) AND" ).append("\n"); 
		query.append("        CUST_E.BKG_CUST_TP_CD(+) 	= 'E' AND" ).append("\n"); 
		query.append("        NVL(BK.OB_SREP_CD,'X')		= SREP.srep_cd(+) and" ).append("\n"); 
		query.append("        I.OBL_ISS_OFC_CD            = E.ofc_cd(+) and" ).append("\n"); 
		query.append("        BK.CMDT_CD            		= COM.CMDT_CD(+) and" ).append("\n"); 
		query.append("		BK.REP_CMDT_CD              = REP.REP_CMDT_CD(+) AND" ).append("\n"); 
		query.append("        R1.BKG_REF_TP_CD(+) 		= 'EBRF' AND" ).append("\n"); 
		query.append("        R2.BKG_REF_TP_CD(+) 		= 'PSAN' AND" ).append("\n"); 
		query.append("        P.BKG_CNTC_PSON_TP_CD 		= 'BK' AND" ).append("\n"); 
		query.append("        ROWNUM = 1" ).append("\n"); 

	}
}