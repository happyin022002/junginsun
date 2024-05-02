/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : EBookingReceiptDBDAOsearchErrMsgToEsvcRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.02.01
*@LastModifier : 
*@LastVersion : 1.0
* 2017.02.01 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class EBookingReceiptDBDAOsearchErrMsgToEsvcRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchErrMsgToEsvc
	  * </pre>
	  */
	public EBookingReceiptDBDAOsearchErrMsgToEsvcRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eai_if_tp",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("err_msg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rqst_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rqst_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sender_id",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("doc_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ff_ref_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.integration").append("\n"); 
		query.append("FileName : EBookingReceiptDBDAOsearchErrMsgToEsvcRSQL").append("\n"); 
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
		query.append("select EAI_STS" ).append("\n"); 
		query.append("    , EAI_DT			" ).append("\n"); 
		query.append("    , COMPANY		" ).append("\n"); 
		query.append("    , IB_NO         " ).append("\n"); 
		query.append("    , IB_SEQ        " ).append("\n"); 
		query.append("    , IB_EDI_ID     " ).append("\n"); 
		query.append("    , IB_FF_REF_NO  " ).append("\n"); 
		query.append("    , IB_BKG_NO		" ).append("\n"); 
		query.append("    , IB_CFM_IND	" ).append("\n"); 
		query.append("    , IB_BKG_OFC	" ).append("\n"); 
		query.append("    , IB_CFM_USR_ID	" ).append("\n"); 
		query.append("    , IB_C_DATE		" ).append("\n"); 
		query.append("    , IB_R_DATE		" ).append("\n"); 
		query.append("    , EAI_IF_TP     " ).append("\n"); 
		query.append("    , IB_NU_ERROR   " ).append("\n"); 
		query.append("    , IB_MSG_FLAG" ).append("\n"); 
		query.append("  from " ).append("\n"); 
		query.append("    (SELECT 'U'                                   EAI_STS--insert 성공의 경우" ).append("\n"); 
		query.append("            , TO_CHAR(sysdate,'yyyymmddhh24miss') EAI_DT			" ).append("\n"); 
		query.append("            , 'SMLM'			                  COMPANY		" ).append("\n"); 
		query.append("          	, xter_Rqst_no                        IB_NO         " ).append("\n"); 
		query.append("          	, to_char(xter_rqst_seq)              IB_SEQ        " ).append("\n"); 
		query.append("          	, xter_sndr_id                        IB_EDI_ID     " ).append("\n"); 
		query.append("          	, @[ff_ref_no]                        IB_FF_REF_NO  " ).append("\n"); 
		query.append("        	, bkg_No	                          IB_BKG_NO		" ).append("\n"); 
		query.append("        	, BKG_UPLD_STS_CD	                  IB_CFM_IND	" ).append("\n"); 
		query.append("        	, BKG_OFC_CD		                  IB_BKG_OFC	" ).append("\n"); 
		query.append("        	, UPLD_USR_ID	                      IB_CFM_USR_ID	" ).append("\n"); 
		query.append("        	, TO_CHAR(UPLD_DT,'yyyymmddhh24miss') IB_C_DATE		" ).append("\n"); 
		query.append("        	, TO_CHAR(RQST_DT,'yyyymmddhh24miss') IB_R_DATE		" ).append("\n"); 
		query.append("	    	, @[eai_if_tp]                        EAI_IF_TP     " ).append("\n"); 
		query.append("    	  	, NVL((select distinct  " ).append("\n"); 
		query.append("                      case when instr(e.err_msg,'ORA-12899') > 0 " ).append("\n"); 
		query.append("                           then  'Please check the flat file. '" ).append("\n"); 
		query.append("                                 ||'   Group : '||h.attr_ctnt6||'  /  Prefix : '||h.attr_ctnt2||'  /  Max Length : '" ).append("\n"); 
		query.append("                                 ||(select data_length from all_tab_columns where table_name = h.attr_ctnt3 and column_name = h.attr_ctnt4)" ).append("\n"); 
		query.append("                           when instr(e.err_msg,'ORA-00001') > 0 AND instr(e.err_msg,'XPKBKG_XTER_CUST') > 0" ).append("\n"); 
		query.append("                           then 'Please check the flat file. There is Duplicated item. '" ).append("\n"); 
		query.append("                                 ||'   Group : '||h.attr_ctnt6||' /  Prefix : IBCS_TP  may be duplicated'" ).append("\n"); 
		query.append("                           when instr(e.err_msg,'ORA-00001') > 0 AND instr(e.err_msg,'XPKBKG_XTER_QTY') > 0" ).append("\n"); 
		query.append("                           then 'Please check the flat file. There is Duplicated item. '" ).append("\n"); 
		query.append("                                 ||'   Group : '||h.attr_ctnt6||' /  Prefix :  CNTRTS_CD may be duplicated'" ).append("\n"); 
		query.append("                           when instr(e.err_msg,'ORA-00001') > 0 AND instr(e.err_msg,'XPKBKG_XTER_RQST_MST') > 0" ).append("\n"); 
		query.append("                           then 'Please check the flat file. '" ).append("\n"); 
		query.append("                                 ||'If this is House BL, check if master BL has been sent.'" ).append("\n"); 
		query.append("                           when instr(e.err_msg,'ORA-00001') > 0 AND instr(e.err_msg,'XPKBKG_XTER_XPT_LIC_NO') > 0" ).append("\n"); 
		query.append("                           then 'Please check the flat file. There is Duplicated item. '" ).append("\n"); 
		query.append("                                 ||'   Group : '||h.attr_ctnt6||' /  Prefix :  IBME_ELNO may be duplicated'" ).append("\n"); 
		query.append("                           when instr(e.err_msg,'ORA-00957') > 0 " ).append("\n"); 
		query.append("                           then 'Please check the flat file. There is Duplicated Prefix in '" ).append("\n"); 
		query.append("                                 ||'   Group : '||h.attr_ctnt6" ).append("\n"); 
		query.append("                           when instr(e.err_msg,'ORA-01400') > 0 " ).append("\n"); 
		query.append("                           then 'Please check the flat file. Mandatory item is missing'" ).append("\n"); 
		query.append("                                 ||'   Group : '||h.attr_ctnt6||'  /  Prefix : '||h.attr_ctnt2" ).append("\n"); 
		query.append("                           else @[err_msg]" ).append("\n"); 
		query.append("                      end Description" ).append("\n"); 
		query.append("               from bkg_hrd_cdg_ctnt h, " ).append("\n"); 
		query.append("                    (select @[err_msg] err_msg from dual)  e" ).append("\n"); 
		query.append("               where hrd_cdg_id  = 'XTER_BKG_RECEIPT'" ).append("\n"); 
		query.append("               and e.err_msg like '%'||h.attr_ctnt3||'%'" ).append("\n"); 
		query.append("               and (e.err_msg like '%'||h.attr_ctnt4||'%'  or (instr(e.err_msg,'ORA-12899') = 0 and instr(e.err_msg,'ORA-01400') = 0))" ).append("\n"); 
		query.append("               and h.attr_ctnt3 is not null" ).append("\n"); 
		query.append("               and rownum = 1), @[err_msg])       IB_NU_ERROR  " ).append("\n"); 
		query.append("        	, DOC_TP_CD		                      IB_MSG_FLAG	" ).append("\n"); 
		query.append("      FROM bkg_xter_rqst_mst" ).append("\n"); 
		query.append("	 where xter_sndr_id = @[sender_id]" ).append("\n"); 
		query.append("	   and xter_rqst_no = @[rqst_no]" ).append("\n"); 
		query.append("	   and xter_rqst_seq= @[rqst_seq]" ).append("\n"); 
		query.append("    union all   " ).append("\n"); 
		query.append("    SELECT 'U'                                    EAI_STS--insert 실패의 경우(row가 없음)" ).append("\n"); 
		query.append("            , TO_CHAR(sysdate,'yyyymmddhh24miss') EAI_DT			" ).append("\n"); 
		query.append("            , 'SMLM'			                  COMPANY		" ).append("\n"); 
		query.append("          	, @[rqst_no]                          IB_NO         " ).append("\n"); 
		query.append("          	, @[rqst_seq]                         IB_SEQ        " ).append("\n"); 
		query.append("          	, @[sender_id]                        IB_EDI_ID     " ).append("\n"); 
		query.append("          	, @[ff_ref_no]                        IB_FF_REF_NO  " ).append("\n"); 
		query.append("        	, @[bkg_no]	                          IB_BKG_NO		" ).append("\n"); 
		query.append("        	, ''	                              IB_CFM_IND	" ).append("\n"); 
		query.append("        	, ''		                          IB_BKG_OFC	" ).append("\n"); 
		query.append("        	, ''	                              IB_CFM_USR_ID	" ).append("\n"); 
		query.append("        	, TO_CHAR(sysdate,'yyyymmddhh24miss') IB_C_DATE		" ).append("\n"); 
		query.append("        	, TO_CHAR(sysdate,'yyyymmddhh24miss') IB_R_DATE		" ).append("\n"); 
		query.append("    		, @[eai_if_tp]                        EAI_IF_TP     " ).append("\n"); 
		query.append("     	 	, NVL((select distinct  " ).append("\n"); 
		query.append("                      case when instr(e.err_msg,'ORA-12899') > 0 " ).append("\n"); 
		query.append("                           then  'Please check the flat file. '" ).append("\n"); 
		query.append("                                 ||'   Group : '||h.attr_ctnt6||'  /  Prefix : '||h.attr_ctnt2||'  /  Max Length : '" ).append("\n"); 
		query.append("                                 ||(select data_length from all_tab_columns where table_name = h.attr_ctnt3 and column_name = h.attr_ctnt4)" ).append("\n"); 
		query.append("                           when instr(e.err_msg,'ORA-00001') > 0 AND instr(e.err_msg,'XPKBKG_XTER_CUST') > 0" ).append("\n"); 
		query.append("                           then 'Please check the flat file. There is Duplicated item. '" ).append("\n"); 
		query.append("                                 ||'   Group : '||h.attr_ctnt6||' /  Prefix : IBCS_TP  may be duplicated'" ).append("\n"); 
		query.append("                           when instr(e.err_msg,'ORA-00001') > 0 AND instr(e.err_msg,'XPKBKG_XTER_QTY') > 0" ).append("\n"); 
		query.append("                           then 'Please check the flat file. There is Duplicated item. '" ).append("\n"); 
		query.append("                                 ||'   Group : '||h.attr_ctnt6||' /  Prefix :  CNTRTS_CD may be duplicated'" ).append("\n"); 
		query.append("                           when instr(e.err_msg,'ORA-00001') > 0 AND instr(e.err_msg,'XPKBKG_XTER_RQST_MST') > 0" ).append("\n"); 
		query.append("                           then 'Please check the flat file. '" ).append("\n"); 
		query.append("                                 ||'   If this is House BL, check if master BL has been sent or request number is duplicated'" ).append("\n"); 
		query.append("                           when instr(e.err_msg,'ORA-00001') > 0 AND instr(e.err_msg,'XPKBKG_XTER_XPT_LIC_NO') > 0" ).append("\n"); 
		query.append("                           then 'Please check the flat file. There is Duplicated item. '" ).append("\n"); 
		query.append("                                 ||'   Group : '||h.attr_ctnt6||' /  Prefix :  IBME_ELNO may be duplicated'" ).append("\n"); 
		query.append("                           when instr(e.err_msg,'ORA-00957') > 0 " ).append("\n"); 
		query.append("                           then 'Please check the flat file. There is Duplicated Prefix in '" ).append("\n"); 
		query.append("                                 ||'   Group : '||h.attr_ctnt6" ).append("\n"); 
		query.append("                           when instr(e.err_msg,'ORA-01400') > 0 " ).append("\n"); 
		query.append("                           then 'Please check the flat file. Mandatory item is missing'" ).append("\n"); 
		query.append("                                 ||'   Group : '||h.attr_ctnt6||'  /  Prefix : '||h.attr_ctnt2" ).append("\n"); 
		query.append("                           else @[err_msg]" ).append("\n"); 
		query.append("                      end Description" ).append("\n"); 
		query.append("               from bkg_hrd_cdg_ctnt h, " ).append("\n"); 
		query.append("                    (select @[err_msg] err_msg from dual)  e" ).append("\n"); 
		query.append("               where hrd_cdg_id  = 'XTER_BKG_RECEIPT'" ).append("\n"); 
		query.append("               and e.err_msg like '%'||h.attr_ctnt3||'%'" ).append("\n"); 
		query.append("               and (e.err_msg like '%'||h.attr_ctnt4||'%'  or (instr(e.err_msg,'ORA-12899') = 0 and instr(e.err_msg,'ORA-01400') = 0))" ).append("\n"); 
		query.append("               and h.attr_ctnt3 is not null" ).append("\n"); 
		query.append("               and rownum = 1), @[err_msg])       IB_NU_ERROR    " ).append("\n"); 
		query.append("        	, @[doc_tp_cd]	                      IB_MSG_FLAG	" ).append("\n"); 
		query.append("      from dual    	" ).append("\n"); 
		query.append("    )" ).append("\n"); 
		query.append("where rownum = 1" ).append("\n"); 

	}
}