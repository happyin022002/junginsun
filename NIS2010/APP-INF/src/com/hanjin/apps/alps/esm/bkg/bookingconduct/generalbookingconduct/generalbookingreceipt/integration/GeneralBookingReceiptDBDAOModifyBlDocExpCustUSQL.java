/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : GeneralBookingReceiptDBDAOModifyBlDocExpCustUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.09.19
*@LastModifier : KIM HYUN HWA
*@LastVersion : 1.0
* 2011.09.19 KIM HYUN HWA
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author ISD1
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class GeneralBookingReceiptDBDAOModifyBlDocExpCustUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Booking Customer Tab 에서 오른쪽 상단에 A/Customer 변경 시 Export Ref. 항목에,
	  * 입력된 기존 입력 data + 줄 바꿈 처리 Customer 의 Name 이 저장 되도록 변경(Before, After 의 A/Customer 다르면 Before 삭제 및 After로 변경)
	  * </pre>
	  */
	public GeneralBookingReceiptDBDAOModifyBlDocExpCustUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("old_act_cust_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("new_act_cust_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("old_act_cust_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("new_act_cust_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.integration").append("\n"); 
		query.append("FileName : GeneralBookingReceiptDBDAOModifyBlDocExpCustUSQL").append("\n"); 
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
		query.append("UPDATE BKG_CUST_HIS" ).append("\n"); 
		query.append("SET    CUST_NM = ( CASE WHEN " ).append("\n"); 
		query.append("                       DECODE(@[old_act_cust_cd],'','',(SELECT 'X' " ).append("\n"); 
		query.append("                                                        FROM BKG_CUST_HIS " ).append("\n"); 
		query.append("                                                        WHERE BKG_NO= @[bkg_no]" ).append("\n"); 
		query.append("                                                        AND   CORR_NO = 'TMP0000001'" ).append("\n"); 
		query.append("			                                            AND   BKG_CUST_TP_CD ='E'" ).append("\n"); 
		query.append("                                                        AND   CUST_NM LIKE '%'||@[old_act_cust_nm]||'%' )) IS NULL " ).append("\n"); 
		query.append("                       THEN ( SELECT DECODE(NVL(CUST_NM,''),'','',CUST_NM||CHR(13))||DECODE(@[new_act_cust_cd],NULL,'' ,@[new_act_cust_nm])" ).append("\n"); 
		query.append("                              FROM   BKG_CUST_HIS " ).append("\n"); 
		query.append("                              WHERE  BKG_NO= @[bkg_no] AND CORR_NO = 'TMP0000001'  AND BKG_CUST_TP_CD ='E')  " ).append("\n"); 
		query.append("                       ELSE ( SELECT DECODE(@[new_act_cust_cd],NULL,REPLACE(CUST_NM,@[old_act_cust_nm]  ,'') ,REPLACE(CUST_NM,@[old_act_cust_nm],@[new_act_cust_nm])) " ).append("\n"); 
		query.append("                              FROM   BKG_CUST_HIS" ).append("\n"); 
		query.append("                              WHERE  BKG_NO= @[bkg_no] AND CORR_NO = 'TMP0000001'" ).append("\n"); 
		query.append("							  AND    BKG_CUST_TP_CD ='E')" ).append("\n"); 
		query.append("                      END)" ).append("\n"); 
		query.append(", UPD_USR_ID = @[upd_usr_id]" ).append("\n"); 
		query.append(", UPD_DT     = SYSDATE" ).append("\n"); 
		query.append("WHERE  BKG_NO  =  @[bkg_no]" ).append("\n"); 
		query.append("AND CORR_NO = 'TMP0000001'" ).append("\n"); 
		query.append("AND BKG_CUST_TP_CD ='E'" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("UPDATE BKG_CUSTOMER" ).append("\n"); 
		query.append("SET    CUST_NM =  ( CASE WHEN " ).append("\n"); 
		query.append("                         DECODE(@[old_act_cust_cd],'','',(SELECT 'X' " ).append("\n"); 
		query.append("                                                           FROM BKG_CUSTOMER " ).append("\n"); 
		query.append("                                                           WHERE BKG_NO= @[bkg_no]" ).append("\n"); 
		query.append("                                                           AND BKG_CUST_TP_CD ='E' " ).append("\n"); 
		query.append("                                                           AND   CUST_NM LIKE '%'||@[old_act_cust_nm]||'%' )) IS NULL " ).append("\n"); 
		query.append("                         THEN ( SELECT DECODE(NVL(CUST_NM,''),'','',CUST_NM||CHR(13))||DECODE(@[new_act_cust_cd],NULL,'', @[new_act_cust_nm])" ).append("\n"); 
		query.append("                                FROM BKG_CUSTOMER " ).append("\n"); 
		query.append("                                WHERE BKG_NO= @[bkg_no] AND BKG_CUST_TP_CD ='E')  " ).append("\n"); 
		query.append("                         ELSE ( SELECT DECODE(@[new_act_cust_cd],NULL,REPLACE(CUST_NM ,@[old_act_cust_nm] ,'') ,REPLACE(CUST_NM ,@[old_act_cust_nm],@[new_act_cust_nm])) " ).append("\n"); 
		query.append("                                FROM BKG_CUSTOMER" ).append("\n"); 
		query.append("                                WHERE BKG_NO= @[bkg_no] AND BKG_CUST_TP_CD ='E')" ).append("\n"); 
		query.append("                         END)" ).append("\n"); 
		query.append(", UPD_USR_ID = @[upd_usr_id]" ).append("\n"); 
		query.append(", UPD_DT     = SYSDATE" ).append("\n"); 
		query.append("WHERE  BKG_NO =  @[bkg_no]" ).append("\n"); 
		query.append("AND BKG_CUST_TP_CD ='E'" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}