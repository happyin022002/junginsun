/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : TariffMgtDBDAOsearchDisposalTariffQuarterListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.10.04
*@LastModifier : 장준우
*@LastVersion : 1.0
* 2010.10.04 장준우
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.mnr.agreementmanage.tariffmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Jang Jun-Woo
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TariffMgtDBDAOsearchDisposalTariffQuarterListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 분기별 지역별 매각기준 가격정보 현황을 조회합니다.
	  * </pre>
	  */
	public TariffMgtDBDAOsearchDisposalTariffQuarterListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("p_eq_knd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("p_trf_eff_yr",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("p_loc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("p_trf_eff_qtr_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("p_loc_tp",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.mnr.agreementmanage.tariffmgt.integration").append("\n"); 
		query.append("FileName : TariffMgtDBDAOsearchDisposalTariffQuarterListRSQL").append("\n"); 
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
		query.append("SELECT  A.TRF_EFF_YR, A.TRF_EFF_QTR_NO, A.EQ_KND_CD," ).append("\n"); 
		query.append("        A.TRF_EFF_QTR_NO||'/4 QTA' AS TRF_EFF_QTR_NM,           " ).append("\n"); 
		query.append("        DECODE(A.EQ_KND_CD, 'U', 'Container','Z','Chassis','M.G.Set') AS EQ_KND_NM, " ).append("\n"); 
		query.append("        A.RCC_CD, A.LOC_CD, A.LOC_CNT, A.CURR_CD,    " ).append("\n"); 
		query.append("        NVL2(A.LOC_CD, A.TPSZ_DP01, A.TPSZ_DP01/A.LOC_CNT) AS TPSZ_DP01,         " ).append("\n"); 
		query.append("        NVL2(A.LOC_CD, A.TPSZ_DP02, A.TPSZ_DP02/A.LOC_CNT) AS TPSZ_DP02," ).append("\n"); 
		query.append("        NVL2(A.LOC_CD, A.TPSZ_DP03, A.TPSZ_DP03/A.LOC_CNT) AS TPSZ_DP03," ).append("\n"); 
		query.append("        NVL2(A.LOC_CD, A.TPSZ_DP04, A.TPSZ_DP04/A.LOC_CNT) AS TPSZ_DP04,         " ).append("\n"); 
		query.append("        NVL2(A.LOC_CD, A.TPSZ_DP05, A.TPSZ_DP05/A.LOC_CNT) AS TPSZ_DP05," ).append("\n"); 
		query.append("        NVL2(A.LOC_CD, A.TPSZ_DP06, A.TPSZ_DP06/A.LOC_CNT) AS TPSZ_DP06," ).append("\n"); 
		query.append("        NVL2(A.LOC_CD, A.TPSZ_DP07, A.TPSZ_DP07/A.LOC_CNT) AS TPSZ_DP07," ).append("\n"); 
		query.append("        NVL2(A.LOC_CD, A.TPSZ_DP08, A.TPSZ_DP08/A.LOC_CNT) AS TPSZ_DP08," ).append("\n"); 
		query.append("        NVL2(A.LOC_CD, A.TPSZ_DP09, A.TPSZ_DP09/A.LOC_CNT) AS TPSZ_DP09," ).append("\n"); 
		query.append("        NVL2(A.LOC_CD, A.TPSZ_DP10, A.TPSZ_DP10/A.LOC_CNT) AS TPSZ_DP10," ).append("\n"); 
		query.append("        NVL2(A.LOC_CD, A.TPSZ_DP11, A.TPSZ_DP11/A.LOC_CNT) AS TPSZ_DP11," ).append("\n"); 
		query.append("        NVL2(A.LOC_CD, A.TPSZ_DP12, A.TPSZ_DP12/A.LOC_CNT) AS TPSZ_DP12," ).append("\n"); 
		query.append("        NVL2(A.LOC_CD, A.TPSZ_DP13, A.TPSZ_DP13/A.LOC_CNT) AS TPSZ_DP13," ).append("\n"); 
		query.append("        NVL2(A.LOC_CD, A.TPSZ_DP14, A.TPSZ_DP14/A.LOC_CNT) AS TPSZ_DP14,         " ).append("\n"); 
		query.append("        NVL2(A.LOC_CD, A.TPSZ_DP15, A.TPSZ_DP15/A.LOC_CNT) AS TPSZ_DP15," ).append("\n"); 
		query.append("        NVL2(A.LOC_CD, A.TPSZ_DP16, A.TPSZ_DP16/A.LOC_CNT) AS TPSZ_DP16," ).append("\n"); 
		query.append("        NVL2(A.LOC_CD, A.TPSZ_DP17, A.TPSZ_DP17/A.LOC_CNT) AS TPSZ_DP17," ).append("\n"); 
		query.append("        NVL2(A.LOC_CD, A.TPSZ_DP18, A.TPSZ_DP18/A.LOC_CNT) AS TPSZ_DP18," ).append("\n"); 
		query.append("        NVL2(A.LOC_CD, A.TPSZ_DP19, A.TPSZ_DP19/A.LOC_CNT) AS TPSZ_DP19," ).append("\n"); 
		query.append("        NVL2(A.LOC_CD, A.TPSZ_DP20, A.TPSZ_DP20/A.LOC_CNT) AS TPSZ_DP20," ).append("\n"); 
		query.append("        NVL2(A.LOC_CD, A.TPSZ_DP21, A.TPSZ_DP21/A.LOC_CNT) AS TPSZ_DP21," ).append("\n"); 
		query.append("        NVL2(A.LOC_CD, A.TPSZ_DP22, A.TPSZ_DP22/A.LOC_CNT) AS TPSZ_DP22," ).append("\n"); 
		query.append("        NVL2(A.LOC_CD, A.TPSZ_DP23, A.TPSZ_DP23/A.LOC_CNT) AS TPSZ_DP23," ).append("\n"); 
		query.append("        NVL2(A.LOC_CD, A.TPSZ_DP24, A.TPSZ_DP24/A.LOC_CNT) AS TPSZ_DP24,         " ).append("\n"); 
		query.append("        NVL2(A.LOC_CD, A.TPSZ_DP25, A.TPSZ_DP25/A.LOC_CNT) AS TPSZ_DP25," ).append("\n"); 
		query.append("        NVL2(A.LOC_CD, A.TPSZ_DP26, A.TPSZ_DP26/A.LOC_CNT) AS TPSZ_DP26," ).append("\n"); 
		query.append("        NVL2(A.LOC_CD, A.TPSZ_DP27, A.TPSZ_DP27/A.LOC_CNT) AS TPSZ_DP27," ).append("\n"); 
		query.append("        NVL2(A.LOC_CD, A.TPSZ_DP28, A.TPSZ_DP28/A.LOC_CNT) AS TPSZ_DP28," ).append("\n"); 
		query.append("        NVL2(A.LOC_CD, A.TPSZ_DP29, A.TPSZ_DP29/A.LOC_CNT) AS TPSZ_DP29," ).append("\n"); 
		query.append("        NVL2(A.LOC_CD, A.TPSZ_DP30, A.TPSZ_DP30/A.LOC_CNT) AS TPSZ_DP30" ).append("\n"); 
		query.append("FROM   (SELECT  MAX(A.TRF_EFF_YR) AS TRF_EFF_YR, A.TRF_EFF_QTR_NO, " ).append("\n"); 
		query.append("                MAX(A.EQ_KND_CD) AS EQ_KND_CD, A.RCC_CD, A.LOC_CD, A.CURR_CD," ).append("\n"); 
		query.append("				CASE WHEN A.RCC_CD IS NULL THEN 1" ).append("\n"); 
		query.append("                     ELSE COUNT(A.LOC_CD) OVER(PARTITION BY A.TRF_EFF_QTR_NO, A.RCC_CD, A.CURR_CD)" ).append("\n"); 
		query.append("                END LOC_CNT,                                         " ).append("\n"); 
		query.append("                SUM(CASE WHEN A.RPT_DP_SEQ = 1 THEN A.MNR_DISP_TRF_AMT END) AS TPSZ_DP01," ).append("\n"); 
		query.append("                SUM(CASE WHEN A.RPT_DP_SEQ = 2 THEN A.MNR_DISP_TRF_AMT END) AS TPSZ_DP02,  " ).append("\n"); 
		query.append("                SUM(CASE WHEN A.RPT_DP_SEQ = 3 THEN A.MNR_DISP_TRF_AMT END) AS TPSZ_DP03," ).append("\n"); 
		query.append("                SUM(CASE WHEN A.RPT_DP_SEQ = 4 THEN A.MNR_DISP_TRF_AMT END) AS TPSZ_DP04," ).append("\n"); 
		query.append("                SUM(CASE WHEN A.RPT_DP_SEQ = 5 THEN A.MNR_DISP_TRF_AMT END) AS TPSZ_DP05," ).append("\n"); 
		query.append("                SUM(CASE WHEN A.RPT_DP_SEQ = 6 THEN A.MNR_DISP_TRF_AMT END) AS TPSZ_DP06," ).append("\n"); 
		query.append("                SUM(CASE WHEN A.RPT_DP_SEQ = 7 THEN A.MNR_DISP_TRF_AMT END) AS TPSZ_DP07," ).append("\n"); 
		query.append("                SUM(CASE WHEN A.RPT_DP_SEQ = 8 THEN A.MNR_DISP_TRF_AMT END) AS TPSZ_DP08," ).append("\n"); 
		query.append("                SUM(CASE WHEN A.RPT_DP_SEQ = 9 THEN A.MNR_DISP_TRF_AMT END) AS TPSZ_DP09," ).append("\n"); 
		query.append("                SUM(CASE WHEN A.RPT_DP_SEQ =10 THEN A.MNR_DISP_TRF_AMT END) AS TPSZ_DP10," ).append("\n"); 
		query.append("                SUM(CASE WHEN A.RPT_DP_SEQ =11 THEN A.MNR_DISP_TRF_AMT END) AS TPSZ_DP11," ).append("\n"); 
		query.append("                SUM(CASE WHEN A.RPT_DP_SEQ =12 THEN A.MNR_DISP_TRF_AMT END) AS TPSZ_DP12," ).append("\n"); 
		query.append("                SUM(CASE WHEN A.RPT_DP_SEQ =13 THEN A.MNR_DISP_TRF_AMT END) AS TPSZ_DP13," ).append("\n"); 
		query.append("                SUM(CASE WHEN A.RPT_DP_SEQ =14 THEN A.MNR_DISP_TRF_AMT END) AS TPSZ_DP14," ).append("\n"); 
		query.append("                SUM(CASE WHEN A.RPT_DP_SEQ =15 THEN A.MNR_DISP_TRF_AMT END) AS TPSZ_DP15," ).append("\n"); 
		query.append("                SUM(CASE WHEN A.RPT_DP_SEQ =16 THEN A.MNR_DISP_TRF_AMT END) AS TPSZ_DP16," ).append("\n"); 
		query.append("                SUM(CASE WHEN A.RPT_DP_SEQ =17 THEN A.MNR_DISP_TRF_AMT END) AS TPSZ_DP17," ).append("\n"); 
		query.append("                SUM(CASE WHEN A.RPT_DP_SEQ =18 THEN A.MNR_DISP_TRF_AMT END) AS TPSZ_DP18," ).append("\n"); 
		query.append("                SUM(CASE WHEN A.RPT_DP_SEQ =19 THEN A.MNR_DISP_TRF_AMT END) AS TPSZ_DP19," ).append("\n"); 
		query.append("                SUM(CASE WHEN A.RPT_DP_SEQ =20 THEN A.MNR_DISP_TRF_AMT END) AS TPSZ_DP20," ).append("\n"); 
		query.append("                SUM(CASE WHEN A.RPT_DP_SEQ =21 THEN A.MNR_DISP_TRF_AMT END) AS TPSZ_DP21," ).append("\n"); 
		query.append("                SUM(CASE WHEN A.RPT_DP_SEQ =22 THEN A.MNR_DISP_TRF_AMT END) AS TPSZ_DP22,  " ).append("\n"); 
		query.append("                SUM(CASE WHEN A.RPT_DP_SEQ =23 THEN A.MNR_DISP_TRF_AMT END) AS TPSZ_DP23," ).append("\n"); 
		query.append("                SUM(CASE WHEN A.RPT_DP_SEQ =24 THEN A.MNR_DISP_TRF_AMT END) AS TPSZ_DP24," ).append("\n"); 
		query.append("                SUM(CASE WHEN A.RPT_DP_SEQ =25 THEN A.MNR_DISP_TRF_AMT END) AS TPSZ_DP25," ).append("\n"); 
		query.append("                SUM(CASE WHEN A.RPT_DP_SEQ =26 THEN A.MNR_DISP_TRF_AMT END) AS TPSZ_DP26," ).append("\n"); 
		query.append("                SUM(CASE WHEN A.RPT_DP_SEQ =27 THEN A.MNR_DISP_TRF_AMT END) AS TPSZ_DP27," ).append("\n"); 
		query.append("                SUM(CASE WHEN A.RPT_DP_SEQ =28 THEN A.MNR_DISP_TRF_AMT END) AS TPSZ_DP28," ).append("\n"); 
		query.append("                SUM(CASE WHEN A.RPT_DP_SEQ =29 THEN A.MNR_DISP_TRF_AMT END) AS TPSZ_DP29," ).append("\n"); 
		query.append("                SUM(CASE WHEN A.RPT_DP_SEQ =30 THEN A.MNR_DISP_TRF_AMT END) AS TPSZ_DP30 " ).append("\n"); 
		query.append("        FROM   (SELECT  A.TRF_EFF_YR, A.TRF_EFF_QTR_NO, A.EQ_KND_CD, A.EQ_TPSZ_CD," ).append("\n"); 
		query.append("                        DECODE(@[p_loc_tp], '1',A.LCC_CD, '2',A.SCC_CD, A.RCC_CD) AS RCC_CD," ).append("\n"); 
		query.append("                        A.LOC_CD, A.CURR_CD, A.MNR_DISP_TRF_AMT, B.RPT_DP_SEQ" ).append("\n"); 
		query.append("                FROM   (SELECT  A.TRF_EFF_YR, A.TRF_EFF_QTR_NO, A.MNR_DISP_TRF_SEQ, A.EQ_KND_CD, " ).append("\n"); 
		query.append("                                A.EQ_TPSZ_CD, B.RCC_CD, B.LCC_CD, B.SCC_CD,     " ).append("\n"); 
		query.append("                                A.LOC_CD, A.CURR_CD, " ).append("\n"); 
		query.append("                                A.MNR_DISP_TRF_AMT, A.MNR_TRF_RMK, " ).append("\n"); 
		query.append("                                A.CRE_OFC_CD, A.CRE_USR_ID, A.CRE_DT, A.UPD_USR_ID, A.UPD_DT        " ).append("\n"); 
		query.append("                        FROM    MNR_DISP_TRF A," ).append("\n"); 
		query.append("                               (SELECT  A.LOC_CD, A.RGN_CD, A.SCC_CD, A.EQ_CTRL_OFC_CD," ).append("\n"); 
		query.append("                                        C.LCC_CD, C.ECC_CD, C.RCC_CD" ).append("\n"); 
		query.append("                                FROM    MDM_LOCATION A,  " ).append("\n"); 
		query.append("                                        MDM_EQ_ORZ_CHT C        " ).append("\n"); 
		query.append("                                WHERE   A.SCC_CD = C.SCC_CD" ).append("\n"); 
		query.append("                                AND     NVL(A.DELT_FLG, 'N') <> 'Y'" ).append("\n"); 
		query.append("                                ) B" ).append("\n"); 
		query.append("                        WHERE   A.LOC_CD = B.LOC_CD" ).append("\n"); 
		query.append("                        AND     A.TRF_EFF_YR = @[p_trf_eff_yr]" ).append("\n"); 
		query.append("#if (${p_trf_eff_qtr_no} != '') " ).append("\n"); 
		query.append("                        AND     A.TRF_EFF_QTR_NO = @[p_trf_eff_qtr_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${p_eq_knd_cd} != '') " ).append("\n"); 
		query.append("                        AND     A.EQ_KND_CD = @[p_eq_knd_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${p_loc_tp} == '1' && ${p_loc_cd} != '')" ).append("\n"); 
		query.append("                        AND     B.RCC_CD = @[p_loc_cd]" ).append("\n"); 
		query.append("#elseif (${p_loc_tp} == '2' && ${p_loc_cd} != '')" ).append("\n"); 
		query.append("                        AND     B.LCC_CD = @[p_loc_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("                        ) A," ).append("\n"); 
		query.append("                       (SELECT  A.EQ_KND_CD, A.EQ_TPSZ_CD, " ).append("\n"); 
		query.append("                                ROW_NUMBER() OVER(PARTITION BY A.EQ_KND_CD ORDER BY A.DP_SEQ) AS RPT_DP_SEQ" ).append("\n"); 
		query.append("                        FROM   (SELECT  EQ_KND_CD, EQ_TPSZ_CD, DP_SEQ" ).append("\n"); 
		query.append("                                FROM    CGM_EQ_TP_SZ" ).append("\n"); 
		query.append("                                UNION ALL" ).append("\n"); 
		query.append("                                SELECT  'U' AS EQ_KND_CD, CNTR_TPSZ_CD, RPT_DP_SEQ   " ).append("\n"); 
		query.append("                                FROM    MDM_CNTR_TP_SZ" ).append("\n"); 
		query.append("                                ) A                " ).append("\n"); 
		query.append("                        ) B" ).append("\n"); 
		query.append("                WHERE   A.EQ_KND_CD  = B.EQ_KND_CD" ).append("\n"); 
		query.append("                AND     A.EQ_TPSZ_CD = B.EQ_TPSZ_CD   " ).append("\n"); 
		query.append("                ) A                  " ).append("\n"); 
		query.append("#if (${p_loc_tp} != '2')                      " ).append("\n"); 
		query.append("        GROUP BY ROLLUP(A.TRF_EFF_QTR_NO, A.RCC_CD, A.CURR_CD, A.LOC_CD)" ).append("\n"); 
		query.append("#else                                    " ).append("\n"); 
		query.append("        GROUP BY A.TRF_EFF_QTR_NO, A.RCC_CD, A.CURR_CD, A.LOC_CD" ).append("\n"); 
		query.append("#end        " ).append("\n"); 
		query.append("        ) A                  " ).append("\n"); 
		query.append("WHERE  (A.CURR_CD IS NOT NULL    " ).append("\n"); 
		query.append("OR      A.RCC_CD IS NULL)" ).append("\n"); 
		query.append("ORDER BY A.TRF_EFF_QTR_NO, A.RCC_CD, A.CURR_CD, A.LOC_CD" ).append("\n"); 

	}
}