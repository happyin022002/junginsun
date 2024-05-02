/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : EBookingReceiptDBDAOmodifyEBookingControlMgmtUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.08.24
*@LastModifier : 윤용상
*@LastVersion : 1.0
* 2016.08.24 윤용상
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author YOON Yong-Sang
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class EBookingReceiptDBDAOmodifyEBookingControlMgmtUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * modifyEBookingControlMgmt
	  * </pre>
	  */
	public EBookingReceiptDBDAOmodifyEBookingControlMgmtUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inp_xter_rqst_acpt_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("spc_ctrlr_rmk",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("xter_rqst_no",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("xter_sndr_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.integration").append("\n"); 
		query.append("FileName : EBookingReceiptDBDAOmodifyEBookingControlMgmtUSQL").append("\n"); 
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
		query.append("SET    " ).append("\n"); 
		query.append(" #if(${inp_xter_rqst_acpt_cd} == 'RMK')" ).append("\n"); 
		query.append("       spc_ctrlr_rmk = @[spc_ctrlr_rmk]," ).append("\n"); 
		query.append("	   upd_dt = sysdate," ).append("\n"); 
		query.append("       upd_usr_id = @[usr_id]" ).append("\n"); 
		query.append(" #else" ).append("\n"); 
		query.append("	   XTER_RQST_ACPT_CD = @[inp_xter_rqst_acpt_cd]," ).append("\n"); 
		query.append("       XTER_RQST_ACPT_USR_ID = @[usr_id]," ).append("\n"); 
		query.append("       XTER_RQST_ACPT_UPD_DT = SYSDATE" ).append("\n"); 
		query.append(" #end" ).append("\n"); 
		query.append("WHERE  XTER_SNDR_ID         = @[xter_sndr_id]" ).append("\n"); 
		query.append("AND    XTER_RQST_NO         = @[xter_rqst_no]" ).append("\n"); 
		query.append("AND    XTER_RQST_SEQ        = @[xter_rqst_seq]" ).append("\n"); 

	}
}