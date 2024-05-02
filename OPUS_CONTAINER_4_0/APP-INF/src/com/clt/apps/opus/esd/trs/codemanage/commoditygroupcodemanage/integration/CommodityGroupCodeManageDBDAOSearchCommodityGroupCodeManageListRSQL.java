/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CommodityGroupCodeManageDAOsearchCommodityGroupCodeManageListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.12.03
*@LastModifier : 김진
*@LastVersion : 1.0
* 2009.12.03 김진
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.trs.codemanage.commoditygroupcodemanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author KIM JIN
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CommodityGroupCodeManageDBDAOSearchCommodityGroupCodeManageListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchCommodityGroupCodeManageList
	  * </pre>
	  */
	public CommodityGroupCodeManageDBDAOSearchCommodityGroupCodeManageListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vndr_commoodity_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vndr_commoodity_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vndr_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.trs.codemanage.commoditygroupcodemanage.integration").append("\n"); 
		query.append("FileName : CommodityGroupCodeManageDAOsearchCommodityGroupCodeManageListRSQL").append("\n"); 
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
		query.append("A.trsp_grp_cmdt_cd," ).append("\n"); 
		query.append("B.vndr_lgl_eng_nm vndr_nm," ).append("\n"); 
		query.append("A.vndr_seq," ).append("\n"); 
		query.append("A.trsp_cmdt_grp_nm," ).append("\n"); 
		query.append("'Y' save," ).append("\n"); 
		query.append("A.vndr_seq||A.trsp_grp_cmdt_cd dupl," ).append("\n"); 
		query.append("A.delt_flg" ).append("\n"); 
		query.append("FROM trs_trsp_cmdt_grp A, mdm_vendor B" ).append("\n"); 
		query.append("WHERE A.vndr_seq=B.vndr_seq" ).append("\n"); 
		query.append("#if (${vndr_cd} != '')" ).append("\n"); 
		query.append("AND A.vndr_seq like @[vndr_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${vndr_commoodity_cd} != '')" ).append("\n"); 
		query.append("AND A.trsp_grp_cmdt_cd like @[vndr_commoodity_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${vndr_commoodity_nm} != '')" ).append("\n"); 
		query.append("AND A.trsp_cmdt_grp_nm like @[vndr_commoodity_nm]" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}