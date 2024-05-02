/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : EBookingReceiptDBDAOUpdateXterRqstCfmUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.08.31
*@LastModifier : 
*@LastVersion : 1.0
* 2017.08.31 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class EBookingReceiptDBDAOUpdateXterRqstCfmUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * bkg_xter_rqst_mst에 upload 되었음을 기록한다.
	  * 
	  * SEANACCS의 경우 049/050(Creation Request), 053/054(Update Request) 가 Pair 로 접수됨.
	  * Master : 049/053
	  * Attached : 050/054
	  * Master의 BKG No Update시 Split 요청받은 Attached 도 함께 Update한다.
	  * </pre>
	  */
	public EBookingReceiptDBDAOUpdateXterRqstCfmUSQL(){
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

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.integration").append("\n"); 
		query.append("FileName : EBookingReceiptDBDAOUpdateXterRqstCfmUSQL").append("\n"); 
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
		query.append("UPDATE BKG_XTER_RQST_MST M" ).append("\n"); 
		query.append("   SET M.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("	 , M.UPLD_USR_ID = @[usr_id]" ).append("\n"); 
		query.append("	 , M.UPLD_DT = GLOBALDATE_PKG.TIME_CONV_FNC('KRSEL',SYSDATE,(SELECT POR_CD FROM BKG_BOOKING WHERE BKG_NO = @[bkg_no]))" ).append("\n"); 
		query.append("	 , M.UPLD_GDT = GLOBALDATE_PKG.TIME_CONV_FNC('KRSEL',SYSDATE,'GMT' )" ).append("\n"); 
		query.append("	 , M.UPD_DT = SYSDATE" ).append("\n"); 
		query.append(" 	 , M.UPD_USR_ID = @[usr_id]" ).append("\n"); 
		query.append("	 , M.HNDL_OFC_CD = nvl(HNDL_OFC_CD, @[ofc_cd])" ).append("\n"); 
		query.append("	 , M.BKG_UPLD_STS_CD = 'F'" ).append("\n"); 
		query.append(" WHERE M.XTER_SNDR_ID  = @[sender_id]" ).append("\n"); 
		query.append("   AND M.XTER_RQST_NO  = @[rqst_no]" ).append("\n"); 
		query.append("   AND M.XTER_RQST_SEQ IN( @[rqst_seq], (SELECT XTER_RQST_SEQ " ).append("\n"); 
		query.append("								 FROM BKG_XTER_RQST_MST S" ).append("\n"); 
		query.append("								 WHERE S.XTER_SNDR_ID  = 'SEANACCS'" ).append("\n"); 
		query.append("								 AND S.XTER_RQST_NO  = M.XTER_RQST_NO" ).append("\n"); 
		query.append("								 AND S.XTER_RQST_SEQ = @[rqst_seq] + 1" ).append("\n"); 
		query.append("                                 AND S.SNACCS_MSG_TP_CD in ('SAT050','SAT054','SAT141','SAT142','SAT146','SAT147')" ).append("\n"); 
		query.append("                                 AND NVL(S.SNACCS_SPLIT_NO,'0') = NVL(M.SNACCS_SPLIT_NO,'0')))" ).append("\n"); 

	}
}