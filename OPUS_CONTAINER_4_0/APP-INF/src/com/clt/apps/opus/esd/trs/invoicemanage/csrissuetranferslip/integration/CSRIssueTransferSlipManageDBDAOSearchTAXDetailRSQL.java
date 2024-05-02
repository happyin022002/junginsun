/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CSRIssueTransferSlipManageDBDAOSearchTAXDetailRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.21
*@LastModifier : 김진
*@LastVersion : 1.0
* 2009.08.21 김진
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.trs.invoicemanage.csrissuetranferslip.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author KIM JIN
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CSRIssueTransferSlipManageDBDAOSearchTAXDetailRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 세금계산서 상세정보를 조회
	  * </pre>
	  */
	public CSRIssueTransferSlipManageDBDAOSearchTAXDetailRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("VNDR_SEQ",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.trs.invoicemanage.csrissuetranferslip.integration").append("\n"); 
		query.append("FileName : CSRIssueTransferSlipManageDBDAOSearchTAXDetailRSQL").append("\n"); 
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
		query.append("SELECT 	DECODE(VNDR_CNT_CD, 'KR', VNDR_LOCL_LANG_NM, VNDR_LGL_ENG_NM) VNDR_NM" ).append("\n"); 
		query.append(",	BZCT_NM" ).append("\n"); 
		query.append(",	BZTP_NM" ).append("\n"); 
		query.append(",	DECODE(VNDR_CNT_CD, 'KR', LOCL_LANG_ADDR, ENG_ADDR) VNDR_ADDR" ).append("\n"); 
		query.append(",	VNDR_SEQ" ).append("\n"); 
		query.append(",	CEO_NM" ).append("\n"); 
		query.append(",	RGST_NO" ).append("\n"); 
		query.append(", 	(" ).append("\n"); 
		query.append("SELECT '|'||SUBSTR(MAX(SYS_CONNECT_BY_PATH(WKPLC_NM, '|' )),2)" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT	WKPLC_NM, ROWNUM RNUM" ).append("\n"); 
		query.append("FROM  	AP_WORKPLACE" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("START WITH RNUM = 1" ).append("\n"); 
		query.append("CONNECT BY PRIOR RNUM = RNUM - 1" ).append("\n"); 
		query.append(") AS EVI_CODE" ).append("\n"); 
		query.append("FROM   	MDM_VENDOR" ).append("\n"); 
		query.append("WHERE  	VNDR_SEQ = @[VNDR_SEQ]" ).append("\n"); 

	}
}