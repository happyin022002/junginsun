/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : CLLCDLManifestDBDAOsearchCdlCntrRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.04.10
*@LastModifier : 
*@LastVersion : 1.0
* 2010.04.10 
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

public class CLLCDLManifestDBDAOsearchCdlCntrRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchCdlCntr
	  * </pre>
	  */
	public CLLCDLManifestDBDAOsearchCdlCntrRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("awk_cgo_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("in_yd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_cgo_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dcgo_flg",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("bb_cgo_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("in_bkg_no",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("rc_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rd_cgo_flg",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.terminaldocumentation.cllcdlmanifest.integration").append("\n"); 
		query.append("FileName : CLLCDLManifestDBDAOsearchCdlCntrRSQL").append("\n"); 
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
		query.append("SELECT	MAX('{CNTR_INFO'||CHR(10)||" ).append("\n"); 
		query.append("	'CNTRNBR:'||NVL(C.CNTR_NO,' ')||CHR(10)||" ).append("\n"); 
		query.append("	'PUNIT:'||NVl(C.PCK_TP_CD,' ')||CHR(10)||" ).append("\n"); 
		query.append("	DECODE(@[in_yd_cd],'CNXMN','PUNIT_DESC:'||NVL(P.PCK_NM,' ')||CHR(10),'')||" ).append("\n"); 
		query.append("	'PKG:'||NVL(C.PCK_QTY,0)||CHR(10)||" ).append("\n"); 
		query.append("	'CNTRWGT:'||DECODE(NVL(C.WGT_UT_CD,' ')," ).append("\n"); 
		query.append("						'LBS',ROUND(NVL(C.CNTR_WGT,0)*0.4536,2)," ).append("\n"); 
		query.append("						NVL(C.CNTR_WGT,0)" ).append("\n"); 
		query.append("				)||CHR(10)||" ).append("\n"); 
		query.append("	'CNTRGWGT:'||CHR(10)||" ).append("\n"); 
		query.append("	'CNTR_WGT_UNIT:'||'KGS'||CHR(10)||" ).append("\n"); 
		query.append("	'CNTRTRW:'||DECODE(NVL(SPEC.TARE_WGT, 0), 0" ).append("\n"); 
		query.append("                            , DECODE(NVL(MDM.CNTR_TPSZ_TARE_WGT, 0), 0" ).append("\n"); 
		query.append("                                 , DECODE(O.CNTR_TPSZ_CD, 'T2', 3600, 'T4', 5200, 0), MDM.CNTR_TPSZ_TARE_WGT)" ).append("\n"); 
		query.append("              , SPEC.TARE_WGT  )||CHR(10)||" ).append("\n"); 
		query.append("	'CNTRTYPE:'||NVL(C.CNTR_TPSZ_CD,' ')||CHR(10))||" ).append("\n"); 
		query.append("	'SEALNBR:'||NVL(MIN(S.CNTR_SEAL_NO),' ')||CHR(10)||" ).append("\n"); 
		query.append("	MAX(" ).append("\n"); 
		query.append("	'FM_IND:'||@[bkg_cgo_tp_cd]||CHR(10)||" ).append("\n"); 
		query.append("	'RF_IND:'||@[rc_flg]||CHR(10)||" ).append("\n"); 
		query.append("	'DG_IND:'||@[dcgo_flg]||CHR(10)||" ).append("\n"); 
		query.append("	'AK_IND:'||@[awk_cgo_flg]||CHR(10)||" ).append("\n"); 
		query.append("	'BK_IND:'||@[bb_cgo_flg]||CHR(10)||" ).append("\n"); 
		query.append("	'TEMP:'||NVL(R.CDO_TEMP,0)||CHR(10)||" ).append("\n"); 
		query.append("	'TUNIT:C'||CHR(10)||" ).append("\n"); 
		query.append("	'VENT:'	|| CASE WHEN R.VENT_RTO = 0 THEN 'C'" ).append("\n"); 
		query.append("					WHEN R.VENT_RTO > 0 AND R.VENT_RTO < 35 THEN 'Q'" ).append("\n"); 
		query.append("					WHEN R.VENT_RTO >= 35 AND R.VENT_RTO < 65 THEN 'H'" ).append("\n"); 
		query.append("					WHEN R.VENT_RTO >= 65 AND R.VENT_RTO < 100 THEN 'T'" ).append("\n"); 
		query.append("					WHEN R.VENT_RTO = 100 THEN 'O' END		|| CHR(10)||" ).append("\n"); 
		query.append("	'MEASURE:'||NVL(C.MEAS_QTY,0)||CHR(10)||" ).append("\n"); 
		query.append("	'MEASURE_UNIT:'||NVL(C.MEAS_UT_CD,' ')||CHR(10)||" ).append("\n"); 
		query.append("	'RDTYPE:'||NVL(C.RCV_TERM_CD,' ')||NVL(C. DE_TERM_CD,' ')||CHR(10)||" ).append("\n"); 
		query.append("	'CMDT_DESC:'||@[cmdt_desc]||CHR(10)||" ).append("\n"); 
		query.append("	'CMDTCD:'||@[cmdt_cd]||CHR(10)||" ).append("\n"); 
		query.append("	'RF_REMARK:'||replace(NVL(R.DIFF_RMK,' '),CHR(13)||CHR(10),' ')||CHR(10)||" ).append("\n"); 
		query.append("	'RFDRY_IND:'||DECODE(@[rd_cgo_flg],'N','0','Y','1',@[rd_cgo_flg])||CHR(10)||" ).append("\n"); 
		query.append("	'OVF:'||NVL(A.OVR_FWRD_LEN,0)||CHR(10)||" ).append("\n"); 
		query.append("	'OVR:'||NVL(A.OVR_BKWD_LEN,0)||CHR(10)||" ).append("\n"); 
		query.append("	'OVH:'||NVL(A.OVR_HGT,0)||CHR(10)||" ).append("\n"); 
		query.append("	'OVLW:'||NVL(A.OVR_LF_LEN,0)||CHR(10)||" ).append("\n"); 
		query.append("	'OVRW:'||NVL(A.OVR_RT_LEN,0)||CHR(10)||" ).append("\n"); 
		query.append("	'OVWGT:'||NVL(A.GRS_WGT,0)||CHR(10)||" ).append("\n"); 
		query.append("	'OVWGT_UNIT:'||NVL(A.WGT_UT_CD,' ')||CHR(10)||" ).append("\n"); 
		query.append("	'VOID_SLOT:'||NVL(A.OVR_VOID_SLT_QTY,0)||CHR(10)||" ).append("\n"); 
		query.append("	'STWG_REQ:'||CHR(10)||" ).append("\n"); 
		query.append("	'SOCIND:'||NVL(C.SOC_FLG,' ')||CHR(10)||" ).append("\n"); 
		query.append("	'HAULAGE:'||CHR(10)||" ).append("\n"); 
		query.append("	'BKWGT:'||CHR(10)||" ).append("\n"); 
		query.append("	'BKWGTU:'||CHR(10)||" ).append("\n"); 
		query.append("	'BKW:'||CHR(10)||" ).append("\n"); 
		query.append("	'BKH:'||CHR(10)||" ).append("\n"); 
		query.append("	'BKL:'||CHR(10)||" ).append("\n"); 
		query.append("	'CNTROWN:'||NVL(O.OWNR_CO_CD,' ')||CHR(10)||" ).append("\n"); 
		query.append("	'CNTRTRM:'||NVL(O.LSTM_CD,' ')||CHR(10)) CNTR_INFO," ).append("\n"); 
		query.append("	C.cntr_no," ).append("\n"); 
		query.append("	'' IN_VVD_CD," ).append("\n"); 
		query.append("	'' IN_POL_CD," ).append("\n"); 
		query.append("	'' BKG_NO," ).append("\n"); 
		query.append("	'' BL_NO	" ).append("\n"); 
		query.append("FROM	BKG_CONTAINER C, BKG_RF_CGO R, BKG_AWK_CGO A, MST_CONTAINER O, MDM_PCK_TP P, BKG_CNTR_SEAL_NO S, MST_CNTR_SPEC SPEC, MDM_CNTR_TP_SZ MDM" ).append("\n"); 
		query.append("WHERE	C.BKG_NO	= @[in_bkg_no]" ).append("\n"); 
		query.append("AND	C.CNTR_NO	= @[cntr_no]" ).append("\n"); 
		query.append("AND C.BKG_NO	= R.BKG_NO(+)" ).append("\n"); 
		query.append("AND	C.CNTR_NO	= R.CNTR_NO(+)	" ).append("\n"); 
		query.append("AND	C.BKG_NO	= A.BKG_NO(+)" ).append("\n"); 
		query.append("AND	C.CNTR_NO	= A.CNTR_NO(+)" ).append("\n"); 
		query.append("AND	C.PCK_TP_CD	= P.PCK_CD(+)" ).append("\n"); 
		query.append("AND	C.BKG_NO	= S.BKG_NO(+)" ).append("\n"); 
		query.append("AND	C.CNTR_NO	= S.CNTR_NO(+)" ).append("\n"); 
		query.append("--AND	S.CNTR_SEAL_SEQ(+) = 1" ).append("\n"); 
		query.append("AND	O.CNTR_NO	= C.CNTR_NO" ).append("\n"); 
		query.append("AND O.CNTR_SPEC_NO      =   SPEC.CNTR_SPEC_NO(+)" ).append("\n"); 
		query.append("AND O.CNTR_TPSZ_CD      =   MDM.CNTR_TPSZ_CD" ).append("\n"); 

	}
}