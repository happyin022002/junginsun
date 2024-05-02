/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : GeneralBookingReceiptDBDAOSearchScTypeRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.03.07
*@LastModifier : 김태경
*@LastVersion : 1.0
* 2011.03.07 김태경
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author taekyoung.kim
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class GeneralBookingReceiptDBDAOSearchScTypeRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Sc Type 조회
	  * </pre>
	  */
	public GeneralBookingReceiptDBDAOSearchScTypeRSQL(){
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
		params.put("sc_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.integration").append("\n"); 
		query.append("FileName : GeneralBookingReceiptDBDAOSearchScTypeRSQL").append("\n"); 
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
		query.append("select distinct PRC_CTRT_CUST_TP_CD real_cust_tp_cd" ).append("\n"); 
		query.append("  from pri_sp_hdr hdr" ).append("\n"); 
		query.append("        , pri_sp_mn main" ).append("\n"); 
		query.append("        , pri_sp_ctrt_cust_tp cust" ).append("\n"); 
		query.append("		, (" ).append("\n"); 
		query.append("		   SELECT NVL((" ).append("\n"); 
		query.append("                       SELECT RT_APLY_DT" ).append("\n"); 
		query.append("#if (${ca_flg}== 'Y')" ).append("\n"); 
		query.append("                         FROM BKG_RT_HIS RT" ).append("\n"); 
		query.append("                        WHERE BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("                          AND CORR_NO = 'TMP0000001'" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("                         FROM BKG_RATE R" ).append("\n"); 
		query.append("                        WHERE BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("                          AND RT_APLY_DT IS NOT NULL" ).append("\n"); 
		query.append("                      ),(" ).append("\n"); 
		query.append("		               SELECT SYSDATE FROM DUAL" ).append("\n"); 
		query.append("                      )" ).append("\n"); 
		query.append("                  ) APPL_DT" ).append("\n"); 
		query.append("             FROM DUAL" ).append("\n"); 
		query.append("          ) APPL_DT" ).append("\n"); 
		query.append(" where hdr.prop_no = main.prop_no" ).append("\n"); 
		query.append("   and main.prop_no = cust.prop_no" ).append("\n"); 
		query.append("   and main.amdt_seq = cust.amdt_seq" ).append("\n"); 
		query.append("   and MAIN.eff_dt - 0.0001 < APPL_DT.APPL_DT" ).append("\n"); 
		query.append("   AND MAIN.exp_dt + 0.9999 > APPL_DT.APPL_DT" ).append("\n"); 
		query.append("   and prop_sts_cd = 'F'" ).append("\n"); 
		query.append("   and hdr.sc_no = @[sc_no]" ).append("\n"); 
		query.append("   and rownum = 1" ).append("\n"); 

	}
}