/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : AdjustmentManageDBDAOCreateResponsibleOfficeChangeRequestCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.05.24
*@LastModifier : 조원주
*@LastVersion : 1.0
* 2012.05.24 조원주
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.tpb.processmanage.adjustmentmanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author CHO WON-JOO
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AdjustmentManageDBDAOCreateResponsibleOfficeChangeRequestCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * CreateResponsibleOfficeChangeRequest
	  * </pre>
	  */
	public AdjustmentManageDBDAOCreateResponsibleOfficeChangeRequestCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_ra_rmk2",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_user_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_ra_rmk1",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_wrtf_rsn_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_user_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("stl_to_clt_cng_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("n3pty_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_file_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.tpb.processmanage.adjustmentmanage.integration").append("\n"); 
		query.append("FileName : AdjustmentManageDBDAOCreateResponsibleOfficeChangeRequestCSQL").append("\n"); 
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
		query.append("CALL TPB_ADJ_PKG.CRE_ADJ_REQ_PRC(" ).append("\n"); 
		query.append("	@[n3pty_no]," ).append("\n"); 
		query.append("	@[s_user_ofc_cd]," ).append("\n"); 
		query.append("	@[s_user_id]," ).append("\n"); 
		query.append("	'O'," ).append("\n"); 
		query.append("	@[s_ra_rmk1]," ).append("\n"); 
		query.append("	@[stl_to_clt_cng_ofc_cd]," ).append("\n"); 
		query.append("	@[s_file_no]," ).append("\n"); 
		query.append("	@[s_ra_rmk1]," ).append("\n"); 
		query.append("	@[s_ra_rmk2]," ).append("\n"); 
		query.append("    @[s_wrtf_rsn_cd]" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}