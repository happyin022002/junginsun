/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : BookingUtilDBDAOSearchCustTpIdInfoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.12.17
*@LastModifier : 조정민
*@LastVersion : 1.0
* 2012.12.17 조정민
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author JEONGMINCHO
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BookingUtilDBDAOSearchCustTpIdInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 자동전송 Group ID와 BKG 접수 경로를 등록해 놓고 해당 될 경우 처리되게 함
	  * </pre>
	  */
	public BookingUtilDBDAOSearchCustTpIdInfoRSQL(){
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
		query.append("Path : com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.integration").append("\n"); 
		query.append("FileName : BookingUtilDBDAOSearchCustTpIdInfoRSQL").append("\n"); 
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
		query.append("SELECT GRP.CUST_TRD_PRNR_ID rcv_id" ).append("\n"); 
		query.append("      ,GRP.ESVC_GRP_CD group_id" ).append("\n"); 
		query.append("      ,CUST.CUST_CNT_CD || CUST.CUST_SEQ ref_code" ).append("\n"); 
		query.append("  FROM BKG_BOOKING BKG" ).append("\n"); 
		query.append("      ,BKG_CUSTOMER CUST" ).append("\n"); 
		query.append("      ,BKG_EDI_GRP GRP" ).append("\n"); 
		query.append("      ,BKG_EDI_GRP_CUST CGRP" ).append("\n"); 
		query.append("      ,BKG_HRD_CDG_CTNT HRD" ).append("\n"); 
		query.append(" WHERE BKG.BKG_NO = CUST.BKG_NO" ).append("\n"); 
		query.append("   AND BKG.XTER_BKG_RQST_CD = HRD.ATTR_CTNT3" ).append("\n"); 
		query.append("   AND BKG.BKG_NO = @[bkg_no] " ).append("\n"); 
		query.append("   AND HRD.HRD_CDG_ID = 'CUST_301_CHG_VVD'" ).append("\n"); 
		query.append("   AND GRP.ESVC_GRP_CD = HRD.ATTR_CTNT1" ).append("\n"); 
		query.append("   AND GRP.ESVC_GRP_CD = CGRP.ESVC_GRP_CD " ).append("\n"); 
		query.append("   AND GRP.CUST_TRD_PRNR_ID = HRD.ATTR_CTNT2" ).append("\n"); 
		query.append("   AND CUST.BKG_CUST_TP_CD = HRD.ATTR_CTNT4" ).append("\n"); 
		query.append("   AND CUST.CUST_CNT_CD = CGRP.CNT_CD" ).append("\n"); 
		query.append("   AND CUST.CUST_SEQ = CGRP.CUST_SEQ" ).append("\n"); 
		query.append("   AND CGRP.CNT_CD <> ' '" ).append("\n"); 
		query.append("   AND ROWNUM = 1" ).append("\n"); 

	}
}