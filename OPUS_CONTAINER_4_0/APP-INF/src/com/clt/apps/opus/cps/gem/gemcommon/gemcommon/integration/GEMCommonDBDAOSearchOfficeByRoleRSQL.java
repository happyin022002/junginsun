/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : GEMCommonDBDAOSearchOfficeByRoleRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.12
*@LastModifier : 진윤오
*@LastVersion : 1.0
* 2009.06.12 진윤오
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.cps.gem.gemcommon.gemcommon.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author J.Y.O
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class GEMCommonDBDAOSearchOfficeByRoleRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 로그인한 사용자 권한에 따른 OFFICE CD 를 조회
	  * </pre>
	  */
	public GEMCommonDBDAOSearchOfficeByRoleRSQL(){
		setQuery();
		
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ofc_lvl3",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ofc_lvl1",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rgn_ofc_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ofc_lvl2",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("SELECT OFC_CD" ).append("\n"); 
		query.append("FROM   GEM_OFC_HIS" ).append("\n"); 
		query.append("START WITH OFC_CD IN (SELECT L_4" ).append("\n"); 
		query.append("FROM   GEM_OFC_LEVEL_V" ).append("\n"); 
		query.append("WHERE  1 = 1" ).append("\n"); 
		query.append("#if (${rgn_ofc_flg} != '')" ).append("\n"); 
		query.append("AND    RGN_OFC_FLG = @[rgn_ofc_flg]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${ofc_lvl1} != '')" ).append("\n"); 
		query.append("AND    L_2 = @[ofc_lvl1]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${ofc_lvl2} != '')" ).append("\n"); 
		query.append("AND    L_3 = @[ofc_lvl2]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${ofc_lvl3} != '')" ).append("\n"); 
		query.append("AND    L_4 = @[ofc_lvl3]" ).append("\n"); 
		query.append("#end)" ).append("\n"); 
		query.append("CONNECT BY PRIOR OFC_CD = BFR_OFC_CD" ).append("\n"); 

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.nis2010.cps.gem.gemcommon.gemcommon.integration").append("\n"); 
		query.append("FileName : GEMCommonDBDAOSearchOfficeByRoleRSQL").append("\n"); 
		query.append("*/").append("\n"); 
	}
}