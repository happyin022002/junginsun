/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : CLLCDLManifestDBDAOsearchCllCntrRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.11.24
*@LastModifier : 
*@LastVersion : 1.0
* 2016.11.24 
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

public class CLLCDLManifestDBDAOsearchCllCntrRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchCllCntr
	  * 
	  * 2011.1.20 
	  *   - [CHM-201108213] CLL/CDL EDI 기능에 Multi Seal 지원 로직 추가
	  *   - [CHM-201108406] COPRAR EDI issue 관련 보완 요청 - Venterm Terminal (CAVANM2)
	  * </pre>
	  */
	public CLLCDLManifestDBDAOsearchCllCntrRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cmdt_desc",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cmdt_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("FileName : CLLCDLManifestDBDAOsearchCllCntrRSQL").append("\n"); 
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
		query.append("SELECT	'{CNTR_INFO'||CHR(10)||" ).append("\n"); 
		query.append("	'CNTRNBR:'||NVL(M.CNTR_NO,' ')||CHR(10)||" ).append("\n"); 
		query.append("	'TS_IND:'||NVL(M.TS_CGO_CD,' ')||CHR(10)||" ).append("\n"); 
		query.append("    'RAIL_DEST:'||NVL((SELECT D.NOD_CD" ).append("\n"); 
		query.append("                         FROM SCE_COP_HDR H, SCE_COP_DTL D" ).append("\n"); 
		query.append("                        WHERE H.BKG_NO = M.BKG_NO" ).append("\n"); 
		query.append("                          AND H.CNTR_NO = M.CNTR_NO" ).append("\n"); 
		query.append("                          AND H.COP_NO = D.COP_NO" ).append("\n"); 
		query.append("                          AND H.COP_STS_CD <> 'X'" ).append("\n"); 
		query.append("                          AND D.COP_DTL_SEQ = (SELECT MAX(COP_DTL_SEQ) FROM SCE_COP_DTL WHERE COP_NO = H.COP_NO AND ACT_CD = 'FIRRAD')" ).append("\n"); 
		query.append("                       ),' ')||CHR(10)||" ).append("\n"); 
		query.append("	'PUNIT:'||NVL(M.PCK_TP_CD,' ')||CHR(10)||" ).append("\n"); 
		query.append("	'PKG:'||NVL(M.PCK_QTY,0)||CHR(10)||" ).append("\n"); 
		query.append("	'CNTRWGT:'||DECODE(NVL(M.WGT_TP_CD,' ')," ).append("\n"); 
		query.append("					   'LBS', ROUND(NVL(M.CNTR_WGT,0)*0.4536,0)," ).append("\n"); 
		query.append("					   NVL(M.CNTR_WGT,0))||CHR(10)||" ).append("\n"); 
		query.append("	'CNTRGWGT:'||ROUND(DECODE(NVL(M.WGT_TP_CD,' ')," ).append("\n"); 
		query.append("					          'LBS', ROUND(NVL(M.CNTR_WGT,0)*0.4536,0)," ).append("\n"); 
		query.append("         					   NVL(M.CNTR_WGT,0))" ).append("\n"); 
		query.append("                    + (DECODE(NVL(DECODE(NVL(KKK.SPEC_TARE_WGT, 0), 0, DECODE(NVL(KKK.MDM_CNTR_TPSZ_TARE_WGT, 0), 0, DECODE(KKK.O_CNTR_TPSZ_CD, 'T2', 3600, 'T4', 5200, 0), KKK.MDM_CNTR_TPSZ_TARE_WGT), KKK.SPEC_TARE_WGT  ),0),0,(SELECT CNTR_TPSZ_TARE_WGT FROM MDM_CNTR_TP_SZ WHERE CNTR_TPSZ_CD = M.CNTR_TPSZ_CD), NVL(DECODE(NVL(KKK.SPEC_TARE_WGT, 0), 0, DECODE(NVL(KKK.MDM_CNTR_TPSZ_TARE_WGT, 0), 0, DECODE(KKK.O_CNTR_TPSZ_CD, 'T2', 3600, 'T4', 5200, 0), KKK.MDM_CNTR_TPSZ_TARE_WGT), KKK.SPEC_TARE_WGT  ),0))) * DECODE(NVL(M.WGT_TP_CD, ' '), 'LBS',0.4536,1),2)||CHR(10)||" ).append("\n"); 
		query.append("	'CNTR_WGT_UNIT:'||'KGS'||CHR(10)||" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("    'CNTR_TOTAL_WGT:'|| (" ).append("\n"); 
		query.append("                            SELECT " ).append("\n"); 
		query.append("									NVL(" ).append("\n"); 
		query.append("										SUM(" ).append("\n"); 
		query.append("                                        	DECODE(NVL(WGT_TP_CD,' ')" ).append("\n"); 
		query.append("                                				,'LBS', ROUND(NVL(CNTR_WGT,0)*0.4536,0)" ).append("\n"); 
		query.append("                                				,NVL(CNTR_WGT,0)" ).append("\n"); 
		query.append("                                		      )" ).append("\n"); 
		query.append("                                			) " ).append("\n"); 
		query.append("										, DECODE(NVL(M.WGT_TP_CD,' ')," ).append("\n"); 
		query.append("					   						'LBS', ROUND(NVL(M.CNTR_WGT,0)*0.4536,0)," ).append("\n"); 
		query.append("					   							NVL(M.CNTR_WGT,0))" ).append("\n"); 
		query.append("										) CNTR_TOTAL_WGT" ).append("\n"); 
		query.append("							FROM BKG_CSTMS_TML_CLL" ).append("\n"); 
		query.append("							WHERE 1=1" ).append("\n"); 
		query.append("							AND VSL_CD 			= SUBSTR(@[in_vvd_cd],1,4)" ).append("\n"); 
		query.append("							AND SKD_VOY_NO 		= SUBSTR(@[in_vvd_cd],5,4)" ).append("\n"); 
		query.append("							AND SKD_DIR_CD 		= SUBSTR(@[in_vvd_cd],9,1)" ).append("\n"); 
		query.append("							AND PORT_CD 		= @[in_pol_cd]" ).append("\n"); 
		query.append("							AND CNTR_NO 		= @[cntr_no]" ).append("\n"); 
		query.append("							AND CRE_USR_ID 		= @[cre_usr_id]" ).append("\n"); 
		query.append("							AND  TEU_CNTR_QTY + FEU_CNTR_QTY < 1" ).append("\n"); 
		query.append("                        ) ||CHR(10)||" ).append("\n"); 
		query.append("        " ).append("\n"); 
		query.append("    'CNTR_TOTAL_WGT_UNIT:'||'KGS'||CHR(10)||" ).append("\n"); 
		query.append("	'CNTRTRW:'||NVL(TARE_CNTR_WGT,0)||CHR(10)||" ).append("\n"); 
		query.append("	'CNTRTYPE:'||NVL(M.CNTR_TPSZ_CD,' ')||CHR(10)||" ).append("\n"); 
		query.append("	'SEALNBR:'||NVL(M.CNTR_SEAL_NO,' ')||CHR(10)||" ).append("\n"); 
		query.append("	'FM_IND:'||NVL(M.FULL_MTY_CD,' ')||CHR(10)||" ).append("\n"); 
		query.append("	'RF_IND:'||NVL(M.RC_FLG,' ')||CHR(10)||" ).append("\n"); 
		query.append("	'DG_IND:'||NVL(M.DCGO_FLG,' ')||CHR(10)||" ).append("\n"); 
		query.append("	'AK_IND:'||NVL(M.AWK_CGO_FLG,' ')||CHR(10)||" ).append("\n"); 
		query.append("	'BK_IND:'||NVL(M.BB_CGO_FLG,' ')||CHR(10)||" ).append("\n"); 
		query.append("	'TEMPMIN:'||NVL(M.CDO_TEMP,'')||CHR(10)||" ).append("\n"); 
		query.append("	'TEMPMAX:'||NVL(M.CDO_TEMP,'')||CHR(10)||" ).append("\n"); 
		query.append("	'TEMP:'||NVL(M.FDO_TEMP,'')||CHR(10)||" ).append("\n"); 
		query.append("	'TUNIT:F'||CHR(10)||" ).append("\n"); 
		query.append("	'TEMP_C:'||NVL(M.CDO_TEMP,'')||CHR(10)||" ).append("\n"); 
		query.append("	'TUNIT_C:C'||CHR(10)||" ).append("\n"); 
		query.append("	'VENT:'	|| CASE WHEN M.CNTR_VENT_RTO = 0 THEN 'C'" ).append("\n"); 
		query.append("					WHEN M.CNTR_VENT_RTO > 0 AND M.CNTR_VENT_RTO < 35 THEN 'Q'" ).append("\n"); 
		query.append("					WHEN M.CNTR_VENT_RTO >= 35 AND M.CNTR_VENT_RTO < 65 THEN 'H'" ).append("\n"); 
		query.append("					WHEN M.CNTR_VENT_RTO >= 65 AND M.CNTR_VENT_RTO < 100 THEN 'T'" ).append("\n"); 
		query.append("					WHEN M.CNTR_VENT_RTO = 100 THEN 'O' END		|| CHR(10)||" ).append("\n"); 
		query.append("	'VENT_NUM:' || (SELECT DECODE(NVL(VENT_RTO, 0), 0, '', VENT_RTO) FROM BKG_RF_CGO WHERE BKG_NO = M.BKG_NO AND RC_SEQ = M.RC_SEQ) ||CHR(10)||" ).append("\n"); 
		query.append("	'VENT_CMH:' || (SELECT DECODE(NVL(CBM_PER_HR_QTY, 0), 0, '', CBM_PER_HR_QTY) FROM BKG_RF_CGO WHERE BKG_NO = M.BKG_NO AND RC_SEQ = M.RC_SEQ) ||CHR(10)||" ).append("\n"); 
		query.append("	'HUMID:'    ||  NVL((SELECT HUMID_NO FROM BKG_RF_CGO WHERE BKG_NO = M.BKG_NO AND RC_SEQ = M.RC_SEQ),0) ||CHR(10)||" ).append("\n"); 
		query.append("    'MEASURE:'||NVL(M.MEAS_QTY,0)||CHR(10)||" ).append("\n"); 
		query.append("	'MEASURE_UNIT:'||NVL(M.CNTR_MEAS_UT_CD,' ')||CHR(10)||" ).append("\n"); 
		query.append("	'RDTYPE:'||NVL(M.RCV_TERM_CD,' ')||NVL(M.DE_TERM_CD,' ')||CHR(10)||" ).append("\n"); 
		query.append("	'CMDT_DESC:'||@[cmdt_desc]||CHR(10)||" ).append("\n"); 
		query.append("	'CMDTCD:'||@[cmdt_cd]||CHR(10)||" ).append("\n"); 
		query.append("	'RF_REMARK:'||replace(NVL(M.LIST_RMK,' '),chr(10),' ')||CHR(10)||" ).append("\n"); 
		query.append("	'RFDRY_IND:'||NVL(M.RD_CGO_FLG,' ')||CHR(10)||" ).append("\n"); 
		query.append("	'OVF:'||NVL(M.OVR_FWRD_LEN,0)||CHR(10)||" ).append("\n"); 
		query.append("	'OVR:'||NVL(M.OVR_BKWD_LEN,0)||CHR(10)||" ).append("\n"); 
		query.append("	'OVH:'||NVL(M.OVR_HGT,0)||CHR(10)||" ).append("\n"); 
		query.append("	'OVLW:'||NVL(M.OVR_PORT_LEN,0)||CHR(10)||" ).append("\n"); 
		query.append("	'OVRW:'||NVL(M.OVR_SD_LEN,0)||CHR(10)||" ).append("\n"); 
		query.append("	'OVWGT:'||NVL(M.OVR_CNTR_WGT,0)||CHR(10)||" ).append("\n"); 
		query.append("	'OVWGT_UNIT:'||NVL(M.OVR_WGT_UT_CD,' ')||CHR(10)||" ).append("\n"); 
		query.append("	'VOID_SLOT:'||NVL(( SELECT A.OVR_VOID_SLT_QTY" ).append("\n"); 
		query.append("                          FROM BKG_AWK_CGO A " ).append("\n"); 
		query.append("                         WHERE A.BKG_NO = M.BKG_NO" ).append("\n"); 
		query.append("                           AND NVL(A.CNTR_NO,TO_CHAR(A.AWK_CGO_SEQ)) = CASE WHEN NVL(A.CNTR_NO,'N') = 'N' THEN TO_CHAR(NVL(M.AWK_CGO_SEQ,0))" ).append("\n"); 
		query.append("                                                                       ELSE M.CNTR_NO END ),0)||CHR(10)||" ).append("\n"); 
		query.append("	'STWG_REQ:'||REPLACE(REPLACE(NVL(( SELECT A.STWG_RQST_DESC" ).append("\n"); 
		query.append("                          FROM BKG_AWK_CGO A " ).append("\n"); 
		query.append("                         WHERE A.BKG_NO = M.BKG_NO" ).append("\n"); 
		query.append("                           AND NVL(A.CNTR_NO,TO_CHAR(A.AWK_CGO_SEQ)) = CASE WHEN NVL(A.CNTR_NO,'N') = 'N' THEN TO_CHAR(NVL(M.AWK_CGO_SEQ,0))" ).append("\n"); 
		query.append("                                                                       ELSE M.CNTR_NO END ),' '),CHR(10),''),CHR(13),'')||CHR(10)||" ).append("\n"); 
		query.append("	'SOCIND:'||NVL(M.SOC_FLG,' ')||CHR(10)||" ).append("\n"); 
		query.append("	'SOCNAME:'||DECODE(M.SOC_FLG,'Y',(SELECT VNDR_LGL_ENG_NM" ).append("\n"); 
		query.append("                                        FROM MDM_VENDOR T1" ).append("\n"); 
		query.append("                                           , MST_CONTAINER T2" ).append("\n"); 
		query.append("                                       WHERE T1.VNDR_SEQ = T2.VNDR_SEQ" ).append("\n"); 
		query.append("                                         AND T2.CNTR_NO = M.CNTR_NO),' ')||CHR(10)||" ).append("\n"); 
		query.append("	'VANNING:'||NVL(M.POR_CD,' ')||CHR(10)||" ).append("\n"); 
		query.append("	'HAULAGE:'||DECODE(M.RCV_TERM_CD, 'D', 'P', 'H')" ).append("\n"); 
		query.append("                 ||NVL((SELECT DECODE(TRO.HLG_TP_CD, 'C', 'P', 'H')" ).append("\n"); 
		query.append("                          FROM BKG_EUR_TRO TRO" ).append("\n"); 
		query.append("                         WHERE TRO.BKG_NO = M.BKG_NO" ).append("\n"); 
		query.append("                           AND TRO.CNTR_NO = M.CNTR_NO" ).append("\n"); 
		query.append("                           AND TRO.IO_BND_CD = 'I'" ).append("\n"); 
		query.append("                           AND TRO.CXL_FLG = 'N'), DECODE(M.DE_TERM_CD, 'D', 'P', 'H'))||CHR(10)||" ).append("\n"); 
		query.append("	'HAULAGENAME:'||DECODE(M.RCV_TERM_CD, 'D', 'carrier outbound', 'merchant outbound')" ).append("\n"); 
		query.append("                     ||'-'||NVL((SELECT DECODE(TRO.HLG_TP_CD, 'C', 'carrier inbound', 'merchant inbound')" ).append("\n"); 
		query.append("                                   FROM BKG_EUR_TRO TRO" ).append("\n"); 
		query.append("                                  WHERE TRO.BKG_NO = M.BKG_NO" ).append("\n"); 
		query.append("                                    AND TRO.CNTR_NO = M.CNTR_NO" ).append("\n"); 
		query.append("                                    AND TRO.IO_BND_CD = 'I'" ).append("\n"); 
		query.append("                                    AND TRO.CXL_FLG = 'N'), DECODE(M.DE_TERM_CD, 'D', 'carrier inbound', 'merchant inbound'))||CHR(10)||" ).append("\n"); 
		query.append("	'BKWGT:'||NVL(BB.GRS_WGT,0)||CHR(10)||" ).append("\n"); 
		query.append("	'BKWGTU:'||NVL(BB.WGT_UT_CD,' ')||CHR(10)||" ).append("\n"); 
		query.append("	'BKW:'||NVL(BB.DIM_WDT,0)||CHR(10)||" ).append("\n"); 
		query.append("	'BKH:'||NVL(BB.DIM_HGT,0)||CHR(10)||" ).append("\n"); 
		query.append("	'BKL:'||NVL(BB.DIM_LEN,0)||CHR(10)||" ).append("\n"); 
		query.append("	'CNTROWN:'||NVL(KKK.OWNR_CO_CD,' ')||CHR(10)||" ).append("\n"); 
		query.append("	'CNTRTRM:'||NVL(KKK.LSTM_CD,' ')||CHR(10) CNTR_INFO," ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	BKG_JOIN_FNC(CURSOR(" ).append("\n"); 
		query.append("        (" ).append("\n"); 
		query.append("            SELECT CNTR_SEAL_NO" ).append("\n"); 
		query.append("              FROM BKG_CNTR_SEAL_NO" ).append("\n"); 
		query.append("             WHERE BKG_NO = M.BKG_NO" ).append("\n"); 
		query.append("              AND CNTR_NO = M.CNTR_NO" ).append("\n"); 
		query.append("              AND CNTR_SEAL_SEQ > 0" ).append("\n"); 
		query.append("         )" ).append("\n"); 
		query.append("     ),'@') CNTR_SEAL_NO," ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	M.CNTR_NO," ).append("\n"); 
		query.append("	'' IN_VVD_CD," ).append("\n"); 
		query.append("	'' IN_POL_CD," ).append("\n"); 
		query.append("	'' BKG_NO," ).append("\n"); 
		query.append("	'' CRE_USR_ID," ).append("\n"); 
		query.append("	'' BL_NO" ).append("\n"); 
		query.append("FROM	BKG_CSTMS_TML_CLL M, BKG_BB_CGO BB," ).append("\n"); 
		query.append("		( SELECT NVL(SPEC.TARE_WGT,0) SPEC_TARE_WGT, NVL(MDM.CNTR_TPSZ_TARE_WGT,0) MDM_CNTR_TPSZ_TARE_WGT," ).append("\n"); 
		query.append("		         NVL(O.CNTR_TPSZ_CD,'') O_CNTR_TPSZ_CD, O.CNTR_NO CNTR_NO, O.OWNR_CO_CD, O.LSTM_CD" ).append("\n"); 
		query.append("		FROM " ).append("\n"); 
		query.append("		MST_CONTAINER    O," ).append("\n"); 
		query.append("		MST_CNTR_SPEC    SPEC," ).append("\n"); 
		query.append("		MDM_CNTR_TP_SZ   MDM" ).append("\n"); 
		query.append("		  WHERE 1=1" ).append("\n"); 
		query.append("			 AND    O.CNTR_NO          = @[cntr_no]" ).append("\n"); 
		query.append("			 AND    O.CNTR_SPEC_NO     = SPEC.CNTR_SPEC_NO(+)" ).append("\n"); 
		query.append("			 AND    O.CNTR_TPSZ_CD     = MDM.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("			 AND    ROWNUM = 1 ) KKK" ).append("\n"); 
		query.append("WHERE	M.VSL_CD		= SUBSTR(@[in_vvd_cd],1,4)" ).append("\n"); 
		query.append("AND	M.SKD_VOY_NO		= SUBSTR(@[in_vvd_cd],5,4)" ).append("\n"); 
		query.append("AND	M.SKD_DIR_CD		= SUBSTR(@[in_vvd_cd],9,1)" ).append("\n"); 
		query.append("AND	M.PORT_CD		= @[in_pol_cd]" ).append("\n"); 
		query.append("AND	M.BKG_NO		= @[bkg_no]" ).append("\n"); 
		query.append("AND	M.CNTR_NO		= @[cntr_no]" ).append("\n"); 
		query.append("AND	M.BKG_NO        = BB.BKG_NO(+)" ).append("\n"); 
		query.append("AND	M.CNTR_NO       = KKK.CNTR_NO(+)" ).append("\n"); 
		query.append("AND M.CRE_USR_ID = @[cre_usr_id]" ).append("\n"); 
		query.append("AND	rownum = 1" ).append("\n"); 

	}
}