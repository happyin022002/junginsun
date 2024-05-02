/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : VslConnBufferTimeDBDAOSearchVslConnBufferTimeListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.05.02
*@LastModifier : 
*@LastVersion : 1.0
* 2016.05.02 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.prd.networklinkmanage.vslconnbuffertime.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class VslConnBufferTimeDBDAOSearchVslConnBufferTimeListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * VslConnBufferTimeDBDAOSearchVslConnBufferTimeList
	  * </pre>
	  */
	public VslConnBufferTimeDBDAOSearchVslConnBufferTimeListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dchg_slan_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dchg_cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dchg_tml_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.prd.networklinkmanage.vslconnbuffertime.integration").append("\n"); 
		query.append("FileName : VslConnBufferTimeDBDAOSearchVslConnBufferTimeListRSQL").append("\n"); 
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
		query.append("SELECT dchg_cnt_cd" ).append("\n"); 
		query.append("      ,dchg_tml_cd" ).append("\n"); 
		query.append("      ,dchg_slan_cd" ).append("\n"); 
		query.append("      ,io_bnd_cd" ).append("\n"); 
		query.append("      ,lod_cnt_cd" ).append("\n"); 
		query.append("      ,lod_tml_cd" ).append("\n"); 
		query.append("      ,lod_slan_cd" ).append("\n"); 
		query.append("      ,cnn_buf_hrs" ).append("\n"); 
		query.append("      ,vsl_cnn_tp_cd" ).append("\n"); 
		query.append("      ,vsl_cnn_rmk" ).append("\n"); 
		query.append("      ,cre_usr_id" ).append("\n"); 
		query.append("      ,cre_dt" ).append("\n"); 
		query.append("      ,upd_usr_id" ).append("\n"); 
		query.append("      ,upd_dt" ).append("\n"); 
		query.append("  FROM prd_vsl_cnn_tm_mgmt" ).append("\n"); 
		query.append(" WHERE dchg_cnt_cd = NVL(@[dchg_cnt_cd], dchg_cnt_cd)" ).append("\n"); 
		query.append("   AND dchg_tml_cd = NVL(@[dchg_tml_cd], dchg_tml_cd)" ).append("\n"); 
		query.append("   AND dchg_slan_cd = NVL(@[dchg_slan_cd], dchg_slan_cd)" ).append("\n"); 

	}
}