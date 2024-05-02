/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : EBookingReceiptDBDAOSearchDocRqstInterfaceRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.10.23
*@LastModifier : 
*@LastVersion : 1.0
* 2014.10.23 
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

public class EBookingReceiptDBDAOSearchDocRqstInterfaceRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * external request 처리를 위해 external rqst의 Booking 정보를 조회한다.
	  * </pre>
	  */
	public EBookingReceiptDBDAOSearchDocRqstInterfaceRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("xter_rqst_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("xter_sndr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("xter_rqst_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.integration").append("\n"); 
		query.append("FileName : EBookingReceiptDBDAOSearchDocRqstInterfaceRSQL").append("\n"); 
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
		query.append("SELECT M.BKG_NO," ).append("\n"); 
		query.append("       NVL(M.XTER_BL_TP_CD, I.RQST_BL_TP_CD) RQST_BL_TP_CD," ).append("\n"); 
		query.append("       NVL(NVL(M.INCL_RT_BL_KNT, I.OBL_RT_INCL_KNT), 0) OBL_RT_INCL_KNT," ).append("\n"); 
		query.append("       NVL(NVL(M.XCLD_RT_BL_KNT, I.OBL_RT_XCLD_KNT), 0) OBL_RT_XCLD_KNT," ).append("\n"); 
		query.append("       NVL(I.OBL_TTL_KNT, 0) OBL_TTL_KNT," ).append("\n"); 
		query.append("       NVL(NVL(M.NON_NEGO_RT_INCL_KNT, I.NON_NEGO_RT_INCL_KNT), 0) NON_NEGO_RT_INCL_KNT," ).append("\n"); 
		query.append("       NVL(NVL(M.NON_NEGO_RT_XCLD_KNT, I.NON_NEGO_RT_XCLD_KNT), 0) NON_NEGO_RT_XCLD_KNT," ).append("\n"); 
		query.append("       NVL(I.CPY_TTL_KNT, 0) CPY_TTL_KNT," ).append("\n"); 
		query.append("       NVL(M.BL_ISS_LOC_CD, I.RQST_ISS_PLC_NM) RQST_ISS_PLC_NM," ).append("\n"); 
		query.append("       TO_CHAR(NVL(M.BL_ISS_DT, RQST_ISS_DT),'YYYY-MM-DD') RQST_ISS_DT," ).append("\n"); 
		query.append("       I.BL_DE_TO_CD," ).append("\n"); 
		query.append("       I.BL_DE_MZD_CD," ).append("\n"); 
		query.append("       I.BL_DOC_RQST_RMK," ).append("\n"); 
		query.append("       '' LOC_NM," ).append("\n"); 
		query.append("       I.WBL_RT_TP_CD," ).append("\n"); 
		query.append("       I.WBL_EML" ).append("\n"); 
		query.append("FROM BKG_XTER_RQST_MST M, BKG_BL_ISS I" ).append("\n"); 
		query.append("WHERE M.BKG_NO = I.BKG_NO(+)" ).append("\n"); 
		query.append("AND M.XTER_SNDR_ID = @[xter_sndr_id]" ).append("\n"); 
		query.append("AND M.XTER_RQST_NO = @[xter_rqst_no]" ).append("\n"); 
		query.append("AND M.XTER_RQST_SEQ = @[xter_rqst_seq]" ).append("\n"); 

	}
}