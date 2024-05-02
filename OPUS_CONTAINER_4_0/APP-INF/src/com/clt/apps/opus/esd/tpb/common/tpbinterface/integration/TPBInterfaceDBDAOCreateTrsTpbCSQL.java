/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : TPBInterfaceDBDAOCreateTrsTpbCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.12.03
*@LastModifier : 박성진
*@LastVersion : 1.0
* 2009.12.03 박성진
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.tpb.common.tpbinterface.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author SungJin Park
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TPBInterfaceDBDAOCreateTrsTpbCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * CreateTrsTpb
	  * </pre>
	  */
	public TPBInterfaceDBDAOCreateTrsTpbCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trsp_if_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trsp_if_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("user_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("user_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.tpb.common.tpbinterface.integration").append("\n"); 
		query.append("FileName : TPBInterfaceDBDAOCreateTrsTpbCSQL").append("\n"); 
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
		query.append("Call TPB_CRE_IF_DATA_TRS_PRC (" ).append("\n"); 
		query.append("@[trsp_if_ofc_cd]" ).append("\n"); 
		query.append(",@[trsp_if_seq]" ).append("\n"); 
		query.append(",@[user_ofc_cd]" ).append("\n"); 
		query.append(",@[user_id]" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}