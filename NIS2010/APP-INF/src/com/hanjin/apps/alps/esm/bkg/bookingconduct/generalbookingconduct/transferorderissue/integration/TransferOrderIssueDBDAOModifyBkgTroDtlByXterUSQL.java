/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : TransferOrderIssueDBDAOModifyBkgTroDtlByXterUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.12.13
*@LastModifier : 
*@LastVersion : 1.0
* 2017.12.13 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.transferorderissue.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
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
		params.put("rtn_yd_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cntr_tpsz_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("dor_arr_dt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("tro_sub_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.transferorderissue.integration").append("\n"); 
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
		query.append(",	TRO_QTY      = @[tro_qty]" ).append("\n"); 
		query.append("#if (${dor_arr_dt} != '') " ).append("\n"); 
		query.append(",	DOR_ARR_DT = TO_DATE(@[dor_arr_dt], 'YYYY-MM-DD HH24:MI') " ).append("\n"); 
		query.append("#else " ).append("\n"); 
		query.append(",	DOR_ARR_DT = @[dor_arr_dt]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(",	PKUP_LOC_CD = nvl(@[pkup_loc_cd], (select substr(MTY_PKUP_YD_CD, 1, 5) from bkg_booking where bkg_no = @[bkg_no]))" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${pkup_yd_cd} != '') " ).append("\n"); 
		query.append(",	PKUP_YD_CD = @[pkup_loc_cd]||@[pkup_yd_cd]" ).append("\n"); 
		query.append("#else " ).append("\n"); 
		query.append(",	PKUP_YD_CD = nvl(@[pkup_yd_cd], (select MTY_PKUP_YD_CD from bkg_booking where bkg_no = @[bkg_no]))" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(",	RTN_LOC_CD = nvl(@[rtn_loc_cd], (select substr(FULL_RTN_YD_CD, 1, 5) from bkg_booking where bkg_no = @[bkg_no]))" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${rtn_yd_cd} != '') " ).append("\n"); 
		query.append(",	RTN_YD_CD = @[rtn_loc_cd]||@[rtn_yd_cd]" ).append("\n"); 
		query.append("#else " ).append("\n"); 
		query.append(",	RTN_YD_CD = nvl(@[rtn_yd_cd], (select FULL_RTN_YD_CD from bkg_booking where bkg_no = @[bkg_no]))" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("--,	CNTR_NO" ).append("\n"); 
		query.append("--,	CMDT_CD" ).append("\n"); 
		query.append("--,	PCTL_NO" ).append("\n"); 
		query.append(",	UPD_USR_ID = @[upd_usr_id]" ).append("\n"); 
		query.append(",	UPD_DT = sysdate " ).append("\n"); 
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