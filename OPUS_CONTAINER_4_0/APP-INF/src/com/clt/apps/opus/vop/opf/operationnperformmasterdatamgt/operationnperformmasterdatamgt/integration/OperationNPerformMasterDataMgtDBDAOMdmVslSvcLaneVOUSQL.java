/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : IOperationNPerformMasterDataMgtDBDAOMdmVslSvcLaneVOUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.22
*@LastModifier : 김종옥
*@LastVersion : 1.0
* 2009.05.22 김종옥
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.opf.operationnperformmasterdatamgt.operationnperformmasterdatamgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Kim Jong Ock
 * @see DAO 참조
 * @since J2EE 1.4
 */

public class OperationNPerformMasterDataMgtDBDAOMdmVslSvcLaneVOUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  *    
	  * </pre>
	  */
	public OperationNPerformMasterDataMgtDBDAOMdmVslSvcLaneVOUSQL(){
		setQuery();
		
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = "12,N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("upd_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = "12,N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("tml_prod_rpt_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = "12,N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_slan_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("UPDATE mdm_vsl_svc_lane SET" ).append("\n"); 
		query.append("tml_prod_rpt_flg = @[tml_prod_rpt_flg]," ).append("\n"); 
		query.append("upd_dt = sysdate," ).append("\n"); 
		query.append("upd_usr_id = @[upd_usr_id]" ).append("\n"); 
		query.append("WHERE	vsl_slan_cd = @[vsl_slan_cd]" ).append("\n"); 

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.vop.opf.operationnperformmasterdatamgt.operationnperformmasterdatamgt.integration").append("\n"); 
		query.append("FileName : OperationNPerformMasterDataMgtDBDAOMdmVslSvcLaneVOUSQL").append("\n"); 
		query.append("*/").append("\n"); 
	}
}