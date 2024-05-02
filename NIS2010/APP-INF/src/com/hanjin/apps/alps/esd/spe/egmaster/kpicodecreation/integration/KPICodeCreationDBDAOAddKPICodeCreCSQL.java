/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : KPICodeCreationDBDAOAddKPICodeCreCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.02.10
*@LastModifier : 백형인
*@LastVersion : 1.0
* 2015.02.10 백형인
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.spe.egmaster.kpicodecreation.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author HI
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class KPICodeCreationDBDAOAddKPICodeCreCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * KPI Code Creation 데이터를 입력 한다
	  * </pre>
	  */
	public KPICodeCreationDBDAOAddKPICodeCreCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sp_kpi_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("ev_svc_cate_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sp_kpi_nm",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("sp_kpi_desc",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.spe.egmaster.kpicodecreation.integration ").append("\n"); 
		query.append("FileName : KPICodeCreationDBDAOAddKPICodeCreCSQL").append("\n"); 
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
		query.append("INSERT INTO SPE_SP_SVC_CATE_KPI(SP_KPI_ID" ).append("\n"); 
		query.append("                              , EV_SVC_CATE_CD" ).append("\n"); 
		query.append("                              , SP_KPI_NM" ).append("\n"); 
		query.append("                              , SP_KPI_DESC" ).append("\n"); 
		query.append("                              , SP_KPI_TP_CD" ).append("\n"); 
		query.append("                              , DELT_FLG" ).append("\n"); 
		query.append("                              , CRE_USR_ID" ).append("\n"); 
		query.append("                              , CRE_DT" ).append("\n"); 
		query.append("                              , UPD_USR_ID" ).append("\n"); 
		query.append("                              , UPD_DT" ).append("\n"); 
		query.append("                              )VALUES(" ).append("\n"); 
		query.append("                                @[ev_svc_cate_cd]||(SELECT LPAD(COUNT(1)+1,3,0) FROM SPE_SP_SVC_CATE_KPI WHERE EV_SVC_CATE_CD LIKE @[ev_svc_cate_cd]||'%')" ).append("\n"); 
		query.append("                              , @[ev_svc_cate_cd]" ).append("\n"); 
		query.append("                              , @[sp_kpi_nm]" ).append("\n"); 
		query.append("                              , @[sp_kpi_desc]" ).append("\n"); 
		query.append("                              , @[sp_kpi_tp_cd]" ).append("\n"); 
		query.append("                              , 'N'" ).append("\n"); 
		query.append("                              , @[cre_usr_id]" ).append("\n"); 
		query.append("                              , SYSDATE" ).append("\n"); 
		query.append("                              , @[upd_usr_id]" ).append("\n"); 
		query.append("                              , SYSDATE" ).append("\n"); 
		query.append("                              )" ).append("\n"); 

	}
}