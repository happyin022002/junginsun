/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ArrivalNoticeDBDAOsearchArrNtcCustInfoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.18
*@LastModifier : 박성호
*@LastVersion : 1.0
* 2009.08.18 박성호
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Park Sungho
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ArrivalNoticeDBDAOsearchArrNtcCustInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ....
	  * </pre>
	  */
	public ArrivalNoticeDBDAOsearchArrNtcCustInfoRSQL(){
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
		params.put("bkg_cust_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.integration").append("\n"); 
		query.append("FileName : ArrivalNoticeDBDAOsearchArrNtcCustInfoRSQL").append("\n"); 
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
		query.append("/* 242-1,2,3 */" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("'' a" ).append("\n"); 
		query.append(",a.bkg_no" ).append("\n"); 
		query.append(",bkg_cust_tp_cd" ).append("\n"); 
		query.append(",a.cust_cnt_cd" ).append("\n"); 
		query.append(",decode(a.cust_seq,0,b.cust_seq,a.cust_seq) as cust_seq" ).append("\n"); 
		query.append(",cust_lgl_eng_nm AS mdm_name" ).append("\n"); 
		query.append(",cust_nm AS bl_name" ).append("\n"); 
		query.append(",cust_addr AS address" ).append("\n"); 
		query.append(",cstms_desc AS rep_cmdt" ).append("\n"); 
		query.append(",cust_fax_no AS fax_no" ).append("\n"); 
		query.append(",cust_eml AS email" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("FROM bkg_customer a" ).append("\n"); 
		query.append(",mdm_customer b" ).append("\n"); 
		query.append(",bkg_bl_doc   c" ).append("\n"); 
		query.append("WHERE 1 = 1" ).append("\n"); 
		query.append("AND a.bkg_cust_tp_cd = @[bkg_cust_tp_cd]" ).append("\n"); 
		query.append("AND a.cust_cnt_cd = b.cust_cnt_cd(+)" ).append("\n"); 
		query.append("AND a.cust_seq = b.cust_seq(+)" ).append("\n"); 
		query.append("AND a.bkg_no = c.bkg_no" ).append("\n"); 
		query.append("AND a.bkg_no = @[bkg_no]" ).append("\n"); 

	}
}