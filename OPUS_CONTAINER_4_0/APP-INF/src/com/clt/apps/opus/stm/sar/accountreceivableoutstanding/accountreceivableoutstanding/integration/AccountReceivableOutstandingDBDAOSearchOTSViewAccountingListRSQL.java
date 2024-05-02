/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : AccountReceivableOutstandingDBDAOSearchOTSViewAccountingListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.10.02
*@LastModifier : 
*@LastVersion : 1.0
* 2014.10.02 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.stm.sar.accountreceivableoutstanding.accountreceivableoutstanding.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AccountReceivableOutstandingDBDAOSearchOTSViewAccountingListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Search Outstanding vew accounting
	  * </pre>
	  */
	public AccountReceivableOutstandingDBDAOSearchOTSViewAccountingListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ots_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("Path : com.clt.apps.opus.stm.sar.accountreceivableoutstanding.accountreceivableoutstanding.integration").append("\n"); 
		query.append("FileName : AccountReceivableOutstandingDBDAOSearchOTSViewAccountingListRSQL").append("\n"); 
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
		query.append("SELECT   SOH.BL_NO " ).append("\n"); 
		query.append("       , SOH.IF_NO " ).append("\n"); 
		query.append("       , SOH.OTS_OFC_CD" ).append("\n"); 
		query.append("       , SLC.SGM_CTNT1" ).append("\n"); 
		query.append("       , SLC.SGM_CTNT2" ).append("\n"); 
		query.append("       , SLC.SGM_CTNT3" ).append("\n"); 
		query.append("       , SLC.SGM_CTNT4" ).append("\n"); 
		query.append("       , SLC.SGM_CTNT5" ).append("\n"); 
		query.append("       , SLC.SGM_CTNT6" ).append("\n"); 
		query.append("       , SOD.ACCT_CLSS_CD" ).append("\n"); 
		query.append("       , SOD.CURR_CD" ).append("\n"); 
		query.append("       , SOD.INP_DR_AMT" ).append("\n"); 
		query.append("       , SOD.INP_CR_AMT" ).append("\n"); 
		query.append("       , SOD.ACCT_DR_AMT" ).append("\n"); 
		query.append("       , SOD.ACCT_CR_AMT" ).append("\n"); 
		query.append("       , SOD.CONV_XCH_RT" ).append("\n"); 
		query.append("       , SOD.ACCT_XCH_RT_DT" ).append("\n"); 
		query.append("       , SOD.CHG_TP_CD" ).append("\n"); 
		query.append("	   , SOH.GL_DT" ).append("\n"); 
		query.append("FROM   SAR_OTS_HIS SOH " ).append("\n"); 
		query.append("       , SAR_OTS_DTRB SOD " ).append("\n"); 
		query.append("       , SCO_LEGR_CD_CMB SLC " ).append("\n"); 
		query.append("WHERE  SOD.OTS_CD_CMB_SEQ = SLC.CD_CMB_SEQ " ).append("\n"); 
		query.append("       AND SOH.OTS_HIS_SEQ = SOD.OTS_HIS_SEQ " ).append("\n"); 
		query.append("       AND SOH.BL_NO = @[bl_no]" ).append("\n"); 
		query.append("	   AND SOH.INV_NO = @[inv_no]" ).append("\n"); 
		query.append("       AND SOH.OTS_OFC_CD= @[ots_ofc_cd] " ).append("\n"); 
		query.append("ORDER  BY SOH.IF_NO " ).append("\n"); 
		query.append("     , SOD.CHG_TP_CD " ).append("\n"); 
		query.append("     , SOD.ACCT_CLSS_CD" ).append("\n"); 

	}
}