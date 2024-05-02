/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : DMTCommonDBDAODualTypeRegionRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.14
*@LastModifier : 이성훈
*@LastVersion : 1.0
* 2009.05.14 이성훈
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.dmt.dmtcommon.commonfinder.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author SungHoon, Lee
 * @see DAO 참조
 * @since J2EE 1.4
 */

public class DMTCommonDBDAODualTypeRegionRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Dual 인 Region 정보 조회를 위한 쿼리
	  * </pre>
	  */
	public DMTCommonDBDAODualTypeRegionRSQL(){
		setQuery();
		
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = "12,N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("SELECT	DISTINCT a.rgn_cd, b.rgn_nm" ).append("\n"); 
		query.append("FROM	dmt_calc_tp a, mdm_region b" ).append("\n"); 
		query.append("WHERE	a.cnt_cd = @[cnt_cd]" ).append("\n"); 
		query.append("AND a.dmdt_calc_tp_cd = 'D'" ).append("\n"); 
		query.append("AND a.rgn_cd = b.rgn_cd" ).append("\n"); 

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.dmt.dmtcommon.dmtcommonfinder.integration").append("\n"); 
		query.append("FileName : DMTCommonDBDAODualTypeRegionRSQL").append("\n"); 
		query.append("*/").append("\n"); 
	}
}