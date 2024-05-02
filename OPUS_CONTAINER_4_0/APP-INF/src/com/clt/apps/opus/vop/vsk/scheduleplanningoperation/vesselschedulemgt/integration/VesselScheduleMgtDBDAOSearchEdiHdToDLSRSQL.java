/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : VesselScheduleMgtDBDAOSearchEdiHdToDLSRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.04.12
*@LastModifier : 유혁
*@LastVersion : 1.0
* 2011.04.12 유혁
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.vsk.scheduleplanningoperation.vesselschedulemgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Ryu Hyuk
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class VesselScheduleMgtDBDAOSearchEdiHdToDLSRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchEdiHdToDLS
	  * </pre>
	  */
	public VesselScheduleMgtDBDAOSearchEdiHdToDLSRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.vop.vsk.scheduleplanningoperation.vesselschedulemgt.integration").append("\n"); 
		query.append("FileName : VesselScheduleMgtDBDAOSearchEdiHdToDLSRSQL").append("\n"); 
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
		query.append("SELECT	'$$$MSGSTART:'" ).append("\n"); 
		query.append("	|| RPAD(NVL(TRIM('COMPANY'),' '),20,' ')" ).append("\n"); 
		query.append("	|| RPAD(NVL(TRIM('DLS'),' '),20,' ')" ).append("\n"); 
		query.append("	|| RPAD(NVL(TRIM('DLSVVD'),' '),10,' ') " ).append("\n"); 
		query.append("	|| 'KOR' || TO_CHAR(SYSDATE,'RRMMDD') || LTRIM(TO_CHAR(VSK_EDI_SEQ.NEXTVAL, '00000'))AS HEADER" ).append("\n"); 
		query.append("FROM	DUAL" ).append("\n"); 

	}
}