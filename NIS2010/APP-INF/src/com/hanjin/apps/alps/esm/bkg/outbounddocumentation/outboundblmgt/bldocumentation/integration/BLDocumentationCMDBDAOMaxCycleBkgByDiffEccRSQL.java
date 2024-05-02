/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : BLDocumentationCMDBDAOMaxCycleBkgByDiffEccRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.07
*@LastModifier : 김영출
*@LastVersion : 1.0
* 2009.10.07 김영출
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Kim Youngchul
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BLDocumentationCMDBDAOMaxCycleBkgByDiffEccRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * select
	  * </pre>
	  */
	public BLDocumentationCMDBDAOMaxCycleBkgByDiffEccRSQL(){
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

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.integration").append("\n"); 
		query.append("FileName : BLDocumentationCMDBDAOMaxCycleBkgByDiffEccRSQL").append("\n"); 
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
		query.append("SELECT B4.MAX_BCNTR_CYCLE CNMV_CYC_NO" ).append("\n"); 
		query.append(",	   B4.OLD_BKG_NO BKG_NO" ).append("\n"); 
		query.append(",	   B4.OLD_BKG_CGO_TP BKG_CGO_TP_CD" ).append("\n"); 
		query.append(",	   B4.OLD_TRUNK_VVD VVD" ).append("\n"); 
		query.append("FROM   MST_CONTAINER B1, (SELECT CNTR_NO, X_CNMS_CD" ).append("\n"); 
		query.append("FROM	 (SELECT /*+INDEX_DESC(CTM_MOVEMENT XUK1CTM_MOVEMENT) */" ).append("\n"); 
		query.append("MVMT_STS_CD X_CNMS_CD" ).append("\n"); 
		query.append(",										 ROWNUM X_ROWNUM" ).append("\n"); 
		query.append(",										 CNTR_NO" ).append("\n"); 
		query.append("FROM	 CTM_MOVEMENT" ).append("\n"); 
		query.append("WHERE  CNTR_NO = @[cntr_no]" ).append("\n"); 
		query.append("AND ROWNUM <= 2)" ).append("\n"); 
		query.append("WHERE  X_ROWNUM = 2) B2, (SELECT /*+INDEX_DESC(CTM_MOVEMENT XUK1CTM_MOVEMENT) */" ).append("\n"); 
		query.append("CNTR_NO" ).append("\n"); 
		query.append(",														   CNMV_YR" ).append("\n"); 
		query.append(",														   CNMV_ID_NO" ).append("\n"); 
		query.append("FROM   CTM_MOVEMENT" ).append("\n"); 
		query.append("WHERE  CNTR_NO = @[cntr_no]" ).append("\n"); 
		query.append("AND ROWNUM = 1) B3" ).append("\n"); 
		query.append(",	   (SELECT *" ).append("\n"); 
		query.append("FROM   (SELECT A.CNTR_NO" ).append("\n"); 
		query.append(",					   A.CNMV_CYC_NO AS MAX_BCNTR_CYCLE" ).append("\n"); 
		query.append(",					   B.BKG_NO AS OLD_BKG_NO" ).append("\n"); 
		query.append(",					   B.BKG_CGO_TP_CD AS OLD_BKG_CGO_TP" ).append("\n"); 
		query.append(",					   B.VSL_CD || B.SKD_VOY_NO || B.SKD_DIR_CD AS OLD_TRUNK_VVD" ).append("\n"); 
		query.append("FROM   BKG_CONTAINER A, BKG_BOOKING B" ).append("\n"); 
		query.append("WHERE  A.CNTR_NO = @[cntr_no]" ).append("\n"); 
		query.append("AND B.BKG_NO = A.BKG_NO" ).append("\n"); 
		query.append("AND (B.BKG_NO || B.VSL_CD || B.SKD_VOY_NO || B.SKD_DIR_CD <> 'PSEUDO00001PSDO9999W')" ).append("\n"); 
		query.append("AND NVL (B.BKG_STS_CD, ' ') NOT IN ('S', 'X')" ).append("\n"); 
		query.append("ORDER BY A.CNTR_NO DESC, A.CNMV_CYC_NO DESC, B.BKG_NO DESC)" ).append("\n"); 
		query.append("WHERE  ROWNUM = 1) B4" ).append("\n"); 
		query.append("WHERE  B1.CNTR_NO = B2.CNTR_NO" ).append("\n"); 
		query.append("AND B1.CNTR_NO = B3.CNTR_NO" ).append("\n"); 
		query.append("AND B1.CNTR_NO = B4.CNTR_NO" ).append("\n"); 
		query.append("AND B1.CNTR_NO = @[cntr_no]" ).append("\n"); 

	}
}