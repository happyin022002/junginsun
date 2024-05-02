/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : BDRCorrectionDBDAOSearchCaCustRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.12.09
*@LastModifier : 김영철
*@LastVersion : 1.0
* 2009.12.09 김영철
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingcorrection.bdrcorrection.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Kim YC
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
		query.append("Path : com.hanjin.apps.alps.esm.bkg.bookingcorrection.bdrcorrection.integration").append("\n"); 
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
		query.append("nvl(new.BKG_CUST_TP_CD,' ') ncust_tp_cd, nvl(new.cust_cd,'0') ncust_cd, nvl(new.cust_nm_addr,' ') ncust_nm, nvl(new.addr_cd,'///') naddr_cd, nvl(new.fax_eml,'/') nfax_eml" ).append("\n"); 
		query.append("from" ).append("\n"); 
		query.append("( select BKG_CUST_TP_CD, trim(CUST_CNT_CD||nvl(CUST_SEQ,0)) cust_cd, CUST_NM||CUST_ADDR cust_nm_addr," ).append("\n"); 
		query.append("CUST_CTY_NM||'/'||CUST_STE_CD||'/'||CUST_ZIP_ID||'/'||CSTMS_DECL_CNT_CD addr_cd," ).append("\n"); 
		query.append("CUST_FAX_NO||'/'||CUST_EML fax_eml" ).append("\n"); 
		query.append("from bkg_cust_his" ).append("\n"); 
		query.append("where bkg_no = @[bkg_no]" ).append("\n"); 
		query.append("and corr_no = @[ca_no]" ).append("\n"); 
		query.append("and BKG_CUST_TP_CD in ( 'S','C','F','N','A','E' ) ) new FULL OUTER JOIN" ).append("\n"); 
		query.append("( select BKG_CUST_TP_CD, trim(CUST_CNT_CD||nvl(CUST_SEQ,0)) cust_cd, CUST_NM||CUST_ADDR cust_nm_addr," ).append("\n"); 
		query.append("CUST_CTY_NM||'/'||CUST_STE_CD||'/'||CUST_ZIP_ID||'/'||CSTMS_DECL_CNT_CD addr_cd," ).append("\n"); 
		query.append("CUST_FAX_NO||'/'||CUST_EML fax_eml" ).append("\n"); 
		query.append("from bkg_cust_his BCH" ).append("\n"); 
		query.append("where bkg_no = @[bkg_no]" ).append("\n"); 
		query.append("and BKG_CUST_TP_CD in ( 'S','C','F','N','A','E' )" ).append("\n"); 
		query.append("and corr_no  = ( SELECT CORR_NO FROM BKG_CORRECTION" ).append("\n"); 
		query.append("WHERE BKG_NO = BCH.BKG_NO" ).append("\n"); 
		query.append("AND CORR_DT = ( SELECT MAX(CORR_DT) FROM BKG_CORRECTION" ).append("\n"); 
		query.append("WHERE BKG_NO = BCH.BKG_NO" ).append("\n"); 
		query.append("AND CORR_DT < ( select CORR_DT from bkg_correction" ).append("\n"); 
		query.append("where BKG_NO = BCH.BKG_NO" ).append("\n"); 
		query.append("AND  corr_no = @[ca_no] )) ) ) old" ).append("\n"); 
		query.append("on old.BKG_CUST_TP_CD = new.BKG_CUST_TP_CD" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("SELECT item_hdr, his_cate_nm, pre_ctnt, crnt_ctnt" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("select MAX(item_hdr) item_hdr, MAX(his_cate_nm) his_cate_nm, MAX(pre_ctnt) pre_ctnt, MAX(crnt_ctnt) crnt_ctnt, SEQ SEQ" ).append("\n"); 
		query.append("from (" ).append("\n"); 
		query.append("select '' item_hdr," ).append("\n"); 
		query.append("case" ).append("\n"); 
		query.append("when ocust_tp_cd = 'S' or ncust_tp_cd = 'S' Then 'Shipper Code'" ).append("\n"); 
		query.append("when ocust_tp_cd = 'C' or ncust_tp_cd = 'C' Then 'Consignee Code'" ).append("\n"); 
		query.append("when ocust_tp_cd = 'N' or ncust_tp_cd = 'N' Then 'Notify Code'" ).append("\n"); 
		query.append("when ocust_tp_cd = 'F' or ncust_tp_cd = 'F' Then 'F/Forward Code'" ).append("\n"); 
		query.append("when ocust_tp_cd = 'A' or ncust_tp_cd = 'A' Then 'A/Notify Code'" ).append("\n"); 
		query.append("when ocust_tp_cd = 'E' or ncust_tp_cd = 'E' Then 'Export Ref Code'" ).append("\n"); 
		query.append("END his_cate_nm," ).append("\n"); 
		query.append("ocust_cd pre_ctnt," ).append("\n"); 
		query.append("ncust_cd crnt_ctnt," ).append("\n"); 
		query.append("case" ).append("\n"); 
		query.append("when ocust_tp_cd = 'S' or ncust_tp_cd = 'S' Then 10" ).append("\n"); 
		query.append("when ocust_tp_cd = 'C' or ncust_tp_cd = 'C' Then 30" ).append("\n"); 
		query.append("when ocust_tp_cd = 'F' or ncust_tp_cd = 'F' Then 50" ).append("\n"); 
		query.append("when ocust_tp_cd = 'N' or ncust_tp_cd = 'N' Then 70" ).append("\n"); 
		query.append("when ocust_tp_cd = 'A' or ncust_tp_cd = 'A' Then 90" ).append("\n"); 
		query.append("when ocust_tp_cd = 'E' or ncust_tp_cd = 'E' Then 110" ).append("\n"); 
		query.append("END seq" ).append("\n"); 
		query.append("from ca" ).append("\n"); 
		query.append("where ocust_cd <> ncust_cd" ).append("\n"); 
		query.append("union all" ).append("\n"); 
		query.append("select '' item_hdr," ).append("\n"); 
		query.append("case" ).append("\n"); 
		query.append("when ocust_tp_cd = 'S' or ncust_tp_cd = 'S' Then 'Shipper'" ).append("\n"); 
		query.append("when ocust_tp_cd = 'C' or ncust_tp_cd = 'C' Then 'Consignee'" ).append("\n"); 
		query.append("when ocust_tp_cd = 'N' or ncust_tp_cd = 'N' Then 'Notify'" ).append("\n"); 
		query.append("when ocust_tp_cd = 'F' or ncust_tp_cd = 'F' Then 'F/Forward'" ).append("\n"); 
		query.append("when ocust_tp_cd = 'A' or ncust_tp_cd = 'A' Then 'A/Notify'" ).append("\n"); 
		query.append("when ocust_tp_cd = 'E' or ncust_tp_cd = 'E' Then 'Export Ref'" ).append("\n"); 
		query.append("END his_cate_nm," ).append("\n"); 
		query.append("ocust_nm pre_ctnt," ).append("\n"); 
		query.append("ncust_nm crnt_ctnt," ).append("\n"); 
		query.append("case" ).append("\n"); 
		query.append("when ocust_tp_cd = 'S' or ncust_tp_cd = 'S' Then 20" ).append("\n"); 
		query.append("when ocust_tp_cd = 'C' or ncust_tp_cd = 'C' Then 40" ).append("\n"); 
		query.append("when ocust_tp_cd = 'F' or ncust_tp_cd = 'F' Then 60" ).append("\n"); 
		query.append("when ocust_tp_cd = 'N' or ncust_tp_cd = 'N' Then 80" ).append("\n"); 
		query.append("when ocust_tp_cd = 'A' or ncust_tp_cd = 'A' Then 100" ).append("\n"); 
		query.append("when ocust_tp_cd = 'E' or ncust_tp_cd = 'E' Then 120" ).append("\n"); 
		query.append("END seq" ).append("\n"); 
		query.append("from ca" ).append("\n"); 
		query.append("where ocust_nm <> ncust_nm" ).append("\n"); 
		query.append("union all" ).append("\n"); 
		query.append("select '' item_hdr," ).append("\n"); 
		query.append("case" ).append("\n"); 
		query.append("when ocust_tp_cd = 'S' or ncust_tp_cd = 'S' Then 'Shipper Addr Code'" ).append("\n"); 
		query.append("when ocust_tp_cd = 'C' or ncust_tp_cd = 'C' Then 'Consignee Addr Code'" ).append("\n"); 
		query.append("when ocust_tp_cd = 'N' or ncust_tp_cd = 'N' Then 'Notify Addr Code'" ).append("\n"); 
		query.append("when ocust_tp_cd = 'F' or ncust_tp_cd = 'F' Then 'F/Forward Addr Code'" ).append("\n"); 
		query.append("when ocust_tp_cd = 'A' or ncust_tp_cd = 'A' Then 'A/Notify Addr Code'" ).append("\n"); 
		query.append("when ocust_tp_cd = 'E' or ncust_tp_cd = 'E' Then 'Export Ref Addr Code'" ).append("\n"); 
		query.append("END his_cate_nm," ).append("\n"); 
		query.append("oaddr_cd pre_ctnt," ).append("\n"); 
		query.append("naddr_cd crnt_ctnt," ).append("\n"); 
		query.append("case" ).append("\n"); 
		query.append("when ocust_tp_cd = 'S' or ncust_tp_cd = 'S' Then 21" ).append("\n"); 
		query.append("when ocust_tp_cd = 'C' or ncust_tp_cd = 'C' Then 41" ).append("\n"); 
		query.append("when ocust_tp_cd = 'F' or ncust_tp_cd = 'F' Then 61" ).append("\n"); 
		query.append("when ocust_tp_cd = 'N' or ncust_tp_cd = 'N' Then 81" ).append("\n"); 
		query.append("when ocust_tp_cd = 'A' or ncust_tp_cd = 'A' Then 101" ).append("\n"); 
		query.append("when ocust_tp_cd = 'E' or ncust_tp_cd = 'E' Then 121" ).append("\n"); 
		query.append("END seq" ).append("\n"); 
		query.append("from ca" ).append("\n"); 
		query.append("where oaddr_cd <> naddr_cd" ).append("\n"); 
		query.append("union all" ).append("\n"); 
		query.append("select '' item_hdr," ).append("\n"); 
		query.append("case" ).append("\n"); 
		query.append("when ocust_tp_cd = 'S' or ncust_tp_cd = 'S' Then 'Shipper Fax Email'" ).append("\n"); 
		query.append("when ocust_tp_cd = 'C' or ncust_tp_cd = 'C' Then 'Consignee Fax Email'" ).append("\n"); 
		query.append("when ocust_tp_cd = 'N' or ncust_tp_cd = 'N' Then 'Notify Fax Email'" ).append("\n"); 
		query.append("when ocust_tp_cd = 'F' or ncust_tp_cd = 'F' Then 'F/Forward Fax Email'" ).append("\n"); 
		query.append("when ocust_tp_cd = 'A' or ncust_tp_cd = 'A' Then 'A/Notify Fax Email'" ).append("\n"); 
		query.append("when ocust_tp_cd = 'E' or ncust_tp_cd = 'E' Then 'Export Ref Fax Email'" ).append("\n"); 
		query.append("END his_cate_nm," ).append("\n"); 
		query.append("ofax_eml pre_ctnt," ).append("\n"); 
		query.append("nfax_eml crnt_ctnt," ).append("\n"); 
		query.append("case" ).append("\n"); 
		query.append("when ocust_tp_cd = 'S' or ncust_tp_cd = 'S' Then 22" ).append("\n"); 
		query.append("when ocust_tp_cd = 'C' or ncust_tp_cd = 'C' Then 42" ).append("\n"); 
		query.append("when ocust_tp_cd = 'F' or ncust_tp_cd = 'F' Then 62" ).append("\n"); 
		query.append("when ocust_tp_cd = 'N' or ncust_tp_cd = 'N' Then 82" ).append("\n"); 
		query.append("when ocust_tp_cd = 'A' or ncust_tp_cd = 'A' Then 102" ).append("\n"); 
		query.append("when ocust_tp_cd = 'E' or ncust_tp_cd = 'E' Then 122" ).append("\n"); 
		query.append("END seq" ).append("\n"); 
		query.append("from ca" ).append("\n"); 
		query.append("where ofax_eml <> nfax_eml" ).append("\n"); 
		query.append(") ca, bkg_correction cor" ).append("\n"); 
		query.append("where cor.bkg_no = @[bkg_no]" ).append("\n"); 
		query.append("and cor.corr_no = @[ca_no]" ).append("\n"); 
		query.append("GROUP BY seq" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("WHERE pre_ctnt <> crnt_ctnt" ).append("\n"); 
		query.append("ORDER BY SEQ" ).append("\n"); 

	}
}