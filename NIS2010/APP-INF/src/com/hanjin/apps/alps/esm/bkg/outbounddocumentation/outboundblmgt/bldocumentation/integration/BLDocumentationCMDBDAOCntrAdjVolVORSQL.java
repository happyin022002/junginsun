/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : BLDocumentationCMDBDAOCntrAdjVolVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.12.04
*@LastModifier : 김영출
*@LastVersion : 1.0
* 2009.12.04 김영출
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

public class BLDocumentationCMDBDAOCntrAdjVolVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  *    
	  * </pre>
	  */
	public BLDocumentationCMDBDAOCntrAdjVolVORSQL(){
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
		params.put("cntr_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.integration").append("\n"); 
		query.append("FileName : BLDocumentationCMDBDAOCntrAdjVolVORSQL").append("\n"); 
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
		query.append("SELECT C.BKG_NO" ).append("\n"); 
		query.append(",      (SELECT OP_CNTR_QTY FROM BKG_QUANTITY WHERE BKG_NO=B.BKG_NO AND CNTR_TPSZ_CD=C.CNTR_TPSZ_CD) BKG_VOL" ).append("\n"); 
		query.append(",      C.CNTR_NO" ).append("\n"); 
		query.append(",      C.CNTR_TPSZ_CD" ).append("\n"); 
		query.append(",      C.CNTR_VOL_QTY" ).append("\n"); 
		query.append(",      '' ADJ_VOL_QTY" ).append("\n"); 
		query.append(",      DECODE(NVL((SELECT COUNT(TRSP_SO_STS_CD)" ).append("\n"); 
		query.append("FROM   TRS_TRSP_SVC_ORD" ).append("\n"); 
		query.append("WHERE  BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("AND EQ_NO = @[cntr_no]" ).append("\n"); 
		query.append("AND DELT_FLG = 'N'" ).append("\n"); 
		query.append("AND NVL(TRSP_FRST_FLG, 'N') = 'N'), 0)," ).append("\n"); 
		query.append("'0', 'N'," ).append("\n"); 
		query.append("'Y')" ).append("\n"); 
		query.append("SO_FLG" ).append("\n"); 
		query.append(",      DECODE(NVL((SELECT SUM (CNT)" ).append("\n"); 
		query.append("FROM   (SELECT COUNT(DCGO_SEQ) CNT" ).append("\n"); 
		query.append("FROM   BKG_DG_CGO" ).append("\n"); 
		query.append("WHERE  BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT COUNT(AWK_CGO_SEQ) CNT" ).append("\n"); 
		query.append("FROM   BKG_AWK_CGO" ).append("\n"); 
		query.append("WHERE  BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT COUNT(BB_CGO_SEQ) CNT" ).append("\n"); 
		query.append("FROM   BKG_BB_CGO" ).append("\n"); 
		query.append("WHERE  BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT COUNT(RC_SEQ) CNT" ).append("\n"); 
		query.append("FROM   BKG_RF_CGO" ).append("\n"); 
		query.append("WHERE  BKG_NO = @[bkg_no])), 0)," ).append("\n"); 
		query.append("'0', 'N'," ).append("\n"); 
		query.append("'Y')" ).append("\n"); 
		query.append("SPCL_FLG" ).append("\n"); 
		query.append(",      '' CRE_USR_ID" ).append("\n"); 
		query.append(",      '' UPD_USR_ID" ).append("\n"); 
		query.append("FROM   BKG_BOOKING A, BKG_BOOKING B, BKG_CONTAINER C" ).append("\n"); 
		query.append("WHERE  A.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("AND A.VSL_CD = B.VSL_CD" ).append("\n"); 
		query.append("AND A.SKD_VOY_NO = B.SKD_VOY_NO" ).append("\n"); 
		query.append("AND A.SKD_DIR_CD = B.SKD_DIR_CD" ).append("\n"); 
		query.append("AND A.BKG_CGO_TP_CD = B.BKG_CGO_TP_CD" ).append("\n"); 
		query.append("AND A.POL_CD = B.POL_CD" ).append("\n"); 
		query.append("AND A.POD_CD = B.POD_CD" ).append("\n"); 
		query.append("AND B.BKG_NO = C.BKG_NO" ).append("\n"); 
		query.append("AND B.BKG_STS_CD IN ('W', 'F')" ).append("\n"); 
		query.append("AND C.CNTR_NO = @[cntr_no]" ).append("\n"); 
		query.append("ORDER BY C.CNTR_DP_SEQ" ).append("\n"); 

	}
}