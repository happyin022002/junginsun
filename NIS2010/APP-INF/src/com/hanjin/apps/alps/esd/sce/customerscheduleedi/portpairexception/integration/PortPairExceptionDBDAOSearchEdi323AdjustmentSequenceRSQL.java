/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : PortPairExceptionDBDAOSearchEdi323AdjustmentSequenceRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.09.26
*@LastModifier : 
*@LastVersion : 1.0
* 2013.09.26 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.sce.customerscheduleedi.portpairexception.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PortPairExceptionDBDAOSearchEdi323AdjustmentSequenceRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SCE_323_ADJ, SCE_323_AD_LANE에 저장하기 전 pk 를 채번하는 select 문
	  * </pre>
	  */
	public PortPairExceptionDBDAOSearchEdi323AdjustmentSequenceRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.sce.customerscheduleedi.portpairexception.integration").append("\n"); 
		query.append("FileName : PortPairExceptionDBDAOSearchEdi323AdjustmentSequenceRSQL").append("\n"); 
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
		query.append("SELECT " ).append("\n"); 
		query.append("		TO_CHAR(SYSDATE,'YYYYMMDD')	ADJ_RGST_DT," ).append("\n"); 
		query.append("		SCE_323_ADJ_SEQ.NEXTVAL ADJ_SEQ" ).append("\n"); 
		query.append("FROM	DUAL" ).append("\n"); 

	}
}