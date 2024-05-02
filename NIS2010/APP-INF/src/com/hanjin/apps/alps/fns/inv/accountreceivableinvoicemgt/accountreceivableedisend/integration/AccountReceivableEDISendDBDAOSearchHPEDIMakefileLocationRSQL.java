/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : AccountReceivableEDISendDBDAOSearchHPEDIMakefileLocationRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.08.16
*@LastModifier : 최도순
*@LastVersion : 1.0
* 2010.08.16 최도순
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.accountreceivableedisend.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Choi Do Soon
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AccountReceivableEDISendDBDAOSearchHPEDIMakefileLocationRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 
	  * </pre>
	  */
	public AccountReceivableEDISendDBDAOSearchHPEDIMakefileLocationRSQL(){
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
		query.append("Path : com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.accountreceivableedisend.integration").append("\n"); 
		query.append("FileName : AccountReceivableEDISendDBDAOSearchHPEDIMakefileLocationRSQL").append("\n"); 
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
		query.append("SELECT 'POR' AS LOC_TP_CD  ,BKG.POR_CD AS LOC_CD  ,LOC.LOC_NM AS LOC_NAME ,SUBSTR(BKG.POR_CD,1,2) AS LOC_CNT_CD  ,CNT.CNT_NM AS LOC_CNT_NAME" ).append("\n"); 
		query.append("  FROM BKG_BOOKING BKG, MDM_LOCATION LOC, MDM_COUNTRY CNT" ).append("\n"); 
		query.append(" WHERE BKG.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("   AND BKG.POR_CD IS NOT NULL" ).append("\n"); 
		query.append("   AND BKG.POR_CD = LOC.LOC_CD" ).append("\n"); 
		query.append("   AND SUBSTR(BKG.POR_CD,1,2) = CNT.CNT_CD" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT 'POL' AS LOC_TP_CD  ,BKG.POL_CD AS LOC_CD  ,LOC.LOC_NM AS LOC_NAME ,SUBSTR(BKG.POL_CD,1,2) AS LOC_CNT_CD  ,CNT.CNT_NM AS LOC_CNT_NAME" ).append("\n"); 
		query.append("  FROM BKG_BOOKING BKG, MDM_LOCATION LOC, MDM_COUNTRY CNT" ).append("\n"); 
		query.append(" WHERE BKG.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("   AND BKG.POL_CD IS NOT NULL" ).append("\n"); 
		query.append("   AND BKG.POL_CD = LOC.LOC_CD" ).append("\n"); 
		query.append("   AND SUBSTR(BKG.POL_CD,1,2) = CNT.CNT_CD" ).append("\n"); 
		query.append("UNION ALL " ).append("\n"); 
		query.append("SELECT 'POD' AS LOC_TP_CD  ,BKG.POD_CD AS LOC_CD  ,LOC.LOC_NM AS LOC_NAME ,SUBSTR(BKG.POD_CD,1,2) AS LOC_CNT_CD  ,CNT.CNT_NM AS LOC_CNT_NAME" ).append("\n"); 
		query.append("  FROM BKG_BOOKING BKG, MDM_LOCATION LOC, MDM_COUNTRY CNT" ).append("\n"); 
		query.append(" WHERE BKG.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("   AND BKG.POD_CD IS NOT NULL" ).append("\n"); 
		query.append("   AND BKG.POD_CD = LOC.LOC_CD" ).append("\n"); 
		query.append("   AND SUBSTR(BKG.POD_CD,1,2) = CNT.CNT_CD" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT 'DEL' AS LOC_TP_CD  ,BKG.POL_CD AS LOC_CD  ,LOC.LOC_NM AS LOC_NAME ,SUBSTR(BKG.DEL_CD,1,2) AS LOC_CNT_CD  ,CNT.CNT_NM AS LOC_CNT_NAME" ).append("\n"); 
		query.append("  FROM BKG_BOOKING BKG, MDM_LOCATION LOC, MDM_COUNTRY CNT" ).append("\n"); 
		query.append(" WHERE BKG.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("   AND BKG.DEL_CD IS NOT NULL" ).append("\n"); 
		query.append("   AND BKG.DEL_CD = LOC.LOC_CD" ).append("\n"); 
		query.append("   AND SUBSTR(BKG.DEL_CD,1,2) = CNT.CNT_CD " ).append("\n"); 

	}
}