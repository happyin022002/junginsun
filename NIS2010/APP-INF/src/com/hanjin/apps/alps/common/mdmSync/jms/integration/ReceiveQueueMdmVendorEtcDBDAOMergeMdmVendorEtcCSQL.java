/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : ReceiveQueueMdmVendorEtcDBDAOMergeMdmVendorEtcCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.09.09
*@LastModifier : KIM HYUN HWA
*@LastVersion : 1.0
* 2013.09.09 KIM HYUN HWA
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.common.mdmSync.jms.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author ISD1
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ReceiveQueueMdmVendorEtcDBDAOMergeMdmVendorEtcCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * MergeMdmVendorEtc
	  * </pre>
	  */
	public ReceiveQueueMdmVendorEtcDBDAOMergeMdmVendorEtcCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("lu_delt_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("chk_de_cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("chk_de_zip_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("chk_de_addr1",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("chk_de_ste_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eai_if_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("chk_de_addr2",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("chk_de_addr3",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("upd_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eai_evnt_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("chk_de_cty_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.common.mdmSync.jms.integration").append("\n"); 
		query.append("FileName : ReceiveQueueMdmVendorEtcDBDAOMergeMdmVendorEtcCSQL").append("\n"); 
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
		query.append("MERGE INTO MDM_VENDOR a " ).append("\n"); 
		query.append("    USING (select @[vndr_seq] VNDR_SEQ from dual ) b " ).append("\n"); 
		query.append("    ON (a.VNDR_SEQ = b.VNDR_SEQ ) " ).append("\n"); 
		query.append("WHEN MATCHED THEN" ).append("\n"); 
		query.append("UPDATE" ).append("\n"); 
		query.append("set chk_de_addr1 = HJSEAI_PKG.h_decode(@[chk_de_addr1], 'UTF8', 'UTF8') ," ).append("\n"); 
		query.append("  chk_de_addr2 = HJSEAI_PKG.h_decode(@[chk_de_addr2], 'UTF8', 'UTF8') ," ).append("\n"); 
		query.append("  chk_de_addr3 = HJSEAI_PKG.h_decode(@[chk_de_addr3], 'UTF8', 'UTF8') ," ).append("\n"); 
		query.append("  chk_de_cty_nm = @[chk_de_cty_nm] ," ).append("\n"); 
		query.append("  chk_de_ste_cd = @[chk_de_ste_cd] ," ).append("\n"); 
		query.append("  chk_de_zip_cd = @[chk_de_zip_cd] ," ).append("\n"); 
		query.append("  chk_de_cnt_cd = @[chk_de_cnt_cd] ," ).append("\n"); 
		query.append("  lu_delt_flg = @[lu_delt_flg] ," ).append("\n"); 
		query.append("  upd_usr_id = @[upd_usr_id] ," ).append("\n"); 
		query.append("  upd_dt = to_date(@[upd_dt], 'yyyymmddhh24miss') ," ).append("\n"); 
		query.append("  eai_evnt_dt = to_date(@[eai_evnt_dt], 'yyyymmddhh24miss') ," ).append("\n"); 
		query.append("  eai_if_id = @[eai_if_id]" ).append("\n"); 
		query.append("where VNDR_SEQ = @[vndr_seq] WHEN NOT MATCHED THEN" ).append("\n"); 
		query.append("insert ( VNDR_SEQ," ).append("\n"); 
		query.append("      chk_de_addr1," ).append("\n"); 
		query.append("      chk_de_addr2," ).append("\n"); 
		query.append("      chk_de_addr3," ).append("\n"); 
		query.append("      chk_de_cty_nm," ).append("\n"); 
		query.append("      chk_de_ste_cd," ).append("\n"); 
		query.append("      chk_de_zip_cd," ).append("\n"); 
		query.append("      chk_de_cnt_cd," ).append("\n"); 
		query.append("      lu_delt_flg," ).append("\n"); 
		query.append("      cre_usr_id," ).append("\n"); 
		query.append("      cre_dt," ).append("\n"); 
		query.append("      upd_usr_id," ).append("\n"); 
		query.append("      upd_dt," ).append("\n"); 
		query.append("      eai_evnt_dt," ).append("\n"); 
		query.append("      eai_if_id )" ).append("\n"); 
		query.append("values ( @[vndr_seq]," ).append("\n"); 
		query.append("      HJSEAI_PKG.h_decode(@[chk_de_addr1], 'UTF8', 'UTF8')," ).append("\n"); 
		query.append("      HJSEAI_PKG.h_decode(@[chk_de_addr2], 'UTF8', 'UTF8')," ).append("\n"); 
		query.append("      HJSEAI_PKG.h_decode(@[chk_de_addr3], 'UTF8', 'UTF8')," ).append("\n"); 
		query.append("      @[chk_de_cty_nm]," ).append("\n"); 
		query.append("      @[chk_de_ste_cd]," ).append("\n"); 
		query.append("      @[chk_de_zip_cd]," ).append("\n"); 
		query.append("      @[chk_de_cnt_cd]," ).append("\n"); 
		query.append("      @[lu_delt_flg]," ).append("\n"); 
		query.append("      @[cre_usr_id]," ).append("\n"); 
		query.append("      to_date(@[cre_dt], 'yyyymmddhh24miss')," ).append("\n"); 
		query.append("      @[upd_usr_id]," ).append("\n"); 
		query.append("      to_date(@[upd_dt], 'yyyymmddhh24miss')," ).append("\n"); 
		query.append("      to_date(@[eai_evnt_dt], 'yyyymmddhh24miss')," ).append("\n"); 
		query.append("      @[eai_if_id] )" ).append("\n"); 

	}
}