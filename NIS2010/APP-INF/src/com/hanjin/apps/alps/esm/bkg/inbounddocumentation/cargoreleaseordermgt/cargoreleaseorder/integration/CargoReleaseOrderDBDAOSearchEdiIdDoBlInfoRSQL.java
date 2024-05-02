/*=========================================================
*Copyright(c) 2018 SM Line
*@FileName : CargoReleaseOrderDBDAOSearchEdiIdDoBlInfoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2018.05.02
*@LastModifier : 
*@LastVersion : 1.0
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CargoReleaseOrderDBDAOSearchEdiIdDoBlInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Indonesia SUBBA Do Reference 정보 조회
	  * </pre>
	  */
	public CargoReleaseOrderDBDAOSearchEdiIdDoBlInfoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("event_tp",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.integration").append("\n"); 
		query.append("FileName : CargoReleaseOrderDBDAOSearchEdiIdDoBlInfoRSQL").append("\n"); 
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
		query.append("     ||'BL_NO:'          || NVL(BKGM.BL_NO,' ')                                                                              || CHR(10)" ).append("\n"); 
		query.append("     || 'MSG_FUNC:'      || DECODE(@[event_tp], 'RL', 'N', 'AT', 'U', 'CC', 'C') || CHR(10)" ).append("\n"); 
		query.append("     || 'DO_NBR:'        || BDO.DO_NO||BDO.DO_NO_SPLIT || CHR(10)" ).append("\n"); 
		query.append("     || 'MRN_NBR:'       || CHR(10)" ).append("\n"); 
		query.append("     || 'MSN_NBR:'       || CHR(10)" ).append("\n"); 
		query.append("     || 'VVD:'           || BVVD.VSL_CD||BVVD.SKD_VOY_NO||BVVD.SKD_DIR_CD                                                    || CHR(10)" ).append("\n"); 
		query.append("     || 'VSL_CALLSIGN:'  || VSL.CALL_SGN_NO                                                                                  || CHR(10)" ).append("\n"); 
		query.append("     || 'VSL_FULLNAME:'  || VSL.VSL_ENG_NM                                                                                   || CHR(10)" ).append("\n"); 
		query.append("     || 'FINAL_DEST:'    || BKGM.DEL_CD                                                                                      || CHR(10)" ).append("\n"); 
		query.append("     || 'FINAL_DESTNAME:'|| DEL.LOC_NM||'  '||CNT1.CNT_NM                                                                    || CHR(10)" ).append("\n"); 
		query.append("     || 'DO_DATE:'       || NVL(TO_CHAR(DTL.EVNT_DT,'YYYYMMDD'),' ')                                                         || CHR(10)" ).append("\n"); 
		query.append("     /* 최소 냉동일 기준 5일  변경 6 > 5일로변경 2014.08.13 */" ).append("\n"); 
		query.append("     || 'BL_DMIF_END_DT:'|| NVL(( SELECT TO_CHAR(MIN(VPS_ETA_DT) + 5,'YYYYMMDD') /* ETA  eta데이트를 실제 배가 도착하면 업데이트 함 */" ).append("\n"); 
		query.append("                                  FROM BKG_BOOKING BKG" ).append("\n"); 
		query.append("                                     ,VSK_VSL_PORT_SKD VSKD" ).append("\n"); 
		query.append("                                     ,BKG_VVD VVD" ).append("\n"); 
		query.append("                                 WHERE 1=1" ).append("\n"); 
		query.append("                                   AND BKG.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("                                   AND BKG.BKG_NO = VVD.BKG_NO" ).append("\n"); 
		query.append("                                   AND BKG.POD_CD = VVD.POD_CD" ).append("\n"); 
		query.append("                                   AND VVD.VSL_PRE_PST_CD IN ('T','U')" ).append("\n"); 
		query.append("                                   AND VVD.VSL_CD = VSKD.VSL_CD" ).append("\n"); 
		query.append("                                   AND VVD.SKD_VOY_NO = VSKD.SKD_VOY_NO" ).append("\n"); 
		query.append("                                   AND VVD.SKD_DIR_CD = VSKD.SKD_DIR_CD" ).append("\n"); 
		query.append("                                   AND VVD.POD_CD = VSKD.VPS_PORT_CD" ).append("\n"); 
		query.append("                                   AND VVD.POD_CLPT_IND_SEQ = VSKD.CLPT_IND_SEQ" ).append("\n"); 
		query.append("                                ),' ')                                                                                       || CHR(10)" ).append("\n"); 
		query.append("     || 'DEMU_FROM:'     || NVL(TO_CHAR(NULL,'YYYYMMDDHHMM'),' ')                                                            || CHR(10)" ).append("\n"); 
		query.append("     || 'DEMU_TO:'       || NVL(TO_CHAR(NULL,'YYYYMMDDHHMM'),' ')                                                            || CHR(10)" ).append("\n"); 
		query.append("     || 'SHPR_CD:'       || SH.CUST_CNT_CD || SH.CUST_SEQ                                                                    || CHR(10)" ).append("\n"); 
		query.append("     || 'SHPR_NAME1:'    || BKG_SPCLCHAR_CONV_FNC(SCE_TOKEN_NL_FNC(SH.CUST_NM,   1),'Y')                                     || CHR(10)" ).append("\n"); 
		query.append("     || 'SHPR_NAME2:'    || BKG_SPCLCHAR_CONV_FNC(SCE_TOKEN_NL_FNC(SH.CUST_NM,   2),'Y')                                     || CHR(10)" ).append("\n"); 
		query.append("     || 'SHPR_NAME3:'    || BKG_SPCLCHAR_CONV_FNC(DECODE(SH.ADDR_PRN_FLG, 'Y', SCE_TOKEN_NL_FNC(SH.CUST_ADDR, 1), ''),'Y')   || CHR(10)" ).append("\n"); 
		query.append("     || 'SHPR_NAME4:'    || BKG_SPCLCHAR_CONV_FNC(DECODE(SH.ADDR_PRN_FLG, 'Y', SCE_TOKEN_NL_FNC(SH.CUST_ADDR, 2), ''),'Y')   || CHR(10)" ).append("\n"); 
		query.append("     || 'SHPR_NAME5:'    || BKG_SPCLCHAR_CONV_FNC(DECODE(SH.ADDR_PRN_FLG, 'Y', SCE_TOKEN_NL_FNC(SH.CUST_ADDR, 3), ''),'Y')   || CHR(10)" ).append("\n"); 
		query.append("     || 'CNEE_CD:'       || CN.CUST_CNT_CD || CN.CUST_SEQ                                                                    || CHR(10)" ).append("\n"); 
		query.append("     || 'CNEE_NAME1:'    || BKG_SPCLCHAR_CONV_FNC(SCE_TOKEN_NL_FNC(CN.CUST_NM,   1),'Y')                                     || CHR(10)" ).append("\n"); 
		query.append("     || 'CNEE_NAME2:'    || BKG_SPCLCHAR_CONV_FNC(SCE_TOKEN_NL_FNC(CN.CUST_NM,   2),'Y')                                     || CHR(10)" ).append("\n"); 
		query.append("     || 'CNEE_NAME3:'    || BKG_SPCLCHAR_CONV_FNC(SCE_TOKEN_NL_FNC(REPLACE(REPLACE(CN.CUST_ADDR,CHR(10),CHR(13)||' '),CHR(13)||CHR(13),CHR(13)),1),'Y') || CHR(10)" ).append("\n"); 
		query.append("     || 'CNEE_NAME4:'    || BKG_SPCLCHAR_CONV_FNC(SCE_TOKEN_NL_FNC(REPLACE(REPLACE(CN.CUST_ADDR,CHR(10),CHR(13)||' '),CHR(13)||CHR(13),CHR(13)),2),'Y') || CHR(10)" ).append("\n"); 
		query.append("     || 'CNEE_NAME5:'    || BKG_SPCLCHAR_CONV_FNC(SCE_TOKEN_NL_FNC(REPLACE(REPLACE(CN.CUST_ADDR,CHR(10),CHR(13)||' '),CHR(13)||CHR(13),CHR(13)),3),'Y') || CHR(10)" ).append("\n"); 
		query.append("     || 'CNEE_REG_NO:'   || NVL(BDO.RCVR_BIZ_NO,'')                                                                          || CHR(10) /* 2007.06.11 */" ).append("\n"); 
		query.append("     || 'NTFY_CD:'       || NF.CUST_CNT_CD || NF.CUST_SEQ                                                                    || CHR(10)" ).append("\n"); 
		query.append("     || 'NTFY_NAME1:'    || BKG_SPCLCHAR_CONV_FNC(SCE_TOKEN_NL_FNC(NF.CUST_NM, 1),'Y')                                       || CHR(10)" ).append("\n"); 
		query.append("     || 'NTFY_NAME2:'    || BKG_SPCLCHAR_CONV_FNC(SCE_TOKEN_NL_FNC(NF.CUST_NM, 2),'Y')                                       || CHR(10)" ).append("\n"); 
		query.append("     || 'NTFY_FAX_NO:'   || NF.CUST_FAX_NO                                                                                   || CHR(10)" ).append("\n"); 
		query.append("     || 'SELF_TRANS:'    || BDO.SELF_TRNS_FLG                                                                                || CHR(10)" ).append("\n"); 
		query.append("     || 'MSN_DISCLOC:'   || CHR(10)" ).append("\n"); 
		query.append("     || 'POD_LOC:'       || BKGM.POD_CD                                                                                      || CHR(10)" ).append("\n"); 
		query.append("     || 'POD_NAME:'      || POD.LOC_NM||'  '||CNT2.CNT_NM                                                                    || CHR(10)  " ).append("\n"); 
		query.append("     /* (주)한진 요청으로 KLNET으로  CUSTOMS_DESCRIPTION 전송 2015.04.08 */" ).append("\n"); 
		query.append("     || 'CUSTOMS_DESCRIPTION:'|| (SELECT BD.CSTMS_DESC FROM   BKG_BL_DOC BD WHERE  BD.BKG_NO = BKGM.BKG_NO)                  || CHR(10)  " ).append("\n"); 
		query.append("	 || 'SOC:'   			 || NVL(BKGM.SOC_FLG, 'N') || CHR(10) " ).append("\n"); 
		query.append("	 || 'PIN_NO:' || BDO.DO_PIN_NO || CHR(10)" ).append("\n"); 
		query.append("  FROM BKG_BOOKING BKGM" ).append("\n"); 
		query.append("     , BKG_DO BDO" ).append("\n"); 
		query.append("     , BKG_DO_DTL DTL" ).append("\n"); 
		query.append("     , BKG_VVD BVVD" ).append("\n"); 
		query.append("     , MDM_VSL_CNTR VSL" ).append("\n"); 
		query.append("     , MDM_LOCATION DEL" ).append("\n"); 
		query.append("     , MDM_COUNTRY  CNT1" ).append("\n"); 
		query.append("     , BKG_CUSTOMER SH" ).append("\n"); 
		query.append("     , BKG_CUSTOMER CN" ).append("\n"); 
		query.append("     , BKG_CUSTOMER NF" ).append("\n"); 
		query.append("     , MDM_LOCATION POD" ).append("\n"); 
		query.append("     , MDM_COUNTRY  CNT2" ).append("\n"); 
		query.append(" WHERE BKGM.BKG_NO         = @[bkg_no]" ).append("\n"); 
		query.append("   AND BKGM.BKG_NO         = BDO.BKG_NO(+)" ).append("\n"); 
		query.append("   AND BDO.BKG_NO          = DTL.BKG_NO(+)" ).append("\n"); 
		query.append("   AND BDO.RLSE_SEQ        = DTL.RLSE_SEQ(+)" ).append("\n"); 
		query.append("   AND DTL.RLSE_STS_CD(+)  = 'R'" ).append("\n"); 
		query.append("   AND BVVD.BKG_NO         = BKGM.BKG_NO" ).append("\n"); 
		query.append("   AND BVVD.POD_CD         = BKGM.POD_CD" ).append("\n"); 
		query.append("   AND BVVD.VSL_PRE_PST_CD IN ('T','U')" ).append("\n"); 
		query.append("   AND BVVD.VSL_SEQ         = ( SELECT MAX(VSL_SEQ) " ).append("\n"); 
		query.append("                                FROM BKG_VVD BVVD2" ).append("\n"); 
		query.append("                               WHERE BVVD2.BKG_NO = BKGM.BKG_NO " ).append("\n"); 
		query.append("                                 AND BVVD2.VSL_PRE_PST_CD IN ('T', 'U') " ).append("\n"); 
		query.append("                                 AND BVVD2.POD_CD = BKGM.POD_CD  ) " ).append("\n"); 
		query.append("   AND BVVD.VSL_CD         = VSL.VSL_CD(+)" ).append("\n"); 
		query.append("   AND BKGM.DEL_CD         = DEL.LOC_CD(+)" ).append("\n"); 
		query.append("   AND DEL.CNT_CD          = CNT1.CNT_CD(+)" ).append("\n"); 
		query.append("   AND BKGM.BKG_NO         = SH.BKG_NO(+)" ).append("\n"); 
		query.append("   AND SH.BKG_CUST_TP_CD   = 'S'" ).append("\n"); 
		query.append("   AND BKGM.BKG_NO         = CN.BKG_NO(+)" ).append("\n"); 
		query.append("   AND CN.BKG_CUST_TP_CD   = 'C'" ).append("\n"); 
		query.append("   AND BKGM.BKG_NO         = NF.BKG_NO(+)" ).append("\n"); 
		query.append("   AND NF.BKG_CUST_TP_CD   = 'N'" ).append("\n"); 
		query.append("   AND BKGM.POD_CD         = POD.LOC_CD(+)" ).append("\n"); 
		query.append("   AND POD.CNT_CD          = CNT2.CNT_CD(+)" ).append("\n"); 

	}
}