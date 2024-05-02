/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : CustomerSpaceGuaranteeDBDAOSearchCustomerSpaceGuaranteeConvListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.01.23
*@LastModifier : Arie
*@LastVersion : 1.0
* 2017.01.23 Arie
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.spc.modelconstraintmanage.customerspaceguarantee.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Arie
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CustomerSpaceGuaranteeDBDAOSearchCustomerSpaceGuaranteeConvListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Type Size 별 Conversion
	  * 2017.1.23 SM상선 전환에 따른 소스변경
	  * </pre>
	  */
	public CustomerSpaceGuaranteeDBDAOSearchCustomerSpaceGuaranteeConvListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.spc.modelconstraintmanage.customerspaceguarantee.integration").append("\n"); 
		query.append("FileName : CustomerSpaceGuaranteeDBDAOSearchCustomerSpaceGuaranteeConvListRSQL").append("\n"); 
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
		query.append("SELECT DECODE(A.VSL_OWN_IND_CD, 'O', 'SML', 'Other Operator') AS VSL_OWN_IND_CD," ).append("\n"); 
		query.append("       A.TEU_20FT_CONV_RTO       ," ).append("\n"); 
		query.append("       A.TEU_40FT_CONV_RTO       ," ).append("\n"); 
		query.append("       A.TEU_40FT_HC_CONV_RTO    ," ).append("\n"); 
		query.append("       A.TEU_45FT_HC_CONV_RTO    ," ).append("\n"); 
		query.append("       A.OVR_TEU_20FT_CONV_RTO   ," ).append("\n"); 
		query.append("       A.OVR_TEU_40FT_CONV_RTO   ," ).append("\n"); 
		query.append("       A.OVR_TEU_40FT_HC_CONV_RTO," ).append("\n"); 
		query.append("       A.OVR_TEU_45FT_HC_CONV_RTO" ).append("\n"); 
		query.append("  FROM SAQ_CNTR_SZ_CONV A" ).append("\n"); 

	}
}