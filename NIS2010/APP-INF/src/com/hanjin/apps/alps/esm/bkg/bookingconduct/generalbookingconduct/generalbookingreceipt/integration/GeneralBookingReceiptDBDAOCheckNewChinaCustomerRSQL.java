/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : GeneralBookingReceiptDBDAOCheckNewChinaCustomerRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.04.04
*@LastModifier : 
*@LastVersion : 1.0
* 2016.04.04 
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

public class GeneralBookingReceiptDBDAOCheckNewChinaCustomerRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * GeneralBookingReceiptDBCheckNewChinaCustomer
	  * </pre>
	  */
	public GeneralBookingReceiptDBDAOCheckNewChinaCustomerRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("c_cust_cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("c_cust_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_cust_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ob_srep_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_cust_cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_cust_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_cust_cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.integration").append("\n"); 
		query.append("FileName : GeneralBookingReceiptDBDAOCheckNewChinaCustomerRSQL").append("\n"); 
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
		query.append("SELECT COUNT(1) CNT" ).append("\n"); 
		query.append("  FROM ( SELECT 'Y' -- SHPR" ).append("\n"); 
		query.append("           FROM DUAL" ).append("\n"); 
		query.append("          WHERE NOT EXISTS ( select 1 " ).append("\n"); 
		query.append("                               from bkg_booking  bk" ).append("\n"); 
		query.append("                                  , bkg_customer cust" ).append("\n"); 
		query.append("                              where bk.bkg_no = cust.bkg_no" ).append("\n"); 
		query.append("                                and bk.bkg_cre_Dt > sysdate - 180" ).append("\n"); 
		query.append("                                and bk.bkg_sts_cd <> 'X'" ).append("\n"); 
		query.append("                                and bk.bkg_cgo_tp_cd <> 'P'" ).append("\n"); 
		query.append("                                and cust.CUST_CNT_CD = @[s_cust_cnt_cd]" ).append("\n"); 
		query.append("                                AND CUST_SEQ = @[s_cust_seq]     " ).append("\n"); 
		query.append("                                AND ROWNUM = 1" ).append("\n"); 
		query.append("                           )" ).append("\n"); 
		query.append("            AND 0 < LENGTH(@[s_cust_cnt_cd])" ).append("\n"); 
		query.append("            AND 0 < @[s_cust_seq]  " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("         UNION ALL" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("         SELECT 'Y' -- CNEE" ).append("\n"); 
		query.append("           FROM DUAL" ).append("\n"); 
		query.append("          WHERE NOT EXISTS ( select 1 " ).append("\n"); 
		query.append("                               from bkg_booking  bk" ).append("\n"); 
		query.append("                                  , bkg_customer cust" ).append("\n"); 
		query.append("                              where bk.bkg_no = cust.bkg_no" ).append("\n"); 
		query.append("                                and bk.bkg_cre_Dt > sysdate - 180" ).append("\n"); 
		query.append("                                and bk.bkg_sts_cd <> 'X'" ).append("\n"); 
		query.append("                                and bk.bkg_cgo_tp_cd <> 'P'" ).append("\n"); 
		query.append("                                and cust.CUST_CNT_CD = @[c_cust_cnt_cd]" ).append("\n"); 
		query.append("                                AND CUST_SEQ = @[c_cust_seq]     " ).append("\n"); 
		query.append("                                AND ROWNUM = 1" ).append("\n"); 
		query.append("                           )" ).append("\n"); 
		query.append("            AND 0 < LENGTH(@[c_cust_cnt_cd])" ).append("\n"); 
		query.append("            AND 0 < @[c_cust_seq]  " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("         UNION ALL" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("         SELECT 'Y' -- FWDR" ).append("\n"); 
		query.append("           FROM DUAL" ).append("\n"); 
		query.append("          WHERE NOT EXISTS ( select 1 " ).append("\n"); 
		query.append("                               from bkg_booking  bk" ).append("\n"); 
		query.append("                                  , bkg_customer cust" ).append("\n"); 
		query.append("                              where bk.bkg_no = cust.bkg_no" ).append("\n"); 
		query.append("                                and bk.bkg_cre_Dt > sysdate - 180" ).append("\n"); 
		query.append("                                and bk.bkg_sts_cd <> 'X'" ).append("\n"); 
		query.append("                                and bk.bkg_cgo_tp_cd <> 'P'" ).append("\n"); 
		query.append("                                and cust.CUST_CNT_CD = @[f_cust_cnt_cd]" ).append("\n"); 
		query.append("                                AND CUST_SEQ = @[f_cust_seq]     " ).append("\n"); 
		query.append("                                AND ROWNUM = 1" ).append("\n"); 
		query.append("                           )" ).append("\n"); 
		query.append("            AND 0 < LENGTH(@[f_cust_cnt_cd])" ).append("\n"); 
		query.append("            AND 0 < @[f_cust_seq]         " ).append("\n"); 
		query.append("       ) CUST" ).append("\n"); 
		query.append("       " ).append("\n"); 
		query.append("     -- L.OFC 가 북중국 지역" ).append("\n"); 
		query.append("     , ( SELECT RGN_CD " ).append("\n"); 
		query.append("           FROM MDM_SLS_REP      REP" ).append("\n"); 
		query.append("              , MDM_ORGANIZATION ORG" ).append("\n"); 
		query.append("              , MDM_LOCATION     LOC" ).append("\n"); 
		query.append("          WHERE REP.OFC_CD  = ORG.OFC_CD" ).append("\n"); 
		query.append("            AND ORG.OFC_TP_CD IN ('BS','BB')" ).append("\n"); 
		query.append("            AND LOC.LOC_CD  = ORG.LOC_CD" ).append("\n"); 
		query.append("            AND RGN_CD      = 'CNN' -- 북중국" ).append("\n"); 
		query.append("            AND REP.SREP_CD  = @[ob_srep_cd]" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("         UNION ALL" ).append("\n"); 
		query.append("     -- L.OFC 가 서남아 지역" ).append("\n"); 
		query.append("         SELECT ORG.OFC_CD" ).append("\n"); 
		query.append("           FROM MDM_SLS_REP      REP" ).append("\n"); 
		query.append("              , MDM_ORGANIZATION ORG" ).append("\n"); 
		query.append("          WHERE REP.OFC_CD  = ORG.OFC_CD" ).append("\n"); 
		query.append("            AND ORG.OFC_TP_CD IN ('BS','BB')" ).append("\n"); 
		query.append("            AND ORG.AR_HD_QTR_OFC_CD ='SINRS' " ).append("\n"); 
		query.append("            AND REP.SREP_CD  = @[ob_srep_cd]" ).append("\n"); 
		query.append("       )" ).append("\n"); 
		query.append(" WHERE NOT EXISTS (SELECT 1 " ).append("\n"); 
		query.append("                     FROM BKG_HRD_CDG_CTNT " ).append("\n"); 
		query.append("                    WHERE HRD_CDG_ID = 'BKG_VALIDATION'" ).append("\n"); 
		query.append("                      AND ATTR_CTNT1 = 'CNN_NEW_CUST_APRO'" ).append("\n"); 
		query.append("                      AND ATTR_CTNT2 = 'OFF')" ).append("\n"); 

	}
}