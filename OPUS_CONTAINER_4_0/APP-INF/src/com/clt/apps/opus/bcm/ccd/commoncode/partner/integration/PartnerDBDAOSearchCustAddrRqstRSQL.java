/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : PartnerDBDAOSearchCustAddrRqstRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.11.26
*@LastModifier : 
*@LastVersion : 1.0
* 2014.11.26 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.bcm.ccd.commoncode.partner.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PartnerDBDAOSearchCustAddrRqstRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * MDM_CUST_ADDR_RQST 테이블정보를 가져온다.
	  * </pre>
	  */
	public PartnerDBDAOSearchCustAddrRqstRSQL(){
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
		query.append("Path : com.clt.apps.opus.bcm.ccd.commoncode.partner.integration ").append("\n"); 
		query.append("FileName : PartnerDBDAOSearchCustAddrRqstRSQL").append("\n"); 
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
		query.append("SELECT  CUST_CNT_CD" ).append("\n"); 
		query.append("       ,CUST_SEQ" ).append("\n"); 
		query.append("       ,ADDR_TP_CD" ).append("\n"); 
		query.append("       ,ADDR_SEQ" ).append("\n"); 
		query.append("       ,PRMRY_CHK_FLG" ).append("\n"); 
		query.append("       ,BZET_NM" ).append("\n"); 
		query.append("       ,BZET_ADDR" ).append("\n"); 
		query.append("       ,CTY_NM" ).append("\n"); 
		query.append("       ,STE_CD" ).append("\n"); 
		query.append("       ,ZIP_CD" ).append("\n"); 
		query.append("       ,CNTC_EML" ).append("\n"); 
		query.append("       ,CNTC_PSON_NM" ).append("\n"); 
		query.append("       ,BZET_RMK" ).append("\n"); 
		query.append("       ,CRE_USR_ID" ).append("\n"); 
		query.append("       ,CRE_DT" ).append("\n"); 
		query.append("       ,UPD_USR_ID" ).append("\n"); 
		query.append("       ,UPD_DT" ).append("\n"); 
		query.append("       ,DELT_FLG" ).append("\n"); 
		query.append("       ,EAI_EVNT_DT" ).append("\n"); 
		query.append("       ,CRM_ROW_ID" ).append("\n"); 
		query.append("       ,LOCL_ADDR1" ).append("\n"); 
		query.append("       ,LOCL_ADDR2" ).append("\n"); 
		query.append("       ,LOCL_ADDR3" ).append("\n"); 
		query.append("       ,LOCL_ADDR4" ).append("\n"); 
		query.append("       ,CNT_CD" ).append("\n"); 
		query.append("       ,EAI_IF_ID" ).append("\n"); 
		query.append("FROM   MDM_CUST_ADDR_RQST" ).append("\n"); 
		query.append("WHERE  RQST_NO = @[rqst_no]" ).append("\n"); 

	}
}