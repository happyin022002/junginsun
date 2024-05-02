/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : CLLCDLManifestDBDAOsearchCdlBlRSQL.java
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

public class CLLCDLManifestDBDAOsearchCdlBlRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchCdlBl
	  * </pre>
	  */
	public CLLCDLManifestDBDAOsearchCdlBlRSQL(){
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
		params.put("in_pol_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.terminaldocumentation.cllcdlmanifest.integration").append("\n"); 
		query.append("FileName : CLLCDLManifestDBDAOsearchCdlBlRSQL").append("\n"); 
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
		query.append("SELECT	'{BL_INFO'||chr(10)||" ).append("\n"); 
		query.append("	'BLNBR:'||NVL(B.BL_NO,' ')||NVL(B.BL_TP_CD,' ')||CHR(10)||" ).append("\n"); 
		query.append("	'BLPOL:'||NVL(B.POL_CD,' ')||CHR(10)||" ).append("\n"); 
		query.append("	'POL_AMS:'||C1.LOC_AMS_PORT_CD||CHR(10)||" ).append("\n"); 
		query.append("	'POL_FULLNAME:'||C1.LOC_NM||CHR(10)||" ).append("\n"); 
		query.append("	'BLPOD:'||NVL(B.POD_CD,' ')||CHR(10)||" ).append("\n"); 
		query.append("	'POD_AMS:'||C2.LOC_AMS_PORT_CD||CHR(10)||" ).append("\n"); 
		query.append("	'POD_FULLNAME:'||C2.LOC_NM||CHR(10)||" ).append("\n"); 
		query.append("	'BLPOR:'||NVL(B.POR_CD,' ')||CHR(10)||" ).append("\n"); 
		query.append("	'POR_AMS:'||C3.LOC_AMS_PORT_CD||CHR(10)||" ).append("\n"); 
		query.append("	'POR_FULLNAME:'||C3.LOC_NM||CHR(10)||" ).append("\n"); 
		query.append("	'BLDEL:'||NVL(B.DEL_CD,' ')||CHR(10)||" ).append("\n"); 
		query.append("	'DEL_AMS:'||C4.LOC_AMS_PORT_CD||CHR(10)||" ).append("\n"); 
		query.append("	'DEL_FULLNAME:'||C4.LOC_NM||CHR(10)||" ).append("\n"); 
		query.append("	'BLRLY:'||decode(@[in_pol_cd],NULL,NVL(B.PST_RLY_PORT_CD,' '),NVL(B.PRE_RLY_PORT_CD,' '))||CHR(10)||" ).append("\n"); 
		query.append("	'RLY_AMS:'||C5.LOC_AMS_PORT_CD||CHR(10)||" ).append("\n"); 
		query.append("	'RLY_FULLNAME:'||C5.LOC_NM||CHR(10)||" ).append("\n"); 
		query.append("	'BLPLACE:'||NVL(E.LOC_CD,' ')||CHR(10)||" ).append("\n"); 
		query.append("	'BLDATE:'||NVL(TO_CHAR(ISS.OBL_ISS_DT,'RRMMDD'),' ')||CHR(10)||" ).append("\n"); 
		query.append("	'SHPRCN:'||NVL(BCS.CUST_CNT_CD,'')||CHR(10)||" ).append("\n"); 
		query.append("	'SHPRCD:'||NVL(TO_CHAR(BCS.CUST_SEQ),'')||CHR(10)||" ).append("\n"); 
		query.append("	'SHPR1:'||REPLACE(SCE_TOKEN_NL_FNC(BCS.CUST_NM,1),'*','-')||CHR(10)||" ).append("\n"); 
		query.append("	'SHPR2:'||REPLACE(SCE_TOKEN_NL_FNC(BCS.CUST_NM,2),'*','-')||CHR(10)||" ).append("\n"); 
		query.append("	'SHPR3:'||REPLACE(SCE_TOKEN_NL_FNC(BCS.CUST_ADDR,1),'*','-')||CHR(10)||" ).append("\n"); 
		query.append("	'SHPR4:'||REPLACE(SCE_TOKEN_NL_FNC(BCS.CUST_ADDR,2),'*','-')||CHR(10)||" ).append("\n"); 
		query.append("	'SHPR5:'||REPLACE(SCE_TOKEN_NL_FNC(BCS.CUST_ADDR,3),'*','-')||CHR(10)||" ).append("\n"); 
		query.append("	'SHPRTAXID:'||CHR(10)||" ).append("\n"); 
		query.append("	'CNEECN:'||NVL(BCC.CUST_CNT_CD,'')||CHR(10)||" ).append("\n"); 
		query.append("	'CNEECD:'||NVL(TO_CHAR(BCC.CUST_SEQ),'')||CHR(10)||" ).append("\n"); 
		query.append("	'CNEE1:'||REPLACE(SCE_TOKEN_NL_FNC(BCC.CUST_NM,1),'*','-')||CHR(10)||" ).append("\n"); 
		query.append("	'CNEE2:'||REPLACE(SCE_TOKEN_NL_FNC(BCC.CUST_NM,2),'*','-')||CHR(10)||" ).append("\n"); 
		query.append("	'CNEE3:'||REPLACE(SCE_TOKEN_NL_FNC(BCC.CUST_ADDR,1),'*','-')||CHR(10)||" ).append("\n"); 
		query.append("	'CNEE4:'||REPLACE(SCE_TOKEN_NL_FNC(BCC.CUST_ADDR,2),'*','-')||CHR(10)||" ).append("\n"); 
		query.append("	'CNEE5:'||REPLACE(SCE_TOKEN_NL_FNC(BCC.CUST_ADDR,3),'*','-')||CHR(10)||" ).append("\n"); 
		query.append("	'CNEETAXID:'||CHR(10) BL_INFO," ).append("\n"); 
		query.append("	NVL(B.BL_NO,' ') BL_NO," ).append("\n"); 
		query.append("	NVL(B.BKG_NO,' ') BKG_NO, " ).append("\n"); 
		query.append("	NVL(B.BKG_CGO_TP_CD,' ') BKG_CGO_TP_CD," ).append("\n"); 
		query.append("	NVL(B.DCGO_FLG,' ') DCGO_FLG," ).append("\n"); 
		query.append("	NVL(B.RC_FLG,' ') RC_FLG," ).append("\n"); 
		query.append("	NVL(B.AWK_CGO_FLG,' ') AWK_CGO_FLG," ).append("\n"); 
		query.append("	NVL(B.BB_CGO_FLG,' ') BB_CGO_FLG," ).append("\n"); 
		query.append("	NVL(B.RD_CGO_FLG,' ') RD_CGO_FLG," ).append("\n"); 
		query.append("	NVL(B.CMDT_CD,' ') CMDT_CD," ).append("\n"); 
		query.append("	TRANSLATE(NVL(COM.CMDT_NM,' '),chr(10),' ') CMDT_DESC" ).append("\n"); 
		query.append("FROM	BKG_BOOKING B, BKG_BL_ISS ISS," ).append("\n"); 
		query.append("	BKG_CUSTOMER BCS," ).append("\n"); 
		query.append("	BKG_CUSTOMER BCC," ).append("\n"); 
		query.append("	MDM_LOCATION C1," ).append("\n"); 
		query.append("	MDM_LOCATION C2," ).append("\n"); 
		query.append("	MDM_LOCATION C3," ).append("\n"); 
		query.append("	MDM_LOCATION C4," ).append("\n"); 
		query.append("	MDM_LOCATION C5," ).append("\n"); 
		query.append("	MDM_ORGANIZATION E," ).append("\n"); 
		query.append("	MDM_COMMODITY COM" ).append("\n"); 
		query.append("WHERE	B.BKG_NO	= @[bkg_no]" ).append("\n"); 
		query.append("AND	B.BKG_NO		= ISS.BKG_NO(+)" ).append("\n"); 
		query.append("AND	B.POL_CD		= C1.LOC_CD(+)" ).append("\n"); 
		query.append("AND	B.POD_CD		= C2.LOC_CD(+)" ).append("\n"); 
		query.append("AND	B.POR_CD		= C3.LOC_CD(+)" ).append("\n"); 
		query.append("AND	B.DEL_CD		= C4.LOC_CD(+)" ).append("\n"); 
		query.append("AND	DECODE(@[in_pol_cd],NULL,NVL(B.PST_RLY_PORT_CD,' '),NVL(B.PRE_RLY_PORT_CD,' ')) = C5.LOC_CD(+)" ).append("\n"); 
		query.append("AND	ISS.OBL_ISS_OFC_CD	= E.OFC_CD(+)" ).append("\n"); 
		query.append("AND	B.CMDT_CD		= COM.CMDT_CD(+)" ).append("\n"); 
		query.append("AND	B.BKG_NO		= BCS.BKG_NO" ).append("\n"); 
		query.append("AND	BCS.BKG_CUST_TP_CD	= 'S'" ).append("\n"); 
		query.append("AND	B.BKG_NO		= BCC.BKG_NO" ).append("\n"); 
		query.append("AND	BCC.BKG_CUST_TP_CD	= 'C'" ).append("\n"); 

	}
}