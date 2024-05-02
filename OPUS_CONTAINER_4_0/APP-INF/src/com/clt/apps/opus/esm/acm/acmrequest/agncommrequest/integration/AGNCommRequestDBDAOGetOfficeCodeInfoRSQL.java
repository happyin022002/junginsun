/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : AGNCommRequestDBDAOGetOfficeCodeInfoRSQL.java
*@FileTitle :
*Open Issues :
*Change history :
*@LastModifyDate : 2012.08.20
*@LastModifier :
*@LastVersion : 1.0
* 2012.08.20
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.acm.acmrequest.agncommrequest.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AGNCommRequestDBDAOGetOfficeCodeInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();

	Logger log =Logger.getLogger(this.getClass());

	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;

	/**
	  * <pre>
	  * GetOfficeCodeInfo
	  * Booking 의 POR, POL, POD, DEL 에 해당하는
	  *  FINC_CTRL_OFC_CD 와 AR_OFC_CD 를 구함
	  * </pre>
	  */
	public AGNCommRequestDBDAOGetOfficeCodeInfoRSQL(){
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
		query.append("Path : com.clt.apps.opus.esm.acm.acmrequest.agncommrequest.integration").append("\n");
		query.append("FileName : AGNCommRequestDBDAOGetOfficeCodeInfoRSQL").append("\n");
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
		query.append("SELECT " ).append("\n");
		query.append(" B.BKG_NO" ).append("\n");
		query.append(",B.BKG_OFC_CD,OB.AR_OFC_CD AS BKG_OFC_AR " ).append("\n");
		query.append(",B.POR_CD,L1.FINC_CTRL_OFC_CD AS POR_FINC,O1.AR_OFC_CD AS POR_AR" ).append("\n");
		query.append(",B.POL_CD,L2.FINC_CTRL_OFC_CD AS POL_FINC,O2.AR_OFC_CD AS POL_AR" ).append("\n");
		query.append(",B.POD_CD,L3.FINC_CTRL_OFC_CD AS POD_FINC,O3.AR_OFC_CD AS POD_AR" ).append("\n");
		query.append(",B.DEL_CD,L4.FINC_CTRL_OFC_CD AS DEL_FINC,O4.AR_OFC_CD AS DEL_AR" ).append("\n");
		query.append(",L1.CONTI_CD AS POR_CONTI_CD" ).append("\n");
		query.append(",L2.CONTI_CD AS POL_CONTI_CD" ).append("\n");
		query.append(",L3.CONTI_CD AS POD_CONTI_CD" ).append("\n");
		query.append(",L4.CONTI_CD AS DEL_CONTI_CD" ).append("\n");
		query.append("FROM " ).append("\n");
		query.append(" BKG_BOOKING B" ).append("\n");
		query.append(",MDM_LOCATION L1" ).append("\n");
		query.append(",MDM_LOCATION L2" ).append("\n");
		query.append(",MDM_LOCATION L3" ).append("\n");
		query.append(",MDM_LOCATION L4" ).append("\n");
		query.append(",MDM_ORGANIZATION OB" ).append("\n");
		query.append(",MDM_ORGANIZATION O1" ).append("\n");
		query.append(",MDM_ORGANIZATION O2" ).append("\n");
		query.append(",MDM_ORGANIZATION O3" ).append("\n");
		query.append(",MDM_ORGANIZATION O4" ).append("\n");
		query.append("WHERE 1=1" ).append("\n");
		query.append("AND B.BKG_NO = @[bkg_no]-- 'AAR200100200' " ).append("\n");
		query.append("AND B.POR_CD = L1.LOC_CD" ).append("\n");
		query.append("AND B.POL_CD = L2.LOC_CD" ).append("\n");
		query.append("AND B.POD_CD = L3.LOC_CD" ).append("\n");
		query.append("AND B.DEL_CD = L4.LOC_CD" ).append("\n");
		query.append("AND B.BKG_OFC_CD = OB.OFC_CD " ).append("\n");
		query.append("AND L1.FINC_CTRL_OFC_CD = O1.OFC_CD " ).append("\n");
		query.append("AND L2.FINC_CTRL_OFC_CD = O2.OFC_CD " ).append("\n");
		query.append("AND L3.FINC_CTRL_OFC_CD = O3.OFC_CD " ).append("\n");
		query.append("AND L4.FINC_CTRL_OFC_CD = O4.OFC_CD" ).append("\n");

	}
}