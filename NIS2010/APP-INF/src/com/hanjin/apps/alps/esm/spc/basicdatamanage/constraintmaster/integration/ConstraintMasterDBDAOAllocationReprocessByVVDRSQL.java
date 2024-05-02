/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : ConstraintMasterDBDAOAllocationReprocessByVVDRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.06.11
*@LastModifier : Kim sung wook
*@LastVersion : 1.0
* 2015.06.11 Kim sung wook
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.spc.basicdatamanage.constraintmaster.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ConstraintMasterDBDAOAllocationReprocessByVVDRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Compulsory Firm 에서 Reprocess 버튼 클릭시 동작, VVD로 SPC_SB_BKG_APLY_PROC 호출함.
	  * </pre>
	  */
	public ConstraintMasterDBDAOAllocationReprocessByVVDRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cfm_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_vvd_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.spc.basicdatamanage.constraintmaster.integration").append("\n"); 
		query.append("FileName : ConstraintMasterDBDAOAllocationReprocessByVVDRSQL").append("\n"); 
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
		query.append("CALL SPC_SB_BKG_APLY_PRC('V', null, @[bkg_vvd_cd], null, null, null, null, @[cfm_usr_id])" ).append("\n"); 
		query.append("/*" ).append("\n"); 
		query.append("    in_mode       IN VARCHAR2, -- default=B, B:BKG단건, V:VVD, W:Week기준(wk, duration, rev lane, bound)" ).append("\n"); 
		query.append("    in_bkg_no     IN VARCHAR2, " ).append("\n"); 
		query.append("    in_vvd        IN VARCHAR2," ).append("\n"); 
		query.append("    in_rlane      IN VARCHAR2," ).append("\n"); 
		query.append("    in_bound      IN VARCHAR2," ).append("\n"); 
		query.append("    in_wk         IN VARCHAR2," ).append("\n"); 
		query.append("    in_duration   IN VARCHAR2," ).append("\n"); 
		query.append("    in_user_id    IN VARCHAR2" ).append("\n"); 
		query.append("*/" ).append("\n"); 

	}
}