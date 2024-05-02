/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : ReplanManageDBDAOSearchCopHdrByMstCopNoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.07.20
*@LastModifier : 김인수
*@LastVersion : 1.0
* 2011.07.20 김인수
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.sce.replanmanage.replanmanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Kim In-soo
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ReplanManageDBDAOSearchCopHdrByMstCopNoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Master cop no 로 COP 를 조회한다.
	  * </pre>
	  */
	public ReplanManageDBDAOSearchCopHdrByMstCopNoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cop_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.sce.replanmanage.replanmanage.integration").append("\n"); 
		query.append("FileName : ReplanManageDBDAOSearchCopHdrByMstCopNoRSQL").append("\n"); 
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
		query.append("select" ).append("\n"); 
		query.append("	cop_no," ).append("\n"); 
		query.append("	mst_cop_no," ).append("\n"); 
		query.append("	cntr_no," ).append("\n"); 
		query.append("	trnk_vsl_cd," ).append("\n"); 
		query.append("	trnk_skd_voy_no," ).append("\n"); 
		query.append("	trnk_skd_dir_cd," ).append("\n"); 
		query.append("	cop_sts_cd," ).append("\n"); 
		query.append("	ob_tro_flg," ).append("\n"); 
		query.append("	ib_tro_flg" ).append("\n"); 
		query.append("from" ).append("\n"); 
		query.append("sce_cop_hdr" ).append("\n"); 
		query.append("where" ).append("\n"); 
		query.append("	mst_cop_no = @[cop_no]" ).append("\n"); 
		query.append("	and cop_sts_cd in ('C', 'T', 'F')" ).append("\n"); 
		query.append("#if (${expt_flg} == 'Y')" ).append("\n"); 
		query.append("	and cop_no != @[cop_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	and COP_NO NOT IN (" ).append("\n"); 
		query.append("		#foreach($ele IN ${copList})" ).append("\n"); 
		query.append("			#if($velocityCount == 1 ) " ).append("\n"); 
		query.append("				'$ele'" ).append("\n"); 
		query.append("			#else " ).append("\n"); 
		query.append("				,'$ele' " ).append("\n"); 
		query.append("			#end " ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("		) " ).append("\n"); 
		query.append("" ).append("\n"); 

	}
}