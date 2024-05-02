/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : TCharterIOConsultationDBDAOCondSearchSlipApprovalVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.21
*@LastModifier : 윤세영
*@LastVersion : 1.0
* 2009.08.21 윤세영
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioconsultation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Yoon, Seyeong
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TCharterIOConsultationDBDAOCondSearchSlipApprovalVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  *    
	  * </pre>
	  */
	public TCharterIOConsultationDBDAOCondSearchSlipApprovalVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioconsultation.integration").append("\n"); 
		query.append("FileName : TCharterIOConsultationDBDAOCondSearchSlipApprovalVORSQL").append("\n"); 
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
		query.append("'' FROM_CRE_DT" ).append("\n"); 
		query.append(",'' CSR_NO" ).append("\n"); 
		query.append(",'' VSL_CD" ).append("\n"); 
		query.append(",'' TO_EFF_DT" ).append("\n"); 
		query.append(",'' FROM_EFF_DT" ).append("\n"); 
		query.append(",'' TO_CRE_DT" ).append("\n"); 
		query.append(",'' SLIP_APRO_FLG" ).append("\n"); 
		query.append(",'' VAT_SLP_TP_CD" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 

	}
}