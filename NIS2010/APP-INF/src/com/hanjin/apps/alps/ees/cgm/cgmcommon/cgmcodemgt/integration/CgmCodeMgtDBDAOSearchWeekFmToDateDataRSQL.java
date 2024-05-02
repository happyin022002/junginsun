/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CgmCodeMgtDBDAOSearchWeekFmToDateDataRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.17
*@LastModifier : 최민회
*@LastVersion : 1.0
* 2009.09.17 최민회
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.cgm.cgmcommon.cgmcodemgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author CHOI MIN HOI
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CgmCodeMgtDBDAOSearchWeekFmToDateDataRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * chungpa 20090825 1113 공통코드 작성.  WEEK정보 반환
	  * </pre>
	  */
	public CgmCodeMgtDBDAOSearchWeekFmToDateDataRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eq_spec_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.cgm.cgmcommon.cgmcodemgt.integration").append("\n"); 
		query.append("FileName : CgmCodeMgtDBDAOSearchWeekFmToDateDataRSQL").append("\n"); 
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
		query.append("SELECT" ).append("\n"); 
		query.append("PLN_YR AS CODE1" ).append("\n"); 
		query.append(",PLN_WK AS CODE2" ).append("\n"); 
		query.append(",PLN_MON AS CODE3" ).append("\n"); 
		query.append(",WK_ST_DT AS CODE4" ).append("\n"); 
		query.append(",WK_END_DT AS CODE5" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("EQR_WK_PRD t1" ).append("\n"); 
		query.append("WHERE" ).append("\n"); 
		query.append("@[eq_spec_no] BETWEEN WK_ST_DT AND WK_END_DT" ).append("\n"); 

	}
}