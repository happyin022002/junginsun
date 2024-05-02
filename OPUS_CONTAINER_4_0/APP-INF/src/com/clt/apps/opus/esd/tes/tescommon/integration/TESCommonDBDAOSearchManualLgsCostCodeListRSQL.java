/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : TESCommonDBDAOSearchManualLgsCostCodeListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.03.10
*@LastModifier : 
*@LastVersion : 1.0
* 2016.03.10 
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

public class TESCommonDBDAOSearchManualLgsCostCodeListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Manual LGS Cost Code 를 조회한다.
	  * </pre>
	  */
	public TESCommonDBDAOSearchManualLgsCostCodeListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("calc_cost_grp_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.tes.tescommon.integration").append("\n"); 
		query.append("FileName : TESCommonDBDAOSearchManualLgsCostCodeListRSQL").append("\n"); 
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
		query.append("SELECT LTRIM(MAX(SYS_CONNECT_BY_PATH(LGS_COST_CD,'|')),'|') AS LGS_COST_CD" ).append("\n"); 
		query.append("  FROM " ).append("\n"); 
		query.append("       (SELECT ROWNUM ROW_ID " ).append("\n"); 
		query.append("            , Z.LGS_COST_CD " ).append("\n"); 
		query.append("         FROM " ).append("\n"); 
		query.append("              (SELECT LGS_COST_CD " ).append("\n"); 
		query.append("                FROM TES_TML_SO_COST " ).append("\n"); 
		query.append("               WHERE DECODE(@[calc_cost_grp_cd],'MT',MRN_TML_FLG,'ON',ODCK_RAIL_CHG_FLG,'OT',FDCK_CY_TML_FLG, 'OS',FDCK_CY_STO_FLG,'ST',STO_INV_FLG) = 'Y' " ).append("\n"); 
		query.append("                     AND COST_CALC_MZD_CD = 'M' " ).append("\n"); 
		query.append("               ORDER BY LGS_COST_CD" ).append("\n"); 
		query.append("              ) Z " ).append("\n"); 
		query.append("       ) CONNECT BY PRIOR ROW_ID = ROW_ID - 1 START " ).append("\n"); 
		query.append("WITH ROW_ID = 1" ).append("\n"); 

	}
}