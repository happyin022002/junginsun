/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : USA404EDIStatusInquiryDBDAOsearchUSRailBasicRatesRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.08.21
*@LastModifier : 김성욱
*@LastVersion : 1.0
* 2015.08.21 김성욱
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.trs.workordermanage.usa404edistatusinquiry.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Sung-Wook Kim
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class USA404EDIStatusInquiryDBDAOsearchUSRailBasicRatesRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchUSRailBasicRates
	  * </pre>
	  */
	public USA404EDIStatusInquiryDBDAOsearchUSRailBasicRatesRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trsp_so_ofc_cty_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trsp_so_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eq_tp_sz_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.trs.workordermanage.usa404edistatusinquiry.integration").append("\n"); 
		query.append("FileName : USA404EDIStatusInquiryDBDAOsearchUSRailBasicRatesRSQL").append("\n"); 
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
		query.append("SELECT A.TRSP_SO_OFC_CTY_CD" ).append("\n"); 
		query.append("      ,A.TRSP_SO_SEQ" ).append("\n"); 
		query.append("      ,A.SUB_RAIL_SEQ" ).append("\n"); 
		query.append("      ,A.VNDR_SEQ" ).append("\n"); 
		query.append("      ,V.VNDR_LGL_ENG_NM AS VNDR_NM" ).append("\n"); 
		query.append("      ,A.TRSP_AGMT_OFC_CTY_CD||A.TRSP_AGMT_SEQ AS AGMT_NO" ).append("\n"); 
		query.append("      ,@[eq_tp_sz_cd] AS EQ_TPSZ_CD" ).append("\n"); 
		query.append("      ,A.CURR_CD" ).append("\n"); 
		query.append("      ,A.BZC_AMT AS TRSP_RT" ).append("\n"); 
		query.append("  FROM TRS_TRSP_RAIL_BIL_VNDR_SET A" ).append("\n"); 
		query.append("      ,MDM_VENDOR V" ).append("\n"); 
		query.append(" WHERE 1=1    " ).append("\n"); 
		query.append("   AND A.TRSP_SO_OFC_CTY_CD = @[trsp_so_ofc_cty_cd]" ).append("\n"); 
		query.append("   AND A.TRSP_SO_SEQ = @[trsp_so_seq]" ).append("\n"); 
		query.append("   AND A.VNDR_SEQ = V.VNDR_SEQ" ).append("\n"); 
		query.append(" ORDER BY A.SUB_RAIL_SEQ" ).append("\n"); 

	}
}