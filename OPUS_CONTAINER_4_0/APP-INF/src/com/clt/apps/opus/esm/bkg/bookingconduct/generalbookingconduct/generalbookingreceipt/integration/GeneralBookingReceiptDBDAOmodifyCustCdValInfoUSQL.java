/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : GeneralBookingReceiptDBDAOmodifyCustCdValInfoUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.06.27
*@LastModifier : 
*@LastVersion : 1.0
* 2016.06.27 
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

public class GeneralBookingReceiptDBDAOmodifyCustCdValInfoUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ESM_BKG_1054 Code Validation Unmatch Customer에서 주로 사용함 Unmatch에서 Match로 변경될 때 처리
	  * </pre>
	  */
	public GeneralBookingReceiptDBDAOmodifyCustCdValInfoUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cor_cust_cd",new String[]{arrTmp[0],arrTmp[1]});

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

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("val_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_cust_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.integration").append("\n"); 
		query.append("FileName : GeneralBookingReceiptDBDAOmodifyCustCdValInfoUSQL").append("\n"); 
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
		query.append("UPDATE BKG_CUSTOMER" ).append("\n"); 
		query.append("  SET  AN_SND_FLG = DECODE(@[val_cd], 'S', 'N', 'Y') -- SKIP은 메일 발송하지 않는다." ).append("\n"); 
		query.append("     , CUST_CNT_CD = CASE WHEN @[val_cd] IN ('M', 'W') THEN UPPER(SUBSTR( @[cor_cust_cd], 1,2))" ).append("\n"); 
		query.append("                          WHEN @[val_cd] = 'N' THEN NULL  -- Skip, Not Exists는 null로 초기화" ).append("\n"); 
		query.append("                          ELSE CUST_CNT_CD END" ).append("\n"); 
		query.append("     , CUST_SEQ = CASE WHEN @[val_cd] IN ('M', 'W') THEN TO_NUMBER(SUBSTR(@[cor_cust_cd],3,6))" ).append("\n"); 
		query.append("                       WHEN @[val_cd] = 'N' THEN NULL" ).append("\n"); 
		query.append("                       ELSE CUST_SEQ END" ).append("\n"); 
		query.append("     , VAL_CD = @[val_cd]" ).append("\n"); 
		query.append("     , VAL_USR_ID = @[usr_id]" ).append("\n"); 
		query.append("     , VAL_OFC_CD = @[ofc_cd]" ).append("\n"); 
		query.append("     , VAL_DT =  SYSDATE" ).append("\n"); 
		query.append("     , CHG_DP_FLG = (SELECT NVL(MAX(AN_PRN_RT_FLG), 'N')" ).append("\n"); 
		query.append("                       FROM BKG_USR_DFLT_SET" ).append("\n"); 
		query.append("                      WHERE USR_ID = @[usr_id])" ).append("\n"); 
		query.append("     , ORG_CUST_CNT_CD = CUST_CNT_CD" ).append("\n"); 
		query.append("     , ORG_CUST_SEQ = CUST_SEQ" ).append("\n"); 
		query.append("     , UPD_USR_ID = @[usr_id]" ).append("\n"); 
		query.append("     , UPD_DT = SYSDATE" ).append("\n"); 
		query.append("WHERE BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("  AND BKG_CUST_TP_CD = @[bkg_cust_tp_cd]" ).append("\n"); 
		query.append("  AND (@[val_cd] IN ('N', 'O', 'S')  -- not existence는 mdm_customer 존재여부와 상관없이 처리가능한다." ).append("\n"); 
		query.append("       OR EXISTS (SELECT 1" ).append("\n"); 
		query.append("                    FROM MDM_CUSTOMER" ).append("\n"); 
		query.append("                   WHERE CUST_CNT_CD = UPPER(SUBSTR( @[cor_cust_cd], 1,2))  -- validation내용이 R-(Not Exists로 ID생성을 요청하였을 경우)" ).append("\n"); 
		query.append("                     AND CUST_SEQ = TO_NUMBER(SUBSTR(@[cor_cust_cd],3,6))" ).append("\n"); 
		query.append("                  ) -- not existence가 아닌 것은 입력한 값이 code에 있을 경우에만 등록한다." ).append("\n"); 
		query.append("       )" ).append("\n"); 

	}
}