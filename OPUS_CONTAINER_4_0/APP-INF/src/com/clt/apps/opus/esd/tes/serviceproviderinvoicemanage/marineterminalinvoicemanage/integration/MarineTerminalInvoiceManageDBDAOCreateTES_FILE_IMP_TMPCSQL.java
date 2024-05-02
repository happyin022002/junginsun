/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : MarineTerminalInvoiceManageDBDAOCreateTES_FILE_IMP_TMPCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.25
*@LastModifier : 박재흥
*@LastVersion : 1.0
* 2009.09.25 박재흥
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.tes.serviceproviderinvoicemanage.marineterminalinvoicemanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author park chae heung
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class MarineTerminalInvoiceManageDBDAOCreateTES_FILE_IMP_TMPCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * CreateTES_FILE_IMP_TMP
	  * </pre>
	  */
	public MarineTerminalInvoiceManageDBDAOCreateTES_FILE_IMP_TMPCSQL(){
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
		params.put("vvd_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cntr_tpsz_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("io_bnd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("atb_dt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cntr_no",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("wrk_dt",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("Path : com.clt.apps.opus.esd.tes.serviceproviderinvoicemanage.marineterminalinvoicemanage.integration").append("\n"); 
		query.append("FileName : MarineTerminalInvoiceManageDBDAOCreateTES_FILE_IMP_TMPCSQL").append("\n"); 
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
		query.append("tml_so_ofc_cty_cd," ).append("\n"); 
		query.append("tml_so_seq," ).append("\n"); 
		query.append("tml_so_tmp_seq," ).append("\n"); 
		query.append("cntr_no," ).append("\n"); 
		query.append("cntr_tpsz_cd," ).append("\n"); 
		query.append("cntr_sty_cd," ).append("\n"); 
		query.append("io_bnd_cd," ).append("\n"); 
		query.append("vndr_seq," ).append("\n"); 
		query.append("yd_cd," ).append("\n"); 
		query.append("vvd_cd," ).append("\n"); 
		query.append("atb_dt," ).append("\n"); 
		query.append("rcv_dt," ).append("\n"); 
		query.append("wrk_dt," ).append("\n"); 
		query.append("cre_usr_id," ).append("\n"); 
		query.append("upd_usr_id," ).append("\n"); 
		query.append("cre_dt," ).append("\n"); 
		query.append("upd_dt" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("VALUES(      @[tml_so_ofc_cty_cd]       --tml_so_ofc_cty_cd," ).append("\n"); 
		query.append(",@[tml_so_seq]       		--tml_so_seq," ).append("\n"); 
		query.append(",@[tml_so_tmp_seq]	   		--tml_so_tmp_seq" ).append("\n"); 
		query.append(",@[cntr_no]       			--cntr_no," ).append("\n"); 
		query.append(",@[cntr_tpsz_cd]       		--cntr_tpsz_cd," ).append("\n"); 
		query.append(",@[cntr_sty_cd]       		--cntr_sty_cd," ).append("\n"); 
		query.append(",@[io_bnd_cd]       		--io_bnd_cd," ).append("\n"); 
		query.append(",@[vndr_seq]       			--vndr_seq," ).append("\n"); 
		query.append(",@[yd_cd]       			--yd_cd," ).append("\n"); 
		query.append(",@[vvd_cd]       			--vvd_cd," ).append("\n"); 
		query.append(",TO_DATE(REPLACE(@[atb_dt],'-'),'YYYYMMDD') --atb_dt," ).append("\n"); 
		query.append(",TO_DATE(REPLACE(@[rcv_dt],'-'),'YYYYMMDD') --rcv_dt," ).append("\n"); 
		query.append(",REPLACE(@[wrk_dt],'-') --wrk_dt" ).append("\n"); 
		query.append(",@[cre_usr_id]			--cre_usr_id" ).append("\n"); 
		query.append(",@[upd_usr_id]			--upd_usr_id" ).append("\n"); 
		query.append(",SYSDATE" ).append("\n"); 
		query.append(",SYSDATE" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}