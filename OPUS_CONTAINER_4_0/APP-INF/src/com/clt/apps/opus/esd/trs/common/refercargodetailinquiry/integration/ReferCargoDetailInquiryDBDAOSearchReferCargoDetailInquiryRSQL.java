/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : ReferCargoDetailInquiryDBDAOSearchReferCargoDetailInquiryRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.03.18
*@LastModifier : 최종혁
*@LastVersion : 1.0
* 2011.03.18 최종혁
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.trs.common.refercargodetailinquiry.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author JH CHOI
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ReferCargoDetailInquiryDBDAOSearchReferCargoDetailInquiryRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Refer Cargo Inquiry 팝업 조회 SQL
	  * </pre>
	  */
	public ReferCargoDetailInquiryDBDAOSearchReferCargoDetailInquiryRSQL(){
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
		query.append("Path : com.clt.apps.opus.esd.trs.common.refercargodetailinquiry.integration").append("\n"); 
		query.append("FileName : ReferCargoDetailInquiryDBDAOSearchReferCargoDetailInquiryRSQL").append("\n"); 
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
		query.append("SELECT NVL(A.CTRL_ATMS_FLG,'N') CTRL_ATMS_FLG   -- NEW_CTRL_ATMS_FLG" ).append("\n"); 
		query.append(",NVL(A.MODI_ATMS_FLG,'N') MODI_ATMS_FLG   -- NEW_MODI_ATMS_FLG" ).append("\n"); 
		query.append(",NVL(A.HUMID_CTRL_FLG,'N') HUMID_CTRL_FLG -- NEW_HUMID_FLG" ).append("\n"); 
		query.append(",A.CMDT_CD  -- CMDT_CD" ).append("\n"); 
		query.append(",B.CMDT_NM  -- CMDT_CDNM" ).append("\n"); 
		query.append(",DECODE(A.CLNG_TP_CD,'S','FRESH','F','FROZEN','C','CHILLED') CLNG_TP_CD -- CGO_NTR_CD" ).append("\n"); 
		query.append(",A.CDO_TEMP -- CDO_TEMP" ).append("\n"); 
		query.append(",A.FDO_TEMP -- FDO_TEMP" ).append("\n"); 
		query.append(",A.HUMID_NO -- RF_HUMID" ).append("\n"); 
		query.append(",A.VENT_RTO -- NEW_VENT_NO" ).append("\n"); 
		query.append(",A.PCK_QTY   -- PCK_QTY" ).append("\n"); 
		query.append(",A.PCK_TP_CD -- PCK_CD" ).append("\n"); 
		query.append(",A.WGT_UT_CD GRS_WGT_TP_CD --GRS_WGT_TP_CD" ).append("\n"); 
		query.append(",A.WGT_UT_CD NET_WGT_TP_CD --NET_WGT_TP_CD" ).append("\n"); 
		query.append(",A.GRS_WGT   -- GRS_WGT" ).append("\n"); 
		query.append(",A.NET_WGT   -- NET_WGT" ).append("\n"); 
		query.append(",DECODE(A.CNTR_DRN_CD,'Y', 'OPEN', 'N', 'CLOSE') CNTR_DRN_CD -- NEW_DRN_CGO_NO" ).append("\n"); 
		query.append(",DECODE(A.PWR_SPL_CBL_FLG,'1','Y','N') PWR_SPL_CBL_FLG       -- MGST_PWR_SPL_CBL_ADD_FLG" ).append("\n"); 
		query.append(",A.VLTG_NO   -- RF_VLTG_PWR" ).append("\n"); 
		query.append(",A.DIFF_RMK  -- RC_RMK" ).append("\n"); 
		query.append("FROM   BKG_RF_CGO    A" ).append("\n"); 
		query.append(",MDM_COMMODITY B" ).append("\n"); 
		query.append("WHERE  A.CMDT_CD = B.CMDT_CD(+)" ).append("\n"); 
		query.append("AND    A.CNTR_DRN_CD IS NOT NULL" ).append("\n"); 
		query.append("AND    A.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${sExsep} == 'E' && ${tro_seq} != '')" ).append("\n"); 
		query.append("AND   A.RC_SEQ = @[tro_seq]" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("AND   A.CNTR_NO  = @[cntr_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}