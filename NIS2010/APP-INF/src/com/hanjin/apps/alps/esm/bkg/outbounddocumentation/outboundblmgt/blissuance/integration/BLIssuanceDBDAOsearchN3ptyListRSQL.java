/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : BLIssuanceDBDAOsearchN3ptyListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.12.10
*@LastModifier : 
*@LastVersion : 1.0
* 2014.12.10 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BLIssuanceDBDAOsearchN3ptyListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * BLIssuanceDBDAOsearchN3ptyListRSQL
	  * </pre>
	  */
	public BLIssuanceDBDAOsearchN3ptyListRSQL(){
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
		query.append("Path : com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.integration").append("\n"); 
		query.append("FileName : BLIssuanceDBDAOsearchN3ptyListRSQL").append("\n"); 
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
		query.append("SELECT DISTINCT RT.BKG_NO,RT.N3PTY_RCV_OFC_CD AS N3PTY_OFC_CD" ).append("\n"); 
		query.append("     ,RT.N3PTY_CUST_CNT_CD AS PAYR_CUST_CNT_CD" ).append("\n"); 
		query.append("     ,RT.N3PTY_CUST_SEQ AS PAYR_CUST_SEQ" ).append("\n"); 
		query.append("     ,RT.FRT_TERM_CD" ).append("\n"); 
		query.append("     ,BKG.OB_SLS_OFC_CD AS POL_OFC_CD" ).append("\n"); 
		query.append("     ,BKG.BKG_OFC_CD" ).append("\n"); 
		query.append("     ,(SELECT SUM(CHG_AMT)" ).append("\n"); 
		query.append("        FROM BKG_CHG_RT RT,BKG_BOOKING BKG" ).append("\n"); 
		query.append("       WHERE BKG.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("         AND BKG.BKG_NO = RT.BKG_NO" ).append("\n"); 
		query.append("         AND RT.N3PTY_RCV_OFC_CD IS NOT NULL" ).append("\n"); 
		query.append("         AND RT.FRT_INCL_XCLD_DIV_CD='N') AS N3PTY_BL_CHG_TTL_AMT" ).append("\n"); 
		query.append("     ,ISS.OBL_ISS_OFC_CD AS BL_ISS_OFC_CD" ).append("\n"); 
		query.append("  FROM BKG_CHG_RT RT" ).append("\n"); 
		query.append("      ,BKG_BOOKING BKG" ).append("\n"); 
		query.append("      ,BKG_BL_ISS ISS " ).append("\n"); 
		query.append(" WHERE BKG.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("   AND BKG.BKG_NO = RT.BKG_NO" ).append("\n"); 
		query.append("   AND BKG.BKG_NO = ISS.BKG_NO(+)" ).append("\n"); 
		query.append("   AND RT.N3PTY_RCV_OFC_CD IS NOT NULL" ).append("\n"); 
		query.append("   AND RT.CHG_CD = 'OFT'   " ).append("\n"); 
		query.append("   AND RT.FRT_INCL_XCLD_DIV_CD='N'" ).append("\n"); 

	}
}