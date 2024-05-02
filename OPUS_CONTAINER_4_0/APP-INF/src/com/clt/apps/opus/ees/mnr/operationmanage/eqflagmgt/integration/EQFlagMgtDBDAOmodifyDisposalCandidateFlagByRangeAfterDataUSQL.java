/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : EQFlagMgtDBDAOmodifyDisposalCandidateFlagByRangeAfterDataUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.09.08
*@LastModifier : 
*@LastVersion : 1.0
* 2015.09.08 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.mnr.operationmanage.eqflagmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class EQFlagMgtDBDAOmodifyDisposalCandidateFlagByRangeAfterDataUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * EQFlagMgtDBDAOmodifyDisposalCandidateFlagByRangeAfterDataUSQL
	  * </pre>
	  */
	public EQFlagMgtDBDAOmodifyDisposalCandidateFlagByRangeAfterDataUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mnr_disp_sel_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fm_ser_no",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("lot_eq_pfx_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("to_ser_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.mnr.operationmanage.eqflagmgt.integration").append("\n"); 
		query.append("FileName : EQFlagMgtDBDAOmodifyDisposalCandidateFlagByRangeAfterDataUSQL").append("\n"); 
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
		query.append("UPDATE MNR_EQ_STS  SET   " ).append("\n"); 
		query.append("MNR_DISP_SEL_TP_CD='R',                                     " ).append("\n"); 
		query.append("MNR_DISP_SEL_FLG = DECODE(@[mnr_disp_sel_flg],'1','Y','N'),                                           " ).append("\n"); 
		query.append("MNR_DISP_SEL_FLG_DT =DECODE(@[mnr_disp_sel_flg],'1',SYSDATE,null),   " ).append("\n"); 
		query.append("UPD_USR_ID = @[upd_usr_id],                                           " ).append("\n"); 
		query.append("UPD_DT = SYSDATE                                           " ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("#if(${eq_knd_cd} == 'U')" ).append("\n"); 
		query.append("AND EQ_NO IN (SELECT CNTR_NO " ).append("\n"); 
		query.append("                FROM MST_CONTAINER" ).append("\n"); 
		query.append("               WHERE CNTR_NO BETWEEN @[lot_eq_pfx_cd] || @[fm_ser_no] || '0'  AND @[lot_eq_pfx_cd] || @[to_ser_no] ||'9'" ).append("\n"); 
		query.append("                 AND LSTM_CD = 'OW')" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("AND EQ_NO IN (SELECT EQ_NO" ).append("\n"); 
		query.append("                FROM CGM_EQUIPMENT" ).append("\n"); 
		query.append("               WHERE EQ_NO BETWEEN @[lot_eq_pfx_cd] || @[fm_ser_no] || '0'  AND @[lot_eq_pfx_cd] || @[to_ser_no] ||'9'" ).append("\n"); 
		query.append("                 AND AGMT_LSTM_CD = 'OW')" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}