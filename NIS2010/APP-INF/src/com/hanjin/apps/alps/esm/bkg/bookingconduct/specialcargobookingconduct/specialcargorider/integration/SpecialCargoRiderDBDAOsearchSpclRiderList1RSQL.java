/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SpecialCargoRiderDBDAOsearchSpclRiderList1RSQL.java
*@FileTitle : Charge_Charge code inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.26
*@LastModifier : 이진서
*@LastVersion : 1.0
* 2009.06.26 이진서
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingconduct.specialcargobookingconduct.specialcargorider.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Lee Jin Seo
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SpecialCargoRiderDBDAOsearchSpclRiderList1RSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();

	Logger log =Logger.getLogger(this.getClass());

	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;

	/**
	  * <pre>
	  * RIDR_TP_CD에 따른 쿼리문 변경
	  * </pre>
	  */
	public SpecialCargoRiderDBDAOsearchSpclRiderList1RSQL(){
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
		query.append("#if (${ridr_tp_cd} == 'D')" ).append("\n");
		query.append("----  DCGO_SEQ" ).append("\n");
		query.append("SELECT" ).append("\n");
		query.append("CNTR_NO ||' / '|| CNTR_CGO_SEQ AS CARGO_NAME" ).append("\n");
		query.append(",DCGO_SEQ AS CARGO_VALUE" ).append("\n");
		query.append("FROM BKG_DG_CGO" ).append("\n");
		query.append("WHERE BKG_NO = @[bkg_no]" ).append("\n");
		query.append("" ).append("\n");
		query.append("#elseif (${ridr_tp_cd} == 'A')" ).append("\n");
		query.append("----  AWK_CGO_SEQ" ).append("\n");
		query.append("SELECT" ).append("\n");
		query.append("CNTR_NO AS CARGO_NAME" ).append("\n");
		query.append(",AWK_CGO_SEQ AS CARGO_VALUE" ).append("\n");
		query.append("FROM BKG_AWK_CGO" ).append("\n");
		query.append("WHERE BKG_NO = @[bkg_no]" ).append("\n");
		query.append("" ).append("\n");
		query.append("#else" ).append("\n");
		query.append("----  AWK_CGO_SEQ" ).append("\n");
		query.append("SELECT" ).append("\n");
		query.append("'' AS CARGO_NAME" ).append("\n");
		query.append(",'' AS CARGO_VALUE" ).append("\n");
		query.append("FROM DUAL" ).append("\n");
		query.append("#end" ).append("\n");

		query.append("/*").append("\n");
		query.append("Path : com.hanjin.apps.alps.esm.bkg.bookingconduct.specialcargobookingconduct.specialcargorider.integration").append("\n");
		query.append("FileName : SpecialCargoRiderDBDAOsearchSpclRiderList1RSQL").append("\n");
		query.append("*/").append("\n");
	}
}