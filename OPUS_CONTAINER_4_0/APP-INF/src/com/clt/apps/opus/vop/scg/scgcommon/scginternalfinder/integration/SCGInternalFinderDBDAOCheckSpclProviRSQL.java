/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SCGInternalFinderDBDAOCheckSpclProviRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.11
*@LastModifier : 이도형
*@LastVersion : 1.0
* 2009.06.11 이도형
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.scg.scgcommon.scginternalfinder.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Dohyoung Lee
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SCGInternalFinderDBDAOCheckSpclProviRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * CheckSpclProvi 체크
	  * </pre>
	  */
	public SCGInternalFinderDBDAOCheckSpclProviRSQL(){
		setQuery();
		
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.NUMERIC + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("imdg_spcl_provi_no",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("SELECT" ).append("\n"); 
		query.append("IMDG_SPCL_PROVI_NO" ).append("\n"); 
		query.append(",	IMDG_SPCL_PROVI_DESC" ).append("\n"); 
		query.append(",	DELT_FLG" ).append("\n"); 
		query.append(",	CRE_USR_ID" ).append("\n"); 
		query.append(",	CRE_DT" ).append("\n"); 
		query.append(",	UPD_USR_ID" ).append("\n"); 
		query.append(",	UPD_DT" ).append("\n"); 
		query.append("FROM SCG_IMDG_SPCL_PROVI" ).append("\n"); 
		query.append("WHERE	IMDG_SPCL_PROVI_NO = @[imdg_spcl_provi_no]" ).append("\n"); 
		query.append("AND	DELT_FLG = 'N'" ).append("\n"); 

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.vop.scg.scgcommon.scginternalfinder.integration").append("\n"); 
		query.append("FileName : SCGInternalFinderDBDAOCheckSpclProviRSQL").append("\n"); 
		query.append("*/").append("\n"); 
	}
}