/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ServiceProviderCategoryManageDBDAOMultiSPE_SVC_PROV_SVC_CATE_MTCHSCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.30
*@LastModifier : 남궁진호
*@LastVersion : 1.0
* 2009.07.30 남궁진호
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.spe.mastermanage.serviceprovidercategorymanage.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author NAMKOONG Jin Ho
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ServiceProviderCategoryManageDBDAOMultiSpeSvcProvSvcCateMtchsCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ServiceProviderCategoryManageDBDAOMultiSPE_SVC_PROV_SVC_CATE_MTCHSUSQL.Query
	  * </pre>
	  */
	public ServiceProviderCategoryManageDBDAOMultiSpeSvcProvSvcCateMtchsCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("svc_cate_rail_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vndr_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("svc_cate_cy_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("svc_cate_wtr_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("svc_cate_tml_flg",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("svc_cate_trsp_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("svc_cate_eq_flg",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.spe.mastermanage.serviceprovidercategorymanage.integration ").append("\n"); 
		query.append("FileName : ServiceProviderCategoryManageDBDAOMultiSPE_SVC_PROV_SVC_CATE_MTCHSCSQL").append("\n"); 
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
		query.append("INSERT INTO SPE_SVC_PROV_SVC_CATE_MTCH (" ).append("\n"); 
		query.append("VNDR_SEQ," ).append("\n"); 
		query.append("SVC_CATE_TRSP_FLG," ).append("\n"); 
		query.append("SVC_CATE_RAIL_FLG," ).append("\n"); 
		query.append("SVC_CATE_CY_FLG," ).append("\n"); 
		query.append("SVC_CATE_TML_FLG," ).append("\n"); 
		query.append("SVC_CATE_WTR_FLG," ).append("\n"); 
		query.append("SVC_CATE_EQ_FLG," ).append("\n"); 
		query.append("CRE_USR_ID," ).append("\n"); 
		query.append("CRE_DT," ).append("\n"); 
		query.append("UPD_USR_ID," ).append("\n"); 
		query.append("UPD_DT )" ).append("\n"); 
		query.append("VALUES ( @[vndr_seq] ," ).append("\n"); 
		query.append("DECODE(@[svc_cate_trsp_flg] , '1', 'Y', 'N')," ).append("\n"); 
		query.append("DECODE(@[svc_cate_rail_flg] , '1', 'Y', 'N')," ).append("\n"); 
		query.append("DECODE(@[svc_cate_cy_flg] , '1', 'Y', 'N')," ).append("\n"); 
		query.append("DECODE(@[svc_cate_tml_flg] , '1', 'Y', 'N')," ).append("\n"); 
		query.append("DECODE(@[svc_cate_wtr_flg] , '1', 'Y', 'N')," ).append("\n"); 
		query.append("DECODE(@[svc_cate_eq_flg] , '1', 'Y', 'N')," ).append("\n"); 
		query.append("@[cre_usr_id]," ).append("\n"); 
		query.append("SYSDATE," ).append("\n"); 
		query.append("@[upd_usr_id]," ).append("\n"); 
		query.append("SYSDATE" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}