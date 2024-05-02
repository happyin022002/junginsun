/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : WeeklyCMDBDAOSearchYardCodeNameOfficeListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.09.03
*@LastModifier : 최덕우
*@LastVersion : 1.0
* 2015.09.03 최덕우
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.mas.weeklypfmc.weeklycm.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Choi Duk Woo
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class WeeklyCMDBDAOSearchYardCodeNameOfficeListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Yard Code 를 조회한다.
	  * </pre>
	  */
	public WeeklyCMDBDAOSearchYardCodeNameOfficeListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("nod_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.mas.weeklypfmc.weeklycm.integration").append("\n"); 
		query.append("FileName : WeeklyCMDBDAOSearchYardCodeNameOfficeListRSQL").append("\n"); 
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
		query.append("SELECT YD_CD AS NOD_CD" ).append("\n"); 
		query.append("      ,YD_NM AS NOD_NM" ).append("\n"); 
		query.append("      ,OFC_CD AS CTRL_OFC_CD" ).append("\n"); 
		query.append("      ,CASE WHEN YD_FCTY_TP_MRN_TML_FLG = 'Y' THEN" ).append("\n"); 
		query.append("               'M'" ).append("\n"); 
		query.append("            WHEN YD_FCTY_TP_MRN_TML_FLG = 'N' AND YD_FCTY_TP_RAIL_RMP_FLG = 'Y' THEN" ).append("\n"); 
		query.append("               'R'" ).append("\n"); 
		query.append("            ELSE '*'" ).append("\n"); 
		query.append("       END IB_NOD_TP" ).append("\n"); 
		query.append("      ,(SELECT NOD_CD FROM MAS_STO_EXP_NOD WHERE NOD_CD = M.YD_CD) F_NOD_CD" ).append("\n"); 
		query.append("FROM MDM_YARD M" ).append("\n"); 
		query.append("WHERE M.YD_CD = REPLACE(@[nod_cd],'*','')" ).append("\n"); 
		query.append("ORDER BY (SELECT NOD_CD FROM MAS_STO_EXP_NOD WHERE NOD_CD = M.YD_CD)ASC" ).append("\n"); 

	}
}