/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : TransferOrderIssueDBDAOModifyEurTroDtlByXterUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.03.31
*@LastModifier : 류대영
*@LastVersion : 1.0
* 2010.03.31 류대영
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.transferorderissue.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Ryu Daeyoung
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TransferOrderIssueDBDAOModifyEurTroDtlByXterUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * TransferOrderIssueDBDAOModifyEurTroDtlByXterUSQL
	  * </pre>
	  */
	public TransferOrderIssueDBDAOModifyEurTroDtlByXterUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("dor_pst_no",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("tro_seq",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("dor_addr_1",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.transferorderissue.integration").append("\n"); 
		query.append("FileName : TransferOrderIssueDBDAOModifyEurTroDtlByXterUSQL").append("\n"); 
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
		query.append("UPDATE BKG_EUR_TRO_DTL SET" ).append("\n"); 
		query.append("DOR_ZIP_ID = @[dor_pst_no]" ).append("\n"); 
		query.append(", DOR_ADDR   = @[dor_addr_1]" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${arr_dt} != '')" ).append("\n"); 
		query.append(",	ARR_DT = TO_DATE(@[arr_dt], 'YYYY-MM-DD HH24:MI')" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append(",	ARR_DT = @[arr_dt]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(", CNTC_PSON_NM = @[cntc_pson_nm]" ).append("\n"); 
		query.append(", CNTC_PHN_NO  = @[cntc_phn_no]" ).append("\n"); 
		query.append("--       DOR_ADDR_TP_CD" ).append("\n"); 
		query.append("--     , LOC_CD" ).append("\n"); 
		query.append("--     , ZN_CD" ).append("\n"); 
		query.append("--     , LOD_REF_NO" ).append("\n"); 
		query.append("--     , CNTC_EML" ).append("\n"); 
		query.append(",	UPD_USR_ID  = @[upd_usr_id]" ).append("\n"); 
		query.append(",	UPD_DT      = sysdate" ).append("\n"); 
		query.append("WHERE BKG_NO      = @[bkg_no]" ).append("\n"); 
		query.append("AND IO_BND_CD   = 'O'" ).append("\n"); 
		query.append("AND TRO_SEQ     = @[tro_seq]" ).append("\n"); 
		query.append("AND TRO_SUB_SEQ = @[tro_sub_seq]" ).append("\n"); 
		query.append("AND TRO_SEQ IN (SELECT TRO_SEQ" ).append("\n"); 
		query.append("FROM BKG_EUR_TRO" ).append("\n"); 
		query.append("WHERE BKG_NO      = @[bkg_no]" ).append("\n"); 
		query.append("AND IO_BND_CD   = 'O'" ).append("\n"); 
		query.append("AND TRO_SEQ     = @[tro_seq]" ).append("\n"); 
		query.append("AND NVL(CFM_FLG, 'N') = 'N'" ).append("\n"); 
		query.append("AND NVL(CXL_FLG, 'N') = 'N')" ).append("\n"); 

	}
}