/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : SceAdminManageDBDAODelSceCsrMntrDSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.09.15
*@LastModifier : 
*@LastVersion : 1.0
* 2011.09.15 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.sce.sceadminmanage.sceadminmanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SceAdminManageDBDAODelSceCsrMntrDSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SCE_CSR_MNTR TABLE의 내용을 삭제
	  * </pre>
	  */
	public SceAdminManageDBDAODelSceCsrMntrDSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.sce.sceadminmanage.sceadminmanage.integration").append("\n"); 
		query.append("FileName : SceAdminManageDBDAODelSceCsrMntrDSQL").append("\n"); 
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
		query.append("delete from SCE_CSR_MNTR" ).append("\n"); 

	}
}