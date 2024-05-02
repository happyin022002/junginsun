/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : BkgCopManageDBDAOModifySoStsPlnedUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.01.04
*@LastModifier : 김인수
*@LastVersion : 1.0
* 2011.01.04 김인수
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.sce.bkgcopmanage.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Kim In-soo
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BkgCopManageDBDAOModifySoStsPlnedUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * OD-SO 의 SO STATUS 를 PLANNED 로 원복한다.
	  * </pre>
	  */
	public BkgCopManageDBDAOModifySoStsPlnedUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.sce.bkgcopmanage.integration ").append("\n"); 
		query.append("FileName : BkgCopManageDBDAOModifySoStsPlnedUSQL").append("\n"); 
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