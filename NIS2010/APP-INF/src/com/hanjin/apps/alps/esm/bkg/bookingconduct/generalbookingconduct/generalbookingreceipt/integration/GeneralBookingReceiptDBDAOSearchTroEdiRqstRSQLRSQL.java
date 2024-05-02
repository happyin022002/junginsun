/*=========================================================
*Copyright(c) 2018 CyberLogitec
*@FileName : GeneralBookingReceiptDBDAOSearchTroEdiRqstRSQLRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2018.03.30
*@LastModifier : 
*@LastVersion : 1.0
* 2018.03.30 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class GeneralBookingReceiptDBDAOSearchTroEdiRqstRSQLRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * TRO KR EDI
	  * </pre>
	  */
	public GeneralBookingReceiptDBDAOSearchTroEdiRqstRSQLRSQL(){
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
		query.append("Path : com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.integration").append("\n"); 
		query.append("FileName : GeneralBookingReceiptDBDAOSearchTroEdiRqstRSQLRSQL").append("\n"); 
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
		query.append("SELECT BT.TRO_SEQ" ).append("\n"); 
		query.append("       ,BT.RTN_TRO_FLG" ).append("\n"); 
		query.append("       ,BT.OWNR_TRK_FLG" ).append("\n"); 
		query.append("FROM BKG_TRO BT" ).append("\n"); 
		query.append("	 ,BKG_BOOKING BB" ).append("\n"); 
		query.append("WHERE BT.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("AND BT.CXL_FLG = 'N'" ).append("\n"); 
		query.append("AND BT.BKG_NO = BB.BKG_NO" ).append("\n"); 
		query.append("AND BB.MTY_PKUP_YD_CD = 'KRSEL1H'" ).append("\n"); 
		query.append("AND BB.POL_CD LIKE 'KR%'" ).append("\n"); 
		query.append("AND ROWNUM = 1" ).append("\n"); 

	}
}