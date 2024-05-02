/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : USA404EDIStatusInquiryDBDAObatchUSA404ComfirmedMessageAutoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.12.24
*@LastModifier : 
*@LastVersion : 1.0
* 2014.12.24 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.trs.workordermanage.usa404edistatusinquiry.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class USA404EDIStatusInquiryDBDAObatchUSA404ComfirmedMessageAutoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * select
	  * </pre>
	  */
	public USA404EDIStatusInquiryDBDAObatchUSA404ComfirmedMessageAutoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trspSoSeq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trspSoOfcCtyCd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.trs.workordermanage.usa404edistatusinquiry.integration").append("\n"); 
		query.append("FileName : USA404EDIStatusInquiryDBDAObatchUSA404ComfirmedMessageAutoRSQL").append("\n"); 
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
		query.append("SELECT " ).append("\n"); 
		query.append("	A.TRSP_SO_OFC_CTY_CD, A.TRSP_SO_SEQ, A.EQ_NO, " ).append("\n"); 
		query.append("	A.EQ_TPSZ_CD, A.PROV_VNDR_SEQ, A.PROV_USR_ID, " ).append("\n"); 
		query.append("	A.PROV_FAX_NO, A.PROV_EML, A.SHPR_CUST_NM, " ).append("\n"); 
		query.append("	A.SHPR_FAX_NO, TO_CHAR(GLOBALDATE_PKG.TIME_LOCAL_OFC_FNC(C.OFC_CD), 'YYYYMMDD HH24:MI:SS') SND_DT, " ).append("\n"); 
		query.append("	C.OFC_CD CRE_OFC_CD, A.CRE_USR_ID, A.PROV_CFM_MZD_CD " ).append("\n"); 
		query.append("FROM TRS_TRSP_RAIL_BIL_ORD A, TRS_TRSP_CFM_MSG_HIS B, MDM_VENDOR C " ).append("\n"); 
		query.append("WHERE A.TRSP_SO_OFC_CTY_CD = @[trspSoOfcCtyCd] " ).append("\n"); 
		query.append("AND A.TRSP_SO_SEQ = @[trspSoSeq] " ).append("\n"); 
		query.append("AND A.TRSP_SO_OFC_CTY_CD   = B.TRSP_SO_OFC_CTY_CD(+) " ).append("\n"); 
		query.append("AND A.TRSP_SO_SEQ          = B.TRSP_SO_SEQ(+) " ).append("\n"); 
		query.append("AND A.PROV_VNDR_SEQ        = C.VNDR_SEQ " ).append("\n"); 
		query.append("AND A.DELT_FLG             = 'N' " ).append("\n"); 
		query.append("GROUP BY A.TRSP_SO_OFC_CTY_CD, A.TRSP_SO_SEQ, A.EQ_NO, A.EQ_TPSZ_CD, A.PROV_VNDR_SEQ, A.PROV_USR_ID, A.PROV_FAX_NO, A.PROV_EML, A.SHPR_CUST_NM, A.SHPR_FAX_NO, C.OFC_CD, A.CRE_USR_ID, A.PROV_CFM_MZD_CD" ).append("\n"); 

	}
}