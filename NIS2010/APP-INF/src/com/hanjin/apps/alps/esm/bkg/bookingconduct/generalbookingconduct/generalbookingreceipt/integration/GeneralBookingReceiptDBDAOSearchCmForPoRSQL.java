/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : GeneralBookingReceiptDBDAOSearchCmForPoRSQL.java
*@FileTitle :
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.18
*@LastModifier : 이진서
*@LastVersion : 1.0
* 2009.06.18 이진서
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Lee Jin Seo
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class GeneralBookingReceiptDBDAOSearchCmForPoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();

	Logger log =Logger.getLogger(this.getClass());

	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;

	/**
	  * <pre>
	  * PO & Other No에 CM정보를 Copy하기 위해 조회한다
	  * </pre>
	  */
	public GeneralBookingReceiptDBDAOSearchCmForPoRSQL(){
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
		params.put("cntr_no",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("BKG_NO," ).append("\n");
		query.append("'' as REF_SEQ," ).append("\n");
		query.append("CNTR_NO," ).append("\n");
		query.append("PO_NO," ).append("\n");
		query.append("'' as ITM_NO," ).append("\n");
		query.append("'' as ITM_DESC," ).append("\n");
		query.append("PCK_QTY," ).append("\n");
		query.append("PCK_TP_CD," ).append("\n");
		query.append("CNTR_MF_WGT as CNTR_WGT," ).append("\n");
		query.append("WGT_UT_CD," ).append("\n");
		query.append("MEAS_QTY," ).append("\n");
		query.append("MEAS_UT_CD" ).append("\n");
		query.append("FROM BKG_CNTR_MF_DESC" ).append("\n");
		query.append("WHERE" ).append("\n");
		query.append("BKG_NO =  @[bkg_no]" ).append("\n");
		query.append("AND CNTR_NO =  @[cntr_no]" ).append("\n");

		query.append("/*").append("\n");
		query.append("Path : com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.integration").append("\n");
		query.append("FileName : GeneralBookingReceiptDBDAOSearchCmForPoRSQL").append("\n");
		query.append("*/").append("\n");
	}
}