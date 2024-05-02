/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SCRateQuotationDBDAOPriSqScgAdjVOCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.13
*@LastModifier : 송민석
*@LastVersion : 1.0
* 2009.11.13 송민석
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.scquotation.scratequotation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author SONG MIN SEOK
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SCRateQuotationDBDAOPriSqScgAdjVOCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  *    CM/OP 산출 이후 Conversion 대상이 되는 예외적용 Surcharge 값을 반영하여 Simulation하기 위한 정보 insert
	  * </pre>
	  */
	public SCRateQuotationDBDAOPriSqScgAdjVOCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rat_ut_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("gen_spcl_rt_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("prc_de_term_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("prc_cmdt_def_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dest_via_loc_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("chg_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dest_via_loc_def_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("qttn_ver_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("qttn_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dest_loc_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("prc_rcv_term_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("org_loc_def_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("org_via_loc_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_rat_ut_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("org_loc_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("org_via_loc_def_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("adj_scg_usd_amt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("dest_loc_def_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("prc_cgo_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("adj_scg_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("prc_cmdt_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.pri.scquotation.scratequotation.integration").append("\n"); 
		query.append("FileName : SCRateQuotationDBDAOPriSqScgAdjVOCSQL").append("\n"); 
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
		query.append("INSERT INTO pri_sq_scg_adj(" ).append("\n"); 
		query.append("qttn_no," ).append("\n"); 
		query.append("qttn_ver_no," ).append("\n"); 
		query.append("gen_spcl_rt_tp_cd," ).append("\n"); 
		query.append("scg_adj_seq," ).append("\n"); 
		query.append("prc_cmdt_tp_cd," ).append("\n"); 
		query.append("prc_cmdt_def_cd," ).append("\n"); 
		query.append("org_loc_tp_cd," ).append("\n"); 
		query.append("org_loc_def_cd," ).append("\n"); 
		query.append("org_via_loc_tp_cd," ).append("\n"); 
		query.append("org_via_loc_def_cd," ).append("\n"); 
		query.append("dest_via_loc_tp_cd," ).append("\n"); 
		query.append("dest_via_loc_def_cd," ).append("\n"); 
		query.append("dest_loc_tp_cd," ).append("\n"); 
		query.append("dest_loc_def_cd," ).append("\n"); 
		query.append("prc_rcv_term_cd," ).append("\n"); 
		query.append("prc_de_term_cd," ).append("\n"); 
		query.append("bkg_rat_ut_cd," ).append("\n"); 
		query.append("prc_cgo_tp_cd," ).append("\n"); 
		query.append("chg_cd," ).append("\n"); 
		query.append("curr_cd," ).append("\n"); 
		query.append("adj_scg_amt," ).append("\n"); 
		query.append("adj_scg_usd_amt," ).append("\n"); 
		query.append("mapg_scre," ).append("\n"); 
		query.append("cre_usr_id," ).append("\n"); 
		query.append("cre_dt," ).append("\n"); 
		query.append("upd_usr_id," ).append("\n"); 
		query.append("upd_dt" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("@[qttn_no]," ).append("\n"); 
		query.append("@[qttn_ver_no]," ).append("\n"); 
		query.append("@[gen_spcl_rt_tp_cd]," ).append("\n"); 
		query.append("(select nvl(max(scg_adj_seq),0)+1 from pri_sq_scg_adj where  qttn_no = @[qttn_no] and qttn_ver_no = @[qttn_ver_no]  and gen_spcl_rt_tp_cd=@[gen_spcl_rt_tp_cd] )," ).append("\n"); 
		query.append("@[prc_cmdt_tp_cd]," ).append("\n"); 
		query.append("@[prc_cmdt_def_cd]," ).append("\n"); 
		query.append("@[org_loc_tp_cd]," ).append("\n"); 
		query.append("@[org_loc_def_cd]," ).append("\n"); 
		query.append("@[org_via_loc_tp_cd]," ).append("\n"); 
		query.append("@[org_via_loc_def_cd]," ).append("\n"); 
		query.append("@[dest_via_loc_tp_cd]," ).append("\n"); 
		query.append("@[dest_via_loc_def_cd]," ).append("\n"); 
		query.append("@[dest_loc_tp_cd]," ).append("\n"); 
		query.append("@[dest_loc_def_cd]," ).append("\n"); 
		query.append("@[prc_rcv_term_cd]," ).append("\n"); 
		query.append("@[prc_de_term_cd]," ).append("\n"); 
		query.append("@[bkg_rat_ut_cd]," ).append("\n"); 
		query.append("@[prc_cgo_tp_cd]," ).append("\n"); 
		query.append("@[chg_cd]," ).append("\n"); 
		query.append("@[curr_cd]," ).append("\n"); 
		query.append("@[adj_scg_amt]," ).append("\n"); 
		query.append("@[adj_scg_usd_amt]," ).append("\n"); 
		query.append("(decode( @[prc_cmdt_def_cd], null, 0, 1 )  + decode( @[org_loc_def_cd], null, 0, 1 ) +" ).append("\n"); 
		query.append("decode( @[org_via_loc_def_cd], null, 0, 1 )  + decode( @[dest_via_loc_def_cd], null, 0, 1 ) +" ).append("\n"); 
		query.append("decode( @[dest_loc_def_cd], null, 0, 1 )  + decode( @[prc_rcv_term_cd], null, 0, 1 ) +" ).append("\n"); 
		query.append("decode( @[prc_de_term_cd], null, 0, 1 )  + decode( @[rat_ut_cd], null, 0, 1 ) +" ).append("\n"); 
		query.append("decode( @[prc_cgo_tp_cd], null, 0, 1 ))," ).append("\n"); 
		query.append("@[cre_usr_id]," ).append("\n"); 
		query.append("SYSDATE," ).append("\n"); 
		query.append("@[upd_usr_id]," ).append("\n"); 
		query.append("SYSDATE" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 

	}
}