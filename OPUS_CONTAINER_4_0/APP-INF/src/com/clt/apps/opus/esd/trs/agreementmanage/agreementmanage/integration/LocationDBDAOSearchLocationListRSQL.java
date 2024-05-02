/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : LocationDBDAOSearchLocationListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.02.24
*@LastModifier : 
*@LastVersion : 1.0
* 2015.02.24 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.trs.agreementmanage.agreementmanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class LocationDBDAOSearchLocationListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Search LocationList
	  * </pre>
	  */
	public LocationDBDAOSearchLocationListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("loc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("loc_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.NUMERIC + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("startpart",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.NUMERIC + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("endpart",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.trs.agreementmanage.agreementmanage.integration").append("\n"); 
		query.append("FileName : LocationDBDAOSearchLocationListRSQL").append("\n"); 
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
		query.append("SELECT" ).append("\n"); 
		query.append("	LOC_CD," ).append("\n"); 
		query.append("	LOC_NM," ).append("\n"); 
		query.append("	SCC_CD," ).append("\n"); 
		query.append("	LCC_CD," ).append("\n"); 
		query.append("	RCC_CD," ).append("\n"); 
		query.append("	CNT_CD" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("		SELECT ROW_NUMBER() OVER (ORDER BY A.LOC_CD ASC) no," ).append("\n"); 
		query.append("			A.LOC_CD," ).append("\n"); 
		query.append("			A.LOC_NM," ).append("\n"); 
		query.append("			A.RGN_CD," ).append("\n"); 
		query.append("			A.STE_CD LOC_STATE," ).append("\n"); 
		query.append("			A.HUB_LOC_CD," ).append("\n"); 
		query.append("			A.UN_LOC_IND_CD," ).append("\n"); 
		query.append("			A.UN_LOC_CD," ).append("\n"); 
		query.append("			A.LOC_CHR_CD," ).append("\n"); 
		query.append("			A.SCC_CD," ).append("\n"); 
		query.append("			C.LCC_CD," ).append("\n"); 
		query.append("			C.ECC_CD," ).append("\n"); 
		query.append("			C.RCC_CD," ).append("\n"); 
		query.append("			A.CNT_CD," ).append("\n"); 
		query.append("			A.SLS_OFC_CD," ).append("\n"); 
		query.append("			A.EQ_CTRL_OFC_CD," ).append("\n"); 
		query.append("			A.DELT_FLG" ).append("\n"); 
		query.append("		FROM MDM_LOCATION A, MDM_COUNTRY B, MDM_EQ_ORZ_CHT C" ).append("\n"); 
		query.append("		WHERE 1 = 1 " ).append("\n"); 
		query.append("			AND A.CNT_CD = B.CNT_CD(+)" ).append("\n"); 
		query.append("			AND A.LOC_CD = C.SCC_CD" ).append("\n"); 
		query.append("            AND NVL(A.DELT_FLG, 'N') = 'N'" ).append("\n"); 
		query.append("            AND NVL(B.DELT_FLG, 'N') = 'N'" ).append("\n"); 
		query.append("            AND NVL(C.DELT_FLG, 'N') = 'N'" ).append("\n"); 
		query.append("		#if(${loc_cd} != '')" ).append("\n"); 
		query.append("			AND A.LOC_CD like '%' || @[loc_cd] || '%'" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("		#if(${loc_nm} != '')" ).append("\n"); 
		query.append("			AND upper(A.LOC_NM) like '%' || upper(@[loc_nm])  || '%'" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("		#if(${cnt_cd} != '')" ).append("\n"); 
		query.append("			AND A.CNT_CD like @[cnt_cd]  || '%'" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("	) A	                   " ).append("\n"); 
		query.append("WHERE no BETWEEN @[startpart] AND @[endpart]" ).append("\n"); 
		query.append("ORDER BY LOC_CD" ).append("\n"); 

	}
}