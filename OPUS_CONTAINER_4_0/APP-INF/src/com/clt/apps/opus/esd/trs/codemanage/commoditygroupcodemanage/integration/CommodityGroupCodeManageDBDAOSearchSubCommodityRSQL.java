/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CommodityGroupCodeManageDAOSearchSubCommodityRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.16
*@LastModifier : 김진
*@LastVersion : 1.0
* 2009.07.16 김진
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

public class CommodityGroupCodeManageDBDAOSearchSubCommodityRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchSubCommodity
	  * </pre>
	  */
	public CommodityGroupCodeManageDBDAOSearchSubCommodityRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vndr_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trsp_grp_cmdt_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.trs.codemanage.commoditygroupcodemanage.integration").append("\n"); 
		query.append("FileName : CommodityGroupCodeManageDAOSearchSubCommodityRSQL").append("\n"); 
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
		query.append("A.cmdt_cd," ).append("\n"); 
		query.append("A.vndr_seq," ).append("\n"); 
		query.append("A.cre_usr_id," ).append("\n"); 
		query.append("to_char(A.cre_dt,'YYYYMMDD') cre_dt," ).append("\n"); 
		query.append("B.cmdt_nm," ).append("\n"); 
		query.append("'N' deleteval" ).append("\n"); 
		query.append("FROM trs_cmdt_grp_cz A, mdm_commodity B" ).append("\n"); 
		query.append("WHERE A.delt_flg!='Y'" ).append("\n"); 
		query.append("AND A.cmdt_cd=B.cmdt_cd" ).append("\n"); 
		query.append("AND A.trsp_grp_cmdt_cd = @[trsp_grp_cmdt_cd]" ).append("\n"); 
		query.append("AND A.vndr_seq = @[vndr_seq]" ).append("\n"); 

	}
}