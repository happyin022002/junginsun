/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : CustomerSpaceGuaranteeDBDAOSearchCustomerSpaceGuaranteeConvLaneListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.02.03
*@LastModifier : 최윤성
*@LastVersion : 1.0
* 2010.02.03 최윤성
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.spc.modelconstraintmanage.customerspaceguarantee.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author CHOI Yun Sung
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CustomerSpaceGuaranteeDBDAOSearchCustomerSpaceGuaranteeConvLaneListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Lane, 선사별 예외조건 조회
	  * </pre>
	  */
	public CustomerSpaceGuaranteeDBDAOSearchCustomerSpaceGuaranteeConvLaneListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.spc.modelconstraintmanage.customerspaceguarantee.integration").append("\n"); 
		query.append("FileName : CustomerSpaceGuaranteeDBDAOSearchCustomerSpaceGuaranteeConvLaneListRSQL").append("\n"); 
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
		query.append("  SELECT A.RLANE_CD                ," ).append("\n"); 
		query.append("         A.DIR_CD                  ," ).append("\n"); 
		query.append("         A.CRR_CD                  ," ).append("\n"); 
		query.append("         A.TEU_20FT_CONV_RTO       ," ).append("\n"); 
		query.append("         A.TEU_40FT_CONV_RTO       ," ).append("\n"); 
		query.append("         A.TEU_40FT_HC_CONV_RTO    ," ).append("\n"); 
		query.append("         A.TEU_45FT_HC_CONV_RTO    ," ).append("\n"); 
		query.append("         A.OVR_TEU_20FT_CONV_RTO   ," ).append("\n"); 
		query.append("         A.OVR_TEU_40FT_CONV_RTO   ," ).append("\n"); 
		query.append("         A.OVR_TEU_40FT_HC_CONV_RTO," ).append("\n"); 
		query.append("         A.OVR_TEU_45FT_HC_CONV_RTO" ).append("\n"); 
		query.append("    FROM SAQ_CNTR_SZ_CONV_LANE A" ).append("\n"); 
		query.append("ORDER BY A.RLANE_CD," ).append("\n"); 
		query.append("         A.DIR_CD  ," ).append("\n"); 
		query.append("         A.CRR_CD" ).append("\n"); 

	}
}