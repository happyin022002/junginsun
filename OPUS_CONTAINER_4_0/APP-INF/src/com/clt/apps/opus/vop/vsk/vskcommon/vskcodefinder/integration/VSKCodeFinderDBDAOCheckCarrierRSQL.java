/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : VSKCodeFinderDBDAOCheckCarrierRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.04
*@LastModifier : 임창빈
*@LastVersion : 1.0
* 2009.11.04 임창빈
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.vsk.vskcommon.vskcodefinder.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Chang-Bin Lim
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class VSKCodeFinderDBDAOCheckCarrierRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * VOP_VSK_0063 Insert 시 유효성 검증 및 Code에 대한 Naem조회 이벤트 처리
	  * </pre>
	  */
	public VSKCodeFinderDBDAOCheckCarrierRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("crr_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.vop.vsk.vskcommon.vskcodefinder.integration").append("\n"); 
		query.append("FileName : VSKCodeFinderDBDAOCheckCarrierRSQL").append("\n"); 
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
		query.append("SELECT	CRR_CD, CRR_NM AS CRR_FULL_NM, 'x' AS EXT_FLG, DELT_FLG" ).append("\n"); 
		query.append("FROM	MDM_CARRIER" ).append("\n"); 
		query.append("WHERE	1 =1" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${crr_cd} != '')" ).append("\n"); 
		query.append("AND CRR_CD LIKE UPPER(@[crr_cd] ||'%')" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("ORDER BY 1" ).append("\n"); 

	}
}