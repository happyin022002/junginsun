/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : BLDocumentationBLDBDAOHblBkgInfoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.04.20
*@LastModifier : 
*@LastVersion : 1.0
* 2015.04.20 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BLDocumentationBLDBDAOHblBkgInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * select
	  * </pre>
	  */
	public BLDocumentationBLDBDAOHblBkgInfoRSQL(){
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
		query.append("Path : com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.integration").append("\n"); 
		query.append("FileName : BLDocumentationBLDBDAOHblBkgInfoRSQL").append("\n"); 
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
		query.append("#if (${ca_flg} == 'Y') " ).append("\n"); 
		query.append("SELECT A.BKG_NO" ).append("\n"); 
		query.append(",      A.BL_NO || NVL(A.BL_TP_CD, DECODE(C.OBL_SRND_FLG, 'Y', 'S', NULL)) AS BL_NO" ).append("\n"); 
		query.append(",      A.BL_TP_CD" ).append("\n"); 
		query.append(",      (SELECT BL_NO FROM BKG_BKG_HIS WHERE BKG_NO=A.FM_BKG_NO AND CORR_NO='TMP0000001') ORG_BL_NO" ).append("\n"); 
		query.append(",      A.POR_CD" ).append("\n"); 
		query.append(",      A.POL_CD" ).append("\n"); 
		query.append(",      A.POD_CD" ).append("\n"); 
		query.append(",      A.DEL_CD" ).append("\n"); 
		query.append(",      A.USA_CSTMS_FILE_CD" ).append("\n"); 
		query.append(",      A.CND_CSTMS_FILE_CD" ).append("\n"); 
		query.append(",      '' CND_FLG" ).append("\n"); 
		query.append(",      '' HTS_FLG" ).append("\n"); 
		query.append(",      A.BKG_STS_CD" ).append("\n"); 
		query.append(",      B.BDR_FLG" ).append("\n"); 
		query.append(",      NVL2(B.CORR_NO, 'Y', 'N') CA_FLG" ).append("\n"); 
		query.append(",      (SELECT MK_DESC FROM BKG_BL_MK_DESC_HIS WHERE BKG_NO=A.BKG_NO AND CORR_NO='TMP0000001' AND MK_SEQ=1) BKG_MK_DESC" ).append("\n"); 
		query.append(",      (SELECT CSTMS_DESC FROM BKG_BL_DOC_HIS WHERE BKG_NO=A.BKG_NO AND CORR_NO='TMP0000001') BKG_CSTMS_DESC" ).append("\n"); 
		query.append(",      B.PCK_QTY BKG_PCK_QTY" ).append("\n"); 
		query.append(",      B.PCK_TP_CD  BKG_PCK_UNIT" ).append("\n"); 
		query.append(",      B.ACT_WGT BKG_WGT_QTY" ).append("\n"); 
		query.append(",      B.WGT_UT_CD  BKG_WGT_UNIT" ).append("\n"); 
		query.append(",      B.MEAS_QTY BKG_MEAS_QTY" ).append("\n"); 
		query.append(",      B.MEAS_UT_CD BKG_MEAS_UNIT" ).append("\n"); 
		query.append("FROM   BKG_BKG_HIS A, BKG_BL_DOC_HIS B, BKG_BL_ISS_HIS C" ).append("\n"); 
		query.append("WHERE  A.BKG_NO = B.BKG_NO" ).append("\n"); 
		query.append("AND    A.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("AND    A.CORR_NO = 'TMP0000001'" ).append("\n"); 
		query.append("AND    B.CORR_NO = 'TMP0000001'" ).append("\n"); 
		query.append("AND    A.BKG_NO = C.BKG_NO(+)" ).append("\n"); 
		query.append("AND    A.CORR_NO = C.CORR_NO(+)" ).append("\n"); 
		query.append("#else " ).append("\n"); 
		query.append("SELECT A.BKG_NO" ).append("\n"); 
		query.append(",      A.BL_NO || NVL(A.BL_TP_CD, DECODE(C.OBL_SRND_FLG, 'Y', 'S', NULL)) AS BL_NO" ).append("\n"); 
		query.append(",      A.BL_TP_CD" ).append("\n"); 
		query.append(",      (SELECT BL_NO FROM BKG_BOOKING WHERE BKG_NO=A.FM_BKG_NO) ORG_BL_NO" ).append("\n"); 
		query.append(",      A.POR_CD" ).append("\n"); 
		query.append(",      A.POL_CD" ).append("\n"); 
		query.append(",      A.POD_CD" ).append("\n"); 
		query.append(",      A.DEL_CD" ).append("\n"); 
		query.append(",      A.USA_CSTMS_FILE_CD" ).append("\n"); 
		query.append(",      A.CND_CSTMS_FILE_CD" ).append("\n"); 
		query.append(",      '' CND_FLG" ).append("\n"); 
		query.append(",      '' HTS_FLG" ).append("\n"); 
		query.append(",      A.BKG_STS_CD" ).append("\n"); 
		query.append(",      B.BDR_FLG" ).append("\n"); 
		query.append(",      NVL2(B.CORR_NO, 'Y', 'N') CA_FLG" ).append("\n"); 
		query.append(",      (SELECT MK_DESC FROM BKG_BL_MK_DESC WHERE BKG_NO = A.BKG_NO AND MK_SEQ = 1) BKG_MK_DESC" ).append("\n"); 
		query.append(",      (SELECT CSTMS_DESC FROM BKG_BL_DOC WHERE BKG_NO = A.BKG_NO) BKG_CSTMS_DESC" ).append("\n"); 
		query.append(",      B.PCK_QTY BKG_PCK_QTY" ).append("\n"); 
		query.append(",      B.PCK_TP_CD  BKG_PCK_UNIT" ).append("\n"); 
		query.append(",      B.ACT_WGT BKG_WGT_QTY" ).append("\n"); 
		query.append(",      B.WGT_UT_CD  BKG_WGT_UNIT" ).append("\n"); 
		query.append(",      B.MEAS_QTY BKG_MEAS_QTY" ).append("\n"); 
		query.append(",      B.MEAS_UT_CD BKG_MEAS_UNIT" ).append("\n"); 
		query.append("FROM   BKG_BOOKING A, BKG_BL_DOC B, BKG_BL_ISS C" ).append("\n"); 
		query.append("WHERE  A.BKG_NO = B.BKG_NO" ).append("\n"); 
		query.append("AND    A.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("AND    A.BKG_NO = C.BKG_NO(+)" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}