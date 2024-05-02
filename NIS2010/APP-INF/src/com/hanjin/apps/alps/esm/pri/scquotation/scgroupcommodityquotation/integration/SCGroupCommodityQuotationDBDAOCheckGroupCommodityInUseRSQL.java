/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : SCGroupCommodityQuotationDBDAOCheckGroupCommodityInUseRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.01.13
*@LastModifier : 이승준
*@LastVersion : 1.0
* 2010.01.13 이승준
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.scquotation.scgroupcommodityquotation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Seung-Jun,Lee
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SCGroupCommodityQuotationDBDAOCheckGroupCommodityInUseRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * CMDT CD가 RATE에서 사용하는지 체크
	  * </pre>
	  */
	public SCGroupCommodityQuotationDBDAOCheckGroupCommodityInUseRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("prc_grp_cmdt_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("qttn_ver_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("qttn_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.pri.scquotation.scgroupcommodityquotation.integration").append("\n"); 
		query.append("FileName : SCGroupCommodityQuotationDBDAOCheckGroupCommodityInUseRSQL").append("\n"); 
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
		query.append("SELECT PRC_CMDT_DEF_CD AS CD" ).append("\n"); 
		query.append("FROM PRI_SQ_RT_CMDT" ).append("\n"); 
		query.append("WHERE QTTN_NO       = @[qttn_no]" ).append("\n"); 
		query.append("AND QTTN_VER_NO     = @[qttn_ver_no]" ).append("\n"); 
		query.append("AND PRC_CMDT_DEF_CD = @[prc_grp_cmdt_cd]" ).append("\n"); 

	}
}