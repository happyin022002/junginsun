/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : CsScreenDBDAOsearchPkupNtcNtfyInfoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.04.16
*@LastModifier : 
*@LastVersion : 1.0
* 2010.04.16 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.inbounddocumentation.csscreenmgt.csscreen.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CsScreenDBDAOsearchPkupNtcNtfyInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchPkupNtcNtfyInfo
	  * </pre>
	  */
	public CsScreenDBDAOsearchPkupNtcNtfyInfoRSQL(){
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
		params.put("bkg_cust_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.inbounddocumentation.csscreenmgt.csscreen.integration").append("\n"); 
		query.append("FileName : CsScreenDBDAOsearchPkupNtcNtfyInfoRSQL").append("\n"); 
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
		query.append("SELECT SUBQ.BKG_NO                                                              AS BKG_NO" ).append("\n"); 
		query.append("     , SUBQ.CNTR_NO                                                             AS CNTR_NO         -- 기존 Query에 준함" ).append("\n"); 
		query.append("     , DECODE(SUBQ.PKUP_NTC_TP_CD,'PP','Time','FC','F/O/C','TO','Trucker','MA') AS PKUP_NTC_TP_CD  -- 기존 Query에 준함" ).append("\n"); 
		query.append("     , SUBQ.PKUP_NTC_FOM_CD                                                     AS PKUP_NTC_FOM_CD -- 기존 Query에 준함" ).append("\n"); 
		query.append("     , SUBQ.FAX_NO1                                                             AS FAX_NO1         -- 기존 Query에 준함" ).append("\n"); 
		query.append("     , SUBQ.FAX_NO2                                                             AS FAX_NO2" ).append("\n"); 
		query.append("     , SUBQ.FAX_NO3                                                             AS FAX_NO3" ).append("\n"); 
		query.append("     , SUBQ.FAX_NO4                                                             AS FAX_NO4" ).append("\n"); 
		query.append("     , SUBQ.FAX_NO5                                                             AS FAX_NO5" ).append("\n"); 
		query.append("     , DECODE(NVL(SUBQ.FAX_SND_RSLT_CD1,'9'), '5', 'B', '6', 'R','9','X','P')   AS FAX_SND_RSLT_CD1 -- Arrival Notice Sent History와 같은 코드 사용할 시에 전송결과 코드 변환" ).append("\n"); 
		query.append("     , DECODE(NVL(SUBQ.FAX_SND_RSLT_CD2,'9'), '5', 'B', '6', 'R','9','X','P')   AS FAX_SND_RSLT_CD2 -- Arrival Notice Sent History와 같은 코드 사용할 시에 전송결과 코드 변환" ).append("\n"); 
		query.append("     , DECODE(NVL(SUBQ.FAX_SND_RSLT_CD3,'9'), '5', 'B', '6', 'R','9','X','P')   AS FAX_SND_RSLT_CD3 -- Arrival Notice Sent History와 같은 코드 사용할 시에 전송결과 코드 변환" ).append("\n"); 
		query.append("     , DECODE(NVL(SUBQ.FAX_SND_RSLT_CD4,'9'), '5', 'B', '6', 'R','9','X','P')   AS FAX_SND_RSLT_CD4 -- Arrival Notice Sent History와 같은 코드 사용할 시에 전송결과 코드 변환" ).append("\n"); 
		query.append("     , DECODE(NVL(SUBQ.FAX_SND_RSLT_CD5,'9'), '5', 'B', '6', 'R','9','X','P')   AS FAX_SND_RSLT_CD5 -- Arrival Notice Sent History와 같은 코드 사용할 시에 전송결과 코드 변환" ).append("\n"); 
		query.append("     , BKG_COM_INTG_CD_NM_FNC('CD00959', SUBQ.FAX_SND_RSLT_CD1 )                AS FAX_SND_RSLT_NM1  -- RD E-MAIL전송 상태" ).append("\n"); 
		query.append("     , BKG_COM_INTG_CD_NM_FNC('CD00959', SUBQ.FAX_SND_RSLT_CD2 )                AS FAX_SND_RSLT_NM2  -- RD E-MAIL전송 상태" ).append("\n"); 
		query.append("     , BKG_COM_INTG_CD_NM_FNC('CD00959', SUBQ.FAX_SND_RSLT_CD3 )                AS FAX_SND_RSLT_NM3  -- RD E-MAIL전송 상태" ).append("\n"); 
		query.append("     , BKG_COM_INTG_CD_NM_FNC('CD00959', SUBQ.FAX_SND_RSLT_CD4 )                AS FAX_SND_RSLT_NM4  -- RD E-MAIL전송 상태" ).append("\n"); 
		query.append("     , BKG_COM_INTG_CD_NM_FNC('CD00959', SUBQ.FAX_SND_RSLT_CD5 )                AS FAX_SND_RSLT_NM5  -- RD E-MAIL전송 상태" ).append("\n"); 
		query.append("     , TO_CHAR(SUBQ.FAX_SND_DT, 'YYYY-MM-DD HH24:MI')                           AS FAX_SND_DT     -- YYYY-MM-DD HH:MM" ).append("\n"); 
		query.append("     , TO_CHAR(SUBQ.FAX_SND_GDT,'YYYY-MM-DD HH24:MI')                           AS FAX_SND_GDT      " ).append("\n"); 
		query.append("     , SUBQ.NTC_EML1                                                            AS NTC_EML1  -- 기존 Query에 준함" ).append("\n"); 
		query.append("     , SUBQ.NTC_EML2                                                            AS NTC_EML2" ).append("\n"); 
		query.append("     , SUBQ.NTC_EML3                                                            AS NTC_EML3" ).append("\n"); 
		query.append("     , SUBQ.NTC_EML4                                                            AS NTC_EML4" ).append("\n"); 
		query.append("     , SUBQ.NTC_EML5                                                            AS NTC_EML5" ).append("\n"); 
		query.append("     , DECODE(NVL(SUBQ.EML_SND_RSLT_CD1,'9'), '3', 'B', '2', 'R', '9','X','P')  AS EML_SND_RSLT_CD1 -- Pickup Notice Sent History와 같은 코드 사용할 시에 전송결과 코드 변환" ).append("\n"); 
		query.append("     , DECODE(NVL(SUBQ.EML_SND_RSLT_CD2,'9'), '3', 'B', '2', 'R', '9','X','P')  AS EML_SND_RSLT_CD2 -- Pickup Notice Sent History와 같은 코드 사용할 시에 전송결과 코드 변환" ).append("\n"); 
		query.append("     , DECODE(NVL(SUBQ.EML_SND_RSLT_CD3,'9'), '3', 'B', '2', 'R', '9','X','P')  AS EML_SND_RSLT_CD3 -- Pickup Notice Sent History와 같은 코드 사용할 시에 전송결과 코드 변환" ).append("\n"); 
		query.append("     , DECODE(NVL(SUBQ.EML_SND_RSLT_CD4,'9'), '3', 'B', '2', 'R', '9','X','P')  AS EML_SND_RSLT_CD4 -- Pickup Notice Sent History와 같은 코드 사용할 시에 전송결과 코드 변환" ).append("\n"); 
		query.append("     , DECODE(NVL(SUBQ.EML_SND_RSLT_CD5,'9'), '3', 'B', '2', 'R', '9','X','P')  AS EML_SND_RSLT_CD5 -- Pickup Notice Sent History와 같은 코드 사용할 시에 전송결과 코드 변환" ).append("\n"); 
		query.append("     , BKG_COM_INTG_CD_NM_FNC('CD00960', SUBQ.EML_SND_RSLT_CD1 )                AS EML_SND_RSLT_NM1  -- RD E-MAIL전송 상태" ).append("\n"); 
		query.append("     , BKG_COM_INTG_CD_NM_FNC('CD00960', SUBQ.EML_SND_RSLT_CD2 )                AS EML_SND_RSLT_NM2  -- RD E-MAIL전송 상태" ).append("\n"); 
		query.append("     , BKG_COM_INTG_CD_NM_FNC('CD00960', SUBQ.EML_SND_RSLT_CD3 )                AS EML_SND_RSLT_NM3  -- RD E-MAIL전송 상태" ).append("\n"); 
		query.append("     , BKG_COM_INTG_CD_NM_FNC('CD00960', SUBQ.EML_SND_RSLT_CD4 )                AS EML_SND_RSLT_NM4  -- RD E-MAIL전송 상태" ).append("\n"); 
		query.append("     , BKG_COM_INTG_CD_NM_FNC('CD00960', SUBQ.EML_SND_RSLT_CD5 )                AS EML_SND_RSLT_NM5  -- RD E-MAIL전송 상태" ).append("\n"); 
		query.append("     , TO_CHAR(SUBQ.EML_SND_DT, 'YYYY-MM-DD HH24:MI')                           AS EML_SND_DT     -- YYYY-MM-DD HH:MM" ).append("\n"); 
		query.append("     , TO_CHAR(SUBQ.EML_SND_GDT,'YYYY-MM-DD HH24:MI')                           AS EML_SND_GDT      " ).append("\n"); 
		query.append("     , SUBQ.DIFF_RMK                                                            AS DIFF_RMK         -- 기존 Query에 준함" ).append("\n"); 
		query.append("     , DECODE(SUBQ.FAX_SND_ID,'BAT_BKG_015','Auto',SUBQ.FAX_SND_ID)             AS FAX_SND_ID" ).append("\n"); 
		query.append("     , DECODE(SUBQ.EML_SND_ID,'BAT_BKG_015','Auto',SUBQ.EML_SND_ID)             AS EML_SND_ID" ).append("\n"); 
		query.append("FROM " ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("    SELECT PNL.BKG_NO" ).append("\n"); 
		query.append("          ,PNL.CNTR_NO" ).append("\n"); 
		query.append("          ,MAX(PNL.PKUP_NTC_TP_CD)                                                                            AS PKUP_NTC_TP_CD" ).append("\n"); 
		query.append("          ,MAX(PNL.PKUP_NTC_FOM_CD)                                                                           AS PKUP_NTC_FOM_CD" ).append("\n"); 
		query.append("          ,MAX(DECODE(PND.CUST_CNTC_TP_CD, 'C1', PND.FAX_NO     , NULL))                                      AS FAX_NO1 " ).append("\n"); 
		query.append("          ,MAX(DECODE(PND.CUST_CNTC_TP_CD, 'C2', PND.FAX_NO     , NULL))                                      AS FAX_NO2" ).append("\n"); 
		query.append("          ,MAX(DECODE(PND.CUST_CNTC_TP_CD, 'B1', PND.FAX_NO     , NULL))                                      AS FAX_NO3" ).append("\n"); 
		query.append("          ,MAX(DECODE(PND.CUST_CNTC_TP_CD, 'B2', PND.FAX_NO     , NULL))                                      AS FAX_NO4" ).append("\n"); 
		query.append("          ,MAX(DECODE(PND.CUST_CNTC_TP_CD, 'AN', PND.FAX_NO     , NULL))                                      AS FAX_NO5" ).append("\n"); 
		query.append("          ,MAX(DECODE(PND.CUST_CNTC_TP_CD, 'C1', NVL(PND.FAX_NTC_SND_RSLT_CD, FXSD.FAX_PROC_STS_CD) , NULL))  AS FAX_SND_RSLT_CD1 " ).append("\n"); 
		query.append("          ,MAX(DECODE(PND.CUST_CNTC_TP_CD, 'C2', NVL(PND.FAX_NTC_SND_RSLT_CD, FXSD.FAX_PROC_STS_CD) , NULL))  AS FAX_SND_RSLT_CD2" ).append("\n"); 
		query.append("          ,MAX(DECODE(PND.CUST_CNTC_TP_CD, 'B1', NVL(PND.FAX_NTC_SND_RSLT_CD, FXSD.FAX_PROC_STS_CD) , NULL))  AS FAX_SND_RSLT_CD3" ).append("\n"); 
		query.append("          ,MAX(DECODE(PND.CUST_CNTC_TP_CD, 'B2', NVL(PND.FAX_NTC_SND_RSLT_CD, FXSD.FAX_PROC_STS_CD) , NULL))  AS FAX_SND_RSLT_CD4" ).append("\n"); 
		query.append("          ,MAX(DECODE(PND.CUST_CNTC_TP_CD, 'AN', NVL(PND.FAX_NTC_SND_RSLT_CD, FXSD.FAX_PROC_STS_CD) , NULL))  AS FAX_SND_RSLT_CD5" ).append("\n"); 
		query.append("          ,MAX(NVL(PND.FAX_SND_DT, FXSD.FAX_SND_LOCL_DT))                                                     AS FAX_SND_DT" ).append("\n"); 
		query.append("          ,MAX(NVL(PND.FAX_SND_GDT, GLOBALDATE_PKG.TIME_CONV_FNC( ( SELECT B.LOC_CD" ).append("\n"); 
		query.append("                                                                   FROM COM_USER A" ).append("\n"); 
		query.append("                                                                       ,MDM_ORGANIZATION B" ).append("\n"); 
		query.append("                                                                   WHERE A.USR_ID=PND.FAX_SND_USR_ID" ).append("\n"); 
		query.append("                                                                   AND   A.OFC_CD = B.OFC_CD ),FXSD.FAX_SND_LOCL_DT,'GMT' )))                                                             AS FAX_SND_GDT" ).append("\n"); 
		query.append("          ,MAX(PND.FAX_SND_USR_ID)                                                                            AS FAX_SND_ID" ).append("\n"); 
		query.append("          ,MAX(DECODE(PND.CUST_CNTC_TP_CD, 'C1', PND.NTC_EML     , NULL))                                     AS NTC_EML1 " ).append("\n"); 
		query.append("          ,MAX(DECODE(PND.CUST_CNTC_TP_CD, 'C2', PND.NTC_EML     , NULL))                                     AS NTC_EML2" ).append("\n"); 
		query.append("          ,MAX(DECODE(PND.CUST_CNTC_TP_CD, 'B1', PND.NTC_EML     , NULL))                                     AS NTC_EML3" ).append("\n"); 
		query.append("          ,MAX(DECODE(PND.CUST_CNTC_TP_CD, 'B2', PND.NTC_EML     , NULL))                                     AS NTC_EML4" ).append("\n"); 
		query.append("          ,MAX(DECODE(PND.CUST_CNTC_TP_CD, 'AN', PND.NTC_EML     , NULL))                                     AS NTC_EML5" ).append("\n"); 
		query.append("          ,MAX(DECODE(PND.CUST_CNTC_TP_CD, 'C1', NVL(PND.EML_NTC_SND_RSLT_CD, EMSD.EML_PROC_STS_CD) , NULL))  AS EML_SND_RSLT_CD1 " ).append("\n"); 
		query.append("          ,MAX(DECODE(PND.CUST_CNTC_TP_CD, 'C2', NVL(PND.EML_NTC_SND_RSLT_CD, EMSD.EML_PROC_STS_CD) , NULL))  AS EML_SND_RSLT_CD2" ).append("\n"); 
		query.append("          ,MAX(DECODE(PND.CUST_CNTC_TP_CD, 'B1', NVL(PND.EML_NTC_SND_RSLT_CD, EMSD.EML_PROC_STS_CD) , NULL))  AS EML_SND_RSLT_CD3" ).append("\n"); 
		query.append("          ,MAX(DECODE(PND.CUST_CNTC_TP_CD, 'B2', NVL(PND.EML_NTC_SND_RSLT_CD, EMSD.EML_PROC_STS_CD) , NULL))  AS EML_SND_RSLT_CD4" ).append("\n"); 
		query.append("          ,MAX(DECODE(PND.CUST_CNTC_TP_CD, 'AN', NVL(PND.EML_NTC_SND_RSLT_CD, EMSD.EML_PROC_STS_CD) , NULL))  AS EML_SND_RSLT_CD5" ).append("\n"); 
		query.append("          ,MAX(NVL(PND.EML_SND_DT, EMSD.EML_DT))                                                              AS EML_SND_DT" ).append("\n"); 
		query.append("          ,MAX(NVL(PND.EML_SND_GDT, EMSD.EML_DT))                                                             AS EML_SND_GDT" ).append("\n"); 
		query.append("          ,MAX(PND.EML_SND_USR_ID)                                                                            AS EML_SND_ID" ).append("\n"); 
		query.append("          ,MAX(PNL.DIFF_RMK)                                                                                  AS DIFF_RMK" ).append("\n"); 
		query.append("    FROM (" ).append("\n"); 
		query.append("          SELECT BPN.BKG_NO           AS BKG_NO" ).append("\n"); 
		query.append("                ,BPN.CNTR_NO            AS CNTR_NO" ).append("\n"); 
		query.append("                ,BPN.NTC_SEQ          AS NTC_SEQ" ).append("\n"); 
		query.append("                ,BPN.BKG_CUST_TP_CD   AS BKG_CUST_TP_CD  " ).append("\n"); 
		query.append("                ,BPN.PKUP_NTC_TP_CD   AS PKUP_NTC_TP_CD" ).append("\n"); 
		query.append("                ,BPN.PKUP_NTC_FOM_CD  AS PKUP_NTC_FOM_CD" ).append("\n"); 
		query.append("                ,BPN.DIFF_RMK         AS DIFF_RMK" ).append("\n"); 
		query.append("                ,ROW_NUMBER() OVER (PARTITION BY BPN.BKG_NO, BPN.CNTR_NO ORDER BY NTC_SEQ DESC) AS ROW_NUM" ).append("\n"); 
		query.append("           FROM BKG_PKUP_NTC            BPN" ).append("\n"); 
		query.append("           WHERE BPN.BKG_NO              = @[bkg_no]   --'HKGZ1080240' " ).append("\n"); 
		query.append("             AND BPN.PKUP_NTC_TP_CD      <> 'TO'" ).append("\n"); 
		query.append("             AND BPN.PKUP_NTC_SND_STS_CD <> 'X'" ).append("\n"); 
		query.append("         )      PNL" ).append("\n"); 
		query.append("       , BKG_PKUP_NTC_DTL   PND" ).append("\n"); 
		query.append("       , COM_FAX_SND_INFO   FXSD" ).append("\n"); 
		query.append("       , COM_EML_SND_INFO   EMSD" ).append("\n"); 
		query.append("    WHERE PNL.ROW_NUM        = 1" ).append("\n"); 
		query.append("    AND   PNL.BKG_CUST_TP_CD = @[bkg_cust_tp_cd]   --'C' " ).append("\n"); 
		query.append("    AND   PND.BKG_NO(+)      = PNL.BKG_NO" ).append("\n"); 
		query.append("    AND   PND.NTC_SEQ(+)     = PNL.NTC_SEQ" ).append("\n"); 
		query.append("    AND   FXSD.FAX_SND_NO(+) = PND.FAX_NTC_SND_ID " ).append("\n"); 
		query.append("    AND   EMSD.EML_SND_NO(+) = PND.EML_NTC_SND_ID " ).append("\n"); 
		query.append("    GROUP BY PNL.BKG_NO,PNL.CNTR_NO" ).append("\n"); 
		query.append(") SUBQ" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 

	}
}