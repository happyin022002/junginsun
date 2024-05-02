/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : IndiaManifestListDownloadDBDAOmodifyIgmVesselUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.03.15
*@LastModifier : 
*@LastVersion : 1.0
* 2010.03.15 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.india.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class IndiaManifestListDownloadDBDAOmodifyIgmVesselUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * modifyIgmVessel
	  * </pre>
	  */
	public IndiaManifestListDownloadDBDAOmodifyIgmVesselUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ida_line_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ida_mrn_line_opr_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("ibd_no",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("port_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bd_area_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ida_cfs_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ida_agn_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trns_opr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ida_voy_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("arr_dt2",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("vsl_nm",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("call_sgn_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ida_yr_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("crr_agn_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_decl_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ida_decl_vsl_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.india.integration").append("\n"); 
		query.append("FileName : IndiaManifestListDownloadDBDAOmodifyIgmVesselUSQL").append("\n"); 
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
		query.append("UPDATE BKG_CSTMS_IDA_VSL SET " ).append("\n"); 
		query.append("	IDA_DECL_VSL_NO = @[ida_decl_vsl_no] " ).append("\n"); 
		query.append(",	VSL_DECL_DT = TO_DATE(@[vsl_decl_dt], 'YYYYMMDD') " ).append("\n"); 
		query.append(",	VSL_NM = @[vsl_nm] " ).append("\n"); 
		query.append(",	CALL_SGN_NO = @[call_sgn_no] " ).append("\n"); 
		query.append(",	IDA_LINE_NO = @[ida_line_no] " ).append("\n"); 
		query.append(",	IDA_AGN_ID = @[crr_agn_cd]" ).append("\n"); 
		query.append(",	CNT_CD = @[cnt_cd] " ).append("\n"); 
		query.append(",	OTR_DCHG_YD_ID = @[port_cd] " ).append("\n"); 
		query.append(",	ARR_DT = TO_DATE(@[arr_dt], 'YYYYMMDD')  " ).append("\n"); 
		query.append(",	ARR_DT2 = TO_DATE(@[arr_dt2], 'YYYYMMDD')  " ).append("\n"); 
		query.append(",	IBD_NO = @[ibd_no] " ).append("\n"); 
		query.append(",	CRR_AGN_ID = @[ida_agn_id] " ).append("\n"); 
		query.append(",	IDA_MRN_LINE_OPR_ID = @[ida_mrn_line_opr_cd] " ).append("\n"); 
		query.append(",	IDA_CFS_ID = @[ida_cfs_id] " ).append("\n"); 
		query.append(",	BD_AREA_CD = @[bd_area_cd] " ).append("\n"); 
		query.append(",	IDA_VOY_NO = @[ida_voy_no] " ).append("\n"); 
		query.append(",	IDA_YR_NO = @[ida_yr_no] " ).append("\n"); 
		query.append(",	TRNS_OPR_ID = @[trns_opr_id] " ).append("\n"); 
		query.append(",	CRE_USR_ID = @[cre_usr_id] " ).append("\n"); 
		query.append(",	UPD_USR_ID = @[upd_usr_id] " ).append("\n"); 
		query.append(",	UPD_DT = SYSDATE " ).append("\n"); 
		query.append("WHERE	VSL_CD 		= SUBSTR(@[vvd_cd], 1, 4)" ).append("\n"); 
		query.append("AND	SKD_VOY_NO 	= SUBSTR(@[vvd_cd], 5, 4) " ).append("\n"); 
		query.append("AND	SKD_DIR_CD 	= SUBSTR(@[vvd_cd], 9, 1) " ).append("\n"); 
		query.append("AND	POD_CD 			= @[pod_cd]" ).append("\n"); 

	}
}