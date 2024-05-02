/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : TCharterIOSettlementDBDAOCustomConsultationVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.25
*@LastModifier : 윤세영
*@LastVersion : 1.0
* 2009.06.25 윤세영
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharteriosettlement.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Yoon, Seyeong
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TCharterIOSettlementDBDAOCustomConsultationVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * CustomConsultationVO
	  * </pre>
	  */
	public TCharterIOSettlementDBDAOCustomConsultationVORSQL(){
		setQuery();
		
		params = new HashMap<String,String[]>();
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
		query.append("'' SLP_TP_CD" ).append("\n"); 
		query.append(",''SLP_FUNC_CD" ).append("\n"); 
		query.append(",''	SLP_OFC_CD" ).append("\n"); 
		query.append(",'' SLP_ISS_DT" ).append("\n"); 
		query.append(",''	SLP_SER_NO" ).append("\n"); 
		query.append(",	'' FLET_CTRT_NO" ).append("\n"); 
		query.append(",	'' CSR_CURR_CD" ).append("\n"); 
		query.append(",	'' CSR_USR_ID" ).append("\n"); 
		query.append(",	'' CSR_DESC" ).append("\n"); 
		query.append(",	'' EFF_DT" ).append("\n"); 
		query.append(",	'' VNDR_SEQ" ).append("\n"); 
		query.append(",	'' CRE_USR_ID" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.nis2010.esm.fms.timecharterinoutaccounting.tcharteriosettlement.integration").append("\n"); 
		query.append("FileName : TCharterIOSettlementDBDAOCustomConsultationVORSQL").append("\n"); 
		query.append("*/").append("\n"); 
	}
}