/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : BLIssuanceDBDAOsearchDblEdiHpNameFlgRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.08.31
*@LastModifier : 
*@LastVersion : 1.0
* 2016.08.31 
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

public class BLIssuanceDBDAOsearchDblEdiHpNameFlgRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * hp
	  * </pre>
	  */
	public BLIssuanceDBDAOsearchDblEdiHpNameFlgRSQL(){
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
		query.append("FileName : BLIssuanceDBDAOsearchDblEdiHpNameFlgRSQL").append("\n"); 
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
		query.append("SELECT  " ).append("\n"); 
		query.append("       'HP_ASIA_FLG:' || (SELECT 'Y' FROM BKG_CHG_RT RT" ).append("\n"); 
		query.append("                                                        WHERE RT.BKG_NO = @[bkg_no] " ).append("\n"); 
		query.append("                                                        AND ((FRT_INCL_XCLD_DIV_CD ='N' " ).append("\n"); 
		query.append("                                                            AND N3PTY_RCV_OFC_CD IN ('SINSC')" ).append("\n"); 
		query.append("                                                            AND N3PTY_CUST_CNT_CD IN ('SG')" ).append("\n"); 
		query.append("                                                            AND N3PTY_CUST_SEQ IN ( 17434 ))" ).append("\n"); 
		query.append("                                                         OR" ).append("\n"); 
		query.append("                                                        (EXISTS (SELECT 1 FROM BKG_RATE " ).append("\n"); 
		query.append("                                                                            WHERE BKG_NO = RT.BKG_NO " ).append("\n"); 
		query.append("                                                                            AND (    PPD_RCV_OFC_CD IN ('SINSC') AND PPD_PAYR_CNT_CD IN ('SG') AND PPD_PAYR_CUST_SEQ IN (17434)" ).append("\n"); 
		query.append("                                                                                  OR CLT_OFC_CD IN ('SINSC') AND CLT_PAYR_CNT_CD IN ('SG') AND CLT_PAYR_CUST_SEQ IN(17434))                                                                           " ).append("\n"); 
		query.append("                                                        )))" ).append("\n"); 
		query.append("                                                        AND ROWNUM = 1)                            || CHR(10) " ).append("\n"); 
		query.append("       || 'HP_SIN_FLG:'        || (SELECT 'Y' FROM BKG_CHG_RT RT" ).append("\n"); 
		query.append("                                                        WHERE RT.BKG_NO = @[bkg_no]  " ).append("\n"); 
		query.append("                                                        AND ((FRT_INCL_XCLD_DIV_CD ='N' " ).append("\n"); 
		query.append("                                                            AND N3PTY_RCV_OFC_CD IN ('SINSC')" ).append("\n"); 
		query.append("                                                            AND N3PTY_CUST_CNT_CD IN ('SG')" ).append("\n"); 
		query.append("                                                            AND N3PTY_CUST_SEQ IN ( 260 ))" ).append("\n"); 
		query.append("                                                        OR " ).append("\n"); 
		query.append("                                                        (EXISTS (SELECT 1 FROM BKG_RATE " ).append("\n"); 
		query.append("                                                                            WHERE BKG_NO = RT.BKG_NO " ).append("\n"); 
		query.append("                                                                            AND (    PPD_RCV_OFC_CD IN ('SINSC') AND PPD_PAYR_CNT_CD IN ('SG') AND PPD_PAYR_CUST_SEQ IN (260)" ).append("\n"); 
		query.append("                                                                                  OR CLT_OFC_CD IN ('SINSC') AND CLT_PAYR_CNT_CD IN ('SG') AND CLT_PAYR_CUST_SEQ IN(260))                                                                           " ).append("\n"); 
		query.append("                                                        )))" ).append("\n"); 
		query.append("                                                        AND ROWNUM = 1)                            || CHR(10)" ).append("\n"); 
		query.append("        " ).append("\n"); 
		query.append("       " ).append("\n"); 
		query.append("FROM  DUAL" ).append("\n"); 

	}
}