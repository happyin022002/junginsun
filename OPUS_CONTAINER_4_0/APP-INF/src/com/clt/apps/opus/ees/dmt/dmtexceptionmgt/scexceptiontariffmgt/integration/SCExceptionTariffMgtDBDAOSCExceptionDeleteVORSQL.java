/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SCExceptionTariffMgtDBDAOSCExceptionDeleteVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.24
*@LastModifier : 
*@LastVersion : 1.0
* 2009.09.24 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.dmt.dmtexceptionmgt.scexceptiontariffmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SCExceptionTariffMgtDBDAOSCExceptionDeleteVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 현재 Requested 상태의 버전정보를 Update 한 후 2103 번 팝업화면에서 복사한 정보로 Save 를 수행한 경우,
	  * 버전의 기존정보를 삭제하기 위한 정보를 담고 있는 VO 객체를 생성하기 위한 쿼리
	  * </pre>
	  */
	public SCExceptionTariffMgtDBDAOSCExceptionDeleteVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.dmt.dmtexceptionmgt.scexceptiontariffmgt.integration").append("\n"); 
		query.append("FileName : SCExceptionTariffMgtDBDAOSCExceptionDeleteVORSQL").append("\n"); 
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
		query.append("SELECT	'' DEL_PROP_NO" ).append("\n"); 
		query.append(",	'' DEL_SC_EXPT_VER_SEQ" ).append("\n"); 
		query.append("FROM	DUAL" ).append("\n"); 

	}
}