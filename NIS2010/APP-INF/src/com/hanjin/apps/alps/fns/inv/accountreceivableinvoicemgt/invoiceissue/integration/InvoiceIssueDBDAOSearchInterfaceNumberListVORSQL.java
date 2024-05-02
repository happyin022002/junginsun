/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : InvoiceIssueDBDAOSearchInterfaceNumberListVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.12.10
*@LastModifier : 정휘택
*@LastVersion : 1.0
* 2009.12.10 정휘택
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.invoiceissue.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Jung Hwi Taek
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class InvoiceIssueDBDAOSearchInterfaceNumberListVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * InvoiceIssueDBDAOSearchInterfaceNumberListVORSQL
	  * </pre>
	  */
	public InvoiceIssueDBDAOSearchInterfaceNumberListVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("port",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("scp",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("if_user_id",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("max_io_bnd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("max_inv_iss_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("from_dt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("max_act_cust_cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bnd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("max_inv_split_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ar_ofc_cd2",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("max_bl_src_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("max_skd_voy_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("max_vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("max_svc_scp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("max_port_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("max_trsp_rqst_ord_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("max_act_cust_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("max_skd_dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("max_sail_arr_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.invoiceissue.integration").append("\n"); 
		query.append("FileName : InvoiceIssueDBDAOSearchInterfaceNumberListVORSQL").append("\n"); 
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
		query.append("SELECT V1.ACT_CUST_CNT_CD" ).append("\n"); 
		query.append(", V1.ACT_CUST_SEQ" ).append("\n"); 
		query.append(", V1.VSL_CD" ).append("\n"); 
		query.append(", V1.SKD_VOY_NO" ).append("\n"); 
		query.append(", V1.SKD_DIR_CD" ).append("\n"); 
		query.append(", V1.IO_BND_CD" ).append("\n"); 
		query.append(", V1.PORT_CD" ).append("\n"); 
		query.append(", V1.SVC_SCP_CD" ).append("\n"); 
		query.append(", V1.BL_SRC_NO" ).append("\n"); 
		query.append(", V1.INV_ISS_TP_CD" ).append("\n"); 
		query.append(", V1.SAIL_ARR_DT" ).append("\n"); 
		query.append("--, V1.BKG_NO" ).append("\n"); 
		query.append(", V1.REV_TP_CD" ).append("\n"); 
		query.append(", V1.TRSP_RQST_ORD_FLG" ).append("\n"); 
		query.append(", V1.INV_SPLIT_CD" ).append("\n"); 
		query.append("--, MAX(V1.AR_IF_NO) AR_IF_NO" ).append("\n"); 
		query.append(", V1.AR_IF_NO AR_IF_NO" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("(SELECT A.ACT_CUST_CNT_CD" ).append("\n"); 
		query.append(", A.ACT_CUST_SEQ" ).append("\n"); 
		query.append(", A.VSL_CD" ).append("\n"); 
		query.append(", A.SKD_VOY_NO" ).append("\n"); 
		query.append(", A.SKD_DIR_CD" ).append("\n"); 
		query.append(", A.IO_BND_CD" ).append("\n"); 
		query.append(", DECODE(A.IO_BND_CD, 'I', A.POD_CD, A.POL_CD) PORT_CD" ).append("\n"); 
		query.append(", A.SVC_SCP_CD" ).append("\n"); 
		query.append(", A.BL_SRC_NO" ).append("\n"); 
		query.append(", NVL(DECODE(A.INV_SPLIT_CD, 'C','*', A.INV_SPLIT_CD),'*') INV_SPLIT_CD" ).append("\n"); 
		query.append(", I.INV_ISS_TP_CD" ).append("\n"); 
		query.append(", A.SAIL_ARR_DT" ).append("\n"); 
		query.append("--, A.BKG_NO" ).append("\n"); 
		query.append(", A.REV_TP_CD" ).append("\n"); 
		query.append(", A.TRSP_RQST_ORD_FLG" ).append("\n"); 
		query.append(", A.AR_IF_NO" ).append("\n"); 
		query.append(", G.CHG_AMT" ).append("\n"); 
		query.append("FROM INV_AR_MN A" ).append("\n"); 
		query.append(", MDM_CUSTOMER F" ).append("\n"); 
		query.append(", INV_AR_CHG G" ).append("\n"); 
		query.append(", INV_AR_STUP_OFC I" ).append("\n"); 
		query.append("WHERE A.AR_OFC_CD = @[ar_ofc_cd2]" ).append("\n"); 
		query.append("AND NVL(A.INV_DELT_DIV_CD, 'N') <> 'Y'" ).append("\n"); 
		query.append("AND A.BL_INV_CFM_DT IS NOT NULL" ).append("\n"); 
		query.append("AND A.AR_IF_NO = G.AR_IF_NO" ).append("\n"); 
		query.append("#if (${inv_dup_flg} != 'Y')" ).append("\n"); 
		query.append("AND G.INV_ISS_FLG = 'N'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("AND I.AR_OFC_CD = @[ar_ofc_cd2]" ).append("\n"); 
		query.append("--AND A.AR_IF_NO = 'VLCM944126'" ).append("\n"); 
		query.append("AND A.AR_IF_NO NOT IN ( SELECT AR_IF_NO" ).append("\n"); 
		query.append("FROM INV_AR_MN" ).append("\n"); 
		query.append("WHERE AR_IF_NO = A.AR_IF_NO" ).append("\n"); 
		query.append("AND USD_XCH_RT = 0 )" ).append("\n"); 
		query.append("AND A.REV_TP_CD||A.REV_SRC_CD||A.ACT_CUST_CNT_CD||A.ACT_CUST_SEQ NOT IN (SELECT 'MTH@'" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT 'MDJ@'" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT 'MSO@'" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT A.REV_TP_CD||A.REV_SRC_CD||S2.REP_CUST_CNT_CD||S2.REP_CUST_SEQ" ).append("\n"); 
		query.append("FROM INV_AR_STUP_OFC S1" ).append("\n"); 
		query.append(", MDM_ORGANIZATION S2" ).append("\n"); 
		query.append("WHERE S1.AR_OFC_CD = @[ar_ofc_cd2]" ).append("\n"); 
		query.append("AND S1.OTS_SMRY_CD = 'INV'" ).append("\n"); 
		query.append("AND S1.AR_OFC_CD = S2.AR_OFC_CD" ).append("\n"); 
		query.append("AND S2.DELT_FLG = 'N')" ).append("\n"); 
		query.append("AND A.ACT_CUST_CNT_CD = F.CUST_CNT_CD" ).append("\n"); 
		query.append("AND A.ACT_CUST_SEQ = F.CUST_SEQ" ).append("\n"); 
		query.append("AND F.DELT_FLG <> 'Y'" ).append("\n"); 
		query.append("#if (${bnd} != 'A' && ${bnd} != '')" ).append("\n"); 
		query.append("AND A.IO_BND_CD = @[bnd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${from_dt} != '' && ${to_dt} != '')" ).append("\n"); 
		query.append("#if (${dt_option} == 'G')" ).append("\n"); 
		query.append("AND A.BL_INV_CFM_DT BETWEEN REPLACE(@[from_dt],'-','') AND REPLACE(@[to_dt],'-','')" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("AND TO_CHAR(A.UPD_DT, 'YYYYMMDD') BETWEEN REPLACE(@[from_dt],'-','') AND REPLACE(@[to_dt],'-','')" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${vvd} != '')" ).append("\n"); 
		query.append("AND A.VSL_CD = SUBSTR(@[vvd], 1, 4)" ).append("\n"); 
		query.append("AND A.SKD_VOY_NO = SUBSTR(@[vvd], 5, 4)" ).append("\n"); 
		query.append("AND A.SKD_DIR_CD = SUBSTR(@[vvd], 9, 1)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${bnd} == 'I' && ${port} != '')" ).append("\n"); 
		query.append("AND A.POD_CD = @[port]" ).append("\n"); 
		query.append("#elseif (${bnd} == 'O' && ${port} != '')" ).append("\n"); 
		query.append("AND A.POL_CD = @[port]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${scp} != '')" ).append("\n"); 
		query.append("AND A.SVC_SCP_CD = @[scp]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${cust_cnt_cd} != '')" ).append("\n"); 
		query.append("AND A.ACT_CUST_CNT_CD = @[cust_cnt_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${cust_seq} != '')" ).append("\n"); 
		query.append("AND A.ACT_CUST_SEQ = @[cust_seq]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${bl_nos} != '')" ).append("\n"); 
		query.append("AND A.BL_SRC_NO IN (${bl_nos})" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${if_user_id} != '')" ).append("\n"); 
		query.append("AND A.UPD_USR_ID = @[if_user_id]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(") V1" ).append("\n"); 
		query.append("WHERE V1.ACT_CUST_CNT_CD   = @[max_act_cust_cnt_cd]" ).append("\n"); 
		query.append("AND V1.ACT_CUST_SEQ      = TO_NUMBER(@[max_act_cust_seq])" ).append("\n"); 
		query.append("AND V1.VSL_CD            = @[max_vsl_cd]" ).append("\n"); 
		query.append("AND V1.SKD_VOY_NO        = @[max_skd_voy_no]" ).append("\n"); 
		query.append("AND V1.SKD_DIR_CD        = @[max_skd_dir_cd]" ).append("\n"); 
		query.append("AND V1.IO_BND_CD         = @[max_io_bnd_cd]" ).append("\n"); 
		query.append("AND V1.PORT_CD           = @[max_port_cd]" ).append("\n"); 
		query.append("AND V1.SVC_SCP_CD        = @[max_svc_scp_cd]" ).append("\n"); 
		query.append("#if (${inv_mlt_bl_iss_flg} != 'Y')" ).append("\n"); 
		query.append("AND NVL(V1.BL_SRC_NO, ' ')  = NVL(@[max_bl_src_no], ' ')" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("AND V1.INV_ISS_TP_CD     = @[max_inv_iss_tp_cd]" ).append("\n"); 
		query.append("AND V1.SAIL_ARR_DT       = @[max_sail_arr_dt]" ).append("\n"); 
		query.append("AND V1.TRSP_RQST_ORD_FLG = @[max_trsp_rqst_ord_flg]" ).append("\n"); 
		query.append("AND V1.INV_SPLIT_CD = @[max_inv_split_cd]" ).append("\n"); 
		query.append("GROUP BY V1.ACT_CUST_CNT_CD" ).append("\n"); 
		query.append(", V1.ACT_CUST_SEQ" ).append("\n"); 
		query.append(", V1.VSL_CD" ).append("\n"); 
		query.append(", V1.SKD_VOY_NO" ).append("\n"); 
		query.append(", V1.SKD_DIR_CD" ).append("\n"); 
		query.append(", V1.IO_BND_CD" ).append("\n"); 
		query.append(", V1.PORT_CD" ).append("\n"); 
		query.append(", V1.SVC_SCP_CD" ).append("\n"); 
		query.append(", V1.BL_SRC_NO" ).append("\n"); 
		query.append(", V1.INV_ISS_TP_CD" ).append("\n"); 
		query.append(", V1.SAIL_ARR_DT" ).append("\n"); 
		query.append("--, V1.BKG_NO" ).append("\n"); 
		query.append(", V1.REV_TP_CD" ).append("\n"); 
		query.append(", V1.TRSP_RQST_ORD_FLG" ).append("\n"); 
		query.append(", V1.INV_SPLIT_CD" ).append("\n"); 
		query.append("--, DECODE(V1.INV_ISS_TP_CD, 'S', '', 'E', V1.AR_IF_NO)" ).append("\n"); 
		query.append(", V1.AR_IF_NO" ).append("\n"); 
		query.append("#if (${ots_smry_cd} == 'BL')" ).append("\n"); 
		query.append("HAVING SUM(V1.CHG_AMT) <> 0" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("ORDER BY V1.ACT_CUST_CNT_CD" ).append("\n"); 
		query.append(", V1.ACT_CUST_SEQ" ).append("\n"); 
		query.append(", V1.VSL_CD" ).append("\n"); 
		query.append(", V1.SKD_VOY_NO" ).append("\n"); 
		query.append(", V1.SKD_DIR_CD" ).append("\n"); 
		query.append(", V1.IO_BND_CD" ).append("\n"); 
		query.append(", V1.PORT_CD" ).append("\n"); 
		query.append(", V1.SVC_SCP_CD" ).append("\n"); 
		query.append(", V1.BL_SRC_NO" ).append("\n"); 
		query.append(", V1.INV_ISS_TP_CD" ).append("\n"); 
		query.append(", V1.SAIL_ARR_DT" ).append("\n"); 
		query.append("--, V1.BKG_NO" ).append("\n"); 
		query.append(", V1.REV_TP_CD" ).append("\n"); 
		query.append(", V1.TRSP_RQST_ORD_FLG" ).append("\n"); 
		query.append("--, DECODE(V1.INV_ISS_TP_CD, 'S', '', 'E', V1.AR_IF_NO)" ).append("\n"); 
		query.append(", V1.AR_IF_NO" ).append("\n"); 

	}
}