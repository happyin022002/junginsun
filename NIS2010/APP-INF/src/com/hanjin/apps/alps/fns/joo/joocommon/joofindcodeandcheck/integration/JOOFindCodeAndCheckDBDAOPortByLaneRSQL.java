/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : JOOFindCodeAndCheckDBDAOPortByLaneRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.08.31
*@LastModifier : 
*@LastVersion : 1.0
* 2010.08.31 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.joo.joocommon.joofindcodeandcheck.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class JOOFindCodeAndCheckDBDAOPortByLaneRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Port list retrieved by lane
	  * 
	  * 2010.08.26 정윤태 [CHM-201005708-01] 
	  * 
	  * LSP J/O Basic Port Creation 메뉴에서 Basic Port 설정시,
	  * 현재일자부터 200일 (현재 option) 전까지 조회가능에서
	  * 600일 전까지의 port info를 조회할수 있도록 변경 요청.
	  * </pre>
	  */
	public JOOFindCodeAndCheckDBDAOPortByLaneRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("super_cd1",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.fns.joo.joocommon.joofindcodeandcheck.integration").append("\n"); 
		query.append("FileName : JOOFindCodeAndCheckDBDAOPortByLaneRSQL").append("\n"); 
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
		query.append("       VPS_PORT_CD AS CODE" ).append("\n"); 
		query.append("  FROM VSK_VSL_PORT_SKD" ).append("\n"); 
		query.append(" WHERE VPS_ETA_DT >= TRUNC(SYSDATE -600) /*2010.08.26 600으로 재수정 -> Test용으로 200 으로 수정.기존(100)-박효숙차장.*/" ).append("\n"); 
		query.append("   AND SLAN_CD = substr(@[super_cd1],1,3)" ).append("\n"); 
		query.append(" GROUP BY VPS_PORT_CD" ).append("\n"); 
		query.append(" ORDER BY VPS_PORT_CD" ).append("\n"); 

	}
}