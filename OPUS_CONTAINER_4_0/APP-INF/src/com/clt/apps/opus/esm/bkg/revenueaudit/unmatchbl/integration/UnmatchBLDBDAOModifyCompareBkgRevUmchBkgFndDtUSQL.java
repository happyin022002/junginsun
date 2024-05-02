/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : UnmatchBLDBDAOModifyCompareBkgRevUmchBkgFndDtUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.04.29
*@LastModifier : 류선우
*@LastVersion : 1.0
* 2010.04.29 류선우
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.revenueaudit.unmatchbl.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Ryu Sun Woo
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class UnmatchBLDBDAOModifyCompareBkgRevUmchBkgFndDtUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * modifyCompareBkgRevUmchBkgFndDt
	  * </pre>
	  */
	public UnmatchBLDBDAOModifyCompareBkgRevUmchBkgFndDtUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rev_aud_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("max_umch_bkg_seq",new String[]{arrTmp[0],arrTmp[1]});

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

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.revenueaudit.unmatchbl.integration").append("\n"); 
		query.append("FileName : UnmatchBLDBDAOModifyCompareBkgRevUmchBkgFndDtUSQL").append("\n"); 
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
		query.append("UPDATE  BKG_REV_UMCH_BKG" ).append("\n"); 
		query.append("SET     REV_AUD_TP_CD   = @[rev_aud_tp_cd]  ," ).append("\n"); 
		query.append("        LST_UMCH_FND_DT = SYSDATE           ," ).append("\n"); 
		query.append("        UPD_USR_ID      = @[upd_usr_id]     ," ).append("\n"); 
		query.append("        UPD_DT          = SYSDATE" ).append("\n"); 
		query.append("WHERE   BKG_NO          = @[bkg_no]" ).append("\n"); 
		query.append("AND     UMCH_BKG_SEQ    = TO_NUMBER(@[max_umch_bkg_seq]) - 1" ).append("\n"); 
		query.append("AND     REV_AUD_STS_CD  = 'U'" ).append("\n"); 

	}
}