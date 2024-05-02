/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ArrivalNoticeDBDAOBkgCustTmpltRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.29
*@LastModifier : 
*@LastVersion : 1.0
* 2009.05.29 
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

public class ArrivalNoticeDBDAOBkgCustTmpltRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Integrated Customer Data Management(OB)
	  * </pre>
	  */
	public ArrivalNoticeDBDAOBkgCustTmpltRSQL(){
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
		query.append("SELECT cust_cnt_cd" ).append("\n"); 
		query.append(",cust_seq" ).append("\n"); 
		query.append(",tmplt_seq" ).append("\n"); 
		query.append(",cust_nm" ).append("\n"); 
		query.append(",cust_addr" ).append("\n"); 
		query.append(",cust_cty_nm" ).append("\n"); 
		query.append(",cust_ste_cd" ).append("\n"); 
		query.append(",cust_zip_cd" ).append("\n"); 
		query.append(",cust_phn_no" ).append("\n"); 
		query.append(",cust_fax_no" ).append("\n"); 
		query.append(",cust_eml" ).append("\n"); 
		query.append(",atnd_nm" ).append("\n"); 
		query.append(",tmplt_rmk" ).append("\n"); 
		query.append(",cre_usr_id" ).append("\n"); 
		query.append(",cre_dt" ).append("\n"); 
		query.append(",upd_usr_id" ).append("\n"); 
		query.append(",upd_dt" ).append("\n"); 
		query.append("FROM bkg_cust_tmplt" ).append("\n"); 
		query.append("where cust_cnt_cd = @[cust_cnt_cd_ib]" ).append("\n"); 
		query.append("and   cust_seq = @[cust_seq_ib]" ).append("\n"); 

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.inboundnoticemgt.inboundnotice.integration").append("\n"); 
		query.append("FileName : ArrivalNoticeDBDAOBkgCustTmpltRSQL").append("\n"); 
		query.append("*/").append("\n"); 
	}
}