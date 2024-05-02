/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : AccountReceivableEDISendDBDAOSearchContainerInvoiceRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.12.21
*@LastModifier : 
*@LastVersion : 1.0
* 2016.12.21 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.accountreceivableedisend.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AccountReceivableEDISendDBDAOSearchContainerInvoiceRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Search Container Invoice
	  * </pre>
	  */
	public AccountReceivableEDISendDBDAOSearchContainerInvoiceRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sc_rfa_no",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cust_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("sa_to_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bdr_ind_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("chg_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("tvvd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sa_from_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("svc_scp_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.accountreceivableedisend.integration").append("\n"); 
		query.append("FileName : AccountReceivableEDISendDBDAOSearchContainerInvoiceRSQL").append("\n"); 
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
		query.append("SELECT MERGE_CHK" ).append("\n"); 
		query.append("    , EDI_HDR_SEQ" ).append("\n"); 
		query.append("    , AR_IF_NO" ).append("\n"); 
		query.append("    , BL_NO" ).append("\n"); 
		query.append("    , DECODE(EDI_HDR_SEQ, '', DECODE(SUBSTR(REV_TP_SRC_CD, 1, 1), 'M', BL_SEQ, MAX(BL_SEQ) OVER(PARTITION BY AR_OFC_CD, CNTR_NO, CNMV_CYC_NO, INV_DELT_DIV_CD)), BL_SEQ) BL_SEQ" ).append("\n"); 
		query.append("    , BKG_NO" ).append("\n"); 
		query.append("    , INV_NO" ).append("\n"); 
		query.append("    , CNTR_NO" ).append("\n"); 
		query.append("    , CNMV_CYC_NO" ).append("\n"); 
		query.append("    , AR_OFC_CD" ).append("\n"); 
		query.append("    , SOURCE_CD" ).append("\n"); 
		query.append("    , REV_TP_SRC_CD" ).append("\n"); 
		query.append("    , ACT_CUST_CNT_CD" ).append("\n"); 
		query.append("    , ACT_CUST_SEQ" ).append("\n"); 
		query.append("    , CUST_CD" ).append("\n"); 
		query.append("    , CUST_NM" ).append("\n"); 
		query.append("    , VSL_CD" ).append("\n"); 
		query.append("    , SKD_VOY_NO" ).append("\n"); 
		query.append("    , SKD_DIR_CD" ).append("\n"); 
		query.append("    , TRNK_VVD_CD" ).append("\n"); 
		query.append("    , SVC_SCP_CD" ).append("\n"); 
		query.append("    , SLAN_CD" ).append("\n"); 
		query.append("    , SAIL_ARR_DT" ).append("\n"); 
		query.append("    , IO_BND_CD" ).append("\n"); 
		query.append("    , POR_CD" ).append("\n"); 
		query.append("    , POL_CD" ).append("\n"); 
		query.append("    , POD_CD" ).append("\n"); 
		query.append("    , DEL_CD" ).append("\n"); 
		query.append("    , SC_NO" ).append("\n"); 
		query.append("    , RFA_NO" ).append("\n"); 
		query.append("    , BDR_IND_FLG" ).append("\n"); 
		query.append("    , INV_DT" ).append("\n"); 
		query.append("    , LOCL_CURR_CD" ).append("\n"); 
		query.append("    , INV_TTL_LOCL_AMT" ).append("\n"); 
		query.append("    , EDI_SND_FLG" ).append("\n"); 
		query.append("    , EDI_SND_DT" ).append("\n"); 
		query.append("    , EDI_TP_CD" ).append("\n"); 
		query.append("    , CHG_SEQ" ).append("\n"); 
		query.append("    , CHG_CD" ).append("\n"); 
		query.append("    , CURR_CD" ).append("\n"); 
		query.append("    , PER_TP_CD" ).append("\n"); 
		query.append("    , TRF_RT_AMT" ).append("\n"); 
		query.append("    , RAT_AS_CNTR_QTY" ).append("\n"); 
		query.append("    , CHG_AMT" ).append("\n"); 
		query.append("    , INV_DELT_DIV_CD " ).append("\n"); 
		query.append("FROM (          " ).append("\n"); 
		query.append("    SELECT DECODE(INV_NO, '', CNTR_NO||'-'||LPAD(CNMV_CYC_NO,4,'0')||LPAD(BL_SEQ + DENSE_RANK() OVER(PARTITION BY DECODE(INV_NO, '', CNTR_NO, ''), DECODE(INV_NO, '', CNMV_CYC_NO, ''), DECODE(INV_NO, '', DECODE(SUBSTR(REV_TP_SRC_CD, 1, 1), 'M', 'B','A'), '') ORDER BY DECODE(SUBSTR(REV_TP_SRC_CD, 1, 1), 'M', AR_IF_NO, DECODE(INV_DELT_DIV_CD, 'X', 'A', 'B')), DECODE(SUBSTR(REV_TP_SRC_CD, 1, 1), 'M', AR_IF_NO, ACT_CUST_CNT_CD), DECODE(SUBSTR(REV_TP_SRC_CD, 1, 1), 'M', AR_IF_NO, ACT_CUST_SEQ)),2,'0'), INV_NO) MERGE_CHK" ).append("\n"); 
		query.append("        , EDI_HDR_SEQ" ).append("\n"); 
		query.append("        , AR_IF_NO" ).append("\n"); 
		query.append("        , BL_NO" ).append("\n"); 
		query.append("        , DECODE(INV_NO, '', BL_SEQ + DENSE_RANK() OVER(PARTITION BY DECODE(INV_NO, '', CNTR_NO, ''), DECODE(INV_NO, '', CNMV_CYC_NO, ''), DECODE(INV_NO, '', DECODE(SUBSTR(REV_TP_SRC_CD, 1, 1), 'M', 'B','A'), '') ORDER BY DECODE(SUBSTR(REV_TP_SRC_CD, 1, 1), 'M', AR_IF_NO, DECODE(INV_DELT_DIV_CD, 'X', 'A', 'B')), DECODE(SUBSTR(REV_TP_SRC_CD, 1, 1), 'M', AR_IF_NO, ACT_CUST_CNT_CD), DECODE(SUBSTR(REV_TP_SRC_CD, 1, 1), 'M', AR_IF_NO, ACT_CUST_SEQ)), BL_SEQ) BL_SEQ" ).append("\n"); 
		query.append("        , BKG_NO  " ).append("\n"); 
		query.append("        , DECODE(INV_NO, '', CNTR_NO||'-'||LPAD(CNMV_CYC_NO,4,'0')||LPAD(BL_SEQ + DENSE_RANK() OVER(PARTITION BY DECODE(INV_NO, '', CNTR_NO, ''), DECODE(INV_NO, '', CNMV_CYC_NO, ''), DECODE(INV_NO, '', DECODE(SUBSTR(REV_TP_SRC_CD, 1, 1), 'M', 'B','A'), '') ORDER BY DECODE(SUBSTR(REV_TP_SRC_CD, 1, 1), 'M', AR_IF_NO, DECODE(INV_DELT_DIV_CD, 'X', 'A', 'B')), DECODE(SUBSTR(REV_TP_SRC_CD, 1, 1), 'M', AR_IF_NO, ACT_CUST_CNT_CD), DECODE(SUBSTR(REV_TP_SRC_CD, 1, 1), 'M', AR_IF_NO, ACT_CUST_SEQ)),2,'0'), INV_NO) INV_NO" ).append("\n"); 
		query.append("        , CNTR_NO" ).append("\n"); 
		query.append("        , CNMV_CYC_NO" ).append("\n"); 
		query.append("        , AR_OFC_CD" ).append("\n"); 
		query.append("        , DECODE(SUBSTR(REV_TP_SRC_CD, 1, 1), 'M', 'DMT', 'BKG') SOURCE_CD" ).append("\n"); 
		query.append("        , REV_TP_SRC_CD" ).append("\n"); 
		query.append("        , ACT_CUST_CNT_CD" ).append("\n"); 
		query.append("        , ACT_CUST_SEQ" ).append("\n"); 
		query.append("        , ACT_CUST_CNT_CD||'-'||LPAD(ACT_CUST_SEQ, 6, '0') CUST_CD" ).append("\n"); 
		query.append("        , (SELECT CUST_LGL_ENG_NM" ).append("\n"); 
		query.append("           FROM MDM_CUSTOMER" ).append("\n"); 
		query.append("           WHERE CUST_CNT_CD = ACT_CUST_CNT_CD" ).append("\n"); 
		query.append("           AND CUST_SEQ = ACT_CUST_SEQ) CUST_NM" ).append("\n"); 
		query.append("        , VSL_CD" ).append("\n"); 
		query.append("        , SKD_VOY_NO" ).append("\n"); 
		query.append("        , SKD_DIR_CD" ).append("\n"); 
		query.append("        , TRNK_VVD_CD" ).append("\n"); 
		query.append("        , SVC_SCP_CD" ).append("\n"); 
		query.append("        , SLAN_CD" ).append("\n"); 
		query.append("        , SAIL_ARR_DT" ).append("\n"); 
		query.append("        , IO_BND_CD" ).append("\n"); 
		query.append("        , POR_CD" ).append("\n"); 
		query.append("        , POL_CD" ).append("\n"); 
		query.append("        , POD_CD" ).append("\n"); 
		query.append("        , DEL_CD" ).append("\n"); 
		query.append("        , SC_NO" ).append("\n"); 
		query.append("        , RFA_NO" ).append("\n"); 
		query.append("        , BDR_IND_FLG" ).append("\n"); 
		query.append("        , INV_DT" ).append("\n"); 
		query.append("        , LOCL_CURR_CD" ).append("\n"); 
		query.append("        , DECODE(INV_TTL_LOCL_AMT, '', (SUM(CHG_AMT * INV_XCH_RT) OVER (PARTITION BY AR_IF_NO, CNTR_NO, CNMV_CYC_NO, INV_DELT_DIV_CD)), INV_TTL_LOCL_AMT) INV_TTL_LOCL_AMT" ).append("\n"); 
		query.append("        , EDI_SND_FLG" ).append("\n"); 
		query.append("        , TO_CHAR(EDI_SND_DT, 'YYYY-MM-DD HH24:MI:SS') EDI_SND_DT" ).append("\n"); 
		query.append("        , EDI_TP_CD" ).append("\n"); 
		query.append("        , CHG_SEQ" ).append("\n"); 
		query.append("        , CHG_CD" ).append("\n"); 
		query.append("        , CURR_CD" ).append("\n"); 
		query.append("        , PER_TP_CD" ).append("\n"); 
		query.append("        , TRF_RT_AMT" ).append("\n"); 
		query.append("        , RAT_AS_CNTR_QTY" ).append("\n"); 
		query.append("        , CHG_AMT" ).append("\n"); 
		query.append("        , INV_DELT_DIV_CD        " ).append("\n"); 
		query.append("    FROM (" ).append("\n"); 
		query.append("        -- START EDI TRANSFERED DATA" ).append("\n"); 
		query.append("        SELECT A.EDI_HDR_SEQ" ).append("\n"); 
		query.append("			, A.AR_IF_NO " ).append("\n"); 
		query.append("            , A.BL_NO" ).append("\n"); 
		query.append("            , A.BL_SEQ" ).append("\n"); 
		query.append("            , A.BKG_NO" ).append("\n"); 
		query.append("            , A.INV_NO" ).append("\n"); 
		query.append("            , A.CNTR_NO AS CNTR_NO    " ).append("\n"); 
		query.append("            , A.CNMV_CYC_NO" ).append("\n"); 
		query.append("            , A.AR_OFC_CD" ).append("\n"); 
		query.append("            , A.REV_TP_SRC_CD" ).append("\n"); 
		query.append("            , A.ACT_CUST_CNT_CD" ).append("\n"); 
		query.append("            , A.ACT_CUST_SEQ" ).append("\n"); 
		query.append("            , A.VSL_CD" ).append("\n"); 
		query.append("            , A.SKD_VOY_NO" ).append("\n"); 
		query.append("            , A.SKD_DIR_CD" ).append("\n"); 
		query.append("            , A.TRNK_VVD_CD" ).append("\n"); 
		query.append("            , A.SVC_SCP_CD" ).append("\n"); 
		query.append("            , A.SLAN_CD" ).append("\n"); 
		query.append("            , A.SAIL_ARR_DT" ).append("\n"); 
		query.append("            , A.IO_BND_CD" ).append("\n"); 
		query.append("            , A.POR_CD" ).append("\n"); 
		query.append("            , A.POL_CD" ).append("\n"); 
		query.append("            , A.POD_CD" ).append("\n"); 
		query.append("            , A.DEL_CD" ).append("\n"); 
		query.append("            , A.SC_NO" ).append("\n"); 
		query.append("            , A.RFA_NO" ).append("\n"); 
		query.append("            , A.BDR_IND_FLG" ).append("\n"); 
		query.append("            , A.INV_DT" ).append("\n"); 
		query.append("            , A.LOCL_CURR_CD" ).append("\n"); 
		query.append("            , A.INV_TTL_LOCL_AMT" ).append("\n"); 
		query.append("            , A.EDI_SND_FLG" ).append("\n"); 
		query.append("            , A.EDI_SND_DT" ).append("\n"); 
		query.append("            , A.EDI_TP_CD" ).append("\n"); 
		query.append("            , B.CHG_SEQ" ).append("\n"); 
		query.append("            , B.CHG_CD" ).append("\n"); 
		query.append("            , B.CURR_CD" ).append("\n"); 
		query.append("            , B.PER_TP_CD" ).append("\n"); 
		query.append("            , B.TRF_RT_AMT" ).append("\n"); 
		query.append("            , B.RAT_AS_CNTR_QTY" ).append("\n"); 
		query.append("            , B.CHG_AMT" ).append("\n"); 
		query.append("            , NULL INV_XCH_RT" ).append("\n"); 
		query.append("            , 'N' INV_DELT_DIV_CD " ).append("\n"); 
		query.append("            , 1 EDI_CNT" ).append("\n"); 
		query.append("            , 1 CXL_CNT" ).append("\n"); 
		query.append("        FROM INV_EDI_HDR A," ).append("\n"); 
		query.append("             INV_EDI_CHG B" ).append("\n"); 
		query.append("        WHERE A.EDI_HDR_SEQ = B.EDI_HDR_SEQ" ).append("\n"); 
		query.append("        AND A.AR_OFC_CD = @[ar_ofc_cd]" ).append("\n"); 
		query.append("        #if (${sc_rfa_no} != '')" ).append("\n"); 
		query.append("            #if (${cntc_tp_cd} == 'S')" ).append("\n"); 
		query.append("                AND A.SC_NO IN (@[sc_rfa_no])" ).append("\n"); 
		query.append("            #elseif (${cntc_tp_cd} == 'R')" ).append("\n"); 
		query.append("                AND A.RFA_NO IN (@[sc_rfa_no])" ).append("\n"); 
		query.append("            #end" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("        #if (${cust_cd} != '')" ).append("\n"); 
		query.append("            AND A.ACT_CUST_CNT_CD||A.ACT_CUST_SEQ IN (@[cust_cd])" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("        #if (${source_cd} == 'BKG')" ).append("\n"); 
		query.append("            AND SUBSTR(A.REV_TP_SRC_CD, 1, 1) <> 'M'" ).append("\n"); 
		query.append("        #elseif (${source_cd} == 'DMT')" ).append("\n"); 
		query.append("            AND SUBSTR(A.REV_TP_SRC_CD, 1, 1) = 'M'" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("        #if (${io_bnd_cd} != 'A')" ).append("\n"); 
		query.append("            AND A.IO_BND_CD = @[io_bnd_cd]" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("        #if (${tvvd_cd} != '')" ).append("\n"); 
		query.append("            AND A.TRNK_VVD_CD = @[tvvd_cd]" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("        #if (${bdr_ind_flg} != 'A')" ).append("\n"); 
		query.append("            AND A.BDR_IND_FLG = @[bdr_ind_flg]     " ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("        #if (${bl_no} != '')" ).append("\n"); 
		query.append("            AND A.BL_NO = @[bl_no]" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("        #if (${sa_from_dt} != '' && ${sa_to_dt} != '')" ).append("\n"); 
		query.append("            AND A.SAIL_ARR_DT BETWEEN REPLACE(@[sa_from_dt], '-', '') AND REPLACE(@[sa_to_dt], '-', '')" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("        #if (${svc_scp_cd} != '')" ).append("\n"); 
		query.append("            AND A.SVC_SCP_CD = @[svc_scp_cd]" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("        #if (${chg_cd} != '')" ).append("\n"); 
		query.append("            AND B.CHG_CD IN (@[chg_cd])" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("        #if (${cntr_no} != '')" ).append("\n"); 
		query.append("            AND A.CNTR_NO = @[cntr_no]" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("        AND A.EDI_TP_CD = 'INV_CNTR'" ).append("\n"); 
		query.append("        -- END EDI TRANSFERED DATA" ).append("\n"); 
		query.append("        UNION ALL" ).append("\n"); 
		query.append("        -- START EDI CANCEL DATA" ).append("\n"); 
		query.append("        SELECT NULL EDI_HDR_SEQ" ).append("\n"); 
		query.append("			, A.AR_IF_NO " ).append("\n"); 
		query.append("            , A.BL_NO" ).append("\n"); 
		query.append("            , A.BL_SEQ     " ).append("\n"); 
		query.append("            , A.BKG_NO" ).append("\n"); 
		query.append("            , '' INV_NO" ).append("\n"); 
		query.append("            , A.CNTR_NO AS CNTR_NO" ).append("\n"); 
		query.append("            , A.CNMV_CYC_NO" ).append("\n"); 
		query.append("            , A.AR_OFC_CD" ).append("\n"); 
		query.append("            , A.REV_TP_SRC_CD" ).append("\n"); 
		query.append("            , A.ACT_CUST_CNT_CD" ).append("\n"); 
		query.append("            , A.ACT_CUST_SEQ" ).append("\n"); 
		query.append("            , A.VSL_CD" ).append("\n"); 
		query.append("            , A.SKD_VOY_NO" ).append("\n"); 
		query.append("            , A.SKD_DIR_CD" ).append("\n"); 
		query.append("            , A.TRNK_VVD_CD" ).append("\n"); 
		query.append("            , A.SVC_SCP_CD" ).append("\n"); 
		query.append("            , A.SLAN_CD" ).append("\n"); 
		query.append("            , A.SAIL_ARR_DT" ).append("\n"); 
		query.append("            , A.IO_BND_CD" ).append("\n"); 
		query.append("            , A.POR_CD" ).append("\n"); 
		query.append("            , A.POL_CD" ).append("\n"); 
		query.append("            , A.POD_CD" ).append("\n"); 
		query.append("            , A.DEL_CD" ).append("\n"); 
		query.append("            , A.SC_NO" ).append("\n"); 
		query.append("            , A.RFA_NO" ).append("\n"); 
		query.append("            , A.BDR_IND_FLG" ).append("\n"); 
		query.append("            , TO_CHAR(SYSDATE, 'YYYYMMDD') INV_DT" ).append("\n"); 
		query.append("            , A.LOCL_CURR_CD" ).append("\n"); 
		query.append("            , NULL INV_TTL_LOCL_AMT" ).append("\n"); 
		query.append("            , 'N' EDI_SND_FLG" ).append("\n"); 
		query.append("            , NULL EDI_SND_DT" ).append("\n"); 
		query.append("            , A.EDI_TP_CD" ).append("\n"); 
		query.append("            , B.CHG_SEQ" ).append("\n"); 
		query.append("            , B.CHG_CD" ).append("\n"); 
		query.append("            , B.CURR_CD" ).append("\n"); 
		query.append("            , B.PER_TP_CD" ).append("\n"); 
		query.append("            , B.TRF_RT_AMT" ).append("\n"); 
		query.append("            , B.RAT_AS_CNTR_QTY" ).append("\n"); 
		query.append("            , B.CHG_AMT * (-1) AS CHG_AMT" ).append("\n"); 
		query.append("            , (SELECT INV_XCH_RT" ).append("\n"); 
		query.append("               FROM INV_AR_CHG" ).append("\n"); 
		query.append("               WHERE AR_IF_NO = A.AR_IF_NO" ).append("\n"); 
		query.append("               AND CURR_CD = B.CURR_CD" ).append("\n"); 
		query.append("               AND ROWNUM = 1) INV_XCH_RT" ).append("\n"); 
		query.append("            , 'X' AS INV_DELT_DIV_CD " ).append("\n"); 
		query.append("            , 1 EDI_CNT" ).append("\n"); 
		query.append("            , MAX((SELECT COUNT(*)" ).append("\n"); 
		query.append("                   FROM INV_AR_MN IAM" ).append("\n"); 
		query.append("                   WHERE BL_SRC_NO = A.BL_NO" ).append("\n"); 
		query.append("                   AND AR_OFC_CD = A.AR_OFC_CD" ).append("\n"); 
		query.append("                   AND REV_TP_CD <> 'M'" ).append("\n"); 
		query.append("                   AND NVL(INV_SPLIT_CD, 'M') IN ('M','C','E','X')  " ).append("\n"); 
		query.append("                   AND BL_INV_CFM_DT IS NOT NULL" ).append("\n"); 
		query.append("                   AND INV_DELT_DIV_CD = 'X' " ).append("\n"); 
		query.append("                   AND AR_IF_NO > A.AR_IF_NO)) OVER(PARTITION BY A.AR_OFC_CD, A.CNTR_NO, A.CNMV_CYC_NO) CXL_CNT" ).append("\n"); 
		query.append("        FROM INV_EDI_HDR A," ).append("\n"); 
		query.append("             INV_EDI_CHG B," ).append("\n"); 
		query.append("             (SELECT AR_OFC_CD, CNTR_NO, CNMV_CYC_NO, MAX(BL_SEQ) MAX_BL_SEQ" ).append("\n"); 
		query.append("              FROM INV_EDI_HDR" ).append("\n"); 
		query.append("              WHERE AR_OFC_CD = @[ar_ofc_cd]" ).append("\n"); 
		query.append("              #if (${sc_rfa_no} != '')" ).append("\n"); 
		query.append("                  #if (${cntc_tp_cd} == 'S')" ).append("\n"); 
		query.append("                      AND SC_NO IN (@[sc_rfa_no])" ).append("\n"); 
		query.append("                  #elseif (${cntc_tp_cd} == 'R')" ).append("\n"); 
		query.append("                      AND RFA_NO IN (@[sc_rfa_no])" ).append("\n"); 
		query.append("                  #end" ).append("\n"); 
		query.append("              #end" ).append("\n"); 
		query.append("              #if (${cust_cd} != '')" ).append("\n"); 
		query.append("                  AND ACT_CUST_CNT_CD||ACT_CUST_SEQ IN (@[cust_cd])" ).append("\n"); 
		query.append("              #end" ).append("\n"); 
		query.append("              #if (${source_cd} == 'BKG')" ).append("\n"); 
		query.append("                  AND SUBSTR(REV_TP_SRC_CD, 1, 1) <> 'M'" ).append("\n"); 
		query.append("              #elseif (${source_cd} == 'DMT')" ).append("\n"); 
		query.append("                  AND SUBSTR(REV_TP_SRC_CD, 1, 1) = 'M'" ).append("\n"); 
		query.append("              #end" ).append("\n"); 
		query.append("              #if (${io_bnd_cd} != 'A')" ).append("\n"); 
		query.append("                  AND IO_BND_CD = @[io_bnd_cd]" ).append("\n"); 
		query.append("              #end" ).append("\n"); 
		query.append("              #if (${tvvd_cd} != '')" ).append("\n"); 
		query.append("                  AND TRNK_VVD_CD = @[tvvd_cd]" ).append("\n"); 
		query.append("              #end" ).append("\n"); 
		query.append("              #if (${bdr_ind_flg} != 'A')" ).append("\n"); 
		query.append("                  AND BDR_IND_FLG = @[bdr_ind_flg]     " ).append("\n"); 
		query.append("              #end" ).append("\n"); 
		query.append("              #if (${bl_no} != '')" ).append("\n"); 
		query.append("                  AND BL_NO = @[bl_no]" ).append("\n"); 
		query.append("              #end" ).append("\n"); 
		query.append("              #if (${sa_from_dt} != '' && ${sa_to_dt} != '')" ).append("\n"); 
		query.append("                  AND SAIL_ARR_DT BETWEEN REPLACE(@[sa_from_dt], '-', '') AND REPLACE(@[sa_to_dt], '-', '')" ).append("\n"); 
		query.append("              #end" ).append("\n"); 
		query.append("              #if (${svc_scp_cd} != '')" ).append("\n"); 
		query.append("                  AND SVC_SCP_CD = @[svc_scp_cd]" ).append("\n"); 
		query.append("              #end" ).append("\n"); 
		query.append("              #if (${cntr_no} != '')" ).append("\n"); 
		query.append("                  AND CNTR_NO = @[cntr_no]" ).append("\n"); 
		query.append("              #end" ).append("\n"); 
		query.append("              AND EDI_TP_CD = 'INV_CNTR'" ).append("\n"); 
		query.append("              AND SUBSTR(REV_TP_SRC_CD, 1, 1) <> 'M'" ).append("\n"); 
		query.append("              GROUP BY AR_OFC_CD, CNTR_NO, CNMV_CYC_NO) C" ).append("\n"); 
		query.append("        WHERE A.EDI_HDR_SEQ = B.EDI_HDR_SEQ" ).append("\n"); 
		query.append("        AND A.AR_OFC_CD = C.AR_OFC_CD" ).append("\n"); 
		query.append("        AND A.CNTR_NO = C.CNTR_NO" ).append("\n"); 
		query.append("        AND A.CNMV_CYC_NO = C.CNMV_CYC_NO" ).append("\n"); 
		query.append("        AND A.BL_SEQ = C.MAX_BL_SEQ" ).append("\n"); 
		query.append("        AND A.EDI_TP_CD = 'INV_CNTR'" ).append("\n"); 
		query.append("        AND SUBSTR(A.REV_TP_SRC_CD, 1, 1) <> 'M'" ).append("\n"); 
		query.append("        #if (${chg_cd} != '')" ).append("\n"); 
		query.append("            AND B.CHG_CD IN (@[chg_cd])" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("        AND EXISTS (SELECT 'X'" ).append("\n"); 
		query.append("                    FROM INV_EDI_HDR P," ).append("\n"); 
		query.append("                         INV_EDI_CHG Q" ).append("\n"); 
		query.append("                    WHERE P.EDI_HDR_SEQ = Q.EDI_HDR_SEQ" ).append("\n"); 
		query.append("                    AND P.AR_OFC_CD = A.AR_OFC_CD" ).append("\n"); 
		query.append("                    AND P.CNTR_NO = A.CNTR_NO" ).append("\n"); 
		query.append("                    AND P.CNMV_CYC_NO = A.CNMV_CYC_NO" ).append("\n"); 
		query.append("                    AND P.BL_SEQ = A.BL_SEQ" ).append("\n"); 
		query.append("                    AND P.EDI_TP_CD = 'INV_CNTR'" ).append("\n"); 
		query.append("                    AND SUBSTR(P.REV_TP_SRC_CD, 1, 1) <> 'M'" ).append("\n"); 
		query.append("                    HAVING SUM(Q.CHG_AMT) > 0)" ).append("\n"); 
		query.append("        -- END EDI CANCEL DATA        " ).append("\n"); 
		query.append("        UNION ALL      " ).append("\n"); 
		query.append("        -- START NEW EDI DATA" ).append("\n"); 
		query.append("  		SELECT NULL EDI_HDR_SEQ " ).append("\n"); 
		query.append("			, B.AR_IF_NO " ).append("\n"); 
		query.append("	        , B.BL_SRC_NO BL_NO" ).append("\n"); 
		query.append("            , NVL((SELECT MAX(BL_SEQ)" ).append("\n"); 
		query.append("                   FROM INV_EDI_HDR" ).append("\n"); 
		query.append("                   WHERE CNTR_NO = D.CNTR_NO" ).append("\n"); 
		query.append("                   AND CNMV_CYC_NO = G.CNMV_CYC_NO" ).append("\n"); 
		query.append("                   AND AR_OFC_CD = B.AR_OFC_CD" ).append("\n"); 
		query.append("                   AND SUBSTR(REV_TP_SRC_CD, 1, 1) <> 'M'" ).append("\n"); 
		query.append("                   AND EDI_TP_CD = 'INV_CNTR'), 0) BL_SEQ    " ).append("\n"); 
		query.append("            , B.BKG_NO" ).append("\n"); 
		query.append("            , '' INV_NO" ).append("\n"); 
		query.append("            , D.CNTR_NO" ).append("\n"); 
		query.append("            , G.CNMV_CYC_NO" ).append("\n"); 
		query.append("            , B.AR_OFC_CD" ).append("\n"); 
		query.append("            , B.REV_TP_CD||B.REV_SRC_CD REV_TP_SRC_CD" ).append("\n"); 
		query.append("            , B.ACT_CUST_CNT_CD" ).append("\n"); 
		query.append("            , B.ACT_CUST_SEQ" ).append("\n"); 
		query.append("            , B.VSL_CD" ).append("\n"); 
		query.append("            , B.SKD_VOY_NO" ).append("\n"); 
		query.append("            , B.SKD_DIR_CD" ).append("\n"); 
		query.append("            , B.TRNK_VSL_CD||B.TRNK_SKD_VOY_NO||B.TRNK_SKD_DIR_CD TRNK_VVD_CD" ).append("\n"); 
		query.append("            , B.SVC_SCP_CD" ).append("\n"); 
		query.append("            , B.SLAN_CD" ).append("\n"); 
		query.append("            , B.SAIL_ARR_DT" ).append("\n"); 
		query.append("            , B.IO_BND_CD" ).append("\n"); 
		query.append("            , B.POR_CD" ).append("\n"); 
		query.append("            , B.POL_CD" ).append("\n"); 
		query.append("            , B.POD_CD" ).append("\n"); 
		query.append("            , B.DEL_CD" ).append("\n"); 
		query.append("            , B.SC_NO" ).append("\n"); 
		query.append("            , B.RFA_NO" ).append("\n"); 
		query.append("            , C.BDR_FLG BDR_IND_FLG" ).append("\n"); 
		query.append("            , TO_CHAR(SYSDATE, 'YYYYMMDD') INV_DT" ).append("\n"); 
		query.append("            , B.LOCL_CURR_CD" ).append("\n"); 
		query.append("            , NULL INV_TTL_LOCL_AMT" ).append("\n"); 
		query.append("            , 'N' EDI_SND_FLG" ).append("\n"); 
		query.append("            , NULL EDI_SND_DT" ).append("\n"); 
		query.append("            , 'INV_CNTR' EDI_TP_CD" ).append("\n"); 
		query.append("            , ROW_NUMBER() OVER (PARTITION BY D.CNTR_NO, G.CNMV_CYC_NO, B.BL_SRC_NO ORDER BY D.CHG_CD, D.CURR_CD, D.RAT_UT_CD) CHG_SEQ" ).append("\n"); 
		query.append("            , D.CHG_CD" ).append("\n"); 
		query.append("            , D.CURR_CD" ).append("\n"); 
		query.append("            , D.RAT_UT_CD PER_TP_CD" ).append("\n"); 
		query.append("            , D.CHG_UT_AMT TRF_RT_AMT" ).append("\n"); 
		query.append("            , D.RAT_AS_QTY RAT_AS_CNTR_QTY" ).append("\n"); 
		query.append("            , D.CHG_AMT" ).append("\n"); 
		query.append("            , (SELECT INV_XCH_RT" ).append("\n"); 
		query.append("               FROM INV_AR_CHG" ).append("\n"); 
		query.append("               WHERE AR_IF_NO = B.AR_IF_NO" ).append("\n"); 
		query.append("               AND CURR_CD = D.CURR_CD" ).append("\n"); 
		query.append("               AND ROWNUM = 1) INV_XCH_RT" ).append("\n"); 
		query.append("            , B.INV_DELT_DIV_CD     " ).append("\n"); 
		query.append("            , NVL((SELECT SUM(DISTINCT SUBSTR(AR_IF_NO, 4))" ).append("\n"); 
		query.append("                   FROM INV_EDI_HDR" ).append("\n"); 
		query.append("                   WHERE EDI_TP_CD = 'INV_CNTR'" ).append("\n"); 
		query.append("                   AND CNTR_NO = D.CNTR_NO" ).append("\n"); 
		query.append("                   AND CNMV_CYC_NO = G.CNMV_CYC_NO" ).append("\n"); 
		query.append("                   AND AR_OFC_CD = B.AR_OFC_CD" ).append("\n"); 
		query.append("                   AND BL_SEQ IN (SELECT MAX(BL_SEQ)" ).append("\n"); 
		query.append("                                  FROM INV_EDI_HDR" ).append("\n"); 
		query.append("                                  WHERE EDI_TP_CD = 'INV_CNTR'" ).append("\n"); 
		query.append("                                  AND CNTR_NO = D.CNTR_NO" ).append("\n"); 
		query.append("                                  AND CNMV_CYC_NO = G.CNMV_CYC_NO" ).append("\n"); 
		query.append("                                  AND AR_OFC_CD = B.AR_OFC_CD)), 0)" ).append("\n"); 
		query.append("              - SUM(DISTINCT SUBSTR(A.MAX_AR_IF_NO, 4)) OVER(PARTITION BY B.AR_OFC_CD, D.CNTR_NO, G.CNMV_CYC_NO) EDI_CNT" ).append("\n"); 
		query.append("            , 1 CXL_CNT" ).append("\n"); 
		query.append("        FROM (SELECT BKG_NO, MAX(AR_IF_NO) MAX_AR_IF_NO" ).append("\n"); 
		query.append("              FROM INV_AR_MN IAM" ).append("\n"); 
		query.append("              WHERE AR_OFC_CD = @[ar_ofc_cd]" ).append("\n"); 
		query.append("              #if (${sc_rfa_no} != '')" ).append("\n"); 
		query.append("                  #if (${cntc_tp_cd} == 'S')" ).append("\n"); 
		query.append("                      AND SC_NO IN (@[sc_rfa_no])" ).append("\n"); 
		query.append("                  #elseif (${cntc_tp_cd} == 'R')" ).append("\n"); 
		query.append("                      AND RFA_NO IN (@[sc_rfa_no])" ).append("\n"); 
		query.append("                  #end" ).append("\n"); 
		query.append("              #end" ).append("\n"); 
		query.append("              #if (${cust_cd} != '')" ).append("\n"); 
		query.append("                  AND ACT_CUST_CNT_CD||ACT_CUST_SEQ IN (@[cust_cd])" ).append("\n"); 
		query.append("              #end" ).append("\n"); 
		query.append("              #if (${source_cd} == 'BKG')" ).append("\n"); 
		query.append("                  AND REV_TP_CD <> 'M'" ).append("\n"); 
		query.append("              #elseif (${source_cd} == 'DMT')" ).append("\n"); 
		query.append("                  AND REV_TP_CD = 'M'" ).append("\n"); 
		query.append("              #end" ).append("\n"); 
		query.append("              #if (${io_bnd_cd} != 'A')" ).append("\n"); 
		query.append("                  AND IO_BND_CD = @[io_bnd_cd]" ).append("\n"); 
		query.append("              #end" ).append("\n"); 
		query.append("              #if (${tvvd_cd} != '')" ).append("\n"); 
		query.append("                  AND TRNK_VSL_CD||TRNK_SKD_VOY_NO||TRNK_SKD_DIR_CD = @[tvvd_cd]" ).append("\n"); 
		query.append("              #end  " ).append("\n"); 
		query.append("              #if (${bl_no} != '')" ).append("\n"); 
		query.append("                  AND BL_SRC_NO = @[bl_no]" ).append("\n"); 
		query.append("              #end" ).append("\n"); 
		query.append("              #if (${sa_from_dt} != '' && ${sa_to_dt} != '')" ).append("\n"); 
		query.append("                  AND SAIL_ARR_DT BETWEEN REPLACE(@[sa_from_dt], '-', '') AND REPLACE(@[sa_to_dt], '-', '')" ).append("\n"); 
		query.append("              #end" ).append("\n"); 
		query.append("              #if (${svc_scp_cd} != '')" ).append("\n"); 
		query.append("                  AND SVC_SCP_CD = @[svc_scp_cd]" ).append("\n"); 
		query.append("              #end     " ).append("\n"); 
		query.append("              AND REV_TP_CD <> 'M'" ).append("\n"); 
		query.append("              AND NVL(INV_SPLIT_CD, 'M') IN ('M','C','E','X')" ).append("\n"); 
		query.append("              AND BL_INV_CFM_DT IS NOT NULL" ).append("\n"); 
		query.append("              AND OTS_PAY_CD IS NULL " ).append("\n"); 
		query.append("              AND ORG_INV_NO IS NULL" ).append("\n"); 
		query.append("              GROUP BY BKG_NO) A," ).append("\n"); 
		query.append("              INV_AR_MN B," ).append("\n"); 
		query.append("              BKG_BL_DOC C," ).append("\n"); 
		query.append("              BKG_CNTR_RT D," ).append("\n"); 
		query.append("              BKG_RATE E," ).append("\n"); 
		query.append("              MDM_ORGANIZATION F," ).append("\n"); 
		query.append("              BKG_CONTAINER G" ).append("\n"); 
		query.append("        WHERE A.MAX_AR_IF_NO = B.AR_IF_NO" ).append("\n"); 
		query.append("        AND A.BKG_NO = C.BKG_NO" ).append("\n"); 
		query.append("        AND A.BKG_NO = D.BKG_NO" ).append("\n"); 
		query.append("        AND A.BKG_NO = E.BKG_NO" ).append("\n"); 
		query.append("        AND A.BKG_NO = G.BKG_NO" ).append("\n"); 
		query.append("        AND D.CNTR_NO = G.CNTR_NO" ).append("\n"); 
		query.append("        AND B.INV_DELT_DIV_CD = 'N'" ).append("\n"); 
		query.append("        AND F.OFC_CD = NVL(D.N3PTY_RCV_OFC_CD, DECODE(D.FRT_TERM_CD, 'P', E.PPD_RCV_OFC_CD, E.CLT_OFC_CD))" ).append("\n"); 
		query.append("        AND F.AR_OFC_CD = @[ar_ofc_cd]" ).append("\n"); 
		query.append("        #if (${io_bnd_cd} != 'A')" ).append("\n"); 
		query.append("            AND D.FRT_TERM_CD = DECODE(@[io_bnd_cd], 'O', 'P', 'I', 'C')" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("        #if (${bdr_ind_flg} != 'A')" ).append("\n"); 
		query.append("            AND C.BDR_FLG = @[bdr_ind_flg]     " ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("        #if (${chg_cd} != '')" ).append("\n"); 
		query.append("            AND D.CHG_CD IN (@[chg_cd])" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("        #if (${cntr_no} != '')" ).append("\n"); 
		query.append("            AND D.CNTR_NO = @[cntr_no]" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("        -- END NEW EDI DATA   " ).append("\n"); 
		query.append("        UNION ALL   " ).append("\n"); 
		query.append("        -- START MDM,MDT DATA" ).append("\n"); 
		query.append("        SELECT NULL EDI_HDR_SEQ " ).append("\n"); 
		query.append("			, A.AR_IF_NO " ).append("\n"); 
		query.append("	        , A.BL_SRC_NO BL_NO         " ).append("\n"); 
		query.append("            , NVL((SELECT MAX(BL_SEQ)" ).append("\n"); 
		query.append("                   FROM INV_EDI_HDR" ).append("\n"); 
		query.append("                   WHERE CNTR_NO = C.TRF_NO" ).append("\n"); 
		query.append("                   AND CNMV_CYC_NO = D.CNMV_CYC_NO + 9000" ).append("\n"); 
		query.append("                   AND AR_OFC_CD = A.AR_OFC_CD" ).append("\n"); 
		query.append("                   AND SUBSTR(REV_TP_SRC_CD, 1, 1) = 'M'" ).append("\n"); 
		query.append("                   AND EDI_TP_CD = 'INV_CNTR'), 0) BL_SEQ     " ).append("\n"); 
		query.append("            , A.BKG_NO" ).append("\n"); 
		query.append("            , '' INV_NO" ).append("\n"); 
		query.append("            , C.TRF_NO AS CNTR_NO" ).append("\n"); 
		query.append("            , D.CNMV_CYC_NO + 9000 CNMV_CYC_NO" ).append("\n"); 
		query.append("            , A.AR_OFC_CD" ).append("\n"); 
		query.append("            , A.REV_TP_CD||A.REV_SRC_CD REV_TP_SRC_CD" ).append("\n"); 
		query.append("            , A.ACT_CUST_CNT_CD" ).append("\n"); 
		query.append("            , A.ACT_CUST_SEQ" ).append("\n"); 
		query.append("            , A.VSL_CD" ).append("\n"); 
		query.append("            , A.SKD_VOY_NO" ).append("\n"); 
		query.append("            , A.SKD_DIR_CD" ).append("\n"); 
		query.append("            , A.TRNK_VSL_CD||A.TRNK_SKD_VOY_NO||A.TRNK_SKD_DIR_CD TRNK_VVD_CD" ).append("\n"); 
		query.append("            , A.SVC_SCP_CD" ).append("\n"); 
		query.append("            , A.SLAN_CD" ).append("\n"); 
		query.append("            , A.SAIL_ARR_DT" ).append("\n"); 
		query.append("            , A.IO_BND_CD" ).append("\n"); 
		query.append("            , A.POR_CD" ).append("\n"); 
		query.append("            , A.POL_CD" ).append("\n"); 
		query.append("            , A.POD_CD" ).append("\n"); 
		query.append("            , A.DEL_CD" ).append("\n"); 
		query.append("            , A.SC_NO" ).append("\n"); 
		query.append("            , A.RFA_NO" ).append("\n"); 
		query.append("            , '' BDR_IND_FLG" ).append("\n"); 
		query.append("            , TO_CHAR(SYSDATE, 'YYYYMMDD') INV_DT" ).append("\n"); 
		query.append("            , A.LOCL_CURR_CD" ).append("\n"); 
		query.append("            , NULL INV_TTL_LOCL_AMT" ).append("\n"); 
		query.append("            , 'N' EDI_SND_FLG" ).append("\n"); 
		query.append("            , NULL EDI_SND_DT" ).append("\n"); 
		query.append("            , 'INV_CNTR' EDI_TP_CD" ).append("\n"); 
		query.append("            , C.CHG_SEQ" ).append("\n"); 
		query.append("            , C.CHG_CD" ).append("\n"); 
		query.append("            , C.CURR_CD" ).append("\n"); 
		query.append("            , C.PER_TP_CD" ).append("\n"); 
		query.append("            , C.TRF_RT_AMT" ).append("\n"); 
		query.append("            , C.RAT_AS_CNTR_QTY" ).append("\n"); 
		query.append("            , C.CHG_AMT" ).append("\n"); 
		query.append("            , (SELECT INV_XCH_RT" ).append("\n"); 
		query.append("               FROM INV_AR_CHG" ).append("\n"); 
		query.append("               WHERE AR_IF_NO = A.AR_IF_NO" ).append("\n"); 
		query.append("               AND CURR_CD = C.CURR_CD" ).append("\n"); 
		query.append("               AND ROWNUM = 1) INV_XCH_RT" ).append("\n"); 
		query.append("             , A.INV_DELT_DIV_CD " ).append("\n"); 
		query.append("             , 1 EDI_CNT" ).append("\n"); 
		query.append("             , 1 CXL_CNT" ).append("\n"); 
		query.append("        FROM INV_AR_MN A," ).append("\n"); 
		query.append("             INV_AR_IF_MN B," ).append("\n"); 
		query.append("             INV_AR_IF_CHG C," ).append("\n"); 
		query.append("             BKG_CONTAINER D" ).append("\n"); 
		query.append("        WHERE A.AR_IF_NO = B.AR_IF_NO" ).append("\n"); 
		query.append("        AND B.SRC_IF_DT = C.SRC_IF_DT" ).append("\n"); 
		query.append("        AND B.SRC_IF_SEQ = C.SRC_IF_SEQ" ).append("\n"); 
		query.append("        AND A.BKG_NO = D.BKG_NO" ).append("\n"); 
		query.append("        AND C.TRF_NO = D.CNTR_NO" ).append("\n"); 
		query.append("        AND B.BL_INV_IF_FLG = 'Y'" ).append("\n"); 
		query.append("        AND B.BL_INV_IF_DT IS NOT NULL" ).append("\n"); 
		query.append("        AND A.REV_TP_CD = 'M'" ).append("\n"); 
		query.append("        AND A.REV_SRC_CD IN ('DM', 'DT')" ).append("\n"); 
		query.append("        AND A.OTS_PAY_CD IS NULL " ).append("\n"); 
		query.append("        AND A.ORG_INV_NO IS NULL" ).append("\n"); 
		query.append("        AND A.AR_OFC_CD = @[ar_ofc_cd]" ).append("\n"); 
		query.append("        #if (${sc_rfa_no} != '')" ).append("\n"); 
		query.append("            #if (${cntc_tp_cd} == 'S')" ).append("\n"); 
		query.append("                AND A.SC_NO IN (@[sc_rfa_no])" ).append("\n"); 
		query.append("            #elseif (${cntc_tp_cd} == 'R')" ).append("\n"); 
		query.append("                AND A.RFA_NO IN (@[sc_rfa_no])" ).append("\n"); 
		query.append("            #end" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("        #if (${cust_cd} != '')" ).append("\n"); 
		query.append("            AND A.ACT_CUST_CNT_CD||A.ACT_CUST_SEQ IN (@[cust_cd])" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("        #if (${source_cd} == 'BKG')" ).append("\n"); 
		query.append("            AND A.REV_TP_CD <> 'M'" ).append("\n"); 
		query.append("        #elseif (${source_cd} == 'DMT')" ).append("\n"); 
		query.append("            AND A.REV_TP_CD = 'M'" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("        #if (${io_bnd_cd} != 'A')" ).append("\n"); 
		query.append("            AND A.IO_BND_CD = @[io_bnd_cd]" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("        #if (${tvvd_cd} != '')" ).append("\n"); 
		query.append("            AND A.TRNK_VSL_CD||A.TRNK_SKD_VOY_NO||A.TRNK_SKD_DIR_CD = @[tvvd_cd]" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("        #if (${bl_no} != '')" ).append("\n"); 
		query.append("            AND A.BL_SRC_NO = @[bl_no]" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("        #if (${sa_from_dt} != '' && ${sa_to_dt} != '')" ).append("\n"); 
		query.append("            AND A.SAIL_ARR_DT BETWEEN REPLACE(@[sa_from_dt], '-', '') AND REPLACE(@[sa_to_dt], '-', '')" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("        #if (${svc_scp_cd} != '')" ).append("\n"); 
		query.append("            AND A.SVC_SCP_CD = @[svc_scp_cd]" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("        #if (${chg_cd} != '')" ).append("\n"); 
		query.append("            AND C.CHG_CD IN (@[chg_cd])" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("        #if (${cntr_no} != '')" ).append("\n"); 
		query.append("            AND C.TRF_NO = @[cntr_no]" ).append("\n"); 
		query.append("        #end   " ).append("\n"); 
		query.append("        AND NOT EXISTS (SELECT 'X'   " ).append("\n"); 
		query.append("                        FROM INV_EDI_HDR" ).append("\n"); 
		query.append("                        WHERE EDI_TP_CD = 'INV_CNTR'" ).append("\n"); 
		query.append("						AND CNTR_NO = C.TRF_NO" ).append("\n"); 
		query.append("                        AND CNMV_CYC_NO = D.CNMV_CYC_NO + 9000" ).append("\n"); 
		query.append("                        AND AR_IF_NO = A.AR_IF_NO)" ).append("\n"); 
		query.append("        -- END MDM,MDT DATA                                  " ).append("\n"); 
		query.append("         )" ).append("\n"); 
		query.append("    WHERE EDI_CNT <> 0" ).append("\n"); 
		query.append("    AND CXL_CNT <> 0" ).append("\n"); 
		query.append("     )" ).append("\n"); 
		query.append("ORDER BY INV_NO" ).append("\n"); 
		query.append("        , BL_NO" ).append("\n"); 
		query.append("        , AR_IF_NO" ).append("\n"); 
		query.append("        , CHG_SEQ" ).append("\n"); 

	}
}