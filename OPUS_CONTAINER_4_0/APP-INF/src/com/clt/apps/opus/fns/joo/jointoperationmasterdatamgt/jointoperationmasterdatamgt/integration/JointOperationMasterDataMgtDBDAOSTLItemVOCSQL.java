/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : JointOperationMasterDataMgtDBDAOSTLItemVOCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.07.15
*@LastModifier : 
*@LastVersion : 1.0
* 2015.07.15 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.fns.joo.jointoperationmasterdatamgt.jointoperationmasterdatamgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class JointOperationMasterDataMgtDBDAOSTLItemVOCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * joo_stl_itm 입력
	  * </pre>
	  */
	public JointOperationMasterDataMgtDBDAOSTLItemVOCSQL(){
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
		params.put("jo_auto_cre_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ord_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("jo_mnl_cre_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("jo_stl_itm_nm",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.fns.joo.jointoperationmasterdatamgt.jointoperationmasterdatamgt.integration").append("\n"); 
		query.append("FileName : JointOperationMasterDataMgtDBDAOSTLItemVOCSQL").append("\n"); 
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
		query.append("insert into joo_stl_itm (" ).append("\n"); 
		query.append("	jo_stl_itm_cd," ).append("\n"); 
		query.append("	jo_stl_itm_nm," ).append("\n"); 
		query.append("	jo_auto_cre_flg," ).append("\n"); 
		query.append("	jo_mnl_cre_flg," ).append("\n"); 
		query.append("	cre_dt," ).append("\n"); 
		query.append("	cre_usr_id," ).append("\n"); 
		query.append("	upd_dt," ).append("\n"); 
		query.append("	upd_usr_id," ).append("\n"); 
		query.append("    ord_seq" ).append("\n"); 
		query.append(") values( " ).append("\n"); 
		query.append("	@[jo_stl_itm_cd]," ).append("\n"); 
		query.append("	@[jo_stl_itm_nm]," ).append("\n"); 
		query.append("	@[jo_auto_cre_flg]," ).append("\n"); 
		query.append("	@[jo_mnl_cre_flg]," ).append("\n"); 
		query.append("	sysdate," ).append("\n"); 
		query.append("	@[usr_id]," ).append("\n"); 
		query.append("	sysdate," ).append("\n"); 
		query.append("	@[usr_id]," ).append("\n"); 
		query.append("	@[ord_seq]" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}