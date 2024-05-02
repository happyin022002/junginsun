/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : TransferOrderIssueDBDAOSearchCntrPartialRSQL.java
*@FileTitle :
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.19
*@LastModifier : 이남경
*@LastVersion : 1.0
* 2009.06.19 이남경
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.transferorderissue.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Lee Nam Kyung
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TransferOrderIssueDBDAOSearchCntrPartialRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();

	Logger log =Logger.getLogger(this.getClass());

	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;

	/**
	  * <pre>
	  * TransferOrderIssueDB::SearchCntrPartial
	  * </pre>
	  */
	public TransferOrderIssueDBDAOSearchCntrPartialRSQL(){
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
		query.append("SELECT MAX(RESULT_FLAG) RESULT_FLAG" ).append("\n");
		query.append("FROM (" ).append("\n");
		query.append("SELECT DECODE(CNTR.CNTR_PRT_FLG, 'Y','N'," ).append("\n");
		query.append("DECODE(TRS.TRSP_SO_OFC_CTY_CD, NULL, 'P', 'S')) RESULT_FLAG" ).append("\n");
		query.append("FROM BKG_CONTAINER CNTR," ).append("\n");
		query.append("TRS_TRSP_SVC_ORD TRS" ).append("\n");
		query.append("WHERE CNTR.BKG_NO = TRS.BKG_NO(+)" ).append("\n");
		query.append("AND CNTR.CNTR_NO = TRS.CNTR_NO(+)" ).append("\n");
		query.append("AND CNTR.BKG_NO = @[bkg_no]" ).append("\n");
		query.append("AND CNTR.CNTR_PRT_FLG = 'Y'" ).append("\n");
		query.append(")" ).append("\n");
		query.append("GROUP BY RESULT_FLAG" ).append("\n");

		query.append("/*").append("\n");
		query.append("Path : com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.transferorderissue.integration").append("\n");
		query.append("FileName : TransferOrderIssueDBDAOSearchCntrPartialRSQL").append("\n");
		query.append("*/").append("\n");
	}
}