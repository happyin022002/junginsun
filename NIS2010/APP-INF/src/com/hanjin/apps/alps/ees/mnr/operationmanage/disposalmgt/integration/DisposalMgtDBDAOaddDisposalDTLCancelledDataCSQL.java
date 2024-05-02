/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : DisposalMgtDBDAOaddDisposalDTLCancelledDataCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.11.23
*@LastModifier : 
*@LastVersion : 1.0
* 2011.11.23 신혜정
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

public class DisposalMgtDBDAOaddDisposalDTLCancelledDataCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * addDisposalDTLCancelledData
	  * </pre>
	  */
	public DisposalMgtDBDAOaddDisposalDTLCancelledDataCSQL(){
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
		query.append("FileName : DisposalMgtDBDAOaddDisposalDTLCancelledDataCSQL").append("\n"); 
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
		query.append("INSERT INTO MNR_DISP_CXL_DTL(" ).append("\n"); 
		query.append("	DISP_NO          " ).append("\n"); 
		query.append("	, CXL_INV_SEQ" ).append("\n"); 
		query.append("	, DISP_DTL_SEQ" ).append("\n"); 
		query.append("	, DISP_UT_TP_CD" ).append("\n"); 
		query.append("	, EQ_NO" ).append("\n"); 
		query.append("	, EQ_TPSZ_CD" ).append("\n"); 
		query.append("	, DISP_YD_CD" ).append("\n"); 
		query.append("	, DISP_QTY" ).append("\n"); 
		query.append("	, DISP_SOLD_DT" ).append("\n"); 
		query.append("	, DISP_TRKR_NM" ).append("\n"); 
		query.append("	, DISP_RLSE_NO" ).append("\n"); 
		query.append("	, DISP_UT_PRC" ).append("\n"); 
		query.append("	, DISP_RSN_CD" ).append("\n"); 
		query.append("	, PART_AMT" ).append("\n"); 
		query.append("	, INV_AMT" ).append("\n"); 
		query.append("	, FILE_SEQ" ).append("\n"); 
		query.append("	, INV_NO" ).append("\n"); 
		query.append("	, RCV_INV_SEQ" ).append("\n"); 
		query.append("	, MNR_DISP_DTL_RMK" ).append("\n"); 
		query.append("	, MNR_PRNR_CNT_CD" ).append("\n"); 
		query.append("	, MNR_PRNR_SEQ" ).append("\n"); 
		query.append("	, DISP_TRF_UT_PRC" ).append("\n"); 
		query.append("	, DISP_VRFY_TP_CD" ).append("\n"); 
		query.append("	, NIS_PRNR_CNT_CD" ).append("\n"); 
		query.append("	, NIS_PRNR_VNDR_SEQ" ).append("\n"); 
		query.append("	, NIS_PRNR_VNDR_ABBR_NM" ).append("\n"); 
		query.append("	, CRE_USR_ID" ).append("\n"); 
		query.append("	, CRE_DT" ).append("\n"); 
		query.append("	, UPD_USR_ID" ).append("\n"); 
		query.append("	, UPD_DT" ).append("\n"); 
		query.append(")(" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("	DISP_NO          " ).append("\n"); 
		query.append("	, (SELECT NVL(MAX(B.CXL_INV_SEQ), 0)+1 " ).append("\n"); 
		query.append("		FROM MNR_DISP_CXL_DTL B" ).append("\n"); 
		query.append("		WHERE B.DISP_NO = A.DISP_NO" ).append("\n"); 
		query.append("		      AND B.DISP_DTL_SEQ = A.DISP_DTL_SEQ)" ).append("\n"); 
		query.append("	, DISP_DTL_SEQ" ).append("\n"); 
		query.append("	, DISP_UT_TP_CD" ).append("\n"); 
		query.append("	, EQ_NO" ).append("\n"); 
		query.append("	, EQ_TPSZ_CD" ).append("\n"); 
		query.append("	, DISP_YD_CD" ).append("\n"); 
		query.append("	, DISP_QTY" ).append("\n"); 
		query.append("	, DISP_SOLD_DT" ).append("\n"); 
		query.append("	, DISP_TRKR_NM" ).append("\n"); 
		query.append("	, DISP_RLSE_NO" ).append("\n"); 
		query.append("	, DISP_UT_PRC" ).append("\n"); 
		query.append("	, DISP_RSN_CD" ).append("\n"); 
		query.append("	, PART_AMT" ).append("\n"); 
		query.append("	, INV_AMT" ).append("\n"); 
		query.append("	, FILE_SEQ" ).append("\n"); 
		query.append("	, INV_NO" ).append("\n"); 
		query.append("	, RCV_INV_SEQ" ).append("\n"); 
		query.append("	, MNR_DISP_DTL_RMK" ).append("\n"); 
		query.append("	, MNR_PRNR_CNT_CD" ).append("\n"); 
		query.append("	, MNR_PRNR_SEQ" ).append("\n"); 
		query.append("	, DISP_TRF_UT_PRC" ).append("\n"); 
		query.append("	, DISP_VRFY_TP_CD" ).append("\n"); 
		query.append("	, NIS_PRNR_CNT_CD" ).append("\n"); 
		query.append("	, NIS_PRNR_VNDR_SEQ" ).append("\n"); 
		query.append("	, NIS_PRNR_VNDR_ABBR_NM" ).append("\n"); 
		query.append("	, CRE_USR_ID" ).append("\n"); 
		query.append("	, CRE_DT" ).append("\n"); 
		query.append("	, UPD_USR_ID" ).append("\n"); 
		query.append("	, UPD_DT" ).append("\n"); 
		query.append("FROM " ).append("\n"); 
		query.append("    MNR_DISP_DTL A" ).append("\n"); 
		query.append("WHERE" ).append("\n"); 
		query.append("    RCV_INV_SEQ = @[rcv_inv_seq]" ).append("\n"); 
		query.append(")    " ).append("\n"); 

	}
}