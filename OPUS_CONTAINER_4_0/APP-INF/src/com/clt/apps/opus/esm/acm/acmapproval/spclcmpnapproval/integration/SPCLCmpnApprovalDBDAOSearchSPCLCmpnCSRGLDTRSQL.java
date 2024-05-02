/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : SPCLCmpnApprovalDBDAOSearchSPCLCmpnCSRGLDTRSQL.java
*@FileTitle :
*Open Issues :
*Change history :
*@LastModifyDate : 2012.07.02
*@LastModifier : 김봉균
*@LastVersion : 1.0
* 2012.07.02 김봉균
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.acm.acmapproval.spclcmpnapproval.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author KIM BONG-GYOON
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SPCLCmpnApprovalDBDAOSearchSPCLCmpnCSRGLDTRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();

	Logger log =Logger.getLogger(this.getClass());

	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;

	/**
	  * <pre>
	  * SearchSPCLCmpnCSRGLDT
	  * </pre>
	  */
	public SPCLCmpnApprovalDBDAOSearchSPCLCmpnCSRGLDTRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ap_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inv_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ar_hd_qtr_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n");
		query.append("Path : com.clt.apps.opus.esm.acm.acmapproval.spclcmpnapproval.integration ").append("\n");
		query.append("FileName : SPCLCmpnApprovalDBDAOSearchSPCLCmpnCSRGLDTRSQL").append("\n");
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
		query.append("/* 마감월 체크하여 gl_dt(effDt 재셋팅) */" ).append("\n");
		query.append("SELECT NVL(GL_DT,@[inv_dt]) AS GL_DT" ).append("\n");
		query.append("FROM (SELECT DECODE(A.OFC_CD,@[ap_ofc_cd],1 ,2) AS GL_DIV_CD" ).append("\n");
		query.append(",DECODE (A.STS, 'O', @[inv_dt], 'C', B.DT) AS GL_DT " ).append("\n");
		query.append("  FROM (SELECT CLZ_STS_CD AS STS, OFC_CD" ).append("\n");
		query.append("          FROM AP_PERIOD " ).append("\n");
		query.append("         WHERE SYS_DIV_CD = 23 " ).append("\n");
		query.append("           AND AR_AP_DIV_CD = 'P' " ).append("\n");
		query.append("           AND OFC_CD IN (@[ap_ofc_cd],@[ar_hd_qtr_ofc_cd]) -- " ).append("\n");
		query.append("           AND EFF_YRMON = SUBSTR (@[inv_dt], 1, 6)) A " ).append("\n");
		query.append("     , (SELECT MIN (EFF_YRMON) || '01' AS DT " ).append("\n");
		query.append("          FROM AP_PERIOD " ).append("\n");
		query.append("         WHERE SYS_DIV_CD = 23 " ).append("\n");
		query.append("           AND AR_AP_DIV_CD = 'P' " ).append("\n");
		query.append("           AND OFC_CD IN (@[ap_ofc_cd],@[ar_hd_qtr_ofc_cd]) -- " ).append("\n");
		query.append("           AND CLZ_STS_CD = 'O' AND EFF_YRMON >= SUBSTR(REPLACE(@[inv_dt], '-'), 1, 6) ) B " ).append("\n");
		query.append("ORDER BY 1)" ).append("\n");
		query.append("WHERE ROWNUM = 1" ).append("\n");

	}
}