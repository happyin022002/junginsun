/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EBookingReceiptDBDAOModifyAutoBkgRctSendUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.18
*@LastModifier : 류대영
*@LastVersion : 1.0
* 2009.10.18 류대영
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Dae-Young RYU
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class EBookingReceiptDBDAOModifyAutoBkgRctSendUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * auto confirm edi를 전송했음을 기록한다.
	  * </pre>
	  */
	public EBookingReceiptDBDAOModifyAutoBkgRctSendUSQL(){
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
		params.put("sender_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.integration").append("\n"); 
		query.append("FileName : EBookingReceiptDBDAOModifyAutoBkgRctSendUSQL").append("\n"); 
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
		query.append("UPDATE	BKG_XTER_RQST_MST" ).append("\n"); 
		query.append("SET	AUTO_CFM_EDI_FLG	= 'Y'," ).append("\n"); 
		query.append("AUTO_CFM_EDI_DT	    = nvl(GLOBALDATE_PKG.TIME_CONV_FNC('KRSEL',SYSDATE," ).append("\n"); 
		query.append("(SELECT POL_CD" ).append("\n"); 
		query.append("FROM BKG_XTER_RQST_MST" ).append("\n"); 
		query.append("where XTER_SNDR_ID  = @[sender_id]" ).append("\n"); 
		query.append("and xter_rqst_no  = @[rqst_no]" ).append("\n"); 
		query.append("and xter_rqst_seq = @[rqst_seq]))" ).append("\n"); 
		query.append(", SYSDATE)" ).append("\n"); 
		query.append("where XTER_SNDR_ID  = @[sender_id]" ).append("\n"); 
		query.append("and xter_rqst_no  = @[rqst_no]" ).append("\n"); 
		query.append("and xter_rqst_seq = @[rqst_seq]" ).append("\n"); 

	}
}