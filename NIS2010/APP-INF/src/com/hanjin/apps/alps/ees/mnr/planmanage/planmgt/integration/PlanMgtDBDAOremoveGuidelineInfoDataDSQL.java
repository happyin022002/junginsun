/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : PlanMgtDBDAOremoveGuidelineInfoDataDSQL.java
*@FileTitle : M&R Guideline & Information
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.08
*@LastModifier : 이주현
*@LastVersion : 1.0
* 2009.06.08 이주현
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.mnr.planmanage.planmgt.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author LEE JU HYUN
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PlanMgtDBDAOremoveGuidelineInfoDataDSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * MNR Guideline 정보를 삭제한다.
	  * </pre>
	  */
	public PlanMgtDBDAOremoveGuidelineInfoDataDSQL(){
		setQuery();
		
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mnr_gline_seq",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("DELETE FROM MNR_GUIDELINE A" ).append("\n"); 
		query.append("WHERE MNR_GLINE_SEQ = @[mnr_gline_seq]" ).append("\n"); 

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.mnr.planmanage.planmgt.integration ").append("\n"); 
		query.append("FileName : PlanMgtDBDAOremoveGuidelineInfoDataDSQL").append("\n"); 
		query.append("*/").append("\n"); 
	}
}