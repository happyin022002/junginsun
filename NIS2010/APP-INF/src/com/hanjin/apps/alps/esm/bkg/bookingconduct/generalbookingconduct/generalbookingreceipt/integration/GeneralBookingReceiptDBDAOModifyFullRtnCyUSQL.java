/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : GeneralBookingReceiptDBDAOModifyFullRtnCyUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.01.16
*@LastModifier : 
*@LastVersion : 1.0
* 2015.01.16 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class GeneralBookingReceiptDBDAOModifyFullRtnCyUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * FULL_RTN_CY 를 지운다.
	  * manual 로 Full Return CY 를 입력하는 베트남의 특정한 경우, 최초 생성 시 FULL_RTN_CY 를 공란으로 하기 위함이다.
	  * ( 140414 한진해운 홍우리 대리의 요구 사항 )
	  * 
	  * 2015.01.16 [CHM-201433427] 
	  * Nike SC GLO902015 에 대한 Full Return CY 하드코딩 요청
	  * </pre>
	  */
	public GeneralBookingReceiptDBDAOModifyFullRtnCyUSQL(){
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
		query.append("Path : com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.integration").append("\n"); 
		query.append("FileName : GeneralBookingReceiptDBDAOModifyFullRtnCyUSQL").append("\n"); 
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
		query.append("UPDATE BKG_BOOKING BBK" ).append("\n"); 
		query.append("   SET FULL_RTN_YD_CD = DECODE(BBK.SC_NO||'^'||BBK.POR_NOD_CD,'GLO902015^THLCHY2','THLCHY6','')" ).append("\n"); 
		query.append("     , UPD_DT         = SYSDATE" ).append("\n"); 
		query.append(" WHERE BKG_NO         = @[bkg_no]" ).append("\n"); 
		query.append("   AND (( 'Y' = (SELECT NVL( ( SELECT 'Y' " ).append("\n"); 
		query.append("                                 FROM BKG_BOOKING  BK" ).append("\n"); 
		query.append("                                    , BKG_CUSTOMER SHPR " ).append("\n"); 
		query.append("                                    , ( SELECT ATTR_CTNT1 AS SHPR_CD" ).append("\n"); 
		query.append("                                             , ATTR_CTNT2 AS POR_NOD_CD" ).append("\n"); 
		query.append("                                             , ATTR_CTNT3 AS POL_CD" ).append("\n"); 
		query.append("                                          FROM BKG_HRD_CDG_CTNT" ).append("\n"); 
		query.append("                                         WHERE HRD_CDG_ID  = 'MNL_FULL_RTN_CY'" ).append("\n"); 
		query.append("                                           AND ATTR_CTNT10 = 'N'" ).append("\n"); 
		query.append("                                    ) HRD_CDG" ).append("\n"); 
		query.append("                                WHERE 1=1" ).append("\n"); 
		query.append("                                  AND BK.BKG_NO = BBK.BKG_NO" ).append("\n"); 
		query.append("                                  AND BK.BKG_NO = SHPR.BKG_NO" ).append("\n"); 
		query.append("                                  AND SHPR.BKG_CUST_TP_CD = 'S'" ).append("\n"); 
		query.append("                                  AND SHPR.CUST_CNT_CD||LPAD(SHPR.CUST_SEQ,6,'0') = HRD_CDG.SHPR_CD" ).append("\n"); 
		query.append("                                  AND BK.POR_NOD_CD                               = HRD_CDG.POR_NOD_CD" ).append("\n"); 
		query.append("                                  AND BK.POL_CD                                   = HRD_CDG.POL_CD" ).append("\n"); 
		query.append("                                  AND ROWNUM = 1     " ).append("\n"); 
		query.append("                                  ),'N') MNL_FULL_RTN_YD_CD_FLG FROM DUAL ) -- GeneralBookingReceiptDBDAOmodifybkgRouteFromPrdUSQL 참고" ).append("\n"); 
		query.append("         ) OR ( BBK.SC_NO = 'GLO902015' " ).append("\n"); 
		query.append("                AND BBK.POR_NOD_CD = 'THLCHY2') -- SC no. 경우 full rtn cy 하드 코딩 " ).append("\n"); 
		query.append("       )" ).append("\n"); 

	}
}