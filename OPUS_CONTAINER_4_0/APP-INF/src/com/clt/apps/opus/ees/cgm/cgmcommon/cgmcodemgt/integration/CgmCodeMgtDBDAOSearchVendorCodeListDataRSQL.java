/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : CgmCodeMgtDBDAOSearchVendorCodeListDataRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.12.24
*@LastModifier : 박광석
*@LastVersion : 1.0
* 2014.12.24 박광석
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.cgm.cgmcommon.cgmcodemgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author PARK KWANG SEOK
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CgmCodeMgtDBDAOSearchVendorCodeListDataRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * CgmCodeMgtDB.SearchVendorCodeListData
	  * </pre>
	  */
	public CgmCodeMgtDBDAOSearchVendorCodeListDataRSQL(){
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

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.cgm.cgmcommon.cgmcodemgt.integration").append("\n"); 
		query.append("FileName : CgmCodeMgtDBDAOSearchVendorCodeListDataRSQL").append("\n"); 
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
		query.append("SELECT A.VNDR_SEQ AS CODE1," ).append("\n"); 
		query.append("	   A.VNDR_LGL_ENG_NM AS DESC1," ).append("\n"); 
		query.append("	   A.GEN_PAY_TERM_CD AS CODE2," ).append("\n"); 
		query.append("       NVL(A.PAY_CURR_CD, A.INV_CURR_CD) AS CODE3" ).append("\n"); 
		query.append("FROM   MDM_VENDOR A" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${vndr_seq} != '') " ).append("\n"); 
		query.append("	WHERE @[vndr_seq] = A.VNDR_SEQ" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}