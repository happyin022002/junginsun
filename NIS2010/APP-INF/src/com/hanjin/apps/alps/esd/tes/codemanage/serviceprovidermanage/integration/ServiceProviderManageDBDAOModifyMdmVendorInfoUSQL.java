/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : ServiceProviderManageDBDAOModifyMdmVendorInfoUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.08.08
*@LastModifier : 
*@LastVersion : 1.0
* 2017.08.08 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.tes.codemanage.serviceprovidermanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ServiceProviderManageDBDAOModifyMdmVendorInfoUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ModifyMdmVendorInfo
	  * </pre>
	  */
	public ServiceProviderManageDBDAOModifyMdmVendorInfoUSQL(){
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
		params.put("ida_gst_rgst_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("ida_cntc_pson_nm",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("ida_gst_rgst_sts_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ida_spcl_ecn_zn_doc_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ida_spcl_ecn_zn_doc_desc",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ida_vndr_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ida_altn_rcvr_nm",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.tes.codemanage.serviceprovidermanage.integration").append("\n"); 
		query.append("FileName : ServiceProviderManageDBDAOModifyMdmVendorInfoUSQL").append("\n"); 
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
		query.append("UPDATE MDM_VENDOR" ).append("\n"); 
		query.append("SET  IDA_PAN_NO = @[ida_pan_no]" ).append("\n"); 
		query.append("    ,IDA_GST_RGST_NO = @[ida_gst_rgst_no]" ).append("\n"); 
		query.append("    ,IDA_SPCL_ECN_ZN_UT_FLG = @[ida_spcl_ecn_zn_ut_flg]" ).append("\n"); 
		query.append("    ,IDA_CNTC_PSON_NM = @[ida_cntc_pson_nm]" ).append("\n"); 
		query.append("    ,IDA_ALTN_RCVR_NM = @[ida_altn_rcvr_nm]" ).append("\n"); 
		query.append("	,IDA_SPCL_ECN_ZN_DOC_NO = @[ida_spcl_ecn_zn_doc_no]" ).append("\n"); 
		query.append("	,IDA_SPCL_ECN_ZN_DOC_DESC = @[ida_spcl_ecn_zn_doc_desc]" ).append("\n"); 
		query.append("	,IDA_CO_TYPE_CD = @[ida_co_type_cd]" ).append("\n"); 
		query.append("	,IDA_GST_RGST_STS_CD = @[ida_gst_rgst_sts_cd]" ).append("\n"); 
		query.append("	,IDA_GST_RGST_TP_CD = @[ida_gst_rgst_tp_cd]" ).append("\n"); 
		query.append("	,UPD_USR_ID = @[upd_usr_id]" ).append("\n"); 
		query.append("	,UPD_DT = SYSDATE" ).append("\n"); 
		query.append("WHERE VNDR_SEQ = @[ida_vndr_seq]" ).append("\n"); 

	}
}