/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : ModelManageDBDAODeleteAllModelDSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.04.10
*@LastModifier : 최윤성
*@LastVersion : 1.0
* 2013.04.10 최윤성
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.spc.modelmanage.modelmanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author CHOI Yun Sung
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ModelManageDBDAODeleteAllModelDSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 동일주차에 새로운 Season 생성시, 기생성된 Season 관련 정보를 삭제합니다.
	  * [CHM-201322502-01] SPC 프로젝트 - 성수기 선복운영 개선을 위한 T/F추진
	  * </pre>
	  */
	public ModelManageDBDAODeleteAllModelDSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.spc.modelmanage.modelmanage.integration").append("\n"); 
		query.append("FileName : ModelManageDBDAODeleteAllModelDSQL").append("\n"); 
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
		query.append("DELETE FROM ${table_nm}" ).append("\n"); 
		query.append("WHERE COST_YRWK = (SELECT COST_YR||COST_WK" ).append("\n"); 
		query.append("                     FROM MAS_WK_PRD" ).append("\n"); 
		query.append("                    WHERE SYSDATE BETWEEN TO_DATE(SLS_FM_DT, 'YYYYMMDD') AND TO_DATE(SLS_TO_DT,'YYYYMMDD')+0.99999" ).append("\n"); 
		query.append("                  )" ).append("\n"); 

	}
}
