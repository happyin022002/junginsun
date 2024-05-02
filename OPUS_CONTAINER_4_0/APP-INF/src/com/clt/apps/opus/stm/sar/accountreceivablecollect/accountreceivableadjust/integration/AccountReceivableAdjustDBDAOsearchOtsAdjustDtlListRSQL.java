/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : AccountReceivableAdjustDBDAOsearchOtsAdjustDtlListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.07.06
*@LastModifier : 
*@LastVersion : 1.0
* 2015.07.06 
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

public class AccountReceivableAdjustDBDAOsearchOtsAdjustDtlListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Retrieve Outstanding Adjustment 
	  * </pre>
	  */
	public AccountReceivableAdjustDBDAOsearchOtsAdjustDtlListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rhq_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rep_ots_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("adjt_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bl_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.stm.sar.accountreceivablecollect.accountreceivableadjust.integration").append("\n"); 
		query.append("FileName : AccountReceivableAdjustDBDAOsearchOtsAdjustDtlListRSQL").append("\n"); 
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
		query.append("SELECT  P.CHG_TP_CD  " ).append("\n"); 
		query.append("       , P.BL_CURR_CD  " ).append("\n"); 
		query.append("	   , TRIM(SAR_GET_FMT_MASK_FNC(P.BL_CURR_CD, NVL(SUM(P.BAL_AMT), 0))) AS OTS_BAL_AMT       " ).append("\n"); 
		query.append("       , '' AS OTS_ADJ_BAL_AMT     " ).append("\n"); 
		query.append("       , P.RHQ_CD" ).append("\n"); 
		query.append("       , B.INV_OFC_CD" ).append("\n"); 
		query.append("       , P.BL_NO  " ).append("\n"); 
		query.append("       , P.INV_NO" ).append("\n"); 
		query.append("	   , A.OFC_CURR_CD" ).append("\n"); 
		query.append("       , Q.LOCL_XCH_RT" ).append("\n"); 
		query.append("       , Q.USD_XCH_RT" ).append("\n"); 
		query.append("       , P.RHQ_CD||B.INV_OFC_CD||P.BL_NO||P.INV_NO AS OTS_DTL_KEY  " ).append("\n"); 
		query.append("	   , (SELECT NVL(MC.DP_PRCS_KNT, '0') FROM MDM_CURRENCY MC WHERE MC.CURR_CD = P.BL_CURR_CD) CURR_DP_PRCS_KNT " ).append("\n"); 
		query.append("FROM SAR_OTS_CHG P,  " ).append("\n"); 
		query.append("     SAR_OTS_DTL Q," ).append("\n"); 
		query.append("     SAR_OTS_HDR A,        " ).append("\n"); 
		query.append("     SAR_OTS_HIS B" ).append("\n"); 
		query.append("WHERE P.RHQ_CD = Q.RHQ_CD   " ).append("\n"); 
		query.append("AND P.OTS_OFC_CD = Q.OTS_OFC_CD    " ).append("\n"); 
		query.append("AND P.BL_NO = Q.BL_NO    " ).append("\n"); 
		query.append("AND P.INV_NO = Q.INV_NO   " ).append("\n"); 
		query.append("AND P.CHG_TP_CD = Q.CHG_TP_CD " ).append("\n"); 
		query.append("AND P.BL_CURR_CD = Q.BL_CURR_CD  " ).append("\n"); 
		query.append("AND P.OTS_HIS_SEQ = B.OTS_HIS_SEQ     " ).append("\n"); 
		query.append("AND A.RHQ_CD = B.RHQ_CD   " ).append("\n"); 
		query.append("AND A.OTS_OFC_CD = B.OTS_OFC_CD " ).append("\n"); 
		query.append("AND A.BL_NO = B.BL_NO        " ).append("\n"); 
		query.append("AND A.INV_NO = B.INV_NO     " ).append("\n"); 
		query.append("AND A.RHQ_CD = @[rhq_cd]     " ).append("\n"); 
		query.append("#if(${ots_cd} == 'COU')   " ).append("\n"); 
		query.append("    AND A.OTS_OFC_CD = @[rep_ots_ofc_cd] " ).append("\n"); 
		query.append("#else       " ).append("\n"); 
		query.append("    AND A.OTS_OFC_CD = @[adjt_ofc_cd] " ).append("\n"); 
		query.append("#end     " ).append("\n"); 
		query.append("#if(${bl_no} != '')   " ).append("\n"); 
		query.append("    AND A.BL_NO = @[bl_no]  " ).append("\n"); 
		query.append("#end      " ).append("\n"); 
		query.append("#if(${ots_smry_cd} == 'INV')" ).append("\n"); 
		query.append("    #if(${inv_no} != '')   " ).append("\n"); 
		query.append("        AND A.INV_NO = @[inv_no]" ).append("\n"); 
		query.append("    #else  " ).append("\n"); 
		query.append("        AND A.INV_NO <> '**********' " ).append("\n"); 
		query.append("    #end " ).append("\n"); 
		query.append("#else     " ).append("\n"); 
		query.append("    #if(${inv_no} != '')    " ).append("\n"); 
		query.append("        AND A.INV_NO = @[inv_no]    " ).append("\n"); 
		query.append("    #else   " ).append("\n"); 
		query.append("        AND A.INV_NO = '**********'    " ).append("\n"); 
		query.append("    #end " ).append("\n"); 
		query.append("#end    " ).append("\n"); 
		query.append("AND B.OTS_HIS_TP_CD = 'OTS'   " ).append("\n"); 
		query.append("AND A.STL_FLG = 'N'" ).append("\n"); 
		query.append("GROUP BY P.CHG_TP_CD  " ).append("\n"); 
		query.append("       , P.BL_CURR_CD " ).append("\n"); 
		query.append("       , P.RHQ_CD" ).append("\n"); 
		query.append("       , B.INV_OFC_CD" ).append("\n"); 
		query.append("       , P.BL_NO  " ).append("\n"); 
		query.append("       , P.INV_NO" ).append("\n"); 
		query.append("	   , Q.LOCL_XCH_RT" ).append("\n"); 
		query.append("       , Q.USD_XCH_RT" ).append("\n"); 
		query.append("       , A.OFC_CURR_CD" ).append("\n"); 
		query.append("       , P.RHQ_CD||B.INV_OFC_CD||P.BL_NO||P.INV_NO " ).append("\n"); 
		query.append("HAVING NVL(SUM(P.BAL_AMT), 0) != 0" ).append("\n"); 
		query.append("ORDER BY" ).append("\n"); 
		query.append("	P.CHG_TP_CD," ).append("\n"); 
		query.append("	P.BL_CURR_CD" ).append("\n"); 

	}
}