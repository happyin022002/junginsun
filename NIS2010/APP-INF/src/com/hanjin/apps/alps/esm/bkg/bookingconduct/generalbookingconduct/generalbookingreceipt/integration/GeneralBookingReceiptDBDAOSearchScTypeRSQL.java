/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : GeneralBookingReceiptDBDAOSearchScTypeRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.04.07
*@LastModifier : 
*@LastVersion : 1.0
* 2015.04.07 
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

public class GeneralBookingReceiptDBDAOSearchScTypeRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Sc Type 조회
	  * 2015.04.01 [CHM-201534662] US Filer type validation 추가 요청 - SC Type이 A이면 Affiliate 의 1개 member의 type 기준
	  *                 I(BCO)   : 01(O), 02(O), 03(X)   (기존 validation)
	  *                 N(NVO) : 01(X), 02(X), 03(O)   (기존 validation)
	  *                 A(Association) - Affiliate BCO : 01(O), 02(O), 03(X)      (추가)
	  *                 A(Association) - Affiliate N-BCO : 01(X), 02(X), 03(O)   (추가)
	  *                 (Association 의 Affiliate 의 RVIS_CNTR_CUST_TP_CD 는 동일함 전제)
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
		query.append("Path : com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.integration").append("\n"); 
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
		query.append("             , (select appl_dt   " ).append("\n"); 
		query.append("                  from " ).append("\n"); 
		query.append("                (select 1 rank, RT_APLY_DT appl_dt --rate applicable" ).append("\n"); 
		query.append("       #if (${ca_flg}== 'Y')" ).append("\n"); 
		query.append("                from BKG_RT_HIS rt" ).append("\n"); 
		query.append("                  where bkg_no = @[bkg_no]" ).append("\n"); 
		query.append("                       and corr_no = 'TMP0000001'" ).append("\n"); 
		query.append("       #else" ).append("\n"); 
		query.append("                   from bkg_rate r" ).append("\n"); 
		query.append("                  where bkg_no = @[bkg_no]" ).append("\n"); 
		query.append("       #end" ).append("\n"); 
		query.append("                    and rt_aply_dt is not null" ).append("\n"); 
		query.append("                 union all" ).append("\n"); 
		query.append("                 select 3 rank, sysdate appl_dt" ).append("\n"); 
		query.append("                   from dual) " ).append("\n"); 
		query.append("                 where rownum = 1                  " ).append("\n"); 
		query.append("                 order by rank) appl_dt" ).append("\n"); 
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