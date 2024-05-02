/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : CopDetailReceiveDBDAOSearchEdi322MsgRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.10.31
*@LastModifier : 
*@LastVersion : 1.0
* 2013.10.31 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.sce.copdetailreceive.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CopDetailReceiveDBDAOSearchEdi322MsgRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchEdi322Msg
	  * </pre>
	  */
	public CopDetailReceiveDBDAOSearchEdi322MsgRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("evnt_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eq_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("edi_322_sts_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.sce.copdetailreceive.integration").append("\n"); 
		query.append("FileName : CopDetailReceiveDBDAOSearchEdi322MsgRSQL").append("\n"); 
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
		query.append("select evnt_dt" ).append("\n"); 
		query.append(",eq_no" ).append("\n"); 
		query.append(",edi_322_sts_cd" ).append("\n"); 
		query.append(",sndr_id" ).append("\n"); 
		query.append(",rcvr_id" ).append("\n"); 
		query.append(",evnt_yd_cd" ).append("\n"); 
		query.append(",evnt_cty_nm" ).append("\n"); 
		query.append(",evnt_ste_cd" ).append("\n"); 
		query.append(",evnt_cnt_cd" ).append("\n"); 
		query.append(",eq_desc_cd" ).append("\n"); 
		query.append(",eq_sts_cd" ).append("\n"); 
		query.append(",chss_edi_322_no" ).append("\n"); 
		query.append(",vsl_cd" ).append("\n"); 
		query.append(",lloyd_vsl_no" ).append("\n"); 
		query.append(",vsl_nm" ).append("\n"); 
		query.append(",vsl_voy_dir_no" ).append("\n"); 
		query.append(",spcl_hndl_cd" ).append("\n"); 
		query.append(",bl_edi_322_no" ).append("\n"); 
		query.append(",bkg_edi_322_no" ).append("\n"); 
		query.append(",cre_dt" ).append("\n"); 
		query.append(",psn_cd" ).append("\n"); 
		query.append(",pkup_edi_322_no" ).append("\n"); 
		query.append(",err_msg" ).append("\n"); 
		query.append(",rail_dest_n1st_eta_dt" ).append("\n"); 
		query.append("from   edi_322_msg" ).append("\n"); 
		query.append("where  evnt_dt = to_date(@[evnt_dt],'YYYYMMDDHH24MISS')" ).append("\n"); 
		query.append("and    eq_no = @[eq_no]" ).append("\n"); 
		query.append("and    edi_322_sts_cd = @[edi_322_sts_cd]" ).append("\n"); 

	}
}