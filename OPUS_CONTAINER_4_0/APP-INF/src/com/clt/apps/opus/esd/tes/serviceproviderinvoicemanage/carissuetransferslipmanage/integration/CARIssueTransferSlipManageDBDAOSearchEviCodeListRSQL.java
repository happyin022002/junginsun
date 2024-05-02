/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : CARIssueTransferSlipManageDBDAOSearchEviCodeListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.02.06
*@LastModifier : 
*@LastVersion : 1.0
* 2012.02.06 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.tes.serviceproviderinvoicemanage.carissuetransferslipmanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CARIssueTransferSlipManageDBDAOSearchEviCodeListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchEviCodeList
	  * </pre>
	  */
	public CARIssueTransferSlipManageDBDAOSearchEviCodeListRSQL(){
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
		query.append("Path : com.clt.apps.opus.esd.tes.serviceproviderinvoicemanage.carissuetransferslipmanage.integration").append("\n"); 
		query.append("FileName : CARIssueTransferSlipManageDBDAOSearchEviCodeListRSQL").append("\n"); 
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
		query.append("SELECT 	DECODE(vndr_cnt_cd, 'KR', vndr_locl_lang_nm, vndr_lgl_eng_nm) vndr_nm" ).append("\n"); 
		query.append("		,	bzct_nm" ).append("\n"); 
		query.append("		,	bztp_nm" ).append("\n"); 
		query.append("		,	DECODE(vndr_cnt_cd, 'KR', locl_lang_addr, eng_addr) vndr_addr" ).append("\n"); 
		query.append("		,	vndr_seq" ).append("\n"); 
		query.append("		,	ceo_nm" ).append("\n"); 
		query.append("		,	rgst_no" ).append("\n"); 
		query.append("		, 	(" ).append("\n"); 
		query.append("				SELECT '|'||SUBSTR(MAX(SYS_CONNECT_BY_PATH(wkplc_nm, '|' )),2)" ).append("\n"); 
		query.append("				FROM" ).append("\n"); 
		query.append("					(" ).append("\n"); 
		query.append("						SELECT	wkplc_nm, ROWNUM RNUM" ).append("\n"); 
		query.append("						FROM  	AP_WORKPLACE" ).append("\n"); 
		query.append("					)" ).append("\n"); 
		query.append("				START WITH RNUM = 1" ).append("\n"); 
		query.append("				CONNECT BY PRIOR RNUM = RNUM - 1" ).append("\n"); 
		query.append("			) AS wkplc_nmstring" ).append("\n"); 
		query.append("FROM   	MDM_VENDOR" ).append("\n"); 
		query.append("WHERE  	VNDR_SEQ = @[vndr_seq]" ).append("\n"); 

	}
}