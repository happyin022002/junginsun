/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : TariffMgtDBDAOaddDisposalTariffDetailDataCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.17
*@LastModifier : 권영법
*@LastVersion : 1.0
* 2009.11.17 권영법
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

public class TariffMgtDBDAOaddDisposalTariffDetailDataCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 입력
	  * </pre>
	  */
	public TariffMgtDBDAOaddDisposalTariffDetailDataCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("curr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mnr_disp_trf_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("loc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mnr_vrfy_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("ctrl_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("temp_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mnr_disp_trf_grp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dtl_rmk",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eq_tpsz_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("mnr_disp_trf_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.mnr.agreementmanage.tariffmgt.integration").append("\n"); 
		query.append("FileName : TariffMgtDBDAOaddDisposalTariffDetailDataCSQL").append("\n"); 
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
		query.append("INSERT INTO MNR_DISP_TRF_DTL(" ).append("\n"); 
		query.append("MNR_DISP_TRF_SEQ" ).append("\n"); 
		query.append(",MNR_DISP_TRF_DTL_SEQ" ).append("\n"); 
		query.append(",MNR_DISP_TRF_GRP_CD" ).append("\n"); 
		query.append(",CTRL_OFC_CD" ).append("\n"); 
		query.append(",LOC_CD" ).append("\n"); 
		query.append(",CURR_CD" ).append("\n"); 
		query.append(",EQ_TPSZ_CD" ).append("\n"); 
		query.append(",MNR_DISP_TRF_AMT" ).append("\n"); 
		query.append(",MNR_VRFY_TP_CD" ).append("\n"); 
		query.append(",DTL_RMK" ).append("\n"); 
		query.append(",CRE_USR_ID" ).append("\n"); 
		query.append(",CRE_DT" ).append("\n"); 
		query.append(",UPD_USR_ID" ).append("\n"); 
		query.append(",UPD_DT" ).append("\n"); 
		query.append(")VALUES" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("@[mnr_disp_trf_seq]" ).append("\n"); 
		query.append(",(SELECT NVL(MAX(MNR_DISP_TRF_DTL_SEQ),0)+ @[temp_seq]" ).append("\n"); 
		query.append("FROM MNR_DISP_TRF_DTL" ).append("\n"); 
		query.append("WHERE MNR_DISP_TRF_SEQ= @[mnr_disp_trf_seq]" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append(",@[mnr_disp_trf_grp_cd]" ).append("\n"); 
		query.append(",@[ctrl_ofc_cd]" ).append("\n"); 
		query.append(",@[loc_cd]" ).append("\n"); 
		query.append(",@[curr_cd]" ).append("\n"); 
		query.append(",@[eq_tpsz_cd]" ).append("\n"); 
		query.append(",@[mnr_disp_trf_amt]" ).append("\n"); 
		query.append(",@[mnr_vrfy_tp_cd]" ).append("\n"); 
		query.append(",@[dtl_rmk]" ).append("\n"); 
		query.append(",@[cre_usr_id]" ).append("\n"); 
		query.append(",SYSDATE" ).append("\n"); 
		query.append(",@[upd_usr_id]" ).append("\n"); 
		query.append(",SYSDATE" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}