/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : DemDet3rdDBDAOMultiDEMDET3RDUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.02.21
*@LastModifier : 최성민
*@LastVersion : 1.0
* 2011.02.21 최성민
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.coa.stdunitcost.demdet3rd.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author SHOISUNGMIN
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class DemDet3rdDBDAOMultiDEMDET3RDUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * _DMDT_N3RD_PTY 테이블의 데이터 업데이트 
	  * 
	  * 각 Row별 insert,delte,Update가 
	  * 발생한다.
	  * </pre>
	  */
	public DemDet3rdDBDAOMultiDEMDET3RDUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("bkg_vol_qty",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_tpsz_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("stnd_cost_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("uc_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ttl_dmdt_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cost_yrmon",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cost_ass_bse_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.coa.stdunitcost.demdet3rd.integration").append("\n"); 
		query.append("FileName : DemDet3rdDBDAOMultiDEMDET3RDUSQL").append("\n"); 
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
		query.append("UPDATE	COA_DMDT_N3RD_PTY " ).append("\n"); 
		query.append("SET		UC_AMT			= TO_NUMBER(@[uc_amt]), " ).append("\n"); 
		query.append("		TTL_DMDT_AMT	= TO_NUMBER(@[ttl_dmdt_amt])," ).append("\n"); 
		query.append("		BKG_VOL_QTY		= TO_NUMBER(@[bkg_vol_qty])," ).append("\n"); 
		query.append("		COST_ASS_BSE_CD	= @[cost_ass_bse_cd], " ).append("\n"); 
		query.append("		UPD_DT			= SYSDATE, " ).append("\n"); 
		query.append("		UPD_USR_ID		= @[upd_usr_id]" ).append("\n"); 
		query.append("WHERE	COST_YRMON		= @[cost_yrmon]" ).append("\n"); 
		query.append("AND		CNTR_TPSZ_CD	= @[cntr_tpsz_cd]" ).append("\n"); 
		query.append("AND		STND_COST_CD	= @[stnd_cost_cd]" ).append("\n"); 

	}
}