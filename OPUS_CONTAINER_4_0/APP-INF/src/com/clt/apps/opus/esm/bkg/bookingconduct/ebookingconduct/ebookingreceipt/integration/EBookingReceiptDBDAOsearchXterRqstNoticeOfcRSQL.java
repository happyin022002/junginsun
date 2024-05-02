/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : EBookingReceiptDBDAOsearchXterRqstNoticeOfcRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.02.24
*@LastModifier : 
*@LastVersion : 1.0
* 2017.02.24 
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

public class EBookingReceiptDBDAOsearchXterRqstNoticeOfcRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Office 정보에서 xter rqst 접수시 email을 받을 주소를 조회해온다.
	  * </pre>
	  */
	public EBookingReceiptDBDAOsearchXterRqstNoticeOfcRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("rqst_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sender_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.integration").append("\n"); 
		query.append("FileName : EBookingReceiptDBDAOsearchXterRqstNoticeOfcRSQL").append("\n"); 
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
		query.append("select decode(mst.doc_tp_cd, 'B', bkg_ntfc_eml, si_ntfc_eml) EML" ).append("\n"); 
		query.append("  from bkg_xter_rqst_mst mst, bkg_Esvc_ofc_eml eml" ).append("\n"); 
		query.append(" where mst.XTER_SNDR_ID = @[sender_id]" ).append("\n"); 
		query.append("   and mst.xter_rqst_no = @[rqst_no]" ).append("\n"); 
		query.append("   and mst.xter_rqst_seq= @[rqst_seq]" ).append("\n"); 
		query.append("   and mst.hndl_ofc_cd  =       eml.hndl_ofc_cd" ).append("\n"); 

	}
}