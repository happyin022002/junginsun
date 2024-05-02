/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : GeneralBookingReceiptDBDAOSearchSpclNotApproveRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.12.18
*@LastModifier : Maeda Atsushi
*@LastVersion : 1.0
* 2014.12.18 Maeda Atsushi
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Maeda Atsushi
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class GeneralBookingReceiptDBDAOSearchSpclNotApproveRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * bkg에 승인되지 않은 special cargo 정보가 있는지 확인한다
	  * </pre>
	  */
	public GeneralBookingReceiptDBDAOSearchSpclNotApproveRSQL(){
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
		query.append("Path : com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.integration").append("\n"); 
		query.append("FileName : GeneralBookingReceiptDBDAOSearchSpclNotApproveRSQL").append("\n"); 
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
		query.append("select 'Y' REJECT_FLAG" ).append("\n"); 
		query.append("from " ).append("\n"); 
		query.append("    (SELECT 'Y'" ).append("\n"); 
		query.append("#if (${ca_flg}== 'Y')" ).append("\n"); 
		query.append("      FROM  bkg_dg_cgo_his" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("      FROM  bkg_dg_cgo" ).append("\n"); 
		query.append("#end    " ).append("\n"); 
		query.append("     where bkg_no = @[bkg_no]      " ).append("\n"); 
		query.append("#if (${ca_flg}== 'Y')" ).append("\n"); 
		query.append("		AND   CORR_NO = 'TMP0000001'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("       and 'N'    = spcl_cgo_apro_Cd --거절된 건" ).append("\n"); 
		query.append("       and rownum = 1                 --한 건만 거절되도 해당" ).append("\n"); 
		query.append("    UNION " ).append("\n"); 
		query.append("    SELECT 'Y'" ).append("\n"); 
		query.append("#if (${ca_flg}== 'Y')" ).append("\n"); 
		query.append("      FROM  bkg_rf_cgo_his" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("      FROM bkg_rf_cgo " ).append("\n"); 
		query.append("#end    " ).append("\n"); 
		query.append("     where bkg_no = @[bkg_no]    " ).append("\n"); 
		query.append("#if (${ca_flg}== 'Y')" ).append("\n"); 
		query.append("		AND   CORR_NO = 'TMP0000001'" ).append("\n"); 
		query.append("#end  " ).append("\n"); 
		query.append("       and 'N'    = spcl_cgo_apro_Cd " ).append("\n"); 
		query.append("       and rownum = 1" ).append("\n"); 
		query.append("    UNION " ).append("\n"); 
		query.append("    SELECT 'Y'" ).append("\n"); 
		query.append("#if (${ca_flg}== 'Y')" ).append("\n"); 
		query.append("      FROM  bkg_awk_cgo_his" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("      FROM  bkg_awk_cgo" ).append("\n"); 
		query.append("#end    " ).append("\n"); 
		query.append("     where bkg_no = @[bkg_no]  " ).append("\n"); 
		query.append("#if (${ca_flg}== 'Y')" ).append("\n"); 
		query.append("		AND   CORR_NO = 'TMP0000001'" ).append("\n"); 
		query.append("#end    " ).append("\n"); 
		query.append("       and 'N'    = spcl_cgo_apro_Cd " ).append("\n"); 
		query.append("       and rownum = 1" ).append("\n"); 
		query.append("    UNION " ).append("\n"); 
		query.append("    SELECT 'Y'" ).append("\n"); 
		query.append("#if (${ca_flg}== 'Y')" ).append("\n"); 
		query.append("      FROM  bkg_bb_cgo_his" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("      FROM  bkg_bb_cgo" ).append("\n"); 
		query.append("#end    " ).append("\n"); 
		query.append("     where bkg_no = @[bkg_no]    " ).append("\n"); 
		query.append("#if (${ca_flg}== 'Y')" ).append("\n"); 
		query.append("		AND   CORR_NO = 'TMP0000001'" ).append("\n"); 
		query.append("#end  " ).append("\n"); 
		query.append("       and 'N'    = spcl_cgo_apro_Cd " ).append("\n"); 
		query.append("       and rownum = 1    " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("    UNION " ).append("\n"); 
		query.append("    SELECT 'Y'" ).append("\n"); 
		query.append("#if (${ca_flg}== 'Y')" ).append("\n"); 
		query.append("      FROM  bkg_stwg_cgo_his" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("      FROM  bkg_stwg_cgo" ).append("\n"); 
		query.append("#end    " ).append("\n"); 
		query.append("     where bkg_no = @[bkg_no]    " ).append("\n"); 
		query.append("#if (${ca_flg}== 'Y')" ).append("\n"); 
		query.append("		AND   CORR_NO = 'TMP0000001'" ).append("\n"); 
		query.append("#end  " ).append("\n"); 
		query.append("       and 'N'    = spcl_cgo_apro_Cd " ).append("\n"); 
		query.append("       and rownum = 1 " ).append("\n"); 
		query.append("    )" ).append("\n"); 

	}
}