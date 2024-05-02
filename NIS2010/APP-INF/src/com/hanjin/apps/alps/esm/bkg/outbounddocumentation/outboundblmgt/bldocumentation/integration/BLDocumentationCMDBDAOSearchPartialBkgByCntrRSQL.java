/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : BLDocumentationCMDBDAOSearchPartialBkgByCntrRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.08.24
*@LastModifier : 
*@LastVersion : 1.0
* 2012.08.24 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BLDocumentationCMDBDAOSearchPartialBkgByCntrRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * cntr를 기준으로 partial bkg들을 조회한다
	  * </pre>
	  */
	public BLDocumentationCMDBDAOSearchPartialBkgByCntrRSQL(){
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

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.integration").append("\n"); 
		query.append("FileName : BLDocumentationCMDBDAOSearchPartialBkgByCntrRSQL").append("\n"); 
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
		query.append("SELECT BK.BKG_NO" ).append("\n"); 
		query.append("  FROM BKG_BOOKING BK, BKG_CONTAINER CNTR" ).append("\n"); 
		query.append(" WHERE BK.BKG_NO     = CNTR.BKG_NO" ).append("\n"); 
		query.append("   AND CNTR.CNTR_NO  = @[cntr_no]" ).append("\n"); 
		query.append("   AND BK.BKG_STS_CD <> 'X'" ).append("\n"); 
		query.append("   AND ((BK.BKG_NO = @[bkg_no] and BK.BKG_CRE_TP_CD IN ('B', 'S', 'C'))" ).append("\n"); 
		query.append("			OR " ).append("\n"); 
		query.append("		(BK.FM_BKG_NO = @[bkg_no] and BK.BKG_CRE_TP_CD IN ('B', 'S'))" ).append("\n"); 
		query.append("		)" ).append("\n"); 

	}
}