/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : Jp24ManifestListDownloadDBDAOSearchEdiAdvJpMarkDescRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.03.14
*@LastModifier : 
*@LastVersion : 1.0
* 2014.03.14 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.jp24.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class Jp24ManifestListDownloadDBDAOSearchEdiAdvJpMarkDescRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 
	  * </pre>
	  */
	public Jp24ManifestListDownloadDBDAOSearchEdiAdvJpMarkDescRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bl_split_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bl_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.jp24.integration").append("\n"); 
		query.append("FileName : Jp24ManifestListDownloadDBDAOSearchEdiAdvJpMarkDescRSQL").append("\n"); 
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
		query.append("SELECT --59 품명" ).append("\n"); 
		query.append("        RPAD(DECODE(TRIM(DBMS_LOB.SUBSTR(MK.BL_DESC||C.CMDT_NM, 350, 1)), 'N/M', MK.BL_DESC, NVL(BKG_SPCLCHAR_CONV_FNC(MK.BL_DESC||C.CMDT_NM, 'J'), 'N/M')), 350, ' ') AS DATA00," ).append("\n"); 
		query.append("       --60 대표품목번호" ).append("\n"); 
		query.append("       RPAD(NVL(MK.CMDT_HS_CD, ' '), 6, ' ') AS DATA01," ).append("\n"); 
		query.append("       --61 기호번호" ).append("\n"); 
		query.append("--       RPAD(BKG_SPCLCHAR_CONV_FNC(NVL(SUBSTR(MK.DIFF_RMK, 1, 140), ' '), 'J'), 140, ' ') AS DATA02," ).append("\n"); 
		query.append("       RPAD(DECODE(TRIM(DBMS_LOB.SUBSTR(MK.DIFF_RMK, 140, 1)), 'N/M', 'NO MARK', '.', 'NO MARK', '..', 'NO MARK', '...', 'NO MARK', BKG_SPCLCHAR_CONV_FNC(MK.DIFF_RMK, 'J')), 140, ' ') AS DATA02," ).append("\n"); 
		query.append("       --62 갯수" ).append("\n"); 
		query.append("       --LPAD(NVL(A.PCK_QTY, 0), 8, ' ') AS DATA03," ).append("\n"); 
		query.append("       LPAD(CASE WHEN TO_CHAR(NVL(A.PCK_QTY, 0), '999999') < 0.99999 THEN '1' ELSE TO_CHAR(NVL(A.PCK_QTY, 0), '9999999') END , 8, ' ') AS DATA03," ).append("\n"); 
		query.append("       --63 갯수 단위코드" ).append("\n"); 
		query.append("       RPAD(DECODE(P.JP_CSTMS_PCK_CD, NULL, 'ZZ', P.JP_CSTMS_PCK_CD), 3, ' ') AS DATA04," ).append("\n"); 
		query.append("       --64 총중량" ).append("\n"); 
		query.append("--       LPAD(DECODE(NVL(A.GRS_WGT, 0), 0, 0, SUBSTR(TO_CHAR(NVL(A.GRS_WGT, 0), '0999999.999'), 2)), 10, ' ') AS DATA05," ).append("\n"); 
		query.append("       LPAD(TO_CHAR(NVL(A.GRS_WGT, 0), 'FM999990.000'), 10, ' ') AS DATA05," ).append("\n"); 
		query.append("       --65 중량단위코드" ).append("\n"); 
		query.append("       DECODE(NVL(A.WGT_UT_CD, 'KGS'), 'LBS', 'LBR', 'KGS', 'KGM', A.WGT_UT_CD) AS DATA06," ).append("\n"); 
		query.append("       --66 Net 중량" ).append("\n"); 
		query.append("--       LPAD(DECODE(NVL(A.NET_WGT, 0), 0, 0, SUBSTR(TO_CHAR(NVL(A.NET_WGT, 0), '0999999.999'), 2)), 10, ' ') AS DATA07," ).append("\n"); 
		query.append("       RPAD(' ', 10, ' ') AS DATA07," ).append("\n"); 
		query.append("       --67 Net 중량단위 코드" ).append("\n"); 
		query.append("--       DECODE(NVL(A.WGT_UT_CD, 'KGS'), 'LBS', 'LBR', 'KGS', 'KGM', A.WGT_UT_CD ) AS DATA08," ).append("\n"); 
		query.append("       RPAD(' ', 3, ' ') AS DATA08," ).append("\n"); 
		query.append("       --68 용적" ).append("\n"); 
		query.append("--       LPAD(DECODE(NVL(A.MEAS_QTY, 0), 0, 0, SUBSTR(TO_CHAR(NVL(A.MEAS_QTY, 0), '0999999.999'), 2)), 10, ' ') AS DATA09," ).append("\n"); 
		query.append("       LPAD(TO_CHAR(NVL(A.MEAS_QTY, 0), 'FM999990.000'), 10, ' ') AS DATA09," ).append("\n"); 
		query.append("       --69 용적단위코드" ).append("\n"); 
		query.append("       DECODE(NVL(A.MEAS_UT_CD, 'CBM'), 'CMF', 'FTQ', 'MTQ') AS DATA10," ).append("\n"); 
		query.append("       --70 원산국 코드" ).append("\n"); 
		query.append("       RPAD(' ', 2, ' ') AS DATA11," ).append("\n"); 
		query.append("       --71 위험화물코드" ).append("\n"); 
		query.append("       RPAD(' ', 3, ' ') AS DATA12," ).append("\n"); 
		query.append("       --72 IMDG Class" ).append("\n"); 
		query.append("       RPAD(NVL(A.IMDG_CLSS_CD, ' '), 4, ' ') AS DATA13," ).append("\n"); 
		query.append("       --73 UN No" ).append("\n"); 
		query.append("       RPAD(NVL(A.IMDG_UN_NO, ' '), 4, ' ') AS DATA14," ).append("\n"); 
		query.append("       --74 해상운임(Freight)" ).append("\n"); 
		query.append("       RPAD(' ', 18, ' ') AS DATA15," ).append("\n"); 
		query.append("       --75 해상운임통화종별코드" ).append("\n"); 
		query.append("       RPAD(' ', 3, ' ') AS DATA16," ).append("\n"); 
		query.append("       --76 가격" ).append("\n"); 
		query.append("       RPAD(' ', 18, ' ') AS DATA17," ).append("\n"); 
		query.append("       --77 가격통화종별코드" ).append("\n"); 
		query.append("       RPAD(' ', 3, ' ') AS DATA18," ).append("\n"); 
		query.append("       --78 포괄 보세 운송 승인 번호" ).append("\n"); 
		query.append("       RPAD(' ', 11, ' ') AS DATA19," ).append("\n"); 
		query.append("       --79 가양육식별" ).append("\n"); 
		query.append("       DECODE(NVL(A.LOCL_TS_IND_CD, 'L'), 'T', '28 ', '   ') AS DATA20," ).append("\n"); 
		query.append("       --80 가양육사유코드" ).append("\n"); 
		query.append("       DECODE(NVL(A.LOCL_TS_IND_CD, ' '), 'T', NVL(A.JP_CSTMS_TRNS_CD, ' '), '   ') AS DATA21," ).append("\n"); 
		query.append("       --81 가양육기간" ).append("\n"); 
		query.append("       DECODE(NVL(A.LOCL_TS_IND_CD, ' '), 'T', SUBSTR(TO_CHAR(NVL(A.LMT_NO, 0), '99'), 2), '  ') AS DATA22," ).append("\n"); 
		query.append("       --82 운송 기간시작 예정일  (8)   C" ).append("\n"); 
		query.append("       RPAD(' ', 8, ' ') AS DATA23," ).append("\n"); 
		query.append("       --83 운송 기간종료 예정일  (8)   C" ).append("\n"); 
		query.append("       RPAD(' ', 8, ' ') AS DATA24," ).append("\n"); 
		query.append("       --84 개별운송 또는 가양육 화물보세 운송의 운송 도구 코드  (2)   C" ).append("\n"); 
		query.append("       RPAD(' ', 2, ' ') AS DATA25," ).append("\n"); 
		query.append("       --85 도착지코드  (5)   C" ).append("\n"); 
		query.append("       RPAD(' ', 5, ' ') AS DATA26," ).append("\n"); 
		query.append("       --86 도착지명  (35)   C" ).append("\n"); 
		query.append("       RPAD(' ', 35, ' ') AS DATA27," ).append("\n"); 
		query.append("       --87 타법령 코드  (2)   (반복5)   C" ).append("\n"); 
		query.append("       RPAD(' ', 2, ' ') AS DATA28," ).append("\n"); 
		query.append("       --87 타법령 코드  (2)   (반복5)   C" ).append("\n"); 
		query.append("       RPAD(' ', 2, ' ') AS DATA29," ).append("\n"); 
		query.append("       --87 타법령 코드  (2)   (반복5)   C" ).append("\n"); 
		query.append("       RPAD(' ', 2, ' ') AS DATA30," ).append("\n"); 
		query.append("       --87 타법령 코드  (2)   (반복5)   C" ).append("\n"); 
		query.append("       RPAD(' ', 2, ' ') AS DATA31," ).append("\n"); 
		query.append("       --87 타법령 코드  (2)   (반복5)   C" ).append("\n"); 
		query.append("       RPAD(' ', 2, ' ') AS DATA32," ).append("\n"); 
		query.append("       --88 Remark  (140)   C" ).append("\n"); 
		query.append("       RPAD(' ', 140, ' ') AS DATA33," ).append("\n"); 
		query.append("       --89 Remark  (140)   C" ).append("\n"); 
		query.append("       RPAD(' ', 20, ' ') AS DATA34" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("  FROM BKG_CSTMS_ADV_JP_BL A," ).append("\n"); 
		query.append("       BKG_CSTMS_ADV_JP_MK MK," ).append("\n"); 
		query.append("       MDM_PCK_TP P," ).append("\n"); 
		query.append("       MDM_COMMODITY C" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(" WHERE A.BL_NO = @[bl_no]" ).append("\n"); 
		query.append("   AND A.BL_SPLIT_NO = NVL(@[bl_split_no], '  ')" ).append("\n"); 
		query.append("   AND A.BL_NO = MK.BL_NO" ).append("\n"); 
		query.append("   AND A.BL_SPLIT_NO = MK.BL_SPLIT_NO" ).append("\n"); 
		query.append("   AND A.PCK_TP_CD = P.PCK_CD(+)" ).append("\n"); 
		query.append("   AND A.CMDT_CD = C.CMDT_CD(+)" ).append("\n"); 

	}
}