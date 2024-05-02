/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : DisposalMgtDBDAOsearchDSPConfirmMailListDataRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.05.24
*@LastModifier : 박명신
*@LastVersion : 1.0
* 2010.05.24 박명신
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.mnr.operationmanage.disposalmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author park myoung sin
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class DisposalMgtDBDAOsearchDSPConfirmMailListDataRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchDSPConfirmMailListData
	  * </pre>
	  */
	public DisposalMgtDBDAOsearchDSPConfirmMailListDataRSQL(){
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
		params.put("rqst_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mnr_prnr_eml",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.mnr.operationmanage.disposalmgt.integration").append("\n"); 
		query.append("FileName : DisposalMgtDBDAOsearchDSPConfirmMailListDataRSQL").append("\n"); 
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
		query.append("SELECT  NVL(B.MNR_PRNR_EML, A.MNR_PRNR_EML) AS RECIPIENT," ).append("\n"); 
		query.append("'Disposal Confirm Notice [' || @[disp_no] || ']  - ' ||  TO_CHAR(sysdate, 'yyyy.mm.dd hh:mm') AS SUBJECT," ).append("\n"); 
		query.append("'Disposal Confirm Notice [' || @[disp_no] || ']  - ' ||  TO_CHAR(sysdate, 'yyyy.mm.dd hh:mm') AS TEXTCONTENT," ).append("\n"); 
		query.append("@[mnr_prnr_eml] AS SENDER" ).append("\n"); 
		query.append("FROM MNR_PARTNER A, MNR_PRNR_CNTC_PNT B" ).append("\n"); 
		query.append("WHERE A.MNR_GRP_TP_CD = 'DSP'" ).append("\n"); 
		query.append("AND  (A.MNR_PRNR_CNT_CD, A.MNR_PRNR_SEQ) IN" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT MNR_PRNR_CNT_CD,MNR_PRNR_SEQ FROM MNR_DISP_BUYR_DTL_PART" ).append("\n"); 
		query.append("WHERE MNR_DISP_CFM_STS_CD <> 'N' AND DISP_NO = @[disp_no]" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("AND   A.MNR_PRNR_CRE_SEQ  = B.MNR_PRNR_CRE_SEQ(+)" ).append("\n"); 
		query.append("AND   B.OFC_CD = @[rqst_ofc_cd]" ).append("\n"); 
		query.append("AND (B.MNR_PRNR_EML IS NOT NULL OR A.MNR_PRNR_EML IS NOT NULL)" ).append("\n"); 

	}
}