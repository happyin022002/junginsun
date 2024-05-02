/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : CargoReleaseOrderDBDAOSearchEdiKorDoBlInfoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.12.03
*@LastModifier : 
*@LastVersion : 1.0
* 2014.12.03 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CargoReleaseOrderDBDAOSearchEdiKorDoBlInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Do Reference 정보 조회
	  * </pre>
	  */
	public CargoReleaseOrderDBDAOSearchEdiKorDoBlInfoRSQL(){
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
		params.put("do_type",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.integration").append("\n"); 
		query.append("FileName : CargoReleaseOrderDBDAOSearchEdiKorDoBlInfoRSQL").append("\n"); 
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
		query.append("SELECT CHR(10)" ).append("\n"); 
		query.append("    ||'BL_NO:'          || NVL(BKGM.BL_NO,' ')                                                                              || CHR(10)" ).append("\n"); 
		query.append("    || 'MSG_FUNC:'      || DECODE(@[do_type],'KDC','C','N')                                                                 || CHR(10)" ).append("\n"); 
		query.append("    || 'DO_NBR:'        || DECODE(@[do_type],'KDL', NVL(BDO.DO_NO||BDO.DO_NO_SPLIT,'NONDO'), BDO.DO_NO||BDO.DO_NO_SPLIT )   || CHR(10)" ).append("\n"); 
		query.append("    || 'MRN_NBR:'       || MSN.MF_REF_NO||MSN.MRN_CHK_NO                                                                    || CHR(10)" ).append("\n"); 
		query.append("    || 'MSN_NBR:'       || MSN.MF_SEQ_NO                                                                                    || CHR(10)" ).append("\n"); 
		query.append("    || 'VVD:'           || BVVD.VSL_CD||BVVD.SKD_VOY_NO||BVVD.SKD_DIR_CD                                                    || CHR(10)" ).append("\n"); 
		query.append("    || 'VSL_CALLSIGN:'  || VSL.CALL_SGN_NO                                                                                  || CHR(10)" ).append("\n"); 
		query.append("    || 'VSL_FULLNAME:'  || VSL.VSL_ENG_NM                                                                                   || CHR(10)" ).append("\n"); 
		query.append("    || 'FINAL_DEST:'    || BKGM.DEL_CD                                                                                      || CHR(10)" ).append("\n"); 
		query.append("    || 'FINAL_DESTNAME:'|| DEL.LOC_NM||'  '||CNT1.CNT_NM                                                                    || CHR(10)" ).append("\n"); 
		query.append("    || 'DO_DATE:'       || NVL(TO_CHAR(DTL.EVNT_DT,'YYYYMMDD'),' ')                                                         || CHR(10)" ).append("\n"); 
		query.append("    || 'DEMU_FROM:'     || NVL(TO_CHAR(NULL,'YYYYMMDDHHMM'),' ')                                                            || CHR(10)" ).append("\n"); 
		query.append("    || 'DEMU_TO:'       || NVL(TO_CHAR(NULL,'YYYYMMDDHHMM'),' ')                                                            || CHR(10)" ).append("\n"); 
		query.append("    || 'SHPR_CD:'       || SH.CUST_CNT_CD || SH.CUST_SEQ                                                                    || CHR(10)" ).append("\n"); 
		query.append("    || 'SHPR_NAME1:'    || BKG_TOKEN_NL_FNC(SH.CUST_NM,   1, '')                                                            || CHR(10)" ).append("\n"); 
		query.append("    || 'SHPR_NAME2:'    || BKG_TOKEN_NL_FNC(SH.CUST_NM,   2, '')                                                            || CHR(10)" ).append("\n"); 
		query.append("    || 'SHPR_NAME3:'    || DECODE(SH.ADDR_PRN_FLG, 'Y', BKG_TOKEN_NL_FNC(SH.CUST_ADDR, 1, ''), '')                          || CHR(10)" ).append("\n"); 
		query.append("    || 'SHPR_NAME4:'    || DECODE(SH.ADDR_PRN_FLG, 'Y', BKG_TOKEN_NL_FNC(SH.CUST_ADDR, 2, ''), '')                          || CHR(10)" ).append("\n"); 
		query.append("    || 'SHPR_NAME5:'    || DECODE(SH.ADDR_PRN_FLG, 'Y', BKG_TOKEN_NL_FNC(SH.CUST_ADDR, 3, ''), '')                          || CHR(10)" ).append("\n"); 
		query.append("    || 'CNEE_CD:'       || CN.CUST_CNT_CD || CN.CUST_SEQ                                                                    || CHR(10)" ).append("\n"); 
		query.append("    || 'CNEE_NAME1:'    || BKG_TOKEN_NL_FNC(CN.CUST_NM,   1, '')                                                            || CHR(10)" ).append("\n"); 
		query.append("    || 'CNEE_NAME2:'    || BKG_TOKEN_NL_FNC(CN.CUST_NM,   2, '')                                                            || CHR(10)" ).append("\n"); 
		query.append("    || 'CNEE_NAME3:'    || BKG_TOKEN_NL_FNC(REPLACE(REPLACE(CN.CUST_ADDR,CHR(10),CHR(13)||' '),CHR(13)||CHR(13),CHR(13)),1, '') || CHR(10)" ).append("\n"); 
		query.append("    || 'CNEE_NAME4:'    || BKG_TOKEN_NL_FNC(REPLACE(REPLACE(CN.CUST_ADDR,CHR(10),CHR(13)||' '),CHR(13)||CHR(13),CHR(13)),2, '') || CHR(10)" ).append("\n"); 
		query.append("    || 'CNEE_NAME5:'    || BKG_TOKEN_NL_FNC(REPLACE(REPLACE(CN.CUST_ADDR,CHR(10),CHR(13)||' '),CHR(13)||CHR(13),CHR(13)),3, '') || CHR(10)" ).append("\n"); 
		query.append("    || 'CNEE_REG_NO:'   || NVL(BDO.RCVR_BIZ_NO,'')                                                                          || CHR(10) /* 2007.06.11 */" ).append("\n"); 
		query.append("    || 'NTFY_CD:'       || NF.CUST_CNT_CD || NF.CUST_SEQ                                                                    || CHR(10)" ).append("\n"); 
		query.append("    || 'NTFY_NAME1:'    || BKG_TOKEN_NL_FNC(NF.CUST_NM, 1, '')                                                              || CHR(10)" ).append("\n"); 
		query.append("    || 'NTFY_NAME2:'    || BKG_TOKEN_NL_FNC(NF.CUST_NM, 2, '')                                                              || CHR(10)" ).append("\n"); 
		query.append("    || 'NTFY_FAX_NO:'   || NF.CUST_FAX_NO                                                                                   || CHR(10)" ).append("\n"); 
		query.append("    || 'SELF_TRANS:'    || BDO.SELF_TRNS_FLG                                                                                || CHR(10)" ).append("\n"); 
		query.append("    || 'MSN_DISCLOC:'   || MSN.CSTMS_DCHG_LOC_WH_CD                                                                         || CHR(10)" ).append("\n"); 
		query.append("    || 'POD_LOC:'       || BKGM.POD_CD                                                                                      || CHR(10)" ).append("\n"); 
		query.append("    || 'POD_NAME:'      || POD.LOC_NM||'  '||CNT2.CNT_NM                                                                    || CHR(10)" ).append("\n"); 
		query.append(" FROM BKG_BOOKING BKGM" ).append("\n"); 
		query.append("    , BKG_DO BDO" ).append("\n"); 
		query.append("    , BKG_DO_DTL DTL" ).append("\n"); 
		query.append("    , BKG_CSTMS_KR_MF_SEQ_NO MSN" ).append("\n"); 
		query.append("    , BKG_VVD BVVD" ).append("\n"); 
		query.append("    , MDM_VSL_CNTR VSL" ).append("\n"); 
		query.append("    , MDM_LOCATION DEL" ).append("\n"); 
		query.append("    , MDM_COUNTRY  CNT1" ).append("\n"); 
		query.append("    , BKG_CUSTOMER SH" ).append("\n"); 
		query.append("    , BKG_CUSTOMER CN" ).append("\n"); 
		query.append("    , BKG_CUSTOMER NF" ).append("\n"); 
		query.append("    , MDM_LOCATION POD" ).append("\n"); 
		query.append("    , MDM_COUNTRY  CNT2" ).append("\n"); 
		query.append("WHERE BKGM.BKG_NO         = @[bkg_no]" ).append("\n"); 
		query.append("  AND BKGM.BKG_NO         = BDO.BKG_NO(+)" ).append("\n"); 
		query.append("  AND BDO.BKG_NO          = DTL.BKG_NO(+)" ).append("\n"); 
		query.append("  AND BDO.RLSE_SEQ        = DTL.RLSE_SEQ(+)" ).append("\n"); 
		query.append("  AND DTL.RLSE_STS_CD(+)  = 'R'" ).append("\n"); 
		query.append("  AND MSN.BKG_NO          = BKGM.BKG_NO " ).append("\n"); 
		query.append("  AND MSN.MF_CFM_FLG      = 'Y'" ).append("\n"); 
		query.append("  AND MSN.MRN_BL_TS_CD    = 'I'" ).append("\n"); 
		query.append("  AND MSN.CFM_DT          = ( SELECT MAX(SEQ.CFM_DT) " ).append("\n"); 
		query.append("                              FROM BKG_CSTMS_KR_MF_SEQ_NO SEQ" ).append("\n"); 
		query.append("                              WHERE SEQ.BKG_NO        = @[bkg_no]" ).append("\n"); 
		query.append("                              AND   SEQ.MF_CFM_FLG    = 'Y'" ).append("\n"); 
		query.append("                              AND   SEQ.MRN_BL_TS_CD  = 'I' )  " ).append("\n"); 
		query.append("  AND BVVD.BKG_NO         = BKGM.BKG_NO" ).append("\n"); 
		query.append("  AND BVVD.POD_CD         = BKGM.POD_CD" ).append("\n"); 
		query.append("  AND BVVD.VSL_PRE_PST_CD IN ('T','U')" ).append("\n"); 
		query.append("  AND BVVD.VSL_CD         = VSL.VSL_CD(+)" ).append("\n"); 
		query.append("  AND BKGM.DEL_CD         = DEL.LOC_CD(+)" ).append("\n"); 
		query.append("  AND DEL.CNT_CD          = CNT1.CNT_CD(+)" ).append("\n"); 
		query.append("  AND BKGM.BKG_NO         = SH.BKG_NO(+)" ).append("\n"); 
		query.append("  AND SH.BKG_CUST_TP_CD   = 'S'" ).append("\n"); 
		query.append("  AND BKGM.BKG_NO         = CN.BKG_NO(+)" ).append("\n"); 
		query.append("  AND CN.BKG_CUST_TP_CD   = 'C'" ).append("\n"); 
		query.append("  AND BKGM.BKG_NO         = NF.BKG_NO(+)" ).append("\n"); 
		query.append("  AND NF.BKG_CUST_TP_CD   = 'N'" ).append("\n"); 
		query.append("  AND BKGM.POD_CD         = POD.LOC_CD(+)" ).append("\n"); 
		query.append("  AND POD.CNT_CD          = CNT2.CNT_CD(+)" ).append("\n"); 

	}
}