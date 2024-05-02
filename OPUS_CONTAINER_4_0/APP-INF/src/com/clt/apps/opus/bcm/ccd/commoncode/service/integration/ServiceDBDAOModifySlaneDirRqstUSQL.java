/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : ServiceDBDAOModifySlaneDirRqstUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.12.21
*@LastModifier : 
*@LastVersion : 1.0
* 2015.12.21 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.bcm.ccd.commoncode.service.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ServiceDBDAOModifySlaneDirRqstUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Request VSL DIR cd 내용 수정
	  * </pre>
	  */
	public ServiceDBDAOModifySlaneDirRqstUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rqst_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_slan_dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_slan_dir_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dir_delt_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("user_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("modi_vsl_slan_dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_slan_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.bcm.ccd.commoncode.service.integration").append("\n"); 
		query.append("FileName : ServiceDBDAOModifySlaneDirRqstUSQL").append("\n"); 
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
		query.append("UPDATE MDM_VSL_SVC_LANE_DIR_RQST " ).append("\n"); 
		query.append("   SET DELT_FLG = @[dir_delt_flg]" ).append("\n"); 
		query.append("      ,UPD_USR_ID = @[user_id]" ).append("\n"); 
		query.append("      ,UPD_DT = SYSDATE" ).append("\n"); 
		query.append("      ,VSL_SLAN_DIR_SEQ = @[vsl_slan_dir_seq]" ).append("\n"); 
		query.append("      ,MODI_VSL_SLAN_DIR_CD = @[modi_vsl_slan_dir_cd]" ).append("\n"); 
		query.append(" WHERE RQST_NO = @[rqst_no]" ).append("\n"); 
		query.append("   AND VSL_SLAN_CD = @[vsl_slan_cd]" ).append("\n"); 
		query.append("   AND VSL_SLAN_DIR_CD = @[vsl_slan_dir_cd]" ).append("\n"); 

	}
}