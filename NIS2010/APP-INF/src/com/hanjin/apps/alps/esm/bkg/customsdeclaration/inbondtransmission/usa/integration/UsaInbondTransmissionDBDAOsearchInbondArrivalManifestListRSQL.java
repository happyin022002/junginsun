/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : UsaInbondTransmissionDBDAOsearchInbondArrivalManifestListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.04.11
*@LastModifier : 
*@LastVersion : 1.0
* 2017.04.11 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.inbondtransmission.usa.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

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
		params.put("fromt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("xpt_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pod",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("edi_error",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.customsdeclaration.inbondtransmission.usa.integration").append("\n"); 
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
		query.append("#if (${bl_cntr_gubun} != 'BL') " ).append("\n"); 
		query.append("select A.CNTR_NO, A.BL_NO, A.VVD, A.DEL_CD, A.CSTMS_LOC_CD, A.IBD_TRSP_NO," ).append("\n"); 
		query.append("    A.IBD_TP_CD, A.ARR_DT, A.TRSP_ISS_DT, A.ARR_TIME, A.TRSP_ISS_TIME," ).append("\n"); 
		query.append("    A.USA_LST_LOC_CD, A.MJR_IBD_AUTH_DT, A.MJR_IBD_AUTH_TIME, A.XPT_DT, A.XPT_TIME, " ).append("\n"); 
		query.append("    A.XPT_ACPT_DT, A.XPT_ACPT_TIME, A.CNMV_STS_CD, A.CSTMS_POD_CD, A.POD_CD, A.HUB_LOC_CD," ).append("\n"); 
		query.append("    A.FRT_CLT_FLG, A.OBL_RDEM_FLG, A.CSTMS_CLR_CD," ).append("\n"); 
		query.append("	MAX(A.ARR_FLG) OVER(PARTITION BY A.VVD, A.CNTR_NO ORDER BY A.VVD, A.CNTR_NO) ARR_FLG," ).append("\n"); 
		query.append("	MAX(A.XPT_FLG) OVER(PARTITION BY A.VVD, A.CNTR_NO ORDER BY A.VVD, A.CNTR_NO) XPT_FLG," ).append("\n"); 
		query.append("    A.TRSP_AUTH_DT, A.TRSP_AUTH_TIME," ).append("\n"); 
		query.append("    CASE WHEN LENGTH(TRIM(SUBSTR(A.PKUP, 1, 20))) > 0  " ).append("\n"); 
		query.append("            AND  LENGTH(TRIM(SUBSTR(A.PKUP, 21, 20))) > 0" ).append("\n"); 
		query.append("            AND  LENGTH(TRIM(SUBSTR(A.PKUP, 41))) > 0 THEN" ).append("\n"); 
		query.append("        TRIM(SUBSTR(A.PKUP, 1, 20))" ).append("\n"); 
		query.append("    ELSE" ).append("\n"); 
		query.append("        A.PKUP_NO" ).append("\n"); 
		query.append("    END PKUP_NO," ).append("\n"); 
		query.append("    CASE WHEN LENGTH(TRIM(SUBSTR(A.PKUP, 1, 20))) > 0 " ).append("\n"); 
		query.append("            AND  LENGTH(TRIM(SUBSTR(A.PKUP, 21, 20))) > 0" ).append("\n"); 
		query.append("            AND  LENGTH(TRIM(SUBSTR(A.PKUP, 41))) > 0 THEN" ).append("\n"); 
		query.append("        TRIM(SUBSTR(A.PKUP, 21, 20))" ).append("\n"); 
		query.append("    ELSE" ).append("\n"); 
		query.append("        A.YD_CD" ).append("\n"); 
		query.append("    END YD_CD," ).append("\n"); 
		query.append("    CASE WHEN LENGTH(TRIM(SUBSTR(A.PKUP, 1, 20))) > 0 " ).append("\n"); 
		query.append("            AND  LENGTH(TRIM(SUBSTR(A.PKUP, 21, 20))) > 0" ).append("\n"); 
		query.append("            AND  LENGTH(TRIM(SUBSTR(A.PKUP, 41))) > 0 THEN" ).append("\n"); 
		query.append("        TRIM(SUBSTR(A.PKUP, 41))" ).append("\n"); 
		query.append("    ELSE" ).append("\n"); 
		query.append("        A.AVAL_DT" ).append("\n"); 
		query.append("    END AVAL_DT," ).append("\n"); 
		query.append("	'C' BL_CNTR_FLAG," ).append("\n"); 
		query.append("	TO_CHAR(GLOBALDATE_PKG.TIME_CONV_FNC ('KRACY', sysdate, 'USNYC'), 'YYYY-MM-DD HH24:MI') USDATE," ).append("\n"); 
		query.append("	A.ARR_DT || A.ARR_TIME ARR_DT_BEFORE," ).append("\n"); 
		query.append("	A.XPT_DT || A.XPT_TIME XPT_DT_BEFORE," ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(" 	(" ).append("\n"); 
		query.append("        SELECT CNTR_NO" ).append("\n"); 
		query.append("        FROM BKG_CONTAINER" ).append("\n"); 
		query.append("        WHERE BKG_NO = a.bkg_no" ).append("\n"); 
		query.append("        AND CNTR_NO = A.CNTR_NO" ).append("\n"); 
		query.append("        AND CNTR_VOL_QTY != 1         " ).append("\n"); 
		query.append("     ) PARTIAL_CNTR_NO," ).append("\n"); 
		query.append("	" ).append("\n"); 
		query.append("	'' LCL_FLG," ).append("\n"); 
		query.append("	'' INBOND_LOCAL," ).append("\n"); 
		query.append("	'' LOCAL_BL_CNT,	-- 0408에서 사용됨" ).append("\n"); 
		query.append("	'' INBOND_BL_CNT,	-- 0408에서 사용됨" ).append("\n"); 
		query.append("	'' TOTAL_BL_CNT,	-- 0408에서 사용됨" ).append("\n"); 
		query.append("	'' POD_SCC, 		-- 0408에서 사용됨" ).append("\n"); 
		query.append("	'' DEL_SCC			-- 0408에서 사용됨" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("FROM          " ).append("\n"); 
		query.append("    (" ).append("\n"); 
		query.append("    select" ).append("\n"); 
		query.append("#if (${arr_gubun} == '1' || ${arr_gubun} == 'on')" ).append("\n"); 
		query.append("		/*+ INDEX(I XPKBKG_CSTMS_ADV_BL) */" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("        C.CNTR_NO, I.BKG_NO," ).append("\n"); 
		query.append("        I.BL_NO BL_NO, I.VSL_CD || I.SKD_VOY_NO || I.SKD_DIR_CD VVD," ).append("\n"); 
		query.append("        I.DEL_CD, I.CSTMS_LOC_CD, IBD.IBD_TRSP_NO, IBD.IBD_TRSP_TP_CD IBD_TP_CD, to_char(C.ARR_DT,'yyyy-mm-dd') ARR_DT," ).append("\n"); 
		query.append("        to_char(C.CGO_ARR_ACPT_DT, 'YYYY-MM-DD') TRSP_AUTH_DT," ).append("\n"); 
		query.append("        to_char(IBD.IBD_TRSP_ISS_DT,'yyyy-mm-dd') TRSP_ISS_DT," ).append("\n"); 
		query.append("        NVL(to_char(C.ARR_DT,'HH24:MI'),'') ARR_TIME," ).append("\n"); 
		query.append("        to_char(C.CGO_ARR_ACPT_DT, 'HH24:MI') TRSP_AUTH_TIME," ).append("\n"); 
		query.append("        to_char(IBD_TRSP_ISS_DT,'HH24:MI') TRSP_ISS_TIME," ).append("\n"); 
		query.append("        I.USA_LST_LOC_CD," ).append("\n"); 
		query.append("        to_char(IBD.IBD_TRSP_ACPT_DT,'yyyy-mm-dd') MJR_IBD_AUTH_DT, to_char(IBD.IBD_TRSP_ACPT_DT,'HH24:MI') MJR_IBD_AUTH_TIME," ).append("\n"); 
		query.append("        to_char(C.XPT_DT,'yyyy-mm-dd') XPT_DT, NVL(to_char(C.XPT_DT,'HH24:MI'),'') XPT_TIME," ).append("\n"); 
		query.append("        to_char(C.XPT_ACPT_DT,'yyyy-mm-dd') XPT_ACPT_DT, to_char(C.XPT_ACPT_DT,'HH24:MI') XPT_ACPT_TIME," ).append("\n"); 
		query.append("        C.PKUP_NO, TO_CHAR(C.AVAL_DT,'yyyy-mm-dd HH24:MI') AVAL_DT, C.YD_CD, C.CNMV_STS_CD," ).append("\n"); 
		query.append("        I.CSTMS_POD_CD, I.POD_CD, I.HUB_LOC_CD, R.FRT_CLT_FLG, R.OBL_RDEM_FLG, R.CSTMS_CLR_CD," ).append("\n"); 
		query.append("        DECODE(C.ARR_FLG, 'Y','Y', ' ') ARR_FLG, DECODE(C.XPT_FLG, 'Y','Y', ' ') XPT_FLG," ).append("\n"); 
		query.append("        SUBSTR(MAX(NVL(TO_CHAR(P.PKUP_AVAL_DT,'yyyymmddHH24MISS'),'++++++++++++++') || RPAD(P.PKUP_NO, 20, ' ') ||RPAD(P.PKUP_YD_CD, 20, ' ')||TO_CHAR(P.PKUP_AVAL_DT,'yyyy-mm-dd HH24:MI')), 15) PKUP" ).append("\n"); 
		query.append("    from BKG_CSTMS_ADV_IBD IBD, BKG_CSTMS_ADV_BL I, BKG_CSTMS_ADV_CNTR C, BKG_CGO_RLSE R, BKG_CSTMS_ADV_RSLT R2" ).append("\n"); 
		query.append("		,BKG_PKUP_NTC_PKUP_NO P" ).append("\n"); 
		query.append("    WHERE	I.CNT_CD = 'US'" ).append("\n"); 
		query.append("		AND I.CNT_CD = IBD.CNT_CD" ).append("\n"); 
		query.append("        AND I.BL_NO = IBD.BL_NO" ).append("\n"); 
		query.append("        AND I.CNT_CD = C.CNT_CD" ).append("\n"); 
		query.append("        AND I.BL_NO = C.BL_NO" ).append("\n"); 
		query.append("        AND I.BL_NO = R.BL_NO(+)" ).append("\n"); 
		query.append("        AND I.CNT_CD = R2.CNT_CD(+)" ).append("\n"); 
		query.append("        AND I.BL_NO = R2.BL_NO(+)" ).append("\n"); 
		query.append("		AND I.MF_NO IS NULL" ).append("\n"); 
		query.append("		AND R2.DSPO_CD(+) = '1J'" ).append("\n"); 
		query.append("		AND R2.ENTR_NO(+) LIKE 'V5N%' " ).append("\n"); 
		query.append("		AND R2.RCV_LOC_CD(+) LIKE 'US%'" ).append("\n"); 
		query.append("		AND R2.CSTMS_SEQ(+) > 0" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("		#if (${vvd} != '')" ).append("\n"); 
		query.append("		AND I.VSL_CD = SUBSTR(@[vvd],1,4)" ).append("\n"); 
		query.append("		AND I.SKD_VOY_NO = SUBSTR(@[vvd], 5, 4)" ).append("\n"); 
		query.append("		AND I.SKD_DIR_CD = SUBSTR(@[vvd], 9, 1)" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("		#if (${pod} != '')" ).append("\n"); 
		query.append("		AND I.CSTMS_POD_CD = @[pod]" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${arr_gubun} == '1' || ${arr_gubun} == 'on') " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	#if (${eq_ofc} != '' ) " ).append("\n"); 
		query.append("		AND NVL(I.DEL_CD, ' ') IN (SELECT LOC_CD FROM MDM_LOCATION WHERE NVL(EQ_CTRL_OFC_CD,' ') LIKE @[eq_ofc] || '%')" ).append("\n"); 
		query.append("		AND NVL(C.YD_CD,' ') in (SELECT NVL(MTY_PKUP_YD_CD,' ') FROM MDM_LOCATION WHERE NVL(EQ_CTRL_OFC_CD,' ') like @[eq_ofc] || '%') " ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("	#if (${fromd} != '') " ).append("\n"); 
		query.append("		AND C.ARR_DT >= TO_DATE(REPLACE(REPLACE(@[fromd], '-', ''), '/', '') ||' '|| REPLACE(@[fromt], ':', '') ,'YYYYMMDD HH24MI')" ).append("\n"); 
		query.append("	#end " ).append("\n"); 
		query.append("	#if (${tod} != '') " ).append("\n"); 
		query.append("		AND C.ARR_DT < TO_DATE(REPLACE(REPLACE(@[tod], '-', ''), '/', '') ||' '|| REPLACE(@[tot], ':', '') ,'YYYYMMDD HH24MI')+1" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${ibd_tp_cd} == 'All') " ).append("\n"); 
		query.append("		AND 1=1" ).append("\n"); 
		query.append("#elseif (${ibd_tp_cd} == '612') " ).append("\n"); 
		query.append("		AND IBD.IBD_TRSP_TP_CD IN ('61','62')" ).append("\n"); 
		query.append("#elseif (${ibd_tp_cd} == '623') " ).append("\n"); 
		query.append("		AND IBD.IBD_TRSP_TP_CD IN ('62','63')" ).append("\n"); 
		query.append("#else " ).append("\n"); 
		query.append("		AND IBD.IBD_TRSP_TP_CD = @[ibd_tp_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${arr_dt} != '') " ).append("\n"); 
		query.append("		AND NVL(C.ARR_FLG, 'N') = @[arr_dt]" ).append("\n"); 
		query.append("#end " ).append("\n"); 
		query.append("#if (${xpt_dt} != '') " ).append("\n"); 
		query.append("		AND NVL(C.XPT_FLG, 'N') = @[xpt_dt]" ).append("\n"); 
		query.append("#end " ).append("\n"); 
		query.append("#if (${edi_error} == 'NA') " ).append("\n"); 
		query.append("		AND C.CGO_ARR_ACPT_DT IS NULL AND @[edi_error] = @[edi_error]" ).append("\n"); 
		query.append("#elseif (${edi_error} == 'NE') " ).append("\n"); 
		query.append("		AND C.XPT_ACPT_DT IS NULL" ).append("\n"); 
		query.append("#end " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("        AND CASE " ).append("\n"); 
		query.append("            WHEN NVL(@[hub], 'X') = 'X' THEN 1" ).append("\n"); 
		query.append("            WHEN NVL(@[hub], ' ') = 'USCHI' THEN" ).append("\n"); 
		query.append("                INSTR('USCHI,USCLE,USCMH,USCVG,USDET,USDWH,USEVA,USFAR,USGRB,USGRR,USIND,USMKE,USMRV,USMSP,USOMA,USPIA,USRXG,USSDF,USSGF,USSTE,USSTL,USTOL,USWRZ,USDAY,USMKC,USDSM,USKCK', I.HUB_LOC_CD)" ).append("\n"); 
		query.append("            ELSE" ).append("\n"); 
		query.append("                INSTR(I.HUB_LOC_CD, @[hub])" ).append("\n"); 
		query.append("            END  > 0" ).append("\n"); 
		query.append("		AND I.MF_STS_CD = 'A'" ).append("\n"); 
		query.append("		AND IBD.IBD_TRSP_NO LIKE 'V5N%'" ).append("\n"); 
		query.append("		AND @[bl_cntr_gubun] = @[bl_cntr_gubun] " ).append("\n"); 
		query.append("		AND C.BL_NO = P.BL_NO(+)" ).append("\n"); 
		query.append("		AND C.CNTR_NO = P.CNTR_NO(+)" ).append("\n"); 
		query.append("    GROUP BY C.CNTR_NO, I.BKG_NO," ).append("\n"); 
		query.append("        I.BL_NO, I.VSL_CD, I.SKD_VOY_NO, I.SKD_DIR_CD, I.CSTMS_POD_CD, I.POD_CD, I.HUB_LOC_CD, " ).append("\n"); 
		query.append("        I.DEL_CD, I.CSTMS_LOC_CD, IBD.IBD_TRSP_NO, IBD.IBD_TRSP_TP_CD, C.ARR_DT," ).append("\n"); 
		query.append("        IBD.IBD_TRSP_ISS_DT, C.CGO_ARR_ACPT_DT," ).append("\n"); 
		query.append("        I.USA_LST_LOC_CD, IBD.IBD_TRSP_ACPT_DT, C.XPT_DT, C.XPT_ACPT_DT," ).append("\n"); 
		query.append("        C.PKUP_NO, C.AVAL_DT, C.YD_CD, C.CNMV_STS_CD," ).append("\n"); 
		query.append("        R.FRT_CLT_FLG, R.OBL_RDEM_FLG, R.CSTMS_CLR_CD, C.ARR_FLG, C.XPT_FLG " ).append("\n"); 
		query.append("    )    A" ).append("\n"); 
		query.append("--ORDER BY A.CNTR_NO, A.BL_NO, A.POD_CD, A.HUB_LOC_CD, A.IBD_TRSP_NO" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("select A.CNTR_NO, A.BL_NO, A.VVD, A.DEL_CD, A.CSTMS_LOC_CD, A.IBD_TRSP_NO," ).append("\n"); 
		query.append("    A.IBD_TP_CD, A.ARR_DT, A.TRSP_ISS_DT, A.ARR_TIME, A.TRSP_ISS_TIME," ).append("\n"); 
		query.append("    A.USA_LST_LOC_CD, A.MJR_IBD_AUTH_DT, A.MJR_IBD_AUTH_TIME, A.XPT_DT, A.XPT_TIME, " ).append("\n"); 
		query.append("    A.XPT_ACPT_DT, A.XPT_ACPT_TIME, A.CNMV_STS_CD, A.CSTMS_POD_CD, A.POD_CD, A.HUB_LOC_CD," ).append("\n"); 
		query.append("    A.FRT_CLT_FLG, A.OBL_RDEM_FLG, A.CSTMS_CLR_CD, " ).append("\n"); 
		query.append("    A.ARR_FLG, A.XPT_FLG," ).append("\n"); 
		query.append("    A.TRSP_AUTH_DT, A.TRSP_AUTH_TIME," ).append("\n"); 
		query.append("    A.PKUP_NO, A.YD_CD, A.AVAL_DT, 'B' BL_CNTR_FLAG," ).append("\n"); 
		query.append("	TO_CHAR(GLOBALDATE_PKG.TIME_CONV_FNC ('KRACY', sysdate, 'USNYC'), 'YYYY-MM-DD HH24:MI') USDATE," ).append("\n"); 
		query.append("	A.ARR_DT || A.ARR_TIME ARR_DT_BEFORE," ).append("\n"); 
		query.append("	A.XPT_DT || A.XPT_TIME XPT_DT_BEFORE," ).append("\n"); 
		query.append("	'' PARTIAL_CNTR_NO," ).append("\n"); 
		query.append("	'' LCL_FLG," ).append("\n"); 
		query.append("	'' INBOND_LOCAL," ).append("\n"); 
		query.append("	'' LOCAL_BL_CNT,	-- 0408에서 사용됨" ).append("\n"); 
		query.append("	'' TOTAL_BL_CNT		-- 0408에서 사용됨" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("FROM          " ).append("\n"); 
		query.append("    (" ).append("\n"); 
		query.append("    select" ).append("\n"); 
		query.append("#if (${arr_gubun} == '1' || ${arr_gubun} == 'on')" ).append("\n"); 
		query.append("		/*+ INDEX(I XPKBKG_CSTMS_ADV_BL) */" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("        ' ' CNTR_NO, I.BKG_NO," ).append("\n"); 
		query.append("        I.BL_NO BL_NO, I.VSL_CD || I.SKD_VOY_NO || I.SKD_DIR_CD VVD," ).append("\n"); 
		query.append("        I.DEL_CD, I.CSTMS_LOC_CD, IBD.IBD_TRSP_NO, IBD.IBD_TRSP_TP_CD IBD_TP_CD, to_char(IBD.IBD_TRSP_ARR_DT,'yyyy-mm-dd') ARR_DT," ).append("\n"); 
		query.append("        to_char(IBD.IBD_TRSP_ARR_ACPT_DT, 'YYYY-MM-DD') TRSP_AUTH_DT," ).append("\n"); 
		query.append("        to_char(IBD.IBD_TRSP_ISS_DT,'yyyy-mm-dd') TRSP_ISS_DT," ).append("\n"); 
		query.append("        NVL(to_char(IBD.IBD_TRSP_ARR_DT,'HH24:MI'),'') ARR_TIME," ).append("\n"); 
		query.append("        to_char(IBD.IBD_TRSP_ARR_ACPT_DT, 'HH24:MI') TRSP_AUTH_TIME," ).append("\n"); 
		query.append("        to_char(IBD.IBD_TRSP_ISS_DT,'HH24:MI') TRSP_ISS_TIME," ).append("\n"); 
		query.append("        I.USA_LST_LOC_CD," ).append("\n"); 
		query.append("        to_char(IBD.IBD_TRSP_ACPT_DT,'yyyy-mm-dd') MJR_IBD_AUTH_DT, to_char(IBD.IBD_TRSP_ACPT_DT,'HH24:MI') MJR_IBD_AUTH_TIME," ).append("\n"); 
		query.append("        to_char(IBD.IBD_TRSP_XPT_DT,'yyyy-mm-dd') XPT_DT, NVL(to_char(IBD.IBD_TRSP_XPT_DT,'HH24:MI'),'') XPT_TIME," ).append("\n"); 
		query.append("        to_char(IBD.IBD_TRSP_XPT_ACPT_DT,'yyyy-mm-dd') XPT_ACPT_DT, to_char(IBD.IBD_TRSP_XPT_ACPT_DT,'HH24:MI') XPT_ACPT_TIME," ).append("\n"); 
		query.append("        ' ' PKUP_NO, ' ' AVAL_DT, ' ' YD_CD,  ' ' CNMV_STS_CD," ).append("\n"); 
		query.append("        I.CSTMS_POD_CD, I.POD_CD, I.HUB_LOC_CD, R.FRT_CLT_FLG, R.OBL_RDEM_FLG, R.CSTMS_CLR_CD," ).append("\n"); 
		query.append("        DECODE(IBD.IBD_TRSP_ARR_SND_FLG, 'Y','Y', ' ') ARR_FLG, DECODE(IBD.IBD_TRSP_XPT_SND_FLG, 'Y','Y', ' ') XPT_FLG" ).append("\n"); 
		query.append("    from BKG_CSTMS_ADV_IBD IBD, BKG_CSTMS_ADV_BL I, BKG_CGO_RLSE R, BKG_CSTMS_ADV_RSLT R2" ).append("\n"); 
		query.append("    WHERE	I.CNT_CD = 'US'" ).append("\n"); 
		query.append("		AND I.CNT_CD = IBD.CNT_CD" ).append("\n"); 
		query.append("        AND I.BL_NO = IBD.BL_NO" ).append("\n"); 
		query.append("        AND I.BL_NO = R.BL_NO(+)" ).append("\n"); 
		query.append("        AND I.CNT_CD = R2.CNT_CD(+)" ).append("\n"); 
		query.append("        AND I.BL_NO = R2.BL_NO(+)" ).append("\n"); 
		query.append("		AND I.MF_NO IS NULL" ).append("\n"); 
		query.append("		AND R2.DSPO_CD(+) = '1J'" ).append("\n"); 
		query.append("		AND R2.ENTR_NO(+) LIKE 'V5N%' " ).append("\n"); 
		query.append("		AND R2.RCV_LOC_CD(+) LIKE 'US%'" ).append("\n"); 
		query.append("		AND R2.CSTMS_SEQ(+) > 0" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("		#if (${vvd} != '')" ).append("\n"); 
		query.append("		AND I.VSL_CD = SUBSTR(@[vvd],1,4)" ).append("\n"); 
		query.append("		AND I.SKD_VOY_NO = SUBSTR(@[vvd], 5, 4)" ).append("\n"); 
		query.append("		AND I.SKD_DIR_CD = SUBSTR(@[vvd], 9, 1)" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("		#if (${pod} != '')" ).append("\n"); 
		query.append("		AND I.CSTMS_POD_CD = @[pod]" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${arr_gubun} == '1' || ${arr_gubun} == 'on') " ).append("\n"); 
		query.append("	#if (${eq_ofc} != '' ) " ).append("\n"); 
		query.append("		AND NVL(I.DEL_CD, ' ') IN (SELECT LOC_CD FROM MDM_LOCATION WHERE NVL(EQ_CTRL_OFC_CD,' ') LIKE @[eq_ofc]|| '%')" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("	#if (${fromd} != '') " ).append("\n"); 
		query.append("		AND IBD.IBD_TRSP_ARR_DT >= TO_DATE(REPLACE(REPLACE(@[fromd], '-', ''), '/', '') ||' '|| REPLACE(@[fromt], ':', '') ,'YYYYMMDD HH24MI')" ).append("\n"); 
		query.append("	#end " ).append("\n"); 
		query.append("	#if (${tod} != '') " ).append("\n"); 
		query.append("		AND IBD.IBD_TRSP_ARR_DT < TO_DATE(REPLACE(REPLACE(@[tod], '-', ''), '/', '') ||' '|| REPLACE(@[tot], ':', '') ,'YYYYMMDD HH24MI')+1" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${ibd_tp_cd} == 'All') " ).append("\n"); 
		query.append("		AND 1=1" ).append("\n"); 
		query.append("#elseif (${ibd_tp_cd} == '612') " ).append("\n"); 
		query.append("		AND IBD.IBD_TRSP_TP_CD IN ('61','62')" ).append("\n"); 
		query.append("#elseif (${ibd_tp_cd} == '623') " ).append("\n"); 
		query.append("		AND IBD.IBD_TRSP_TP_CD IN ('62','63')" ).append("\n"); 
		query.append("#else " ).append("\n"); 
		query.append("		AND IBD.IBD_TRSP_TP_CD = @[ibd_tp_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${arr_dt} != '') " ).append("\n"); 
		query.append("		AND NVL(IBD.IBD_TRSP_ARR_SND_FLG, 'N') = @[arr_dt]" ).append("\n"); 
		query.append("#end " ).append("\n"); 
		query.append("#if (${xpt_dt} != '') " ).append("\n"); 
		query.append("		AND NVL(IBD.IBD_TRSP_XPT_SND_FLG, 'N') = @[xpt_dt]" ).append("\n"); 
		query.append("#end " ).append("\n"); 
		query.append("#if (${edi_error} == 'NA') " ).append("\n"); 
		query.append("		AND IBD.IBD_TRSP_ARR_ACPT_DT IS NULL AND @[edi_error] = @[edi_error]" ).append("\n"); 
		query.append("#elseif (${edi_error} == 'NE') " ).append("\n"); 
		query.append("		AND IBD.IBD_TRSP_XPT_ACPT_DT IS NULL" ).append("\n"); 
		query.append("#end " ).append("\n"); 
		query.append("        AND CASE " ).append("\n"); 
		query.append("            WHEN NVL(@[hub], 'X') = 'X' THEN 1" ).append("\n"); 
		query.append("            WHEN NVL(@[hub], ' ') = 'USCHI' THEN" ).append("\n"); 
		query.append("                INSTR('USCHI,USCLE,USCMH,USCVG,USDET,USDWH,USEVA,USFAR,USGRB,USGRR,USIND,USMKE,USMRV,USMSP,USOMA,USPIA,USRXG,USSDF,USSGF,USSTE,USSTL,USTOL,USWRZ,USDAY,USMKC,USDSM,USKCK', I.HUB_LOC_CD)" ).append("\n"); 
		query.append("            ELSE" ).append("\n"); 
		query.append("                INSTR(I.HUB_LOC_CD, @[hub])" ).append("\n"); 
		query.append("            END  > 0" ).append("\n"); 
		query.append("		AND I.MF_STS_CD = 'A'" ).append("\n"); 
		query.append("		" ).append("\n"); 
		query.append("		AND IBD.IBD_TRSP_NO LIKE 'V5N%'" ).append("\n"); 
		query.append("    GROUP BY  " ).append("\n"); 
		query.append("        I.BKG_NO, I.BL_NO, I.VSL_CD, I.SKD_VOY_NO, I.SKD_DIR_CD, I.CSTMS_POD_CD, I.POD_CD, I.HUB_LOC_CD," ).append("\n"); 
		query.append("        I.DEL_CD, I.CSTMS_LOC_CD, IBD.IBD_TRSP_NO, IBD.IBD_TRSP_TP_CD, IBD.IBD_TRSP_ARR_DT," ).append("\n"); 
		query.append("        IBD.IBD_TRSP_ISS_DT, IBD.IBD_TRSP_ARR_ACPT_DT," ).append("\n"); 
		query.append("        I.USA_LST_LOC_CD, IBD.IBD_TRSP_ACPT_DT, IBD.IBD_TRSP_XPT_DT, IBD.IBD_TRSP_XPT_ACPT_DT," ).append("\n"); 
		query.append("        R.FRT_CLT_FLG, R.OBL_RDEM_FLG, R.CSTMS_CLR_CD, IBD.IBD_TRSP_ARR_SND_FLG, IBD.IBD_TRSP_XPT_SND_FLG " ).append("\n"); 
		query.append("    )    A" ).append("\n"); 
		query.append("--ORDER BY A.BL_NO, A.VVD, A.POD_CD, A.HUB_LOC_CD, A.DEL_CD, A.IBD_TRSP_NO" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}