/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : GeneralBookingReceiptDBDAOModifyBkgCustCodeUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.01.16
*@LastModifier : 
*@LastVersion : 1.0
* 2017.01.16 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class GeneralBookingReceiptDBDAOModifyBkgCustCodeUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Booking Creation 화면에서 Customer정보를 수정한다
	  * </pre>
	  */
	public GeneralBookingReceiptDBDAOModifyBkgCustCodeUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_cust_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_addr",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.integration").append("\n"); 
		query.append("FileName : GeneralBookingReceiptDBDAOModifyBkgCustCodeUSQL").append("\n"); 
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
		query.append("UPDATE BKG_CUST_HIS SET " ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("UPDATE BKG_CUSTOMER SET " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("	CUST_CNT_CD = @[cust_cnt_cd]" ).append("\n"); 
		query.append(",	CUST_SEQ = @[cust_seq]" ).append("\n"); 
		query.append(",	CUST_NM = @[cust_nm]" ).append("\n"); 
		query.append(",   CUST_ADDR = @[cust_addr]" ).append("\n"); 
		query.append("#if (${cust_subst_flg}== 'Y')" ).append("\n"); 
		query.append(",	CUST_CTY_NM =(SELECT CTY_NM                    " ).append("\n"); 
		query.append("			      FROM MDM_CUST_ADDR" ).append("\n"); 
		query.append("		          WHERE CUST_CNT_CD   = @[cust_cnt_cd]" ).append("\n"); 
		query.append("			      AND CUST_SEQ      = @[cust_seq]" ).append("\n"); 
		query.append("		          AND PRMRY_CHK_FLG = 'Y'" ).append("\n"); 
		query.append("		          AND ROWNUM        = 1)" ).append("\n"); 
		query.append(",	CUST_STE_CD = (SELECT STE_CD                    " ).append("\n"); 
		query.append("		   	   	   FROM MDM_CUST_ADDR" ).append("\n"); 
		query.append("			       WHERE CUST_CNT_CD   = @[cust_cnt_cd]" ).append("\n"); 
		query.append("		           AND CUST_SEQ      = @[cust_seq]" ).append("\n"); 
		query.append("			       AND PRMRY_CHK_FLG = 'Y'" ).append("\n"); 
		query.append("			       AND ROWNUM        = 1)" ).append("\n"); 
		query.append(",	CUST_ZIP_ID = (SELECT ZIP_CD                    " ).append("\n"); 
		query.append("	               FROM MDM_CUST_ADDR" ).append("\n"); 
		query.append("			       WHERE CUST_CNT_CD   = @[cust_cnt_cd]" ).append("\n"); 
		query.append("			       AND CUST_SEQ      = @[cust_seq]" ).append("\n"); 
		query.append("			       AND PRMRY_CHK_FLG = 'Y'" ).append("\n"); 
		query.append("			       AND ROWNUM        = 1)" ).append("\n"); 
		query.append(",	CUST_EML =(SELECT CNTC_EML                   " ).append("\n"); 
		query.append("	           FROM MDM_CUST_ADDR" ).append("\n"); 
		query.append("               WHERE CUST_CNT_CD   = @[cust_cnt_cd]" ).append("\n"); 
		query.append("               AND CUST_SEQ      = @[cust_seq]" ).append("\n"); 
		query.append("               AND PRMRY_CHK_FLG = 'Y'" ).append("\n"); 
		query.append("               AND ROWNUM        = 1)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(",	UPD_USR_ID = @[upd_usr_id]" ).append("\n"); 
		query.append(",	UPD_DT = SYSDATE" ).append("\n"); 
		query.append(",   CUST_CD_UPD_DT = GLOBALDATE_PKG.TIME_CONV_FNC(COM_ConstantMgr_PKG.COM_getBaseLocationCode_FNC(),sysdate,(SELECT POL_CD FROM BKG_BOOKING WHERE BKG_NO = @[bkg_no]))" ).append("\n"); 
		query.append("WHERE	BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("AND	BKG_CUST_TP_CD = @[bkg_cust_tp_cd]" ).append("\n"); 
		query.append("#if (${ca_flg}== 'Y')" ).append("\n"); 
		query.append("AND   CORR_NO = 'TMP0000001'" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}