/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : AccountReceivableReceiptDBDAOSearchReceiptForAPInterfaceRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.07.14
*@LastModifier : 
*@LastVersion : 1.0
* 2015.07.14 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.stm.sar.accountreceivablecollect.accountreceivablereceipt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AccountReceivableReceiptDBDAOSearchReceiptForAPInterfaceRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Search receipt info for AP interface
	  * </pre>
	  */
	public AccountReceivableReceiptDBDAOSearchReceiptForAPInterfaceRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rct_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.stm.sar.accountreceivablecollect.accountreceivablereceipt.integration").append("\n"); 
		query.append("FileName : AccountReceivableReceiptDBDAOSearchReceiptForAPInterfaceRSQL").append("\n"); 
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
		query.append("SELECT SAP_GEN_INV_NUM_FNC ('02', DECODE(SIGN(SRA.APLY_AMT), -1, 'C', 'S'), @[usr_id], SRAD.AP_OFC_CD) INV_NO" ).append("\n"); 
		query.append("	   , SRA.GL_DT    " ).append("\n"); 
		query.append("       , SRA.GL_DT INV_DT" ).append("\n"); 
		query.append("       , SR.RCT_CURR_CD INV_CURR_CD" ).append("\n"); 
		query.append("       , SRA.APLY_AMT INV_AMT" ).append("\n"); 
		query.append("       , SRAD.VNDR_NO" ).append("\n"); 
		query.append("       , SRA.RCV_CD_CMB_SEQ" ).append("\n"); 
		query.append("       , SR.RCT_NO ATTR_CTNT4" ).append("\n"); 
		query.append("       , SRAD.AP_OFC_CD OFC_CD" ).append("\n"); 
		query.append("       , 'AR REFUND - ' || SRAD.AP_RMK INV_DESC" ).append("\n"); 
		query.append("       , DECODE(SIGN(SRA.APLY_AMT), -1, 'CREDIT', 'STANDARD') INV_TP_LU_CD" ).append("\n"); 
		query.append("       , MO.LOC_CD ATTR_CTNT3" ).append("\n"); 
		query.append("       , SAM.ACCT_CTNT3" ).append("\n"); 
		query.append("       , SAM.AR_ACCT_CD CLR_ACCT_CD" ).append("\n"); 
		query.append("       , SAM.PAY_ACCT_CD" ).append("\n"); 
		query.append("	   , SRAD.RCT_APLY_DTL_SEQ" ).append("\n"); 
		query.append("	   , SRA.ACCT_XCH_RT_LVL INV_XCH_RT_TP_CD" ).append("\n"); 
		query.append("	   , SRA.GL_DT INV_XCH_DT" ).append("\n"); 
		query.append("	   , SRA.CONV_XCH_RT INV_XCH_RT" ).append("\n"); 
		query.append("	   , SR.RCT_DT ATTR_CTNT11" ).append("\n"); 
		query.append("FROM SAR_RECEIPT SR," ).append("\n"); 
		query.append("     SAR_RCV_APPL SRA," ).append("\n"); 
		query.append("     SAR_RCT_APLY_DTL SRAD," ).append("\n"); 
		query.append("     SAR_ACCT_MTX SAM," ).append("\n"); 
		query.append("     MDM_ORGANIZATION MO" ).append("\n"); 
		query.append("	 #if(${save_kind_cd} == 'R')" ).append("\n"); 
		query.append("		, SAR_RCT_HDR_SEQ_TMP TMP" ).append("\n"); 
		query.append("	 #end" ).append("\n"); 
		query.append("WHERE SR.RCT_SEQ = SRA.RCT_SEQ" ).append("\n"); 
		query.append("AND SR.RCT_SEQ = SRAD.RCT_SEQ" ).append("\n"); 
		query.append("AND SRA.RCT_APLY_DTL_SEQ = SRAD.RCT_APLY_DTL_SEQ" ).append("\n"); 
		query.append("AND SRA.ACCT_MTX_SEQ = SAM.ACCT_MTX_SEQ" ).append("\n"); 
		query.append("AND SR.RCT_OFC_CD = MO.OFC_CD" ).append("\n"); 
		query.append("AND SRA.RCV_APPL_STS_CD = 'WRTF'" ).append("\n"); 
		query.append("#if(${save_kind_cd} == 'S')" ).append("\n"); 
		query.append("	AND SRA.RCV_APPL_TP_CD = 'RECEIPT'" ).append("\n"); 
		query.append("	AND SRAD.AP_IF_CD IS NULL" ).append("\n"); 
		query.append("#elseif(${save_kind_cd} == 'R')" ).append("\n"); 
		query.append("	AND SRA.RCV_APPL_TP_CD = 'REVERSE'" ).append("\n"); 
		query.append("    AND SRAD.AP_IF_CD = 'I'   " ).append("\n"); 
		query.append("	AND SRA.RVS_GL_DT IS NOT NULL   " ).append("\n"); 
		query.append("	AND SRAD.RCT_APLY_HDR_SEQ = TMP.RCT_APLY_HDR_SEQ" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("	AND SRA.RCV_APPL_TP_CD = 'CANCEL'" ).append("\n"); 
		query.append("    AND SRAD.AP_IF_CD = 'I'  " ).append("\n"); 
		query.append("	AND SRA.RCT_CXL_DT IS NOT NULL" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("AND SAM.ACCT_CTNT1 = 'WRTF'" ).append("\n"); 
		query.append("AND SAM.PAY_ACCT_CD IS NOT NULL" ).append("\n"); 
		query.append("AND SAM.DELT_FLG = 'N'" ).append("\n"); 
		query.append("AND NVL(SAM.ACCT_ST_DT, SRA.GL_DT) >= SRA.GL_DT" ).append("\n"); 
		query.append("AND NVL(SAM.ACCT_END_DT, SRA.GL_DT) <= SRA.GL_DT" ).append("\n"); 
		query.append("AND SR.RCT_NO = @[rct_no]" ).append("\n"); 

	}
}