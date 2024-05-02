/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : OperationNPerformMasterDataMgtDBDAOOpfCodRjctCdVOUSQL.java
*@FileTitle : COD Reject Reason Code Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.11
*@LastModifier : 이선영
*@LastVersion : 1.0
* 2009.05.11 이선영
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.opf.operationnperformmasterdatamgt.operationnperformmasterdatamgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Sunyoung
 * @see DAO 참조
 * @since J2EE 1.4
 */

public class OperationNPerformMasterDataMgtDBDAOOpfCodRjctCdVOUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  *    
	  * </pre>
	  */
	public OperationNPerformMasterDataMgtDBDAOOpfCodRjctCdVOUSQL(){
		setQuery();
		
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = "12,N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cod_rjct_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("delt_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = "12,N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cod_rjct_desc",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("UPDATE opf_cod_rjct_cd SET" ).append("\n"); 
		query.append("cod_rjct_cd = @[cod_rjct_cd]" ).append("\n"); 
		query.append(",	cod_rjct_desc = @[cod_rjct_desc]" ).append("\n"); 
		query.append(",	delt_flg = @[delt_flg]" ).append("\n"); 
		query.append(",	upd_usr_id = @[upd_usr_id]" ).append("\n"); 
		query.append("WHERE	cod_rjct_cd = @[cod_rjct_cd]" ).append("\n"); 

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.vop.opf.operationnperformmasterdatamgt.operationnperformmasterdatamgt.integration").append("\n"); 
		query.append("FileName : OperationNPerformMasterDataMgtDBDAOOpfCodRjctCdVOUSQL").append("\n"); 
		query.append("*/").append("\n"); 
	}
}