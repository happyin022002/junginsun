/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : CntrMtyRouteSettingDBDAOsearchCntrTpSzListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.07.27
*@LastModifier : 
*@LastVersion : 1.0
* 2016.07.27 
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

public class CntrMtyRouteSettingDBDAOsearchCntrTpSzListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * CntrMtyRouteSettingDBDAOsearchCntrTpSzList
	  * </pre>
	  */
	public CntrMtyRouteSettingDBDAOsearchCntrTpSzListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("p_loc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("plodg_dchg_div_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.eqr.cntrmtybkgmanage.cntrmtyroutesetting.integration").append("\n"); 
		query.append("FileName : CntrMtyRouteSettingDBDAOsearchCntrTpSzListRSQL").append("\n"); 
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
		query.append("SELECT DECODE(B.CNTR_TPSZ_CD, NULL, 0, 1) CHK_FLG" ).append("\n"); 
		query.append("      ,A.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("      ,@[plodg_dchg_div_cd] LODG_DCHG_DIV_CD" ).append("\n"); 
		query.append("      ,@[p_loc_cd] LOC_NM" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("        SELECT CNTR_TPSZ_CD " ).append("\n"); 
		query.append("        FROM MDM_CNTR_TP_SZ" ).append("\n"); 
		query.append("        WHERE DELT_FLG     = 'N'" ).append("\n"); 
		query.append("        AND   ACIAC_DIV_CD = 'A' " ).append("\n"); 
		query.append("        ORDER BY CNTR_TPSZ_GRP_CD, CNTR_TPSZ_CD" ).append("\n"); 
		query.append("     ) A     " ).append("\n"); 
		query.append("    ,(" ).append("\n"); 
		query.append("        SELECT CNTR_TPSZ_CD" ).append("\n"); 
		query.append("        FROM EQR_CTRL_ROUT_SET_TP_SZ" ).append("\n"); 
		query.append("        WHERE LODG_DCHG_DIV_CD = @[plodg_dchg_div_cd]" ).append("\n"); 
		query.append("        AND   LOC_CD           = @[p_loc_cd]" ).append("\n"); 
		query.append("     ) B" ).append("\n"); 
		query.append("--WHERE 1=1    " ).append("\n"); 
		query.append("WHERE A.CNTR_TPSZ_CD = B.CNTR_TPSZ_CD(+)" ).append("\n"); 

	}
}