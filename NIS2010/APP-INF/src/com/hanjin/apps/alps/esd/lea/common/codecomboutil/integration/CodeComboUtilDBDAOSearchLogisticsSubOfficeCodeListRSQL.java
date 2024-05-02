/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : CodeComboUtilDBDAOSearchLogisticsSubOfficeCodeListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.06.17
*@LastModifier : 
*@LastVersion : 1.0
* 2015.06.17 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.lea.common.codecomboutil.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CodeComboUtilDBDAOSearchLogisticsSubOfficeCodeListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Logistics Sub Office Code List 정보를 조회한다.
	  * </pre>
	  */
	public CodeComboUtilDBDAOSearchLogisticsSubOfficeCodeListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("code",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.lea.common.codecomboutil.integration").append("\n"); 
		query.append("FileName : CodeComboUtilDBDAOSearchLogisticsSubOfficeCodeListRSQL").append("\n"); 
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
		query.append("SELECT     XX.SUB_OFC_CD             AS CODE" ).append("\n"); 
		query.append("--       , XX.SUB_OFC_CD             AS NAME" ).append("\n"); 
		query.append("FROM       ( " ).append("\n"); 
		query.append("            SELECT     DISTINCT" ).append("\n"); 
		query.append("                       LL.OFC_CD                  AS SUB_OFC_CD" ).append("\n"); 
		query.append("            FROM       MAS_OFC_LVL                LL" ).append("\n"); 
		query.append("            WHERE      1 = 1" ).append("\n"); 
		query.append("            AND        CASE (" ).append("\n"); 
		query.append("                            SELECT  OFC_LVL" ).append("\n"); 
		query.append("                            FROM    (" ).append("\n"); 
		query.append("                                    SELECT  L.OFC_LVL" ).append("\n"); 
		query.append("                                    FROM    MAS_OFC_LVL       L " ).append("\n"); 
		query.append("                                    WHERE   L.OFC_N3RD_LVL_CD IS NOT NULL" ).append("\n"); 
		query.append("                                    AND     L.OFC_N5TH_LVL_CD IS NOT NULL " ).append("\n"); 
		query.append("                                    AND     L.OFC_CD          = @[code]     /* LOGIN-OFFICE CODE BINDING */" ).append("\n"); 
		query.append("                                    ORDER BY L.OFC_APLY_TO_YRMON  DESC   " ).append("\n"); 
		query.append("                                    )    " ).append("\n"); 
		query.append("                             WHERE   ROWNUM  = 1 " ).append("\n"); 
		query.append("                            ) " ).append("\n"); 
		query.append("                             WHEN '1' THEN 'XXXXX'" ).append("\n"); 
		query.append("                             WHEN '2' THEN 'XXXXX'" ).append("\n"); 
		query.append("                             WHEN '3' THEN 'XXXXX'" ).append("\n"); 
		query.append("                             WHEN '4' THEN LL.OFC_N5TH_LVL_CD" ).append("\n"); 
		query.append("                             WHEN '5' THEN LL.OFC_N5TH_LVL_CD" ).append("\n"); 
		query.append("                             WHEN '6' THEN LL.OFC_N5TH_LVL_CD" ).append("\n"); 
		query.append("                             WHEN '7' THEN LL.OFC_N5TH_LVL_CD" ).append("\n"); 
		query.append("                             WHEN '9' THEN 'XXXXX'" ).append("\n"); 
		query.append("                             ELSE          'XXXXX' " ).append("\n"); 
		query.append("                       END                        = @[code]    /* LOGIN-OFFICE CODE BINDING */" ).append("\n"); 
		query.append("                                                             " ).append("\n"); 
		query.append("                   OR  LL.OFC_CD                  = @[code]   /* LOGIN-OFFICE CODE BINDING */" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("           ) XX" ).append("\n"); 
		query.append("ORDER BY   XX.SUB_OFC_CD" ).append("\n"); 

	}
}