/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : BookingUtilDBDAOsearchPoNoLengthRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.18
*@LastModifier : 류대영
*@LastVersion : 1.0
* 2009.08.18 류대영
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author RYU DAE YOUNG
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BookingUtilDBDAOsearchPoNoLengthRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * select
	  * </pre>
	  */
	public BookingUtilDBDAOsearchPoNoLengthRSQL(){
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
		query.append("Path : com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.integration").append("\n"); 
		query.append("FileName : BookingUtilDBDAOsearchPoNoLengthRSQL").append("\n"); 
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
		query.append("select decode(nvl(case.flag, 'N'), 'N', 'Y', 'Y'" ).append("\n"); 
		query.append(", decode(case.required_len, nvl(input_po.input_len, 0), 'Y', 'N')) cust_ref_no" ).append("\n"); 
		query.append("from" ).append("\n"); 
		query.append("(select bk1.bkg_no" ).append("\n"); 
		query.append(", 'Y' flag" ).append("\n"); 
		query.append(", attr_ctnt5 required_len" ).append("\n"); 
		query.append("from bkg_booking bk1, bkg_customer cust, bkg_hrd_cdg_ctnt po_len" ).append("\n"); 
		query.append("where bk1.bkg_no = cust.bkg_no" ).append("\n"); 
		query.append("and bk1.bkg_no = @[bkg_no]" ).append("\n"); 
		query.append("and po_len.HRD_CDG_ID = 'PO_LENGTH'" ).append("\n"); 
		query.append("and ((po_Len.attr_ctnt2 = cust.cust_cnt_cd and po_Len.attr_ctnt3 = cust.cust_seq)" ).append("\n"); 
		query.append("or po_Len.attr_ctnt4 = bk1.sc_no)" ).append("\n"); 
		query.append("and rownum = 1) case" ).append("\n"); 
		query.append(", (select distinct ref_no.bkg_no" ).append("\n"); 
		query.append(", length(ref_no.cust_ref_no_ctnt) input_len" ).append("\n"); 
		query.append("from bkg_reference ref_no" ).append("\n"); 
		query.append("where ref_no.BKG_REF_TP_CD in ('BKPO', 'CTPO', 'CMPO')" ).append("\n"); 
		query.append("and ref_no.bkg_no = @[bkg_no]) input_po" ).append("\n"); 
		query.append(", bkg_booking bk" ).append("\n"); 
		query.append("where bk.bkg_no = @[bkg_no]" ).append("\n"); 
		query.append("and bk.bkg_no = case.bkg_no(+)" ).append("\n"); 
		query.append("and bk.bkg_no = input_po.bkg_no(+)" ).append("\n"); 

	}
}