/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : VesselScheduleMgtDBDAOCreateVslSkdChangeHistoryVvdHisSeqRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.12.12
*@LastModifier : 
*@LastVersion : 1.0
* 2013.12.12 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.vsk.scheduleplanningoperation.vesselschedulemgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class VesselScheduleMgtDBDAOCreateVslSkdChangeHistoryVvdHisSeqRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Vessel Schedule 최초생성시 이력테이블 VVD_HIS_SEQ 추출
	  * </pre>
	  */
	public VesselScheduleMgtDBDAOCreateVslSkdChangeHistoryVvdHisSeqRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.vop.vsk.scheduleplanningoperation.vesselschedulemgt.integration").append("\n"); 
		query.append("FileName : VesselScheduleMgtDBDAOCreateVslSkdChangeHistoryVvdHisSeqRSQL").append("\n"); 
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
		query.append("SELECT	VSK_VSL_SKD_VVD_HIS_SEQ.NEXTVAL	AS NEW_VVD_HIS_SEQ FROM	DUAL" ).append("\n"); 

	}
}