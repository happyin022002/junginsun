/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : BkgCopManageDBDAOModifyOdSoStsPlnedUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.09.30
*@LastModifier : 
*@LastVersion : 1.0
* 2011.09.30 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.sce.bkgcopmanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BkgCopManageDBDAOModifyOdSoStsPlnedUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * od-so 의 status 를 planned 로 원복한다.
	  * </pre>
	  */
	public BkgCopManageDBDAOModifyOdSoStsPlnedUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cop_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.sce.bkgcopmanage.integration").append("\n"); 
		query.append("FileName : BkgCopManageDBDAOModifyOdSoStsPlnedUSQL").append("\n"); 
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
		query.append("UPDATE SCE_PLN_SO_LIST SET" ).append("\n"); 
		query.append("	TRSP_SO_STS_CD = 'P'" ).append("\n"); 
		query.append("WHERE" ).append("\n"); 
		query.append("	COP_NO = @[cop_no]" ).append("\n"); 
		query.append("	AND COST_ACT_GRP_CD LIKE 'OD%'" ).append("\n"); 

	}
}