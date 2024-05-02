/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : EBookingReceiptDBDAOSearchXterDescForAckRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.01.08
*@LastModifier : jklim
*@LastVersion : 1.0
* 2015.01.08 jklim
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

public class EBookingReceiptDBDAOSearchXterDescForAckRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * auto confirm edi 중 desc 정보를 조회한다.
	  * </pre>
	  */
	public EBookingReceiptDBDAOSearchXterDescForAckRSQL(){
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
		query.append("FileName : EBookingReceiptDBDAOSearchXterDescForAckRSQL").append("\n"); 
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
		query.append("select  '{DESC'                                ||CHR(10)||" ).append("\n"); 
		query.append("        'BL_DESC:'|| replace(to_char(GDS_DESC), chr(10), chr(10)||'BL_DESC:')  ||" ).append("\n"); 
		query.append("        '}DESC'                                ||CHR(10) FLAT_FILE" ).append("\n"); 
		query.append("  from bkg_xter_rqst_mst  " ).append("\n"); 
		query.append(" where XTER_SNDR_ID  = @[sender_id]" ).append("\n"); 
		query.append("   and xter_rqst_no  = @[rqst_no]" ).append("\n"); 
		query.append("   and xter_rqst_seq = @[rqst_seq]" ).append("\n"); 

	}
}