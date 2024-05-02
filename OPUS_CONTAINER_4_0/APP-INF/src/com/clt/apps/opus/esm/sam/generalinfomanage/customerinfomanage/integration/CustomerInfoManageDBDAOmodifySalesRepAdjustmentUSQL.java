/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : CustomerInfoManageDBDAOmodifySalesRepAdjustmentUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.02.29
*@LastModifier : 
*@LastVersion : 1.0
* 2012.02.29 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.sam.generalinfomanage.customerinfomanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CustomerInfoManageDBDAOmodifySalesRepAdjustmentUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Customer의 담당 Sales REp 변경 정보를 저장한다.
	  * </pre>
	  */
	public CustomerInfoManageDBDAOmodifySalesRepAdjustmentUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pre_srep_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("user_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.sam.generalinfomanage.customerinfomanage.integration").append("\n"); 
		query.append("FileName : CustomerInfoManageDBDAOmodifySalesRepAdjustmentUSQL").append("\n"); 
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
		query.append("update sam_cust_sls_rep_info" ).append("\n"); 
		query.append("   set delt_flg = 'Y'," ).append("\n"); 
		query.append("       upd_usr_id = @[user_id]," ).append("\n"); 
		query.append("       upd_dt     = sysdate" ).append("\n"); 
		query.append(" where cust_cnt_cd = substr(@[cust_cd],1,2)" ).append("\n"); 
		query.append("   and cust_seq    = to_number(substr(@[cust_cd],3))" ).append("\n"); 
		query.append("   and srep_cd     = @[pre_srep_cd]" ).append("\n"); 

	}
}