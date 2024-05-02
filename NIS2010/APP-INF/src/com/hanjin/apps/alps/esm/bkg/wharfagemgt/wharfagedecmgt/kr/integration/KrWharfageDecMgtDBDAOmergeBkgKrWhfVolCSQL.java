/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : KrWharfageDecMgtDBDAOmergeBkgKrWhfVolCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.06.18
*@LastModifier : 
*@LastVersion : 1.0
* 2010.06.18 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.wharfagemgt.wharfagedecmgt.kr.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class KrWharfageDecMgtDBDAOmergeBkgKrWhfVolCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * mergeBkgKrWhfVol
	  * </pre>
	  */
	public KrWharfageDecMgtDBDAOmergeBkgKrWhfVolCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("io_port_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("unld_agn_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("whf_rt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("tml_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sail_dt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("arr_yr",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("whf_vol_dc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("port_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_call_sgn_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("arr_tms_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("unld_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("mf_ref_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("whf_pay_dt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("whf_bnd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.wharfagemgt.wharfagedecmgt.kr.integration").append("\n"); 
		query.append("FileName : KrWharfageDecMgtDBDAOmergeBkgKrWhfVolCSQL").append("\n"); 
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
		query.append("MERGE INTO BKG_KR_WHF_VOL A" ).append("\n"); 
		query.append("USING DUAL" ).append("\n"); 
		query.append("ON ( ( @[vsl_cd]  || @[skd_voy_no] || @[skd_dir_cd] || @[port_cd] || @[whf_bnd_cd] ) = (A.VSL_CD || A.SKD_VOY_NO || A.SKD_DIR_CD || A.PORT_CD || A.WHF_BND_CD) )" ).append("\n"); 
		query.append("WHEN MATCHED THEN" ).append("\n"); 
		query.append("UPDATE SET" ).append("\n"); 
		query.append(" A.CALL_SGN_NO     = @[vsl_call_sgn_cd]" ).append("\n"); 
		query.append(",A.UNLD_AGN_ID     = @[unld_agn_cd]" ).append("\n"); 
		query.append(",A.TML_CD          = @[tml_cd]" ).append("\n"); 
		query.append(",A.WHF_RT          = @[whf_rt]" ).append("\n"); 
		query.append(",A.ARR_YR          = @[arr_yr]" ).append("\n"); 
		query.append(",A.ARR_TMS_NO      = @[arr_tms_no]" ).append("\n"); 
		query.append(",A.UNLD_TP_CD      = @[unld_tp_cd]" ).append("\n"); 
		query.append(",A.BRTH_CD         = @[io_port_cd]" ).append("\n"); 
		query.append(",A.WHF_PAY_DT      = @[whf_pay_dt]" ).append("\n"); 
		query.append(",A.PAY_DT      	   = @[whf_pay_dt]" ).append("\n"); 
		query.append(",A.WHF_VOL_DC_CD   = @[whf_vol_dc_cd]" ).append("\n"); 
		query.append(",A.PORT_NM         = @[port_nm]" ).append("\n"); 
		query.append(",A.MF_REF_NO       = @[mf_ref_no]" ).append("\n"); 
		query.append(",A.SAIL_DT         = @[sail_dt]" ).append("\n"); 
		query.append(",A.UPD_USR_ID      = @[upd_usr_id]" ).append("\n"); 
		query.append(",A.UPD_DT          = SYSDATE" ).append("\n"); 
		query.append("WHEN NOT MATCHED THEN" ).append("\n"); 
		query.append("INSERT" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append(" A.VSL_CD" ).append("\n"); 
		query.append(",A.SKD_VOY_NO" ).append("\n"); 
		query.append(",A.SKD_DIR_CD" ).append("\n"); 
		query.append(",A.PORT_CD" ).append("\n"); 
		query.append(",A.WHF_BND_CD" ).append("\n"); 
		query.append(",A.CALL_SGN_NO" ).append("\n"); 
		query.append(",A.UNLD_AGN_ID" ).append("\n"); 
		query.append(",A.TML_CD" ).append("\n"); 
		query.append(",A.WHF_RT" ).append("\n"); 
		query.append(",A.ARR_YR" ).append("\n"); 
		query.append(",A.ARR_TMS_NO" ).append("\n"); 
		query.append(",A.UNLD_TP_CD" ).append("\n"); 
		query.append(",A.BRTH_CD" ).append("\n"); 
		query.append(",A.WHF_PAY_DT" ).append("\n"); 
		query.append(",A.VSL_NM" ).append("\n"); 
		query.append(",A.PAY_DT" ).append("\n"); 
		query.append(",A.WHF_VOL_DC_CD" ).append("\n"); 
		query.append(",A.PORT_NM" ).append("\n"); 
		query.append(",A.MF_REF_NO" ).append("\n"); 
		query.append(",A.SAIL_DT" ).append("\n"); 
		query.append(",A.CRE_USR_ID" ).append("\n"); 
		query.append(",A.CRE_DT" ).append("\n"); 
		query.append(",A.UPD_USR_ID" ).append("\n"); 
		query.append(",A.UPD_DT" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("VALUES" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append(" @[vsl_cd]" ).append("\n"); 
		query.append(",@[skd_voy_no]" ).append("\n"); 
		query.append(",@[skd_dir_cd]" ).append("\n"); 
		query.append(",@[port_cd]" ).append("\n"); 
		query.append(",@[whf_bnd_cd]" ).append("\n"); 
		query.append(",@[vsl_call_sgn_cd]" ).append("\n"); 
		query.append(",@[unld_agn_cd]" ).append("\n"); 
		query.append(",@[tml_cd]" ).append("\n"); 
		query.append(",@[whf_rt]" ).append("\n"); 
		query.append(",@[arr_yr]" ).append("\n"); 
		query.append(",@[arr_tms_no]" ).append("\n"); 
		query.append(",@[unld_tp_cd]" ).append("\n"); 
		query.append(",@[io_port_cd]" ).append("\n"); 
		query.append(",@[whf_pay_dt]" ).append("\n"); 
		query.append(",DECODE(TRIM(@[vsl_nm]), NULL, " ).append("\n"); 
		query.append("		(SELECT VSL_ENG_NM FROM MDM_VSL_CNTR" ).append("\n"); 
		query.append("           WHERE VSL_CD = @[vsl_cd]),@[vsl_nm])" ).append("\n"); 
		query.append(",@[whf_pay_dt]" ).append("\n"); 
		query.append(",@[whf_vol_dc_cd]" ).append("\n"); 
		query.append(",@[port_nm]" ).append("\n"); 
		query.append(",@[mf_ref_no]" ).append("\n"); 
		query.append(",@[sail_dt]" ).append("\n"); 
		query.append(",@[cre_usr_id]" ).append("\n"); 
		query.append(",SYSDATE" ).append("\n"); 
		query.append(",@[upd_usr_id]" ).append("\n"); 
		query.append(",SYSDATE" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}