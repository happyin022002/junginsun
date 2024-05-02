/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SingleTransportationSOManageDBDAOEmptyModify01SingleTrsUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.23
*@LastModifier : 
*@LastVersion : 1.0
* 2009.09.23 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.trs.emptyreposomanage.singletransportationsomanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SingleTransportationSOManageDBDAOEmptyModify01SingleTrsUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * f_cmd : MODIFY01
	  * </pre>
	  */
	public SingleTransportationSOManageDBDAOEmptyModify01SingleTrsUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.NUMERIC + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trsp_so_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("upd_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.NUMERIC + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trsp_so_cmb_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trsp_so_ofc_cty_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("soffice_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.trs.emptyreposomanage.singletransportationsomanage.integration").append("\n"); 
		query.append("FileName : SingleTransportationSOManageDBDAOEmptyModify01SingleTrsUSQL").append("\n"); 
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
		query.append("UPDATE trs_trsp_svc_ord" ).append("\n"); 
		query.append("SET trsp_so_cmb_seq = NULL" ).append("\n"); 
		query.append(",cmb_so_rlt_sts_flg = NULL" ).append("\n"); 
		query.append(",trsp_so_cmb_srt_no = NULL" ).append("\n"); 
		query.append(",upd_dt  = SYSDATE" ).append("\n"); 
		query.append(",locl_upd_dt = GLOBALDATE_PKG.TIME_LOCAL_OFC_FNC(@[soffice_cd])" ).append("\n"); 
		query.append(",upd_usr_id = @[upd_usr_id]" ).append("\n"); 
		query.append("WHERE" ).append("\n"); 
		query.append("trsp_so_ofc_cty_cd = @[trsp_so_ofc_cty_cd]" ).append("\n"); 
		query.append("AND trsp_so_seq = @[trsp_so_seq]" ).append("\n"); 
		query.append("AND trsp_so_cmb_seq = @[trsp_so_cmb_seq]" ).append("\n"); 
		query.append("AND delt_flg = 'N'" ).append("\n"); 
		query.append("AND hjl_no IS NULL" ).append("\n"); 

	}
}