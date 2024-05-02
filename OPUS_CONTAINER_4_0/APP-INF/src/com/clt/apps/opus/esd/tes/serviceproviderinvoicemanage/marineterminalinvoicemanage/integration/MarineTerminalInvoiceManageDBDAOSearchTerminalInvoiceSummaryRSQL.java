/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : MarineTerminalInvoiceManageDBDAOSearchTerminalInvoiceSummaryRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.04.14
*@LastModifier : 
*@LastVersion : 1.0
* 2016.04.14 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.tes.serviceproviderinvoicemanage.marineterminalinvoicemanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class MarineTerminalInvoiceManageDBDAOSearchTerminalInvoiceSummaryRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchTerminalInvoiceSummary
	  * </pre>
	  */
	public MarineTerminalInvoiceManageDBDAOSearchTerminalInvoiceSummaryRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cost_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vndr_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("to_prd_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inv_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inv_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("yd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fm_prd_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("tml_inv_sts_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("csr_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("tml_inv_rjct_sts_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.tes.serviceproviderinvoicemanage.marineterminalinvoicemanage.integration").append("\n"); 
		query.append("FileName : MarineTerminalInvoiceManageDBDAOSearchTerminalInvoiceSummaryRSQL").append("\n"); 
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
		query.append("SELECT XMLAGG(XMLELEMENT(x,''||BB.LGS_COST_CD||' ') ORDER BY LGS_COST_CD).EXTRACT('//text()').GetStringVal() AS COST_CD, " ).append("\n"); 
		query.append("       AA.INV_NO, AA.VVD, AA.TML_SO_OFC_CTY_CD, AA.TML_SO_SEQ, AA.INV_TP_CD,AA.TML_INV_TP_CD,AA.TML_INV_STS_CD,AA.TML_INV_RJCT_STS_CD,AA.CRE_DT,AA.LOCL_CRE_DT,AA.INV_OFC_CD,AA.INV_OFC_DEL_FLG," ).append("\n"); 
		query.append("       AA.COST_OFC_CD,AA.COST_OFC_DEL_FLG,AA.YD_CD,AA.YD_DEL_FLG,AA.CURR_CD,AA.ISS_DT,AA.RCV_DT,AA.EFF_DT,AA.PAY_DUE_DT,AA.PAY_DT,AA.PAY_FLG,AA.HLD_FLG,AA.VNDR_SEQ,AA.VNDR_DEL_FLG, " ).append("\n"); 
		query.append("       AA.VAT_AMT,AA.WHLD_TAX_AMT,AA.TTL_INV_AMT,AA.DELT_FLG,AA.CSR_NO,AA.CRE_USR_ID,AA.CSR_STATUS,AA.TML_EDI_SO_OFC_CTY_CD,AA.TML_EDI_SO_SEQ,AA.INV_RJCT_RMK,AA.EDI_FLG,AA.RTRO_TML_INV_FLG," ).append("\n"); 
		query.append("       AA.AUTO_CALC_AMT ,AA.MANUAL_AMT" ).append("\n"); 
		query.append("FROM " ).append("\n"); 
		query.append("(SELECT INV_NO,  VVD," ).append("\n"); 
		query.append("TML_SO_OFC_CTY_CD,TML_SO_SEQ,INV_TP_CD,TML_INV_TP_CD,TML_INV_STS_CD,TML_INV_RJCT_STS_CD,CRE_DT,LOCL_CRE_DT,INV_OFC_CD,INV_OFC_DEL_FLG," ).append("\n"); 
		query.append("COST_OFC_CD,COST_OFC_DEL_FLG,YD_CD,YD_DEL_FLG,CURR_CD,ISS_DT,RCV_DT,EFF_DT,PAY_DUE_DT,PAY_DT,PAY_FLG,HLD_FLG,VNDR_SEQ,VNDR_DEL_FLG, MAX(VAT_AMT) VAT_AMT, MAX(WHLD_TAX_AMT) WHLD_TAX_AMT, MAX(TTL_INV_AMT) TTL_INV_AMT," ).append("\n"); 
		query.append("DELT_FLG,CSR_NO,CRE_USR_ID,CSR_STATUS,TML_EDI_SO_OFC_CTY_CD,TML_EDI_SO_SEQ,INV_RJCT_RMK,EDI_FLG,RTRO_TML_INV_FLG, SUM(AUTO_CALC_AMT) AUTO_CALC_AMT ,SUM(MANUAL_AMT) MANUAL_AMT" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("SELECT  	/*+ FIRST_ROWS */ D.LGS_COST_CD, " ).append("\n"); 
		query.append("            H.INV_NO," ).append("\n"); 
		query.append("            '' VVD," ).append("\n"); 
		query.append("			H.TML_SO_OFC_CTY_CD," ).append("\n"); 
		query.append("			H.TML_SO_SEQ," ).append("\n"); 
		query.append("			DECODE(H.TML_INV_TP_CD,'TM','MR','ON','RC','OF','OC','ST','MS') INV_TP_CD," ).append("\n"); 
		query.append("			H.TML_INV_TP_CD," ).append("\n"); 
		query.append("			DECODE(H.TML_INV_STS_CD,'R','RC','C','CF','A','AR','P','AP','D','PD') TML_INV_STS_CD," ).append("\n"); 
		query.append("			H.TML_INV_RJCT_STS_CD," ).append("\n"); 
		query.append(" 			TO_CHAR(H.CRE_DT,'YYYYMMDD')		CRE_DT," ).append("\n"); 
		query.append(" 			TO_CHAR(H.LOCL_CRE_DT,'YYYYMMDDHH24MISS') LOCL_CRE_DT," ).append("\n"); 
		query.append("		 	H.INV_OFC_CD," ).append("\n"); 
		query.append("			(SELECT DELT_FLG FROM MDM_ORGANIZATION WHERE OFC_CD = H.INV_OFC_CD)  INV_OFC_DEL_FLG," ).append("\n"); 
		query.append("			H.COST_OFC_CD," ).append("\n"); 
		query.append("			(SELECT DELT_FLG FROM MDM_ORGANIZATION WHERE OFC_CD = H.COST_OFC_CD) COST_OFC_DEL_FLG," ).append("\n"); 
		query.append("			H.YD_CD," ).append("\n"); 
		query.append("			(SELECT DELT_FLG FROM MDM_YARD WHERE YD_CD = H.YD_CD)		YD_DEL_FLG," ).append("\n"); 
		query.append("			H.CURR_CD," ).append("\n"); 
		query.append("			TO_CHAR(H.ISS_DT,'YYYYMMDD')		ISS_DT," ).append("\n"); 
		query.append("			TO_CHAR(H.RCV_DT,'YYYYMMDD')		RCV_DT," ).append("\n"); 
		query.append("		 	TO_CHAR(H.EFF_DT,'YYYYMMDD')		EFF_DT," ).append("\n"); 
		query.append("			TO_CHAR(H.PAY_DUE_DT,'YYYYMMDD')	PAY_DUE_DT," ).append("\n"); 
		query.append("			TO_CHAR(H.PAY_DT,'YYYYMMDD')	    PAY_DT," ).append("\n"); 
		query.append("			H.PAY_FLG," ).append("\n"); 
		query.append("			H.HLD_FLG," ).append("\n"); 
		query.append("			LPAD(H.VNDR_SEQ, 6, '0') 	VNDR_SEQ," ).append("\n"); 
		query.append("			(SELECT DELT_FLG FROM MDM_VENDOR WHERE VNDR_SEQ = H.VNDR_SEQ)	VNDR_DEL_FLG," ).append("\n"); 
		query.append("		 	H.VAT_AMT," ).append("\n"); 
		query.append("		 	H.WHLD_TAX_AMT," ).append("\n"); 
		query.append("			H.TTL_INV_AMT," ).append("\n"); 
		query.append("			H.DELT_FLG," ).append("\n"); 
		query.append("			H.CSR_NO," ).append("\n"); 
		query.append("			H.CRE_USR_ID," ).append("\n"); 
		query.append("			CASE" ).append("\n"); 
		query.append("			WHEN H.TML_INV_STS_CD = 'R' THEN 'Processing'" ).append("\n"); 
		query.append("			WHEN H.TML_INV_STS_CD = 'C' AND A.IF_FLG IS NULL THEN 'Processing'" ).append("\n"); 
		query.append("			WHEN H.TML_INV_STS_CD = 'A' AND H.TML_INV_RJCT_STS_CD = 'RJ' THEN 'Disapproved'" ).append("\n"); 
		query.append("			WHEN H.TML_INV_STS_CD = 'A' AND A.IF_FLG IS NULL THEN 'Approval Requested'" ).append("\n"); 
		query.append("			WHEN A.IF_FLG = 'Y' AND A.RCV_ERR_FLG IS NULL THEN 'I/F Success'" ).append("\n"); 
		query.append("			WHEN A.IF_FLG IS NULL THEN 'Approval Requested'" ).append("\n"); 
		query.append("			WHEN A.IF_FLG = 'E' THEN 'I/F Error'" ).append("\n"); 
		query.append("			WHEN A.RCV_ERR_FLG = 'E' THEN 'Rejected'" ).append("\n"); 
		query.append("			ELSE 'ALL'" ).append("\n"); 
		query.append("			END CSR_STATUS," ).append("\n"); 
		query.append("			''  TML_EDI_SO_OFC_CTY_CD," ).append("\n"); 
		query.append("			NULL  TML_EDI_SO_SEQ," ).append("\n"); 
		query.append("			H.INV_RJCT_RMK," ).append("\n"); 
		query.append("			H.EDI_FLG," ).append("\n"); 
		query.append("			H.RTRO_TML_INV_FLG," ).append("\n"); 
		query.append("  			DECODE(D.CALC_TP_CD,'A',D.INV_AMT,0) AUTO_CALC_AMT," ).append("\n"); 
		query.append("  			DECODE(D.CALC_TP_CD,'M',D.INV_AMT,0) MANUAL_AMT" ).append("\n"); 
		query.append("FROM 		TES_TML_SO_HDR H, AP_INV_HDR A, TES_TML_SO_DTL D" ).append("\n"); 
		query.append("WHERE 		(H.DELT_FLG = 'N' or DELT_FLG IS NULL)" ).append("\n"); 
		query.append("AND		H.CSR_NO = A.CSR_NO(+)" ).append("\n"); 
		query.append("AND     H.TML_SO_OFC_CTY_CD = D.TML_SO_OFC_CTY_CD(+)" ).append("\n"); 
		query.append("AND     H.TML_SO_SEQ = D.TML_SO_SEQ(+)" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${inv_date_type} == 'I') " ).append("\n"); 
		query.append("and	h.iss_dt between to_date(@[fm_prd_dt],'yyyy-mm-dd') and to_date(@[to_prd_dt],'yyyy-mm-dd')+0.99999" ).append("\n"); 
		query.append("#elseif (${inv_date_type} == 'R') " ).append("\n"); 
		query.append("and	h.rcv_dt between to_date(@[fm_prd_dt],'yyyy-mm-dd') and to_date(@[to_prd_dt],'yyyy-mm-dd')+0.99999" ).append("\n"); 
		query.append("#elseif (${inv_date_type} == 'P') " ).append("\n"); 
		query.append("and	h.locl_upd_dt between to_date(@[fm_prd_dt],'yyyy-mm-dd') and to_date(@[to_prd_dt],'yyyy-mm-dd')+0.99999" ).append("\n"); 
		query.append("#else " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${yd_cd} != '') " ).append("\n"); 
		query.append("and	h.yd_cd	 =	@[yd_cd]" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${inv_no} != '') " ).append("\n"); 
		query.append("and	h.inv_no	like	'%'||@[inv_no]||'%'" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${cost_cd} !='')                                   " ).append("\n"); 
		query.append("AND D.LGS_COST_CD IN (" ).append("\n"); 
		query.append("    #foreach($key IN ${cost_cd})" ).append("\n"); 
		query.append("        #if($velocityCount < $cost_cd.size()) " ).append("\n"); 
		query.append("			'$key', " ).append("\n"); 
		query.append("		#else " ).append("\n"); 
		query.append("			'$key' " ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("    ) " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${vndr_seq} != '') " ).append("\n"); 
		query.append("and	h.vndr_seq	=	@[vndr_seq]" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${cost_ofc_cd} != '') " ).append("\n"); 
		query.append("and	h.cost_ofc_cd	=	@[cost_ofc_cd]" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${inv_ofc_cd} != '') " ).append("\n"); 
		query.append("and	h.inv_ofc_cd	=	@[inv_ofc_cd]" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${tml_inv_sts_cd} != '') " ).append("\n"); 
		query.append("and	h.tml_inv_sts_cd	=	@[tml_inv_sts_cd]" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("and	h.tml_inv_sts_cd in ('R','C','A','P','D')" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${csr_no} != '') " ).append("\n"); 
		query.append("and	h.csr_no like	'%'||@[csr_no]||'%'	" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${tml_inv_rjct_sts_cd} != '') " ).append("\n"); 
		query.append("and	h.tml_inv_rjct_sts_cd = @[tml_inv_rjct_sts_cd]" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("and	h.tml_inv_rjct_sts_cd in ('NL','RJ','RL')" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${csr_status} == 'AR') " ).append("\n"); 
		query.append("AND	A.IF_FLG IS NULL" ).append("\n"); 
		query.append("AND	H.CSR_NO IS NOT NULL" ).append("\n"); 
		query.append("#elseif (${csr_status} == 'PC') " ).append("\n"); 
		query.append("AND	( H.TML_INV_STS_CD = 'R' OR (H.TML_INV_STS_CD = 'C' AND A.IF_FLG IS NULL) )" ).append("\n"); 
		query.append("#elseif (${csr_status} == 'IE') " ).append("\n"); 
		query.append("AND	A.IF_FLG = 'E'" ).append("\n"); 
		query.append("#elseif (${csr_status} == 'RJ') " ).append("\n"); 
		query.append("AND	A.RCV_ERR_FLG = 'E'" ).append("\n"); 
		query.append("#elseif (${csr_status} == 'SC') " ).append("\n"); 
		query.append("AND	A.IF_FLG = 'Y'	AND A.RCV_ERR_FLG IS NULL" ).append("\n"); 
		query.append("#elseif (${csr_status} == 'DA') " ).append("\n"); 
		query.append("AND	 H.TML_INV_STS_CD = 'A' AND H.TML_INV_RJCT_STS_CD = 'RJ'" ).append("\n"); 
		query.append("#else " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("AND		H.CSR_NO = A.CSR_NO(+)																	" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("ORDER BY LOCL_CRE_DT DESC, VNDR_SEQ DESC, INV_NO DESC)" ).append("\n"); 
		query.append("GROUP BY INV_NO, TML_SO_OFC_CTY_CD,TML_SO_SEQ,INV_TP_CD,TML_INV_TP_CD,TML_INV_STS_CD,TML_INV_RJCT_STS_CD,CRE_DT,LOCL_CRE_DT,INV_OFC_CD,INV_OFC_DEL_FLG," ).append("\n"); 
		query.append("COST_OFC_CD,COST_OFC_DEL_FLG,YD_CD,YD_DEL_FLG,CURR_CD,ISS_DT,RCV_DT,EFF_DT,PAY_DUE_DT,PAY_DT,PAY_FLG,HLD_FLG,VNDR_SEQ,VNDR_DEL_FLG, " ).append("\n"); 
		query.append("DELT_FLG,CSR_NO,CRE_USR_ID,CSR_STATUS,TML_EDI_SO_OFC_CTY_CD,TML_EDI_SO_SEQ,INV_RJCT_RMK,EDI_FLG,RTRO_TML_INV_FLG) AA," ).append("\n"); 
		query.append("(SELECT DISTINCT H.INV_NO, H.TML_SO_OFC_CTY_CD, H.TML_SO_SEQ, D.LGS_COST_CD " ).append("\n"); 
		query.append(" FROM TES_TML_SO_HDR H, AP_INV_HDR A, TES_TML_SO_DTL D" ).append("\n"); 
		query.append(" WHERE 1=1" ).append("\n"); 
		query.append(" AND (H.DELT_FLG = 'N' or DELT_FLG IS NULL)" ).append("\n"); 
		query.append(" AND H.CSR_NO = A.CSR_NO(+)" ).append("\n"); 
		query.append(" AND H.TML_SO_OFC_CTY_CD = D.TML_SO_OFC_CTY_CD(+)" ).append("\n"); 
		query.append(" AND H.TML_SO_SEQ = D.TML_SO_SEQ(+)" ).append("\n"); 
		query.append(") BB" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND AA.TML_SO_OFC_CTY_CD = BB.TML_SO_OFC_CTY_CD" ).append("\n"); 
		query.append("AND AA.TML_SO_SEQ        = BB.TML_SO_SEQ" ).append("\n"); 
		query.append("AND AA.INV_NO            = BB.INV_NO     " ).append("\n"); 
		query.append("GROUP BY AA.INV_NO, AA.VVD, AA.TML_SO_OFC_CTY_CD, AA.TML_SO_SEQ, AA.INV_TP_CD,AA.TML_INV_TP_CD,AA.TML_INV_STS_CD,AA.TML_INV_RJCT_STS_CD,AA.CRE_DT,AA.LOCL_CRE_DT,AA.INV_OFC_CD,AA.INV_OFC_DEL_FLG," ).append("\n"); 
		query.append("       AA.COST_OFC_CD,AA.COST_OFC_DEL_FLG,AA.YD_CD,AA.YD_DEL_FLG,AA.CURR_CD,AA.ISS_DT,AA.RCV_DT,AA.EFF_DT,AA.PAY_DUE_DT,AA.PAY_DT,AA.PAY_FLG,AA.HLD_FLG,AA.VNDR_SEQ,AA.VNDR_DEL_FLG, " ).append("\n"); 
		query.append("       AA.VAT_AMT,AA.WHLD_TAX_AMT,AA.TTL_INV_AMT,AA.DELT_FLG,AA.CSR_NO,AA.CRE_USR_ID,AA.CSR_STATUS,AA.TML_EDI_SO_OFC_CTY_CD,AA.TML_EDI_SO_SEQ,AA.INV_RJCT_RMK,AA.EDI_FLG,AA.RTRO_TML_INV_FLG," ).append("\n"); 
		query.append("       AA.AUTO_CALC_AMT ,AA.MANUAL_AMT" ).append("\n"); 

	}
}