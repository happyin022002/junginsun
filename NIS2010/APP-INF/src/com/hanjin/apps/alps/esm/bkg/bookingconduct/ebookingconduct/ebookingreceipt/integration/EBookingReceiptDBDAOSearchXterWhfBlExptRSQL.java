/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : EBookingReceiptDBDAOSearchXterWhfBlExptRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.05.16
*@LastModifier : 
*@LastVersion : 1.0
* 2013.05.16 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class EBookingReceiptDBDAOSearchXterWhfBlExptRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchXterWhfBlExpt
	  * </pre>
	  */
	public EBookingReceiptDBDAOSearchXterWhfBlExptRSQL(){
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
		query.append("Path : com.hanjin.apps.alps.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.integration").append("\n"); 
		query.append("FileName : EBookingReceiptDBDAOSearchXterWhfBlExptRSQL").append("\n"); 
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
		query.append("SELECT" ).append("\n"); 
		query.append("A.ATTR_CTNT1 AS KR_WHF_EXPT_CD," ).append("\n"); 
		query.append("A.ATTR_CTNT5 AS KR_WHF_EXPT_DESC," ).append("\n"); 
		query.append("DECODE(A.ATTR_CTNT1, B.BKG_RT_WHF_EXPT_CD, 'Y', 'N') AS KR_WHF_EXPT_APPL_FLG," ).append("\n"); 
		query.append("'' WHF_SHPR_RGST_NO" ).append("\n"); 
		query.append("FROM BKG_HRD_CDG_CTNT A, BKG_XTER_RQST_MST B" ).append("\n"); 
		query.append("WHERE A.HRD_CDG_ID = 'KR_WHF_EXEMPT_CD'" ).append("\n"); 
		query.append("AND B.XTER_SNDR_ID(+)  = @[sender_id]" ).append("\n"); 
		query.append("AND B.XTER_RQST_NO(+)  = @[rqst_no]" ).append("\n"); 
		query.append("AND B.XTER_RQST_SEQ(+) = @[rqst_seq]" ).append("\n"); 
		query.append("AND B.BKG_RT_WHF_EXPT_CD(+) = A.ATTR_CTNT1" ).append("\n"); 
		query.append("AND A.ATTR_CTNT1 IN ('D','X')" ).append("\n"); 
		query.append("ORDER BY ATTR_CTNT6" ).append("\n"); 

	}
}