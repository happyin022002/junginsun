/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ReplanManageDBDAOSearchTurnVvdRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.27
*@LastModifier : 김인수
*@LastVersion : 1.0
* 2009.11.27 김인수
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.sce.replanmanage.replanmanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Kim In-soo
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ReplanManageDBDAOSearchTurnVvdRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * VVD 로 Turn VVD 를 조회하여 return 한다.
	  * </pre>
	  */
	public ReplanManageDBDAOSearchTurnVvdRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("nod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("skd_dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("skd_voy_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("call_yd_ind_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.sce.replanmanage.replanmanage.integration").append("\n"); 
		query.append("FileName : ReplanManageDBDAOSearchTurnVvdRSQL").append("\n"); 
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
		query.append("VSL_CD,TURN_SKD_VOY_NO,TURN_SKD_DIR_CD,TURN_CLPT_IND_SEQ" ).append("\n"); 
		query.append("FROM VSK_VSL_PORT_SKD" ).append("\n"); 
		query.append("WHERE   VSL_CD = @[vsl_cd]" ).append("\n"); 
		query.append("AND     SKD_VOY_NO = @[skd_voy_no]" ).append("\n"); 
		query.append("AND     SKD_DIR_CD = @[skd_dir_cd]" ).append("\n"); 
		query.append("AND     CALL_YD_IND_SEQ = @[call_yd_ind_seq]" ).append("\n"); 
		query.append("AND     YD_CD = @[nod_cd]" ).append("\n"); 

	}
}