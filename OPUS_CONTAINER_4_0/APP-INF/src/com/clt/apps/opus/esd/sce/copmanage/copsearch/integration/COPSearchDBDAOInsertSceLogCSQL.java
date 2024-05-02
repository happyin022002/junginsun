/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : COPSearchDBDAOInsertSceLogCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.12.15
*@LastModifier : 김인수
*@LastVersion : 1.0
* 2010.12.15 김인수
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.sce.copmanage.copsearch.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Kim In-soo
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class COPSearchDBDAOInsertSceLogCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * cop change master
	  * </pre>
	  */
	public COPSearchDBDAOInsertSceLogCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_event_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cop_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.sce.copmanage.copsearch.integration").append("\n"); 
		query.append("FileName : COPSearchDBDAOInsertSceLogCSQL").append("\n"); 
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
		query.append("INSERT INTO sce_cop_his " ).append("\n"); 
		query.append("                       ( COP_NO" ).append("\n"); 
		query.append("                       , ACCL_SEQ" ).append("\n"); 
		query.append("                       , CNTR_NO" ).append("\n"); 
		query.append("                       , BKG_NO" ).append("\n"); 
		query.append("                       , CNTR_TPSZ_CD" ).append("\n"); 
		query.append("                       , PCTL_NO" ).append("\n"); 
		query.append("                       , BKG_STS_CD" ).append("\n"); 
		query.append("                       , COP_STS_CD" ).append("\n"); 
		query.append("                       , BKG_EVNT_TP_CD" ).append("\n"); 
		query.append("                       , UMCH_STS_CD" ).append("\n"); 
		query.append("                       , OB_TRO_SEQ" ).append("\n"); 
		query.append("                       , OB_TRO_SUB_SEQ" ).append("\n"); 
		query.append("                       , IB_TRO_SEQ" ).append("\n"); 
		query.append("                       , IB_TRO_SUB_SEQ" ).append("\n"); 
		query.append("                       , CRE_USR_ID" ).append("\n"); 
		query.append("                       , CRE_DT" ).append("\n"); 
		query.append("                       , UPD_USR_ID" ).append("\n"); 
		query.append("                       , UPD_DT" ).append("\n"); 
		query.append("				       , MST_COP_NO" ).append("\n"); 
		query.append("                       )" ).append("\n"); 
		query.append("SELECT hdr.cop_no" ).append("\n"); 
		query.append("     , SCE_COP_HIS_SEQ.NEXTVAL" ).append("\n"); 
		query.append("     , hdr.cntr_no" ).append("\n"); 
		query.append("     , hdr.bkg_no" ).append("\n"); 
		query.append("     , hdr.cntr_tpsz_cd" ).append("\n"); 
		query.append("     , hdr.pctl_no" ).append("\n"); 
		query.append("     , bk.bkg_sts_cd" ).append("\n"); 
		query.append("     , hdr.cop_sts_cd" ).append("\n"); 
		query.append("     , @[bkg_event_tp_cd] " ).append("\n"); 
		query.append("     , ''" ).append("\n"); 
		query.append("     , ''" ).append("\n"); 
		query.append("     , ''" ).append("\n"); 
		query.append("     , ''" ).append("\n"); 
		query.append("     , ''" ).append("\n"); 
		query.append("     , @[cre_usr_id]  AS cre_usr_id" ).append("\n"); 
		query.append("     , SYSDATE AS cre_dt" ).append("\n"); 
		query.append("     , @[cre_usr_id]  AS upd_usr_id" ).append("\n"); 
		query.append("     , SYSDATE AS upd_dt" ).append("\n"); 
		query.append("	 , MST_COP_NO" ).append("\n"); 
		query.append("  FROM sce_cop_hdr hdr" ).append("\n"); 
		query.append("     , bkg_booking bk" ).append("\n"); 
		query.append(" WHERE hdr.bkg_no = bk.bkg_no" ).append("\n"); 
		query.append("   AND hdr.cop_no = @[cop_no]" ).append("\n"); 

	}
}