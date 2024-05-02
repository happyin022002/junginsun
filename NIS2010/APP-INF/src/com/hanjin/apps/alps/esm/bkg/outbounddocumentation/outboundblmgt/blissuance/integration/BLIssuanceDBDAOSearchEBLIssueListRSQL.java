/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : BLIssuanceDBDAOSearchEBLIssueListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.04.24
*@LastModifier : 김태경
*@LastVersion : 1.0
* 2011.04.24 김태경
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author kim tae kyoung
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BLIssuanceDBDAOSearchEBLIssueListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 
	  * </pre>
	  */
	public BLIssuanceDBDAOSearchEBLIssueListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("cust_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("del_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sr_sts_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("sr_rqst_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sr_rqst_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.integration").append("\n"); 
		query.append("FileName : BLIssuanceDBDAOSearchEBLIssueListRSQL").append("\n"); 
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
		query.append("SELECT  SR_RQST_TP_CD," ).append("\n"); 
		query.append("        SR_STS_CD," ).append("\n"); 
		query.append("        SR_RQST_NO," ).append("\n"); 
		query.append("        BKG_NO," ).append("\n"); 
		query.append("        SR_RQST_DT," ).append("\n"); 
		query.append("        CUST_CD," ).append("\n"); 
		query.append("        CUST_NM," ).append("\n"); 
		query.append("        CNTC_EML," ).append("\n"); 
		query.append("        PHN_NO," ).append("\n"); 
		query.append("        EBL_RJCT_RSN," ).append("\n"); 
		query.append("        AUTH_CFM," ).append("\n"); 
		query.append("        SND_USR_ID," ).append("\n"); 
		query.append("        SND_DT," ).append("\n"); 
		query.append("        ACK_RCV_FLG," ).append("\n"); 
		query.append("    	EBL_CFM_USR_ID," ).append("\n"); 
		query.append("    	CRE_DT  " ).append("\n"); 
		query.append("  FROM  (" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("    NVL(EBL.SR_RQST_TP_CD ,'N') SR_RQST_TP_CD," ).append("\n"); 
		query.append("    NVL(EBL.SR_STS_CD,'N') SR_STS_CD," ).append("\n"); 
		query.append("    EBL.SR_RQST_NO," ).append("\n"); 
		query.append("    BK.BKG_NO," ).append("\n"); 
		query.append("    EBL.SR_RQST_DT," ).append("\n"); 
		query.append("    CUST.CUST_CNT_CD||CUST.CUST_SEQ AS CUST_CD," ).append("\n"); 
		query.append("    CUST.CUST_NM," ).append("\n"); 
		query.append("    CNTC.CNTC_EML," ).append("\n"); 
		query.append("    CNTC.PHN_NO," ).append("\n"); 
		query.append("    EBL.EBL_RJCT_RSN," ).append("\n"); 
		query.append("    NVL(EBL.EBL_CFM_FLG ,'N') AS AUTH_CFM," ).append("\n"); 
		query.append("    EBL.SND_USR_ID," ).append("\n"); 
		query.append("    EBL.SND_DT," ).append("\n"); 
		query.append("    EBL.ACK_RCV_FLG," ).append("\n"); 
		query.append("	EBL.EBL_CFM_USR_ID," ).append("\n"); 
		query.append("	EBL.CRE_DT  " ).append("\n"); 
		query.append("FROM BKG_EBL_CRNT_RQST EBL," ).append("\n"); 
		query.append("     BKG_BOOKING BK," ).append("\n"); 
		query.append("     BKG_CUSTOMER CUST," ).append("\n"); 
		query.append("     (SELECT " ).append("\n"); 
		query.append("        CUST_CNT_CD," ).append("\n"); 
		query.append("        CUST_SEQ," ).append("\n"); 
		query.append("        PHN_NO," ).append("\n"); 
		query.append("        CNTC_EML," ).append("\n"); 
		query.append("        ROW_NUMBER() OVER(PARTITION BY CNTC.CUST_CNT_CD, CNTC.CUST_SEQ ORDER BY CNTC.CNTC_PSON_SEQ DESC) ROW_NUMBER" ).append("\n"); 
		query.append("      FROM BKG_CUST_CNTC_PSON CNTC" ).append("\n"); 
		query.append("      ) CNTC" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("  AND EBL.BKG_NO(+) = BK.BKG_NO" ).append("\n"); 
		query.append("  AND BK.BKG_STS_CD <> 'X'" ).append("\n"); 
		query.append("  AND BK.BKG_NO = CUST.BKG_NO" ).append("\n"); 
		query.append("  AND CUST.BKG_CUST_TP_CD ='S'" ).append("\n"); 
		query.append("  AND CUST.CUST_CNT_CD = CNTC.CUST_CNT_CD (+)" ).append("\n"); 
		query.append("  AND CUST.CUST_SEQ = CNTC.CUST_SEQ (+)" ).append("\n"); 
		query.append("  AND CNTC.ROW_NUMBER(+) = 1" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("/* Re-Issue Date & Delivery Date */" ).append("\n"); 
		query.append("#if (${sr_rqst_st_dt} != '' && ${sr_rqst_end_dt} != '')" ).append("\n"); 
		query.append("	AND EBL.SR_RQST_DT >= TO_DATE(${sr_rqst_st_dt},'YYYY-MM-DD')" ).append("\n"); 
		query.append("	AND EBL.SR_RQST_DT <= TO_DATE(${sr_rqst_end_dt},'YYYY-MM-DD') +0.99999" ).append("\n"); 
		query.append("	#if(${dt_type} == 'RIS')" ).append("\n"); 
		query.append("		AND EBL.SR_STS_CD ='R'" ).append("\n"); 
		query.append("	#end " ).append("\n"); 
		query.append("	#if(${dt_type} == 'DEL')" ).append("\n"); 
		query.append("		AND EBL.SR_STS_CD ='D'" ).append("\n"); 
		query.append("	#end " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(" " ).append("\n"); 
		query.append("  /* Booking No */" ).append("\n"); 
		query.append("#if (${bkg_no} != '')   " ).append("\n"); 
		query.append("  AND BK.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("#end  " ).append("\n"); 
		query.append("  /* VVD */" ).append("\n"); 
		query.append("#if (${vvd} != '')    " ).append("\n"); 
		query.append("  AND BK.VSL_CD =SUBSTR(@[vvd], 1, 4)" ).append("\n"); 
		query.append("  AND BK.SKD_VOY_NO = SUBSTR(@[vvd], 5, 4)" ).append("\n"); 
		query.append("  AND BK.SKD_DIR_CD =SUBSTR(@[vvd], 9, 1)" ).append("\n"); 
		query.append("#end   " ).append("\n"); 
		query.append("  " ).append("\n"); 
		query.append("  /* Customer */" ).append("\n"); 
		query.append("  AND EXISTS ( SELECT 'Y'" ).append("\n"); 
		query.append("               FROM BKG_CUSTOMER C" ).append("\n"); 
		query.append("               WHERE 1=1 " ).append("\n"); 
		query.append("                 AND C.BKG_NO = BK.BKG_NO " ).append("\n"); 
		query.append("                 AND C.BKG_CUST_TP_CD = @[cust_tp_cd]" ).append("\n"); 
		query.append("#if (${cust_cd} != '')                     " ).append("\n"); 
		query.append("                 AND C.CUST_CNT_CD = SUBSTR(@[cust_cd],1,2)" ).append("\n"); 
		query.append("                 AND C.CUST_SEQ = SUBSTR(@[cust_cd],3)" ).append("\n"); 
		query.append("#end                  " ).append("\n"); 
		query.append("#if (${cust_nm} != '')                    " ).append("\n"); 
		query.append("                 AND C.CUST_NM LIKE @[cust_nm]||'%'" ).append("\n"); 
		query.append("#end                 " ).append("\n"); 
		query.append("              )   " ).append("\n"); 
		query.append("  /* Lane */    " ).append("\n"); 
		query.append("#if (${slan_cd} != '')               " ).append("\n"); 
		query.append("  AND BK.SLAN_CD = @[slan_cd]" ).append("\n"); 
		query.append("#end  " ).append("\n"); 
		query.append("  /* POR, POL, POD, DEL */" ).append("\n"); 
		query.append("#if (${por_cd} != '')     " ).append("\n"); 
		query.append("  AND BK.POR_CD = @[por_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${pol_cd} != '')  " ).append("\n"); 
		query.append("  AND BK.POL_CD = @[pol_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${pod_cd} != '')   " ).append("\n"); 
		query.append("  AND BK.POD_CD = @[pod_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${del_cd} != '')   " ).append("\n"); 
		query.append("  AND BK.DEL_CD = @[del_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("WHERE  1=1 /* Reference No */" ).append("\n"); 
		query.append("#if (${sr_rqst_no} != '')   " ).append("\n"); 
		query.append("  AND SR_RQST_NO = @[sr_rqst_no]" ).append("\n"); 
		query.append("#end  " ).append("\n"); 
		query.append("/* Request status */" ).append("\n"); 
		query.append("#if (${sr_rqst_tp_cd} != '')   " ).append("\n"); 
		query.append("  AND SR_RQST_TP_CD = @[sr_rqst_tp_cd]" ).append("\n"); 
		query.append("#end    " ).append("\n"); 
		query.append("  /* Status */" ).append("\n"); 
		query.append("#if (${sr_sts_cd} != '')    " ).append("\n"); 
		query.append("  AND SR_STS_CD = @[sr_sts_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}