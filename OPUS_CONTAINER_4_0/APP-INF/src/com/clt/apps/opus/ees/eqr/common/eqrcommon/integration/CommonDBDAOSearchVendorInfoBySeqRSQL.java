/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CommonDBDAOSearchVendorInfoBySeqRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.29
*@LastModifier : 정은호
*@LastVersion : 1.0
* 2009.07.29 정은호
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.eqr.common.eqrcommon.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author ChungEunHo
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CommonDBDAOSearchVendorInfoBySeqRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Vendor 정보를 vendor seq 정보로 검색 (excel load 의 경우 사용)
	  * </pre>
	  */
	public CommonDBDAOSearchVendorInfoBySeqRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("seq_searchword",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.eqr.common.eqrcommon.integration ").append("\n"); 
		query.append("FileName : CommonDBDAOSearchVendorInfoBySeqRSQL").append("\n"); 
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
		query.append("VNDR_ABBR_NM" ).append("\n"); 
		query.append(",VNDR_SEQ" ).append("\n"); 
		query.append(",VNDR_CNT_CD" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("MDM_VENDOR" ).append("\n"); 
		query.append("WHERE" ).append("\n"); 
		query.append("VNDR_CNT_CD||VNDR_SEQ = @[seq_searchword]" ).append("\n"); 

	}
}