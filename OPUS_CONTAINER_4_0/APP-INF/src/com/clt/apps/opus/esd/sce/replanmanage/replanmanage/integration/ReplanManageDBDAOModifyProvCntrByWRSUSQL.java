/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : ReplanManageDBDAOModifyProvCntrByWRSUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.02.23
*@LastModifier : 김인수
*@LastVersion : 1.0
* 2010.02.23 김인수
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

public class ReplanManageDBDAOModifyProvCntrByWRSUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * WRS (Web Railbilling System) 에서 prov_Cntr_no, prov_cntr_tpsz_cd 를 update 하기 위해 호출한다.
	  * </pre>
	  */
	public ReplanManageDBDAOModifyProvCntrByWRSUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("prov_cntr_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("prov_cntr_tpsz_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cop_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.sce.replanmanage.replanmanage.integration").append("\n"); 
		query.append("FileName : ReplanManageDBDAOModifyProvCntrByWRSUSQL").append("\n"); 
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
		query.append("UPDATE SCE_COP_HDR SET" ).append("\n"); 
		query.append("PROV_CNTR_NO       =  @[prov_cntr_no]," ).append("\n"); 
		query.append("PROV_CNTR_TPSZ_CD  =  @[prov_cntr_tpsz_cd]," ).append("\n"); 
		query.append("UPD_DT	= sysdate" ).append("\n"); 
		query.append("WHERE COP_NO             = @[cop_no]" ).append("\n"); 

	}
}