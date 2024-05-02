/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : BookingUtilDBDAOSearchPoNoLengthByDtlRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.10
*@LastModifier : 김병규
*@LastVersion : 1.0
* 2009.08.10 김병규
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author KimByungKyu
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BookingUtilDBDAOSearchPoNoLengthByDtlRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 미주향 BOOKING이면서 특정 화주의 경우 PO가 반드시 입력되어야함
	  * </pre>
	  */
	public BookingUtilDBDAOSearchPoNoLengthByDtlRSQL(){
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
		params.put("sc_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.integration").append("\n"); 
		query.append("FileName : BookingUtilDBDAOSearchPoNoLengthByDtlRSQL").append("\n"); 
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
		query.append("select 'Y' error" ).append("\n"); 
		query.append("from" ).append("\n"); 
		query.append("(select decode(nvl(case.flag, 'N'), 'N', 'N/A' --p/o no validation이 필요없는 case" ).append("\n"); 
		query.append(", 'Y' --p/o no validation이 필요한는 case" ).append("\n"); 
		query.append(", decode(case.required_len, nvl(input_po.input_len, 0), 'Pass', 'Error')) result" ).append("\n"); 
		query.append(", required_len" ).append("\n"); 
		query.append(", input_len" ).append("\n"); 
		query.append("from (select distinct 'Y' flag --입력값이 po_length_validation에 해당하는 case인지 여부" ).append("\n"); 
		query.append(", po_len.attr_ctnt5 required_len --입력되어야할 P/No의 길이" ).append("\n"); 
		query.append("from bkg_hrd_cdg_ctnt po_len" ).append("\n"); 
		query.append("where ((po_len.attr_ctnt2 = @[cust_cnt_cd]/*'CA'*/ and po_len.attr_ctnt3= @[cust_seq]/*'385'*/)" ).append("\n"); 
		query.append("or po_len.attr_ctnt4 =@[sc_no]/*'GLO92004'*/)" ).append("\n"); 
		query.append("and po_Len.HRD_CDG_ID = 'PO_LENGTH'" ).append("\n"); 
		query.append("and rownum = 1 --입력되어야할 길기가 중복이 되어서는 안됨" ).append("\n"); 
		query.append(") case" ).append("\n"); 
		query.append(", (select length(ref_no.CUST_REF_NO_CTNT) input_len --입력된 P/O No의 길이들" ).append("\n"); 
		query.append("from bkg_reference ref_no" ).append("\n"); 
		query.append("where ref_no.bkg_no = @[bkg_no]/*'AARZ1030006'*/" ).append("\n"); 
		query.append("and ref_no.BKG_REF_TP_CD in ('BKPO', 'CTPO', 'CMPO')" ).append("\n"); 
		query.append(") input_po" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("where result = 'Error' --error가 하나만 있으면" ).append("\n"); 
		query.append("and rownum = 1" ).append("\n"); 

	}
}