/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : ContainerMovementMgtDBDAOgetBkgNoByCntrNoAndCrntVvdCdRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.08.24
*@LastModifier : 
*@LastVersion : 1.0
* 2015.08.24 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.ctm.equipmentmovementmgt.containermovementmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ContainerMovementMgtDBDAOgetBkgNoByCntrNoAndCrntVvdCdRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * .
	  * </pre>
	  */
	public ContainerMovementMgtDBDAOgetBkgNoByCntrNoAndCrntVvdCdRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("crnt_vvd_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.ctm.equipmentmovementmgt.containermovementmgt.integration").append("\n"); 
		query.append("FileName : ContainerMovementMgtDBDAOgetBkgNoByCntrNoAndCrntVvdCdRSQL").append("\n"); 
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
		query.append("SELECT BKG_NO, BB_CGO_FLG" ).append("\n"); 
		query.append("FROM (SELECT A.BKG_NO, NVL (A.BB_CGO_FLG, '') AS BB_CGO_FLG, A.CNMV_CYC_NO" ).append("\n"); 
		query.append("  FROM CTM_BKG_CNTR A," ).append("\n"); 
		query.append("       CTM_BOOKING B," ).append("\n"); 
		query.append("          (SELECT MAX(CNMV_CYC_NO) MAX_CNMV_CYC_NO, MAX(BO.OSCA_CRE_DT) MAX_OSCA_CRE_DT" ).append("\n"); 
		query.append("             FROM CTM_BKG_CNTR BC," ).append("\n"); 
		query.append("                  CTM_BOOKING BO," ).append("\n"); 
		query.append("                  CTM_BKG_VVD BV" ).append("\n"); 
		query.append("            WHERE BC.CNTR_NO = @[cntr_no]" ).append("\n"); 
		query.append("              AND BC.BKG_NO = BO.BKG_NO" ).append("\n"); 
		query.append("              AND NVL (BO.BKG_STS_CD, ' ') NOT IN ('X', 'S')" ).append("\n"); 
		query.append("              AND BV.BKG_NO = BC.BKG_NO" ).append("\n"); 
		query.append("			  AND BC.CNMV_CYC_NO <> 9998" ).append("\n"); 
		query.append("              AND BV.VSL_CD = SUBSTR(@[crnt_vvd_cd], 1, 4)" ).append("\n"); 
		query.append("              AND BV.SKD_VOY_NO = SUBSTR(@[crnt_vvd_cd], 5, 4)" ).append("\n"); 
		query.append("              AND BV.SKD_DIR_CD = SUBSTR(@[crnt_vvd_cd], 9, 1))" ).append("\n"); 
		query.append(" WHERE A.CNTR_NO = @[cntr_no]" ).append("\n"); 
		query.append("   AND A.CNMV_CYC_NO = MAX_CNMV_CYC_NO" ).append("\n"); 
		query.append("   AND A.BKG_NO = B.BKG_NO" ).append("\n"); 
		query.append("   AND NVL (B.BKG_STS_CD, ' ') NOT IN ('X', 'S')" ).append("\n"); 
		query.append("   AND ROWNUM = 1" ).append("\n"); 
		query.append("UNION" ).append("\n"); 
		query.append("SELECT /*+ ORDERED INDEX_DESC(A XAK1BKG_CONTAINER) INDEX(B XPKBKG_BOOKING) */" ).append("\n"); 
		query.append("       A.BKG_NO, NVL (A.BB_CGO_FLG, '') AS BB_CGO_FLG, A.CNMV_CYC_NO" ).append("\n"); 
		query.append("  FROM BKG_CONTAINER A," ).append("\n"); 
		query.append("       BKG_BOOKING B" ).append("\n"); 
		query.append(" WHERE A.CNTR_NO = @[cntr_no]" ).append("\n"); 
		query.append("   AND A.CNMV_CYC_NO =" ).append("\n"); 
		query.append("          (SELECT /*+ ORDERED INDEX_DESC(BC XAK1BKG_CONTAINER) INDEX(BO XPKBKG_BOOKING) */" ).append("\n"); 
		query.append("                  MAX (CNMV_CYC_NO)" ).append("\n"); 
		query.append("             FROM BKG_CONTAINER BC," ).append("\n"); 
		query.append("                  BKG_BOOKING BO" ).append("\n"); 
		query.append("            WHERE BC.CNTR_NO = @[cntr_no]" ).append("\n"); 
		query.append("              AND BC.BKG_NO = BO.BKG_NO" ).append("\n"); 
		query.append("              AND NVL (BO.BKG_STS_CD, ' ') NOT IN ('X', 'S'))" ).append("\n"); 
		query.append("   AND A.BKG_NO = B.BKG_NO" ).append("\n"); 
		query.append("   AND NVL (B.BKG_STS_CD, ' ') NOT IN ('X', 'S')" ).append("\n"); 
		query.append("   AND ROWNUM = 1" ).append("\n"); 
		query.append("ORDER BY CNMV_CYC_NO DESC )" ).append("\n"); 
		query.append("WHERE ROWNUM=1" ).append("\n"); 

	}
}