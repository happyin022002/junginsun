/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : JointOperationMasterDataMgtDBDAOSTLItemAcctVOCSQL.java
*@FileTitle : Adjustment Over Used Slot Hire for RDR
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.16
*@LastModifier : 박희동
*@LastVersion : 1.0
* 2009.10.16 박희동
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.fns.joo.jointoperationmasterdatamgt.jointoperationmasterdatamgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Park Hee Dong
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class JointOperationMasterDataMgtDBDAOSTLItemAcctVOCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * joo_stl_itm 에 입력   
	  * </pre>
	  */
	public JointOperationMasterDataMgtDBDAOSTLItemAcctVOCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("jo_stl_itm_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("re_divr_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("jo_estm_acct_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dr_acct_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cr_acct_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.fns.joo.jointoperationmasterdatamgt.jointoperationmasterdatamgt.integration").append("\n"); 
		query.append("FileName : JointOperationMasterDataMgtDBDAOSTLItemAcctVOCSQL").append("\n"); 
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
		query.append("insert into joo_stl_itm_acct (" ).append("\n"); 
		query.append("re_divr_cd," ).append("\n"); 
		query.append("jo_stl_itm_cd," ).append("\n"); 
		query.append("dr_acct_cd," ).append("\n"); 
		query.append("cr_acct_cd," ).append("\n"); 
		query.append("jo_estm_acct_cd," ).append("\n"); 
		query.append("cre_dt," ).append("\n"); 
		query.append("cre_usr_id," ).append("\n"); 
		query.append("upd_dt," ).append("\n"); 
		query.append("upd_usr_id" ).append("\n"); 
		query.append(") values(" ).append("\n"); 
		query.append("@[re_divr_cd]," ).append("\n"); 
		query.append("@[jo_stl_itm_cd]," ).append("\n"); 
		query.append("@[dr_acct_cd]," ).append("\n"); 
		query.append("@[cr_acct_cd]," ).append("\n"); 
		query.append("@[jo_estm_acct_cd]," ).append("\n"); 
		query.append("sysdate," ).append("\n"); 
		query.append("@[upd_usr_id]," ).append("\n"); 
		query.append("sysdate," ).append("\n"); 
		query.append("@[upd_usr_id]" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}