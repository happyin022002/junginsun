/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : PerformanceReportDBDAODocQueueSummarySRKindVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.08.28
*@LastModifier : 
*@LastVersion : 1.0
* 2013.08.28 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PerformanceReportDBDAODocQueueSummarySRKindVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * PerformanceReportDBDAODocQueueSummarySRKindVORSQL
	  * </pre>
	  */
	public PerformanceReportDBDAODocQueueSummarySRKindVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sr_amd_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fax",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vvd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dpcs_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dura_to_dt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("slan_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("qa",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("srep_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dura_from_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("input",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rate",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("sts",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_nm",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("bkg_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("src_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.integration").append("\n"); 
		query.append("FileName : PerformanceReportDBDAODocQueueSummarySRKindVORSQL").append("\n"); 
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
		query.append("SELECT REGION," ).append("\n"); 
		query.append("       BKG_OFC_CD," ).append("\n"); 
		query.append("       KIND," ).append("\n"); 
		query.append("       TOTAL," ).append("\n"); 
		query.append("       ORIGINAL," ).append("\n"); 
		query.append("       TRIM(TO_CHAR(ROUND(DECODE(ORIGINAL, 0, 0, (ORIGINAL / TOTAL) * 100), 2), '990.99')) AS ORIGINAL_PER," ).append("\n"); 
		query.append("       AMEND," ).append("\n"); 
		query.append("       TRIM(TO_CHAR(ROUND(DECODE(AMEND, 0, 0, (AMEND / TOTAL) * 100), 2), '990.99')) AS AMEND_PER," ).append("\n"); 
		query.append("       ADDITION," ).append("\n"); 
		query.append("       TRIM(TO_CHAR(ROUND(DECODE(ADDITION, 0, 0, (ADDITION / TOTAL) * 100), 2), '990.99')) AS ADDITION_PER," ).append("\n"); 
		query.append("       CUSTOMS," ).append("\n"); 
		query.append("       TRIM(TO_CHAR(ROUND(DECODE(CUSTOMS, 0, 0, (CUSTOMS / TOTAL) * 100), 2), '990.99')) AS CUSTOMS_PER," ).append("\n"); 
		query.append("       BL_CONFIRM," ).append("\n"); 
		query.append("       TRIM(TO_CHAR(ROUND(DECODE(BL_CONFIRM, 0, 0, (BL_CONFIRM / TOTAL) * 100), 2), '990.99')) AS BL_CONFIRM_PER" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("  FROM" ).append("\n"); 
		query.append("       (SELECT REGION," ).append("\n"); 
		query.append("               BKG_OFC_CD," ).append("\n"); 
		query.append("               KIND," ).append("\n"); 
		query.append("               COUNT(*) AS TOTAL," ).append("\n"); 
		query.append("               SUM(DECODE(SR_AMD_TP_CD, 'O', 1, 0)) AS ORIGINAL," ).append("\n"); 
		query.append("               SUM(DECODE(SR_AMD_TP_CD, 'A', 1, 0)) AS AMEND," ).append("\n"); 
		query.append("               SUM(DECODE(SR_AMD_TP_CD, 'T', 1, 0)) AS ADDITION," ).append("\n"); 
		query.append("               SUM(DECODE(SR_AMD_TP_CD, 'E', 1, 'C', 1, 'I', 1, 0)) AS CUSTOMS," ).append("\n"); 
		query.append("               SUM(DECODE(SR_AMD_TP_CD, 'B', 1, 0)) AS BL_CONFIRM" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("          FROM (SELECT NVL((SELECT INTG_CD_VAL_DESC" ).append("\n"); 
		query.append("                              FROM COM_INTG_CD_DTL" ).append("\n"); 
		query.append("                             WHERE INTG_CD_ID = 'CD01603'" ).append("\n"); 
		query.append("                               AND INTG_CD_VAL_CTNT = (SELECT DISTINCT DECODE(RGN_OFC_CD, 'E', 'DE', 'J', 'JP', 'K', 'KR', 'N', 'US', 'S', 'PK', 'C', 'CN', 'XX')" ).append("\n"); 
		query.append("                                                         FROM BKG_EML_ACCT_STUP" ).append("\n"); 
		query.append("                                                        WHERE BKG_OFC_CD = B.BKG_OFC_CD" ).append("\n"); 
		query.append("                                                          AND ROWNUM = 1))," ).append("\n"); 
		query.append("                           '('||B.BKG_OFC_CD||')') AS REGION," ).append("\n"); 
		query.append("                       B.BKG_OFC_CD," ).append("\n"); 
		query.append("                       (SELECT INTG_CD_VAL_DP_DESC" ).append("\n"); 
		query.append("                          FROM COM_INTG_CD_DTL" ).append("\n"); 
		query.append("                         WHERE INTG_CD_ID = 'CD01577'" ).append("\n"); 
		query.append("                           AND (APLY_ST_DT < TO_CHAR(SYSDATE, 'YYYYMMDD') AND APLY_END_DT > TO_CHAR(SYSDATE, 'YYYYMMDD'))" ).append("\n"); 
		query.append("                           AND INTG_CD_VAL_CTNT = A.SR_AMD_TP_CD) AS KIND," ).append("\n"); 
		query.append("                       A.SR_AMD_TP_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                     FROM BKG_SR_CRNT_RQST A," ).append("\n"); 
		query.append("#if (${bkg_no} == '')" ).append("\n"); 
		query.append("     #if (${rgn_cd} != '')" ).append("\n"); 
		query.append("                          BKG_EML_ACCT_STUP EAS," ).append("\n"); 
		query.append("     #end" ).append("\n"); 
		query.append("     #if (${vvd_cd} != '' || (${slan_cd} != '' && ${slan_cd} != 'All'))" ).append("\n"); 
		query.append("                          BKG_VVD VVD," ).append("\n"); 
		query.append("     #end" ).append("\n"); 
		query.append("     #if (${cust_cnt_cd} != '' || ${cust_seq} != '' || ${cust_nm} != '')" ).append("\n"); 
		query.append("                          BKG_CUSTOMER S," ).append("\n"); 
		query.append("                          BKG_CUSTOMER C," ).append("\n"); 
		query.append("                          BKG_CUSTOMER N," ).append("\n"); 
		query.append("                          BKG_CUSTOMER F," ).append("\n"); 
		query.append("     #end" ).append("\n"); 
		query.append("     #if (${srep_cd} != '' || ${split_only_flg} != '')" ).append("\n"); 
		query.append("                          BKG_XTER_RQST_MST XTER," ).append("\n"); 
		query.append("     #end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("                          BKG_BOOKING B" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                    WHERE 1 = 1" ).append("\n"); 
		query.append("                      AND B.BKG_NO = A.BKG_NO" ).append("\n"); 
		query.append("                      AND B.BKG_STS_CD <> 'X'" ).append("\n"); 
		query.append("#if (${bkg_no} == '')" ).append("\n"); 
		query.append("     /* Duration */" ).append("\n"); 
		query.append("     #if (${dura_from_dt} != '' && ${dura_to_dt} !='' )" ).append("\n"); 
		query.append("                      AND A.SR_WRK_STS_DT BETWEEN TO_DATE(@[dura_from_dt], 'YYYY-MM-DD') AND TO_DATE(@[dura_to_dt], 'YYYY-MM-DD') + 1" ).append("\n"); 
		query.append("     #end" ).append("\n"); 
		query.append("     /* Doc OFC */" ).append("\n"); 
		query.append("     #if (${dpcs_ofc_cd} != '')" ).append("\n"); 
		query.append("                      AND A.DPCS_OFC_CD = @[dpcs_ofc_cd]" ).append("\n"); 
		query.append("     #end" ).append("\n"); 
		query.append("     /* Input */" ).append("\n"); 
		query.append("     #if (${input} != '')" ).append("\n"); 
		query.append("                      AND NVL(A.BL_DOC_INP_FLG, 'N') = @[input]" ).append("\n"); 
		query.append("     #end" ).append("\n"); 
		query.append("     /* Rate */" ).append("\n"); 
		query.append("     #if (${rate} != '')" ).append("\n"); 
		query.append("                      AND NVL(A.BL_RT_FLG, 'N') = @[rate]" ).append("\n"); 
		query.append("     #end" ).append("\n"); 
		query.append("     /* Qa */" ).append("\n"); 
		query.append("     #if (${qa} != '')" ).append("\n"); 
		query.append("                      AND NVL(A.BL_AUD_FLG, 'N') = @[qa]" ).append("\n"); 
		query.append("     #end" ).append("\n"); 
		query.append("     /* Fax */" ).append("\n"); 
		query.append("     #if (${fax} != '')" ).append("\n"); 
		query.append("                      AND NVL(A.BL_DRFT_FAX_OUT_FLG, 'N') = @[fax]" ).append("\n"); 
		query.append("     #end" ).append("\n"); 
		query.append("     /* Region */" ).append("\n"); 
		query.append("     #if (${rgn_cd} != '')" ).append("\n"); 
		query.append("                      AND EAS.BKG_OFC_CD = B.BKG_OFC_CD" ).append("\n"); 
		query.append("                      AND EAS.RGN_OFC_CD IN (${rgn_cd})" ).append("\n"); 
		query.append("     #end" ).append("\n"); 
		query.append("     #if (${vvd_cd} != '' || (${slan_cd} != '' && ${slan_cd} != 'All'))" ).append("\n"); 
		query.append("                      AND VVD.BKG_NO = B.BKG_NO" ).append("\n"); 
		query.append("          /* VVD */" ).append("\n"); 
		query.append("          #if (${vvd_cd} != '')" ).append("\n"); 
		query.append("                      AND VVD.VSL_CD||VVD.SKD_VOY_NO||VVD.SKD_DIR_CD LIKE @[vvd_cd]||'%'" ).append("\n"); 
		query.append("          #end" ).append("\n"); 
		query.append("          /* LANE */" ).append("\n"); 
		query.append("          #if (${slan_cd} != '' && ${slan_cd} != 'All')" ).append("\n"); 
		query.append("                      AND VVD.SLAN_CD = @[slan_cd]" ).append("\n"); 
		query.append("          #end" ).append("\n"); 
		query.append("     #end" ).append("\n"); 
		query.append("     /* POL */" ).append("\n"); 
		query.append("     #if (${pol_cd} != '')" ).append("\n"); 
		query.append("                      AND B.POL_CD LIKE @[pol_cd]||'%'" ).append("\n"); 
		query.append("     #end" ).append("\n"); 
		query.append("     /* POD */" ).append("\n"); 
		query.append("     #if (${pod_cd} != '')" ).append("\n"); 
		query.append("                      AND B.POD_CD LIKE @[pod_cd]||'%'" ).append("\n"); 
		query.append("     #end" ).append("\n"); 
		query.append("     /* Booking Office */" ).append("\n"); 
		query.append("     #if (${bkg_ofc_cd} != '')" ).append("\n"); 
		query.append("                      AND B.BKG_OFC_CD LIKE '%'||@[bkg_ofc_cd]||'%'" ).append("\n"); 
		query.append("     #end" ).append("\n"); 
		query.append("     /* STS */" ).append("\n"); 
		query.append("     #if (${sts} == 'X')" ).append("\n"); 
		query.append("                      AND A.SR_CRNT_STS_CD = 'XX'" ).append("\n"); 
		query.append("     #elseif (${sts} != '' && ${sts} != 'A')" ).append("\n"); 
		query.append("                      AND A.SR_WRK_STS_CD = @[sts]" ).append("\n"); 
		query.append("                      AND A.SR_CRNT_STS_CD <> 'XX'" ).append("\n"); 
		query.append("     #else" ).append("\n"); 
		query.append("                      AND A.SR_CRNT_STS_CD <> 'XX'" ).append("\n"); 
		query.append("     #end" ).append("\n"); 
		query.append("     /* SRC */" ).append("\n"); 
		query.append("     #if (${src_cd} != '')" ).append("\n"); 
		query.append("                      AND A.SR_KND_CD = @[src_cd]" ).append("\n"); 
		query.append("     #end" ).append("\n"); 
		query.append("     /* S/R KIND */" ).append("\n"); 
		query.append("     #if (${sr_amd_tp_cd} != '' && ${sr_amd_tp_cd} != 'L')" ).append("\n"); 
		query.append("                      AND A.SR_AMD_TP_CD = @[sr_amd_tp_cd]" ).append("\n"); 
		query.append("     #end" ).append("\n"); 
		query.append("     /* Customer Type에 따른 Customer Code 및 Customer Name이 조건으로 들어온 경우 */" ).append("\n"); 
		query.append("     #if (${cust_cnt_cd} != '' || ${cust_seq} != '' || ${cust_nm} != '')" ).append("\n"); 
		query.append("                      AND S.BKG_NO(+) = A.BKG_NO" ).append("\n"); 
		query.append("                      AND S.BKG_CUST_TP_CD(+) = 'S'" ).append("\n"); 
		query.append("                      AND C.BKG_NO(+) = A.BKG_NO" ).append("\n"); 
		query.append("                      AND C.BKG_CUST_TP_CD(+) = 'C'" ).append("\n"); 
		query.append("                      AND N.BKG_NO(+) = A.BKG_NO" ).append("\n"); 
		query.append("                      AND N.BKG_CUST_TP_CD(+) = 'N'" ).append("\n"); 
		query.append("                      AND F.BKG_NO(+) = A.BKG_NO" ).append("\n"); 
		query.append("                      AND F.BKG_CUST_TP_CD(+) = 'F'" ).append("\n"); 
		query.append("          #if (${cust_cnt_cd} != '')" ).append("\n"); 
		query.append("               #if (${bkg_cust_tp_cd} == 'S')" ).append("\n"); 
		query.append("                      AND S.CUST_CNT_CD = @[cust_cnt_cd]" ).append("\n"); 
		query.append("               #elseif (${bkg_cust_tp_cd} == 'C')" ).append("\n"); 
		query.append("                      AND C.CUST_CNT_CD = @[cust_cnt_cd]" ).append("\n"); 
		query.append("               #elseif (${bkg_cust_tp_cd} == 'N')" ).append("\n"); 
		query.append("                      AND N.CUST_CNT_CD = @[cust_cnt_cd]" ).append("\n"); 
		query.append("               #elseif (${bkg_cust_tp_cd} == 'F')" ).append("\n"); 
		query.append("                      AND F.CUST_CNT_CD = @[cust_cnt_cd]" ).append("\n"); 
		query.append("               #end" ).append("\n"); 
		query.append("          #end" ).append("\n"); 
		query.append("          #if (${cust_seq} != '')" ).append("\n"); 
		query.append("               #if (${bkg_cust_tp_cd} == 'S')" ).append("\n"); 
		query.append("                      AND S.CUST_SEQ = @[cust_seq]" ).append("\n"); 
		query.append("               #elseif (${bkg_cust_tp_cd} == 'C')" ).append("\n"); 
		query.append("                      AND C.CUST_SEQ = @[cust_seq]" ).append("\n"); 
		query.append("               #elseif (${bkg_cust_tp_cd} == 'N')" ).append("\n"); 
		query.append("                      AND N.CUST_SEQ = @[cust_seq]" ).append("\n"); 
		query.append("               #elseif (${bkg_cust_tp_cd} == 'F')" ).append("\n"); 
		query.append("                      AND F.CUST_SEQ = @[cust_seq]" ).append("\n"); 
		query.append("               #end" ).append("\n"); 
		query.append("          #end" ).append("\n"); 
		query.append("          #if (${cust_nm} != '')" ).append("\n"); 
		query.append("               #if (${bkg_cust_tp_cd} == 'S')" ).append("\n"); 
		query.append("                      AND UPPER(S.CUST_NM) LIKE @[cust_nm] || '%'" ).append("\n"); 
		query.append("               #elseif (${bkg_cust_tp_cd} == 'C')" ).append("\n"); 
		query.append("                      AND UPPER(C.CUST_NM) LIKE @[cust_nm] || '%'" ).append("\n"); 
		query.append("               #elseif (${bkg_cust_tp_cd} == 'N')" ).append("\n"); 
		query.append("                      AND UPPER(N.CUST_NM) LIKE @[cust_nm] || '%'" ).append("\n"); 
		query.append("               #elseif (${bkg_cust_tp_cd} == 'F')" ).append("\n"); 
		query.append("                      AND UPPER(F.CUST_NM) LIKE @[cust_nm] || '%'" ).append("\n"); 
		query.append("               #end" ).append("\n"); 
		query.append("          #end" ).append("\n"); 
		query.append("     #end" ).append("\n"); 
		query.append("     #if (${srep_cd} != '' || ${split_only_flg} != '')" ).append("\n"); 
		query.append("                      AND XTER.XTER_SNDR_ID(+) = A.XTER_SNDR_ID" ).append("\n"); 
		query.append("                      AND XTER.XTER_RQST_NO(+) = A.XTER_RQST_NO" ).append("\n"); 
		query.append("                      AND XTER.XTER_RQST_SEQ(+) = A.XTER_RQST_SEQ" ).append("\n"); 
		query.append("                      AND NVL(XTER.SNACCS_MSG_TP_CD, ' ') NOT IN ('SAT050', 'SAT054')" ).append("\n"); 
		query.append("          #if (${srep_cd} != '')" ).append("\n"); 
		query.append("                      AND NVL(B.OB_SREP_CD, XTER.SREP_CD) = @[srep_cd]" ).append("\n"); 
		query.append("          #end" ).append("\n"); 
		query.append("          #if (${split_only_flg} != '')" ).append("\n"); 
		query.append("                      AND XTER.SPLIT_STS_CD IN ('S', 'F')" ).append("\n"); 
		query.append("          #end" ).append("\n"); 
		query.append("     #end" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("/* Booking No */" ).append("\n"); 
		query.append("                      AND A.BKG_NO LIKE @[bkg_no]||'%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("               )" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("         GROUP BY REGION," ).append("\n"); 
		query.append("                  BKG_OFC_CD," ).append("\n"); 
		query.append("                  KIND" ).append("\n"); 
		query.append("       )" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(" ORDER BY REGION," ).append("\n"); 
		query.append("          BKG_OFC_CD," ).append("\n"); 
		query.append("          KIND" ).append("\n"); 

	}
}