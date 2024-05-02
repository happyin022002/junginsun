/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : CommonDBDAOSearchLaneRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.01.20
*@LastModifier : 
*@LastVersion : 1.0
* 2017.01.20 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.eqr.common.eqrcommon.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CommonDBDAOSearchLaneRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 해당 VVD에 대한 Lane
	  * </pre>
	  */
	public CommonDBDAOSearchLaneRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fr_yyyy_week",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("to_yyyy_week",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("skd_dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("skd_voy_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.eqr.common.eqrcommon.integration").append("\n"); 
		query.append("FileName : CommonDBDAOSearchLaneRSQL").append("\n"); 
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
		query.append("SELECT	" ).append("\n"); 
		query.append("    DISTINCT A.VSL_SLAN_CD" ).append("\n"); 
		query.append("    , DECODE(NVL(A.skd_usd_ind_cd,'B')" ).append("\n"); 
		query.append("        ,'B'" ).append("\n"); 
		query.append("        ,'Both'" ).append("\n"); 
		query.append("        ,'H'" ).append("\n"); 
		query.append("        ,'SML'" ).append("\n"); 
		query.append("        ,'D'" ).append("\n"); 
		query.append("        ,'SEN') COMPANY		" ).append("\n"); 
		query.append("FROM	" ).append("\n"); 
		query.append("    VSK_VSL_SKD A" ).append("\n"); 
		query.append("    , VSK_VSL_PORT_SKD B						" ).append("\n"); 
		query.append("WHERE  " ).append("\n"); 
		query.append("    A.VSL_CD			= B.VSL_CD									" ).append("\n"); 
		query.append("    AND	A.SKD_VOY_NO	= B.SKD_VOY_NO								" ).append("\n"); 
		query.append("    AND	A.SKD_DIR_CD	= B.SKD_DIR_CD								" ).append("\n"); 
		query.append("    AND	A.VSL_CD		= @[vsl_cd]								" ).append("\n"); 
		query.append("    AND	A.SKD_VOY_NO	= @[skd_voy_no]								" ).append("\n"); 
		query.append("    AND	A.SKD_DIR_CD	= @[skd_dir_cd]								" ).append("\n"); 
		query.append("    AND	NVL(B.SKD_CNG_STS_CD,'N') not in ('S')						" ).append("\n"); 
		query.append("    AND	B.VPS_ETD_DT BETWEEN   (" ).append("\n"); 
		query.append("                                SELECT " ).append("\n"); 
		query.append("                                    TO_DATE(WK_ST_DT,'YYYYMMDD') " ).append("\n"); 
		query.append("                                FROM " ).append("\n"); 
		query.append("                                    EQR_WK_PRD " ).append("\n"); 
		query.append("                                WHERE " ).append("\n"); 
		query.append("                                    PLN_YR||PLN_WK = @[fr_yyyy_week]" ).append("\n"); 
		query.append("                                )	" ).append("\n"); 
		query.append("					    AND     (" ).append("\n"); 
		query.append("					            SELECT " ).append("\n"); 
		query.append("					                TO_DATE(WK_END_DT,'YYYYMMDD') " ).append("\n"); 
		query.append("					            FROM " ).append("\n"); 
		query.append("					                EQR_WK_PRD " ).append("\n"); 
		query.append("					            WHERE " ).append("\n"); 
		query.append("					                PLN_YR||PLN_WK = @[to_yyyy_week] " ).append("\n"); 
		query.append("					            )" ).append("\n"); 

	}
}