/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : AccountReceivableAdjustDBDAOsearchOffsetARPopupListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.03.24
*@LastModifier : 
*@LastVersion : 1.0
* 2015.03.24 
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

public class AccountReceivableAdjustDBDAOsearchOffsetARPopupListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Inquery AR Search Popup
	  * </pre>
	  */
	public AccountReceivableAdjustDBDAOsearchOffsetARPopupListRSQL(){
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
		params.put("bil_to_cust_cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vvd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inv_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ots_smry_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("chg_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bl_curr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("offst_curr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bil_to_cust_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.stm.sar.accountreceivablecollect.accountreceivableadjust.integration").append("\n"); 
		query.append("FileName : AccountReceivableAdjustDBDAOsearchOffsetARPopupListRSQL").append("\n"); 
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
		query.append("      A.VSL_CD " ).append("\n"); 
		query.append("    , A.SKD_VOY_NO" ).append("\n"); 
		query.append("    , A.DIR_CD" ).append("\n"); 
		query.append("    , A.VSL_CD || A.SKD_VOY_NO || A.DIR_CD AS VVD_CD" ).append("\n"); 
		query.append("    , A.BIL_TO_CUST_CNT_CD" ).append("\n"); 
		query.append("    , A.BIL_TO_CUST_SEQ" ).append("\n"); 
		query.append("    , A.BIL_TO_CUST_CNT_CD || LPAD(A.BIL_TO_CUST_SEQ, 6,'0') AS BIL_TO_CUST_NUM" ).append("\n"); 
		query.append("    , (SELECT CUST_LGL_ENG_NM FROM MDM_CUSTOMER WHERE CUST_CNT_CD = A.BIL_TO_CUST_CNT_CD AND CUST_SEQ = A.BIL_TO_CUST_SEQ) AS CUST_LGL_ENG_NM" ).append("\n"); 
		query.append("    , A.OTS_TP_CD" ).append("\n"); 
		query.append("    , A.STL_FLG " ).append("\n"); 
		query.append("    , A.POL_CD" ).append("\n"); 
		query.append("    , A.POD_CD" ).append("\n"); 
		query.append("    , A.SVC_SCP_CD" ).append("\n"); 
		query.append("    , A.BKG_IO_BND_CD" ).append("\n"); 
		query.append("    , A.XCH_RT_DT" ).append("\n"); 
		query.append("    , A.XCH_RT_TP_CD" ).append("\n"); 
		query.append("    , A.MAX_AR_IF_NO    " ).append("\n"); 
		query.append("    , B.RHQ_CD" ).append("\n"); 
		query.append("    , B.OTS_OFC_CD" ).append("\n"); 
		query.append("    , B.BL_NO" ).append("\n"); 
		query.append("    , B.INV_NO" ).append("\n"); 
		query.append("    , DECODE(@[ots_smry_cd], 'INV', B.INV_NO, B.BL_NO) AS BL_INV_NO" ).append("\n"); 
		query.append("    , B.BL_CURR_CD" ).append("\n"); 
		query.append("    , B.CHG_TP_CD" ).append("\n"); 
		query.append("    , B.INV_AMT" ).append("\n"); 
		query.append("    , B.ADJ_AMT    " ).append("\n"); 
		query.append("    , B.LOCL_XCH_RT" ).append("\n"); 
		query.append("    , B.USD_XCH_RT" ).append("\n"); 
		query.append("    , B.BAL_LOCL_AMT" ).append("\n"); 
		query.append("    , B.BAL_USD_AMT" ).append("\n"); 
		query.append("    , 'AR' AS OFFST_TP_CD    " ).append("\n"); 
		query.append("    , C.INV_OFC_CD" ).append("\n"); 
		query.append("    , SAR_GET_FMT_MASK_FNC(B.BL_CURR_CD,C.BAL_AMT) BAL_AMT" ).append("\n"); 
		query.append("    , @[offst_curr_cd] AS OFFST_CURR_CD" ).append("\n"); 
		query.append("   -- , 0.00 AS AR_XCH_RT" ).append("\n"); 
		query.append("    , DECODE(@[offst_curr_cd],'USD', B.USD_XCH_RT, A.OFC_CURR_CD, B.LOCL_XCH_RT, B.BL_CURR_CD, 1.00, 0.00 )  AS AR_XCH_RT" ).append("\n"); 
		query.append("    , 0.00 AS AR_XCH_AMT" ).append("\n"); 
		query.append("    , C.GL_DT" ).append("\n"); 
		query.append("    , (SELECT NVL(MC.DP_PRCS_KNT,0) FROM MDM_CURRENCY MC WHERE MC.CURR_CD = B.BL_CURR_CD)  AS DP_PRCS_KNT" ).append("\n"); 
		query.append("FROM SAR_OTS_HDR A" ).append("\n"); 
		query.append("   , SAR_OTS_DTL B   " ).append("\n"); 
		query.append("   , (" ).append("\n"); 
		query.append("        SELECT   A.RHQ_CD" ).append("\n"); 
		query.append("               , A.OTS_OFC_CD" ).append("\n"); 
		query.append("               , A.BL_NO" ).append("\n"); 
		query.append("               , A.INV_NO" ).append("\n"); 
		query.append("               , A.BL_CURR_CD" ).append("\n"); 
		query.append("               , A.CHG_TP_CD" ).append("\n"); 
		query.append("               , SUM(A.BAL_AMT) AS BAL_AMT                       " ).append("\n"); 
		query.append("               , B.INV_OFC_CD " ).append("\n"); 
		query.append("               , MAX(A.GL_DT) AS GL_DT                      " ).append("\n"); 
		query.append("        FROM " ).append("\n"); 
		query.append("            SAR_OTS_CHG A" ).append("\n"); 
		query.append("           ,SAR_OTS_HIS B" ).append("\n"); 
		query.append("        WHERE  1 = 1  " ).append("\n"); 
		query.append("          AND  A.OTS_HIS_SEQ = B.OTS_HIS_SEQ" ).append("\n"); 
		query.append("        GROUP BY A.RHQ_CD" ).append("\n"); 
		query.append("               , A.OTS_OFC_CD" ).append("\n"); 
		query.append("               , A.BL_NO" ).append("\n"); 
		query.append("               , A.INV_NO" ).append("\n"); 
		query.append("               , A.BL_CURR_CD" ).append("\n"); 
		query.append("               , A.CHG_TP_CD" ).append("\n"); 
		query.append("               , B.INV_OFC_CD" ).append("\n"); 
		query.append("     ) C     " ).append("\n"); 
		query.append("WHERE A.RHQ_CD = B.RHQ_CD" ).append("\n"); 
		query.append("  AND A.OTS_OFC_CD = B.OTS_OFC_CD" ).append("\n"); 
		query.append("  AND A.BL_NO = B.BL_NO" ).append("\n"); 
		query.append("  AND A.INV_NO = B.INV_NO       " ).append("\n"); 
		query.append("  AND B.RHQ_CD = C.RHQ_CD     " ).append("\n"); 
		query.append("  AND B.OTS_OFC_CD = C.OTS_OFC_CD" ).append("\n"); 
		query.append("  AND B.BL_NO = C.BL_NO" ).append("\n"); 
		query.append("  AND B.INV_NO = C.INV_NO" ).append("\n"); 
		query.append("  AND B.BL_CURR_CD = C.BL_CURR_CD " ).append("\n"); 
		query.append("  AND B.CHG_TP_CD = C.CHG_TP_CD " ).append("\n"); 
		query.append("  AND A.STL_FLG = 'N'  " ).append("\n"); 
		query.append("  -- 검색 조건은 로그인 사용자의 SCO_OFC_INFO TABLE의  정보로  설정" ).append("\n"); 
		query.append("  AND A.RHQ_CD =  @[rhq_cd]   " ).append("\n"); 
		query.append("  AND (C.BAL_AMT > 0 OR C.BAL_AMT < 0)" ).append("\n"); 
		query.append("  #if(${ots_cd} == 'COU')   " ).append("\n"); 
		query.append("    AND A.OTS_OFC_CD = @[rep_ots_ofc_cd] " ).append("\n"); 
		query.append("  #else       " ).append("\n"); 
		query.append("    AND C.INV_OFC_CD = @[inv_ofc_cd]  " ).append("\n"); 
		query.append("  #end   " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("  #if(${ots_smry_cd} == 'INV')" ).append("\n"); 
		query.append("      #if(${bl_inv_no} != '')   " ).append("\n"); 
		query.append("          AND A.INV_NO IN (${bl_inv_no})" ).append("\n"); 
		query.append("	  #else" ).append("\n"); 
		query.append("		  AND A.INV_NO <> '**********' " ).append("\n"); 
		query.append("      #end " ).append("\n"); 
		query.append("  #else     " ).append("\n"); 
		query.append("      #if(${bl_inv_no} != '')   " ).append("\n"); 
		query.append("          AND A.BL_NO  IN (${bl_inv_no})" ).append("\n"); 
		query.append("	  #else" ).append("\n"); 
		query.append("		  AND A.INV_NO = '**********'" ).append("\n"); 
		query.append("      #end   " ).append("\n"); 
		query.append("  #end  " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("  #if(${vvd_cd} != '') " ).append("\n"); 
		query.append("    AND A.VSL_CD || A.SKD_VOY_NO || A.DIR_CD = @[vvd_cd]" ).append("\n"); 
		query.append("  #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("  #if(${bil_to_cust_cnt_cd} != '') " ).append("\n"); 
		query.append("    AND A.BIL_TO_CUST_CNT_CD  = @[bil_to_cust_cnt_cd]" ).append("\n"); 
		query.append("  #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("  #if(${bil_to_cust_seq} != '') " ).append("\n"); 
		query.append("    AND LPAD(A.BIL_TO_CUST_SEQ, 6,'0')  = LPAD(@[bil_to_cust_seq], 6,'0')" ).append("\n"); 
		query.append("  #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("  #if(${chg_tp_cd} != '')    " ).append("\n"); 
		query.append("      AND B.CHG_TP_CD  =   @[chg_tp_cd]" ).append("\n"); 
		query.append("  #end     " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("  #if(${bl_curr_cd} != '')    " ).append("\n"); 
		query.append("      AND B.BL_CURR_CD  =   @[bl_curr_cd]" ).append("\n"); 
		query.append("  #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("ORDER BY " ).append("\n"); 
		query.append("        A.RHQ_CD" ).append("\n"); 
		query.append("      , A.OTS_OFC_CD" ).append("\n"); 
		query.append("      , A.BL_NO" ).append("\n"); 
		query.append("      , A.INV_NO" ).append("\n"); 

	}
}