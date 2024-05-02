/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : EBookingReceiptDBDAOsearchXterEdiSeqAckRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.12.04
*@LastModifier : 이도형
*@LastVersion : 1.0
* 2014.12.04 이도형
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

public class EBookingReceiptDBDAOsearchXterEdiSeqAckRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchXterEdiSeqAck
	  * </pre>
	  */
	public EBookingReceiptDBDAOsearchXterEdiSeqAckRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.integration").append("\n"); 
		query.append("FileName : EBookingReceiptDBDAOsearchXterEdiSeqAckRSQL").append("\n"); 
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
		query.append("SELECT RPAD(NVL(TRIM('BKG'),' '),3)||TO_CHAR(SYSDATE,'rrmmdd')||LTRIM(TO_CHAR(BKG_EDI_SEQ.nextval,'000009'),' ') EDI_SEQ" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 

	}
}