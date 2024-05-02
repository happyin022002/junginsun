/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : SpecialCargoReceiptDBDAOSearchSpclProviNoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.10.19
*@LastModifier : 
*@LastVersion : 1.0
* 2011.10.19 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingconduct.specialcargobookingconduct.specialcargoreceipt.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SpecialCargoReceiptDBDAOSearchSpclProviNoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * IMDG UN NUMBER의 SPECIAL PROVISION No 조회
	  * </pre>
	  */
	public SpecialCargoReceiptDBDAOSearchSpclProviNoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("imdg_un_no_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("imdg_un_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.bookingconduct.specialcargobookingconduct.specialcargoreceipt.integration ").append("\n"); 
		query.append("FileName : SpecialCargoReceiptDBDAOSearchSpclProviNoRSQL").append("\n"); 
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
		query.append("SELECT 	 SUBSTR(XMLAGG(XMLELEMENT(X, '/' || IMDG_SPCL_PROVI_NO) ORDER BY DP_SEQ).EXTRACT('//text()'), 2) AS SPCL_PROVI_NO" ).append("\n"); 
		query.append("FROM     SCG_IMDG_UN_NO_SPCL_PROVI" ).append("\n"); 
		query.append("WHERE 	 IMDG_UN_NO  = @[imdg_un_no]" ).append("\n"); 
		query.append("AND 	 IMDG_UN_NO_SEQ = @[imdg_un_no_seq]" ).append("\n"); 
		query.append("GROUP BY IMDG_UN_NO, IMDG_UN_NO_SEQ" ).append("\n"); 

	}
}