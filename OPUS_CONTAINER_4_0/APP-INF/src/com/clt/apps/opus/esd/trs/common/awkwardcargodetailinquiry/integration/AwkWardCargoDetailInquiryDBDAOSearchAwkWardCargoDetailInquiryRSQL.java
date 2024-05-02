/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : AwkWardCargoDetailInquiryDBDAOSearchAwkWardCargoDetailInquiryRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.11
*@LastModifier : 최종혁
*@LastVersion : 1.0
* 2009.11.11 최종혁
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.trs.common.awkwardcargodetailinquiry.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author JH CHOI
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AwkWardCargoDetailInquiryDBDAOSearchAwkWardCargoDetailInquiryRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * AwkWard Cargo Inquiry 팝업 조회 SQL
	  * </pre>
	  */
	public AwkWardCargoDetailInquiryDBDAOSearchAwkWardCargoDetailInquiryRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("tro_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.trs.common.awkwardcargodetailinquiry.integration").append("\n"); 
		query.append("FileName : AwkWardCargoDetailInquiryDBDAOSearchAwkWardCargoDetailInquiryRSQL").append("\n"); 
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
		query.append("SELECT A.PCK_TP_CD        -- PCK_TP_CD" ).append("\n"); 
		query.append(",A.PCK_QTY          -- PCK_QTY" ).append("\n"); 
		query.append(",A.WGT_UT_CD  GRS_WGT_TP_CD      -- GRS_WGT_TP_CD" ).append("\n"); 
		query.append(",A.WGT_UT_CD	NET_WGT_TP_CD	  -- NET_WGT_TP_CD" ).append("\n"); 
		query.append(",A.GRS_WGT          -- GRS_WGT" ).append("\n"); 
		query.append(",A.NET_WGT          -- NET_WGT" ).append("\n"); 
		query.append(",A.CMDT_CD          -- CMDT_CD" ).append("\n"); 
		query.append(",B.CMDT_NM          -- CMDT_NM" ).append("\n"); 
		query.append(",A.TTL_DIM_LEN      -- TTL_DIM_LEN" ).append("\n"); 
		query.append(",A.TTL_DIM_WDT      -- TTL_DIM_WDT" ).append("\n"); 
		query.append(",A.TTL_DIM_HGT      -- TTL_DIM_HGT" ).append("\n"); 
		query.append(",A.OVR_FWRD_LEN     -- FWRD_OVR_LEN" ).append("\n"); 
		query.append(",A.OVR_BKWD_LEN     -- BKWD_OVR_LEN" ).append("\n"); 
		query.append(",A.OVR_HGT          -- OVR_HGT" ).append("\n"); 
		query.append(",A.OVR_LF_LEN       -- OVR_PORT_NO" ).append("\n"); 
		query.append(",A.OVR_RT_LEN       -- OVR_SD_NO" ).append("\n"); 
		query.append(",A.STWG_RQST_DESC   -- STWG_INSTR_DESC" ).append("\n"); 
		query.append(",A.OVR_VOID_SLT_QTY -- OVR_VOID_SLT_NO" ).append("\n"); 
		query.append(",A.DIFF_RMK -- AWK_CGO_RMK" ).append("\n"); 
		query.append("FROM   BKG_AWK_CGO A" ).append("\n"); 
		query.append(",MDM_COMMODITY B" ).append("\n"); 
		query.append("WHERE A.CMDT_CD = B.CMDT_CD(+)" ).append("\n"); 
		query.append("AND   A.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${sExsep} == 'E' && ${tro_seq} != '')" ).append("\n"); 
		query.append("AND   A.AWK_CGO_SEQ = @[tro_seq]" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("AND   A.CNTR_NO  = @[cntr_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}