/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : OptimizeddistancemgtDBDAOYardGroupComboRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.03.14
*@LastModifier : 
*@LastVersion : 1.0
* 2014.03.14 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.vsk.vesseloperationsupportmgt.optimizeddistancemgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class OptimizeddistancemgtDBDAOYardGroupComboRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Port의 값이 입력되면 해당 Port의 Yard Group 값을 조회한다.
	  * </pre>
	  */
	public OptimizeddistancemgtDBDAOYardGroupComboRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("port_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.vop.vsk.vesseloperationsupportmgt.optimizeddistancemgt.integration").append("\n"); 
		query.append("FileName : OptimizeddistancemgtDBDAOYardGroupComboRSQL").append("\n"); 
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
		query.append("SELECT  YD_GRP_ID AS FM_YD_GRP_CD" ).append("\n"); 
		query.append("      , YD_GRP_ID AS TO_YD_GRP_CD" ).append("\n"); 
		query.append("      , YD_GRP_ID AS SHEET_TO_YD_GRP_CD" ).append("\n"); 
		query.append("	  , YD_GRP_ID AS SHEET_FM_YD_GRP_CD" ).append("\n"); 
		query.append("FROM   (" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("        SELECT 'All'  AS YD_GRP_ID FROM DUAL" ).append("\n"); 
		query.append("        UNION ALL" ).append("\n"); 
		query.append("        SELECT DISTINCT YD_GRP_ID--, COUNT(*) KNT" ).append("\n"); 
		query.append("        FROM   (" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                SELECT DISTINCT X.YD_GRP_ID FROM VSK_YD_GRP X WHERE X.YD_CD LIKE @[port_cd]||'%'" ).append("\n"); 
		query.append("                UNION ALL" ).append("\n"); 
		query.append("                SELECT   DISTINCT '*'" ).append("\n"); 
		query.append("                FROM     MDM_YARD     Y" ).append("\n"); 
		query.append("                WHERE    Y.YD_CD      LIKE @[port_cd]||'%'" ).append("\n"); 
		query.append("                AND      Y.DELT_FLG   = 'N'" ).append("\n"); 
		query.append("                AND      Y.YD_FCTY_TP_MRN_TML_FLG = 'Y'" ).append("\n"); 
		query.append("                AND      NOT EXISTS               (SELECT ''" ).append("\n"); 
		query.append("                                                   FROM   VSK_YD_GRP   G" ).append("\n"); 
		query.append("                                                   WHERE  G.YD_CD      = Y.YD_CD" ).append("\n"); 
		query.append("                                                   )  " ).append("\n"); 
		query.append("                AND      0                        <> (SELECT  COUNT(1)" ).append("\n"); 
		query.append("                                                      FROM    VSK_YD_GRP G" ).append("\n"); 
		query.append("                                                      WHERE   G.YD_CD    LIKE @[port_cd]||'%'" ).append("\n"); 
		query.append("                                                     )" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("               ) XX" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("       )" ).append("\n"); 
		query.append("ORDER BY DECODE(YD_GRP_ID,'All','A','*','Z',YD_GRP_ID)    " ).append("\n"); 

	}
}