/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : RFAExceptionTariffMgtDBDAOModifyLastVersionProgUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.01.15
*@LastModifier : 
*@LastVersion : 1.0
* 2010.01.15 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.dmt.dmtexceptionmgt.rfaexceptiontariffmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class RFAExceptionTariffMgtDBDAOModifyLastVersionProgUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Before Booking Request 이력중 마지막 Prog 의 상태가 'Temp.Saved' 인 경우, 그 정보를 갱신하기 위한 쿼리
	  * </pre>
	  */
	public RFAExceptionTariffMgtDBDAOModifyLastVersionProgUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rfa_expt_mapg_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dmdt_expt_rqst_sts_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("upd_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rfa_expt_ver_seq",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("rfa_expt_dar_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("prog_rmk",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.dmt.dmtexceptionmgt.rfaexceptiontariffmgt.integration").append("\n"); 
		query.append("FileName : RFAExceptionTariffMgtDBDAOModifyLastVersionProgUSQL").append("\n"); 
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
		query.append("UPDATE	DMT_RFA_EXPT_TRF_PROG RFA_TRF_PROG SET" ).append("\n"); 
		query.append("UPD_USR_ID 			= @[upd_usr_id]" ).append("\n"); 
		query.append(",	UPD_DT 				= NVL(GLOBALDATE_PKG.TIME_LOCAL_OFC_FNC(@[upd_ofc_cd]), SYSDATE)" ).append("\n"); 
		query.append(",	UPD_OFC_CD 			= @[upd_ofc_cd]" ).append("\n"); 
		query.append(",	PROG_RMK			= @[prog_rmk]" ).append("\n"); 
		query.append("WHERE   RFA_EXPT_DAR_NO		= @[rfa_expt_dar_no]" ).append("\n"); 
		query.append("AND RFA_EXPT_MAPG_SEQ	= @[rfa_expt_mapg_seq]" ).append("\n"); 
		query.append("AND RFA_EXPT_VER_SEQ	= @[rfa_expt_ver_seq]" ).append("\n"); 
		query.append("AND PROG_SEQ 			=" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT  /*+ INDEX_DESC(DMT_RFA_EXPT_TRF_PROG XPKDMT_RFA_EXPT_TRF_PROG) */ PROG_SEQ" ).append("\n"); 
		query.append("FROM    DMT_RFA_EXPT_TRF_PROG" ).append("\n"); 
		query.append("WHERE   RFA_EXPT_DAR_NO		= RFA_TRF_PROG.RFA_EXPT_DAR_NO" ).append("\n"); 
		query.append("AND RFA_EXPT_MAPG_SEQ 	= RFA_TRF_PROG.RFA_EXPT_MAPG_SEQ" ).append("\n"); 
		query.append("AND RFA_EXPT_VER_SEQ	= RFA_TRF_PROG.RFA_EXPT_VER_SEQ" ).append("\n"); 
		query.append("AND ROWNUM          	= 1" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("AND DMDT_EXPT_RQST_STS_CD = @[dmdt_expt_rqst_sts_cd]" ).append("\n"); 

	}
}