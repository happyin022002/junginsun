/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : VesselScheduleMgtDBDAOSearchEdiHdToKRPUSHNRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.01.23
*@LastModifier : 
*@LastVersion : 1.0
* 2017.01.23 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.vsk.scheduleplanningoperation.vesselschedulemgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class VesselScheduleMgtDBDAOSearchEdiHdToKRPUSHNRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchEdiHdToKRPUSHN
	  * </pre>
	  */
	public VesselScheduleMgtDBDAOSearchEdiHdToKRPUSHNRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("headerSeq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.vop.vsk.scheduleplanningoperation.vesselschedulemgt.integration").append("\n"); 
		query.append("FileName : VesselScheduleMgtDBDAOSearchEdiHdToKRPUSHNRSQL").append("\n"); 
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
		query.append("	|| RPAD(NVL(TRIM('SML'	),' '),20,' ')" ).append("\n"); 
		query.append("	|| RPAD(NVL(TRIM('HJNPC010'	),' '),20,' ')" ).append("\n"); 
		query.append("	|| RPAD(NVL(TRIM('IFTSAI'	),' '),10,' ')" ).append("\n"); 
		query.append("	||@[headerSeq] AS HEADER" ).append("\n"); 
		query.append("FROM	DUAL" ).append("\n"); 

	}
}