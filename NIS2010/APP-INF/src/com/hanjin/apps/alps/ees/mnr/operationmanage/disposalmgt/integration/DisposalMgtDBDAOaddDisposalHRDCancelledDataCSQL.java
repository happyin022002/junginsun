/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : DisposalMgtDBDAOaddDisposalHRDCancelledDataCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.11.21
*@LastModifier : 
*@LastVersion : 1.0
* 2011.11.21 신혜정
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.mnr.operationmanage.disposalmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 신혜정
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class DisposalMgtDBDAOaddDisposalHRDCancelledDataCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * addDisposalHRDCancelledData
	  * </pre>
	  */
	public DisposalMgtDBDAOaddDisposalHRDCancelledDataCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rcv_inv_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.mnr.operationmanage.disposalmgt.integration").append("\n"); 
		query.append("FileName : DisposalMgtDBDAOaddDisposalHRDCancelledDataCSQL").append("\n"); 
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
		query.append("INSERT INTO MNR_DISP_CXL_HDR(" ).append("\n"); 
		query.append("	DISP_NO" ).append("\n"); 
		query.append("	, CXL_INV_SEQ" ).append("\n"); 
		query.append("	, EQ_KND_CD" ).append("\n"); 
		query.append("	, DISP_TP_CD" ).append("\n"); 
		query.append("	, DISP_STS_CD" ).append("\n"); 
		query.append("	, DISP_ST_DT" ).append("\n"); 
		query.append("	, DISP_END_DT" ).append("\n"); 
		query.append("	, DISP_PKUP_ST_DT" ).append("\n"); 
		query.append("	, DISP_PKUP_END_DT" ).append("\n"); 
		query.append("	, DISP_BULTN_DT" ).append("\n"); 
		query.append("	, CURR_CD" ).append("\n"); 
		query.append("	, DISP_ST_PRC" ).append("\n"); 
		query.append("	, DISP_QTY" ).append("\n"); 
		query.append("	, DISP_EML_FLG" ).append("\n"); 
		query.append("	, RQST_OFC_CD" ).append("\n"); 
		query.append("	, RQST_DT" ).append("\n"); 
		query.append("	, RQST_USR_ID" ).append("\n"); 
		query.append("	, APRO_OFC_CD" ).append("\n"); 
		query.append("	, APRO_DT" ).append("\n"); 
		query.append("	, APRO_USR_ID" ).append("\n"); 
		query.append("	, FILE_SEQ" ).append("\n"); 
		query.append("	, MNR_DISP_RMK" ).append("\n"); 
		query.append("	, MNR_PRNR_CNT_CD" ).append("\n"); 
		query.append("	, MNR_PRNR_SEQ" ).append("\n"); 
		query.append("	, CRE_USR_ID" ).append("\n"); 
		query.append("	, CRE_DT" ).append("\n"); 
		query.append("	, UPD_USR_ID" ).append("\n"); 
		query.append("	, UPD_DT" ).append("\n"); 
		query.append(")(" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("	DISP_NO" ).append("\n"); 
		query.append("	, (SELECT NVL(MAX(B.CXL_INV_SEQ), 0)+1 " ).append("\n"); 
		query.append("		FROM MNR_DISP_CXL_HDR B" ).append("\n"); 
		query.append("		WHERE B.DISP_NO = A.DISP_NO)  " ).append("\n"); 
		query.append("	, EQ_KND_CD" ).append("\n"); 
		query.append("	, DISP_TP_CD" ).append("\n"); 
		query.append("	, DISP_STS_CD" ).append("\n"); 
		query.append("	, DISP_ST_DT" ).append("\n"); 
		query.append("	, DISP_END_DT" ).append("\n"); 
		query.append("	, DISP_PKUP_ST_DT" ).append("\n"); 
		query.append("	, DISP_PKUP_END_DT" ).append("\n"); 
		query.append("	, DISP_BULTN_DT" ).append("\n"); 
		query.append("	, CURR_CD" ).append("\n"); 
		query.append("	, DISP_ST_PRC" ).append("\n"); 
		query.append("	, DISP_QTY" ).append("\n"); 
		query.append("	, DISP_EML_FLG" ).append("\n"); 
		query.append("	, RQST_OFC_CD" ).append("\n"); 
		query.append("	, RQST_DT" ).append("\n"); 
		query.append("	, RQST_USR_ID" ).append("\n"); 
		query.append("	, APRO_OFC_CD" ).append("\n"); 
		query.append("	, APRO_DT" ).append("\n"); 
		query.append("	, APRO_USR_ID" ).append("\n"); 
		query.append("	, FILE_SEQ" ).append("\n"); 
		query.append("	, MNR_DISP_RMK" ).append("\n"); 
		query.append("	, MNR_PRNR_CNT_CD" ).append("\n"); 
		query.append("	, MNR_PRNR_SEQ" ).append("\n"); 
		query.append("	, CRE_USR_ID" ).append("\n"); 
		query.append("	, CRE_DT" ).append("\n"); 
		query.append("	, UPD_USR_ID" ).append("\n"); 
		query.append("	, UPD_DT " ).append("\n"); 
		query.append("FROM " ).append("\n"); 
		query.append("    MNR_DISP_HDR A" ).append("\n"); 
		query.append("WHERE" ).append("\n"); 
		query.append("    DISP_NO IN (" ).append("\n"); 
		query.append("        SELECT DISTINCT(DISP_NO) FROM MNR_DISP_DTL WHERE RCV_INV_SEQ = @[rcv_inv_seq] " ).append("\n"); 
		query.append("    )" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}