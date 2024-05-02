/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : DisposalMgtDBDAOsearchDisposalDTLListDataRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.05.24
*@LastModifier : 김종옥
*@LastVersion : 1.0
* 2011.05.24 김종옥
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.mnr.operationmanage.disposalmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Kim Jong Ock
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class DisposalMgtDBDAOsearchDisposalDTLListDataRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchDisposalDTLListData
	  * </pre>
	  */
	public DisposalMgtDBDAOsearchDisposalDTLListDataRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("disp_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("disp_ut_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.mnr.operationmanage.disposalmgt.integration").append("\n"); 
		query.append("FileName : DisposalMgtDBDAOsearchDisposalDTLListDataRSQL").append("\n"); 
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
		query.append("A.DISP_NO" ).append("\n"); 
		query.append(",A.DISP_DTL_SEQ" ).append("\n"); 
		query.append(",A.DISP_UT_TP_CD" ).append("\n"); 
		query.append(",A.EQ_NO" ).append("\n"); 
		query.append(",A.EQ_TPSZ_CD" ).append("\n"); 
		query.append(",NVL(" ).append("\n"); 
		query.append("(SELECT MTS.CNTR_TPSZ_DESC FROM MDM_CNTR_TP_SZ MTS WHERE MTS.CNTR_TPSZ_CD = A.EQ_TPSZ_CD AND ROWNUM = 1)" ).append("\n"); 
		query.append(",(SELECT CTS.DIFF_DESC FROM CGM_EQ_TP_SZ CTS WHERE CTS.EQ_TPSZ_CD  = A.EQ_TPSZ_CD AND ROWNUM = 1)" ).append("\n"); 
		query.append(") AS EQ_TPSZ_DESC" ).append("\n"); 
		query.append(",A.DISP_YD_CD" ).append("\n"); 
		query.append(",A.DISP_QTY" ).append("\n"); 
		query.append(",A.DISP_SOLD_DT" ).append("\n"); 
		query.append(",A.DISP_TRKR_NM" ).append("\n"); 
		query.append(",A.DISP_RLSE_NO" ).append("\n"); 
		query.append(",A.DISP_UT_PRC" ).append("\n"); 
		query.append(",A.DISP_RSN_CD" ).append("\n"); 
		query.append(",A.PART_AMT" ).append("\n"); 
		query.append(",A.INV_AMT" ).append("\n"); 
		query.append(",A.FILE_SEQ" ).append("\n"); 
		query.append(",A.RCV_INV_SEQ" ).append("\n"); 
		query.append(",A.MNR_DISP_DTL_RMK" ).append("\n"); 
		query.append(",A.MNR_PRNR_CNT_CD" ).append("\n"); 
		query.append(",A.MNR_PRNR_SEQ" ).append("\n"); 
		query.append(",A.CRE_USR_ID" ).append("\n"); 
		query.append(",A.CRE_DT" ).append("\n"); 
		query.append(",A.UPD_USR_ID" ).append("\n"); 
		query.append(",A.UPD_DT" ).append("\n"); 
		query.append(",B.LSTM_CD" ).append("\n"); 
		query.append(",B.MVMT_CD" ).append("\n"); 
		query.append(",B.MTRL_NM" ).append("\n"); 
		query.append(",B.MKR_NM" ).append("\n"); 
		query.append(",B.MDL_NM" ).append("\n"); 
		query.append(",B.RPR_COST_AMT" ).append("\n"); 
		query.append(",A.DISP_TRF_UT_PRC" ).append("\n"); 
		query.append(",A.DISP_VRFY_TP_CD" ).append("\n"); 
		query.append(",A.INV_NO" ).append("\n"); 
		query.append("FROM MNR_DISP_DTL A,MNR_EQ_STS_V B,MNR_DISP_HDR C" ).append("\n"); 
		query.append("WHERE A.DISP_NO = @[disp_no]" ).append("\n"); 
		query.append("AND   A.DISP_UT_TP_CD = @[disp_ut_tp_cd]" ).append("\n"); 
		query.append("AND   A.EQ_NO = B.EQ_NO(+)" ).append("\n"); 
		query.append("AND   A.DISP_NO = C.DISP_NO" ).append("\n"); 

	}
}