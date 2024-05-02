/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : SpecialCargoReceiptDBDAOSearchBkgRjEmlRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.05.22
*@LastModifier : 김종호
*@LastVersion : 1.0
* 2012.05.22 김종호
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingconduct.specialcargobookingconduct.specialcargoreceipt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Jong-Ho Kim
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SpecialCargoReceiptDBDAOSearchBkgRjEmlRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Special Cargo Reject건 자동이메일전송기능
	  * </pre>
	  */
	public SpecialCargoReceiptDBDAOSearchBkgRjEmlRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.bookingconduct.specialcargobookingconduct.specialcargoreceipt.integration").append("\n"); 
		query.append("FileName : SpecialCargoReceiptDBDAOSearchBkgRjEmlRSQL").append("\n"); 
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
		query.append("SELECT MAX(REV1.USR_NM) USR_NM," ).append("\n"); 
		query.append("	    MAX(REV1.USR_EML) USR_EML," ).append("\n"); 
		query.append("	    MAX(SP.RQST_USR_ID) RQST_USR_ID," ).append("\n"); 
		query.append("	    MAX(REV2.USR_EML) RQST_USR_EML   " ).append("\n"); 
		query.append("FROM BKG_BOOKING BK," ).append("\n"); 
		query.append("	     COM_USER REV1," ).append("\n"); 
		query.append("	     COM_USER REV2" ).append("\n"); 
		query.append("-- checking spcl_cgo_tp" ).append("\n"); 
		query.append("#if (${spcl_cgo_tp} == 'A')" ).append("\n"); 
		query.append("	     ,BKG_AWK_CGO SP" ).append("\n"); 
		query.append("#elseif (${spcl_cgo_tp} == 'B')" ).append("\n"); 
		query.append("		 ,BKG_BB_CGO SP" ).append("\n"); 
		query.append("#elseif (${spcl_cgo_tp} == 'D')" ).append("\n"); 
		query.append("		 ,BKG_DG_CGO SP" ).append("\n"); 
		query.append("#elseif (${spcl_cgo_tp} == 'R')" ).append("\n"); 
		query.append("		 ,BKG_RF_CGO SP" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("WHERE BK.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("	   AND UPPER(BK.DOC_USR_ID) = UPPER(REV1.USR_ID(+))" ).append("\n"); 
		query.append("	   AND BK.BKG_NO = SP.BKG_NO" ).append("\n"); 
		query.append("	   AND SP.RQST_USR_ID = REV2.USR_ID(+)" ).append("\n"); 

	}
}