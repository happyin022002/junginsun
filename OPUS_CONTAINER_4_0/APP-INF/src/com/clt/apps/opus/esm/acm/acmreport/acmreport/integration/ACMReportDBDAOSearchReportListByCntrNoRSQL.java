/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : ACMReportDBDAOSearchReportListByCntrNoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.12.29
*@LastModifier : 
*@LastVersion : 1.0
* 2014.12.29 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.acm.acmreport.acmreport.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ACMReportDBDAOSearchReportListByCntrNoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchReportListByCntrNo
	  * </pre>
	  */
	public ACMReportDBDAOSearchReportListByCntrNoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("to_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ar_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ob_sls_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("comm_vvd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pol_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_rlane_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("agn_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("del_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("io_bnd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("por_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("aud_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fm_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_trd_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.acm.acmreport.acmreport.integration").append("\n"); 
		query.append("FileName : ACMReportDBDAOSearchReportListByCntrNoRSQL").append("\n"); 
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
		query.append("SELECT " ).append("\n"); 
		query.append("        CNTR_NO" ).append("\n"); 
		query.append("        , CNTR_TPSZ_CD" ).append("\n"); 
		query.append("        , A.BKG_NO" ).append("\n"); 
		query.append("        , A.BKG_NO AS BL_NO" ).append("\n"); 
		query.append("        , AGN_CD" ).append("\n"); 
		query.append("        , IO_BND_CD" ).append("\n"); 
		query.append("        , MAX (A.AC_VSL_CD||A.AC_SKD_VOY_NO||A.AC_SKD_DIR_CD) AS COMM_VVD" ).append("\n"); 
		query.append("        , MAX (TO_CHAR (TO_DATE (SAIL_ARR_DT, 'YYYYMMDD'), 'YYYY-MM-DD')) AS SAIL_ARR_DT" ).append("\n"); 
		query.append("        , INF.POR_CD AS POR_CD" ).append("\n"); 
		query.append("        , INF.POL_CD AS POL_CD" ).append("\n"); 
		query.append("        , INF.POD_CD AS POD_CD" ).append("\n"); 
		query.append("        , INF.DEL_CD AS DEL_CD" ).append("\n"); 
		query.append("        , NVL (SUM (DECODE (A.AC_TP_CD, 'H', A.IF_QTY_AMT, 0 )), 0) AS CHF_AMT" ).append("\n"); 
		query.append("        , NVL (SUM (DECODE (A.AC_TP_CD, 'N', A.IF_QTY_AMT, 0 )), 0) AS CSF_AMT" ).append("\n"); 
		query.append("        , NVL (SUM (DECODE (A.AC_TP_CD, 'R', A.IF_QTY_AMT, 0 )), 0) AS RCSF_AMT    " ).append("\n"); 
		query.append("        , MAX (A.CURR_CD) AS CURR_CD" ).append("\n"); 
		query.append("        , MAX (TO_CHAR (A.CRE_DT, 'YYYY-MM-DD')) AS CALC_DT" ).append("\n"); 
		query.append("        , MAX (TO_CHAR (A.RQST_DT, 'YYYY-MM-DD')) AS RQST_DT" ).append("\n"); 
		query.append("        , MAX (TO_CHAR (A.APRO_DT, 'YYYY-MM-DD')) AS APRO_DT" ).append("\n"); 
		query.append("        , MAX (TO_CHAR (A.IF_DT, 'YYYY-MM-DD')) AS IF_DT " ).append("\n"); 
		query.append("        " ).append("\n"); 
		query.append("         , (MAX (INF.FRT_FWRD_CNT_CD) || TO_CHAR (MAX (INF.FRT_FWRD_SEQ), 'FM000000')) AS FF_CD" ).append("\n"); 
		query.append("         , MAX (" ).append("\n"); 
		query.append("                 CASE 'BOMBB'" ).append("\n"); 
		query.append("                 WHEN A.AR_OFC_CD THEN NVL ( (SELECT E.CUST_NM" ).append("\n"); 
		query.append("                                  				FROM BKG_CUSTOMER E" ).append("\n"); 
		query.append("                                 			   WHERE INF.BKG_NO = E.BKG_NO" ).append("\n"); 
		query.append("                                   				 AND E.BKG_CUST_TP_CD = 'B' ) " ).append("\n"); 
		query.append("										   , (SELECT E.CUST_NM" ).append("\n"); 
		query.append("                                  				FROM BKG_CUSTOMER E" ).append("\n"); 
		query.append("                                 			   WHERE INF.BKG_NO = E.BKG_NO" ).append("\n"); 
		query.append("                                   				 AND E.BKG_CUST_TP_CD = 'F' ) )" ).append("\n"); 
		query.append("                  ELSE (SELECT NVL(D.CUST_LOCL_LANG_NM, D.CUST_LGL_ENG_NM)" ).append("\n"); 
		query.append("                          FROM MDM_CUSTOMER D," ).append("\n"); 
		query.append("                               BKG_CUSTOMER E" ).append("\n"); 
		query.append("                         WHERE E.CUST_CNT_CD = D.CUST_CNT_CD(+)" ).append("\n"); 
		query.append("                           AND E.CUST_SEQ = D.CUST_SEQ(+)" ).append("\n"); 
		query.append("                           AND INF.BKG_NO = E.BKG_NO(+)" ).append("\n"); 
		query.append("                           AND E.BKG_CUST_TP_CD(+) = 'F' )" ).append("\n"); 
		query.append("                                       END ) AS FF_NAME" ).append("\n"); 
		query.append("         , MAX ( (SELECT E.CUST_ADDR" ).append("\n"); 
		query.append("                    FROM BKG_CUSTOMER E" ).append("\n"); 
		query.append("                   WHERE INF.BKG_NO = E.BKG_NO" ).append("\n"); 
		query.append("                     AND E.BKG_CUST_TP_CD = 'F' ) ) AS FF_ADDR" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("         , MAX (INF.TRD_CD) AS TRD_CD" ).append("\n"); 
		query.append("         , MAX (INF.RLANE_CD) AS RLANE_CD" ).append("\n"); 
		query.append("         , MAX (A.AC_SKD_DIR_CD) AS DIR_CD" ).append("\n"); 
		query.append("         , MAX (A.AUD_NO) AS AUD_NO" ).append("\n"); 
		query.append("  " ).append("\n"); 
		query.append("  FROM (" ).append("\n"); 
		query.append("        SELECT" ).append("\n"); 
		query.append("               CNTR_NO" ).append("\n"); 
		query.append("             , AMT.*     " ).append("\n"); 
		query.append("          FROM" ).append("\n"); 
		query.append("                (SELECT BKG_NO" ).append("\n"); 
		query.append("                     , CNTR_NO" ).append("\n"); 
		query.append("                     , DECODE(SUBSTR(CNTR_TPSZ_CD,1,1), 'R', DECODE (RC_FLG, 'Y', CNTR_TPSZ_CD, SUBSTR(CNTR_TPSZ_CD,1,1)||'D'||SUBSTR(CNTR_TPSZ_CD,2,1)), CNTR_TPSZ_CD) AS CNTR_TPSZ_CD" ).append("\n"); 
		query.append("                     , RC_FLG " ).append("\n"); 
		query.append("                  FROM BKG_CONTAINER" ).append("\n"); 
		query.append("                 ) CNTR" ).append("\n"); 
		query.append("                ," ).append("\n"); 
		query.append("                (SELECT CNTR_TPSZ_CD" ).append("\n"); 
		query.append("                      , (IF_DTRB_AMT/BKG_VOL_QTY) AS IF_QTY_AMT" ).append("\n"); 
		query.append("                      , AGN.* " ).append("\n"); 
		query.append("                   FROM ACM_AGN_COMM_DTL DTL" ).append("\n"); 
		query.append("                       ,ACM_AGN_COMM  AGN" ).append("\n"); 
		query.append("                  WHERE 1=1" ).append("\n"); 
		query.append("                    AND AGN.BKG_NO = DTL.BKG_NO" ).append("\n"); 
		query.append("                    AND AGN.AGN_CD = DTL.AGN_CD" ).append("\n"); 
		query.append("                    AND AGN.IO_BND_CD = DTL.IO_BND_CD" ).append("\n"); 
		query.append("                    AND AGN.AC_TP_CD = DTL.AC_TP_CD" ).append("\n"); 
		query.append("                    AND AGN.AC_SEQ = DTL.AC_SEQ" ).append("\n"); 
		query.append("                 UNION" ).append("\n"); 
		query.append("                 SELECT CNTR_TPSZ_CD" ).append("\n"); 
		query.append("                      , (IF_DTRB_AMT/BKG_VOL_QTY) AS IF_QTY_AMT" ).append("\n"); 
		query.append("                      , AGN.* " ).append("\n"); 
		query.append("                   FROM ACM_AGN_COMM_DTL DTL" ).append("\n"); 
		query.append("                       ,ACM_AGN_COMM  AGN" ).append("\n"); 
		query.append("                  WHERE 1=1" ).append("\n"); 
		query.append("                    AND AGN.BKG_NO = DTL.BKG_NO" ).append("\n"); 
		query.append("                    AND AGN.AGN_CD = DTL.AGN_CD" ).append("\n"); 
		query.append("                    AND AGN.IO_BND_CD = DTL.IO_BND_CD" ).append("\n"); 
		query.append("                    AND AGN.AC_TP_CD = DTL.AC_TP_CD" ).append("\n"); 
		query.append("                    AND AGN.AC_SEQ + 1000 = DTL.AC_SEQ" ).append("\n"); 
		query.append("                  ) AMT" ).append("\n"); 
		query.append("         WHERE 1=1" ).append("\n"); 
		query.append("           AND AMT.BKG_NO = CNTR.BKG_NO" ).append("\n"); 
		query.append("           AND AMT.CNTR_TPSZ_CD = CNTR.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("		) A" ).append("\n"); 
		query.append("        , ACM_AGN_BKG_INFO INF" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("  AND INF.BKG_NO = A.BKG_NO" ).append("\n"); 
		query.append("#if (${agn_cd} != '')" ).append("\n"); 
		query.append("                  AND A.AGN_CD             = @[agn_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${ar_ofc_cd} != '')" ).append("\n"); 
		query.append("                  AND A.AR_OFC_CD          = @[ar_ofc_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${s_trd_cd} != '')" ).append("\n"); 
		query.append("                  AND INF.TRD_CD             = @[s_trd_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${s_rlane_cd} != '')" ).append("\n"); 
		query.append("                  AND INF.RLANE_CD           = @[s_rlane_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${s_dir_cd} != '')" ).append("\n"); 
		query.append("                  AND A.AC_SKD_DIR_CD    = @[s_dir_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("                  AND A.AC_TP_CD" ).append("\n"); 
		query.append("                   IN" ).append("\n"); 
		query.append("                    (" ).append("\n"); 
		query.append("                      'H', 'N', 'R'" ).append("\n"); 
		query.append("                    )" ).append("\n"); 
		query.append("                  AND A.IO_BND_CD" ).append("\n"); 
		query.append("                   IN" ).append("\n"); 
		query.append("                    (" ).append("\n"); 
		query.append("                 CASE @[io_bnd_cd]" ).append("\n"); 
		query.append("                 WHEN 'O'" ).append("\n"); 
		query.append("                 THEN 'O'" ).append("\n"); 
		query.append("                 WHEN 'I'" ).append("\n"); 
		query.append("                 THEN 'I'" ).append("\n"); 
		query.append("                 ELSE A.IO_BND_CD" ).append("\n"); 
		query.append("                  END" ).append("\n"); 
		query.append("                    )" ).append("\n"); 
		query.append("#if (${comm_vvd} != '')" ).append("\n"); 
		query.append("                  AND A.AC_VSL_CD||A.AC_SKD_VOY_NO||A.AC_SKD_DIR_CD = @[comm_vvd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${bkg_ofc_cd} != '')" ).append("\n"); 
		query.append("                  AND INF.BKG_OFC_CD = @[bkg_ofc_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${ob_sls_ofc_cd} != '')" ).append("\n"); 
		query.append("                  AND (SELECT B.OB_SLS_OFC_CD FROM BKG_BOOKING B WHERE B.BKG_NO = A.BKG_NO) IN (@[ob_sls_ofc_cd])" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${por_cd} != '')" ).append("\n"); 
		query.append("                  AND INF.POR_CD = @[por_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${pol_cd} != '')" ).append("\n"); 
		query.append("                  AND INF.POL_CD = @[pol_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${pod_cd} != '')" ).append("\n"); 
		query.append("                  AND INF.POD_CD = @[pod_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${del_cd} != '')" ).append("\n"); 
		query.append("                  AND INF.DEL_CD = @[del_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${bl_no} != '')" ).append("\n"); 
		query.append("                  AND INF.BL_NO IN ( ${bl_no} )" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${aud_no} != '')" ).append("\n"); 
		query.append("                  AND A.AUD_NO = @[aud_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${sts_option} == 'CS')" ).append("\n"); 
		query.append("                  AND A.AC_STS_CD" ).append("\n"); 
		query.append("                   IN" ).append("\n"); 
		query.append("                    (" ).append("\n"); 
		query.append("                      'CS', 'CE', 'IC', 'CA'" ).append("\n"); 
		query.append("                    )" ).append("\n"); 
		query.append("                  AND A.CRE_DT" ).append("\n"); 
		query.append("              BETWEEN TO_DATE (REPLACE(@[fm_dt],'-',''), 'YYYYMMDD')" ).append("\n"); 
		query.append("                  AND TO_DATE (REPLACE(@[to_dt],'-',''), 'YYYYMMDD')+0.999999" ).append("\n"); 
		query.append("#elseif (${sts_option} == 'RS')" ).append("\n"); 
		query.append("                  AND A.AC_STS_CD IN ( 'RS','RM' )" ).append("\n"); 
		query.append("                  AND A.RQST_DT" ).append("\n"); 
		query.append("              BETWEEN TO_DATE (REPLACE(@[fm_dt],'-',''), 'YYYYMMDD')" ).append("\n"); 
		query.append("                  AND TO_DATE (REPLACE(@[to_dt],'-',''), 'YYYYMMDD')+0.999999" ).append("\n"); 
		query.append("#elseif (${sts_option} == 'AS')" ).append("\n"); 
		query.append("                  AND A.AC_STS_CD IN ( 'AS' )" ).append("\n"); 
		query.append("                  AND A.AUD_DT" ).append("\n"); 
		query.append("              BETWEEN TO_DATE (REPLACE(@[fm_dt],'-',''), 'YYYYMMDD')" ).append("\n"); 
		query.append("                  AND TO_DATE (REPLACE(@[to_dt],'-',''), 'YYYYMMDD')+0.999999" ).append("\n"); 
		query.append("#elseif (${sts_option} == 'PS')" ).append("\n"); 
		query.append("                  AND A.AC_STS_CD IN ( 'PS' )" ).append("\n"); 
		query.append("                  AND A.APRO_DT" ).append("\n"); 
		query.append("              BETWEEN TO_DATE (REPLACE(@[fm_dt],'-',''), 'YYYYMMDD')" ).append("\n"); 
		query.append("                  AND TO_DATE (REPLACE(@[to_dt],'-',''), 'YYYYMMDD')+0.999999" ).append("\n"); 
		query.append("#elseif (${sts_option} == 'IS')" ).append("\n"); 
		query.append("                  AND A.AC_STS_CD IN ( 'IF' )" ).append("\n"); 
		query.append("                  AND A.IF_DT" ).append("\n"); 
		query.append("              BETWEEN TO_DATE (REPLACE(@[fm_dt],'-',''), 'YYYYMMDD')" ).append("\n"); 
		query.append("                  AND TO_DATE (REPLACE(@[to_dt],'-',''), 'YYYYMMDD')+0.999999" ).append("\n"); 
		query.append("#elseif (${sts_option} == 'RR')" ).append("\n"); 
		query.append("                  AND A.AC_STS_CD IN ('RR', 'AR', 'PR', 'IC')" ).append("\n"); 
		query.append("                  AND A.UPD_DT" ).append("\n"); 
		query.append("              BETWEEN TO_DATE (REPLACE(@[fm_dt],'-',''), 'YYYYMMDD')" ).append("\n"); 
		query.append("                  AND TO_DATE (REPLACE(@[to_dt],'-',''), 'YYYYMMDD')+0.999999" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("                  AND A.CRE_DT" ).append("\n"); 
		query.append("              BETWEEN TO_DATE (REPLACE(@[fm_dt],'-',''), 'YYYYMMDD')" ).append("\n"); 
		query.append("                  AND TO_DATE (REPLACE(@[to_dt],'-',''), 'YYYYMMDD')+0.999999" ).append("\n"); 
		query.append("#end       " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("GROUP BY CNTR_NO, CNTR_TPSZ_CD, A.BKG_NO, AGN_CD, IO_BND_CD" ).append("\n"); 
		query.append("           , INF.POR_CD, INF.POL_CD, INF.POD_CD, INF.DEL_CD" ).append("\n"); 
		query.append("ORDER BY A.BKG_NO" ).append("\n"); 

	}
}