/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : OnsiteInspectionResultMgtDBDAOUpdateSurveyItemsDeleteFlagUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.08.05
*@LastModifier : 이율규
*@LastVersion : 1.0
* 2015.08.05 이율규
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.mnr.generalmanage.onsiteinspectionresultmgt.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Yulkyu Lee
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class OnsiteInspectionResultMgtDBDAOUpdateSurveyItemsDeleteFlagUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * M&R On-site Inspection Result Item Management 페이지에서 사용자가 삭제 요청한 데이터의 Delete Flag를 Y로 변경
	  * (추후 사용자의 원복 요청에 대비 하기 위한 장치)
	  * </pre>
	  */
	public OnsiteInspectionResultMgtDBDAOUpdateSurveyItemsDeleteFlagUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ev_itm_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.mnr.generalmanage.onsiteinspectionresultmgt.integration ").append("\n"); 
		query.append("FileName : OnsiteInspectionResultMgtDBDAOUpdateSurveyItemsDeleteFlagUSQL").append("\n"); 
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
		query.append("UPDATE MNR_ONSITE_INSP_RSLT_ITM" ).append("\n"); 
		query.append("SET DELT_FLG = 'Y'" ).append("\n"); 
		query.append("WHERE EV_ITM_SEQ = @[ev_itm_seq]" ).append("\n"); 

	}
}