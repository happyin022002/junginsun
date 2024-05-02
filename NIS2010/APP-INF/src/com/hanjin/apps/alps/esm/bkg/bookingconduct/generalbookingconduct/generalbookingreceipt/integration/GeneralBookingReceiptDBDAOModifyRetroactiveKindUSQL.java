/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : GeneralBookingReceiptDBDAOModifyRetroactiveKindUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.02.12
*@LastModifier : 
*@LastVersion : 1.0
* 2015.02.12 
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

public class GeneralBookingReceiptDBDAOModifyRetroactiveKindUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * PCT +1 이후 Contract No 변경여부를 기록한다.
	  * Work With Booking, Booking Status Report, Port Closing Report의 OFT Change after PCT (Retroactive Kind Code)
	  * * PCT가 현재시점 이후로 변경될 경우 RTRO_KND_CD를 리셋한다.
	  * </pre>
	  */
	public GeneralBookingReceiptDBDAOModifyRetroactiveKindUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("taa_no_old",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("sc_no_old",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sc_no",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("rfa_no_old",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rfa_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.integration").append("\n"); 
		query.append("FileName : GeneralBookingReceiptDBDAOModifyRetroactiveKindUSQL").append("\n"); 
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
		query.append("#if (${ca_flg}== 'Y')" ).append("\n"); 
		query.append("UPDATE BKG_BKG_HIS SET " ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("UPDATE BKG_BOOKING SET " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("    RTRO_KND_CD = CASE WHEN PORT_CLZ_DT > GLOBALDATE_PKG.TIME_CONV_FNC('KRSEL', SYSDATE, POR_CD) THEN NULL" ).append("\n"); 
		query.append("                       WHEN PORT_CLZ_DT + 1 < GLOBALDATE_PKG.TIME_CONV_FNC('KRSEL', SYSDATE, POR_CD)" ).append("\n"); 
		query.append("                            AND ( @[sc_no_old] <> @[sc_no] OR @[rfa_no_old] <> @[rfa_no] OR @[taa_no_old] <> @[taa_no])" ).append("\n"); 
		query.append("                            THEN 'C'" ).append("\n"); 
		query.append("                       ELSE RTRO_KND_CD" ).append("\n"); 
		query.append("                  END," ).append("\n"); 
		query.append("    RTRO_REF_DT = CASE WHEN PORT_CLZ_DT + 1 < GLOBALDATE_PKG.TIME_CONV_FNC('KRSEL', SYSDATE, POR_CD)" ).append("\n"); 
		query.append("                            AND ( @[sc_no_old] <> @[sc_no] OR @[rfa_no_old] <> @[rfa_no] OR @[taa_no_old] <> @[taa_no])" ).append("\n"); 
		query.append("                            THEN PORT_CLZ_DT" ).append("\n"); 
		query.append("                       ELSE RTRO_REF_DT" ).append("\n"); 
		query.append("                  END," ).append("\n"); 
		query.append("    RTRO_UPD_DT = CASE WHEN PORT_CLZ_DT + 1 < GLOBALDATE_PKG.TIME_CONV_FNC('KRSEL', SYSDATE, POR_CD)" ).append("\n"); 
		query.append("                            AND ( @[sc_no_old] <> @[sc_no] OR @[rfa_no_old] <> @[rfa_no] OR @[taa_no_old] <> @[taa_no])" ).append("\n"); 
		query.append("                            THEN SYSDATE" ).append("\n"); 
		query.append("                       ELSE RTRO_UPD_DT" ).append("\n"); 
		query.append("                  END" ).append("\n"); 
		query.append("WHERE	BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("AND SPLIT_FLG = 'N'" ).append("\n"); 
		query.append("#if (${ca_flg}== 'Y')" ).append("\n"); 
		query.append("AND   CORR_NO = 'TMP0000001'" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}