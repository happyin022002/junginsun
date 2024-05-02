/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : ConstraintMasterDBDAOMultiSpcSbBkgUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.11.16
*@LastModifier : Arie
*@LastVersion : 1.0
* 2015.11.16 Arie
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.spc.basicdatamanage.constraintmaster.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Arie
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ConstraintMasterDBDAOMultiSpcSbBkgUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SPC_SB_BKG 테이블에 데이터 INSERT/UPDATE
	  * 2015.08.27 CHM-201537700 SB BKG management에서 Cancel BKG인지 요청('F'BKG에 대한 B.check Save가 들어오는것이 확인되어 구문변경함)
	  * </pre>
	  */
	public ConstraintMasterDBDAOMultiSpcSbBkgUSQL(){
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
		params.put("cfm_rqst_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cfm_rqst_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("lst_sb_rmk",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.spc.basicdatamanage.constraintmaster.integration").append("\n"); 
		query.append("FileName : ConstraintMasterDBDAOMultiSpcSbBkgUSQL").append("\n"); 
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
		query.append("UPDATE SPC_SB_BKG " ).append("\n"); 
		query.append("SET" ).append("\n"); 
		query.append("#if(${cfm_usr_id} != '') " ).append("\n"); 
		query.append("   	   CFM_USR_ID      = @[cfm_usr_id]" ).append("\n"); 
		query.append("	 , CFM_DT          = SYSDATE" ).append("\n"); 
		query.append("	 , UPD_USR_ID      = @[cfm_usr_id]" ).append("\n"); 
		query.append("	 , LST_SB_RMK      = @[lst_sb_rmk]" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("	#if(${cfm_rqst_flg} == '1') " ).append("\n"); 
		query.append("	   CFM_RQST_FLG    = @[cfm_rqst_flg]" ).append("\n"); 
		query.append("	 , CFM_RQST_USR_ID = @[cfm_rqst_usr_id]" ).append("\n"); 
		query.append("	 , CFM_RQST_DT     = SYSDATE" ).append("\n"); 
		query.append("	 , UPD_USR_ID      = @[cfm_rqst_usr_id]" ).append("\n"); 
		query.append("	#elseif(${cfm_rqst_flg} == '0') " ).append("\n"); 
		query.append("	   CFM_RQST_FLG    = ''" ).append("\n"); 
		query.append("	 , CFM_RQST_USR_ID = ''" ).append("\n"); 
		query.append("	 , CFM_RQST_DT     = ''" ).append("\n"); 
		query.append("	 , UPD_USR_ID      = @[cfm_rqst_usr_id]" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("	 , UPD_DT          = SYSDATE" ).append("\n"); 
		query.append("WHERE BKG_NO = @[bkg_no]" ).append("\n"); 

	}
}