/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : BLIssuanceDBDAOSearchBlClauseInfoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.11.10
*@LastModifier : 
*@LastVersion : 1.0
* 2015.11.10 
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

public class BLIssuanceDBDAOSearchBlClauseInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * BL Clause Remark Info
	  * </pre>
	  */
	public BLIssuanceDBDAOSearchBlClauseInfoRSQL(){
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
		query.append("FileName : BLIssuanceDBDAOSearchBlClauseInfoRSQL").append("\n"); 
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
		query.append("SELECT FF" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("SELECT BL_CLUZ_DESC AS FF" ).append("\n"); 
		query.append("        ,ROW_NUMBER() OVER(PARTITION BY BK.XTER_SNDR_ID,BK.XTER_RQST_NO ORDER BY BK.UPLD_DT DESC) RNUM " ).append("\n"); 
		query.append("FROM BKG_XTER_RQST_MST BK, BKG_XTER_CLUZ BC" ).append("\n"); 
		query.append("WHERE BK.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("  AND BK.XTER_RQST_NO = BC.XTER_RQST_NO" ).append("\n"); 
		query.append("  AND BK.XTER_RQST_SEQ = BC.XTER_RQST_SEQ" ).append("\n"); 
		query.append("  AND BK.XTER_SNDR_ID = BC.XTER_SNDR_ID" ).append("\n"); 
		query.append("  AND BKG_UPLD_STS_CD ='F'" ).append("\n"); 
		query.append("  AND BK.UPLD_GDT = (SELECT MAX(BXRM.UPLD_GDT) " ).append("\n"); 
		query.append("                       FROM BKG_XTER_RQST_MST BXRM" ).append("\n"); 
		query.append("                       WHERE BXRM.BKG_NO =  @[bkg_no]" ).append("\n"); 
		query.append("                         AND BXRM.BKG_UPLD_STS_CD = 'F') " ).append("\n"); 
		query.append(") FF" ).append("\n"); 
		query.append("--WHERE RNUM =1" ).append("\n"); 
		query.append("--AND ROWNUM =1" ).append("\n"); 

	}
}