/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : EBookingReceiptDBDAOSendXterRqstNoticeSubjectRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.03.28
*@LastModifier : 
*@LastVersion : 1.0
* 2016.03.28 
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

public class EBookingReceiptDBDAOSendXterRqstNoticeSubjectRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * S
	  * </pre>
	  */
	public EBookingReceiptDBDAOSendXterRqstNoticeSubjectRSQL(){
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
		query.append("FileName : EBookingReceiptDBDAOSendXterRqstNoticeSubjectRSQL").append("\n"); 
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
		query.append("SELECT CASE WHEN MST.DOC_TP_CD = 'B' AND MST.XTER_BKG_RQST_STS_CD = 'C' THEN" ).append("\n"); 
		query.append("            'New Booking Request-Sender: '|| " ).append("\n"); 
		query.append("                CASE WHEN MST.XTER_SNDR_ID = 'PEGASUS' THEN NVL((SELECT BHCC.ATTR_CTNT2 FROM BKG_HRD_CDG_CTNT BHCC WHERE BHCC.HRD_CDG_ID = 'CUSTOMER_301_EDI_ID' AND BHCC.ATTR_CTNT1 = MST.PGSS_EDI_ID AND ROWNUM = 1),MST.XTER_SNDR_ID)" ).append("\n"); 
		query.append("                ELSE MST.XTER_SNDR_ID END" ).append("\n"); 
		query.append("                ||' ReleaseNo: '||MST.XTER_RQST_NO||' Version: '||MST.XTER_RQST_SEQ" ).append("\n"); 
		query.append("                ||DECODE(MST.POR_CD,NULL,'',' POR:'||MST.POR_CD)||DECODE(MST.POL_CD,NULL,'',' LP:'||MST.POL_CD)||DECODE(MST.POD_CD,NULL,'',' POD:'||MST.POD_CD)" ).append("\n"); 
		query.append("                ||DECODE(MST.DEL_CD,NULL,'',' DEL:'||MST.DEL_CD)" ).append("\n"); 
		query.append("            WHEN MST.DOC_TP_CD = 'B' AND MST.XTER_BKG_RQST_STS_CD = 'U' THEN" ).append("\n"); 
		query.append("            'Change Booking Request-Sender: '||MST.XTER_SNDR_ID||' ReleaseNo: '||MST.XTER_RQST_NO||' Version: '||MST.XTER_RQST_SEQ" ).append("\n"); 
		query.append("                ||DECODE(MST.POR_CD,NULL,'',' POR:'||MST.POR_CD)||DECODE(MST.POL_CD,NULL,'',' LP:'||MST.POL_CD)||DECODE(MST.POD_CD,NULL,'',' POD:'||MST.POD_CD)" ).append("\n"); 
		query.append("                ||DECODE(MST.DEL_CD,NULL,'',' DEL:'||MST.DEL_CD)||DECODE(MST.BKG_NO,NULL,'',' Booking # '||MST.BKG_NO)" ).append("\n"); 
		query.append("            WHEN MST.DOC_TP_CD = 'B' AND MST.XTER_BKG_RQST_STS_CD = 'X' THEN" ).append("\n"); 
		query.append("            'Cancel Booking Request-Sender: '||MST.XTER_SNDR_ID||' ReleaseNo: '||MST.XTER_RQST_NO||' Version: '||MST.XTER_RQST_SEQ" ).append("\n"); 
		query.append("                ||DECODE(MST.POR_CD,NULL,'',' POR:'||MST.POR_CD)||DECODE(MST.POL_CD,NULL,'',' LP:'||MST.POL_CD)||DECODE(MST.POD_CD,NULL,'',' POD:'||MST.POD_CD)" ).append("\n"); 
		query.append("                ||DECODE(MST.DEL_CD,NULL,'',' DEL:'||MST.DEL_CD)||DECODE(MST.BKG_NO,NULL,'',' Booking # '||MST.BKG_NO)" ).append("\n"); 
		query.append("            WHEN MST.DOC_TP_CD = 'S' AND MST.XTER_BKG_RQST_STS_CD = 'C' THEN" ).append("\n"); 
		query.append("            'New eSI-Sender: '||MST.XTER_SNDR_ID||' ReleaseNo: '||MST.XTER_RQST_NO||' Version: '||MST.XTER_RQST_SEQ" ).append("\n"); 
		query.append("                ||DECODE(MST.BKG_NO,NULL,'',' Booking # '||MST.BKG_NO)||DECODE(MST.POR_CD,NULL,'',' POR:'||MST.POR_CD)" ).append("\n"); 
		query.append("                ||DECODE(MST.POL_CD,NULL,'',' LP:'||MST.POL_CD)||DECODE(MST.POD_CD,NULL,'',' POD:'||MST.POD_CD)||DECODE(MST.DEL_CD,NULL,'',' DEL:'||MST.DEL_CD)" ).append("\n"); 
		query.append("            WHEN MST.DOC_TP_CD = 'S' AND MST.XTER_BKG_RQST_STS_CD = 'U' THEN" ).append("\n"); 
		query.append("            'Change eSI-Sender: '||MST.XTER_SNDR_ID||' ReleaseNo: '||MST.XTER_RQST_NO||' Version: '||MST.XTER_RQST_SEQ" ).append("\n"); 
		query.append("                ||DECODE(MST.BKG_NO,NULL,'',' Booking # '||MST.BKG_NO)||DECODE(MST.POR_CD,NULL,'',' POR:'||MST.POR_CD)" ).append("\n"); 
		query.append("                ||DECODE(MST.POL_CD,NULL,'',' LP:'||MST.POL_CD)||DECODE(MST.POD_CD,NULL,'',' POD:'||MST.POD_CD)||DECODE(MST.DEL_CD,NULL,'',' DEL:'||MST.DEL_CD)" ).append("\n"); 
		query.append("            ELSE " ).append("\n"); 
		query.append("            'New e-Booking or e-SI request has arrived'" ).append("\n"); 
		query.append("            END SUBJECT" ).append("\n"); 
		query.append("FROM BKG_XTER_RQST_MST MST" ).append("\n"); 
		query.append("WHERE MST.XTER_SNDR_ID = @[sender_id]" ).append("\n"); 
		query.append("AND MST.XTER_RQST_NO = @[rqst_no]" ).append("\n"); 
		query.append("AND MST.XTER_RQST_SEQ = @[rqst_seq]" ).append("\n"); 

	}
}