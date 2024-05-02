/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : InvoiceIssueDBDAOVIEIssueTargetByBLNoRSQL.java
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

public class InvoiceIssueDBDAOVIEIssueTargetByBLNoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Invoice Main, Invoice Charge 테이블을 Select
	  * </pre>
	  */
	public InvoiceIssueDBDAOVIEIssueTargetByBLNoRSQL(){
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
		params.put("inv_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bl_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.invoiceissue.integration").append("\n"); 
		query.append("FileName : InvoiceIssueDBDAOVIEIssueTargetByBLNoRSQL").append("\n"); 
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
		query.append("SELECT B.AR_IF_NO, B.AR_IF_SER_NO, B.CHG_SEQ, B.CURR_CD, @[inv_no] INV_NO" ).append("\n"); 
		query.append("  FROM INV_AR_MN A, INV_AR_CHG B " ).append("\n"); 
		query.append(" WHERE A.AR_IF_NO = B.AR_IF_NO" ).append("\n"); 
		query.append("#if (${inv_type} == 'FRT')" ).append("\n"); 
		query.append("                  AND A.REV_TP_CD <> 'M'" ).append("\n"); 
		query.append("                  AND (((B.CHG_CD NOT IN ('DHF','OBS','VDT') OR NVL(B.CURR_CD, ' ') <> 'VND') AND	" ).append("\n"); 
		query.append("                      B.CHG_CD NOT IN ('OTH','DTH', 'DDC','VTT','THC','ORC','DTC','REF','VRT','SLF','VST', 'CLN','VCT', 'VET','VFT','TVA')" ).append("\n"); 
		query.append("                      )" ).append("\n"); 
		query.append("                  OR ((B.CHG_CD = 'OTH' AND A.IO_BND_CD = 'I') OR" ).append("\n"); 
		query.append("                      (B.CHG_CD = 'DTH' AND A.IO_BND_CD = 'O') OR" ).append("\n"); 
		query.append("                      (B.CHG_CD = 'DDC' AND A.IO_BND_CD = 'O')" ).append("\n"); 
		query.append("                      )" ).append("\n"); 
		query.append("                      )" ).append("\n"); 
		query.append("                  AND NOT EXISTS(SELECT 1 FROM DUAL WHERE B.CHG_CD = 'DDF'" ).append("\n"); 
		query.append("                                                      AND A.IO_BND_CD = 'I'" ).append("\n"); 
		query.append("                                                      AND B.CURR_CD = 'VND')" ).append("\n"); 
		query.append("				  AND NOT EXISTS(SELECT 1 FROM DUAL WHERE B.CHG_CD = 'EIS' AND A.IO_BND_CD = 'I' )" ).append("\n"); 
		query.append("                  AND NOT EXISTS(SELECT 1 FROM DUAL WHERE B.CHG_CD = 'BCC' )" ).append("\n"); 
		query.append("                  AND NOT EXISTS(SELECT 1 FROM DUAL WHERE B.CHG_CD IN ('PCS','VPT'))" ).append("\n"); 
		query.append("                  AND NOT EXISTS(SELECT 1 FROM DUAL WHERE B.CHG_CD = 'MCF' AND B.CURR_CD IN ('VND','USD'))" ).append("\n"); 
		query.append("                  AND NOT EXISTS(SELECT 1 FROM DUAL WHERE B.CHG_CD = 'CFC' AND B.CURR_CD IN ('VND','USD'))" ).append("\n"); 
		query.append("                  AND NOT EXISTS(SELECT 1 FROM DUAL WHERE B.CHG_CD = 'LBP' AND A.IO_BND_CD = 'O' AND B.CURR_CD = 'VND')" ).append("\n"); 
		query.append("                  AND NOT EXISTS(SELECT 1 FROM DUAL WHERE B.CHG_CD = 'TAC' AND B.CURR_CD = 'VND')" ).append("\n"); 
		query.append("				  AND NOT EXISTS(SELECT 1 FROM DUAL WHERE B.CHG_CD = 'BLR' AND A.IO_BND_CD = 'O' AND B.CURR_CD = 'VND')" ).append("\n"); 
		query.append("#elseif (${inv_type} == 'THC')" ).append("\n"); 
		query.append("   				  AND A.REV_TP_CD <> 'M'" ).append("\n"); 
		query.append("                  AND ((B.CHG_CD = 'OTH' AND A.IO_BND_CD = 'O') OR" ).append("\n"); 
		query.append("                      (B.CHG_CD = 'DTH' AND A.IO_BND_CD = 'I') OR" ).append("\n"); 
		query.append("                      (B.CHG_CD = 'DDC' AND A.IO_BND_CD = 'I') OR " ).append("\n"); 
		query.append("                      (B.CHG_CD ='VTT') OR" ).append("\n"); 
		query.append("                      (B.CHG_CD ='THC') OR" ).append("\n"); 
		query.append("                      (B.CHG_CD ='ORC'))" ).append("\n"); 
		query.append("#elseif (${inv_type} == 'DHF')" ).append("\n"); 
		query.append("   				  AND (B.CHG_CD IN ('OBS','DHF','VDT') OR" ).append("\n"); 
		query.append("  		              (B.CHG_CD = 'DDF' AND A.IO_BND_CD ='I'))" ).append("\n"); 
		query.append("                  AND B.CURR_CD ='VND'" ).append("\n"); 
		query.append("#elseif (${inv_type} == 'DMR')" ).append("\n"); 
		query.append("   				  AND A.REV_TP_CD = 'M'" ).append("\n"); 
		query.append("                  AND B.CHG_CD IN ('DMR','DTC','TVA','IVA')" ).append("\n"); 
		query.append("                  AND B.AR_IF_NO IN (SELECT AR_IF_NO FROM INV_AR_CHG  WHERE AR_IF_NO = B.AR_IF_NO AND CHG_CD IN ('DMR','DTC'))" ).append("\n"); 
		query.append("#elseif (${inv_type} == 'MNR')" ).append("\n"); 
		query.append("   				  AND A.REV_TP_CD = 'M'" ).append("\n"); 
		query.append("                  AND B.CHG_CD IN ('RPC','TVA', 'CMF')" ).append("\n"); 
		query.append("                  AND B.AR_IF_NO IN   (SELECT AR_IF_NO FROM INV_AR_CHG  WHERE AR_IF_NO = B.AR_IF_NO AND CHG_CD = 'RPC')" ).append("\n"); 
		query.append("#elseif (${inv_type} == 'MRI')" ).append("\n"); 
		query.append("   				  AND A.REV_TP_CD = 'M'" ).append("\n"); 
		query.append("                  AND ((B.CHG_CD IN ('DHF','OBS','RPC', 'CMF') AND " ).append("\n"); 
		query.append("                      NVL(B.CURR_CD, ' ') <> 'VND') OR" ).append("\n"); 
		query.append("                      (B.CHG_CD  NOT IN ('OTH','DTH','DDC','DHF','OBS'," ).append("\n"); 
		query.append("                                         'DMR', 'DTC', 'RPC','SLF','CLN','VDT','VTT','VST','VCT','VFT','PCS','VPT')))" ).append("\n"); 
		query.append("#elseif (${inv_type} == 'SLF')" ).append("\n"); 
		query.append("                        AND A.REV_TP_CD <> 'M'" ).append("\n"); 
		query.append("		                AND B.CHG_CD IN ('SLF','VST')" ).append("\n"); 
		query.append("#elseif (${inv_type} == 'CLN')" ).append("\n"); 
		query.append("                        AND A.REV_TP_CD <> 'M'" ).append("\n"); 
		query.append("		                AND B.CHG_CD IN ('CLN','VCT')" ).append("\n"); 
		query.append("#elseif (${inv_type} == 'REF')" ).append("\n"); 
		query.append("-- 2010-07-19 TYPE REF 추가" ).append("\n"); 
		query.append("-- 2111-11-22 REF charge가 MRI로 발생되기 때문에 REVENUE TYPE 체크가 의미 없어서 삭제하기로 함" ).append("\n"); 
		query.append("		                AND B.CHG_CD IN ('REF','VRT')" ).append("\n"); 
		query.append("						AND B.CURR_CD = 'USD'" ).append("\n"); 
		query.append("#elseif (${inv_type} == 'ETC')" ).append("\n"); 
		query.append("				  		AND (  (B.CHG_CD IN ('EIS','VET') AND A.IO_BND_CD = 'I')" ).append("\n"); 
		query.append("              				OR (B.CHG_CD IN ('TVA') AND A.IO_BND_CD = 'O' AND B.CURR_CD = 'USD')" ).append("\n"); 
		query.append("              				OR (B.CHG_CD IN ('BCC','PCS','VPT'))" ).append("\n"); 
		query.append("              				OR (B.CHG_CD IN ('MCF') AND B.CURR_CD IN ('VND','USD'))" ).append("\n"); 
		query.append("              				OR (B.CHG_CD IN ('CFC','VFT') AND B.CURR_CD IN ('VND','USD'))" ).append("\n"); 
		query.append("	      			  		OR (B.CHG_CD IN ('LBP','TVA') AND A.IO_BND_CD = 'O' AND B.CURR_CD = 'VND')" ).append("\n"); 
		query.append("							OR (B.CHG_CD IN ('BLR','TVA') AND A.IO_BND_CD = 'O' AND B.CURR_CD = 'VND')" ).append("\n"); 
		query.append("	      			  		OR (B.CHG_CD IN ('TAC','TVA') AND B.CURR_CD = 'VND')" ).append("\n"); 
		query.append("	    				)" ).append("\n"); 
		query.append("#end	" ).append("\n"); 
		query.append("   AND A.BL_SRC_NO = @[bl_no]" ).append("\n"); 
		query.append("   AND A.AR_OFC_CD = @[ar_ofc_cd]" ).append("\n"); 
		query.append("   AND A.BL_INV_CFM_DT IS NOT NULL " ).append("\n"); 
		query.append("   AND B.INV_ISS_FLG = 'N' " ).append("\n"); 
		query.append("   AND NVL(A.INV_DELT_DIV_CD,'N') <> 'Y'" ).append("\n"); 

	}
}