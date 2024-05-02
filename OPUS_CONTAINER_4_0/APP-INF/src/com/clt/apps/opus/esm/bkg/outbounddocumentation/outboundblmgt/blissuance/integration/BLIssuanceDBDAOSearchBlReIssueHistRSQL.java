/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : BLIssuanceDBDAOSearchBlReIssueHistRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.01.13
*@LastModifier : 문경일
*@LastVersion : 1.0
* 2016.01.13 문경일
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author KYOUNGIL MOON
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BLIssuanceDBDAOSearchBlReIssueHistRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchBlReIssueHist
	  * </pre>
	  */
	public BLIssuanceDBDAOSearchBlReIssueHistRSQL(){
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
		query.append("Path : com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.integration").append("\n"); 
		query.append("FileName : BLIssuanceDBDAOSearchBlReIssueHistRSQL").append("\n"); 
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
		query.append("SELECT BKG_NO" ).append("\n"); 
		query.append("		,HIS_SEQ" ).append("\n"); 
		query.append("		,BKG_EVNT_KND_CD" ).append("\n"); 
		query.append("		,RISS_FLG" ).append("\n"); 
		query.append("		,BL_RISS_RSN_CD" ).append("\n"); 
		query.append("		,RISS_RSN" ).append("\n"); 
		query.append("		,ISS_CXL_FLG" ).append("\n"); 
		query.append("  FROM(SELECT 	HIS.BKG_NO" ).append("\n"); 
		query.append("		        ,HIS.HIS_SEQ" ).append("\n"); 
		query.append("        		,HIS.BKG_EVNT_KND_CD" ).append("\n"); 
		query.append("		        ,HIS.RISS_FLG" ).append("\n"); 
		query.append("		        ,HIS.BL_RISS_RSN_CD" ).append("\n"); 
		query.append("		        ,HIS.RISS_RSN " ).append("\n"); 
		query.append("				,HIS.ISS_CXL_FLG" ).append("\n"); 
		query.append("				,ROW_NUMBER() OVER(ORDER BY HIS_SEQ DESC) SEQ" ).append("\n"); 
		query.append("		FROM BKG_DOC_ISS_HIS HIS " ).append("\n"); 
		query.append("		WHERE 1=1" ).append("\n"); 
		query.append("			AND	HIS.BKG_NO =@[bkg_no] " ).append("\n"); 
		query.append("			AND HIS.BKG_EVNT_KND_CD = 'R')" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND SEQ = 1" ).append("\n"); 
		query.append("AND ISS_CXL_FLG = 'N'" ).append("\n"); 

	}
}