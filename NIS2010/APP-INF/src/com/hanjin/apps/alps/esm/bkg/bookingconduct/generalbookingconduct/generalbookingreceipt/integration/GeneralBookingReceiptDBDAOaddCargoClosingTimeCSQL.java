/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : GeneralBookingReceiptDBDAOaddCargoClosingTimeCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.06.03
*@LastModifier : 
*@LastVersion : 1.0
* 2016.06.03 
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

public class GeneralBookingReceiptDBDAOaddCargoClosingTimeCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * insert
	  * </pre>
	  */
	public GeneralBookingReceiptDBDAOaddCargoClosingTimeCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.integration").append("\n"); 
		query.append("FileName : GeneralBookingReceiptDBDAOaddCargoClosingTimeCSQL").append("\n"); 
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
		query.append("insert into bkg_clz_tm    " ).append("\n"); 
		query.append("(BKG_NO,CLZ_TP_CD,CLZ_YD_CD,MNL_SET_DT,MNL_SET_USR_ID,SYS_SET_DT,NTC_FLG,CRE_USR_ID,CRE_DT,UPD_USR_ID,UPD_DT)" ).append("\n"); 
		query.append("select @[bkg_no]" ).append("\n"); 
		query.append("        , 'M' code  --Empty Pick Update Date" ).append("\n"); 
		query.append("        , mty_pkup_yd_cd portYard" ).append("\n"); 
		query.append("        , null" ).append("\n"); 
		query.append("        , null" ).append("\n"); 
		query.append("        , null" ).append("\n"); 
		query.append("        , NVL(" ).append("\n"); 
		query.append("		  (SELECT MTY_PKUP_YD_FLG" ).append("\n"); 
		query.append("             FROM BKG_RPT_ITM_STUP NTC_SET," ).append("\n"); 
		query.append("                 (SELECT ITM_SEQ" ).append("\n"); 
		query.append("                    FROM (SELECT BKG_CUST_TP_CD RNK, NTC_SET.ITM_SEQ" ).append("\n"); 
		query.append("                            FROM BKG_BOOKING BK, BKG_CUSTOMER CUST, BKG_RPT_ITM_STUP NTC_SET" ).append("\n"); 
		query.append("                           WHERE BK.BKG_NO            = @[bkg_no]  " ).append("\n"); 
		query.append("                             AND BK.BKG_NO            = CUST.BKG_NO" ).append("\n"); 
		query.append("                             AND CUST.BKG_CUST_TP_CD  IN ('S', 'F')" ).append("\n"); 
		query.append("                             AND CUST.CUST_CNT_CD     = NTC_SET.CUST_CNT_CD" ).append("\n"); 
		query.append("                             AND CUST.CUST_SEQ        = NTC_SET.CUST_SEQ    " ).append("\n"); 
		query.append("                             AND BK.BKG_OFC_CD        = NTC_SET.BKG_OFC_CD" ).append("\n"); 
		query.append("                           UNION" ).append("\n"); 
		query.append("                          SELECT 'Z' RNK, NTC_SET.ITM_SEQ" ).append("\n"); 
		query.append("                            FROM BKG_BOOKING BK, BKG_RPT_ITM_STUP NTC_SET" ).append("\n"); 
		query.append("                           WHERE BK.BKG_NO            = @[bkg_no]  " ).append("\n"); 
		query.append("                             AND BK.BKG_OFC_CD        = NTC_SET.BKG_OFC_CD" ).append("\n"); 
		query.append("				             AND NTC_SET.CUST_CNT_CD IS NULL" ).append("\n"); 
		query.append("           					 AND NTC_SET.CUST_SEQ    IS NULL" ).append("\n"); 
		query.append("                           ORDER BY RNK)" ).append("\n"); 
		query.append("                   WHERE ROWNUM = 1) MATCHED" ).append("\n"); 
		query.append("            WHERE NTC_SET.ITM_SEQ  = MATCHED.ITM_SEQ), 'N')     " ).append("\n"); 
		query.append("        , NVL(@[usr_id], 'SYSTEM')" ).append("\n"); 
		query.append("        , sysdate" ).append("\n"); 
		query.append("        , NVL(@[usr_id], 'SYSTEM')" ).append("\n"); 
		query.append("        , sysdate" ).append("\n"); 
		query.append(" from bkg_booking" ).append("\n"); 
		query.append("where bkg_no       = @[bkg_no]" ).append("\n"); 
		query.append("  and 'M' not in (select clz_tp_cd from bkg_clz_tm where bkg_no = @[bkg_no])" ).append("\n"); 
		query.append("union" ).append("\n"); 
		query.append("select @[bkg_no]" ).append("\n"); 
		query.append("        , 'R' code  --Cargo Cut-Off (Return CY)" ).append("\n"); 
		query.append("        , FULL_RTN_YD_CD portYard" ).append("\n"); 
		query.append("        , null" ).append("\n"); 
		query.append("        , null" ).append("\n"); 
		query.append("        , null" ).append("\n"); 
		query.append("        , NVL(" ).append("\n"); 
		query.append("		  (SELECT FULL_RTN_YD_FLG" ).append("\n"); 
		query.append("             FROM BKG_RPT_ITM_STUP NTC_SET," ).append("\n"); 
		query.append("                 (SELECT ITM_SEQ" ).append("\n"); 
		query.append("                    FROM (SELECT BKG_CUST_TP_CD RNK, NTC_SET.ITM_SEQ" ).append("\n"); 
		query.append("                            FROM BKG_BOOKING BK, BKG_CUSTOMER CUST, BKG_RPT_ITM_STUP NTC_SET" ).append("\n"); 
		query.append("                           WHERE BK.BKG_NO            = @[bkg_no]  " ).append("\n"); 
		query.append("                             AND BK.BKG_NO            = CUST.BKG_NO" ).append("\n"); 
		query.append("                             AND CUST.BKG_CUST_TP_CD  IN ('S', 'F')" ).append("\n"); 
		query.append("                             AND CUST.CUST_CNT_CD     = NTC_SET.CUST_CNT_CD" ).append("\n"); 
		query.append("                             AND CUST.CUST_SEQ        = NTC_SET.CUST_SEQ    " ).append("\n"); 
		query.append("                             AND BK.BKG_OFC_CD        = NTC_SET.BKG_OFC_CD" ).append("\n"); 
		query.append("                           UNION" ).append("\n"); 
		query.append("                          SELECT 'Z' RNK, NTC_SET.ITM_SEQ" ).append("\n"); 
		query.append("                            FROM BKG_BOOKING BK, BKG_RPT_ITM_STUP NTC_SET" ).append("\n"); 
		query.append("                           WHERE BK.BKG_NO            = @[bkg_no]  " ).append("\n"); 
		query.append("                             AND BK.BKG_OFC_CD        = NTC_SET.BKG_OFC_CD" ).append("\n"); 
		query.append("				             AND NTC_SET.CUST_CNT_CD IS NULL" ).append("\n"); 
		query.append("           					 AND NTC_SET.CUST_SEQ    IS NULL" ).append("\n"); 
		query.append("                           ORDER BY RNK)" ).append("\n"); 
		query.append("                   WHERE ROWNUM = 1) MATCHED" ).append("\n"); 
		query.append("            WHERE NTC_SET.ITM_SEQ  = MATCHED.ITM_SEQ), 'N')     " ).append("\n"); 
		query.append("        , NVL(@[usr_id], 'SYSTEM')" ).append("\n"); 
		query.append("        , sysdate" ).append("\n"); 
		query.append("        , NVL(@[usr_id], 'SYSTEM')" ).append("\n"); 
		query.append("        , sysdate" ).append("\n"); 
		query.append(" from bkg_booking" ).append("\n"); 
		query.append("where bkg_no       = @[bkg_no]" ).append("\n"); 
		query.append("  and 'R' not in (select clz_tp_cd from bkg_clz_tm where bkg_no = @[bkg_no])" ).append("\n"); 
		query.append("union" ).append("\n"); 
		query.append("select @[bkg_no]" ).append("\n"); 
		query.append("        , 'F' code  --Rail Receiving Date" ).append("\n"); 
		query.append("        , ORG_NOD_CD portYard" ).append("\n"); 
		query.append("        , null" ).append("\n"); 
		query.append("        , null" ).append("\n"); 
		query.append("        , null" ).append("\n"); 
		query.append("        , NVL(" ).append("\n"); 
		query.append("		  (SELECT RAIL_RCV_FLG" ).append("\n"); 
		query.append("             FROM BKG_RPT_ITM_STUP NTC_SET," ).append("\n"); 
		query.append("                 (SELECT ITM_SEQ" ).append("\n"); 
		query.append("                    FROM (SELECT BKG_CUST_TP_CD RNK, NTC_SET.ITM_SEQ" ).append("\n"); 
		query.append("                            FROM BKG_BOOKING BK, BKG_CUSTOMER CUST, BKG_RPT_ITM_STUP NTC_SET" ).append("\n"); 
		query.append("                           WHERE BK.BKG_NO            = @[bkg_no]  " ).append("\n"); 
		query.append("                             AND BK.BKG_NO            = CUST.BKG_NO" ).append("\n"); 
		query.append("                             AND CUST.BKG_CUST_TP_CD  IN ('S', 'F')" ).append("\n"); 
		query.append("                             AND CUST.CUST_CNT_CD     = NTC_SET.CUST_CNT_CD" ).append("\n"); 
		query.append("                             AND CUST.CUST_SEQ        = NTC_SET.CUST_SEQ    " ).append("\n"); 
		query.append("                             AND BK.BKG_OFC_CD        = NTC_SET.BKG_OFC_CD" ).append("\n"); 
		query.append("                           UNION" ).append("\n"); 
		query.append("                          SELECT 'Z' RNK, NTC_SET.ITM_SEQ" ).append("\n"); 
		query.append("                            FROM BKG_BOOKING BK, BKG_RPT_ITM_STUP NTC_SET" ).append("\n"); 
		query.append("                           WHERE BK.BKG_NO            = @[bkg_no]  " ).append("\n"); 
		query.append("                             AND BK.BKG_OFC_CD        = NTC_SET.BKG_OFC_CD" ).append("\n"); 
		query.append("				             AND NTC_SET.CUST_CNT_CD IS NULL" ).append("\n"); 
		query.append("           					 AND NTC_SET.CUST_SEQ    IS NULL" ).append("\n"); 
		query.append("                           ORDER BY RNK)" ).append("\n"); 
		query.append("                   WHERE ROWNUM = 1) MATCHED" ).append("\n"); 
		query.append("            WHERE NTC_SET.ITM_SEQ  = MATCHED.ITM_SEQ), 'N')    " ).append("\n"); 
		query.append("        , NVL(@[usr_id], 'SYSTEM')" ).append("\n"); 
		query.append("        , sysdate" ).append("\n"); 
		query.append("        , NVL(@[usr_id], 'SYSTEM')" ).append("\n"); 
		query.append("        , sysdate " ).append("\n"); 
		query.append(" from prd_prod_ctl_rout_dtl dtl " ).append("\n"); 
		query.append("        , prd_prod_ctl_mst mst " ).append("\n"); 
		query.append("        , sce_cop_hdr cop " ).append("\n"); 
		query.append("where dtl.PCTL_IO_BND_CD = 'O' " ).append("\n"); 
		query.append("  and dtl.TRSP_MOD_CD    = 'RD' " ).append("\n"); 
		query.append("  and mst.pctl_no        = dtl.pctl_no " ).append("\n"); 
		query.append("  and mst.pctl_no        = cop.pctl_no " ).append("\n"); 
		query.append("  and cop.bkg_no         = @[bkg_no]" ).append("\n"); 
		query.append("  and cop.COP_STS_CD     <> 'X'" ).append("\n"); 
		query.append("  and 'F' not in (select clz_tp_cd from bkg_clz_tm where bkg_no = @[bkg_no])" ).append("\n"); 
		query.append("  and dtl.pctl_seq = (select min(fst.pctl_seq)" ).append("\n"); 
		query.append("                        from prd_prod_ctl_rout_dtl fst " ).append("\n"); 
		query.append("                       where fst.pctl_no = mst.pctl_no " ).append("\n"); 
		query.append("                         and fst.PCTL_IO_BND_CD = 'O'                         " ).append("\n"); 
		query.append("                         and fst.TRSP_MOD_CD = 'RD')" ).append("\n"); 
		query.append("  and rownum = 1" ).append("\n"); 
		query.append("union                     " ).append("\n"); 
		query.append("select @[bkg_no]" ).append("\n"); 
		query.append("        , 'O' code  --Rail Receiving Date" ).append("\n"); 
		query.append("        , ORG_NOD_CD portYard" ).append("\n"); 
		query.append("        , null" ).append("\n"); 
		query.append("        , null" ).append("\n"); 
		query.append("        , null" ).append("\n"); 
		query.append("        , NVL(" ).append("\n"); 
		query.append("		  (SELECT RAIL_RCV_FLG" ).append("\n"); 
		query.append("             FROM BKG_RPT_ITM_STUP NTC_SET," ).append("\n"); 
		query.append("                 (SELECT ITM_SEQ" ).append("\n"); 
		query.append("                    FROM (SELECT BKG_CUST_TP_CD RNK, NTC_SET.ITM_SEQ" ).append("\n"); 
		query.append("                            FROM BKG_BOOKING BK, BKG_CUSTOMER CUST, BKG_RPT_ITM_STUP NTC_SET" ).append("\n"); 
		query.append("                           WHERE BK.BKG_NO            = @[bkg_no]  " ).append("\n"); 
		query.append("                             AND BK.BKG_NO            = CUST.BKG_NO" ).append("\n"); 
		query.append("                             AND CUST.BKG_CUST_TP_CD  IN ('S', 'F')" ).append("\n"); 
		query.append("                             AND CUST.CUST_CNT_CD     = NTC_SET.CUST_CNT_CD" ).append("\n"); 
		query.append("                             AND CUST.CUST_SEQ        = NTC_SET.CUST_SEQ    " ).append("\n"); 
		query.append("                             AND BK.BKG_OFC_CD        = NTC_SET.BKG_OFC_CD" ).append("\n"); 
		query.append("                           UNION" ).append("\n"); 
		query.append("                          SELECT 'Z' RNK, NTC_SET.ITM_SEQ" ).append("\n"); 
		query.append("                            FROM BKG_BOOKING BK, BKG_RPT_ITM_STUP NTC_SET" ).append("\n"); 
		query.append("                           WHERE BK.BKG_NO            = @[bkg_no]  " ).append("\n"); 
		query.append("                             AND BK.BKG_OFC_CD        = NTC_SET.BKG_OFC_CD" ).append("\n"); 
		query.append("				             AND NTC_SET.CUST_CNT_CD IS NULL" ).append("\n"); 
		query.append("           					 AND NTC_SET.CUST_SEQ    IS NULL" ).append("\n"); 
		query.append("                           ORDER BY RNK)" ).append("\n"); 
		query.append("                   WHERE ROWNUM = 1) MATCHED" ).append("\n"); 
		query.append("            WHERE NTC_SET.ITM_SEQ  = MATCHED.ITM_SEQ), 'N') " ).append("\n"); 
		query.append("        , NVL(@[usr_id], 'SYSTEM')" ).append("\n"); 
		query.append("        , sysdate" ).append("\n"); 
		query.append("        , NVL(@[usr_id], 'SYSTEM')" ).append("\n"); 
		query.append("        , sysdate " ).append("\n"); 
		query.append(" from prd_prod_ctl_rout_dtl dtl " ).append("\n"); 
		query.append("        , prd_prod_ctl_mst mst " ).append("\n"); 
		query.append("        , sce_cop_hdr cop " ).append("\n"); 
		query.append("where dtl.PCTL_IO_BND_CD = 'O' " ).append("\n"); 
		query.append("  and dtl.TRSP_MOD_CD    = 'RD' " ).append("\n"); 
		query.append("  and mst.pctl_no        = dtl.pctl_no " ).append("\n"); 
		query.append("  and mst.pctl_no        = cop.pctl_no " ).append("\n"); 
		query.append("  and cop.bkg_no         = @[bkg_no]  " ).append("\n"); 
		query.append("  and cop.COP_STS_CD     <> 'X'" ).append("\n"); 
		query.append("  and 'O' not in (select clz_tp_cd from bkg_clz_tm where bkg_no = @[bkg_no])" ).append("\n"); 
		query.append("  and dtl.pctl_seq = (select min(fst.pctl_seq)" ).append("\n"); 
		query.append("                        from prd_prod_ctl_rout_dtl fst " ).append("\n"); 
		query.append("                       where fst.pctl_no = mst.pctl_no " ).append("\n"); 
		query.append("                         and fst.PCTL_IO_BND_CD = 'O'                         " ).append("\n"); 
		query.append("                         and fst.TRSP_MOD_CD = 'RD')" ).append("\n"); 
		query.append("  and rownum = 1" ).append("\n"); 
		query.append("union " ).append("\n"); 
		query.append("select @[bkg_no]" ).append("\n"); 
		query.append("        , 'T' code  --Port Cut-Off (Terminal CY)" ).append("\n"); 
		query.append("        , pol_nod_cd portYard" ).append("\n"); 
		query.append("        , null" ).append("\n"); 
		query.append("        , null" ).append("\n"); 
		query.append("        , null" ).append("\n"); 
		query.append("        , NVL(" ).append("\n"); 
		query.append("		  (SELECT PORT_COFF_FLG" ).append("\n"); 
		query.append("             FROM BKG_RPT_ITM_STUP NTC_SET," ).append("\n"); 
		query.append("                 (SELECT ITM_SEQ" ).append("\n"); 
		query.append("                    FROM (SELECT BKG_CUST_TP_CD RNK, NTC_SET.ITM_SEQ" ).append("\n"); 
		query.append("                            FROM BKG_BOOKING BK, BKG_CUSTOMER CUST, BKG_RPT_ITM_STUP NTC_SET" ).append("\n"); 
		query.append("                           WHERE BK.BKG_NO            = @[bkg_no]  " ).append("\n"); 
		query.append("                             AND BK.BKG_NO            = CUST.BKG_NO" ).append("\n"); 
		query.append("                             AND CUST.BKG_CUST_TP_CD  IN ('S', 'F')" ).append("\n"); 
		query.append("                             AND CUST.CUST_CNT_CD     = NTC_SET.CUST_CNT_CD" ).append("\n"); 
		query.append("                             AND CUST.CUST_SEQ        = NTC_SET.CUST_SEQ    " ).append("\n"); 
		query.append("                             AND BK.BKG_OFC_CD        = NTC_SET.BKG_OFC_CD" ).append("\n"); 
		query.append("                           UNION" ).append("\n"); 
		query.append("                          SELECT 'Z' RNK, NTC_SET.ITM_SEQ" ).append("\n"); 
		query.append("                            FROM BKG_BOOKING BK, BKG_RPT_ITM_STUP NTC_SET" ).append("\n"); 
		query.append("                           WHERE BK.BKG_NO            = @[bkg_no]  " ).append("\n"); 
		query.append("                             AND BK.BKG_OFC_CD        = NTC_SET.BKG_OFC_CD" ).append("\n"); 
		query.append("				             AND NTC_SET.CUST_CNT_CD IS NULL" ).append("\n"); 
		query.append("           					 AND NTC_SET.CUST_SEQ    IS NULL" ).append("\n"); 
		query.append("                           ORDER BY RNK)" ).append("\n"); 
		query.append("                   WHERE ROWNUM = 1) MATCHED" ).append("\n"); 
		query.append("            WHERE NTC_SET.ITM_SEQ  = MATCHED.ITM_SEQ), 'N') " ).append("\n"); 
		query.append("        , NVL(@[usr_id], 'SYSTEM')" ).append("\n"); 
		query.append("        , sysdate" ).append("\n"); 
		query.append("        , NVL(@[usr_id], 'SYSTEM')" ).append("\n"); 
		query.append("        , sysdate" ).append("\n"); 
		query.append(" from bkg_booking" ).append("\n"); 
		query.append("where bkg_no       = @[bkg_no]" ).append("\n"); 
		query.append("  and 'T' not in (select clz_tp_cd from bkg_clz_tm where bkg_no = @[bkg_no])" ).append("\n"); 
		query.append("union " ).append("\n"); 
		query.append("select @[bkg_no]" ).append("\n"); 
		query.append("        , 'D' code  --Documentation Cut-Off" ).append("\n"); 
		query.append("        , pol_nod_cd portYard" ).append("\n"); 
		query.append("        , null" ).append("\n"); 
		query.append("        , null" ).append("\n"); 
		query.append("        , null" ).append("\n"); 
		query.append("        , NVL(" ).append("\n"); 
		query.append("		  (SELECT DOC_COFF_FLG" ).append("\n"); 
		query.append("             FROM BKG_RPT_ITM_STUP NTC_SET," ).append("\n"); 
		query.append("                 (SELECT ITM_SEQ" ).append("\n"); 
		query.append("                    FROM (SELECT BKG_CUST_TP_CD RNK, NTC_SET.ITM_SEQ" ).append("\n"); 
		query.append("                            FROM BKG_BOOKING BK, BKG_CUSTOMER CUST, BKG_RPT_ITM_STUP NTC_SET" ).append("\n"); 
		query.append("                           WHERE BK.BKG_NO            = @[bkg_no]  " ).append("\n"); 
		query.append("                             AND BK.BKG_NO            = CUST.BKG_NO" ).append("\n"); 
		query.append("                             AND CUST.BKG_CUST_TP_CD  IN ('S', 'F')" ).append("\n"); 
		query.append("                             AND CUST.CUST_CNT_CD     = NTC_SET.CUST_CNT_CD" ).append("\n"); 
		query.append("                             AND CUST.CUST_SEQ        = NTC_SET.CUST_SEQ    " ).append("\n"); 
		query.append("                             AND BK.BKG_OFC_CD        = NTC_SET.BKG_OFC_CD" ).append("\n"); 
		query.append("                           UNION" ).append("\n"); 
		query.append("                          SELECT 'Z' RNK, NTC_SET.ITM_SEQ" ).append("\n"); 
		query.append("                            FROM BKG_BOOKING BK, BKG_RPT_ITM_STUP NTC_SET" ).append("\n"); 
		query.append("                           WHERE BK.BKG_NO            = @[bkg_no]  " ).append("\n"); 
		query.append("                             AND BK.BKG_OFC_CD        = NTC_SET.BKG_OFC_CD" ).append("\n"); 
		query.append("				             AND NTC_SET.CUST_CNT_CD IS NULL" ).append("\n"); 
		query.append("           					 AND NTC_SET.CUST_SEQ    IS NULL" ).append("\n"); 
		query.append("                           ORDER BY RNK)" ).append("\n"); 
		query.append("                   WHERE ROWNUM = 1) MATCHED" ).append("\n"); 
		query.append("            WHERE NTC_SET.ITM_SEQ  = MATCHED.ITM_SEQ), 'N') " ).append("\n"); 
		query.append("        , NVL(@[usr_id], 'SYSTEM')" ).append("\n"); 
		query.append("        , sysdate" ).append("\n"); 
		query.append("        , NVL(@[usr_id], 'SYSTEM')" ).append("\n"); 
		query.append("        , sysdate" ).append("\n"); 
		query.append(" from bkg_booking" ).append("\n"); 
		query.append("where bkg_no       = @[bkg_no]" ).append("\n"); 
		query.append("  and 'D' not in (select clz_tp_cd from bkg_clz_tm where bkg_no = @[bkg_no])" ).append("\n"); 
		query.append("union " ).append("\n"); 
		query.append("select @[bkg_no]" ).append("\n"); 
		query.append("        , 'V' code  --VGM CUT-OFF" ).append("\n"); 
		query.append("        , pol_nod_cd portYard" ).append("\n"); 
		query.append("        , null" ).append("\n"); 
		query.append("        , null" ).append("\n"); 
		query.append("        , null" ).append("\n"); 
		query.append("        , 'Y'" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("        , NVL(@[usr_id], 'SYSTEM')" ).append("\n"); 
		query.append("        , sysdate" ).append("\n"); 
		query.append("        , NVL(@[usr_id], 'SYSTEM')" ).append("\n"); 
		query.append("        , sysdate" ).append("\n"); 
		query.append(" from bkg_booking" ).append("\n"); 
		query.append("where bkg_no       = @[bkg_no]" ).append("\n"); 
		query.append("  and 'V' not in (select clz_tp_cd from bkg_clz_tm where bkg_no = @[bkg_no])" ).append("\n"); 
		query.append("union " ).append("\n"); 
		query.append("select @[bkg_no]" ).append("\n"); 
		query.append("        , 'E' code  --Export Customs Cut-Off는 자동 계산이 없음" ).append("\n"); 
		query.append("        , pol_nod_cd portYard" ).append("\n"); 
		query.append("        , null" ).append("\n"); 
		query.append("        , null" ).append("\n"); 
		query.append("        , null" ).append("\n"); 
		query.append("        , NVL(" ).append("\n"); 
		query.append("		  (SELECT CUST_COFF_FLG" ).append("\n"); 
		query.append("             FROM BKG_RPT_ITM_STUP NTC_SET," ).append("\n"); 
		query.append("                 (SELECT ITM_SEQ" ).append("\n"); 
		query.append("                    FROM (SELECT BKG_CUST_TP_CD RNK, NTC_SET.ITM_SEQ" ).append("\n"); 
		query.append("                            FROM BKG_BOOKING BK, BKG_CUSTOMER CUST, BKG_RPT_ITM_STUP NTC_SET" ).append("\n"); 
		query.append("                           WHERE BK.BKG_NO            = @[bkg_no]  " ).append("\n"); 
		query.append("                             AND BK.BKG_NO            = CUST.BKG_NO" ).append("\n"); 
		query.append("                             AND CUST.BKG_CUST_TP_CD  IN ('S', 'F')" ).append("\n"); 
		query.append("                             AND CUST.CUST_CNT_CD     = NTC_SET.CUST_CNT_CD" ).append("\n"); 
		query.append("                             AND CUST.CUST_SEQ        = NTC_SET.CUST_SEQ    " ).append("\n"); 
		query.append("                             AND BK.BKG_OFC_CD        = NTC_SET.BKG_OFC_CD" ).append("\n"); 
		query.append("                           UNION" ).append("\n"); 
		query.append("                          SELECT 'Z' RNK, NTC_SET.ITM_SEQ" ).append("\n"); 
		query.append("                            FROM BKG_BOOKING BK, BKG_RPT_ITM_STUP NTC_SET" ).append("\n"); 
		query.append("                           WHERE BK.BKG_NO            = @[bkg_no]  " ).append("\n"); 
		query.append("                             AND BK.BKG_OFC_CD        = NTC_SET.BKG_OFC_CD" ).append("\n"); 
		query.append("				             AND NTC_SET.CUST_CNT_CD IS NULL" ).append("\n"); 
		query.append("           					 AND NTC_SET.CUST_SEQ    IS NULL" ).append("\n"); 
		query.append("                           ORDER BY RNK)" ).append("\n"); 
		query.append("                   WHERE ROWNUM = 1) MATCHED" ).append("\n"); 
		query.append("            WHERE NTC_SET.ITM_SEQ  = MATCHED.ITM_SEQ), 'N')" ).append("\n"); 
		query.append("        , NVL(@[usr_id], 'SYSTEM')" ).append("\n"); 
		query.append("        , sysdate" ).append("\n"); 
		query.append("        , NVL(@[usr_id], 'SYSTEM')" ).append("\n"); 
		query.append("        , sysdate" ).append("\n"); 
		query.append(" from bkg_booking" ).append("\n"); 
		query.append("where bkg_no       = @[bkg_no]" ).append("\n"); 
		query.append("  and 'E' not in (select clz_tp_cd from bkg_clz_tm where bkg_no = @[bkg_no])" ).append("\n"); 
		query.append("union " ).append("\n"); 
		query.append("select @[bkg_no]" ).append("\n"); 
		query.append("        , 'L' code  --Early Release Date" ).append("\n"); 
		query.append("        , pol_nod_cd portYard" ).append("\n"); 
		query.append("        , null" ).append("\n"); 
		query.append("        , null" ).append("\n"); 
		query.append("        , null" ).append("\n"); 
		query.append("        , NVL(" ).append("\n"); 
		query.append("		  (SELECT PORT_COFF_FLG" ).append("\n"); 
		query.append("             FROM BKG_RPT_ITM_STUP NTC_SET," ).append("\n"); 
		query.append("                 (SELECT ITM_SEQ" ).append("\n"); 
		query.append("                    FROM (SELECT BKG_CUST_TP_CD RNK, NTC_SET.ITM_SEQ" ).append("\n"); 
		query.append("                            FROM BKG_BOOKING BK, BKG_CUSTOMER CUST, BKG_RPT_ITM_STUP NTC_SET" ).append("\n"); 
		query.append("                           WHERE BK.BKG_NO            = @[bkg_no]  " ).append("\n"); 
		query.append("                             AND BK.BKG_NO            = CUST.BKG_NO" ).append("\n"); 
		query.append("                             AND CUST.BKG_CUST_TP_CD  IN ('S', 'F')" ).append("\n"); 
		query.append("                             AND CUST.CUST_CNT_CD     = NTC_SET.CUST_CNT_CD" ).append("\n"); 
		query.append("                             AND CUST.CUST_SEQ        = NTC_SET.CUST_SEQ    " ).append("\n"); 
		query.append("                             AND BK.BKG_OFC_CD        = NTC_SET.BKG_OFC_CD" ).append("\n"); 
		query.append("                           UNION" ).append("\n"); 
		query.append("                          SELECT 'Z' RNK, NTC_SET.ITM_SEQ" ).append("\n"); 
		query.append("                            FROM BKG_BOOKING BK, BKG_RPT_ITM_STUP NTC_SET" ).append("\n"); 
		query.append("                           WHERE BK.BKG_NO            = @[bkg_no]  " ).append("\n"); 
		query.append("                             AND BK.BKG_OFC_CD        = NTC_SET.BKG_OFC_CD" ).append("\n"); 
		query.append("				             AND NTC_SET.CUST_CNT_CD IS NULL" ).append("\n"); 
		query.append("           					 AND NTC_SET.CUST_SEQ    IS NULL" ).append("\n"); 
		query.append("                           ORDER BY RNK)" ).append("\n"); 
		query.append("                   WHERE ROWNUM = 1) MATCHED" ).append("\n"); 
		query.append("            WHERE NTC_SET.ITM_SEQ  = MATCHED.ITM_SEQ), 'N') " ).append("\n"); 
		query.append("        , NVL(@[usr_id], 'SYSTEM')" ).append("\n"); 
		query.append("        , sysdate" ).append("\n"); 
		query.append("        , NVL(@[usr_id], 'SYSTEM')" ).append("\n"); 
		query.append("        , sysdate" ).append("\n"); 
		query.append(" from bkg_booking" ).append("\n"); 
		query.append("where bkg_no       = @[bkg_no]" ).append("\n"); 
		query.append("  and 'L' not in (select clz_tp_cd from bkg_clz_tm where bkg_no = @[bkg_no])" ).append("\n"); 

	}
}