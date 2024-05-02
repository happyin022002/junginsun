/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : EBookingReceiptDBDAOUpdateXterRqstCfmUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.04.11
*@LastModifier : 류대영
*@LastVersion : 1.0
* 2010.04.11 류대영
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Ryu Daeyoung
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
	  * bkg_xter_rqst_mst에 upload 되었음을 기혹한다.
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
		query.append("Path : com.clt.apps.opus.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.integration").append("\n"); 
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
		query.append("UPDATE BKG_XTER_RQST_MST" ).append("\n"); 
		query.append("SET BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append(", UPLD_USR_ID = @[usr_id]" ).append("\n"); 
		query.append(", UPLD_DT = GLOBALDATE_PKG.TIME_CONV_FNC('KRSEL',SYSDATE,(SELECT POL_CD FROM BKG_BOOKING WHERE BKG_NO = @[bkg_no]))" ).append("\n"); 
		query.append(", UPLD_GDT = GLOBALDATE_PKG.TIME_CONV_FNC('KRSEL',SYSDATE,'GMT' )" ).append("\n"); 
		query.append(", UPD_DT = SYSDATE" ).append("\n"); 
		query.append(", UPD_USR_ID = @[usr_id]" ).append("\n"); 
		query.append(", HNDL_OFC_CD = nvl(HNDL_OFC_CD, @[ofc_cd])" ).append("\n"); 
		query.append(", BKG_UPLD_STS_CD = 'F'" ).append("\n"); 
		query.append("WHERE XTER_SNDR_ID  = @[sender_id]" ).append("\n"); 
		query.append("AND XTER_RQST_NO  = @[rqst_no]" ).append("\n"); 
		query.append("AND XTER_RQST_SEQ = @[rqst_seq]" ).append("\n"); 

	}
}