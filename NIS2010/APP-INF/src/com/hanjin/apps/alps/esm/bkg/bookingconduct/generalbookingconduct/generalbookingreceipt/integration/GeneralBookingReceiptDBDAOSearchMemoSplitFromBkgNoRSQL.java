/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : GeneralBookingReceiptDBDAOSearchMemoSplitFromBkgNoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.09.03
*@LastModifier : 류대영
*@LastVersion : 1.0
* 2013.09.03 류대영
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author DYRYU
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class GeneralBookingReceiptDBDAOSearchMemoSplitFromBkgNoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 하위 BKG가 모두 Cancel 된 경우의 bkgno를 조회한다.
	  * </pre>
	  */
	public GeneralBookingReceiptDBDAOSearchMemoSplitFromBkgNoRSQL(){
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
		query.append("FileName : GeneralBookingReceiptDBDAOSearchMemoSplitFromBkgNoRSQL").append("\n"); 
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
		query.append("SELECT A.BKG_NO" ).append("\n"); 
		query.append("  FROM (" ).append("\n"); 
		query.append("        SELECT A.ROOT_BKG_NO AS BKG_NO" ).append("\n"); 
		query.append("              ,SUM(DECODE(A.BKG_STS_CD, 'X', 0, 1)) AS CNT" ).append("\n"); 
		query.append("          FROM ( SELECT CONNECT_BY_ROOT BKG_NO AS ROOT_BKG_NO" ).append("\n"); 
		query.append("                       ,BKG_NO" ).append("\n"); 
		query.append("                       ,BKG_STS_CD" ).append("\n"); 
		query.append("                       ,BL_NO_TP" ).append("\n"); 
		query.append("                   FROM BKG_BOOKING A" ).append("\n"); 
		query.append("                  WHERE CONNECT_BY_ROOT BKG_NO <> A.BKG_NO" ).append("\n"); 
		query.append("					AND A.BKG_CRE_TP_CD = 'S'" ).append("\n"); 
		query.append("                CONNECT BY PRIOR BKG_NO = FM_BKG_NO" ).append("\n"); 
		query.append("                  START WITH BKG_NO IN ( SELECT BKG_NO" ).append("\n"); 
		query.append("                                           FROM BKG_BOOKING" ).append("\n"); 
		query.append("                                          WHERE BKG_STS_CD = 'S'" ).append("\n"); 
		query.append("                                          START WITH BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("                                        CONNECT BY PRIOR FM_BKG_NO = BKG_NO)    " ).append("\n"); 
		query.append("         " ).append("\n"); 
		query.append("             ) A" ).append("\n"); 
		query.append("        WHERE BL_NO_TP = '9'" ).append("\n"); 
		query.append("        GROUP BY ROOT_BKG_NO )A" ).append("\n"); 
		query.append("      ,BKG_BOOKING B" ).append("\n"); 
		query.append(" WHERE A.BKG_NO = B.BKG_NO" ).append("\n"); 
		query.append("   AND B.BKG_STS_CD = 'S'" ).append("\n"); 
		query.append("   AND A.CNT = 0" ).append("\n"); 

	}
}