/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : VSKCodeFinderDBDAOSearchCarrierListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.01.26
*@LastModifier : 임창빈
*@LastVersion : 1.0
* 2010.01.26 임창빈
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

public class VSKCodeFinderDBDAOSearchCarrierListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * VOP_VSK_0063 SELECT QUERY
	  * </pre>
	  */
	public VSKCodeFinderDBDAOSearchCarrierListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("crr_full_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("crr_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.vop.vsk.vskcommon.vskcodefinder.integration").append("\n"); 
		query.append("FileName : VSKCodeFinderDBDAOSearchCarrierListRSQL").append("\n"); 
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
		query.append("#if (${crr_cd} != '')" ).append("\n"); 
		query.append("AND CRR_CD LIKE UPPER(@[crr_cd] ||'%')" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${crr_full_nm} != '')" ).append("\n"); 
		query.append("AND CRR_NM LIKE UPPER(@[crr_full_nm] ||'%')" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("AND DELT_FLG = 'N'" ).append("\n"); 
		query.append("ORDER BY 1" ).append("\n"); 

	}
}