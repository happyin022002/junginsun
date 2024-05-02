/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : CsScreenDBDAOsearchUsFrgightInfoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.03.17
*@LastModifier : 
*@LastVersion : 1.0
* 2010.03.17 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.inbounddocumentation.csscreenmgt.csscreen.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CsScreenDBDAOsearchUsFrgightInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchUsFrgightInfo
	  * </pre>
	  */
	public CsScreenDBDAOsearchUsFrgightInfoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.inbounddocumentation.csscreenmgt.csscreen.integration").append("\n"); 
		query.append("FileName : CsScreenDBDAOsearchUsFrgightInfoRSQL").append("\n"); 
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
		query.append("SELECT /*+ INDEX_DESC(C XPKBKG_CGO_RLSE_HIS) */" ).append("\n"); 
		query.append("      A.BKG_NO                                         AS BKG_NO" ).append("\n"); 
		query.append("     ,NVL(B.FRT_CLT_FLG,'N')                           AS FRT_CLT_FLG" ).append("\n"); 
		query.append("     ,TO_CHAR(B.FRT_CLT_LST_DT,'YYYY-MM-DD HH24:MI')   AS FRT_CLT_LST_DT" ).append("\n"); 
		query.append("     ,C.EVNT_OFC_CD                                    AS FRT_CLT_OFC_CD" ).append("\n"); 
		query.append("     ,C.HIS_SEQ                                        AS HIS_SEQ" ).append("\n"); 
		query.append("FROM BKG_BOOKING A" ).append("\n"); 
		query.append("    LEFT OUTER JOIN BKG_CGO_RLSE B" ).append("\n"); 
		query.append("     ON( B.BL_NO = A.BL_NO " ).append("\n"); 
		query.append("        AND B.FRT_CLT_FLG = 'Y')" ).append("\n"); 
		query.append("    LEFT OUTER JOIN BKG_CGO_RLSE_HIS C" ).append("\n"); 
		query.append("     ON( C.BL_NO = B.BL_NO" ).append("\n"); 
		query.append("         AND C.FRT_CLT_FLG = B.FRT_CLT_FLG " ).append("\n"); 
		query.append("         AND TO_CHAR(B.FRT_CLT_LST_DT,'YYYYMMDDHH24MI') = TO_CHAR(C.EVNT_DT,'YYYYMMDDHH24MI')" ).append("\n"); 
		query.append("    )" ).append("\n"); 
		query.append("WHERE A.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("AND   ROWNUM = 1" ).append("\n"); 

	}
}