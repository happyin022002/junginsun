/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : BreakBulkCargoDetailInquiryDBDAOSearchBreakBulkCargoDetailInquiryRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.22
*@LastModifier : 
*@LastVersion : 1.0
* 2009.10.22 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.trs.common.breakbulkcargodetailinquiry.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BreakBulkCargoDetailInquiryDBDAOSearchBreakBulkCargoDetailInquiryRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Break Bulk Cargo Inquiry 팝업 조회 SQL
	  * </pre>
	  */
	public BreakBulkCargoDetailInquiryDBDAOSearchBreakBulkCargoDetailInquiryRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sBkg_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.trs.common.breakbulkcargodetailinquiry.integration").append("\n"); 
		query.append("FileName : BreakBulkCargoDetailInquiryDBDAOSearchBreakBulkCargoDetailInquiryRSQL").append("\n"); 
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
		query.append("SELECT  A.PCK_QTY         -- CGO_PCK_QTY" ).append("\n"); 
		query.append(",A.PCK_TP_CD       -- PCK_TP_CD" ).append("\n"); 
		query.append(",A.WGT_UT_CD       -- CGO_TTL_WGT_TP_CD" ).append("\n"); 
		query.append(",A.GRS_WGT         -- CGO_TTL_WGT" ).append("\n"); 
		query.append(",A.GRAV_CTR_DESC   -- CGO_GRAV_CTR_CTNT" ).append("\n"); 
		query.append(",A.CMDT_CD         -- CMDT_CD" ).append("\n"); 
		query.append(",B.CMDT_NM         -- CMDT_CDNM" ).append("\n"); 
		query.append(",A.SLNG_PNT_FLG    -- SLNG_PNT_FLG" ).append("\n"); 
		query.append(",A.PCK_DTL_DESC    -- CGO_PCK_DTL_DESC" ).append("\n"); 
		query.append(",A.DIM_LEN         -- TTL_DIM_LEN" ).append("\n"); 
		query.append(",A.DIM_WDT         -- TTL_DIM_WDT" ).append("\n"); 
		query.append(",A.DIM_HGT         -- TTL_DIM_HGT" ).append("\n"); 
		query.append(",'' VOID_SLT_KNT   -- VOID_SLT_KNT" ).append("\n"); 
		query.append(",A.CGO_LODG_MZD_CD -- LODG_MZD_KND_CD" ).append("\n"); 
		query.append(",'' SHP_CRN_WGT    -- SHP_CRN_WGT" ).append("\n"); 
		query.append(",A.SCR_DNG_CTNT    -- SCR_DNG_DESC" ).append("\n"); 
		query.append(",A.SPCL_RQST_DESC  -- SPCL_RQST_DESC" ).append("\n"); 
		query.append(",'' BRK_CGO_RMK    -- BRK_CGO_RMK" ).append("\n"); 
		query.append("FROM    BKG_BB_CGO    A" ).append("\n"); 
		query.append(",MDM_COMMODITY B" ).append("\n"); 
		query.append("WHERE   A.CMDT_CD = B.CMDT_CD(+)" ).append("\n"); 
		query.append("AND     A.BKG_NO  = @[sBkg_no]" ).append("\n"); 

	}
}