/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : EBookingReceiptDBDAOModifyAllPreviousSIRequestStatusUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.08.31
*@LastModifier : Do Soon Choi
*@LastVersion : 1.0
* 2015.08.31 Do Soon Choi
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Do Soon Choi
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class EBookingReceiptDBDAOModifyAllPreviousSIRequestStatusUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Interface로 Upload된 정보 PreviousStatus Update
	  * </pre>
	  */
	public EBookingReceiptDBDAOModifyAllPreviousSIRequestStatusUSQL(){
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
		params.put("rqst_seq",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("sender_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.integration").append("\n"); 
		query.append("FileName : EBookingReceiptDBDAOModifyAllPreviousSIRequestStatusUSQL").append("\n"); 
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
		query.append("UPDATE BKG_XTER_RQST_MST" ).append("\n"); 
		query.append("   SET BKG_UPLD_STS_CD = 'D'" ).append("\n"); 
		query.append("     , UPD_USR_ID = 'HOMEPAGE'" ).append("\n"); 
		query.append("     , UPD_DT = sysdate" ).append("\n"); 
		query.append("	 , RQST_DELT_FLG = 'Y'" ).append("\n"); 
		query.append("     , XTER_RQST_STS_USR_ID = 'HOMEPAGE'" ).append("\n"); 
		query.append("     , XTER_RQST_STS_CD = 'D'" ).append("\n"); 
		query.append("     , XTER_RQST_STS_UPD_DT = SYSDATE" ).append("\n"); 
		query.append(" WHERE BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("   AND NVL(BKG_UPLD_STS_CD,'N') = 'N'" ).append("\n"); 
		query.append("   AND NVL(SYS_UPLD_FLG,'N') = 'N'" ).append("\n"); 
		query.append("   AND DOC_TP_CD IN ('S','U')" ).append("\n"); 
		query.append("   AND (XTER_SNDR_ID,XTER_RQST_NO,XTER_RQST_SEQ) NOT IN (SELECT @[sender_id],@[rqst_no],@[rqst_seq] FROM DUAL)" ).append("\n"); 

	}
}