/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : GeneralBookingReceiptDBDAOcheckChnDgCargoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.07.29
*@LastModifier : 김봉균
*@LastVersion : 1.0
* 2011.07.29 김봉균
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author KIM BONG GYOON
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class GeneralBookingReceiptDBDAOcheckChnDgCargoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 중국 상해 I/B DG화물 관련 MSDS 경고팝업 추가에 따른 SQL문.
	  * </pre>
	  */
	public GeneralBookingReceiptDBDAOcheckChnDgCargoRSQL(){
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
		query.append("FileName : GeneralBookingReceiptDBDAOcheckChnDgCargoRSQL").append("\n"); 
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
		query.append("SELECT DECODE( SUM(CNT), 0, 'N', 'Y') AS valFlg" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("    SELECT COUNT('X') CNT" ).append("\n"); 
		query.append("    FROM BKG_BOOKING" ).append("\n"); 
		query.append("    WHERE BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("      AND DCGO_FLG = 'Y'" ).append("\n"); 
		query.append("      AND ( SUBSTR(POR_CD, 1, 2) <> 'CN'" ).append("\n"); 
		query.append("          or POD_CD ='CNSHA' )" ).append("\n"); 
		query.append("    UNION ALL" ).append("\n"); 
		query.append("    SELECT COUNT('X')" ).append("\n"); 
		query.append("    FROM BKG_BOOKING A," ).append("\n"); 
		query.append("      BKG_VVD B" ).append("\n"); 
		query.append("    WHERE A.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("      AND A.DCGO_FLG = 'Y'" ).append("\n"); 
		query.append("      AND B.BKG_NO = A.BKG_NO" ).append("\n"); 
		query.append("      AND B.POD_CD ='CNSHA' )" ).append("\n"); 

	}
}