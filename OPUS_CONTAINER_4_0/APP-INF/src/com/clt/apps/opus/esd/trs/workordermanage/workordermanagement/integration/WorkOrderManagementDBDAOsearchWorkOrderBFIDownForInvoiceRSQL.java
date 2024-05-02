/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : WorkOrderManagementDBDAOsearchWorkOrderBFIDownForInvoiceRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.01.05
*@LastModifier : 김성욱
*@LastVersion : 1.0
* 2017.01.05 김성욱
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.trs.workordermanage.workordermanagement.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Sung-Wook Kim
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class WorkOrderManagementDBDAOsearchWorkOrderBFIDownForInvoiceRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchWorkOrderBFIDownForInvoiceRSQL
	  * </pre>
	  */
	public WorkOrderManagementDBDAOsearchWorkOrderBFIDownForInvoiceRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("to_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fm_dt",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.trs.workordermanage.workordermanagement.integration").append("\n"); 
		query.append("FileName : WorkOrderManagementDBDAOsearchWorkOrderBFIDownForInvoiceRSQL").append("\n"); 
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
		query.append("SELECT ROWNUM as SEQ," ).append("\n"); 
		query.append("       S.EQ_NO," ).append("\n"); 
		query.append("       S.EQ_TPSZ_CD," ).append("\n"); 
		query.append("       S.TRSP_SO_OFC_CTY_CD||S.TRSP_SO_SEQ as TRSP_SO_NO," ).append("\n"); 
		query.append("       S.TRSP_WO_OFC_CTY_CD||S.TRSP_WO_SEQ as TRSP_WO_NO," ).append("\n"); 
		query.append("       S.REF_INV_NO as INV_NO," ).append("\n"); 
		query.append("       S.BZC_AMT + NVL (S.FUEL_SCG_AMT, 0) + NVL (S.NEGO_AMT, 0) + NVL (S.ETC_ADD_AMT, 0) AS TOT_INV_AMT" ).append("\n"); 
		query.append("  FROM TRS_TRSP_SVC_ORD S, TRS_TRSP_WRK_ORD W, SCE_COP_HDR SCE" ).append("\n"); 
		query.append(" WHERE S.TRSP_WO_OFC_CTY_CD = W.TRSP_WO_OFC_CTY_CD" ).append("\n"); 
		query.append("   AND S.TRSP_WO_SEQ = W.TRSP_WO_SEQ" ).append("\n"); 
		query.append("   AND S.TRSP_SO_STS_CD = 'I'" ).append("\n"); 
		query.append("   AND S.INV_NO IS NULL" ).append("\n"); 
		query.append("   AND S.TRS_SUB_STS_CD IN ('ST', 'CM') " ).append("\n"); 
		query.append("   AND NVL(S.DELT_FLG,'N') = 'N'" ).append("\n"); 
		query.append("   AND NVL(W.DELT_FLG,'N') = 'N'" ).append("\n"); 
		query.append("   AND S.WO_EXE_DT BETWEEN TO_DATE(@[fm_dt]||'000000','YYYY-MM-DDHH24MISS') AND TO_DATE(@[to_dt]||'235959','YYYY-MM-DDHH24MISS')" ).append("\n"); 
		query.append("#if (${cre_ofc_cd} != '')" ).append("\n"); 
		query.append("   AND W.CRE_OFC_CD = @[cre_ofc_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${vndr_seq} != '')" ).append("\n"); 
		query.append("	#if (${temp_not_sp} == 'N')" ).append("\n"); 
		query.append("		AND	W.WO_VNDR_SEQ IN (" ).append("\n"); 
		query.append("	#else" ).append("\n"); 
		query.append("		AND	W.WO_VNDR_SEQ NOT IN (" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("		#foreach ($user_vndrSeqs IN ${vndrSeqs})" ).append("\n"); 
		query.append("			#if($velocityCount < $vndrSeqs.size())" ).append("\n"); 
		query.append("				'$user_vndrSeqs'," ).append("\n"); 
		query.append("			#else" ).append("\n"); 
		query.append("				'$user_vndrSeqs'" ).append("\n"); 
		query.append("			#end" ).append("\n"); 
		query.append("		#end			  " ).append("\n"); 
		query.append("	)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("   AND S.COP_NO = SCE.COP_NO(+)" ).append("\n"); 
		query.append("   AND SCE.COP_STS_CD(+) IN ('C', 'T', 'F') " ).append("\n"); 
		query.append(" ORDER BY S.EQ_NO,S.EQ_TPSZ_CD,S.TRSP_SO_OFC_CTY_CD||S.TRSP_SO_SEQ, S.TRSP_WO_OFC_CTY_CD||S.TRSP_WO_SEQ" ).append("\n"); 

	}
}