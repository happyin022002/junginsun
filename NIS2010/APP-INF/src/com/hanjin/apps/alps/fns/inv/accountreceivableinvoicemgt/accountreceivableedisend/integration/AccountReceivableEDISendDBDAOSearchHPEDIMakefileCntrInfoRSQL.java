/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : AccountReceivableEDISendDBDAOSearchHPEDIMakefileCntrInfoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.02.08
*@LastModifier : 최도순
*@LastVersion : 1.0
* 2011.02.08 최도순
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.accountreceivableedisend.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Choi Do Soon
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AccountReceivableEDISendDBDAOSearchHPEDIMakefileCntrInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 
	  * </pre>
	  */
	public AccountReceivableEDISendDBDAOSearchHPEDIMakefileCntrInfoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.accountreceivableedisend.integration").append("\n"); 
		query.append("FileName : AccountReceivableEDISendDBDAOSearchHPEDIMakefileCntrInfoRSQL").append("\n"); 
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
		query.append("SELECT  CNTR.CNTR_NO" ).append("\n"); 
		query.append("       ,CNTR.CNTR_TPSZ_CD AS CNTR_TYPE" ).append("\n"); 
		query.append("       ,'' AS CNTR_LOAD" ).append("\n"); 
		query.append("       ,SEAL.CNTR_SEAL_NO AS CNTR_SEAL_NO" ).append("\n"); 
		query.append("       ,(select  /*+INDEX_desc( REF XPKBKG_REF_DTL ) */" ).append("\n"); 
		query.append("                REF.de_no" ).append("\n"); 
		query.append("            from BKG_REF_DTL REF" ).append("\n"); 
		query.append("            where  REF.BKG_NO = CNTR.BKG_NO" ).append("\n"); 
		query.append("            and  REF.cust_ref_tp_cd ='HP' " ).append("\n"); 
		query.append("            and rownum = 1 )  as CNTR_SHIP_ID" ).append("\n"); 
		query.append("       ,(select SUBSTR(re.cust_ref_no_ctnt,1,50)" ).append("\n"); 
		query.append("            from BKG_REFERENCE RE" ).append("\n"); 
		query.append("            where  RE.BKG_NO = CNTR.BKG_NO" ).append("\n"); 
		query.append("            AND  RE.CNTR_NO = CNTR.cntr_NO" ).append("\n"); 
		query.append("            and  RE.BKG_REF_TP_CD = 'CTPO' " ).append("\n"); 
		query.append("            and rownum = 1 )  as CN_REF_PO" ).append("\n"); 
		query.append("       ,(select  /*+INDEX_desc( REF XPKBKG_REF_DTL ) */" ).append("\n"); 
		query.append("                REF.PRT_NO" ).append("\n"); 
		query.append("            from BKG_REF_DTL REF" ).append("\n"); 
		query.append("            where  REF.BKG_NO = CNTR.BKG_NO" ).append("\n"); 
		query.append("            and  REF.cust_ref_tp_cd ='HP' " ).append("\n"); 
		query.append("            and rownum = 1 )  as CN_REF_PT" ).append("\n"); 
		query.append("       ,(select  /*+INDEX_desc( REF XPKBKG_REF_DTL ) */" ).append("\n"); 
		query.append("                REF.de_no" ).append("\n"); 
		query.append("            from BKG_REF_DTL REF" ).append("\n"); 
		query.append("            where  REF.BKG_NO = CNTR.BKG_NO" ).append("\n"); 
		query.append("            and  REF.cust_ref_tp_cd ='HP' " ).append("\n"); 
		query.append("            and rownum = 1 )   as CN_REF_SI" ).append("\n"); 
		query.append("           ,cntr.PCK_QTY AS CM_PKG" ).append("\n"); 
		query.append("        ,cntr.PCK_TP_CD AS  CM_PKG_CD" ).append("\n"); 
		query.append("        ,cntr.cntr_wgt  AS CM_WGT" ).append("\n"); 
		query.append("        ,cntr.WGT_UT_CD AS CM_WGT_CD" ).append("\n"); 
		query.append("        ,cntr.MEAS_QTY AS CM_MEA" ).append("\n"); 
		query.append("        ,cntr.MEAS_UT_CD AS CM_MEA_CD" ).append("\n"); 
		query.append("        ,(SELECT CSTMS_DESC FROM BKG_BL_DOC WHERE BKG_NO = CNTR.BKG_NO ) AS CM_DESC" ).append("\n"); 
		query.append("FROM  BKG_CONTAINER CNTR" ).append("\n"); 
		query.append("     ,BKG_CNTR_SEAL_NO SEAL" ).append("\n"); 
		query.append("WHERE CNTR.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("AND CNTR.BKG_NO = SEAL.BKG_NO" ).append("\n"); 
		query.append("AND CNTR.CNTR_NO = SEAL.CNTR_NO" ).append("\n"); 
		query.append("AND SEAL.CNTR_SEAL_SEQ = 1" ).append("\n"); 

	}
}