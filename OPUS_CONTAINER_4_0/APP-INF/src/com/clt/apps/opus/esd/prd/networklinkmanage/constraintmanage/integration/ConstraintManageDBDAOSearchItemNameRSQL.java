/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ConstraintManageDBDAOSearchItemNameRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.13
*@LastModifier : 노승배
*@LastVersion : 1.0
* 2009.08.13 노승배
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.prd.networklinkmanage.constraintmanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Noh Seung Bae
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ConstraintManageDBDAOSearchItemNameRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchItemName
	  * </pre>
	  */
	public ConstraintManageDBDAOSearchItemNameRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("item_code",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("category_code",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.prd.networklinkmanage.constraintmanage.integration").append("\n"); 
		query.append("FileName : ConstraintManageDBDAOSearchItemNameRSQL").append("\n"); 
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
		query.append("SELECT pctl_cnst_itm_nm item_name, cnst_rjct_flg use_flag" ).append("\n"); 
		query.append("FROM prd_prod_ctl_cnst_itm" ).append("\n"); 
		query.append("WHERE pctl_cnst_cate_cd = @[category_code]" ).append("\n"); 
		query.append("AND pctl_cnst_itm_cd = @[item_code]" ).append("\n"); 

	}
}