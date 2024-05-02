/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : DODInvoiceMgtDBDAOSearchDODInvoiceListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.10.24
*@LastModifier : 
*@LastVersion : 1.0
* 2014.10.24 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.eas.dodinvoicemgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class DODInvoiceMgtDBDAOSearchDODInvoiceListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchDODInvoiceList
	  * </pre>
	  */
	public DODInvoiceMgtDBDAOSearchDODInvoiceListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("payer_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("to_cre_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ar_if_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fm_cre_dt",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.eas.dodinvoicemgt.integration").append("\n"); 
		query.append("FileName : DODInvoiceMgtDBDAOSearchDODInvoiceListRSQL").append("\n"); 
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
		query.append("SELECT DISTINCT" ).append("\n"); 
		query.append("     M.DOD_INV_NO" ).append("\n"); 
		query.append("    ,M.AR_IF_FLG" ).append("\n"); 
		query.append("    ,M.BL_NO" ).append("\n"); 
		query.append("    ,M.BKG_NO" ).append("\n"); 
		query.append("    ,M.INV_CURR_CD" ).append("\n"); 
		query.append("    ,M.TTL_INV_AMT" ).append("\n"); 
		query.append("	,DECODE(M.CNTC_PNT_FAX_NO, null, 'N', 'Y') AS FAX_NO_FLG" ).append("\n"); 
		query.append("    ,DECODE(M.CNTC_PNT_EML, null, 'N', 'Y') AS MAIL_ADDR_FLG    " ).append("\n"); 
		query.append(",TO_CHAR(M.CRE_DT, 'YYYY-MM-DD') AS CRE_DT" ).append("\n"); 
		query.append(",M.CRE_OFC_CD" ).append("\n"); 
		query.append(",(SELECT C.USR_NM " ).append("\n"); 
		query.append("  FROM COM_USER C" ).append("\n"); 
		query.append("  WHERE C.USR_ID = M.CRE_USR_ID) AS CRE_USR_NM" ).append("\n"); 
		query.append(",M.AR_IF_NO" ).append("\n"); 
		query.append(",TO_CHAR(M.AR_IF_DT, 'YYYY-MM-DD') AS AR_IF_DT" ).append("\n"); 
		query.append(",(SELECT C.USR_NM " ).append("\n"); 
		query.append("  FROM COM_USER C" ).append("\n"); 
		query.append("  WHERE C.USR_ID = M.AR_IF_USR_ID) AS AR_IF_USR_ID" ).append("\n"); 
		query.append(",DECODE(M.DOD_INV_STS_CD, 'I', 'ISSUED', 'X', 'CANCELLED', 'C', 'CREDIT NOTE') AS DOD_INV_STS_CD" ).append("\n"); 
		query.append(",(SELECT C.USR_NM " ).append("\n"); 
		query.append("  FROM COM_USER C" ).append("\n"); 
		query.append("  WHERE C.USR_ID = M.CXL_USR_ID) AS CXL_USR_ID" ).append("\n"); 
		query.append(",M.CNTC_PNT_NM" ).append("\n"); 
		query.append(",M.CNTC_PNT_PHN_NO" ).append("\n"); 
		query.append(",M.CNTC_PNT_FAX_NO" ).append("\n"); 
		query.append(",M.CNTC_PNT_EML" ).append("\n"); 
		query.append(",NVL(PA.PAYR_NM, MC.CUST_LOCL_LANG_NM) AS PAYR_NM" ).append("\n"); 
		query.append(",M.CN_REF_INV_NO" ).append("\n"); 
		query.append("FROM EAS_DOD_INV_MN M, EAS_DOD_INV_DTL D," ).append("\n"); 
		query.append("     EAS_PAYR_INFO PA," ).append("\n"); 
		query.append("     MDM_CUSTOMER MC" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND M.DOD_INV_NO = D.DOD_INV_NO" ).append("\n"); 
		query.append("AND M.CUST_CNT_CD = PA.CUST_CNT_CD" ).append("\n"); 
		query.append("AND M.CUST_SEQ = PA.CUST_SEQ" ).append("\n"); 
		query.append("AND M.CUST_CNT_CD = MC.CUST_CNT_CD" ).append("\n"); 
		query.append("AND M.CUST_SEQ = MC.CUST_SEQ" ).append("\n"); 
		query.append("#if(${f_tp_cd} == 'D' )" ).append("\n"); 
		query.append("AND M.CRE_DT BETWEEN TO_DATE(@[fm_cre_dt],'YYYY-MM-DD') AND TO_DATE(@[to_cre_dt],'YYYY-MM-DD')+0.99999" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("#if(${dod_inv_no} != '' && ${dod_inv_no} != 'null' )" ).append("\n"); 
		query.append("AND M.DOD_INV_NO IN (${dod_inv_no})" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${bl_no} != '' && ${bl_no} != 'null' )" ).append("\n"); 
		query.append("AND M.BL_NO IN (${bl_no})" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${cre_ofc_cd} != '' && ${cre_ofc_cd} != 'null' && ${cre_ofc_cd} != 'A' )" ).append("\n"); 
		query.append("AND M.CRE_OFC_CD = @[cre_ofc_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${dod_loc_cd} != '' && ${dod_loc_cd} != 'null' && ${dod_loc_cd} != 'A' )" ).append("\n"); 
		query.append("AND D.DOD_LOC_CD IN (${dod_loc_cd})" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${ar_if_flg} != 'A' )  " ).append("\n"); 
		query.append("AND M.AR_IF_FLG = @[ar_if_flg]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${chk_cancel} != 'C' )" ).append("\n"); 
		query.append("AND NVL(M.DOD_INV_STS_CD,'') = 'I'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${payer_cd} != '' && ${payer_cd} != 'null' )" ).append("\n"); 
		query.append("AND PA.CUST_CNT_CD||lpad(PA.CUST_SEQ,6,0) LIKE @[payer_cd] || '%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("ORDER BY CRE_DT, DOD_INV_NO" ).append("\n"); 

	}
}