/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : EBookingReceiptDBDAOSearchXptLicNoByCntCdRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.08.29
*@LastModifier : 류대영
*@LastVersion : 1.0
* 2013.08.29 류대영
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author DYRYU
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class EBookingReceiptDBDAOSearchXptLicNoByCntCdRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * e-bkg에서 접수된 국가별 export no를 조회한다
	  * </pre>
	  */
	public EBookingReceiptDBDAOSearchXptLicNoByCntCdRSQL(){
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

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.integration").append("\n"); 
		query.append("FileName : EBookingReceiptDBDAOSearchXptLicNoByCntCdRSQL").append("\n"); 
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
		query.append("SELECT XPT_LIC_NO" ).append("\n"); 
		query.append("	, to_char(ID_XPT_NO_ISS_DT,'yyyyMMdd') ID_XPT_NO_ISS_DT" ).append("\n"); 
		query.append("	, NVL(ID_OFC_ID, '040300') ID_OFC_ID" ).append("\n"); 
		query.append("	, NVL(ID_DECL_CD, 'E') ID_DECL_CD" ).append("\n"); 
		query.append("  FROM BKG_XTER_XPT_LIC_NO MST" ).append("\n"); 
		query.append(" WHERE MST.XTER_SNDR_ID  = @[sender_id]" ).append("\n"); 
		query.append("   AND MST.XTER_RQST_NO  = @[rqst_no]" ).append("\n"); 
		query.append("   AND MST.XTER_RQST_SEQ = @[rqst_seq]" ).append("\n"); 
		query.append("   and MST.CNT_CD        = @[cnt_cd]" ).append("\n"); 

	}
}