/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : TotalLossMgtDBDAOsearchEqCurrentStatusRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.08.18
*@LastModifier : 
*@LastVersion : 1.0
* 2016.08.18 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.mnr.operationmanage.totallossmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TotalLossMgtDBDAOsearchEqCurrentStatusRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Total Loss 제각처리 취소시, 현재의 EQ Status를 확인한다.
	  * 만약 이미 활성화된 장비라면 작업을 진행하지 않는다.
	  * </pre>
	  */
	public TotalLossMgtDBDAOsearchEqCurrentStatusRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eq_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.mnr.operationmanage.totallossmgt.integration").append("\n"); 
		query.append("FileName : TotalLossMgtDBDAOsearchEqCurrentStatusRSQL").append("\n"); 
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
		query.append("#if (${eq_kind_cd} == 'U')" ).append("\n"); 
		query.append("SELECT CRNT_YD_CD AS YD_CD, ACIAC_DIV_CD FROM MST_CONTAINER" ).append("\n"); 
		query.append("WHERE CNTR_NO = @[eq_no]" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("SELECT CRNT_YD_CD AS YD_CD, ACIAC_DIV_CD FROM CGM_EQUIPMENT" ).append("\n"); 
		query.append("WHERE EQ_NO = @[eq_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}