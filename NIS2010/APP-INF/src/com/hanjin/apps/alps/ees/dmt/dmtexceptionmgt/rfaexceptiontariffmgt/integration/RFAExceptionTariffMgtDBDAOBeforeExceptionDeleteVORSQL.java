/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : RFAExceptionTariffMgtDBDAOBeforeExceptionDeleteVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.01.12
*@LastModifier : 
*@LastVersion : 1.0
* 2010.01.12 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.dmt.dmtexceptionmgt.rfaexceptiontariffmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class RFAExceptionTariffMgtDBDAOBeforeExceptionDeleteVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 2105 DAR History 팝업을 통해서 복사한 데이터를 저장할 경우, 현재 버전의 기존 정보를 삭제하기 위한 매개변수 값을 저장할 VO 객체를 생성하기 위한 쿼리
	  * </pre>
	  */
	public RFAExceptionTariffMgtDBDAOBeforeExceptionDeleteVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.dmt.dmtexceptionmgt.rfaexceptiontariffmgt.integration").append("\n"); 
		query.append("FileName : RFAExceptionTariffMgtDBDAOBeforeExceptionDeleteVORSQL").append("\n"); 
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
		query.append("SELECT	'' DEL_RFA_EXPT_DAR_NO" ).append("\n"); 
		query.append(",	'' DEL_RFA_EXPT_MAPG_SEQ" ).append("\n"); 
		query.append(",	'' DEL_RFA_EXPT_VER_SEQ" ).append("\n"); 
		query.append("FROM	DUAL" ).append("\n"); 

	}
}