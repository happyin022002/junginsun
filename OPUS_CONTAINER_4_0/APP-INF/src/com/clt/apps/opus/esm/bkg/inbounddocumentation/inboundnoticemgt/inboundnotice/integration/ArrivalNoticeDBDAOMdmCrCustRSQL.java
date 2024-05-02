/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : ArrivalNoticeDBDAOMdmCrCustRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.04.25
*@LastModifier : 
*@LastVersion : 1.0
* 2012.04.25 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ArrivalNoticeDBDAOMdmCrCustRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ...
	  * </pre>
	  */
	public ArrivalNoticeDBDAOMdmCrCustRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_seq_ib",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_cnt_cd_ib",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.integration").append("\n"); 
		query.append("FileName : ArrivalNoticeDBDAOMdmCrCustRSQL").append("\n"); 
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
		query.append("SELECT act_cust_cnt_cd || act_cust_seq AS act_cust_cd" ).append("\n"); 
		query.append("      ,ob_eml" ).append("\n"); 
		query.append("      ,ib_eml" ).append("\n"); 
		query.append("      ,locl_nm" ).append("\n"); 
		query.append("      ,locl_addr1 || locl_addr2 AS addr1" ).append("\n"); 
		query.append("      ,locl_addr3 || locl_addr4 AS addr2" ).append("\n"); 
		query.append("      ,cr_cust_tp_cd" ).append("\n"); 
		query.append("      ,LOCL_IB_OFC_CD as kr_ib_ofc_cd" ).append("\n"); 
		query.append("      ,locl_zip_cd" ).append("\n"); 
		query.append("      ,nvl(ob_phn_no, ib_phn_no) AS phn_no" ).append("\n"); 
		query.append("      ,nvl(ob_fax_no, ib_fax_no) AS fax_no" ).append("\n"); 
		query.append("      ,cr_cust_rmk" ).append("\n"); 
		query.append("  FROM mdm_cr_cust" ).append("\n"); 
		query.append(" WHERE cust_cnt_cd = @[cust_cnt_cd_ib]" ).append("\n"); 
		query.append("   AND cust_seq = @[cust_seq_ib]" ).append("\n"); 

	}
}