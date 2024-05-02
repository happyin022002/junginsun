/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : BLDocumentationCMDBDAOCntrCmEtcInfoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.20
*@LastModifier : 김영출
*@LastVersion : 1.0
* 2009.11.20 김영출
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Kim Youngchul
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BLDocumentationCMDBDAOCntrCmEtcInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * select
	  * </pre>
	  */
	public BLDocumentationCMDBDAOCntrCmEtcInfoRSQL(){
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
		query.append("Path : com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.integration").append("\n"); 
		query.append("FileName : BLDocumentationCMDBDAOCntrCmEtcInfoRSQL").append("\n"); 
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
		query.append("SELECT T2.*" ).append("\n"); 
		query.append("FROM   (SELECT   T1.*" ).append("\n"); 
		query.append(",                ROWNUM RN" ).append("\n"); 
		query.append(",                LAST_VALUE(T1.DEL_CD) OVER(ORDER BY ROWNUM) LV" ).append("\n"); 
		query.append("FROM     (SELECT A.BKG_NO" ).append("\n"); 
		query.append(",                        A.VSL_CD || A.SKD_VOY_NO || A.SKD_DIR_CD T_VVD" ).append("\n"); 
		query.append(",                        A.BKG_OFC_CD" ).append("\n"); 
		query.append(",                        A.POR_CD" ).append("\n"); 
		query.append(",                        A.POL_CD" ).append("\n"); 
		query.append(",                        A.POD_CD" ).append("\n"); 
		query.append(",                        DECODE(A.DEL_CD,(LAG(A.DEL_CD, 1, DEL_CD) OVER(ORDER BY B.CNTR_DP_SEQ)), A.DEL_CD, 'VAR') DEL_CD" ).append("\n"); 
		query.append(",                        BKG_JOIN_FNC(CURSOR(SELECT CNTR_SEAL_NO" ).append("\n"); 
		query.append("FROM   BKG_CNTR_SEAL_NO" ).append("\n"); 
		query.append("WHERE  BKG_NO = B.BKG_NO" ).append("\n"); 
		query.append("AND    CNTR_NO = B.CNTR_NO)) CNTR_SEAL_NO" ).append("\n"); 
		query.append(",                        B.CNTR_NO" ).append("\n"); 
		query.append(",                        B.CNTR_TPSZ_CD" ).append("\n"); 
		query.append(",                        B.RCV_TERM_CD" ).append("\n"); 
		query.append(",                        B.DE_TERM_CD" ).append("\n"); 
		query.append(",                        B.ADV_SHTG_CD" ).append("\n"); 
		query.append(",                        B.DCGO_FLG" ).append("\n"); 
		query.append(",                        B.BB_CGO_FLG" ).append("\n"); 
		query.append(",                        B.AWK_CGO_FLG" ).append("\n"); 
		query.append(",                        B.RC_FLG" ).append("\n"); 
		query.append(",                        B.RD_CGO_FLG" ).append("\n"); 
		query.append(",                        B.HNGR_FLG" ).append("\n"); 
		query.append(",                        SUM(B.PCK_QTY) OVER(PARTITION BY B.CNTR_NO) PCK_QTY" ).append("\n"); 
		query.append(",                        B.PCK_TP_CD" ).append("\n"); 
		query.append(",                        SUM(B.CNTR_WGT) OVER(PARTITION BY B.CNTR_NO) CNTR_WGT" ).append("\n"); 
		query.append(",                        B.WGT_UT_CD" ).append("\n"); 
		query.append(",                        SUM(B.MEAS_QTY) OVER(PARTITION BY B.CNTR_NO) MEAS_QTY" ).append("\n"); 
		query.append(",                        B.MEAS_UT_CD" ).append("\n"); 
		query.append(",                        B.CRE_USR_ID" ).append("\n"); 
		query.append(",                        B.UPD_USR_ID" ).append("\n"); 
		query.append("FROM   BKG_BOOKING A, BKG_CONTAINER B" ).append("\n"); 
		query.append("WHERE  A.BKG_NO = B.BKG_NO" ).append("\n"); 
		query.append("AND    A.BKG_STS_CD <> 'X'" ).append("\n"); 
		query.append("AND    B.CNTR_NO = @[cntr_no]" ).append("\n"); 
		query.append("AND    A.VSL_CD || A.SKD_VOY_NO || A.SKD_DIR_CD = @[vvd]" ).append("\n"); 
		query.append("ORDER BY B.CNTR_DP_SEQ) T1" ).append("\n"); 
		query.append("ORDER BY RN DESC) T2" ).append("\n"); 
		query.append("WHERE  rownum = 1" ).append("\n"); 

	}
}