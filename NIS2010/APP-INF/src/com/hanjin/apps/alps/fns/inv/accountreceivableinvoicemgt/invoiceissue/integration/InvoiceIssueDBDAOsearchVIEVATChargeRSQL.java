/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : InvoiceIssueDBDAOsearchVIEVATChargeRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.07.28
*@LastModifier : 
*@LastVersion : 1.0
* 2014.07.28 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.invoiceissue.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class InvoiceIssueDBDAOsearchVIEVATChargeRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * .searchVIEVATCharge
	  * </pre>
	  */
	public InvoiceIssueDBDAOsearchVIEVATChargeRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("bl_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.invoiceissue.integration").append("\n"); 
		query.append("FileName : InvoiceIssueDBDAOsearchVIEVATChargeRSQL").append("\n"); 
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
		query.append("SELECT CASE WHEN VAT_CNT > 0 AND SUM_VAT_AMT <> 0 THEN 'Y'" ).append("\n"); 
		query.append("                                                  ELSE 'N'" ).append("\n"); 
		query.append("       END VAT_EXIST" ).append("\n"); 
		query.append("#if (${inv_type} == 'ETC')" ).append("\n"); 
		query.append("	  ,A.CHG_CD " ).append("\n"); 
		query.append("	  ,B.CHG_CD CHG_CD_ISS" ).append("\n"); 
		query.append("FROM (SELECT DISTINCT DECODE(B.CHG_CD, 'EIS', 'VET','VFT','VFT','VPT','VPT','TVA') CHG_CD" ).append("\n"); 
		query.append("    	 FROM INV_AR_MN A, INV_AR_CHG B" ).append("\n"); 
		query.append("     	 WHERE A.AR_IF_NO = B.AR_IF_NO" ).append("\n"); 
		query.append("       		AND A.BL_SRC_NO = @[bl_no]" ).append("\n"); 
		query.append("       		AND A.AR_OFC_CD = @[ar_ofc_cd]" ).append("\n"); 
		query.append("       		AND A.BL_INV_CFM_DT IS NOT NULL" ).append("\n"); 
		query.append("       		AND (B.CHG_CD = 'EIS' AND A.IO_BND_CD = 'I' " ).append("\n"); 
		query.append("            OR (B.CHG_CD IN ('BCC','PCS','VPT'))                                                                                                                                                        " ).append("\n"); 
		query.append("            OR (B.CHG_CD IN ('MCF','VFT') AND B.CURR_CD IN ('VND','USD'))                                                                                                                                                        " ).append("\n"); 
		query.append("            OR (B.CHG_CD = 'LBP' AND A.IO_BND_CD = 'O' AND B.CURR_CD = 'VND')                                                                                                                                                                                     " ).append("\n"); 
		query.append("            OR (B.CHG_CD = 'TAC' AND B.CURR_CD = 'VND')" ).append("\n"); 
		query.append("			OR (B.CHG_CD = 'BLR' AND  A.IO_BND_CD = 'O' AND B.CURR_CD = 'VND'))" ).append("\n"); 
		query.append("       		) A" ).append("\n"); 
		query.append(",(SELECT COUNT(*) VAT_CNT, SUM(B.CHG_AMT) SUM_VAT_AMT, B.CHG_CD" ).append("\n"); 
		query.append("FROM INV_AR_MN A, INV_AR_CHG B" ).append("\n"); 
		query.append(" WHERE A.AR_IF_NO = B.AR_IF_NO" ).append("\n"); 
		query.append("   AND A.BL_SRC_NO = @[bl_no]" ).append("\n"); 
		query.append("   AND A.AR_OFC_CD = @[ar_ofc_cd]" ).append("\n"); 
		query.append("   AND A.BL_INV_CFM_DT IS NOT NULL" ).append("\n"); 
		query.append("   AND B.INV_ISS_FLG = 'N'" ).append("\n"); 
		query.append("   AND B.CHG_CD in ('TVA','VET','VFT','VPT')" ).append("\n"); 
		query.append("   GROUP BY B.CHG_CD" ).append("\n"); 
		query.append("   ) B" ).append("\n"); 
		query.append("WHERE A.CHG_CD = B.CHG_CD(+)" ).append("\n"); 
		query.append("ORDER BY A.CHG_CD DESC" ).append("\n"); 
		query.append("#else " ).append("\n"); 
		query.append("    ,'' CHG_CD" ).append("\n"); 
		query.append("	,'' CHG_CD_ISS" ).append("\n"); 
		query.append("		FROM (" ).append("\n"); 
		query.append("SELECT COUNT(*) VAT_CNT, SUM(B.CHG_AMT) SUM_VAT_AMT" ).append("\n"); 
		query.append("FROM INV_AR_MN A, INV_AR_CHG B" ).append("\n"); 
		query.append(" WHERE A.AR_IF_NO = B.AR_IF_NO" ).append("\n"); 
		query.append("   AND A.BL_SRC_NO = @[bl_no]" ).append("\n"); 
		query.append("   AND A.AR_OFC_CD = @[ar_ofc_cd]" ).append("\n"); 
		query.append("   AND A.BL_INV_CFM_DT IS NOT NULL" ).append("\n"); 
		query.append("   /* 베트남은 CHARGE별로 이슈를 하기 때문에 INV_AR_MN 테이블의 ISSUE FLAG 로는 해당 TYPW별로 이슈 여부를 알 수 없기 때문에 INV_AR_CHG 테이블에서 체크를 함 */" ).append("\n"); 
		query.append("   AND B.INV_ISS_FLG = 'N'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("   #if (${inv_type} == 'THC')" ).append("\n"); 
		query.append("       AND A.REV_TP_CD <> 'M'" ).append("\n"); 
		query.append("       AND B.CHG_CD = 'VTT')" ).append("\n"); 
		query.append("   #end" ).append("\n"); 
		query.append("   /* DHF TYPE 은 REVENUE TYPE CODE 가 B,C 와 M TYPE 이 섞여 있는 경우가 있다고 해서 REV_TP_CD 비교를 하지 않음  */" ).append("\n"); 
		query.append("   #if (${inv_type} == 'DHF')" ).append("\n"); 
		query.append("        AND B.CHG_CD = 'VDT')" ).append("\n"); 
		query.append("   #end" ).append("\n"); 
		query.append("   #if (${inv_type} == 'SLF')" ).append("\n"); 
		query.append("       AND A.REV_TP_CD <> 'M'" ).append("\n"); 
		query.append("       AND B.CHG_CD = 'VST')" ).append("\n"); 
		query.append("   #end" ).append("\n"); 
		query.append("   #if (${inv_type} == 'CLN')" ).append("\n"); 
		query.append("       AND A.REV_TP_CD <> 'M'" ).append("\n"); 
		query.append("       AND B.CHG_CD = 'VCT')" ).append("\n"); 
		query.append("   #end" ).append("\n"); 
		query.append("   #if (${inv_type} == 'REF')" ).append("\n"); 
		query.append("       AND A.REV_TP_CD <> 'M'" ).append("\n"); 
		query.append("       AND B.CHG_CD = 'VRT')" ).append("\n"); 
		query.append("   #end" ).append("\n"); 

	}
}