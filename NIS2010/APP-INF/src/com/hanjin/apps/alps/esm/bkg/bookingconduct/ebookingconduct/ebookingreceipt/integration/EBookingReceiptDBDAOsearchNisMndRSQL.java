/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EBookingReceiptDBDAOsearchNisMndRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.12.15
*@LastModifier : 민동진
*@LastVersion : 1.0
* 2009.12.15 민동진
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Min, DongJin
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class EBookingReceiptDBDAOsearchNisMndRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchNisMnd
	  * </pre>
	  */
	public EBookingReceiptDBDAOsearchNisMndRSQL(){
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
		query.append("Path : com.hanjin.apps.alps.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.integration").append("\n"); 
		query.append("FileName : EBookingReceiptDBDAOsearchNisMndRSQL").append("\n"); 
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
		query.append("SELECT MKDESC.MK_DESC" ).append("\n"); 
		query.append(", PCK_QTY" ).append("\n"); 
		query.append(", PCK_TP_CD" ).append("\n"); 
		query.append(", (SELECT PCK_NM FROM MDM_PCK_TP WHERE PCK_CD=BL.PCK_TP_CD) PCK_NM" ).append("\n"); 
		query.append(", ACT_WGT" ).append("\n"); 
		query.append(", WGT_UT_CD" ).append("\n"); 
		query.append(", ACT_WGT_PRN_FLG" ).append("\n"); 
		query.append(", MEAS_QTY" ).append("\n"); 
		query.append(", MEAS_UT_CD" ).append("\n"); 
		query.append(", MKDESC.CMDT_DESC" ).append("\n"); 
		query.append(", PCK_CMDT_DESC" ).append("\n"); 
		query.append(", CNTR_CMDT_DESC" ).append("\n"); 
		query.append(", CSTMS_DESC" ).append("\n"); 
		query.append(", TTL_PCK_DESC" ).append("\n"); 
		query.append(", (SELECT BKG_JOIN_FNC(CURSOR(SELECT A1.OP_CNTR_QTY || 'X' || SUBSTR(A2.CNTR_TPSZ_DESC, 1, 4)" ).append("\n"); 
		query.append("FROM BKG_QUANTITY A1, MDM_CNTR_TP_SZ A2" ).append("\n"); 
		query.append("WHERE A1.BKG_NO = BL.BKG_NO" ).append("\n"); 
		query.append("AND A1.CNTR_TPSZ_CD = A2.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("AND A1.CNTR_TPSZ_CD <> 'Q2'" ).append("\n"); 
		query.append("AND A1.CNTR_TPSZ_CD <> 'Q4'), ',')" ).append("\n"); 
		query.append("||' CONTAINER(S) SAID TO CONTAIN:' FROM DUAL) CNTR_DESC" ).append("\n"); 
		query.append(", DECODE((SELECT 'Y'" ).append("\n"); 
		query.append("FROM BKG_XPT_IMP_LIC" ).append("\n"); 
		query.append("WHERE BKG_NO = BL.BKG_NO" ).append("\n"); 
		query.append("AND ROWNUM = 1), 'Y', 'Y', 'N') XPT_IMP --EXPORT IMPORT INFORMATION 활성화 FLAG" ).append("\n"); 
		query.append(", DECODE((SELECT 'Y'" ).append("\n"); 
		query.append("FROM BKG_REF_DTL" ).append("\n"); 
		query.append("WHERE BKG_NO = BL.BKG_NO" ).append("\n"); 
		query.append("AND ROWNUM = 1" ).append("\n"); 
		query.append("UNION" ).append("\n"); 
		query.append("SELECT 'Y'" ).append("\n"); 
		query.append("FROM BKG_REFERENCE" ).append("\n"); 
		query.append("WHERE BKG_REF_TP_CD IN ('BKPO', 'CTPO', 'CMPO')" ).append("\n"); 
		query.append("AND BKG_NO = BL.BKG_NO" ).append("\n"); 
		query.append("AND ROWNUM = 1), 'Y', 'Y', 'N') PO_NO --P/O OTHER NO" ).append("\n"); 
		query.append(", DECODE((SELECT 'Y'" ).append("\n"); 
		query.append("FROM BKG_IMG_STO" ).append("\n"); 
		query.append("WHERE RIDR_TP_CD = 'B'" ).append("\n"); 
		query.append("AND BKG_NO = BL.BKG_NO" ).append("\n"); 
		query.append("AND ROWNUM = 1), 'Y', 'Y', 'N') RIDER --B/L RIDER" ).append("\n"); 
		query.append("FROM BKG_BL_DOC BL, BKG_BL_MK_DESC MKDESC" ).append("\n"); 
		query.append("WHERE BL.BKG_NO = MKDESC.BKG_NO(+)" ).append("\n"); 
		query.append("AND BL.BKG_NO = @[bkg_no]" ).append("\n"); 

	}
}