/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EBookingReceiptDBDAOsearchNisHbl2RSQL.java
*@FileTitle :
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.15
*@LastModifier : 전용진
*@LastVersion : 1.0
* 2009.06.15 전용진
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Jun Yong Jin
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class EBookingReceiptDBDAOsearchNisHbl2RSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();

	Logger log =Logger.getLogger(this.getClass());

	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;

	/**
	  * <pre>
	  * searchNisHbl2
	  * </pre>
	  */
	public EBookingReceiptDBDAOsearchNisHbl2RSQL(){
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
		query.append("SELECT USA_CSTMS_FILE_NO" ).append("\n");
		query.append(",SCAC_CD" ).append("\n");
		query.append(",PCK_QTY" ).append("\n");
		query.append("FROM BKG_USA_CSTMS_FILE_NO" ).append("\n");
		query.append("WHERE BKG_NO  = @[bkg_no]" ).append("\n");
		query.append("ORDER BY USA_CSTMS_FILE_NO" ).append("\n");

		query.append("/*").append("\n");
		query.append("Path : com.hanjin.apps.alps.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.integration").append("\n");
		query.append("FileName : EBookingReceiptDBDAOsearchNisHbl2RSQL").append("\n");
		query.append("*/").append("\n");
	}
}