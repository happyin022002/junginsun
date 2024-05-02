/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : GeneralBookingReceiptDBDAOModifyBkgBookingByCustUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.09.27
*@LastModifier : 
*@LastVersion : 1.0
* 2017.09.27 
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

public class GeneralBookingReceiptDBDAOModifyBkgBookingByCustUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Customer화면에서 Booking정보를 수정한다.
	  * </pre>
	  */
	public GeneralBookingReceiptDBDAOModifyBkgBookingByCustUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("kr_cstms_cust_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("indiv_pson_flg",new String[]{arrTmp[0],arrTmp[1]});

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

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sam_cnee_ntfy_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("agmt_act_cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("agmt_act_cust_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_to_ord_flg",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.integration").append("\n"); 
		query.append("FileName : GeneralBookingReceiptDBDAOModifyBkgBookingByCustUSQL").append("\n"); 
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
		query.append("UPDATE BKG_BKG_HIS SET" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("UPDATE BKG_BOOKING SET" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("	AGMT_ACT_CNT_CD = @[agmt_act_cnt_cd]" ).append("\n"); 
		query.append("   ,AGMT_ACT_CUST_SEQ = @[agmt_act_cust_seq]" ).append("\n"); 
		query.append("   ,KR_CSTMS_CUST_TP_CD = NVL(@[kr_cstms_cust_tp_cd]," ).append("\n"); 
		query.append("								(SELECT NVL2(BHCC.ATTR_CTNT1,'C',DECODE(RVIS_CNTR_CUST_TP_CD, 'B', 'S', 'C'))" ).append("\n"); 
		query.append("								 FROM MDM_CUSTOMER MC" ).append("\n"); 
		query.append("								     ,BKG_HRD_CDG_CTNT BHCC" ).append("\n"); 
		query.append("#if (${ca_flg}== 'Y')" ).append("\n"); 
		query.append("								     ,BKG_CUST_HIS BC" ).append("\n"); 
		query.append("							     WHERE BC.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("                                 AND   BC.CORR_NO = 'TMP0000001'" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("								     ,BKG_CUSTOMER BC" ).append("\n"); 
		query.append("							     WHERE BC.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("								 AND BC.BKG_CUST_TP_CD = 'S'" ).append("\n"); 
		query.append("								 AND BC.CUST_CNT_CD = MC.CUST_CNT_CD" ).append("\n"); 
		query.append("								 AND BC.CUST_SEQ = MC.CUST_SEQ" ).append("\n"); 
		query.append("								 AND BHCC.HRD_CDG_ID(+) = 'KR_PANTOS_CUSTOMER'" ).append("\n"); 
		query.append("								 AND BC.CUST_CNT_CD = BHCC.ATTR_CTNT1(+)" ).append("\n"); 
		query.append("								 AND BC.CUST_SEQ = BHCC.ATTR_CTNT2(+)" ).append("\n"); 
		query.append("                                 AND ROWNUM = 1" ).append("\n"); 
		query.append("                                 ))" ).append("\n"); 
		query.append("   ,CUST_TO_ORD_FLG = @[cust_to_ord_flg]" ).append("\n"); 
		query.append("   ,SAM_CNEE_NTFY_FLG = NVL(@[sam_cnee_ntfy_flg], 'N')" ).append("\n"); 
		query.append("   ,INDIV_PSON_FLG = @[indiv_pson_flg]" ).append("\n"); 
		query.append("   ,OB_SLS_OFC_CD = (SELECT OFC_CD FROM MDM_SLS_REP WHERE UPPER(SREP_CD) = UPPER(@[ob_srep_cd]))" ).append("\n"); 
		query.append("   ,OB_SREP_CD = @[ob_srep_cd]" ).append("\n"); 
		query.append("   ,UPD_USR_ID = @[upd_usr_id]" ).append("\n"); 
		query.append("   ,UPD_DT = SYSDATE" ).append("\n"); 
		query.append("WHERE BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("#if (${ca_flg}== 'Y')" ).append("\n"); 
		query.append("AND   CORR_NO = 'TMP0000001'" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}