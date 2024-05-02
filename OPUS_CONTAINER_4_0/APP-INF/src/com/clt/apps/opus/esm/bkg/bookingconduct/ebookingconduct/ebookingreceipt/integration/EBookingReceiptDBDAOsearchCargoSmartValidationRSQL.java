/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : EBookingReceiptDBDAOsearchCargoSmartValidationRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.01.06
*@LastModifier : 
*@LastVersion : 1.0
* 2017.01.06 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class EBookingReceiptDBDAOsearchCargoSmartValidationRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchXterBkgAck
	  * </pre>
	  */
	public EBookingReceiptDBDAOsearchCargoSmartValidationRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("edi_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.integration").append("\n"); 
		query.append("FileName : EBookingReceiptDBDAOsearchCargoSmartValidationRSQL").append("\n"); 
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
		query.append("SELECT" ).append("\n"); 
		query.append("	VGM.XTER_VGM_RQST_SEQ," ).append("\n"); 
		query.append("  	CASE " ).append("\n"); 
		query.append("    WHEN (SELECT" ).append("\n"); 
		query.append("            COUNT(BKG.BKG_NO) CNT" ).append("\n"); 
		query.append("          FROM BKG_BOOKING BKG, BKG_CONTAINER CNT" ).append("\n"); 
		query.append("          WHERE BKG.BKG_NO = (SELECT REF_NO FROM BKG_XTER_VGM_REF_NO WHERE XTER_SNDR_ID = VGM.XTER_SNDR_ID AND XTER_VGM_DOC_ID = VGM.XTER_VGM_DOC_ID AND XTER_VGM_RQST_SEQ = VGM.XTER_VGM_RQST_SEQ AND CNTR_NO = VGM.CNTR_NO AND XTER_REF_TP_CD = 'BN' AND ROWNUM = 1)" ).append("\n"); 
		query.append("          AND BKG.BKG_NO = CNT.BKG_NO" ).append("\n"); 
		query.append("          AND BKG_STS_CD <> 'X'" ).append("\n"); 
		query.append("          AND CNT.CNTR_NO = VGM.CNTR_NO) = 0 THEN '2'" ).append("\n"); 
		query.append("    WHEN VGM.RQST_DT - 1 > SYSDATE  THEN '3'" ).append("\n"); 
		query.append("    WHEN (SELECT MST_SPEC_FNC('TARE',VGM.CNTR_NO) TARE FROM DUAL) >= DECODE(VGM.WGT_UT_CD, 'LBS', VGM.VGM_WGT*0.453592, VGM.VGM_WGT)  THEN '4'" ).append("\n"); 
		query.append("    WHEN (SELECT MST_SPEC_FNC('GRSS',VGM.CNTR_NO) GRSS FROM DUAL) < DECODE(VGM.WGT_UT_CD, 'LBS', VGM.VGM_WGT*0.453592, VGM.VGM_WGT) THEN '5'" ).append("\n"); 
		query.append("  ELSE '1'" ).append("\n"); 
		query.append("  END RES_TP_CD" ).append("\n"); 
		query.append("FROM BKG_XTER_VGM_RQST VGM" ).append("\n"); 
		query.append("WHERE VGM.EDI_MSG_PROC_ID = @[edi_no]" ).append("\n"); 

	}
}