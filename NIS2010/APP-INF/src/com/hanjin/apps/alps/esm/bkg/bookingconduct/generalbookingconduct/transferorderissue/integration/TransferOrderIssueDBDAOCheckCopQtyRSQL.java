/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : TransferOrderIssueDBDAOCheckCopQtyRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.10.07
*@LastModifier : 
*@LastVersion : 1.0
* 2015.10.07 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.transferorderissue.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TransferOrderIssueDBDAOCheckCopQtyRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * cop qty와 tro qty 중 tro qty가 더 많은지 확인
	  * </pre>
	  */
	public TransferOrderIssueDBDAOCheckCopQtyRSQL(){
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
		params.put("cntr_tpsz_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("tro_qty",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.transferorderissue.integration").append("\n"); 
		query.append("FileName : TransferOrderIssueDBDAOCheckCopQtyRSQL").append("\n"); 
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
		query.append("SELECT CASE WHEN @[tro_qty] > CNT THEN 'Y'" ).append("\n"); 
		query.append("       ELSE 'N'" ).append("\n"); 
		query.append("       END AS CFM_BLOCK_FLG" ).append("\n"); 
		query.append("  FROM (" ).append("\n"); 
		query.append("        SELECT COUNT(*) CNT" ).append("\n"); 
		query.append("          FROM (" ).append("\n"); 
		query.append("                SELECT *" ).append("\n"); 
		query.append("                  FROM SCE_COP_HDR" ).append("\n"); 
		query.append("                 WHERE BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("                   AND COP_STS_CD <> 'X'" ).append("\n"); 
		query.append("                   AND CNTR_TPSZ_CD = @[cntr_tpsz_cd]" ).append("\n"); 
		query.append("                   AND 'N' = (SELECT FLEX_HGT_FLG FROM BKG_BOOKING WHERE BKG_NO = @[bkg_no])" ).append("\n"); 
		query.append("                UNION ALL" ).append("\n"); 
		query.append("                SELECT M.*" ).append("\n"); 
		query.append("                  FROM SCE_COP_HDR M" ).append("\n"); 
		query.append("                 WHERE M.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("                   AND M.COP_STS_CD <> 'X'" ).append("\n"); 
		query.append("                   AND M.CNTR_TPSZ_CD IN (SELECT CNTR_TPSZ_CD" ).append("\n"); 
		query.append("                                          FROM SCE_COP_CNTR_REPO_RULE" ).append("\n"); 
		query.append("                                         WHERE (CNTR_TPSZ_CD = M.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("                                            OR PROV_CNTR_TPSZ_CD = M.CNTR_TPSZ_CD)" ).append("\n"); 
		query.append("                                           AND (CNTR_TPSZ_CD = @[cntr_tpsz_cd]" ).append("\n"); 
		query.append("                                            OR PROV_CNTR_TPSZ_CD = @[cntr_tpsz_cd])" ).append("\n"); 
		query.append("                                           AND NVL(ACT_FLG, 'N') = 'Y')" ).append("\n"); 
		query.append("                   AND 'Y' = (SELECT FLEX_HGT_FLG FROM BKG_BOOKING WHERE BKG_NO = @[bkg_no])" ).append("\n"); 
		query.append("               )" ).append("\n"); 
		query.append("        )" ).append("\n"); 
		query.append(" WHERE 'ON' = (SELECT ATTR_CTNT2  " ).append("\n"); 
		query.append("                 FROM BKG_HRD_CDG_CTNT " ).append("\n"); 
		query.append("                WHERE HRD_CDG_ID = 'BKG_VALIDATION' " ).append("\n"); 
		query.append("                  AND ATTR_CTNT1 = 'TRO_QTY_CFM')" ).append("\n"); 

	}
}