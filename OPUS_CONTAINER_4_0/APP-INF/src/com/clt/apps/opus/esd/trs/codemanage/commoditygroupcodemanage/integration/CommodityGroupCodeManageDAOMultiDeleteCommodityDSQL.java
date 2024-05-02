/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : CommodityGroupCodeManageDAOMultiDeleteCommodityDSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.05.03
*@LastModifier : 
*@LastVersion : 1.0
* 2010.05.03 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.trs.codemanage.commoditygroupcodemanage.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CommodityGroupCodeManageDAOMultiDeleteCommodityDSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Rail Vendor별 Group Commodity를 재 정의한 데이터를 삭제
	  * </pre>
	  */
	public CommodityGroupCodeManageDAOMultiDeleteCommodityDSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.NUMERIC + ",N";
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
		query.append("Path : com.clt.apps.opus.esd.trs.codemanage.commoditygroupcodemanage.integration ").append("\n"); 
		query.append("FileName : CommodityGroupCodeManageDAOMultiDeleteCommodityDSQL").append("\n"); 
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
		query.append("delete 	trs_cmdt_grp_cz" ).append("\n"); 
		query.append("WHERE 	trsp_grp_cmdt_cd	= @[trsp_grp_cmdt_cd]" ).append("\n"); 
		query.append("AND vndr_seq	 	= @[vndr_seq]" ).append("\n"); 

	}
}