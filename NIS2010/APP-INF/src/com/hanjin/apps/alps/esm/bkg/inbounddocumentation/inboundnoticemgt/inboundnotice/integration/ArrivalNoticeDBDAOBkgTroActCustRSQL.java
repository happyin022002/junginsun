/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ArrivalNoticeDBDAOBkgTroActCustRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.01
*@LastModifier : 박성호
*@LastVersion : 1.0
* 2009.06.01 박성호
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Park Sung Ho
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ArrivalNoticeDBDAOBkgTroActCustRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Integrated Customer Data Management(TRO)
	  * </pre>
	  */
	public ArrivalNoticeDBDAOBkgTroActCustRSQL(){
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
		query.append("SELECT tro_act_cust_knd_cd" ).append("\n"); 
		query.append(",tro_vndr_seq" ).append("\n"); 
		query.append(",ofc_cd" ).append("\n"); 
		query.append(",tro_act_rep_seq" ).append("\n"); 
		query.append(",cnt_cd" ).append("\n"); 
		query.append(",cust_seq" ).append("\n"); 
		query.append(",vndr_seq" ).append("\n"); 
		query.append(",loc_cd" ).append("\n"); 
		query.append(",zn_cd" ).append("\n"); 
		query.append(",act_shpr_nm" ).append("\n"); 
		query.append(",act_shpr_addr" ).append("\n"); 
		query.append(",cntc_pson_nm" ).append("\n"); 
		query.append(",cntc_phn_no" ).append("\n"); 
		query.append(",cntc_fax_no" ).append("\n"); 
		query.append(",cntc_mphn_no" ).append("\n"); 
		query.append(",cntc_eml" ).append("\n"); 
		query.append(",dor_zip_id" ).append("\n"); 
		query.append(",diff_rmk" ).append("\n"); 
		query.append(",cre_usr_id" ).append("\n"); 
		query.append(",cre_dt" ).append("\n"); 
		query.append(",upd_usr_id" ).append("\n"); 
		query.append(",upd_dt" ).append("\n"); 
		query.append("FROM bkg_tro_act_cust" ).append("\n"); 
		query.append("WHERE   cnt_cd = @[cust_cnt_cd_ib]" ).append("\n"); 
		query.append("AND cust_seq = @[cust_seq_ib]" ).append("\n"); 

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.nis2010.esm.bkg.inboundnoticemgt.inboundnotice.integration").append("\n"); 
		query.append("FileName : ArrivalNoticeDBDAOBkgTroActCustRSQL").append("\n"); 
		query.append("*/").append("\n"); 
	}
}