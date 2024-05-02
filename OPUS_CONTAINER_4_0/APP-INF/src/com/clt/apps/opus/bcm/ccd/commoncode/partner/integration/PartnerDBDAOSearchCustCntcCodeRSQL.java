/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : PartnerDBDAOSearchCustCntcCodeRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.12.22
*@LastModifier : 
*@LastVersion : 1.0
* 2015.12.22 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.bcm.ccd.commoncode.partner.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PartnerDBDAOSearchCustCntcCodeRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Customer Contact Point Code Creation 정보 조회
	  * </pre>
	  */
	public PartnerDBDAOSearchCustCntcCodeRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.bcm.ccd.commoncode.partner.integration").append("\n"); 
		query.append("FileName : PartnerDBDAOSearchCustCntcCodeRSQL").append("\n"); 
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
		query.append("	   CUST_CNT_CD" ).append("\n"); 
		query.append("	,  TRIM(TO_CHAR(CUST_SEQ,'000000')) CUST_SEQ " ).append("\n"); 
		query.append("	,  CUST_CNTC_PNT_SEQ" ).append("\n"); 
		query.append("	,  CUST_EML" ).append("\n"); 
		query.append("	,  CUST_IP" ).append("\n"); 
		query.append("	,  CUST_URL" ).append("\n"); 
		query.append("	,  INTL_PHN_NO" ).append("\n"); 
		query.append("	,  PHN_NO" ).append("\n"); 
		query.append("	,  INTL_FAX_NO" ).append("\n"); 
		query.append("	,  FAX_NO" ).append("\n"); 
		query.append("	,  EAI_EVNT_DT" ).append("\n"); 
		query.append("	,  EAI_IF_ID" ).append("\n"); 
		query.append("	,  PRMRY_CHK_FLG" ).append("\n"); 
		query.append("	,  NVL(PAY_RQST_LTR_FLG, 'N') PAY_RQST_LTR_FLG" ).append("\n"); 
		query.append("    ,  CRE_USR_ID" ).append("\n"); 
		query.append("    ,  CRE_DT" ).append("\n"); 
		query.append("    ,  UPD_USR_ID" ).append("\n"); 
		query.append("    ,  UPD_DT" ).append("\n"); 
		query.append("FROM MDM_CUST_CNTC_PNT" ).append("\n"); 
		query.append("WHERE  CUST_CNT_CD =@[cust_cnt_cd]" ).append("\n"); 
		query.append("AND CUST_SEQ = @[cust_seq]" ).append("\n"); 

	}
}