/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : StccCodeRestrictionDBDAOSearchStccCodeRestrictionRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.08.04
*@LastModifier : 
*@LastVersion : 1.0
* 2015.08.04 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.trs.common.stcccoderestrictionpopup.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class StccCodeRestrictionDBDAOSearchStccCodeRestrictionRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * StccCodeRestrictionDBDAOSearchStccCodeRestriction
	  * </pre>
	  */
	public StccCodeRestrictionDBDAOSearchStccCodeRestrictionRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("stcc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("stcc_desc",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("startpart",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("stcc_rstr_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("endpart",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.trs.common.stcccoderestrictionpopup.integration").append("\n"); 
		query.append("FileName : StccCodeRestrictionDBDAOSearchStccCodeRestrictionRSQL").append("\n"); 
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
		query.append("select STCC_CD" ).append("\n"); 
		query.append("      ,STCC_DESC" ).append("\n"); 
		query.append("      ,STCC_RSTR_FLG" ).append("\n"); 
		query.append("  from (SELECT T1.STCC_CD" ).append("\n"); 
		query.append("              ,T1.STCC_DESC" ).append("\n"); 
		query.append("              ,T1.STCC_RSTR_FLG" ).append("\n"); 
		query.append("              ,rownum rum" ).append("\n"); 
		query.append("          FROM TRS_STCC_CD_RSTR T1" ).append("\n"); 
		query.append("         WHERE STCC_CD LIKE @[stcc_cd] || '%'" ).append("\n"); 
		query.append("           AND UPPER(STCC_DESC) LIKE UPPER(@[stcc_desc]) || '%'" ).append("\n"); 
		query.append("           AND NVL2(@[stcc_rstr_flg], STCC_RSTR_FLG, 'X') = NVL(@[stcc_rstr_flg], 'X'))" ).append("\n"); 
		query.append(" where rum BETWEEN @[startpart] AND @[endpart]" ).append("\n"); 

	}
}