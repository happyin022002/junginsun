/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : CntrMtyRouteSettingDBDAOSearchCntrMtyRouteSettingListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.07.28
*@LastModifier : 
*@LastVersion : 1.0
* 2016.07.28 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.eqr.cntrmtybkgmanage.cntrmtyroutesetting.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CntrMtyRouteSettingDBDAOSearchCntrMtyRouteSettingListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * CntrMtyRouteSettingDBDAOSearchCntrMtyRouteSettingList
	  * </pre>
	  */
	public CntrMtyRouteSettingDBDAOSearchCntrMtyRouteSettingListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("p_rcc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_loc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.eqr.cntrmtybkgmanage.cntrmtyroutesetting.integration").append("\n"); 
		query.append("FileName : CntrMtyRouteSettingDBDAOSearchCntrMtyRouteSettingListRSQL").append("\n"); 
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
		query.append("SELECT A.RCC_CD RCC_NM" ).append("\n"); 
		query.append("      ,A.LODG_DCHG_DIV_CD" ).append("\n"); 
		query.append("      ,A.LOC_CD LOC_NM " ).append("\n"); 
		query.append("      ,CASE WHEN ( " ).append("\n"); 
		query.append("                    SELECT COUNT(1) " ).append("\n"); 
		query.append("                    FROM EQR_CTRL_ROUT_SET_TP_SZ X" ).append("\n"); 
		query.append("                    WHERE X.LODG_DCHG_DIV_CD = A.LODG_DCHG_DIV_CD  " ).append("\n"); 
		query.append("                    AND   X.LOC_CD           = A.LOC_CD    " ).append("\n"); 
		query.append("                  ) > 0 THEN 0 -- CNTR IMAGE 표현" ).append("\n"); 
		query.append("                        ELSE 1 -- CNTR IMAGE 없음" ).append("\n"); 
		query.append("       END CNTR_IMG" ).append("\n"); 
		query.append("      ,DECODE(A.MTY_BKG_DSABIL_FLG, 'Y', 1, 0)       MTY_BKG_DSABIL_FLG" ).append("\n"); 
		query.append("      ,DECODE(A.MTY_SPLIT_BKG_DSABIL_FLG, 'Y', 1, 0) MTY_SPLIT_BKG_DSABIL_FLG" ).append("\n"); 
		query.append("FROM EQR_CTRL_ROUT_SET A" ).append("\n"); 
		query.append(" WHERE 1=1" ).append("\n"); 
		query.append(" #if(${p_rcc_cd} != 'ALL')" ).append("\n"); 
		query.append("   #if(${p_rcc_cd} != '')" ).append("\n"); 
		query.append("     AND A.RCC_CD = @[p_rcc_cd]" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append(" #end" ).append("\n"); 
		query.append(" #if(${s_loc_cd} != '')" ).append("\n"); 
		query.append("   AND A.LOC_CD = @[s_loc_cd]" ).append("\n"); 
		query.append(" #end" ).append("\n"); 

	}
}