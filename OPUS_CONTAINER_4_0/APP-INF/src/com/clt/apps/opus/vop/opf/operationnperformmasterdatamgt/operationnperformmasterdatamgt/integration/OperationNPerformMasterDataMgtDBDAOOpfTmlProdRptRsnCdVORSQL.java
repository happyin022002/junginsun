/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : OperationNPerformMasterDataMgtDBDAOOpfTmlProdRptRsnCdVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.12
*@LastModifier : 우지석
*@LastVersion : 1.0
* 2009.06.12 우지석
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.opf.operationnperformmasterdatamgt.operationnperformmasterdatamgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Ji Seok Woo
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class OperationNPerformMasterDataMgtDBDAOOpfTmlProdRptRsnCdVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * select   opf_tml_prod_rpt_rsn_cd
	  * </pre>
	  */
	public OperationNPerformMasterDataMgtDBDAOOpfTmlProdRptRsnCdVORSQL(){
		setQuery();
		
		params = new HashMap<String,String[]>();
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
		query.append("select" ).append("\n"); 
		query.append("tml_prod_rpt_rsn_cd," ).append("\n"); 
		query.append("tml_prod_rpt_rsn_desc," ).append("\n"); 
		query.append("delt_flg," ).append("\n"); 
		query.append("cre_usr_id," ).append("\n"); 
		query.append("cre_dt," ).append("\n"); 
		query.append("upd_usr_id," ).append("\n"); 
		query.append("upd_dt" ).append("\n"); 
		query.append("from opf_tml_prod_rpt_rsn_cd" ).append("\n"); 
		query.append("where	delt_flg != 'Y'" ).append("\n"); 
		query.append("order by tml_prod_rpt_rsn_cd" ).append("\n"); 

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.vop.opf.operationnperformmasterdatamgt.operationnperformmasterdatamgt.integration").append("\n"); 
		query.append("FileName : OperationNPerformMasterDataMgtDBDAOOpfTmlProdRptRsnCdVORSQL").append("\n"); 
		query.append("*/").append("\n"); 
	}
}