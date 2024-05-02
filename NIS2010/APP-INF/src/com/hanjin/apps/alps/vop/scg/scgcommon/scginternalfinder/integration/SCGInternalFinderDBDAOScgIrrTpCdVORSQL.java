/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SCGInternalFinderDBDAOScgIrrTpCdVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.21
*@LastModifier : 김현욱
*@LastVersion : 1.0
* 2009.07.21 김현욱
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.scg.scgcommon.scginternalfinder.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Kim Hyun Uk
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SCGInternalFinderDBDAOScgIrrTpCdVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Irregular Type 조회      
	  * </pre>
	  */
	public SCGInternalFinderDBDAOScgIrrTpCdVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("awk_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dg_flg",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.vop.scg.scgcommon.scginternalfinder.integration").append("\n"); 
		query.append("FileName : SCGInternalFinderDBDAOScgIrrTpCdVORSQL").append("\n"); 
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
		query.append("SELECT" ).append("\n"); 
		query.append("spcl_cgo_irr_tp_cd" ).append("\n"); 
		query.append(",	spcl_cgo_irr_tp_nm" ).append("\n"); 
		query.append(",	spcl_cgo_irr_tp_desc" ).append("\n"); 
		query.append(",	dg_flg" ).append("\n"); 
		query.append(",	awk_flg" ).append("\n"); 
		query.append(",	delt_flg" ).append("\n"); 
		query.append(",	cre_usr_id" ).append("\n"); 
		query.append(",	cre_dt" ).append("\n"); 
		query.append(",	upd_usr_id" ).append("\n"); 
		query.append(",	upd_dt" ).append("\n"); 
		query.append("FROM scg_irr_tp_cd" ).append("\n"); 
		query.append("WHERE	delt_flg = 'N'" ).append("\n"); 
		query.append("#if (${dg_flg} != '')" ).append("\n"); 
		query.append("AND dg_flg = @[dg_flg]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${awk_flg} != '')" ).append("\n"); 
		query.append("AND	awk_flg = @[awk_flg]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("ORDER BY spcl_cgo_irr_tp_cd" ).append("\n"); 

	}
}