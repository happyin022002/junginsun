/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : RailSoManageDBDAOSearchEmptyRepoRefSeqRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.09.25
*@LastModifier : 
*@LastVersion : 1.0
* 2013.09.25 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.trs.railsomanage.railsomanage.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class RailSoManageDBDAOSearchEmptyRepoRefSeqRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Ref_Seq 채번
	  * </pre>
	  */
	public RailSoManageDBDAOSearchEmptyRepoRefSeqRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("so_if_div_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fm_loc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pln_yrwk",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.trs.railsomanage.railsomanage.integration ").append("\n"); 
		query.append("FileName : RailSoManageDBDAOSearchEmptyRepoRefSeqRSQL").append("\n"); 
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
		query.append("SELECT 'H'" ).append("\n"); 
		query.append("       ||@[fm_loc_cd]" ).append("\n"); 
		query.append("       ||SUBSTR(@[pln_yrwk],3,4)" ).append("\n"); 
		query.append("       ||'W'     " ).append("\n"); 
		query.append("       ||LPAD(TRS_TRSP_MT_REF_ID_SEQ1.NEXTVAL,3,0)     " ).append("\n"); 
		query.append("       ||@[so_if_div_cd]   REF_ID " ).append("\n"); 
		query.append("  FROM DUAL " ).append("\n"); 

	}
}