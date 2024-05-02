/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : CLLCDLManifestDBDAOsearchCntrExportTransmitCntrRSQL.java
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

public class CLLCDLManifestDBDAOsearchCntrExportTransmitCntrRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Container Export EDI 전송시 Container정보를 구하는 쿼리.
	  * </pre>
	  */
	public CLLCDLManifestDBDAOsearchCntrExportTransmitCntrRSQL(){
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

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.terminaldocumentation.cllcdlmanifest.integration").append("\n"); 
		query.append("FileName : CLLCDLManifestDBDAOsearchCntrExportTransmitCntrRSQL").append("\n"); 
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
		query.append("SELECT  NVL(c.cntr_no,' ') CNTRNBR," ).append("\n"); 
		query.append("    	NVL(c.PCK_TP_CD,' ') PUNIT," ).append("\n"); 
		query.append("    	NVL(c.PCK_QTY,'') PKG," ).append("\n"); 
		query.append("    	DECODE(NVL(C.WGT_UT_CD,DOC.WGT_UT_CD),'LBS',ROUND(NVL(DECODE(c.CNTR_WGT,0,NULL,c.CNTR_WGT),ROUND(DOC.ACT_WGT / QTY.QTY, 0))*0.4536,0),NVL(DECODE(c.CNTR_WGT,0,NULL,c.CNTR_WGT),ROUND(DOC.ACT_WGT / QTY.QTY, 0))) CNTRWGT," ).append("\n"); 
		query.append("		DECODE(DECODE(NVL(c.WGT_UT_CD,DOC.WGT_UT_CD),'LBS',ROUND(NVL(DECODE(c.CNTR_WGT,0,NULL,c.CNTR_WGT),ROUND(DOC.ACT_WGT / QTY.QTY, 0))*0.4536,0),NVL(DECODE(c.CNTR_WGT,0,NULL,c.CNTR_WGT),ROUND(DOC.ACT_WGT / QTY.QTY, 0))),NULL,NULL,0,NULL,'0',NULL,DECODE(NVL(DECODE(c.CNTR_WGT,0,NULL,c.CNTR_WGT),DOC.WGT_UT_CD),'LBS',ROUND(NVL(DECODE(c.CNTR_WGT,0,NULL,c.CNTR_WGT),ROUND(DOC.ACT_WGT / QTY.QTY, 0))*0.4536,2),NVL(DECODE(c.CNTR_WGT,0,NULL,c.CNTR_WGT),ROUND(DOC.ACT_WGT / QTY.QTY, 0))) + DECODE(NVL(S.TARE_WGT, 0), 0, DECODE(NVL(T.CNTR_TPSZ_TARE_WGT, 0), 0, DECODE(O.CNTR_TPSZ_CD, 'T2', 3600, 'T4', 5200, 0), T.CNTR_TPSZ_TARE_WGT), S.TARE_WGT  ) ) CNTRGWGT," ).append("\n"); 
		query.append("    	'KGM' CNTR_WGT_UNIT," ).append("\n"); 
		query.append("    	DECODE(NVL(S.TARE_WGT, 0), 0, DECODE(NVL(T.CNTR_TPSZ_TARE_WGT, 0), 0, DECODE(O.CNTR_TPSZ_CD, 'T2', 3600, 'T4', 5200, 0), T.CNTR_TPSZ_TARE_WGT), S.TARE_WGT  ) CNTRTRW," ).append("\n"); 
		query.append("    	NVL(c.CNTR_TPSZ_CD,' ') CNTRTYPE," ).append("\n"); 
		query.append("    	(  SELECT MIN(CNTR_SEAL_NO) CNTR_SEAL_NO" ).append("\n"); 
		query.append("			 FROM BKG_CNTR_SEAL_NO" ).append("\n"); 
		query.append("  			WHERE BKG_NO = C.BKG_NO" ).append("\n"); 
		query.append("    		  AND CNTR_NO = C.CNTR_NO) SEALNBR," ).append("\n"); 
		query.append("    	DECODE(BK.BKG_CGO_TP_CD,'F','F','M') FM_IND," ).append("\n"); 
		query.append("    	BK.RC_FLG RF_IND," ).append("\n"); 
		query.append("    	BK.DCGO_FLG DG_IND," ).append("\n"); 
		query.append("    	BK.AWK_CGO_FLG AK_IND," ).append("\n"); 
		query.append("    	BK.BB_CGO_FLG BK_IND," ).append("\n"); 
		query.append("    	'' TEMP," ).append("\n"); 
		query.append("    	'' TUNIT," ).append("\n"); 
		query.append("    	'' VENT," ).append("\n"); 
		query.append("    	NVL(c.MEAS_QTY,'') MEASURE," ).append("\n"); 
		query.append("    	NVL(c.MEAS_UT_CD,' ') MEASURE_UNIT," ).append("\n"); 
		query.append("    	NVL(c.RCV_TERM_CD,' ')||NVL(c.DE_TERM_CD,' ') RDTYPE," ).append("\n"); 
		query.append("    	Translate(NVL(COM.CMDT_NM,' '),chr(10),' ') CMDT_DESC," ).append("\n"); 
		query.append("    	NVL(BK.cmdt_cd,' ') CMDTCD," ).append("\n"); 
		query.append("    	'' RF_REMARK," ).append("\n"); 
		query.append("    	DECODE(BK.RD_CGO_FLG,'Y','1','0') RFDRY_IND," ).append("\n"); 
		query.append("    	'' OVF," ).append("\n"); 
		query.append("    	'' OVR," ).append("\n"); 
		query.append("    	'' OVH," ).append("\n"); 
		query.append("    	'' OVLW," ).append("\n"); 
		query.append("    	'' OVRW," ).append("\n"); 
		query.append("    	'' OVWGT," ).append("\n"); 
		query.append("    	'' OVWGT_UNIT," ).append("\n"); 
		query.append("    	'' VOID_SLOT," ).append("\n"); 
		query.append("    	'' STWG_REQ," ).append("\n"); 
		query.append("    	nvl(C.SOC_FLG,' ') SOCIND," ).append("\n"); 
		query.append("    	'' HAULAGE," ).append("\n"); 
		query.append("    	'' BKWGT," ).append("\n"); 
		query.append("    	'' BKWGTU," ).append("\n"); 
		query.append("    	'' BKW," ).append("\n"); 
		query.append("    	'' BKH," ).append("\n"); 
		query.append("    	'' BKL," ).append("\n"); 
		query.append("    	NVL(O.OWNR_CO_CD,' ') CNTROWN," ).append("\n"); 
		query.append("    	NVL(O.LSTM_CD,' ') CNTRTRM," ).append("\n"); 
		query.append("    	C.cntr_no CNTR_NO" ).append("\n"); 
		query.append("FROM	BKG_BOOKING BK, " ).append("\n"); 
		query.append("    	BKG_BL_DOC DOC," ).append("\n"); 
		query.append("    	BKG_CONTAINER C, " ).append("\n"); 
		query.append("    	MST_CONTAINER O, " ).append("\n"); 
		query.append("		MST_CNTR_SPEC S," ).append("\n"); 
		query.append("    	MDM_CNTR_TP_SZ T," ).append("\n"); 
		query.append("		MDM_COMMODITY COM," ).append("\n"); 
		query.append("		( 	SELECT 	BKG_NO," ).append("\n"); 
		query.append("					SUM(NVL(OP_CNTR_QTY,0)) QTY " ).append("\n"); 
		query.append("			FROM 	BKG_QUANTITY" ).append("\n"); 
		query.append("    		WHERE 	BKG_NO = @[form_bkg_no]" ).append("\n"); 
		query.append("      		AND 	CNTR_TPSZ_CD NOT IN ('Q2','Q4')" ).append("\n"); 
		query.append("      		GROUP BY BKG_NO ) QTY" ).append("\n"); 
		query.append("WHERE	BK.BKG_NO				= @[form_bkg_no]" ).append("\n"); 
		query.append("AND	    BK.BKG_NO 				= DOC.BKG_NO" ).append("\n"); 
		query.append("and		BK.BKG_NO				= C.BKG_NO" ).append("\n"); 
		query.append("AND     BK.BKG_NO               = QTY.BKG_NO(+)" ).append("\n"); 
		query.append("and		C.CNTR_NO				= O.CNTR_NO(+)" ).append("\n"); 
		query.append("AND     O.CNTR_SPEC_NO          = S.CNTR_SPEC_NO(+)" ).append("\n"); 
		query.append("and		O.CNTR_TPSZ_CD 			= T.CNTR_TPSZ_CD(+)" ).append("\n"); 
		query.append("AND 	BK.CMDT_CD            	= COM.CMDT_CD(+)" ).append("\n"); 
		query.append("and		NVL(C.DCGO_FLG,'N')		= 'N'" ).append("\n"); 
		query.append("and		NVL(C.BB_CGO_FLG,'N')	= 'N'" ).append("\n"); 
		query.append("and		NVL(C.AWK_CGO_FLG,'N')	= 'N'" ).append("\n"); 
		query.append("and		NVL(C.RC_FLG,'N')		= 'N'" ).append("\n"); 

	}
}