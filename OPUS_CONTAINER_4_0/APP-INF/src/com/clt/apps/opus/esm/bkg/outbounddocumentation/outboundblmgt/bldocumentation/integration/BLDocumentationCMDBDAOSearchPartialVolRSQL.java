/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : BLDocumentationCMDBDAOSearchPartialVolRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.11.05
*@LastModifier : 
*@LastVersion : 1.0
* 2014.11.05 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BLDocumentationCMDBDAOSearchPartialVolRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * split시 나눠지는 volume, weight를 조회한다.
	  * </pre>
	  */
	public BLDocumentationCMDBDAOSearchPartialVolRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("source_bkg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.integration ").append("\n"); 
		query.append("FileName : BLDocumentationCMDBDAOSearchPartialVolRSQL").append("\n"); 
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
		query.append("SELECT CNTR_NO" ).append("\n"); 
		query.append(" 	 , SUM(CNTR_VOL_QTY) CNTR_VOL_QTY" ).append("\n"); 
		query.append("     , SUM(CNTR_WGT) CNTR_WGT" ).append("\n"); 
		query.append("  FROM BKG_BOOKING BK, BKG_CONTAINER CNTR" ).append("\n"); 
		query.append(" WHERE BK.BKG_NO = CNTR.BKG_NO" ).append("\n"); 
		query.append("   AND BK.BKG_STS_CD <> 'X'" ).append("\n"); 
		query.append("   AND CNTR.CNTR_NO = @[cntr_no] " ).append("\n"); 
		query.append("   AND BK.BKG_NO <> NVL((SELECT MAX(BKG_NO) " ).append("\n"); 
		query.append("						   FROM BKG_BOOKING " ).append("\n"); 
		query.append(" 						  WHERE FM_BKG_NO = @[source_bkg] " ).append("\n"); 
		query.append("							AND BKG_STS_CD <> 'X'" ).append("\n"); 
		query.append("							AND BKG_CRE_TP_CD = 'S'), 'X')" ).append("\n"); 
		query.append("   AND ((BK.BKG_NO = @[source_bkg] and BK.BKG_CRE_TP_CD IN ('B', 'S', 'C'))" ).append("\n"); 
		query.append("			OR " ).append("\n"); 
		query.append("		(BK.FM_BKG_NO = @[source_bkg] and BK.BKG_CRE_TP_CD IN ('B', 'S'))" ).append("\n"); 
		query.append("		)" ).append("\n"); 
		query.append(" GROUP BY CNTR_NO" ).append("\n"); 

	}
}