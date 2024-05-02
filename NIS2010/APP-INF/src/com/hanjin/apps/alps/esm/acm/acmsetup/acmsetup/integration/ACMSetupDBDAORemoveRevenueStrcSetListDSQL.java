/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : ACMSetupDBDAORemoveRevenueStrcSetListDSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.03.27
*@LastModifier : 이정수
*@LastVersion : 1.0
* 2012.03.27 이정수
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.acm.acmsetup.acmsetup.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Lee Jeong Soo
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ACMSetupDBDAORemoveRevenueStrcSetListDSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * RemoveRevenueStrcSetList
	  * </pre>
	  */
	public ACMSetupDBDAORemoveRevenueStrcSetListDSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rev_chg_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.acm.acmsetup.acmsetup.integration").append("\n"); 
		query.append("FileName : ACMSetupDBDAORemoveRevenueStrcSetListDSQL").append("\n"); 
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
		query.append("DELETE ACM_AGN_SET_REV_CHG_CD" ).append("\n"); 
		query.append(" WHERE REV_CHG_SEQ = @[rev_chg_seq]" ).append("\n"); 

	}
}