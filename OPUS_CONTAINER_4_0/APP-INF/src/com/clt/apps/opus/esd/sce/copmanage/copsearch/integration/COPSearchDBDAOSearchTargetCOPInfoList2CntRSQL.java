/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : COPSearchDBDAOSearchTargetCOPInfoList2CntRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.12.07
*@LastModifier : 오현경
*@LastVersion : 1.0
* 2009.12.07 오현경
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.sce.copmanage.copsearch.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Oh hyun-kyoung
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class COPSearchDBDAOSearchTargetCOPInfoList2CntRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchTargetCOPInfoList2Cnt
	  * </pre>
	  */
	public COPSearchDBDAOSearchTargetCOPInfoList2CntRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("io_bnd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pctl_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.sce.copmanage.copsearch.integration").append("\n"); 
		query.append("FileName : COPSearchDBDAOSearchTargetCOPInfoList2CntRSQL").append("\n"); 
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
		query.append("SELECT MAX(grp_cnt) max_cnt" ).append("\n"); 
		query.append("FROM ( SELECT a.pctl_no" ).append("\n"); 
		query.append(", COUNT(a.pctl_no) OVER(PARTITION BY a.pctl_no) grp_cnt" ).append("\n"); 
		query.append("FROM prd_prod_ctl_mst a  , prd_prod_ctl_rout_dtl b" ).append("\n"); 
		query.append("WHERE a.pctl_no = b.pctl_no" ).append("\n"); 
		query.append("AND a.pctl_no LIKE SUBSTR(@[pctl_no] , 1, 16) ||'%'" ).append("\n"); 
		query.append("AND nod_lnk_div_cd = 'L'" ).append("\n"); 
		query.append("AND pctl_io_bnd_cd = @[io_bnd_cd]" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}