/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : TransferOrderIssueDBDAOAddNewEurTroDtlCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.10.21
*@LastModifier : 
*@LastVersion : 1.0
* 2016.10.21 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.transferorderissue.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TransferOrderIssueDBDAOAddNewEurTroDtlCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * TransferOrderIssueDBDAOAddNewEurTroDtlCSQL
	  * </pre>
	  */
	public TransferOrderIssueDBDAOAddNewEurTroDtlCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("tro_sub_seq",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("dor_zip_id",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dor_arr_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dor_addr",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("xter_tro_sub_seq",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("xter_tro_seq",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("io_bnd_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cntc_phn_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.transferorderissue.integration").append("\n"); 
		query.append("FileName : TransferOrderIssueDBDAOAddNewEurTroDtlCSQL").append("\n"); 
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
		query.append("MERGE INTO BKG_EUR_TRO_DTL A" ).append("\n"); 
		query.append("USING" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("    SELECT @[bkg_no] BKG_NO, @[io_bnd_cd] IO_BND_CD, @[tro_seq] TRO_SEQ, @[tro_sub_seq] TRO_SUB_SEQ FROM DUAL" ).append("\n"); 
		query.append(") B     " ).append("\n"); 
		query.append("ON (A.BKG_NO = B.BKG_NO AND A.IO_BND_CD = B.IO_BND_CD AND A.TRO_SEQ = B.TRO_SEQ AND A.TRO_SUB_SEQ = B.TRO_SUB_SEQ)" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("WHEN MATCHED THEN" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("UPDATE SET" ).append("\n"); 
		query.append("DOR_ZIP_ID = @[dor_zip_id]," ).append("\n"); 
		query.append("DOR_ADDR = @[dor_addr]," ).append("\n"); 
		query.append("ARR_DT = TO_DATE(@[dor_arr_dt], 'YYYY-MM-DD HH24:MI')," ).append("\n"); 
		query.append("CNTC_PSON_NM = @[cntc_pson_nm]," ).append("\n"); 
		query.append("CNTC_PHN_NO = @[cntc_phn_no]," ).append("\n"); 
		query.append("CNTC_EML = @[cntc_eml]," ).append("\n"); 
		query.append("XTER_TRO_SEQ = @[xter_tro_seq]," ).append("\n"); 
		query.append("XTER_TRO_SUB_SEQ = @[xter_tro_sub_seq]" ).append("\n"); 
		query.append("WHERE BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("AND IO_BND_CD = @[io_bnd_cd]" ).append("\n"); 
		query.append("AND TRO_SEQ = @[tro_seq]" ).append("\n"); 
		query.append("AND TRO_SUB_SEQ = @[tro_sub_seq]" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("WHEN NOT MATCHED THEN" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("INSERT (" ).append("\n"); 
		query.append("	BKG_NO" ).append("\n"); 
		query.append(",	IO_BND_CD" ).append("\n"); 
		query.append(",	TRO_SEQ" ).append("\n"); 
		query.append(",	TRO_SUB_SEQ" ).append("\n"); 
		query.append(",   DOR_ADDR" ).append("\n"); 
		query.append(",   CNTC_PSON_NM" ).append("\n"); 
		query.append(",   CNTC_PHN_NO" ).append("\n"); 
		query.append(",   CNTC_EML" ).append("\n"); 
		query.append(",   DOR_ZIP_ID" ).append("\n"); 
		query.append("#if (${dor_arr_dt} != '') " ).append("\n"); 
		query.append(",	ARR_DT" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(",	CRE_USR_ID" ).append("\n"); 
		query.append(",	CRE_DT" ).append("\n"); 
		query.append(",	UPD_USR_ID" ).append("\n"); 
		query.append(",	UPD_DT" ).append("\n"); 
		query.append(",	DOR_ADDR_TP_CD" ).append("\n"); 
		query.append(",	XTER_TRO_SEQ " ).append("\n"); 
		query.append(",	XTER_TRO_SUB_SEQ" ).append("\n"); 
		query.append(",	LOC_CD" ).append("\n"); 
		query.append(",	ZN_CD" ).append("\n"); 
		query.append(") VALUES( " ).append("\n"); 
		query.append("	@[bkg_no]" ).append("\n"); 
		query.append(",	@[io_bnd_cd]" ).append("\n"); 
		query.append(",	@[tro_seq]" ).append("\n"); 
		query.append(",	@[tro_sub_seq]" ).append("\n"); 
		query.append(",	@[dor_addr]" ).append("\n"); 
		query.append(",	@[cntc_pson_nm]" ).append("\n"); 
		query.append(",	@[cntc_phn_no]" ).append("\n"); 
		query.append(",	@[cntc_eml]" ).append("\n"); 
		query.append(",	@[dor_zip_id]" ).append("\n"); 
		query.append("#if (${dor_arr_dt} != '') " ).append("\n"); 
		query.append(",	TO_DATE(@[dor_arr_dt], 'YYYY-MM-DD HH24:MI')" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(",	@[cre_usr_id]" ).append("\n"); 
		query.append(",	sysdate " ).append("\n"); 
		query.append(",	@[upd_usr_id]" ).append("\n"); 
		query.append(",	sysdate " ).append("\n"); 
		query.append(",	'D'" ).append("\n"); 
		query.append(", 	@[xter_tro_seq]" ).append("\n"); 
		query.append(",	@[xter_tro_sub_seq]" ).append("\n"); 
		query.append(",	(SELECT POR_CD FROM BKG_BOOKING BK WHERE BKG_NO = @[bkg_no])" ).append("\n"); 
		query.append(",	(SELECT REP_ZN_CD FROM MDM_LOCATION MDM, BKG_BOOKING BK WHERE BK.BKG_NO = @[bkg_no] AND BK.POR_CD = MDM.LOC_CD ) " ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}