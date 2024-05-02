/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : PSOCodeFinderDBDAOsearchVslClassListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.09.16
*@LastModifier : 유혁
*@LastVersion : 1.0
* 2010.09.16 유혁
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.pso.psocommon.psocodefinder.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Ryu Hyuk
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PSOCodeFinderDBDAOsearchVslClassListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * vessle 조회
	  * 2010.09.15 CHM-201005696-01 진마리아 Port charge invocie Summary 메뉴 수정 요청
	  * - 지역본부및 office별, Port별 S/P No.로 발생한 Actual invoice를 조회하기 위한 조건 추가/삭제 및 Grid내 칼럼 추가 요청함
	  * - 기존 Main 화면에서 조회조건이 속한 Invoice Master 정보를 보여주고, Detail에서는 해당 Invoice의 Detail  모든 정보를 보여주도록 되어있으나, 조회조건에 맞는 Detail 정보만이 조회되도록 수정.
	  * </pre>
	  */
	public PSOCodeFinderDBDAOsearchVslClassListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.vop.pso.psocommon.psocodefinder.integration").append("\n"); 
		query.append("FileName : PSOCodeFinderDBDAOsearchVslClassListRSQL").append("\n"); 
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
		query.append("SELECT  CNTR_VSL_CLSS_CAPA" ).append("\n"); 
		query.append("FROM MDM_VSL_CNTR" ).append("\n"); 
		query.append("WHERE VSL_CD IN " ).append("\n"); 
		query.append("	(SELECT VSL_CD FROM FMS_CONTRACT WHERE FLET_CTRT_TP_CD IN ('TI', 'OW'))" ).append("\n"); 
		query.append("AND   CNTR_VSL_CLSS_CAPA IS NOT NULL" ).append("\n"); 
		query.append("GROUP BY CNTR_VSL_CLSS_CAPA" ).append("\n"); 
		query.append("ORDER BY CNTR_VSL_CLSS_CAPA" ).append("\n"); 

	}
}