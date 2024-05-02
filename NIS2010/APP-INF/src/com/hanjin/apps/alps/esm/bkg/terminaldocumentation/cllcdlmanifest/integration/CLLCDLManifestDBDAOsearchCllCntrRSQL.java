/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : CLLCDLManifestDBDAOsearchCllCntrRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.05.24
*@LastModifier : 
*@LastVersion : 1.0
* 2016.05.24 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.terminaldocumentation.cllcdlmanifest.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

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
	  * 2011.1.20 경종윤 
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
		params.put("in_pol_split_no",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cntr_no",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("Path : com.hanjin.apps.alps.esm.bkg.terminaldocumentation.cllcdlmanifest.integration").append("\n"); 
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
		query.append("	'CNTRNBR_OLD:'||(	SELECT OLD_CNTR " ).append("\n"); 
		query.append("						FROM	(" ).append("\n"); 
		query.append("									SELECT  PRE_CTNT.CNTR_NO OLD_CNTR, " ).append("\n"); 
		query.append("        									CRNT_CTNT.CNTR_NO CRNT_CTNT" ).append("\n"); 
		query.append("				 					FROM (       " ).append("\n"); 
		query.append("											SELECT 	ROWNUM RN, SUBSTR(PRE_CTNT,1,11) CNTR_NO " ).append("\n"); 
		query.append("											FROM 	BKG_HIS_MST MST, BKG_HIS_DTL DTL" ).append("\n"); 
		query.append("	      									WHERE 	MST.BKG_NO = DTL.BKG_NO" ).append("\n"); 
		query.append("      										AND   	MST.HIS_SEQ = DTL.HIS_SEQ" ).append("\n"); 
		query.append("      										AND   	MST.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("      										AND   	DTL.HIS_CATE_NM LIKE 'Container%'" ).append("\n"); 
		query.append("      										AND   	MST.BKG_HIS_ISS_UI_ID NOT IN ('ESM_BKG_0079_07','SYSTEM')" ).append("\n"); 
		query.append("      										AND   	DTL.PRE_CTNT IS NOT NULL" ).append("\n"); 
		query.append("      										AND   	SUBSTR(PRE_CTNT,1,11) NOT IN (	SELECT 	CNTR_NO" ).append("\n"); 
		query.append(" 																					FROM 	BKG_CONTAINER" ).append("\n"); 
		query.append("	 																				WHERE 	BKG_NO = @[bkg_no])) PRE_CTNT," ).append("\n"); 
		query.append("								(	SELECT 	ROWNUM RN, CNTR_NO" ).append("\n"); 
		query.append(" 									FROM 	BKG_CONTAINER" ).append("\n"); 
		query.append(" 									WHERE 	BKG_NO = @[bkg_no]) CRNT_CTNT" ).append("\n"); 
		query.append("								WHERE 	CRNT_CTNT.RN = PRE_CTNT.RN(+))" ).append("\n"); 
		query.append("						WHERE 	CRNT_CTNT = @[cntr_no]" ).append("\n"); 
		query.append("						AND		ROWNUM = 1)||CHR(10)||" ).append("\n"); 
		query.append("	'ALPS_EQID:'||(SELECT MAX(DOC_PROC_SEQ) " ).append("\n"); 
		query.append("					 FROM BKG_DOC_PROC_SKD" ).append("\n"); 
		query.append("					WHERE BKG_DOC_PROC_TP_CD = 'CNTATC'" ).append("\n"); 
		query.append("					  AND BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("					  AND DIFF_RMK = @[cntr_no] )||CHR(10)||" ).append("\n"); 
		query.append("    'PUNIT:'||NVL(M.PCK_TP_CD,' ')||CHR(10)||" ).append("\n"); 
		query.append("	'PKG:'||NVL(M.PCK_QTY,0)||CHR(10)||" ).append("\n"); 
		query.append("	'CNTRWGT:'||DECODE(NVL(M.WGT_TP_CD,' ')," ).append("\n"); 
		query.append("					   'LBS', ROUND(NVL(M.CNTR_WGT,0)*0.4536,0)," ).append("\n"); 
		query.append("					   NVL(M.CNTR_WGT,0))||CHR(10)||" ).append("\n"); 
		query.append("	'CNTRGWGT:'||CHR(10)||" ).append("\n"); 
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
		query.append("							#if (${in_pol_split_no} != '')" ).append("\n"); 
		query.append("							AND NVL(CLPT_IND_SEQ, '1') = @[in_pol_split_no]" ).append("\n"); 
		query.append("							#end" ).append("\n"); 
		query.append("							AND CNTR_NO 		= @[cntr_no]" ).append("\n"); 
		query.append("							AND CRE_USR_ID 		= @[cre_usr_id]" ).append("\n"); 
		query.append("							AND  TEU_CNTR_QTY + FEU_CNTR_QTY < 1" ).append("\n"); 
		query.append("                        ) ||CHR(10)||" ).append("\n"); 
		query.append("        " ).append("\n"); 
		query.append("    'CNTR_TOTAL_WGT_UNIT:'||'KGS'||CHR(10)||" ).append("\n"); 
		query.append("	'CNTRTRW:'||NVL(TARE_CNTR_WGT,0)||CHR(10)||" ).append("\n"); 
		query.append("	'CNTRTYPE:'||NVL(M.CNTR_TPSZ_CD,' ')||CHR(10)||" ).append("\n"); 
		query.append("	'VGM_WGTQTY:'||NVL(M.VGM_WGT,0)||CHR(10)||" ).append("\n"); 
		query.append("    'VGM_WGTCD:'||'KGS'||CHR(10)||" ).append("\n"); 
		query.append("    'VGM_METHOD:'||NVL(M.VGM_MZD_TP_CD, ' ')||CHR(10)||" ).append("\n"); 
		query.append("    'VGM_SIGNATURE:'||NVL(M.VGM_VRFY_SIG_CTNT, ' ')||CHR(10)||" ).append("\n"); 
		query.append("	'SEALNBR:'||NVL(M.CNTR_SEAL_NO,' ')||CHR(10)||" ).append("\n"); 
		query.append("	'FM_IND:'||NVL(M.FULL_MTY_CD,' ')||CHR(10)||" ).append("\n"); 
		query.append("	'RF_IND:'||NVL(M.RC_FLG,' ')||CHR(10)||" ).append("\n"); 
		query.append("	'DG_IND:'||NVL(M.DCGO_FLG,' ')||CHR(10)||" ).append("\n"); 
		query.append("	'AK_IND:'||NVL(M.AWK_CGO_FLG,' ')||CHR(10)||" ).append("\n"); 
		query.append("	'BK_IND:'||NVL(M.BB_CGO_FLG,' ')||CHR(10)||" ).append("\n"); 
		query.append("	'TEMP:'||DECODE(M.FDO_TEMP,NULL,M.CDO_TEMP,M.FDO_TEMP)||CHR(10)||" ).append("\n"); 
		query.append("	'TUNIT:'||DECODE(M.FDO_TEMP,NULL,'C','F')||CHR(10)||" ).append("\n"); 
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
		query.append("	'RF_REMARK:'||replace(NVL(M.LIST_RMK,' '),chr(13)||chr(10),' ')||CHR(10)||" ).append("\n"); 
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
		query.append("	'HAULAGE:'||' '||CHR(10)||" ).append("\n"); 
		query.append("	'BKWGT:'||NVL(BB.GRS_WGT,0)||CHR(10)||" ).append("\n"); 
		query.append("	'BKWGTU:'||NVL(BB.WGT_UT_CD,' ')||CHR(10)||" ).append("\n"); 
		query.append("	'BKW:'||NVL(BB.DIM_WDT,0)||CHR(10)||" ).append("\n"); 
		query.append("	'BKH:'||NVL(BB.DIM_HGT,0)||CHR(10)||" ).append("\n"); 
		query.append("	'BKL:'||NVL(BB.DIM_LEN,0)||CHR(10)||" ).append("\n"); 
		query.append("	'CNTROWN:'||NVL(O.OWNR_CO_CD,' ')||CHR(10)||" ).append("\n"); 
		query.append("	'CNTRTRM:'||NVL(O.LSTM_CD,' ')||CHR(10) CNTR_INFO," ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	BKG_JOIN_FNC(CURSOR(" ).append("\n"); 
		query.append("        (" ).append("\n"); 
		query.append("            SELECT CNTR_SEAL_NO " ).append("\n"); 
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
		query.append("FROM	BKG_CSTMS_TML_CLL M, BKG_BB_CGO BB, MST_CONTAINER O" ).append("\n"); 
		query.append("WHERE	M.VSL_CD		= SUBSTR(@[in_vvd_cd],1,4)" ).append("\n"); 
		query.append("AND	M.SKD_VOY_NO		= SUBSTR(@[in_vvd_cd],5,4)" ).append("\n"); 
		query.append("AND	M.SKD_DIR_CD		= SUBSTR(@[in_vvd_cd],9,1)" ).append("\n"); 
		query.append("AND	M.PORT_CD		= @[in_pol_cd]" ).append("\n"); 
		query.append("#if (${in_pol_split_no} != '')" ).append("\n"); 
		query.append("AND NVL(M.CLPT_IND_SEQ, '1')  = @[in_pol_split_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("AND	M.BKG_NO		= @[bkg_no]" ).append("\n"); 
		query.append("AND	M.CNTR_NO		= @[cntr_no]" ).append("\n"); 
		query.append("AND	M.BKG_NO        = BB.BKG_NO(+)" ).append("\n"); 
		query.append("AND	M.CNTR_NO       = O.CNTR_NO(+)" ).append("\n"); 
		query.append("AND M.CRE_USR_ID = @[cre_usr_id]" ).append("\n"); 
		query.append("AND	rownum = 1" ).append("\n"); 

	}
}