/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : BLIssuanceDBDAOSearchDblRemarkByBkgNoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.08.17
*@LastModifier : 
*@LastVersion : 1.0
* 2015.08.17 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BLIssuanceDBDAOSearchDblRemarkByBkgNoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchDblRemarkByBkgNo
	  * </pre>
	  */
	public BLIssuanceDBDAOSearchDblRemarkByBkgNoRSQL(){
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
		query.append("Path : com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.integration ").append("\n"); 
		query.append("FileName : BLIssuanceDBDAOSearchDblRemarkByBkgNoRSQL").append("\n"); 
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
		query.append("SELECT BKG.BKG_NO" ).append("\n"); 
		query.append("       ,BKG_DRAFT_REMARK_FNC(BKG.BKG_NO, '6', 'N', NULL) AS REMARK" ).append("\n"); 
		query.append("       ,RMK.DIFF_RMK" ).append("\n"); 
		query.append("FROM BKG_BOOKING BKG" ).append("\n"); 
		query.append("     ,(" ).append("\n"); 
		query.append("       SELECT BKG_NO, DIFF_RMK" ).append("\n"); 
		query.append("       FROM" ).append("\n"); 
		query.append("       (" ).append("\n"); 
		query.append("        SELECT B1.BKG_NO" ).append("\n"); 
		query.append("              ,BKG_CUST_TP_CD" ).append("\n"); 
		query.append("              ,B2.DIFF_RMK" ).append("\n"); 
		query.append("        FROM BKG_BOOKING B1" ).append("\n"); 
		query.append("             ,BKG_RPT_ITM_STUP B2" ).append("\n"); 
		query.append("             ,(SELECT BKG_NO" ).append("\n"); 
		query.append("                      ,BKG_CUST_TP_CD" ).append("\n"); 
		query.append("                      ,CUST_CNT_CD" ).append("\n"); 
		query.append("                      ,CUST_SEQ" ).append("\n"); 
		query.append("               FROM BKG_CUSTOMER" ).append("\n"); 
		query.append("               WHERE BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("              ) B3" ).append("\n"); 
		query.append("        WHERE B1.BKG_NO = B3.BKG_NO" ).append("\n"); 
		query.append("        AND B2.CUST_CNT_CD = B3.CUST_CNT_CD" ).append("\n"); 
		query.append("        AND B2.CUST_SEQ = B3.CUST_SEQ" ).append("\n"); 
		query.append("        AND B1.BKG_OFC_CD = B2.BKG_OFC_CD" ).append("\n"); 
		query.append("        AND BKG_CUST_TP_CD IN ('S', 'F')" ).append("\n"); 
		query.append("        ORDER BY BKG_CUST_TP_CD" ).append("\n"); 
		query.append("       )" ).append("\n"); 
		query.append("       WHERE ROWNUM=1" ).append("\n"); 
		query.append("       ) RMK" ).append("\n"); 
		query.append("WHERE BKG.BKG_NO = RMK.BKG_NO(+)" ).append("\n"); 
		query.append("AND BKG.BKG_NO = @[bkg_no]" ).append("\n"); 

	}
}