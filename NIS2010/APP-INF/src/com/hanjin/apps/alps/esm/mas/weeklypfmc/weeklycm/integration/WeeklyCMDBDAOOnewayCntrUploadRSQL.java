/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : WeeklyCMDBDAOOnewayCntrUploadRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.03.11
*@LastModifier : 유제량
*@LastVersion : 1.0
* 2015.03.11 유제량
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.mas.weeklypfmc.weeklycm.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Ryu Je Ryang
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class WeeklyCMDBDAOOnewayCntrUploadRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Oneway Container Upload 의 정보를 조회한다.
	  * </pre>
	  */
	public WeeklyCMDBDAOOnewayCntrUploadRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_fmyearmonth",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_toyearmonth",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_cntrno",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_bkgno",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.mas.weeklypfmc.weeklycm.integration").append("\n"); 
		query.append("FileName : WeeklyCMDBDAOOnewayCntrUploadRSQL").append("\n"); 
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
		query.append("SELECT BKG_NO" ).append("\n"); 
		query.append("      ,CNTR_NO" ).append("\n"); 
		query.append("      ,TPSZ_CD" ).append("\n"); 
		query.append("      ,TERM_CD" ).append("\n"); 
		query.append("      ,MVMT_CD" ).append("\n"); 
		query.append("      ,TO_CHAR(ONH_DT, 'YYYY-MM-DD') AS ONH_DT" ).append("\n"); 
		query.append("      ,ONH_YD_CD" ).append("\n"); 
		query.append("      ,TO_CHAR(OFFH_DT, 'YYYY-MM-DD') AS OFFH_DT" ).append("\n"); 
		query.append("      ,OFFH_YD_CD" ).append("\n"); 
		query.append("      ,BKG_NO AS BKG_NO_ORG" ).append("\n"); 
		query.append("      ,CNTR_NO AS CNTR_NO_ORG" ).append("\n"); 
		query.append("      ,ONH_YD_CD AS ONH_YD_CD_ORG" ).append("\n"); 
		query.append("      ,OFFH_YD_CD AS OFFH_YD_CD_ORG" ).append("\n"); 
		query.append("FROM MAS_OFFH_BKG_LIST" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${f_fmyearmonth} != '' && ${f_toyearmonth} != '')" ).append("\n"); 
		query.append("    WHERE OFFH_DT BETWEEN TO_DATE(@[f_fmyearmonth] || ' 00:00:00', 'YYYYMMDD HH24:MI:SS') AND TO_DATE(@[f_toyearmonth] || ' 23:59:59', 'YYYYMMDD HH24:MI:SS')" ).append("\n"); 
		query.append("    #if (${f_bkgno} != '' && ${f_cntrno} == '')" ).append("\n"); 
		query.append("        AND BKG_NO LIKE @[f_bkgno]||'%'" ).append("\n"); 
		query.append("    #elseif (${f_bkgno} == '' && ${f_cntrno} != '')" ).append("\n"); 
		query.append("        AND CNTR_NO LIKE @[f_cntrno]||'%'" ).append("\n"); 
		query.append("    #elseif (${f_bkgno} != '' && ${f_cntrno} != '')" ).append("\n"); 
		query.append("        AND BKG_NO LIKE @[f_bkgno]||'%'" ).append("\n"); 
		query.append("        AND CNTR_NO LIKE @[f_cntrno]||'%'" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("        " ).append("\n"); 
		query.append("#elseif (${f_fmyearmonth} == '' && ${f_toyearmonth} == '')" ).append("\n"); 
		query.append("    #if (${f_bkgno} != '' && ${f_cntrno} == '')" ).append("\n"); 
		query.append("        WHERE BKG_NO LIKE @[f_bkgno]||'%'" ).append("\n"); 
		query.append("    #elseif (${f_bkgno} == '' && ${f_cntrno} != '')" ).append("\n"); 
		query.append("        WHERE CNTR_NO LIKE @[f_cntrno]||'%'" ).append("\n"); 
		query.append("    #elseif (${f_bkgno} != '' && ${f_cntrno} != '')" ).append("\n"); 
		query.append("        WHERE BKG_NO LIKE @[f_bkgno]||'%'" ).append("\n"); 
		query.append("        AND   CNTR_NO LIKE @[f_cntrno]||'%'" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("    " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("ORDER BY BKG_NO, CNTR_NO" ).append("\n"); 

	}
}