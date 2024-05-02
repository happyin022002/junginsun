/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CLLCDLManifestDBDAOsearchCntrInfoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.15
*@LastModifier : 김승민
*@LastVersion : 1.0
* 2009.09.15 김승민
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.terminaldocumentation.cllcdlmanifest.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author SEUN GMIN KIM
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CLLCDLManifestDBDAOsearchCntrInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchCntrInfo
	  * </pre>
	  */
	public CLLCDLManifestDBDAOsearchCntrInfoRSQL(){
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
		params.put("cntr_no",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("Path : com.hanjin.apps.alps.esm.bkg.terminaldocumentation.cllcdlmanifest.integration").append("\n"); 
		query.append("FileName : CLLCDLManifestDBDAOsearchCntrInfoRSQL").append("\n"); 
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
		query.append("NVL(B.BL_NO,' ') BL_NO," ).append("\n"); 
		query.append("NVL(B.BL_TP_CD,' ') BL_TP_CD," ).append("\n"); 
		query.append("NVL(BCS.CUST_CNT_CD,' ') SHPR_CNT_CD," ).append("\n"); 
		query.append("BCS.CUST_SEQ SHPR_SEQ," ).append("\n"); 
		query.append("SCE_TOKEN_NL_FNC(BCS.CUST_NM,1) SHPR_NM1," ).append("\n"); 
		query.append("SCE_TOKEN_NL_FNC(BCS.CUST_NM,2) SHPR_NM2," ).append("\n"); 
		query.append("SCE_TOKEN_NL_FNC(BCS.CUST_ADDR,1) SHPR_NM3," ).append("\n"); 
		query.append("SCE_TOKEN_NL_FNC(BCS.CUST_ADDR,2) SHPR_NM4," ).append("\n"); 
		query.append("SCE_TOKEN_NL_FNC(BCS.CUST_ADDR,3) SHPR_NM5," ).append("\n"); 
		query.append("NVL(BCC.CUST_CNT_CD,' ') CNEE_CNT_CD," ).append("\n"); 
		query.append("BCC.CUST_SEQ CNEE_SEQ," ).append("\n"); 
		query.append("SCE_TOKEN_NL_FNC(BCC.CUST_NM,1) CNEE_NM1," ).append("\n"); 
		query.append("SCE_TOKEN_NL_FNC(BCC.CUST_NM,2) CNEE_NM2," ).append("\n"); 
		query.append("SCE_TOKEN_NL_FNC(BCC.CUST_ADDR,1) CNEE_NM3," ).append("\n"); 
		query.append("SCE_TOKEN_NL_FNC(BCC.CUST_ADDR,2) CNEE_NM4," ).append("\n"); 
		query.append("SCE_TOKEN_NL_FNC(BCC.CUST_ADDR,3) CNEE_NM5," ).append("\n"); 
		query.append("NVL(BCN.CUST_CNT_CD,' ') NTFY_CNT_CD," ).append("\n"); 
		query.append("BCN.CUST_SEQ NTFY_SEQ," ).append("\n"); 
		query.append("SCE_TOKEN_NL_FNC(BCN.CUST_NM,1) NTFY_NM1," ).append("\n"); 
		query.append("SCE_TOKEN_NL_FNC(BCN.CUST_NM,2) NTFY_NM2," ).append("\n"); 
		query.append("SCE_TOKEN_NL_FNC(BCN.CUST_ADDR,1) NTFY_NM3," ).append("\n"); 
		query.append("SCE_TOKEN_NL_FNC(BCN.CUST_ADDR,2) NTFY_NM4," ).append("\n"); 
		query.append("SCE_TOKEN_NL_FNC(BCN.CUST_ADDR,3) NTFY_NM5," ).append("\n"); 
		query.append("NVL(BCA.CUST_CNT_CD,' ') ANTFY_CNT_CD," ).append("\n"); 
		query.append("BCA.CUST_SEQ ANTFY_SEQ," ).append("\n"); 
		query.append("SCE_TOKEN_NL_FNC(BCA.CUST_NM,1) ANTFY_NM1," ).append("\n"); 
		query.append("SCE_TOKEN_NL_FNC(BCA.CUST_NM,2) ANTFY_NM2," ).append("\n"); 
		query.append("SCE_TOKEN_NL_FNC(BCA.CUST_NM,3) ANTFY_NM3," ).append("\n"); 
		query.append("SCE_TOKEN_NL_FNC(BCA.CUST_NM,4) ANTFY_NM4," ).append("\n"); 
		query.append("SCE_TOKEN_NL_FNC(BCA.CUST_NM,5) ANTFY_NM5," ).append("\n"); 
		query.append("NVL(BCF.CUST_CNT_CD,' ') FF_CNT_CD," ).append("\n"); 
		query.append("BCF.CUST_SEQ FF_CUST_SEQ," ).append("\n"); 
		query.append("SCE_TOKEN_NL_FNC(BCF.CUST_NM,1) FF_NM1," ).append("\n"); 
		query.append("SCE_TOKEN_NL_FNC(BCF.CUST_NM,2) FF_NM2," ).append("\n"); 
		query.append("SCE_TOKEN_NL_FNC(BCF.CUST_NM,3) FF_NM3," ).append("\n"); 
		query.append("SCE_TOKEN_NL_FNC(BCF.CUST_NM,4) FF_NM4," ).append("\n"); 
		query.append("SCE_TOKEN_NL_FNC(BCF.CUST_NM,5) FF_NM5," ).append("\n"); 
		query.append("--DECODE(DOC.WGT_UT_CD," ).append("\n"); 
		query.append("--		'LBS', ROUND(DECODE(NVL(N.CNTR_TARE_WGT,0)," ).append("\n"); 
		query.append("--							0, NVL(Z.CNTR_TPSZ_TARE_WGT,0)," ).append("\n"); 
		query.append("--							NVL(N.CNTR_TARE_WGT,0)" ).append("\n"); 
		query.append("--						) * 2.20495, 0" ).append("\n"); 
		query.append("--				)," ).append("\n"); 
		query.append("--		 DECODE(NVL(N.CNTR_TARE_WGT,0)," ).append("\n"); 
		query.append("--				0, NVL(Z.CNTR_TPSZ_TARE_WGT,0)," ).append("\n"); 
		query.append("--				NVL(N.CNTR_TARE_WGT,0)" ).append("\n"); 
		query.append("--			)" ).append("\n"); 
		query.append("--) TARE_CNTR_WGT," ).append("\n"); 
		query.append("'' TARE_CNTR_WGT," ).append("\n"); 
		query.append("T.VSL_CD||T.SKD_VOY_NO||T.SKD_DIR_CD TS_VVD_ID," ).append("\n"); 
		query.append("T.POL_CD," ).append("\n"); 
		query.append("T.POD_CD," ).append("\n"); 
		query.append("O.CMDT_CD," ).append("\n"); 
		query.append("O.CMDT_NM," ).append("\n"); 
		query.append("P.REP_CMDT_CD," ).append("\n"); 
		query.append("P.REP_CMDT_NM," ).append("\n"); 
		query.append("B.VSL_CD||B.SKD_VOY_NO||B.SKD_DIR_CD TRNK_VVD_ID," ).append("\n"); 
		query.append("substr(Translate(NVL(R.DIFF_RMK,' '),chr(13)||chr(10),' '),1,50) BL_RMK" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("BKG_BOOKING B," ).append("\n"); 
		query.append("BKG_BL_DOC DOC," ).append("\n"); 
		query.append("MDM_COMMODITY O," ).append("\n"); 
		query.append("MDM_REP_CMDT P," ).append("\n"); 
		query.append("BKG_VVD V," ).append("\n"); 
		query.append("BKG_VVD T," ).append("\n"); 
		query.append("BKG_CONTAINER C," ).append("\n"); 
		query.append("BKG_RF_CGO R," ).append("\n"); 
		query.append("BKG_AWK_CGO A," ).append("\n"); 
		query.append("MDM_CNTR_TP_SZ Z," ).append("\n"); 
		query.append("--(	SELECT M.CNTR_NO CNTR_NO," ).append("\n"); 
		query.append("--		DECODE(NVL(S.TARE_WGT, 0), 0" ).append("\n"); 
		query.append("--		, DECODE(NVL(MDM.CNTR_TPSZ_TARE_WGT, 0), 0" ).append("\n"); 
		query.append("--			, DECODE(M.CNTR_TPSZ_CD, 'T2', 3600, 'T4', 5200, 0)," ).append("\n"); 
		query.append("--                            MDM.CNTR_TPSZ_TARE_WGT)" ).append("\n"); 
		query.append("--	, S.TARE_WGT  ) CNTR_TARE_WGT" ).append("\n"); 
		query.append("--	FROM MST_CONTAINER M, MST_CNTR_SPEC S, MDM_CNTR_TP_SZ MDM" ).append("\n"); 
		query.append("--	WHERE M.CNTR_SPEC_NO      =   S.CNTR_SPEC_NO" ).append("\n"); 
		query.append("--	AND   M.CNTR_TPSZ_CD      =   MDM.CNTR_TPSZ_CD) N," ).append("\n"); 
		query.append("BKG_CUSTOMER BCS," ).append("\n"); 
		query.append("BKG_CUSTOMER BCC," ).append("\n"); 
		query.append("BKG_CUSTOMER BCN," ).append("\n"); 
		query.append("BKG_CUSTOMER BCA," ).append("\n"); 
		query.append("BKG_CUSTOMER BCF" ).append("\n"); 
		query.append("WHERE	B.BKG_NO		= @[bkg_no]" ).append("\n"); 
		query.append("AND	C.CNTR_NO		= @[cntr_no]" ).append("\n"); 
		query.append("AND	B.BKG_NO		= DOC.BKG_NO(+)" ).append("\n"); 
		query.append("AND	B.BKG_NO		= C.BKG_NO(+)" ).append("\n"); 
		query.append("AND	B.BKG_NO		= V.BKG_NO(+)" ).append("\n"); 
		query.append("AND	@[pol_cd]			= V.POL_CD(+)" ).append("\n"); 
		query.append("AND	B.BKG_NO		= T.BKG_NO(+)" ).append("\n"); 
		query.append("AND	@[pod_cd]			= T.POD_CD(+)" ).append("\n"); 
		query.append("AND	B.CMDT_CD		= O.CMDT_CD(+)" ).append("\n"); 
		query.append("AND	B.REP_CMDT_CD		= P.REP_CMDT_CD(+)" ).append("\n"); 
		query.append("AND	C.BKG_NO		= R.BKG_NO(+)" ).append("\n"); 
		query.append("AND	C.CNTR_NO		= R.CNTR_NO(+)" ).append("\n"); 
		query.append("AND	C.BKG_NO		= A.BKG_NO(+)" ).append("\n"); 
		query.append("AND	C.CNTR_NO		= A.CNTR_NO(+)" ).append("\n"); 
		query.append("--AND	C.CNTR_NO		= N.CNTR_NO(+)" ).append("\n"); 
		query.append("AND	C.CNTR_TPSZ_CD		= Z.CNTR_TPSZ_CD(+)" ).append("\n"); 
		query.append("AND	B.BKG_NO = BCS.BKG_NO" ).append("\n"); 
		query.append("AND	BCS.BKG_CUST_TP_CD = 'S'" ).append("\n"); 
		query.append("AND	B.BKG_NO = BCC.BKG_NO (+)" ).append("\n"); 
		query.append("AND	BCC.BKG_CUST_TP_CD (+) = 'C'" ).append("\n"); 
		query.append("AND	B.BKG_NO = BCN.BKG_NO (+)" ).append("\n"); 
		query.append("AND	BCN.BKG_CUST_TP_CD (+) = 'N'" ).append("\n"); 
		query.append("AND	B.BKG_NO = BCA.BKG_NO (+)" ).append("\n"); 
		query.append("AND	BCA.BKG_CUST_TP_CD (+) = 'A'" ).append("\n"); 
		query.append("AND	B.BKG_NO = BCF.BKG_NO (+)" ).append("\n"); 
		query.append("AND	BCF.BKG_CUST_TP_CD (+) = 'F'" ).append("\n"); 
		query.append("AND	ROWNUM = 1" ).append("\n"); 

	}
}