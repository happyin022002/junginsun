/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : EBookingReceiptDBDAOSearchErrMsgForMailRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.01.27
*@LastModifier : 
*@LastVersion : 1.0
* 2015.01.27 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class EBookingReceiptDBDAOSearchErrMsgForMailRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * e-BKG/SI 송신시 발생한 Error Msg를 사용자가 알 수 있는 내용으로 변환한다.
	  * </pre>
	  */
	public EBookingReceiptDBDAOSearchErrMsgForMailRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("err_msg",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.integration ").append("\n"); 
		query.append("FileName : EBookingReceiptDBDAOSearchErrMsgForMailRSQL").append("\n"); 
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
		query.append("select NVL((select distinct  " ).append("\n"); 
		query.append("       case when instr(e.err_msg,'ORA-12899') > 0 " ).append("\n"); 
		query.append("                then  'Please check the flat file. '" ).append("\n"); 
		query.append("                 ||'   Group : '||h.attr_ctnt6||'  /  Prefix : '||h.attr_ctnt2||'  /  Max Length : '" ).append("\n"); 
		query.append("                 ||(select data_length from all_tab_columns where table_name = h.attr_ctnt3 and column_name = h.attr_ctnt4)" ).append("\n"); 
		query.append("            when instr(e.err_msg,'ORA-00001') > 0 AND instr(e.err_msg,'XPKBKG_XTER_CUST') > 0" ).append("\n"); 
		query.append("                 then 'Please check the flat file. There is Duplicated item. '" ).append("\n"); 
		query.append("                  ||'   Group : '||h.attr_ctnt6||' /  Prefix : IBCS_TP  may be duplicated'" ).append("\n"); 
		query.append("            when instr(e.err_msg,'ORA-00001') > 0 AND instr(e.err_msg,'XPKBKG_XTER_QTY') > 0" ).append("\n"); 
		query.append("                 then 'Please check the flat file. There is Duplicated item. '" ).append("\n"); 
		query.append("                  ||'   Group : '||h.attr_ctnt6||' /  Prefix :  CNTRTS_CD may be duplicated'" ).append("\n"); 
		query.append("            when instr(e.err_msg,'ORA-00001') > 0 AND instr(e.err_msg,'XPKBKG_XTER_RQST_MST') > 0" ).append("\n"); 
		query.append("                 then 'Please check the flat file. '" ).append("\n"); 
		query.append("                  ||'If this is House BL, check if master BL has been sent.'" ).append("\n"); 
		query.append("            when instr(e.err_msg,'ORA-00001') > 0 AND instr(e.err_msg,'XPKBKG_XTER_XPT_LIC_NO') > 0" ).append("\n"); 
		query.append("                 then 'Please check the flat file. There''s Duplicated item. '" ).append("\n"); 
		query.append("                  ||'   Group : '||h.attr_ctnt6||' /  Prefix :  IBME_ELNO may be duplicated'" ).append("\n"); 
		query.append("            when instr(e.err_msg,'ORA-00957') > 0 " ).append("\n"); 
		query.append("                 then 'Please check the flat file. There''s Duplicated Prefix in '" ).append("\n"); 
		query.append("                  ||'   Group : '||h.attr_ctnt6" ).append("\n"); 
		query.append("            when instr(e.err_msg,'ORA-01400') > 0 " ).append("\n"); 
		query.append("                then 'Please check the flat file. Mandatory item is missing'" ).append("\n"); 
		query.append("                    ||'Group : '||h.attr_ctnt6||'  /  Prefix : '||h.attr_ctnt2" ).append("\n"); 
		query.append("            else @[err_msg]" ).append("\n"); 
		query.append("            end Description" ).append("\n"); 
		query.append("from bkg_hrd_cdg_ctnt h, " ).append("\n"); 
		query.append("     (select @[err_msg] err_msg from dual)  e" ).append("\n"); 
		query.append("where hrd_cdg_id  = 'XTER_BKG_RECEIPT'" ).append("\n"); 
		query.append("and e.err_msg like '%'||h.attr_ctnt3||'%'" ).append("\n"); 
		query.append("and (e.err_msg like '%'||h.attr_ctnt4||'%'  or (instr(e.err_msg,'ORA-12899') = 0 and instr(e.err_msg,'ORA-01400') = 0))" ).append("\n"); 
		query.append("and h.attr_ctnt3 is not null" ).append("\n"); 
		query.append("and rownum = 1), @[err_msg]) ERR_DESC" ).append("\n"); 
		query.append("from dual" ).append("\n"); 

	}
}