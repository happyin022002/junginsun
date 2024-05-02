/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : TCharterIOConsultationDBDAOSearchTaxDetailEvidenceListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.03
*@LastModifier : 정윤태
*@LastVersion : 1.0
* 2009.09.03 정윤태
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioconsultation.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author JUNGYOONTAE
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TCharterIOConsultationDBDAOSearchTaxDetailEvidenceListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * TCharterIOConsultationDBDAOSearchTaxDetailEvidenceListRSQL
	  * </pre>
	  */
	public TCharterIOConsultationDBDAOSearchTaxDetailEvidenceListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("csr_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioconsultation.integration ").append("\n"); 
		query.append("FileName : TCharterIOConsultationDBDAOSearchTaxDetailEvidenceListRSQL").append("\n"); 
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
		query.append("SELECT FD.ITM_NM," ).append("\n"); 
		query.append("TO_CHAR(FD.SPL_AMT,'FM999,999,999,999,999,990') SPL_AMT," ).append("\n"); 
		query.append("TO_CHAR(FD.TAX_AMT,'FM999,999,999,999,999,990') TAX_AMT," ).append("\n"); 
		query.append("TO_CHAR(FD.SPL_AMT + FD.TAX_AMT,'FM999,999,999,999,999,990') TOTAL_AMT" ).append("\n"); 
		query.append("FROM FMS_TAX FT, FMS_TAX_DTL FD" ).append("\n"); 
		query.append("WHERE FT.TAX_INV_YRMON = FD.TAX_INV_YRMON" ).append("\n"); 
		query.append("AND FT.OFC_CD = FD.OFC_CD" ).append("\n"); 
		query.append("AND FT.TAX_SER_NO = FD.TAX_SER_NO" ).append("\n"); 
		query.append("AND    FT.SLP_TP_CD" ).append("\n"); 
		query.append("|| FT.SLP_FUNC_CD" ).append("\n"); 
		query.append("|| FT.SLP_OFC_CD" ).append("\n"); 
		query.append("|| FT.SLP_ISS_DT" ).append("\n"); 
		query.append("|| FT.SLP_SER_NO = @[csr_no]" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT FD.ITM_NM," ).append("\n"); 
		query.append("TO_CHAR(FD.SPL_AMT,'FM999,999,999,999,999,990') SPL_AMT," ).append("\n"); 
		query.append("'0' TAX_AMT," ).append("\n"); 
		query.append("TO_CHAR(FD.SPL_AMT,'FM999,999,999,999,999,990') TOTAL_AMT" ).append("\n"); 
		query.append("FROM FMS_BILL FB, FMS_BIL_DTL FD" ).append("\n"); 
		query.append("WHERE FB.BIL_INV_YRMON = FD.BIL_INV_YRMON" ).append("\n"); 
		query.append("AND FB.OFC_CD = FD.OFC_CD" ).append("\n"); 
		query.append("AND FB.BIL_SER_NO = FD.BIL_SER_NO" ).append("\n"); 
		query.append("AND    FB.SLP_TP_CD" ).append("\n"); 
		query.append("|| FB.SLP_FUNC_CD" ).append("\n"); 
		query.append("|| FB.SLP_OFC_CD" ).append("\n"); 
		query.append("|| FB.SLP_ISS_DT" ).append("\n"); 
		query.append("|| FB.SLP_SER_NO = @[csr_no]" ).append("\n"); 

	}
}