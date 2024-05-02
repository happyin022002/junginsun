/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CommonDBDAOSearchVendorInfoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.29
*@LastModifier : 정은호
*@LastVersion : 1.0
* 2009.07.29 정은호
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.eqr.common.eqrcommon.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author ChungEunHo
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CommonDBDAOSearchVendorInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Vendor combo box 정보를 검색
	  * </pre>
	  */
	public CommonDBDAOSearchVendorInfoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.eqr.common.eqrcommon.integration ").append("\n"); 
		query.append("FileName : CommonDBDAOSearchVendorInfoRSQL").append("\n"); 
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
		query.append("--UPDATE BY YANG JUNGRAN 20070605 - CONFIRM BY HWANG YOUNGSIN" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("DISTINCT A.VNDR_ABBR_NM," ).append("\n"); 
		query.append("A.VNDR_SEQ," ).append("\n"); 
		query.append("A.VNDR_CNT_CD" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("MDM_VENDOR A," ).append("\n"); 
		query.append("MDM_CNTR_VNDR_CLSS B" ).append("\n"); 
		query.append("WHERE" ).append("\n"); 
		query.append("A.VNDR_ABBR_NM LIKE UPPER('${vendor_searchword}%')" ).append("\n"); 
		query.append("AND A.VNDR_SEQ = B.VNDR_SEQ" ).append("\n"); 
		query.append("AND B.DELT_FLG ='N'" ).append("\n"); 
		query.append("AND B.CNTR_VNDR_SVC_CD IN ('LSR', 'LSE')" ).append("\n"); 
		query.append("AND A.DELT_FLG = 'N'" ).append("\n"); 
		query.append("ORDER BY VNDR_ABBR_NM" ).append("\n"); 

	}
}