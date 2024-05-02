/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : AccountReceivableOutstandingDBDAOSearchOTSAgingPKRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.07.28
*@LastModifier : 
*@LastVersion : 1.0
* 2015.07.28 
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

public class AccountReceivableOutstandingDBDAOSearchOTSAgingPKRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * search aging group  primary key (office ,  office+customer)
	  * </pre>
	  */
	public AccountReceivableOutstandingDBDAOSearchOTSAgingPKRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sail_arr_dt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("ots_src_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cr_mk_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ots_grp_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("stl_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bil_to_cust_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.stm.sar.accountreceivableoutstanding.accountreceivableoutstanding.integration").append("\n"); 
		query.append("FileName : AccountReceivableOutstandingDBDAOSearchOTSAgingPKRSQL").append("\n"); 
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
		query.append("#if(${sum_ofc_cust_tp} == 'OFC')" ).append("\n"); 
		query.append("    #if(${sum_tp} == 'OFC')" ).append("\n"); 
		query.append("  	  A.CLT_OFC_CD AS PRIMARY_KEY" ).append("\n"); 
		query.append("	, A.CLT_OFC_CD " ).append("\n"); 
		query.append("    , '' CUST_NUM" ).append("\n"); 
		query.append("    , '' CUST_NM" ).append("\n"); 
		query.append("    , MAX(A.AR_HD_QTR_OFC_CD) AS AR_HD_QTR_OFC_CD" ).append("\n"); 
		query.append("    #else" ).append("\n"); 
		query.append("      MAX(A.CLT_OFC_CD) AS PRIMARY_KEY" ).append("\n"); 
		query.append("	, '' AS CLT_OFC_CD " ).append("\n"); 
		query.append("    , '' CUST_NUM" ).append("\n"); 
		query.append("    , '' CUST_NM" ).append("\n"); 
		query.append("    , MAX(A.AR_HD_QTR_OFC_CD) AS AR_HD_QTR_OFC_CD" ).append("\n"); 
		query.append("    #end " ).append("\n"); 
		query.append("#elseif(${sum_ofc_cust_tp} == 'CUST')" ).append("\n"); 
		query.append("  	  A.CLT_OFC_CD || A.CUST_CNT_CD || A.CUST_SEQ AS PRIMARY_KEY" ).append("\n"); 
		query.append("	, A.CLT_OFC_CD " ).append("\n"); 
		query.append("	, A.CUST_CNT_CD || LPAD(A.CUST_SEQ, 6, '0') AS CUST_NUM" ).append("\n"); 
		query.append("    , (SELECT NVL(BB.LOCL_NM, AA.CUST_LGL_ENG_NM) " ).append("\n"); 
		query.append("         FROM MDM_CUSTOMER AA" ).append("\n"); 
		query.append("            , MDM_CR_CUST BB " ).append("\n"); 
		query.append("        WHERE AA.CUST_CNT_CD = BB.CUST_CNT_CD(+)" ).append("\n"); 
		query.append("          AND AA.CUST_SEQ = BB.CUST_SEQ(+)" ).append("\n"); 
		query.append("          AND AA.CUST_CNT_CD = A.CUST_CNT_CD " ).append("\n"); 
		query.append("          AND AA.CUST_SEQ = A.CUST_SEQ) AS CUST_NM" ).append("\n"); 
		query.append("    , MAX(A.AR_HD_QTR_OFC_CD) AS AR_HD_QTR_OFC_CD" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("FROM " ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT " ).append("\n"); 
		query.append("	  A.CLT_OFC_CD " ).append("\n"); 
		query.append("    , C.AR_HD_QTR_OFC_CD" ).append("\n"); 
		query.append("    , A.BIL_TO_CUST_CNT_CD AS CUST_CNT_CD" ).append("\n"); 
		query.append("    , A.BIL_TO_CUST_SEQ AS CUST_SEQ" ).append("\n"); 
		query.append("FROM SAR_OTS_HDR A" ).append("\n"); 
		query.append("   , SAR_OTS_DTL B" ).append("\n"); 
		query.append("   , MDM_ORGANIZATION C" ).append("\n"); 
		query.append("WHERE 1 = 1" ).append("\n"); 
		query.append("  AND A.RHQ_CD = B.RHQ_CD" ).append("\n"); 
		query.append("  AND A.OTS_OFC_CD = B.OTS_OFC_CD" ).append("\n"); 
		query.append("  AND A.BL_NO = B.BL_NO" ).append("\n"); 
		query.append("  AND A.INV_NO = B.INV_NO" ).append("\n"); 
		query.append("  AND A.CLT_OFC_CD = C.OFC_CD(+)  " ).append("\n"); 
		query.append("#if (${rhq} != '')" ).append("\n"); 
		query.append("AND A.RHQ_CD IN (${rhq})" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${clt_ofc_cd} != '')" ).append("\n"); 
		query.append("AND A.CLT_OFC_CD IN (${clt_ofc_cd})" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${stl_flg} != '')" ).append("\n"); 
		query.append("AND A.STL_FLG = @[stl_flg]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${cr_mk_flg} != '')" ).append("\n"); 
		query.append("AND A.CR_MK_FLG = @[cr_mk_flg]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${ots_grp_tp_cd} != '')" ).append("\n"); 
		query.append("AND A.OTS_GRP_TP_CD = @[ots_grp_tp_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${bl_sum_tp} == 'OTS')" ).append("\n"); 
		query.append("AND EXISTS(SELECT 'X'" ).append("\n"); 
		query.append("             FROM  SAR_OTS_DTL SOD2" ).append("\n"); 
		query.append("            WHERE  SOD2.RHQ_CD = B.RHQ_CD" ).append("\n"); 
		query.append("              AND  SOD2.OTS_OFC_CD = B.OTS_OFC_CD" ).append("\n"); 
		query.append("              AND  SOD2.BL_NO = B.BL_NO" ).append("\n"); 
		query.append("              AND  SOD2.INV_NO = B.INV_NO" ).append("\n"); 
		query.append("            HAVING " ).append("\n"); 
		query.append("                   SUM(SOD2.BAL_AMT) > 0)" ).append("\n"); 
		query.append("#elseif(${bl_sum_tp} == 'OPY')" ).append("\n"); 
		query.append("AND EXISTS(SELECT 'X'" ).append("\n"); 
		query.append("             FROM  SAR_OTS_DTL SOD2" ).append("\n"); 
		query.append("            WHERE  SOD2.RHQ_CD = B.RHQ_CD" ).append("\n"); 
		query.append("              AND  SOD2.OTS_OFC_CD = B.OTS_OFC_CD" ).append("\n"); 
		query.append("              AND  SOD2.BL_NO = B.BL_NO" ).append("\n"); 
		query.append("              AND  SOD2.INV_NO = B.INV_NO" ).append("\n"); 
		query.append("            HAVING " ).append("\n"); 
		query.append("                   SUM(SOD2.BAL_AMT) < 0)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${bl_inv_tp} == 'INV')" ).append("\n"); 
		query.append("AND A.INV_NO <> '**********'" ).append("\n"); 
		query.append("#elseif(${bl_inv_tp} == 'BL')" ).append("\n"); 
		query.append("AND A.INV_NO = '**********'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${ots_src_cd} != '')" ).append("\n"); 
		query.append("  #if(${ots_src_cd} == 'OTHER')" ).append("\n"); 
		query.append("    AND (A.OTS_SRC_CD IN (SELECT LU_CD " ).append("\n"); 
		query.append("                           FROM SCO_LU_DTL " ).append("\n"); 
		query.append("                          WHERE LU_TP_CD = 'OTS SRC CD'  " ).append("\n"); 
		query.append("                            AND LU_CD NOT IN ('INVAR','BMS','JO','CDAM','AGENT','3RD')" ).append("\n"); 
		query.append("                         )" ).append("\n"); 
		query.append("         OR A.OTS_SRC_CD IS NULL " ).append("\n"); 
		query.append("         )" ).append("\n"); 
		query.append("  #else   " ).append("\n"); 
		query.append("	AND A.OTS_SRC_CD = @[ots_src_cd]" ).append("\n"); 
		query.append("  #end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${sail_arr_dt} != '')" ).append("\n"); 
		query.append("AND A.SAIL_ARR_DT >= @[sail_arr_dt]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${bil_to_cust_cnt_cd} != '')" ).append("\n"); 
		query.append("AND A.BIL_TO_CUST_CNT_CD = @[bil_to_cust_cnt_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${bil_to_cust_seq} != '')" ).append("\n"); 
		query.append("AND A.BIL_TO_CUST_SEQ = @[bil_to_cust_seq]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if(${bl_sum_tp} != 'OTS')" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT " ).append("\n"); 
		query.append("	  SR.RCT_OFC_CD    AS CLT_OFC_CD" ).append("\n"); 
		query.append("    , MO.AR_HD_QTR_OFC_CD" ).append("\n"); 
		query.append("    , SR.RCT_CUST_CNT_CD AS CUST_CNT_CD" ).append("\n"); 
		query.append("    , SR.RCT_CUST_SEQ AS CUST_SEQ" ).append("\n"); 
		query.append("FROM   SAR_RECEIPT SR," ).append("\n"); 
		query.append("       MDM_ORGANIZATION MO," ).append("\n"); 
		query.append("       MDM_CUSTOMER MC" ).append("\n"); 
		query.append("WHERE  SR.RCT_OFC_CD = MO.OFC_CD   " ).append("\n"); 
		query.append("AND    SR.RCT_CUST_CNT_CD = MC.CUST_CNT_CD" ).append("\n"); 
		query.append("AND    SR.RCT_CUST_SEQ = MC.CUST_SEQ" ).append("\n"); 
		query.append("AND    SR.RCT_CUST_CNT_CD IS NOT NULL" ).append("\n"); 
		query.append("AND    SR.RCT_CUST_SEQ IS NOT NULL" ).append("\n"); 
		query.append("AND    SR.RCT_STS_CD = 'UNAPP'" ).append("\n"); 
		query.append("AND    SR.BAL_RCT_AMT <> 0" ).append("\n"); 
		query.append("#if(${clt_ofc_cd} != '')" ).append("\n"); 
		query.append("AND    SR.RCT_OFC_CD IN (${clt_ofc_cd})" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${rhq} != '')" ).append("\n"); 
		query.append("AND	   MO.AR_HD_QTR_OFC_CD IN (${rhq})" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${bil_to_cust_cnt_cd} != '')" ).append("\n"); 
		query.append("AND SR.RCT_CUST_CNT_CD = @[bil_to_cust_cnt_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${bil_to_cust_seq} != '')" ).append("\n"); 
		query.append("AND SR.RCT_CUST_SEQ  = @[bil_to_cust_seq]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(") A" ).append("\n"); 
		query.append("#if(${sum_ofc_cust_tp} == 'OFC' && ${sum_tp} == 'OFC')" ).append("\n"); 
		query.append("GROUP BY " ).append("\n"); 
		query.append("    A.CLT_OFC_CD " ).append("\n"); 
		query.append("ORDER BY " ).append("\n"); 
		query.append("    A.CLT_OFC_CD" ).append("\n"); 
		query.append("#elseif(${sum_ofc_cust_tp} == 'CUST')" ).append("\n"); 
		query.append("GROUP BY" ).append("\n"); 
		query.append("    A.CLT_OFC_CD " ).append("\n"); 
		query.append("  , A.CUST_CNT_CD" ).append("\n"); 
		query.append("  , A.CUST_SEQ" ).append("\n"); 
		query.append("ORDER BY" ).append("\n"); 
		query.append("    A.CLT_OFC_CD" ).append("\n"); 
		query.append("  , A.CUST_CNT_CD" ).append("\n"); 
		query.append("  , A.CUST_SEQ" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}