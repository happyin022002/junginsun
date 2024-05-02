/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : BDRCorrectionDBDAOSearchCaCustRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.02.18
*@LastModifier : 
*@LastVersion : 1.0
* 2011.02.18 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingcorrection.bdrcorrection.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BDRCorrectionDBDAOSearchCaCustRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * BDRCorrectionDBDAOSearchCaCustRSQL
	  * </pre>
	  */
	public BDRCorrectionDBDAOSearchCaCustRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ca_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.bookingcorrection.bdrcorrection.integration").append("\n"); 
		query.append("FileName : BDRCorrectionDBDAOSearchCaCustRSQL").append("\n"); 
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
		query.append("with CA as" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("select nvl(old.BKG_CUST_TP_CD,' ') ocust_tp_cd, nvl(old.cust_cd,'0') ocust_cd, nvl(old.cust_nm_addr,' ') ocust_nm, nvl(old.addr_cd,'///') oaddr_cd, nvl(old.fax_eml,'/') ofax_eml," ).append("\n"); 
		query.append("       nvl(new.BKG_CUST_TP_CD,' ') ncust_tp_cd, nvl(new.cust_cd,'0') ncust_cd, nvl(new.cust_nm_addr,' ') ncust_nm, nvl(new.addr_cd,'///') naddr_cd, nvl(new.fax_eml,'/') nfax_eml" ).append("\n"); 
		query.append("from " ).append("\n"); 
		query.append("( select BKG_CUST_TP_CD, trim(CUST_CNT_CD||nvl(CUST_SEQ,0)) cust_cd, CUST_NM||CUST_ADDR cust_nm_addr," ).append("\n"); 
		query.append("         CUST_CTY_NM||'/'||CUST_STE_CD||'/'||CUST_ZIP_ID||'/'||CSTMS_DECL_CNT_CD addr_cd," ).append("\n"); 
		query.append("         CUST_FAX_NO||'/'||CUST_EML fax_eml " ).append("\n"); 
		query.append("from bkg_cust_his" ).append("\n"); 
		query.append("where bkg_no = @[bkg_no]" ).append("\n"); 
		query.append("  and corr_no = @[ca_no]" ).append("\n"); 
		query.append("  and BKG_CUST_TP_CD in ( SELECT ATTR_CTNT1 FROM BKG_HRD_CDG_CTNT WHERE 'BKG_CUST_TTL_ORD' = HRD_CDG_ID ) ) new FULL OUTER JOIN         " ).append("\n"); 
		query.append("( select BKG_CUST_TP_CD, trim(CUST_CNT_CD||nvl(CUST_SEQ,0)) cust_cd, CUST_NM||CUST_ADDR cust_nm_addr," ).append("\n"); 
		query.append("         CUST_CTY_NM||'/'||CUST_STE_CD||'/'||CUST_ZIP_ID||'/'||CSTMS_DECL_CNT_CD addr_cd," ).append("\n"); 
		query.append("         CUST_FAX_NO||'/'||CUST_EML fax_eml " ).append("\n"); 
		query.append("from bkg_cust_his BCH" ).append("\n"); 
		query.append("where bkg_no = @[bkg_no]  " ).append("\n"); 
		query.append("  and BKG_CUST_TP_CD in ( SELECT ATTR_CTNT1 FROM BKG_HRD_CDG_CTNT WHERE 'BKG_CUST_TTL_ORD' = HRD_CDG_ID )" ).append("\n"); 
		query.append("  and corr_no  = ( SELECT CORR_NO FROM BKG_CORRECTION " ).append("\n"); 
		query.append("                    WHERE BKG_NO = BCH.BKG_NO" ).append("\n"); 
		query.append("                      AND CORR_DT = ( SELECT MAX(CORR_DT) FROM BKG_CORRECTION" ).append("\n"); 
		query.append("                                       WHERE BKG_NO = BCH.BKG_NO" ).append("\n"); 
		query.append("                                         AND CORR_DT < ( select CORR_DT from bkg_correction " ).append("\n"); 
		query.append("                                                        where BKG_NO = BCH.BKG_NO " ).append("\n"); 
		query.append("                                                        AND  corr_no = @[ca_no] )) ) ) old" ).append("\n"); 
		query.append("on old.BKG_CUST_TP_CD = new.BKG_CUST_TP_CD" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("SELECT item_hdr, his_cate_nm, pre_ctnt, crnt_ctnt" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("    select MAX(item_hdr) item_hdr, MAX(his_cate_nm) his_cate_nm, MAX(pre_ctnt) pre_ctnt, MAX(crnt_ctnt) crnt_ctnt, SEQ SEQ" ).append("\n"); 
		query.append("      from (" ).append("\n"); 
		query.append("        SELECT '' AS ITEM_HDR," ).append("\n"); 
		query.append("               HCD.ATTR_CTNT3 AS HIS_CATE_NM," ).append("\n"); 
		query.append("               OCUST_CD AS PRE_CTNT," ).append("\n"); 
		query.append("               NCUST_CD AS CRNT_CTNT," ).append("\n"); 
		query.append("               TO_NUMBER(HCD.ATTR_CTNT2) AS SEQ" ).append("\n"); 
		query.append("          FROM CA,BKG_HRD_CDG_CTNT HCD" ).append("\n"); 
		query.append("         WHERE OCUST_CD <> NCUST_CD" ).append("\n"); 
		query.append("           AND 'BKG_CUST_TTL_ORD' = HCD.HRD_CDG_ID" ).append("\n"); 
		query.append("           AND HCD.ATTR_CTNT1 IN (CA.OCUST_TP_CD,CA.NCUST_TP_CD)" ).append("\n"); 
		query.append("         UNION ALL" ).append("\n"); 
		query.append("        SELECT ''," ).append("\n"); 
		query.append("               HCD.ATTR_CTNT5," ).append("\n"); 
		query.append("               OCUST_NM," ).append("\n"); 
		query.append("               NCUST_NM," ).append("\n"); 
		query.append("               TO_NUMBER(HCD.ATTR_CTNT4)" ).append("\n"); 
		query.append("          FROM CA,BKG_HRD_CDG_CTNT HCD" ).append("\n"); 
		query.append("         WHERE OCUST_NM <> NCUST_NM" ).append("\n"); 
		query.append("           AND 'BKG_CUST_TTL_ORD' = HCD.HRD_CDG_ID" ).append("\n"); 
		query.append("           AND HCD.ATTR_CTNT1 IN (CA.OCUST_TP_CD,CA.NCUST_TP_CD)" ).append("\n"); 
		query.append("         UNION ALL" ).append("\n"); 
		query.append("        SELECT ''," ).append("\n"); 
		query.append("               HCD.ATTR_CTNT7," ).append("\n"); 
		query.append("               OADDR_CD," ).append("\n"); 
		query.append("               NADDR_CD," ).append("\n"); 
		query.append("               TO_NUMBER(HCD.ATTR_CTNT6)" ).append("\n"); 
		query.append("          FROM CA,BKG_HRD_CDG_CTNT HCD" ).append("\n"); 
		query.append("         WHERE OADDR_CD <> NADDR_CD" ).append("\n"); 
		query.append("           AND 'BKG_CUST_TTL_ORD' = HCD.HRD_CDG_ID" ).append("\n"); 
		query.append("           AND HCD.ATTR_CTNT1 IN (CA.OCUST_TP_CD,CA.NCUST_TP_CD)" ).append("\n"); 
		query.append("         UNION ALL" ).append("\n"); 
		query.append("        SELECT ''," ).append("\n"); 
		query.append("               HCD.ATTR_CTNT9," ).append("\n"); 
		query.append("               OFAX_EML," ).append("\n"); 
		query.append("               NFAX_EML," ).append("\n"); 
		query.append("               TO_NUMBER(HCD.ATTR_CTNT8)" ).append("\n"); 
		query.append("          FROM CA,BKG_HRD_CDG_CTNT HCD" ).append("\n"); 
		query.append("         WHERE OFAX_EML <> NFAX_EML" ).append("\n"); 
		query.append("           AND 'BKG_CUST_TTL_ORD' = HCD.HRD_CDG_ID" ).append("\n"); 
		query.append("           AND HCD.ATTR_CTNT1 IN (CA.OCUST_TP_CD,CA.NCUST_TP_CD)" ).append("\n"); 
		query.append("        ) ca, bkg_correction cor" ).append("\n"); 
		query.append("        where cor.bkg_no = @[bkg_no]" ).append("\n"); 
		query.append("          and cor.corr_no = @[ca_no]" ).append("\n"); 
		query.append("        GROUP BY seq" ).append("\n"); 
		query.append("    )" ).append("\n"); 
		query.append("    WHERE pre_ctnt <> crnt_ctnt" ).append("\n"); 
		query.append("    ORDER BY SEQ" ).append("\n"); 

	}
}