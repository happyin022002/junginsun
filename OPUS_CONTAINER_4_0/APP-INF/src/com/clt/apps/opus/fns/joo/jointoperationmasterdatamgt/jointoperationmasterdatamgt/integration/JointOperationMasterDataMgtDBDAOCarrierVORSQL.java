/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : JointOperationMasterDataMgtDBDAOCarrierVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.02
*@LastModifier : 박희동
*@LastVersion : 1.0
* 2009.11.02 박희동
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.fns.joo.jointoperationmasterdatamgt.jointoperationmasterdatamgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Park Hee Dong
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class JointOperationMasterDataMgtDBDAOCarrierVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * JOO_CARRIER 조회
	  * </pre>
	  */
	public JointOperationMasterDataMgtDBDAOCarrierVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("jo_crr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rlane_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.fns.joo.jointoperationmasterdatamgt.jointoperationmasterdatamgt.integration").append("\n"); 
		query.append("FileName : JointOperationMasterDataMgtDBDAOCarrierVORSQL").append("\n"); 
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
		query.append("select" ).append("\n"); 
		query.append("a.jo_crr_cd," ).append("\n"); 
		query.append("a.trd_cd," ).append("\n"); 
		query.append("a.rlane_cd," ).append("\n"); 
		query.append("a.cust_cnt_cd," ).append("\n"); 
		query.append("lpad(a.cust_seq,6,'0') as cust_seq," ).append("\n"); 
		query.append("a.jo_stl_opt_cd," ).append("\n"); 
		query.append("b.cust_lgl_eng_nm," ).append("\n"); 
		query.append("lpad(a.vndr_seq,6,'0') as vndr_seq," ).append("\n"); 
		query.append("c.vndr_lgl_eng_nm," ).append("\n"); 
		query.append("a.delt_flg," ).append("\n"); 
		query.append("'' usr_id," ).append("\n"); 
		query.append("'' re_divr_cd," ).append("\n"); 
		query.append("'' ofc_cd," ).append("\n"); 
		query.append("'' bzet_addr" ).append("\n"); 
		query.append("from   joo_carrier  a," ).append("\n"); 
		query.append("mdm_customer b," ).append("\n"); 
		query.append("mdm_vendor   c" ).append("\n"); 
		query.append("where  a.vndr_seq    = c.vndr_seq(+)" ).append("\n"); 
		query.append("and    a.cust_cnt_cd = b.cust_cnt_cd(+)" ).append("\n"); 
		query.append("and    a.cust_seq    = b.cust_seq(+)" ).append("\n"); 
		query.append("and    a.jo_crr_cd   = @[jo_crr_cd]" ).append("\n"); 
		query.append("and    a.rlane_cd    = @[rlane_cd]" ).append("\n"); 

	}
}