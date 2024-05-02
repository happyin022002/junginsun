/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : CustMainDBDAOModifyGstCustCodeUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.07.26
*@LastModifier : 
*@LastVersion : 1.0
* 2017.07.26 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.bcm.cms.custmanage.custmain.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CustMainDBDAOModifyGstCustCodeUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Customer information GST update
	  * </pre>
	  */
	public CustMainDBDAOModifyGstCustCodeUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ida_co_type_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ida_spcl_ecn_zn_ut_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("upd_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ida_gst_rgst_no",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("ida_pan_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ida_cust_eml",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.bcm.cms.custmanage.custmain.integration").append("\n"); 
		query.append("FileName : CustMainDBDAOModifyGstCustCodeUSQL").append("\n"); 
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
		query.append("UPDATE MDM_CUSTOMER" ).append("\n"); 
		query.append("SET" ).append("\n"); 
		query.append("   ida_pan_no                          = @[ida_pan_no]                                                            " ).append("\n"); 
		query.append(",  ida_gst_rgst_no                     = @[ida_gst_rgst_no]                                                       " ).append("\n"); 
		query.append(",  IDA_SPCL_ECN_ZN_UT_FLG              = @[ida_spcl_ecn_zn_ut_flg]  " ).append("\n"); 
		query.append(",  IDA_CO_TYPE_CD			           = @[ida_co_type_cd]" ).append("\n"); 
		query.append(",  IDA_CUST_EML                        = @[ida_cust_eml]                                                      " ).append("\n"); 
		query.append(",  UPD_USR_ID                          = @[upd_usr_id]                                                            " ).append("\n"); 
		query.append(",  UPD_DT                              = sysdate                                                                  " ).append("\n"); 
		query.append("WHERE  CUST_CNT_CD    = @[cust_cnt_cd]" ).append("\n"); 
		query.append("AND CUST_SEQ          = @[cust_seq]" ).append("\n"); 

	}
}