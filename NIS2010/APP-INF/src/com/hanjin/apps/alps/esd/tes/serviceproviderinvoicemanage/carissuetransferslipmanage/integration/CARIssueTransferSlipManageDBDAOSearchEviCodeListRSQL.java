/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : CARIssueTransferSlipManageDBDAOSearchEviCodeListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.09.17
*@LastModifier : yOnghO
*@LastVersion : 1.0
* 2015.09.17 yOnghO
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.tes.serviceproviderinvoicemanage.carissuetransferslipmanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author yOnghO
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

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("usr_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.tes.serviceproviderinvoicemanage.carissuetransferslipmanage.integration").append("\n"); 
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
		query.append("SELECT 	DECODE(VNDR_CNT_CD, 'KR', VNDR_LOCL_LANG_NM, VNDR_LGL_ENG_NM) VNDR_NM" ).append("\n"); 
		query.append("      , BZCT_NM" ).append("\n"); 
		query.append("      , BZTP_NM" ).append("\n"); 
		query.append("      , DECODE(VNDR_CNT_CD, 'KR', LOCL_LANG_ADDR, ENG_ADDR) VNDR_ADDR" ).append("\n"); 
		query.append("      , VNDR_SEQ" ).append("\n"); 
		query.append("      , CEO_NM" ).append("\n"); 
		query.append("      , RGST_NO" ).append("\n"); 
		query.append("      , (" ).append("\n"); 
		query.append("		SELECT SUBSTR(MAX(SYS_CONNECT_BY_PATH(WKPLC_NM, '|' )),2)" ).append("\n"); 
		query.append("		FROM	(" ).append("\n"); 
		query.append("				SELECT	WKPLC_NM, ROWNUM RNUM" ).append("\n"); 
		query.append("				FROM  	AP_WORKPLACE" ).append("\n"); 
		query.append("                --WHERE   WKPLC_NM NOT IN ('GPTBO','HJSH','HJSH_HQ','KCTBO')" ).append("\n"); 
		query.append("				WHERE	1	= 1" ).append("\n"); 
		query.append("				-- 유효한 OFFICE CODE로 DEFAULT 설정. (2015-09-18 조아영D)" ).append("\n"); 
		query.append("				AND	  INACT_DT IS NULL OR (INACT_DT IS NOT NULL AND SYSDATE < INACT_DT)			" ).append("\n"); 
		query.append("				)" ).append("\n"); 
		query.append("				START WITH RNUM = 1" ).append("\n"); 
		query.append("				CONNECT BY PRIOR RNUM = RNUM - 1" ).append("\n"); 
		query.append("		) AS WKPLC_NMSTRING" ).append("\n"); 
		query.append("      , (" ).append("\n"); 
		query.append("          SELECT  WKPLC_NM DEF_OFC" ).append("\n"); 
		query.append("          FROM    AP_WORKPLACE" ).append("\n"); 
		query.append("          WHERE   1 = 1" ).append("\n"); 
		query.append("          AND     SUBSTR(WKPLC_NM, 1, 3) = SUBSTR(@[usr_ofc_cd], 1, 3)" ).append("\n"); 
		query.append("          AND     ROWNUM =1" ).append("\n"); 
		query.append("		  -- 유효한 OFFICE CODE로 DEFAULT 설정. (2015-09-18 조아영D)" ).append("\n"); 
		query.append("		  AND	  INACT_DT IS NULL OR (INACT_DT IS NOT NULL AND SYSDATE < INACT_DT)" ).append("\n"); 
		query.append("        ) DEF_OFC" ).append("\n"); 
		query.append("FROM   	MDM_VENDOR" ).append("\n"); 
		query.append("WHERE  	VNDR_SEQ = @[vndr_seq]" ).append("\n"); 

	}
}