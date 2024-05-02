/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : EDISetupDBDAOHistoryEdiGrpCustCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.07.17
*@LastModifier : 채창호
*@LastVersion : 1.0
* 2012.07.17 채창호
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.sce.edisetup.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Chae Change Ho
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class EDISetupDBDAOHistoryEdiGrpCustCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * EDI_GRP_CUST table의 History를 기록하는 SQL
	  * </pre>
	  */
	public EDISetupDBDAOHistoryEdiGrpCustCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("e_co_div_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("e_cust_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("e_cgo_trc_svc_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cgo_trc_bat_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("e_sc_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eai_date",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("e_bkg_ctrt_div_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("e_ib_svc_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("e_cust_cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_types",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("e_edi_grp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("e_sc_eff_end_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("e_sc_eff_st_dt",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.sce.edisetup.integration").append("\n"); 
		query.append("FileName : EDISetupDBDAOHistoryEdiGrpCustCSQL").append("\n"); 
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
		query.append("insert into edi_grp_cust_his" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("edi_snd_his_seq" ).append("\n"); 
		query.append(",edi_grp_cd" ).append("\n"); 
		query.append(",co_div_cd" ).append("\n"); 
		query.append(",cust_cnt_cd" ).append("\n"); 
		query.append(",cust_seq" ).append("\n"); 
		query.append(",sc_no" ).append("\n"); 
		query.append(",sc_eff_st_dt" ).append("\n"); 
		query.append(",sc_eff_end_dt" ).append("\n"); 
		query.append(",ib_svc_flg" ).append("\n"); 
		query.append(",cgo_trc_svc_flg" ).append("\n"); 
		query.append(",eai_evnt_dt" ).append("\n"); 
		query.append(",bkg_ctrt_div_cd" ).append("\n"); 
		query.append(",bkg_cust_tp_desc" ).append("\n"); 
		query.append(",cgo_trc_bat_flg" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("values" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("edi_grp_cust_his_seq1.nextval," ).append("\n"); 
		query.append("@[e_edi_grp_cd]," ).append("\n"); 
		query.append("@[e_co_div_cd]," ).append("\n"); 
		query.append("@[e_cust_cnt_cd]," ).append("\n"); 
		query.append("@[e_cust_seq]," ).append("\n"); 
		query.append("@[e_sc_no]," ).append("\n"); 
		query.append("@[e_sc_eff_st_dt]," ).append("\n"); 
		query.append("@[e_sc_eff_end_dt]," ).append("\n"); 
		query.append("@[e_ib_svc_flg]," ).append("\n"); 
		query.append("decode(@[e_cgo_trc_svc_flg], 1, 'Y', 0, 'N', 'N')," ).append("\n"); 
		query.append("to_date(@[eai_date],'yyyy/mm/dd hh24:mi:ss')," ).append("\n"); 
		query.append("@[e_bkg_ctrt_div_cd]," ).append("\n"); 
		query.append("@[cust_types]," ).append("\n"); 
		query.append("decode(@[cgo_trc_bat_flg], 1, 'Y', 0, 'N', 'N')" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}