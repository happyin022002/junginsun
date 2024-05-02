/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : CostBatchDBDAOMonitorWaitingStsRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.06.04
*@LastModifier : 
*@LastVersion : 1.0
* 2012.06.04 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.trs.costbatch.costbatch.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CostBatchDBDAOMonitorWaitingStsRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 2012.06.04 변종건 [CHM-201217633] Inland Cost Batch Creation - Batch 취소 기능 추가
	  * </pre>
	  */
	public CostBatchDBDAOMonitorWaitingStsRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.trs.costbatch.costbatch.integration ").append("\n"); 
		query.append("FileName : CostBatchDBDAOMonitorWaitingStsRSQL").append("\n"); 
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
		query.append("SELECT  CASE WHEN COUNT(1) > 0 THEN 'Y' ELSE 'N' END ERR_FLG" ).append("\n"); 
		query.append("FROM    TRS_COST_TRF_BAT" ).append("\n"); 
		query.append("WHERE   COST_TRF_BAT_SEQ IN (${cost_trf_bat_seq_arr})" ).append("\n"); 
		query.append("AND     BAT_PROG_STS_CD <> 'W'" ).append("\n"); 

	}
}