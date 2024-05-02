/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : DOFChgTrfmanageDBDAOsearchDofChgDupCntRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.20
*@LastModifier : 
*@LastVersion : 1.0
* 2009.10.20 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.eas.transportmanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class DOFChgTrfmanageDBDAOsearchDofChgDupCntRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Drop Off Charge Tariff 중복 갯수 조회
	  * </pre>
	  */
	public DOFChgTrfmanageDBDAOsearchDofChgDupCntRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_info",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("conti_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_cntr_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("streffdt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("strcnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.eas.transportmanage.integration").append("\n"); 
		query.append("FileName : DOFChgTrfmanageDBDAOsearchDofChgDupCntRSQL").append("\n"); 
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
		query.append("select count(*) dup_cnt" ).append("\n"); 
		query.append("from trs_drff_chg_trf" ).append("\n"); 
		query.append("where to_char(eff_dt,'YYYYMMDD') = @[streffdt]" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if( ${strcnt_cd} != '')" ).append("\n"); 
		query.append("and  fm_loc_cd = @[strcnt_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if( ${cust_info} != '')" ).append("\n"); 
		query.append("and cnt_cd = substr(@[cust_info],0,2)" ).append("\n"); 
		query.append("and cust_seq = substr(@[cust_info],3)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("and conti_cd = @[conti_cd]" ).append("\n"); 
		query.append("and cntr_tp_cd = @[s_cntr_tp_cd]" ).append("\n"); 

	}
}