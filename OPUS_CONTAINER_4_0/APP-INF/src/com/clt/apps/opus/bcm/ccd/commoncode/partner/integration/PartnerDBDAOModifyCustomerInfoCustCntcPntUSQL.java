/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : PartnerDBDAOModifyCustomerInfoCustCntcPntUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.07.04
*@LastModifier : 
*@LastVersion : 1.0
* 2011.07.04 
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

public class PartnerDBDAOModifyCustomerInfoCustCntcPntUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ModifyCustomerInfoCustCntcPnt
	  * </pre>
	  */
	public PartnerDBDAOModifyCustomerInfoCustCntcPntUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		query.append("Path : com.clt.apps.opus.bcm.ccd.commoncode.partner.integration ").append("\n"); 
		query.append("FileName : PartnerDBDAOModifyCustomerInfoCustCntcPntUSQL").append("\n"); 
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
		query.append("UPDATE MDM_CUST_CNTC_PNT" ).append("\n"); 
		query.append("SET FAX_NO = @[fax_no]" ).append("\n"); 
		query.append("  , INTL_FAX_NO = @[intl_fax_no]" ).append("\n"); 
		query.append("  , CUST_EML = @[cust_eml]" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("WHERE CUST_CNT_CD =SUBSTR(@[cust_cd],1,2)" ).append("\n"); 
		query.append("AND   CUST_SEQ = TO_NUMBER(SUBSTR(@[cust_cd],3,6))" ).append("\n"); 

	}
}