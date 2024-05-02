/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : CLLCDLManifestDBDAOsearchCntrExportTransmitCntrSpecialRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.09.15
*@LastModifier : 
*@LastVersion : 1.0
* 2014.09.15 
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

public class CLLCDLManifestDBDAOsearchCntrExportTransmitCntrSpecialRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Container Export EDI 전송시 Ak, DG, RF등 Container정보를 구하는 쿼리.
	  * </pre>
	  */
	public CLLCDLManifestDBDAOsearchCntrExportTransmitCntrSpecialRSQL(){
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
		query.append("Path : com.hanjin.apps.alps.esm.bkg.terminaldocumentation.cllcdlmanifest.integration").append("\n"); 
		query.append("FileName : CLLCDLManifestDBDAOsearchCntrExportTransmitCntrSpecialRSQL").append("\n"); 
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
		query.append("SELECT  NVL(C.cntr_no,' ') CNTRNBR," ).append("\n"); 
		query.append("		NVL(c.PCK_TP_CD,' ') PUNIT," ).append("\n"); 
		query.append("		NVL(c.PCK_QTY,'') PKG," ).append("\n"); 
		query.append("		#if (${in_special_flag} 	== 'BB') " ).append("\n"); 
		query.append("		DECODE(NVL(C.WGT_UT_CD,' '),'LBS',ROUND(NVL(C.CNTR_WGT,'')*0.4536,2),NVL(C.CNTR_WGT,'')) CNTRWGT," ).append("\n"); 
		query.append("		DECODE(NVL(K.WGT_UT_CD,' '),'LBS',ROUND(NVL(K.GRS_WGT,'')*0.4536,2),NVL(K.GRS_WGT,'')) CNTRGWGT," ).append("\n"); 
		query.append("		NVL(K.CNTR_TPSZ_CD,' ') CNTRTYPE," ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("		#if (${in_special_flag} 	== 'RC') " ).append("\n"); 
		query.append("		DECODE(NVL(C.WGT_UT_CD,' '),'LBS',ROUND(NVL(C.CNTR_WGT,'')*0.4536,2),NVL(C.CNTR_WGT,'')) CNTRWGT," ).append("\n"); 
		query.append("		DECODE(NVL(R.WGT_UT_CD,' '),'LBS',ROUND(NVL(R.GRS_WGT,'')*0.4536,2),NVL(R.GRS_WGT,'')) CNTRGWGT," ).append("\n"); 
		query.append("		NVL(R.CNTR_TPSZ_CD,' ') CNTRTYPE," ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("		#if (${in_special_flag} 	== 'AK') " ).append("\n"); 
		query.append("		DECODE(NVL(C.WGT_UT_CD,' '),'LBS',ROUND(NVL(C.CNTR_WGT,'')*0.4536,2),NVL(C.CNTR_WGT,'')) CNTRWGT," ).append("\n"); 
		query.append("		DECODE(NVL(A.WGT_UT_CD,' '),'LBS',ROUND(NVL(A.GRS_WGT,'')*0.4536,2),NVL(A.GRS_WGT,'')) CNTRGWGT," ).append("\n"); 
		query.append("		NVL(A.CNTR_TPSZ_CD,' ') CNTRTYPE," ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("		#if (${in_special_flag} 	== 'DG') " ).append("\n"); 
		query.append("		DECODE(NVL(C.WGT_UT_CD,' '),'LBS',ROUND(NVL(C.CNTR_WGT,'')*0.4536,2),NVL(C.CNTR_WGT,'')) CNTRWGT," ).append("\n"); 
		query.append("		NVL(D.GRS_WGT,'') CNTRGWGT," ).append("\n"); 
		query.append("		NVL(D.CNTR_TPSZ_CD,' ') CNTRTYPE," ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("		'KGM' CNTR_WGT_UNIT," ).append("\n"); 
		query.append("		TO_CHAR(DECODE(NVL(T.CNTR_TPSZ_TARE_WGT,0),0,NVL(T.CNTR_TPSZ_TARE_WGT,0),NVL(T.CNTR_TPSZ_TARE_WGT,0))) CNTRTRW," ).append("\n"); 
		query.append("		 " ).append("\n"); 
		query.append("		(  SELECT MIN(CNTR_SEAL_NO) CNTR_SEAL_NO" ).append("\n"); 
		query.append("			 FROM BKG_CNTR_SEAL_NO" ).append("\n"); 
		query.append("  			WHERE BKG_NO = C.BKG_NO" ).append("\n"); 
		query.append("    		  AND CNTR_NO = C.CNTR_NO " ).append("\n"); 
		query.append("			  AND CNTR_SEAL_SEQ = 1) SEALNBR," ).append("\n"); 
		query.append("		DECODE(BK.BKG_CGO_TP_CD,'F','F','M') FM_IND," ).append("\n"); 
		query.append("		BK.RC_FLG RF_IND," ).append("\n"); 
		query.append("		BK.DCGO_FLG DG_IND," ).append("\n"); 
		query.append("		BK.AWK_CGO_FLG AK_IND," ).append("\n"); 
		query.append("		BK.BB_CGO_FLG BK_IND," ).append("\n"); 
		query.append("		nvl(r.CDO_TEMP,'') TEMP," ).append("\n"); 
		query.append("		'C' TUNIT," ).append("\n"); 
		query.append("		nvl(TO_CHAR(r.VENT_RTO),' ') VENT," ).append("\n"); 
		query.append("		NVL(c.MEAS_QTY,'') MEASURE," ).append("\n"); 
		query.append("		NVL(c.MEAS_UT_CD,' ') MEASURE_UNIT," ).append("\n"); 
		query.append("		nvl(c.RCV_TERM_CD,' ')||nvl(c. DE_TERM_CD,' ') RDTYPE," ).append("\n"); 
		query.append("		Translate(NVL(COM.CMDT_NM,' '),chr(13)||chr(10),' ') CMDT_DESC," ).append("\n"); 
		query.append("    	nvl(BK.cmdt_cd,' ') CMDTCD," ).append("\n"); 
		query.append("		replace(nvl(r.DIFF_RMK,' '),chr(13)||chr(10),' ') RF_REMARK," ).append("\n"); 
		query.append("		BK.RD_CGO_FLG RFDRY_IND," ).append("\n"); 
		query.append("		nvl(A.OVR_FWRD_LEN,'') OVF," ).append("\n"); 
		query.append("		nvl(A.OVR_BKWD_LEN,'') OVR," ).append("\n"); 
		query.append("		nvl(A.OVR_HGT,'') OVH," ).append("\n"); 
		query.append("		nvl(A.OVR_LF_LEN,'') OVLW," ).append("\n"); 
		query.append("		nvl(A.OVR_RT_LEN,'') OVRW," ).append("\n"); 
		query.append("		nvl(A.GRS_WGT,'') OVWGT," ).append("\n"); 
		query.append("		nvl(A.WGT_UT_CD,' ') OVWGT_UNIT," ).append("\n"); 
		query.append("		nvl(A.OVR_VOID_SLT_QTY,'') VOID_SLOT," ).append("\n"); 
		query.append("		'' STWG_REQ," ).append("\n"); 
		query.append("		DECODE(nvl(C.SOC_FLG,' '),'1','Y','N') SOCIND," ).append("\n"); 
		query.append("		'' HAULAGE," ).append("\n"); 
		query.append("		NVL(K.GRS_WGT,'') BKWGT," ).append("\n"); 
		query.append("		NVL(K.WGT_UT_CD,' ') BKWGTU," ).append("\n"); 
		query.append("		NVL(K.DIM_WDT,'') BKW," ).append("\n"); 
		query.append("		NVL(K.DIM_HGT,'') BKH," ).append("\n"); 
		query.append("		NVL(K.DIM_LEN,'') BKL," ).append("\n"); 
		query.append("		NVL(O.OWNR_CO_CD,' ') CNTROWN," ).append("\n"); 
		query.append("		NVL(O.LSTM_CD,' ') CNTRTRM," ).append("\n"); 
		query.append("		C.CNTR_NO" ).append("\n"); 
		query.append("		FROM  BKG_BOOKING BK, " ).append("\n"); 
		query.append("		      BKG_CONTAINER C, " ).append("\n"); 
		query.append("		      ( SELECT A.*," ).append("\n"); 
		query.append("		              ( SELECT AA.CNTR_NO " ).append("\n"); 
		query.append("                         FROM (SELECT ROWNUM RN, BKG_CONTAINER.* " ).append("\n"); 
		query.append("                                 FROM BKG_CONTAINER" ).append("\n"); 
		query.append("                                WHERE BKG_NO = @[form_bkg_no]" ).append("\n"); 
		query.append("                                  AND BB_CGO_FLG = 'Y') AA" ).append("\n"); 
		query.append("                        WHERE AA.RN = A.BB_CGO_SEQ ) CNTR_NO" ).append("\n"); 
		query.append("                  FROM BKG_BB_CGO A " ).append("\n"); 
		query.append("                 WHERE BKG_NO = @[form_bkg_no])  K, " ).append("\n"); 
		query.append("		      BKG_RF_CGO R, " ).append("\n"); 
		query.append("		      BKG_AWK_CGO A, 		      " ).append("\n"); 
		query.append("		      BKG_DG_CGO D, " ).append("\n"); 
		query.append("		      MST_CONTAINER O, " ).append("\n"); 
		query.append("		      MDM_CNTR_TP_SZ T," ).append("\n"); 
		query.append("		      MDM_COMMODITY COM" ).append("\n"); 
		query.append("		WHERE BK.BKG_NO       = @[form_bkg_no]	" ).append("\n"); 
		query.append("		#if (${in_special_flag} 	== 'BB') " ).append("\n"); 
		query.append("		AND   BK.BKG_NO       = K.BKG_NO(+)" ).append("\n"); 
		query.append("		and   K.bkg_no        = C.bkg_no(+)" ).append("\n"); 
		query.append("		and   K.cntr_no       = C.cntr_no(+)" ).append("\n"); 
		query.append("		and   K.bkg_no        = R.bkg_no(+)" ).append("\n"); 
		query.append("		and   K.cntr_no       = R.cntr_no(+)" ).append("\n"); 
		query.append("		and   K.bkg_no        = A.bkg_no(+)" ).append("\n"); 
		query.append("		and   K.cntr_no       = A.cntr_no(+)" ).append("\n"); 
		query.append("		and   K.bkg_no        = D.bkg_no(+)" ).append("\n"); 
		query.append("		and   K.cntr_no       = D.cntr_no(+) " ).append("\n"); 
		query.append("		and   K.cntr_no       = o.cntr_no(+)" ).append("\n"); 
		query.append("		and   C.CNTR_TPSZ_CD  = t.CNTR_TPSZ_CD(+)" ).append("\n"); 
		query.append("		AND   BK.CMDT_CD      = COM.CMDT_CD(+)" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("		#if (${in_special_flag}	== 'RC') " ).append("\n"); 
		query.append("		AND   BK.BKG_NO       = R.BKG_NO(+)" ).append("\n"); 
		query.append("		and   R.bkg_no        = C.bkg_no(+)" ).append("\n"); 
		query.append("		and   R.cntr_no       = C.cntr_no(+)" ).append("\n"); 
		query.append("		and   R.bkg_no        = K.bkg_no(+)" ).append("\n"); 
		query.append("		and   R.cntr_no       = K.cntr_no(+)" ).append("\n"); 
		query.append("		and   R.bkg_no        = A.bkg_no(+)" ).append("\n"); 
		query.append("		and   R.cntr_no       = A.cntr_no(+)" ).append("\n"); 
		query.append("		and   R.bkg_no        = D.bkg_no(+)" ).append("\n"); 
		query.append("		and   R.cntr_no       = D.cntr_no(+)" ).append("\n"); 
		query.append("		and   R.cntr_no       = o.cntr_no(+)" ).append("\n"); 
		query.append("		and   C.CNTR_TPSZ_CD  = t.CNTR_TPSZ_CD(+)" ).append("\n"); 
		query.append("		AND   BK.CMDT_CD      = COM.CMDT_CD(+)" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("		#if (${in_special_flag}	== 'AK') " ).append("\n"); 
		query.append("		AND   BK.BKG_NO       = A.BKG_NO(+)" ).append("\n"); 
		query.append("		and   A.bkg_no        = C.bkg_no(+)" ).append("\n"); 
		query.append("		and   A.cntr_no       = C.cntr_no(+)" ).append("\n"); 
		query.append("		and   A.bkg_no        = K.bkg_no(+)" ).append("\n"); 
		query.append("		and   A.cntr_no       = K.cntr_no(+)" ).append("\n"); 
		query.append("		and   A.bkg_no        = R.bkg_no(+)" ).append("\n"); 
		query.append("		and   A.cntr_no       = R.cntr_no(+)" ).append("\n"); 
		query.append("		and   A.bkg_no        = D.bkg_no(+)" ).append("\n"); 
		query.append("		and   A.cntr_no       = D.cntr_no(+)" ).append("\n"); 
		query.append("		and   A.cntr_no       = o.cntr_no(+)" ).append("\n"); 
		query.append("		and   C.CNTR_TPSZ_CD  = t.CNTR_TPSZ_CD(+)" ).append("\n"); 
		query.append("		AND   BK.CMDT_CD      = COM.CMDT_CD(+)" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("		#if (${in_special_flag}	== 'DG') " ).append("\n"); 
		query.append("		AND   BK.BKG_NO       = D.BKG_NO(+)" ).append("\n"); 
		query.append("		and   D.bkg_no        = C.bkg_no(+)" ).append("\n"); 
		query.append("		and   D.cntr_no       = C.cntr_no(+)" ).append("\n"); 
		query.append("		and   D.bkg_no        = K.bkg_no(+)" ).append("\n"); 
		query.append("		and   D.cntr_no       = K.cntr_no(+)" ).append("\n"); 
		query.append("		and   D.bkg_no        = R.bkg_no(+)" ).append("\n"); 
		query.append("		and   D.cntr_no       = R.cntr_no(+)" ).append("\n"); 
		query.append("		and   D.bkg_no        = A.bkg_no(+)" ).append("\n"); 
		query.append("		and   D.cntr_no       = A.cntr_no(+)" ).append("\n"); 
		query.append("		and   D.cntr_no       = o.cntr_no(+)" ).append("\n"); 
		query.append("		and   C.CNTR_TPSZ_CD  = t.CNTR_TPSZ_CD(+)" ).append("\n"); 
		query.append("		AND   BK.CMDT_CD      = COM.CMDT_CD(+)" ).append("\n"); 
		query.append("		#end" ).append("\n"); 

	}
}