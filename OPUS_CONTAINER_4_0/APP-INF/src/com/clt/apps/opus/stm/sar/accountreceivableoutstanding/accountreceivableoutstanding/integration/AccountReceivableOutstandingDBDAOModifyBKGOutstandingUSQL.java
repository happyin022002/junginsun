/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : AccountReceivableOutstandingDBDAOModifyBKGOutstandingUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.05.13
*@LastModifier : 
*@LastVersion : 1.0
* 2016.05.13 
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

public class AccountReceivableOutstandingDBDAOModifyBKGOutstandingUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ModifyBKGOutstanding
	  * </pre>
	  */
	public AccountReceivableOutstandingDBDAOModifyBKGOutstandingUSQL(){
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
		query.append("FileName : AccountReceivableOutstandingDBDAOModifyBKGOutstandingUSQL").append("\n"); 
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
		query.append("MERGE INTO BKG_OUTSTANDING A" ).append("\n"); 
		query.append("USING (" ).append("\n"); 
		query.append("            SELECT OTS_OFC_CD OFC_CD" ).append("\n"); 
		query.append("                , BL_NO CLT_BL_NO" ).append("\n"); 
		query.append("                , INV_NO" ).append("\n"); 
		query.append("                , OFC_CURR_CD" ).append("\n"); 
		query.append("                , BIL_TO_CUST_CNT_CD||LPAD(BIL_TO_CUST_SEQ, 6, '0') BIL_TO_CUST_CD" ).append("\n"); 
		query.append("                , CR_MK_FLG CR_FLG" ).append("\n"); 
		query.append("                , BKG_IO_BND_CD OTS_BND_TP_CD" ).append("\n"); 
		query.append("                , BKG_NO OTS_BKG_NO" ).append("\n"); 
		query.append("                , TO_DATE(DUE_DT, 'YYYY-MM-DD') OTS_DUE_DT" ).append("\n"); 
		query.append("                , NVL((SELECT 'Y'" ).append("\n"); 
		query.append("       	   		       FROM SAR_OTS_DTL" ).append("\n"); 
		query.append("       	   		       WHERE RHQ_CD = SOH.RHQ_CD" ).append("\n"); 
		query.append("       	   		       AND OTS_OFC_CD = SOH.OTS_OFC_CD" ).append("\n"); 
		query.append("       	   		       AND BL_NO = SOH.BL_NO" ).append("\n"); 
		query.append("       	   		       AND INV_NO = SOH.INV_NO" ).append("\n"); 
		query.append("		   		       HAVING SUM(BAL_AMT) <= 0), 'N') OTS_STL_FLG" ).append("\n"); 
		query.append("                , XCH_RT_TP_CD" ).append("\n"); 
		query.append("                , OTS_RMK CLT_RMK" ).append("\n"); 
		query.append("                , OTS_GRP_TP_CD" ).append("\n"); 
		query.append("                , OTS_TP_CD OTS_OCCR_TP_CD" ).append("\n"); 
		query.append("                , CLT_OFC_CD LST_CLT_OFC_CD" ).append("\n"); 
		query.append("                , CRE_USR_ID" ).append("\n"); 
		query.append("                , UPD_USR_ID" ).append("\n"); 
		query.append("            FROM SAR_OTS_HDR SOH" ).append("\n"); 
		query.append("            WHERE RHQ_CD = @[rhq_cd]" ).append("\n"); 
		query.append("            AND OTS_OFC_CD = @[ots_ofc_cd]" ).append("\n"); 
		query.append("            AND BL_NO = @[bl_no]" ).append("\n"); 
		query.append("            AND INV_NO = @[inv_no]" ).append("\n"); 
		query.append("            AND BKG_IO_BND_CD = 'I'" ).append("\n"); 
		query.append("        ) B" ).append("\n"); 
		query.append("ON (A.OFC_CD = B.OFC_CD" ).append("\n"); 
		query.append("    AND A.CLT_BL_NO = B.CLT_BL_NO" ).append("\n"); 
		query.append("    AND A.INV_NO = B.INV_NO)       " ).append("\n"); 
		query.append("WHEN MATCHED THEN " ).append("\n"); 
		query.append("    UPDATE " ).append("\n"); 
		query.append("        SET A.OFC_CURR_CD = B.OFC_CURR_CD" ).append("\n"); 
		query.append("            , A.BIL_TO_CUST_CD = B.BIL_TO_CUST_CD" ).append("\n"); 
		query.append("            , A.CR_FLG = B.CR_FLG" ).append("\n"); 
		query.append("            , A.OTS_BND_TP_CD = B.OTS_BND_TP_CD" ).append("\n"); 
		query.append("            , A.OTS_BKG_NO = B.OTS_BKG_NO" ).append("\n"); 
		query.append("            , A.OTS_DUE_DT = B.OTS_DUE_DT" ).append("\n"); 
		query.append("            , A.OTS_STL_FLG = B.OTS_STL_FLG" ).append("\n"); 
		query.append("            , A.XCH_RT_TP_CD = B.XCH_RT_TP_CD" ).append("\n"); 
		query.append("            , A.CLT_RMK = B.CLT_RMK" ).append("\n"); 
		query.append("            , A.OTS_GRP_TP_CD = B.OTS_GRP_TP_CD" ).append("\n"); 
		query.append("            , A.OTS_OCCR_TP_CD = B.OTS_OCCR_TP_CD" ).append("\n"); 
		query.append("            , A.LST_CLT_OFC_CD = B.LST_CLT_OFC_CD" ).append("\n"); 
		query.append("            , A.LST_UPD_CHK_DT = SYSDATE          " ).append("\n"); 
		query.append("            , A.UPD_DT = SYSDATE" ).append("\n"); 
		query.append("            , A.UPD_USR_ID = B.UPD_USR_ID" ).append("\n"); 
		query.append("			, A.CNG_IND_FLG = 'Y'" ).append("\n"); 
		query.append("WHEN NOT MATCHED THEN" ).append("\n"); 
		query.append("    INSERT (" ).append("\n"); 
		query.append("            A.OFC_CD" ).append("\n"); 
		query.append("            , A.CLT_BL_NO" ).append("\n"); 
		query.append("            , A.INV_NO" ).append("\n"); 
		query.append("            , A.OFC_CURR_CD" ).append("\n"); 
		query.append("            , A.BIL_TO_CUST_CD" ).append("\n"); 
		query.append("            , A.CR_FLG" ).append("\n"); 
		query.append("            , A.OTS_BND_TP_CD" ).append("\n"); 
		query.append("            , A.OTS_BKG_NO" ).append("\n"); 
		query.append("            , A.OTS_DUE_DT" ).append("\n"); 
		query.append("            , A.OTS_STL_FLG" ).append("\n"); 
		query.append("            , A.XCH_RT_TP_CD" ).append("\n"); 
		query.append("            , A.CLT_RMK" ).append("\n"); 
		query.append("            , A.OTS_GRP_TP_CD" ).append("\n"); 
		query.append("            , A.OTS_OCCR_TP_CD" ).append("\n"); 
		query.append("            , A.LST_CLT_OFC_CD" ).append("\n"); 
		query.append("            , A.LST_UPD_CHK_DT" ).append("\n"); 
		query.append("            , A.CRE_DT" ).append("\n"); 
		query.append("            , A.CRE_USR_ID" ).append("\n"); 
		query.append("            , A.UPD_DT" ).append("\n"); 
		query.append("            , A.UPD_USR_ID" ).append("\n"); 
		query.append("			, A.CNG_IND_FLG" ).append("\n"); 
		query.append("           )" ).append("\n"); 
		query.append("    VALUES (" ).append("\n"); 
		query.append("            B.OFC_CD" ).append("\n"); 
		query.append("            , B.CLT_BL_NO" ).append("\n"); 
		query.append("            , B.INV_NO" ).append("\n"); 
		query.append("            , B.OFC_CURR_CD" ).append("\n"); 
		query.append("            , B.BIL_TO_CUST_CD" ).append("\n"); 
		query.append("            , B.CR_FLG" ).append("\n"); 
		query.append("            , B.OTS_BND_TP_CD" ).append("\n"); 
		query.append("            , B.OTS_BKG_NO" ).append("\n"); 
		query.append("            , B.OTS_DUE_DT" ).append("\n"); 
		query.append("            , B.OTS_STL_FLG" ).append("\n"); 
		query.append("            , B.XCH_RT_TP_CD" ).append("\n"); 
		query.append("            , B.CLT_RMK" ).append("\n"); 
		query.append("            , B.OTS_GRP_TP_CD" ).append("\n"); 
		query.append("            , B.OTS_OCCR_TP_CD" ).append("\n"); 
		query.append("            , B.LST_CLT_OFC_CD" ).append("\n"); 
		query.append("            , SYSDATE" ).append("\n"); 
		query.append("            , SYSDATE" ).append("\n"); 
		query.append("            , B.CRE_USR_ID" ).append("\n"); 
		query.append("            , SYSDATE" ).append("\n"); 
		query.append("            , B.UPD_USR_ID" ).append("\n"); 
		query.append("			, 'Y'" ).append("\n"); 
		query.append("           )" ).append("\n"); 

	}
}