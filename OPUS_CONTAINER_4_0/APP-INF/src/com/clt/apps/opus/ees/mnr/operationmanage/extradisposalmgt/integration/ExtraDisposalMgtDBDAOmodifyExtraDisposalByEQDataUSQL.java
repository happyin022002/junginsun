/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ExtraDisposalMgtDBDAOmodifyExtraDisposalByEQDataUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.09
*@LastModifier : 김완규
*@LastVersion : 1.0
* 2009.09.09 김완규
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.mnr.operationmanage.extradisposalmgt.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author WanGyu Kim
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ExtraDisposalMgtDBDAOmodifyExtraDisposalByEQDataUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Scrapping/Donation Creation 에서 수정저장
	  * </pre>
	  */
	public ExtraDisposalMgtDBDAOmodifyExtraDisposalByEQDataUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("xtra_disp_expn_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("iss_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("xtra_disp_rmk",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("if_trc_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("iss_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("file_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("xtra_disp_sts_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("xtra_disp_incm_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("iss_yd_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("mnr_xtra_disp_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("xtra_disp_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("xtra_disp_desc",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("eq_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.mnr.operationmanage.extradisposalmgt.integration ").append("\n"); 
		query.append("FileName : ExtraDisposalMgtDBDAOmodifyExtraDisposalByEQDataUSQL").append("\n"); 
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
		query.append("UPDATE MNR_XTRA_DISP A" ).append("\n"); 
		query.append("SET A.EQ_TPSZ_CD = @[eq_tpsz_cd]" ).append("\n"); 
		query.append(",A.XTRA_DISP_STS_CD = @[xtra_disp_sts_cd]" ).append("\n"); 
		query.append(",A.MNR_XTRA_DISP_TP_CD = @[mnr_xtra_disp_tp_cd]" ).append("\n"); 
		query.append(",A.CURR_CD = @[curr_cd]" ).append("\n"); 
		query.append(",A.XTRA_DISP_EXPN_AMT = @[xtra_disp_expn_amt]" ).append("\n"); 
		query.append(",A.XTRA_DISP_INCM_AMT = @[xtra_disp_incm_amt]" ).append("\n"); 
		query.append(",A.ISS_DT = TO_DATE(@[iss_dt], 'yyyy-mm-dd')" ).append("\n"); 
		query.append(",A.ISS_OFC_CD = @[iss_ofc_cd]" ).append("\n"); 
		query.append(",A.ISS_YD_CD = @[iss_yd_cd]" ).append("\n"); 
		query.append(",A.XTRA_DISP_DESC = @[xtra_disp_desc]" ).append("\n"); 
		query.append(",A.XTRA_DISP_RMK = @[xtra_disp_rmk]" ).append("\n"); 
		query.append(",A.FILE_SEQ = @[file_seq]" ).append("\n"); 
		query.append(",A.IF_TRC_SEQ = @[if_trc_seq]" ).append("\n"); 
		query.append(",A.UPD_USR_ID = @[upd_usr_id]" ).append("\n"); 
		query.append(",A.UPD_DT = SYSDATE" ).append("\n"); 
		query.append("WHERE A.XTRA_DISP_SEQ = @[xtra_disp_seq]" ).append("\n"); 
		query.append("AND A.EQ_KND_CD = @[eq_knd_cd]" ).append("\n"); 
		query.append("AND A.EQ_NO = @[eq_no]" ).append("\n"); 

	}
}