/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : EBookingReceiptDBDAOSearchXterTroForAckRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.12.15
*@LastModifier : jklim
*@LastVersion : 1.0
* 2014.12.15 jklim
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author jklim
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class EBookingReceiptDBDAOSearchXterTroForAckRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * auto confirm edi 중 tro 정보를 조회한다.
	  * </pre>
	  */
	public EBookingReceiptDBDAOSearchXterTroForAckRSQL(){
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
		query.append("FileName : EBookingReceiptDBDAOSearchXterTroForAckRSQL").append("\n"); 
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
		query.append("select  '{I_BKG_TRO'                                ||CHR(10)||" ).append("\n"); 
		query.append("        'IB_TRO_SEQ:'       || TRO_SEQ              ||CHR(10)||" ).append("\n"); 
		query.append("        'IB_TRO_ACUST_NM:'  || ACT_SHPR_NM          ||CHR(10)||" ).append("\n"); 
		query.append("        'IB_TRO_PERSON:'    || CNTC_PSON_NM         ||CHR(10)||" ).append("\n"); 
		query.append("        'IB_TRO_TEL:'       || CNTC_PHN_NO_CTNT     ||CHR(10)||" ).append("\n"); 
		query.append("        'IB_TRO_REQ_DT:'	|| TO_CHAR(RQST_DT,'YYYYMMDDHH24MI')  ||CHR(10)|| " ).append("\n"); 
		query.append("        'IB_TRO_DOOR_LOC:'  || DOR_LOC_CD           ||CHR(10)||" ).append("\n"); 
		query.append("        'IB_TRO_REMARK:'    || TRO_RMK              ||CHR(10)||" ).append("\n"); 
		query.append("        'IB_TRO_POL_YD_LOC:'|| FULL_RTN_YD_LOC_CD   ||CHR(10)||" ).append("\n"); 
		query.append("        'IB_TRO_POL_YD_NM:' || FULL_RTN_YD_NM       ||CHR(10)||" ).append("\n"); 
		query.append("        '}I_BKG_TRO'                                ||CHR(10) FLAT_FILE" ).append("\n"); 
		query.append("  from bkg_xteR_tro" ).append("\n"); 
		query.append(" where XTER_SNDR_ID  = @[sender_id]" ).append("\n"); 
		query.append("   and xter_rqst_no  = @[rqst_no]" ).append("\n"); 
		query.append("   and xter_rqst_seq = @[rqst_seq]" ).append("\n"); 

	}
}