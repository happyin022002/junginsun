/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EBookingReceiptDBDAOaddBkgXterCntrSealNoCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.12.13
*@LastModifier : 민동진
*@LastVersion : 1.0
* 2009.12.13 민동진
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Min, DongJin
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class EBookingReceiptDBDAOaddBkgXterCntrSealNoCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * addBkgXterCntrSealNo
	  * </pre>
	  */
	public EBookingReceiptDBDAOaddBkgXterCntrSealNoCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("seal_pty_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("xter_cntr_seal_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("xter_rqst_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("seal_knd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("xter_sndr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("xter_rqst_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("prn_flg",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.integration").append("\n"); 
		query.append("FileName : EBookingReceiptDBDAOaddBkgXterCntrSealNoCSQL").append("\n"); 
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
		query.append("INSERT INTO BKG_XTER_CNTR_SEAL_NO" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("XTER_SNDR_ID," ).append("\n"); 
		query.append("XTER_RQST_NO," ).append("\n"); 
		query.append("XTER_RQST_SEQ," ).append("\n"); 
		query.append("CNTR_NO," ).append("\n"); 
		query.append("CNTR_SEQ," ).append("\n"); 
		query.append("CNTR_SEAL_SEQ," ).append("\n"); 
		query.append("XTER_CNTR_SEAL_NO," ).append("\n"); 
		query.append("SEAL_PTY_NM," ).append("\n"); 
		query.append("SEAL_KND_CD," ).append("\n"); 
		query.append("PRN_FLG," ).append("\n"); 
		query.append("CRE_USR_ID," ).append("\n"); 
		query.append("CRE_DT," ).append("\n"); 
		query.append("UPD_USR_ID," ).append("\n"); 
		query.append("UPD_DT" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("@[xter_sndr_id]," ).append("\n"); 
		query.append("@[xter_rqst_no]," ).append("\n"); 
		query.append("@[xter_rqst_seq]," ).append("\n"); 
		query.append("@[cntr_no]," ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT NVL(MAX(CNTR_SEQ), 1)" ).append("\n"); 
		query.append("FROM BKG_XTER_CNTR" ).append("\n"); 
		query.append("WHERE XTER_SNDR_ID  = @[xter_sndr_id]" ).append("\n"); 
		query.append("AND XTER_RQST_NO  = @[xter_rqst_no]" ).append("\n"); 
		query.append("AND XTER_RQST_SEQ = @[xter_rqst_seq]" ).append("\n"); 
		query.append("AND CNTR_NO       = @[cntr_no]" ).append("\n"); 
		query.append(")," ).append("\n"); 
		query.append("ROWNUM + (" ).append("\n"); 
		query.append("SELECT NVL(MAX(CNTR_SEAL_SEQ),0)" ).append("\n"); 
		query.append("FROM BKG_XTER_CNTR_SEAL_NO" ).append("\n"); 
		query.append("WHERE XTER_SNDR_ID  = @[xter_sndr_id]" ).append("\n"); 
		query.append("AND XTER_RQST_NO  = @[xter_rqst_no]" ).append("\n"); 
		query.append("AND XTER_RQST_SEQ = @[xter_rqst_seq]" ).append("\n"); 
		query.append("AND CNTR_NO       = @[cntr_no]" ).append("\n"); 
		query.append(")," ).append("\n"); 
		query.append("@[xter_cntr_seal_no]," ).append("\n"); 
		query.append("@[seal_pty_nm]," ).append("\n"); 
		query.append("@[seal_knd_cd]," ).append("\n"); 
		query.append("NVL(@[prn_flg], 'N')," ).append("\n"); 
		query.append("'SYSTEM'," ).append("\n"); 
		query.append("SYSDATE," ).append("\n"); 
		query.append("'SYSTEM'," ).append("\n"); 
		query.append("SYSDATE" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 

	}
}