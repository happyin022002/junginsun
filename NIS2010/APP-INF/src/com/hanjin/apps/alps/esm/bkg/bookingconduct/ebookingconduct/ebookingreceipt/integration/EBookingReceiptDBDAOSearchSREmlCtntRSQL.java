/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : EBookingReceiptDBDAOSearchSREmlCtntRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.09.01
*@LastModifier : 
*@LastVersion : 1.0
* 2011.09.01 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class EBookingReceiptDBDAOSearchSREmlCtntRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * EBookingReceiptDBDAOSearchSREmlCtntRSQL
	  * </pre>
	  */
	public EBookingReceiptDBDAOSearchSREmlCtntRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sr_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fax_log_ref_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.integration ").append("\n"); 
		query.append("FileName : EBookingReceiptDBDAOSearchSREmlCtntRSQL").append("\n"); 
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
		query.append("SELECT " ).append("\n"); 
		query.append("	C.SR_NO" ).append("\n"); 
		query.append(",	C.FAX_LOG_REF_NO" ).append("\n"); 
		query.append(",	C.SR_KND_CD" ).append("\n"); 
		query.append(",	C.EML_MN_CTNT" ).append("\n"); 
		query.append(",	C.CRE_USR_ID" ).append("\n"); 
		query.append(",	C.CRE_DT" ).append("\n"); 
		query.append(",	C.UPD_USR_ID" ).append("\n"); 
		query.append(",	C.UPD_DT" ).append("\n"); 
		query.append(",	EML.EML_SUBJ_CTNT" ).append("\n"); 
		query.append(",	EML.EML_ORG_SUBJ_CTNT" ).append("\n"); 
		query.append("FROM BKG_SR_EML_CTNT C" ).append("\n"); 
		query.append(",	BKG_SR_FAX EML" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND	C.SR_NO(+)	= EML.SR_NO" ).append("\n"); 
		query.append("AND	C.FAX_LOG_REF_NO(+) = EML.FAX_LOG_REF_NO" ).append("\n"); 
		query.append("AND	C.SR_KND_CD(+) = EML.SR_KND_CD" ).append("\n"); 
		query.append("AND	EML.SR_NO = @[sr_no]" ).append("\n"); 
		query.append("AND	EML.FAX_LOG_REF_NO = @[fax_log_ref_no]" ).append("\n"); 
		query.append("AND	EML.SR_KND_CD = 'M'" ).append("\n"); 

	}
}