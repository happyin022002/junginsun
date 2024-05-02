/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : DisposalMgtDBDAOsearchDisposalDetailInquiryListDataRSQL.java
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

public class DisposalMgtDBDAOsearchDisposalDetailInquiryListDataRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * DisposalMgtDBDAOsearchDisposalDetailInquiryListDataRSQL
	  * </pre>
	  */
	public DisposalMgtDBDAOsearchDisposalDetailInquiryListDataRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inv_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.mnr.operationmanage.disposalmgt.integration").append("\n"); 
		query.append("FileName : DisposalMgtDBDAOsearchDisposalDetailInquiryListDataRSQL").append("\n"); 
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
		query.append("     B.DISP_NO" ).append("\n"); 
		query.append("    ,B.EQ_NO" ).append("\n"); 
		query.append("    ,B.EQ_TPSZ_CD" ).append("\n"); 
		query.append("    ,B.DISP_RLSE_NO" ).append("\n"); 
		query.append("    ,C.CURR_CD" ).append("\n"); 
		query.append("    ,B.INV_AMT" ).append("\n"); 
		query.append("    ,TO_CHAR(C.RQST_DT, 'yyyy-mm-dd') AS RQST_DT     " ).append("\n"); 
		query.append("    ,TO_CHAR(B.DISP_SOLD_DT, 'yyyy-mm-dd') AS DISP_SOLD_DT      " ).append("\n"); 
		query.append("    ,TO_CHAR(A.INV_DUE_DT, 'yyyy-mm-dd') AS INV_DUE_DT  " ).append("\n"); 
		query.append("    ,B.MNR_DISP_DTL_RMK" ).append("\n"); 
		query.append("	,F.DP_PRCS_KNT" ).append("\n"); 
		query.append("    ,B.CHG_CD " ).append("\n"); 
		query.append("FROM MNR_RCV_INV_WRK A, MNR_DISP_HDR C,  MNR_DISP_DTL B, MDM_CURRENCY F" ).append("\n"); 
		query.append("WHERE C.DISP_NO= B.DISP_NO" ).append("\n"); 
		query.append("AND A.INV_NO = @[inv_no]" ).append("\n"); 
		query.append("AND A.RCV_INV_SEQ = B.RCV_INV_SEQ" ).append("\n"); 
		query.append("AND C.DISP_NO = B.DISP_NO" ).append("\n"); 
		query.append("AND C.CURR_CD = F.CURR_CD" ).append("\n"); 

	}
}