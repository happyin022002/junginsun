/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : UsaInbondTransmissionDBDAOsearchInbondArrivalManifestListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.09.05
*@LastModifier : 
*@LastVersion : 1.0
* 2016.09.05 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.inbondtransmission.usa.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class UsaInbondTransmissionDBDAOsearchInbondArrivalManifestListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * dwkim, 0533조회용
	  * </pre>
	  */
	public UsaInbondTransmissionDBDAOsearchInbondArrivalManifestListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("tod",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fromd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("arr_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eq_ofc",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("hub",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fromt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vvd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("tot",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ibd_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bl_cntr_gubun",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("bl_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("xpt_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("edi_error",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pod",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.customsdeclaration.inbondtransmission.usa.integration").append("\n"); 
		query.append("FileName : UsaInbondTransmissionDBDAOsearchInbondArrivalManifestListRSQL").append("\n"); 
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
		query.append("#if (${bl_cntr_gubun} != 'BL')" ).append("\n"); 
		query.append("SELECT A.CNTR_NO" ).append("\n"); 
		query.append("      ,A.BL_NO" ).append("\n"); 
		query.append("      ,A.VVD" ).append("\n"); 
		query.append("      ,A.DEL_CD" ).append("\n"); 
		query.append("      ,A.CSTMS_LOC_CD" ).append("\n"); 
		query.append("      ,A.IBD_TRSP_NO" ).append("\n"); 
		query.append("      ,A.IBD_TP_CD" ).append("\n"); 
		query.append("      ,NVL(A.ARR_DT, MAX(A.ARR_DT) OVER(PARTITION BY A.VVD,A.CNTR_NO ORDER BY A.VVD,A.CNTR_NO)) AS ARR_DT" ).append("\n"); 
		query.append("      ,A.TRSP_ISS_DT" ).append("\n"); 
		query.append("      ,NVL(A.ARR_TIME, MAX(A.ARR_TIME) OVER(PARTITION BY A.VVD,A.CNTR_NO ORDER BY A.VVD,A.CNTR_NO)) AS ARR_TIME" ).append("\n"); 
		query.append("      ,A.TRSP_ISS_TIME" ).append("\n"); 
		query.append("      ,A.USA_LST_LOC_CD" ).append("\n"); 
		query.append("      ,A.MJR_IBD_AUTH_DT" ).append("\n"); 
		query.append("      ,A.MJR_IBD_AUTH_TIME" ).append("\n"); 
		query.append("      ,A.XPT_DT,A.XPT_TIME" ).append("\n"); 
		query.append("      ,A.XPT_ACPT_DT" ).append("\n"); 
		query.append("      ,A.XPT_ACPT_TIME" ).append("\n"); 
		query.append("      ,A.CNMV_STS_CD" ).append("\n"); 
		query.append("      ,A.CSTMS_POD_CD" ).append("\n"); 
		query.append("      ,A.POD_CD" ).append("\n"); 
		query.append("      ,A.HUB_LOC_CD" ).append("\n"); 
		query.append("      ,A.FRT_CLT_FLG" ).append("\n"); 
		query.append("      ,A.OBL_RDEM_FLG" ).append("\n"); 
		query.append("      ,A.CSTMS_CLR_CD" ).append("\n"); 
		query.append("      ,MAX(A.ARR_FLG) OVER(PARTITION BY A.VVD,A.CNTR_NO ORDER BY A.VVD,A.CNTR_NO) AS ARR_FLG" ).append("\n"); 
		query.append("      ,MAX(A.XPT_FLG) OVER(PARTITION BY A.VVD,A.CNTR_NO ORDER BY A.VVD,A.CNTR_NO) AS XPT_FLG" ).append("\n"); 
		query.append("      ,A.TRSP_AUTH_DT" ).append("\n"); 
		query.append("      ,A.TRSP_AUTH_TIME" ).append("\n"); 
		query.append("      ,CASE WHEN LENGTH(TRIM(SUBSTR(A.PKUP, 1, 20))) > 0" ).append("\n"); 
		query.append("                 AND  LENGTH(TRIM(SUBSTR(A.PKUP, 21, 20))) > 0" ).append("\n"); 
		query.append("                 AND  LENGTH(TRIM(SUBSTR(A.PKUP, 41))) > 0" ).append("\n"); 
		query.append("            THEN TRIM(SUBSTR(A.PKUP, 1, 20))" ).append("\n"); 
		query.append("            ELSE A.PKUP_NO" ).append("\n"); 
		query.append("        END AS PKUP_NO" ).append("\n"); 
		query.append("      ,CASE WHEN LENGTH(TRIM(SUBSTR(A.PKUP, 1, 20))) > 0" ).append("\n"); 
		query.append("                 AND  LENGTH(TRIM(SUBSTR(A.PKUP, 21, 20))) > 0" ).append("\n"); 
		query.append("                 AND  LENGTH(TRIM(SUBSTR(A.PKUP, 41))) > 0" ).append("\n"); 
		query.append("            THEN TRIM(SUBSTR(A.PKUP, 21, 20))" ).append("\n"); 
		query.append("            ELSE A.YD_CD" ).append("\n"); 
		query.append("        END AS YD_CD" ).append("\n"); 
		query.append("      ,CASE WHEN LENGTH(TRIM(SUBSTR(A.PKUP, 1, 20))) > 0" ).append("\n"); 
		query.append("                 AND  LENGTH(TRIM(SUBSTR(A.PKUP, 21, 20))) > 0" ).append("\n"); 
		query.append("                 AND  LENGTH(TRIM(SUBSTR(A.PKUP, 41))) > 0" ).append("\n"); 
		query.append("            THEN TRIM(SUBSTR(A.PKUP, 41))" ).append("\n"); 
		query.append("            ELSE A.AVAL_DT" ).append("\n"); 
		query.append("        END AS AVAL_DT" ).append("\n"); 
		query.append("      ,'C' AS BL_CNTR_FLAG" ).append("\n"); 
		query.append("      ,TO_CHAR(GLOBALDATE_PKG.TIME_CONV_FNC ('KRPUS', SYSDATE, 'USNYC'), 'YYYY-MM-DD HH24:MI') AS USDATE" ).append("\n"); 
		query.append("      ,A.ARR_DT||A.ARR_TIME AS ARR_DT_BEFORE" ).append("\n"); 
		query.append("      ,A.XPT_DT||A.XPT_TIME AS XPT_DT_BEFORE" ).append("\n"); 
		query.append("      ,(SELECT CNTR_NO" ).append("\n"); 
		query.append("          FROM BKG_CONTAINER" ).append("\n"); 
		query.append("         WHERE BKG_NO = a.bkg_no" ).append("\n"); 
		query.append("           AND CNTR_NO = A.CNTR_NO" ).append("\n"); 
		query.append("           AND CNTR_VOL_QTY != 1" ).append("\n"); 
		query.append("       ) AS PARTIAL_CNTR_NO" ).append("\n"); 
		query.append("      ,'' AS LCL_FLG" ).append("\n"); 
		query.append("      ,'' AS INBOND_LOCAL" ).append("\n"); 
		query.append("      ,'' AS LOCAL_BL_CNT    -- 0408에서 사용됨" ).append("\n"); 
		query.append("      ,'' AS INBOND_BL_CNT   -- 0408에서 사용됨" ).append("\n"); 
		query.append("      ,'' AS TOTAL_BL_CNT    -- 0408에서 사용됨" ).append("\n"); 
		query.append("      ,'' AS POD_SCC         -- 0408에서 사용됨" ).append("\n"); 
		query.append("      ,'' AS DEL_SCC         -- 0408에서 사용됨" ).append("\n"); 
		query.append("  FROM (SELECT" ).append("\n"); 
		query.append("#if (${arr_gubun} == '1'||${arr_gubun} == 'on')" ).append("\n"); 
		query.append("        /*+ INDEX(I XPKBKG_CSTMS_ADV_BL) */" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("               C.CNTR_NO" ).append("\n"); 
		query.append("              ,I.BKG_NO" ).append("\n"); 
		query.append("              ,I.BL_NO" ).append("\n"); 
		query.append("              ,I.VSL_CD||I.SKD_VOY_NO||I.SKD_DIR_CD AS VVD" ).append("\n"); 
		query.append("              ,I.DEL_CD" ).append("\n"); 
		query.append("              ,I.CSTMS_LOC_CD" ).append("\n"); 
		query.append("              ,IBD.IBD_TRSP_NO" ).append("\n"); 
		query.append("              ,IBD.IBD_TRSP_TP_CD AS IBD_TP_CD" ).append("\n"); 
		query.append("              ,TO_CHAR(C.ARR_DT,'yyyy-mm-dd') ARR_DT" ).append("\n"); 
		query.append("              ,TO_CHAR(C.CGO_ARR_ACPT_DT, 'YYYY-MM-DD') AS TRSP_AUTH_DT" ).append("\n"); 
		query.append("              ,TO_CHAR(IBD.IBD_TRSP_ISS_DT,'yyyy-mm-dd') AS TRSP_ISS_DT" ).append("\n"); 
		query.append("              ,TO_CHAR(C.ARR_DT,'HH24:MI') AS ARR_TIME" ).append("\n"); 
		query.append("              ,TO_CHAR(C.CGO_ARR_ACPT_DT, 'HH24:MI') AS TRSP_AUTH_TIME" ).append("\n"); 
		query.append("              ,TO_CHAR(IBD_TRSP_ISS_DT,'HH24:MI') AS TRSP_ISS_TIME" ).append("\n"); 
		query.append("              ,I.USA_LST_LOC_CD" ).append("\n"); 
		query.append("              ,TO_CHAR(IBD.IBD_TRSP_ACPT_DT,'yyyy-mm-dd') AS MJR_IBD_AUTH_DT" ).append("\n"); 
		query.append("              ,TO_CHAR(IBD.IBD_TRSP_ACPT_DT,'HH24:MI') AS MJR_IBD_AUTH_TIME" ).append("\n"); 
		query.append("              ,TO_CHAR(C.XPT_DT,'yyyy-mm-dd') AS XPT_DT" ).append("\n"); 
		query.append("              ,TO_CHAR(C.XPT_DT,'HH24:MI') AS XPT_TIME" ).append("\n"); 
		query.append("              ,TO_CHAR(C.XPT_ACPT_DT,'yyyy-mm-dd') AS XPT_ACPT_DT" ).append("\n"); 
		query.append("              ,TO_CHAR(C.XPT_ACPT_DT,'HH24:MI') AS XPT_ACPT_TIME" ).append("\n"); 
		query.append("              ,C.PKUP_NO" ).append("\n"); 
		query.append("              ,TO_CHAR(C.AVAL_DT,'yyyy-mm-dd HH24:MI') AS AVAL_DT" ).append("\n"); 
		query.append("              ,C.YD_CD" ).append("\n"); 
		query.append("              ,(SELECT /*+ INDEX_DESC(CTM_MOVEMENT XUK1CTM_MOVEMENT) */  MVMT_STS_CD||' ('||INP_YD_CD||') '||TO_CHAR(CNMV_EVNT_DT, 'YYYY-MM-DD HH24:MI')" ).append("\n"); 
		query.append("                  FROM CTM_MOVEMENT" ).append("\n"); 
		query.append("                 WHERE CNTR_NO = C.CNTR_NO" ).append("\n"); 
		query.append("                   AND ROWNUM = 1" ).append("\n"); 
		query.append("               ) AS CNMV_STS_CD" ).append("\n"); 
		query.append("              ,I.CSTMS_POD_CD" ).append("\n"); 
		query.append("              ,I.POD_CD" ).append("\n"); 
		query.append("              ,I.HUB_LOC_CD" ).append("\n"); 
		query.append("              ,R.FRT_CLT_FLG" ).append("\n"); 
		query.append("              ,R.OBL_RDEM_FLG" ).append("\n"); 
		query.append("              ,R.CSTMS_CLR_CD" ).append("\n"); 
		query.append("              ,DECODE(C.ARR_FLG, 'Y','Y', ' ') AS ARR_FLG" ).append("\n"); 
		query.append("              ,DECODE(C.XPT_FLG, 'Y','Y', ' ') AS XPT_FLG" ).append("\n"); 
		query.append("              ,SUBSTR(MAX(NVL(TO_CHAR(P.PKUP_AVAL_DT,'yyyymmddHH24MISS'),'++++++++++++++')||RPAD(P.PKUP_NO, 20, ' ')||RPAD(P.PKUP_YD_CD, 20, ' ')||TO_CHAR(P.PKUP_AVAL_DT,'yyyy-mm-dd HH24:MI')), 15) PKUP" ).append("\n"); 
		query.append("          FROM BKG_CSTMS_ADV_IBD IBD" ).append("\n"); 
		query.append("              ,BKG_CSTMS_ADV_BL I" ).append("\n"); 
		query.append("              ,BKG_CSTMS_ADV_CNTR C" ).append("\n"); 
		query.append("              ,BKG_CGO_RLSE R" ).append("\n"); 
		query.append("              ,BKG_CSTMS_ADV_RSLT R2" ).append("\n"); 
		query.append("              ,BKG_PKUP_NTC_PKUP_NO P" ).append("\n"); 
		query.append("         WHERE I.CNT_CD = 'US'" ).append("\n"); 
		query.append("           AND I.CNT_CD = IBD.CNT_CD" ).append("\n"); 
		query.append("           AND I.BL_NO = IBD.BL_NO" ).append("\n"); 
		query.append("           AND I.CNT_CD = C.CNT_CD" ).append("\n"); 
		query.append("           AND I.BL_NO = C.BL_NO" ).append("\n"); 
		query.append("           AND I.BL_NO = R.BL_NO(+)" ).append("\n"); 
		query.append("           AND I.CNT_CD = R2.CNT_CD(+)" ).append("\n"); 
		query.append("           AND I.BL_NO = R2.BL_NO(+)" ).append("\n"); 
		query.append("           AND I.MF_NO IS NULL" ).append("\n"); 
		query.append("           AND R2.DSPO_CD(+) = '1J'" ).append("\n"); 
		query.append("           AND R2.ENTR_NO(+) LIKE BKG_GET_BKG_CTMS_CD_FNC('US','AMS_ASGN_CO_CD',1,1)||'%'" ).append("\n"); 
		query.append("           AND R2.RCV_LOC_CD(+) LIKE 'US%'" ).append("\n"); 
		query.append("           AND R2.CSTMS_SEQ(+) > 0" ).append("\n"); 
		query.append("#if (${vvd} != '')" ).append("\n"); 
		query.append("           AND I.VSL_CD = SUBSTR(@[vvd],1,4)" ).append("\n"); 
		query.append("           AND I.SKD_VOY_NO = SUBSTR(@[vvd], 5, 4)" ).append("\n"); 
		query.append("           AND I.SKD_DIR_CD = SUBSTR(@[vvd], 9, 1)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${pod} != '')" ).append("\n"); 
		query.append("           AND I.CSTMS_POD_CD = @[pod]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${bl_no} != '')" ).append("\n"); 
		query.append("           AND I.BL_NO = @[bl_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${cntr_no} != '')" ).append("\n"); 
		query.append("           AND C.CNTR_NO = @[cntr_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${arr_gubun} == '1'||${arr_gubun} == 'on')" ).append("\n"); 
		query.append("    #if (${eq_ofc} != '' )" ).append("\n"); 
		query.append("           AND NVL(I.DEL_CD, ' ') IN (SELECT LOC_CD FROM MDM_LOCATION WHERE NVL(EQ_CTRL_OFC_CD,' ') LIKE @[eq_ofc]||'%')" ).append("\n"); 
		query.append("           AND NVL(C.YD_CD,' ') in (SELECT NVL(MTY_PKUP_YD_CD,' ') FROM MDM_LOCATION WHERE NVL(EQ_CTRL_OFC_CD,' ') like @[eq_ofc]||'%')" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("    #if (${fromd} != '')" ).append("\n"); 
		query.append("           AND C.ARR_DT >= TO_DATE(REPLACE(REPLACE(@[fromd], '-', ''), '/', '')||' '||REPLACE(@[fromt], ':', '') ,'YYYYMMDD HH24MI')" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("    #if (${tod} != '')" ).append("\n"); 
		query.append("           AND C.ARR_DT < TO_DATE(REPLACE(REPLACE(@[tod], '-', ''), '/', '')||' '||REPLACE(@[tot], ':', '') ,'YYYYMMDD HH24MI')+1" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${ibd_tp_cd} == 'All')" ).append("\n"); 
		query.append("           AND 1=1" ).append("\n"); 
		query.append("#elseif (${ibd_tp_cd} == '612')" ).append("\n"); 
		query.append("           AND IBD.IBD_TRSP_TP_CD IN ('61','62')" ).append("\n"); 
		query.append("#elseif (${ibd_tp_cd} == '623')" ).append("\n"); 
		query.append("           AND IBD.IBD_TRSP_TP_CD IN ('62','63')" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("           AND IBD.IBD_TRSP_TP_CD = @[ibd_tp_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${arr_dt} != '')" ).append("\n"); 
		query.append("           AND NVL(C.ARR_FLG, 'N') = @[arr_dt]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${xpt_dt} != '')" ).append("\n"); 
		query.append("           AND NVL(C.XPT_FLG, 'N') = @[xpt_dt]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${edi_error} == 'NA')" ).append("\n"); 
		query.append("           AND C.CGO_ARR_ACPT_DT IS NULL AND @[edi_error] = @[edi_error]" ).append("\n"); 
		query.append("#elseif (${edi_error} == 'NE')" ).append("\n"); 
		query.append("           AND C.XPT_ACPT_DT IS NULL" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("           AND CASE WHEN NVL(@[hub], 'X') = 'X' THEN 1" ).append("\n"); 
		query.append("                    WHEN NVL(@[hub], ' ') = 'USCHI' THEN" ).append("\n"); 
		query.append("                      INSTR('USCHI,USCLE,USCMH,USCVG,USDET,USDWH,USEVA,USFAR,USGRB,USGRR,USIND,USMKE,USMRV,USMSP,USOMA,USPIA,USRXG,USSDF,USSGF,USSTE,USSTL,USTOL,USWRZ,USDAY,USMKC,USDSM,USKCK', I.HUB_LOC_CD)" ).append("\n"); 
		query.append("                    ELSE INSTR(I.HUB_LOC_CD, @[hub])" ).append("\n"); 
		query.append("                END  > 0" ).append("\n"); 
		query.append("           AND I.MF_STS_CD = 'A'" ).append("\n"); 
		query.append("           AND IBD.IBD_TRSP_NO LIKE BKG_GET_BKG_CTMS_CD_FNC('US','AMS_ASGN_CO_CD',1,1)||'%'" ).append("\n"); 
		query.append("           AND @[bl_cntr_gubun] = @[bl_cntr_gubun]" ).append("\n"); 
		query.append("           AND C.BL_NO = P.BL_NO(+)" ).append("\n"); 
		query.append("           AND C.CNTR_NO = P.CNTR_NO(+)" ).append("\n"); 
		query.append("      GROUP BY C.CNTR_NO" ).append("\n"); 
		query.append("              ,I.BKG_NO" ).append("\n"); 
		query.append("              ,I.BL_NO" ).append("\n"); 
		query.append("              ,I.VSL_CD" ).append("\n"); 
		query.append("              ,I.SKD_VOY_NO" ).append("\n"); 
		query.append("              ,I.SKD_DIR_CD" ).append("\n"); 
		query.append("              ,I.CSTMS_POD_CD" ).append("\n"); 
		query.append("              ,I.POD_CD" ).append("\n"); 
		query.append("              ,I.HUB_LOC_CD" ).append("\n"); 
		query.append("              ,I.DEL_CD" ).append("\n"); 
		query.append("              ,I.CSTMS_LOC_CD" ).append("\n"); 
		query.append("              ,IBD.IBD_TRSP_NO" ).append("\n"); 
		query.append("              ,IBD.IBD_TRSP_TP_CD" ).append("\n"); 
		query.append("              ,C.ARR_DT" ).append("\n"); 
		query.append("              ,IBD.IBD_TRSP_ISS_DT" ).append("\n"); 
		query.append("              ,C.CGO_ARR_ACPT_DT" ).append("\n"); 
		query.append("              ,I.USA_LST_LOC_CD" ).append("\n"); 
		query.append("              ,IBD.IBD_TRSP_ACPT_DT" ).append("\n"); 
		query.append("              ,C.XPT_DT" ).append("\n"); 
		query.append("              ,C.XPT_ACPT_DT" ).append("\n"); 
		query.append("              ,C.PKUP_NO" ).append("\n"); 
		query.append("              ,C.AVAL_DT" ).append("\n"); 
		query.append("              ,C.YD_CD" ).append("\n"); 
		query.append("              ,C.CNMV_STS_CD" ).append("\n"); 
		query.append("              ,R.FRT_CLT_FLG" ).append("\n"); 
		query.append("              ,R.OBL_RDEM_FLG" ).append("\n"); 
		query.append("              ,R.CSTMS_CLR_CD" ).append("\n"); 
		query.append("              ,C.ARR_FLG" ).append("\n"); 
		query.append("              ,C.XPT_FLG" ).append("\n"); 
		query.append("         ) A" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("SELECT A.CNTR_NO" ).append("\n"); 
		query.append("      ,A.BL_NO" ).append("\n"); 
		query.append("      ,A.VVD" ).append("\n"); 
		query.append("      ,A.DEL_CD" ).append("\n"); 
		query.append("      ,A.CSTMS_LOC_CD" ).append("\n"); 
		query.append("      ,A.IBD_TRSP_NO" ).append("\n"); 
		query.append("      ,A.IBD_TP_CD" ).append("\n"); 
		query.append("      ,A.ARR_DT" ).append("\n"); 
		query.append("      ,A.TRSP_ISS_DT" ).append("\n"); 
		query.append("      ,A.ARR_TIME" ).append("\n"); 
		query.append("      ,A.TRSP_ISS_TIME" ).append("\n"); 
		query.append("      ,A.USA_LST_LOC_CD" ).append("\n"); 
		query.append("      ,A.MJR_IBD_AUTH_DT" ).append("\n"); 
		query.append("      ,A.MJR_IBD_AUTH_TIME" ).append("\n"); 
		query.append("      ,A.XPT_DT" ).append("\n"); 
		query.append("      ,A.XPT_TIME" ).append("\n"); 
		query.append("      ,A.XPT_ACPT_DT" ).append("\n"); 
		query.append("      ,A.XPT_ACPT_TIME" ).append("\n"); 
		query.append("      ,A.CNMV_STS_CD" ).append("\n"); 
		query.append("      ,A.CSTMS_POD_CD" ).append("\n"); 
		query.append("      ,A.POD_CD" ).append("\n"); 
		query.append("      ,A.HUB_LOC_CD" ).append("\n"); 
		query.append("      ,A.FRT_CLT_FLG" ).append("\n"); 
		query.append("      ,A.OBL_RDEM_FLG" ).append("\n"); 
		query.append("      ,A.CSTMS_CLR_CD" ).append("\n"); 
		query.append("      ,A.ARR_FLG" ).append("\n"); 
		query.append("      ,A.XPT_FLG" ).append("\n"); 
		query.append("      ,A.TRSP_AUTH_DT" ).append("\n"); 
		query.append("      ,A.TRSP_AUTH_TIME" ).append("\n"); 
		query.append("      ,A.PKUP_NO" ).append("\n"); 
		query.append("      ,A.YD_CD" ).append("\n"); 
		query.append("      ,A.AVAL_DT" ).append("\n"); 
		query.append("      ,'B' BL_CNTR_FLAG" ).append("\n"); 
		query.append("      ,TO_CHAR(GLOBALDATE_PKG.TIME_CONV_FNC ('KRPUS', SYSDATE,'USNYC'),'YYYY-MM-DD HH24:MI') AS USDATE" ).append("\n"); 
		query.append("      ,A.ARR_DT||A.ARR_TIME ARR_DT_BEFORE" ).append("\n"); 
		query.append("      ,A.XPT_DT||A.XPT_TIME XPT_DT_BEFORE" ).append("\n"); 
		query.append("      ,'' PARTIAL_CNTR_NO" ).append("\n"); 
		query.append("      ,'' LCL_FLG" ).append("\n"); 
		query.append("      ,'' INBOND_LOCAL" ).append("\n"); 
		query.append("      ,'' LOCAL_BL_CNT   -- 0408에서 사용됨" ).append("\n"); 
		query.append("      ,'' TOTAL_BL_CNT   -- 0408에서 사용됨" ).append("\n"); 
		query.append("  FROM (SELECT" ).append("\n"); 
		query.append("#if (${arr_gubun} == '1'||${arr_gubun} == 'on')" ).append("\n"); 
		query.append("        /*+ INDEX(I XPKBKG_CSTMS_ADV_BL) */" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("               ' ' AS CNTR_NO" ).append("\n"); 
		query.append("              ,I.BKG_NO" ).append("\n"); 
		query.append("              ,I.BL_NO BL_NO" ).append("\n"); 
		query.append("              ,I.VSL_CD||I.SKD_VOY_NO||I.SKD_DIR_CD AS VVD" ).append("\n"); 
		query.append("              ,I.DEL_CD" ).append("\n"); 
		query.append("              ,I.CSTMS_LOC_CD" ).append("\n"); 
		query.append("              ,IBD.IBD_TRSP_NO" ).append("\n"); 
		query.append("              ,IBD.IBD_TRSP_TP_CD IBD_TP_CD" ).append("\n"); 
		query.append("              ,TO_CHAR(IBD.IBD_TRSP_ARR_DT,'yyyy-mm-dd') AS ARR_DT" ).append("\n"); 
		query.append("              ,TO_CHAR(IBD.IBD_TRSP_ARR_ACPT_DT, 'YYYY-MM-DD') AS TRSP_AUTH_DT" ).append("\n"); 
		query.append("              ,TO_CHAR(IBD.IBD_TRSP_ISS_DT,'yyyy-mm-dd') AS TRSP_ISS_DT" ).append("\n"); 
		query.append("              ,TO_CHAR(IBD.IBD_TRSP_ARR_DT,'HH24:MI') AS ARR_TIME" ).append("\n"); 
		query.append("              ,TO_CHAR(IBD.IBD_TRSP_ARR_ACPT_DT, 'HH24:MI') AS TRSP_AUTH_TIME" ).append("\n"); 
		query.append("              ,TO_CHAR(IBD.IBD_TRSP_ISS_DT,'HH24:MI') AS TRSP_ISS_TIME" ).append("\n"); 
		query.append("              ,I.USA_LST_LOC_CD" ).append("\n"); 
		query.append("              ,TO_CHAR(IBD.IBD_TRSP_ACPT_DT,'yyyy-mm-dd') AS MJR_IBD_AUTH_DT" ).append("\n"); 
		query.append("              ,TO_CHAR(IBD.IBD_TRSP_ACPT_DT,'HH24:MI') AS MJR_IBD_AUTH_TIME" ).append("\n"); 
		query.append("              ,TO_CHAR(IBD.IBD_TRSP_XPT_DT,'yyyy-mm-dd') AS XPT_DT" ).append("\n"); 
		query.append("              ,TO_CHAR(IBD.IBD_TRSP_XPT_DT,'HH24:MI') AS XPT_TIME" ).append("\n"); 
		query.append("              ,TO_CHAR(IBD.IBD_TRSP_XPT_ACPT_DT,'yyyy-mm-dd') AS XPT_ACPT_DT" ).append("\n"); 
		query.append("              ,TO_CHAR(IBD.IBD_TRSP_XPT_ACPT_DT,'HH24:MI') AS XPT_ACPT_TIME" ).append("\n"); 
		query.append("              ,' ' AS PKUP_NO" ).append("\n"); 
		query.append("              ,' ' AS AVAL_DT" ).append("\n"); 
		query.append("              ,' ' AS YD_CD" ).append("\n"); 
		query.append("              ,' ' AS CNMV_STS_CD" ).append("\n"); 
		query.append("              ,I.CSTMS_POD_CD" ).append("\n"); 
		query.append("              ,I.POD_CD" ).append("\n"); 
		query.append("              ,I.HUB_LOC_CD" ).append("\n"); 
		query.append("              ,R.FRT_CLT_FLG" ).append("\n"); 
		query.append("              ,R.OBL_RDEM_FLG" ).append("\n"); 
		query.append("              ,R.CSTMS_CLR_CD" ).append("\n"); 
		query.append("              ,DECODE(IBD.IBD_TRSP_ARR_SND_FLG, 'Y','Y', ' ') AS ARR_FLG" ).append("\n"); 
		query.append("              ,DECODE(IBD.IBD_TRSP_XPT_SND_FLG, 'Y','Y', ' ') AS XPT_FLG" ).append("\n"); 
		query.append("          FROM BKG_CSTMS_ADV_IBD IBD" ).append("\n"); 
		query.append("              ,BKG_CSTMS_ADV_BL I" ).append("\n"); 
		query.append("              ,BKG_CGO_RLSE R" ).append("\n"); 
		query.append("              ,BKG_CSTMS_ADV_RSLT R2" ).append("\n"); 
		query.append("#if (${cntr_no} != '')" ).append("\n"); 
		query.append("              ,BKG_CSTMS_ADV_CNTR C" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("         WHERE I.CNT_CD = 'US'" ).append("\n"); 
		query.append("           AND I.CNT_CD = IBD.CNT_CD" ).append("\n"); 
		query.append("           AND I.BL_NO = IBD.BL_NO" ).append("\n"); 
		query.append("           AND I.BL_NO = R.BL_NO(+)" ).append("\n"); 
		query.append("           AND I.CNT_CD = R2.CNT_CD(+)" ).append("\n"); 
		query.append("           AND I.BL_NO = R2.BL_NO(+)" ).append("\n"); 
		query.append("           AND I.MF_NO IS NULL" ).append("\n"); 
		query.append("           AND R2.DSPO_CD(+) = '1J'" ).append("\n"); 
		query.append("           AND R2.ENTR_NO(+) LIKE BKG_GET_BKG_CTMS_CD_FNC('US','AMS_ASGN_CO_CD',1,1)||'%'" ).append("\n"); 
		query.append("           AND R2.RCV_LOC_CD(+) LIKE 'US%'" ).append("\n"); 
		query.append("           AND R2.CSTMS_SEQ(+) > 0" ).append("\n"); 
		query.append("#if (${vvd} != '')" ).append("\n"); 
		query.append("           AND I.VSL_CD = SUBSTR(@[vvd],1,4)" ).append("\n"); 
		query.append("           AND I.SKD_VOY_NO = SUBSTR(@[vvd], 5, 4)" ).append("\n"); 
		query.append("           AND I.SKD_DIR_CD = SUBSTR(@[vvd], 9, 1)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${pod} != '')" ).append("\n"); 
		query.append("           AND I.CSTMS_POD_CD = @[pod]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${bl_no} != '')" ).append("\n"); 
		query.append("           AND I.BL_NO = @[bl_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${cntr_no} != '')" ).append("\n"); 
		query.append("           AND I.BL_NO = C.BL_NO" ).append("\n"); 
		query.append("           AND C.CNTR_NO = @[cntr_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${arr_gubun} == '1'||${arr_gubun} == 'on')" ).append("\n"); 
		query.append("    #if (${eq_ofc} != '' )" ).append("\n"); 
		query.append("           AND NVL(I.DEL_CD, ' ') IN (SELECT LOC_CD FROM MDM_LOCATION WHERE NVL(EQ_CTRL_OFC_CD,' ') LIKE @[eq_ofc]||'%')" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("    #if (${fromd} != '')" ).append("\n"); 
		query.append("           AND IBD.IBD_TRSP_ARR_DT >= TO_DATE(REPLACE(REPLACE(@[fromd], '-', ''), '/', '')||' '||REPLACE(@[fromt], ':', '') ,'YYYYMMDD HH24MI')" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("    #if (${tod} != '')" ).append("\n"); 
		query.append("           AND IBD.IBD_TRSP_ARR_DT < TO_DATE(REPLACE(REPLACE(@[tod], '-', ''), '/', '')||' '||REPLACE(@[tot], ':', '') ,'YYYYMMDD HH24MI')+1" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${ibd_tp_cd} == 'All')" ).append("\n"); 
		query.append("           AND 1=1" ).append("\n"); 
		query.append("#elseif (${ibd_tp_cd} == '612')" ).append("\n"); 
		query.append("           AND IBD.IBD_TRSP_TP_CD IN ('61','62')" ).append("\n"); 
		query.append("#elseif (${ibd_tp_cd} == '623')" ).append("\n"); 
		query.append("           AND IBD.IBD_TRSP_TP_CD IN ('62','63')" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("           AND IBD.IBD_TRSP_TP_CD = @[ibd_tp_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${arr_dt} != '')" ).append("\n"); 
		query.append("           AND NVL(IBD.IBD_TRSP_ARR_SND_FLG, 'N') = @[arr_dt]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${xpt_dt} != '')" ).append("\n"); 
		query.append("           AND NVL(IBD.IBD_TRSP_XPT_SND_FLG, 'N') = @[xpt_dt]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${edi_error} == 'NA')" ).append("\n"); 
		query.append("           AND IBD.IBD_TRSP_ARR_ACPT_DT IS NULL AND @[edi_error] = @[edi_error]" ).append("\n"); 
		query.append("#elseif (${edi_error} == 'NE')" ).append("\n"); 
		query.append("           AND IBD.IBD_TRSP_XPT_ACPT_DT IS NULL" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("           AND CASE WHEN NVL(@[hub], 'X') = 'X' THEN 1" ).append("\n"); 
		query.append("                    WHEN NVL(@[hub], ' ') = 'USCHI' THEN" ).append("\n"); 
		query.append("                        INSTR('USCHI,USCLE,USCMH,USCVG,USDET,USDWH,USEVA,USFAR,USGRB,USGRR,USIND,USMKE,USMRV,USMSP,USOMA,USPIA,USRXG,USSDF,USSGF,USSTE,USSTL,USTOL,USWRZ,USDAY,USMKC,USDSM,USKCK', I.HUB_LOC_CD)" ).append("\n"); 
		query.append("                    ELSE INSTR(I.HUB_LOC_CD, @[hub])" ).append("\n"); 
		query.append("                 END  > 0" ).append("\n"); 
		query.append("           AND I.MF_STS_CD = 'A'" ).append("\n"); 
		query.append("           AND IBD.IBD_TRSP_NO LIKE BKG_GET_BKG_CTMS_CD_FNC('US','AMS_ASGN_CO_CD',1,1)||'%'" ).append("\n"); 
		query.append("      GROUP BY I.BKG_NO" ).append("\n"); 
		query.append("              ,I.BL_NO" ).append("\n"); 
		query.append("              ,I.VSL_CD" ).append("\n"); 
		query.append("              ,I.SKD_VOY_NO" ).append("\n"); 
		query.append("              ,I.SKD_DIR_CD" ).append("\n"); 
		query.append("              ,I.CSTMS_POD_CD" ).append("\n"); 
		query.append("              ,I.POD_CD" ).append("\n"); 
		query.append("              ,I.HUB_LOC_CD" ).append("\n"); 
		query.append("              ,I.DEL_CD" ).append("\n"); 
		query.append("              ,I.CSTMS_LOC_CD" ).append("\n"); 
		query.append("              ,IBD.IBD_TRSP_NO" ).append("\n"); 
		query.append("              ,IBD.IBD_TRSP_TP_CD" ).append("\n"); 
		query.append("              ,IBD.IBD_TRSP_ARR_DT" ).append("\n"); 
		query.append("              ,IBD.IBD_TRSP_ISS_DT" ).append("\n"); 
		query.append("              ,IBD.IBD_TRSP_ARR_ACPT_DT" ).append("\n"); 
		query.append("              ,I.USA_LST_LOC_CD" ).append("\n"); 
		query.append("              ,IBD.IBD_TRSP_ACPT_DT" ).append("\n"); 
		query.append("              ,IBD.IBD_TRSP_XPT_DT" ).append("\n"); 
		query.append("              ,IBD.IBD_TRSP_XPT_ACPT_DT" ).append("\n"); 
		query.append("              ,R.FRT_CLT_FLG" ).append("\n"); 
		query.append("              ,R.OBL_RDEM_FLG" ).append("\n"); 
		query.append("              ,R.CSTMS_CLR_CD" ).append("\n"); 
		query.append("              ,IBD.IBD_TRSP_ARR_SND_FLG" ).append("\n"); 
		query.append("              ,IBD.IBD_TRSP_XPT_SND_FLG" ).append("\n"); 
		query.append("      ) A" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}