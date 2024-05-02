/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : EBookingReceiptDBDAOupdateRerouteOfcCdUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.11.02
*@LastModifier : 이도형
*@LastVersion : 1.0
* 2015.11.02 이도형
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author LEE, do hyoung
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class EBookingReceiptDBDAOupdateRerouteOfcCdUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * EBookingReceiptDBDAOupdateRerouteOfcCdUSQL
	  * </pre>
	  */
	public EBookingReceiptDBDAOupdateRerouteOfcCdUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rqst_no",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("sender_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("new_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.integration").append("\n"); 
		query.append("FileName : EBookingReceiptDBDAOupdateRerouteOfcCdUSQL").append("\n"); 
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
		query.append("UPDATE BKG_XTER_RQST_MST MST" ).append("\n"); 
		query.append("   SET MST.HNDL_OFC_CD = @[new_ofc_cd]" ).append("\n"); 
		query.append("     , MST.BKG_OFC_CD = @[new_ofc_cd]" ).append("\n"); 
		query.append("     , MST.PRE_HNDL_OFC_CD = MST.HNDL_OFC_CD" ).append("\n"); 
		query.append("     , MST.CNG_HNDL_OFC_USR_ID = @[usr_id]" ).append("\n"); 
		query.append("     , MST.CNG_HNDL_OFC_UPD_DT = GLOBALDATE_PKG.TIME_CONV_FNC('KRSEL',SYSDATE,(SELECT MO.LOC_CD FROM COM_USER CU, MDM_ORGANIZATION MO WHERE CU.USR_ID = @[usr_id] AND CU.OFC_CD = MO.OFC_CD))" ).append("\n"); 
		query.append(" WHERE MST.XTER_SNDR_ID = @[sender_id]" ).append("\n"); 
		query.append("   AND MST.XTER_RQST_NO = @[rqst_no]" ).append("\n"); 
		query.append("   AND MST.DOC_TP_CD = 'B'" ).append("\n"); 
		query.append("   AND MST.BKG_UPLD_STS_CD IN ('N','P')" ).append("\n"); 
		query.append("   AND NOT EXISTS (SELECT 'X' FROM BKG_BOOKING BB WHERE BB.BKG_NO = MST.BKG_NO)" ).append("\n"); 

	}
}