/*=========================================================
*Copyright(c) 2018 CyberLogitec
*@FileName : BookingARCreationDBDAOModifyINDGstRtoUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2018.02.13
*@LastModifier : 
*@LastVersion : 1.0
* 2018.02.13 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.bookingarcreation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BookingARCreationDBDAOModifyINDGstRtoUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Modify INDIA Gst Rto
	  * </pre>
	  */
	public BookingARCreationDBDAOModifyINDGstRtoUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ind_gst_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("user_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ar_if_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.bookingarcreation.integration").append("\n"); 
		query.append("FileName : BookingARCreationDBDAOModifyINDGstRtoUSQL").append("\n"); 
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
		query.append("UPDATE INV_AR_CHG   -- 2018.02.13 1월 ~ 9월까지 한시적 STO TAX 면제로직 추가" ).append("\n"); 
		query.append("SET IDA_CGST_RTO = DECODE(CHG_CD||(SELECT IO_BND_CD FROM INV_AR_MN WHERE AR_IF_NO = @[ar_if_no]), 'OFTO', 0, (SELECT IDA_CGST_RTO FROM TABLE(INV_GET_IDA_GST_RTO_FNC(@[ind_gst_tp_cd], IDA_SAC_CD))))" ).append("\n"); 
		query.append("  , IDA_SGST_RTO = DECODE(CHG_CD||(SELECT IO_BND_CD FROM INV_AR_MN WHERE AR_IF_NO = @[ar_if_no]), 'OFTO', 0, (SELECT IDA_SGST_RTO FROM TABLE(INV_GET_IDA_GST_RTO_FNC(@[ind_gst_tp_cd], IDA_SAC_CD))))" ).append("\n"); 
		query.append("  , IDA_IGST_RTO = DECODE(CHG_CD||(SELECT IO_BND_CD FROM INV_AR_MN WHERE AR_IF_NO = @[ar_if_no]), 'OFTO', 0, (SELECT IDA_IGST_RTO FROM TABLE(INV_GET_IDA_GST_RTO_FNC(@[ind_gst_tp_cd], IDA_SAC_CD))))" ).append("\n"); 
		query.append("  , IDA_UGST_RTO = DECODE(CHG_CD||(SELECT IO_BND_CD FROM INV_AR_MN WHERE AR_IF_NO = @[ar_if_no]), 'OFTO', 0, (SELECT IDA_UGST_RTO FROM TABLE(INV_GET_IDA_GST_RTO_FNC(@[ind_gst_tp_cd], IDA_SAC_CD))))" ).append("\n"); 
		query.append("  , UPD_USR_ID = @[user_id]" ).append("\n"); 
		query.append("  , UPD_DT = SYSDATE" ).append("\n"); 
		query.append("WHERE AR_IF_NO = @[ar_if_no]" ).append("\n"); 

	}
}