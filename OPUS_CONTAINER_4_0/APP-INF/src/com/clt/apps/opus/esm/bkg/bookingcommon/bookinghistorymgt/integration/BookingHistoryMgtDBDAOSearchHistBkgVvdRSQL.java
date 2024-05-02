/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : BookingHistoryMgtDBDAOSearchHistBkgVvdRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.01.26
*@LastModifier : 류대영
*@LastVersion : 1.0
* 2010.01.26 류대영
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingcommon.bookinghistorymgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Dae-Young RYU
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BookingHistoryMgtDBDAOSearchHistBkgVvdRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * BookingHistoryMgtDBDAOSearchHistBkgVvdRSQL
	  * </pre>
	  */
	public BookingHistoryMgtDBDAOSearchHistBkgVvdRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_lodg_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pol_yd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_pre_pst_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pod_yd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_trsp_mzd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("skd_dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pol_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("slan_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("op_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rev_vvd_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pod_clpt_ind_seq",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("pol_clpt_ind_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("skd_voy_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.bookingcommon.bookinghistorymgt.integration").append("\n"); 
		query.append("FileName : BookingHistoryMgtDBDAOSearchHistBkgVvdRSQL").append("\n"); 
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
		query.append("WITH OLD AS" ).append("\n"); 
		query.append("(SELECT @[bkg_no] BKG_NO" ).append("\n"); 
		query.append(", @[vsl_pre_pst_cd] VSL_PRE_PST_CD" ).append("\n"); 
		query.append(", @[vsl_seq] VSL_SEQ" ).append("\n"); 
		query.append(", @[slan_cd] SLAN_CD" ).append("\n"); 
		query.append(", @[vsl_cd] VSL_CD" ).append("\n"); 
		query.append(", @[skd_voy_no] SKD_VOY_NO" ).append("\n"); 
		query.append(", @[skd_dir_cd] SKD_DIR_CD" ).append("\n"); 
		query.append(", @[pol_clpt_ind_seq] POL_CLPT_IND_SEQ" ).append("\n"); 
		query.append(", @[op_cd] OP_CD" ).append("\n"); 
		query.append(", @[pol_cd] POL_CD" ).append("\n"); 
		query.append(", @[pol_yd_cd] POL_YD_CD" ).append("\n"); 
		query.append(", @[pod_cd] POD_CD" ).append("\n"); 
		query.append(", @[pod_yd_cd] POD_YD_CD" ).append("\n"); 
		query.append(", @[bkg_trsp_mzd_cd] BKG_TRSP_MZD_CD" ).append("\n"); 
		query.append(", @[cntr_lodg_flg] CNTR_LODG_FLG" ).append("\n"); 
		query.append(", @[rev_vvd_flg] REV_VVD_FLG" ).append("\n"); 
		query.append(", @[pod_clpt_ind_seq] POD_CLPT_IND_SEQ" ).append("\n"); 
		query.append("FROM DUAL)" ).append("\n"); 
		query.append("SELECT HIS_CATE_NM" ).append("\n"); 
		query.append(", PRE_CTNT" ).append("\n"); 
		query.append(", CRNT_CTNT" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT 'VVD' HIS_CATE_NM" ).append("\n"); 
		query.append(", (SELECT INTG_CD_VAL_DP_DESC FROM COM_INTG_CD_DTL WHERE INTG_CD_ID = 'CD01233' AND OLD.VSL_PRE_PST_CD = INTG_CD_VAL_CTNT)||" ).append("\n"); 
		query.append("'/'||OLD.SLAN_CD||" ).append("\n"); 
		query.append("'/'||OLD.VSL_CD||OLD.SKD_VOY_NO||OLD.SKD_DIR_CD||" ).append("\n"); 
		query.append("'/'||OLD.POL_YD_CD||" ).append("\n"); 
		query.append("'/'||OLD.POD_YD_CD PRE_CTNT" ).append("\n"); 
		query.append(", (SELECT INTG_CD_VAL_DP_DESC FROM COM_INTG_CD_DTL WHERE INTG_CD_ID = 'CD01233' AND NOW.VSL_PRE_PST_CD = INTG_CD_VAL_CTNT)||" ).append("\n"); 
		query.append("'/'||NOW.SLAN_CD||" ).append("\n"); 
		query.append("'/'||NOW.VSL_CD||NOW.SKD_VOY_NO||NOW.SKD_DIR_CD||" ).append("\n"); 
		query.append("'/'||NOW.POL_YD_CD||" ).append("\n"); 
		query.append("'/'||NOW.POD_YD_CD CRNT_CTNT" ).append("\n"); 
		query.append("FROM OLD" ).append("\n"); 
		query.append("#if (${ca_flg} == 'Y')" ).append("\n"); 
		query.append(", BKG_VVD_HIS NOW" ).append("\n"); 
		query.append("WHERE NOW.BKG_NO(+)         = OLD.BKG_NO" ).append("\n"); 
		query.append("AND NOW.CORR_NO(+)        = 'TMP0000001'" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append(", BKG_VVD NOW" ).append("\n"); 
		query.append("WHERE NOW.BKG_NO(+)         = OLD.BKG_NO" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("AND NOW.VSL_PRE_PST_CD(+) = OLD.VSL_PRE_PST_CD" ).append("\n"); 
		query.append("AND NOW.VSL_SEQ(+)        = OLD.VSL_SEQ" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("WHERE NVL(TRIM(PRE_CTNT), ' ') <> NVL(TRIM(CRNT_CTNT), ' ')" ).append("\n"); 

	}
}