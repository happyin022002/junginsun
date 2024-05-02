/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : InvoiceIssueDBDAOVIEIssueTargetBLNoListRSQL.java
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

public class InvoiceIssueDBDAOVIEIssueTargetBLNoListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Invoice Main, Invoice Charge 테이블에서 INV TYPE  별 charge 조건으로 Select
	  * </pre>
	  */
	public InvoiceIssueDBDAOVIEIssueTargetBLNoListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("to_dt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("ar_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("port_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("from_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.NUMERIC + ",N";
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
		params.put("dt_opt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cust_cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.invoiceissue.integration").append("\n"); 
		query.append("FileName : InvoiceIssueDBDAOVIEIssueTargetBLNoListRSQL").append("\n"); 
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
		query.append("SELECT AA.BL_SRC_NO BL_NO," ).append("\n"); 
		query.append("       AA.LOCL_CURR_CD," ).append("\n"); 
		query.append("       AA.IO_BND_CD," ).append("\n"); 
		query.append("       SUM(AA.INV_TTL_LOCL_AMT) INV_TTL_LOCL_AMT" ).append("\n"); 
		query.append("  FROM INV_AR_MN AA," ).append("\n"); 
		query.append("      (SELECT A.BL_SRC_NO," ).append("\n"); 
		query.append("              B.CURR_CD," ).append("\n"); 
		query.append("              B.CHG_CD," ).append("\n"); 
		query.append("              SUBSTR(MAX(DECODE(A.REV_TP_CD,'M','A','B')||A.AR_IF_NO),2,11) AR_IF_NO," ).append("\n"); 
		query.append("              SUM(B.CHG_AMT) CHG_AMT" ).append("\n"); 
		query.append("         FROM (SELECT A.*," ).append("\n"); 
		query.append("                      ROWNUM" ).append("\n"); 
		query.append("                 FROM INV_AR_MN A " ).append("\n"); 
		query.append("                WHERE 1=1" ).append("\n"); 
		query.append("                  AND A.AR_OFC_CD = @[ar_ofc_cd]" ).append("\n"); 
		query.append("#if (${io_bnd_cd} != '')" ).append("\n"); 
		query.append("		          AND A.IO_BND_CD = @[io_bnd_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("                  AND A.BL_INV_CFM_DT IS NOT NULL" ).append("\n"); 
		query.append("#if (${cust_cnt_cd} != '')" ).append("\n"); 
		query.append("                  AND EXISTS (SELECT 'X'" ).append("\n"); 
		query.append("                                FROM INV_AR_MN" ).append("\n"); 
		query.append("                               WHERE DECODE(@[dt_opt], 'G', BL_INV_CFM_DT, 'S', SAIL_ARR_DT) BETWEEN @[from_dt] AND @[to_dt]" ).append("\n"); 
		query.append("                                 AND A.BL_SRC_NO = BL_SRC_NO" ).append("\n"); 
		query.append("                                 AND A.AR_OFC_CD = AR_OFC_CD)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("                                 AND NVL(A.INV_DELT_DIV_CD, 'N') <> 'Y'" ).append("\n"); 
		query.append("#if (${vvd_cd} != '')" ).append("\n"); 
		query.append("                                 AND A.VSL_CD = SUBSTR(@[vvd_cd],1,4)" ).append("\n"); 
		query.append(" 		                         AND A.SKD_VOY_NO = SUBSTR(@[vvd_cd],5,4)" ).append("\n"); 
		query.append("		                         AND A.SKD_DIR_CD = SUBSTR(@[vvd_cd],9,1)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${svc_scp_cd} != '')" ).append("\n"); 
		query.append("		                         AND A.SVC_SCP_CD = @[svc_scp_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${port_cd} != '')" ).append("\n"); 
		query.append("		                         AND DECODE(A.IO_BND_CD,'I',A.POL_CD, A.POD_CD ) = @[port_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${cust_cnt_cd} != '')" ).append("\n"); 
		query.append("                                 AND A.ACT_CUST_CNT_CD = @[cust_cnt_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${cust_seq} != '')" ).append("\n"); 
		query.append("                                 AND A.ACT_CUST_SEQ = TO_NUMBER(@[cust_seq])" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${bl_nos} != '')" ).append("\n"); 
		query.append("		                         AND A.BL_SRC_NO IN (${bl_nos})" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("/*" ).append("\n"); 
		query.append("                                 AND NOT EXISTS (SELECT 'X'" ).append("\n"); 
		query.append("                                                   FROM MDM_ORGANIZATION" ).append("\n"); 
		query.append("                                                  WHERE MDM_ORGANIZATION.REP_CUST_CNT_CD = A.ACT_CUST_CNT_CD" ).append("\n"); 
		query.append("                                                    AND MDM_ORGANIZATION.REP_CUST_SEQ = A.ACT_CUST_SEQ ) " ).append("\n"); 
		query.append("*/" ).append("\n"); 
		query.append("					) A," ).append("\n"); 
		query.append("                      INV_AR_CHG B" ).append("\n"); 
		query.append("                WHERE A.AR_IF_NO = B.AR_IF_NO" ).append("\n"); 
		query.append("                  AND B.INV_ISS_FLG ='N'" ).append("\n"); 
		query.append("#if (${inv_type} == 'FRT')" ).append("\n"); 
		query.append("                  AND A.REV_TP_CD <> 'M'" ).append("\n"); 
		query.append("                  AND (   (     (B.CHG_CD NOT IN ('DHF','OBS','VDT') OR NVL(B.CURR_CD, ' ') <> 'VND') AND" ).append("\n"); 
		query.append("                                 B.CHG_CD NOT IN ('OTH','DTH', 'DDC','VTT','THC','ORC','DTC','REF','VRT','SLF','VST', 'CLN','VCT','VET','VFT', 'TVA')" ).append("\n"); 
		query.append("                          )" ).append("\n"); 
		query.append("                       OR (     (B.CHG_CD = 'OTH' AND A.IO_BND_CD = 'I') OR" ).append("\n"); 
		query.append("                                (B.CHG_CD = 'DTH' AND A.IO_BND_CD = 'O') OR" ).append("\n"); 
		query.append("                                (B.CHG_CD = 'DDC' AND A.IO_BND_CD = 'O')" ).append("\n"); 
		query.append("                          )							" ).append("\n"); 
		query.append("                      )" ).append("\n"); 
		query.append("                  AND NOT EXISTS(SELECT 1 FROM DUAL WHERE B.CHG_CD = 'DDF'" ).append("\n"); 
		query.append("                                                      AND A.IO_BND_CD = 'I'" ).append("\n"); 
		query.append("                                                      AND B.CURR_CD = 'VND')" ).append("\n"); 
		query.append("				  AND NOT EXISTS(SELECT 1 FROM DUAL WHERE B.CHG_CD = 'EIS' AND A.IO_BND_CD = 'I' )" ).append("\n"); 
		query.append("                  AND NOT EXISTS(SELECT 1 FROM DUAL WHERE B.CHG_CD = 'BCC' )" ).append("\n"); 
		query.append("                  AND NOT EXISTS(SELECT 1 FROM DUAL WHERE B.CHG_CD IN ('PCS','VPT'))" ).append("\n"); 
		query.append("                  AND NOT EXISTS(SELECT 1 FROM DUAL WHERE B.CHG_CD = 'MCF' AND B.CURR_CD IN ('VND', 'USD'))" ).append("\n"); 
		query.append("                  AND NOT EXISTS(SELECT 1 FROM DUAL WHERE B.CHG_CD = 'CFC' AND B.CURR_CD IN ('VND', 'USD'))" ).append("\n"); 
		query.append("                  AND NOT EXISTS(SELECT 1 FROM DUAL WHERE B.CHG_CD = 'LBP' AND A.IO_BND_CD = 'O' AND B.CURR_CD = 'VND')" ).append("\n"); 
		query.append("                  AND NOT EXISTS(SELECT 1 FROM DUAL WHERE B.CHG_CD = 'BLR' AND A.IO_BND_CD = 'O' AND B.CURR_CD = 'VND')" ).append("\n"); 
		query.append("                  AND NOT EXISTS(SELECT 1 FROM DUAL WHERE B.CHG_CD = 'TAC' AND B.CURR_CD = 'VND')" ).append("\n"); 
		query.append("#elseif (${inv_type} == 'THC')" ).append("\n"); 
		query.append("                  AND A.REV_TP_CD <> 'M'" ).append("\n"); 
		query.append("                  AND ((B.CHG_CD = 'OTH' AND A.IO_BND_CD = 'O') OR" ).append("\n"); 
		query.append("                      (B.CHG_CD = 'DTH' AND A.IO_BND_CD = 'I') OR" ).append("\n"); 
		query.append("                      (B.CHG_CD = 'DDC' AND A.IO_BND_CD = 'I') OR " ).append("\n"); 
		query.append("                      (B.CHG_CD ='VTT') OR" ).append("\n"); 
		query.append("                      (B.CHG_CD ='THC') OR" ).append("\n"); 
		query.append("                      (B.CHG_CD ='ORC'))" ).append("\n"); 
		query.append("#elseif (${inv_type} == 'DHF')" ).append("\n"); 
		query.append("                  AND (B.CHG_CD IN ('OBS','DHF','VDT') OR" ).append("\n"); 
		query.append("  		              (B.CHG_CD = 'DDF' AND A.IO_BND_CD ='I'))" ).append("\n"); 
		query.append("                  AND B.CURR_CD ='VND'" ).append("\n"); 
		query.append("#elseif (${inv_type} == 'DMR')" ).append("\n"); 
		query.append("                  AND A.REV_TP_CD = 'M'" ).append("\n"); 
		query.append("                  AND B.CHG_CD IN ('DMR','DTC','TVA','IVA')" ).append("\n"); 
		query.append("                  AND B.AR_IF_NO IN (SELECT AR_IF_NO FROM INV_AR_CHG  WHERE AR_IF_NO = B.AR_IF_NO AND CHG_CD IN ('DMR','DTC'))" ).append("\n"); 
		query.append("#elseif (${inv_type} == 'MNR')" ).append("\n"); 
		query.append("                  AND A.REV_TP_CD = 'M'" ).append("\n"); 
		query.append("                  AND B.CHG_CD IN ('RPC','TVA')" ).append("\n"); 
		query.append("				  AND B.AR_IF_NO IN (SELECT AR_IF_NO FROM INV_AR_CHG  WHERE AR_IF_NO = B.AR_IF_NO AND CHG_CD = 'RPC')" ).append("\n"); 
		query.append("#elseif (${inv_type} == 'MRI')" ).append("\n"); 
		query.append("                  AND A.REV_TP_CD = 'M'" ).append("\n"); 
		query.append("                  AND ((B.CHG_CD IN ('DHF','OBS','RPC') AND " ).append("\n"); 
		query.append("                      NVL(B.CURR_CD, ' ') <> 'VND') OR" ).append("\n"); 
		query.append("                      (B.CHG_CD  NOT IN ('OTH','DTH','DDC','DHF','OBS'," ).append("\n"); 
		query.append("                                         'DMR', 'DTC', 'RPC','SLF','CLN','VDT','VTT','VST','VCT','VFT','PCS','VPT')))" ).append("\n"); 
		query.append("#elseif (${inv_type} == 'SLF')" ).append("\n"); 
		query.append("                  AND A.REV_TP_CD <> 'M'" ).append("\n"); 
		query.append("                  AND B.CHG_CD IN ('SLF','VST')" ).append("\n"); 
		query.append("#elseif (${inv_type} == 'CLN')" ).append("\n"); 
		query.append("                  AND A.REV_TP_CD <> 'M'" ).append("\n"); 
		query.append("                  AND B.CHG_CD IN ('CLN','VCT')" ).append("\n"); 
		query.append("#elseif (${inv_type} == 'REF')" ).append("\n"); 
		query.append("-- 2010-07-19 TYPE REF 추가	" ).append("\n"); 
		query.append("-- 2111-11-22 REF charge가 MRI로 발생되기 때문에 REVENUE TYPE 체크가 의미 없어서 삭제하기로 함" ).append("\n"); 
		query.append("                  AND B.CHG_CD IN ('REF','VRT')" ).append("\n"); 
		query.append("				  AND B.CURR_CD = 'USD'" ).append("\n"); 
		query.append("#elseif (${inv_type} == 'ETC')									" ).append("\n"); 
		query.append("				  AND (  (B.CHG_CD IN ('EIS','VET') AND A.IO_BND_CD = 'I')" ).append("\n"); 
		query.append("            		  OR (B.CHG_CD IN ('TVA') AND A.IO_BND_CD = 'O' AND B.CURR_CD = 'USD')" ).append("\n"); 
		query.append("            		  OR (B.CHG_CD IN ('BCC','PCS','VPT'))" ).append("\n"); 
		query.append("            		  OR (B.CHG_CD = 'MCF' AND B.CURR_CD IN ('VND','USD'))" ).append("\n"); 
		query.append("	      			  OR (B.CHG_CD IN ('LBP','+') AND A.IO_BND_CD = 'O' AND B.CURR_CD = 'VND')" ).append("\n"); 
		query.append("	      			  OR (B.CHG_CD IN ('TAC','TVA') AND B.CURR_CD = 'VND')" ).append("\n"); 
		query.append("	      			  OR (B.CHG_CD IN ('CFC','VFT') AND B.CURR_CD IN ('VND','USD'))" ).append("\n"); 
		query.append("            		  OR (B.CHG_CD = 'BLR' AND  A.IO_BND_CD = 'O' AND B.CURR_CD = 'VND')" ).append("\n"); 
		query.append("	    			)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("            GROUP BY A.BL_SRC_NO, B.CURR_CD, B.CHG_CD ) BB" ).append("\n"); 
		query.append(" WHERE AA.AR_IF_NO = BB.AR_IF_NO" ).append("\n"); 
		query.append("   AND BB.CHG_AMT <> 0" ).append("\n"); 
		query.append(" GROUP BY AA.BL_SRC_NO, AA.LOCL_CURR_CD, AA.IO_BND_CD" ).append("\n"); 
		query.append("HAVING SUM(AA.INV_TTL_LOCL_AMT) <> 0" ).append("\n"); 

	}
}