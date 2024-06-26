/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : PartnerDBDAOSearchMdmCustCntcPntRqstRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.03.26
*@LastModifier : 김성욱
*@LastVersion : 1.0
* 2015.03.26 김성욱
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.bcm.ccd.commoncode.partner.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Sung-Wook Kim
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PartnerDBDAOSearchMdmCustCntcPntRqstRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * DESC Enter..
	  * </pre>
	  */
	public PartnerDBDAOSearchMdmCustCntcPntRqstRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rqst_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.bcm.ccd.commoncode.partner.integration").append("\n"); 
		query.append("FileName : PartnerDBDAOSearchMdmCustCntcPntRqstRSQL").append("\n"); 
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
		query.append("       CUST_CNT_CD," ).append("\n"); 
		query.append("       CUST_SEQ," ).append("\n"); 
		query.append("       CUST_CNTC_PNT_SEQ," ).append("\n"); 
		query.append("       CUST_EML," ).append("\n"); 
		query.append("       CUST_IP," ).append("\n"); 
		query.append("       CUST_URL," ).append("\n"); 
		query.append("       INTL_PHN_NO," ).append("\n"); 
		query.append("       PHN_NO," ).append("\n"); 
		query.append("       INTL_FAX_NO," ).append("\n"); 
		query.append("       FAX_NO," ).append("\n"); 
		query.append("       EAI_EVNT_DT," ).append("\n"); 
		query.append("       EAI_IF_ID," ).append("\n"); 
		query.append("	   PRMRY_CHK_FLG," ).append("\n"); 
		query.append("	   PAY_RQST_LTR_FLG" ).append("\n"); 
		query.append("  FROM MDM_CUST_CNTC_PNT_RQST" ).append("\n"); 
		query.append(" WHERE RQST_NO = @[rqst_no]" ).append("\n"); 

	}
}