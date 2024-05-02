/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : AccountReceivableAdjustDBDAOSearchAdjViewAccountingListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.05.15
*@LastModifier : 
*@LastVersion : 1.0
* 2015.05.15 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.stm.sar.accountreceivablecollect.accountreceivableadjust.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AccountReceivableAdjustDBDAOSearchAdjViewAccountingListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Search Adjust view Accounting
	  * </pre>
	  */
	public AccountReceivableAdjustDBDAOSearchAdjViewAccountingListRSQL(){
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
		params.put("adj_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.stm.sar.accountreceivablecollect.accountreceivableadjust.integration").append("\n"); 
		query.append("FileName : AccountReceivableAdjustDBDAOSearchAdjViewAccountingListRSQL").append("\n"); 
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
		query.append("SELECT *" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("  SELECT   SAH.ADJ_NO" ).append("\n"); 
		query.append("         , SAH.ADJ_STS_CD" ).append("\n"); 
		query.append("         , SCD.DTRB_SRC_TP_CD" ).append("\n"); 
		query.append("         , SOC.BL_NO" ).append("\n"); 
		query.append("         , SOC.IF_NO" ).append("\n"); 
		query.append("         , SOC.CHG_TP_CD" ).append("\n"); 
		query.append("         , SOC.OTS_OFC_CD" ).append("\n"); 
		query.append("         , SLC.SGM_CTNT1" ).append("\n"); 
		query.append("         , SLC.SGM_CTNT2" ).append("\n"); 
		query.append("         , SLC.SGM_CTNT3" ).append("\n"); 
		query.append("         , SLC.SGM_CTNT4" ).append("\n"); 
		query.append("         , SLC.SGM_CTNT5" ).append("\n"); 
		query.append("         , SLC.SGM_CTNT6" ).append("\n"); 
		query.append("		 , SAH.ADJ_GL_DT AS GL_DT" ).append("\n"); 
		query.append("         , SCD.CURR_CD" ).append("\n"); 
		query.append("         , SCD.INP_DR_AMT" ).append("\n"); 
		query.append("         , SCD.INP_CR_AMT" ).append("\n"); 
		query.append("         , SCD.ACCT_DR_AMT" ).append("\n"); 
		query.append("         , SCD.ACCT_CR_AMT" ).append("\n"); 
		query.append("         , SCD.CONV_XCH_RT" ).append("\n"); 
		query.append("         , SCD.ACCT_XCH_RT_DT" ).append("\n"); 
		query.append("         , '' AS ACTION_TYPE" ).append("\n"); 
		query.append("         , SAH.ADJ_TP_CD " ).append("\n"); 
		query.append("  FROM   SAR_ADJ_HIS SAH " ).append("\n"); 
		query.append("         , SAR_CLT_DTRB SCD " ).append("\n"); 
		query.append("         , SCO_LEGR_CD_CMB SLC " ).append("\n"); 
		query.append("         , SAR_OTS_CHG SOC " ).append("\n"); 
		query.append("  WHERE  SAH.ADJ_HIS_SEQ = SCD.DTRB_SRC_SEQ " ).append("\n"); 
		query.append("    AND  SCD.DTRB_CD_CMB_SEQ = SLC.CD_CMB_SEQ " ).append("\n"); 
		query.append("    AND  SAH.OTS_HIS_SEQ = SOC.OTS_HIS_SEQ(+) " ).append("\n"); 
		query.append("    AND  SAH.CHG_TP_CD = SOC.CHG_TP_CD(+) " ).append("\n"); 
		query.append("    AND  SCD.DTRB_SRC_TBL_CD = 'ADJ' " ).append("\n"); 
		query.append("    AND  SAH.ADJ_NO = @[adj_no]" ).append("\n"); 
		query.append("    AND (SIGN(NVL(SCD.INP_DR_AMT,0)) + SIGN(NVL(SCD.INP_CR_AMT,0)) + SIGN(NVL(SCD.ACCT_DR_AMT,0)) + SIGN(NVL(SCD.ACCT_CR_AMT,0))) > 0" ).append("\n"); 
		query.append("  ORDER  BY SCD.DTRB_SRC_SEQ " ).append("\n"); 
		query.append("          , SCD.CLT_DTRB_SEQ" ).append("\n"); 
		query.append(") A" ).append("\n"); 
		query.append("#if(${action_type} == 'ASA')  " ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT *" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("  SELECT   SOH.BL_NO AS ADJ_NO" ).append("\n"); 
		query.append("         , 'OTS' AS ADJ_STS_CD" ).append("\n"); 
		query.append("         , SOD.ACCT_CLSS_CD" ).append("\n"); 
		query.append("         , SOH.BL_NO " ).append("\n"); 
		query.append("         , SOH.IF_NO " ).append("\n"); 
		query.append("         , SOD.CHG_TP_CD" ).append("\n"); 
		query.append("         , SOH.OTS_OFC_CD" ).append("\n"); 
		query.append("         , SLC.SGM_CTNT1" ).append("\n"); 
		query.append("         , SLC.SGM_CTNT2" ).append("\n"); 
		query.append("         , SLC.SGM_CTNT3" ).append("\n"); 
		query.append("         , SLC.SGM_CTNT4" ).append("\n"); 
		query.append("         , SLC.SGM_CTNT5" ).append("\n"); 
		query.append("         , SLC.SGM_CTNT6" ).append("\n"); 
		query.append("         , SOH.GL_DT AS GL_DT" ).append("\n"); 
		query.append("         , SOD.CURR_CD" ).append("\n"); 
		query.append("         , SOD.INP_DR_AMT" ).append("\n"); 
		query.append("         , SOD.INP_CR_AMT" ).append("\n"); 
		query.append("         , SOD.ACCT_DR_AMT" ).append("\n"); 
		query.append("         , SOD.ACCT_CR_AMT" ).append("\n"); 
		query.append("         , SOD.CONV_XCH_RT" ).append("\n"); 
		query.append("         , SOD.ACCT_XCH_RT_DT         " ).append("\n"); 
		query.append("         , '' AS ACTION_TYPE" ).append("\n"); 
		query.append("         , 'ASA' AS ADJ_TP_CD" ).append("\n"); 
		query.append("  FROM   SAR_OTS_HIS SOH " ).append("\n"); 
		query.append("         , SAR_OTS_DTRB SOD " ).append("\n"); 
		query.append("         , SCO_LEGR_CD_CMB SLC " ).append("\n"); 
		query.append("  WHERE  SOD.OTS_CD_CMB_SEQ = SLC.CD_CMB_SEQ " ).append("\n"); 
		query.append("         AND SOH.OTS_HIS_SEQ = SOD.OTS_HIS_SEQ " ).append("\n"); 
		query.append("         AND SOH.BL_NO = @[adj_no]" ).append("\n"); 
		query.append("         AND SOH.OTS_OFC_CD= @[ots_ofc_cd] " ).append("\n"); 
		query.append("  ORDER  BY SOH.IF_NO " ).append("\n"); 
		query.append("       , SOD.CHG_TP_CD " ).append("\n"); 
		query.append("       , SOD.ACCT_CLSS_CD" ).append("\n"); 
		query.append(") B" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}