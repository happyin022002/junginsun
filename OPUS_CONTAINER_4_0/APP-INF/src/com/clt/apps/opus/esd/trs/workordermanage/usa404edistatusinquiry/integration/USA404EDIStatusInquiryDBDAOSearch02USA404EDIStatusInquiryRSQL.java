/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : USA404EDIStatusInquiryDBDAOSearch02USA404EDIStatusInquiryRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.03.09
*@LastModifier : 최 선
*@LastVersion : 1.0
* 2011.03.09 최 선
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.trs.workordermanage.usa404edistatusinquiry.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Sun, Choi
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class USA404EDIStatusInquiryDBDAOSearch02USA404EDIStatusInquiryRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * search02USA404EDIStatusInquiry SELECT
	  * </pre>
	  */
	public USA404EDIStatusInquiryDBDAOSearch02USA404EDIStatusInquiryRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("trsp_so_ofc_cty_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.trs.workordermanage.usa404edistatusinquiry.integration").append("\n"); 
		query.append("FileName : USA404EDIStatusInquiryDBDAOSearch02USA404EDIStatusInquiryRSQL").append("\n"); 
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
		query.append("A.EQ_NO," ).append("\n"); 
		query.append("A.EQ_TPSZ_CD," ).append("\n"); 
		query.append("A.TRSP_SO_OFC_CTY_CD," ).append("\n"); 
		query.append("A.TRSP_SO_SEQ," ).append("\n"); 
		query.append("ROW_NUMBER() OVER (" ).append("\n"); 
		query.append("PARTITION BY B.TRSP_SO_OFC_CTY_CD, B.TRSP_SO_SEQ, B.EQ_NO, B.EQ_TPSZ_CD, B.MSG_TP_CD, B.SND_TP_CD" ).append("\n"); 
		query.append("ORDER BY B.SND_SEQ ASC" ).append("\n"); 
		query.append(") SND_SEQ," ).append("\n"); 
		query.append("B.MSG_TP_CD," ).append("\n"); 
		query.append("B.SND_TP_CD," ).append("\n"); 
		query.append("B.RLT_TRKR_SEQ," ).append("\n"); 
		query.append("B.RLT_TRKR_NM," ).append("\n"); 
		query.append("B.RLT_TRKR_FAX_NO," ).append("\n"); 
		query.append("B.RLT_TRKR_EML," ).append("\n"); 
		query.append("B.SHPR_CUST_NM," ).append("\n"); 
		query.append("B.SHPR_FAX_NO," ).append("\n"); 
		query.append("B.SHPR_EML," ).append("\n"); 
		query.append("TO_CHAR(B.SND_DT, 'YYYYMMDD') SND_DT," ).append("\n"); 
		query.append("B.SND_OFC_CD," ).append("\n"); 
		query.append("B.SND_USR_ID," ).append("\n"); 
		query.append("DECODE(B.TRSP_SO_SEQ, NULL, '', 'Y') SND_YN" ).append("\n"); 
		query.append("FROM  TRS_TRSP_RAIL_BIL_ORD A," ).append("\n"); 
		query.append("TRS_TRSP_CFM_MSG_HIS  B" ).append("\n"); 
		query.append("WHERE A.TRSP_SO_OFC_CTY_CD = B.TRSP_SO_OFC_CTY_CD(+)" ).append("\n"); 
		query.append("AND   A.TRSP_SO_SEQ        = B.TRSP_SO_SEQ(+)" ).append("\n"); 
		query.append("AND   A.TRSP_SO_OFC_CTY_CD = @[trsp_so_ofc_cty_cd]" ).append("\n"); 
		query.append("AND   A.TRSP_SO_SEQ        = @[trsp_so_seq]" ).append("\n"); 
		query.append("AND   A.DELT_FLG           = 'N'" ).append("\n"); 

	}
}