/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : CLLCDLManifestDBDAOmodifyCllRfAkCgoFlagUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.02.11
*@LastModifier : 
*@LastVersion : 1.0
* 2015.02.11 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.terminaldocumentation.cllcdlmanifest.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CLLCDLManifestDBDAOmodifyCllRfAkCgoFlagUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * CLLCDLManifestDBDAOmodifyCllRfAkCgoFlag
	  * </pre>
	  */
	public CLLCDLManifestDBDAOmodifyCllRfAkCgoFlagUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ovr_bkwd_len",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cdo_temp",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("clpt_ind_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ovr_hgt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("ovr_wgt_ut_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fdo_temp",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("awk_cgo_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rc_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ovr_cntr_wgt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_vent_rto",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cntr_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ovr_sd_len",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_lodg_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ovr_fwrd_len",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("ovr_port_len",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.terminaldocumentation.cllcdlmanifest.integration").append("\n"); 
		query.append("FileName : CLLCDLManifestDBDAOmodifyCllRfAkCgoFlagUSQL").append("\n"); 
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
		query.append("UPDATE BKG_CSTMS_TML_CLL" ).append("\n"); 
		query.append("SET	OVR_FWRD_LEN	= NVL(@[ovr_fwrd_len],0)," ).append("\n"); 
		query.append("	OVR_BKWD_LEN	= NVL(@[ovr_bkwd_len],0)," ).append("\n"); 
		query.append("	OVR_HGT		= NVL(@[ovr_hgt],0)," ).append("\n"); 
		query.append("	OVR_PORT_LEN	= NVL(@[ovr_port_len],0)," ).append("\n"); 
		query.append("	OVR_SD_LEN	= NVL(@[ovr_sd_len],0)," ).append("\n"); 
		query.append("	OVR_WGT_UT_CD	= @[ovr_wgt_ut_cd]," ).append("\n"); 
		query.append("	OVR_CNTR_WGT	= NVL(@[ovr_cntr_wgt],0)," ).append("\n"); 
		query.append("	FDO_TEMP	= NVL(@[fdo_temp],0)," ).append("\n"); 
		query.append("	CDO_TEMP	= NVL(@[cdo_temp],0)," ).append("\n"); 
		query.append("	CNTR_VENT_RTO	= @[cntr_vent_rto]," ).append("\n"); 
		query.append("	UPD_USR_ID	= @[upd_usr_id]," ).append("\n"); 
		query.append("	UPD_DT = SYSDATE," ).append("\n"); 
		query.append("	RC_SEQ = NVL(@[rc_seq],0)," ).append("\n"); 
		query.append("	AWK_CGO_SEQ = NVL(@[awk_cgo_seq],0)," ).append("\n"); 
		query.append("	RC_FLG = DECODE(NVL(@[rc_seq],'N'),'N','N',0,'N','Y')," ).append("\n"); 
		query.append("	AWK_CGO_FLG = DECODE(NVL(@[awk_cgo_seq],'N'),'N','N',0,'N','Y')," ).append("\n"); 
		query.append("	DCGO_FLG = ( SELECT DECODE(COUNT(*),0,'N','Y') FROM BKG_CSTMS_TML_CLL_DG_CGO" ).append("\n"); 
		query.append("				  WHERE VSL_CD		= @[vsl_cd]" ).append("\n"); 
		query.append("                    AND	SKD_VOY_NO	= @[skd_voy_no]" ).append("\n"); 
		query.append("                    AND	SKD_DIR_CD	= @[skd_dir_cd]" ).append("\n"); 
		query.append("                    AND	PORT_CD		= @[port_cd]" ).append("\n"); 
		query.append("                    AND	BKG_NO		= @[bkg_no]" ).append("\n"); 
		query.append("                    AND	CNTR_NO	    = @[cntr_no]" ).append("\n"); 
		query.append("                    AND	CNTR_LODG_NO= @[cntr_lodg_no] )" ).append("\n"); 
		query.append("WHERE	VSL_CD		= @[vsl_cd]" ).append("\n"); 
		query.append("AND	SKD_VOY_NO	= @[skd_voy_no]" ).append("\n"); 
		query.append("AND	SKD_DIR_CD	= @[skd_dir_cd]" ).append("\n"); 
		query.append("AND	PORT_CD		= @[port_cd]" ).append("\n"); 
		query.append("#if (${clpt_ind_seq} != '')        " ).append("\n"); 
		query.append("  AND NVL(CLPT_IND_SEQ,'1') = @[clpt_ind_seq]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("AND	BKG_NO		= @[bkg_no]" ).append("\n"); 
		query.append("AND	CNTR_NO	= @[cntr_no]" ).append("\n"); 
		query.append("AND	CNTR_LODG_NO	= @[cntr_lodg_no]" ).append("\n"); 

	}
}