/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : BkgCopManageDBDAOSearchBkgRcvNoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.16
*@LastModifier : 김인수
*@LastVersion : 1.0
* 2009.10.16 김인수
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.sce.bkgcopmanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Kim In-soo
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BkgCopManageDBDAOSearchBkgRcvNoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * BKG_RCV_DT, BKG_RCV_NO 를 조회한다.
	  * </pre>
	  */
	public BkgCopManageDBDAOSearchBkgRcvNoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.sce.bkgcopmanage.integration").append("\n"); 
		query.append("FileName : BkgCopManageDBDAOSearchBkgRcvNoRSQL").append("\n"); 
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
		query.append("select" ).append("\n"); 
		query.append("TO_CHAR(SYSDATE, 'YYYYMMDD') AS BKG_RCV_DT," ).append("\n"); 
		query.append("SCE_BKG_OP_HIS_SEQ1.NEXTVAL AS	BKG_RCV_NO" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 

	}
}