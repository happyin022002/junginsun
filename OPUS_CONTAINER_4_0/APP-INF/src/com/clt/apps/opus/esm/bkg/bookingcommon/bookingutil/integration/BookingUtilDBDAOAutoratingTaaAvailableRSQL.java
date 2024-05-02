/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : BookingUtilDBDAOAutoratingTaaAvailableRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.06.07
*@LastModifier : 
*@LastVersion : 1.0
* 2015.06.07 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BookingUtilDBDAOAutoratingTaaAvailableRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * BookingUtilDBDAOAutoratingTaaAvailable TAA 의 customer 와 Booking Customer 가 매칭 여부 확인
	  * </pre>
	  */
	public BookingUtilDBDAOAutoratingTaaAvailableRSQL(){
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
		params.put("taa_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("date",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.integration").append("\n"); 
		query.append("FileName : BookingUtilDBDAOAutoratingTaaAvailableRSQL").append("\n"); 
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
		query.append("#if(${ca_flg} == 'Y')" ).append("\n"); 
		query.append("SELECT COALESCE(" ).append("\n"); 
		query.append("    (SELECT 'Y' FROM BKG_BKG_HIS" ).append("\n"); 
		query.append("     WHERE BKG_NO = @[bkg_no] " ).append("\n"); 
		query.append("     AND CORR_NO ='TMP0000001'" ).append("\n"); 
		query.append("     AND BKG_CTRL_PTY_CUST_CNT_CD > ' '" ).append("\n"); 
		query.append("     AND BKG_CTRL_PTY_CUST_CNT_CD||BKG_CTRL_PTY_CUST_SEQ IN (" ).append("\n"); 
		query.append("    															SELECT MN.CTRT_CUST_CNT_CD||MN.CTRT_CUST_SEQ FROM PRI_TAA_HDR HD, PRI_TAA_MN MN" ).append("\n"); 
		query.append("															    WHERE HD.TAA_NO = @[taa_no] /* 화면에 있는 SC 사용 */" ).append("\n"); 
		query.append("															      AND HD.TAA_PROP_NO = MN.TAA_PROP_NO " ).append("\n"); 
		query.append("															      AND TO_DATE(@[date],'YYYYMMDD') BETWEEN MN.EFF_DT AND MN.EXP_DT" ).append("\n"); 
		query.append("															      AND MN.CFM_FLG ='Y' /* Confirm 된것만 사용 */" ).append("\n"); 
		query.append("    														)" ).append("\n"); 
		query.append("	)," ).append("\n"); 
		query.append("(SELECT 'Y' FROM BKG_CUST_HIS" ).append("\n"); 
		query.append("WHERE BKG_NO = @[bkg_no]   /* 화면에 BKG NO*/" ).append("\n"); 
		query.append("AND BKG_CUST_TP_CD IN ('S','C','N','F')" ).append("\n"); 
		query.append("AND CORR_NO ='TMP0000001'" ).append("\n"); 
		query.append("AND CUST_CNT_CD||CUST_SEQ IN (" ).append("\n"); 
		query.append("    SELECT MN.CTRT_CUST_CNT_CD||MN.CTRT_CUST_SEQ FROM PRI_TAA_HDR HD, PRI_TAA_MN MN" ).append("\n"); 
		query.append("    WHERE HD.TAA_NO = @[taa_no] /* 화면에 있는 SC 사용 */" ).append("\n"); 
		query.append("      AND HD.TAA_PROP_NO = MN.TAA_PROP_NO " ).append("\n"); 
		query.append("      AND TO_DATE(@[date],'YYYYMMDD') BETWEEN MN.EFF_DT AND MN.EXP_DT" ).append("\n"); 
		query.append("      AND MN.CFM_FLG ='Y' /* Confirm 된것만 사용 */" ).append("\n"); 
		query.append("    ) AND ROWNUM =1" ).append("\n"); 
		query.append("),'N') OUTPUT_TEXT" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("SELECT COALESCE(" ).append("\n"); 
		query.append("    (SELECT 'Y' FROM BKG_BOOKING" ).append("\n"); 
		query.append("     WHERE BKG_NO = @[bkg_no] " ).append("\n"); 
		query.append("     AND BKG_CTRL_PTY_CUST_CNT_CD > ' '" ).append("\n"); 
		query.append("     AND BKG_CTRL_PTY_CUST_CNT_CD||BKG_CTRL_PTY_CUST_SEQ IN (" ).append("\n"); 
		query.append("    															SELECT MN.CTRT_CUST_CNT_CD||MN.CTRT_CUST_SEQ FROM PRI_TAA_HDR HD, PRI_TAA_MN MN" ).append("\n"); 
		query.append("															    WHERE HD.TAA_NO = @[taa_no] /* 화면에 있는 SC 사용 */" ).append("\n"); 
		query.append("															      AND HD.TAA_PROP_NO = MN.TAA_PROP_NO " ).append("\n"); 
		query.append("															      AND TO_DATE(@[date],'YYYYMMDD') BETWEEN MN.EFF_DT AND MN.EXP_DT" ).append("\n"); 
		query.append("															      AND MN.CFM_FLG ='Y' /* Confirm 된것만 사용 */" ).append("\n"); 
		query.append("    														)" ).append("\n"); 
		query.append("	)," ).append("\n"); 
		query.append("(SELECT 'Y' FROM BKG_CUSTOMER" ).append("\n"); 
		query.append("WHERE BKG_NO = @[bkg_no]   /* 화면에 BKG NO*/" ).append("\n"); 
		query.append("AND BKG_CUST_TP_CD IN ('S','C','N','F')" ).append("\n"); 
		query.append("AND CUST_CNT_CD||CUST_SEQ IN (" ).append("\n"); 
		query.append("    SELECT MN.CTRT_CUST_CNT_CD||MN.CTRT_CUST_SEQ FROM PRI_TAA_HDR HD, PRI_TAA_MN MN" ).append("\n"); 
		query.append("    WHERE HD.TAA_NO = @[taa_no] /* 화면에 있는 SC 사용 */" ).append("\n"); 
		query.append("      AND HD.TAA_PROP_NO = MN.TAA_PROP_NO " ).append("\n"); 
		query.append("      AND TO_DATE(@[date],'YYYYMMDD') BETWEEN MN.EFF_DT AND MN.EXP_DT" ).append("\n"); 
		query.append("      AND MN.CFM_FLG ='Y' /* Confirm 된것만 사용 */" ).append("\n"); 
		query.append("    ) AND ROWNUM =1" ).append("\n"); 
		query.append("),'N') OUTPUT_TEXT" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}