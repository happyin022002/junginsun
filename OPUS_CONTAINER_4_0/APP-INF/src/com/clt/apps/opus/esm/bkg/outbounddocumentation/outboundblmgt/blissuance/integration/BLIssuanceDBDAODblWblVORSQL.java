/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : BLIssuanceDBDAODblWblVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.05.19
*@LastModifier : 
*@LastVersion : 1.0
* 2010.05.19 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BLIssuanceDBDAODblWblVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * DblWblVO
	  * </pre>
	  */
	public BLIssuanceDBDAODblWblVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.integration").append("\n"); 
		query.append("FileName : BLIssuanceDBDAODblWblVORSQL").append("\n"); 
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
		query.append("SELECT  '' AS EML" ).append("\n"); 
		query.append("       ,'' AS CNSN_CD" ).append("\n"); 
		query.append("       ,'' AS TMPLMRDPDF" ).append("\n"); 
		query.append("       ,'' AS ITR" ).append("\n"); 
		query.append("       ,'' AS REMARK" ).append("\n"); 
		query.append("       ,'' AS BKG_STS_CD" ).append("\n"); 
		query.append("       ,'' AS EML_DATE" ).append("\n"); 
		query.append("       ,'' AS FAX_REASON" ).append("\n"); 
		query.append("       ,'' AS BL_NO" ).append("\n"); 
		query.append("       ,'' AS EML_RESULT" ).append("\n"); 
		query.append("       ,'' AS HIDD_OPT" ).append("\n"); 
		query.append("       ,'' AS FRT_PPD_FLG" ).append("\n"); 
		query.append("       ,'' AS TITLE" ).append("\n"); 
		query.append("       ,'' AS POL_CD" ).append("\n"); 
		query.append("       ,'' AS FRT_CLT_FLG" ).append("\n"); 
		query.append("       ,'' AS CNTC_PSON_NM" ).append("\n"); 
		query.append("       ,'' AS FAX_DATE" ).append("\n"); 
		query.append("       ,'' AS CNSN_NM" ).append("\n"); 
		query.append("       ,'' AS SHPR_NM" ).append("\n"); 
		query.append("       ,'' AS SHPR_CD" ).append("\n"); 
		query.append("       ,'' AS RCVINFO" ).append("\n"); 
		query.append("       ,'' AS SYSCD" ).append("\n"); 
		query.append("       ,'' AS TMPLPARAM" ).append("\n"); 
		query.append("       ,'' AS TMPLMRD" ).append("\n"); 
		query.append("       ,'' AS RCVEML" ).append("\n"); 
		query.append("       ,'' AS CONTENTS" ).append("\n"); 
		query.append("       ,'' AS NTC_KND_CD" ).append("\n"); 
		query.append("       ,'' AS FRT_ALL_FLG" ).append("\n"); 
		query.append("       ,'' AS FILEKEY" ).append("\n"); 
		query.append("       ,'' AS SHORT_SHPR_NM" ).append("\n"); 
		query.append("       ,'' AS BATCHFLG" ).append("\n"); 
		query.append("       ,'' AS FRT_CHG_FLG" ).append("\n"); 
		query.append("       ,'' AS EML_REASON" ).append("\n"); 
		query.append("       ,'' AS POD_CD" ).append("\n"); 
		query.append("       ,'' AS VVD" ).append("\n"); 
		query.append("       ,'' AS BKG_NO" ).append("\n"); 
		query.append("       ,'' AS FAX_RESULT" ).append("\n"); 
		query.append("       ,'' AS SNDNM" ).append("\n"); 
		query.append("       ,'' AS FAX_NO" ).append("\n"); 
		query.append("       ,'' AS FRT_ARR_FLG" ).append("\n"); 
		query.append("       ,'' AS SNDEML" ).append("\n"); 
		query.append("       ,'' AS GRP_FLAG" ).append("\n"); 
		query.append("       ,'' AS FF_CD" ).append("\n"); 
		query.append("	   ,'' AS HISTORY_GUBUN" ).append("\n"); 
		query.append("       ,'' AS POR_CD" ).append("\n"); 
		query.append("FROM   DUAL" ).append("\n"); 

	}
}