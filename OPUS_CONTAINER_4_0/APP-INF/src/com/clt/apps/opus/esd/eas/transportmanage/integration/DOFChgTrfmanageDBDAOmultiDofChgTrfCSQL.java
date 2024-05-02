/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : DOFChgTrfmanageDBDAOmultiDofChgTrfCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.01.27
*@LastModifier : 양봉준
*@LastVersion : 1.0
* 2010.01.27 양봉준
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.eas.transportmanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Bongjun Yang
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class DOFChgTrfmanageDBDAOmultiDofChgTrfCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Drop Off Charge Tariff 등록
	  * </pre>
	  */
	public DOFChgTrfmanageDBDAOmultiDofChgTrfCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_info",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("conti_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("curr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("newEffDate",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ctrl_user_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.NUMERIC + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("chrr_frt_tax_val",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fm_loc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_rmk",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ctrl_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.eas.transportmanage.integration").append("\n"); 
		query.append("FileName : DOFChgTrfmanageDBDAOmultiDofChgTrfCSQL").append("\n"); 
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
		query.append("insert into trs_drff_chg_trf" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("eff_dt, fm_loc_cd, cnt_cd, cust_seq, conti_cd, cntr_tp_cd" ).append("\n"); 
		query.append(",chrr_frt_tax_val ,curr_cd ,cre_usr_id ,cre_dt" ).append("\n"); 
		query.append(",upd_usr_id ,upd_dt ,cust_rmk,cre_ofc_cd" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("values" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("to_date( @[newEffDate]||'000000', 'YYYYMMDDHH24MISS'), @[fm_loc_cd],substr(@[cust_info],0,2), substr(@[cust_info],3), @[conti_cd], @[cntr_tp_cd]," ).append("\n"); 
		query.append("@[chrr_frt_tax_val], @[curr_cd], @[ctrl_user_id], sysdate," ).append("\n"); 
		query.append("@[ctrl_user_id], sysdate, @[cust_rmk], @[ctrl_ofc_cd]" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}