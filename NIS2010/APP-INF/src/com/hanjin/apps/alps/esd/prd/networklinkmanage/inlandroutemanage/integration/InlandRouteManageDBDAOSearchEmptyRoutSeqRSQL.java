/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : InlandRouteManageDBDAOSearchEmptyRoutSeqRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.05
*@LastModifier : 김귀진
*@LastVersion : 1.0
* 2009.11.05 김귀진
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.prd.networklinkmanage.inlandroutemanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author kIm kwi-jin
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class InlandRouteManageDBDAOSearchEmptyRoutSeqRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * next SearchEmptyRoutSeq
	  * </pre>
	  */
	public InlandRouteManageDBDAOSearchEmptyRoutSeqRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("i_rout_org_nod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("i_rout_dest_nod_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.prd.networklinkmanage.inlandroutemanage.integration").append("\n"); 
		query.append("FileName : InlandRouteManageDBDAOSearchEmptyRoutSeqRSQL").append("\n"); 
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
		query.append("SELECT MAX (next_rout_seq) + 1 next_rout_seq," ).append("\n"); 
		query.append("MAX (next_prio_seq) + 1 next_prio_seq" ).append("\n"); 
		query.append("FROM (SELECT NVL (MAX (rout_seq), 0) next_rout_seq, 0 next_prio_seq" ).append("\n"); 
		query.append("FROM prd_inlnd_rout_mst" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT 0 next_rout_seq, NVL (MAX (prio_seq), 0) next_prio_seq" ).append("\n"); 
		query.append("FROM prd_inlnd_rout_mst M" ).append("\n"); 
		query.append("WHERE rout_org_nod_cd LIKE" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("SUBSTR (@[i_rout_org_nod_cd], 1, 5) || '%'" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("AND rout_dest_nod_cd LIKE" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("SUBSTR (@[i_rout_dest_nod_cd], 1, 5) || '%'" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("AND PCTL_IO_BND_CD = 'M'" ).append("\n"); 
		query.append("AND NVL(DELT_FLG,'N') = 'N'" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}