/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CommodityGroupCodeManageDAOsearch_vndr_commodityRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.16
*@LastModifier : 김진
*@LastVersion : 1.0
* 2009.07.16 김진
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

public class CommodityGroupCodeManageDBDAOSearchVndrCommodityBySeqRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * search_vndr_commodity
	  * </pre>
	  */
	public CommodityGroupCodeManageDBDAOSearchVndrCommodityBySeqRSQL(){
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

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.trs.codemanage.commoditygroupcodemanage.integration ").append("\n"); 
		query.append("FileName : CommodityGroupCodeManageDAOsearch_vndr_commodityRSQL").append("\n"); 
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
		query.append("vndr_seq vndr_no," ).append("\n"); 
		query.append("VNDR_LGL_ENG_NM vndr_nm_eng" ).append("\n"); 
		query.append("FROM	mdm_vendor" ).append("\n"); 
		query.append("WHERE	vndr_seq = @[vndr_seq]" ).append("\n"); 

	}
}