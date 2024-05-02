/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : GeneralBookingReceiptDBDAOAddBkgVvdCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.01.13
*@LastModifier : 
*@LastVersion : 1.0
* 2017.01.13 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class GeneralBookingReceiptDBDAOAddBkgVvdCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * BKG VVD 저장
	  * </pre>
	  */
	public GeneralBookingReceiptDBDAOAddBkgVvdCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("vsl_pre_pst_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("upd_usr_id",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("pod_yd_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("source_bkg_no",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("bkg_trsp_mzd_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.NUMERIC + ",N";
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
		params.put("cntr_lodg_flg",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("skd_dir_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("pol_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rev_vvd_flg",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.integration").append("\n"); 
		query.append("FileName : GeneralBookingReceiptDBDAOAddBkgVvdCSQL").append("\n"); 
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
		query.append("#if (${ca_flg}== 'Y')" ).append("\n"); 
		query.append("INSERT INTO BKG_VVD_HIS (" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("INSERT INTO BKG_VVD (" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("	BKG_NO" ).append("\n"); 
		query.append("#if (${ca_flg}== 'Y')" ).append("\n"); 
		query.append(",   CORR_NO" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(",	VSL_PRE_PST_CD" ).append("\n"); 
		query.append(",	VSL_SEQ" ).append("\n"); 
		query.append(",	SLAN_CD" ).append("\n"); 
		query.append(",	VSL_CD" ).append("\n"); 
		query.append(",	SKD_VOY_NO" ).append("\n"); 
		query.append(",	SKD_DIR_CD" ).append("\n"); 
		query.append(",	POD_CLPT_IND_SEQ" ).append("\n"); 
		query.append(",	POL_CLPT_IND_SEQ" ).append("\n"); 
		query.append(",	OP_CD" ).append("\n"); 
		query.append(",	POL_CD" ).append("\n"); 
		query.append(",	POL_YD_CD" ).append("\n"); 
		query.append(",	POD_CD" ).append("\n"); 
		query.append(",	POD_YD_CD" ).append("\n"); 
		query.append(",	BKG_TRSP_MZD_CD" ).append("\n"); 
		query.append(",	CNTR_LODG_FLG" ).append("\n"); 
		query.append(",	REV_VVD_FLG" ).append("\n"); 
		query.append(",	CRE_USR_ID" ).append("\n"); 
		query.append(",	CRE_DT" ).append("\n"); 
		query.append(",	UPD_USR_ID" ).append("\n"); 
		query.append(",	UPD_DT" ).append("\n"); 
		query.append(") VALUES( " ).append("\n"); 
		query.append("	@[bkg_no]" ).append("\n"); 
		query.append("#if (${ca_flg}== 'Y')" ).append("\n"); 
		query.append(",   'TMP0000001'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(",	@[vsl_pre_pst_cd]" ).append("\n"); 
		query.append(",	@[vsl_seq]" ).append("\n"); 
		query.append("#if (${split_flg} == 'Y') " ).append("\n"); 
		query.append(",	NVL((select vsl_slan_Cd from vsk_vsl_skd where vsl_cd = @[vsl_cd] and skd_voy_no = @[skd_voy_no] and skd_Dir_Cd = @[skd_dir_cd]), (SELECT SLAN_CD FROM BKG_VVD WHERE BKG_NO = @[source_bkg_no] AND VSL_PRE_PST_CD = @[vsl_pre_pst_cd]AND VSL_SEQ = @[vsl_seq]" ).append("\n"); 
		query.append("))--slan_cd" ).append("\n"); 
		query.append("#else " ).append("\n"); 
		query.append(",	(select vsl_slan_Cd from vsk_vsl_skd where vsl_cd = @[vsl_cd] and skd_voy_no = @[skd_voy_no] and skd_Dir_Cd = @[skd_dir_cd])--slan_cd" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(",	@[vsl_cd]" ).append("\n"); 
		query.append(",	@[skd_voy_no]" ).append("\n"); 
		query.append(",	@[skd_dir_cd]" ).append("\n"); 
		query.append(",	@[pod_clpt_ind_seq]" ).append("\n"); 
		query.append(",	@[pol_clpt_ind_seq]" ).append("\n"); 
		query.append(",	@[op_cd]" ).append("\n"); 
		query.append(",	@[pol_cd]" ).append("\n"); 
		query.append(",	@[pol_yd_cd]" ).append("\n"); 
		query.append(",	@[pod_cd]" ).append("\n"); 
		query.append(",	@[pod_yd_cd]" ).append("\n"); 
		query.append(",	@[bkg_trsp_mzd_cd]" ).append("\n"); 
		query.append(",	NVL(@[cntr_lodg_flg],'N')" ).append("\n"); 
		query.append(",	NVL(@[rev_vvd_flg],'N')" ).append("\n"); 
		query.append(",	@[cre_usr_id]" ).append("\n"); 
		query.append(",	SYSDATE" ).append("\n"); 
		query.append(",	@[upd_usr_id]" ).append("\n"); 
		query.append(",	SYSDATE" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}