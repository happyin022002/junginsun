/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : TransferOrderIssueDBDAOAddBkgTroDtlCSQL.java
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

public class TransferOrderIssueDBDAOAddBkgTroDtlCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * TransferOrderIssueDB::AddBkgTroDtl
	  * </pre>
	  */
	public TransferOrderIssueDBDAOAddBkgTroDtlCSQL(){
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
		params.put("pctl_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.NUMERIC + ",N";
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
		params.put("dor_arr_dt_hhmi",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cmdt_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pkup_dt_hhmi",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("io_bnd_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cxl_flg",new String[]{arrTmp[0],arrTmp[1]});

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

		tmp = java.sql.Types.FLOAT + ",N";
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
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dor_arr_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.NUMERIC + ",N";
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
		params.put("rtn_loc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rtn_tro_flg",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.transferorderissue.integration").append("\n"); 
		query.append("FileName : TransferOrderIssueDBDAOAddBkgTroDtlCSQL").append("\n"); 
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
		query.append("INSERT INTO BKG_TRO_DTL (" ).append("\n"); 
		query.append("	BKG_NO" ).append("\n"); 
		query.append(",	IO_BND_CD" ).append("\n"); 
		query.append(",	RTN_TRO_FLG" ).append("\n"); 
		query.append(",	TRO_SEQ" ).append("\n"); 
		query.append(",	TRO_SUB_SEQ" ).append("\n"); 
		query.append(",	CNTR_TPSZ_CD" ).append("\n"); 
		query.append(",	TRO_QTY" ).append("\n"); 
		query.append(",	CNTR_NO" ).append("\n"); 
		query.append(",	DOR_ARR_DT" ).append("\n"); 
		query.append(",	PKUP_LOC_CD" ).append("\n"); 
		query.append(",	PKUP_YD_CD" ).append("\n"); 
		query.append(",	RTN_LOC_CD" ).append("\n"); 
		query.append(",	RTN_YD_CD" ).append("\n"); 
		query.append(",	CMDT_CD" ).append("\n"); 
		query.append(",	PCTL_NO" ).append("\n"); 
		query.append(",	CXL_FLG" ).append("\n"); 
		query.append(",	CRE_USR_ID" ).append("\n"); 
		query.append(",	CRE_DT" ).append("\n"); 
		query.append(",	UPD_USR_ID" ).append("\n"); 
		query.append(",	UPD_DT" ).append("\n"); 
		query.append(",	PKUP_DT" ).append("\n"); 
		query.append(",	XTER_TRO_SEQ" ).append("\n"); 
		query.append(",	XTER_TRO_SUB_SEQ" ).append("\n"); 
		query.append(") VALUES( " ).append("\n"); 
		query.append("	@[bkg_no]" ).append("\n"); 
		query.append(",	@[io_bnd_cd]" ).append("\n"); 
		query.append(",	@[rtn_tro_flg]" ).append("\n"); 
		query.append(",	@[tro_seq]" ).append("\n"); 
		query.append(",	@[tro_sub_seq]" ).append("\n"); 
		query.append(",	@[cntr_tpsz_cd]" ).append("\n"); 
		query.append(",	NVL(DECODE(@[tro_qty], '0', '1', @[tro_qty]), '1')" ).append("\n"); 
		query.append(",	@[cntr_no]" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${dor_arr_dt} != '') " ).append("\n"); 
		query.append(",	TO_DATE(@[dor_arr_dt]||' '||@[dor_arr_dt_hhmi], 'YYYY-MM-DD HH24:MI') " ).append("\n"); 
		query.append("#else " ).append("\n"); 
		query.append(",   @[dor_arr_dt]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(",	nvl(@[pkup_loc_cd], (select substr(MTY_PKUP_YD_CD, 1, 5) from bkg_booking where bkg_no = @[bkg_no]))" ).append("\n"); 
		query.append("#if (${pkup_yd_cd} != '') " ).append("\n"); 
		query.append(",	@[pkup_loc_cd]||@[pkup_yd_cd]" ).append("\n"); 
		query.append("#else " ).append("\n"); 
		query.append(",   nvl(@[pkup_yd_cd], (select MTY_PKUP_YD_CD from bkg_booking where bkg_no = @[bkg_no]))" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(",	nvl(@[rtn_loc_cd], (select substr(FULL_RTN_YD_CD, 1, 5) from bkg_booking where bkg_no = @[bkg_no]))" ).append("\n"); 
		query.append("#if (${rtn_yd_cd} != '') " ).append("\n"); 
		query.append(",	@[rtn_loc_cd]||@[rtn_yd_cd]" ).append("\n"); 
		query.append("#else " ).append("\n"); 
		query.append(",   nvl(@[rtn_yd_cd], (select FULL_RTN_YD_CD from bkg_booking where bkg_no = @[bkg_no]))" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(",	@[cmdt_cd]" ).append("\n"); 
		query.append(",	@[pctl_no]" ).append("\n"); 
		query.append(",	@[cxl_flg]" ).append("\n"); 
		query.append(",	@[cre_usr_id]" ).append("\n"); 
		query.append(",	sysdate " ).append("\n"); 
		query.append(",	@[upd_usr_id]" ).append("\n"); 
		query.append(",	sysdate " ).append("\n"); 
		query.append("#if (${pkup_dt} != '') " ).append("\n"); 
		query.append(",	TO_DATE(@[pkup_dt]||' '||@[pkup_dt_hhmi], 'YYYY-MM-DD HH24:MI') " ).append("\n"); 
		query.append("#else " ).append("\n"); 
		query.append(",   @[pkup_dt]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(",	@[xter_tro_seq]" ).append("\n"); 
		query.append(",	@[xter_tro_sub_seq]" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}