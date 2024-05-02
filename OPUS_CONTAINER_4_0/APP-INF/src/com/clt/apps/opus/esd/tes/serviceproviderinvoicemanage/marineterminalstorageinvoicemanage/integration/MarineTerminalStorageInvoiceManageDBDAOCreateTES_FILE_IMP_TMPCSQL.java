/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : MarineTerminalStorageInvoiceManageDBDAOCreateTES_FILE_IMP_TMPCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.15
*@LastModifier : 이정혜
*@LastVersion : 1.0
* 2009.10.15 이정혜
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.tes.serviceproviderinvoicemanage.marineterminalstorageinvoicemanage.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author HARRY
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class MarineTerminalStorageInvoiceManageDBDAOCreateTES_FILE_IMP_TMPCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * CreateTES_FILE_IMP_TMP
	  * </pre>
	  */
	public MarineTerminalStorageInvoiceManageDBDAOCreateTES_FILE_IMP_TMPCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("tml_so_tmp_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vndr_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("tml_so_ofc_cty_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("to_prd_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_tpsz_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fm_prd_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rcv_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inv_gate_in_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("io_bnd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("tml_so_seq",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("yd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("wrk_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inv_gate_out_dt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cntr_sty_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.tes.serviceproviderinvoicemanage.marineterminalstorageinvoicemanage.integration ").append("\n"); 
		query.append("FileName : MarineTerminalStorageInvoiceManageDBDAOCreateTES_FILE_IMP_TMPCSQL").append("\n"); 
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
		query.append("INSERT INTO TES_FILE_IMP_TMP(" ).append("\n"); 
		query.append("TML_SO_OFC_CTY_CD," ).append("\n"); 
		query.append("TML_SO_SEQ," ).append("\n"); 
		query.append("TML_SO_TMP_SEQ," ).append("\n"); 
		query.append("CNTR_NO," ).append("\n"); 
		query.append("CNTR_TPSZ_CD," ).append("\n"); 
		query.append("CNTR_STY_CD," ).append("\n"); 
		query.append("IO_BND_CD," ).append("\n"); 
		query.append("WRK_DT," ).append("\n"); 
		query.append("INV_GATE_IN_DT," ).append("\n"); 
		query.append("INV_GATE_OUT_DT," ).append("\n"); 
		query.append("VNDR_SEQ," ).append("\n"); 
		query.append("YD_CD," ).append("\n"); 
		query.append("RCV_DT," ).append("\n"); 
		query.append("FM_PRD_DT," ).append("\n"); 
		query.append("TO_PRD_DT," ).append("\n"); 
		query.append("CRE_USR_ID," ).append("\n"); 
		query.append("CRE_DT," ).append("\n"); 
		query.append("UPD_USR_ID," ).append("\n"); 
		query.append("UPD_DT" ).append("\n"); 
		query.append(") VALUES (" ).append("\n"); 
		query.append("@[tml_so_ofc_cty_cd]" ).append("\n"); 
		query.append(", @[tml_so_seq]" ).append("\n"); 
		query.append(", @[tml_so_tmp_seq]" ).append("\n"); 
		query.append(", @[cntr_no]" ).append("\n"); 
		query.append(", @[cntr_tpsz_cd]" ).append("\n"); 
		query.append(", @[cntr_sty_cd]" ).append("\n"); 
		query.append(", @[io_bnd_cd]" ).append("\n"); 
		query.append(", @[wrk_dt]" ).append("\n"); 
		query.append(", TO_DATE(@[inv_gate_in_dt],'YYYYMMDDHH24MISS')" ).append("\n"); 
		query.append(", TO_DATE(@[inv_gate_out_dt],'YYYYMMDDHH24MISS')" ).append("\n"); 
		query.append(", @[vndr_seq]" ).append("\n"); 
		query.append(", @[yd_cd]" ).append("\n"); 
		query.append(", TO_DATE(@[rcv_dt],'YYYY-MM-DD')" ).append("\n"); 
		query.append(", @[fm_prd_dt]" ).append("\n"); 
		query.append(", @[to_prd_dt]" ).append("\n"); 
		query.append(", @[cre_usr_id]" ).append("\n"); 
		query.append(", SYSDATE" ).append("\n"); 
		query.append(", @[upd_usr_id]" ).append("\n"); 
		query.append(", SYSDATE" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}