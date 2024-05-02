/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CommodityGroupCodeManageDAOMultiPartCommodityCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.24
*@LastModifier : 김진
*@LastVersion : 1.0
* 2009.07.24 김진
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.trs.codemanage.commoditygroupcodemanage.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author KIM JIN
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CommodityGroupCodeManageDBDAOMultiPartCommodityCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Rail VENDOR 별 GROUP COMMODITY를 재 정의하여 입력
	  * </pre>
	  */
	public CommodityGroupCodeManageDBDAOMultiPartCommodityCSQL(){
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
		params.put("cre_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trsp_grp_cmdt_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.trs.codemanage.commoditygroupcodemanage.integration ").append("\n"); 
		query.append("FileName : CommodityGroupCodeManageDAOMultiPartCommodityCSQL").append("\n"); 
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
		query.append("INSERT INTO trs_cmdt_grp_cz (" ).append("\n"); 
		query.append("trsp_grp_cmdt_cd," ).append("\n"); 
		query.append("cmdt_cd," ).append("\n"); 
		query.append("vndr_seq," ).append("\n"); 
		query.append("cre_usr_id," ).append("\n"); 
		query.append("cre_dt," ).append("\n"); 
		query.append("delt_flg" ).append("\n"); 
		query.append(") VALUES (" ).append("\n"); 
		query.append("@[trsp_grp_cmdt_cd]," ).append("\n"); 
		query.append("@[cmdt_cd]," ).append("\n"); 
		query.append("@[vndr_seq]," ).append("\n"); 
		query.append("@[cre_usr_id]," ).append("\n"); 
		query.append("TO_DATE( @[cre_dt], 'YYYYMMDD HH24:MI:SS')," ).append("\n"); 
		query.append("'N'" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}