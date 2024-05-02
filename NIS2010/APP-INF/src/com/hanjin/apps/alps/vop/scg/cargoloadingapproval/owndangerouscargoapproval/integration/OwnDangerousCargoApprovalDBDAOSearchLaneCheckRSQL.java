/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : OwnDangerousCargoApprovalDBDAOSearchLaneCheckRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.07.03
*@LastModifier : 
*@LastVersion : 1.0
* 2012.07.03 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.scg.cargoloadingapproval.owndangerouscargoapproval.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class OwnDangerousCargoApprovalDBDAOSearchLaneCheckRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * DESC Enter..
	  * </pre>
	  */
	public OwnDangerousCargoApprovalDBDAOSearchLaneCheckRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_slan_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.vop.scg.cargoloadingapproval.owndangerouscargoapproval.integration ").append("\n"); 
		query.append("FileName : OwnDangerousCargoApprovalDBDAOSearchLaneCheckRSQL").append("\n"); 
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
		query.append("A.VSL_SLAN_CD," ).append("\n"); 
		query.append("A.VSL_SLAN_NM," ).append("\n"); 
		query.append("A.VSL_SVC_TP_CD," ).append("\n"); 
		query.append("A.spcl_cgo_rqst_tgt_lane_flg," ).append("\n"); 
		query.append("A.TML_PROD_RPT_FLG," ).append("\n"); 
		query.append("A.UPD_USR_ID,A.UPD_DT," ).append("\n"); 
		query.append("(SELECT D.INTG_CD_VAL_DP_DESC FROM COM_INTG_CD_DTL D" ).append("\n"); 
		query.append("WHERE D.INTG_CD_ID = 'CD00717'" ).append("\n"); 
		query.append("AND D.INTG_CD_VAL_CTNT = A.VSL_SVC_TP_CD )SVC_TYPE_NAME" ).append("\n"); 
		query.append("FROM MDM_VSL_SVC_LANE A" ).append("\n"); 
		query.append("WHERE 1 = 1" ).append("\n"); 
		query.append("AND A.spcl_cgo_rqst_tgt_lane_flg = 'Y'" ).append("\n"); 
		query.append("AND A.DELT_FLG='N'" ).append("\n"); 
		query.append("AND A.VSL_SLAN_CD = @[vsl_slan_cd]" ).append("\n"); 
		query.append("ORDER BY A.VSL_SLAN_CD" ).append("\n"); 

	}
}