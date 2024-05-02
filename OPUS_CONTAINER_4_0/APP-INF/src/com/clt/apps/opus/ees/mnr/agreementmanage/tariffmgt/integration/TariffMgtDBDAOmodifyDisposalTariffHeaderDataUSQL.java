/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : TariffMgtDBDAOmodifyDisposalTariffHeaderDataUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.02.08
*@LastModifier : 권영법
*@LastVersion : 1.0
* 2010.02.08 권영법
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.mnr.agreementmanage.tariffmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author YoungBuebKwon
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TariffMgtDBDAOmodifyDisposalTariffHeaderDataUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 수정
	  * </pre>
	  */
	public TariffMgtDBDAOmodifyDisposalTariffHeaderDataUSQL(){
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
		params.put("mnr_inp_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mnr_disp_trf_sts_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("eq_knd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mnr_trf_rmk",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mnr_disp_trf_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mnr_disp_trf_lst_ver_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mnr_disp_trf_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.mnr.agreementmanage.tariffmgt.integration").append("\n"); 
		query.append("FileName : TariffMgtDBDAOmodifyDisposalTariffHeaderDataUSQL").append("\n"); 
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
		query.append("UPDATE MNR_DISP_TRF_HDR A" ).append("\n"); 
		query.append("SET A.EFF_DT = TO_DATE(@[eff_dt], 'yyyy-mm-dd')" ).append("\n"); 
		query.append(",A.EQ_KND_CD = @[eq_knd_cd]" ).append("\n"); 
		query.append(",A.MNR_DISP_TRF_TP_CD = @[mnr_disp_trf_tp_cd]" ).append("\n"); 
		query.append(",A.MNR_INP_TP_CD = @[mnr_inp_tp_cd]" ).append("\n"); 
		query.append(",MNR_DISP_TRF_STS_CD =@[mnr_disp_trf_sts_cd]" ).append("\n"); 
		query.append(",MNR_DISP_TRF_STS_DT = SYSDATE" ).append("\n"); 
		query.append(",MNR_TRF_RMK = @[mnr_trf_rmk]" ).append("\n"); 
		query.append(",MNR_DISP_TRF_LST_VER_FLG = @[mnr_disp_trf_lst_ver_flg]" ).append("\n"); 
		query.append(",UPD_USR_ID = @[upd_usr_id]" ).append("\n"); 
		query.append(",UPD_DT =SYSDATE" ).append("\n"); 
		query.append("WHERE A.MNR_DISP_TRF_SEQ = @[mnr_disp_trf_seq]" ).append("\n"); 

	}
}