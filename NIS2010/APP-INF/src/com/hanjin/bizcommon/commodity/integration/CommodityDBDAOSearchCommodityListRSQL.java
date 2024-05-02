/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : CommodityDBDAOSearchCommodityListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.08.03
*@LastModifier : 
*@LastVersion : 1.0
* 2016.08.03 
* 1.0 Creation
=========================================================*/
package com.hanjin.bizcommon.commodity.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CommodityDBDAOSearchCommodityListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Commodity 리스트 조회
	  * </pre>
	  */
	public CommodityDBDAOSearchCommodityListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rep_cmdt_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cmdt_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("startpart",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cmdt_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rep_imdg_lvl_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("endpart",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.bizcommon.commodity.integration").append("\n"); 
		query.append("FileName : CommodityDBDAOSearchCommodityListRSQL").append("\n"); 
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
		query.append("SELECT cmdt_cd," ).append("\n"); 
		query.append("	cmdt_nm," ).append("\n"); 
		query.append("	rep_cmdt_cd," ).append("\n"); 
		query.append("	rep_imdg_lvl_cd," ).append("\n"); 
		query.append("	to_char(upd_dt,'YYYY-MM-DD') upd_dt," ).append("\n"); 
		query.append("	chem_flg" ).append("\n"); 
		query.append("FROM ( " ).append("\n"); 
		query.append("	SELECT ROW_NUMBER() OVER (ORDER BY cmdt_cd ASC) no," ).append("\n"); 
		query.append("		cmdt_cd,              " ).append("\n"); 
		query.append("        cmdt_nm," ).append("\n"); 
		query.append("        rep_cmdt_cd," ).append("\n"); 
		query.append("		rep_imdg_lvl_cd," ).append("\n"); 
		query.append("		upd_dt," ).append("\n"); 
		query.append("	 	chem_flg" ).append("\n"); 
		query.append("	FROM mdm_commodity" ).append("\n"); 
		query.append("	WHERE 1 = 1" ).append("\n"); 
		query.append("	AND DELT_FLG ='N'" ).append("\n"); 
		query.append("#if (${cmdt_cd} != '') " ).append("\n"); 
		query.append("	AND cmdt_cd like @[cmdt_cd] || '%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${rep_cmdt_cd} != '') " ).append("\n"); 
		query.append("	AND rep_cmdt_cd like @[rep_cmdt_cd] || '%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${cmdt_nm} != '') " ).append("\n"); 
		query.append("	AND cmdt_nm like '%' || @[cmdt_nm] || '%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${rep_imdg_lvl_cd} != '') " ).append("\n"); 
		query.append("	AND rep_imdg_lvl_cd = @[rep_imdg_lvl_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("    ) a	  " ).append("\n"); 
		query.append("#if (${ipage} != 0 ) " ).append("\n"); 
		query.append("	WHERE no BETWEEN @[startpart] AND @[endpart]" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}