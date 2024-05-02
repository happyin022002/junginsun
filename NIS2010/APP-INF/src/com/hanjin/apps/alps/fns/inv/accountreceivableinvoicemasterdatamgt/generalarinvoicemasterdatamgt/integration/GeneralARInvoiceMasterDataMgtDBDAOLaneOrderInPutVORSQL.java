/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : GeneralARInvoiceMasterDataMgtDBDAOLaneOrderInPutVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.06
*@LastModifier : 김세일
*@LastVersion : 1.0
* 2009.05.06 김세일
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemasterdatamgt.generalarinvoicemasterdatamgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author saeil kim
 * @see DAO 참조
 * @since J2EE 1.4
 */

public class GeneralARInvoiceMasterDataMgtDBDAOLaneOrderInPutVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  *    
	  * </pre>
	  */
	public GeneralARInvoiceMasterDataMgtDBDAOLaneOrderInPutVORSQL(){
		setQuery();
		
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = "12,N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rlane_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = "12,N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("zn_ioc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = "12,N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("slan_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = "12,N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("delt_flg",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("a.rlane_cd rlane_cd," ).append("\n"); 
		query.append("b.rlane_nm rlane_nm," ).append("\n"); 
		query.append("a.rnk_seq rnk_seq," ).append("\n"); 
		query.append("a.rlane_desc rlane_desc," ).append("\n"); 
		query.append("a.zn_ioc_cd zn_ioc_cd," ).append("\n"); 
		query.append("a.ioc_desc ioc_desc," ).append("\n"); 
		query.append("a.slan_cd slan_cd," ).append("\n"); 
		query.append("a.delt_flg delt_flg," ).append("\n"); 
		query.append("a.cre_usr_id cre_usr_id," ).append("\n"); 
		query.append("a.cre_dt cre_dt," ).append("\n"); 
		query.append("a.eai_evnt_dt eai_evnt_dt," ).append("\n"); 
		query.append("a.upd_dt upd_dt" ).append("\n"); 
		query.append("from ar_rout_rnk a, MDM_REV_LANE b" ).append("\n"); 
		query.append("where a.rlane_cd = b.rlane_cd(+)" ).append("\n"); 
		query.append("#if (${rlane_cd} != '')" ).append("\n"); 
		query.append("and a.rlane_cd like '%' || @[rlane_cd]|| '%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${zn_ioc_cd} != '')" ).append("\n"); 
		query.append("and	a.zn_ioc_cd = @[zn_ioc_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${slan_cd} != '')" ).append("\n"); 
		query.append("and	a.slan_cd like '%' || @[slan_cd]|| '%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${delt_flg} != '')" ).append("\n"); 
		query.append("and	a.delt_flg = @[delt_flg]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("order by a.rnk_seq" ).append("\n"); 

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.nis2010.fns.inv.accountreceivableinvoicemasterdatamgt.generalarinvoicemasterdatamgt.integration").append("\n"); 
		query.append("FileName : GeneralARInvoiceMasterDataMgtDBDAOLaneOrderInPutVORSQL").append("\n"); 
		query.append("*/").append("\n"); 
	}
}