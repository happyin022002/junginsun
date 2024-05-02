/*=========================================================
*Copyright(c) 2017 Hipluscard
*@FileName : SCGRICalculationProposalDBDAORsltGriCalcRateActualCustListVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.11.22
*@LastModifier : 송민석
*@LastVersion : 1.0
* 2017.11.22 송민석
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.scproposal.scgricalculationproposal.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author SONG Min Seok
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SCGRICalculationProposalDBDAORsltGriCalcRateActualCustListVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * GRI Calc. Rate의 actual customer 조회
	  * </pre>
	  */
	public SCGRICalculationProposalDBDAORsltGriCalcRateActualCustListVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.NUMERIC + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("amdt_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_lgl_eng_nm",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("svc_scp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("gen_spcl_rt_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("prop_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.pri.scproposal.scgricalculationproposal.integration").append("\n"); 
		query.append("FileName : SCGRICalculationProposalDBDAORsltGriCalcRateActualCustListVORSQL").append("\n"); 
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
		query.append("	A.PROP_NO" ).append("\n"); 
		query.append("	, A.AMDT_SEQ" ).append("\n"); 
		query.append("	, A.SVC_SCP_CD" ).append("\n"); 
		query.append("	, A.GEN_SPCL_RT_TP_CD" ).append("\n"); 
		query.append("	, A.CMDT_HDR_SEQ" ).append("\n"); 
		query.append("	, A.ACT_CUST_SEQ" ).append("\n"); 
		query.append("	, A.CUST_CNT_CD" ).append("\n"); 
		query.append("	, A.CUST_SEQ" ).append("\n"); 
		query.append("	, A.PRC_PROG_STS_CD" ).append("\n"); 
		query.append("	, A.SRC_INFO_CD" ).append("\n"); 
		query.append("	, A.N1ST_CMNC_AMDT_SEQ" ).append("\n"); 
		query.append("	, A.ACPT_USR_ID" ).append("\n"); 
		query.append("	, A.ACPT_OFC_CD" ).append("\n"); 
		query.append("	, A.ACPT_DT" ).append("\n"); 
		query.append("	, A.CRE_USR_ID" ).append("\n"); 
		query.append("	, A.CRE_DT" ).append("\n"); 
		query.append("	, A.UPD_USR_ID" ).append("\n"); 
		query.append("	, A.UPD_DT " ).append("\n"); 
		query.append("	, B.CUST_LGL_ENG_NM" ).append("\n"); 
		query.append("	, A.CUST_CNT_CD || TO_CHAR(A.CUST_SEQ,'FM099999') AS CUSTOMER_CD" ).append("\n"); 
		query.append("	, c.BZET_ADDR ||' '||c.CTY_NM||DECODE(c.STE_CD||c.ZIP_CD,'','',', '||c.STE_CD||' '||c.ZIP_CD) BZET_ADDR" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	, (SELECT INTG_CD_VAL_DESC" ).append("\n"); 
		query.append("	  FROM COM_INTG_CD_DTL" ).append("\n"); 
		query.append("	 WHERE INTG_CD_ID = 'CD00697'" ).append("\n"); 
		query.append("	   AND INTG_CD_VAL_CTNT = B.RVIS_CNTR_CUST_TP_CD) AS RVIS_CNTR_CUST_TP_NM" ).append("\n"); 
		query.append("	, B.OFC_CD" ).append("\n"); 
		query.append("	, B.SREP_CD" ).append("\n"); 
		query.append("	, CASE WHEN B.VBS_CLSS_CD <> '99' " ).append("\n"); 
		query.append("	    THEN (SELECT INTG_CD_VAL_DESC" ).append("\n"); 
		query.append("		    FROM COM_INTG_CD_DTL" ).append("\n"); 
		query.append("		   WHERE INTG_CD_ID = 'CD00698'" ).append("\n"); 
		query.append("		     AND INTG_CD_VAL_CTNT = B.VBS_CLSS_CD)" ).append("\n"); 
		query.append("	    ELSE NULL" ).append("\n"); 
		query.append("	END VBS_CLSS_NM" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("FROM PRI_SP_SCP_RT_ACT_CUST A, MDM_CUSTOMER B, MDM_CUST_ADDR C" ).append("\n"); 
		query.append("WHERE A.SRC_INFO_CD <> 'AD'" ).append("\n"); 
		query.append("AND A.CUST_CNT_CD = B.CUST_CNT_CD" ).append("\n"); 
		query.append("AND A.CUST_SEQ = B.CUST_SEQ" ).append("\n"); 
		query.append("AND B.DELT_FLG = 'N'" ).append("\n"); 
		query.append("AND C.CUST_CNT_CD(+) = B.CUST_CNT_CD" ).append("\n"); 
		query.append("AND C.CUST_SEQ(+) = B.CUST_SEQ" ).append("\n"); 
		query.append("AND C.PRMRY_CHK_FLG(+) = 'Y'" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("AND A.PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("AND A.AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append("AND A.SVC_SCP_CD = @[svc_scp_cd]" ).append("\n"); 
		query.append("AND A.GEN_SPCL_RT_TP_CD = @[gen_spcl_rt_tp_cd]" ).append("\n"); 
		query.append("#if (${cust_cnt_cd} != '')" ).append("\n"); 
		query.append("   AND A.CUST_CNT_CD = @[cust_cnt_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${cust_seq} != '')" ).append("\n"); 
		query.append("   AND A.CUST_SEQ = TO_NUMBER(@[cust_seq])" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${cust_lgl_eng_nm} != '')" ).append("\n"); 
		query.append("   AND B.CUST_LGL_ENG_NM LIKE '%' || @[cust_lgl_eng_nm] || '%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}