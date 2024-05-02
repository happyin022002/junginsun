/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : COPUpdateDBDAOSearchCOPDetailDataRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.29
*@LastModifier : 오현경
*@LastVersion : 1.0
* 2009.09.29 오현경
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.sce.copmanage.copupdate.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Oh hyun-kyoung
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class COPUpdateDBDAOSearchCOPDetailDataRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchCOPDetailData
	  * </pre>
	  */
	public COPUpdateDBDAOSearchCOPDetailDataRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("act_dt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cntr_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cop_dtl_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cop_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.sce.copmanage.copupdate.integration").append("\n"); 
		query.append("FileName : COPUpdateDBDAOSearchCOPDetailDataRSQL").append("\n"); 
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
		query.append("SELECT a.cop_no" ).append("\n"); 
		query.append(",a.cop_dtl_seq" ).append("\n"); 
		query.append(",a.nod_cd" ).append("\n"); 
		query.append(",a.act_sts_cd" ).append("\n"); 
		query.append(",a.vsl_cd" ).append("\n"); 
		query.append(",a.skd_voy_no" ).append("\n"); 
		query.append(",a.skd_dir_cd" ).append("\n"); 
		query.append(",a.stnd_edi_sts_cd" ).append("\n"); 
		query.append(",@[act_dt] AS actDt" ).append("\n"); 
		query.append(",@[cntr_no] cntr_no" ).append("\n"); 
		query.append(",@[bkg_no]  bkg_no" ).append("\n"); 
		query.append("FROM   sce_cop_dtl a" ).append("\n"); 
		query.append("WHERE  a.cop_no          = @[cop_no]" ).append("\n"); 
		query.append("--AND    a.cop_grp_seq = ''" ).append("\n"); 
		query.append("AND    a.cop_dtl_seq = @[cop_dtl_seq]" ).append("\n"); 

	}
}