/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : BkgCopManageDBDAOCheckCopToBeCanceledRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.07.11
*@LastModifier : 김성욱
*@LastVersion : 1.0
* 2016.07.11 김성욱
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.sce.bkgcopmanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Sung-Wook Kim
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BkgCopManageDBDAOCheckCopToBeCanceledRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * container detach �맆 �븣 �샇異쒗븯�뿬 COP 媛� bkg qty 蹂대떎 �뜑 珥덇낵�릺�뼱 議댁옱�븷 寃쎌슦�뿉�뒗 container detach �맂 COP 瑜� cancel �떆�궓�떎.
	  * </pre>
	  */
	public BkgCopManageDBDAOCheckCopToBeCanceledRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cop_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.sce.bkgcopmanage.integration").append("\n"); 
		query.append("FileName : BkgCopManageDBDAOCheckCopToBeCanceledRSQL").append("\n"); 
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
		query.append("WITH RMN_COP AS (" ).append("\n"); 
		query.append("    SELECT A.BKG_NO," ).append("\n"); 
		query.append("           B.CNTR_TPSZ_CD," ).append("\n"); 
		query.append("           COUNT(*) AS CNTR_QTY" ).append("\n"); 
		query.append("      FROM (SELECT BKG_NO," ).append("\n"); 
		query.append("                   COP_NO," ).append("\n"); 
		query.append("                   CNTR_TPSZ_CD" ).append("\n"); 
		query.append("              FROM SCE_COP_HDR" ).append("\n"); 
		query.append("             WHERE COP_NO = @[cop_no]" ).append("\n"); 
		query.append("           ) A," ).append("\n"); 
		query.append("           SCE_COP_HDR B," ).append("\n"); 
		query.append("           BKG_BOOKING C," ).append("\n"); 
		query.append("           SCE_COP_CNTR_REPO_RULE D" ).append("\n"); 
		query.append("     WHERE A.BKG_NO = B.BKG_NO" ).append("\n"); 
		query.append("       AND A.BKG_NO = C.BKG_NO" ).append("\n"); 
		query.append("       AND A.CNTR_TPSZ_CD = D.CNTR_TPSZ_CD (+)" ).append("\n"); 
		query.append("       AND B.COP_NO != @[cop_no]" ).append("\n"); 
		query.append("       AND B.COP_STS_CD != 'X'" ).append("\n"); 
		query.append("       AND (CASE WHEN C.FLEX_HGT_FLG = 'Y' AND B.CNTR_TPSZ_CD = D.PROV_CNTR_TPSZ_CD AND A.CNTR_TPSZ_CD != B.CNTR_TPSZ_CD THEN 'TRUE' " ).append("\n"); 
		query.append("                 WHEN A.CNTR_TPSZ_CD = B.CNTR_TPSZ_CD THEN 'TRUE' " ).append("\n"); 
		query.append("                 ELSE 'FALSE' " ).append("\n"); 
		query.append("             END) = 'TRUE'" ).append("\n"); 
		query.append("       AND NOT EXISTS (SELECT 'X' FROM SCE_PLN_SO_LIST" ).append("\n"); 
		query.append("                        WHERE COP_NO = @[cop_no]" ).append("\n"); 
		query.append("                          AND TRSP_SO_STS_CD IN ('C','R','I')" ).append("\n"); 
		query.append("                      )" ).append("\n"); 
		query.append("     GROUP BY A.BKG_NO, B.CNTR_TPSZ_CD " ).append("\n"); 
		query.append(") " ).append("\n"); 
		query.append("SELECT CASE WHEN SUM(CEIL(B.OP_CNTR_QTY)) <= MAX(D.SUM_CNTR_QTY) THEN 'CANCEL' " ).append("\n"); 
		query.append("            ELSE 'REMAIN' " ).append("\n"); 
		query.append("        END AS CHK_RSLT" ).append("\n"); 
		query.append("  FROM BKG_QUANTITY B," ).append("\n"); 
		query.append("       RMN_COP C," ).append("\n"); 
		query.append("       (SELECT SUM(CNTR_QTY) AS SUM_CNTR_QTY" ).append("\n"); 
		query.append("          FROM RMN_COP" ).append("\n"); 
		query.append("       ) D" ).append("\n"); 
		query.append(" WHERE B.BKG_NO = C.BKG_NO" ).append("\n"); 
		query.append("   AND B.CNTR_TPSZ_CD = C.CNTR_TPSZ_CD" ).append("\n"); 

	}
}