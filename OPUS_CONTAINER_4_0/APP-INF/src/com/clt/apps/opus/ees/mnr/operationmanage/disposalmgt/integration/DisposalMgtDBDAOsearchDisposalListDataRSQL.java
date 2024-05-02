/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : DisposalMgtDBDAOsearchDisposalListDataRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.07.12
*@LastModifier : 
*@LastVersion : 1.0
* 2016.07.12 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.mnr.operationmanage.disposalmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class DisposalMgtDBDAOsearchDisposalListDataRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchDisposalListData
	  * </pre>
	  */
	public DisposalMgtDBDAOsearchDisposalListDataRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("self_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("chg_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("in_apro_end_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("in_apro_st_dt",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.mnr.operationmanage.disposalmgt.integration").append("\n"); 
		query.append("FileName : DisposalMgtDBDAOsearchDisposalListDataRSQL").append("\n"); 
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
		query.append("         MAX(A.DISP_NO) DISP_NO" ).append("\n"); 
		query.append("        ,MAX(A.EQ_KND_CD) EQ_KND_CD" ).append("\n"); 
		query.append("        ,MAX(A.DISP_STS_CD) DISP_STS_CD" ).append("\n"); 
		query.append("        ,MAX(A.CURR_CD) CURR_CD" ).append("\n"); 
		query.append("        ,SUM(B.DISP_UT_PRC) DISP_ST_PRC" ).append("\n"); 
		query.append("        ,SUM(B.DISP_QTY) DISP_QTY" ).append("\n"); 
		query.append("        ,MAX(A.DISP_EML_FLG) DISP_EML_FLG" ).append("\n"); 
		query.append("        ,MAX(A.RQST_OFC_CD) RQST_OFC_CD" ).append("\n"); 
		query.append("        ,MAX(TO_CHAR(A.RQST_DT, 'yyyy-mm-dd')) RQST_DT" ).append("\n"); 
		query.append("        ,MAX(A.RQST_USR_ID) RQST_USR_ID" ).append("\n"); 
		query.append("        ,MAX(A.APRO_OFC_CD) APRO_OFC_CD" ).append("\n"); 
		query.append("        ,TO_CHAR(GLOBALDATE_PKG.TIME_CONV_OFC_FNC(MNR_COMMON_PKG.MNR_GET_HOOFC_FNC(),MAX(A.APRO_DT),@[self_ofc_cd]),'YYYY-MM-DD') AS APRO_DT" ).append("\n"); 
		query.append("        ,MAX(A.APRO_USR_ID) APRO_USR_ID" ).append("\n"); 
		query.append("        ,MAX(A.FILE_SEQ) FILE_SEQ" ).append("\n"); 
		query.append("        ,MAX(A.MNR_DISP_RMK) MNR_DISP_RMK" ).append("\n"); 
		query.append("        ,MAX(A.MNR_PRNR_CNT_CD) MNR_PRNR_CNT_CD" ).append("\n"); 
		query.append("        ,MAX(A.MNR_PRNR_SEQ) MNR_PRNR_SEQ" ).append("\n"); 
		query.append("        ,MAX(A.CRE_USR_ID) CRE_USR_ID" ).append("\n"); 
		query.append("        ,TO_CHAR(GLOBALDATE_PKG.TIME_CONV_OFC_FNC(MNR_COMMON_PKG.MNR_GET_HOOFC_FNC(),MAX(A.CRE_DT),@[self_ofc_cd]),'YYYY-MM-DD') AS CRE_DT" ).append("\n"); 
		query.append("        ,MAX(A.UPD_USR_ID) UPD_USR_ID" ).append("\n"); 
		query.append("        ,TO_CHAR(GLOBALDATE_PKG.TIME_CONV_OFC_FNC(MNR_COMMON_PKG.MNR_GET_HOOFC_FNC(),MAX(A.UPD_DT),@[self_ofc_cd]),'YYYY-MM-DD') AS UPD_DT" ).append("\n"); 
		query.append("        ,MAX(B.INV_NO) INV_NO" ).append("\n"); 
		query.append("FROM MNR_DISP_HDR A , MNR_DISP_DTL B" ).append("\n"); 
		query.append("WHERE  1 = 1" ).append("\n"); 
		query.append("	AND  A.DISP_NO = B.DISP_NO" ).append("\n"); 
		query.append("#if (${eq_no_list} != '')	" ).append("\n"); 
		query.append("     AND B.EQ_NO IN (" ).append("\n"); 
		query.append("         #foreach ($user_eq_no IN ${eqNos})" ).append("\n"); 
		query.append("         	#if($velocityCount < $eqNos.size())" ).append("\n"); 
		query.append("            	'$user_eq_no'," ).append("\n"); 
		query.append("            #else" ).append("\n"); 
		query.append("                '$user_eq_no'" ).append("\n"); 
		query.append("            #end" ).append("\n"); 
		query.append("         #end                      " ).append("\n"); 
		query.append("     )" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${inv_no_list} != '')	" ).append("\n"); 
		query.append("     AND B.INV_NO IN (" ).append("\n"); 
		query.append("         #foreach ($user_inv_no IN ${invNos})" ).append("\n"); 
		query.append("         	#if($velocityCount < $invNos.size())" ).append("\n"); 
		query.append("            	'$user_inv_no'," ).append("\n"); 
		query.append("            #else" ).append("\n"); 
		query.append("                '$user_inv_no'" ).append("\n"); 
		query.append("            #end" ).append("\n"); 
		query.append("         #end                      " ).append("\n"); 
		query.append("     )" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${disp_search_type} == 'request')	" ).append("\n"); 
		query.append("AND A.DISP_STS_CD IN ('HS','HJ')" ).append("\n"); 
		query.append("AND A.RQST_OFC_CD = @[self_ofc_cd]" ).append("\n"); 
		query.append("#elseif (${disp_search_type} == 'approval' && ${status_cd} == 'R')	" ).append("\n"); 
		query.append("AND A.DISP_STS_CD IN ('HR')" ).append("\n"); 
		query.append("AND A.APRO_OFC_CD = @[self_ofc_cd]" ).append("\n"); 
		query.append("#elseif (${disp_search_type} == 'approval' && ${status_cd} == 'A')	" ).append("\n"); 
		query.append("AND A.DISP_STS_CD IN ('HC')" ).append("\n"); 
		query.append("AND B.INV_NO IS NULL" ).append("\n"); 
		query.append("AND A.APRO_OFC_CD = @[self_ofc_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${disp_no_list} != '')" ).append("\n"); 
		query.append("        AND     A.DISP_NO IN (" ).append("\n"); 
		query.append("                #foreach ($user_disp_no IN ${dispNos})" ).append("\n"); 
		query.append("                        #if($velocityCount < $dispNos.size())" ).append("\n"); 
		query.append("                                '$user_disp_no'," ).append("\n"); 
		query.append("                        #else" ).append("\n"); 
		query.append("                                '$user_disp_no'" ).append("\n"); 
		query.append("                        #end" ).append("\n"); 
		query.append("                #end                      " ).append("\n"); 
		query.append("        )" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${in_apro_st_dt} != '' && ${in_apro_end_dt} != '')" ).append("\n"); 
		query.append("	#if (${input_date_type_code} == 'R')" ).append("\n"); 
		query.append("	AND RQST_DT BETWEEN TO_DATE(@[in_apro_st_dt], 'yyyy-mm-dd') AND TO_DATE(@[in_apro_end_dt], 'yyyy-mm-dd') + 0.99999" ).append("\n"); 
		query.append("	#elseif (${input_date_type_code} == 'A')	" ).append("\n"); 
		query.append("	AND APRO_DT BETWEEN GLOBALDATE_PKG.TIME_CONV_OFC_FNC(@[self_ofc_cd],TO_DATE(@[in_apro_st_dt],'yyyy-mm-dd'),MNR_COMMON_PKG.MNR_GET_HOOFC_FNC()) AND GLOBALDATE_PKG.TIME_CONV_OFC_FNC(@[self_ofc_cd],TO_DATE(@[in_apro_end_dt],'yyyy-mm-dd') + 0.99999,MNR_COMMON_PKG.MNR_GET_HOOFC_FNC())" ).append("\n"); 
		query.append("	#else" ).append("\n"); 
		query.append("	AND APRO_DT BETWEEN GLOBALDATE_PKG.TIME_CONV_OFC_FNC(@[self_ofc_cd],TO_DATE(@[in_apro_st_dt],'yyyy-mm-dd'),MNR_COMMON_PKG.MNR_GET_HOOFC_FNC()) AND GLOBALDATE_PKG.TIME_CONV_OFC_FNC(@[self_ofc_cd],TO_DATE(@[in_apro_end_dt],'yyyy-mm-dd') + 0.99999,MNR_COMMON_PKG.MNR_GET_HOOFC_FNC())" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${chg_cd} != 'A' && ${chg_cd} != '')" ).append("\n"); 
		query.append("   AND B.CHG_CD = @[chg_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("GROUP BY A.DISP_NO" ).append("\n"); 

	}
}