/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : IndiaManifestListDownloadDBDAOaddIgmVesselCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.12.19
*@LastModifier : 이경원
*@LastVersion : 1.0
* 2011.12.19 이경원
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.india.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Lee KyungWon
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class IndiaManifestListDownloadDBDAOaddIgmVesselCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * addIgmVessel
	  * </pre>
	  */
	public IndiaManifestListDownloadDBDAOaddIgmVesselCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("ida_voy_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ida_port_gnte_dt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("upd_usr_id",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("vsl_decl_dt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("ibd_no",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("ida_port_gnte_no",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("ida_vsl_imo_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ida_tml_opr_no",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("arr_dt2",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ida_cstms_hus_no",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("vsl_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("crr_agn_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.india.integration").append("\n"); 
		query.append("FileName : IndiaManifestListDownloadDBDAOaddIgmVesselCSQL").append("\n"); 
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
		query.append("INSERT INTO bkg_cstms_ida_vsl (" ).append("\n"); 
		query.append("VSL_CD" ).append("\n"); 
		query.append(",	SKD_VOY_NO" ).append("\n"); 
		query.append(",	SKD_DIR_CD" ).append("\n"); 
		query.append(",	POD_CD" ).append("\n"); 
		query.append(",	IDA_DECL_VSL_NO" ).append("\n"); 
		query.append(",	VSL_DECL_DT" ).append("\n"); 
		query.append(",	VSL_NM" ).append("\n"); 
		query.append(",	CALL_SGN_NO" ).append("\n"); 
		query.append(",	IDA_LINE_NO" ).append("\n"); 
		query.append(",	IDA_AGN_ID" ).append("\n"); 
		query.append(",	CNT_CD" ).append("\n"); 
		query.append(",	OTR_DCHG_YD_ID" ).append("\n"); 
		query.append(",	ARR_DT" ).append("\n"); 
		query.append(",	ARR_DT2" ).append("\n"); 
		query.append(",	IBD_NO" ).append("\n"); 
		query.append(",	CRR_AGN_ID" ).append("\n"); 
		query.append(",	IDA_MRN_LINE_OPR_ID" ).append("\n"); 
		query.append(",	IDA_CFS_ID" ).append("\n"); 
		query.append(",	BD_AREA_CD" ).append("\n"); 
		query.append(",	IDA_VOY_NO" ).append("\n"); 
		query.append(",	IDA_YR_NO" ).append("\n"); 
		query.append(",	TRNS_OPR_ID" ).append("\n"); 
		query.append(",	CRE_USR_ID" ).append("\n"); 
		query.append(",	CRE_DT" ).append("\n"); 
		query.append(",	UPD_USR_ID" ).append("\n"); 
		query.append(",	UPD_DT" ).append("\n"); 
		query.append(",   IDA_VSL_IMO_NO" ).append("\n"); 
		query.append(",   IDA_CSTMS_HUS_NO" ).append("\n"); 
		query.append(",   IDA_TML_OPR_NO" ).append("\n"); 
		query.append(",	IDA_PORT_GNTE_NO" ).append("\n"); 
		query.append(",	IDA_PORT_GNTE_DT" ).append("\n"); 
		query.append(") VALUES(" ).append("\n"); 
		query.append("SUBSTR(@[vvd_cd], 1, 4)" ).append("\n"); 
		query.append(",	SUBSTR(@[vvd_cd], 5, 4)" ).append("\n"); 
		query.append(",	SUBSTR(@[vvd_cd], 9, 1)" ).append("\n"); 
		query.append(",	@[pod_cd]" ).append("\n"); 
		query.append(",	@[ida_decl_vsl_no]" ).append("\n"); 
		query.append(",	TO_DATE(@[vsl_decl_dt], 'YYYYMMDD')" ).append("\n"); 
		query.append(",	@[vsl_nm]" ).append("\n"); 
		query.append(",	@[call_sgn_no]" ).append("\n"); 
		query.append(",	@[ida_line_no]" ).append("\n"); 
		query.append(",	@[ida_agn_id]" ).append("\n"); 
		query.append(",	@[cnt_cd]" ).append("\n"); 
		query.append(",	@[port_cd]" ).append("\n"); 
		query.append(",	TO_DATE(@[arr_dt], 'YYYYMMDD')" ).append("\n"); 
		query.append(",	TO_DATE(@[arr_dt2], 'YYYYMMDD')" ).append("\n"); 
		query.append(",	@[ibd_no]" ).append("\n"); 
		query.append(",	@[crr_agn_cd]" ).append("\n"); 
		query.append(",	@[ida_mrn_line_opr_cd]" ).append("\n"); 
		query.append(",	@[ida_cfs_id]" ).append("\n"); 
		query.append(",	@[bd_area_cd]" ).append("\n"); 
		query.append(",	@[ida_voy_no]" ).append("\n"); 
		query.append(",	@[ida_yr_no]" ).append("\n"); 
		query.append(",	@[trns_opr_id]" ).append("\n"); 
		query.append(",	@[cre_usr_id]" ).append("\n"); 
		query.append(",	SYSDATE" ).append("\n"); 
		query.append(",	@[upd_usr_id]" ).append("\n"); 
		query.append(",	SYSDATE" ).append("\n"); 
		query.append(",   @[ida_vsl_imo_no]" ).append("\n"); 
		query.append(",   @[ida_cstms_hus_no]" ).append("\n"); 
		query.append(",   @[ida_tml_opr_no]" ).append("\n"); 
		query.append(",	@[ida_port_gnte_no]" ).append("\n"); 
		query.append(",   @[ida_port_gnte_dt]" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}