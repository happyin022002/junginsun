/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : BookingARCreationDBDAOSearchRevCoaAcctCdRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.05.23
*@LastModifier : 
*@LastVersion : 1.0
* 2016.05.23 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.bookingarcreation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BookingARCreationDBDAOSearchRevCoaAcctCdRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 
	  * </pre>
	  */
	public BookingARCreationDBDAOSearchRevCoaAcctCdRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("svr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rev_src_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rev_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("chg_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("acct_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.bookingarcreation.integration").append("\n"); 
		query.append("FileName : BookingARCreationDBDAOSearchRevCoaAcctCdRSQL").append("\n"); 
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
		query.append("SELECT DECODE(@[chg_cd], 'WHF', DECODE( @[svr_id], 'KOR', DECODE(@[rev_tp_cd]||@[rev_src_cd], 'MOC', '411915', 'MBN', '954113', '211541'), " ).append("\n"); 
		query.append("                                                           DECODE(@[rev_tp_cd]||@[rev_src_cd], 'MBN', '954113', DECODE(@[rev_tp_cd], 'M', '411915', '954112')))," ).append("\n"); 
		query.append("                         'CTT', DECODE( @[svr_id], 'KOR', DECODE(@[rev_tp_cd]||@[rev_src_cd], 'MOC', '411915', 'MBN', '954113', '211551'), " ).append("\n"); 
		query.append("                                                          DECODE(@[rev_tp_cd]||@[rev_src_cd], 'MBN', '954113', DECODE(@[rev_tp_cd], 'M', '411915', '954112'))," ).append("\n"); 
		query.append("                                                          DECODE(@[rev_tp_cd]||@[rev_src_cd], 'MBN', '954113', DECODE(@[rev_tp_cd], 'M', '411915', '954112')))," ).append("\n"); 
		query.append("                         'TVA', DECODE(@[rev_tp_cd]||@[rev_src_cd], 'MBN', '954113', '212111')," ).append("\n"); 
		query.append("                         'CTX', DECODE(@[rev_tp_cd]||@[rev_src_cd], 'MBN', '954113', DECODE(SUBSTR(LOC_CD,1,2),'JP','212111',DECODE(@[rev_tp_cd],'M','411915','954112')))," ).append("\n"); 
		query.append("                         'CDX', DECODE(@[rev_tp_cd]||@[rev_src_cd], 'MBN', '954113', DECODE(SUBSTR(LOC_CD,1,2),'JP','212111',DECODE(@[rev_tp_cd],'M','411915','954112')))," ).append("\n"); 
		query.append("                         'GST', DECODE(@[rev_tp_cd]||@[rev_src_cd], 'MBN', '954113', DECODE(SUBSTR(LOC_CD,1,2),'IN','212111',DECODE(@[rev_tp_cd],'M','411915','954112')))," ).append("\n"); 
		query.append("						 'SBC', DECODE(@[rev_tp_cd]||@[rev_src_cd], 'MBN', '954113', DECODE(SUBSTR(LOC_CD,1,2),'IN','212111',DECODE(@[rev_tp_cd],'M','411915','954112')))," ).append("\n"); 
		query.append("						 'KKC', DECODE(@[rev_tp_cd]||@[rev_src_cd], 'MBN', '954113', DECODE(SUBSTR(LOC_CD,1,2),'IN','212111',DECODE(@[rev_tp_cd],'M','411915','954112')))," ).append("\n"); 
		query.append("						 'STO', DECODE(@[rev_tp_cd]||@[rev_src_cd], 'MBN', '954113', DECODE(SUBSTR(LOC_CD,1,2),'IN','212111',DECODE(@[rev_tp_cd],'M','411915','954112')))," ).append("\n"); 
		query.append("                         'AST', DECODE(@[rev_tp_cd]||@[rev_src_cd], 'MBN', '954113', DECODE(SUBSTR(LOC_CD,1,2),'AU','212111',DECODE(@[rev_tp_cd],'M','411915','954112')))," ).append("\n"); 
		query.append("                         'VDT', DECODE(@[rev_tp_cd]||@[rev_src_cd], 'MBN', '954113', DECODE(SUBSTR(LOC_CD,1,2),'VN','212111',DECODE(@[rev_tp_cd],'M','411915','954112')))," ).append("\n"); 
		query.append("                         'VTT', DECODE(@[rev_tp_cd]||@[rev_src_cd], 'MBN', '954113', DECODE(SUBSTR(LOC_CD,1,2),'VN','212111',DECODE(@[rev_tp_cd],'M','411915','954112')))," ).append("\n"); 
		query.append("						 'VRT', DECODE(@[rev_tp_cd]||@[rev_src_cd], 'MBN', '954113', DECODE(SUBSTR(LOC_CD,1,2),'VN','212111',DECODE(@[rev_tp_cd],'M','411915','954112')))," ).append("\n"); 
		query.append("                         'VST', DECODE(@[rev_tp_cd]||@[rev_src_cd], 'MBN', '954113', DECODE(SUBSTR(LOC_CD,1,2),'VN','212111',DECODE(@[rev_tp_cd],'M','411915','954112')))," ).append("\n"); 
		query.append("						 'VCT', DECODE(@[rev_tp_cd]||@[rev_src_cd], 'MBN', '954113', DECODE(SUBSTR(LOC_CD,1,2),'VN','212111',DECODE(@[rev_tp_cd],'M','411915','954112')))," ).append("\n"); 
		query.append("						 'VET', DECODE(@[rev_tp_cd]||@[rev_src_cd], 'MBN', '954113', DECODE(SUBSTR(LOC_CD,1,2),'VN','212111',DECODE(@[rev_tp_cd],'M','411915','954112')))," ).append("\n"); 
		query.append("						 'VFT', DECODE(@[rev_tp_cd]||@[rev_src_cd], 'MBN', '954113', DECODE(SUBSTR(LOC_CD,1,2),'VN','212111',DECODE(@[rev_tp_cd],'M','411915','954112')))," ).append("\n"); 
		query.append("						 'VPT', DECODE(@[rev_tp_cd]||@[rev_src_cd], 'MBN', '954113', DECODE(SUBSTR(LOC_CD,1,2),'VN','212111',DECODE(@[rev_tp_cd],'M','411915','954112'))),                         " ).append("\n"); 
		query.append("						 'FAC', '512641',  " ).append("\n"); 
		query.append("                         'TPC', '411915'," ).append("\n"); 
		query.append("						 'IEV',	'212121'," ).append("\n"); 
		query.append("                         DECODE(@[rev_tp_cd]||@[rev_src_cd], 'MSO', '954113'," ).append("\n"); 
		query.append("                                           'MTP', '957112'," ).append("\n"); 
		query.append("                                           'MBN', '954113'," ).append("\n"); 
		query.append("                                           'MRD', DECODE(@[chg_cd], 'XXX', '954113'), DECODE(@[rev_tp_cd], 'M', @[acct_cd], '954112'))) rev_coa_acct_cd" ).append("\n"); 
		query.append("  FROM MDM_ORGANIZATION " ).append("\n"); 
		query.append(" WHERE OFC_CD = @[ofc_cd]" ).append("\n"); 

	}
}