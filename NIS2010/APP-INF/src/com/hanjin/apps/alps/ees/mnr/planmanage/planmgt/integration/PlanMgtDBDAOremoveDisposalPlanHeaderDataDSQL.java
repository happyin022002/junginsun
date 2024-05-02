/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : PlanMgtDBDAOremoveDisposalPlanHeaderDataDSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.24
*@LastModifier : 김완규
*@LastVersion : 1.0
* 2009.08.24 김완규
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.mnr.planmanage.planmgt.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author WanGyu Kim
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PlanMgtDBDAOremoveDisposalPlanHeaderDataDSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Disposal Planning Header 삭제
	  * </pre>
	  */
	public PlanMgtDBDAOremoveDisposalPlanHeaderDataDSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mnr_pln_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.mnr.planmanage.planmgt.integration ").append("\n"); 
		query.append("FileName : PlanMgtDBDAOremoveDisposalPlanHeaderDataDSQL").append("\n"); 
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
		query.append("DELETE FROM MNR_PLN_HDR A" ).append("\n"); 
		query.append("WHERE MNR_PLN_SEQ = @[mnr_pln_seq]" ).append("\n"); 

	}
}