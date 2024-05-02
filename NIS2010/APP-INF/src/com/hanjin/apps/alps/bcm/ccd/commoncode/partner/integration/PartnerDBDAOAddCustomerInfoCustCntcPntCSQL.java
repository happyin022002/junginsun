/*=========================================================
*Copyright(c) 2018 SM Line
*@FileName : PartnerDBDAOAddCustomerInfoCustCntcPntCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2018.04.02
*@LastModifier : 
*@LastVersion : 1.0
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.bcm.ccd.commoncode.partner.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PartnerDBDAOAddCustomerInfoCustCntcPntCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * AddCustomerInfoCustCntcPnt
	  * </pre>
	  */
	public PartnerDBDAOAddCustomerInfoCustCntcPntCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("phn_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_eml",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("intl_phn_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fax_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("intl_fax_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.bcm.ccd.commoncode.partner.integration").append("\n"); 
		query.append("FileName : PartnerDBDAOAddCustomerInfoCustCntcPntCSQL").append("\n"); 
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
		query.append("INSERT INTO MDM_CUST_CNTC_PNT" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("CUST_CNT_CD," ).append("\n"); 
		query.append("CUST_SEQ," ).append("\n"); 
		query.append("CUST_CNTC_PNT_SEQ," ).append("\n"); 
		query.append("CUST_EML," ).append("\n"); 
		query.append("INTL_PHN_NO," ).append("\n"); 
		query.append("PHN_NO," ).append("\n"); 
		query.append("INTL_FAX_NO," ).append("\n"); 
		query.append("FAX_NO" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("VALUES" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SUBSTR(@[cust_cd],1,2)," ).append("\n"); 
		query.append("TO_NUMBER(SUBSTR(@[cust_cd],3,6))," ).append("\n"); 
		query.append("(SELECT NVL(MAX(CUST_CNTC_PNT_SEQ)+1, 1)" ).append("\n"); 
		query.append(" FROM MDM_CUST_CNTC_PNT" ).append("\n"); 
		query.append(" WHERE CUST_CNT_CD = SUBSTR(@[cust_cd],1,2)" ).append("\n"); 
		query.append(" AND CUST_SEQ = TO_NUMBER(SUBSTR(@[cust_cd],3,6)))," ).append("\n"); 
		query.append("@[cust_eml]," ).append("\n"); 
		query.append("@[intl_phn_no]," ).append("\n"); 
		query.append("@[phn_no]," ).append("\n"); 
		query.append("@[intl_fax_no]," ).append("\n"); 
		query.append("@[fax_no]" ).append("\n"); 
		query.append(") " ).append("\n"); 

	}
}