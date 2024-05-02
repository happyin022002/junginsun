/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : LaneExpenseRatioMgtDAOmodifyMdmVslSvcLaneUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.29
*@LastModifier : 박명종
*@LastVersion : 1.0
* 2009.05.29 박명종
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.pso.portchargebudget.laneexpenseratiomgt.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author myoungjong park
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class LaneExpenseRatioMgtDAOmodifyMdmVslSvcLaneUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * MDM_VSL_SVC_LANE 수정
	  * </pre>
	  */
	public LaneExpenseRatioMgtDAOmodifyMdmVslSvcLaneUSQL(){
		setQuery();
		
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = "12,N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pndlm_flg",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("UPDATE mdm_vsl_svc_lane SET" ).append("\n"); 
		query.append("pndlm_flg = @[pndlm_flg]" ).append("\n"); 
		query.append("WHERE	vsl_slan_cd = @[vsl_slan_cd]" ).append("\n"); 

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.vop.pso.portchargebudget.laneexpenseratiomgt.integration ").append("\n"); 
		query.append("FileName : LaneExpenseRatioMgtDAOmodifyMdmVslSvcLaneUSQL").append("\n"); 
		query.append("*/").append("\n"); 
	}
}