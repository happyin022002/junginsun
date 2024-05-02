/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : BLDocumentationCMDBDAOSearchBdrFlgForNewRouteRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.10.08
*@LastModifier : 류대영
*@LastVersion : 1.0
* 2013.10.08 류대영
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author DYRYU
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BLDocumentationCMDBDAOSearchBdrFlgForNewRouteRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * BKG No.로 BDR이 걸렸는지 check
	  * </pre>
	  */
	public BLDocumentationCMDBDAOSearchBdrFlgForNewRouteRSQL(){
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
		query.append("Path : com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.integration").append("\n"); 
		query.append("FileName : BLDocumentationCMDBDAOSearchBdrFlgForNewRouteRSQL").append("\n"); 
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
		query.append("SELECT 'Y' FLG" ).append("\n"); 
		query.append("FROM BKG_VVD_HIS A, BKG_VVD_BDR_LOG B" ).append("\n"); 
		query.append("WHERE A.VSL_CD = B.VSL_CD " ).append("\n"); 
		query.append("  AND A.SKD_VOY_NO = B.SKD_VOY_NO" ).append("\n"); 
		query.append("  AND A.SKD_DIR_CD = B.SKD_DIR_CD" ).append("\n"); 
		query.append("  AND A.POL_CD = B.POL_CD" ).append("\n"); 
		query.append("  AND A.POL_CLPT_IND_SEQ = B.POL_CLPT_IND_SEQ" ).append("\n"); 
		query.append("  AND A.POD_CD = B.POD_CD" ).append("\n"); 
		query.append("  AND A.POD_CLPT_IND_SEQ = B.POD_CLPT_IND_SEQ" ).append("\n"); 
		query.append("  " ).append("\n"); 
		query.append("  AND 'Y' = CASE WHEN A.VSL_PRE_PST_CD = 'S' AND FDR_MNL_BDR_FLG  = 'Y' THEN 'Y'" ).append("\n"); 
		query.append("                 WHEN A.VSL_PRE_PST_CD = 'S' AND FDR_AUTO_BDR_FLG = 'Y' THEN 'Y'" ).append("\n"); 
		query.append("                 WHEN A.VSL_PRE_PST_CD = 'S' AND FDR_BDR_FLG      = 'Y' THEN 'Y'" ).append("\n"); 
		query.append("                             " ).append("\n"); 
		query.append("                 WHEN A.VSL_PRE_PST_CD = 'T' AND TRNK_MNL_BDR_FLG  = 'Y' THEN 'Y'" ).append("\n"); 
		query.append("                 WHEN A.VSL_PRE_PST_CD = 'T' AND TRNK_AUTO_BDR_FLG = 'Y' THEN 'Y'" ).append("\n"); 
		query.append("                 WHEN A.VSL_PRE_PST_CD = 'T' AND TRNK_BDR_FLG      = 'Y' THEN 'Y'" ).append("\n"); 
		query.append("			ELSE 'N' END" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("  AND A.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("  AND A.CORR_NO = 'TMP0000001'" ).append("\n"); 

	}
}