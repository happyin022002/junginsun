/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : WorkOrderIssueDBDAOModifyWoIssStsCdUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.10.05
*@LastModifier : 박찬우
*@LastVersion : 1.0
* 2015.10.05 박찬우
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.trs.workordermanage.workorderissue.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Chanwoo Park
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class WorkOrderIssueDBDAOModifyWoIssStsCdUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Tranport Status Update 시 TRS_TRSP_WRK_ORD.WO_ISS_STS_CD = 'I' 로 변환하는 코드
	  * </pre>
	  */
	public WorkOrderIssueDBDAOModifyWoIssStsCdUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("upd_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trsp_wo_ofc_cty_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trsp_wo_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.trs.workordermanage.workorderissue.integration ").append("\n"); 
		query.append("FileName : WorkOrderIssueDBDAOModifyWoIssStsCdUSQL").append("\n"); 
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
		query.append("UPDATE TRS_TRSP_WRK_ORD" ).append("\n"); 
		query.append("	 SET UPD_USR_ID     = @[upd_usr_id]" ).append("\n"); 
		query.append("		,UPD_DT         = sysdate" ).append("\n"); 
		query.append("		,WO_ISS_STS_CD  = 'I'" ).append("\n"); 
		query.append(" WHERE TRSP_WO_OFC_CTY_CD = @[trsp_wo_ofc_cty_cd]" ).append("\n"); 
		query.append("   AND TRSP_WO_SEQ = @[trsp_wo_seq]" ).append("\n"); 
		query.append("   AND WO_ISS_STS_CD = 'X'" ).append("\n"); 

	}
}