/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : EBookingReceiptDBDAOsearchBlIssCompleteRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.01.23
*@LastModifier : 
*@LastVersion : 1.0
* 2013.01.23 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class EBookingReceiptDBDAOsearchBlIssCompleteRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 해당 bkg의 e-bkg 수신시 BL Issue 관련 마지막 상태가 Complete인지 조회
	  * </pre>
	  */
	public EBookingReceiptDBDAOsearchBlIssCompleteRSQL(){
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
		query.append("FileName : EBookingReceiptDBDAOsearchBlIssCompleteRSQL").append("\n"); 
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
		query.append("SELECT   BKG_NO" ).append("\n"); 
		query.append(", BKG_DOC_PROC_TP_CD" ).append("\n"); 
		query.append("FROM BKG_DOC_PROC_SKD BDPS" ).append("\n"); 
		query.append("WHERE BDPS.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("AND   BDPS.BKG_DOC_PROC_TP_CD = 'BLCMPC'" ).append("\n"); 
		query.append("AND BDPS.DOC_PERF_DELT_FLG = 'N'" ).append("\n"); 
		query.append("AND EXISTS (SELECT 'X'" ).append("\n"); 
		query.append("FROM BKG_BL_ISS BBI" ).append("\n"); 
		query.append("WHERE BBI.BKG_NO = BDPS.BKG_NO" ).append("\n"); 
		query.append("AND BBI.BL_RDY_FLG = 'N')" ).append("\n"); 

	}
}