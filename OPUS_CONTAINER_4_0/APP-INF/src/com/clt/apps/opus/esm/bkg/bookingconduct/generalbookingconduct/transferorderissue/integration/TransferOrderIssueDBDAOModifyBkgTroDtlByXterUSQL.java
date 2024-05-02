/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : TransferOrderIssueDBDAOModifyBkgTroDtlByXterUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.04.11
*@LastModifier : 정인선
*@LastVersion : 1.0
* 2016.04.11 정인선
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.transferorderissue.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author jung in sun
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TransferOrderIssueDBDAOModifyBkgTroDtlByXterUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * TransferOrderIssueDBDAOModifyBkgTroDtlByXterUSQL
	  * </pre>
	  */
	public TransferOrderIssueDBDAOModifyBkgTroDtlByXterUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("pkup_yd_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cntr_tpsz_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("pkup_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rtn_yd_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("upd_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("tro_qty",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pkup_loc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rtn_loc_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("tro_sub_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.transferorderissue.integration").append("\n"); 
		query.append("FileName : TransferOrderIssueDBDAOModifyBkgTroDtlByXterUSQL").append("\n"); 
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
		query.append("UPDATE BKG_TRO_DTL SET " ).append("\n"); 
		query.append("	CNTR_TPSZ_CD = @[cntr_tpsz_cd]" ).append("\n"); 
		query.append(",	TRO_QTY      = NVL(DECODE(@[tro_qty], '0', '1', @[tro_qty]), '1')" ).append("\n"); 
		query.append("#if (${dor_arr_dt} != '') " ).append("\n"); 
		query.append(",	DOR_ARR_DT = TO_DATE(@[dor_arr_dt], 'YYYY-MM-DD HH24:MI') " ).append("\n"); 
		query.append("#else " ).append("\n"); 
		query.append(",	DOR_ARR_DT = @[dor_arr_dt]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(",	PKUP_LOC_CD = @[pkup_loc_cd]" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${pkup_yd_cd} != '') " ).append("\n"); 
		query.append(",	PKUP_YD_CD = @[pkup_loc_cd]||@[pkup_yd_cd]" ).append("\n"); 
		query.append("#else " ).append("\n"); 
		query.append(",	PKUP_YD_CD = @[pkup_yd_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(",	RTN_LOC_CD = @[rtn_loc_cd]" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${rtn_yd_cd} != '') " ).append("\n"); 
		query.append(",	RTN_YD_CD = @[rtn_loc_cd]||@[rtn_yd_cd]" ).append("\n"); 
		query.append("#else " ).append("\n"); 
		query.append(",	RTN_YD_CD = @[rtn_yd_cd] " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(",	UPD_USR_ID = @[upd_usr_id]" ).append("\n"); 
		query.append(",	UPD_DT = sysdate " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${pkup_dt} != '') " ).append("\n"); 
		query.append(",	PKUP_DT = TO_DATE(@[pkup_dt], 'YYYY-MM-DD HH24:MI') " ).append("\n"); 
		query.append("#else " ).append("\n"); 
		query.append(",	PKUP_DT = @[pkup_dt]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(",   XTER_TRO_SEQ = @[xter_tro_seq]" ).append("\n"); 
		query.append(",   XTER_TRO_SUB_SEQ = @[xter_tro_sub_seq]" ).append("\n"); 
		query.append("WHERE BKG_NO      = @[bkg_no]" ).append("\n"); 
		query.append("  AND IO_BND_CD   = 'O'" ).append("\n"); 
		query.append("  AND RTN_TRO_FLG = 'N'" ).append("\n"); 
		query.append("  AND TRO_SEQ     = @[tro_seq]" ).append("\n"); 
		query.append("  AND TRO_SUB_SEQ = @[tro_sub_seq]" ).append("\n"); 
		query.append("  AND TRO_SEQ IN (SELECT TRO_SEQ " ).append("\n"); 
		query.append("					FROM BKG_TRO " ).append("\n"); 
		query.append("				   WHERE BKG_NO      = @[bkg_no]" ).append("\n"); 
		query.append("					 AND IO_BND_CD   = 'O'" ).append("\n"); 
		query.append("					 AND RTN_TRO_FLG = 'N'" ).append("\n"); 
		query.append("					 AND TRO_SEQ     = @[tro_seq]" ).append("\n"); 
		query.append("					 AND NVL(CXL_FLG, 'N') = 'N')" ).append("\n"); 

	}
}