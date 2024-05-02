/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : EBookingReceiptDBDAOmodifyBkgXterVgmRqstUpldUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.06.23
*@LastModifier : 
*@LastVersion : 1.0
* 2016.06.23 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class EBookingReceiptDBDAOmodifyBkgXterVgmRqstUpldUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Modify BKG_XTER_VGM_RQST for Upload
	  * </pre>
	  */
	public EBookingReceiptDBDAOmodifyBkgXterVgmRqstUpldUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vgm_upld_sts_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("xter_vgm_rqst_seq",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("upd_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("xter_vgm_doc_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.integration").append("\n"); 
		query.append("FileName : EBookingReceiptDBDAOmodifyBkgXterVgmRqstUpldUSQL").append("\n"); 
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
		query.append("UPDATE BKG_XTER_VGM_RQST" ).append("\n"); 
		query.append("SET    VGM_UPLD_STS_CD = @[vgm_upld_sts_cd]" ).append("\n"); 
		query.append("	 , UPLD_USR_ID = @[upd_usr_id]" ).append("\n"); 
		query.append("	 , UPLD_DT = SYSDATE" ).append("\n"); 
		query.append("     , UPLD_GDT =  GLOBALDATE_PKG.TIME_CONV_FNC(COM_CONSTANTMGR_PKG.COM_GETBASELOCATIONCODE_FNC(),sysdate,'GMT')" ).append("\n"); 
		query.append("WHERE XTER_SNDR_ID = @[xter_sndr_id]" ).append("\n"); 
		query.append("AND XTER_VGM_DOC_ID = @[xter_vgm_doc_id]" ).append("\n"); 
		query.append("AND XTER_VGM_RQST_SEQ = @[xter_vgm_rqst_seq]" ).append("\n"); 
		query.append("AND CNTR_NO =  @[cntr_no]" ).append("\n"); 

	}
}