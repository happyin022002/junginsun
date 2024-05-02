/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : TransferOrderIssueDBDAOModifyEurTroDtlUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.12.03
*@LastModifier : 류대영
*@LastVersion : 1.0
* 2013.12.03 류대영
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.transferorderissue.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author DYRYU
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TransferOrderIssueDBDAOModifyEurTroDtlUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * TransferOrderIssueDBDAOModifyEurTroDtlUSQL
	  * </pre>
	  */
	public TransferOrderIssueDBDAOModifyEurTroDtlUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("arr_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("zn_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("tro_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dor_addr_2",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dor_addr_3",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dor_addr_4",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("lod_ref_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dor_addr_1",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntc_eml",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntc_pson_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dor_addr_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dor_pst_no",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntc_phn_no",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("dor_loc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("arr_dt_hhmi",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("tro_sub_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.transferorderissue.integration").append("\n"); 
		query.append("FileName : TransferOrderIssueDBDAOModifyEurTroDtlUSQL").append("\n"); 
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
		query.append("UPDATE BKG_EUR_TRO_DTL SET " ).append("\n"); 
		query.append("       DOR_ADDR_TP_CD = @[dor_addr_tp_cd]     " ).append("\n"); 
		query.append("     , LOC_CD         = @[dor_loc_cd]" ).append("\n"); 
		query.append("#if (${zn_cd} != '') " ).append("\n"); 
		query.append("     , ZN_CD = @[dor_loc_cd]||@[zn_cd]" ).append("\n"); 
		query.append("#else " ).append("\n"); 
		query.append("     , ZN_CD = @[zn_cd] " ).append("\n"); 
		query.append("#end      " ).append("\n"); 
		query.append("     , LOD_REF_NO = @[lod_ref_no]" ).append("\n"); 
		query.append("     , DOR_ZIP_ID = @[dor_pst_no]" ).append("\n"); 
		query.append("     , DOR_ADDR   = RPAD(@[dor_addr_1], 50, ' ')||" ).append("\n"); 
		query.append("                    RPAD(@[dor_addr_2], 50, ' ')||" ).append("\n"); 
		query.append("                    RPAD(NVL(@[dor_addr_3],' '), 50, ' ')||" ).append("\n"); 
		query.append("                    RPAD(@[dor_addr_4], 50, ' ')" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${arr_dt} != '') " ).append("\n"); 
		query.append("     ,	ARR_DT = TO_DATE(@[arr_dt]||' '||@[arr_dt_hhmi], 'YYYY-MM-DD HH24:MI') " ).append("\n"); 
		query.append("#else " ).append("\n"); 
		query.append("     ,	ARR_DT = @[arr_dt]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("     , CNTC_PSON_NM = @[cntc_pson_nm]" ).append("\n"); 
		query.append("     , CNTC_PHN_NO  = @[cntc_phn_no]" ).append("\n"); 
		query.append("     , CNTC_EML     = @[cntc_eml]" ).append("\n"); 
		query.append("     ,	UPD_USR_ID  = @[upd_usr_id]" ).append("\n"); 
		query.append("     ,	UPD_DT      = sysdate " ).append("\n"); 
		query.append(" WHERE BKG_NO      = @[bkg_no]" ).append("\n"); 
		query.append("   AND IO_BND_CD   = @[io_bnd_cd]" ).append("\n"); 
		query.append("   AND TRO_SEQ     = @[tro_seq]" ).append("\n"); 
		query.append("   AND TRO_SUB_SEQ = @[tro_sub_seq]" ).append("\n"); 

	}
}