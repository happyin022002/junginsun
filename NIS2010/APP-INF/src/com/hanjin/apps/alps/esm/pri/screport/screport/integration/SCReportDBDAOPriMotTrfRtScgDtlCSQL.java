/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : SCReportDBDAOPriMotTrfRtScgDtlCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.11.19
*@LastModifier : 송호진
*@LastVersion : 1.0
* 2014.11.19 송호진
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.screport.screport.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author SongHojin
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SCReportDBDAOPriMotTrfRtScgDtlCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * PRI_MOT_TRF_RT_SCG_DTL Table Insert
	  * </pre>
	  */
	public SCReportDBDAOPriMotTrfRtScgDtlCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("oens_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("tgoh_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dddf_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rt_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("csr_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("odhf_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dact_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("othc_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("stf_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eic_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("buc_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dddc_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("odcs_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("aps_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mot_trf_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ocms_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("oslf_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ddts_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("tdis_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pcs_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("oobs_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("baf_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pcc_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("svc_scp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("od_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("twsc_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("psc_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dthc_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dnfc_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("caf_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("docp_amt",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.pri.screport.screport.integration").append("\n"); 
		query.append("FileName : SCReportDBDAOPriMotTrfRtScgDtlCSQL").append("\n"); 
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
		query.append("INSERT INTO PRI_MOT_TRF_RT_SCG_DTL" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("WITH SCG_LIST AS (" ).append("\n"); 
		query.append("    SELECT  @[svc_scp_cd] AS SVC_SCP_CD, @[mot_trf_seq] AS MOT_TRF_SEQ, @[rt_seq] AS RT_SEQ, '01' AS MOT_TRF_CHG_CD, TO_NUMBER ( @[baf_amt]   ) AS MOT_TRF_CHG_AMT FROM DUAL WHERE @[baf_amt]   IS NOT NULL AND  TO_NUMBER ( @[baf_amt]  ) > 0 UNION ALL" ).append("\n"); 
		query.append("    SELECT  @[svc_scp_cd] AS SVC_SCP_CD, @[mot_trf_seq] AS MOT_TRF_SEQ, @[rt_seq] AS RT_SEQ, '02' AS MOT_TRF_CHG_CD, TO_NUMBER ( @[caf_amt]   ) AS MOT_TRF_CHG_AMT FROM DUAL WHERE @[caf_amt]   IS NOT NULL AND  TO_NUMBER ( @[caf_amt]  ) > 0 UNION ALL" ).append("\n"); 
		query.append("    SELECT  @[svc_scp_cd] AS SVC_SCP_CD, @[mot_trf_seq] AS MOT_TRF_SEQ, @[rt_seq] AS RT_SEQ, '03' AS MOT_TRF_CHG_CD, TO_NUMBER ( @[othc_amt]  ) AS MOT_TRF_CHG_AMT FROM DUAL WHERE @[othc_amt]  IS NOT NULL AND  TO_NUMBER ( @[othc_amt] ) > 0 UNION ALL" ).append("\n"); 
		query.append("    SELECT  @[svc_scp_cd] AS SVC_SCP_CD, @[mot_trf_seq] AS MOT_TRF_SEQ, @[rt_seq] AS RT_SEQ, '04' AS MOT_TRF_CHG_CD, TO_NUMBER ( @[dthc_amt]  ) AS MOT_TRF_CHG_AMT FROM DUAL WHERE @[dthc_amt]  IS NOT NULL AND  TO_NUMBER ( @[dthc_amt] ) > 0 UNION ALL" ).append("\n"); 
		query.append("    SELECT  @[svc_scp_cd] AS SVC_SCP_CD, @[mot_trf_seq] AS MOT_TRF_SEQ, @[rt_seq] AS RT_SEQ, '05' AS MOT_TRF_CHG_CD, TO_NUMBER ( @[aps_amt]   ) AS MOT_TRF_CHG_AMT FROM DUAL WHERE @[aps_amt]   IS NOT NULL AND  TO_NUMBER ( @[aps_amt]  ) > 0 UNION ALL" ).append("\n"); 
		query.append("    SELECT  @[svc_scp_cd] AS SVC_SCP_CD, @[mot_trf_seq] AS MOT_TRF_SEQ, @[rt_seq] AS RT_SEQ, '06' AS MOT_TRF_CHG_CD, TO_NUMBER ( @[csr_amt]   ) AS MOT_TRF_CHG_AMT FROM DUAL WHERE @[csr_amt]   IS NOT NULL AND  TO_NUMBER ( @[csr_amt]  ) > 0 UNION ALL" ).append("\n"); 
		query.append("    SELECT  @[svc_scp_cd] AS SVC_SCP_CD, @[mot_trf_seq] AS MOT_TRF_SEQ, @[rt_seq] AS RT_SEQ, '07' AS MOT_TRF_CHG_CD, TO_NUMBER ( @[pcc_amt]   ) AS MOT_TRF_CHG_AMT FROM DUAL WHERE @[pcc_amt]   IS NOT NULL AND  TO_NUMBER ( @[pcc_amt]  ) > 0 UNION ALL" ).append("\n"); 
		query.append("    SELECT  @[svc_scp_cd] AS SVC_SCP_CD, @[mot_trf_seq] AS MOT_TRF_SEQ, @[rt_seq] AS RT_SEQ, '08' AS MOT_TRF_CHG_CD, TO_NUMBER ( @[pcs_amt]   ) AS MOT_TRF_CHG_AMT FROM DUAL WHERE @[pcs_amt]   IS NOT NULL AND  TO_NUMBER ( @[pcs_amt]  ) > 0 UNION ALL" ).append("\n"); 
		query.append("    SELECT  @[svc_scp_cd] AS SVC_SCP_CD, @[mot_trf_seq] AS MOT_TRF_SEQ, @[rt_seq] AS RT_SEQ, '09' AS MOT_TRF_CHG_CD, TO_NUMBER ( @[stf_amt]   ) AS MOT_TRF_CHG_AMT FROM DUAL WHERE @[stf_amt]   IS NOT NULL AND  TO_NUMBER ( @[stf_amt]  ) > 0 UNION ALL" ).append("\n"); 
		query.append("    SELECT  @[svc_scp_cd] AS SVC_SCP_CD, @[mot_trf_seq] AS MOT_TRF_SEQ, @[rt_seq] AS RT_SEQ, '10' AS MOT_TRF_CHG_CD, TO_NUMBER ( @[dact_amt]  ) AS MOT_TRF_CHG_AMT FROM DUAL WHERE @[dact_amt]  IS NOT NULL AND  TO_NUMBER ( @[dact_amt] ) > 0 UNION ALL" ).append("\n"); 
		query.append("    SELECT  @[svc_scp_cd] AS SVC_SCP_CD, @[mot_trf_seq] AS MOT_TRF_SEQ, @[rt_seq] AS RT_SEQ, '11' AS MOT_TRF_CHG_CD, TO_NUMBER ( @[dddc_amt]  ) AS MOT_TRF_CHG_AMT FROM DUAL WHERE @[dddc_amt]  IS NOT NULL AND  TO_NUMBER ( @[dddc_amt] ) > 0 UNION ALL" ).append("\n"); 
		query.append("    SELECT  @[svc_scp_cd] AS SVC_SCP_CD, @[mot_trf_seq] AS MOT_TRF_SEQ, @[rt_seq] AS RT_SEQ, '12' AS MOT_TRF_CHG_CD, TO_NUMBER ( @[dddf_amt]  ) AS MOT_TRF_CHG_AMT FROM DUAL WHERE @[dddf_amt]  IS NOT NULL AND  TO_NUMBER ( @[dddf_amt] ) > 0 UNION ALL" ).append("\n"); 
		query.append("    SELECT  @[svc_scp_cd] AS SVC_SCP_CD, @[mot_trf_seq] AS MOT_TRF_SEQ, @[rt_seq] AS RT_SEQ, '13' AS MOT_TRF_CHG_CD, TO_NUMBER ( @[dnfc_amt]  ) AS MOT_TRF_CHG_AMT FROM DUAL WHERE @[dnfc_amt]  IS NOT NULL AND  TO_NUMBER ( @[dnfc_amt] ) > 0 UNION ALL" ).append("\n"); 
		query.append("    SELECT  @[svc_scp_cd] AS SVC_SCP_CD, @[mot_trf_seq] AS MOT_TRF_SEQ, @[rt_seq] AS RT_SEQ, '14' AS MOT_TRF_CHG_CD, TO_NUMBER ( @[oens_amt]  ) AS MOT_TRF_CHG_AMT FROM DUAL WHERE @[oens_amt]  IS NOT NULL AND  TO_NUMBER ( @[oens_amt] ) > 0 UNION ALL" ).append("\n"); 
		query.append("    SELECT  @[svc_scp_cd] AS SVC_SCP_CD, @[mot_trf_seq] AS MOT_TRF_SEQ, @[rt_seq] AS RT_SEQ, '15' AS MOT_TRF_CHG_CD, TO_NUMBER ( @[od_amt]    ) AS MOT_TRF_CHG_AMT FROM DUAL WHERE @[od_amt]    IS NOT NULL AND  TO_NUMBER ( @[od_amt]   ) > 0 UNION ALL" ).append("\n"); 
		query.append("    SELECT  @[svc_scp_cd] AS SVC_SCP_CD, @[mot_trf_seq] AS MOT_TRF_SEQ, @[rt_seq] AS RT_SEQ, '16' AS MOT_TRF_CHG_CD, TO_NUMBER ( @[tdis_amt]  ) AS MOT_TRF_CHG_AMT FROM DUAL WHERE @[tdis_amt]  IS NOT NULL AND  TO_NUMBER ( @[tdis_amt] ) > 0 UNION ALL" ).append("\n"); 
		query.append("    SELECT  @[svc_scp_cd] AS SVC_SCP_CD, @[mot_trf_seq] AS MOT_TRF_SEQ, @[rt_seq] AS RT_SEQ, '17' AS MOT_TRF_CHG_CD, TO_NUMBER ( @[tgoh_amt]  ) AS MOT_TRF_CHG_AMT FROM DUAL WHERE @[tgoh_amt]  IS NOT NULL AND  TO_NUMBER ( @[tgoh_amt] ) > 0 UNION ALL" ).append("\n"); 
		query.append("    SELECT  @[svc_scp_cd] AS SVC_SCP_CD, @[mot_trf_seq] AS MOT_TRF_SEQ, @[rt_seq] AS RT_SEQ, '18' AS MOT_TRF_CHG_CD, TO_NUMBER ( @[twsc_amt]  ) AS MOT_TRF_CHG_AMT FROM DUAL WHERE @[twsc_amt]  IS NOT NULL AND  TO_NUMBER ( @[twsc_amt] ) > 0 UNION ALL" ).append("\n"); 
		query.append("    SELECT  @[svc_scp_cd] AS SVC_SCP_CD, @[mot_trf_seq] AS MOT_TRF_SEQ, @[rt_seq] AS RT_SEQ, '19' AS MOT_TRF_CHG_CD, TO_NUMBER ( @[psc_amt]   ) AS MOT_TRF_CHG_AMT FROM DUAL WHERE @[psc_amt]   IS NOT NULL AND  TO_NUMBER ( @[psc_amt]  ) > 0 UNION ALL" ).append("\n"); 
		query.append("    SELECT  @[svc_scp_cd] AS SVC_SCP_CD, @[mot_trf_seq] AS MOT_TRF_SEQ, @[rt_seq] AS RT_SEQ, '20' AS MOT_TRF_CHG_CD, TO_NUMBER ( @[buc_amt]   ) AS MOT_TRF_CHG_AMT FROM DUAL WHERE @[buc_amt]   IS NOT NULL AND  TO_NUMBER ( @[buc_amt]  ) > 0 UNION ALL" ).append("\n"); 
		query.append("    SELECT  @[svc_scp_cd] AS SVC_SCP_CD, @[mot_trf_seq] AS MOT_TRF_SEQ, @[rt_seq] AS RT_SEQ, '21' AS MOT_TRF_CHG_CD, TO_NUMBER ( @[eic_amt]   ) AS MOT_TRF_CHG_AMT FROM DUAL WHERE @[eic_amt]   IS NOT NULL AND  TO_NUMBER ( @[eic_amt]  ) > 0 UNION ALL" ).append("\n"); 
		query.append("    SELECT  @[svc_scp_cd] AS SVC_SCP_CD, @[mot_trf_seq] AS MOT_TRF_SEQ, @[rt_seq] AS RT_SEQ, '22' AS MOT_TRF_CHG_CD, TO_NUMBER ( @[oslf_amt]  ) AS MOT_TRF_CHG_AMT FROM DUAL WHERE @[oslf_amt]  IS NOT NULL AND  TO_NUMBER ( @[oslf_amt] ) > 0 UNION ALL" ).append("\n"); 
		query.append("    SELECT  @[svc_scp_cd] AS SVC_SCP_CD, @[mot_trf_seq] AS MOT_TRF_SEQ, @[rt_seq] AS RT_SEQ, '23' AS MOT_TRF_CHG_CD, TO_NUMBER ( @[oobs_amt]  ) AS MOT_TRF_CHG_AMT FROM DUAL WHERE @[oobs_amt]  IS NOT NULL AND  TO_NUMBER ( @[oobs_amt] ) > 0 UNION ALL" ).append("\n"); 
		query.append("    SELECT  @[svc_scp_cd] AS SVC_SCP_CD, @[mot_trf_seq] AS MOT_TRF_SEQ, @[rt_seq] AS RT_SEQ, '24' AS MOT_TRF_CHG_CD, TO_NUMBER ( @[odhf_amt]  ) AS MOT_TRF_CHG_AMT FROM DUAL WHERE @[odhf_amt]  IS NOT NULL AND  TO_NUMBER ( @[odhf_amt] ) > 0 UNION ALL" ).append("\n"); 
		query.append("    SELECT  @[svc_scp_cd] AS SVC_SCP_CD, @[mot_trf_seq] AS MOT_TRF_SEQ, @[rt_seq] AS RT_SEQ, '25' AS MOT_TRF_CHG_CD, TO_NUMBER ( @[odcs_amt]  ) AS MOT_TRF_CHG_AMT FROM DUAL WHERE @[odcs_amt]  IS NOT NULL AND  TO_NUMBER ( @[odcs_amt] ) > 0 UNION ALL" ).append("\n"); 
		query.append("    SELECT  @[svc_scp_cd] AS SVC_SCP_CD, @[mot_trf_seq] AS MOT_TRF_SEQ, @[rt_seq] AS RT_SEQ, '26' AS MOT_TRF_CHG_CD, TO_NUMBER ( @[ddts_amt]  ) AS MOT_TRF_CHG_AMT FROM DUAL WHERE @[ddts_amt]  IS NOT NULL AND  TO_NUMBER ( @[ddts_amt] ) > 0 UNION ALL" ).append("\n"); 
		query.append("    SELECT  @[svc_scp_cd] AS SVC_SCP_CD, @[mot_trf_seq] AS MOT_TRF_SEQ, @[rt_seq] AS RT_SEQ, '27' AS MOT_TRF_CHG_CD, TO_NUMBER ( @[ocms_amt]  ) AS MOT_TRF_CHG_AMT FROM DUAL WHERE @[ocms_amt]  IS NOT NULL AND  TO_NUMBER ( @[ocms_amt] ) > 0 UNION ALL" ).append("\n"); 
		query.append("    SELECT  @[svc_scp_cd] AS SVC_SCP_CD, @[mot_trf_seq] AS MOT_TRF_SEQ, @[rt_seq] AS RT_SEQ, '28' AS MOT_TRF_CHG_CD, TO_NUMBER ( @[docp_amt]  ) AS MOT_TRF_CHG_AMT FROM DUAL WHERE @[docp_amt]  IS NOT NULL AND  TO_NUMBER ( @[docp_amt] ) > 0 " ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("SELECT  SVC_SCP_CD" ).append("\n"); 
		query.append("    ,   MOT_TRF_SEQ" ).append("\n"); 
		query.append("    ,   RT_SEQ" ).append("\n"); 
		query.append("    ,   ROW_NUMBER () OVER ( ORDER BY MOT_TRF_CHG_CD ) " ).append("\n"); 
		query.append("    ,   MOT_TRF_CHG_CD" ).append("\n"); 
		query.append("    ,   MOT_TRF_CHG_AMT" ).append("\n"); 
		query.append("    ,   @[cre_usr_id]" ).append("\n"); 
		query.append("    ,   SYSDATE" ).append("\n"); 
		query.append("    ,   @[cre_usr_id]" ).append("\n"); 
		query.append("    ,   SYSDATE" ).append("\n"); 
		query.append("FROM    SCG_LIST" ).append("\n"); 
		query.append("ORDER	BY MOT_TRF_CHG_CD" ).append("\n"); 

	}
}