/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : AccountReceivableOutstandingDBDAOSearchOTSAgingBaseCntListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.02.23
*@LastModifier : 
*@LastVersion : 1.0
* 2015.02.23 
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

public class AccountReceivableOutstandingDBDAOSearchOTSAgingBaseCntListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Select Aging Count
	  * </pre>
	  */
	public AccountReceivableOutstandingDBDAOSearchOTSAgingBaseCntListRSQL(){
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
		params.put("ots_rt_flg",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("due_dt",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("FileName : AccountReceivableOutstandingDBDAOSearchOTSAgingBaseCntListRSQL").append("\n"); 
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
		query.append("SELECT  " ).append("\n"); 
		query.append("        '' AS SAIL_ARR_DT" ).append("\n"); 
		query.append("		#if(${sum_ofc_cust_tp} == 'OFC')" ).append("\n"); 
		query.append("           #if(${sum_tp} == 'OFC')" ).append("\n"); 
		query.append("      		, A.CLT_OFC_CD" ).append("\n"); 
		query.append("		    , A.CLT_OFC_CD AS PRIMARY_KEY" ).append("\n"); 
		query.append("           #else      " ).append("\n"); 
		query.append("    		, MAX(A.CLT_OFC_CD) AS CLT_OFC_CD" ).append("\n"); 
		query.append("            , '' AS CUST_LGL_ENG_NM" ).append("\n"); 
		query.append("		    , MAX(A.CLT_OFC_CD) AS PRIMARY_KEY" ).append("\n"); 
		query.append("           #end" ).append("\n"); 
		query.append("		#elseif(${sum_ofc_cust_tp} == 'CUST')" ).append("\n"); 
		query.append("		, A.CLT_OFC_CD" ).append("\n"); 
		query.append("		, A.BIL_TO_CUST_CNT_CD" ).append("\n"); 
		query.append("		, A.BIL_TO_CUST_SEQ" ).append("\n"); 
		query.append("		, A.CLT_OFC_CD || A.BIL_TO_CUST_CNT_CD || A.BIL_TO_CUST_SEQ AS PRIMARY_KEY" ).append("\n"); 
		query.append("		, (" ).append("\n"); 
		query.append("		   SELECT CUST_LGL_ENG_NM " ).append("\n"); 
		query.append("		   FROM MDM_CUSTOMER " ).append("\n"); 
		query.append("		   WHERE CUST_CNT_CD = A.BIL_TO_CUST_CNT_CD AND CUST_SEQ = A.BIL_TO_CUST_SEQ" ).append("\n"); 
		query.append("		   ) AS CUST_LGL_ENG_NM" ).append("\n"); 
		query.append("		" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("        , COUNT(CASE WHEN A.BKG_IO_BND_CD ='I' THEN 1 ELSE NULL END) AS IB_CNT" ).append("\n"); 
		query.append("	    , COUNT(CASE WHEN A.BKG_IO_BND_CD ='O' THEN 1 ELSE NULL END) AS OB_CNT" ).append("\n"); 
		query.append("		, COUNT(A.RHQ_CD) AS TOT_CNT" ).append("\n"); 
		query.append("FROM SAR_OTS_HDR A" ).append("\n"); 
		query.append("WHERE 1 = 1" ).append("\n"); 
		query.append("#if(${stl_flg} != '')" ).append("\n"); 
		query.append("AND A.STL_FLG = @[stl_flg]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if(${cr_mk_flg} != '')" ).append("\n"); 
		query.append("AND A.CR_MK_FLG = @[cr_mk_flg]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if(${ots_grp_tp_cd} != '')" ).append("\n"); 
		query.append("AND A.OTS_GRP_TP_CD = @[ots_grp_tp_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if(${bl_sum_tp} == 'OTS')" ).append("\n"); 
		query.append("AND EXISTS (SELECT 1 " ).append("\n"); 
		query.append("              FROM SAR_OTS_DTL                      " ).append("\n"); 
		query.append("            WHERE 1 = 1" ).append("\n"); 
		query.append("            AND RHQ_CD = A.RHQ_CD" ).append("\n"); 
		query.append("            AND OTS_OFC_CD = A.OTS_OFC_CD" ).append("\n"); 
		query.append("            AND BL_NO = A.BL_NO" ).append("\n"); 
		query.append("            AND INV_NO = A.INV_NO" ).append("\n"); 
		query.append("            AND BAL_AMT > 0)" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#elseif(${bl_sum_tp} == 'OPY')" ).append("\n"); 
		query.append("AND EXISTS (SELECT 1 " ).append("\n"); 
		query.append("              FROM SAR_OTS_DTL                      " ).append("\n"); 
		query.append("            WHERE 1 = 1" ).append("\n"); 
		query.append("            AND RHQ_CD = A.RHQ_CD" ).append("\n"); 
		query.append("            AND OTS_OFC_CD = A.OTS_OFC_CD" ).append("\n"); 
		query.append("            AND BL_NO = A.BL_NO" ).append("\n"); 
		query.append("            AND INV_NO = A.INV_NO" ).append("\n"); 
		query.append("            AND BAL_AMT < 0)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if(${bl_inv_tp} == 'INV')" ).append("\n"); 
		query.append("AND A.INV_NO <> '**********'" ).append("\n"); 
		query.append("#elseif(${bl_inv_tp} == 'BL')" ).append("\n"); 
		query.append("AND A.INV_NO = '**********'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
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
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if(${clt_ofc_cd} != '')" ).append("\n"); 
		query.append("AND A.CLT_OFC_CD IN (${clt_ofc_cd})" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if(${due_tp} == 'BAD_OTS')" ).append("\n"); 
		query.append("AND 1 = 1" ).append("\n"); 
		query.append("#elseif(${due_tp} == 'WI_TERM_OTS')" ).append("\n"); 
		query.append("AND A.DUE_DT >= @[due_dt]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if(${sail_arr_dt} != '')" ).append("\n"); 
		query.append("AND A.SAIL_ARR_DT >= @[sail_arr_dt]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if(${ots_rt_flg} != '')" ).append("\n"); 
		query.append("AND A.OTS_RT_FLG = @[ots_rt_flg]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if(${bil_to_cust_cnt_cd} != '')" ).append("\n"); 
		query.append("AND A.BIL_TO_CUST_CNT_CD = @[bil_to_cust_cnt_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if(${bil_to_cust_seq} != '')" ).append("\n"); 
		query.append("AND A.BIL_TO_CUST_SEQ = @[bil_to_cust_seq]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if(${sum_ofc_cust_tp} == 'OFC' && ${sum_tp} == 'OFC')" ).append("\n"); 
		query.append("GROUP BY " ).append("\n"); 
		query.append("  A.CLT_OFC_CD" ).append("\n"); 
		query.append("#elseif(${sum_ofc_cust_tp} == 'CUST')" ).append("\n"); 
		query.append("GROUP BY" ).append("\n"); 
		query.append("  A.CLT_OFC_CD" ).append("\n"); 
		query.append(", A.BIL_TO_CUST_CNT_CD" ).append("\n"); 
		query.append(", A.BIL_TO_CUST_SEQ" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}