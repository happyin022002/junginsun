/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : RocsManifestListDownLoadDBDAOSqlNameRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.05
*@LastModifier : 임재택
*@LastVersion : 1.0
* 2009.07.05 임재택
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.rocs.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author LIM JAE TAEK
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class RocsManifestListDownLoadDBDAOSqlNameRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ROCS(ROTTERDAM) 세관 신고용 데이터 중 Booking Table에는 있는데 Rocs Table에는 없는 Booking No List를 조회한다. (B/L Creation Indicator = 'Y')
	  * </pre>
	  */
	public RocsManifestListDownLoadDBDAOSqlNameRSQL(){
		setQuery();
		
		params = new HashMap<String,String[]>();
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
		query.append("SELECT" ).append("\n"); 
		query.append("'' frm_crn_number," ).append("\n"); 
		query.append("'' bkg_no," ).append("\n"); 
		query.append("'' bl_seq" ).append("\n"); 
		query.append("from dual" ).append("\n"); 

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.rocs.integration").append("\n"); 
		query.append("FileName : RocsManifestListDownLoadDBDAOSqlNameRSQL").append("\n"); 
		query.append("*/").append("\n"); 
	}
}