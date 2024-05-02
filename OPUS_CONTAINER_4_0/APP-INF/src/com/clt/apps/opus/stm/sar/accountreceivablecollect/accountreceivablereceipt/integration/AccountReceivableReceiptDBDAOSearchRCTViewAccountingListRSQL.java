/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : AccountReceivableReceiptDBDAOSearchRCTViewAccountingListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.09.30
*@LastModifier : 
*@LastVersion : 1.0
* 2014.09.30 
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

public class AccountReceivableReceiptDBDAOSearchRCTViewAccountingListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Receipts View Account list
	  * </pre>
	  */
	public AccountReceivableReceiptDBDAOSearchRCTViewAccountingListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rct_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.stm.sar.accountreceivablecollect.accountreceivablereceipt.integration").append("\n"); 
		query.append("FileName : AccountReceivableReceiptDBDAOSearchRCTViewAccountingListRSQL").append("\n"); 
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
		query.append("SELECT   SR.RCT_NO          " ).append("\n"); 
		query.append("       , SRA.RCV_APPL_TP_CD " ).append("\n"); 
		query.append("       , SCD.DTRB_SRC_TP_CD" ).append("\n"); 
		query.append("       , SOC.BL_NO  " ).append("\n"); 
		query.append("	   , SOC.INV_NO        " ).append("\n"); 
		query.append("       , SOC.IF_NO          " ).append("\n"); 
		query.append("       , SOC.CHG_TP_CD      " ).append("\n"); 
		query.append("       , SLC.SGM_CTNT1      " ).append("\n"); 
		query.append("       , SLC.SGM_CTNT2      " ).append("\n"); 
		query.append("       , SLC.SGM_CTNT3      " ).append("\n"); 
		query.append("       , SLC.SGM_CTNT4      " ).append("\n"); 
		query.append("       , SLC.SGM_CTNT5      " ).append("\n"); 
		query.append("       , SLC.SGM_CTNT6      " ).append("\n"); 
		query.append("       , SCD.CURR_CD        " ).append("\n"); 
		query.append("       , SCD.INP_DR_AMT     " ).append("\n"); 
		query.append("       , SCD.INP_CR_AMT     " ).append("\n"); 
		query.append("       , SCD.ACCT_DR_AMT    " ).append("\n"); 
		query.append("       , SCD.ACCT_CR_AMT    " ).append("\n"); 
		query.append("       , SCD.CONV_XCH_RT    " ).append("\n"); 
		query.append("       , SCD.ACCT_XCH_RT_DT" ).append("\n"); 
		query.append("	   , SRA.GL_DT   " ).append("\n"); 
		query.append("	   , SRA.WRTF_TP_CD WRTF_CD     " ).append("\n"); 
		query.append("FROM     SAR_RECEIPT SR " ).append("\n"); 
		query.append("       , SAR_RCV_APPL SRA " ).append("\n"); 
		query.append("       , SAR_CLT_DTRB SCD " ).append("\n"); 
		query.append("       , SCO_LEGR_CD_CMB SLC " ).append("\n"); 
		query.append("       , SAR_OTS_CHG SOC " ).append("\n"); 
		query.append("WHERE  SR.RCT_SEQ = SRA.RCT_SEQ " ).append("\n"); 
		query.append("       AND SRA.RCV_APPL_SEQ = SCD.DTRB_SRC_SEQ " ).append("\n"); 
		query.append("       AND SCD.DTRB_CD_CMB_SEQ = SLC.CD_CMB_SEQ " ).append("\n"); 
		query.append("       AND SRA.OTS_HIS_SEQ = SOC.OTS_HIS_SEQ(+) " ).append("\n"); 
		query.append("       AND SRA.CHG_TP_CD = SOC.CHG_TP_CD(+) " ).append("\n"); 
		query.append("       AND SCD.DTRB_SRC_TBL_CD = 'RCT'        " ).append("\n"); 
		query.append("       AND SR.RCT_NO = @[rct_no]" ).append("\n"); 
		query.append("ORDER  BY SCD.DTRB_SRC_SEQ " ).append("\n"); 
		query.append("        , SCD.CLT_DTRB_SEQ" ).append("\n"); 

	}
}