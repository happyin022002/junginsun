/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EBookingReceiptDBDAOsearchXterHblCountRSQL.java
*@FileTitle :
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.19
*@LastModifier : 전용진
*@LastVersion : 1.0
* 2009.06.19 전용진
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Jun Yong Jin
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class EBookingReceiptDBDAOsearchXterHblCountRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();

	Logger log =Logger.getLogger(this.getClass());

	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;

	/**
	  * <pre>
	  * searchXterHblCount
	  * </pre>
	  */
	public EBookingReceiptDBDAOsearchXterHblCountRSQL(){
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

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("xter_sndr_id",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("SELECT  XTER_RQST_NO" ).append("\n");
		query.append("FROM	BKG_XTER_RQST_MST" ).append("\n");
		query.append("WHERE	BKG_NO = @[bkg_no]" ).append("\n");
		query.append("AND		XTER_RQST_SNDR_ID = @[xter_sndr_id]" ).append("\n");
		query.append("AND		XTER_BL_TP_CD = 'H'" ).append("\n");

		query.append("/*").append("\n");
		query.append("Path : com.clt.apps.opus.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.integration").append("\n");
		query.append("FileName : EBookingReceiptDBDAOsearchXterHblCountRSQL").append("\n");
		query.append("*/").append("\n");
	}
}