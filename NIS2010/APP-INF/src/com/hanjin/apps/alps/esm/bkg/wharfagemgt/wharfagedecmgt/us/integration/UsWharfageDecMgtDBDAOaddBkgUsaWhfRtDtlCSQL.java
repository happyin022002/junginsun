/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : UsWharfageDecMgtDBDAOaddBkgUsaWhfRtDtlCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.28
*@LastModifier : 김민정
*@LastVersion : 1.0
* 2009.08.28 김민정
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.wharfagemgt.wharfagedecmgt.us.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Kim Minjung
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class UsWharfageDecMgtDBDAOaddBkgUsaWhfRtDtlCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * addBkgUsaWhfRtDtl
	  * </pre>
	  */
	public UsWharfageDecMgtDBDAOaddBkgUsaWhfRtDtlCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eff_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("usa_whf_trsp_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("whf_ut_prc",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("upd_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("full_mty_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("usa_whf_rat_ut_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("usa_whf_expt_flg",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.wharfagemgt.wharfagedecmgt.us.integration").append("\n"); 
		query.append("FileName : UsWharfageDecMgtDBDAOaddBkgUsaWhfRtDtlCSQL").append("\n"); 
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
		query.append("MERGE INTO BKG_USA_WHF_RT_DTL" ).append("\n"); 
		query.append("USING DUAL" ).append("\n"); 
		query.append("ON (" ).append("\n"); 
		query.append("PORT_CD = @[port_cd]" ).append("\n"); 
		query.append("AND IO_BND_CD = @[io_bnd_cd]" ).append("\n"); 
		query.append("AND TO_CHAR(EFF_DT, 'YYYYMMDD') = @[eff_dt]" ).append("\n"); 
		query.append("AND USA_WHF_RAT_UT_CD = @[usa_whf_rat_ut_cd]" ).append("\n"); 
		query.append("AND FULL_MTY_CD = @[full_mty_cd]" ).append("\n"); 
		query.append("AND USA_WHF_TRSP_TP_CD = @[usa_whf_trsp_tp_cd]" ).append("\n"); 
		query.append("AND USA_WHF_EXPT_FLG = @[usa_whf_expt_flg]" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("WHEN NOT MATCHED THEN" ).append("\n"); 
		query.append("INSERT" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("PORT_CD" ).append("\n"); 
		query.append(",	IO_BND_CD" ).append("\n"); 
		query.append(",	EFF_DT" ).append("\n"); 
		query.append(",   RT_SEQ" ).append("\n"); 
		query.append(",   USA_WHF_RAT_UT_CD" ).append("\n"); 
		query.append(",   FULL_MTY_CD" ).append("\n"); 
		query.append(",   USA_WHF_TRSP_TP_CD" ).append("\n"); 
		query.append(",   USA_WHF_EXPT_FLG" ).append("\n"); 
		query.append(",   WHF_UT_PRC" ).append("\n"); 
		query.append(",	CRE_USR_ID" ).append("\n"); 
		query.append(",	UPD_USR_ID" ).append("\n"); 
		query.append(") VALUES(" ).append("\n"); 
		query.append("@[port_cd]" ).append("\n"); 
		query.append(",	@[io_bnd_cd]" ).append("\n"); 
		query.append(",	TO_DATE(@[eff_dt], 'YYYYMMDD')" ).append("\n"); 
		query.append(",	(SELECT NVL(MAX(RT_SEQ), 0) + 1" ).append("\n"); 
		query.append("FROM BKG_USA_WHF_RT_DTL" ).append("\n"); 
		query.append("WHERE PORT_CD = @[port_cd]" ).append("\n"); 
		query.append("AND IO_BND_CD = @[io_bnd_cd]" ).append("\n"); 
		query.append("AND TO_CHAR(EFF_DT,'YYYYMMDD') = @[eff_dt]" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append(",	@[usa_whf_rat_ut_cd]" ).append("\n"); 
		query.append(",	@[full_mty_cd]" ).append("\n"); 
		query.append(",	@[usa_whf_trsp_tp_cd]" ).append("\n"); 
		query.append(",	@[usa_whf_expt_flg]" ).append("\n"); 
		query.append(",	@[whf_ut_prc]" ).append("\n"); 
		query.append(",	@[upd_usr_id]" ).append("\n"); 
		query.append(",	@[upd_usr_id]" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("WHEN MATCHED THEN" ).append("\n"); 
		query.append("UPDATE" ).append("\n"); 
		query.append("SET UPD_DT = SYSDATE" ).append("\n"); 
		query.append(",UPD_USR_ID = @[upd_usr_id]" ).append("\n"); 
		query.append(",WHF_UT_PRC = @[whf_ut_prc]" ).append("\n"); 

	}
}