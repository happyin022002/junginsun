/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : TESeBillingManageCommonDBDAOGetEdiInvoiceListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.06.22
*@LastModifier : 
*@LastVersion : 1.0
* 2012.06.22 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.tes.edi.ebilling.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TESeBillingManageCommonDBDAOGetEdiInvoiceListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * F/F에 처리된 모든 INVOICE 조회
	  * </pre>
	  */
	public TESeBillingManageCommonDBDAOGetEdiInvoiceListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("tml_inv_edi_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.tes.edi.ebilling.integration").append("\n"); 
		query.append("FileName : TESeBillingManageCommonDBDAOGetEdiInvoiceListRSQL").append("\n"); 
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
		query.append("SELECT" ).append("\n"); 
		query.append("H.TML_EDI_SO_OFC_CTY_CD" ).append("\n"); 
		query.append(", H.TML_EDI_SO_SEQ" ).append("\n"); 
		query.append(", H.TML_INV_TP_CD" ).append("\n"); 
		query.append(", H.TML_INV_STS_CD" ).append("\n"); 
		query.append(", H.TML_INV_RJCT_STS_CD" ).append("\n"); 
		query.append(", H.INV_OFC_CD" ).append("\n"); 
		query.append(", H.COST_OFC_CD" ).append("\n"); 
		query.append(", H.VNDR_SEQ" ).append("\n"); 
		query.append(", H.YD_CD" ).append("\n"); 
		query.append(", H.INV_NO" ).append("\n"); 
		query.append(", H.CURR_CD" ).append("\n"); 
		query.append(", H.RCV_DT" ).append("\n"); 
		query.append(", H.ISS_DT" ).append("\n"); 
		query.append(", H.TTL_INV_AMT" ).append("\n"); 
		query.append(", H.VAT_AMT" ).append("\n"); 
		query.append(", H.WHLD_TAX_AMT" ).append("\n"); 
		query.append(", H.ATCH_TP_CD" ).append("\n"); 
		query.append(", H.IO_IND_CD" ).append("\n"); 
		query.append(", H.TML_SO_OFC_CTY_CD" ).append("\n"); 
		query.append(", H.TML_SO_SEQ" ).append("\n"); 
		query.append(", H.DELT_FLG" ).append("\n"); 
		query.append(", H.IB_VVD_CD" ).append("\n"); 
		query.append(", H.OB_VVD_CD" ).append("\n"); 
		query.append(", H.INV_RJCT_RMK" ).append("\n"); 
		query.append(", H.STO_DYS_IND_CD" ).append("\n"); 
		query.append(", H.VLD_CHK_FLG" ).append("\n"); 
		query.append(", H.FM_PRD_DT" ).append("\n"); 
		query.append(", H.TO_PRD_DT" ).append("\n"); 
		query.append(", H.TML_INV_EDI_SEQ" ).append("\n"); 
		query.append(", H.FLT_FILE_MSG_ID" ).append("\n"); 
		query.append(", H.SNDR_ID" ).append("\n"); 
		query.append(", H.RCVR_ID" ).append("\n"); 
		query.append(", H.EDI_MSG" ).append("\n"); 
		query.append(", H.EDI_RCV_RULE_MN_SEQ" ).append("\n"); 
		query.append(", H.ATB_DT" ).append("\n"); 
		query.append(", H.LOCL_CRE_DT" ).append("\n"); 
		query.append(", H.LOCL_UPD_DT" ).append("\n"); 
		query.append(", H.CRE_USR_ID" ).append("\n"); 
		query.append(", H.CRE_DT" ).append("\n"); 
		query.append(", H.UPD_USR_ID" ).append("\n"); 
		query.append(", H.UPD_DT" ).append("\n"); 
		query.append("FROM TES_EDI_SO_HDR H" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND H.TML_INV_EDI_SEQ = @[tml_inv_edi_seq]" ).append("\n"); 
		query.append("AND H.TML_SO_OFC_CTY_CD IS NULL" ).append("\n"); 
		query.append("AND H.TML_SO_SEQ IS NULL" ).append("\n"); 
		query.append("AND NVL(H.DELT_FLG,'N') <> 'Y'" ).append("\n"); 

	}
}