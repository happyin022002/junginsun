/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : SpecialCargoReceiptDBDAOSearchSpRejectCntRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.05.24
*@LastModifier : 
*@LastVersion : 1.0
* 2012.05.24 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingconduct.specialcargobookingconduct.specialcargoreceipt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SpecialCargoReceiptDBDAOSearchSpRejectCntRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * BKG에 대한 REJECT 요청의 개수
	  * </pre>
	  */
	public SpecialCargoReceiptDBDAOSearchSpRejectCntRSQL(){
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
		query.append("FileName : SpecialCargoReceiptDBDAOSearchSpRejectCntRSQL").append("\n"); 
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
		query.append("SELECT COUNT(1) " ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("-- checking spcl_cgo_tp" ).append("\n"); 
		query.append("#if (${spcl_cgo_tp} == 'A')" ).append("\n"); 
		query.append("	     BKG_AWK_CGO SP" ).append("\n"); 
		query.append("#elseif (${spcl_cgo_tp} == 'B')" ).append("\n"); 
		query.append("		 BKG_BB_CGO SP" ).append("\n"); 
		query.append("#elseif (${spcl_cgo_tp} == 'D')" ).append("\n"); 
		query.append("		 BKG_DG_CGO SP" ).append("\n"); 
		query.append("#elseif (${spcl_cgo_tp} == 'R')" ).append("\n"); 
		query.append("		 BKG_RF_CGO SP" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("WHERE SP.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("AND SP.SPCL_CGO_APRO_CD = 'N'" ).append("\n"); 

	}
}