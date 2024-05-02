/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : SPServiceCategoryDBDAOAddSpSvcCateCfmStupCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.02.10
*@LastModifier : 백형인
*@LastVersion : 1.0
* 2015.02.10 백형인
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.spe.egmaster.spservicecategory.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author HI
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SPServiceCategoryDBDAOAddSpSvcCateCfmStupCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 업체의 서비스 카테고리 정보를 저장한다.
	  * </pre>
	  */
	public SPServiceCategoryDBDAOAddSpSvcCateCfmStupCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("upd_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sp_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ev_svc_cate_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.spe.egmaster.spservicecategory.integration ").append("\n"); 
		query.append("FileName : SPServiceCategoryDBDAOAddSpSvcCateCfmStupCSQL").append("\n"); 
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
		query.append("INSERT INTO SPE_SP_SVC_CATE_STUP(SP_SEQ" ).append("\n"); 
		query.append("                               , EV_SVC_CATE_CD" ).append("\n"); 
		query.append("                               , CRE_USR_ID" ).append("\n"); 
		query.append("                               , CRE_DT" ).append("\n"); 
		query.append("                               , UPD_USR_ID" ).append("\n"); 
		query.append("                               , UPD_DT" ).append("\n"); 
		query.append("                              )VALUES(" ).append("\n"); 
		query.append("                                 @[sp_seq]" ).append("\n"); 
		query.append("                               , @[ev_svc_cate_cd]" ).append("\n"); 
		query.append("                               , @[cre_usr_id]" ).append("\n"); 
		query.append("                               , SYSDATE" ).append("\n"); 
		query.append("                               , @[upd_usr_id]" ).append("\n"); 
		query.append("                               , SYSDATE" ).append("\n"); 
		query.append("                              )" ).append("\n"); 

	}
}