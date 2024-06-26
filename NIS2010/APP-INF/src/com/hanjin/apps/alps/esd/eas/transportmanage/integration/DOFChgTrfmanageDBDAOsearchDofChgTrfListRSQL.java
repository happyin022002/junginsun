/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : DOFChgTrfmanageDBDAOsearchDofChgTrfListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.03.08
*@LastModifier : 
*@LastVersion : 1.0
* 2012.03.08 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.eas.transportmanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class DOFChgTrfmanageDBDAOsearchDofChgTrfListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Drop-off Charge조회
	  * </pre>
	  */
	public DOFChgTrfmanageDBDAOsearchDofChgTrfListRSQL(){
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
		params.put("streffdt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("strcnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.eas.transportmanage.integration").append("\n"); 
		query.append("FileName : DOFChgTrfmanageDBDAOsearchDofChgTrfListRSQL").append("\n"); 
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
		query.append("select to_char(eff_dt,'YYYYMMDD') effdt, fm_loc_cd" ).append("\n"); 
		query.append(", cnt_cd||cust_seq cust_info, conti_cd, conti_cd conti_cd_old, cntr_tp_cd" ).append("\n"); 
		query.append(" , curr_cd, chrr_frt_tax_val, cre_usr_id, cust_rmk,cre_ofc_cd" ).append("\n"); 
		query.append(" from trs_drff_chg_trf  " ).append("\n"); 
		query.append(" where to_char(eff_dt,'YYYYMMDD') = @[streffdt]                                          " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if(${strcnt_cd} != '')" ).append("\n"); 
		query.append("	   and  fm_loc_cd like @[strcnt_cd]||'%'                                           	" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if( ${cust_info} != '')" ).append("\n"); 
		query.append("	   and cnt_cd = substr(@[cust_info],0,2)" ).append("\n"); 
		query.append("	   and cust_seq = substr(@[cust_info],3)                                                            			" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("order by fm_loc_cd, cust_info, conti_cd, cntr_tp_cd" ).append("\n"); 

	}
}