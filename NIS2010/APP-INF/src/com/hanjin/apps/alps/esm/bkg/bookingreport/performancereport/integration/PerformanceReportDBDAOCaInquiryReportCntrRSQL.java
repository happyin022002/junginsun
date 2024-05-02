/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : PerformanceReportDBDAOCaInquiryReportCntrRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.31
*@LastModifier : 강동윤
*@LastVersion : 1.0
* 2009.10.31 강동윤
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author kang dong yun
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PerformanceReportDBDAOCaInquiryReportCntrRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * search
	  * </pre>
	  */
	public PerformanceReportDBDAOCaInquiryReportCntrRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bl_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.integration").append("\n"); 
		query.append("FileName : PerformanceReportDBDAOCaInquiryReportCntrRSQL").append("\n"); 
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
		query.append("SELECT CNT.CNTR_NO" ).append("\n"); 
		query.append(",CNT.CNTR_TPSZ_CD" ).append("\n"); 
		query.append(",BKG_JOIN_FNC(CURSOR( SELECT CNTR_SEAL_NO FROM BKG_CNTR_SEAL_NO WHERE BKG_NO = CNT.BKG_NO AND CNTR_NO = CNT.CNTR_NO)) CNTR_SEAL_NO" ).append("\n"); 
		query.append(",CNT.CNTR_PRT_FLG" ).append("\n"); 
		query.append(",CNT.RCV_TERM_CD" ).append("\n"); 
		query.append(",CNT.DE_TERM_CD" ).append("\n"); 
		query.append(",(SELECT INTG_CD_VAL_DP_DESC FROM COM_INTG_CD_DTL WHERE INTG_CD_ID = 'CD00767' AND INTG_CD_VAL_CTNT = BKG.BKG_CGO_TP_CD) BKG_CGO_TP_CD" ).append("\n"); 
		query.append(",CNT.DIFF_RMK" ).append("\n"); 
		query.append("FROM BKG_BOOKING          BKG" ).append("\n"); 
		query.append(",BKG_CONTAINER        CNT" ).append("\n"); 
		query.append("WHERE BKG.BKG_NO = CNT.BKG_NO" ).append("\n"); 
		query.append("AND BKG.BL_NO = @[bl_no]" ).append("\n"); 

	}
}