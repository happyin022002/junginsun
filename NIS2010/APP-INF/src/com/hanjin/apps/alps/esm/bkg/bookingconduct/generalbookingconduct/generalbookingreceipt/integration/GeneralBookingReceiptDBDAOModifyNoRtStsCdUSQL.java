/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : GeneralBookingReceiptDBDAOModifyNoRtStsCdUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.10.30
*@LastModifier : 
*@LastVersion : 1.0
* 2014.10.30 
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

public class GeneralBookingReceiptDBDAOModifyNoRtStsCdUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * BKG_BOOKING 테이블의 NO_RT_STS_CD 를 업데이트 한다.
	  * </pre>
	  */
	public GeneralBookingReceiptDBDAOModifyNoRtStsCdUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("no_rt_sts_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("upd_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.integration").append("\n"); 
		query.append("FileName : GeneralBookingReceiptDBDAOModifyNoRtStsCdUSQL").append("\n"); 
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
		query.append("#if (${ca_flg}== 'Y') " ).append("\n"); 
		query.append("UPDATE BKG_BKG_HIS BK" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("UPDATE BKG_BOOKING BK" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("   SET NON_RT_STS_CD = @[no_rt_sts_cd]" ).append("\n"); 
		query.append("	 , UPD_USR_ID    = @[upd_usr_id]" ).append("\n"); 
		query.append("	 , UPD_DT        = SYSDATE" ).append("\n"); 
		query.append(" WHERE BKG_NO        = @[bkg_no]" ).append("\n"); 
		query.append("   AND BKG_CRE_DT > = (SELECT NVL( ( SELECT TO_DATE(NVL(ATTR_CTNT3,'1000/01/01 00:00'),'YYYY/MM/DD HH24:MI')" ).append("\n"); 
		query.append("                                      FROM BKG_HRD_CDG_CTNT ON_OFF" ).append("\n"); 
		query.append("                                     WHERE ON_OFF.HRD_CDG_ID = 'BKG_VALIDATION'" ).append("\n"); 
		query.append("                                       AND ON_OFF.ATTR_CTNT1 = 'NON_RT_STS_CD_DT'" ).append("\n"); 
		query.append("                                       AND ON_OFF.ATTR_CTNT2 = 'ON'" ).append("\n"); 
		query.append("                                       AND ROWNUM = 1 )" ).append("\n"); 
		query.append("                                , TO_DATE('9999/01/01 00:00','YYYY/MM/DD HH24:MI'))" ).append("\n"); 
		query.append("                        FROM DUAL )" ).append("\n"); 
		query.append("#if (${ca_flg}== 'Y') " ).append("\n"); 
		query.append("   AND CORR_NO = 'TMP0000001' " ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}