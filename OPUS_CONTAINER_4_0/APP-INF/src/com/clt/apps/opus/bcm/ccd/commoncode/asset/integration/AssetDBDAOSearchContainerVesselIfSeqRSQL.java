/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : AssetDBDAOSearchContainerVesselIfSeqRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.11.06
*@LastModifier : 
*@LastVersion : 1.0
* 2014.11.06 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.bcm.ccd.commoncode.asset.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AssetDBDAOSearchContainerVesselIfSeqRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * MDM_VSL_CNTR_IF 테이블의 VSL_CNTR_IF_SEQ 를 채번한다.
	  * </pre>
	  */
	public AssetDBDAOSearchContainerVesselIfSeqRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.bcm.ccd.commoncode.asset.integration ").append("\n"); 
		query.append("FileName : AssetDBDAOSearchContainerVesselIfSeqRSQL").append("\n"); 
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
		query.append("SELECT MDM_VSL_CNTR_IF_SEQ.NEXTVAL vsl_cntr_if_seq " ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 

	}
}