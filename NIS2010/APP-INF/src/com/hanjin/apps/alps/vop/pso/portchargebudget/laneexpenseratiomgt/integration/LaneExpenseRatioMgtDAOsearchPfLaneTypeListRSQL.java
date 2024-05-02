/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : LaneExpenseRatioMgtDAOsearchPfLaneTypeListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.28
*@LastModifier : 박명종
*@LastVersion : 1.0
* 2009.05.28 박명종
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.pso.portchargebudget.laneexpenseratiomgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author myoungjong park
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class LaneExpenseRatioMgtDAOsearchPfLaneTypeListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 입력받은 Service Lane Code에 Standard P/F Type Code와 펜드럼 서비스 구분자를 조회한다.
	  * </pre>
	  */
	public LaneExpenseRatioMgtDAOsearchPfLaneTypeListRSQL(){
		setQuery();
		
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = "12,N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_slan_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("SELECT  T1.VSL_SLAN_CD, T1.PF_SVC_TP_CD, T2.PNDLM_FLG" ).append("\n"); 
		query.append("FROM    VSK_PF_SKD T1, MDM_VSL_SVC_LANE T2" ).append("\n"); 
		query.append("WHERE   T1.VSL_SLAN_CD      = T2.VSL_SLAN_CD" ).append("\n"); 
		query.append("AND     T1.SLAN_STND_FLG    = 'Y'" ).append("\n"); 
		query.append("AND     T2.DELT_FLG             = 'N'" ).append("\n"); 
		query.append("AND     T2.VSL_SLAN_CD      = @[vsl_slan_cd]" ).append("\n"); 
		query.append("ORDER BY VSL_SLAN_CD" ).append("\n"); 

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.vop.pso.portchargebudget.laneexpenseratiomgt.integration").append("\n"); 
		query.append("FileName : LaneExpenseRatioMgtDAOsearchPfLaneTypeListRSQL").append("\n"); 
		query.append("*/").append("\n"); 
	}
}