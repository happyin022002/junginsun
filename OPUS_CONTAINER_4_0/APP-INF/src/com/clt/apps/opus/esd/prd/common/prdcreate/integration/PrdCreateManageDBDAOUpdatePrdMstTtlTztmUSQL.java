/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : PrdCreateManageDBDAOUpdatePrdMstTtlTztmUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.27
*@LastModifier : 정선용
*@LastVersion : 1.0
* 2009.08.27 정선용
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.prd.common.prdcreate.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author sun yong Jung
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PrdCreateManageDBDAOUpdatePrdMstTtlTztmUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * UpdatePrdMstTtlTztm
	  * </pre>
	  */
	public PrdCreateManageDBDAOUpdatePrdMstTtlTztmUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("hd_pctl_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("t_vvd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.prd.common.prdcreate.integration").append("\n"); 
		query.append("FileName : PrdCreateManageDBDAOUpdatePrdMstTtlTztmUSQL").append("\n"); 
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
		query.append("UPDATE PRD_PROD_CTL_MST M" ).append("\n"); 
		query.append("SET TTL_TZTM_HRS = (" ).append("\n"); 
		query.append("SELECT ROUND((MAX(TT.DEP_FSH_DT) -MIN(TT.ARR_ST_DT))*24)" ).append("\n"); 
		query.append("FROM PRD_PROD_CTL_ROUT_DTL TT" ).append("\n"); 
		query.append("WHERE TT.PCTL_NO = M.PCTL_NO )," ).append("\n"); 
		query.append("(TRNK_VSL_CD, TRNK_SKD_VOY_NO , TRNK_SKD_DIR_CD ) = (" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("DECODE(@[t_vvd],'',SUBSTR(VVD,1,4),SUBSTR(@[t_vvd],1,4))," ).append("\n"); 
		query.append("DECODE(@[t_vvd],'',SUBSTR(VVD,5,4),SUBSTR(@[t_vvd],5,4))," ).append("\n"); 
		query.append("DECODE(@[t_vvd],'',SUBSTR(VVD,9,1),SUBSTR(@[t_vvd],9,1))" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("PCTL_NO,PRD_GET_TLANE_FNC(PCTL_NO,'VVD') VVD" ).append("\n"); 
		query.append("FROM PRD_PROD_CTL_MST MM" ).append("\n"); 
		query.append("WHERE" ).append("\n"); 
		query.append("MM.PCTL_NO LIKE @[hd_pctl_no]||'%'" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("WHERE" ).append("\n"); 
		query.append("PCTL_NO = M.PCTL_NO" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("WHERE  PCTL_NO LIKE @[hd_pctl_no]||'%'" ).append("\n"); 

	}
}