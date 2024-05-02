/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : TESCommonDBDAOSearchLanCdListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.03.11
*@LastModifier : 
*@LastVersion : 1.0
* 2016.03.11 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.tes.tescommon.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TESCommonDBDAOSearchLanCdListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SLAN_CD List 를 조회 한다.
	  * </pre>
	  */
	public TESCommonDBDAOSearchLanCdListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vvd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("yd_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.tes.tescommon.integration").append("\n"); 
		query.append("FileName : TESCommonDBDAOSearchLanCdListRSQL").append("\n"); 
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
		query.append("SELECT LTRIM(MAX(SYS_CONNECT_BY_PATH(SLAN_CD,'|')),'|') AS SLAN_CD " ).append("\n"); 
		query.append("  FROM " ).append("\n"); 
		query.append("       (SELECT ROWNUM ROW_ID " ).append("\n"); 
		query.append("            , Z.SLAN_CD " ).append("\n"); 
		query.append("         FROM " ).append("\n"); 
		query.append("              (SELECT	DISTINCT SLAN_CD  " ).append("\n"); 
		query.append("              FROM	VSK_VSL_PORT_SKD         	" ).append("\n"); 
		query.append("              WHERE	SLAN_CD IS NOT NULL" ).append("\n"); 
		query.append("              #if ( ${vsl_cd_sub} != 'CNTC') " ).append("\n"); 
		query.append("              AND		VPS_PORT_CD	= SUBSTR(@[yd_cd],0,5)" ).append("\n"); 
		query.append("              AND		VSL_CD		= SUBSTR(@[vvd],1,4)     " ).append("\n"); 
		query.append("              AND		SKD_VOY_NO	= SUBSTR(@[vvd],5,4) " ).append("\n"); 
		query.append("              AND		SKD_DIR_CD	= SUBSTR(@[vvd],9,1) " ).append("\n"); 
		query.append("              #end" ).append("\n"); 
		query.append("              ) Z " ).append("\n"); 
		query.append("       ) " ).append("\n"); 
		query.append("CONNECT BY PRIOR ROW_ID = ROW_ID - 1 " ).append("\n"); 
		query.append("START WITH ROW_ID = 1" ).append("\n"); 

	}
}