/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : JointOperationMasterDataMgtDBDAOSTLItemVOUSQL.java
*@FileTitle : Carrier Merger
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.11
*@LastModifier : 박희동
*@LastVersion : 1.0
* 2009.05.11 박희동
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.joo.jointoperationmasterdatamgt.jointoperationmasterdatamgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Park Hee Dong
 * @see DAO 참조
 * @since J2EE 1.4
 */

public class JointOperationMasterDataMgtDBDAOSTLItemVOUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * joo_stl_itm update
	  * </pre>
	  */
	public JointOperationMasterDataMgtDBDAOSTLItemVOUSQL(){
		setQuery();
		
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = "12,N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("jo_auto_cre_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = "12,N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("jo_stl_itm_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = "12,N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("jo_mnl_cre_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = "12,N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("jo_stl_itm_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = "12,N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("usr_id",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("update joo_stl_itm set" ).append("\n"); 
		query.append("jo_stl_itm_cd = @[jo_stl_itm_cd]," ).append("\n"); 
		query.append("jo_stl_itm_nm = @[jo_stl_itm_nm]," ).append("\n"); 
		query.append("jo_auto_cre_flg = @[jo_auto_cre_flg]," ).append("\n"); 
		query.append("jo_mnl_cre_flg = @[jo_mnl_cre_flg]," ).append("\n"); 
		query.append("upd_dt = sysdate," ).append("\n"); 
		query.append("upd_usr_id = @[usr_id]" ).append("\n"); 
		query.append("where	jo_stl_itm_cd = @[jo_stl_itm_cd]" ).append("\n"); 

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.nis2010.fns.joo.jointoperationmasterdatamgt.jointoperationmasterdatamgt.integration").append("\n"); 
		query.append("FileName : JointOperationMasterDataMgtDBDAOSTLItemVOUSQL").append("\n"); 
		query.append("*/").append("\n"); 
	}
}