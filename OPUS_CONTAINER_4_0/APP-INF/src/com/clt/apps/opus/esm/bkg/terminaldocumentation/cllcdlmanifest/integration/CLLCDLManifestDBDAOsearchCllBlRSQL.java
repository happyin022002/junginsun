/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : CLLCDLManifestDBDAOsearchCllBlRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.10.20
*@LastModifier : 
*@LastVersion : 1.0
* 2016.10.20 
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

public class CLLCDLManifestDBDAOsearchCllBlRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchCllBl
	  * </pre>
	  */
	public CLLCDLManifestDBDAOsearchCllBlRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("in_loc_nm",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("in_vvd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("in_dest_svr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("in_pol_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.terminaldocumentation.cllcdlmanifest.integration").append("\n"); 
		query.append("FileName : CLLCDLManifestDBDAOsearchCllBlRSQL").append("\n"); 
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
		query.append("SELECT '{BL_INFO'||chr(10)||" ).append("\n"); 
		query.append("	'BLNBR:'||NVL(M.BL_NO,' ')||CHR(10)||" ).append("\n"); 
		query.append("	'BLPOL:'||NVL(M.POL_CD,' ')||CHR(10)||" ).append("\n"); 
		query.append("	'POL_AMS:'||C1.LOC_AMS_PORT_CD||CHR(10)||" ).append("\n"); 
		query.append("	'POL_FULLNAME:'||C1.LOC_NM||CHR(10)||" ).append("\n"); 
		query.append("	'BLPOD:'||NVL(M.POD_CD,' ')||CHR(10)||" ).append("\n"); 
		query.append("	'POD_AMS:'||C2.LOC_AMS_PORT_CD||CHR(10)||" ).append("\n"); 
		query.append("	'POD_FULLNAME:'||C2.LOC_NM||CHR(10)||" ).append("\n"); 
		query.append("	'BLCK_STWG_CD:'||BK.BLCK_STWG_CD||CHR(10)||" ).append("\n"); 
		query.append("	'BLPOR:'||NVL(M.POR_CD,' ')||CHR(10)||" ).append("\n"); 
		query.append("	'POR_AMS:'||C3.LOC_AMS_PORT_CD||CHR(10)||" ).append("\n"); 
		query.append("	'POR_FULLNAME:'||C3.LOC_NM||CHR(10)||" ).append("\n"); 
		query.append("	'BLDEL:'||NVL(M.DEL_CD,' ')||CHR(10)||" ).append("\n"); 
		query.append("	'DEL_AMS:'||C4.LOC_AMS_PORT_CD||CHR(10)||" ).append("\n"); 
		query.append("	'DEL_FULLNAME:'||C4.LOC_NM||CHR(10)||" ).append("\n"); 
		query.append("	'BLRLY:'||DECODE(@[in_pol_cd]," ).append("\n"); 
		query.append("					 NULL, NVL(BK.PST_RLY_PORT_CD,' ')," ).append("\n"); 
		query.append("					 NVL(BK.PRE_RLY_PORT_CD,' '))||CHR(10)||" ).append("\n"); 
		query.append("	'RLY_AMS:'||C5.LOC_AMS_PORT_CD||CHR(10)||" ).append("\n"); 
		query.append("	'RLY_FULLNAME:'||C5.LOC_NM||CHR(10)||" ).append("\n"); 
		query.append("	'UCR_NO:'||CHR(10)||" ).append("\n"); 
		query.append("	'UCR_CODE:'||CHR(10)||" ).append("\n"); 
		query.append("	'BLPLACE:'||CHR(10)||" ).append("\n"); 
		query.append("	'BLDATE:'||CHR(10)||" ).append("\n"); 
		query.append("	'SHPRCN:'||NVL(M.SHPR_CNT_CD,'')||CHR(10)||" ).append("\n"); 
		query.append("	'SHPRCD:'||DECODE(TO_CHAR(M.SHPR_SEQ),'0','',TO_CHAR(M.SHPR_SEQ))||CHR(10)||" ).append("\n"); 
		query.append("	'SHPR1:'||NVL(M.SHPR_NM1,' ')||CHR(10)||" ).append("\n"); 
		query.append("	'SHPR2:'||NVL(M.SHPR_NM2,' ')||CHR(10)||" ).append("\n"); 
		query.append("	'SHPR3:'||NVL(M.SHPR_NM3,' ')||CHR(10)||" ).append("\n"); 
		query.append("	'SHPR4:'||NVL(M.SHPR_NM4,' ')||CHR(10)||" ).append("\n"); 
		query.append("	'SHPR5:'||NVL(M.SHPR_NM5,' ')||CHR(10)||" ).append("\n"); 
		query.append("	'SHPRTAXID:'||CHR(10)||" ).append("\n"); 
		query.append("	'CNEECN:'||NVL(M.CNEE_CNT_CD,'')||CHR(10)||" ).append("\n"); 
		query.append("	'CNEECD:'||DECODE(TO_CHAR(M.CNEE_SEQ),'0','',TO_CHAR(M.CNEE_SEQ))||CHR(10)||" ).append("\n"); 
		query.append("	'CNEE1:'||NVL(M.CNEE_NM1,' ')||CHR(10)||" ).append("\n"); 
		query.append("	'CNEE2:'||NVL(M.CNEE_NM2,' ')||CHR(10)||" ).append("\n"); 
		query.append("	'CNEE3:'||NVL(M.CNEE_NM3,' ')||CHR(10)||" ).append("\n"); 
		query.append("	'CNEE4:'||NVL(M.CNEE_NM4,' ')||CHR(10)||" ).append("\n"); 
		query.append("	'CNEE5:'||NVL(M.CNEE_NM5,' ')||CHR(10)||" ).append("\n"); 
		query.append("	'CNEETAXID:'||CHR(10)||" ).append("\n"); 
		query.append("	'NTFYCN:'||NVL(M.NTFY_CNT_CD,'')||CHR(10)||" ).append("\n"); 
		query.append("	'NTFYCD:'||DECODE(TO_CHAR(M.NTFY_SEQ),'0','',TO_CHAR(M.NTFY_SEQ))||CHR(10)||" ).append("\n"); 
		query.append("	'NTFY1:'||NVL(M.NTFY_NM1,' ')||CHR(10)||" ).append("\n"); 
		query.append("	'NTFY2:'||NVL(M.NTFY_NM2,' ')||CHR(10)||" ).append("\n"); 
		query.append("	'NTFY3:'||NVL(M.NTFY_NM3,' ')||CHR(10)||" ).append("\n"); 
		query.append("	'NTFY4:'||NVL(M.NTFY_NM4,' ')||CHR(10)||" ).append("\n"); 
		query.append("	'NTFY5:'||NVL(M.NTFY_NM5,' ')||CHR(10)||" ).append("\n"); 
		query.append("	'NTFYTAXID:'||CHR(10)||" ).append("\n"); 
		query.append("	'NTFY2CN:'||NVL(M.ANTFY_CNT_CD,'')||CHR(10)||" ).append("\n"); 
		query.append("	'NTFY2CD:'||DECODE(TO_CHAR(M.ANTFY_SEQ),'0','',TO_CHAR(M.ANTFY_SEQ))||CHR(10)||" ).append("\n"); 
		query.append("	'NTFY21:'||NVL(M.ANTFY_NM1,' ')||CHR(10)||" ).append("\n"); 
		query.append("	'NTFY22:'||NVL(M.ANTFY_NM2,' ')||CHR(10)||" ).append("\n"); 
		query.append("	'NTFY23:'||NVL(M.ANTFY_NM3,' ')||CHR(10)||" ).append("\n"); 
		query.append("	'NTFY24:'||NVL(M.ANTFY_NM4,' ')||CHR(10)||" ).append("\n"); 
		query.append("	'NTFY25:'||NVL(M.ANTFY_NM5,' ')||CHR(10)||" ).append("\n"); 
		query.append("	'FFWDCN:'||NVL(M.FF_CNT_CD,'')||CHR(10)||" ).append("\n"); 
		query.append("	'FFWDCD:'||DECODE(TO_CHAR(M.FF_CUST_SEQ),'0','',TO_CHAR(M.FF_CUST_SEQ))||CHR(10)||" ).append("\n"); 
		query.append("	'FFWD1:'||NVL(M.FF_NM1,' ')||CHR(10)||" ).append("\n"); 
		query.append("	'FFWD2:'||NVL(M.FF_NM2,' ')||CHR(10)||" ).append("\n"); 
		query.append("	'FFWD3:'||NVL(M.FF_NM3,' ')||CHR(10)||" ).append("\n"); 
		query.append("	'FFWD4:'||NVL(M.FF_NM4,' ')||CHR(10)||" ).append("\n"); 
		query.append("	'FFWD5:'||NVL(M.FF_NM5,' ')||CHR(10)||" ).append("\n"); 
		query.append("	'EXPOCN:'||CHR(10)||" ).append("\n"); 
		query.append("	'EXPOCD:'||CHR(10)||" ).append("\n"); 
		query.append("	'EXPO1:'||CHR(10)||" ).append("\n"); 
		query.append("	'EXPO2:'||CHR(10)||" ).append("\n"); 
		query.append("	'EXPO3:'||CHR(10)||" ).append("\n"); 
		query.append("	'EXPO4:'||CHR(10)||" ).append("\n"); 
		query.append("	'EXPO5:'||CHR(10)||" ).append("\n"); 
		query.append("	'BLCOPY:3'||CHR(10)||" ).append("\n"); 
		query.append("	'BLORG:1'||CHR(10)||" ).append("\n"); 
		query.append("	'BLPKG:'||NVL(DOC.PCK_QTY,0)||CHR(10)||" ).append("\n"); 
		query.append("	'BLPKGU:'||NVL(DOC.PCK_TP_CD,' ')||CHR(10)||" ).append("\n"); 
		query.append("	'BLWGT:'||NVL(DOC.ACT_WGT,0)||CHR(10)||" ).append("\n"); 
		query.append("	'BL_WGT_UNIT:'||NVL(DOC.WGT_UT_CD,' ')||CHR(10)||" ).append("\n"); 
		query.append("	'BLMEA:'||NVL(DOC.MEAS_QTY,0)||CHR(10)||" ).append("\n"); 
		query.append("	'BL_MEA_UNIT:'||NVL(DOC.MEAS_UT_CD,' ')||CHR(10)||" ).append("\n"); 
		query.append("	'RDTYPE:'||NVL(M.RCV_TERM_CD,' ')||NVL(M.DE_TERM_CD,' ')||CHR(10)||" ).append("\n"); 
		query.append("	'CARGOTYPE:'||NVL(BK.BKG_CGO_TP_CD,' ')||CHR(10)||" ).append("\n"); 
		query.append("	'COMMODITY:'||NVL(M.CMDT_CD,' ')||CHR(10)||" ).append("\n"); 
		query.append("	'BLCMD:'||NVL(M.CMDT_DESC,' ')||CHR(10)||" ).append("\n"); 
		query.append("	'BLREPCMDCD:'||NVL(M.REP_CMDT_CD,' ')||CHR(10)||" ).append("\n"); 
		query.append("	'BLREPCMD:'||TRANSLATE(NVL(M.REP_CMDT_DESC,' '),CHR(10),' ')||CHR(10)||" ).append("\n"); 
		query.append("	TO_CLOB('REMARK:'||REPLACE(REPLACE(Translate(NVL(BK.XTER_RMK,' '),chr(10),' ')," ).append("\n"); 
		query.append("							   '$','S')," ).append("\n"); 
		query.append("					   '#',' '))||CHR(10)||" ).append("\n"); 
		query.append("	'AUS_QUAR:'||' '||CHR(10)||" ).append("\n"); 
		query.append("	'SRNBR:'||CHR(10)||" ).append("\n"); 
		query.append("	'BKGNBR:'||NVL(M.bkg_no,' ')||CHR(10)||" ).append("\n"); 
		query.append("	'BKG_DT:'||NVL(TO_CHAR(BK.BKG_CRE_DT,'RRRRMMDDHH24MI'),' ')|| CHR(10)||" ).append("\n"); 
		query.append("	'RGN_BKGNBR:'||NVL(REF.CUST_REF_NO_CTNT,' ')||CHR(10)||" ).append("\n"); 
		query.append("	'PPDOFC:'||CHR(10)||" ).append("\n"); 
		query.append("	'CCTOFC:'||CHR(10)||" ).append("\n"); 
		query.append("	'THDOFC:'||CHR(10)||" ).append("\n"); 
		query.append("	'SCNO:'||CHR(10)||" ).append("\n"); 
		query.append("	'RFANO:'||CHR(10)||" ).append("\n"); 
		query.append("	'WAYBILL_IND:'||DECODE(M.BL_TP_CD,'W','Y','N')||CHR(10)||" ).append("\n"); 
		query.append("	'CUSTREF_NUM:'||CHR(10)||" ).append("\n"); 
		query.append("	'FINAL_ETA:'||CHR(10)||" ).append("\n"); 
		query.append("	'FUNC_CODE:'||CHR(10)||" ).append("\n"); 
		query.append("	'ONBOARD:'||CHR(10)||" ).append("\n"); 
		query.append("	'INBOND_TP:'||NVL((SELECT IBD_TRSP_TP_CD" ).append("\n"); 
		query.append("                      FROM BKG_CSTMS_ADV_IBD IBD" ).append("\n"); 
		query.append("                     WHERE IBD.BL_NO = M.BL_NO" ).append("\n"); 
		query.append("                       AND ROWNUM = 1" ).append("\n"); 
		query.append("                   ),' ')||CHR(10)||" ).append("\n"); 
		query.append("	'INBOND_NO:'||CHR(10)||" ).append("\n"); 
		query.append("	'BLTS:'||CHR(10)||" ).append("\n"); 
		query.append("	'BLTP:'||CHR(10)||" ).append("\n"); 
		query.append("	'MSN:'||CHR(10)||" ).append("\n"); 
		query.append("	'MSNCFM:'||CHR(10)||" ).append("\n"); 
		query.append("	'CMDESC:'||CHR(10)||" ).append("\n"); 
		query.append("	'LOCAL_IPI:'||DECODE(@[in_dest_svr_cd]," ).append("\n"); 
		query.append("						 'EUR',TS_CGO_CD," ).append("\n"); 
		query.append("						 'DEU',TS_CGO_CD," ).append("\n"); 
		query.append("						 'SWA',TS_CGO_CD," ).append("\n"); 
		query.append("						 'DSW',TS_CGO_CD," ).append("\n"); 
		query.append("						 NVL(@[in_loc_nm],' '))||CHR(10)||" ).append("\n"); 
		query.append("	'EQREL:'||BK.MTY_PKUP_YD_CD|| CHR(10)||" ).append("\n"); 
		query.append("	'EQPICKDT:'||TO_CHAR(BK.MTY_PKUP_DT,'RRRRMMDDHH24MI')|| CHR(10)||" ).append("\n"); 
		query.append("	'EQRTN:'||BK.FULL_RTN_YD_CD|| CHR(10)||" ).append("\n"); 
		query.append("	'TRANS_MODE:'||CHR(10)||" ).append("\n"); 
		query.append("	'UD_CD:'||NVL(BK.STWG_CD,' ')||CHR(10)||" ).append("\n"); 
		query.append("    'LOC_GOODS:'||(SELECT SUBSTR(IBD_LOC_GDS_DESC,1,9) FROM BKG_CSTMS_ADV_BL CN_LOC WHERE CN_LOC.CNT_CD = 'CA' AND CN_LOC.BKG_NO = BK.BKG_NO AND CN_LOC.BL_NO = BK.BL_NO)||CHR(10) BL_INFO," ).append("\n"); 
		query.append("	NVL(BK.BKG_NO,' ') BKG_NO," ).append("\n"); 
		query.append("	NVL(BK.BKG_CGO_TP_CD,' ') BKG_CGO_TP_CD," ).append("\n"); 
		query.append("	NVL(BK.DCGO_FLG,' ') DCGO_FLG," ).append("\n"); 
		query.append("	NVL(BK.RC_FLG,' ') RC_FLG," ).append("\n"); 
		query.append("	NVL(BK.AWK_CGO_FLG,' ') AWK_CGO_FLG," ).append("\n"); 
		query.append("	NVL(BK.BB_CGO_FLG,' ') BB_CGO_FLG," ).append("\n"); 
		query.append("	NVL(BK.RD_CGO_FLG,' ') RD_CGO_FLG," ).append("\n"); 
		query.append("	NVL(M.CMDT_CD,' ') CMDT_CD," ).append("\n"); 
		query.append("	Translate(NVL(M.CMDT_DESC,' '),CHR(10),' ') CMDT_DESC" ).append("\n"); 
		query.append("FROM	BKG_BOOKING BK," ).append("\n"); 
		query.append("	BKG_BL_DOC DOC," ).append("\n"); 
		query.append("	BKG_REFERENCE REF," ).append("\n"); 
		query.append("	BKG_CSTMS_TML_CLL M," ).append("\n"); 
		query.append("	MDM_LOCATION C1," ).append("\n"); 
		query.append("	MDM_LOCATION C2," ).append("\n"); 
		query.append("	MDM_LOCATION C3," ).append("\n"); 
		query.append("	MDM_LOCATION C4," ).append("\n"); 
		query.append("	MDM_LOCATION C5," ).append("\n"); 
		query.append("	MDM_COMMODITY COM" ).append("\n"); 
		query.append("WHERE	M.VSL_CD		= SUBSTR(@[in_vvd_cd],1,4)" ).append("\n"); 
		query.append("AND	M.SKD_VOY_NO		= SUBSTR(@[in_vvd_cd],5,4)" ).append("\n"); 
		query.append("AND	M.SKD_DIR_CD		= SUBSTR(@[in_vvd_cd],9,1)" ).append("\n"); 
		query.append("AND	M.PORT_CD		= @[in_pol_cd]" ).append("\n"); 
		query.append("AND	M.BKG_NO		= @[bkg_no]" ).append("\n"); 
		query.append("AND	M.CNTR_NO		= @[cntr_no]" ).append("\n"); 
		query.append("AND	M.BKG_NO		= BK.BKG_NO" ).append("\n"); 
		query.append("AND	M.BKG_NO		= DOC.BKG_NO(+)" ).append("\n"); 
		query.append("AND	M.BKG_NO		= REF.BKG_NO(+)" ).append("\n"); 
		query.append("AND	REF.BKG_REF_TP_CD(+)	= 'PSAN'" ).append("\n"); 
		query.append("AND	BK.POL_CD		= C1.LOC_CD(+)" ).append("\n"); 
		query.append("AND	BK.POD_CD		= C2.LOC_CD(+)" ).append("\n"); 
		query.append("AND	BK.POR_CD		= C3.LOC_CD(+)" ).append("\n"); 
		query.append("AND	BK.DEL_CD		= C4.LOC_CD(+)" ).append("\n"); 
		query.append("AND	DECODE(@[in_pol_cd]," ).append("\n"); 
		query.append("		   NULL, NVL(BK.PST_RLY_PORT_CD,' ')," ).append("\n"); 
		query.append("		   NVL(BK.PRE_RLY_PORT_CD,' ')) = C5.LOC_CD(+)" ).append("\n"); 
		query.append("AND	BK.CMDT_CD		= COM.CMDT_CD(+)" ).append("\n"); 
		query.append("AND M.CRE_USR_ID = @[cre_usr_id]" ).append("\n"); 
		query.append("AND	ROWNUM = 1" ).append("\n"); 

	}
}