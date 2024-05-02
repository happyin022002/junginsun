/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : CLLCDLManifestDBDAOsearchCdlCustRSQL.java
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

public class CLLCDLManifestDBDAOsearchCdlCustRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchCdlCust
	  * </pre>
	  */
	public CLLCDLManifestDBDAOsearchCdlCustRSQL(){
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
		params.put("in_local_ipi",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("in_area_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inv_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("custref_num",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trans_mnode",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("in_pol_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.terminaldocumentation.cllcdlmanifest.integration").append("\n"); 
		query.append("FileName : CLLCDLManifestDBDAOsearchCdlCustRSQL").append("\n"); 
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
		query.append("SELECT	'NTFYCN:'||NVL(BCN.CUST_CNT_CD,'')||CHR(10)||" ).append("\n"); 
		query.append("	'NTFYCD:'||NVL(TO_CHAR(BCN.CUST_SEQ),'')||CHR(10)||" ).append("\n"); 
		query.append("	'NTFY1:'||REPLACE(SCE_TOKEN_NL_FNC(BCN.CUST_NM,1),'*','-')||CHR(10)||" ).append("\n"); 
		query.append("	'NTFY2:'||REPLACE(SCE_TOKEN_NL_FNC(BCN.CUST_NM,2),'*','-')||CHR(10)||" ).append("\n"); 
		query.append("	'NTFY3:'||REPLACE(SCE_TOKEN_NL_FNC(BCN.CUST_ADDR,1),'*','-')||CHR(10)||" ).append("\n"); 
		query.append("	'NTFY4:'||REPLACE(SCE_TOKEN_NL_FNC(BCN.CUST_ADDR,2),'*','-')||CHR(10)||" ).append("\n"); 
		query.append("	'NTFY5:'||REPLACE(SCE_TOKEN_NL_FNC(BCN.CUST_ADDR,3),'*','-')||CHR(10)||" ).append("\n"); 
		query.append("	'NTFYTAXID:'||CHR(10)||" ).append("\n"); 
		query.append("	'NTFY2CN:'||NVL(BCA.CUST_CNT_CD,'')||CHR(10)||" ).append("\n"); 
		query.append("	'NTFY2CD:'||NVL(TO_CHAR(BCA.CUST_SEQ),'')||CHR(10)||" ).append("\n"); 
		query.append("	'NTFY21:'||REPLACE(SCE_TOKEN_NL_FNC(BCA.CUST_NM,1),'*','-')||CHR(10)||" ).append("\n"); 
		query.append("	'NTFY22:'||REPLACE(SCE_TOKEN_NL_FNC(BCA.CUST_NM,2),'*','-')||CHR(10)||" ).append("\n"); 
		query.append("	'NTFY23:'||REPLACE(SCE_TOKEN_NL_FNC(BCA.CUST_NM,3),'*','-')||CHR(10)||" ).append("\n"); 
		query.append("	'NTFY24:'||REPLACE(SCE_TOKEN_NL_FNC(BCA.CUST_NM,4),'*','-')||CHR(10)||" ).append("\n"); 
		query.append("	'NTFY25:'||REPLACE(SCE_TOKEN_NL_FNC(BCA.CUST_NM,5),'*','-')||CHR(10)||" ).append("\n"); 
		query.append("	'FFWDCN:'||NVL(BCF.CUST_CNT_CD,'')||CHR(10)||" ).append("\n"); 
		query.append("	'FFWDCD:'||NVL(TO_CHAR(BCF.CUST_SEQ),'')||CHR(10)||" ).append("\n"); 
		query.append("	'FFWD1:'||REPLACE(SCE_TOKEN_NL_FNC(BCF.CUST_NM,1),'*','-')||CHR(10)||" ).append("\n"); 
		query.append("	'FFWD2:'||REPLACE(SCE_TOKEN_NL_FNC(BCF.CUST_NM,2),'*','-')||CHR(10)||" ).append("\n"); 
		query.append("	'FFWD3:'||REPLACE(SCE_TOKEN_NL_FNC(BCF.CUST_NM,3),'*','-')||CHR(10)||" ).append("\n"); 
		query.append("	'FFWD4:'||REPLACE(SCE_TOKEN_NL_FNC(BCF.CUST_NM,4),'*','-')||CHR(10)||" ).append("\n"); 
		query.append("	'FFWD5:'||REPLACE(SCE_TOKEN_NL_FNC(BCF.CUST_NM,5),'*','-')||CHR(10)||" ).append("\n"); 
		query.append("	'EXPOCN:'||NVL(BCE.CUST_CNT_CD,'')||CHR(10)||" ).append("\n"); 
		query.append("	'EXPOCD:'||NVL(TO_CHAR(BCE.CUST_SEQ),'')||CHR(10)||" ).append("\n"); 
		query.append("	'EXPO1:'||REPLACE(SCE_TOKEN_NL_FNC(BCE.CUST_NM,1),'*','-')||CHR(10)||" ).append("\n"); 
		query.append("	'EXPO2:'||REPLACE(SCE_TOKEN_NL_FNC(BCE.CUST_NM,2),'*','-')||CHR(10)||" ).append("\n"); 
		query.append("	'EXPO3:'||REPLACE(SCE_TOKEN_NL_FNC(BCE.CUST_NM,3),'*','-')||CHR(10)||" ).append("\n"); 
		query.append("	'EXPO4:'||REPLACE(SCE_TOKEN_NL_FNC(BCE.CUST_NM,4),'*','-')||CHR(10)||" ).append("\n"); 
		query.append("	'EXPO5:'||REPLACE(SCE_TOKEN_NL_FNC(BCE.CUST_NM,5),'*','-')||CHR(10)||" ).append("\n"); 
		query.append("	'BLCOPY:'||NVL(BL.BL_CPY_KNT,0)||CHR(10)||" ).append("\n"); 
		query.append("	'BLORG:1'||CHR(10)||" ).append("\n"); 
		query.append("	'BLPKG:'||NVL(DOC.PCK_QTY,0)||CHR(10)||" ).append("\n"); 
		query.append("	'BLPKGU:'||NVL(DOC.PCK_TP_CD,' ')||CHR(10)||" ).append("\n"); 
		query.append("	'BLWGT:'||NVL(DOC.ACT_WGT,0)||CHR(10)||" ).append("\n"); 
		query.append("	'BL_WGT_UNIT:'||NVL(DOC.WGT_UT_CD,' ')||CHR(10)||" ).append("\n"); 
		query.append("	'BLMEA:'||NVL(DOC.MEAS_QTY,0)||CHR(10)||" ).append("\n"); 
		query.append("	'BL_MEA_UNIT:'||NVL(DOC.MEAS_UT_CD,' ')||CHR(10)||" ).append("\n"); 
		query.append("	'RDTYPE:'||NVL(BK.RCV_TERM_CD,' ')||NVL(BK.DE_TERM_CD,' ')||CHR(10)||" ).append("\n"); 
		query.append("	'CARGOTYPE:'||NVL(BK.BKG_CGO_TP_CD,' ')||CHR(10)||" ).append("\n"); 
		query.append("	'COMMODITY:'||NVL(BK.CMDT_CD,' ')||CHR(10)||" ).append("\n"); 
		query.append("	'BLCMD:'||NVL(@[cmdt_nm],' ')||CHR(10)||" ).append("\n"); 
		query.append("	'BLREPCMDCD:'||NVL(BK.REP_CMDT_CD,' ')||CHR(10)||" ).append("\n"); 
		query.append("	'BLREPCMD:'||NVL(@[rep_cmdt_nm],' ')||CHR(10)||" ).append("\n"); 
		query.append("	'REMARK:'||REPLACE(REPLACE(REPLACE(Translate(NVL(BK.XTER_RMK,' '),chr(10),' '),'$','S'),'#',' '),'*','-')||CHR(10)||" ).append("\n"); 
		query.append("	'AUS_QUAR:'||' '||CHR(10)||" ).append("\n"); 
		query.append("	'SRNBR:'||CHR(10)||" ).append("\n"); 
		query.append("	'BKGNBR:'||NVL(BK.BKG_NO,' ')||CHR(10)||" ).append("\n"); 
		query.append("	'RGN_BKGNBR:'||NVL(REF.CUST_REF_NO_CTNT,' ')||CHR(10)||" ).append("\n"); 
		query.append("	'PPDOFC:'||NVL(F.PPD_RCV_OFC_CD,' ')||CHR(10)||" ).append("\n"); 
		query.append("	'CCTOFC:'||NVL(F.CLT_OFC_CD,' ')||CHR(10)||" ).append("\n"); 
		query.append("	'THDOFC:'||@[in_area_id]||CHR(10)||" ).append("\n"); 
		query.append("	'SCNO:'||NVL(BK.SC_NO,' ')||CHR(10)||" ).append("\n"); 
		query.append("	'RFANO:'||NVL(BK.RFA_NO,' ')||CHR(10)||" ).append("\n"); 
		query.append("	'WAYBILL_IND:'||CHR(10)||" ).append("\n"); 
		query.append("	'CUSTREF_NUM:'||@[custref_num]||CHR(10)||" ).append("\n"); 
		query.append("	'FINAL_ETA:'||CHR(10)||" ).append("\n"); 
		query.append("	'FUNC_CODE:'||CHR(10)||" ).append("\n"); 
		query.append("	'ONBOARD:'||CHR(10)||" ).append("\n"); 
		query.append("	'INV_NO:'||NVL(@[inv_no],'')||CHR(10)||" ).append("\n"); 
		query.append("	'BLTS:'||CHR(10)||" ).append("\n"); 
		query.append("	'BLTP:'||CHR(10)||" ).append("\n"); 
		query.append("	'MSN:'||CHR(10)||" ).append("\n"); 
		query.append("	'MSNCFM:'||CHR(10)||" ).append("\n"); 
		query.append("	'CMDESC:'||CHR(10)||" ).append("\n"); 
		query.append("	'LOCAL_IPI:'||NVL(@[in_local_ipi],' ')||CHR(10)||" ).append("\n"); 
		query.append("	'EQREL:'||BK.MTY_PKUP_YD_CD|| CHR(10)||" ).append("\n"); 
		query.append("	'EQPICKDT:'||TO_CHAR(BK.MTY_PKUP_DT,'RRRRMMDDHH24MI')|| CHR(10)||" ).append("\n"); 
		query.append("	'EQRTN:'||BK.FULL_RTN_YD_CD|| CHR(10)||" ).append("\n"); 
		query.append("	'TRANS_MODE:'||NVL(@[trans_mnode],' ')|| CHR(10)||" ).append("\n"); 
		query.append("	'UD_CD:'||NVL(BK.STWG_CD,' ')||CHR(10) CUST_INFO" ).append("\n"); 
		query.append("FROM	BKG_BOOKING BK," ).append("\n"); 
		query.append("	BKG_BL_DOC DOC," ).append("\n"); 
		query.append("	BKG_BL_ISS BL," ).append("\n"); 
		query.append("	BKG_REFERENCE REF," ).append("\n"); 
		query.append("	BKG_RATE F," ).append("\n"); 
		query.append("	BKG_CUSTOMER BCN," ).append("\n"); 
		query.append("	BKG_CUSTOMER BCA," ).append("\n"); 
		query.append("	BKG_CUSTOMER BCF," ).append("\n"); 
		query.append("	BKG_CUSTOMER BCE," ).append("\n"); 
		query.append("	MDM_LOCATION C1," ).append("\n"); 
		query.append("	MDM_LOCATION C2," ).append("\n"); 
		query.append("	MDM_LOCATION C3," ).append("\n"); 
		query.append("	MDM_LOCATION C4," ).append("\n"); 
		query.append("	MDM_LOCATION C5," ).append("\n"); 
		query.append("	MDM_COMMODITY COM" ).append("\n"); 
		query.append("WHERE	BK.BKG_NO	= @[bkg_no]" ).append("\n"); 
		query.append("AND	BK.BKG_NO		= BL.BKG_NO (+)" ).append("\n"); 
		query.append("AND	BK.BKG_NO		= REF.BKG_NO (+)" ).append("\n"); 
		query.append("AND	REF.BKG_REF_TP_CD(+)	= 'PSAN'" ).append("\n"); 
		query.append("AND	BK.BKG_NO		= DOC.BKG_NO" ).append("\n"); 
		query.append("AND	BK.BKG_NO		= F.BKG_NO (+)" ).append("\n"); 
		query.append("AND	BK.POL_CD		= C1.LOC_CD(+)" ).append("\n"); 
		query.append("AND	BK.POD_CD		= C2.LOC_CD(+)" ).append("\n"); 
		query.append("AND	BK.POR_CD		= C3.LOC_CD(+)" ).append("\n"); 
		query.append("AND	BK.DEL_CD		= C4.LOC_CD(+)" ).append("\n"); 
		query.append("AND	DECODE(@[in_pol_cd],NULL,NVL(BK.PST_RLY_PORT_CD,' '),NVL(BK.PRE_RLY_PORT_CD,' ')) = C5.LOC_CD(+)" ).append("\n"); 
		query.append("AND	BK.CMDT_CD		= COM.CMDT_CD(+)" ).append("\n"); 
		query.append("AND	BK.BKG_NO		= BCN.BKG_NO" ).append("\n"); 
		query.append("AND	BCN.BKG_CUST_TP_CD	= 'N'" ).append("\n"); 
		query.append("AND	BK.BKG_NO		= BCA.BKG_NO" ).append("\n"); 
		query.append("AND	BCA.BKG_CUST_TP_CD	= 'A'" ).append("\n"); 
		query.append("AND	BK.BKG_NO		= BCF.BKG_NO" ).append("\n"); 
		query.append("AND	BCF.BKG_CUST_TP_CD	= 'F'" ).append("\n"); 
		query.append("AND	BK.BKG_NO		= BCE.BKG_NO" ).append("\n"); 
		query.append("AND	BCE.BKG_CUST_TP_CD	= 'E'" ).append("\n"); 

	}
}