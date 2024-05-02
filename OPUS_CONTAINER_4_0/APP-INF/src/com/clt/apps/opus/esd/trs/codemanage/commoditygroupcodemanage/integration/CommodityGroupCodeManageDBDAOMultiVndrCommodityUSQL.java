/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CommodityGroupCodeManageDAOMultiVndrCommodityUSQL.java
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

public class CommodityGroupCodeManageDBDAOMultiVndrCommodityUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Rail Vendor별로 정의된 Commodity Group을 수정
	  * </pre>
	  */
	public CommodityGroupCodeManageDBDAOMultiVndrCommodityUSQL(){
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

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("upd_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trsp_cmdt_grp_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("delt_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("upd_dt",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.trs.codemanage.commoditygroupcodemanage.integration").append("\n"); 
		query.append("FileName : CommodityGroupCodeManageDAOMultiVndrCommodityUSQL").append("\n"); 
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
		query.append("UPDATE	trs_trsp_cmdt_grp" ).append("\n"); 
		query.append("SET		trsp_cmdt_grp_nm	= @[trsp_cmdt_grp_nm]," ).append("\n"); 
		query.append("delt_flg			= @[delt_flg]," ).append("\n"); 
		query.append("upd_usr_id			= @[upd_usr_id]," ).append("\n"); 
		query.append("upd_dt			= TO_DATE(@[upd_dt], 'YYYYMMDD HH24:MI:SS')" ).append("\n"); 
		query.append("WHERE	trsp_grp_cmdt_cd	= @[trsp_grp_cmdt_cd]" ).append("\n"); 
		query.append("AND vndr_seq		= @[vndr_seq]" ).append("\n"); 

	}
}