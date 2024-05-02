/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : VietnamManifestListDownloadDBDAOSearchCustomsBlInfoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.05.12
*@LastModifier : 
*@LastVersion : 1.0
* 2016.05.12 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.vietnam.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class VietnamManifestListDownloadDBDAOSearchCustomsBlInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 
	  * </pre>
	  */
	public VietnamManifestListDownloadDBDAOSearchCustomsBlInfoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("frm_port_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_vvd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.vietnam.integration").append("\n"); 
		query.append("FileName : VietnamManifestListDownloadDBDAOSearchCustomsBlInfoRSQL").append("\n"); 
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
		query.append("-- Header (S) -----------------------------------" ).append("\n"); 
		query.append("       NVL(MV.VSL_ENG_NM, '') AS VSL_NM," ).append("\n"); 
		query.append("       NVL(MV.CALL_SGN_NO, '') AS VSL_CALLSIGN," ).append("\n"); 
		query.append("       TO_CHAR(P.VPS_ETD_DT, 'YYYYMMDD') AS ETD," ).append("\n"); 
		query.append("       TO_CHAR(P.VPS_ETA_DT, 'YYYYMMDD') AS ETA," ).append("\n"); 
		query.append("-- Header (E) -----------------------------------" ).append("\n"); 
		query.append("-- Grid (S) -------------------------------------" ).append("\n"); 
		query.append("       ROWNUM AS SEQ," ).append("\n"); 
		query.append("       V.VSL_CD||V.SKD_VOY_NO||V.SKD_DIR_CD AS VVD," ).append("\n"); 
		query.append("       B.BL_NO," ).append("\n"); 
		query.append("       B.BKG_NO," ).append("\n"); 
		query.append("       BKG_SPCLCHAR_CONV_FNC(SUBSTR(CU.CUST_NM, 1, 35), 'Y') AS CUST_NM," ).append("\n"); 
		query.append("       C.CNTR_NO," ).append("\n"); 
		query.append("       C.CNTR_TPSZ_CD," ).append("\n"); 
		query.append("       'Sent' AS SF, --컬럼 생성 준비 중::,NVL2(BKG_CSTMS_VN_SND_LOG.MF_SND_DT,'Sent','Un-sent') SF  --Success/Fail => --Sent / Un-sent" ).append("\n"); 
		query.append("       NVL(B.RCV_TERM_CD||B.DE_TERM_CD, '') AS RD," ).append("\n"); 
		query.append("#if (${pol_gubun} == '1')" ).append("\n"); 
		query.append("       DECODE(B.POL_CD, V.POL_CD, 'L', 'T') AS LS, --Outbound 조건" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("       DECODE(B.POD_CD, V.POD_CD, 'L', 'T') AS LS, --Inbound 조건" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("       B.POR_CD AS B_POR," ).append("\n"); 
		query.append("       V.POL_CD AS V_POL," ).append("\n"); 
		query.append("       V.POD_CD AS V_POD," ).append("\n"); 
		query.append("       SUBSTR(V.POD_YD_CD, 6, 2) AS V_POD_CD," ).append("\n"); 
		query.append("       B.DEL_CD AS B_DEL," ).append("\n"); 
		query.append("       SUBSTR(B.DEL_NOD_CD, 6, 2) AS B_DEL_CD," ).append("\n"); 
		query.append("       C.CNTR_WGT AS ACT_WGT," ).append("\n"); 
		query.append("       SUM(CNTR_WGT) OVER (PARTITION BY C.CNTR_NO) AS ACT_WGT_SUM," ).append("\n"); 
		query.append("       C.WGT_UT_CD," ).append("\n"); 
		query.append("       C.MEAS_QTY," ).append("\n"); 
		query.append("       C.MEAS_UT_CD," ).append("\n"); 
		query.append("       C.PCK_QTY," ).append("\n"); 
		query.append("       C.PCK_TP_CD," ).append("\n"); 
		query.append("       R.FRT_TERM_CD AS FREIGHT," ).append("\n"); 
		query.append("       B.RD_CGO_FLG AS RF," ).append("\n"); 
		query.append("       CASE" ).append("\n"); 
		query.append("         WHEN B.DCGO_FLG = 'Y' OR B.RC_FLG = 'Y' OR B.AWK_CGO_FLG = 'Y' OR B.BB_CGO_FLG = 'Y' THEN 'Y'" ).append("\n"); 
		query.append("         ELSE 'N'" ).append("\n"); 
		query.append("       END AS DG," ).append("\n"); 
		query.append("       TO_CHAR(SYSDATE, 'YYYY/MM/DD') AS S_DATE,--컬럼 생성 준비 중::,NVL(BKG_CSTMS_VN_SND_LOG.MF_SND_DT,'') AS S_DATE" ).append("\n"); 
		query.append("-- Grid (E) -------------------------------------" ).append("\n"); 
		query.append("-- Tail:: Y 갯수만 Counting (S)------------------" ).append("\n"); 
		query.append("       DECODE(SUBSTR(C.CNTR_TPSZ_CD, 2, 1), '2', 'Y', '') AS TPSZ_20_CHK," ).append("\n"); 
		query.append("       CASE" ).append("\n"); 
		query.append("          WHEN SUBSTR(C.CNTR_TPSZ_CD, 2, 1) != '2' THEN 'Y'" ).append("\n"); 
		query.append("          ELSE ''" ).append("\n"); 
		query.append("       END AS TPSZ_40_CHK," ).append("\n"); 
		query.append("       NVL2(C.CNTR_TPSZ_CD, 'Y', '') AS TPSZ_TOT_CHK" ).append("\n"); 
		query.append("-- Tail:: Y 갯수만 Counting (E)------------------" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("  FROM BKG_VVD V," ).append("\n"); 
		query.append("       MDM_VSL_CNTR MV," ).append("\n"); 
		query.append("       VSK_VSL_PORT_SKD P," ).append("\n"); 
		query.append("       BKG_BOOKING B," ).append("\n"); 
		query.append("       BKG_CONTAINER C," ).append("\n"); 
		query.append("       BKG_RATE R," ).append("\n"); 
		query.append("       BKG_CUSTOMER CU" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(" WHERE 1 = 1" ).append("\n"); 
		query.append("   AND V.VSL_CD = SUBSTR(@[s_vvd], 1, 4)    --[vvd]" ).append("\n"); 
		query.append("   AND V.SKD_VOY_NO = SUBSTR(@[s_vvd], 5, 4)    --[vvd] HNMN0088E" ).append("\n"); 
		query.append("   AND V.SKD_DIR_CD = SUBSTR(@[s_vvd], 9, 1)    --[vvd]" ).append("\n"); 
		query.append("#if (${pol_gubun} == '1')" ).append("\n"); 
		query.append("   AND V.POL_CD = @[frm_port_cd]    --Mode=Outbound 조건" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("   AND V.POD_CD = @[frm_port_cd]    --Mode=Inbound 조건'VNSGN'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("   AND MV.VSL_CD = V.VSL_CD" ).append("\n"); 
		query.append("   AND P.VSL_CD = V.VSL_CD" ).append("\n"); 
		query.append("   AND P.SKD_VOY_NO = V.SKD_VOY_NO" ).append("\n"); 
		query.append("   AND P.SKD_DIR_CD = V.SKD_DIR_CD#if (${pol_gubun} == '1')" ).append("\n"); 
		query.append("   AND P.VPS_PORT_CD = V.POL_CD    --Mode=Outbound 조건" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("   AND P.VPS_PORT_CD = V.POD_CD    --Mode=Inbound 조건" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("   AND B.BKG_NO = V.BKG_NO" ).append("\n"); 
		query.append("   AND B.BKG_STS_CD <> 'X'" ).append("\n"); 
		query.append("   AND C.BKG_NO = B.BKG_NO" ).append("\n"); 
		query.append("   AND R.BKG_NO(+) = B.BKG_NO" ).append("\n"); 
		query.append("   AND B.BKG_NO = CU.BKG_NO(+)" ).append("\n"); 
		query.append("   AND CU.BKG_CUST_TP_CD(+) = 'C'" ).append("\n"); 
		query.append("   AND P.CLPT_IND_SEQ = '1'" ).append("\n"); 

	}
}