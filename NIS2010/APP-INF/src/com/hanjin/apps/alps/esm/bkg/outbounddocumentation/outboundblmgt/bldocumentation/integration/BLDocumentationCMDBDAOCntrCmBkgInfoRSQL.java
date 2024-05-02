/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : BLDocumentationCMDBDAOCntrCmBkgInfoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.20
*@LastModifier : 김영출
*@LastVersion : 1.0
* 2009.11.20 김영출
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

public class BLDocumentationCMDBDAOCntrCmBkgInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * select
	  * </pre>
	  */
	public BLDocumentationCMDBDAOCntrCmBkgInfoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vvd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.integration").append("\n"); 
		query.append("FileName : BLDocumentationCMDBDAOCntrCmBkgInfoRSQL").append("\n"); 
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
		query.append("SELECT A.BKG_NO" ).append("\n"); 
		query.append(",      A.BL_NO" ).append("\n"); 
		query.append(",      A.BL_TP_CD" ).append("\n"); 
		query.append(",      A.BKG_STS_CD" ).append("\n"); 
		query.append(",      A.BKG_CGO_TP_CD" ).append("\n"); 
		query.append(",      A.VSL_CD" ).append("\n"); 
		query.append(",      A.SKD_VOY_NO" ).append("\n"); 
		query.append(",      A.SKD_DIR_CD" ).append("\n"); 
		query.append(",      A.RCV_TERM_CD" ).append("\n"); 
		query.append(",      A.DE_TERM_CD" ).append("\n"); 
		query.append(",      A.POR_CD" ).append("\n"); 
		query.append(",      A.POL_CD" ).append("\n"); 
		query.append(",      A.POD_CD" ).append("\n"); 
		query.append(",      A.DEL_CD" ).append("\n"); 
		query.append(",      A.CMDT_CD" ).append("\n"); 
		query.append(",      A.REP_CMDT_CD" ).append("\n"); 
		query.append(",      (SELECT CMDT_NM FROM MDM_COMMODITY WHERE CMDT_CD=A.CMDT_CD) CMDT_NM" ).append("\n"); 
		query.append(",      (SELECT BDR_FLG FROM BKG_BL_DOC WHERE BKG_NO=A.BKG_NO) BDR_FLG" ).append("\n"); 
		query.append(",      (SELECT OBL_ISS_FLG FROM BKG_BL_ISS WHERE BKG_NO=A.BKG_NO) OBL_ISS_FLG" ).append("\n"); 
		query.append(",      B.CNTR_NO" ).append("\n"); 
		query.append(",      B.PCK_QTY" ).append("\n"); 
		query.append(",      B.PCK_TP_CD" ).append("\n"); 
		query.append(",      B.CNTR_WGT" ).append("\n"); 
		query.append(",      B.WGT_UT_CD" ).append("\n"); 
		query.append(",      B.MEAS_QTY" ).append("\n"); 
		query.append(",      B.MEAS_UT_CD" ).append("\n"); 
		query.append(",      B.CNTR_VOL_QTY" ).append("\n"); 
		query.append(",      B.RCV_TERM_CD" ).append("\n"); 
		query.append(",      B.DE_TERM_CD" ).append("\n"); 
		query.append(",      B.DCGO_FLG" ).append("\n"); 
		query.append(",      B.AWK_CGO_FLG" ).append("\n"); 
		query.append(",      B.HNGR_FLG" ).append("\n"); 
		query.append(",      B.MF_CFM_FLG" ).append("\n"); 
		query.append(",      B.CNTR_DP_SEQ" ).append("\n"); 
		query.append(",      B.CRE_USR_ID" ).append("\n"); 
		query.append(",      B.UPD_USR_ID" ).append("\n"); 
		query.append("FROM   BKG_BOOKING A, BKG_CONTAINER B" ).append("\n"); 
		query.append("WHERE  A.BKG_NO = B.BKG_NO" ).append("\n"); 
		query.append("AND    B.CNTR_NO = @[cntr_no]" ).append("\n"); 
		query.append("AND    A.VSL_CD || A.SKD_VOY_NO || A.SKD_DIR_CD = @[vvd]" ).append("\n"); 
		query.append("AND    A.BKG_STS_CD <> 'X'" ).append("\n"); 
		query.append("ORDER BY A.BKG_NO, B.CNTR_DP_SEQ" ).append("\n"); 

	}
}